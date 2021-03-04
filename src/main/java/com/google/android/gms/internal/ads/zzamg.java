package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@zzark
public final class zzamg extends zzalw {
    private final NativeContentAdMapper zzdoe;

    public zzamg(NativeContentAdMapper nativeContentAdMapper) {
        this.zzdoe = nativeContentAdMapper;
    }

    @Override // com.google.android.gms.internal.ads.zzalv
    public final IObjectWrapper zzsd() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzalv
    public final zzacx zzse() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzalv
    public final String getHeadline() {
        return this.zzdoe.getHeadline();
    }

    @Override // com.google.android.gms.internal.ads.zzalv
    public final List getImages() {
        List<NativeAd.Image> images = this.zzdoe.getImages();
        if (images == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NativeAd.Image image : images) {
            arrayList.add(new zzabr(image.getDrawable(), image.getUri(), image.getScale()));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzalv
    public final String getBody() {
        return this.zzdoe.getBody();
    }

    @Override // com.google.android.gms.internal.ads.zzalv
    public final zzadb zzsf() {
        NativeAd.Image logo = this.zzdoe.getLogo();
        if (logo != null) {
            return new zzabr(logo.getDrawable(), logo.getUri(), logo.getScale());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzalv
    public final String getCallToAction() {
        return this.zzdoe.getCallToAction();
    }

    @Override // com.google.android.gms.internal.ads.zzalv
    public final String getAdvertiser() {
        return this.zzdoe.getAdvertiser();
    }

    @Override // com.google.android.gms.internal.ads.zzalv
    public final void recordImpression() {
        this.zzdoe.recordImpression();
    }

    @Override // com.google.android.gms.internal.ads.zzalv
    public final void zzk(IObjectWrapper iObjectWrapper) {
        this.zzdoe.handleClick((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzalv
    public final void zzl(IObjectWrapper iObjectWrapper) {
        this.zzdoe.trackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzalv
    public final void zzb(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.zzdoe.trackViews((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    @Override // com.google.android.gms.internal.ads.zzalv
    public final void zzm(IObjectWrapper iObjectWrapper) {
        this.zzdoe.untrackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzalv
    public final boolean getOverrideImpressionRecording() {
        return this.zzdoe.getOverrideImpressionRecording();
    }

    @Override // com.google.android.gms.internal.ads.zzalv
    public final boolean getOverrideClickHandling() {
        return this.zzdoe.getOverrideClickHandling();
    }

    @Override // com.google.android.gms.internal.ads.zzalv
    public final Bundle getExtras() {
        return this.zzdoe.getExtras();
    }

    @Override // com.google.android.gms.internal.ads.zzalv
    public final IObjectWrapper zzvb() {
        View adChoicesContent = this.zzdoe.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.wrap(adChoicesContent);
    }

    @Override // com.google.android.gms.internal.ads.zzalv
    public final zzyp getVideoController() {
        if (this.zzdoe.getVideoController() != null) {
            return this.zzdoe.getVideoController().zzbc();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzalv
    public final IObjectWrapper zzvc() {
        View zzafh = this.zzdoe.zzafh();
        if (zzafh == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzafh);
    }
}
