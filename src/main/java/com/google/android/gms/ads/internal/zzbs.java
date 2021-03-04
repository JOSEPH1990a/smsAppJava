package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzct;
import com.google.android.gms.internal.ads.zzcu;
import java.util.concurrent.Callable;

/* access modifiers changed from: package-private */
public final class zzbs implements Callable<zzcu> {
    private final /* synthetic */ zzbp zzbra;

    zzbs(zzbp zzbp) {
        this.zzbra = zzbp;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzcu call() throws Exception {
        return new zzcu(zzct.zza(this.zzbra.zzbob.zzdp, this.zzbra.mContext, false));
    }
}
