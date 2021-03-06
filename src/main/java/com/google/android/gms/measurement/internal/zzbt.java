package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;

/* access modifiers changed from: package-private */
public final class zzbt implements Thread.UncaughtExceptionHandler {
    private final String zzapa;
    private final /* synthetic */ zzbr zzapb;

    public zzbt(zzbr zzbr, String str) {
        this.zzapb = zzbr;
        Preconditions.checkNotNull(str);
        this.zzapa = str;
    }

    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.zzapb.zzgt().zzjg().zzg(this.zzapa, th);
    }
}
