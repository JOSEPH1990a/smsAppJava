package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzwb;

final class zzai implements Runnable {
    private final /* synthetic */ zzwb zzbod;
    private final /* synthetic */ zzah zzboe;

    zzai(zzah zzah, zzwb zzwb) {
        this.zzboe = zzah;
        this.zzbod = zzwb;
    }

    public final void run() {
        synchronized (zzah.zza(this.zzboe)) {
            if (zzah.zzb(this.zzboe)) {
                zzah.zza(this.zzboe, this.zzbod);
            } else {
                zzah.zza(this.zzboe, this.zzbod, 1);
            }
        }
    }
}
