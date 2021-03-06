package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzbr extends zzbut<zzbr> {
    public String zzdv = null;

    public zzbr() {
        this.zzfwt = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final void zza(zzbur zzbur) throws IOException {
        String str = this.zzdv;
        if (str != null) {
            zzbur.zzf(1, str);
        }
        super.zza(zzbur);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final int zzt() {
        int zzt = super.zzt();
        String str = this.zzdv;
        return str != null ? zzt + zzbur.zzg(1, str) : zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final /* synthetic */ zzbuz zza(zzbuq zzbuq) throws IOException {
        while (true) {
            int zzaku = zzbuq.zzaku();
            if (zzaku == 0) {
                return this;
            }
            if (zzaku == 10) {
                this.zzdv = zzbuq.readString();
            } else if (!super.zza(zzbuq, zzaku)) {
                return this;
            }
        }
    }
}
