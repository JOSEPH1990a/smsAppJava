package fi.iki.elonen;

import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.widget.helper.ItemTouchHelper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.TrustManagerFactory;

public abstract class NanoHTTPD {
    private static final Pattern BOUNDARY_PATTERN = Pattern.compile(BOUNDARY_REGEX, 2);
    private static final String BOUNDARY_REGEX = "[ |\t]*(boundary)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;]*)['|\"]?";
    private static final Pattern CHARSET_PATTERN = Pattern.compile(CHARSET_REGEX, 2);
    private static final String CHARSET_REGEX = "[ |\t]*(charset)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;]*)['|\"]?";
    private static final Pattern CONTENT_DISPOSITION_ATTRIBUTE_PATTERN = Pattern.compile(CONTENT_DISPOSITION_ATTRIBUTE_REGEX);
    private static final String CONTENT_DISPOSITION_ATTRIBUTE_REGEX = "[ |\t]*([a-zA-Z]*)[ |\t]*=[ |\t]*['|\"]([^\"^']*)['|\"]";
    private static final Pattern CONTENT_DISPOSITION_PATTERN = Pattern.compile(CONTENT_DISPOSITION_REGEX, 2);
    private static final String CONTENT_DISPOSITION_REGEX = "([ |\t]*Content-Disposition[ |\t]*:)(.*)";
    private static final Pattern CONTENT_TYPE_PATTERN = Pattern.compile(CONTENT_TYPE_REGEX, 2);
    private static final String CONTENT_TYPE_REGEX = "([ |\t]*content-type[ |\t]*:)(.*)";
    private static final Logger LOG = Logger.getLogger(NanoHTTPD.class.getName());
    public static final String MIME_HTML = "text/html";
    public static final String MIME_PLAINTEXT = "text/plain";
    protected static Map<String, String> MIME_TYPES = null;
    private static final String QUERY_STRING_PARAMETER = "NanoHttpd.QUERY_STRING";
    public static final int SOCKET_READ_TIMEOUT = 5000;
    protected AsyncRunner asyncRunner;
    private final String hostname;
    private final int myPort;
    private volatile ServerSocket myServerSocket;
    private Thread myThread;
    private ServerSocketFactory serverSocketFactory;
    private TempFileManagerFactory tempFileManagerFactory;

    public interface AsyncRunner {
        void closeAll();

        void closed(ClientHandler clientHandler);

        void exec(ClientHandler clientHandler);
    }

    public interface IHTTPSession {
        void execute() throws IOException;

        CookieHandler getCookies();

        Map<String, String> getHeaders();

        InputStream getInputStream();

        Method getMethod();

        Map<String, String> getParms();

        String getQueryParameterString();

        String getUri();

        void parseBody(Map<String, String> map) throws IOException, ResponseException;
    }

    public interface ServerSocketFactory {
        ServerSocket create() throws IOException;
    }

    public interface TempFile {
        void delete() throws Exception;

        String getName();

        OutputStream open() throws Exception;
    }

    public interface TempFileManager {
        void clear();

        TempFile createTempFile(String str) throws Exception;
    }

    public interface TempFileManagerFactory {
        TempFileManager create();
    }

    public class ClientHandler implements Runnable {
        private final Socket acceptSocket;
        private final InputStream inputStream;

        private ClientHandler(InputStream inputStream2, Socket socket) {
            this.inputStream = inputStream2;
            this.acceptSocket = socket;
        }

        public void close() {
            NanoHTTPD.safeClose(this.inputStream);
            NanoHTTPD.safeClose(this.acceptSocket);
        }

        public void run() {
            OutputStream outputStream = null;
            try {
                outputStream = this.acceptSocket.getOutputStream();
                HTTPSession hTTPSession = new HTTPSession(NanoHTTPD.this.tempFileManagerFactory.create(), this.inputStream, outputStream, this.acceptSocket.getInetAddress());
                while (!this.acceptSocket.isClosed()) {
                    hTTPSession.execute();
                }
            } catch (Exception e) {
                if ((!(e instanceof SocketException) || !"NanoHttpd Shutdown".equals(e.getMessage())) && !(e instanceof SocketTimeoutException)) {
                    NanoHTTPD.LOG.log(Level.FINE, "Communication with the client broken", (Throwable) e);
                }
            } catch (Throwable th) {
                NanoHTTPD.safeClose(null);
                NanoHTTPD.safeClose(this.inputStream);
                NanoHTTPD.safeClose(this.acceptSocket);
                NanoHTTPD.this.asyncRunner.closed(this);
                throw th;
            }
            NanoHTTPD.safeClose(outputStream);
            NanoHTTPD.safeClose(this.inputStream);
            NanoHTTPD.safeClose(this.acceptSocket);
            NanoHTTPD.this.asyncRunner.closed(this);
        }
    }

    public static class Cookie {
        private final String e;
        private final String n;
        private final String v;

        public static String getHTTPTime(int i) {
            Calendar instance = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            instance.add(5, i);
            return simpleDateFormat.format(instance.getTime());
        }

        public Cookie(String str, String str2) {
            this(str, str2, 30);
        }

        public Cookie(String str, String str2, int i) {
            this.n = str;
            this.v = str2;
            this.e = getHTTPTime(i);
        }

        public Cookie(String str, String str2, String str3) {
            this.n = str;
            this.v = str2;
            this.e = str3;
        }

        public String getHTTPHeader() {
            return String.format("%s=%s; expires=%s", this.n, this.v, this.e);
        }
    }

    public class CookieHandler implements Iterable<String> {
        private final HashMap<String, String> cookies = new HashMap<>();
        private final ArrayList<Cookie> queue = new ArrayList<>();

        public CookieHandler(Map<String, String> map) {
            String str = map.get("cookie");
            if (str != null) {
                for (String str2 : str.split(";")) {
                    String[] split = str2.trim().split("=");
                    if (split.length == 2) {
                        this.cookies.put(split[0], split[1]);
                    }
                }
            }
        }

        public void delete(String str) {
            set(str, "-delete-", -30);
        }

        @Override // java.lang.Iterable
        public Iterator<String> iterator() {
            return this.cookies.keySet().iterator();
        }

        public String read(String str) {
            return this.cookies.get(str);
        }

