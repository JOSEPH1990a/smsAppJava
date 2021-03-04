package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* access modifiers changed from: package-private */
public final class zzbpv implements zzbqa {
    private final int limit = this.zzfll.size();
    private int position = 0;
    private final /* synthetic */ zzbpu zzfll;

    zzbpv(zzbpu zzbpu) {
        this.zzfll = zzbpu;
    }

    public final boolean hasNext() {
        return this.position < this.limit;
    }

    @Override // com.google.android.gms.internal.ads.zzbqa
    public final byte nextByte() {
        try {
            zzbpu zzbpu = this.zzfll;
            int i = this.position;
            this.position = i + 1;
            return zzbpu.zzem(i);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator
    public final /* synthetic */ Byte next() {
        return Byte.valueOf(nextByte());
    }
}
