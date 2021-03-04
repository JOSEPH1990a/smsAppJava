package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzaxv;
import com.google.android.gms.internal.ads.zzayh;

@zzark
final class zzao extends zzaxv {
    final /* synthetic */ zzal zzbow;
    private final int zzbox;

    public zzao(zzal zzal, int i) {
        this.zzbow = zzal;
        this.zzbox = i;
    }

    @Override // com.google.android.gms.internal.ads.zzaxv
    public final void onStop() {
    }

    @Override // com.google.android.gms.internal.ads.zzaxv
    public final void zzki() {
        boolean z = this.zzbow.zzbls.zzbpa;
        zzbv.zzlf();
        zzaq zzaq = new zzaq(z, zzayh.zzay(this.zzbow.zzbls.zzsp), this.zzbow.zzboo, this.zzbow.zzbop, this.zzbow.zzbls.zzbpa ? this.zzbox : -1, this.zzbow.zzboq, this.zzbow.zzbls.zzbsu.zzbph, this.zzbow.zzbls.zzbsu.zzbpi);
        int requestedOrientation = this.zzbow.zzbls.zzbsu.zzdrv.getRequestedOrientation();
        int i = requestedOrientation == -1 ? this.zzbow.zzbls.zzbsu.orientation : requestedOrientation;
        zzal zzal = this.zzbow;
        zzayh.zzelc.post(new zzap(this, new AdOverlayInfoParcel(zzal, zzal, zzal, zzal.zzbls.zzbsu.zzdrv, i, this.zzbow.zzbls.zzbsp, this.zzbow.zzbls.zzbsu.zzdyi, zzaq)));
    }
}
