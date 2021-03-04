package com.google.android.gms.measurement.internal;

final class zzbc implements Runnable {
    private final /* synthetic */ boolean zzamw;
    private final /* synthetic */ zzbb zzamx;

    zzbc(zzbb zzbb, boolean z) {
        this.zzamx = zzbb;
        this.zzamw = z;
    }

    public final void run() {
        zzbb.zza(this.zzamx).zzm(this.zzamw);
    }
}
