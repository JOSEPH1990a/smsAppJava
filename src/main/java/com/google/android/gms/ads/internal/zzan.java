package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzavr;
import com.google.android.gms.internal.ads.zzawd;

/* access modifiers changed from: package-private */
public final class zzan implements zzavr {
    private final /* synthetic */ zzal zzbow;

    zzan(zzal zzal) {
        this.zzbow = zzal;
    }

    @Override // com.google.android.gms.internal.ads.zzavr
    public final void onRewardedVideoAdOpened() {
        this.zzbow.zziw();
    }

    @Override // com.google.android.gms.internal.ads.zzavr
    public final void onRewardedVideoStarted() {
        this.zzbow.zzkf();
    }

    @Override // com.google.android.gms.internal.ads.zzavr
    public final void onRewardedVideoAdClosed() {
        this.zzbow.zziv();
    }

    @Override // com.google.android.gms.internal.ads.zzavr
    public final void zzc(zzawd zzawd) {
        this.zzbow.zzb(zzawd);
    }

    @Override // com.google.android.gms.internal.ads.zzavr
    public final void zzkh() {
        this.zzbow.onAdClicked();
    }

    @Override // com.google.android.gms.internal.ads.zzavr
    public final void onRewardedVideoAdLeftApplication() {
        this.zzbow.zzij();
    }

    @Override // com.google.android.gms.internal.ads.zzavr
    public final void onRewardedVideoCompleted() {
        this.zzbow.zzkg();
    }
}
