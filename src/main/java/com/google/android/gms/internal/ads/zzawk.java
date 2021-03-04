package com.google.android.gms.internal.ads;

final class zzawk implements zzbbn<Void> {
    private final /* synthetic */ zzbcb zzegf;

    zzawk(zzawg zzawg, zzbcb zzbcb) {
        this.zzegf = zzbcb;
    }

    @Override // com.google.android.gms.internal.ads.zzbbn
    public final void zzb(Throwable th) {
        zzawg.zzxu().remove(this.zzegf);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzbbn
    public final /* synthetic */ void zzl(Void r2) {
        zzawg.zzxu().remove(this.zzegf);
    }
}
