package com.google.android.gms.internal.ads;

final class zzbde implements Runnable {
    private final /* synthetic */ zzbcx zzeqv;

    zzbde(zzbcx zzbcx) {
        this.zzeqv = zzbcx;
    }

    public final void run() {
        if (zzbcx.zza(this.zzeqv) != null) {
            zzbcx.zza(this.zzeqv).onPaused();
            zzbcx.zza(this.zzeqv).zzabh();
        }
    }
}
