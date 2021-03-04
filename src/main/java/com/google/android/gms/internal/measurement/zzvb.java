package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class zzvb<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zzbzt;

    public zzvb(Iterator<Map.Entry<K, Object>> it) {
        this.zzbzt = it;
    }

    public final boolean hasNext() {
        return this.zzbzt.hasNext();
    }

    public final void remove() {
        this.zzbzt.remove();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Object> next = this.zzbzt.next();
        return next.getValue() instanceof zzuy ? new zzva(next) : next;
    }
}
