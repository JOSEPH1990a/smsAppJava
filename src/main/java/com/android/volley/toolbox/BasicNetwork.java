package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.Cache;
import com.android.volley.Header;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RetryPolicy;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class BasicNetwork implements Network {
    protected static final boolean DEBUG = VolleyLog.DEBUG;
    private static final int DEFAULT_POOL_SIZE = 4096;
    private static final int SLOW_REQUEST_THRESHOLD_MS = 3000;
    private final BaseHttpStack mBaseHttpStack;
    @Deprecated
    protected final HttpStack mHttpStack;
    protected final ByteArrayPool mPool;

    @Deprecated
    public BasicNetwork(HttpStack httpStack) {
        this(httpStack, new ByteArrayPool(4096));
    }

    @Deprecated
    public BasicNetwork(HttpStack httpStack, ByteArrayPool byteArrayPool) {
        this.mHttpStack = httpStack;
        this.mBaseHttpStack = new AdaptedHttpStack(httpStack);
        this.mPool = byteArrayPool;
    }

    public BasicNetwork(BaseHttpStack baseHttpStack) {
        this(baseHttpStack, new ByteArrayPool(4096));
    }

    public BasicNetwork(BaseHttpStack baseHttpStack, ByteArrayPool byteArrayPool) {
        this.mBaseHttpStack = baseHttpStack;
        this.mHttpStack = baseHttpStack;
        this.mPool = byteArrayPool;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005e, code lost:
        r15 = null;
        r19 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ab, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ad, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ae, code lost:
        r1 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00af, code lost:
        r19 = r1;
        r15 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b4, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b5, code lost:
        r1 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b7, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b8, code lost:
        r19 = r1;
        r15 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c3, code lost:
        r0 = r12.getStatusCode();
        com.android.volley.VolleyLog.e("Unexpected response code %d for %s", java.lang.Integer.valueOf(r0), r29.getUrl());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00dc, code lost:
        if (r15 != null) goto L_0x00de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00de, code lost:
        r1 = new com.android.volley.NetworkResponse(r0, r15, false, android.os.SystemClock.elapsedRealtime() - r9, r19);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ef, code lost:
        if (r0 == 401) goto L_0x012b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00f8, code lost:
        if (r0 < 400) goto L_0x0105;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0104, code lost:
        throw new com.android.volley.ClientError(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0107, code lost:
        if (r0 < 500) goto L_0x0125;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0111, code lost:
        if (r29.shouldRetryServerErrors() != false) goto L_0x0113;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0113, code lost:
        attemptRetryOnException("server", r29, new com.android.volley.ServerError(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0124, code lost:
        throw new com.android.volley.ServerError(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x012a, code lost:
        throw new com.android.volley.ServerError(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x012b, code lost:
        attemptRetryOnException("auth", r29, new com.android.volley.AuthFailureError(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0137, code lost:
        attemptRetryOnException("network", r29, new com.android.volley.NetworkError());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0148, code lost:
        throw new com.android.volley.NoConnectionError(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0149, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0164, code lost:
        throw new java.lang.RuntimeException("Bad URL " + r29.getUrl(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0165, code lost:
        attemptRetryOnException("socket", r29, new com.android.volley.TimeoutError());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0149 A[ExcHandler: MalformedURLException (r0v1 'e' java.net.MalformedURLException A[CUSTOM_DECLARE]), Splitter:B:2:0x000e] */
    /* JADX WARNING: Removed duplicated region for block: B:76:? A[ExcHandler: SocketTimeoutException (unused java.net.SocketTimeoutException), SYNTHETIC, Splitter:B:2:0x000e] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0143 A[SYNTHETIC] */
    @Override // com.android.volley.Network
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.android.volley.NetworkResponse performRequest(com.android.volley.Request<?> r29) throws com.android.volley.VolleyError {
        /*
        // Method dump skipped, instructions count: 369
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.BasicNetwork.performRequest(com.android.volley.Request):com.android.volley.NetworkResponse");
    }

    private void logSlowRequests(long j, Request<?> request, byte[] bArr, int i) {
        if (DEBUG || j > 3000) {
            Object[] objArr = new Object[5];
            objArr[0] = request;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(i);
            objArr[4] = Integer.valueOf(request.getRetryPolicy().getCurrentRetryCount());
            VolleyLog.d("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    private static void attemptRetryOnException(String str, Request<?> request, VolleyError volleyError) throws VolleyError {
        RetryPolicy retryPolicy = request.getRetryPolicy();
        int timeoutMs = request.getTimeoutMs();
        try {
            retryPolicy.retry(volleyError);
            request.addMarker(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(timeoutMs)));
        } catch (VolleyError e) {
            request.addMarker(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(timeoutMs)));
            throw e;
        }
    }

    private Map<String, String> getCacheHeaders(Cache.Entry entry) {
        if (entry == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        if (entry.etag != null) {
            hashMap.put("If-None-Match", entry.etag);
        }
        if (entry.lastModified > 0) {
            hashMap.put("If-Modified-Since", HttpHeaderParser.formatEpochAsRfc1123(entry.lastModified));
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public void logError(String str, String str2, long j) {
        VolleyLog.v("HTTP ERROR(%s) %d ms to fetch %s", str, Long.valueOf(SystemClock.elapsedRealtime() - j), str2);
    }

    private byte[] inputStreamToBytes(InputStream inputStream, int i) throws IOException, ServerError {
        PoolingByteArrayOutputStream poolingByteArrayOutputStream = new PoolingByteArrayOutputStream(this.mPool, i);
        if (inputStream != null) {
            try {
                byte[] buf = this.mPool.getBuf(1024);
                while (true) {
                    int read = inputStream.read(buf);
                    if (read == -1) {
                        break;
                    }
                    poolingByteArrayOutputStream.write(buf, 0, read);
                }
                byte[] byteArray = poolingByteArrayOutputStream.toByteArray();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                        VolleyLog.v("Error occurred when closing InputStream", new Object[0]);
                    }
                }
                this.mPool.returnBuf(buf);
                poolingByteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                        VolleyLog.v("Error occurred when closing InputStream", new Object[0]);
                    }
                }
                this.mPool.returnBuf(null);
                poolingByteArrayOutputStream.close();
                throw th;
            }
        } else {
            throw new ServerError();
        }
    }

    @Deprecated
    protected static Map<String, String> convertHeaders(Header[] headerArr) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < headerArr.length; i++) {
            treeMap.put(headerArr[i].getName(), headerArr[i].getValue());
        }
        return treeMap;
    }

    private static List<Header> combineHeaders(List<Header> list, Cache.Entry entry) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            for (Header header : list) {
                treeSet.add(header.getName());
            }
        }
        ArrayList arrayList = new ArrayList(list);
        if (entry.allResponseHeaders != null) {
            if (!entry.allResponseHeaders.isEmpty()) {
                for (Header header2 : entry.allResponseHeaders) {
                    if (!treeSet.contains(header2.getName())) {
                        arrayList.add(header2);
                    }
                }
            }
        } else if (!entry.responseHeaders.isEmpty()) {
            for (Map.Entry<String, String> entry2 : entry.responseHeaders.entrySet()) {
                if (!treeSet.contains(entry2.getKey())) {
                    arrayList.add(new Header(entry2.getKey(), entry2.getValue()));
                }
            }
        }
        return arrayList;
    }
}
