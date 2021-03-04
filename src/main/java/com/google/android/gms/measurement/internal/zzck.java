package com.google.android.gms.measurement.internal;

final class zzck implements Runnable {
    private final /* synthetic */ zzag zzagi;
    private final /* synthetic */ String zzagj;
    private final /* synthetic */ zzby zzaql;

    zzck(zzby zzby, zzag zzag, String str) {
        this.zzaql = zzby;
        this.zzagi = zzag;
        this.zzagj = str;
    }

    public final void run() {
        zzby.zza(this.zzaql).zzme();
        zzby.zza(this.zzaql).zzd(this.zzagi, this.zzagj);
    }
}
