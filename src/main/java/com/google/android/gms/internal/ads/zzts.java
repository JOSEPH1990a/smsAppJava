package com.google.android.gms.internal.ads;

/* access modifiers changed from: package-private */
public final class zzts implements zzsw {
    private final /* synthetic */ zztq zzbzt;

    zzts(zztq zztq) {
        this.zzbzt = zztq;
    }

    @Override // com.google.android.gms.internal.ads.zzsw
    public final void zzs(boolean z) {
        if (z) {
            this.zzbzt.connect();
        } else {
            this.zzbzt.disconnect();
        }
    }
}
