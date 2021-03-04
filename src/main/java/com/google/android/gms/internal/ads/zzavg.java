package com.google.android.gms.internal.ads;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

@zzark
public final class zzavg extends zzavc {
    @Nullable
    private RewardedVideoAdListener zzhy;

    public zzavg(@Nullable RewardedVideoAdListener rewardedVideoAdListener) {
        this.zzhy = rewardedVideoAdListener;
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void onRewardedVideoAdLoaded() {
        RewardedVideoAdListener rewardedVideoAdListener = this.zzhy;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoAdLoaded();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void onRewardedVideoAdOpened() {
        RewardedVideoAdListener rewardedVideoAdListener = this.zzhy;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoAdOpened();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void onRewardedVideoStarted() {
        RewardedVideoAdListener rewardedVideoAdListener = this.zzhy;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoStarted();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void onRewardedVideoAdClosed() {
        RewardedVideoAdListener rewardedVideoAdListener = this.zzhy;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoAdClosed();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void zza(zzaur zzaur) {
        RewardedVideoAdListener rewardedVideoAdListener = this.zzhy;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewarded(new zzave(zzaur));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void onRewardedVideoAdLeftApplication() {
        RewardedVideoAdListener rewardedVideoAdListener = this.zzhy;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoAdLeftApplication();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void onRewardedVideoAdFailedToLoad(int i) {
        RewardedVideoAdListener rewardedVideoAdListener = this.zzhy;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoAdFailedToLoad(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void onRewardedVideoCompleted() {
        RewardedVideoAdListener rewardedVideoAdListener = this.zzhy;
        if (rewardedVideoAdListener != null) {
            rewardedVideoAdListener.onRewardedVideoCompleted();
        }
    }

    @Nullable
    public final RewardedVideoAdListener getRewardedVideoAdListener() {
        return this.zzhy;
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        this.zzhy = rewardedVideoAdListener;
    }
}
