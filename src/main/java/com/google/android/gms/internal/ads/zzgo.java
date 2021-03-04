package com.google.android.gms.internal.ads;

/* access modifiers changed from: package-private */
public final class zzgo implements Runnable {
    private final /* synthetic */ zzgl zzabk;
    private final /* synthetic */ zzfs zzabo;

    zzgo(zzgl zzgl, zzfs zzfs) {
        this.zzabk = zzgl;
        this.zzabo = zzfs;
    }

    public final void run() {
        zzgl.zza(this.zzabk).zzc(this.zzabo);
    }
}
