package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

/* access modifiers changed from: package-private */
public final class zzkg implements zzkf {
    private zzkg() {
    }

    @Override // com.google.android.gms.internal.ads.zzkf
    public final boolean zzes() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzkf
    public final int getCodecCount() {
        return MediaCodecList.getCodecCount();
    }

    @Override // com.google.android.gms.internal.ads.zzkf
    public final MediaCodecInfo getCodecInfoAt(int i) {
        return MediaCodecList.getCodecInfoAt(i);
    }

    @Override // com.google.android.gms.internal.ads.zzkf
    public final boolean zza(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return "video/avc".equals(str);
    }
}
