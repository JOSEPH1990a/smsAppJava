package com.google.android.gms.measurement.internal;

final class zzcd implements Runnable {
    private final /* synthetic */ zzby zzaql;
    private final /* synthetic */ zzo zzaqm;

    zzcd(zzby zzby, zzo zzo) {
        this.zzaql = zzby;
        this.zzaqm = zzo;
    }

    public final void run() {
        zzby.zza(this.zzaql).zzme();
        zzby.zza(this.zzaql).zze(this.zzaqm);
    }
}
