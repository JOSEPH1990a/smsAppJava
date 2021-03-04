package com.google.android.gms.measurement.internal;

final class zzca implements Runnable {
    private final /* synthetic */ zzk zzaqk;
    private final /* synthetic */ zzby zzaql;
    private final /* synthetic */ zzo zzaqm;

    zzca(zzby zzby, zzo zzo, zzk zzk) {
        this.zzaql = zzby;
        this.zzaqm = zzo;
        this.zzaqk = zzk;
    }

    public final void run() {
        zzby.zza(this.zzaql).zzme();
        zzby.zza(this.zzaql).zzc(this.zzaqm, this.zzaqk);
    }
}
