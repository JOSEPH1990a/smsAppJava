package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;

public class zzaj implements zzm {
    private static final boolean DEBUG = zzaf.DEBUG;
    @Deprecated
    private final zzar zzbo;
    private final zzai zzbp;
    private final zzak zzbq;

    @Deprecated
    public zzaj(zzar zzar) {
        this(zzar, new zzak(4096));
    }

    @Deprecated
    private zzaj(zzar zzar, zzak zzak) {
        this.zzbo = zzar;
        this.zzbp = new zzah(zzar);
        this.zzbq = zzak;
    }

    public zzaj(zzai zzai) {
        this(zzai, new zzak(4096));
    }

    private zzaj(zzai zzai, zzak zzak) {
        this.zzbp = zzai;
        this.zzbo = zzai;
        this.zzbq = zzak;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0208, code lost:
        throw new com.google.android.gms.internal.ads.zzq(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0209, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x020a, code lost:
        r2 = java.lang.String.valueOf(r22.getUrl());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x021a, code lost:
        if (r2.length() != 0) goto L_0x021c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x021c, code lost:
        r2 = "Bad URL ".concat(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0221, code lost:
        r2 = new java.lang.String("Bad URL ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0229, code lost:
        throw new java.lang.RuntimeException(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x022a, code lost:
        zza("socket", r22, new com.google.android.gms.internal.ads.zzad());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x018d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x018e, code lost:
        r17 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0191, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0192, code lost:
        r17 = r5;
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0195, code lost:
        r13 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0198, code lost:
        r0 = r10.getStatusCode();
        com.google.android.gms.internal.ads.zzaf.e("Unexpected response code %d for %s", java.lang.Integer.valueOf(r0), r22.getUrl());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01af, code lost:
        if (r13 != null) goto L_0x01b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01b1, code lost:
        r5 = new com.google.android.gms.internal.ads.zzp(r0, r13, false, android.os.SystemClock.elapsedRealtime() - r3, r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01c1, code lost:
        if (r0 == 401) goto L_0x01eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01ca, code lost:
        if (r0 < 400) goto L_0x01d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01d6, code lost:
        throw new com.google.android.gms.internal.ads.zzg(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01d9, code lost:
        if (r0 < 500) goto L_0x01e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01e4, code lost:
        throw new com.google.android.gms.internal.ads.zzac(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01ea, code lost:
        throw new com.google.android.gms.internal.ads.zzac(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01eb, code lost:
        zza("auth", r22, new com.google.android.gms.internal.ads.zza(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01f7, code lost:
        zza("network", r22, new com.google.android.gms.internal.ads.zzo());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0209 A[ExcHandler: MalformedURLException (r0v1 'e' java.net.MalformedURLException A[CUSTOM_DECLARE]), Splitter:B:2:0x000f] */
    /* JADX WARNING: Removed duplicated region for block: B:110:? A[ExcHandler: SocketTimeoutException (unused java.net.SocketTimeoutException), SYNTHETIC, Splitter:B:2:0x000f] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0203 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0198  */
    @Override // com.google.android.gms.internal.ads.zzm
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.ads.zzp zzc(com.google.android.gms.internal.ads.zzr<?> r22) throws com.google.android.gms.internal.ads.zzae {
        /*
        // Method dump skipped, instructions count: 566
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaj.zzc(com.google.android.gms.internal.ads.zzr):com.google.android.gms.internal.ads.zzp");
    }

    private static void zza(String str, zzr<?> zzr, zzae zzae) throws zzae {
        zzab zzk = zzr.zzk();
        int zzj = zzr.zzj();
        try {
            zzk.zza(zzae);
            zzr.zzb(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(zzj)));
        } catch (zzae e) {
            zzr.zzb(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(zzj)));
            throw e;
        }
    }

    private final byte[] zza(InputStream inputStream, int i) throws IOException, zzac {
        zzav zzav = new zzav(this.zzbq, i);
        if (inputStream != null) {
            try {
                byte[] zzb = this.zzbq.zzb(1024);
                while (true) {
                    int read = inputStream.read(zzb);
                    if (read == -1) {
                        break;
                    }
                    zzav.write(zzb, 0, read);
                }
                byte[] byteArray = zzav.toByteArray();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                        zzaf.v("Error occurred when closing InputStream", new Object[0]);
                    }
                }
                this.zzbq.zza(zzb);
                zzav.close();
                return byteArray;
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                        zzaf.v("Error occurred when closing InputStream", new Object[0]);
                    }
                }
                this.zzbq.zza(null);
                zzav.close();
                throw th;
            }
        } else {
            throw new zzac();
        }
    }
}
