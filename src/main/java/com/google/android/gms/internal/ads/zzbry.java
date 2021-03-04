package com.google.android.gms.internal.ads;

import java.util.List;

final class zzbry extends zzbrv {
    private zzbry() {
        super();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzbrv
    public final <L> List<L> zza(Object obj, long j) {
        zzbrk zzd = zzd(obj, j);
        if (zzd.zzaki()) {
            return zzd;
        }
        int size = zzd.size();
        zzbrk zzel = zzd.zzel(size == 0 ? 10 : size << 1);
        zzbua.zza(obj, j, zzel);
        return zzel;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzbrv
    public final void zzb(Object obj, long j) {
        zzd(obj, j).zzakj();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.gms.internal.ads.zzbrk] */
    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzbrv
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzbrk<E> zzd = zzd(obj, j);
        zzbrk<E> zzd2 = zzd(obj2, j);
        int size = zzd.size();
        int size2 = zzd2.size();
        zzbrk<E> zzbrk = zzd;
        zzbrk = zzd;
        if (size > 0 && size2 > 0) {
            boolean zzaki = zzd.zzaki();
            zzbrk<E> zzbrk2 = zzd;
            if (!zzaki) {
                zzbrk2 = zzd.zzel(size2 + size);
            }
            zzbrk2.addAll(zzd2);
            zzbrk = zzbrk2;
        }
        if (size > 0) {
            zzd2 = zzbrk;
        }
        zzbua.zza(obj, j, zzd2);
    }

    private static <E> zzbrk<E> zzd(Object obj, long j) {
        return (zzbrk) zzbua.zzp(obj, j);
    }
}
