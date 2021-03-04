package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;

@zzark
public final class zzwa extends zzxr {
    private final AdMetadataListener zzcja;

    public zzwa(AdMetadataListener adMetadataListener) {
        this.zzcja = adMetadataListener;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void onAdMetadataChanged() {
        AdMetadataListener adMetadataListener = this.zzcja;
        if (adMetadataListener != null) {
            adMetadataListener.onAdMetadataChanged();
        }
    }
}
