package com.google.android.gms.measurement.internal;

/* access modifiers changed from: package-private */
public final class zzer implements Runnable {
    private final /* synthetic */ zzk zzaqk;
    private final /* synthetic */ zzfv zzaqn;
    private final /* synthetic */ zzeb zzasi;
    private final /* synthetic */ boolean zzasl;

    zzer(zzeb zzeb, boolean z, zzfv zzfv, zzk zzk) {
        this.zzasi = zzeb;
        this.zzasl = z;
        this.zzaqn = zzfv;
        this.zzaqk = zzk;
    }

    public final void run() {
        zzaj zzaj = this.zzasi.zzasc;
        if (zzaj == null) {
            this.zzasi.zzgt().zzjg().zzby("Discarding data. Failed to set user attribute");
            return;
        }
        this.zzasi.zza(zzaj, this.zzasl ? null : this.zzaqn, this.zzaqk);
        this.zzasi.zzcy();
    }
}
