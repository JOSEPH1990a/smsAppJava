package com.google.android.gms.internal.ads;

import android.view.View;

public final class zzrk implements zzsq {
    private zzacd zzbvn;

    public zzrk(zzacd zzacd) {
        this.zzbvn = zzacd;
    }

    @Override // com.google.android.gms.internal.ads.zzsq
    public final zzsq zzne() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzsq
    public final View zznc() {
        zzacd zzacd = this.zzbvn;
        if (zzacd != null) {
            return zzacd.zzss();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzsq
    public final boolean zznd() {
        return this.zzbvn == null;
    }
}
