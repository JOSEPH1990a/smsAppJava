package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;

@zzark
@TargetApi(16)
public final class zzbfw extends zzbfk implements zzbez {
    private String url;
    private boolean zzexf;
    private zzbes zzexl;
    private Exception zzexm;
    private boolean zzexn;

    public zzbfw(zzbdz zzbdz, zzbdy zzbdy) {
        super(zzbdz);
        this.zzexl = new zzbes(zzbdz.getContext(), zzbdy);
        this.zzexl.zza(this);
    }

    @Override // com.google.android.gms.internal.ads.zzbez
    public final void zzdd(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzbez
    public final void zzp(int i, int i2) {
    }

    @Override // com.google.android.gms.internal.ads.zzbez
    public final void zzb(boolean z, long j) {
        zzbdz zzbdz = (zzbdz) this.zzewo.get();
        if (zzbdz != null) {
            zzbcg.zzepo.execute(new zzbfx(zzbdz, z, j));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbez
    public final void zza(String str, Exception exc) {
        this.zzexm = exc;
        zzaxz.zzc("Precache error", exc);
        zzfa(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbfk
    public final void zzda(int i) {
        this.zzexl.zzacz().zzdg(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbfk
    public final void zzcz(int i) {
        this.zzexl.zzacz().zzdf(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbfk
    public final void zzdb(int i) {
        this.zzexl.zzacz().zzdb(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbfk
    public final void zzdc(int i) {
        this.zzexl.zzacz().zzdc(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbfk, com.google.android.gms.common.api.Releasable
    public final void release() {
        zzbes zzbes = this.zzexl;
        if (zzbes != null) {
            zzbes.zza((zzbez) null);
            this.zzexl.release();
        }
        super.release();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbfk
    public final String zzey(String str) {
        String valueOf = String.valueOf("cache:");
        String valueOf2 = String.valueOf(super.zzey(str));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0078, code lost:
        if (r33.zzexm == null) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007e, code lost:
        throw r33.zzexm;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0088, code lost:
        throw new java.io.IOException("Abort requested before buffering finished. ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0148, code lost:
        r0 = th;
     */
    @Override // com.google.android.gms.internal.ads.zzbfk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzex(java.lang.String r34) {
        /*
        // Method dump skipped, instructions count: 408
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbfw.zzex(java.lang.String):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzbfk
    public final void abort() {
        zzfa(null);
    }

    private final void zzfa(String str) {
        synchronized (this) {
            this.zzexf = true;
            notify();
            release();
        }
        String str2 = this.url;
        if (str2 != null) {
            String zzey = zzey(str2);
            Exception exc = this.zzexm;
            if (exc != null) {
                zza(this.url, zzey, "badUrl", zzb(str, exc));
            } else {
                zza(this.url, zzey, "externalAbort", "Programmatic precache abort.");
            }
        }
    }

    public final zzbes zzadd() {
        synchronized (this) {
            this.zzexn = true;
            notify();
        }
        this.zzexl.zza((zzbez) null);
        zzbes zzbes = this.zzexl;
        this.zzexl = null;
        return zzbes;
    }

    private static String zzb(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(canonicalName).length() + String.valueOf(message).length());
        sb.append(str);
        sb.append("/");
        sb.append(canonicalName);
        sb.append(":");
        sb.append(message);
        return sb.toString();
    }
}
