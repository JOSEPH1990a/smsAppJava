package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfe;
import java.io.IOException;

public final class zzfw extends zzyc<zzfw> {
    private static volatile zzfw[] zzaxg;
    public String zzafh = null;
    public String zzafi = null;
    public String zzafk = null;
    public String zzafp = null;
    public String zzagm = null;
    public String zzahr = null;
    public String zzawp = null;
    public Integer zzaxh = null;
    public zzft[] zzaxi = zzft.zzmz();
    public zzfz[] zzaxj = zzfz.zznd();
    public Long zzaxk = null;
    public Long zzaxl = null;
    public Long zzaxm = null;
    public Long zzaxn = null;
    public Long zzaxo = null;
    public String zzaxp = null;
    public String zzaxq = null;
    public String zzaxr = null;
    public Integer zzaxs = null;
    public Long zzaxt = null;
    public Long zzaxu = null;
    public String zzaxv = null;
    public Boolean zzaxw = null;
    public Long zzaxx = null;
    public Integer zzaxy = null;
    public Boolean zzaxz = null;
    public zzfr[] zzaya = zzfr.zzmx();
    public Integer zzayb = null;
    private Integer zzayc = null;
    private Integer zzayd = null;
    public String zzaye = null;
    public Long zzayf = null;
    public Long zzayg = null;
    public String zzayh = null;
    private String zzayi = null;
    public Integer zzayj = null;
    public zzfe.zzb zzayk = null;
    public int[] zzayl = zzyl.zzcao;
    private Long zzaym = null;
    public String zzts = null;
    public String zztt = null;

    public static zzfw[] zznb() {
        if (zzaxg == null) {
            synchronized (zzyg.zzcfc) {
                if (zzaxg == null) {
                    zzaxg = new zzfw[0];
                }
            }
        }
        return zzaxg;
    }