        public void set(Cookie cookie) {
            this.queue.add(cookie);
        }

        public void set(String str, String str2, int i) {
            this.queue.add(new Cookie(str, str2, Cookie.getHTTPTime(i)));
        }

        public void unloadQueue(Response response) {
            Iterator<Cookie> it = this.queue.iterator();
            while (it.hasNext()) {
                response.addHeader("Set-Cookie", it.next().getHTTPHeader());
            }
        }
    }

    public static class DefaultAsyncRunner implements AsyncRunner {
        private long requestCount;
        private final List<ClientHandler> running = Collections.synchronizedList(new ArrayList());

        public List<ClientHandler> getRunning() {
            return this.running;
        }

        @Override // fi.iki.elonen.NanoHTTPD.AsyncRunner
        public void closeAll() {
            Iterator it = new ArrayList(this.running).iterator();
            while (it.hasNext()) {
                ((ClientHandler) it.next()).close();
            }
        }

        @Override // fi.iki.elonen.NanoHTTPD.AsyncRunner
        public void closed(ClientHandler clientHandler) {
            this.running.remove(clientHandler);
        }

        @Override // fi.iki.elonen.NanoHTTPD.AsyncRunner
        public void exec(ClientHandler clientHandler) {
            this.requestCount++;
            Thread thread = new Thread(clientHandler);
            thread.setDaemon(true);
            thread.setName("NanoHttpd Request Processor (#" + this.requestCount + ")");
            this.running.add(clientHandler);
            thread.start();
        }
    }

    public static class DefaultTempFile implements TempFile {
        private final File file;
        private final OutputStream fstream = new FileOutputStream(this.file);

        public DefaultTempFile(File file2) throws IOException {
            this.file = File.createTempFile("NanoHTTPD-", "", file2);
        }

        @Override // fi.iki.elonen.NanoHTTPD.TempFile
        public void delete() throws Exception {
            NanoHTTPD.safeClose(this.fstream);
            if (!this.file.delete()) {
                throw new Exception("could not delete temporary file");
            }
        }

        @Override // fi.iki.elonen.NanoHTTPD.TempFile
        public String getName() {
            return this.file.getAbsolutePath();
        }

        @Override // fi.iki.elonen.NanoHTTPD.TempFile
        public OutputStream open() throws Exception {
            return this.fstream;
        }
    }

    public static class DefaultTempFileManager implements TempFileManager {
        private final List<TempFile> tempFiles;
        private final File tmpdir = new File(System.getProperty("java.io.tmpdir"));

        public DefaultTempFileManager() {
            if (!this.tmpdir.exists()) {
                this.tmpdir.mkdirs();
            }
            this.tempFiles = new ArrayList();
        }

        @Override // fi.iki.elonen.NanoHTTPD.TempFileManager
        public void clear() {
            for (TempFile tempFile : this.tempFiles) {
                try {
                    tempFile.delete();
                } catch (Exception e) {
                    NanoHTTPD.LOG.log(Level.WARNING, "could not delete file ", (Throwable) e);
                }
            }
            this.tempFiles.clear();
        }

        @Override // fi.iki.elonen.NanoHTTPD.TempFileManager
        public TempFile createTempFile(String str) throws Exception {
            DefaultTempFile defaultTempFile = new DefaultTempFile(this.tmpdir);
            this.tempFiles.add(defaultTempFile);
            return defaultTempFile;
        }
    }

    private class DefaultTempFileManagerFactory implements TempFileManagerFactory {
        private DefaultTempFileManagerFactory() {
        }

        @Override // fi.iki.elonen.NanoHTTPD.TempFileManagerFactory
        public TempFileManager create() {
            return new DefaultTempFileManager();
        }
    }

    public static class DefaultServerSocketFactory implements ServerSocketFactory {
        @Override // fi.iki.elonen.NanoHTTPD.ServerSocketFactory
        public ServerSocket create() throws IOException {
            return new ServerSocket();
        }
    }

    public static class SecureServerSocketFactory implements ServerSocketFactory {
        private String[] sslProtocols;
        private SSLServerSocketFactory sslServerSocketFactory;

        public SecureServerSocketFactory(SSLServerSocketFactory sSLServerSocketFactory, String[] strArr) {
            this.sslServerSocketFactory = sSLServerSocketFactory;
            this.sslProtocols = strArr;
        }

        @Override // fi.iki.elonen.NanoHTTPD.ServerSocketFactory
        public ServerSocket create() throws IOException {
            SSLServerSocket sSLServerSocket = (SSLServerSocket) this.sslServerSocketFactory.createServerSocket();
            String[] strArr = this.sslProtocols;
            if (strArr != null) {
                sSLServerSocket.setEnabledProtocols(strArr);
            } else {
                sSLServerSocket.setEnabledProtocols(sSLServerSocket.getSupportedProtocols());
            }
            sSLServerSocket.setUseClientMode(false);
            sSLServerSocket.setWantClientAuth(false);
            sSLServerSocket.setNeedClientAuth(false);
            return sSLServerSocket;
        }
    }

    protected class HTTPSession implements IHTTPSession {
        public static final int BUFSIZE = 8192;
        public static final int MAX_HEADER_SIZE = 1024;
        private static final int MEMORY_STORE_LIMIT = 1024;
        private static final int REQUEST_BUFFER_LEN = 512;
        private CookieHandler cookies;
        private Map<String, String> headers;
        private final BufferedInputStream inputStream;
        private Method method;
        private final OutputStream outputStream;
        private Map<String, String> parms;
        private String protocolVersion;
        private String queryParameterString;
        private String remoteIp;
        private int rlen;
        private int splitbyte;
        private final TempFileManager tempFileManager;
        private String uri;

        public HTTPSession(TempFileManager tempFileManager2, InputStream inputStream2, OutputStream outputStream2) {
            this.tempFileManager = tempFileManager2;
            this.inputStream = new BufferedInputStream(inputStream2, 8192);
            this.outputStream = outputStream2;
        }

        public HTTPSession(TempFileManager tempFileManager2, InputStream inputStream2, OutputStream outputStream2, InetAddress inetAddress) {
            this.tempFileManager = tempFileManager2;
            this.inputStream = new BufferedInputStream(inputStream2, 8192);
            this.outputStream = outputStream2;
            this.remoteIp = (inetAddress.isLoopbackAddress() || inetAddress.isAnyLocalAddress()) ? "127.0.0.1" : inetAddress.getHostAddress().toString();
            this.headers = new HashMap();
        }

