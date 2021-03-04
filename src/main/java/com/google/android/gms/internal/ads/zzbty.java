package com.google.android.gms.internal.ads;

import java.util.ListIterator;

final class zzbty implements ListIterator<String> {
    private ListIterator<String> zzfua = this.zzfuc.zzftz.listIterator(this.zzfub);
    private final /* synthetic */ int zzfub;
    private final /* synthetic */ zzbtx zzfuc;

    zzbty(zzbtx zzbtx, int i) {
        this.zzfuc = zzbtx;
        this.zzfub = i;
    }

    public final boolean hasNext() {
        return this.zzfua.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zzfua.hasPrevious();
    }

    public final int nextIndex() {
        return this.zzfua.nextIndex();
    }

    public final int previousIndex() {
        return this.zzfua.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.ListIterator
    public final /* synthetic */ void add(String str) {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.ListIterator
    public final /* synthetic */ void set(String str) {
        throw new UnsupportedOperationException();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.ListIterator
    public final /* synthetic */ String previous() {
        return this.zzfua.previous();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator, java.util.ListIterator
    public final /* synthetic */ String next() {
        return this.zzfua.next();
    }
}
