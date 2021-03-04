package com.google.android.gms.internal.ads;

import java.util.Iterator;

final class zzbtz implements Iterator<String> {
    private final /* synthetic */ zzbtx zzfuc;
    private Iterator<String> zzfud = this.zzfuc.zzftz.iterator();

    zzbtz(zzbtx zzbtx) {
        this.zzfuc = zzbtx;
    }

    public final boolean hasNext() {
        return this.zzfud.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.zzfud.next();
    }
}