        private void decodeHeader(BufferedReader bufferedReader, Map<String, String> map, Map<String, String> map2, Map<String, String> map3) throws ResponseException {
            String str;
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    StringTokenizer stringTokenizer = new StringTokenizer(readLine);
                    if (stringTokenizer.hasMoreTokens()) {
                        map.put(FirebaseAnalytics.Param.METHOD, stringTokenizer.nextToken());
                        if (stringTokenizer.hasMoreTokens()) {
                            String nextToken = stringTokenizer.nextToken();
                            int indexOf = nextToken.indexOf(63);
                            if (indexOf >= 0) {
                                decodeParms(nextToken.substring(indexOf + 1), map2);
                                str = NanoHTTPD.decodePercent(nextToken.substring(0, indexOf));
                            } else {
                                str = NanoHTTPD.decodePercent(nextToken);
                            }
                            if (stringTokenizer.hasMoreTokens()) {
                                this.protocolVersion = stringTokenizer.nextToken();
                            } else {
                                this.protocolVersion = "HTTP/1.1";
                                NanoHTTPD.LOG.log(Level.FINE, "no protocol version specified, strange. Assuming HTTP/1.1.");
                            }
                            String readLine2 = bufferedReader.readLine();
                            while (readLine2 != null && readLine2.trim().length() > 0) {
                                int indexOf2 = readLine2.indexOf(58);
                                if (indexOf2 >= 0) {
                                    map3.put(readLine2.substring(0, indexOf2).trim().toLowerCase(Locale.US), readLine2.substring(indexOf2 + 1).trim());
                                }
                                readLine2 = bufferedReader.readLine();
                            }
                            map.put("uri", str);
                            return;
                        }
                        throw new ResponseException(Response.Status.BAD_REQUEST, "BAD REQUEST: Missing URI. Usage: GET /example/file.html");
                    }
                    throw new ResponseException(Response.Status.BAD_REQUEST, "BAD REQUEST: Syntax error. Usage: GET /example/file.html");
                }
            } catch (IOException e) {
                Response.Status status = Response.Status.INTERNAL_ERROR;
                throw new ResponseException(status, "SERVER INTERNAL ERROR: IOException: " + e.getMessage(), e);
            }
        }

        private void decodeMultipartFormData(String str, String str2, ByteBuffer byteBuffer, Map<String, String> map, Map<String, String> map2) throws ResponseException {
            try {
                int[] boundaryPositions = getBoundaryPositions(byteBuffer, str.getBytes());
                int i = 2;
                if (boundaryPositions.length >= 2) {
                    int i2 = 1024;
                    byte[] bArr = new byte[1024];
                    int i3 = 0;
                    int i4 = 0;
                    while (i4 < boundaryPositions.length - 1) {
                        byteBuffer.position(boundaryPositions[i4]);
                        int remaining = byteBuffer.remaining() < i2 ? byteBuffer.remaining() : 1024;
                        byteBuffer.get(bArr, i3, remaining);
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr, i3, remaining), Charset.forName(str2)), remaining);
                        if (bufferedReader.readLine().contains(str)) {
                            String readLine = bufferedReader.readLine();
                            String str3 = null;
                            String str4 = null;
                            String str5 = null;
                            int i5 = 2;
                            while (readLine != null && readLine.trim().length() > 0) {
                                Matcher matcher = NanoHTTPD.CONTENT_DISPOSITION_PATTERN.matcher(readLine);
                                if (matcher.matches()) {
                                    Matcher matcher2 = NanoHTTPD.CONTENT_DISPOSITION_ATTRIBUTE_PATTERN.matcher(matcher.group(i));
                                    while (matcher2.find()) {
                                        String group = matcher2.group(1);
                                        if (group.equalsIgnoreCase(AppMeasurementSdk.ConditionalUserProperty.NAME)) {
                                            str4 = matcher2.group(2);
                                            str3 = str3;
                                        } else {
                                            str3 = group.equalsIgnoreCase("filename") ? matcher2.group(2) : str3;
                                        }
                                    }
                                }
                                Matcher matcher3 = NanoHTTPD.CONTENT_TYPE_PATTERN.matcher(readLine);
                                if (matcher3.matches()) {
                                    str5 = matcher3.group(2).trim();
                                }
                                readLine = bufferedReader.readLine();
                                i5++;
                                i = 2;
                            }
                            int i6 = 0;
                            while (true) {
                                int i7 = i5 - 1;
                                if (i5 <= 0) {
                                    break;
                                }
                                i6 = scipOverNewLine(bArr, i6);
                                i5 = i7;
                            }
                            if (i6 < remaining - 4) {
                                int i8 = boundaryPositions[i4] + i6;
                                i4++;
                                int i9 = boundaryPositions[i4] - 4;
                                byteBuffer.position(i8);
                                if (str5 == null) {
                                    byte[] bArr2 = new byte[(i9 - i8)];
                                    byteBuffer.get(bArr2);
                                    map.put(str4, new String(bArr2, str2));
                                } else {
                                    String saveTmpFile = saveTmpFile(byteBuffer, i8, i9 - i8, str3);
                                    if (!map2.containsKey(str4)) {
                                        map2.put(str4, saveTmpFile);
                                    } else {
                                        int i10 = 2;
                                        while (true) {
                                            if (!map2.containsKey(str4 + i10)) {
                                                break;
                                            }
                                            i10++;
                                        }
                                        map2.put(str4 + i10, saveTmpFile);
                                    }
                                    map.put(str4, str3);
                                }
                                i2 = 1024;
                                i = 2;
                                i3 = 0;
                            } else {
                                throw new ResponseException(Response.Status.INTERNAL_ERROR, "Multipart header size exceeds MAX_HEADER_SIZE.");
                            }
                        } else {
                            throw new ResponseException(Response.Status.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but chunk does not start with boundary.");
                        }
                    }
                    return;
                }
                throw new ResponseException(Response.Status.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but contains less than two boundary strings.");
            } catch (ResponseException e) {
                throw e;
            } catch (Exception e2) {
                throw new ResponseException(Response.Status.INTERNAL_ERROR, e2.toString());
            }
        }

        private int scipOverNewLine(byte[] bArr, int i) {
            while (bArr[i] != 10) {
                i++;
            }
            return i + 1;
        }

        private void decodeParms(String str, Map<String, String> map) {
            if (str == null) {
                this.queryParameterString = "";
                return;
            }
            this.queryParameterString = str;
            StringTokenizer stringTokenizer = new StringTokenizer(str, "&");
            while (stringTokenizer.hasMoreTokens()) {
                String nextToken = stringTokenizer.nextToken();
                int indexOf = nextToken.indexOf(61);
                if (indexOf >= 0) {
                    map.put(NanoHTTPD.decodePercent(nextToken.substring(0, indexOf)).trim(), NanoHTTPD.decodePercent(nextToken.substring(indexOf + 1)));
                } else {
                    map.put(NanoHTTPD.decodePercent(nextToken).trim(), "");
                }
            }
        }

        @Override // fi.iki.elonen.NanoHTTPD.IHTTPSession
        public void execute() throws IOException {
            Response response = null;
            try {
                byte[] bArr = new byte[8192];
                boolean z = false;
                this.splitbyte = 0;
                this.rlen = 0;
                this.inputStream.mark(8192);
                try {
                    int read = this.inputStream.read(bArr, 0, 8192);
                    if (read != -1) {
                        while (read > 0) {
                            this.rlen += read;
                            this.splitbyte = findHeaderEnd(bArr, this.rlen);
                            if (this.splitbyte > 0) {
                                break;
                            }
                            read = this.inputStream.read(bArr, this.rlen, 8192 - this.rlen);
                        }
                        if (this.splitbyte < this.rlen) {
                            this.inputStream.reset();
                            this.inputStream.skip((long) this.splitbyte);
                        }
                        this.parms = new HashMap();
                        if (this.headers == null) {
                            this.headers = new HashMap();
                        } else {
                            this.headers.clear();
                        }
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr, 0, this.rlen)));
                        HashMap hashMap = new HashMap();
                        decodeHeader(bufferedReader, hashMap, this.parms, this.headers);
                        if (this.remoteIp != null) {
                            this.headers.put("remote-addr", this.remoteIp);
                            this.headers.put("http-client-ip", this.remoteIp);
                        }
                        this.method = Method.lookup(hashMap.get(FirebaseAnalytics.Param.METHOD));
                        if (this.method != null) {
                            this.uri = hashMap.get("uri");
                            this.cookies = new CookieHandler(this.headers);
                            String str = this.headers.get("connection");
                            boolean z2 = this.protocolVersion.equals("HTTP/1.1") && (str == null || !str.matches("(?i).*close.*"));
                            response = NanoHTTPD.this.serve(this);
                            if (response != null) {
                                String str2 = this.headers.get("accept-encoding");
                                this.cookies.unloadQueue(response);
                                response.setRequestMethod(this.method);
                                if (NanoHTTPD.this.useGzipWhenAccepted(response) && str2 != null && str2.contains("gzip")) {
                                    z = true;
                                }
                                response.setGzipEncoding(z);
                                response.setKeepAlive(z2);
                                response.send(this.outputStream);
                                if (!z2 || "close".equalsIgnoreCase(response.getHeader("connection"))) {
                                    throw new SocketException("NanoHttpd Shutdown");
                                }
                                NanoHTTPD.safeClose(response);
                                this.tempFileManager.clear();
                                return;
                            }
                            throw new ResponseException(Response.Status.INTERNAL_ERROR, "SERVER INTERNAL ERROR: Serve() returned a null response.");
                        }
                        throw new ResponseException(Response.Status.BAD_REQUEST, "BAD REQUEST: Syntax error.");
                    }
                    NanoHTTPD.safeClose(this.inputStream);
                    NanoHTTPD.safeClose(this.outputStream);
                    throw new SocketException("NanoHttpd Shutdown");
                } catch (Exception unused) {
                    NanoHTTPD.safeClose(this.inputStream);
                    NanoHTTPD.safeClose(this.outputStream);
                    throw new SocketException("NanoHttpd Shutdown");
                }
            } catch (SocketException e) {
                throw e;
            } catch (SocketTimeoutException e2) {
                throw e2;
            } catch (IOException e3) {
                NanoHTTPD.newFixedLengthResponse(Response.Status.INTERNAL_ERROR, NanoHTTPD.MIME_PLAINTEXT, "SERVER INTERNAL ERROR: IOException: " + e3.getMessage()).send(this.outputStream);
                NanoHTTPD.safeClose(this.outputStream);
            } catch (ResponseException e4) {
                NanoHTTPD.newFixedLengthResponse(e4.getStatus(), NanoHTTPD.MIME_PLAINTEXT, e4.getMessage()).send(this.outputStream);
                NanoHTTPD.safeClose(this.outputStream);
            } catch (Throwable th) {
                NanoHTTPD.safeClose(null);
                this.tempFileManager.clear();
                throw th;
            }
        }

        private int findHeaderEnd(byte[] bArr, int i) {
            int i2;
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (i4 >= i) {
                    return 0;
                }
                if (bArr[i3] == 13 && bArr[i4] == 10 && (i2 = i3 + 3) < i && bArr[i3 + 2] == 13 && bArr[i2] == 10) {
                    return i3 + 4;
                }
                if (bArr[i3] == 10 && bArr[i4] == 10) {
                    return i3 + 2;
                }
                i3 = i4;
            }
        }

        private int[] getBoundaryPositions(ByteBuffer byteBuffer, byte[] bArr) {
            int[] iArr = new int[0];
            if (byteBuffer.remaining() < bArr.length) {
                return iArr;
            }
            byte[] bArr2 = new byte[(bArr.length + 4096)];
            int remaining = byteBuffer.remaining() < bArr2.length ? byteBuffer.remaining() : bArr2.length;
            byteBuffer.get(bArr2, 0, remaining);
            int length = remaining - bArr.length;
            int[] iArr2 = iArr;
            int i = 0;
            while (true) {
                int[] iArr3 = iArr2;
                int i2 = 0;
                while (i2 < length) {
                    int[] iArr4 = iArr3;
                    int i3 = 0;
                    while (i3 < bArr.length && bArr2[i2 + i3] == bArr[i3]) {
                        if (i3 == bArr.length - 1) {
                            int[] iArr5 = new int[(iArr4.length + 1)];
                            System.arraycopy(iArr4, 0, iArr5, 0, iArr4.length);
                            iArr5[iArr4.length] = i + i2;
                            iArr4 = iArr5;
                        }
                        i3++;
                    }
                    i2++;
                    iArr3 = iArr4;
                }
                i += length;
                System.arraycopy(bArr2, bArr2.length - bArr.length, bArr2, 0, bArr.length);
                length = bArr2.length - bArr.length;
                if (byteBuffer.remaining() < length) {
                    length = byteBuffer.remaining();
                }
                byteBuffer.get(bArr2, bArr.length, length);
                if (length <= 0) {
                    return iArr3;
                }
                iArr2 = iArr3;
            }
        }

        @Override // fi.iki.elonen.NanoHTTPD.IHTTPSession
        public CookieHandler getCookies() {
            return this.cookies;
        }

        @Override // fi.iki.elonen.NanoHTTPD.IHTTPSession
        public final Map<String, String> getHeaders() {
            return this.headers;
        }

        @Override // fi.iki.elonen.NanoHTTPD.IHTTPSession
        public final InputStream getInputStream() {
            return this.inputStream;
        }

        @Override // fi.iki.elonen.NanoHTTPD.IHTTPSession
        public final Method getMethod() {
            return this.method;
        }

        @Override // fi.iki.elonen.NanoHTTPD.IHTTPSession
        public final Map<String, String> getParms() {
            return this.parms;
        }

        @Override // fi.iki.elonen.NanoHTTPD.IHTTPSession
        public String getQueryParameterString() {
            return this.queryParameterString;
        }

        private RandomAccessFile getTmpBucket() {
            try {
                return new RandomAccessFile(this.tempFileManager.createTempFile(null).getName(), "rw");
            } catch (Exception e) {
                throw new Error(e);
            }
        }

        @Override // fi.iki.elonen.NanoHTTPD.IHTTPSession
        public final String getUri() {
            return this.uri;
        }

        public long getBodySize() {
            if (this.headers.containsKey("content-length")) {
                return Long.parseLong(this.headers.get("content-length"));
            }
            int i = this.splitbyte;
            int i2 = this.rlen;
            if (i < i2) {
                return (long) (i2 - i);
            }
            return 0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v19, types: [java.nio.ByteBuffer] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // fi.iki.elonen.NanoHTTPD.IHTTPSession
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void parseBody(java.util.Map<java.lang.String, java.lang.String> r20) throws java.io.IOException, fi.iki.elonen.NanoHTTPD.ResponseException {
            /*
            // Method dump skipped, instructions count: 289
            */
            throw new UnsupportedOperationException("Method not decompiled: fi.iki.elonen.NanoHTTPD.HTTPSession.parseBody(java.util.Map):void");
        }

        private String getAttributeFromContentHeader(String str, Pattern pattern, String str2) {
            Matcher matcher = pattern.matcher(str);
            return matcher.find() ? matcher.group(2) : str2;
        }

        private String saveTmpFile(ByteBuffer byteBuffer, int i, int i2, String str) {
            Throwable th;
            Exception e;
            String str2 = "";
            if (i2 > 0) {
                FileOutputStream fileOutputStream = null;
                try {
                    TempFile createTempFile = this.tempFileManager.createTempFile(str);
                    ByteBuffer duplicate = byteBuffer.duplicate();
                    FileOutputStream fileOutputStream2 = new FileOutputStream(createTempFile.getName());
                    try {
                        FileChannel channel = fileOutputStream2.getChannel();
                        duplicate.position(i).limit(i + i2);
                        channel.write(duplicate.slice());
                        str2 = createTempFile.getName();
                        NanoHTTPD.safeClose(fileOutputStream2);
                    } catch (Exception e2) {
                        e = e2;
                        fileOutputStream = fileOutputStream2;
                        try {
                            throw new Error(e);
                        } catch (Throwable th2) {
                            th = th2;
                            NanoHTTPD.safeClose(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = fileOutputStream2;
                        NanoHTTPD.safeClose(fileOutputStream);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    throw new Error(e);
                }
            }
            return str2;
        }
    }

    public enum Method {
        GET,
        PUT,
        POST,
        DELETE,
        HEAD,
        OPTIONS,
        TRACE,
        CONNECT,
        PATCH;

        static Method lookup(String str) {
            Method[] values = values();
            for (Method method : values) {
                if (method.toString().equalsIgnoreCase(str)) {
                    return method;
                }
            }
            return null;
        }
    }

    public static class Response implements Closeable {
        private boolean chunkedTransfer;
        private long contentLength;
        private InputStream data;
        private boolean encodeAsGzip;
        private final Map<String, String> header = new HashMap();
        private boolean keepAlive;
        private String mimeType;
        private Method requestMethod;
        private IStatus status;

        public interface IStatus {
            String getDescription();

            int getRequestStatus();
        }

        public enum Status implements IStatus {
            SWITCH_PROTOCOL(101, "Switching Protocols"),
            OK(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, "OK"),
            CREATED(201, "Created"),
            ACCEPTED(202, "Accepted"),
            NO_CONTENT(204, "No Content"),
            PARTIAL_CONTENT(206, "Partial Content"),
            REDIRECT(301, "Moved Permanently"),
            NOT_MODIFIED(304, "Not Modified"),
            BAD_REQUEST(400, "Bad Request"),
            UNAUTHORIZED(401, "Unauthorized"),
            FORBIDDEN(403, "Forbidden"),
            NOT_FOUND(404, "Not Found"),
            METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
            NOT_ACCEPTABLE(406, "Not Acceptable"),
            REQUEST_TIMEOUT(408, "Request Timeout"),
            CONFLICT(409, "Conflict"),
            RANGE_NOT_SATISFIABLE(416, "Requested Range Not Satisfiable"),
            INTERNAL_ERROR(500, "Internal Server Error"),
            NOT_IMPLEMENTED(501, "Not Implemented"),
            UNSUPPORTED_HTTP_VERSION(505, "HTTP Version Not Supported");
            
            private final String description;
            private final int requestStatus;

            private Status(int i, String str) {
                this.requestStatus = i;
                this.description = str;
            }

            @Override // fi.iki.elonen.NanoHTTPD.Response.IStatus
            public String getDescription() {
                return "" + this.requestStatus + " " + this.description;
            }

            @Override // fi.iki.elonen.NanoHTTPD.Response.IStatus
            public int getRequestStatus() {
                return this.requestStatus;
            }
        }

        /* access modifiers changed from: private */
        public static class ChunkedOutputStream extends FilterOutputStream {
            public ChunkedOutputStream(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.OutputStream, java.io.FilterOutputStream
            public void write(int i) throws IOException {
                write(new byte[]{(byte) i}, 0, 1);
            }

            @Override // java.io.OutputStream, java.io.FilterOutputStream
            public void write(byte[] bArr) throws IOException {
                write(bArr, 0, bArr.length);
            }

            @Override // java.io.OutputStream, java.io.FilterOutputStream
            public void write(byte[] bArr, int i, int i2) throws IOException {
                if (i2 != 0) {
                    this.out.write(String.format("%x\r\n", Integer.valueOf(i2)).getBytes());
                    this.out.write(bArr, i, i2);
                    this.out.write("\r\n".getBytes());
                }
            }

            public void finish() throws IOException {
                this.out.write("0\r\n\r\n".getBytes());
            }
        }

        protected Response(IStatus iStatus, String str, InputStream inputStream, long j) {
            this.status = iStatus;
            this.mimeType = str;
            boolean z = false;
            if (inputStream == null) {
                this.data = new ByteArrayInputStream(new byte[0]);
                this.contentLength = 0;
            } else {
                this.data = inputStream;
                this.contentLength = j;
            }
            this.chunkedTransfer = this.contentLength < 0 ? true : z;
            this.keepAlive = true;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            InputStream inputStream = this.data;
            if (inputStream != null) {
                inputStream.close();
            }
        }

        public void addHeader(String str, String str2) {
            this.header.put(str, str2);
        }

        public InputStream getData() {
            return this.data;
        }

        public String getHeader(String str) {
            for (String str2 : this.header.keySet()) {
                if (str2.equalsIgnoreCase(str)) {
                    return this.header.get(str2);
                }
            }
            return null;
        }

        public String getMimeType() {
            return this.mimeType;
        }

        public Method getRequestMethod() {
            return this.requestMethod;
        }

        public IStatus getStatus() {
            return this.status;
        }

        public void setGzipEncoding(boolean z) {
            this.encodeAsGzip = z;
        }

        public void setKeepAlive(boolean z) {
            this.keepAlive = z;
        }

        private static boolean headerAlreadySent(Map<String, String> map, String str) {
            boolean z = false;
            for (String str2 : map.keySet()) {
                z |= str2.equalsIgnoreCase(str);
            }
            return z;
        }

        /* access modifiers changed from: protected */
        public void send(OutputStream outputStream) {
            String str = this.mimeType;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            try {
                if (this.status != null) {
                    PrintWriter printWriter = new PrintWriter((Writer) new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8")), false);
                    printWriter.print("HTTP/1.1 " + this.status.getDescription() + " \r\n");
                    if (str != null) {
                        printWriter.print("Content-Type: " + str + "\r\n");
                    }
                    if (this.header == null || this.header.get("Date") == null) {
                        printWriter.print("Date: " + simpleDateFormat.format(new Date()) + "\r\n");
                    }
                    if (this.header != null) {
                        for (String str2 : this.header.keySet()) {
                            printWriter.print(str2 + ": " + this.header.get(str2) + "\r\n");
                        }
                    }
                    if (!headerAlreadySent(this.header, "connection")) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Connection: ");
                        sb.append(this.keepAlive ? "keep-alive" : "close");
                        sb.append("\r\n");
                        printWriter.print(sb.toString());
                    }
                    if (headerAlreadySent(this.header, "content-length")) {
                        this.encodeAsGzip = false;
                    }
                    if (this.encodeAsGzip) {
                        printWriter.print("Content-Encoding: gzip\r\n");
                        setChunkedTransfer(true);
                    }
                    long j = this.data != null ? this.contentLength : 0;
                    if (this.requestMethod != Method.HEAD && this.chunkedTransfer) {
                        printWriter.print("Transfer-Encoding: chunked\r\n");
                    } else if (!this.encodeAsGzip) {
                        j = sendContentLengthHeaderIfNotAlreadyPresent(printWriter, this.header, j);
                    }
                    printWriter.print("\r\n");
                    printWriter.flush();
                    sendBodyWithCorrectTransferAndEncoding(outputStream, j);
                    outputStream.flush();
                    NanoHTTPD.safeClose(this.data);
                    return;
                }
                throw new Error("sendResponse(): Status can't be null.");
            } catch (IOException e) {
                NanoHTTPD.LOG.log(Level.SEVERE, "Could not send response to the client", (Throwable) e);
            }
        }

        private void sendBodyWithCorrectTransferAndEncoding(OutputStream outputStream, long j) throws IOException {
            if (this.requestMethod == Method.HEAD || !this.chunkedTransfer) {
                sendBodyWithCorrectEncoding(outputStream, j);
                return;
            }
            ChunkedOutputStream chunkedOutputStream = new ChunkedOutputStream(outputStream);
            sendBodyWithCorrectEncoding(chunkedOutputStream, -1);
            chunkedOutputStream.finish();
        }

        private void sendBodyWithCorrectEncoding(OutputStream outputStream, long j) throws IOException {
            if (this.encodeAsGzip) {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                sendBody(gZIPOutputStream, -1);
                gZIPOutputStream.finish();
                return;
            }
            sendBody(outputStream, j);
        }

        private void sendBody(OutputStream outputStream, long j) throws IOException {
            long j2;
            byte[] bArr = new byte[((int) PlaybackStateCompat.ACTION_PREPARE)];
            boolean z = j == -1;
            while (true) {
                if (j > 0 || z) {
                    if (z) {
                        j2 = 16384;
                    } else {
                        j2 = Math.min(j, (long) PlaybackStateCompat.ACTION_PREPARE);
                    }
                    int read = this.data.read(bArr, 0, (int) j2);
                    if (read > 0) {
                        outputStream.write(bArr, 0, read);
                        if (!z) {
                            j -= (long) read;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        protected static long sendContentLengthHeaderIfNotAlreadyPresent(PrintWriter printWriter, Map<String, String> map, long j) {
            for (String str : map.keySet()) {
                if (str.equalsIgnoreCase("content-length")) {
                    try {
                        return Long.parseLong(map.get(str));
                    } catch (NumberFormatException unused) {
                        return j;
                    }
                }
            }
            printWriter.print("Content-Length: " + j + "\r\n");
            return j;
        }

        public void setChunkedTransfer(boolean z) {
            this.chunkedTransfer = z;
        }

        public void setData(InputStream inputStream) {
            this.data = inputStream;
        }

        public void setMimeType(String str) {
            this.mimeType = str;
        }

        public void setRequestMethod(Method method) {
            this.requestMethod = method;
        }

        public void setStatus(IStatus iStatus) {
            this.status = iStatus;
        }
    }

    public static final class ResponseException extends Exception {
        private static final long serialVersionUID = 6569838532917408380L;
        private final Response.Status status;

        public ResponseException(Response.Status status2, String str) {
            super(str);
            this.status = status2;
        }

        public ResponseException(Response.Status status2, String str, Exception exc) {
            super(str, exc);
            this.status = status2;
        }

        public Response.Status getStatus() {
            return this.status;
        }
    }

    public class ServerRunnable implements Runnable {
        private IOException bindException;
        private boolean hasBinded;
        private final int timeout;

        private ServerRunnable(int i) {
            this.hasBinded = false;
            this.timeout = i;
        }

        public void run() {
            try {
                NanoHTTPD.this.myServerSocket.bind(NanoHTTPD.this.hostname != null ? new InetSocketAddress(NanoHTTPD.this.hostname, NanoHTTPD.this.myPort) : new InetSocketAddress(NanoHTTPD.this.myPort));
                this.hasBinded = true;
                do {
                    try {
                        Socket accept = NanoHTTPD.this.myServerSocket.accept();
                        if (this.timeout > 0) {
                            accept.setSoTimeout(this.timeout);
                        }
                        NanoHTTPD.this.asyncRunner.exec(NanoHTTPD.this.createClientHandler(accept, accept.getInputStream()));
                    } catch (IOException e) {
                        NanoHTTPD.LOG.log(Level.FINE, "Communication with the client broken", (Throwable) e);
                    }
                } while (!NanoHTTPD.this.myServerSocket.isClosed());
            } catch (IOException e2) {
                this.bindException = e2;
            }
        }
    }

    public static Map<String, String> mimeTypes() {
        if (MIME_TYPES == null) {
            MIME_TYPES = new HashMap();
            loadMimeTypes(MIME_TYPES, "META-INF/nanohttpd/default-mimetypes.properties");
            loadMimeTypes(MIME_TYPES, "META-INF/nanohttpd/mimetypes.properties");
            if (MIME_TYPES.isEmpty()) {
                LOG.log(Level.WARNING, "no mime types found in the classpath! please provide mimetypes.properties");
            }
        }
        return MIME_TYPES;
    }

    private static void loadMimeTypes(Map<String, String> map, String str) {
        try {
            Enumeration<URL> resources = NanoHTTPD.class.getClassLoader().getResources(str);
            while (resources.hasMoreElements()) {
                URL nextElement = resources.nextElement();
                Properties properties = new Properties();
                InputStream inputStream = null;
                try {
                    inputStream = nextElement.openStream();
                    properties.load(nextElement.openStream());
                } catch (IOException e) {
                    Logger logger = LOG;
                    Level level = Level.SEVERE;
                    logger.log(level, "could not load mimetypes from " + nextElement, (Throwable) e);
                } catch (Throwable th) {
                    safeClose(inputStream);
                    throw th;
                }
                safeClose(inputStream);
                map.putAll(properties);
            }
        } catch (IOException unused) {
            Logger logger2 = LOG;
            Level level2 = Level.INFO;
            logger2.log(level2, "no mime types available at " + str);
        }
    }

    public static SSLServerSocketFactory makeSSLSocketFactory(KeyStore keyStore, KeyManager[] keyManagerArr) throws IOException {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init(keyStore);
            SSLContext instance2 = SSLContext.getInstance("TLS");
            instance2.init(keyManagerArr, instance.getTrustManagers(), null);
            return instance2.getServerSocketFactory();
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    public static SSLServerSocketFactory makeSSLSocketFactory(KeyStore keyStore, KeyManagerFactory keyManagerFactory) throws IOException {
        try {
            return makeSSLSocketFactory(keyStore, keyManagerFactory.getKeyManagers());
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    public static SSLServerSocketFactory makeSSLSocketFactory(String str, char[] cArr) throws IOException {
        try {
            KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
            instance.load(NanoHTTPD.class.getResourceAsStream(str), cArr);
            KeyManagerFactory instance2 = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            instance2.init(instance, cArr);
            return makeSSLSocketFactory(instance, instance2);
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    public static String getMimeTypeForFile(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        String str2 = lastIndexOf >= 0 ? mimeTypes().get(str.substring(lastIndexOf + 1).toLowerCase()) : null;
        return str2 == null ? "application/octet-stream" : str2;
    }

    /* access modifiers changed from: private */
    public static final void safeClose(Object obj) {
        if (obj != null) {
            try {
                if (obj instanceof Closeable) {
                    ((Closeable) obj).close();
                } else if (obj instanceof Socket) {
                    ((Socket) obj).close();
                } else if (obj instanceof ServerSocket) {
                    ((ServerSocket) obj).close();
                } else {
                    throw new IllegalArgumentException("Unknown object to close");
                }
            } catch (IOException e) {
                LOG.log(Level.SEVERE, "Could not close", (Throwable) e);
            }
        }
    }

    public NanoHTTPD(int i) {
        this(null, i);
    }

    public NanoHTTPD(String str, int i) {
        this.serverSocketFactory = new DefaultServerSocketFactory();
        this.hostname = str;
        this.myPort = i;
        setTempFileManagerFactory(new DefaultTempFileManagerFactory());
        setAsyncRunner(new DefaultAsyncRunner());
    }

    public synchronized void closeAllConnections() {
        stop();
    }

    /* access modifiers changed from: protected */
    public ClientHandler createClientHandler(Socket socket, InputStream inputStream) {
        return new ClientHandler(inputStream, socket);
    }

    /* access modifiers changed from: protected */
    public ServerRunnable createServerRunnable(int i) {
        return new ServerRunnable(i);
    }

    protected static Map<String, List<String>> decodeParameters(Map<String, String> map) {
        return decodeParameters(map.get(QUERY_STRING_PARAMETER));
    }

    protected static Map<String, List<String>> decodeParameters(String str) {
        HashMap hashMap = new HashMap();
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, "&");
            while (stringTokenizer.hasMoreTokens()) {
                String nextToken = stringTokenizer.nextToken();
                int indexOf = nextToken.indexOf(61);
                String trim = (indexOf >= 0 ? decodePercent(nextToken.substring(0, indexOf)) : decodePercent(nextToken)).trim();
                if (!hashMap.containsKey(trim)) {
                    hashMap.put(trim, new ArrayList());
                }
                String decodePercent = indexOf >= 0 ? decodePercent(nextToken.substring(indexOf + 1)) : null;
                if (decodePercent != null) {
                    ((List) hashMap.get(trim)).add(decodePercent);
                }
            }
        }
        return hashMap;
    }

    protected static String decodePercent(String str) {
        try {
            return URLDecoder.decode(str, "UTF8");
        } catch (UnsupportedEncodingException e) {
            LOG.log(Level.WARNING, "Encoding not supported, ignored", (Throwable) e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public boolean useGzipWhenAccepted(Response response) {
        return response.getMimeType() != null && response.getMimeType().toLowerCase().contains("text/");
    }

    public final int getListeningPort() {
        if (this.myServerSocket == null) {
            return -1;
        }
        return this.myServerSocket.getLocalPort();
    }

    public final boolean isAlive() {
        return wasStarted() && !this.myServerSocket.isClosed() && this.myThread.isAlive();
    }

    public ServerSocketFactory getServerSocketFactory() {
        return this.serverSocketFactory;
    }

    public void setServerSocketFactory(ServerSocketFactory serverSocketFactory2) {
        this.serverSocketFactory = serverSocketFactory2;
    }

    public String getHostname() {
        return this.hostname;
    }

    public TempFileManagerFactory getTempFileManagerFactory() {
        return this.tempFileManagerFactory;
    }

    public void makeSecure(SSLServerSocketFactory sSLServerSocketFactory, String[] strArr) {
        this.serverSocketFactory = new SecureServerSocketFactory(sSLServerSocketFactory, strArr);
    }

    public static Response newChunkedResponse(Response.IStatus iStatus, String str, InputStream inputStream) {
        return new Response(iStatus, str, inputStream, -1);
    }

    public static Response newFixedLengthResponse(Response.IStatus iStatus, String str, InputStream inputStream, long j) {
        return new Response(iStatus, str, inputStream, j);
    }

    public static Response newFixedLengthResponse(Response.IStatus iStatus, String str, String str2) {
        byte[] bArr;
        if (str2 == null) {
            return newFixedLengthResponse(iStatus, str, new ByteArrayInputStream(new byte[0]), 0);
        }
        try {
            bArr = str2.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOG.log(Level.SEVERE, "encoding problem, responding nothing", (Throwable) e);
            bArr = new byte[0];
        }
        return newFixedLengthResponse(iStatus, str, new ByteArrayInputStream(bArr), (long) bArr.length);
    }

    public static Response newFixedLengthResponse(String str) {
        return newFixedLengthResponse(Response.Status.OK, MIME_HTML, str);
    }

    public Response serve(IHTTPSession iHTTPSession) {
        HashMap hashMap = new HashMap();
        Method method = iHTTPSession.getMethod();
        if (Method.PUT.equals(method) || Method.POST.equals(method)) {
            try {
                iHTTPSession.parseBody(hashMap);
            } catch (IOException e) {
                Response.Status status = Response.Status.INTERNAL_ERROR;
                return newFixedLengthResponse(status, MIME_PLAINTEXT, "SERVER INTERNAL ERROR: IOException: " + e.getMessage());
            } catch (ResponseException e2) {
                return newFixedLengthResponse(e2.getStatus(), MIME_PLAINTEXT, e2.getMessage());
            }
        }
        Map<String, String> parms = iHTTPSession.getParms();
        parms.put(QUERY_STRING_PARAMETER, iHTTPSession.getQueryParameterString());
        return serve(iHTTPSession.getUri(), method, iHTTPSession.getHeaders(), parms, hashMap);
    }

    @Deprecated
    public Response serve(String str, Method method, Map<String, String> map, Map<String, String> map2, Map<String, String> map3) {
        return newFixedLengthResponse(Response.Status.NOT_FOUND, MIME_PLAINTEXT, "Not Found");
    }

    public void setAsyncRunner(AsyncRunner asyncRunner2) {
        this.asyncRunner = asyncRunner2;
    }

    public void setTempFileManagerFactory(TempFileManagerFactory tempFileManagerFactory2) {
        this.tempFileManagerFactory = tempFileManagerFactory2;
    }

    public void start() throws IOException {
        start(SOCKET_READ_TIMEOUT);
    }

    public void start(int i) throws IOException {
        start(i, true);
    }

    public void start(int i, boolean z) throws IOException {
        this.myServerSocket = getServerSocketFactory().create();
        this.myServerSocket.setReuseAddress(true);
        ServerRunnable createServerRunnable = createServerRunnable(i);
        this.myThread = new Thread(createServerRunnable);
        this.myThread.setDaemon(z);
        this.myThread.setName("NanoHttpd Main Listener");
        this.myThread.start();
        while (!createServerRunnable.hasBinded && createServerRunnable.bindException == null) {
            try {
                Thread.sleep(10);
            } catch (Throwable unused) {
            }
        }
        if (createServerRunnable.bindException != null) {
            throw createServerRunnable.bindException;
        }
    }

    public void stop() {
        try {
            safeClose(this.myServerSocket);
            this.asyncRunner.closeAll();
            if (this.myThread != null) {
                this.myThread.join();
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Could not stop all connections", (Throwable) e);
        }
    }

    public final boolean wasStarted() {
        return (this.myServerSocket == null || this.myThread == null) ? false : true;
    }
}
