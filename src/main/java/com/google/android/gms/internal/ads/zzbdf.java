package com.google.android.gms.internal.ads;

final class zzbdf implements Runnable {
    private final /* synthetic */ zzbcx zzeqv;

    zzbdf(zzbcx zzbcx) {
        this.zzeqv = zzbcx;
    }

    public final void run() {
        if (zzbcx.zza(this.zzeqv) != null) {
            zzbcx.zza(this.zzeqv).zzabf();
        }
    }
}
