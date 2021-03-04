package com.google.android.gms.internal.ads;

/* access modifiers changed from: package-private */
public final class zzajk implements zzbcq<zzajr> {
    private final /* synthetic */ zzaji zzdjr;

    zzajk(zzaji zzaji) {
        this.zzdjr = zzaji;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzbcq
    public final /* synthetic */ void zzh(zzajr zzajr) {
        zzaxz.v("Releasing engine reference.");
        this.zzdjr.zzdjp.zzue();
    }
}
