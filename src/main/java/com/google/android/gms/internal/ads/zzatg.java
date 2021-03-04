package com.google.android.gms.internal.ads;

final class zzatg implements zzbcq<zzajr> {
    private final /* synthetic */ zzatf zzeab;

    zzatg(zzatf zzatf) {
        this.zzeab = zzatf;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzbcq
    public final /* synthetic */ void zzh(zzajr zzajr) {
        try {
            zzajr.zzb("AFMA_getAdapterLessMediationAd", this.zzeab.zzdzz);
        } catch (Exception e) {
            zzaxz.zzb("Error requesting an ad url", e);
            zzatd.zzdzv.zzbv(this.zzeab.zzeaa);
        }
    }
}
