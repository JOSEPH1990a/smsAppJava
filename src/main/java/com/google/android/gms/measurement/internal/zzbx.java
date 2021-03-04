package com.google.android.gms.measurement.internal;

/* access modifiers changed from: package-private */
public final class zzbx implements Runnable {
    private final /* synthetic */ zzcz zzaqg;
    private final /* synthetic */ zzbw zzaqh;

    zzbx(zzbw zzbw, zzcz zzcz) {
        this.zzaqh = zzbw;
        this.zzaqg = zzcz;
    }

    public final void run() {
        this.zzaqh.zza((zzbw) this.zzaqg);
        this.zzaqh.start();
    }
}
