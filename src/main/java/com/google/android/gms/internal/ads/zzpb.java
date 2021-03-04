package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

public final class zzpb implements zzov {
    private static final Pattern zzbgd = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> zzbge = new AtomicReference<>();
    private zzoz zzazo;
    private boolean zzbfr;
    private final boolean zzbgf;
    private final int zzbgg;
    private final int zzbgh;
    private final String zzbgi;
    private final zzpz<String> zzbgj;
    private final zzpe zzbgk;
    private final zzpe zzbgl;
    private final zzpn<? super zzpb> zzbgm;
    private HttpURLConnection zzbgn;
    private InputStream zzbgo;
    private long zzbgp;
    private long zzbgq;
    private long zzbgr;
    private long zzcd;

    public zzpb(String str, zzpz<String> zzpz, zzpn<? super zzpb> zzpn, int i, int i2, boolean z, zzpe zzpe) {
        if (!TextUtils.isEmpty(str)) {
            this.zzbgi = str;
            this.zzbgj = null;
            this.zzbgm = zzpn;
            this.zzbgl = new zzpe();
            this.zzbgg = i;
            this.zzbgh = i2;
            this.zzbgf = true;
            this.zzbgk = null;
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.ads.zzov
    public final Uri getUri() {
        HttpURLConnection httpURLConnection = this.zzbgn;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public final Map<String, List<String>> getResponseHeaders() {
        HttpURLConnection httpURLConnection = this.zzbgn;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    @Override // com.google.android.gms.internal.ads.zzov
    public final long zza(zzoz zzoz) throws zzpc {
        HttpURLConnection httpURLConnection;
        HttpURLConnection zza;
        this.zzazo = zzoz;
        long j = 0;
        this.zzcd = 0;
        this.zzbgr = 0;
        try {
            URL url = new URL(zzoz.uri.toString());
            byte[] bArr = zzoz.zzbft;
            long j2 = zzoz.zzaha;
            long j3 = zzoz.zzcc;
            boolean zzbg = zzoz.zzbg(1);
            if (!this.zzbgf) {
                httpURLConnection = zza(url, bArr, j2, j3, zzbg, true);
            } else {
                URL url2 = url;
                byte[] bArr2 = bArr;
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    if (i <= 20) {
                        zza = zza(url2, bArr2, j2, j3, zzbg, false);
                        int responseCode = zza.getResponseCode();
                        if (!(responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303)) {
                            if (bArr2 == null) {
                                if (responseCode != 307) {
                                    if (responseCode != 308) {
                                        break;
                                    }
                                }
                            } else {
                                break;
                            }
                        }
                        bArr2 = null;
                        String headerField = zza.getHeaderField("Location");
                        zza.disconnect();
                        if (headerField != null) {
                            url2 = new URL(url2, headerField);
                            String protocol = url2.getProtocol();
                            if ("https".equals(protocol) || "http".equals(protocol)) {
                                i = i2;
                                j3 = j3;
                                j2 = j2;
                            } else {
                                String valueOf = String.valueOf(protocol);
                                throw new ProtocolException(valueOf.length() != 0 ? "Unsupported protocol redirect: ".concat(valueOf) : new String("Unsupported protocol redirect: "));
                            }
                        } else {
                            throw new ProtocolException("Null location redirect");
                        }
                    } else {
                        StringBuilder sb = new StringBuilder(31);
                        sb.append("Too many redirects: ");
                        sb.append(i2);
                        throw new NoRouteToHostException(sb.toString());
                    }
                }
                httpURLConnection = zza;
            }
            this.zzbgn = httpURLConnection;
            try {
                int responseCode2 = this.zzbgn.getResponseCode();
                if (responseCode2 < 200 || responseCode2 > 299) {
                    Map<String, List<String>> headerFields = this.zzbgn.getHeaderFields();
                    zzgw();
                    zzpd zzpd = new zzpd(responseCode2, headerFields, zzoz);
                    if (responseCode2 == 416) {
                        zzpd.initCause(new zzox(0));
                    }
                    throw zzpd;
                }
                this.zzbgn.getContentType();
                if (responseCode2 == 200 && zzoz.zzaha != 0) {
                    j = zzoz.zzaha;
                }
                this.zzbgp = j;
                if (!zzoz.zzbg(1)) {
                    long j4 = -1;
                    if (zzoz.zzcc != -1) {
                        this.zzbgq = zzoz.zzcc;
                    } else {
                        long zzc = zzc(this.zzbgn);
                        if (zzc != -1) {
                            j4 = zzc - this.zzbgp;
                        }
                        this.zzbgq = j4;
                    }
                } else {
                    this.zzbgq = zzoz.zzcc;
                }
                try {
                    this.zzbgo = this.zzbgn.getInputStream();
                    this.zzbfr = true;
                    zzpn<? super zzpb> zzpn = this.zzbgm;
                    if (zzpn != null) {
                        zzpn.zza(this, zzoz);
                    }
                    return this.zzbgq;
                } catch (IOException e) {
                    zzgw();
                    throw new zzpc(e, zzoz, 1);
                }
            } catch (IOException e2) {
                zzgw();
                String valueOf2 = String.valueOf(zzoz.uri.toString());
                throw new zzpc(valueOf2.length() != 0 ? "Unable to connect to ".concat(valueOf2) : new String("Unable to connect to "), e2, zzoz, 1);
            }
        } catch (IOException e3) {
            String valueOf3 = String.valueOf(zzoz.uri.toString());
            throw new zzpc(valueOf3.length() != 0 ? "Unable to connect to ".concat(valueOf3) : new String("Unable to connect to "), e3, zzoz, 1);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzov
    public final int read(byte[] bArr, int i, int i2) throws zzpc {
        try {
            if (this.zzbgr != this.zzbgp) {
                byte[] andSet = zzbge.getAndSet(null);
                if (andSet == null) {
                    andSet = new byte[4096];
                }
                while (this.zzbgr != this.zzbgp) {
                    int read = this.zzbgo.read(andSet, 0, (int) Math.min(this.zzbgp - this.zzbgr, (long) andSet.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    } else if (read != -1) {
                        this.zzbgr += (long) read;
                        if (this.zzbgm != null) {
                            this.zzbgm.zzc(this, read);
                        }
                    } else {
                        throw new EOFException();
                    }
                }
                zzbge.set(andSet);
            }
            if (i2 == 0) {
                return 0;
            }
            if (this.zzbgq != -1) {
                long j = this.zzbgq - this.zzcd;
                if (j == 0) {
                    return -1;
                }
                i2 = (int) Math.min((long) i2, j);
            }
            int read2 = this.zzbgo.read(bArr, i, i2);
            if (read2 != -1) {
                this.zzcd += (long) read2;
                if (this.zzbgm != null) {
                    this.zzbgm.zzc(this, read2);
                }
                return read2;
            } else if (this.zzbgq == -1) {
                return -1;
            } else {
                throw new EOFException();
            }
        } catch (IOException e) {
            throw new zzpc(e, this.zzazo, 2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0038, code lost:
        if (r3 > android.support.v4.media.session.PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) goto L_0x003a;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x006b */
    @Override // com.google.android.gms.internal.ads.zzov
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void close() throws com.google.android.gms.internal.ads.zzpc {
        /*
        // Method dump skipped, instructions count: 163
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpb.close():void");
    }

    private final HttpURLConnection zza(URL url, byte[] bArr, long j, long j2, boolean z, boolean z2) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.zzbgg);
        httpURLConnection.setReadTimeout(this.zzbgh);
        for (Map.Entry<String, String> entry : this.zzbgl.zzgx().entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        if (!(j == 0 && j2 == -1)) {
            StringBuilder sb = new StringBuilder(27);
            sb.append("bytes=");
            sb.append(j);
            sb.append("-");
            String sb2 = sb.toString();
            if (j2 != -1) {
                String valueOf = String.valueOf(sb2);
                StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 20);
                sb3.append(valueOf);
                sb3.append((j + j2) - 1);
                sb2 = sb3.toString();
            }
            httpURLConnection.setRequestProperty("Range", sb2);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.zzbgi);
        if (!z) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        if (bArr != null) {
            httpURLConnection.setRequestMethod("POST");
            if (bArr.length != 0) {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.close();
                return httpURLConnection;
            }
        }
        httpURLConnection.connect();
        return httpURLConnection;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long zzc(java.net.HttpURLConnection r8) {
        /*
        // Method dump skipped, instructions count: 212
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpb.zzc(java.net.HttpURLConnection):long");
    }

    private final void zzgw() {
        HttpURLConnection httpURLConnection = this.zzbgn;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.zzbgn = null;
        }
    }
}
