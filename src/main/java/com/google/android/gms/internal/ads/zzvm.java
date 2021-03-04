package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzuw;
import java.io.IOException;

public final class zzvm extends zzbut<zzvm> {
    public String zzcgx = null;
    private zzuw.zza[] zzcgy = new zzuw.zza[0];
    private zzvc zzcgz = null;
    private zzvc zzcha = null;
    private zzvc zzchb = null;

    public zzvm() {
        this.zzfwk = null;
        this.zzfwt = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final void zza(zzbur zzbur) throws IOException {
        String str = this.zzcgx;
        if (str != null) {
            zzbur.zzf(1, str);
        }
        zzuw.zza[] zzaArr = this.zzcgy;
        if (zzaArr != null && zzaArr.length > 0) {
            int i = 0;
            while (true) {
                zzuw.zza[] zzaArr2 = this.zzcgy;
                if (i >= zzaArr2.length) {
                    break;
                }
                zzuw.zza zza = zzaArr2[i];
                if (zza != null) {
                    zzbur.zze(2, zza);
                }
                i++;
            }
        }
        zzvc zzvc = this.zzcgz;
        if (!(zzvc == null || zzvc == null)) {
            zzbur.zzv(3, zzvc.zzom());
        }
        zzvc zzvc2 = this.zzcha;
        if (!(zzvc2 == null || zzvc2 == null)) {
            zzbur.zzv(4, zzvc2.zzom());
        }
        zzvc zzvc3 = this.zzchb;
        if (!(zzvc3 == null || zzvc3 == null)) {
            zzbur.zzv(5, zzvc3.zzom());
        }
        super.zza(zzbur);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final int zzt() {
        int zzt = super.zzt();
        String str = this.zzcgx;
        if (str != null) {
            zzt += zzbur.zzg(1, str);
        }
        zzuw.zza[] zzaArr = this.zzcgy;
        if (zzaArr != null && zzaArr.length > 0) {
            int i = 0;
            while (true) {
                zzuw.zza[] zzaArr2 = this.zzcgy;
                if (i >= zzaArr2.length) {
                    break;
                }
                zzuw.zza zza = zzaArr2[i];
                if (zza != null) {
                    zzt += zzbqk.zzc(2, zza);
                }
                i++;
            }
        }
        zzvc zzvc = this.zzcgz;
        if (!(zzvc == null || zzvc == null)) {
            zzt += zzbur.zzz(3, zzvc.zzom());
        }
        zzvc zzvc2 = this.zzcha;
        if (!(zzvc2 == null || zzvc2 == null)) {
            zzt += zzbur.zzz(4, zzvc2.zzom());
        }
        zzvc zzvc3 = this.zzchb;
        return (zzvc3 == null || zzvc3 == null) ? zzt : zzt + zzbur.zzz(5, zzvc3.zzom());
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final /* synthetic */ zzbuz zza(zzbuq zzbuq) throws IOException {
        while (true) {
            int zzaku = zzbuq.zzaku();
            if (zzaku == 0) {
                return this;
            }
            if (zzaku == 10) {
                this.zzcgx = zzbuq.readString();
            } else if (zzaku == 18) {
                int zzb = zzbvc.zzb(zzbuq, 18);
                zzuw.zza[] zzaArr = this.zzcgy;
                int length = zzaArr == null ? 0 : zzaArr.length;
                zzuw.zza[] zzaArr2 = new zzuw.zza[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzcgy, 0, zzaArr2, 0, length);
                }
                while (length < zzaArr2.length - 1) {
                    zzaArr2[length] = (zzuw.zza) zzbuq.zza(zzuw.zza.zzon());
                    zzbuq.zzaku();
                    length++;
                }
                zzaArr2[length] = (zzuw.zza) zzbuq.zza(zzuw.zza.zzon());
                this.zzcgy = zzaArr2;
            } else if (zzaku == 24) {
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
                this.zzcgz = zzvc.zzcd(zzalm);
            } else if (zzaku == 32) {
                int position2 = zzbuq.getPosition();
                int zzalm2 = zzbuq.zzalm();
                if (zzalm2 != 1000) {
                    switch (zzalm2) {
                        case 0:
                        case 1:
                            break;
                        default:
                            zzbuq.zzgc(position2);
                            zza(zzbuq, zzaku);
                            break;
                    }
                }
                this.zzcha = zzvc.zzcd(zzalm2);
            } else if (zzaku == 40) {
                int position3 = zzbuq.getPosition();
                int zzalm3 = zzbuq.zzalm();
                if (zzalm3 != 1000) {
                    switch (zzalm3) {
                        case 0:
                        case 1:
                            break;
                        default:
                            zzbuq.zzgc(position3);
                            zza(zzbuq, zzaku);
                            break;
                    }
                }
                this.zzchb = zzvc.zzcd(zzalm3);
            } else if (!super.zza(zzbuq, zzaku)) {
                return this;
            }
        }
    }
}
