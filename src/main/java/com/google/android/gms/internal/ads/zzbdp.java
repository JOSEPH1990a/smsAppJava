package com.google.android.gms.internal.ads;

final class zzbdp implements Runnable {
    private final /* synthetic */ zzbdk zzeru;
    private final /* synthetic */ boolean zzerv;

    zzbdp(zzbdk zzbdk, boolean z) {
        this.zzeru = zzbdk;
        this.zzerv = z;
    }

    public final void run() {
        zzbdk.zza(this.zzeru, "windowVisibilityChanged", new String[]{"isVisible", String.valueOf(this.zzerv)});
    }
}
