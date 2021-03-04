package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

final class zzco implements Callable<List<zzfx>> {
    private final /* synthetic */ zzk zzaqk;
    private final /* synthetic */ zzby zzaql;

    zzco(zzby zzby, zzk zzk) {
        this.zzaql = zzby;
        this.zzaqk = zzk;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzfx> call() throws Exception {
        zzby.zza(this.zzaql).zzme();
        return zzby.zza(this.zzaql).zzjt().zzbl(this.zzaqk.packageName);
    }
}
