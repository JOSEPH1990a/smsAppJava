package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Bundle;

/* access modifiers changed from: package-private */
public final class zzbo implements Runnable {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzbw zzaoe;
    private final /* synthetic */ zzas zzaof;
    private final /* synthetic */ long zzaog;
    private final /* synthetic */ Bundle zzaoh;
    private final /* synthetic */ BroadcastReceiver.PendingResult zzrf;

    zzbo(zzbm zzbm, zzbw zzbw, long j, Bundle bundle, Context context, zzas zzas, BroadcastReceiver.PendingResult pendingResult) {
        this.zzaoe = zzbw;
        this.zzaog = j;
        this.zzaoh = bundle;
        this.val$context = context;
        this.zzaof = zzas;
        this.zzrf = pendingResult;
    }

    public final void run() {
        long j = this.zzaoe.zzgu().zzanf.get();
        long j2 = this.zzaog;
        if (j > 0 && (j2 >= j || j2 <= 0)) {
            j2 = j - 1;
        }
        if (j2 > 0) {
            this.zzaoh.putLong("click_timestamp", j2);
        }
        this.zzaoh.putString("_cis", "referrer broadcast");
        zzbw.zza(this.val$context, (zzan) null).zzgj().logEvent("auto", "_cmp", this.zzaoh);
        this.zzaof.zzjo().zzby("Install campaign recorded");
        BroadcastReceiver.PendingResult pendingResult = this.zzrf;
        if (pendingResult != null) {
            pendingResult.finish();
        }
    }
}
