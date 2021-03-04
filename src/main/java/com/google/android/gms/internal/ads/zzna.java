package com.google.android.gms.internal.ads;

/* access modifiers changed from: package-private */
public final class zzna {
    public final boolean zzbcb;
    public final long zzbcc;
    public final long zzbcd;

    public static zzna zza(zznn zznn, long j) {
        int i;
        int size = zznn.zzbbe.size();
        int i2 = 0;
        long j2 = Long.MAX_VALUE;
        int i3 = 0;
        boolean z = false;
        boolean z2 = false;
        long j3 = 0;
        while (i3 < size) {
            zznd zzgj = zznn.zzbbe.get(i3).zzbcn.get(i2).zzgj();
            if (zzgj == null) {
                return new zzna(true, 0, j);
            }
            z2 |= zzgj.zzge();
            int zzai = zzgj.zzai(j);
            if (zzai == 0) {
                i = i3;
                z = true;
                j3 = 0;
                j2 = 0;
            } else if (!z) {
                int zzgd = zzgj.zzgd();
                i = i3;
                long max = Math.max(j3, zzgj.zzaw(zzgd));
                if (zzai != -1) {
                    int i4 = (zzgd + zzai) - 1;
                    j2 = Math.min(j2, zzgj.zzaw(i4) + zzgj.zze(i4, j));
                    j3 = max;
                } else {
                    j3 = max;
                }
            } else {
                i = i3;
            }
            i3 = i + 1;
            i2 = 0;
        }
        return new zzna(z2, j3, j2);
    }

    private zzna(boolean z, long j, long j2) {
        this.zzbcb = z;
        this.zzbcc = j;
        this.zzbcd = j2;
    }
}
