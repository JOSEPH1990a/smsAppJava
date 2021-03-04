package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzxg extends AbstractList<String> implements zzve, RandomAccess {
    private final zzve zzcch;

    public zzxg(zzve zzve) {
        this.zzcch = zzve;
    }

    @Override // com.google.android.gms.internal.measurement.zzve
    public final zzve zzxc() {
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzve
    public final Object zzbp(int i) {
        return this.zzcch.zzbp(i);
    }

    public final int size() {
        return this.zzcch.size();
    }

    @Override // com.google.android.gms.internal.measurement.zzve
    public final void zzc(zzte zzte) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final ListIterator<String> listIterator(int i) {
        return new zzxh(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Iterable
    public final Iterator<String> iterator() {
        return new zzxi(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzve
    public final List<?> zzxb() {
        return this.zzcch.zzxb();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ String get(int i) {
        return (String) this.zzcch.get(i);
    }
}
