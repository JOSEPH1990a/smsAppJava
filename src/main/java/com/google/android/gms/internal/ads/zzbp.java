package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzbp extends zzbut<zzbp> {
    public byte[] data = null;
    public byte[] zzhm = null;
    public byte[] zzhn = null;
    public byte[] zzho = null;

    public zzbp() {
        this.zzfwt = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final void zza(zzbur zzbur) throws IOException {
        byte[] bArr = this.data;
        if (bArr != null) {
            zzbur.zza(1, bArr);
        }
        byte[] bArr2 = this.zzhm;
        if (bArr2 != null) {
            zzbur.zza(2, bArr2);
        }
        byte[] bArr3 = this.zzhn;
        if (bArr3 != null) {
            zzbur.zza(3, bArr3);
        }
        byte[] bArr4 = this.zzho;
        if (bArr4 != null) {
            zzbur.zza(4, bArr4);
        }
        super.zza(zzbur);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final int zzt() {
        int zzt = super.zzt();
        byte[] bArr = this.data;
        if (bArr != null) {
            zzt += zzbur.zzb(1, bArr);
        }
        byte[] bArr2 = this.zzhm;
        if (bArr2 != null) {
            zzt += zzbur.zzb(2, bArr2);
        }
        byte[] bArr3 = this.zzhn;
        if (bArr3 != null) {
            zzt += zzbur.zzb(3, bArr3);
        }
        byte[] bArr4 = this.zzho;
        return bArr4 != null ? zzt + zzbur.zzb(4, bArr4) : zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final /* synthetic */ zzbuz zza(zzbuq zzbuq) throws IOException {
        while (true) {
            int zzaku = zzbuq.zzaku();
            if (zzaku == 0) {
                return this;
            }
            if (zzaku == 10) {
                this.data = zzbuq.readBytes();
            } else if (zzaku == 18) {
                this.zzhm = zzbuq.readBytes();
            } else if (zzaku == 26) {
                this.zzhn = zzbuq.readBytes();
            } else if (zzaku == 34) {
                this.zzho = zzbuq.readBytes();
            } else if (!super.zza(zzbuq, zzaku)) {
                return this;
            }
        }
    }
}
