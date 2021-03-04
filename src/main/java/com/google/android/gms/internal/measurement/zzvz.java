package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

final class zzvz<T> implements zzwl<T> {
    private static final int[] zzcao = new int[0];
    private static final Unsafe zzcap = zzxj.zzyq();
    private final int[] zzcaq;
    private final Object[] zzcar;
    private final int zzcas;
    private final int zzcat;
    private final zzvv zzcau;
    private final boolean zzcav;
    private final boolean zzcaw;
    private final boolean zzcax;
    private final boolean zzcay;
    private final int[] zzcaz;
    private final int zzcba;
    private final int zzcbb;
    private final zzwc zzcbc;
    private final zzvf zzcbd;
    private final zzxd<?, ?> zzcbe;
    private final zzuc<?> zzcbf;
    private final zzvq zzcbg;

    private zzvz(int[] iArr, Object[] objArr, int i, int i2, zzvv zzvv, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzwc zzwc, zzvf zzvf, zzxd<?, ?> zzxd, zzuc<?> zzuc, zzvq zzvq) {
        this.zzcaq = iArr;
        this.zzcar = objArr;
        this.zzcas = i;
        this.zzcat = i2;
        this.zzcaw = zzvv instanceof zzuo;
        this.zzcax = z;
        this.zzcav = zzuc != null && zzuc.zze(zzvv);
        this.zzcay = false;
        this.zzcaz = iArr2;
        this.zzcba = i3;
        this.zzcbb = i4;
        this.zzcbc = zzwc;
        this.zzcbd = zzvf;
        this.zzcbe = zzxd;
        this.zzcbf = zzuc;
        this.zzcau = zzvv;
        this.zzcbg = zzvq;
    }

