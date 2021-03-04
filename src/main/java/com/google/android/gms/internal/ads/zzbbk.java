package com.google.android.gms.internal.ads;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RunnableFuture;
import javax.annotation.Nullable;

@zzark
public abstract class zzbbk extends AbstractExecutorService implements zzbcf {
    /* access modifiers changed from: protected */
    @Override // java.util.concurrent.AbstractExecutorService
    public final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new zzbce(runnable, t);
    }

    /* access modifiers changed from: protected */
    @Override // java.util.concurrent.AbstractExecutorService
    public final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new zzbce(callable);
    }

    @Override // com.google.android.gms.internal.ads.zzbcf
    /* renamed from: zze */
    public final zzbcb<?> submit(Runnable runnable) throws RejectedExecutionException {
        return (zzbcb) super.submit(runnable);
    }

    @Override // com.google.android.gms.internal.ads.zzbcf
    /* renamed from: zza */
    public final <T> zzbcb<T> submit(Callable<T> callable) throws RejectedExecutionException {
        return (zzbcb) super.submit(callable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public /* synthetic */ Future submit(Runnable runnable, @Nullable Object obj) {
        return (zzbcb) super.submit(runnable, obj);
    }
}
