package com.google.android.gms.measurement.internal;

final class zzbz implements Runnable {
    private final /* synthetic */ zzk zzaqk;
    private final /* synthetic */ zzby zzaql;

    zzbz(zzby zzby, zzk zzk) {
        this.zzaql = zzby;
        this.zzaqk = zzk;
    }

    public final void run() {
        zzby.zza(this.zzaql).zzme();
        zzby.zza(this.zzaql).zze(this.zzaqk);
    }
}
