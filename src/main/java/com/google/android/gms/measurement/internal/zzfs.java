package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* access modifiers changed from: package-private */
public final class zzfs implements Callable<String> {
    private final /* synthetic */ zzk zzaqk;
    private final /* synthetic */ zzfo zzaue;

    zzfs(zzfo zzfo, zzk zzk) {
        this.zzaue = zzfo;
        this.zzaqk = zzk;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        zzg zzg;
        if (this.zzaue.zzgv().zzba(this.zzaqk.packageName)) {
            zzg = this.zzaue.zzg(this.zzaqk);
        } else {
            zzg = this.zzaue.zzjt().zzbm(this.zzaqk.packageName);
        }
        if (zzg != null) {
            return zzg.getAppInstanceId();
        }
        this.zzaue.zzgt().zzjj().zzby("App info was null when attempting to get app instance id");
        return null;
    }
}
