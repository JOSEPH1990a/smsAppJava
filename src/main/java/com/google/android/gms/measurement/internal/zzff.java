package com.google.android.gms.measurement.internal;

import android.support.annotation.WorkerThread;

/* access modifiers changed from: package-private */
public final class zzff extends zzy {
    private final /* synthetic */ zzfd zzatd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzff(zzfd zzfd, zzct zzct) {
        super(zzct);
        this.zzatd = zzfd;
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    @WorkerThread
    public final void run() {
        this.zzatd.zzlq();
    }
}
