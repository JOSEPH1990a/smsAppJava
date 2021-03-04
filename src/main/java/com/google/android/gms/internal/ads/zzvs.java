package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzuw;
import java.io.IOException;

public final class zzvs extends zzbut<zzvs> {
    private zzvq zzcis = null;
    private zzvc zzcit = null;
    private zzuw.zzq zzciu = null;
    private zzuw.zzn zzciv = null;

    public zzvs() {
        this.zzfwk = null;
        this.zzfwt = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final void zza(zzbur zzbur) throws IOException {
        zzvq zzvq = this.zzcis;
        if (zzvq != null) {
            zzbur.zza(1, zzvq);
        }
        zzvc zzvc = this.zzcit;
        if (!(zzvc == null || zzvc == null)) {
            zzbur.zzv(2, zzvc.zzom());
        }
        zzuw.zzq zzq = this.zzciu;
        if (zzq != null) {
            zzbur.zze(3, zzq);
        }
        zzuw.zzn zzn = this.zzciv;
        if (zzn != null) {
            zzbur.zze(4, zzn);
        }
        super.zza(zzbur);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final int zzt() {
        int zzt = super.zzt();
        zzvq zzvq = this.zzcis;
        if (zzvq != null) {
            zzt += zzbur.zzb(1, zzvq);
        }
        zzvc zzvc = this.zzcit;
        if (!(zzvc == null || zzvc == null)) {
            zzt += zzbur.zzz(2, zzvc.zzom());
        }
        zzuw.zzq zzq = this.zzciu;
        if (zzq != null) {
            zzt += zzbqk.zzc(3, zzq);
        }
        zzuw.zzn zzn = this.zzciv;
        return zzn != null ? zzt + zzbqk.zzc(4, zzn) : zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final /* synthetic */ zzbuz zza(zzbuq zzbuq) throws IOException {
        while (true) {
            int zzaku = zzbuq.zzaku();
            if (zzaku == 0) {
                return this;
            }
            if (zzaku == 10) {
                if (this.zzcis == null) {
                    this.zzcis = new zzvq();
                }
                zzbuq.zza(this.zzcis);
            } else if (zzaku == 16) {
                int position = zzbuq.getPosition();
                int zzalm = zzbuq.zzalm();
                if (zzalm != 1000) {
                    switch (zzalm) {
                        case 0:
                        case 1:
                            break;
                        default:
                            zzbuq.zzgc(position);
                            zza(zzbuq, zzaku);
                            break;
                    }
                }
                this.zzcit = zzvc.zzcd(zzalm);
            } else if (zzaku == 26) {
                this.zzciu = (zzuw.zzq) zzbuq.zza(zzuw.zzq.zzon());
            } else if (zzaku == 34) {
                this.zzciv = (zzuw.zzn) zzbuq.zza(zzuw.zzn.zzon());
            } else if (!super.zza(zzbuq, zzaku)) {
                return this;
            }
        }
    }
}
