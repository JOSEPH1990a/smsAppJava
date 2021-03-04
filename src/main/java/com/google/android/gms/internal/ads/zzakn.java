package com.google.android.gms.internal.ads;

import android.content.Context;

/* access modifiers changed from: package-private */
public final /* synthetic */ class zzakn implements Runnable {
    private final Context zzdks;
    private final zzakm zzdkt;

    zzakn(Context context, zzakm zzakm) {
        this.zzdks = context;
        this.zzdkt = zzakm;
    }

    public final void run() {
        zzakm.zza(this.zzdks, this.zzdkt);
    }
}
