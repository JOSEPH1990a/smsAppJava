package com.google.android.gms.ads;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import android.util.AttributeSet;
import com.google.android.gms.internal.ads.zzark;

@zzark
public final class NativeExpressAdView extends BaseAdView {
    public NativeExpressAdView(Context context) {
        super(context, 1);
    }

    public NativeExpressAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 1);
    }

    public NativeExpressAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 1);
    }

    public final VideoController getVideoController() {
        return this.zzvw.getVideoController();
    }

    public final void setVideoOptions(VideoOptions videoOptions) {
        this.zzvw.setVideoOptions(videoOptions);
    }

    public final VideoOptions getVideoOptions() {
        return this.zzvw.getVideoOptions();
    }

    @Override // com.google.android.gms.ads.BaseAdView
    public final /* bridge */ /* synthetic */ String getMediationAdapterClassName() {
        return super.getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.ads.BaseAdView
    public final /* bridge */ /* synthetic */ void setAdUnitId(String str) {
        super.setAdUnitId(str);
    }

    @Override // com.google.android.gms.ads.BaseAdView
    public final /* bridge */ /* synthetic */ void setAdSize(AdSize adSize) {
        super.setAdSize(adSize);
    }

    @Override // com.google.android.gms.ads.BaseAdView
    public final /* bridge */ /* synthetic */ void setAdListener(AdListener adListener) {
        super.setAdListener(adListener);
    }

    @Override // com.google.android.gms.ads.BaseAdView
    public final /* bridge */ /* synthetic */ boolean isLoading() {
        return super.isLoading();
    }

    @Override // com.google.android.gms.ads.BaseAdView
    public final /* bridge */ /* synthetic */ void resume() {
        super.resume();
    }

    @Override // com.google.android.gms.ads.BaseAdView
    public final /* bridge */ /* synthetic */ void pause() {
        super.pause();
    }

    @Override // com.google.android.gms.ads.BaseAdView
    @RequiresPermission("android.permission.INTERNET")
    public final /* bridge */ /* synthetic */ void loadAd(AdRequest adRequest) {
        super.loadAd(adRequest);
    }

    @Override // com.google.android.gms.ads.BaseAdView
    public final /* bridge */ /* synthetic */ String getAdUnitId() {
        return super.getAdUnitId();
    }

    @Override // com.google.android.gms.ads.BaseAdView
    public final /* bridge */ /* synthetic */ AdSize getAdSize() {
        return super.getAdSize();
    }

    @Override // com.google.android.gms.ads.BaseAdView
    public final /* bridge */ /* synthetic */ AdListener getAdListener() {
        return super.getAdListener();
    }

    @Override // com.google.android.gms.ads.BaseAdView
    public final /* bridge */ /* synthetic */ void destroy() {
        super.destroy();
    }
}
