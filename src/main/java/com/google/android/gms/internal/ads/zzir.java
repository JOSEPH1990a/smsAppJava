package com.google.android.gms.internal.ads;

import java.io.IOException;

/* access modifiers changed from: package-private */
public final class zzir implements zzio {
    private final /* synthetic */ zzip zzajr;

    private zzir(zzip zzip) {
        this.zzajr = zzip;
    }

    @Override // com.google.android.gms.internal.ads.zzio
    public final int zzab(int i) {
        return zzip.zzab(i);
    }

    @Override // com.google.android.gms.internal.ads.zzio
    public final boolean zzac(int i) {
        return zzip.zzac(i);
    }

    @Override // com.google.android.gms.internal.ads.zzio
    public final void zzd(int i, long j, long j2) throws zzfx {
        this.zzajr.zzd(i, j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzio
    public final void zzad(int i) throws zzfx {
        this.zzajr.zzad(i);
    }

    @Override // com.google.android.gms.internal.ads.zzio
    public final void zzc(int i, long j) throws zzfx {
        this.zzajr.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzio
    public final void zza(int i, double d) throws zzfx {
        this.zzajr.zza(i, d);
    }

    @Override // com.google.android.gms.internal.ads.zzio
    public final void zza(int i, String str) throws zzfx {
        this.zzajr.zza(i, str);
    }

    @Override // com.google.android.gms.internal.ads.zzio
    public final void zza(int i, int i2, zzia zzia) throws IOException, InterruptedException {
        this.zzajr.zza(i, i2, zzia);
    }

    /* synthetic */ zzir(zzip zzip, zziq zziq) {
        this(zzip);
    }
}
