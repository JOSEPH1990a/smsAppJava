package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

final class zzabx implements zzacb {
    private final /* synthetic */ zzabw zzdbr;

    zzabx(zzabw zzabw) {
        this.zzdbr = zzabw;
    }

    @Override // com.google.android.gms.internal.ads.zzacb
    public final void zzc(MotionEvent motionEvent) {
    }

    @Override // com.google.android.gms.internal.ads.zzacb
    public final void zzsh() {
        this.zzdbr.performClick(NativeCustomTemplateAd.ASSET_NAME_VIDEO);
    }
}
