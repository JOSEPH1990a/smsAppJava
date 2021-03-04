package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzbq extends zzbut<zzbq> {
    public Long zzhh = null;
    private String zzhp = null;
    private byte[] zzhq = null;

    public zzbq() {
        this.zzfwt = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final void zza(zzbur zzbur) throws IOException {
        Long l = this.zzhh;
        if (l != null) {
            zzbur.zzr(1, l.longValue());
        }
        String str = this.zzhp;
        if (str != null) {
            zzbur.zzf(3, str);
        }
        byte[] bArr = this.zzhq;
        if (bArr != null) {
            zzbur.zza(4, bArr);
        }
        super.zza(zzbur);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final int zzt() {
        int zzt = super.zzt();
        Long l = this.zzhh;
        if (l != null) {
            zzt += zzbur.zzm(1, l.longValue());
        }
        String str = this.zzhp;
        if (str != null) {
            zzt += zzbur.zzg(3, str);
        }
        byte[] bArr = this.zzhq;
        return bArr != null ? zzt + zzbur.zzb(4, bArr) : zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final /* synthetic */ zzbuz zza(zzbuq zzbuq) throws IOException {
        while (true) {
            int zzaku = zzbuq.zzaku();
            if (zzaku == 0) {
                return this;
            }
            if (zzaku == 8) {
                this.zzhh = Long.valueOf(zzbuq.zzaln());
            } else if (zzaku == 26) {
                this.zzhp = zzbuq.readString();
            } else if (zzaku == 34) {
                this.zzhq = zzbuq.readBytes();
            } else if (!super.zza(zzbuq, zzaku)) {
                return this;
            }
        }
    }
}
