package com.google.android.gms.internal.ads;

/* access modifiers changed from: package-private */
public final class zztr implements Runnable {
    private final /* synthetic */ zztq zzbzt;

    zztr(zztq zztq) {
        this.zzbzt = zztq;
    }

    public final void run() {
        this.zzbzt.disconnect();
    }
}
