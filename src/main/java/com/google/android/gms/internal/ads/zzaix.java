package com.google.android.gms.internal.ads;

/* access modifiers changed from: package-private */
public final /* synthetic */ class zzaix implements zzaij {
    private final zzait zzdja;
    private final zzajm zzdje;
    private final zzaii zzdjf;

    zzaix(zzait zzait, zzajm zzajm, zzaii zzaii) {
        this.zzdja = zzait;
        this.zzdje = zzajm;
        this.zzdjf = zzaii;
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zzub() {
        zzayh.zzelc.postDelayed(new zzaiy(this.zzdja, this.zzdje, this.zzdjf), (long) zzajg.zzdjo);
    }
}
