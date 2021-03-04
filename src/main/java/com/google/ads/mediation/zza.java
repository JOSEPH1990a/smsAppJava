package com.google.ads.mediation;

import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

final class zza implements RewardedVideoAdListener {
    private final /* synthetic */ AbstractAdViewAdapter zzhz;

    zza(AbstractAdViewAdapter abstractAdViewAdapter) {
        this.zzhz = abstractAdViewAdapter;
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void onRewardedVideoAdLoaded() {
        AbstractAdViewAdapter.zza(this.zzhz).onAdLoaded(this.zzhz);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void onRewardedVideoAdOpened() {
        AbstractAdViewAdapter.zza(this.zzhz).onAdOpened(this.zzhz);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void onRewardedVideoStarted() {
        AbstractAdViewAdapter.zza(this.zzhz).onVideoStarted(this.zzhz);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void onRewardedVideoAdClosed() {
        AbstractAdViewAdapter.zza(this.zzhz).onAdClosed(this.zzhz);
        AbstractAdViewAdapter.zza(this.zzhz, (InterstitialAd) null);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void onRewarded(RewardItem rewardItem) {
        AbstractAdViewAdapter.zza(this.zzhz).onRewarded(this.zzhz, rewardItem);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void onRewardedVideoAdLeftApplication() {
        AbstractAdViewAdapter.zza(this.zzhz).onAdLeftApplication(this.zzhz);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void onRewardedVideoAdFailedToLoad(int i) {
        AbstractAdViewAdapter.zza(this.zzhz).onAdFailedToLoad(this.zzhz, i);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAdListener
    public final void onRewardedVideoCompleted() {
        AbstractAdViewAdapter.zza(this.zzhz).onVideoCompleted(this.zzhz);
    }
}
