package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* access modifiers changed from: package-private */
public final class zzwn {
    private static final Class<?> zzcbn = zzya();
    private static final zzxd<?, ?> zzcbo = zzv(false);
    private static final zzxd<?, ?> zzcbp = zzv(true);
    private static final zzxd<?, ?> zzcbq = new zzxf();

    public static void zzj(Class<?> cls) {
        Class<?> cls2;
        if (!zzuo.class.isAssignableFrom(cls) && (cls2 = zzcbn) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zza(int i, List<Double> list, zzxy zzxy, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzxy.zzg(i, list, z);
        }
    }

    public static void zzb(int i, List<Float> list, zzxy zzxy, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzxy.zzf(i, list, z);
        }
    }

    public static void zzc(int i, List<Long> list, zzxy zzxy, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzxy.zzc(i, list, z);
        }
    }

    public static void zzd(int i, List<Long> list, zzxy zzxy, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzxy.zzd(i, list, z);
        }
    }

    public static void zze(int i, List<Long> list, zzxy zzxy, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzxy.zzn(i, list, z);
        }
    }

    public static void zzf(int i, List<Long> list, zzxy zzxy, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzxy.zze(i, list, z);
        }
    }

    public static void zzg(int i, List<Long> list, zzxy zzxy, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzxy.zzl(i, list, z);
        }
    }

    public static void zzh(int i, List<Integer> list, zzxy zzxy, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzxy.zza(i, list, z);
        }
    }

    public static void zzi(int i, List<Integer> list, zzxy zzxy, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzxy.zzj(i, list, z);
        }
    }

    public static void zzj(int i, List<Integer> list, zzxy zzxy, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzxy.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzxy zzxy, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzxy.zzb(i, list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzxy zzxy, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzxy.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzxy zzxy, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzxy.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzxy zzxy, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzxy.zzi(i, list, z);
        }
    }

    public static void zza(int i, List<String> list, zzxy zzxy) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzxy.zza(i, list);
        }
    }

    public static void zzb(int i, List<zzte> list, zzxy zzxy) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzxy.zzb(i, list);
        }
    }

    public static void zza(int i, List<?> list, zzxy zzxy, zzwl zzwl) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzxy.zza(i, list, zzwl);
        }
    }

    public static void zzb(int i, List<?> list, zzxy zzxy, zzwl zzwl) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzxy.zzb(i, list, zzwl);
        }
    }

    static int zzy(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzvj) {
            zzvj zzvj = (zzvj) list;
            i = 0;
            while (i2 < size) {
                i += zztv.zzaw(zzvj.getLong(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zztv.zzaw(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzo(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzy(list) + (list.size() * zztv.zzbd(i));
    }

    static int zzz(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzvj) {
            zzvj zzvj = (zzvj) list;
            i = 0;
            while (i2 < size) {
                i += zztv.zzax(zzvj.getLong(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zztv.zzax(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzp(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzz(list) + (size * zztv.zzbd(i));
    }

    static int zzaa(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzvj) {
            zzvj zzvj = (zzvj) list;
            i = 0;
            while (i2 < size) {
                i += zztv.zzay(zzvj.getLong(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zztv.zzay(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzq(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzaa(list) + (size * zztv.zzbd(i));
    }

    static int zzab(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzup) {
            zzup zzup = (zzup) list;
            i = 0;
            while (i2 < size) {
                i += zztv.zzbj(zzup.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zztv.zzbj(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzr(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzab(list) + (size * zztv.zzbd(i));
    }

    static int zzac(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzup) {
            zzup zzup = (zzup) list;
            i = 0;
            while (i2 < size) {
                i += zztv.zzbe(zzup.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zztv.zzbe(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzs(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzac(list) + (size * zztv.zzbd(i));
    }

    static int zzad(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzup) {
            zzup zzup = (zzup) list;
            i = 0;
            while (i2 < size) {
                i += zztv.zzbf(zzup.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zztv.zzbf(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzt(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzad(list) + (size * zztv.zzbd(i));
    }

    static int zzae(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzup) {
            zzup zzup = (zzup) list;
            i = 0;
            while (i2 < size) {
                i += zztv.zzbg(zzup.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zztv.zzbg(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzu(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzae(list) + (size * zztv.zzbd(i));
    }

    static int zzaf(List<?> list) {
        return list.size() << 2;
    }

    static int zzv(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zztv.zzk(i, 0);
    }

    static int zzag(List<?> list) {
        return list.size() << 3;
    }

    static int zzw(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zztv.zzg(i, 0L);
    }

    static int zzah(List<?> list) {
        return list.size();
    }

    static int zzx(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zztv.zzc(i, true);
    }

    static int zzc(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zzbd = zztv.zzbd(i) * size;
        if (list instanceof zzve) {
            zzve zzve = (zzve) list;
            while (i4 < size) {
                Object zzbp = zzve.zzbp(i4);
                if (zzbp instanceof zzte) {
                    i3 = zztv.zzb((zzte) zzbp);
                } else {
                    i3 = zztv.zzgc((String) zzbp);
                }
                zzbd += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzte) {
                    i2 = zztv.zzb((zzte) obj);
                } else {
                    i2 = zztv.zzgc((String) obj);
                }
                zzbd += i2;
                i4++;
            }
        }
        return zzbd;
    }

    static int zzc(int i, Object obj, zzwl zzwl) {
        if (obj instanceof zzvc) {
            return zztv.zza(i, (zzvc) obj);
        }
        return zztv.zzb(i, (zzvv) obj, zzwl);
    }

    static int zzc(int i, List<?> list, zzwl zzwl) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzbd = zztv.zzbd(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzvc) {
                i2 = zztv.zza((zzvc) obj);
            } else {
                i2 = zztv.zzb((zzvv) obj, zzwl);
            }
            zzbd += i2;
        }
        return zzbd;
    }

    static int zzd(int i, List<zzte> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzbd = size * zztv.zzbd(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzbd += zztv.zzb(list.get(i2));
        }
        return zzbd;
    }

    static int zzd(int i, List<zzvv> list, zzwl zzwl) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zztv.zzc(i, list.get(i3), zzwl);
        }
        return i2;
    }

    public static zzxd<?, ?> zzxx() {
        return zzcbo;
    }

    public static zzxd<?, ?> zzxy() {
        return zzcbp;
    }

    public static zzxd<?, ?> zzxz() {
        return zzcbq;
    }

    private static zzxd<?, ?> zzv(boolean z) {
        try {
            Class<?> zzyb = zzyb();
            if (zzyb == null) {
                return null;
            }
            return (zzxd) zzyb.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzya() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzyb() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean zze(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static <T> void zza(zzvq zzvq, T t, T t2, long j) {
        zzxj.zza(t, j, zzvq.zzc(zzxj.zzp(t, j), zzxj.zzp(t2, j)));
    }

    static <T, FT extends zzuh<FT>> void zza(zzuc<FT> zzuc, T t, T t2) {
        zzuf<FT> zzw = zzuc.zzw(t2);
        if (!zzw.isEmpty()) {
            zzuc.zzx(t).zza(zzw);
        }
    }

    static <T, UT, UB> void zza(zzxd<UT, UB> zzxd, T t, T t2) {
        zzxd.zzf(t, zzxd.zzh(zzxd.zzal(t), zzxd.zzal(t2)));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v5, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    static <UT, UB> UB zza(int i, List<Integer> list, zzut zzut, UB ub, zzxd<UT, UB> zzxd) {
        UB ub2;
        if (zzut == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            ub2 = ub;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzut.zzb(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub2 = (UB) zza(i, intValue, ub2, zzxd);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            ub2 = ub;
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzut.zzb(intValue2)) {
                    Object zza = zza(i, intValue2, ub2, zzxd);
                    it.remove();
                    ub2 = zza;
                }
            }
        }
        return ub2;
    }

    static <UT, UB> UB zza(int i, int i2, UB ub, zzxd<UT, UB> zzxd) {
        if (ub == null) {
            ub = zzxd.zzyk();
        }
        zzxd.zza(ub, i, (long) i2);
        return ub;
    }
}
