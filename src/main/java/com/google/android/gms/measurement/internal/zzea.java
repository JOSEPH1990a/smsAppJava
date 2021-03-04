package com.google.android.gms.measurement.internal;

/* access modifiers changed from: package-private */
public final class zzea implements Runnable {
    private final /* synthetic */ zzdy zzarz;
    private final /* synthetic */ zzdx zzasa;

    zzea(zzdy zzdy, zzdx zzdx) {
        this.zzarz = zzdy;
        this.zzasa = zzdx;
    }

    public final void run() {
        this.zzarz.zza((zzdy) this.zzasa, (zzdx) false);
        zzdy zzdy = this.zzarz;
        zzdy.zzarq = null;
        zzdy.zzgl().zza((zzdx) null);
    }
}
