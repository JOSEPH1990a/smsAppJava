package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* access modifiers changed from: package-private */
@zzark
public final class zzbca<T> implements zzbcb<T> {
    private final T value;
    private final zzbcc zzepj = new zzbcc();

    zzbca(T t) {
        this.value = t;
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
    public final T get() {
        return this.value;
    }

    @Override // java.util.concurrent.Future
    public final T get(long j, TimeUnit timeUnit) {
        return this.value;
    }

    @Override // com.google.android.gms.internal.ads.zzbcb
    public final void zza(Runnable runnable, Executor executor) {
        this.zzepj.zza(runnable, executor);
    }
}
