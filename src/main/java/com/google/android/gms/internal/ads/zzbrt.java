package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzbrt extends zzbpo<String> implements zzbru, RandomAccess {
    private static final zzbrt zzfro;
    private static final zzbru zzfrp = zzfro;
    private final List<Object> zzfrq;

    public zzbrt() {
        this(10);
    }

    public zzbrt(int i) {
        this(new ArrayList(i));
    }

    private zzbrt(ArrayList<Object> arrayList) {
        this.zzfrq = arrayList;
    }

    public final int size() {
        return this.zzfrq.size();
    }

    @Override // com.google.android.gms.internal.ads.zzbpo, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.ads.zzbpo, java.util.List, java.util.AbstractList
    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzakk();
        if (collection instanceof zzbru) {
            collection = ((zzbru) collection).zzano();
        }
        boolean addAll = this.zzfrq.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    @Override // com.google.android.gms.internal.ads.zzbpo
    public final void clear() {
        zzakk();
        this.zzfrq.clear();
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void zzap(zzbpu zzbpu) {
        zzakk();
        this.zzfrq.add(zzbpu);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final Object zzfp(int i) {
        return this.zzfrq.get(i);
    }

    private static String zzu(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzbpu) {
            return ((zzbpu) obj).zzakn();
        }
        return zzbrf.zzw((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final List<?> zzano() {
        return Collections.unmodifiableList(this.zzfrq);
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final zzbru zzanp() {
        return zzaki() ? new zzbtx(this) : this;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzbpo, java.util.List, java.util.AbstractList
    public final /* synthetic */ String set(int i, String str) {
        zzakk();
        return zzu(this.zzfrq.set(i, str));
    }

    @Override // com.google.android.gms.internal.ads.zzbpo, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // com.google.android.gms.internal.ads.zzbpo, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.android.gms.internal.ads.zzbpo, java.util.List
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzbpo, java.util.List, java.util.AbstractList
    public final /* synthetic */ String remove(int i) {
        zzakk();
        Object remove = this.zzfrq.remove(i);
        this.modCount++;
        return zzu(remove);
    }

    @Override // com.google.android.gms.internal.ads.zzbpo, com.google.android.gms.internal.ads.zzbrk
    public final /* bridge */ /* synthetic */ boolean zzaki() {
        return super.zzaki();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzbpo, java.util.List, java.util.AbstractList
    public final /* synthetic */ void add(int i, String str) {
        zzakk();
        this.zzfrq.add(i, str);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzbpo
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.ads.zzbpo
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzbrk
    public final /* synthetic */ zzbrk zzel(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzfrq);
            return new zzbrt(arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzfrq.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzbpu) {
            zzbpu zzbpu = (zzbpu) obj;
            String zzakn = zzbpu.zzakn();
            if (zzbpu.zzako()) {
                this.zzfrq.set(i, zzakn);
            }
            return zzakn;
        }
        byte[] bArr = (byte[]) obj;
        String zzw = zzbrf.zzw(bArr);
        if (zzbrf.zzv(bArr)) {
            this.zzfrq.set(i, zzw);
        }
        return zzw;
    }

    static {
        zzbrt zzbrt = new zzbrt();
        zzfro = zzbrt;
        zzbrt.zzakj();
    }
}
