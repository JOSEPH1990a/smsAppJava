package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzvd extends zzta<String> implements zzve, RandomAccess {
    private static final zzvd zzbzx;
    private static final zzve zzbzy = zzbzx;
    private final List<Object> zzbzz;

    public zzvd() {
        this(10);
    }

    public zzvd(int i) {
        this(new ArrayList(i));
    }

    private zzvd(ArrayList<Object> arrayList) {
        this.zzbzz = arrayList;
    }

    public final int size() {
        return this.zzbzz.size();
    }

    @Override // java.util.AbstractCollection, java.util.List, com.google.android.gms.internal.measurement.zzta, java.util.Collection
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // java.util.List, com.google.android.gms.internal.measurement.zzta, java.util.AbstractList
    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzua();
        if (collection instanceof zzve) {
            collection = ((zzve) collection).zzxb();
        }
        boolean addAll = this.zzbzz.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    @Override // com.google.android.gms.internal.measurement.zzta
    public final void clear() {
        zzua();
        this.zzbzz.clear();
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzve
    public final void zzc(zzte zzte) {
        zzua();
        this.zzbzz.add(zzte);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzve
    public final Object zzbp(int i) {
        return this.zzbzz.get(i);
    }

    private static String zzaa(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzte) {
            return ((zzte) obj).zzud();
        }
        return zzuq.zzm((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzve
    public final List<?> zzxb() {
        return Collections.unmodifiableList(this.zzbzz);
    }

    @Override // com.google.android.gms.internal.measurement.zzve
    public final zzve zzxc() {
        return zztz() ? new zzxg(this) : this;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // java.util.List, com.google.android.gms.internal.measurement.zzta, java.util.AbstractList
    public final /* synthetic */ String set(int i, String str) {
        zzua();
        return zzaa(this.zzbzz.set(i, str));
    }

    @Override // java.util.AbstractCollection, java.util.List, com.google.android.gms.internal.measurement.zzta, java.util.Collection
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.List, com.google.android.gms.internal.measurement.zzta, java.util.Collection
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // java.util.List, com.google.android.gms.internal.measurement.zzta
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, com.google.android.gms.internal.measurement.zzta, java.util.AbstractList
    public final /* synthetic */ String remove(int i) {
        zzua();
        Object remove = this.zzbzz.remove(i);
        this.modCount++;
        return zzaa(remove);
    }

    @Override // com.google.android.gms.internal.measurement.zzuu, com.google.android.gms.internal.measurement.zzta
    public final /* bridge */ /* synthetic */ boolean zztz() {
        return super.zztz();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // java.util.List, com.google.android.gms.internal.measurement.zzta, java.util.AbstractList
    public final /* synthetic */ void add(int i, String str) {
        zzua();
        this.zzbzz.add(i, str);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzta
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.zzta
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzuu
    public final /* synthetic */ zzuu zzal(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzbzz);
            return new zzvd(arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzbzz.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzte) {
            zzte zzte = (zzte) obj;
            String zzud = zzte.zzud();
            if (zzte.zzue()) {
                this.zzbzz.set(i, zzud);
            }
            return zzud;
        }
        byte[] bArr = (byte[]) obj;
        String zzm = zzuq.zzm(bArr);
        if (zzuq.zzl(bArr)) {
            this.zzbzz.set(i, zzm);
        }
        return zzm;
    }

    static {
        zzvd zzvd = new zzvd();
        zzbzx = zzvd;
        zzvd.zzsw();
    }
}
