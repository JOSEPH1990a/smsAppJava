package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzjw implements zzhz {
    private static final int zzatm = zzqe.zzam("RCC\u0001");
    private int version;
    private final zzfs zzaad;
    private int zzajn;
    private int zzaqe = 0;
    private zzii zzasj;
    private final zzpx zzatn = new zzpx(9);
    private long zzato;
    private int zzatp;

    public zzjw(zzfs zzfs) {
        this.zzaad = zzfs;
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final void release() {
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final void zza(zzib zzib) {
        zzib.zza(new zzih(-9223372036854775807L));
        this.zzasj = zzib.zzb(0, 3);
        zzib.zzdy();
        this.zzasj.zzf(this.zzaad);
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final boolean zza(zzia zzia) throws IOException, InterruptedException {
        this.zzatn.reset();
        zzia.zza(this.zzatn.data, 0, 8);
        if (this.zzatn.readInt() == zzatm) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0091 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzhz
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(com.google.android.gms.internal.ads.zzia r11, com.google.android.gms.internal.ads.zzif r12) throws java.io.IOException, java.lang.InterruptedException {
        /*
        // Method dump skipped, instructions count: 236
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjw.zza(com.google.android.gms.internal.ads.zzia, com.google.android.gms.internal.ads.zzif):int");
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final void zzc(long j, long j2) {
        this.zzaqe = 0;
    }
}
