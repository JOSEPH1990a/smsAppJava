package com.google.android.gms.internal.ads;

/* access modifiers changed from: package-private */
public final class zzajf implements zzbco {
    private final /* synthetic */ zzait zzdjj;
    private final /* synthetic */ zzajm zzdjm;

    zzajf(zzait zzait, zzajm zzajm) {
        this.zzdjj = zzait;
        this.zzdjm = zzajm;
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void run() {
        synchronized (zzait.zza(this.zzdjj)) {
            zzait.zza(this.zzdjj, 1);
            zzaxz.v("Failed loading new engine. Marking new engine destroyable.");
            this.zzdjm.zzuf();
        }
    }
}
