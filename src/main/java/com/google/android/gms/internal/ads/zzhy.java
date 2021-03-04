package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;

public final class zzhy implements zzii {
    @Override // com.google.android.gms.internal.ads.zzii
    public final void zza(long j, int i, int i2, int i3, zzij zzij) {
    }

    @Override // com.google.android.gms.internal.ads.zzii
    public final void zzf(zzfs zzfs) {
    }

    @Override // com.google.android.gms.internal.ads.zzii
    public final int zza(zzia zzia, int i, boolean z) throws IOException, InterruptedException {
        int zzv = zzia.zzv(i);
        if (zzv != -1) {
            return zzv;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.google.android.gms.internal.ads.zzii
    public final void zza(zzpx zzpx, int i) {
        zzpx.zzbl(i);
    }
}
