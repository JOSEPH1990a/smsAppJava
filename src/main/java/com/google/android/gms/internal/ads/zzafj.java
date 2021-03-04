package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd;

public final class zzafj extends zzaeu {
    private final UnifiedNativeAd.UnconfirmedClickListener zzdeq;

    public zzafj(UnifiedNativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        this.zzdeq = unconfirmedClickListener;
    }

    @Override // com.google.android.gms.internal.ads.zzaet
    public final void onUnconfirmedClickReceived(String str) {
        this.zzdeq.onUnconfirmedClickReceived(str);
    }

    @Override // com.google.android.gms.internal.ads.zzaet
    public final void onUnconfirmedClickCancelled() {
        this.zzdeq.onUnconfirmedClickCancelled();
    }
}
