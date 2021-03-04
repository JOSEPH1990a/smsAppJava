package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
public final class zzbsz<E> extends zzbpo<E> {
    private static final zzbsz<Object> zzfte;
    private final List<E> zzfrq;

    public static <E> zzbsz<E> zzaoh() {
        return (zzbsz<E>) zzfte;
    }

    zzbsz() {
        this(new ArrayList(10));
    }

    private zzbsz(List<E> list) {
        this.zzfrq = list;
    }

    @Override // com.google.android.gms.internal.ads.zzbpo, java.util.List, java.util.AbstractList
    public final void add(int i, E e) {
        zzakk();
        this.zzfrq.add(i, e);
        this.modCount++;
    }

    @Override // java.util.List, java.util.AbstractList
    public final E get(int i) {
        return this.zzfrq.get(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbpo, java.util.List, java.util.AbstractList
    public final E remove(int i) {
        zzakk();
        E remove = this.zzfrq.remove(i);
        this.modCount++;
        return remove;
    }

    @Override // com.google.android.gms.internal.ads.zzbpo, java.util.List, java.util.AbstractList
    public final E set(int i, E e) {
        zzakk();
        E e2 = this.zzfrq.set(i, e);
        this.modCount++;
        return e2;
    }

    public final int size() {
        return this.zzfrq.size();
    }

    @Override // com.google.android.gms.internal.ads.zzbrk
    public final /* synthetic */ zzbrk zzel(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzfrq);
            return new zzbsz(arrayList);
        }
        throw new IllegalArgumentException();
    }

    static {
        zzbsz<Object> zzbsz = new zzbsz<>();
        zzfte = zzbsz;
        zzbsz.zzakj();
    }
}
