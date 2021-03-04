package com.google.android.gms.internal.measurement;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* access modifiers changed from: package-private */
public class zzwx extends AbstractSet<Map.Entry<K, V>> {
    private final /* synthetic */ zzwo zzcby;

    private zzwx(zzwo zzwo) {
        this.zzcby = zzwo;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return new zzww(this.zzcby, null);
    }

    public int size() {
        return this.zzcby.size();
    }

    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.zzcby.get(entry.getKey());
        Object value = entry.getValue();
        if (obj2 != value) {
            return obj2 != null && obj2.equals(value);
        }
        return true;
    }

    public boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.zzcby.remove(entry.getKey());
        return true;
    }

    public void clear() {
        this.zzcby.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zzcby.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    /* synthetic */ zzwx(zzwo zzwo, zzwp zzwp) {
        this(zzwo);
    }
}
