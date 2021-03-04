package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* access modifiers changed from: package-private */
@zzark
public final class zzbbz<T> implements zzbcb<T> {
    private final Throwable cause;
    private final zzbcc zzepj = new zzbcc();

    zzbbz(Throwable th) {
        this.cause = th;
        this.zzepj.zzaaw();
    }

    public final boolean cancel(boolean z) {
        return false;
    }

    public final boolean isCancelled() {
        return false;
    }

    public final boolean isDone() {
        return true;
    }

    @Override // java.util.concurrent.Future
    public final T get() throws ExecutionException {
        throw new ExecutionException(this.cause);
    }

    @Override // java.util.concurrent.Future
    public final T get(long j, TimeUnit timeUnit) throws ExecutionException {
        throw new ExecutionException(this.cause);
    }

    @Override // com.google.android.gms.internal.ads.zzbcb
    public final void zza(Runnable runnable, Executor executor) {
        this.zzepj.zza(runnable, executor);
    }
}
