package com.google.android.gms.internal.ads;

import android.view.View;

/* access modifiers changed from: package-private */
public final class zzbgj implements Runnable {
    private final /* synthetic */ View val$view;
    private final /* synthetic */ zzawr zzeyn;
    private final /* synthetic */ int zzeyo;
    private final /* synthetic */ zzbgh zzeyp;

    zzbgj(zzbgh zzbgh, View view, zzawr zzawr, int i) {
        this.zzeyp = zzbgh;
        this.val$view = view;
        this.zzeyn = zzawr;
        this.zzeyo = i;
    }

    public final void run() {
        this.zzeyp.zza((zzbgh) this.val$view, (View) this.zzeyn, (zzawr) (this.zzeyo - 1));
    }
}
