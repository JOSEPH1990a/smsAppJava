package com.google.android.gms.internal.ads;

public final class zzla implements zzlw {
    private final zzlw[] zzawm;

    public zzla(zzlw[] zzlwArr) {
        this.zzawm = zzlwArr;
    }

    @Override // com.google.android.gms.internal.ads.zzlw
    public final long zzeu() {
        long j = Long.MAX_VALUE;
        for (zzlw zzlw : this.zzawm) {
            long zzeu = zzlw.zzeu();
            if (zzeu != Long.MIN_VALUE) {
                j = Math.min(j, zzeu);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzlw
    public final boolean zzy(long j) {
        boolean z;
        boolean z2 = false;
        do {
            long zzeu = zzeu();
            if (zzeu == Long.MIN_VALUE) {
                break;
            }
            zzlw[] zzlwArr = this.zzawm;
            z = false;
            for (zzlw zzlw : zzlwArr) {
                if (zzlw.zzeu() == zzeu) {
                    z |= zzlw.zzy(j);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }
}
