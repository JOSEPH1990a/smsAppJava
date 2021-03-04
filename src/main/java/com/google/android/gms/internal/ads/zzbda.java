package com.google.android.gms.internal.ads;

final class zzbda implements Runnable {
    private final /* synthetic */ zzbcx zzeqv;

    zzbda(zzbcx zzbcx) {
        this.zzeqv = zzbcx;
    }

    public final void run() {
        if (zzbcx.zza(this.zzeqv) != null) {
            zzbcx.zza(this.zzeqv).zzabg();
        }
    }
}
