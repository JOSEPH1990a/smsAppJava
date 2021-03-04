package com.google.android.gms.internal.ads;

final class zzaib extends zzbie {
    private final /* synthetic */ zzahv zzdih;

    private zzaib(zzahv zzahv) {
        this.zzdih = zzahv;
    }

    @Override // com.google.android.gms.internal.ads.zzbie
    public final void zza(zzbif zzbif) {
        if (zzahv.zza(this.zzdih) != null) {
            zzahv.zza(this.zzdih).zzub();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbie
    public final void zzb(zzbif zzbif) {
        this.zzdih.zzf(zzbif.uri);
    }

    @Override // com.google.android.gms.internal.ads.zzbie
    public final boolean zzc(zzbif zzbif) {
        return this.zzdih.zzf(zzbif.uri);
    }
}
