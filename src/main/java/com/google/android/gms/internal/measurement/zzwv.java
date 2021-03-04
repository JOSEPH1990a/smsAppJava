package com.google.android.gms.internal.measurement;

import java.util.Map;

/* access modifiers changed from: package-private */
public final class zzwv implements Comparable<zzwv>, Map.Entry<K, V> {
    private V value;
    private final /* synthetic */ zzwo zzcby;
    private final K zzccb;

    zzwv(zzwo zzwo, Map.Entry<K, V> entry) {
        this(zzwo, entry.getKey(), entry.getValue());
    }

    zzwv(zzwo zzwo, K k, V v) {
        this.zzcby = zzwo;
        this.zzccb = k;
        this.value = v;
    }

    @Override // java.util.Map.Entry
    public final V getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        this.zzcby.zzyf();
        V v2 = this.value;
        this.value = v;
        return v2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return equals(this.zzccb, entry.getKey()) && equals(this.value, entry.getValue());
    }

    public final int hashCode() {
        K k = this.zzccb;
        int i = 0;
        int hashCode = k == null ? 0 : k.hashCode();
        V v = this.value;
        if (v != null) {
            i = v.hashCode();
        }
        return hashCode ^ i;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzccb);
        String valueOf2 = String.valueOf(this.value);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length());
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        return sb.toString();
    }

    private static boolean equals(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.zzccb;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(zzwv zzwv) {
        return ((Comparable) getKey()).compareTo((Comparable) zzwv.getKey());
    }
}
