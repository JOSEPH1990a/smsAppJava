package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* access modifiers changed from: package-private */
public final class zzel implements Runnable {
    private final /* synthetic */ zzk zzaqk;
    private final /* synthetic */ zzeb zzasi;

    zzel(zzeb zzeb, zzk zzk) {
        this.zzasi = zzeb;
        this.zzaqk = zzk;
    }

    public final void run() {
        zzaj zzaj = this.zzasi.zzasc;
        if (zzaj == null) {
            this.zzasi.zzgt().zzjg().zzby("Failed to send measurementEnabled to service");
            return;
        }
        try {
            zzaj.zzb(this.zzaqk);
            this.zzasi.zzcy();
        } catch (RemoteException e) {
            this.zzasi.zzgt().zzjg().zzg("Failed to send measurementEnabled to the service", e);
        }
    }
}
