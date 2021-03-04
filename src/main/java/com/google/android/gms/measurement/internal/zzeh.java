package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* access modifiers changed from: package-private */
public final class zzeh implements Runnable {
    private final /* synthetic */ zzk zzaqk;
    private final /* synthetic */ zzeb zzasi;

    zzeh(zzeb zzeb, zzk zzk) {
        this.zzasi = zzeb;
        this.zzaqk = zzk;
    }

    public final void run() {
        zzaj zzaj = this.zzasi.zzasc;
        if (zzaj == null) {
            this.zzasi.zzgt().zzjg().zzby("Discarding data. Failed to send app launch");
            return;
        }
        try {
            zzaj.zza(this.zzaqk);
            this.zzasi.zza(zzaj, (AbstractSafeParcelable) null, this.zzaqk);
            this.zzasi.zzcy();
        } catch (RemoteException e) {
            this.zzasi.zzgt().zzjg().zzg("Failed to send app launch to the service", e);
        }
    }
}
