package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

final class zzce implements Callable<List<zzfx>> {
    private final /* synthetic */ String zzads;
    private final /* synthetic */ String zzadz;
    private final /* synthetic */ zzk zzaqk;
    private final /* synthetic */ zzby zzaql;

    zzce(zzby zzby, zzk zzk, String str, String str2) {
        this.zzaql = zzby;
        this.zzaqk = zzk;
        this.zzads = str;
        this.zzadz = str2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzfx> call() throws Exception {
        zzby.zza(this.zzaql).zzme();
        return zzby.zza(this.zzaql).zzjt().zzb(this.zzaqk.packageName, this.zzads, this.zzadz);
    }
}
