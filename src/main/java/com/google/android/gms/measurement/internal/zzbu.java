package com.google.android.gms.measurement.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* access modifiers changed from: package-private */
public final class zzbu<V> extends FutureTask<V> implements Comparable<zzbu> {
    private final String zzapa;
    private final /* synthetic */ zzbr zzapb;
    private final long zzapc = zzbr.zzaoz.getAndIncrement();
    final boolean zzapd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbu(zzbr zzbr, Callable<V> callable, boolean z, String str) {
        super(callable);
        this.zzapb = zzbr;
        Preconditions.checkNotNull(str);
        this.zzapa = str;
        this.zzapd = z;
        if (this.zzapc == Long.MAX_VALUE) {
            zzbr.zzgt().zzjg().zzby("Tasks index overflow");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbu(zzbr zzbr, Runnable runnable, boolean z, String str) {
        super(runnable, null);
        this.zzapb = zzbr;
        Preconditions.checkNotNull(str);
        this.zzapa = str;
        this.zzapd = false;
        if (this.zzapc == Long.MAX_VALUE) {
            zzbr.zzgt().zzjg().zzby("Tasks index overflow");
        }
    }

    /* access modifiers changed from: protected */
    public final void setException(Throwable th) {
        this.zzapb.zzgt().zzjg().zzg(this.zzapa, th);
        if (th instanceof zzbs) {
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(@NonNull zzbu zzbu) {
        zzbu zzbu2 = zzbu;
        boolean z = this.zzapd;
        if (z != zzbu2.zzapd) {
            return z ? -1 : 1;
        }
        long j = this.zzapc;
        long j2 = zzbu2.zzapc;
        if (j < j2) {
            return -1;
        }
        if (j > j2) {
            return 1;
        }
        this.zzapb.zzgt().zzjh().zzg("Two tasks share the same index. index", Long.valueOf(this.zzapc));
        return 0;
    }
}
