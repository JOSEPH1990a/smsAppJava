package com.google.android.gms.internal.measurement;

import java.util.List;

final class zzvi extends zzvf {
    private zzvi() {
        super();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzvf
    public final <L> List<L> zza(Object obj, long j) {
        zzuu zzd = zzd(obj, j);
        if (zzd.zztz()) {
            return zzd;
        }
        int size = zzd.size();
        zzuu zzal = zzd.zzal(size == 0 ? 10 : size << 1);
        zzxj.zza(obj, j, zzal);
        return zzal;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzvf
    public final void zzb(Object obj, long j) {
        zzd(obj, j).zzsw();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.gms.internal.measurement.zzuu] */
    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzvf
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzuu<E> zzd = zzd(obj, j);
        zzuu<E> zzd2 = zzd(obj2, j);
        int size = zzd.size();
        int size2 = zzd2.size();
        zzuu<E> zzuu = zzd;
        zzuu = zzd;
        if (size > 0 && size2 > 0) {
            boolean zztz = zzd.zztz();
            zzuu<E> zzuu2 = zzd;
            if (!zztz) {
                zzuu2 = zzd.zzal(size2 + size);
            }
            zzuu2.addAll(zzd2);
            zzuu = zzuu2;
        }
        if (size > 0) {
            zzd2 = zzuu;
        }
        zzxj.zza(obj, j, zzd2);
    }

    private static <E> zzuu<E> zzd(Object obj, long j) {
        return (zzuu) zzxj.zzp(obj, j);
    }
}
