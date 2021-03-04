package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzbtk implements Iterator<Object> {
    zzbtk() {
    }

    public final boolean hasNext() {
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
