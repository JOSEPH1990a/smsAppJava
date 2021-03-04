package com.google.android.gms.internal.measurement;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* access modifiers changed from: package-private */
public class zzwo<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean zzbpy;
    private final int zzcbr;
    private List<zzwv> zzcbs;
    private Map<K, V> zzcbt;
    private volatile zzwx zzcbu;
    private Map<K, V> zzcbv;
    private volatile zzwr zzcbw;

    static <FieldDescriptorType extends zzuh<FieldDescriptorType>> zzwo<FieldDescriptorType, Object> zzbw(int i) {
        return new zzwp(i);
    }

    private zzwo(int i) {
        this.zzcbr = i;
        this.zzcbs = Collections.emptyList();
        this.zzcbt = Collections.emptyMap();
        this.zzcbv = Collections.emptyMap();
    }

    public void zzsw() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.zzbpy) {
            if (this.zzcbt.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.zzcbt);
            }
            this.zzcbt = map;
            if (this.zzcbv.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.zzcbv);
            }
            this.zzcbv = map2;
            this.zzbpy = true;
        }
    }

    public final boolean isImmutable() {
        return this.zzbpy;
    }

    public final int zzyc() {
        return this.zzcbs.size();
    }

    public final Map.Entry<K, V> zzbx(int i) {
        return this.zzcbs.get(i);
    }

    public final Iterable<Map.Entry<K, V>> zzyd() {
        if (this.zzcbt.isEmpty()) {
            return zzws.zzyi();
        }
        return this.zzcbt.entrySet();
    }

    public int size() {
        return this.zzcbs.size() + this.zzcbt.size();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.android.gms.internal.measurement.zzwo<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza(comparable) >= 0 || this.zzcbt.containsKey(comparable);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.android.gms.internal.measurement.zzwo<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        return zza >= 0 ? (V) this.zzcbs.get(zza).getValue() : this.zzcbt.get(comparable);
    }

    /* renamed from: zza */
    public final V put(K k, V v) {
        zzyf();
        int zza = zza(k);
        if (zza >= 0) {
            return (V) this.zzcbs.get(zza).setValue(v);
        }
        zzyf();
        if (this.zzcbs.isEmpty() && !(this.zzcbs instanceof ArrayList)) {
            this.zzcbs = new ArrayList(this.zzcbr);
        }
        int i = -(zza + 1);
        if (i >= this.zzcbr) {
            return zzyg().put(k, v);
        }
        int size = this.zzcbs.size();
        int i2 = this.zzcbr;
        if (size == i2) {
            zzwv remove = this.zzcbs.remove(i2 - 1);
            zzyg().put((K) ((Comparable) remove.getKey()), (V) remove.getValue());
        }
        this.zzcbs.add(i, new zzwv(this, k, v));
        return null;
    }

    public void clear() {
        zzyf();
        if (!this.zzcbs.isEmpty()) {
            this.zzcbs.clear();
        }
        if (!this.zzcbt.isEmpty()) {
            this.zzcbt.clear();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.android.gms.internal.measurement.zzwo<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        zzyf();
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        if (zza >= 0) {
            return (V) zzby(zza);
        }
        if (this.zzcbt.isEmpty()) {
            return null;
        }
        return this.zzcbt.remove(comparable);
    }

    /* access modifiers changed from: private */
    public final V zzby(int i) {
        zzyf();
        V v = (V) this.zzcbs.remove(i).getValue();
        if (!this.zzcbt.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = zzyg().entrySet().iterator();
            this.zzcbs.add(new zzwv(this, it.next()));
            it.remove();
        }
        return v;
    }

    private final int zza(K k) {
        int size = this.zzcbs.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.zzcbs.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo((Comparable) this.zzcbs.get(i2).getKey());
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else if (compareTo2 <= 0) {
                return i2;
            } else {
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zzcbu == null) {
            this.zzcbu = new zzwx(this, null);
        }
        return this.zzcbu;
    }

    /* access modifiers changed from: package-private */
    public final Set<Map.Entry<K, V>> zzye() {
        if (this.zzcbw == null) {
            this.zzcbw = new zzwr(this, null);
        }
        return this.zzcbw;
    }

    /* access modifiers changed from: private */
    public final void zzyf() {
        if (this.zzbpy) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzyg() {
        zzyf();
        if (this.zzcbt.isEmpty() && !(this.zzcbt instanceof TreeMap)) {
            this.zzcbt = new TreeMap();
            this.zzcbv = ((TreeMap) this.zzcbt).descendingMap();
        }
        return (SortedMap) this.zzcbt;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzwo)) {
            return super.equals(obj);
        }
        zzwo zzwo = (zzwo) obj;
        int size = size();
        if (size != zzwo.size()) {
            return false;
        }
        int zzyc = zzyc();
        if (zzyc != zzwo.zzyc()) {
            return entrySet().equals(zzwo.entrySet());
        }
        for (int i = 0; i < zzyc; i++) {
            if (!zzbx(i).equals(zzwo.zzbx(i))) {
                return false;
            }
        }
        if (zzyc != size) {
            return this.zzcbt.equals(zzwo.zzcbt);
        }
        return true;
    }

    public int hashCode() {
        int zzyc = zzyc();
        int i = 0;
        for (int i2 = 0; i2 < zzyc; i2++) {
            i += this.zzcbs.get(i2).hashCode();
        }
        return this.zzcbt.size() > 0 ? i + this.zzcbt.hashCode() : i;
    }

    /* synthetic */ zzwo(int i, zzwp zzwp) {
        this(i);
    }
}
