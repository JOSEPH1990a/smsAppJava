package com.google.android.gms.internal.ads;

final class zzapg implements Runnable {
    private final /* synthetic */ zzapf zzdsp;

    zzapg(zzapf zzapf) {
        this.zzdsp = zzapf;
    }

    public final void run() {
        if (zzapf.zza(this.zzdsp).get()) {
            zzaxz.e("Timed out waiting for WebView to finish loading.");
            this.zzdsp.cancel();
        }
    }
}
