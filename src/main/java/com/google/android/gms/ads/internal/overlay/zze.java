package com.google.android.gms.ads.internal.overlay;

import com.google.android.gms.internal.ads.zzbho;

/* access modifiers changed from: package-private */
public final /* synthetic */ class zze implements zzbho {
    private final zzd zzdrm;

    zze(zzd zzd) {
        this.zzdrm = zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzbho
    public final void zzp(boolean z) {
        zzd zzd = this.zzdrm;
        if (zzd.zzdin != null) {
            zzd.zzdin.zzvv();
        }
    }
}
