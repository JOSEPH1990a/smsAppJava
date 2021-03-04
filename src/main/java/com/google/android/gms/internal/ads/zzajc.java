package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* access modifiers changed from: package-private */
public final class zzajc implements Runnable {
    private final /* synthetic */ zzajm zzdjh;
    private final /* synthetic */ zzaii zzdji;
    private final /* synthetic */ zzait zzdjj;

    zzajc(zzait zzait, zzajm zzajm, zzaii zzaii) {
        this.zzdjj = zzait;
        this.zzdjh = zzajm;
        this.zzdji = zzaii;
    }

    public final void run() {
        synchronized (zzait.zza(this.zzdjj)) {
            if (this.zzdjh.getStatus() != -1) {
                if (this.zzdjh.getStatus() != 1) {
                    this.zzdjh.reject();
                    Executor executor = zzbcg.zzepo;
                    zzaii zzaii = this.zzdji;
                    zzaii.getClass();
                    executor.execute(zzajd.zzb(zzaii));
                    zzaxz.v("Could not receive loaded message in a timely manner. Rejecting.");
                }
            }
        }
    }
}
