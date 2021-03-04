package com.google.android.gms.internal.ads;

final class zzsv implements Runnable {
    private final /* synthetic */ zzsu zzbxy;

    zzsv(zzsu zzsu) {
        this.zzbxy = zzsu;
    }

    public final void run() {
        synchronized (this.zzbxy.mLock) {
            if (!(this.zzbxy.zzbxs) || !(this.zzbxy.zzbxt)) {
                zzaxz.zzdn("App is still foreground");
            } else {
                this.zzbxy.zzbxs = false;
                zzaxz.zzdn("App went background");
                for (zzsw zzsw : this.zzbxy.zzbxu) {
                    try {
                        zzsw.zzs(false);
                    } catch (Exception e) {
                        zzbbd.zzb("", e);
                    }
                }
            }
        }
    }
}
