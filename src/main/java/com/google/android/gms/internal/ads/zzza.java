package com.google.android.gms.internal.ads;

/* access modifiers changed from: package-private */
public final class zzza extends zzww {
    private final /* synthetic */ zzyz zzcms;

    zzza(zzyz zzyz) {
        this.zzcms = zzyz;
    }

    @Override // com.google.android.gms.internal.ads.zzww, com.google.android.gms.ads.AdListener
    public final void onAdLoaded() {
        this.zzcms.zzcml.zza(this.zzcms.zzbc());
        super.onAdLoaded();
    }

    @Override // com.google.android.gms.internal.ads.zzww, com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(int i) {
        this.zzcms.zzcml.zza(this.zzcms.zzbc());
        super.onAdFailedToLoad(i);
    }
}
