package com.google.android.gms.measurement.internal;

final class zzcp implements Runnable {
    private final /* synthetic */ zzk zzaqk;
    private final /* synthetic */ zzby zzaql;

    zzcp(zzby zzby, zzk zzk) {
        this.zzaql = zzby;
        this.zzaqk = zzk;
    }

    public final void run() {
        zzby.zza(this.zzaql).zzme();
        zzby.zza(this.zzaql).zzf(this.zzaqk);
    }
}
