package com.google.android.gms.internal.ads;

final class zzbdd implements Runnable {
    private final /* synthetic */ zzbcx zzeqv;
    private final /* synthetic */ int zzeqy;
    private final /* synthetic */ int zzeqz;

    zzbdd(zzbcx zzbcx, int i, int i2) {
        this.zzeqv = zzbcx;
        this.zzeqy = i;
        this.zzeqz = i2;
    }

    public final void run() {
        if (zzbcx.zza(this.zzeqv) != null) {
            zzbcx.zza(this.zzeqv).zzm(this.zzeqy, this.zzeqz);
        }
    }
}
