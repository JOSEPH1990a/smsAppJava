package com.google.android.gms.internal.ads;

/* access modifiers changed from: package-private */
public final class zzaje implements zzbcq<zzaii> {
    private final /* synthetic */ zzait zzdjj;
    private final /* synthetic */ zzajm zzdjm;

    zzaje(zzait zzait, zzajm zzajm) {
        this.zzdjj = zzait;
        this.zzdjm = zzajm;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzbcq
    public final /* synthetic */ void zzh(zzaii zzaii) {
        synchronized (zzait.zza(this.zzdjj)) {
            zzait.zza(this.zzdjj, 0);
            if (!(zzait.zzb(this.zzdjj) == null || this.zzdjm == zzait.zzb(this.zzdjj))) {
                zzaxz.v("New JS engine is loaded, marking previous one as destroyable.");
                zzait.zzb(this.zzdjj).zzuf();
            }
            zzait.zza(this.zzdjj, this.zzdjm);
        }
    }
}
