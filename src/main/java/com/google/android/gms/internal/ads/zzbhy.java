package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzn;

final class zzbhy implements zzn {
    private zzn zzexw;
    private zzbgg zzeyq;

    public zzbhy(zzbgg zzbgg, zzn zzn) {
        this.zzeyq = zzbgg;
        this.zzexw = zzn;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzn
    public final void onPause() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzn
    public final void onResume() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzn
    public final void zziw() {
        this.zzexw.zziw();
        this.zzeyq.zzvv();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzn
    public final void zziv() {
        this.zzexw.zziv();
        this.zzeyq.zzade();
    }
}
