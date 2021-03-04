package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

final class zzcf implements Callable<List<zzfx>> {
    private final /* synthetic */ String zzads;
    private final /* synthetic */ String zzadz;
    private final /* synthetic */ String zzagj;
    private final /* synthetic */ zzby zzaql;

    zzcf(zzby zzby, String str, String str2, String str3) {
        this.zzaql = zzby;
        this.zzagj = str;
        this.zzads = str2;
        this.zzadz = str3;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzfx> call() throws Exception {
        zzby.zza(this.zzaql).zzme();
        return zzby.zza(this.zzaql).zzjt().zzb(this.zzagj, this.zzads, this.zzadz);
    }
}
