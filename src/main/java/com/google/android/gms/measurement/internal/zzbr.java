package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.lang.Thread;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class zzbr extends zzcs {
    private static final AtomicLong zzaoz = new AtomicLong(Long.MIN_VALUE);
    private ExecutorService zzadl;
    private zzbv zzaoq;
    private zzbv zzaor;
    private final PriorityBlockingQueue<zzbu<?>> zzaos = new PriorityBlockingQueue<>();
    private final BlockingQueue<zzbu<?>> zzaot = new LinkedBlockingQueue();
    private final Thread.UncaughtExceptionHandler zzaou = new zzbt(this, "Thread death: Uncaught exception on worker thread");
    private final Thread.UncaughtExceptionHandler zzaov = new zzbt(this, "Thread death: Uncaught exception on network thread");
    private final Object zzaow = new Object();
    private final Semaphore zzaox = new Semaphore(2);
    private volatile boolean zzaoy;

    zzbr(zzbw zzbw) {
        super(zzbw);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.measurement.internal.zzcs
    public final boolean zzgy() {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final void zzaf() {
        if (Thread.currentThread() != this.zzaoq) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final void zzgh() {
        if (Thread.currentThread() != this.zzaor) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public final boolean zzkf() {
        return Thread.currentThread() == this.zzaoq;
    }

    public final <V> Future<V> zzb(Callable<V> callable) throws IllegalStateException {
        zzcl();
        Preconditions.checkNotNull(callable);
        zzbu<?> zzbu = new zzbu<>(this, (Callable<?>) callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzaoq) {
            if (!this.zzaos.isEmpty()) {
                zzgt().zzjj().zzby("Callable skipped the worker queue.");
            }
            zzbu.run();
        } else {
            zza(zzbu);
        }
        return zzbu;
    }

    public final <V> Future<V> zzc(Callable<V> callable) throws IllegalStateException {
        zzcl();
        Preconditions.checkNotNull(callable);
        zzbu<?> zzbu = new zzbu<>(this, (Callable<?>) callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzaoq) {
            zzbu.run();
        } else {
            zza(zzbu);
        }
        return zzbu;
    }

    public final void zzc(Runnable runnable) throws IllegalStateException {
        zzcl();
        Preconditions.checkNotNull(runnable);
        zza(new zzbu<>(this, runnable, false, "Task exception on worker thread"));
    }

    /* access modifiers changed from: package-private */
    public final <T> T zza(AtomicReference<T> atomicReference, long j, String str, Runnable runnable) {
        synchronized (atomicReference) {
            zzgs().zzc(runnable);
            try {
                atomicReference.wait(15000);
            } catch (InterruptedException unused) {
                zzau zzjj = zzgt().zzjj();
                String valueOf = String.valueOf(str);
                zzjj.zzby(valueOf.length() != 0 ? "Interrupted waiting for ".concat(valueOf) : new String("Interrupted waiting for "));
                return null;
            }
        }
        T t = atomicReference.get();
        if (t == null) {
            zzau zzjj2 = zzgt().zzjj();
            String valueOf2 = String.valueOf(str);
            zzjj2.zzby(valueOf2.length() != 0 ? "Timed out waiting for ".concat(valueOf2) : new String("Timed out waiting for "));
        }
        return t;
    }

    private final void zza(zzbu<?> zzbu) {
        synchronized (this.zzaow) {
            this.zzaos.add(zzbu);
            if (this.zzaoq == null) {
                this.zzaoq = new zzbv(this, "Measurement Worker", this.zzaos);
                this.zzaoq.setUncaughtExceptionHandler(this.zzaou);
                this.zzaoq.start();
            } else {
                this.zzaoq.zzki();
            }
        }
    }

    public final void zzd(Runnable runnable) throws IllegalStateException {
        zzcl();
        Preconditions.checkNotNull(runnable);
        zzbu<?> zzbu = new zzbu<>(this, runnable, false, "Task exception on network thread");
        synchronized (this.zzaow) {
            this.zzaot.add(zzbu);
            if (this.zzaor == null) {
                this.zzaor = new zzbv(this, "Measurement Network", this.zzaot);
                this.zzaor.setUncaughtExceptionHandler(this.zzaov);
                this.zzaor.start();
            } else {
                this.zzaor.zzki();
            }
        }
    }

    public final ExecutorService zzkg() {
        ExecutorService executorService;
        synchronized (this.zzaow) {
            if (this.zzadl == null) {
                this.zzadl = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new ArrayBlockingQueue(100));
            }
            executorService = this.zzadl;
        }
        return executorService;
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzgf() {
        super.zzgf();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzgg() {
        super.zzgg();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzaa zzgp() {
        return super.zzgp();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ Clock zzbx() {
        return super.zzbx();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzaq zzgq() {
        return super.zzgq();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzfy zzgr() {
        return super.zzgr();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ zzbr zzgs() {
        return super.zzgs();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ zzas zzgt() {
        return super.zzgt();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzbd zzgu() {
        return super.zzgu();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzq zzgv() {
        return super.zzgv();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ zzn zzgw() {
        return super.zzgw();
    }
}
