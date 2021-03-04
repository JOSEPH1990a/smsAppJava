package com.google.android.gms.measurement.internal;

/* access modifiers changed from: package-private */
public final class zzfp implements Runnable {
    private final /* synthetic */ zzft zzaud;
    private final /* synthetic */ zzfo zzaue;

    zzfp(zzfo zzfo, zzft zzft) {
        this.zzaue = zzfo;
        this.zzaud = zzft;
    }

    public final void run() {
        this.zzaue.zza((zzfo) this.zzaud);
        this.zzaue.start();
    }
}
