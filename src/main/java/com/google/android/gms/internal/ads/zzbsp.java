package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

final class zzbsp<T> implements zzbtc<T> {
    private static final int[] zzfsg = new int[0];
    private static final Unsafe zzfsh = zzbua.zzape();
    private final int[] zzfsi;
    private final Object[] zzfsj;
    private final int zzfsk;
    private final int zzfsl;
    private final zzbsl zzfsm;
    private final boolean zzfsn;
    private final boolean zzfso;
    private final boolean zzfsp;
    private final boolean zzfsq;
    private final int[] zzfsr;
    private final int zzfss;
    private final int zzfst;
    private final zzbst zzfsu;
    private final zzbrv zzfsv;
    private final zzbtu<?, ?> zzfsw;
    private final zzbqr<?> zzfsx;
    private final zzbsg zzfsy;

    private zzbsp(int[] iArr, Object[] objArr, int i, int i2, zzbsl zzbsl, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzbst zzbst, zzbrv zzbrv, zzbtu<?, ?> zzbtu, zzbqr<?> zzbqr, zzbsg zzbsg) {
        this.zzfsi = iArr;
        this.zzfsj = objArr;
        this.zzfsk = i;
        this.zzfsl = i2;
        this.zzfso = zzbsl instanceof zzbrd;
        this.zzfsp = z;
        this.zzfsn = zzbqr != null && zzbqr.zzh(zzbsl);
        this.zzfsq = false;
        this.zzfsr = iArr2;
        this.zzfss = i3;
        this.zzfst = i4;
        this.zzfsu = zzbst;
        this.zzfsv = zzbrv;
        this.zzfsw = zzbtu;
        this.zzfsx = zzbqr;
        this.zzfsm = zzbsl;
        this.zzfsy = zzbsg;
    }

