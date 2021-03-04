package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzuw;
import java.io.IOException;

public final class zzvr extends zzbut<zzvr> {
    private static volatile zzvr[] zzcib;
    private zzuw.zzr zzcic = null;
    private zzuw.zzt zzcid = null;
    private zzuw.zzu zzcie = null;
    private zzuw.zzv zzcif = null;
    private zzuw.zzp zzcig = null;
    private zzuw.zzs zzcih = null;
    private zzvs zzcii = null;
    private Integer zzcij = null;
    private Integer zzcik = null;
    private zzuw.zzn zzcil = null;
    private Integer zzcim = null;
    private Integer zzcin = null;
    private Integer zzcio = null;
    private Integer zzcip = null;
    private Integer zzciq = null;
    private Long zzcir = null;

    public static zzvr[] zzpl() {
        if (zzcib == null) {
            synchronized (zzbux.zzfws) {
                if (zzcib == null) {
                    zzcib = new zzvr[0];
                }
            }
        }
        return zzcib;
    }

    public zzvr() {
        this.zzfwk = null;
        this.zzfwt = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final void zza(zzbur zzbur) throws IOException {
        zzuw.zzr zzr = this.zzcic;
        if (zzr != null) {
            zzbur.zze(5, zzr);
        }
        zzuw.zzt zzt = this.zzcid;
        if (zzt != null) {
            zzbur.zze(6, zzt);
        }
        zzuw.zzu zzu = this.zzcie;
        if (zzu != null) {
            zzbur.zze(7, zzu);
        }
        zzuw.zzv zzv = this.zzcif;
        if (zzv != null) {
            zzbur.zze(8, zzv);
        }
        zzuw.zzp zzp = this.zzcig;
        if (zzp != null) {
            zzbur.zze(9, zzp);
        }
        zzuw.zzs zzs = this.zzcih;
        if (zzs != null) {
            zzbur.zze(10, zzs);
        }
        zzvs zzvs = this.zzcii;
        if (zzvs != null) {
            zzbur.zza(11, zzvs);
        }
        Integer num = this.zzcij;
        if (num != null) {
            zzbur.zzv(12, num.intValue());
        }
        Integer num2 = this.zzcik;
        if (num2 != null) {
            zzbur.zzv(13, num2.intValue());
        }
        zzuw.zzn zzn = this.zzcil;
        if (zzn != null) {
            zzbur.zze(14, zzn);
        }
        Integer num3 = this.zzcim;
        if (num3 != null) {
            zzbur.zzv(15, num3.intValue());
        }
        Integer num4 = this.zzcin;
        if (num4 != null) {
            zzbur.zzv(16, num4.intValue());
        }
        Integer num5 = this.zzcio;
        if (num5 != null) {
            zzbur.zzv(17, num5.intValue());
        }
        Integer num6 = this.zzcip;
        if (num6 != null) {
            zzbur.zzv(18, num6.intValue());
        }
        Integer num7 = this.zzciq;
        if (num7 != null) {
            zzbur.zzv(19, num7.intValue());
        }
        Long l = this.zzcir;
        if (l != null) {
            zzbur.zzj(20, l.longValue());
        }
        super.zza(zzbur);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbut, com.google.android.gms.internal.ads.zzbuz
    public final int zzt() {
        int zzt = super.zzt();
        zzuw.zzr zzr = this.zzcic;
        if (zzr != null) {
            zzt += zzbqk.zzc(5, zzr);
        }
        zzuw.zzt zzt2 = this.zzcid;
        if (zzt2 != null) {
            zzt += zzbqk.zzc(6, zzt2);
        }
        zzuw.zzu zzu = this.zzcie;
        if (zzu != null) {
            zzt += zzbqk.zzc(7, zzu);
        }
        zzuw.zzv zzv = this.zzcif;
        if (zzv != null) {
            zzt += zzbqk.zzc(8, zzv);
        }
        zzuw.zzp zzp = this.zzcig;
        if (zzp != null) {
            zzt += zzbqk.zzc(9, zzp);
        }
        zzuw.zzs zzs = this.zzcih;
        if (zzs != null) {
            zzt += zzbqk.zzc(10, zzs);
        }
        zzvs zzvs = this.zzcii;
        if (zzvs != null) {
            zzt += zzbur.zzb(11, zzvs);
        }
        Integer num = this.zzcij;
        if (num != null) {
            zzt += zzbur.zzz(12, num.intValue());
        }
        Integer num2 = this.zzcik;
        if (num2 != null) {
            zzt += zzbur.zzz(13, num2.intValue());
        }
        zzuw.zzn zzn = this.zzcil;
        if (zzn != null) {
            zzt += zzbqk.zzc(14, zzn);
        }
        Integer num3 = this.zzcim;
        if (num3 != null) {
            zzt += zzbur.zzz(15, num3.intValue());
        }
        Integer num4 = this.zzcin;
        if (num4 != null) {
            zzt += zzbur.zzz(16, num4.intValue());
        }
        Integer num5 = this.zzcio;
        if (num5 != null) {
            zzt += zzbur.zzz(17, num5.intValue());
        }
        Integer num6 = this.zzcip;
        if (num6 != null) {
            zzt += zzbur.zzz(18, num6.intValue());
        }
        Integer num7 = this.zzciq;
        if (num7 != null) {
            zzt += zzbur.zzz(19, num7.intValue());
        }
        Long l = this.zzcir;
        return l != null ? zzt + zzbur.zzn(20, l.longValue()) : zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final /* synthetic */ zzbuz zza(zzbuq zzbuq) throws IOException {
        while (true) {
            int zzaku = zzbuq.zzaku();
            switch (zzaku) {
                case 0:
                    return this;
                case 42:
                    this.zzcic = (zzuw.zzr) zzbuq.zza(zzuw.zzr.zzon());
                    break;
                case 50:
                    this.zzcid = (zzuw.zzt) zzbuq.zza(zzuw.zzt.zzon());
                    break;
                case 58:
                    this.zzcie = (zzuw.zzu) zzbuq.zza(zzuw.zzu.zzon());
                    break;
                case 66:
                    this.zzcif = (zzuw.zzv) zzbuq.zza(zzuw.zzv.zzon());
                    break;
                case 74:
                    this.zzcig = (zzuw.zzp) zzbuq.zza(zzuw.zzp.zzon());
                    break;
                case 82:
                    this.zzcih = (zzuw.zzs) zzbuq.zza(zzuw.zzs.zzon());
                    break;
                case 90:
                    if (this.zzcii == null) {
                        this.zzcii = new zzvs();
                    }
                    zzbuq.zza(this.zzcii);
                    break;
                case 96:
                    this.zzcij = Integer.valueOf(zzbuq.zzalm());
                    break;
                case 104:
                    this.zzcik = Integer.valueOf(zzbuq.zzalm());
                    break;
                case 114:
                    this.zzcil = (zzuw.zzn) zzbuq.zza(zzuw.zzn.zzon());
                    break;
                case 120:
                    this.zzcim = Integer.valueOf(zzbuq.zzalm());
                    break;
                case 128:
                    this.zzcin = Integer.valueOf(zzbuq.zzalm());
                    break;
                case 136:
                    this.zzcio = Integer.valueOf(zzbuq.zzalm());
                    break;
                case 144:
                    this.zzcip = Integer.valueOf(zzbuq.zzalm());
                    break;
                case 152:
                    this.zzciq = Integer.valueOf(zzbuq.zzalm());
                    break;
                case 160:
                    this.zzcir = Long.valueOf(zzbuq.zzaln());
                    break;
                default:
                    if (super.zza(zzbuq, zzaku)) {
                        break;
                    } else {
                        return this;
                    }
            }
        }
    }
}
