package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzwq implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private Iterator<Map.Entry<K, V>> zzcbx;
    private final /* synthetic */ zzwo zzcby;

    private zzwq(zzwo zzwo) {
        this.zzcby = zzwo;
        this.pos = this.zzcby.zzcbs.size();
    }

    public final boolean hasNext() {
        int i = this.pos;
        return (i > 0 && i <= this.zzcby.zzcbs.size()) || zzyh().hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private final Iterator<Map.Entry<K, V>> zzyh() {
        if (this.zzcbx == null) {
            this.zzcbx = this.zzcby.zzcbv.entrySet().iterator();
        }
        return this.zzcbx;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        if (zzyh().hasNext()) {
            return (Map.Entry) zzyh().next();
        }
        List list = this.zzcby.zzcbs;
        int i = this.pos - 1;
        this.pos = i;
        return (Map.Entry) list.get(i);
    }

    /* synthetic */ zzwq(zzwo zzwo, zzwp zzwp) {
        this(zzwo);
    }
}
