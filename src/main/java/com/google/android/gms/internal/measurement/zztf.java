package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* access modifiers changed from: package-private */
public final class zztf extends zzth {
    private final int limit = this.zzbtt.size();
    private int position = 0;
    private final /* synthetic */ zzte zzbtt;

    zztf(zzte zzte) {
        this.zzbtt = zzte;
    }

    public final boolean hasNext() {
        return this.position < this.limit;
    }

    @Override // com.google.android.gms.internal.measurement.zztl
    public final byte nextByte() {
        int i = this.position;
        if (i < this.limit) {
            this.position = i + 1;
            return this.zzbtt.zzan(i);
        }
        throw new NoSuchElementException();
    }
}
