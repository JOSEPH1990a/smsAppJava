package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class zzbti extends zzbto {
    private final /* synthetic */ zzbtf zzftq;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzbti(zzbtf zzbtf) {
        super(zzbtf, null);
        this.zzftq = zzbtf;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, com.google.android.gms.internal.ads.zzbto, java.lang.Iterable
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzbth(this.zzftq, null);
    }

    /* synthetic */ zzbti(zzbtf zzbtf, zzbtg zzbtg) {
        this(zzbtf);
    }
}
