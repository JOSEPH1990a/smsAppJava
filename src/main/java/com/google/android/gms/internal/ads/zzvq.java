package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzvq extends zzbut<zzvq> {
    public Integer zzchy = null;
    public Integer zzchz = null;
    public Integer zzcia = null;

    public zzvq() {
        this.zzfwk = null;
        this.zzfwt = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final void zza(zzbur zzbur) throws IOException {
        Integer num = this.zzchy;
        if (num != null) {
            zzbur.zzv(1, num.intValue());
        }
        Integer num2 = this.zzchz;
        if (num2 != null) {
            zzbur.zzv(2, num2.intValue());
        }
        Integer num3 = this.zzcia;
        if (num3 != null) {
            zzbur.zzv(3, num3.intValue());
        }
        super.zza(zzbur);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final int zzt() {
        int zzt = super.zzt();
        Integer num = this.zzchy;
        if (num != null) {
            zzt += zzbur.zzz(1, num.intValue());
        }
        Integer num2 = this.zzchz;
        if (num2 != null) {
            zzt += zzbur.zzz(2, num2.intValue());
        }
        Integer num3 = this.zzcia;
        return num3 != null ? zzt + zzbur.zzz(3, num3.intValue()) : zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final /* synthetic */ zzbuz zza(zzbuq zzbuq) throws IOException {
        while (true) {
            int zzaku = zzbuq.zzaku();
            if (zzaku == 0) {
                return this;
            }
            if (zzaku == 8) {
                this.zzchy = Integer.valueOf(zzbuq.zzalm());
            } else if (zzaku == 16) {
                this.zzchz = Integer.valueOf(zzbuq.zzalm());
            } else if (zzaku == 24) {
                this.zzcia = Integer.valueOf(zzbuq.zzalm());
            } else if (!super.zza(zzbuq, zzaku)) {
                return this;
            }
        }
    }
}
