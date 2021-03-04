package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

/* access modifiers changed from: package-private */
@TargetApi(21)
public final class zzkh implements zzkf {
    private final int zzavp;
    private MediaCodecInfo[] zzavq;

    public zzkh(boolean z) {
        this.zzavp = z ? 1 : 0;
    }

    @Override // com.google.android.gms.internal.ads.zzkf
    public final boolean zzes() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzkf
    public final int getCodecCount() {
        zzet();
        return this.zzavq.length;
    }

    @Override // com.google.android.gms.internal.ads.zzkf
    public final MediaCodecInfo getCodecInfoAt(int i) {
        zzet();
        return this.zzavq[i];
    }

    @Override // com.google.android.gms.internal.ads.zzkf
    public final boolean zza(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    private final void zzet() {
        if (this.zzavq == null) {
            this.zzavq = new MediaCodecList(this.zzavp).getCodecInfos();
        }
    }
}
