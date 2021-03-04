package com.google.android.gms.internal.ads;

import java.io.InputStream;

/* access modifiers changed from: package-private */
public final class zzuf extends zzbcl<InputStream> {
    private final /* synthetic */ zzue zzcad;

    zzuf(zzue zzue) {
        this.zzcad = zzue;
    }

    @Override // com.google.android.gms.internal.ads.zzbcl
    public final boolean cancel(boolean z) {
        zzue.zza(this.zzcad);
        return super.cancel(z);
    }
}
