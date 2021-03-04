package com.google.android.gms.internal.ads;

import android.content.Context;

/* access modifiers changed from: package-private */
public final /* synthetic */ class zzayd implements Runnable {
    private final Context zzcmy;
    private final zzayc zzekw;
    private final String zzekx;

    zzayd(zzayc zzayc, Context context, String str) {
        this.zzekw = zzayc;
        this.zzcmy = context;
        this.zzekx = str;
    }

    public final void run() {
        this.zzekw.zzm(this.zzcmy, this.zzekx);
    }
}
