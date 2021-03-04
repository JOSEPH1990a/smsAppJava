package com.google.android.gms.measurement.internal;

final class zzcm implements Runnable {
    private final /* synthetic */ zzk zzaqk;
    private final /* synthetic */ zzby zzaql;
    private final /* synthetic */ zzfv zzaqn;

    zzcm(zzby zzby, zzfv zzfv, zzk zzk) {
        this.zzaql = zzby;
        this.zzaqn = zzfv;
        this.zzaqk = zzk;
    }

    public final void run() {
        zzby.zza(this.zzaql).zzme();
        zzby.zza(this.zzaql).zzc(this.zzaqn, this.zzaqk);
    }
}
