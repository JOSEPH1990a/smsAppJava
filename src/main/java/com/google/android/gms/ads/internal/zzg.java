package com.google.android.gms.ads.internal;

import java.util.concurrent.Callable;

/* access modifiers changed from: package-private */
public final class zzg implements Callable<String> {
    private final /* synthetic */ zzc zzbmd;

    zzg(zzc zzc) {
        this.zzbmd = zzc;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        return this.zzbmd.zzbls.zzbso.zzab().zza(this.zzbmd.zzbls.zzsp);
    }
}
