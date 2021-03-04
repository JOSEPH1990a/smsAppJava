package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* access modifiers changed from: package-private */
public final class zzed implements Runnable {
    private final /* synthetic */ boolean zzaeg;
    private final /* synthetic */ zzk zzaqk;
    private final /* synthetic */ zzeb zzasi;
    private final /* synthetic */ AtomicReference zzasj;

    zzed(zzeb zzeb, AtomicReference atomicReference, zzk zzk, boolean z) {
        this.zzasi = zzeb;
        this.zzasj = atomicReference;
        this.zzaqk = zzk;
        this.zzaeg = z;
    }

    public final void run() {
        synchronized (this.zzasj) {
            try {
                zzaj zzaj = this.zzasi.zzasc;
                if (zzaj == null) {
                    this.zzasi.zzgt().zzjg().zzby("Failed to get user properties");
                    return;
                }
                this.zzasj.set(zzaj.zza(this.zzaqk, this.zzaeg));
                this.zzasi.zzcy();
                this.zzasj.notify();
            } catch (RemoteException e) {
                this.zzasi.zzgt().zzjg().zzg("Failed to get user properties", e);
            } finally {
                this.zzasj.notify();
            }
        }
    }
}
