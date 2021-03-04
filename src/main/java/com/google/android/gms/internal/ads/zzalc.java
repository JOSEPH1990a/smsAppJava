package com.google.android.gms.internal.ads;

final class zzalc implements Runnable {
    private final /* synthetic */ zzala zzdnp;
    private final /* synthetic */ zzbcb zzdnq;

    zzalc(zzala zzala, zzbcb zzbcb) {
        this.zzdnp = zzala;
        this.zzdnq = zzbcb;
    }

    public final void run() {
        for (zzbcb zzbcb : zzala.zze(this.zzdnp).keySet()) {
            if (zzbcb != this.zzdnq) {
                ((zzaku) zzala.zze(this.zzdnp).get(zzbcb)).cancel();
            }
        }
    }
}
