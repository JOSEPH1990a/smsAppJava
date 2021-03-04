package com.google.android.gms.measurement.internal;

final class zzcb implements Runnable {
    private final /* synthetic */ zzk zzaqk;
    private final /* synthetic */ zzby zzaql;
    private final /* synthetic */ zzo zzaqm;

    zzcb(zzby zzby, zzo zzo, zzk zzk) {
        this.zzaql = zzby;
        this.zzaqm = zzo;
        this.zzaqk = zzk;
    }

    public final void run() {
        zzby.zza(this.zzaql).zzme();
        zzby.zza(this.zzaql).zzb(this.zzaqm, this.zzaqk);
    }
}
