package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;

/* access modifiers changed from: package-private */
public final class zzen implements Runnable {
    private final /* synthetic */ zzk zzaqk;
    private final /* synthetic */ zzeb zzasi;
    private final /* synthetic */ boolean zzask;
    private final /* synthetic */ boolean zzasl;
    private final /* synthetic */ zzo zzasm;
    private final /* synthetic */ zzo zzasn;

    zzen(zzeb zzeb, boolean z, boolean z2, zzo zzo, zzk zzk, zzo zzo2) {
        this.zzasi = zzeb;
        this.zzask = z;
        this.zzasl = z2;
        this.zzasm = zzo;
        this.zzaqk = zzk;
        this.zzasn = zzo2;
    }

    public final void run() {
        zzaj zzaj = this.zzasi.zzasc;
        if (zzaj == null) {
            this.zzasi.zzgt().zzjg().zzby("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.zzask) {
            this.zzasi.zza(zzaj, this.zzasl ? null : this.zzasm, this.zzaqk);
        } else {
            try {
                if (TextUtils.isEmpty(this.zzasn.packageName)) {
                    zzaj.zza(this.zzasm, this.zzaqk);
                } else {
                    zzaj.zzb(this.zzasm);
                }
            } catch (RemoteException e) {
                this.zzasi.zzgt().zzjg().zzg("Failed to send conditional user property to the service", e);
            }
        }
        this.zzasi.zzcy();
    }
}
