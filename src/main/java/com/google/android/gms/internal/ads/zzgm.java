package com.google.android.gms.internal.ads;

/* access modifiers changed from: package-private */
public final class zzgm implements Runnable {
    private final /* synthetic */ zzhn zzabj;
    private final /* synthetic */ zzgl zzabk;

    zzgm(zzgl zzgl, zzhn zzhn) {
        this.zzabk = zzgl;
        this.zzabj = zzhn;
    }

    public final void run() {
        zzgl.zza(this.zzabk).zza(this.zzabj);
    }
}
