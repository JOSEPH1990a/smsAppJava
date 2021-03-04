package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* access modifiers changed from: package-private */
public final class zzbcj extends zzbbk {
    private final Executor zzept;

    private zzbcj(Executor executor) {
        this.zzept = executor;
    }

    public final boolean isShutdown() {
        return false;
    }

    public final boolean isTerminated() {
        return false;
    }

    public final void execute(Runnable runnable) {
        this.zzept.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ExecutorService
    public final List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException();
    }

    public final void shutdown() {
        throw new UnsupportedOperationException();
    }

    /* synthetic */ zzbcj(Executor executor, zzbch zzbch) {
        this(executor);
    }
}
