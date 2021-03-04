package com.google.android.gms.internal.ads;

/* access modifiers changed from: package-private */
public final class zzlf implements Runnable {
    private final /* synthetic */ zzlc zzaxn;
    private final /* synthetic */ zzli zzaxo;

    zzlf(zzlc zzlc, zzli zzli) {
        this.zzaxn = zzlc;
        this.zzaxo = zzli;
    }

    public final void run() {
        this.zzaxo.release();
        int size = zzlc.zzd(this.zzaxn).size();
        for (int i = 0; i < size; i++) {
            ((zzls) zzlc.zzd(this.zzaxn).valueAt(i)).disable();
        }
    }
}
