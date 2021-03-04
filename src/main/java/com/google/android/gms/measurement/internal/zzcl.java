package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

final class zzcl implements Callable<byte[]> {
    private final /* synthetic */ zzag zzagi;
    private final /* synthetic */ String zzagj;
    private final /* synthetic */ zzby zzaql;

    zzcl(zzby zzby, zzag zzag, String str) {
        this.zzaql = zzby;
        this.zzagi = zzag;
        this.zzagj = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ byte[] call() throws Exception {
        zzby.zza(this.zzaql).zzme();
        return zzby.zza(this.zzaql).zzlw().zzb(this.zzagi, this.zzagj);
    }
}
