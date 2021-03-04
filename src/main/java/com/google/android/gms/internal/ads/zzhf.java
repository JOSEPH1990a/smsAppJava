package com.google.android.gms.internal.ads;

/* access modifiers changed from: package-private */
public final class zzhf implements zzgy {
    private final /* synthetic */ zzhd zzafb;

    private zzhf(zzhd zzhd) {
        this.zzafb = zzhd;
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    public final void zzl(int i) {
        this.zzafb.zzaeu.zzm(i);
        zzhd.zzl(i);
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    public final void zzbs() {
        zzhd.zzdi();
        this.zzafb.zzafa = true;
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    public final void zzc(int i, long j, long j2) {
        this.zzafb.zzaeu.zzb(i, j, j2);
        zzhd.zza(i, j, j2);
    }
}
