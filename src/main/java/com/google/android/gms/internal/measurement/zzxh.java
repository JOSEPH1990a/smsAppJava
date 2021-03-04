package com.google.android.gms.internal.measurement;

import java.util.ListIterator;

final class zzxh implements ListIterator<String> {
    private ListIterator<String> zzcci = this.zzcck.zzcch.listIterator(this.zzccj);
    private final /* synthetic */ int zzccj;
    private final /* synthetic */ zzxg zzcck;

    zzxh(zzxg zzxg, int i) {
        this.zzcck = zzxg;
        this.zzccj = i;
    }

    public final boolean hasNext() {
        return this.zzcci.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zzcci.hasPrevious();
    }

    public final int nextIndex() {
        return this.zzcci.nextIndex();
    }

    public final int previousIndex() {
        return this.zzcci.previousIndex();
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
        return this.zzcci.previous();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator, java.util.ListIterator
    public final /* synthetic */ String next() {
        return this.zzcci.next();
    }
}
