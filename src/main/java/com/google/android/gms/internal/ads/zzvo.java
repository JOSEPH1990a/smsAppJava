package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzuw;
import java.io.IOException;

public final class zzvo extends zzbut<zzvo> {
    private zzuw.zzd.zzb zzchk = null;
    private zzvq zzchl = null;
    private String zzchm = null;
    private String zzchn = null;

    public zzvo() {
        this.zzfwk = null;
        this.zzfwt = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final void zza(zzbur zzbur) throws IOException {
        zzuw.zzd.zzb zzb = this.zzchk;
        if (!(zzb == null || zzb == null)) {
            zzbur.zzv(5, zzb.zzom());
        }
        zzvq zzvq = this.zzchl;
        if (zzvq != null) {
            zzbur.zza(6, zzvq);
        }
        String str = this.zzchm;
        if (str != null) {
            zzbur.zzf(7, str);
        }
        String str2 = this.zzchn;
        if (str2 != null) {
            zzbur.zzf(8, str2);
        }
        super.zza(zzbur);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final int zzt() {
        int zzt = super.zzt();
        zzuw.zzd.zzb zzb = this.zzchk;
        if (!(zzb == null || zzb == null)) {
            zzt += zzbur.zzz(5, zzb.zzom());
        }
        zzvq zzvq = this.zzchl;
        if (zzvq != null) {
            zzt += zzbur.zzb(6, zzvq);
        }
        String str = this.zzchm;
        if (str != null) {
            zzt += zzbur.zzg(7, str);
        }
        String str2 = this.zzchn;
        return str2 != null ? zzt + zzbur.zzg(8, str2) : zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final /* synthetic */ zzbuz zza(zzbuq zzbuq) throws IOException {
        while (true) {
            int zzaku = zzbuq.zzaku();
            if (zzaku == 0) {
                return this;
            }
            if (zzaku == 40) {
                int position = zzbuq.getPosition();
                int zzalm = zzbuq.zzalm();
                switch (zzalm) {
                    case 0:
                    case 1:
                    case 2:
                        this.zzchk = zzuw.zzd.zzb.zzcc(zzalm);
                        continue;
                    default:
                        zzbuq.zzgc(position);
                        zza(zzbuq, zzaku);
                        continue;
                }
            } else if (zzaku == 50) {
                if (this.zzchl == null) {
                    this.zzchl = new zzvq();
                }
                zzbuq.zza(this.zzchl);
            } else if (zzaku == 58) {
                this.zzchm = zzbuq.readString();
            } else if (zzaku == 66) {
                this.zzchn = zzbuq.readString();
            } else if (!super.zza(zzbuq, zzaku)) {
                return this;
            }
        }
    }
}
