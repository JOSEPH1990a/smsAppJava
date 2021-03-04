package com.google.ads.mediation;

import com.google.android.gms.ads.reward.AdMetadataListener;

final class zzb extends AdMetadataListener {
    private final /* synthetic */ AbstractAdViewAdapter zzhz;

    zzb(AbstractAdViewAdapter abstractAdViewAdapter) {
        this.zzhz = abstractAdViewAdapter;
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final void onAdMetadataChanged() {
        if (AbstractAdViewAdapter.zzb(this.zzhz) != null && AbstractAdViewAdapter.zza(this.zzhz) != null) {
            AbstractAdViewAdapter.zza(this.zzhz).zzc(AbstractAdViewAdapter.zzb(this.zzhz).getAdMetadata());
        }
    }
}