    public zzfw() {
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfw)) {
            return false;
        }
        zzfw zzfw = (zzfw) obj;
        Integer num = this.zzaxh;
        if (num == null) {
            if (zzfw.zzaxh != null) {
                return false;
            }
        } else if (!num.equals(zzfw.zzaxh)) {
            return false;
        }
        if (!zzyg.equals(this.zzaxi, zzfw.zzaxi) || !zzyg.equals(this.zzaxj, zzfw.zzaxj)) {
            return false;
        }
        Long l = this.zzaxk;
        if (l == null) {
            if (zzfw.zzaxk != null) {
                return false;
            }
        } else if (!l.equals(zzfw.zzaxk)) {
            return false;
        }
        Long l2 = this.zzaxl;
        if (l2 == null) {
            if (zzfw.zzaxl != null) {
                return false;
            }
        } else if (!l2.equals(zzfw.zzaxl)) {
            return false;
        }
        Long l3 = this.zzaxm;
        if (l3 == null) {
            if (zzfw.zzaxm != null) {
                return false;
            }
        } else if (!l3.equals(zzfw.zzaxm)) {
            return false;
        }
        Long l4 = this.zzaxn;
        if (l4 == null) {
            if (zzfw.zzaxn != null) {
                return false;
            }
        } else if (!l4.equals(zzfw.zzaxn)) {
            return false;
        }
        Long l5 = this.zzaxo;
        if (l5 == null) {
            if (zzfw.zzaxo != null) {
                return false;
            }
        } else if (!l5.equals(zzfw.zzaxo)) {
            return false;
        }
        String str = this.zzaxp;
        if (str == null) {
            if (zzfw.zzaxp != null) {
                return false;
            }
        } else if (!str.equals(zzfw.zzaxp)) {
            return false;
        }
        String str2 = this.zzaxq;
        if (str2 == null) {
            if (zzfw.zzaxq != null) {
                return false;
            }
        } else if (!str2.equals(zzfw.zzaxq)) {
            return false;
        }
        String str3 = this.zzaxr;
        if (str3 == null) {
            if (zzfw.zzaxr != null) {
                return false;
            }
        } else if (!str3.equals(zzfw.zzaxr)) {
            return false;
        }
        String str4 = this.zzahr;
        if (str4 == null) {
            if (zzfw.zzahr != null) {
                return false;
            }
        } else if (!str4.equals(zzfw.zzahr)) {
            return false;
        }
        Integer num2 = this.zzaxs;
        if (num2 == null) {
            if (zzfw.zzaxs != null) {
                return false;
            }
        } else if (!num2.equals(zzfw.zzaxs)) {
            return false;
        }
        String str5 = this.zzafp;
        if (str5 == null) {
            if (zzfw.zzafp != null) {
                return false;
            }
        } else if (!str5.equals(zzfw.zzafp)) {
            return false;
        }
        String str6 = this.zztt;
        if (str6 == null) {
            if (zzfw.zztt != null) {
                return false;
            }
        } else if (!str6.equals(zzfw.zztt)) {
            return false;
        }
        String str7 = this.zzts;
        if (str7 == null) {
            if (zzfw.zzts != null) {
                return false;
            }
        } else if (!str7.equals(zzfw.zzts)) {
            return false;
        }
        Long l6 = this.zzaxt;
        if (l6 == null) {
            if (zzfw.zzaxt != null) {
                return false;
            }
        } else if (!l6.equals(zzfw.zzaxt)) {
            return false;
        }
        Long l7 = this.zzaxu;
        if (l7 == null) {
            if (zzfw.zzaxu != null) {
                return false;
            }
        } else if (!l7.equals(zzfw.zzaxu)) {
            return false;
        }
        String str8 = this.zzaxv;
        if (str8 == null) {
            if (zzfw.zzaxv != null) {
                return false;
            }
        } else if (!str8.equals(zzfw.zzaxv)) {
            return false;
        }
        Boolean bool = this.zzaxw;
        if (bool == null) {
            if (zzfw.zzaxw != null) {
                return false;
            }
        } else if (!bool.equals(zzfw.zzaxw)) {
            return false;
        }
        String str9 = this.zzafh;
        if (str9 == null) {
            if (zzfw.zzafh != null) {
                return false;
            }
        } else if (!str9.equals(zzfw.zzafh)) {
            return false;
        }
        Long l8 = this.zzaxx;
        if (l8 == null) {
            if (zzfw.zzaxx != null) {
                return false;
            }
        } else if (!l8.equals(zzfw.zzaxx)) {
            return false;
        }
        Integer num3 = this.zzaxy;
        if (num3 == null) {
            if (zzfw.zzaxy != null) {
                return false;
            }
        } else if (!num3.equals(zzfw.zzaxy)) {
            return false;
        }
        String str10 = this.zzagm;
        if (str10 == null) {
            if (zzfw.zzagm != null) {
                return false;
            }
        } else if (!str10.equals(zzfw.zzagm)) {
            return false;
        }
        String str11 = this.zzafi;
        if (str11 == null) {
            if (zzfw.zzafi != null) {
                return false;
            }
        } else if (!str11.equals(zzfw.zzafi)) {
            return false;
        }
        Boolean bool2 = this.zzaxz;
        if (bool2 == null) {
            if (zzfw.zzaxz != null) {
                return false;
            }
        } else if (!bool2.equals(zzfw.zzaxz)) {
            return false;
        }
        if (!zzyg.equals(this.zzaya, zzfw.zzaya)) {
            return false;
        }
        String str12 = this.zzafk;
        if (str12 == null) {
            if (zzfw.zzafk != null) {
                return false;
            }
        } else if (!str12.equals(zzfw.zzafk)) {
            return false;
        }
        Integer num4 = this.zzayb;
        if (num4 == null) {
            if (zzfw.zzayb != null) {
                return false;
            }
        } else if (!num4.equals(zzfw.zzayb)) {
            return false;
        }
        Integer num5 = this.zzayc;
        if (num5 == null) {
            if (zzfw.zzayc != null) {
                return false;
            }
        } else if (!num5.equals(zzfw.zzayc)) {
            return false;
        }
        Integer num6 = this.zzayd;
        if (num6 == null) {
            if (zzfw.zzayd != null) {
                return false;
            }
        } else if (!num6.equals(zzfw.zzayd)) {
            return false;
        }
        String str13 = this.zzaye;
        if (str13 == null) {
            if (zzfw.zzaye != null) {
                return false;
            }
        } else if (!str13.equals(zzfw.zzaye)) {
            return false;
        }
        Long l9 = this.zzayf;
        if (l9 == null) {
            if (zzfw.zzayf != null) {
                return false;
            }
        } else if (!l9.equals(zzfw.zzayf)) {
            return false;
        }
        Long l10 = this.zzayg;
        if (l10 == null) {
            if (zzfw.zzayg != null) {
                return false;
            }
        } else if (!l10.equals(zzfw.zzayg)) {
            return false;
        }
        String str14 = this.zzayh;
        if (str14 == null) {
            if (zzfw.zzayh != null) {
                return false;
            }
        } else if (!str14.equals(zzfw.zzayh)) {
            return false;
        }
        String str15 = this.zzayi;
        if (str15 == null) {
            if (zzfw.zzayi != null) {
                return false;
            }
        } else if (!str15.equals(zzfw.zzayi)) {
            return false;
        }
        Integer num7 = this.zzayj;
        if (num7 == null) {
            if (zzfw.zzayj != null) {
                return false;
            }
        } else if (!num7.equals(zzfw.zzayj)) {
            return false;
        }
        String str16 = this.zzawp;
        if (str16 == null) {
            if (zzfw.zzawp != null) {
                return false;
            }
        } else if (!str16.equals(zzfw.zzawp)) {
            return false;
        }
        zzfe.zzb zzb = this.zzayk;
        if (zzb == null) {
            if (zzfw.zzayk != null) {
                return false;
            }
        } else if (!zzb.equals(zzfw.zzayk)) {
            return false;
        }
        if (!zzyg.equals(this.zzayl, zzfw.zzayl)) {
            return false;
        }
        Long l11 = this.zzaym;
        if (l11 == null) {
            if (zzfw.zzaym != null) {
                return false;
            }
        } else if (!l11.equals(zzfw.zzaym)) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzfw.zzcet == null || zzfw.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzfw.zzcet);
    }

    public final int hashCode() {
        int i;
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        Integer num = this.zzaxh;
        int i2 = 0;
        int hashCode2 = (((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + zzyg.hashCode(this.zzaxi)) * 31) + zzyg.hashCode(this.zzaxj)) * 31;
        Long l = this.zzaxk;
        int hashCode3 = (hashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.zzaxl;
        int hashCode4 = (hashCode3 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.zzaxm;
        int hashCode5 = (hashCode4 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Long l4 = this.zzaxn;
        int hashCode6 = (hashCode5 + (l4 == null ? 0 : l4.hashCode())) * 31;
        Long l5 = this.zzaxo;
        int hashCode7 = (hashCode6 + (l5 == null ? 0 : l5.hashCode())) * 31;
        String str = this.zzaxp;
        int hashCode8 = (hashCode7 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.zzaxq;
        int hashCode9 = (hashCode8 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.zzaxr;
        int hashCode10 = (hashCode9 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.zzahr;
        int hashCode11 = (hashCode10 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num2 = this.zzaxs;
        int hashCode12 = (hashCode11 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str5 = this.zzafp;
        int hashCode13 = (hashCode12 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.zztt;
        int hashCode14 = (hashCode13 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.zzts;
        int hashCode15 = (hashCode14 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Long l6 = this.zzaxt;
        int hashCode16 = (hashCode15 + (l6 == null ? 0 : l6.hashCode())) * 31;
        Long l7 = this.zzaxu;
        int hashCode17 = (hashCode16 + (l7 == null ? 0 : l7.hashCode())) * 31;
        String str8 = this.zzaxv;
        int hashCode18 = (hashCode17 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Boolean bool = this.zzaxw;
        int hashCode19 = (hashCode18 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str9 = this.zzafh;
        int hashCode20 = (hashCode19 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Long l8 = this.zzaxx;
        int hashCode21 = (hashCode20 + (l8 == null ? 0 : l8.hashCode())) * 31;
        Integer num3 = this.zzaxy;
        int hashCode22 = (hashCode21 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str10 = this.zzagm;
        int hashCode23 = (hashCode22 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.zzafi;
        int hashCode24 = (hashCode23 + (str11 == null ? 0 : str11.hashCode())) * 31;
        Boolean bool2 = this.zzaxz;
        int hashCode25 = (((hashCode24 + (bool2 == null ? 0 : bool2.hashCode())) * 31) + zzyg.hashCode(this.zzaya)) * 31;
        String str12 = this.zzafk;
        int hashCode26 = (hashCode25 + (str12 == null ? 0 : str12.hashCode())) * 31;
        Integer num4 = this.zzayb;
        int hashCode27 = (hashCode26 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.zzayc;
        int hashCode28 = (hashCode27 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.zzayd;
        int hashCode29 = (hashCode28 + (num6 == null ? 0 : num6.hashCode())) * 31;
        String str13 = this.zzaye;
        int hashCode30 = (hashCode29 + (str13 == null ? 0 : str13.hashCode())) * 31;
        Long l9 = this.zzayf;
        int hashCode31 = (hashCode30 + (l9 == null ? 0 : l9.hashCode())) * 31;
        Long l10 = this.zzayg;
        int hashCode32 = (hashCode31 + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str14 = this.zzayh;
        int hashCode33 = (hashCode32 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.zzayi;
        int hashCode34 = (hashCode33 + (str15 == null ? 0 : str15.hashCode())) * 31;
        Integer num7 = this.zzayj;
        int hashCode35 = (hashCode34 + (num7 == null ? 0 : num7.hashCode())) * 31;
        String str16 = this.zzawp;
        int hashCode36 = hashCode35 + (str16 == null ? 0 : str16.hashCode());
        zzfe.zzb zzb = this.zzayk;
        int i3 = hashCode36 * 31;
        if (zzb == null) {
            i = 0;
        } else {
            i = zzb.hashCode();
        }
        int hashCode37 = (((i3 + i) * 31) + zzyg.hashCode(this.zzayl)) * 31;
        Long l11 = this.zzaym;
        int hashCode38 = (hashCode37 + (l11 == null ? 0 : l11.hashCode())) * 31;
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            i2 = this.zzcet.hashCode();
        }
        return hashCode38 + i2;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi, com.google.android.gms.internal.measurement.zzyc
    public final void zza(zzya zzya) throws IOException {
        Integer num = this.zzaxh;
        if (num != null) {
            zzya.zzd(1, num.intValue());
        }
        zzft[] zzftArr = this.zzaxi;
        if (zzftArr != null && zzftArr.length > 0) {
            int i = 0;
            while (true) {
                zzft[] zzftArr2 = this.zzaxi;
                if (i >= zzftArr2.length) {
                    break;
                }
                zzft zzft = zzftArr2[i];
                if (zzft != null) {
                    zzya.zza(2, zzft);
                }
                i++;
            }
        }
        zzfz[] zzfzArr = this.zzaxj;
        if (zzfzArr != null && zzfzArr.length > 0) {
            int i2 = 0;
            while (true) {
                zzfz[] zzfzArr2 = this.zzaxj;
                if (i2 >= zzfzArr2.length) {
                    break;
                }
                zzfz zzfz = zzfzArr2[i2];
                if (zzfz != null) {
                    zzya.zza(3, zzfz);
                }
                i2++;
            }
        }
        Long l = this.zzaxk;
        if (l != null) {
            zzya.zzi(4, l.longValue());
        }
        Long l2 = this.zzaxl;
        if (l2 != null) {
            zzya.zzi(5, l2.longValue());
        }
        Long l3 = this.zzaxm;
        if (l3 != null) {
            zzya.zzi(6, l3.longValue());
        }
        Long l4 = this.zzaxo;
        if (l4 != null) {
            zzya.zzi(7, l4.longValue());
        }
        String str = this.zzaxp;
        if (str != null) {
            zzya.zzb(8, str);
        }
        String str2 = this.zzaxq;
        if (str2 != null) {
            zzya.zzb(9, str2);
        }
        String str3 = this.zzaxr;
        if (str3 != null) {
            zzya.zzb(10, str3);
        }
        String str4 = this.zzahr;
        if (str4 != null) {
            zzya.zzb(11, str4);
        }
        Integer num2 = this.zzaxs;
        if (num2 != null) {
            zzya.zzd(12, num2.intValue());
        }
        String str5 = this.zzafp;
        if (str5 != null) {
            zzya.zzb(13, str5);
        }
        String str6 = this.zztt;
        if (str6 != null) {
            zzya.zzb(14, str6);
        }
        String str7 = this.zzts;
        if (str7 != null) {
            zzya.zzb(16, str7);
        }
        Long l5 = this.zzaxt;
        if (l5 != null) {
            zzya.zzi(17, l5.longValue());
        }
        Long l6 = this.zzaxu;
        if (l6 != null) {
            zzya.zzi(18, l6.longValue());
        }
        String str8 = this.zzaxv;
        if (str8 != null) {
            zzya.zzb(19, str8);
        }
        Boolean bool = this.zzaxw;
        if (bool != null) {
            zzya.zzb(20, bool.booleanValue());
        }
        String str9 = this.zzafh;
        if (str9 != null) {
            zzya.zzb(21, str9);
        }
        Long l7 = this.zzaxx;
        if (l7 != null) {
            zzya.zzi(22, l7.longValue());
        }
        Integer num3 = this.zzaxy;
        if (num3 != null) {
            zzya.zzd(23, num3.intValue());
        }
        String str10 = this.zzagm;
        if (str10 != null) {
            zzya.zzb(24, str10);
        }
        String str11 = this.zzafi;
        if (str11 != null) {
            zzya.zzb(25, str11);
        }
        Long l8 = this.zzaxn;
        if (l8 != null) {
            zzya.zzi(26, l8.longValue());
        }
        Boolean bool2 = this.zzaxz;
        if (bool2 != null) {
            zzya.zzb(28, bool2.booleanValue());
        }
        zzfr[] zzfrArr = this.zzaya;
        if (zzfrArr != null && zzfrArr.length > 0) {
            int i3 = 0;
            while (true) {
                zzfr[] zzfrArr2 = this.zzaya;
                if (i3 >= zzfrArr2.length) {
                    break;
                }
                zzfr zzfr = zzfrArr2[i3];
                if (zzfr != null) {
                    zzya.zza(29, zzfr);
                }
                i3++;
            }
        }
        String str12 = this.zzafk;
        if (str12 != null) {
            zzya.zzb(30, str12);
        }
        Integer num4 = this.zzayb;
        if (num4 != null) {
            zzya.zzd(31, num4.intValue());
        }
        Integer num5 = this.zzayc;
        if (num5 != null) {
            zzya.zzd(32, num5.intValue());
        }
        Integer num6 = this.zzayd;
        if (num6 != null) {
            zzya.zzd(33, num6.intValue());
        }
        String str13 = this.zzaye;
        if (str13 != null) {
            zzya.zzb(34, str13);
        }
        Long l9 = this.zzayf;
        if (l9 != null) {
            zzya.zzi(35, l9.longValue());
        }
        Long l10 = this.zzayg;
        if (l10 != null) {
            zzya.zzi(36, l10.longValue());
        }
        String str14 = this.zzayh;
        if (str14 != null) {
            zzya.zzb(37, str14);
        }
        String str15 = this.zzayi;
        if (str15 != null) {
            zzya.zzb(38, str15);
        }
        Integer num7 = this.zzayj;
        if (num7 != null) {
            zzya.zzd(39, num7.intValue());
        }
        String str16 = this.zzawp;
        if (str16 != null) {
            zzya.zzb(41, str16);
        }
        zzfe.zzb zzb = this.zzayk;
        if (zzb != null) {
            zzya.zze(44, zzb);
        }
        int[] iArr = this.zzayl;
        if (iArr != null && iArr.length > 0) {
            int i4 = 0;
            while (true) {
                int[] iArr2 = this.zzayl;
                if (i4 >= iArr2.length) {
                    break;
                }
                int i5 = iArr2[i4];
                zzya.zzc(45, 0);
                zzya.zzcd(i5);
                i4++;
            }
        }
        Long l11 = this.zzaym;
        if (l11 != null) {
            zzya.zzi(46, l11.longValue());
        }
        super.zza(zzya);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzyi, com.google.android.gms.internal.measurement.zzyc
    public final int zzf() {
        int[] iArr;
        int zzf = super.zzf();
        Integer num = this.zzaxh;
        if (num != null) {
            zzf += zzya.zzh(1, num.intValue());
        }
        zzft[] zzftArr = this.zzaxi;
        int i = 0;
        if (zzftArr != null && zzftArr.length > 0) {
            int i2 = zzf;
            int i3 = 0;
            while (true) {
                zzft[] zzftArr2 = this.zzaxi;
                if (i3 >= zzftArr2.length) {
                    break;
                }
                zzft zzft = zzftArr2[i3];
                if (zzft != null) {
                    i2 += zzya.zzb(2, zzft);
                }
                i3++;
            }
            zzf = i2;
        }
        zzfz[] zzfzArr = this.zzaxj;
        if (zzfzArr != null && zzfzArr.length > 0) {
            int i4 = zzf;
            int i5 = 0;
            while (true) {
                zzfz[] zzfzArr2 = this.zzaxj;
                if (i5 >= zzfzArr2.length) {
                    break;
                }
                zzfz zzfz = zzfzArr2[i5];
                if (zzfz != null) {
                    i4 += zzya.zzb(3, zzfz);
                }
                i5++;
            }
            zzf = i4;
        }
        Long l = this.zzaxk;
        if (l != null) {
            zzf += zzya.zzd(4, l.longValue());
        }
        Long l2 = this.zzaxl;
        if (l2 != null) {
            zzf += zzya.zzd(5, l2.longValue());
        }
        Long l3 = this.zzaxm;
        if (l3 != null) {
            zzf += zzya.zzd(6, l3.longValue());
        }
        Long l4 = this.zzaxo;
        if (l4 != null) {
            zzf += zzya.zzd(7, l4.longValue());
        }
        String str = this.zzaxp;
        if (str != null) {
            zzf += zzya.zzc(8, str);
        }
        String str2 = this.zzaxq;
        if (str2 != null) {
            zzf += zzya.zzc(9, str2);
        }
        String str3 = this.zzaxr;
        if (str3 != null) {
            zzf += zzya.zzc(10, str3);
        }
        String str4 = this.zzahr;
        if (str4 != null) {
            zzf += zzya.zzc(11, str4);
        }
        Integer num2 = this.zzaxs;
        if (num2 != null) {
            zzf += zzya.zzh(12, num2.intValue());
        }
        String str5 = this.zzafp;
        if (str5 != null) {
            zzf += zzya.zzc(13, str5);
        }
        String str6 = this.zztt;
        if (str6 != null) {
            zzf += zzya.zzc(14, str6);
        }
        String str7 = this.zzts;
        if (str7 != null) {
            zzf += zzya.zzc(16, str7);
        }
        Long l5 = this.zzaxt;
        if (l5 != null) {
            zzf += zzya.zzd(17, l5.longValue());
        }
        Long l6 = this.zzaxu;
        if (l6 != null) {
            zzf += zzya.zzd(18, l6.longValue());
        }
        String str8 = this.zzaxv;
        if (str8 != null) {
            zzf += zzya.zzc(19, str8);
        }
        Boolean bool = this.zzaxw;
        if (bool != null) {
            bool.booleanValue();
            zzf += zzya.zzbd(20) + 1;
        }
        String str9 = this.zzafh;
        if (str9 != null) {
            zzf += zzya.zzc(21, str9);
        }
        Long l7 = this.zzaxx;
        if (l7 != null) {
            zzf += zzya.zzd(22, l7.longValue());
        }
        Integer num3 = this.zzaxy;
        if (num3 != null) {
            zzf += zzya.zzh(23, num3.intValue());
        }
        String str10 = this.zzagm;
        if (str10 != null) {
            zzf += zzya.zzc(24, str10);
        }
        String str11 = this.zzafi;
        if (str11 != null) {
            zzf += zzya.zzc(25, str11);
        }
        Long l8 = this.zzaxn;
        if (l8 != null) {
            zzf += zzya.zzd(26, l8.longValue());
        }
        Boolean bool2 = this.zzaxz;
        if (bool2 != null) {
            bool2.booleanValue();
            zzf += zzya.zzbd(28) + 1;
        }
        zzfr[] zzfrArr = this.zzaya;
        if (zzfrArr != null && zzfrArr.length > 0) {
            int i6 = zzf;
            int i7 = 0;
            while (true) {
                zzfr[] zzfrArr2 = this.zzaya;
                if (i7 >= zzfrArr2.length) {
                    break;
                }
                zzfr zzfr = zzfrArr2[i7];
                if (zzfr != null) {
                    i6 += zzya.zzb(29, zzfr);
                }
                i7++;
            }
            zzf = i6;
        }
        String str12 = this.zzafk;
        if (str12 != null) {
            zzf += zzya.zzc(30, str12);
        }
        Integer num4 = this.zzayb;
        if (num4 != null) {
            zzf += zzya.zzh(31, num4.intValue());
        }
        Integer num5 = this.zzayc;
        if (num5 != null) {
            zzf += zzya.zzh(32, num5.intValue());
        }
        Integer num6 = this.zzayd;
        if (num6 != null) {
            zzf += zzya.zzh(33, num6.intValue());
        }
        String str13 = this.zzaye;
        if (str13 != null) {
            zzf += zzya.zzc(34, str13);
        }
        Long l9 = this.zzayf;
        if (l9 != null) {
            zzf += zzya.zzd(35, l9.longValue());
        }
        Long l10 = this.zzayg;
        if (l10 != null) {
            zzf += zzya.zzd(36, l10.longValue());
        }
        String str14 = this.zzayh;
        if (str14 != null) {
            zzf += zzya.zzc(37, str14);
        }
        String str15 = this.zzayi;
        if (str15 != null) {
            zzf += zzya.zzc(38, str15);
        }
        Integer num7 = this.zzayj;
        if (num7 != null) {
            zzf += zzya.zzh(39, num7.intValue());
        }
        String str16 = this.zzawp;
        if (str16 != null) {
            zzf += zzya.zzc(41, str16);
        }
        zzfe.zzb zzb = this.zzayk;
        if (zzb != null) {
            zzf += zztv.zzc(44, zzb);
        }
        int[] iArr2 = this.zzayl;
        if (iArr2 != null && iArr2.length > 0) {
            int i8 = 0;
            while (true) {
                iArr = this.zzayl;
                if (i >= iArr.length) {
                    break;
                }
                i8 += zzya.zzbl(iArr[i]);
                i++;
            }
            zzf = zzf + i8 + (iArr.length * 2);
        }
        Long l11 = this.zzaym;
        return l11 != null ? zzf + zzya.zzd(46, l11.longValue()) : zzf;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public final /* synthetic */ zzyi zza(zzxz zzxz) throws IOException {
        while (true) {
            int zzuj = zzxz.zzuj();
            switch (zzuj) {
                case 0:
                    return this;
                case 8:
                    this.zzaxh = Integer.valueOf(zzxz.zzvb());
                    break;
                case 18:
                    int zzb = zzyl.zzb(zzxz, 18);
                    zzft[] zzftArr = this.zzaxi;
                    int length = zzftArr == null ? 0 : zzftArr.length;
                    zzft[] zzftArr2 = new zzft[(zzb + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzaxi, 0, zzftArr2, 0, length);
                    }
                    while (length < zzftArr2.length - 1) {
                        zzftArr2[length] = new zzft();
                        zzxz.zza(zzftArr2[length]);
                        zzxz.zzuj();
                        length++;
                    }
                    zzftArr2[length] = new zzft();
                    zzxz.zza(zzftArr2[length]);
                    this.zzaxi = zzftArr2;
                    break;
                case 26:
                    int zzb2 = zzyl.zzb(zzxz, 26);
                    zzfz[] zzfzArr = this.zzaxj;
                    int length2 = zzfzArr == null ? 0 : zzfzArr.length;
                    zzfz[] zzfzArr2 = new zzfz[(zzb2 + length2)];
                    if (length2 != 0) {
                        System.arraycopy(this.zzaxj, 0, zzfzArr2, 0, length2);
                    }
                    while (length2 < zzfzArr2.length - 1) {
                        zzfzArr2[length2] = new zzfz();
                        zzxz.zza(zzfzArr2[length2]);
                        zzxz.zzuj();
                        length2++;
                    }
                    zzfzArr2[length2] = new zzfz();
                    zzxz.zza(zzfzArr2[length2]);
                    this.zzaxj = zzfzArr2;
                    break;
                case 32:
                    this.zzaxk = Long.valueOf(zzxz.zzvc());
                    break;
                case 40:
                    this.zzaxl = Long.valueOf(zzxz.zzvc());
                    break;
                case 48:
                    this.zzaxm = Long.valueOf(zzxz.zzvc());
                    break;
                case 56:
                    this.zzaxo = Long.valueOf(zzxz.zzvc());
                    break;
                case 66:
                    this.zzaxp = zzxz.readString();
                    break;
                case 74:
                    this.zzaxq = zzxz.readString();
                    break;
                case 82:
                    this.zzaxr = zzxz.readString();
                    break;
                case 90:
                    this.zzahr = zzxz.readString();
                    break;
                case 96:
                    this.zzaxs = Integer.valueOf(zzxz.zzvb());
                    break;
                case 106:
                    this.zzafp = zzxz.readString();
                    break;
                case 114:
                    this.zztt = zzxz.readString();
                    break;
                case 130:
                    this.zzts = zzxz.readString();
                    break;
                case 136:
                    this.zzaxt = Long.valueOf(zzxz.zzvc());
                    break;
                case 144:
                    this.zzaxu = Long.valueOf(zzxz.zzvc());
                    break;
                case 154:
                    this.zzaxv = zzxz.readString();
                    break;
                case 160:
                    this.zzaxw = Boolean.valueOf(zzxz.zzup());
                    break;
                case 170:
                    this.zzafh = zzxz.readString();
                    break;
                case 176:
                    this.zzaxx = Long.valueOf(zzxz.zzvc());
                    break;
                case 184:
                    this.zzaxy = Integer.valueOf(zzxz.zzvb());
                    break;
                case 194:
                    this.zzagm = zzxz.readString();
                    break;
                case 202:
                    this.zzafi = zzxz.readString();
                    break;
                case 208:
                    this.zzaxn = Long.valueOf(zzxz.zzvc());
                    break;
                case 224:
                    this.zzaxz = Boolean.valueOf(zzxz.zzup());
                    break;
                case 234:
                    int zzb3 = zzyl.zzb(zzxz, 234);
                    zzfr[] zzfrArr = this.zzaya;
                    int length3 = zzfrArr == null ? 0 : zzfrArr.length;
                    zzfr[] zzfrArr2 = new zzfr[(zzb3 + length3)];
                    if (length3 != 0) {
                        System.arraycopy(this.zzaya, 0, zzfrArr2, 0, length3);
                    }
                    while (length3 < zzfrArr2.length - 1) {
                        zzfrArr2[length3] = new zzfr();
                        zzxz.zza(zzfrArr2[length3]);
                        zzxz.zzuj();
                        length3++;
                    }
                    zzfrArr2[length3] = new zzfr();
                    zzxz.zza(zzfrArr2[length3]);
                    this.zzaya = zzfrArr2;
                    break;
                case 242:
                    this.zzafk = zzxz.readString();
                    break;
                case 248:
                    this.zzayb = Integer.valueOf(zzxz.zzvb());
                    break;
                case 256:
                    this.zzayc = Integer.valueOf(zzxz.zzvb());
                    break;
                case 264:
                    this.zzayd = Integer.valueOf(zzxz.zzvb());
                    break;
                case 274:
                    this.zzaye = zzxz.readString();
                    break;
                case 280:
                    this.zzayf = Long.valueOf(zzxz.zzvc());
                    break;
                case 288:
                    this.zzayg = Long.valueOf(zzxz.zzvc());
                    break;
                case 298:
                    this.zzayh = zzxz.readString();
                    break;
                case 306:
                    this.zzayi = zzxz.readString();
                    break;
                case 312:
                    this.zzayj = Integer.valueOf(zzxz.zzvb());
                    break;
                case 330:
                    this.zzawp = zzxz.readString();
                    break;
                case 354:
                    zzfe.zzb zzb4 = (zzfe.zzb) zzxz.zza(zzfe.zzb.zza());
                    zzfe.zzb zzb5 = this.zzayk;
                    if (zzb5 != null) {
                        zzb4 = (zzfe.zzb) ((zzuo) ((zzfe.zzb.zza) ((zzfe.zzb.zza) zzb5.zzwf()).zza((zzuo) zzb4)).zzwo());
                    }
                    this.zzayk = zzb4;
                    break;
                case 360:
                    int zzb6 = zzyl.zzb(zzxz, 360);
                    int[] iArr = this.zzayl;
                    int length4 = iArr == null ? 0 : iArr.length;
                    int[] iArr2 = new int[(zzb6 + length4)];
                    if (length4 != 0) {
                        System.arraycopy(this.zzayl, 0, iArr2, 0, length4);
                    }
                    while (length4 < iArr2.length - 1) {
                        iArr2[length4] = zzxz.zzvb();
                        zzxz.zzuj();
                        length4++;
                    }
                    iArr2[length4] = zzxz.zzvb();
                    this.zzayl = iArr2;
                    break;
                case 362:
                    int zzas = zzxz.zzas(zzxz.zzvb());
                    int position = zzxz.getPosition();
                    int i = 0;
                    while (zzxz.zzyy() > 0) {
                        zzxz.zzvb();
                        i++;
                    }
                    zzxz.zzcb(position);
                    int[] iArr3 = this.zzayl;
                    int length5 = iArr3 == null ? 0 : iArr3.length;
                    int[] iArr4 = new int[(i + length5)];
                    if (length5 != 0) {
                        System.arraycopy(this.zzayl, 0, iArr4, 0, length5);
                    }
                    while (length5 < iArr4.length) {
                        iArr4[length5] = zzxz.zzvb();
                        length5++;
                    }
                    this.zzayl = iArr4;
                    zzxz.zzat(zzas);
                    break;
                case 368:
                    this.zzaym = Long.valueOf(zzxz.zzvc());
                    break;
                default:
                    if (super.zza(zzxz, zzuj)) {
                        break;
                    } else {
                        return this;
                    }
            }
        }
    }
}
