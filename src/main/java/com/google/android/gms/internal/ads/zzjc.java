package com.google.android.gms.internal.ads;

/* access modifiers changed from: package-private */
public final class zzjc implements zzja {
    private final zzpx zzaos;
    private final int zzapj = this.zzaos.zzhg();
    private final int zzapk = this.zzaos.zzhg();

    public zzjc(zzix zzix) {
        this.zzaos = zzix.zzaos;
        this.zzaos.setPosition(12);
    }

    @Override // com.google.android.gms.internal.ads.zzja
    public final int zzef() {
        return this.zzapk;
    }

    @Override // com.google.android.gms.internal.ads.zzja
    public final int zzeg() {
        int i = this.zzapj;
        return i == 0 ? this.zzaos.zzhg() : i;
    }

    @Override // com.google.android.gms.internal.ads.zzja
    public final boolean zzeh() {
        return this.zzapj != 0;
    }
}
