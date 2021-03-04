package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzuw;
import java.io.IOException;

public final class zzvl extends zzbut<zzvl> {
    public Integer zzcgm = null;
    private zzvc zzcgn = null;
    private zzuw.zzb zzcgo = null;
    public zzvm zzcgp = null;
    private zzuw.zza[] zzcgq = new zzuw.zza[0];
    private zzuw.zzc zzcgr = null;
    private zzuw.zzj zzcgs = null;
    private zzuw.zzi zzcgt = null;
    private zzuw.zzf zzcgu = null;
    private zzuw.zzg zzcgv = null;
    private zzvr[] zzcgw = zzvr.zzpl();

    public zzvl() {
        this.zzfwk = null;
        this.zzfwt = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final void zza(zzbur zzbur) throws IOException {
        Integer num = this.zzcgm;
        if (num != null) {
            zzbur.zzv(7, num.intValue());
        }
        zzvc zzvc = this.zzcgn;
        if (!(zzvc == null || zzvc == null)) {
            zzbur.zzv(8, zzvc.zzom());
        }
        zzuw.zzb zzb = this.zzcgo;
        if (zzb != null) {
            zzbur.zze(9, zzb);
        }
        zzvm zzvm = this.zzcgp;
        if (zzvm != null) {
            zzbur.zza(10, zzvm);
        }
        zzuw.zza[] zzaArr = this.zzcgq;
        int i = 0;
        if (zzaArr != null && zzaArr.length > 0) {
            int i2 = 0;
            while (true) {
                zzuw.zza[] zzaArr2 = this.zzcgq;
                if (i2 >= zzaArr2.length) {
                    break;
                }
                zzuw.zza zza = zzaArr2[i2];
                if (zza != null) {
                    zzbur.zze(11, zza);
                }
                i2++;
            }
        }
        zzuw.zzc zzc = this.zzcgr;
        if (zzc != null) {
            zzbur.zze(12, zzc);
        }
        zzuw.zzj zzj = this.zzcgs;
        if (zzj != null) {
            zzbur.zze(13, zzj);
        }
        zzuw.zzi zzi = this.zzcgt;
        if (zzi != null) {
            zzbur.zze(14, zzi);
        }
        zzuw.zzf zzf = this.zzcgu;
        if (zzf != null) {
            zzbur.zze(15, zzf);
        }
        zzuw.zzg zzg = this.zzcgv;
        if (zzg != null) {
            zzbur.zze(16, zzg);
        }
        zzvr[] zzvrArr = this.zzcgw;
        if (zzvrArr != null && zzvrArr.length > 0) {
            while (true) {
                zzvr[] zzvrArr2 = this.zzcgw;
                if (i >= zzvrArr2.length) {
                    break;
                }
                zzvr zzvr = zzvrArr2[i];
                if (zzvr != null) {
                    zzbur.zza(17, zzvr);
                }
                i++;
            }
        }
        super.zza(zzbur);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final int zzt() {
        int zzt = super.zzt();
        Integer num = this.zzcgm;
        if (num != null) {
            zzt += zzbur.zzz(7, num.intValue());
        }
        zzvc zzvc = this.zzcgn;
        if (!(zzvc == null || zzvc == null)) {
            zzt += zzbur.zzz(8, zzvc.zzom());
        }
        zzuw.zzb zzb = this.zzcgo;
        if (zzb != null) {
            zzt += zzbqk.zzc(9, zzb);
        }
        zzvm zzvm = this.zzcgp;
        if (zzvm != null) {
            zzt += zzbur.zzb(10, zzvm);
        }
        zzuw.zza[] zzaArr = this.zzcgq;
        int i = 0;
        if (zzaArr != null && zzaArr.length > 0) {
            int i2 = zzt;
            int i3 = 0;
            while (true) {
                zzuw.zza[] zzaArr2 = this.zzcgq;
                if (i3 >= zzaArr2.length) {
                    break;
                }
                zzuw.zza zza = zzaArr2[i3];
                if (zza != null) {
                    i2 += zzbqk.zzc(11, zza);
                }
                i3++;
            }
            zzt = i2;
        }
        zzuw.zzc zzc = this.zzcgr;
        if (zzc != null) {
            zzt += zzbqk.zzc(12, zzc);
        }
        zzuw.zzj zzj = this.zzcgs;
        if (zzj != null) {
            zzt += zzbqk.zzc(13, zzj);
        }
        zzuw.zzi zzi = this.zzcgt;
        if (zzi != null) {
            zzt += zzbqk.zzc(14, zzi);
        }
        zzuw.zzf zzf = this.zzcgu;
        if (zzf != null) {
            zzt += zzbqk.zzc(15, zzf);
        }
        zzuw.zzg zzg = this.zzcgv;
        if (zzg != null) {
            zzt += zzbqk.zzc(16, zzg);
        }
        zzvr[] zzvrArr = this.zzcgw;
        if (zzvrArr != null && zzvrArr.length > 0) {
            while (true) {
                zzvr[] zzvrArr2 = this.zzcgw;
                if (i >= zzvrArr2.length) {
                    break;
                }
                zzvr zzvr = zzvrArr2[i];
                if (zzvr != null) {
                    zzt += zzbur.zzb(17, zzvr);
                }
                i++;
            }
        }
        return zzt;
    }

    /* access modifiers changed from: private */
    /* renamed from: zze */
    public final zzvl zza(zzbuq zzbuq) throws IOException {
        int zzalm;
        while (true) {
            int zzaku = zzbuq.zzaku();
            switch (zzaku) {
                case 0:
                    return this;
                case 56:
                    try {
                        zzalm = zzbuq.zzalm();
                        if (zzalm >= 0 && zzalm <= 9) {
                            this.zzcgm = Integer.valueOf(zzalm);
                            break;
                        } else {
                            StringBuilder sb = new StringBuilder(43);
                            sb.append(zzalm);
                            sb.append(" is not a valid enum AdInitiater");
                            break;
                        }
                    } catch (IllegalArgumentException unused) {
                        zzbuq.zzgc(zzbuq.getPosition());
                        zza(zzbuq, zzaku);
                        break;
                    }
                case 64:
                    int position = zzbuq.getPosition();
                    int zzalm2 = zzbuq.zzalm();
                    if (zzalm2 != 1000) {
                        switch (zzalm2) {
                            case 0:
                            case 1:
                                break;
                            default:
                                zzbuq.zzgc(position);
                                zza(zzbuq, zzaku);
                                break;
                        }
                    }
                    this.zzcgn = zzvc.zzcd(zzalm2);
                    break;
                case 74:
                    this.zzcgo = (zzuw.zzb) zzbuq.zza(zzuw.zzb.zzon());
                    break;
                case 82:
                    if (this.zzcgp == null) {
                        this.zzcgp = new zzvm();
                    }
                    zzbuq.zza(this.zzcgp);
                    break;
                case 90:
                    int zzb = zzbvc.zzb(zzbuq, 90);
                    zzuw.zza[] zzaArr = this.zzcgq;
                    int length = zzaArr == null ? 0 : zzaArr.length;
                    zzuw.zza[] zzaArr2 = new zzuw.zza[(zzb + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzcgq, 0, zzaArr2, 0, length);
                    }
                    while (length < zzaArr2.length - 1) {
                        zzaArr2[length] = (zzuw.zza) zzbuq.zza(zzuw.zza.zzon());
                        zzbuq.zzaku();
                        length++;
                    }
                    zzaArr2[length] = (zzuw.zza) zzbuq.zza(zzuw.zza.zzon());
                    this.zzcgq = zzaArr2;
                    break;
                case 98:
                    this.zzcgr = (zzuw.zzc) zzbuq.zza(zzuw.zzc.zzon());
                    break;
                case 106:
                    this.zzcgs = (zzuw.zzj) zzbuq.zza(zzuw.zzj.zzon());
                    break;
                case 114:
                    this.zzcgt = (zzuw.zzi) zzbuq.zza(zzuw.zzi.zzon());
                    break;
                case 122:
                    this.zzcgu = (zzuw.zzf) zzbuq.zza(zzuw.zzf.zzon());
                    break;
                case 130:
                    this.zzcgv = (zzuw.zzg) zzbuq.zza(zzuw.zzg.zzon());
                    break;
                case 138:
                    int zzb2 = zzbvc.zzb(zzbuq, 138);
                    zzvr[] zzvrArr = this.zzcgw;
                    int length2 = zzvrArr == null ? 0 : zzvrArr.length;
                    zzvr[] zzvrArr2 = new zzvr[(zzb2 + length2)];
                    if (length2 != 0) {
                        System.arraycopy(this.zzcgw, 0, zzvrArr2, 0, length2);
                    }
                    while (length2 < zzvrArr2.length - 1) {
                        zzvrArr2[length2] = new zzvr();
                        zzbuq.zza(zzvrArr2[length2]);
                        zzbuq.zzaku();
                        length2++;
                    }
                    zzvrArr2[length2] = new zzvr();
                    zzbuq.zza(zzvrArr2[length2]);
                    this.zzcgw = zzvrArr2;
                    break;
                default:
                    if (super.zza(zzbuq, zzaku)) {
                        break;
                    } else {
                        return this;
                    }
            }
        }
        StringBuilder sb2 = new StringBuilder(43);
        sb2.append(zzalm);
        sb2.append(" is not a valid enum AdInitiater");
        throw new IllegalArgumentException(sb2.toString());
    }
}