    private static boolean zzfv(int i) {
        return (i & 536870912) != 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:132:0x02c0  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x02c4  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x02dc  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x02df  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x03c5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> com.google.android.gms.internal.ads.zzbsp<T> zza(java.lang.Class<T> r33, com.google.android.gms.internal.ads.zzbsj r34, com.google.android.gms.internal.ads.zzbst r35, com.google.android.gms.internal.ads.zzbrv r36, com.google.android.gms.internal.ads.zzbtu<?, ?> r37, com.google.android.gms.internal.ads.zzbqr<?> r38, com.google.android.gms.internal.ads.zzbsg r39) {
        /*
        // Method dump skipped, instructions count: 1190
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbsp.zza(java.lang.Class, com.google.android.gms.internal.ads.zzbsj, com.google.android.gms.internal.ads.zzbst, com.google.android.gms.internal.ads.zzbrv, com.google.android.gms.internal.ads.zzbtu, com.google.android.gms.internal.ads.zzbqr, com.google.android.gms.internal.ads.zzbsg):com.google.android.gms.internal.ads.zzbsp");
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final T newInstance() {
        return (T) this.zzfsu.newInstance(this.zzfsm);
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final boolean equals(T t, T t2) {
        int length = this.zzfsi.length;
        int i = 0;
        while (true) {
            boolean z = true;
            if (i < length) {
                int zzft = zzft(i);
                long j = (long) (zzft & 1048575);
                switch ((zzft & 267386880) >>> 20) {
                    case 0:
                        if (!zzc(t, t2, i) || zzbua.zzl(t, j) != zzbua.zzl(t2, j)) {
                            z = false;
                            break;
                        }
                    case 1:
                        if (!zzc(t, t2, i) || zzbua.zzk(t, j) != zzbua.zzk(t2, j)) {
                            z = false;
                            break;
                        }
                    case 2:
                        if (!zzc(t, t2, i) || zzbua.zzl(t, j) != zzbua.zzl(t2, j)) {
                            z = false;
                            break;
                        }
                    case 3:
                        if (!zzc(t, t2, i) || zzbua.zzl(t, j) != zzbua.zzl(t2, j)) {
                            z = false;
                            break;
                        }
                    case 4:
                        if (!zzc(t, t2, i) || zzbua.zzk(t, j) != zzbua.zzk(t2, j)) {
                            z = false;
                            break;
                        }
                    case 5:
                        if (!zzc(t, t2, i) || zzbua.zzl(t, j) != zzbua.zzl(t2, j)) {
                            z = false;
                            break;
                        }
                    case 6:
                        if (!zzc(t, t2, i) || zzbua.zzk(t, j) != zzbua.zzk(t2, j)) {
                            z = false;
                            break;
                        }
                    case 7:
                        if (!zzc(t, t2, i) || zzbua.zzm(t, j) != zzbua.zzm(t2, j)) {
                            z = false;
                            break;
                        }
                    case 8:
                        if (!zzc(t, t2, i) || !zzbte.zze(zzbua.zzp(t, j), zzbua.zzp(t2, j))) {
                            z = false;
                            break;
                        }
                    case 9:
                        if (!zzc(t, t2, i) || !zzbte.zze(zzbua.zzp(t, j), zzbua.zzp(t2, j))) {
                            z = false;
                            break;
                        }
                    case 10:
                        if (!zzc(t, t2, i) || !zzbte.zze(zzbua.zzp(t, j), zzbua.zzp(t2, j))) {
                            z = false;
                            break;
                        }
                    case 11:
                        if (!zzc(t, t2, i) || zzbua.zzk(t, j) != zzbua.zzk(t2, j)) {
                            z = false;
                            break;
                        }
                    case 12:
                        if (!zzc(t, t2, i) || zzbua.zzk(t, j) != zzbua.zzk(t2, j)) {
                            z = false;
                            break;
                        }
                    case 13:
                        if (!zzc(t, t2, i) || zzbua.zzk(t, j) != zzbua.zzk(t2, j)) {
                            z = false;
                            break;
                        }
                    case 14:
                        if (!zzc(t, t2, i) || zzbua.zzl(t, j) != zzbua.zzl(t2, j)) {
                            z = false;
                            break;
                        }
                    case 15:
                        if (!zzc(t, t2, i) || zzbua.zzk(t, j) != zzbua.zzk(t2, j)) {
                            z = false;
                            break;
                        }
                    case 16:
                        if (!zzc(t, t2, i) || zzbua.zzl(t, j) != zzbua.zzl(t2, j)) {
                            z = false;
                            break;
                        }
                    case 17:
                        if (!zzc(t, t2, i) || !zzbte.zze(zzbua.zzp(t, j), zzbua.zzp(t2, j))) {
                            z = false;
                            break;
                        }
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        z = zzbte.zze(zzbua.zzp(t, j), zzbua.zzp(t2, j));
                        break;
                    case 50:
                        z = zzbte.zze(zzbua.zzp(t, j), zzbua.zzp(t2, j));
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                        long zzfu = (long) (zzfu(i) & 1048575);
                        if (zzbua.zzk(t, zzfu) != zzbua.zzk(t2, zzfu) || !zzbte.zze(zzbua.zzp(t, j), zzbua.zzp(t2, j))) {
                            z = false;
                            break;
                        }
                }
                if (!z) {
                    return false;
                }
                i += 3;
            } else if (!this.zzfsw.zzag(t).equals(this.zzfsw.zzag(t2))) {
                return false;
            } else {
                if (this.zzfsn) {
                    return this.zzfsx.zzq(t).equals(this.zzfsx.zzq(t2));
                }
                return true;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final int hashCode(T t) {
        int length = this.zzfsi.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int zzft = zzft(i2);
            int i3 = this.zzfsi[i2];
            long j = (long) (1048575 & zzft);
            int i4 = 37;
            switch ((zzft & 267386880) >>> 20) {
                case 0:
                    i = (i * 53) + zzbrf.zzbi(Double.doubleToLongBits(zzbua.zzo(t, j)));
                    break;
                case 1:
                    i = (i * 53) + Float.floatToIntBits(zzbua.zzn(t, j));
                    break;
                case 2:
                    i = (i * 53) + zzbrf.zzbi(zzbua.zzl(t, j));
                    break;
                case 3:
                    i = (i * 53) + zzbrf.zzbi(zzbua.zzl(t, j));
                    break;
                case 4:
                    i = (i * 53) + zzbua.zzk(t, j);
                    break;
                case 5:
                    i = (i * 53) + zzbrf.zzbi(zzbua.zzl(t, j));
                    break;
                case 6:
                    i = (i * 53) + zzbua.zzk(t, j);
                    break;
                case 7:
                    i = (i * 53) + zzbrf.zzbf(zzbua.zzm(t, j));
                    break;
                case 8:
                    i = (i * 53) + ((String) zzbua.zzp(t, j)).hashCode();
                    break;
                case 9:
                    Object zzp = zzbua.zzp(t, j);
                    if (zzp != null) {
                        i4 = zzp.hashCode();
                    }
                    i = (i * 53) + i4;
                    break;
                case 10:
                    i = (i * 53) + zzbua.zzp(t, j).hashCode();
                    break;
                case 11:
                    i = (i * 53) + zzbua.zzk(t, j);
                    break;
                case 12:
                    i = (i * 53) + zzbua.zzk(t, j);
                    break;
                case 13:
                    i = (i * 53) + zzbua.zzk(t, j);
                    break;
                case 14:
                    i = (i * 53) + zzbrf.zzbi(zzbua.zzl(t, j));
                    break;
                case 15:
                    i = (i * 53) + zzbua.zzk(t, j);
                    break;
                case 16:
                    i = (i * 53) + zzbrf.zzbi(zzbua.zzl(t, j));
                    break;
                case 17:
                    Object zzp2 = zzbua.zzp(t, j);
                    if (zzp2 != null) {
                        i4 = zzp2.hashCode();
                    }
                    i = (i * 53) + i4;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = (i * 53) + zzbua.zzp(t, j).hashCode();
                    break;
                case 50:
                    i = (i * 53) + zzbua.zzp(t, j).hashCode();
                    break;
                case 51:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + zzbrf.zzbi(Double.doubleToLongBits(zzf(t, j)));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + Float.floatToIntBits(zzg(t, j));
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + zzbrf.zzbi(zzi(t, j));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + zzbrf.zzbi(zzi(t, j));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + zzh(t, j);
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + zzbrf.zzbi(zzi(t, j));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + zzh(t, j);
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + zzbrf.zzbf(zzj(t, j));
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + ((String) zzbua.zzp(t, j)).hashCode();
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + zzbua.zzp(t, j).hashCode();
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + zzbua.zzp(t, j).hashCode();
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + zzh(t, j);
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + zzh(t, j);
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + zzh(t, j);
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + zzbrf.zzbi(zzi(t, j));
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + zzh(t, j);
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + zzbrf.zzbi(zzi(t, j));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + zzbua.zzp(t, j).hashCode();
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i * 53) + this.zzfsw.zzag(t).hashCode();
        return this.zzfsn ? (hashCode * 53) + this.zzfsx.zzq(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void zzd(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.zzfsi.length; i += 3) {
                int zzft = zzft(i);
                long j = (long) (1048575 & zzft);
                int i2 = this.zzfsi[i];
                switch ((zzft & 267386880) >>> 20) {
                    case 0:
                        if (zzd(t2, i)) {
                            zzbua.zza(t, j, zzbua.zzo(t2, j));
                            zze((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zzd(t2, i)) {
                            zzbua.zza((Object) t, j, zzbua.zzn(t2, j));
                            zze((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (zzd(t2, i)) {
                            zzbua.zza((Object) t, j, zzbua.zzl(t2, j));
                            zze((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (zzd(t2, i)) {
                            zzbua.zza((Object) t, j, zzbua.zzl(t2, j));
                            zze((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (zzd(t2, i)) {
                            zzbua.zzb(t, j, zzbua.zzk(t2, j));
                            zze((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (zzd(t2, i)) {
                            zzbua.zza((Object) t, j, zzbua.zzl(t2, j));
                            zze((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (zzd(t2, i)) {
                            zzbua.zzb(t, j, zzbua.zzk(t2, j));
                            zze((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (zzd(t2, i)) {
                            zzbua.zza(t, j, zzbua.zzm(t2, j));
                            zze((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (zzd(t2, i)) {
                            zzbua.zza(t, j, zzbua.zzp(t2, j));
                            zze((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        zza(t, t2, i);
                        break;
                    case 10:
                        if (zzd(t2, i)) {
                            zzbua.zza(t, j, zzbua.zzp(t2, j));
                            zze((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (zzd(t2, i)) {
                            zzbua.zzb(t, j, zzbua.zzk(t2, j));
                            zze((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (zzd(t2, i)) {
                            zzbua.zzb(t, j, zzbua.zzk(t2, j));
                            zze((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (zzd(t2, i)) {
                            zzbua.zzb(t, j, zzbua.zzk(t2, j));
                            zze((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (zzd(t2, i)) {
                            zzbua.zza((Object) t, j, zzbua.zzl(t2, j));
                            zze((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (zzd(t2, i)) {
                            zzbua.zzb(t, j, zzbua.zzk(t2, j));
                            zze((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (zzd(t2, i)) {
                            zzbua.zza((Object) t, j, zzbua.zzl(t2, j));
                            zze((Object) t, i);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        zza(t, t2, i);
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        this.zzfsv.zza(t, t2, j);
                        break;
                    case 50:
                        zzbte.zza(this.zzfsy, t, t2, j);
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        if (zza(t2, i2, i)) {
                            zzbua.zza(t, j, zzbua.zzp(t2, j));
                            zzb(t, i2, i);
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        zzb(t, t2, i);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (zza(t2, i2, i)) {
                            zzbua.zza(t, j, zzbua.zzp(t2, j));
                            zzb(t, i2, i);
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        zzb(t, t2, i);
                        break;
                }
            }
            if (!this.zzfsp) {
                zzbte.zza(this.zzfsw, t, t2);
                if (this.zzfsn) {
                    zzbte.zza(this.zzfsx, t, t2);
                    return;
                }
                return;
            }
            return;
        }
        throw new NullPointerException();
    }

    private final void zza(T t, T t2, int i) {
        long zzft = (long) (zzft(i) & 1048575);
        if (zzd(t2, i)) {
            Object zzp = zzbua.zzp(t, zzft);
            Object zzp2 = zzbua.zzp(t2, zzft);
            if (zzp != null && zzp2 != null) {
                zzbua.zza(t, zzft, zzbrf.zzb(zzp, zzp2));
                zze((Object) t, i);
            } else if (zzp2 != null) {
                zzbua.zza(t, zzft, zzp2);
                zze((Object) t, i);
            }
        }
    }

    private final void zzb(T t, T t2, int i) {
        int zzft = zzft(i);
        int i2 = this.zzfsi[i];
        long j = (long) (zzft & 1048575);
        if (zza(t2, i2, i)) {
            Object zzp = zzbua.zzp(t, j);
            Object zzp2 = zzbua.zzp(t2, j);
            if (zzp != null && zzp2 != null) {
                zzbua.zza(t, j, zzbrf.zzb(zzp, zzp2));
                zzb(t, i2, i);
            } else if (zzp2 != null) {
                zzbua.zza(t, j, zzp2);
                zzb(t, i2, i);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final int zzac(T t) {
        int i;
        int i2;
        long j;
        int i3 = 267386880;
        if (this.zzfsp) {
            Unsafe unsafe = zzfsh;
            int i4 = 0;
            int i5 = 0;
            while (i4 < this.zzfsi.length) {
                int zzft = zzft(i4);
                int i6 = (zzft & i3) >>> 20;
                int i7 = this.zzfsi[i4];
                long j2 = (long) (zzft & 1048575);
                int i8 = (i6 < zzbqx.DOUBLE_LIST_PACKED.id() || i6 > zzbqx.SINT64_LIST_PACKED.id()) ? 0 : this.zzfsi[i4 + 2] & 1048575;
                switch (i6) {
                    case 0:
                        if (zzd(t, i4)) {
                            i5 += zzbqk.zzc(i7, 0.0d);
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zzd(t, i4)) {
                            i5 += zzbqk.zzb(i7, 0.0f);
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (zzd(t, i4)) {
                            i5 += zzbqk.zzm(i7, zzbua.zzl(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (zzd(t, i4)) {
                            i5 += zzbqk.zzn(i7, zzbua.zzl(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (zzd(t, i4)) {
                            i5 += zzbqk.zzz(i7, zzbua.zzk(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (zzd(t, i4)) {
                            i5 += zzbqk.zzp(i7, 0);
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (zzd(t, i4)) {
                            i5 += zzbqk.zzac(i7, 0);
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (zzd(t, i4)) {
                            i5 += zzbqk.zzk(i7, true);
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (zzd(t, i4)) {
                            Object zzp = zzbua.zzp(t, j2);
                            if (zzp instanceof zzbpu) {
                                i5 += zzbqk.zzc(i7, (zzbpu) zzp);
                                break;
                            } else {
                                i5 += zzbqk.zzg(i7, (String) zzp);
                                break;
                            }
                        } else {
                            break;
                        }
                    case 9:
                        if (zzd(t, i4)) {
                            i5 += zzbte.zzc(i7, zzbua.zzp(t, j2), zzfq(i4));
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (zzd(t, i4)) {
                            i5 += zzbqk.zzc(i7, (zzbpu) zzbua.zzp(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (zzd(t, i4)) {
                            i5 += zzbqk.zzaa(i7, zzbua.zzk(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (zzd(t, i4)) {
                            i5 += zzbqk.zzae(i7, zzbua.zzk(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (zzd(t, i4)) {
                            i5 += zzbqk.zzad(i7, 0);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (zzd(t, i4)) {
                            i5 += zzbqk.zzq(i7, 0);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (zzd(t, i4)) {
                            i5 += zzbqk.zzab(i7, zzbua.zzk(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (zzd(t, i4)) {
                            i5 += zzbqk.zzo(i7, zzbua.zzl(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (zzd(t, i4)) {
                            i5 += zzbqk.zzc(i7, (zzbsl) zzbua.zzp(t, j2), zzfq(i4));
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        i5 += zzbte.zzw(i7, zze(t, j2), false);
                        break;
                    case 19:
                        i5 += zzbte.zzv(i7, zze(t, j2), false);
                        break;
                    case 20:
                        i5 += zzbte.zzo(i7, zze(t, j2), false);
                        break;
                    case 21:
                        i5 += zzbte.zzp(i7, zze(t, j2), false);
                        break;
                    case 22:
                        i5 += zzbte.zzs(i7, zze(t, j2), false);
                        break;
                    case 23:
                        i5 += zzbte.zzw(i7, zze(t, j2), false);
                        break;
                    case 24:
                        i5 += zzbte.zzv(i7, zze(t, j2), false);
                        break;
                    case 25:
                        i5 += zzbte.zzx(i7, zze(t, j2), false);
                        break;
                    case 26:
                        i5 += zzbte.zzc(i7, zze(t, j2));
                        break;
                    case 27:
                        i5 += zzbte.zzc(i7, (List<?>) zze(t, j2), zzfq(i4));
                        break;
                    case 28:
                        i5 += zzbte.zzd(i7, zze(t, j2));
                        break;
                    case 29:
                        i5 += zzbte.zzt(i7, zze(t, j2), false);
                        break;
                    case 30:
                        i5 += zzbte.zzr(i7, zze(t, j2), false);
                        break;
                    case 31:
                        i5 += zzbte.zzv(i7, zze(t, j2), false);
                        break;
                    case 32:
                        i5 += zzbte.zzw(i7, zze(t, j2), false);
                        break;
                    case 33:
                        i5 += zzbte.zzu(i7, zze(t, j2), false);
                        break;
                    case 34:
                        i5 += zzbte.zzq(i7, zze(t, j2), false);
                        break;
                    case 35:
                        int zzan = zzbte.zzan((List) unsafe.getObject(t, j2));
                        if (zzan <= 0) {
                            break;
                        } else {
                            if (this.zzfsq) {
                                unsafe.putInt(t, (long) i8, zzan);
                            }
                            i5 += zzbqk.zzfd(i7) + zzbqk.zzff(zzan) + zzan;
                            break;
                        }
                    case 36:
                        int zzam = zzbte.zzam((List) unsafe.getObject(t, j2));
                        if (zzam <= 0) {
                            break;
                        } else {
                            if (this.zzfsq) {
                                unsafe.putInt(t, (long) i8, zzam);
                            }
                            i5 += zzbqk.zzfd(i7) + zzbqk.zzff(zzam) + zzam;
                            break;
                        }
                    case 37:
                        int zzaf = zzbte.zzaf((List) unsafe.getObject(t, j2));
                        if (zzaf <= 0) {
                            break;
                        } else {
                            if (this.zzfsq) {
                                unsafe.putInt(t, (long) i8, zzaf);
                            }
                            i5 += zzbqk.zzfd(i7) + zzbqk.zzff(zzaf) + zzaf;
                            break;
                        }
                    case 38:
                        int zzag = zzbte.zzag((List) unsafe.getObject(t, j2));
                        if (zzag <= 0) {
                            break;
                        } else {
                            if (this.zzfsq) {
                                unsafe.putInt(t, (long) i8, zzag);
                            }
                            i5 += zzbqk.zzfd(i7) + zzbqk.zzff(zzag) + zzag;
                            break;
                        }
                    case 39:
                        int zzaj = zzbte.zzaj((List) unsafe.getObject(t, j2));
                        if (zzaj <= 0) {
                            break;
                        } else {
                            if (this.zzfsq) {
                                unsafe.putInt(t, (long) i8, zzaj);
                            }
                            i5 += zzbqk.zzfd(i7) + zzbqk.zzff(zzaj) + zzaj;
                            break;
                        }
                    case 40:
                        int zzan2 = zzbte.zzan((List) unsafe.getObject(t, j2));
                        if (zzan2 <= 0) {
                            break;
                        } else {
                            if (this.zzfsq) {
                                unsafe.putInt(t, (long) i8, zzan2);
                            }
                            i5 += zzbqk.zzfd(i7) + zzbqk.zzff(zzan2) + zzan2;
                            break;
                        }
                    case 41:
                        int zzam2 = zzbte.zzam((List) unsafe.getObject(t, j2));
                        if (zzam2 <= 0) {
                            break;
                        } else {
                            if (this.zzfsq) {
                                unsafe.putInt(t, (long) i8, zzam2);
                            }
                            i5 += zzbqk.zzfd(i7) + zzbqk.zzff(zzam2) + zzam2;
                            break;
                        }
                    case 42:
                        int zzao = zzbte.zzao((List) unsafe.getObject(t, j2));
                        if (zzao <= 0) {
                            break;
                        } else {
                            if (this.zzfsq) {
                                unsafe.putInt(t, (long) i8, zzao);
                            }
                            i5 += zzbqk.zzfd(i7) + zzbqk.zzff(zzao) + zzao;
                            break;
                        }
                    case 43:
                        int zzak = zzbte.zzak((List) unsafe.getObject(t, j2));
                        if (zzak <= 0) {
                            break;
                        } else {
                            if (this.zzfsq) {
                                unsafe.putInt(t, (long) i8, zzak);
                            }
                            i5 += zzbqk.zzfd(i7) + zzbqk.zzff(zzak) + zzak;
                            break;
                        }
                    case 44:
                        int zzai = zzbte.zzai((List) unsafe.getObject(t, j2));
                        if (zzai <= 0) {
                            break;
                        } else {
                            if (this.zzfsq) {
                                unsafe.putInt(t, (long) i8, zzai);
                            }
                            i5 += zzbqk.zzfd(i7) + zzbqk.zzff(zzai) + zzai;
                            break;
                        }
                    case 45:
                        int zzam3 = zzbte.zzam((List) unsafe.getObject(t, j2));
                        if (zzam3 <= 0) {
                            break;
                        } else {
                            if (this.zzfsq) {
                                unsafe.putInt(t, (long) i8, zzam3);
                            }
                            i5 += zzbqk.zzfd(i7) + zzbqk.zzff(zzam3) + zzam3;
                            break;
                        }
                    case 46:
                        int zzan3 = zzbte.zzan((List) unsafe.getObject(t, j2));
                        if (zzan3 <= 0) {
                            break;
                        } else {
                            if (this.zzfsq) {
                                unsafe.putInt(t, (long) i8, zzan3);
                            }
                            i5 += zzbqk.zzfd(i7) + zzbqk.zzff(zzan3) + zzan3;
                            break;
                        }
                    case 47:
                        int zzal = zzbte.zzal((List) unsafe.getObject(t, j2));
                        if (zzal <= 0) {
                            break;
                        } else {
                            if (this.zzfsq) {
                                unsafe.putInt(t, (long) i8, zzal);
                            }
                            i5 += zzbqk.zzfd(i7) + zzbqk.zzff(zzal) + zzal;
                            break;
                        }
                    case 48:
                        int zzah = zzbte.zzah((List) unsafe.getObject(t, j2));
                        if (zzah <= 0) {
                            break;
                        } else {
                            if (this.zzfsq) {
                                unsafe.putInt(t, (long) i8, zzah);
                            }
                            i5 += zzbqk.zzfd(i7) + zzbqk.zzff(zzah) + zzah;
                            break;
                        }
                    case 49:
                        i5 += zzbte.zzd(i7, zze(t, j2), zzfq(i4));
                        break;
                    case 50:
                        i5 += this.zzfsy.zzb(i7, zzbua.zzp(t, j2), zzfr(i4));
                        break;
                    case 51:
                        if (zza(t, i7, i4)) {
                            i5 += zzbqk.zzc(i7, 0.0d);
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (zza(t, i7, i4)) {
                            i5 += zzbqk.zzb(i7, 0.0f);
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (zza(t, i7, i4)) {
                            i5 += zzbqk.zzm(i7, zzi(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (zza(t, i7, i4)) {
                            i5 += zzbqk.zzn(i7, zzi(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (zza(t, i7, i4)) {
                            i5 += zzbqk.zzz(i7, zzh(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (zza(t, i7, i4)) {
                            i5 += zzbqk.zzp(i7, 0);
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (zza(t, i7, i4)) {
                            i5 += zzbqk.zzac(i7, 0);
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (zza(t, i7, i4)) {
                            i5 += zzbqk.zzk(i7, true);
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (zza(t, i7, i4)) {
                            Object zzp2 = zzbua.zzp(t, j2);
                            if (zzp2 instanceof zzbpu) {
                                i5 += zzbqk.zzc(i7, (zzbpu) zzp2);
                                break;
                            } else {
                                i5 += zzbqk.zzg(i7, (String) zzp2);
                                break;
                            }
                        } else {
                            break;
                        }
                    case 60:
                        if (zza(t, i7, i4)) {
                            i5 += zzbte.zzc(i7, zzbua.zzp(t, j2), zzfq(i4));
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (zza(t, i7, i4)) {
                            i5 += zzbqk.zzc(i7, (zzbpu) zzbua.zzp(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (zza(t, i7, i4)) {
                            i5 += zzbqk.zzaa(i7, zzh(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (zza(t, i7, i4)) {
                            i5 += zzbqk.zzae(i7, zzh(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (zza(t, i7, i4)) {
                            i5 += zzbqk.zzad(i7, 0);
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (zza(t, i7, i4)) {
                            i5 += zzbqk.zzq(i7, 0);
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (zza(t, i7, i4)) {
                            i5 += zzbqk.zzab(i7, zzh(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (zza(t, i7, i4)) {
                            i5 += zzbqk.zzo(i7, zzi(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (zza(t, i7, i4)) {
                            i5 += zzbqk.zzc(i7, (zzbsl) zzbua.zzp(t, j2), zzfq(i4));
                            break;
                        } else {
                            break;
                        }
                }
                i4 += 3;
                i3 = 267386880;
            }
            return i5 + zza((zzbtu) this.zzfsw, (Object) t);
        }
        Unsafe unsafe2 = zzfsh;
        int i9 = 0;
        int i10 = -1;
        int i11 = 0;
        for (int i12 = 0; i12 < this.zzfsi.length; i12 += 3) {
            int zzft2 = zzft(i12);
            int[] iArr = this.zzfsi;
            int i13 = iArr[i12];
            int i14 = (zzft2 & 267386880) >>> 20;
            if (i14 <= 17) {
                i2 = iArr[i12 + 2];
                int i15 = i2 & 1048575;
                i = 1 << (i2 >>> 20);
                if (i15 != i10) {
                    i11 = unsafe2.getInt(t, (long) i15);
                } else {
                    i15 = i10;
                }
                i10 = i15;
            } else if (!this.zzfsq || i14 < zzbqx.DOUBLE_LIST_PACKED.id() || i14 > zzbqx.SINT64_LIST_PACKED.id()) {
                i2 = 0;
                i = 0;
            } else {
                i2 = this.zzfsi[i12 + 2] & 1048575;
                i = 0;
            }
            long j3 = (long) (zzft2 & 1048575);
            switch (i14) {
                case 0:
                    j = 0;
                    if ((i11 & i) != 0) {
                        i9 += zzbqk.zzc(i13, 0.0d);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    j = 0;
                    if ((i11 & i) != 0) {
                        i9 += zzbqk.zzb(i13, 0.0f);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    j = 0;
                    if ((i11 & i) != 0) {
                        i9 += zzbqk.zzm(i13, unsafe2.getLong(t, j3));
                        break;
                    } else {
                        break;
                    }
                case 3:
                    j = 0;
                    if ((i11 & i) != 0) {
                        i9 += zzbqk.zzn(i13, unsafe2.getLong(t, j3));
                        break;
                    } else {
                        break;
                    }
                case 4:
                    j = 0;
                    if ((i11 & i) != 0) {
                        i9 += zzbqk.zzz(i13, unsafe2.getInt(t, j3));
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if ((i11 & i) != 0) {
                        j = 0;
                        i9 += zzbqk.zzp(i13, 0);
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 6:
                    if ((i11 & i) != 0) {
                        i9 += zzbqk.zzac(i13, 0);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 7:
                    if ((i11 & i) != 0) {
                        i9 += zzbqk.zzk(i13, true);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 8:
                    if ((i11 & i) != 0) {
                        Object object = unsafe2.getObject(t, j3);
                        if (object instanceof zzbpu) {
                            i9 += zzbqk.zzc(i13, (zzbpu) object);
                            j = 0;
                            break;
                        } else {
                            i9 += zzbqk.zzg(i13, (String) object);
                            j = 0;
                            break;
                        }
                    } else {
                        j = 0;
                        break;
                    }
                case 9:
                    if ((i11 & i) != 0) {
                        i9 += zzbte.zzc(i13, unsafe2.getObject(t, j3), zzfq(i12));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 10:
                    if ((i11 & i) != 0) {
                        i9 += zzbqk.zzc(i13, (zzbpu) unsafe2.getObject(t, j3));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 11:
                    if ((i11 & i) != 0) {
                        i9 += zzbqk.zzaa(i13, unsafe2.getInt(t, j3));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 12:
                    if ((i11 & i) != 0) {
                        i9 += zzbqk.zzae(i13, unsafe2.getInt(t, j3));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 13:
                    if ((i11 & i) != 0) {
                        i9 += zzbqk.zzad(i13, 0);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 14:
                    if ((i11 & i) != 0) {
                        i9 += zzbqk.zzq(i13, 0);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 15:
                    if ((i11 & i) != 0) {
                        i9 += zzbqk.zzab(i13, unsafe2.getInt(t, j3));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 16:
                    if ((i11 & i) != 0) {
                        i9 += zzbqk.zzo(i13, unsafe2.getLong(t, j3));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 17:
                    if ((i11 & i) != 0) {
                        i9 += zzbqk.zzc(i13, (zzbsl) unsafe2.getObject(t, j3), zzfq(i12));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 18:
                    i9 += zzbte.zzw(i13, (List) unsafe2.getObject(t, j3), false);
                    j = 0;
                    break;
                case 19:
                    i9 += zzbte.zzv(i13, (List) unsafe2.getObject(t, j3), false);
                    j = 0;
                    break;
                case 20:
                    i9 += zzbte.zzo(i13, (List) unsafe2.getObject(t, j3), false);
                    j = 0;
                    break;
                case 21:
                    i9 += zzbte.zzp(i13, (List) unsafe2.getObject(t, j3), false);
                    j = 0;
                    break;
                case 22:
                    i9 += zzbte.zzs(i13, (List) unsafe2.getObject(t, j3), false);
                    j = 0;
                    break;
                case 23:
                    i9 += zzbte.zzw(i13, (List) unsafe2.getObject(t, j3), false);
                    j = 0;
                    break;
                case 24:
                    i9 += zzbte.zzv(i13, (List) unsafe2.getObject(t, j3), false);
                    j = 0;
                    break;
                case 25:
                    i9 += zzbte.zzx(i13, (List) unsafe2.getObject(t, j3), false);
                    j = 0;
                    break;
                case 26:
                    i9 += zzbte.zzc(i13, (List) unsafe2.getObject(t, j3));
                    j = 0;
                    break;
                case 27:
                    i9 += zzbte.zzc(i13, (List<?>) ((List) unsafe2.getObject(t, j3)), zzfq(i12));
                    j = 0;
                    break;
                case 28:
                    i9 += zzbte.zzd(i13, (List) unsafe2.getObject(t, j3));
                    j = 0;
                    break;
                case 29:
                    i9 += zzbte.zzt(i13, (List) unsafe2.getObject(t, j3), false);
                    j = 0;
                    break;
                case 30:
                    i9 += zzbte.zzr(i13, (List) unsafe2.getObject(t, j3), false);
                    j = 0;
                    break;
                case 31:
                    i9 += zzbte.zzv(i13, (List) unsafe2.getObject(t, j3), false);
                    j = 0;
                    break;
                case 32:
                    i9 += zzbte.zzw(i13, (List) unsafe2.getObject(t, j3), false);
                    j = 0;
                    break;
                case 33:
                    i9 += zzbte.zzu(i13, (List) unsafe2.getObject(t, j3), false);
                    j = 0;
                    break;
                case 34:
                    i9 += zzbte.zzq(i13, (List) unsafe2.getObject(t, j3), false);
                    j = 0;
                    break;
                case 35:
                    int zzan4 = zzbte.zzan((List) unsafe2.getObject(t, j3));
                    if (zzan4 > 0) {
                        if (this.zzfsq) {
                            unsafe2.putInt(t, (long) i2, zzan4);
                        }
                        i9 += zzbqk.zzfd(i13) + zzbqk.zzff(zzan4) + zzan4;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 36:
                    int zzam4 = zzbte.zzam((List) unsafe2.getObject(t, j3));
                    if (zzam4 > 0) {
                        if (this.zzfsq) {
                            unsafe2.putInt(t, (long) i2, zzam4);
                        }
                        i9 += zzbqk.zzfd(i13) + zzbqk.zzff(zzam4) + zzam4;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 37:
                    int zzaf2 = zzbte.zzaf((List) unsafe2.getObject(t, j3));
                    if (zzaf2 > 0) {
                        if (this.zzfsq) {
                            unsafe2.putInt(t, (long) i2, zzaf2);
                        }
                        i9 += zzbqk.zzfd(i13) + zzbqk.zzff(zzaf2) + zzaf2;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 38:
                    int zzag2 = zzbte.zzag((List) unsafe2.getObject(t, j3));
                    if (zzag2 > 0) {
                        if (this.zzfsq) {
                            unsafe2.putInt(t, (long) i2, zzag2);
                        }
                        i9 += zzbqk.zzfd(i13) + zzbqk.zzff(zzag2) + zzag2;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 39:
                    int zzaj2 = zzbte.zzaj((List) unsafe2.getObject(t, j3));
                    if (zzaj2 > 0) {
                        if (this.zzfsq) {
                            unsafe2.putInt(t, (long) i2, zzaj2);
                        }
                        i9 += zzbqk.zzfd(i13) + zzbqk.zzff(zzaj2) + zzaj2;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 40:
                    int zzan5 = zzbte.zzan((List) unsafe2.getObject(t, j3));
                    if (zzan5 > 0) {
                        if (this.zzfsq) {
                            unsafe2.putInt(t, (long) i2, zzan5);
                        }
                        i9 += zzbqk.zzfd(i13) + zzbqk.zzff(zzan5) + zzan5;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 41:
                    int zzam5 = zzbte.zzam((List) unsafe2.getObject(t, j3));
                    if (zzam5 > 0) {
                        if (this.zzfsq) {
                            unsafe2.putInt(t, (long) i2, zzam5);
                        }
                        i9 += zzbqk.zzfd(i13) + zzbqk.zzff(zzam5) + zzam5;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 42:
                    int zzao2 = zzbte.zzao((List) unsafe2.getObject(t, j3));
                    if (zzao2 > 0) {
                        if (this.zzfsq) {
                            unsafe2.putInt(t, (long) i2, zzao2);
                        }
                        i9 += zzbqk.zzfd(i13) + zzbqk.zzff(zzao2) + zzao2;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 43:
                    int zzak2 = zzbte.zzak((List) unsafe2.getObject(t, j3));
                    if (zzak2 > 0) {
                        if (this.zzfsq) {
                            unsafe2.putInt(t, (long) i2, zzak2);
                        }
                        i9 += zzbqk.zzfd(i13) + zzbqk.zzff(zzak2) + zzak2;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 44:
                    int zzai2 = zzbte.zzai((List) unsafe2.getObject(t, j3));
                    if (zzai2 > 0) {
                        if (this.zzfsq) {
                            unsafe2.putInt(t, (long) i2, zzai2);
                        }
                        i9 += zzbqk.zzfd(i13) + zzbqk.zzff(zzai2) + zzai2;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 45:
                    int zzam6 = zzbte.zzam((List) unsafe2.getObject(t, j3));
                    if (zzam6 > 0) {
                        if (this.zzfsq) {
                            unsafe2.putInt(t, (long) i2, zzam6);
                        }
                        i9 += zzbqk.zzfd(i13) + zzbqk.zzff(zzam6) + zzam6;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 46:
                    int zzan6 = zzbte.zzan((List) unsafe2.getObject(t, j3));
                    if (zzan6 > 0) {
                        if (this.zzfsq) {
                            unsafe2.putInt(t, (long) i2, zzan6);
                        }
                        i9 += zzbqk.zzfd(i13) + zzbqk.zzff(zzan6) + zzan6;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 47:
                    int zzal2 = zzbte.zzal((List) unsafe2.getObject(t, j3));
                    if (zzal2 > 0) {
                        if (this.zzfsq) {
                            unsafe2.putInt(t, (long) i2, zzal2);
                        }
                        i9 += zzbqk.zzfd(i13) + zzbqk.zzff(zzal2) + zzal2;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 48:
                    int zzah2 = zzbte.zzah((List) unsafe2.getObject(t, j3));
                    if (zzah2 > 0) {
                        if (this.zzfsq) {
                            unsafe2.putInt(t, (long) i2, zzah2);
                        }
                        i9 += zzbqk.zzfd(i13) + zzbqk.zzff(zzah2) + zzah2;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 49:
                    i9 += zzbte.zzd(i13, (List) unsafe2.getObject(t, j3), zzfq(i12));
                    j = 0;
                    break;
                case 50:
                    i9 += this.zzfsy.zzb(i13, unsafe2.getObject(t, j3), zzfr(i12));
                    j = 0;
                    break;
                case 51:
                    if (zza(t, i13, i12)) {
                        i9 += zzbqk.zzc(i13, 0.0d);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 52:
                    if (zza(t, i13, i12)) {
                        i9 += zzbqk.zzb(i13, 0.0f);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 53:
                    if (zza(t, i13, i12)) {
                        i9 += zzbqk.zzm(i13, zzi(t, j3));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 54:
                    if (zza(t, i13, i12)) {
                        i9 += zzbqk.zzn(i13, zzi(t, j3));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 55:
                    if (zza(t, i13, i12)) {
                        i9 += zzbqk.zzz(i13, zzh(t, j3));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 56:
                    if (zza(t, i13, i12)) {
                        i9 += zzbqk.zzp(i13, 0);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 57:
                    if (zza(t, i13, i12)) {
                        i9 += zzbqk.zzac(i13, 0);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 58:
                    if (zza(t, i13, i12)) {
                        i9 += zzbqk.zzk(i13, true);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 59:
                    if (zza(t, i13, i12)) {
                        Object object2 = unsafe2.getObject(t, j3);
                        if (object2 instanceof zzbpu) {
                            i9 += zzbqk.zzc(i13, (zzbpu) object2);
                            j = 0;
                            break;
                        } else {
                            i9 += zzbqk.zzg(i13, (String) object2);
                            j = 0;
                            break;
                        }
                    } else {
                        j = 0;
                        break;
                    }
                case 60:
                    if (zza(t, i13, i12)) {
                        i9 += zzbte.zzc(i13, unsafe2.getObject(t, j3), zzfq(i12));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 61:
                    if (zza(t, i13, i12)) {
                        i9 += zzbqk.zzc(i13, (zzbpu) unsafe2.getObject(t, j3));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 62:
                    if (zza(t, i13, i12)) {
                        i9 += zzbqk.zzaa(i13, zzh(t, j3));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 63:
                    if (zza(t, i13, i12)) {
                        i9 += zzbqk.zzae(i13, zzh(t, j3));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 64:
                    if (zza(t, i13, i12)) {
                        i9 += zzbqk.zzad(i13, 0);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 65:
                    if (zza(t, i13, i12)) {
                        i9 += zzbqk.zzq(i13, 0);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 66:
                    if (zza(t, i13, i12)) {
                        i9 += zzbqk.zzab(i13, zzh(t, j3));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 67:
                    if (zza(t, i13, i12)) {
                        i9 += zzbqk.zzo(i13, zzi(t, j3));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 68:
                    if (zza(t, i13, i12)) {
                        i9 += zzbqk.zzc(i13, (zzbsl) unsafe2.getObject(t, j3), zzfq(i12));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                default:
                    j = 0;
                    break;
            }
        }
        int zza = i9 + zza((zzbtu) this.zzfsw, (Object) t);
        return this.zzfsn ? zza + this.zzfsx.zzq(t).zzamj() : zza;
    }

    private static <UT, UB> int zza(zzbtu<UT, UB> zzbtu, T t) {
        return zzbtu.zzac(zzbtu.zzag(t));
    }

    private static <E> List<E> zze(Object obj, long j) {
        return (List) zzbua.zzp(obj, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0511  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x054f  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0a27  */
    @Override // com.google.android.gms.internal.ads.zzbtc
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.gms.internal.ads.zzbup r15) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 2914
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbsp.zza(java.lang.Object, com.google.android.gms.internal.ads.zzbup):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:190:0x051c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r19, com.google.android.gms.internal.ads.zzbup r20) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1476
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbsp.zzb(java.lang.Object, com.google.android.gms.internal.ads.zzbup):void");
    }

    private final <K, V> void zza(zzbup zzbup, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzbup.zza(i, this.zzfsy.zzab(zzfr(i2)), this.zzfsy.zzx(obj));
        }
    }

    private static <UT, UB> void zza(zzbtu<UT, UB> zzbtu, T t, zzbup zzbup) throws IOException {
        zzbtu.zza(zzbtu.zzag(t), zzbup);
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.nodes.InsnNode.isSame(InsnNode.java:303)
        	at jadx.core.dex.instructions.IndexInsnNode.isSame(IndexInsnNode.java:36)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void zza(T r13, com.google.android.gms.internal.ads.zzbtb r14, com.google.android.gms.internal.ads.zzbqq r15) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1652
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbsp.zza(java.lang.Object, com.google.android.gms.internal.ads.zzbtb, com.google.android.gms.internal.ads.zzbqq):void");
    }

    private static zzbtv zzad(Object obj) {
        zzbrd zzbrd = (zzbrd) obj;
        zzbtv zzbtv = zzbrd.zzfpu;
        if (zzbtv != zzbtv.zzaoz()) {
            return zzbtv;
        }
        zzbtv zzapa = zzbtv.zzapa();
        zzbrd.zzfpu = zzapa;
        return zzapa;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.google.android.gms.internal.ads.zzbtc */
    /* JADX WARN: Multi-variable type inference failed */
    private static int zza(zzbtc zzbtc, byte[] bArr, int i, int i2, zzbpr zzbpr) throws IOException {
        byte b;
        int i3;
        int i4 = i + 1;
        byte b2 = bArr[i];
        if (b2 < 0) {
            i3 = zzbpq.zza(b2, bArr, i4, zzbpr);
            b = zzbpr.zzfld;
        } else {
            i3 = i4;
            b = b2;
        }
        if (b < 0 || b > i2 - i3) {
            throw zzbrl.zzanc();
        }
        Object newInstance = zzbtc.newInstance();
        int i5 = (b == 1 ? 1 : 0) + i3;
        zzbtc.zza(newInstance, bArr, i3, i5, zzbpr);
        zzbtc.zzs(newInstance);
        zzbpr.zzflf = newInstance;
        return i5;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v1, resolved type: com.google.android.gms.internal.ads.zzbsp */
    /* JADX WARN: Multi-variable type inference failed */
    private static int zza(zzbtc zzbtc, byte[] bArr, int i, int i2, int i3, zzbpr zzbpr) throws IOException {
        zzbsp zzbsp = (zzbsp) zzbtc;
        Object newInstance = zzbsp.newInstance();
        int zza = zzbsp.zza(newInstance, bArr, i, i2, i3, zzbpr);
        zzbsp.zzs(newInstance);
        zzbpr.zzflf = newInstance;
        return zza;
    }

    private static int zza(zzbtc<?> zzbtc, int i, byte[] bArr, int i2, int i3, zzbrk<?> zzbrk, zzbpr zzbpr) throws IOException {
        int zza = zza((zzbtc) zzbtc, bArr, i2, i3, zzbpr);
        zzbrk.add(zzbpr.zzflf);
        while (zza < i3) {
            int zza2 = zzbpq.zza(bArr, zza, zzbpr);
            if (i != zzbpr.zzfld) {
                break;
            }
            zza = zza((zzbtc) zzbtc, bArr, zza2, i3, zzbpr);
            zzbrk.add(zzbpr.zzflf);
        }
        return zza;
    }

    private static int zza(byte[] bArr, int i, int i2, zzbuj zzbuj, Class<?> cls, zzbpr zzbpr) throws IOException {
        switch (zzbsq.zzfmd[zzbuj.ordinal()]) {
            case 1:
                int zzb = zzbpq.zzb(bArr, i, zzbpr);
                zzbpr.zzflf = Boolean.valueOf(zzbpr.zzfle != 0);
                return zzb;
            case 2:
                return zzbpq.zze(bArr, i, zzbpr);
            case 3:
                zzbpr.zzflf = Double.valueOf(zzbpq.zzi(bArr, i));
                return i + 8;
            case 4:
            case 5:
                zzbpr.zzflf = Integer.valueOf(zzbpq.zzg(bArr, i));
                return i + 4;
            case 6:
            case 7:
                zzbpr.zzflf = Long.valueOf(zzbpq.zzh(bArr, i));
                return i + 8;
            case 8:
                zzbpr.zzflf = Float.valueOf(zzbpq.zzj(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int zza = zzbpq.zza(bArr, i, zzbpr);
                zzbpr.zzflf = Integer.valueOf(zzbpr.zzfld);
                return zza;
            case 12:
            case 13:
                int zzb2 = zzbpq.zzb(bArr, i, zzbpr);
                zzbpr.zzflf = Long.valueOf(zzbpr.zzfle);
                return zzb2;
            case 14:
                return zza((zzbtc) zzbsy.zzaog().zzf(cls), bArr, i, i2, zzbpr);
            case 15:
                int zza2 = zzbpq.zza(bArr, i, zzbpr);
                zzbpr.zzflf = Integer.valueOf(zzbqf.zzeu(zzbpr.zzfld));
                return zza2;
            case 16:
                int zzb3 = zzbpq.zzb(bArr, i, zzbpr);
                zzbpr.zzflf = Long.valueOf(zzbqf.zzax(zzbpr.zzfle));
                return zzb3;
            case 17:
                return zzbpq.zzd(bArr, i, zzbpr);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static int zza(int i, byte[] bArr, int i2, int i3, Object obj, zzbpr zzbpr) throws IOException {
        return zzbpq.zza(i, bArr, i2, i3, zzad(obj), zzbpr);
    }

    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, zzbpr zzbpr) throws IOException {
        int i8;
        zzbrk zzbrk = (zzbrk) zzfsh.getObject(t, j2);
        if (!zzbrk.zzaki()) {
            int size = zzbrk.size();
            zzbrk = zzbrk.zzel(size == 0 ? 10 : size << 1);
            zzfsh.putObject(t, j2, zzbrk);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    zzbqn zzbqn = (zzbqn) zzbrk;
                    int zza = zzbpq.zza(bArr, i, zzbpr);
                    int i9 = zzbpr.zzfld + zza;
                    while (zza < i9) {
                        zzbqn.zzd(zzbpq.zzi(bArr, zza));
                        zza += 8;
                    }
                    if (zza == i9) {
                        return zza;
                    }
                    throw zzbrl.zzanc();
                } else if (i5 == 1) {
                    zzbqn zzbqn2 = (zzbqn) zzbrk;
                    zzbqn2.zzd(zzbpq.zzi(bArr, i));
                    int i10 = i + 8;
                    while (i10 < i2) {
                        int zza2 = zzbpq.zza(bArr, i10, zzbpr);
                        if (i3 != zzbpr.zzfld) {
                            return i10;
                        }
                        zzbqn2.zzd(zzbpq.zzi(bArr, zza2));
                        i10 = zza2 + 8;
                    }
                    return i10;
                }
                break;
            case 19:
            case 36:
                if (i5 == 2) {
                    zzbra zzbra = (zzbra) zzbrk;
                    int zza3 = zzbpq.zza(bArr, i, zzbpr);
                    int i11 = zzbpr.zzfld + zza3;
                    while (zza3 < i11) {
                        zzbra.zzh(zzbpq.zzj(bArr, zza3));
                        zza3 += 4;
                    }
                    if (zza3 == i11) {
                        return zza3;
                    }
                    throw zzbrl.zzanc();
                } else if (i5 == 5) {
                    zzbra zzbra2 = (zzbra) zzbrk;
                    zzbra2.zzh(zzbpq.zzj(bArr, i));
                    int i12 = i + 4;
                    while (i12 < i2) {
                        int zza4 = zzbpq.zza(bArr, i12, zzbpr);
                        if (i3 != zzbpr.zzfld) {
                            return i12;
                        }
                        zzbra2.zzh(zzbpq.zzj(bArr, zza4));
                        i12 = zza4 + 4;
                    }
                    return i12;
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    zzbrz zzbrz = (zzbrz) zzbrk;
                    int zza5 = zzbpq.zza(bArr, i, zzbpr);
                    int i13 = zzbpr.zzfld + zza5;
                    while (zza5 < i13) {
                        zza5 = zzbpq.zzb(bArr, zza5, zzbpr);
                        zzbrz.zzbj(zzbpr.zzfle);
                    }
                    if (zza5 == i13) {
                        return zza5;
                    }
                    throw zzbrl.zzanc();
                } else if (i5 == 0) {
                    zzbrz zzbrz2 = (zzbrz) zzbrk;
                    int zzb = zzbpq.zzb(bArr, i, zzbpr);
                    zzbrz2.zzbj(zzbpr.zzfle);
                    while (zzb < i2) {
                        int zza6 = zzbpq.zza(bArr, zzb, zzbpr);
                        if (i3 != zzbpr.zzfld) {
                            return zzb;
                        }
                        zzb = zzbpq.zzb(bArr, zza6, zzbpr);
                        zzbrz2.zzbj(zzbpr.zzfle);
                    }
                    return zzb;
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return zzbpq.zza(bArr, i, zzbrk, zzbpr);
                }
                if (i5 == 0) {
                    return zzbpq.zza(i3, bArr, i, i2, zzbrk, zzbpr);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    zzbrz zzbrz3 = (zzbrz) zzbrk;
                    int zza7 = zzbpq.zza(bArr, i, zzbpr);
                    int i14 = zzbpr.zzfld + zza7;
                    while (zza7 < i14) {
                        zzbrz3.zzbj(zzbpq.zzh(bArr, zza7));
                        zza7 += 8;
                    }
                    if (zza7 == i14) {
                        return zza7;
                    }
                    throw zzbrl.zzanc();
                } else if (i5 == 1) {
                    zzbrz zzbrz4 = (zzbrz) zzbrk;
                    zzbrz4.zzbj(zzbpq.zzh(bArr, i));
                    int i15 = i + 8;
                    while (i15 < i2) {
                        int zza8 = zzbpq.zza(bArr, i15, zzbpr);
                        if (i3 != zzbpr.zzfld) {
                            return i15;
                        }
                        zzbrz4.zzbj(zzbpq.zzh(bArr, zza8));
                        i15 = zza8 + 8;
                    }
                    return i15;
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    zzbre zzbre = (zzbre) zzbrk;
                    int zza9 = zzbpq.zza(bArr, i, zzbpr);
                    int i16 = zzbpr.zzfld + zza9;
                    while (zza9 < i16) {
                        zzbre.zzfo(zzbpq.zzg(bArr, zza9));
                        zza9 += 4;
                    }
                    if (zza9 == i16) {
                        return zza9;
                    }
                    throw zzbrl.zzanc();
                } else if (i5 == 5) {
                    zzbre zzbre2 = (zzbre) zzbrk;
                    zzbre2.zzfo(zzbpq.zzg(bArr, i));
                    int i17 = i + 4;
                    while (i17 < i2) {
                        int zza10 = zzbpq.zza(bArr, i17, zzbpr);
                        if (i3 != zzbpr.zzfld) {
                            return i17;
                        }
                        zzbre2.zzfo(zzbpq.zzg(bArr, zza10));
                        i17 = zza10 + 4;
                    }
                    return i17;
                }
                break;
            case 25:
            case 42:
                if (i5 == 2) {
                    zzbps zzbps = (zzbps) zzbrk;
                    int zza11 = zzbpq.zza(bArr, i, zzbpr);
                    int i18 = zzbpr.zzfld + zza11;
                    while (zza11 < i18) {
                        zza11 = zzbpq.zzb(bArr, zza11, zzbpr);
                        zzbps.addBoolean(zzbpr.zzfle != 0);
                    }
                    if (zza11 == i18) {
                        return zza11;
                    }
                    throw zzbrl.zzanc();
                } else if (i5 == 0) {
                    zzbps zzbps2 = (zzbps) zzbrk;
                    int zzb2 = zzbpq.zzb(bArr, i, zzbpr);
                    zzbps2.addBoolean(zzbpr.zzfle != 0);
                    while (zzb2 < i2) {
                        int zza12 = zzbpq.zza(bArr, zzb2, zzbpr);
                        if (i3 != zzbpr.zzfld) {
                            return zzb2;
                        }
                        zzb2 = zzbpq.zzb(bArr, zza12, zzbpr);
                        zzbps2.addBoolean(zzbpr.zzfle != 0);
                    }
                    return zzb2;
                }
                break;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) == 0) {
                        int zza13 = zzbpq.zza(bArr, i, zzbpr);
                        int i19 = zzbpr.zzfld;
                        if (i19 >= 0) {
                            if (i19 == 0) {
                                zzbrk.add("");
                            } else {
                                zzbrk.add(new String(bArr, zza13, i19, zzbrf.UTF_8));
                                zza13 += i19;
                            }
                            while (zza13 < i2) {
                                int zza14 = zzbpq.zza(bArr, zza13, zzbpr);
                                if (i3 != zzbpr.zzfld) {
                                    return zza13;
                                }
                                zza13 = zzbpq.zza(bArr, zza14, zzbpr);
                                int i20 = zzbpr.zzfld;
                                if (i20 < 0) {
                                    throw zzbrl.zzand();
                                } else if (i20 == 0) {
                                    zzbrk.add("");
                                } else {
                                    zzbrk.add(new String(bArr, zza13, i20, zzbrf.UTF_8));
                                    zza13 += i20;
                                }
                            }
                            return zza13;
                        }
                        throw zzbrl.zzand();
                    }
                    int zza15 = zzbpq.zza(bArr, i, zzbpr);
                    int i21 = zzbpr.zzfld;
                    if (i21 >= 0) {
                        if (i21 == 0) {
                            zzbrk.add("");
                        } else {
                            int i22 = zza15 + i21;
                            if (zzbuc.zzm(bArr, zza15, i22)) {
                                zzbrk.add(new String(bArr, zza15, i21, zzbrf.UTF_8));
                                zza15 = i22;
                            } else {
                                throw zzbrl.zzank();
                            }
                        }
                        while (zza15 < i2) {
                            int zza16 = zzbpq.zza(bArr, zza15, zzbpr);
                            if (i3 != zzbpr.zzfld) {
                                return zza15;
                            }
                            zza15 = zzbpq.zza(bArr, zza16, zzbpr);
                            int i23 = zzbpr.zzfld;
                            if (i23 < 0) {
                                throw zzbrl.zzand();
                            } else if (i23 == 0) {
                                zzbrk.add("");
                            } else {
                                int i24 = zza15 + i23;
                                if (zzbuc.zzm(bArr, zza15, i24)) {
                                    zzbrk.add(new String(bArr, zza15, i23, zzbrf.UTF_8));
                                    zza15 = i24;
                                } else {
                                    throw zzbrl.zzank();
                                }
                            }
                        }
                        return zza15;
                    }
                    throw zzbrl.zzand();
                }
                break;
            case 27:
                if (i5 == 2) {
                    return zza(zzfq(i6), i3, bArr, i, i2, zzbrk, zzbpr);
                }
                break;
            case 28:
                if (i5 == 2) {
                    int zza17 = zzbpq.zza(bArr, i, zzbpr);
                    int i25 = zzbpr.zzfld;
                    if (i25 < 0) {
                        throw zzbrl.zzand();
                    } else if (i25 <= bArr.length - zza17) {
                        if (i25 == 0) {
                            zzbrk.add(zzbpu.zzfli);
                        } else {
                            zzbrk.add(zzbpu.zzi(bArr, zza17, i25));
                            zza17 += i25;
                        }
                        while (zza17 < i2) {
                            int zza18 = zzbpq.zza(bArr, zza17, zzbpr);
                            if (i3 != zzbpr.zzfld) {
                                return zza17;
                            }
                            zza17 = zzbpq.zza(bArr, zza18, zzbpr);
                            int i26 = zzbpr.zzfld;
                            if (i26 < 0) {
                                throw zzbrl.zzand();
                            } else if (i26 > bArr.length - zza17) {
                                throw zzbrl.zzanc();
                            } else if (i26 == 0) {
                                zzbrk.add(zzbpu.zzfli);
                            } else {
                                zzbrk.add(zzbpu.zzi(bArr, zza17, i26));
                                zza17 += i26;
                            }
                        }
                        return zza17;
                    } else {
                        throw zzbrl.zzanc();
                    }
                }
                break;
            case 30:
            case 44:
                if (i5 == 2) {
                    i8 = zzbpq.zza(bArr, i, zzbrk, zzbpr);
                } else if (i5 == 0) {
                    i8 = zzbpq.zza(i3, bArr, i, i2, zzbrk, zzbpr);
                }
                T t2 = t;
                zzbtv zzbtv = t2.zzfpu;
                if (zzbtv == zzbtv.zzaoz()) {
                    zzbtv = null;
                }
                zzbtv zzbtv2 = (zzbtv) zzbte.zza(i4, zzbrk, zzfs(i6), zzbtv, this.zzfsw);
                if (zzbtv2 != null) {
                    t2.zzfpu = zzbtv2;
                }
                return i8;
            case 33:
            case 47:
                if (i5 == 2) {
                    zzbre zzbre3 = (zzbre) zzbrk;
                    int zza19 = zzbpq.zza(bArr, i, zzbpr);
                    int i27 = zzbpr.zzfld + zza19;
                    while (zza19 < i27) {
                        zza19 = zzbpq.zza(bArr, zza19, zzbpr);
                        zzbre3.zzfo(zzbqf.zzeu(zzbpr.zzfld));
                    }
                    if (zza19 == i27) {
                        return zza19;
                    }
                    throw zzbrl.zzanc();
                } else if (i5 == 0) {
                    zzbre zzbre4 = (zzbre) zzbrk;
                    int zza20 = zzbpq.zza(bArr, i, zzbpr);
                    zzbre4.zzfo(zzbqf.zzeu(zzbpr.zzfld));
                    while (zza20 < i2) {
                        int zza21 = zzbpq.zza(bArr, zza20, zzbpr);
                        if (i3 != zzbpr.zzfld) {
                            return zza20;
                        }
                        zza20 = zzbpq.zza(bArr, zza21, zzbpr);
                        zzbre4.zzfo(zzbqf.zzeu(zzbpr.zzfld));
                    }
                    return zza20;
                }
                break;
            case 34:
            case 48:
                if (i5 == 2) {
                    zzbrz zzbrz5 = (zzbrz) zzbrk;
                    int zza22 = zzbpq.zza(bArr, i, zzbpr);
                    int i28 = zzbpr.zzfld + zza22;
                    while (zza22 < i28) {
                        zza22 = zzbpq.zzb(bArr, zza22, zzbpr);
                        zzbrz5.zzbj(zzbqf.zzax(zzbpr.zzfle));
                    }
                    if (zza22 == i28) {
                        return zza22;
                    }
                    throw zzbrl.zzanc();
                } else if (i5 == 0) {
                    zzbrz zzbrz6 = (zzbrz) zzbrk;
                    int zzb3 = zzbpq.zzb(bArr, i, zzbpr);
                    zzbrz6.zzbj(zzbqf.zzax(zzbpr.zzfle));
                    while (zzb3 < i2) {
                        int zza23 = zzbpq.zza(bArr, zzb3, zzbpr);
                        if (i3 != zzbpr.zzfld) {
                            return zzb3;
                        }
                        zzb3 = zzbpq.zzb(bArr, zza23, zzbpr);
                        zzbrz6.zzbj(zzbqf.zzax(zzbpr.zzfle));
                    }
                    return zzb3;
                }
                break;
            case 49:
                if (i5 == 3) {
                    zzbtc zzfq = zzfq(i6);
                    int i29 = (i3 & -8) | 4;
                    int zza24 = zza(zzfq, bArr, i, i2, i29, zzbpr);
                    zzbrk.add(zzbpr.zzflf);
                    while (zza24 < i2) {
                        int zza25 = zzbpq.zza(bArr, zza24, zzbpr);
                        if (i3 != zzbpr.zzfld) {
                            return zza24;
                        }
                        zza24 = zza(zzfq, bArr, zza25, i2, i29, zzbpr);
                        zzbrk.add(zzbpr.zzflf);
                    }
                    return zza24;
                }
                break;
        }
        return i;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x003e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x003e */
    private final <K, V> int zza(T t, byte[] bArr, int i, int i2, int i3, long j, zzbpr zzbpr) throws IOException {
        int i4;
        int i5;
        Unsafe unsafe = zzfsh;
        Object zzfr = zzfr(i3);
        Object object = unsafe.getObject(t, j);
        if (this.zzfsy.zzy(object)) {
            Object zzaa = this.zzfsy.zzaa(zzfr);
            this.zzfsy.zzc(zzaa, object);
            unsafe.putObject(t, j, zzaa);
            object = zzaa;
        }
        zzbse<?, ?> zzab = this.zzfsy.zzab(zzfr);
        Map<?, ?> zzw = this.zzfsy.zzw(object);
        int zza = zzbpq.zza(bArr, i, zzbpr);
        int i6 = zzbpr.zzfld;
        if (i6 < 0 || i6 > i2 - zza) {
            throw zzbrl.zzanc();
        }
        int i7 = i6 + zza;
        zzbqs zzbqs = (K) zzab.zzfsa;
        zzbqs zzbqs2 = (V) zzab.zzfsc;
        while (zza < i7) {
            int i8 = zza + 1;
            byte b = bArr[zza];
            if (b < 0) {
                i5 = zzbpq.zza(b, bArr, i8, zzbpr);
                i4 = zzbpr.zzfld;
            } else {
                i5 = i8;
                i4 = b;
            }
            int i9 = (i4 == 1 ? 1 : 0) >>> 3;
            int i10 = (i4 == 1 ? 1 : 0) & 7;
            switch (i9) {
                case 1:
                    if (i10 == zzab.zzfrz.zzapk()) {
                        zza = zza(bArr, i5, i2, zzab.zzfrz, (Class<?>) null, zzbpr);
                        zzbqs = (K) zzbpr.zzflf;
                        continue;
                    }
                    break;
                case 2:
                    if (i10 == zzab.zzfsb.zzapk()) {
                        zza = zza(bArr, i5, i2, zzab.zzfsb, zzab.zzfsc.getClass(), zzbpr);
                        zzbqs2 = (V) zzbpr.zzflf;
                        continue;
                    }
                    break;
            }
            zza = zzbpq.zza(i4, bArr, i5, i2, zzbpr);
        }
        if (zza == i7) {
            zzw.put(zzbqs, zzbqs2);
            return i7;
        }
        throw zzbrl.zzanj();
    }

    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzbpr zzbpr) throws IOException {
        int i9;
        Unsafe unsafe = zzfsh;
        long j2 = (long) (this.zzfsi[i8 + 2] & 1048575);
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Double.valueOf(zzbpq.zzi(bArr, i)));
                    i9 = i + 8;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 52:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Float.valueOf(zzbpq.zzj(bArr, i)));
                    i9 = i + 4;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 53:
            case 54:
                if (i5 == 0) {
                    i9 = zzbpq.zzb(bArr, i, zzbpr);
                    unsafe.putObject(t, j, Long.valueOf(zzbpr.zzfle));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 55:
            case 62:
                if (i5 == 0) {
                    i9 = zzbpq.zza(bArr, i, zzbpr);
                    unsafe.putObject(t, j, Integer.valueOf(zzbpr.zzfld));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 56:
            case 65:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Long.valueOf(zzbpq.zzh(bArr, i)));
                    i9 = i + 8;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Integer.valueOf(zzbpq.zzg(bArr, i)));
                    i9 = i + 4;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 58:
                if (i5 == 0) {
                    i9 = zzbpq.zzb(bArr, i, zzbpr);
                    unsafe.putObject(t, j, Boolean.valueOf(zzbpr.zzfle != 0));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 59:
                if (i5 == 2) {
                    int zza = zzbpq.zza(bArr, i, zzbpr);
                    int i10 = zzbpr.zzfld;
                    if (i10 == 0) {
                        unsafe.putObject(t, j, "");
                    } else if ((i6 & 536870912) == 0 || zzbuc.zzm(bArr, zza, zza + i10)) {
                        unsafe.putObject(t, j, new String(bArr, zza, i10, zzbrf.UTF_8));
                        zza += i10;
                    } else {
                        throw zzbrl.zzank();
                    }
                    unsafe.putInt(t, j2, i4);
                    return zza;
                }
                return i;
            case 60:
                if (i5 == 2) {
                    int zza2 = zza(zzfq(i8), bArr, i, i2, zzbpr);
                    Object object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object == null) {
                        unsafe.putObject(t, j, zzbpr.zzflf);
                    } else {
                        unsafe.putObject(t, j, zzbrf.zzb(object, zzbpr.zzflf));
                    }
                    unsafe.putInt(t, j2, i4);
                    return zza2;
                }
                return i;
            case 61:
                if (i5 == 2) {
                    i9 = zzbpq.zze(bArr, i, zzbpr);
                    unsafe.putObject(t, j, zzbpr.zzflf);
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 63:
                if (i5 == 0) {
                    int zza3 = zzbpq.zza(bArr, i, zzbpr);
                    int i11 = zzbpr.zzfld;
                    zzbri zzfs = zzfs(i8);
                    if (zzfs == null || zzfs.zzcb(i11)) {
                        unsafe.putObject(t, j, Integer.valueOf(i11));
                        i9 = zza3;
                        unsafe.putInt(t, j2, i4);
                        return i9;
                    }
                    zzad(t).zzc(i3, Long.valueOf((long) i11));
                    return zza3;
                }
                return i;
            case 66:
                if (i5 == 0) {
                    i9 = zzbpq.zza(bArr, i, zzbpr);
                    unsafe.putObject(t, j, Integer.valueOf(zzbqf.zzeu(zzbpr.zzfld)));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 67:
                if (i5 == 0) {
                    i9 = zzbpq.zzb(bArr, i, zzbpr);
                    unsafe.putObject(t, j, Long.valueOf(zzbqf.zzax(zzbpr.zzfle)));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 68:
                if (i5 == 3) {
                    i9 = zza(zzfq(i8), bArr, i, i2, (i3 & -8) | 4, zzbpr);
                    Object object2 = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object2 == null) {
                        unsafe.putObject(t, j, zzbpr.zzflf);
                    } else {
                        unsafe.putObject(t, j, zzbrf.zzb(object2, zzbpr.zzflf));
                    }
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            default:
                return i;
        }
    }

    private final zzbtc zzfq(int i) {
        int i2 = (i / 3) << 1;
        zzbtc zzbtc = (zzbtc) this.zzfsj[i2];
        if (zzbtc != null) {
            return zzbtc;
        }
        zzbtc<T> zzf = zzbsy.zzaog().zzf((Class) this.zzfsj[i2 + 1]);
        this.zzfsj[i2] = zzf;
        return zzf;
    }

    private final Object zzfr(int i) {
        return this.zzfsj[(i / 3) << 1];
    }

    private final zzbri zzfs(int i) {
        return (zzbri) this.zzfsj[((i / 3) << 1) + 1];
    }

    private final int zza(T t, byte[] bArr, int i, int i2, int i3, zzbpr zzbpr) throws IOException {
        Unsafe unsafe;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        T t2;
        byte b;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        zzbpr zzbpr2;
        zzbsp<T> zzbsp = this;
        T t3 = t;
        byte[] bArr2 = bArr;
        int i22 = i2;
        int i23 = i3;
        zzbpr zzbpr3 = zzbpr;
        Unsafe unsafe2 = zzfsh;
        int i24 = i;
        int i25 = -1;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        int i29 = -1;
        while (true) {
            if (i24 < i22) {
                int i30 = i24 + 1;
                byte b2 = bArr2[i24];
                if (b2 < 0) {
                    i9 = zzbpq.zza(b2, bArr2, i30, zzbpr3);
                    b = zzbpr3.zzfld;
                } else {
                    b = b2;
                    i9 = i30;
                }
                int i31 = b >>> 3;
                int i32 = b & 7;
                if (i31 > i25) {
                    i10 = zzbsp.zzai(i31, i26 / 3);
                    i11 = -1;
                } else {
                    i10 = zzbsp.zzfw(i31);
                    i11 = -1;
                }
                if (i10 == i11) {
                    i14 = i31;
                    i5 = i9;
                    i15 = i28;
                    i12 = i29;
                    unsafe = unsafe2;
                    i4 = i23;
                    i13 = 0;
                    i16 = b;
                } else {
                    int[] iArr = zzbsp.zzfsi;
                    int i33 = iArr[i10 + 1];
                    int i34 = (i33 & 267386880) >>> 20;
                    long j = (long) (i33 & 1048575);
                    if (i34 <= 17) {
                        int i35 = iArr[i10 + 2];
                        int i36 = 1 << (i35 >>> 20);
                        int i37 = i35 & 1048575;
                        if (i37 != i29) {
                            if (i29 != -1) {
                                unsafe2.putInt(t3, (long) i29, i28);
                            }
                            i28 = unsafe2.getInt(t3, (long) i37);
                            i29 = i37;
                        }
                        switch (i34) {
                            case 0:
                                i20 = i10;
                                i14 = i31;
                                i21 = b;
                                bArr2 = bArr;
                                i19 = i9;
                                if (i32 == 1) {
                                    zzbua.zza(t3, j, zzbpq.zzi(bArr2, i19));
                                    i24 = i19 + 8;
                                    i28 |= i36;
                                    i27 = i21;
                                    i26 = i20;
                                    zzbpr3 = zzbpr;
                                    i25 = i14;
                                    i23 = i3;
                                    i22 = i2;
                                    break;
                                }
                                i15 = i28;
                                i12 = i29;
                                i16 = i21;
                                i13 = i20;
                                unsafe = unsafe2;
                                i5 = i19;
                                i4 = i3;
                                break;
                            case 1:
                                i20 = i10;
                                i14 = i31;
                                i21 = b;
                                bArr2 = bArr;
                                i19 = i9;
                                if (i32 == 5) {
                                    zzbua.zza((Object) t3, j, zzbpq.zzj(bArr2, i19));
                                    i24 = i19 + 4;
                                    i28 |= i36;
                                    i27 = i21;
                                    i26 = i20;
                                    zzbpr3 = zzbpr;
                                    i25 = i14;
                                    i23 = i3;
                                    i22 = i2;
                                    break;
                                }
                                i15 = i28;
                                i12 = i29;
                                i16 = i21;
                                i13 = i20;
                                unsafe = unsafe2;
                                i5 = i19;
                                i4 = i3;
                                break;
                            case 2:
                            case 3:
                                i20 = i10;
                                i14 = i31;
                                i21 = b;
                                bArr2 = bArr;
                                i19 = i9;
                                if (i32 == 0) {
                                    int zzb = zzbpq.zzb(bArr2, i19, zzbpr);
                                    unsafe2.putLong(t, j, zzbpr.zzfle);
                                    i28 |= i36;
                                    i27 = i21;
                                    i26 = i20;
                                    zzbpr3 = zzbpr;
                                    i24 = zzb;
                                    i25 = i14;
                                    i23 = i3;
                                    i22 = i2;
                                    break;
                                }
                                i15 = i28;
                                i12 = i29;
                                i16 = i21;
                                i13 = i20;
                                unsafe = unsafe2;
                                i5 = i19;
                                i4 = i3;
                                break;
                            case 4:
                            case 11:
                                i20 = i10;
                                i14 = i31;
                                i21 = b;
                                bArr2 = bArr;
                                i19 = i9;
                                if (i32 == 0) {
                                    i24 = zzbpq.zza(bArr2, i19, zzbpr);
                                    unsafe2.putInt(t3, j, zzbpr.zzfld);
                                    i28 |= i36;
                                    i27 = i21;
                                    i26 = i20;
                                    zzbpr3 = zzbpr;
                                    i25 = i14;
                                    i23 = i3;
                                    i22 = i2;
                                    break;
                                }
                                i15 = i28;
                                i12 = i29;
                                i16 = i21;
                                i13 = i20;
                                unsafe = unsafe2;
                                i5 = i19;
                                i4 = i3;
                                break;
                            case 5:
                            case 14:
                                i20 = i10;
                                i14 = i31;
                                i21 = b;
                                bArr2 = bArr;
                                if (i32 == 1) {
                                    unsafe2.putLong(t, j, zzbpq.zzh(bArr2, i9));
                                    i24 = i9 + 8;
                                    i28 |= i36;
                                    i27 = i21;
                                    i26 = i20;
                                    zzbpr3 = zzbpr;
                                    i25 = i14;
                                    i23 = i3;
                                    i22 = i2;
                                    break;
                                } else {
                                    i19 = i9;
                                    i15 = i28;
                                    i12 = i29;
                                    i16 = i21;
                                    i13 = i20;
                                    unsafe = unsafe2;
                                    i5 = i19;
                                    i4 = i3;
                                    break;
                                }
                            case 6:
                            case 13:
                                i20 = i10;
                                i14 = i31;
                                i21 = b;
                                bArr2 = bArr;
                                i22 = i2;
                                if (i32 == 5) {
                                    unsafe2.putInt(t3, j, zzbpq.zzg(bArr2, i9));
                                    i24 = i9 + 4;
                                    i28 |= i36;
                                    i27 = i21;
                                    i26 = i20;
                                    zzbpr3 = zzbpr;
                                    i25 = i14;
                                    i23 = i3;
                                    break;
                                } else {
                                    i19 = i9;
                                    i15 = i28;
                                    i12 = i29;
                                    i16 = i21;
                                    i13 = i20;
                                    unsafe = unsafe2;
                                    i5 = i19;
                                    i4 = i3;
                                    break;
                                }
                            case 7:
                                i20 = i10;
                                i14 = i31;
                                i21 = b;
                                bArr2 = bArr;
                                i22 = i2;
                                if (i32 == 0) {
                                    i24 = zzbpq.zzb(bArr2, i9, zzbpr);
                                    zzbua.zza(t3, j, zzbpr.zzfle != 0);
                                    i28 |= i36;
                                    i27 = i21;
                                    i26 = i20;
                                    zzbpr3 = zzbpr;
                                    i25 = i14;
                                    i23 = i3;
                                    break;
                                } else {
                                    i19 = i9;
                                    i15 = i28;
                                    i12 = i29;
                                    i16 = i21;
                                    i13 = i20;
                                    unsafe = unsafe2;
                                    i5 = i19;
                                    i4 = i3;
                                    break;
                                }
                            case 8:
                                i20 = i10;
                                i14 = i31;
                                i21 = b;
                                bArr2 = bArr;
                                i22 = i2;
                                if (i32 == 2) {
                                    if ((i33 & 536870912) == 0) {
                                        i24 = zzbpq.zzc(bArr2, i9, zzbpr);
                                    } else {
                                        i24 = zzbpq.zzd(bArr2, i9, zzbpr);
                                    }
                                    unsafe2.putObject(t3, j, zzbpr.zzflf);
                                    i28 |= i36;
                                    i27 = i21;
                                    i26 = i20;
                                    zzbpr3 = zzbpr;
                                    i25 = i14;
                                    i23 = i3;
                                    break;
                                } else {
                                    i19 = i9;
                                    i15 = i28;
                                    i12 = i29;
                                    i16 = i21;
                                    i13 = i20;
                                    unsafe = unsafe2;
                                    i5 = i19;
                                    i4 = i3;
                                    break;
                                }
                            case 9:
                                i20 = i10;
                                i14 = i31;
                                i21 = b;
                                bArr2 = bArr;
                                if (i32 == 2) {
                                    i22 = i2;
                                    i24 = zza(zzbsp.zzfq(i20), bArr2, i9, i22, zzbpr);
                                    if ((i28 & i36) == 0) {
                                        unsafe2.putObject(t3, j, zzbpr.zzflf);
                                    } else {
                                        unsafe2.putObject(t3, j, zzbrf.zzb(unsafe2.getObject(t3, j), zzbpr.zzflf));
                                    }
                                    i28 |= i36;
                                    i27 = i21;
                                    i26 = i20;
                                    zzbpr3 = zzbpr;
                                    i25 = i14;
                                    i23 = i3;
                                    break;
                                } else {
                                    i19 = i9;
                                    i15 = i28;
                                    i12 = i29;
                                    i16 = i21;
                                    i13 = i20;
                                    unsafe = unsafe2;
                                    i5 = i19;
                                    i4 = i3;
                                    break;
                                }
                            case 10:
                                i20 = i10;
                                i14 = i31;
                                i21 = b;
                                bArr2 = bArr;
                                if (i32 == 2) {
                                    i24 = zzbpq.zze(bArr2, i9, zzbpr);
                                    unsafe2.putObject(t3, j, zzbpr.zzflf);
                                    i28 |= i36;
                                    i27 = i21;
                                    i26 = i20;
                                    zzbpr3 = zzbpr;
                                    i25 = i14;
                                    i23 = i3;
                                    i22 = i2;
                                    break;
                                } else {
                                    i19 = i9;
                                    i15 = i28;
                                    i12 = i29;
                                    i16 = i21;
                                    i13 = i20;
                                    unsafe = unsafe2;
                                    i5 = i19;
                                    i4 = i3;
                                    break;
                                }
                            case 12:
                                i20 = i10;
                                i14 = i31;
                                i21 = b;
                                bArr2 = bArr;
                                if (i32 == 0) {
                                    i24 = zzbpq.zza(bArr2, i9, zzbpr);
                                    int i38 = zzbpr.zzfld;
                                    zzbri zzfs = zzbsp.zzfs(i20);
                                    if (zzfs != null && !zzfs.zzcb(i38)) {
                                        zzad(t).zzc(i21, Long.valueOf((long) i38));
                                        i27 = i21;
                                        i26 = i20;
                                        zzbpr3 = zzbpr;
                                        i25 = i14;
                                        i23 = i3;
                                        i22 = i2;
                                        break;
                                    } else {
                                        unsafe2.putInt(t3, j, i38);
                                        i28 |= i36;
                                        i27 = i21;
                                        i26 = i20;
                                        zzbpr3 = zzbpr;
                                        i25 = i14;
                                        i23 = i3;
                                        i22 = i2;
                                        break;
                                    }
                                } else {
                                    i19 = i9;
                                    i15 = i28;
                                    i12 = i29;
                                    i16 = i21;
                                    i13 = i20;
                                    unsafe = unsafe2;
                                    i5 = i19;
                                    i4 = i3;
                                    break;
                                }
                                break;
                            case 15:
                                i20 = i10;
                                i14 = i31;
                                i21 = b;
                                bArr2 = bArr;
                                if (i32 == 0) {
                                    i24 = zzbpq.zza(bArr2, i9, zzbpr);
                                    unsafe2.putInt(t3, j, zzbqf.zzeu(zzbpr.zzfld));
                                    i28 |= i36;
                                    i27 = i21;
                                    i26 = i20;
                                    zzbpr3 = zzbpr;
                                    i25 = i14;
                                    i23 = i3;
                                    i22 = i2;
                                    break;
                                } else {
                                    i19 = i9;
                                    i15 = i28;
                                    i12 = i29;
                                    i16 = i21;
                                    i13 = i20;
                                    unsafe = unsafe2;
                                    i5 = i19;
                                    i4 = i3;
                                    break;
                                }
                            case 16:
                                i20 = i10;
                                i14 = i31;
                                i21 = b;
                                if (i32 == 0) {
                                    bArr2 = bArr;
                                    int zzb2 = zzbpq.zzb(bArr2, i9, zzbpr);
                                    unsafe2.putLong(t, j, zzbqf.zzax(zzbpr.zzfle));
                                    i28 |= i36;
                                    i27 = i21;
                                    i26 = i20;
                                    zzbpr3 = zzbpr;
                                    i24 = zzb2;
                                    i25 = i14;
                                    i23 = i3;
                                    i22 = i2;
                                    break;
                                } else {
                                    i19 = i9;
                                    i15 = i28;
                                    i12 = i29;
                                    i16 = i21;
                                    i13 = i20;
                                    unsafe = unsafe2;
                                    i5 = i19;
                                    i4 = i3;
                                    break;
                                }
                            case 17:
                                if (i32 == 3) {
                                    i24 = zza(zzbsp.zzfq(i10), bArr, i9, i2, (i31 << 3) | 4, zzbpr);
                                    if ((i28 & i36) == 0) {
                                        zzbpr2 = zzbpr;
                                        unsafe2.putObject(t3, j, zzbpr2.zzflf);
                                    } else {
                                        zzbpr2 = zzbpr;
                                        unsafe2.putObject(t3, j, zzbrf.zzb(unsafe2.getObject(t3, j), zzbpr2.zzflf));
                                    }
                                    i28 |= i36;
                                    i27 = b;
                                    i26 = i10;
                                    zzbpr3 = zzbpr2;
                                    i25 = i31;
                                    i23 = i3;
                                    bArr2 = bArr;
                                    i22 = i2;
                                    break;
                                } else {
                                    i20 = i10;
                                    i14 = i31;
                                    i21 = b;
                                    i19 = i9;
                                    i15 = i28;
                                    i12 = i29;
                                    i16 = i21;
                                    i13 = i20;
                                    unsafe = unsafe2;
                                    i5 = i19;
                                    i4 = i3;
                                    break;
                                }
                            default:
                                i20 = i10;
                                i14 = i31;
                                i19 = i9;
                                i21 = b;
                                i15 = i28;
                                i12 = i29;
                                i16 = i21;
                                i13 = i20;
                                unsafe = unsafe2;
                                i5 = i19;
                                i4 = i3;
                                break;
                        }
                    } else {
                        i14 = i31;
                        bArr2 = bArr;
                        if (i34 != 27) {
                            i15 = i28;
                            if (i34 <= 49) {
                                i12 = i29;
                                i13 = i10;
                                unsafe = unsafe2;
                                i24 = zza(t, bArr, i9, i2, b, i14, i32, i10, (long) i33, i34, j, zzbpr);
                                if (i24 == i9) {
                                    i5 = i24;
                                    i16 = b;
                                    i4 = i3;
                                } else {
                                    bArr2 = bArr;
                                    zzbpr3 = zzbpr;
                                    i28 = i15;
                                    i25 = i14;
                                    i26 = i13;
                                    i29 = i12;
                                    i27 = b;
                                    unsafe2 = unsafe;
                                    i23 = i3;
                                    i22 = i2;
                                    t3 = t;
                                    zzbsp = this;
                                }
                            } else {
                                i12 = i29;
                                i17 = b;
                                i13 = i10;
                                unsafe = unsafe2;
                                i18 = i9;
                                if (i34 != 50) {
                                    i24 = zza(t, bArr, i18, i2, i17, i14, i32, i33, i34, j, i13, zzbpr);
                                    if (i24 == i18) {
                                        i5 = i24;
                                        i16 = i17;
                                        i4 = i3;
                                    } else {
                                        bArr2 = bArr;
                                        zzbpr3 = zzbpr;
                                        i27 = i17;
                                        i28 = i15;
                                        i25 = i14;
                                        i26 = i13;
                                        i29 = i12;
                                        unsafe2 = unsafe;
                                        i23 = i3;
                                        i22 = i2;
                                        t3 = t;
                                        zzbsp = this;
                                    }
                                } else if (i32 == 2) {
                                    i24 = zza(t, bArr, i18, i2, i13, j, zzbpr);
                                    if (i24 == i18) {
                                        i5 = i24;
                                        i16 = i17;
                                        i4 = i3;
                                    } else {
                                        bArr2 = bArr;
                                        zzbpr3 = zzbpr;
                                        i28 = i15;
                                        i25 = i14;
                                        i26 = i13;
                                        i29 = i12;
                                        i27 = i17;
                                        unsafe2 = unsafe;
                                        i23 = i3;
                                        i22 = i2;
                                        t3 = t;
                                        zzbsp = this;
                                    }
                                }
                            }
                        } else if (i32 == 2) {
                            zzbrk zzbrk = (zzbrk) unsafe2.getObject(t3, j);
                            if (!zzbrk.zzaki()) {
                                int size = zzbrk.size();
                                zzbrk = zzbrk.zzel(size == 0 ? 10 : size << 1);
                                unsafe2.putObject(t3, j, zzbrk);
                            }
                            i24 = zza(zzbsp.zzfq(i10), b, bArr, i9, i2, zzbrk, zzbpr);
                            i27 = b;
                            i26 = i10;
                            i28 = i28;
                            i25 = i14;
                            i23 = i3;
                            i22 = i2;
                            zzbpr3 = zzbpr;
                        } else {
                            i15 = i28;
                            i12 = i29;
                            i17 = b;
                            i13 = i10;
                            unsafe = unsafe2;
                            i18 = i9;
                        }
                        i5 = i18;
                        i16 = i17;
                        i4 = i3;
                    }
                }
                if (i16 != i4 || i4 == 0) {
                    i24 = zza(i16, bArr, i5, i2, t, zzbpr);
                    bArr2 = bArr;
                    zzbpr3 = zzbpr;
                    i23 = i4;
                    i27 = i16;
                    i28 = i15;
                    i25 = i14;
                    i26 = i13;
                    i29 = i12;
                    unsafe2 = unsafe;
                    i22 = i2;
                    t3 = t;
                    zzbsp = this;
                } else {
                    i27 = i16;
                    i6 = i15;
                    i7 = i12;
                    i8 = -1;
                }
            } else {
                unsafe = unsafe2;
                i4 = i23;
                i5 = i24;
                i6 = i28;
                i7 = i29;
                i8 = -1;
            }
        }
        if (i7 != i8) {
            long j2 = (long) i7;
            t2 = t;
            unsafe.putInt(t2, j2, i6);
        } else {
            t2 = t;
        }
        zzbtv zzbtv = null;
        for (int i39 = this.zzfss; i39 < this.zzfst; i39++) {
            zzbtv = (zzbtv) zza(t2, this.zzfsr[i39], zzbtv, (zzbtu<UT, UB>) this.zzfsw);
        }
        if (zzbtv != null) {
            this.zzfsw.zzg(t2, zzbtv);
        }
        if (i4 == 0) {
            if (i5 != i2) {
                throw zzbrl.zzanj();
            }
        } else if (i5 > i2 || i27 != i4) {
            throw zzbrl.zzanj();
        }
        return i5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v13, types: [int] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.google.android.gms.internal.ads.zzbtc
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r28, byte[] r29, int r30, int r31, com.google.android.gms.internal.ads.zzbpr r32) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 912
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbsp.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.ads.zzbpr):void");
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void zzs(T t) {
        int i;
        int i2 = this.zzfss;
        while (true) {
            i = this.zzfst;
            if (i2 >= i) {
                break;
            }
            long zzft = (long) (zzft(this.zzfsr[i2]) & 1048575);
            Object zzp = zzbua.zzp(t, zzft);
            if (zzp != null) {
                zzbua.zza(t, zzft, this.zzfsy.zzz(zzp));
            }
            i2++;
        }
        int length = this.zzfsr.length;
        while (i < length) {
            this.zzfsv.zzb(t, (long) this.zzfsr[i]);
            i++;
        }
        this.zzfsw.zzs(t);
        if (this.zzfsn) {
            this.zzfsx.zzs(t);
        }
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzbtu<UT, UB> zzbtu) {
        zzbri zzfs;
        int i2 = this.zzfsi[i];
        Object zzp = zzbua.zzp(obj, (long) (zzft(i) & 1048575));
        return (zzp == null || (zzfs = zzfs(i)) == null) ? ub : (UB) zza(i, i2, (Map<K, V>) this.zzfsy.zzw(zzp), zzfs, ub, zzbtu);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzbri zzbri, UB ub, zzbtu<UT, UB> zzbtu) {
        zzbse<?, ?> zzab = this.zzfsy.zzab(zzfr(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzbri.zzcb(next.getValue().intValue())) {
                if (ub == null) {
                    ub = zzbtu.zzaoy();
                }
                zzbqb zzen = zzbpu.zzen(zzbsd.zza(zzab, next.getKey(), next.getValue()));
                try {
                    zzbsd.zza(zzen.zzakt(), zzab, next.getKey(), next.getValue());
                    zzbtu.zza(ub, i2, zzen.zzaks());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.google.android.gms.internal.ads.zzbtc] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v14, types: [com.google.android.gms.internal.ads.zzbtc] */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0104, code lost:
        continue;
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.google.android.gms.internal.ads.zzbtc
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzae(T r14) {
        /*
        // Method dump skipped, instructions count: 290
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbsp.zzae(java.lang.Object):boolean");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.android.gms.internal.ads.zzbtc */
    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zzbtc zzbtc) {
        return zzbtc.zzae(zzbua.zzp(obj, (long) (i & 1048575)));
    }

    private static void zza(int i, Object obj, zzbup zzbup) throws IOException {
        if (obj instanceof String) {
            zzbup.zzf(i, (String) obj);
        } else {
            zzbup.zza(i, (zzbpu) obj);
        }
    }

    private final void zza(Object obj, int i, zzbtb zzbtb) throws IOException {
        if (zzfv(i)) {
            zzbua.zza(obj, (long) (i & 1048575), zzbtb.zzalb());
        } else if (this.zzfso) {
            zzbua.zza(obj, (long) (i & 1048575), zzbtb.readString());
        } else {
            zzbua.zza(obj, (long) (i & 1048575), zzbtb.zzalc());
        }
    }

    private final int zzft(int i) {
        return this.zzfsi[i + 1];
    }

    private final int zzfu(int i) {
        return this.zzfsi[i + 2];
    }

    private static <T> double zzf(T t, long j) {
        return ((Double) zzbua.zzp(t, j)).doubleValue();
    }

    private static <T> float zzg(T t, long j) {
        return ((Float) zzbua.zzp(t, j)).floatValue();
    }

    private static <T> int zzh(T t, long j) {
        return ((Integer) zzbua.zzp(t, j)).intValue();
    }

    private static <T> long zzi(T t, long j) {
        return ((Long) zzbua.zzp(t, j)).longValue();
    }

    private static <T> boolean zzj(T t, long j) {
        return ((Boolean) zzbua.zzp(t, j)).booleanValue();
    }

    private final boolean zzc(T t, T t2, int i) {
        return zzd(t, i) == zzd(t2, i);
    }

    private final boolean zza(T t, int i, int i2, int i3) {
        if (this.zzfsp) {
            return zzd(t, i);
        }
        return (i2 & i3) != 0;
    }

    private final boolean zzd(T t, int i) {
        if (this.zzfsp) {
            int zzft = zzft(i);
            long j = (long) (zzft & 1048575);
            switch ((zzft & 267386880) >>> 20) {
                case 0:
                    return zzbua.zzo(t, j) != 0.0d;
                case 1:
                    return zzbua.zzn(t, j) != 0.0f;
                case 2:
                    return zzbua.zzl(t, j) != 0;
                case 3:
                    return zzbua.zzl(t, j) != 0;
                case 4:
                    return zzbua.zzk(t, j) != 0;
                case 5:
                    return zzbua.zzl(t, j) != 0;
                case 6:
                    return zzbua.zzk(t, j) != 0;
                case 7:
                    return zzbua.zzm(t, j);
                case 8:
                    Object zzp = zzbua.zzp(t, j);
                    if (zzp instanceof String) {
                        return !((String) zzp).isEmpty();
                    }
                    if (zzp instanceof zzbpu) {
                        return !zzbpu.zzfli.equals(zzp);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzbua.zzp(t, j) != null;
                case 10:
                    return !zzbpu.zzfli.equals(zzbua.zzp(t, j));
                case 11:
                    return zzbua.zzk(t, j) != 0;
                case 12:
                    return zzbua.zzk(t, j) != 0;
                case 13:
                    return zzbua.zzk(t, j) != 0;
                case 14:
                    return zzbua.zzl(t, j) != 0;
                case 15:
                    return zzbua.zzk(t, j) != 0;
                case 16:
                    return zzbua.zzl(t, j) != 0;
                case 17:
                    return zzbua.zzp(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int zzfu = zzfu(i);
            return (zzbua.zzk(t, (long) (zzfu & 1048575)) & (1 << (zzfu >>> 20))) != 0;
        }
    }

    private final void zze(T t, int i) {
        if (!this.zzfsp) {
            int zzfu = zzfu(i);
            long j = (long) (zzfu & 1048575);
            zzbua.zzb(t, j, zzbua.zzk(t, j) | (1 << (zzfu >>> 20)));
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzbua.zzk(t, (long) (zzfu(i2) & 1048575)) == i;
    }

    private final void zzb(T t, int i, int i2) {
        zzbua.zzb(t, (long) (zzfu(i2) & 1048575), i);
    }

    private final int zzfw(int i) {
        if (i < this.zzfsk || i > this.zzfsl) {
            return -1;
        }
        return zzaj(i, 0);
    }

    private final int zzai(int i, int i2) {
        if (i < this.zzfsk || i > this.zzfsl) {
            return -1;
        }
        return zzaj(i, i2);
    }

    private final int zzaj(int i, int i2) {
        int length = (this.zzfsi.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzfsi[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }
}
