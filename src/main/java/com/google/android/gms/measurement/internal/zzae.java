package com.google.android.gms.measurement.internal;

import java.util.Iterator;

/* access modifiers changed from: package-private */
public final class zzae implements Iterator<String> {
    private Iterator<String> zzaie = this.zzaif.zzaid.keySet().iterator();
    private final /* synthetic */ zzad zzaif;

    zzae(zzad zzad) {
        this.zzaif = zzad;
    }

    public final boolean hasNext() {
        return this.zzaie.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.zzaie.next();
    }
}
