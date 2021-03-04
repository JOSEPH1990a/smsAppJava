package com.google.android.gms.internal.ads;

/* access modifiers changed from: package-private */
public final class zzjd implements zzja {
    private final zzpx zzaos;
    private final int zzapk = this.zzaos.zzhg();
    private final int zzapl = (this.zzaos.zzhg() & 255);
    private int zzapm;
    private int zzapn;

    public zzjd(zzix zzix) {
        this.zzaos = zzix.zzaos;
        this.zzaos.setPosition(12);
    }

    @Override // com.google.android.gms.internal.ads.zzja
    public final boolean zzeh() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzja
    public final int zzef() {
        return this.zzapk;
    }

    @Override // com.google.android.gms.internal.ads.zzja
    public final int zzeg() {
        int i = this.zzapl;
        if (i == 8) {
            return this.zzaos.readUnsignedByte();
        }
        if (i == 16) {
            return this.zzaos.readUnsignedShort();
        }
        int i2 = this.zzapm;
        this.zzapm = i2 + 1;
        if (i2 % 2 != 0) {
            return this.zzapn & 15;
        }
        this.zzapn = this.zzaos.readUnsignedByte();
        return (this.zzapn & 240) >> 4;
    }
}
