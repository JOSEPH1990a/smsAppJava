package com.google.android.gms.measurement.internal;

import android.support.annotation.WorkerThread;

/* access modifiers changed from: package-private */
public final class zzfg extends zzy {
    private final /* synthetic */ zzfd zzatd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfg(zzfd zzfd, zzct zzct) {
        super(zzct);
        this.zzatd = zzfd;
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    @WorkerThread
    public final void run() {
        zzfd zzfd = this.zzatd;
        zzfd.zzaf();
        zzfd.zzgt().zzjo().zzby("Current session is expired, remove the session number and Id");
        if (zzfd.zzgv().zzbg(zzfd.zzgk().zzal())) {
            zzfd.zzgj().zza("auto", "_sid", (Object) null, zzfd.zzbx().currentTimeMillis());
        }
        if (zzfd.zzgv().zzbh(zzfd.zzgk().zzal())) {
            zzfd.zzgj().zza("auto", "_sno", (Object) null, zzfd.zzbx().currentTimeMillis());
        }
    }
}
