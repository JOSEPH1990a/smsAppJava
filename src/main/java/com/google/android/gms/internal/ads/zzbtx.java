package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzbtx extends AbstractList<String> implements zzbru, RandomAccess {
    private final zzbru zzftz;

    public zzbtx(zzbru zzbru) {
        this.zzftz = zzbru;
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final zzbru zzanp() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final Object zzfp(int i) {
        return this.zzftz.zzfp(i);
    }

    public final int size() {
        return this.zzftz.size();
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void zzap(zzbpu zzbpu) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final ListIterator<String> listIterator(int i) {
        return new zzbty(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Iterable
    public final Iterator<String> iterator() {
        return new zzbtz(this);
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final List<?> zzano() {
        return this.zzftz.zzano();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ String get(int i) {
        return (String) this.zzftz.get(i);
    }
}
