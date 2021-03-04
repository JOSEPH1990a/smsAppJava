package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class zzwr extends zzwx {
    private final /* synthetic */ zzwo zzcby;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzwr(zzwo zzwo) {
        super(zzwo, null);
        this.zzcby = zzwo;
    }

    @Override // com.google.android.gms.internal.measurement.zzwx, java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzwq(this.zzcby, null);
    }

    /* synthetic */ zzwr(zzwo zzwo, zzwp zzwp) {
        this(zzwo);
    }
}
