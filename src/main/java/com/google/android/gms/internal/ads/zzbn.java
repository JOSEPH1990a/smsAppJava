package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzbn extends zzbut<zzbn> {
    private Long zzfk = null;
    private Long zzfl = null;
    public Long zzhe = null;
    public Long zzhf = null;
    public Long zzhg = null;

    public zzbn() {
        this.zzfwt = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final void zza(zzbur zzbur) throws IOException {
        Long l = this.zzfk;
        if (l != null) {
            zzbur.zzr(1, l.longValue());
        }
        Long l2 = this.zzfl;
        if (l2 != null) {
            zzbur.zzr(2, l2.longValue());
        }
        Long l3 = this.zzhe;
        if (l3 != null) {
            zzbur.zzr(3, l3.longValue());
        }
        Long l4 = this.zzhf;
        if (l4 != null) {
            zzbur.zzr(4, l4.longValue());
        }
        Long l5 = this.zzhg;
        if (l5 != null) {
            zzbur.zzr(5, l5.longValue());
        }
        super.zza(zzbur);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final int zzt() {
        int zzt = super.zzt();
        Long l = this.zzfk;
        if (l != null) {
            zzt += zzbur.zzm(1, l.longValue());
        }
        Long l2 = this.zzfl;
        if (l2 != null) {
            zzt += zzbur.zzm(2, l2.longValue());
        }
        Long l3 = this.zzhe;
        if (l3 != null) {
            zzt += zzbur.zzm(3, l3.longValue());
        }
        Long l4 = this.zzhf;
        if (l4 != null) {
            zzt += zzbur.zzm(4, l4.longValue());
        }
        Long l5 = this.zzhg;
        return l5 != null ? zzt + zzbur.zzm(5, l5.longValue()) : zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final /* synthetic */ zzbuz zza(zzbuq zzbuq) throws IOException {
        while (true) {
            int zzaku = zzbuq.zzaku();
            if (zzaku == 0) {
                return this;
            }
            if (zzaku == 8) {
                this.zzfk = Long.valueOf(zzbuq.zzaln());
            } else if (zzaku == 16) {
                this.zzfl = Long.valueOf(zzbuq.zzaln());
            } else if (zzaku == 24) {
                this.zzhe = Long.valueOf(zzbuq.zzaln());
            } else if (zzaku == 32) {
                this.zzhf = Long.valueOf(zzbuq.zzaln());
            } else if (zzaku == 40) {
                this.zzhg = Long.valueOf(zzbuq.zzaln());
            } else if (!super.zza(zzbuq, zzaku)) {
                return this;
            }
        }
    }
}
