package com.google.android.gms.measurement.internal;

final class zzcq implements Runnable {
    private final /* synthetic */ String zzaeb;
    private final /* synthetic */ String zzagj;
    private final /* synthetic */ zzby zzaql;
    private final /* synthetic */ String zzaqo;
    private final /* synthetic */ long zzaqp;

    zzcq(zzby zzby, String str, String str2, String str3, long j) {
        this.zzaql = zzby;
        this.zzaqo = str;
        this.zzagj = str2;
        this.zzaeb = str3;
        this.zzaqp = j;
    }

    public final void run() {
        String str = this.zzaqo;
        if (str == null) {
            zzby.zza(this.zzaql).zzmh().zzgm().zza(this.zzagj, (zzdx) null);
            return;
        }
        zzby.zza(this.zzaql).zzmh().zzgm().zza(this.zzagj, new zzdx(this.zzaeb, str, this.zzaqp));
    }
}
