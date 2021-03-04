package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;

/* access modifiers changed from: package-private */
public final class zzacv implements zzacb {
    private final /* synthetic */ View zzddh;
    private final /* synthetic */ zzact zzddo;

    zzacv(zzact zzact, View view) {
        this.zzddo = zzact;
        this.zzddh = view;
    }

    @Override // com.google.android.gms.internal.ads.zzacb
    public final void zzsh() {
        if (this.zzddo.zza(zzact.zzdcy)) {
            this.zzddo.onClick(this.zzddh);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacb
    public final void zzc(MotionEvent motionEvent) {
        this.zzddo.onTouch(null, motionEvent);
    }
}
