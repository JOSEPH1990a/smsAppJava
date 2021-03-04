package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzlj implements zzlv {
    private final int track;
    private final /* synthetic */ zzlc zzaxn;

    public zzlj(zzlc zzlc, int i) {
        this.zzaxn = zzlc;
        this.track = i;
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final boolean isReady() {
        return this.zzaxn.zzap(this.track);
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final void zzev() throws IOException {
        this.zzaxn.zzev();
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final int zzb(zzfu zzfu, zzho zzho, boolean z) {
        return this.zzaxn.zza(this.track, zzfu, zzho, z);
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final void zzz(long j) {
        this.zzaxn.zzd(this.track, j);
    }
}
