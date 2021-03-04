package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@zzark
public final class zzamf extends zzalt {
    private final NativeAppInstallAdMapper zzdod;

    public zzamf(NativeAppInstallAdMapper nativeAppInstallAdMapper) {
        this.zzdod = nativeAppInstallAdMapper;
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final IObjectWrapper zzsd() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final zzacx zzse() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final String getHeadline() {
        return this.zzdod.getHeadline();
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final List getImages() {
        List<NativeAd.Image> images = this.zzdod.getImages();
        if (images == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NativeAd.Image image : images) {
            arrayList.add(new zzabr(image.getDrawable(), image.getUri(), image.getScale()));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final String getBody() {
        return this.zzdod.getBody();
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final zzadb zzsb() {
        NativeAd.Image icon = this.zzdod.getIcon();
        if (icon != null) {
            return new zzabr(icon.getDrawable(), icon.getUri(), icon.getScale());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final String getCallToAction() {
        return this.zzdod.getCallToAction();
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final double getStarRating() {
        return this.zzdod.getStarRating();
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final String getStore() {
        return this.zzdod.getStore();
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final String getPrice() {
        return this.zzdod.getPrice();
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final void recordImpression() {
        this.zzdod.recordImpression();
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final void zzk(IObjectWrapper iObjectWrapper) {
        this.zzdod.handleClick((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final void zzl(IObjectWrapper iObjectWrapper) {
        this.zzdod.trackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final void zzb(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.zzdod.trackViews((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final void zzm(IObjectWrapper iObjectWrapper) {
        this.zzdod.untrackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final boolean getOverrideImpressionRecording() {
        return this.zzdod.getOverrideImpressionRecording();
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final boolean getOverrideClickHandling() {
        return this.zzdod.getOverrideClickHandling();
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final Bundle getExtras() {
        return this.zzdod.getExtras();
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final zzyp getVideoController() {
        if (this.zzdod.getVideoController() != null) {
            return this.zzdod.getVideoController().zzbc();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final IObjectWrapper zzvb() {
        View adChoicesContent = this.zzdod.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.wrap(adChoicesContent);
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final IObjectWrapper zzvc() {
        View zzafh = this.zzdod.zzafh();
        if (zzafh == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzafh);
    }
}
