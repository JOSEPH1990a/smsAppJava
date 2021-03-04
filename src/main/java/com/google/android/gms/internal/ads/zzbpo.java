package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class zzbpo<E> extends AbstractList<E> implements zzbrk<E> {
    private boolean zzfla = true;

    zzbpo() {
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList
    public boolean add(E e) {
        zzakk();
        return super.add(e);
    }

    @Override // java.util.List, java.util.AbstractList
    public void add(int i, E e) {
        zzakk();
        super.add(i, e);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        zzakk();
        return super.addAll(collection);
    }

    @Override // java.util.List, java.util.AbstractList
    public boolean addAll(int i, Collection<? extends E> collection) {
        zzakk();
        return super.addAll(i, collection);
    }

    public void clear() {
        zzakk();
        super.clear();
    }

    @Override // com.google.android.gms.internal.ads.zzbrk
    public boolean zzaki() {
        return this.zzfla;
    }

    @Override // com.google.android.gms.internal.ads.zzbrk
    public final void zzakj() {
        this.zzfla = false;
    }

    @Override // java.util.List, java.util.AbstractList
    public E remove(int i) {
        zzakk();
        return (E) super.remove(i);
    }

    @Override // java.util.List
    public boolean remove(Object obj) {
        zzakk();
        return super.remove(obj);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        zzakk();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        zzakk();
        return super.retainAll(collection);
    }

    @Override // java.util.List, java.util.AbstractList
    public E set(int i, E e) {
        zzakk();
        return (E) super.set(i, e);
    }

    /* access modifiers changed from: protected */
    public final void zzakk() {
        if (!this.zzfla) {
            throw new UnsupportedOperationException();
        }
    }
}
