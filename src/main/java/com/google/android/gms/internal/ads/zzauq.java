package com.google.android.gms.internal.ads;

final class zzauq implements Runnable {
    private final /* synthetic */ zzaxg zzblz;
    private final /* synthetic */ zzauo zzeek;

    zzauq(zzauo zzauo, zzaxg zzaxg) {
        this.zzeek = zzauo;
        this.zzblz = zzaxg;
    }

    public final void run() {
        this.zzeek.zzb(new zzaxf(this.zzblz, null, null, null, null, null, null, null));
    }
}
