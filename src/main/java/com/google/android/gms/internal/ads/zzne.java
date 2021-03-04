package com.google.android.gms.internal.ads;

public final class zzne implements zznd {
    private final zzhw zzbce;

    public zzne(zzhw zzhw) {
        this.zzbce = zzhw;
    }

    @Override // com.google.android.gms.internal.ads.zznd
    public final int zzgd() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zznd
    public final boolean zzge() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zznd
    public final int zzai(long j) {
        return this.zzbce.length;
    }

    @Override // com.google.android.gms.internal.ads.zznd
    public final long zzaw(int i) {
        return this.zzbce.zzagw[i];
    }

    @Override // com.google.android.gms.internal.ads.zznd
    public final long zze(int i, long j) {
        return this.zzbce.zzagv[i];
    }

    @Override // com.google.android.gms.internal.ads.zznd
    public final zzno zzax(int i) {
        return new zzno(null, this.zzbce.zzagu[i], (long) this.zzbce.zzagt[i]);
    }

    @Override // com.google.android.gms.internal.ads.zznd
    public final int zzf(long j, long j2) {
        return this.zzbce.zzq(j);
    }
}
