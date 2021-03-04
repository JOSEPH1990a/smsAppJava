package com.google.android.gms.internal.ads;

final class zzle implements Runnable {
    private final /* synthetic */ zzlc zzaxn;

    zzle(zzlc zzlc) {
        this.zzaxn = zzlc;
    }

    public final void run() {
        if (!zzlc.zzb(this.zzaxn)) {
            zzlc.zzc(this.zzaxn).zza((zzlw) this.zzaxn);
        }
    }
}
