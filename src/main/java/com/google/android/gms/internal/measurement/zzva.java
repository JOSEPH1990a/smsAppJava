package com.google.android.gms.internal.measurement;

import java.util.Map;

final class zzva<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzuy> zzbzs;

    private zzva(Map.Entry<K, zzuy> entry) {
        this.zzbzs = entry;
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.zzbzs.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.zzbzs.getValue() == null) {
            return null;
        }
        return zzuy.zzwz();
    }

    public final zzuy zzxa() {
        return this.zzbzs.getValue();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof zzvv) {
            return this.zzbzs.getValue().zzi((zzvv) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