    private static boolean zzbv(int i) {
        return (i & 536870912) != 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:165:0x0381  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x03e5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> com.google.android.gms.internal.measurement.zzvz<T> zza(java.lang.Class<T> r35, com.google.android.gms.internal.measurement.zzvt r36, com.google.android.gms.internal.measurement.zzwc r37, com.google.android.gms.internal.measurement.zzvf r38, com.google.android.gms.internal.measurement.zzxd<?, ?> r39, com.google.android.gms.internal.measurement.zzuc<?> r40, com.google.android.gms.internal.measurement.zzvq r41) {
        /*
        // Method dump skipped, instructions count: 1120
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzvz.zza(java.lang.Class, com.google.android.gms.internal.measurement.zzvt, com.google.android.gms.internal.measurement.zzwc, com.google.android.gms.internal.measurement.zzvf, com.google.android.gms.internal.measurement.zzxd, com.google.android.gms.internal.measurement.zzuc, com.google.android.gms.internal.measurement.zzvq):com.google.android.gms.internal.measurement.zzvz");
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

    @Override // com.google.android.gms.internal.measurement.zzwl
    public final T newInstance() {
        return (T) this.zzcbc.newInstance(this.zzcau);
    }

    @Override // com.google.android.gms.internal.measurement.zzwl
    public final boolean equals(T t, T t2) {
        int length = this.zzcaq.length;
        int i = 0;
        while (true) {
            boolean z = true;
            if (i < length) {
                int zzbt = zzbt(i);
                long j = (long) (zzbt & 1048575);
                switch ((zzbt & 267386880) >>> 20) {
                    case 0:
                        if (!zzc(t, t2, i) || Double.doubleToLongBits(zzxj.zzo(t, j)) != Double.doubleToLongBits(zzxj.zzo(t2, j))) {
                            z = false;
                            break;
                        }
                    case 1:
                        if (!zzc(t, t2, i) || Float.floatToIntBits(zzxj.zzn(t, j)) != Float.floatToIntBits(zzxj.zzn(t2, j))) {
                            z = false;
                            break;
                        }
                    case 2:
                        if (!zzc(t, t2, i) || zzxj.zzl(t, j) != zzxj.zzl(t2, j)) {
                            z = false;
                            break;
                        }
                    case 3:
                        if (!zzc(t, t2, i) || zzxj.zzl(t, j) != zzxj.zzl(t2, j)) {
                            z = false;
                            break;
                        }
                    case 4:
                        if (!zzc(t, t2, i) || zzxj.zzk(t, j) != zzxj.zzk(t2, j)) {
                            z = false;
                            break;
                        }
                    case 5:
                        if (!zzc(t, t2, i) || zzxj.zzl(t, j) != zzxj.zzl(t2, j)) {
                            z = false;
                            break;
                        }
                    case 6:
                        if (!zzc(t, t2, i) || zzxj.zzk(t, j) != zzxj.zzk(t2, j)) {
                            z = false;
                            break;
                        }
                    case 7:
                        if (!zzc(t, t2, i) || zzxj.zzm(t, j) != zzxj.zzm(t2, j)) {
                            z = false;
                            break;
                        }
                    case 8:
                        if (!zzc(t, t2, i) || !zzwn.zze(zzxj.zzp(t, j), zzxj.zzp(t2, j))) {
                            z = false;
                            break;
                        }
                    case 9:
                        if (!zzc(t, t2, i) || !zzwn.zze(zzxj.zzp(t, j), zzxj.zzp(t2, j))) {
                            z = false;
                            break;
                        }
                    case 10:
                        if (!zzc(t, t2, i) || !zzwn.zze(zzxj.zzp(t, j), zzxj.zzp(t2, j))) {
                            z = false;
                            break;
                        }
                    case 11:
                        if (!zzc(t, t2, i) || zzxj.zzk(t, j) != zzxj.zzk(t2, j)) {
                            z = false;
                            break;
                        }
                    case 12:
                        if (!zzc(t, t2, i) || zzxj.zzk(t, j) != zzxj.zzk(t2, j)) {
                            z = false;
                            break;
                        }
                    case 13:
                        if (!zzc(t, t2, i) || zzxj.zzk(t, j) != zzxj.zzk(t2, j)) {
                            z = false;
                            break;
                        }
                    case 14:
                        if (!zzc(t, t2, i) || zzxj.zzl(t, j) != zzxj.zzl(t2, j)) {
                            z = false;
                            break;
                        }
                    case 15:
                        if (!zzc(t, t2, i) || zzxj.zzk(t, j) != zzxj.zzk(t2, j)) {
                            z = false;
                            break;
                        }
                    case 16:
                        if (!zzc(t, t2, i) || zzxj.zzl(t, j) != zzxj.zzl(t2, j)) {
                            z = false;
                            break;
                        }
                    case 17:
                        if (!zzc(t, t2, i) || !zzwn.zze(zzxj.zzp(t, j), zzxj.zzp(t2, j))) {
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
                        z = zzwn.zze(zzxj.zzp(t, j), zzxj.zzp(t2, j));
                        break;
                    case 50:
                        z = zzwn.zze(zzxj.zzp(t, j), zzxj.zzp(t2, j));
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
                        long zzbu = (long) (zzbu(i) & 1048575);
                        if (zzxj.zzk(t, zzbu) != zzxj.zzk(t2, zzbu) || !zzwn.zze(zzxj.zzp(t, j), zzxj.zzp(t2, j))) {
                            z = false;
                            break;
                        }
                }
                if (!z) {
                    return false;
                }
                i += 3;
            } else if (!this.zzcbe.zzal(t).equals(this.zzcbe.zzal(t2))) {
                return false;
            } else {
                if (this.zzcav) {
                    return this.zzcbf.zzw(t).equals(this.zzcbf.zzw(t2));
                }
                return true;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzwl
    public final int hashCode(T t) {
        int length = this.zzcaq.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int zzbt = zzbt(i2);
            int i3 = this.zzcaq[i2];
            long j = (long) (1048575 & zzbt);
            int i4 = 37;
            switch ((zzbt & 267386880) >>> 20) {
                case 0:
                    i = (i * 53) + zzuq.zzbd(Double.doubleToLongBits(zzxj.zzo(t, j)));
                    break;
                case 1:
                    i = (i * 53) + Float.floatToIntBits(zzxj.zzn(t, j));
                    break;
                case 2:
                    i = (i * 53) + zzuq.zzbd(zzxj.zzl(t, j));
                    break;
                case 3:
                    i = (i * 53) + zzuq.zzbd(zzxj.zzl(t, j));
                    break;
                case 4:
                    i = (i * 53) + zzxj.zzk(t, j);
                    break;
                case 5:
                    i = (i * 53) + zzuq.zzbd(zzxj.zzl(t, j));
                    break;
                case 6:
                    i = (i * 53) + zzxj.zzk(t, j);
                    break;
                case 7:
                    i = (i * 53) + zzuq.zzu(zzxj.zzm(t, j));
                    break;
                case 8:
                    i = (i * 53) + ((String) zzxj.zzp(t, j)).hashCode();
                    break;
                case 9:
                    Object zzp = zzxj.zzp(t, j);
                    if (zzp != null) {
                        i4 = zzp.hashCode();
                    }
                    i = (i * 53) + i4;
                    break;
                case 10:
                    i = (i * 53) + zzxj.zzp(t, j).hashCode();
                    break;
                case 11:
                    i = (i * 53) + zzxj.zzk(t, j);
                    break;
                case 12:
                    i = (i * 53) + zzxj.zzk(t, j);
                    break;
                case 13:
                    i = (i * 53) + zzxj.zzk(t, j);
                    break;
                case 14:
                    i = (i * 53) + zzuq.zzbd(zzxj.zzl(t, j));
                    break;
                case 15:
                    i = (i * 53) + zzxj.zzk(t, j);
                    break;
                case 16:
                    i = (i * 53) + zzuq.zzbd(zzxj.zzl(t, j));
                    break;
                case 17:
                    Object zzp2 = zzxj.zzp(t, j);
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
                    i = (i * 53) + zzxj.zzp(t, j).hashCode();
                    break;
                case 50:
                    i = (i * 53) + zzxj.zzp(t, j).hashCode();
                    break;
                case 51:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + zzuq.zzbd(Double.doubleToLongBits(zzf(t, j)));
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
                        i = (i * 53) + zzuq.zzbd(zzi(t, j));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + zzuq.zzbd(zzi(t, j));
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
                        i = (i * 53) + zzuq.zzbd(zzi(t, j));
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
                        i = (i * 53) + zzuq.zzu(zzj(t, j));
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + ((String) zzxj.zzp(t, j)).hashCode();
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + zzxj.zzp(t, j).hashCode();
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + zzxj.zzp(t, j).hashCode();
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
                        i = (i * 53) + zzuq.zzbd(zzi(t, j));
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
                        i = (i * 53) + zzuq.zzbd(zzi(t, j));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zza(t, i3, i2)) {
                        i = (i * 53) + zzxj.zzp(t, j).hashCode();
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i * 53) + this.zzcbe.zzal(t).hashCode();
        return this.zzcav ? (hashCode * 53) + this.zzcbf.zzw(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.measurement.zzwl
    public final void zzd(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.zzcaq.length; i += 3) {
                int zzbt = zzbt(i);
                long j = (long) (1048575 & zzbt);
                int i2 = this.zzcaq[i];
                switch ((zzbt & 267386880) >>> 20) {
                    case 0:
                        if (zzb(t2, i)) {
                            zzxj.zza(t, j, zzxj.zzo(t2, j));
                            zzc(t, i);
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zzb(t2, i)) {
                            zzxj.zza((Object) t, j, zzxj.zzn(t2, j));
                            zzc(t, i);
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (zzb(t2, i)) {
                            zzxj.zza((Object) t, j, zzxj.zzl(t2, j));
                            zzc(t, i);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (zzb(t2, i)) {
                            zzxj.zza((Object) t, j, zzxj.zzl(t2, j));
                            zzc(t, i);
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (zzb(t2, i)) {
                            zzxj.zzb(t, j, zzxj.zzk(t2, j));
                            zzc(t, i);
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (zzb(t2, i)) {
                            zzxj.zza((Object) t, j, zzxj.zzl(t2, j));
                            zzc(t, i);
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (zzb(t2, i)) {
                            zzxj.zzb(t, j, zzxj.zzk(t2, j));
                            zzc(t, i);
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (zzb(t2, i)) {
                            zzxj.zza(t, j, zzxj.zzm(t2, j));
                            zzc(t, i);
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (zzb(t2, i)) {
                            zzxj.zza(t, j, zzxj.zzp(t2, j));
                            zzc(t, i);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        zza(t, t2, i);
                        break;
                    case 10:
                        if (zzb(t2, i)) {
                            zzxj.zza(t, j, zzxj.zzp(t2, j));
                            zzc(t, i);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (zzb(t2, i)) {
                            zzxj.zzb(t, j, zzxj.zzk(t2, j));
                            zzc(t, i);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (zzb(t2, i)) {
                            zzxj.zzb(t, j, zzxj.zzk(t2, j));
                            zzc(t, i);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (zzb(t2, i)) {
                            zzxj.zzb(t, j, zzxj.zzk(t2, j));
                            zzc(t, i);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (zzb(t2, i)) {
                            zzxj.zza((Object) t, j, zzxj.zzl(t2, j));
                            zzc(t, i);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (zzb(t2, i)) {
                            zzxj.zzb(t, j, zzxj.zzk(t2, j));
                            zzc(t, i);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (zzb(t2, i)) {
                            zzxj.zza((Object) t, j, zzxj.zzl(t2, j));
                            zzc(t, i);
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
                        this.zzcbd.zza(t, t2, j);
                        break;
                    case 50:
                        zzwn.zza(this.zzcbg, t, t2, j);
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
                            zzxj.zza(t, j, zzxj.zzp(t2, j));
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
                            zzxj.zza(t, j, zzxj.zzp(t2, j));
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
            if (!this.zzcax) {
                zzwn.zza(this.zzcbe, t, t2);
                if (this.zzcav) {
                    zzwn.zza(this.zzcbf, t, t2);
                    return;
                }
                return;
            }
            return;
        }
        throw new NullPointerException();
    }

    private final void zza(T t, T t2, int i) {
        long zzbt = (long) (zzbt(i) & 1048575);
        if (zzb(t2, i)) {
            Object zzp = zzxj.zzp(t, zzbt);
            Object zzp2 = zzxj.zzp(t2, zzbt);
            if (zzp != null && zzp2 != null) {
                zzxj.zza(t, zzbt, zzuq.zzb(zzp, zzp2));
                zzc(t, i);
            } else if (zzp2 != null) {
                zzxj.zza(t, zzbt, zzp2);
                zzc(t, i);
            }
        }
    }

    private final void zzb(T t, T t2, int i) {
        int zzbt = zzbt(i);
        int i2 = this.zzcaq[i];
        long j = (long) (zzbt & 1048575);
        if (zza(t2, i2, i)) {
            Object zzp = zzxj.zzp(t, j);
            Object zzp2 = zzxj.zzp(t2, j);
            if (zzp != null && zzp2 != null) {
                zzxj.zza(t, j, zzuq.zzb(zzp, zzp2));
                zzb(t, i2, i);
            } else if (zzp2 != null) {
                zzxj.zza(t, j, zzp2);
                zzb(t, i2, i);
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzwl
    public final int zzai(T t) {
        int i;
        int i2;
        long j;
        int i3 = 267386880;
        if (this.zzcax) {
            Unsafe unsafe = zzcap;
            int i4 = 0;
            int i5 = 0;
            while (i4 < this.zzcaq.length) {
                int zzbt = zzbt(i4);
                int i6 = (zzbt & i3) >>> 20;
                int i7 = this.zzcaq[i4];
                long j2 = (long) (zzbt & 1048575);
                int i8 = (i6 < zzui.DOUBLE_LIST_PACKED.id() || i6 > zzui.SINT64_LIST_PACKED.id()) ? 0 : this.zzcaq[i4 + 2] & 1048575;
                switch (i6) {
                    case 0:
                        if (zzb(t, i4)) {
                            i5 += zztv.zzb(i7, 0.0d);
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zzb(t, i4)) {
                            i5 += zztv.zzb(i7, 0.0f);
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (zzb(t, i4)) {
                            i5 += zztv.zzd(i7, zzxj.zzl(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (zzb(t, i4)) {
                            i5 += zztv.zze(i7, zzxj.zzl(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (zzb(t, i4)) {
                            i5 += zztv.zzh(i7, zzxj.zzk(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (zzb(t, i4)) {
                            i5 += zztv.zzg(i7, 0L);
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (zzb(t, i4)) {
                            i5 += zztv.zzk(i7, 0);
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (zzb(t, i4)) {
                            i5 += zztv.zzc(i7, true);
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (zzb(t, i4)) {
                            Object zzp = zzxj.zzp(t, j2);
                            if (zzp instanceof zzte) {
                                i5 += zztv.zzc(i7, (zzte) zzp);
                                break;
                            } else {
                                i5 += zztv.zzc(i7, (String) zzp);
                                break;
                            }
                        } else {
                            break;
                        }
                    case 9:
                        if (zzb(t, i4)) {
                            i5 += zzwn.zzc(i7, zzxj.zzp(t, j2), zzbq(i4));
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (zzb(t, i4)) {
                            i5 += zztv.zzc(i7, (zzte) zzxj.zzp(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (zzb(t, i4)) {
                            i5 += zztv.zzi(i7, zzxj.zzk(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (zzb(t, i4)) {
                            i5 += zztv.zzm(i7, zzxj.zzk(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (zzb(t, i4)) {
                            i5 += zztv.zzl(i7, 0);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (zzb(t, i4)) {
                            i5 += zztv.zzh(i7, 0L);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (zzb(t, i4)) {
                            i5 += zztv.zzj(i7, zzxj.zzk(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (zzb(t, i4)) {
                            i5 += zztv.zzf(i7, zzxj.zzl(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (zzb(t, i4)) {
                            i5 += zztv.zzc(i7, (zzvv) zzxj.zzp(t, j2), zzbq(i4));
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        i5 += zzwn.zzw(i7, zze(t, j2), false);
                        break;
                    case 19:
                        i5 += zzwn.zzv(i7, zze(t, j2), false);
                        break;
                    case 20:
                        i5 += zzwn.zzo(i7, zze(t, j2), false);
                        break;
                    case 21:
                        i5 += zzwn.zzp(i7, zze(t, j2), false);
                        break;
                    case 22:
                        i5 += zzwn.zzs(i7, zze(t, j2), false);
                        break;
                    case 23:
                        i5 += zzwn.zzw(i7, zze(t, j2), false);
                        break;
                    case 24:
                        i5 += zzwn.zzv(i7, zze(t, j2), false);
                        break;
                    case 25:
                        i5 += zzwn.zzx(i7, zze(t, j2), false);
                        break;
                    case 26:
                        i5 += zzwn.zzc(i7, zze(t, j2));
                        break;
                    case 27:
                        i5 += zzwn.zzc(i7, (List<?>) zze(t, j2), zzbq(i4));
                        break;
                    case 28:
                        i5 += zzwn.zzd(i7, zze(t, j2));
                        break;
                    case 29:
                        i5 += zzwn.zzt(i7, zze(t, j2), false);
                        break;
                    case 30:
                        i5 += zzwn.zzr(i7, zze(t, j2), false);
                        break;
                    case 31:
                        i5 += zzwn.zzv(i7, zze(t, j2), false);
                        break;
                    case 32:
                        i5 += zzwn.zzw(i7, zze(t, j2), false);
                        break;
                    case 33:
                        i5 += zzwn.zzu(i7, zze(t, j2), false);
                        break;
                    case 34:
                        i5 += zzwn.zzq(i7, zze(t, j2), false);
                        break;
                    case 35:
                        int zzag = zzwn.zzag((List) unsafe.getObject(t, j2));
                        if (zzag <= 0) {
                            break;
                        } else {
                            if (this.zzcay) {
                                unsafe.putInt(t, (long) i8, zzag);
                            }
                            i5 += zztv.zzbd(i7) + zztv.zzbf(zzag) + zzag;
                            break;
                        }
                    case 36:
                        int zzaf = zzwn.zzaf((List) unsafe.getObject(t, j2));
                        if (zzaf <= 0) {
                            break;
                        } else {
                            if (this.zzcay) {
                                unsafe.putInt(t, (long) i8, zzaf);
                            }
                            i5 += zztv.zzbd(i7) + zztv.zzbf(zzaf) + zzaf;
                            break;
                        }
                    case 37:
                        int zzy = zzwn.zzy((List) unsafe.getObject(t, j2));
                        if (zzy <= 0) {
                            break;
                        } else {
                            if (this.zzcay) {
                                unsafe.putInt(t, (long) i8, zzy);
                            }
                            i5 += zztv.zzbd(i7) + zztv.zzbf(zzy) + zzy;
                            break;
                        }
                    case 38:
                        int zzz = zzwn.zzz((List) unsafe.getObject(t, j2));
                        if (zzz <= 0) {
                            break;
                        } else {
                            if (this.zzcay) {
                                unsafe.putInt(t, (long) i8, zzz);
                            }
                            i5 += zztv.zzbd(i7) + zztv.zzbf(zzz) + zzz;
                            break;
                        }
                    case 39:
                        int zzac = zzwn.zzac((List) unsafe.getObject(t, j2));
                        if (zzac <= 0) {
                            break;
                        } else {
                            if (this.zzcay) {
                                unsafe.putInt(t, (long) i8, zzac);
                            }
                            i5 += zztv.zzbd(i7) + zztv.zzbf(zzac) + zzac;
                            break;
                        }
                    case 40:
                        int zzag2 = zzwn.zzag((List) unsafe.getObject(t, j2));
                        if (zzag2 <= 0) {
                            break;
                        } else {
                            if (this.zzcay) {
                                unsafe.putInt(t, (long) i8, zzag2);
                            }
                            i5 += zztv.zzbd(i7) + zztv.zzbf(zzag2) + zzag2;
                            break;
                        }
                    case 41:
                        int zzaf2 = zzwn.zzaf((List) unsafe.getObject(t, j2));
                        if (zzaf2 <= 0) {
                            break;
                        } else {
                            if (this.zzcay) {
                                unsafe.putInt(t, (long) i8, zzaf2);
                            }
                            i5 += zztv.zzbd(i7) + zztv.zzbf(zzaf2) + zzaf2;
                            break;
                        }
                    case 42:
                        int zzah = zzwn.zzah((List) unsafe.getObject(t, j2));
                        if (zzah <= 0) {
                            break;
                        } else {
                            if (this.zzcay) {
                                unsafe.putInt(t, (long) i8, zzah);
                            }
                            i5 += zztv.zzbd(i7) + zztv.zzbf(zzah) + zzah;
                            break;
                        }
                    case 43:
                        int zzad = zzwn.zzad((List) unsafe.getObject(t, j2));
                        if (zzad <= 0) {
                            break;
                        } else {
                            if (this.zzcay) {
                                unsafe.putInt(t, (long) i8, zzad);
                            }
                            i5 += zztv.zzbd(i7) + zztv.zzbf(zzad) + zzad;
                            break;
                        }
                    case 44:
                        int zzab = zzwn.zzab((List) unsafe.getObject(t, j2));
                        if (zzab <= 0) {
                            break;
                        } else {
                            if (this.zzcay) {
                                unsafe.putInt(t, (long) i8, zzab);
                            }
                            i5 += zztv.zzbd(i7) + zztv.zzbf(zzab) + zzab;
                            break;
                        }
                    case 45:
                        int zzaf3 = zzwn.zzaf((List) unsafe.getObject(t, j2));
                        if (zzaf3 <= 0) {
                            break;
                        } else {
                            if (this.zzcay) {
                                unsafe.putInt(t, (long) i8, zzaf3);
                            }
                            i5 += zztv.zzbd(i7) + zztv.zzbf(zzaf3) + zzaf3;
                            break;
                        }
                    case 46:
                        int zzag3 = zzwn.zzag((List) unsafe.getObject(t, j2));
                        if (zzag3 <= 0) {
                            break;
                        } else {
                            if (this.zzcay) {
                                unsafe.putInt(t, (long) i8, zzag3);
                            }
                            i5 += zztv.zzbd(i7) + zztv.zzbf(zzag3) + zzag3;
                            break;
                        }
                    case 47:
                        int zzae = zzwn.zzae((List) unsafe.getObject(t, j2));
                        if (zzae <= 0) {
                            break;
                        } else {
                            if (this.zzcay) {
                                unsafe.putInt(t, (long) i8, zzae);
                            }
                            i5 += zztv.zzbd(i7) + zztv.zzbf(zzae) + zzae;
                            break;
                        }
                    case 48:
                        int zzaa = zzwn.zzaa((List) unsafe.getObject(t, j2));
                        if (zzaa <= 0) {
                            break;
                        } else {
                            if (this.zzcay) {
                                unsafe.putInt(t, (long) i8, zzaa);
                            }
                            i5 += zztv.zzbd(i7) + zztv.zzbf(zzaa) + zzaa;
                            break;
                        }
                    case 49:
                        i5 += zzwn.zzd(i7, zze(t, j2), zzbq(i4));
                        break;
                    case 50:
                        i5 += this.zzcbg.zzb(i7, zzxj.zzp(t, j2), zzbr(i4));
                        break;
                    case 51:
                        if (zza(t, i7, i4)) {
                            i5 += zztv.zzb(i7, 0.0d);
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (zza(t, i7, i4)) {
                            i5 += zztv.zzb(i7, 0.0f);
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (zza(t, i7, i4)) {
                            i5 += zztv.zzd(i7, zzi(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (zza(t, i7, i4)) {
                            i5 += zztv.zze(i7, zzi(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (zza(t, i7, i4)) {
                            i5 += zztv.zzh(i7, zzh(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (zza(t, i7, i4)) {
                            i5 += zztv.zzg(i7, 0L);
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (zza(t, i7, i4)) {
                            i5 += zztv.zzk(i7, 0);
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (zza(t, i7, i4)) {
                            i5 += zztv.zzc(i7, true);
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (zza(t, i7, i4)) {
                            Object zzp2 = zzxj.zzp(t, j2);
                            if (zzp2 instanceof zzte) {
                                i5 += zztv.zzc(i7, (zzte) zzp2);
                                break;
                            } else {
                                i5 += zztv.zzc(i7, (String) zzp2);
                                break;
                            }
                        } else {
                            break;
                        }
                    case 60:
                        if (zza(t, i7, i4)) {
                            i5 += zzwn.zzc(i7, zzxj.zzp(t, j2), zzbq(i4));
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (zza(t, i7, i4)) {
                            i5 += zztv.zzc(i7, (zzte) zzxj.zzp(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (zza(t, i7, i4)) {
                            i5 += zztv.zzi(i7, zzh(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (zza(t, i7, i4)) {
                            i5 += zztv.zzm(i7, zzh(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (zza(t, i7, i4)) {
                            i5 += zztv.zzl(i7, 0);
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (zza(t, i7, i4)) {
                            i5 += zztv.zzh(i7, 0L);
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (zza(t, i7, i4)) {
                            i5 += zztv.zzj(i7, zzh(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (zza(t, i7, i4)) {
                            i5 += zztv.zzf(i7, zzi(t, j2));
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (zza(t, i7, i4)) {
                            i5 += zztv.zzc(i7, (zzvv) zzxj.zzp(t, j2), zzbq(i4));
                            break;
                        } else {
                            break;
                        }
                }
                i4 += 3;
                i3 = 267386880;
            }
            return i5 + zza((zzxd) this.zzcbe, (Object) t);
        }
        Unsafe unsafe2 = zzcap;
        int i9 = 0;
        int i10 = -1;
        int i11 = 0;
        for (int i12 = 0; i12 < this.zzcaq.length; i12 += 3) {
            int zzbt2 = zzbt(i12);
            int[] iArr = this.zzcaq;
            int i13 = iArr[i12];
            int i14 = (zzbt2 & 267386880) >>> 20;
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
            } else if (!this.zzcay || i14 < zzui.DOUBLE_LIST_PACKED.id() || i14 > zzui.SINT64_LIST_PACKED.id()) {
                i2 = 0;
                i = 0;
            } else {
                i2 = this.zzcaq[i12 + 2] & 1048575;
                i = 0;
            }
            long j3 = (long) (zzbt2 & 1048575);
            switch (i14) {
                case 0:
                    j = 0;
                    if ((i11 & i) != 0) {
                        i9 += zztv.zzb(i13, 0.0d);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    j = 0;
                    if ((i11 & i) != 0) {
                        i9 += zztv.zzb(i13, 0.0f);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    j = 0;
                    if ((i11 & i) != 0) {
                        i9 += zztv.zzd(i13, unsafe2.getLong(t, j3));
                        break;
                    } else {
                        break;
                    }
                case 3:
                    j = 0;
                    if ((i11 & i) != 0) {
                        i9 += zztv.zze(i13, unsafe2.getLong(t, j3));
                        break;
                    } else {
                        break;
                    }
                case 4:
                    j = 0;
                    if ((i11 & i) != 0) {
                        i9 += zztv.zzh(i13, unsafe2.getInt(t, j3));
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if ((i11 & i) != 0) {
                        j = 0;
                        i9 += zztv.zzg(i13, 0L);
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 6:
                    if ((i11 & i) != 0) {
                        i9 += zztv.zzk(i13, 0);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 7:
                    if ((i11 & i) != 0) {
                        i9 += zztv.zzc(i13, true);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 8:
                    if ((i11 & i) != 0) {
                        Object object = unsafe2.getObject(t, j3);
                        if (object instanceof zzte) {
                            i9 += zztv.zzc(i13, (zzte) object);
                            j = 0;
                            break;
                        } else {
                            i9 += zztv.zzc(i13, (String) object);
                            j = 0;
                            break;
                        }
                    } else {
                        j = 0;
                        break;
                    }
                case 9:
                    if ((i11 & i) != 0) {
                        i9 += zzwn.zzc(i13, unsafe2.getObject(t, j3), zzbq(i12));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 10:
                    if ((i11 & i) != 0) {
                        i9 += zztv.zzc(i13, (zzte) unsafe2.getObject(t, j3));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 11:
                    if ((i11 & i) != 0) {
                        i9 += zztv.zzi(i13, unsafe2.getInt(t, j3));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 12:
                    if ((i11 & i) != 0) {
                        i9 += zztv.zzm(i13, unsafe2.getInt(t, j3));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 13:
                    if ((i11 & i) != 0) {
                        i9 += zztv.zzl(i13, 0);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 14:
                    if ((i11 & i) != 0) {
                        i9 += zztv.zzh(i13, 0L);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 15:
                    if ((i11 & i) != 0) {
                        i9 += zztv.zzj(i13, unsafe2.getInt(t, j3));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 16:
                    if ((i11 & i) != 0) {
                        i9 += zztv.zzf(i13, unsafe2.getLong(t, j3));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 17:
                    if ((i11 & i) != 0) {
                        i9 += zztv.zzc(i13, (zzvv) unsafe2.getObject(t, j3), zzbq(i12));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 18:
                    i9 += zzwn.zzw(i13, (List) unsafe2.getObject(t, j3), false);
                    j = 0;
                    break;
                case 19:
                    i9 += zzwn.zzv(i13, (List) unsafe2.getObject(t, j3), false);
                    j = 0;
                    break;
                case 20:
                    i9 += zzwn.zzo(i13, (List) unsafe2.getObject(t, j3), false);
                    j = 0;
                    break;
                case 21:
                    i9 += zzwn.zzp(i13, (List) unsafe2.getObject(t, j3), false);
                    j = 0;
                    break;
                case 22:
                    i9 += zzwn.zzs(i13, (List) unsafe2.getObject(t, j3), false);
                    j = 0;
                    break;
                case 23:
                    i9 += zzwn.zzw(i13, (List) unsafe2.getObject(t, j3), false);
                    j = 0;
                    break;
                case 24:
                    i9 += zzwn.zzv(i13, (List) unsafe2.getObject(t, j3), false);
                    j = 0;
                    break;
                case 25:
                    i9 += zzwn.zzx(i13, (List) unsafe2.getObject(t, j3), false);
                    j = 0;
                    break;
                case 26:
                    i9 += zzwn.zzc(i13, (List) unsafe2.getObject(t, j3));
                    j = 0;
                    break;
                case 27:
                    i9 += zzwn.zzc(i13, (List<?>) ((List) unsafe2.getObject(t, j3)), zzbq(i12));
                    j = 0;
                    break;
                case 28:
                    i9 += zzwn.zzd(i13, (List) unsafe2.getObject(t, j3));
                    j = 0;
                    break;
                case 29:
                    i9 += zzwn.zzt(i13, (List) unsafe2.getObject(t, j3), false);
                    j = 0;
                    break;
                case 30:
                    i9 += zzwn.zzr(i13, (List) unsafe2.getObject(t, j3), false);
                    j = 0;
                    break;
                case 31:
                    i9 += zzwn.zzv(i13, (List) unsafe2.getObject(t, j3), false);
                    j = 0;
                    break;
                case 32:
                    i9 += zzwn.zzw(i13, (List) unsafe2.getObject(t, j3), false);
                    j = 0;
                    break;
                case 33:
                    i9 += zzwn.zzu(i13, (List) unsafe2.getObject(t, j3), false);
                    j = 0;
                    break;
                case 34:
                    i9 += zzwn.zzq(i13, (List) unsafe2.getObject(t, j3), false);
                    j = 0;
                    break;
                case 35:
                    int zzag4 = zzwn.zzag((List) unsafe2.getObject(t, j3));
                    if (zzag4 > 0) {
                        if (this.zzcay) {
                            unsafe2.putInt(t, (long) i2, zzag4);
                        }
                        i9 += zztv.zzbd(i13) + zztv.zzbf(zzag4) + zzag4;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 36:
                    int zzaf4 = zzwn.zzaf((List) unsafe2.getObject(t, j3));
                    if (zzaf4 > 0) {
                        if (this.zzcay) {
                            unsafe2.putInt(t, (long) i2, zzaf4);
                        }
                        i9 += zztv.zzbd(i13) + zztv.zzbf(zzaf4) + zzaf4;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 37:
                    int zzy2 = zzwn.zzy((List) unsafe2.getObject(t, j3));
                    if (zzy2 > 0) {
                        if (this.zzcay) {
                            unsafe2.putInt(t, (long) i2, zzy2);
                        }
                        i9 += zztv.zzbd(i13) + zztv.zzbf(zzy2) + zzy2;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 38:
                    int zzz2 = zzwn.zzz((List) unsafe2.getObject(t, j3));
                    if (zzz2 > 0) {
                        if (this.zzcay) {
                            unsafe2.putInt(t, (long) i2, zzz2);
                        }
                        i9 += zztv.zzbd(i13) + zztv.zzbf(zzz2) + zzz2;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 39:
                    int zzac2 = zzwn.zzac((List) unsafe2.getObject(t, j3));
                    if (zzac2 > 0) {
                        if (this.zzcay) {
                            unsafe2.putInt(t, (long) i2, zzac2);
                        }
                        i9 += zztv.zzbd(i13) + zztv.zzbf(zzac2) + zzac2;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 40:
                    int zzag5 = zzwn.zzag((List) unsafe2.getObject(t, j3));
                    if (zzag5 > 0) {
                        if (this.zzcay) {
                            unsafe2.putInt(t, (long) i2, zzag5);
                        }
                        i9 += zztv.zzbd(i13) + zztv.zzbf(zzag5) + zzag5;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 41:
                    int zzaf5 = zzwn.zzaf((List) unsafe2.getObject(t, j3));
                    if (zzaf5 > 0) {
                        if (this.zzcay) {
                            unsafe2.putInt(t, (long) i2, zzaf5);
                        }
                        i9 += zztv.zzbd(i13) + zztv.zzbf(zzaf5) + zzaf5;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 42:
                    int zzah2 = zzwn.zzah((List) unsafe2.getObject(t, j3));
                    if (zzah2 > 0) {
                        if (this.zzcay) {
                            unsafe2.putInt(t, (long) i2, zzah2);
                        }
                        i9 += zztv.zzbd(i13) + zztv.zzbf(zzah2) + zzah2;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 43:
                    int zzad2 = zzwn.zzad((List) unsafe2.getObject(t, j3));
                    if (zzad2 > 0) {
                        if (this.zzcay) {
                            unsafe2.putInt(t, (long) i2, zzad2);
                        }
                        i9 += zztv.zzbd(i13) + zztv.zzbf(zzad2) + zzad2;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 44:
                    int zzab2 = zzwn.zzab((List) unsafe2.getObject(t, j3));
                    if (zzab2 > 0) {
                        if (this.zzcay) {
                            unsafe2.putInt(t, (long) i2, zzab2);
                        }
                        i9 += zztv.zzbd(i13) + zztv.zzbf(zzab2) + zzab2;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 45:
                    int zzaf6 = zzwn.zzaf((List) unsafe2.getObject(t, j3));
                    if (zzaf6 > 0) {
                        if (this.zzcay) {
                            unsafe2.putInt(t, (long) i2, zzaf6);
                        }
                        i9 += zztv.zzbd(i13) + zztv.zzbf(zzaf6) + zzaf6;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 46:
                    int zzag6 = zzwn.zzag((List) unsafe2.getObject(t, j3));
                    if (zzag6 > 0) {
                        if (this.zzcay) {
                            unsafe2.putInt(t, (long) i2, zzag6);
                        }
                        i9 += zztv.zzbd(i13) + zztv.zzbf(zzag6) + zzag6;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 47:
                    int zzae2 = zzwn.zzae((List) unsafe2.getObject(t, j3));
                    if (zzae2 > 0) {
                        if (this.zzcay) {
                            unsafe2.putInt(t, (long) i2, zzae2);
                        }
                        i9 += zztv.zzbd(i13) + zztv.zzbf(zzae2) + zzae2;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 48:
                    int zzaa2 = zzwn.zzaa((List) unsafe2.getObject(t, j3));
                    if (zzaa2 > 0) {
                        if (this.zzcay) {
                            unsafe2.putInt(t, (long) i2, zzaa2);
                        }
                        i9 += zztv.zzbd(i13) + zztv.zzbf(zzaa2) + zzaa2;
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 49:
                    i9 += zzwn.zzd(i13, (List) unsafe2.getObject(t, j3), zzbq(i12));
                    j = 0;
                    break;
                case 50:
                    i9 += this.zzcbg.zzb(i13, unsafe2.getObject(t, j3), zzbr(i12));
                    j = 0;
                    break;
                case 51:
                    if (zza(t, i13, i12)) {
                        i9 += zztv.zzb(i13, 0.0d);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 52:
                    if (zza(t, i13, i12)) {
                        i9 += zztv.zzb(i13, 0.0f);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 53:
                    if (zza(t, i13, i12)) {
                        i9 += zztv.zzd(i13, zzi(t, j3));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 54:
                    if (zza(t, i13, i12)) {
                        i9 += zztv.zze(i13, zzi(t, j3));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 55:
                    if (zza(t, i13, i12)) {
                        i9 += zztv.zzh(i13, zzh(t, j3));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 56:
                    if (zza(t, i13, i12)) {
                        i9 += zztv.zzg(i13, 0L);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 57:
                    if (zza(t, i13, i12)) {
                        i9 += zztv.zzk(i13, 0);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 58:
                    if (zza(t, i13, i12)) {
                        i9 += zztv.zzc(i13, true);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 59:
                    if (zza(t, i13, i12)) {
                        Object object2 = unsafe2.getObject(t, j3);
                        if (object2 instanceof zzte) {
                            i9 += zztv.zzc(i13, (zzte) object2);
                            j = 0;
                            break;
                        } else {
                            i9 += zztv.zzc(i13, (String) object2);
                            j = 0;
                            break;
                        }
                    } else {
                        j = 0;
                        break;
                    }
                case 60:
                    if (zza(t, i13, i12)) {
                        i9 += zzwn.zzc(i13, unsafe2.getObject(t, j3), zzbq(i12));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 61:
                    if (zza(t, i13, i12)) {
                        i9 += zztv.zzc(i13, (zzte) unsafe2.getObject(t, j3));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 62:
                    if (zza(t, i13, i12)) {
                        i9 += zztv.zzi(i13, zzh(t, j3));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 63:
                    if (zza(t, i13, i12)) {
                        i9 += zztv.zzm(i13, zzh(t, j3));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 64:
                    if (zza(t, i13, i12)) {
                        i9 += zztv.zzl(i13, 0);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 65:
                    if (zza(t, i13, i12)) {
                        i9 += zztv.zzh(i13, 0L);
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 66:
                    if (zza(t, i13, i12)) {
                        i9 += zztv.zzj(i13, zzh(t, j3));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 67:
                    if (zza(t, i13, i12)) {
                        i9 += zztv.zzf(i13, zzi(t, j3));
                        j = 0;
                        break;
                    } else {
                        j = 0;
                        break;
                    }
                case 68:
                    if (zza(t, i13, i12)) {
                        i9 += zztv.zzc(i13, (zzvv) unsafe2.getObject(t, j3), zzbq(i12));
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
        int zza = i9 + zza((zzxd) this.zzcbe, (Object) t);
        return this.zzcav ? zza + this.zzcbf.zzw(t).zzvx() : zza;
    }

    private static <UT, UB> int zza(zzxd<UT, UB> zzxd, T t) {
        return zzxd.zzai(zzxd.zzal(t));
    }

    private static <E> List<E> zze(Object obj, long j) {
        return (List) zzxj.zzp(obj, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0511  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x054f  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0a27  */
    @Override // com.google.android.gms.internal.measurement.zzwl
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.gms.internal.measurement.zzxy r15) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 2914
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzvz.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzxy):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:190:0x051c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r19, com.google.android.gms.internal.measurement.zzxy r20) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1476
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzvz.zzb(java.lang.Object, com.google.android.gms.internal.measurement.zzxy):void");
    }

    private final <K, V> void zza(zzxy zzxy, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzxy.zza(i, this.zzcbg.zzah(zzbr(i2)), this.zzcbg.zzad(obj));
        }
    }

    private static <UT, UB> void zza(zzxd<UT, UB> zzxd, T t, zzxy zzxy) throws IOException {
        zzxd.zza(zzxd.zzal(t), zzxy);
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.instructions.IndexInsnNode.isSame(IndexInsnNode.java:36)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    @Override // com.google.android.gms.internal.measurement.zzwl
    public final void zza(T r18, com.google.android.gms.internal.measurement.zzwk r19, com.google.android.gms.internal.measurement.zzub r20) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1668
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzvz.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzwk, com.google.android.gms.internal.measurement.zzub):void");
    }

    private final zzwl zzbq(int i) {
        int i2 = (i / 3) << 1;
        zzwl zzwl = (zzwl) this.zzcar[i2];
        if (zzwl != null) {
            return zzwl;
        }
        zzwl<T> zzi = zzwh.zzxt().zzi((Class) this.zzcar[i2 + 1]);
        this.zzcar[i2] = zzi;
        return zzi;
    }

    private final Object zzbr(int i) {
        return this.zzcar[(i / 3) << 1];
    }

    private final zzut zzbs(int i) {
        return (zzut) this.zzcar[((i / 3) << 1) + 1];
    }

    @Override // com.google.android.gms.internal.measurement.zzwl
    public final void zzy(T t) {
        int i;
        int i2 = this.zzcba;
        while (true) {
            i = this.zzcbb;
            if (i2 >= i) {
                break;
            }
            long zzbt = (long) (zzbt(this.zzcaz[i2]) & 1048575);
            Object zzp = zzxj.zzp(t, zzbt);
            if (zzp != null) {
                zzxj.zza(t, zzbt, this.zzcbg.zzaf(zzp));
            }
            i2++;
        }
        int length = this.zzcaz.length;
        while (i < length) {
            this.zzcbd.zzb(t, (long) this.zzcaz[i]);
            i++;
        }
        this.zzcbe.zzy(t);
        if (this.zzcav) {
            this.zzcbf.zzy(t);
        }
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzxd<UT, UB> zzxd) {
        zzut zzbs;
        int i2 = this.zzcaq[i];
        Object zzp = zzxj.zzp(obj, (long) (zzbt(i) & 1048575));
        return (zzp == null || (zzbs = zzbs(i)) == null) ? ub : (UB) zza(i, i2, (Map<K, V>) this.zzcbg.zzac(zzp), zzbs, ub, zzxd);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzut zzut, UB ub, zzxd<UT, UB> zzxd) {
        zzvo<?, ?> zzah = this.zzcbg.zzah(zzbr(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzut.zzb(next.getValue().intValue())) {
                if (ub == null) {
                    ub = zzxd.zzyk();
                }
                zztm zzao = zzte.zzao(zzvn.zza(zzah, next.getKey(), next.getValue()));
                try {
                    zzvn.zza(zzao.zzui(), zzah, next.getKey(), next.getValue());
                    zzxd.zza(ub, i2, zzao.zzuh());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.google.android.gms.internal.measurement.zzwl] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v14, types: [com.google.android.gms.internal.measurement.zzwl] */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0104, code lost:
        continue;
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.google.android.gms.internal.measurement.zzwl
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzaj(T r14) {
        /*
        // Method dump skipped, instructions count: 290
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzvz.zzaj(java.lang.Object):boolean");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.android.gms.internal.measurement.zzwl */
    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zzwl zzwl) {
        return zzwl.zzaj(zzxj.zzp(obj, (long) (i & 1048575)));
    }

    private static void zza(int i, Object obj, zzxy zzxy) throws IOException {
        if (obj instanceof String) {
            zzxy.zzb(i, (String) obj);
        } else {
            zzxy.zza(i, (zzte) obj);
        }
    }

    private final void zza(Object obj, int i, zzwk zzwk) throws IOException {
        if (zzbv(i)) {
            zzxj.zza(obj, (long) (i & 1048575), zzwk.zzuq());
        } else if (this.zzcaw) {
            zzxj.zza(obj, (long) (i & 1048575), zzwk.readString());
        } else {
            zzxj.zza(obj, (long) (i & 1048575), zzwk.zzur());
        }
    }

    private final int zzbt(int i) {
        return this.zzcaq[i + 1];
    }

    private final int zzbu(int i) {
        return this.zzcaq[i + 2];
    }

    private static <T> double zzf(T t, long j) {
        return ((Double) zzxj.zzp(t, j)).doubleValue();
    }

    private static <T> float zzg(T t, long j) {
        return ((Float) zzxj.zzp(t, j)).floatValue();
    }

    private static <T> int zzh(T t, long j) {
        return ((Integer) zzxj.zzp(t, j)).intValue();
    }

    private static <T> long zzi(T t, long j) {
        return ((Long) zzxj.zzp(t, j)).longValue();
    }

    private static <T> boolean zzj(T t, long j) {
        return ((Boolean) zzxj.zzp(t, j)).booleanValue();
    }

    private final boolean zzc(T t, T t2, int i) {
        return zzb(t, i) == zzb(t2, i);
    }

    private final boolean zza(T t, int i, int i2, int i3) {
        if (this.zzcax) {
            return zzb(t, i);
        }
        return (i2 & i3) != 0;
    }

    private final boolean zzb(T t, int i) {
        if (this.zzcax) {
            int zzbt = zzbt(i);
            long j = (long) (zzbt & 1048575);
            switch ((zzbt & 267386880) >>> 20) {
                case 0:
                    return zzxj.zzo(t, j) != 0.0d;
                case 1:
                    return zzxj.zzn(t, j) != 0.0f;
                case 2:
                    return zzxj.zzl(t, j) != 0;
                case 3:
                    return zzxj.zzl(t, j) != 0;
                case 4:
                    return zzxj.zzk(t, j) != 0;
                case 5:
                    return zzxj.zzl(t, j) != 0;
                case 6:
                    return zzxj.zzk(t, j) != 0;
                case 7:
                    return zzxj.zzm(t, j);
                case 8:
                    Object zzp = zzxj.zzp(t, j);
                    if (zzp instanceof String) {
                        return !((String) zzp).isEmpty();
                    }
                    if (zzp instanceof zzte) {
                        return !zzte.zzbtq.equals(zzp);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzxj.zzp(t, j) != null;
                case 10:
                    return !zzte.zzbtq.equals(zzxj.zzp(t, j));
                case 11:
                    return zzxj.zzk(t, j) != 0;
                case 12:
                    return zzxj.zzk(t, j) != 0;
                case 13:
                    return zzxj.zzk(t, j) != 0;
                case 14:
                    return zzxj.zzl(t, j) != 0;
                case 15:
                    return zzxj.zzk(t, j) != 0;
                case 16:
                    return zzxj.zzl(t, j) != 0;
                case 17:
                    return zzxj.zzp(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int zzbu = zzbu(i);
            return (zzxj.zzk(t, (long) (zzbu & 1048575)) & (1 << (zzbu >>> 20))) != 0;
        }
    }

    private final void zzc(T t, int i) {
        if (!this.zzcax) {
            int zzbu = zzbu(i);
            long j = (long) (zzbu & 1048575);
            zzxj.zzb(t, j, zzxj.zzk(t, j) | (1 << (zzbu >>> 20)));
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzxj.zzk(t, (long) (zzbu(i2) & 1048575)) == i;
    }

    private final void zzb(T t, int i, int i2) {
        zzxj.zzb(t, (long) (zzbu(i2) & 1048575), i);
    }
}
