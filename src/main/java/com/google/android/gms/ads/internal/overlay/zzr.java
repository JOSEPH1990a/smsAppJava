package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzaxz;

@zzark
public final class zzr extends zzd {
    public zzr(Activity activity) {
        super(activity);
    }

    @Override // com.google.android.gms.internal.ads.zzaop, com.google.android.gms.ads.internal.overlay.zzd
    public final void onCreate(Bundle bundle) {
        zzaxz.v("AdOverlayParcel is null or does not contain valid overlay type.");
        this.zzdre = 3;
        this.mActivity.finish();
    }
}
