package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* access modifiers changed from: package-private */
public final class zzef implements Runnable {
    private final /* synthetic */ zzk zzaqk;
    private final /* synthetic */ zzeb zzasi;
    private final /* synthetic */ AtomicReference zzasj;

    zzef(zzeb zzeb, AtomicReference atomicReference, zzk zzk) {
        this.zzasi = zzeb;
        this.zzasj = atomicReference;
        this.zzaqk = zzk;
    }

    public final void run() {
        synchronized (this.zzasj) {
            try {
                zzaj zzaj = this.zzasi.zzasc;
                if (zzaj == null) {
                    this.zzasi.zzgt().zzjg().zzby("Failed to get app instance id");
                    return;
                }
                this.zzasj.set(zzaj.zzc(this.zzaqk));
                String str = (String) this.zzasj.get();
                if (str != null) {
                    this.zzasi.zzgj().zzcp(str);
                    this.zzasi.zzgu().zzanh.zzcd(str);
                }
                this.zzasi.zzcy();
                this.zzasj.notify();
            } catch (RemoteException e) {
                this.zzasi.zzgt().zzjg().zzg("Failed to get app instance id", e);
            } finally {
                this.zzasj.notify();
            }
        }
    }
}
