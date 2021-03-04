package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;

final class zzacs implements zzacb {
    private final /* synthetic */ View zzddh;
    private final /* synthetic */ zzacr zzddi;

    zzacs(zzacr zzacr, View view) {
        this.zzddi = zzacr;
        this.zzddh = view;
    }

    @Override // com.google.android.gms.internal.ads.zzacb
    public final void zzsh() {
        this.zzddi.onClick(this.zzddh);
    }

    @Override // com.google.android.gms.internal.ads.zzacb
    public final void zzc(MotionEvent motionEvent) {
        this.zzddi.onTouch(null, motionEvent);
    }
}
