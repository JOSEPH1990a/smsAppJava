package com.google.android.gms.internal.ads;

final class zzbdo implements Runnable {
    private final /* synthetic */ zzbdk zzeru;

    zzbdo(zzbdk zzbdk) {
        this.zzeru = zzbdk;
    }

    public final void run() {
        zzbdk.zza(this.zzeru, "surfaceDestroyed", new String[0]);
    }
}
