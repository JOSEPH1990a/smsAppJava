package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

final class zzwi<E> extends zzta<E> {
    private static final zzwi<Object> zzcbm;
    private final List<E> zzbzz;

    public static <E> zzwi<E> zzxu() {
        return (zzwi<E>) zzcbm;
    }

    zzwi() {
        this(new ArrayList(10));
    }

    private zzwi(List<E> list) {
        this.zzbzz = list;
    }

    @Override // java.util.List, com.google.android.gms.internal.measurement.zzta, java.util.AbstractList
    public final void add(int i, E e) {
        zzua();
        this.zzbzz.add(i, e);
        this.modCount++;
    }

    @Override // java.util.List, java.util.AbstractList
    public final E get(int i) {
        return this.zzbzz.get(i);
    }

    @Override // java.util.List, com.google.android.gms.internal.measurement.zzta, java.util.AbstractList
    public final E remove(int i) {
        zzua();
        E remove = this.zzbzz.remove(i);
        this.modCount++;
        return remove;
    }

    @Override // java.util.List, com.google.android.gms.internal.measurement.zzta, java.util.AbstractList
    public final E set(int i, E e) {
        zzua();
        E e2 = this.zzbzz.set(i, e);
        this.modCount++;
        return e2;
    }

    public final int size() {
        return this.zzbzz.size();
    }

    @Override // com.google.android.gms.internal.measurement.zzuu
    public final /* synthetic */ zzuu zzal(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzbzz);
            return new zzwi(arrayList);
        }
        throw new IllegalArgumentException();
    }

    static {
        zzwi<Object> zzwi = new zzwi<>();
        zzcbm = zzwi;
        zzwi.zzsw();
    }
}
