package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicReference;

public final class zzog extends zzoj {
    private static final int[] zzbem = new int[0];
    private final zzon zzben;
    private final AtomicReference<zzoh> zzbeo;

    public zzog() {
        this(null);
    }

    private static int zze(int i, int i2) {
        if (i == -1) {
            return i2 == -1 ? 0 : -1;
        }
        if (i2 == -1) {
            return 1;
        }
        return i - i2;
    }

    private static boolean zze(int i, boolean z) {
        int i2 = i & 3;
        if (i2 != 3) {
            return z && i2 == 2;
        }
        return true;
    }

    private zzog(zzon zzon) {
        this.zzben = null;
        this.zzbeo = new AtomicReference<>(new zzoh());
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0185, code lost:
        if (r9.zzzf <= r15) goto L_0x018a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01df  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01bc  */
    @Override // com.google.android.gms.internal.ads.zzoj
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzom[] zza(com.google.android.gms.internal.ads.zzga[] r36, com.google.android.gms.internal.ads.zzma[] r37, int[][][] r38) throws com.google.android.gms.internal.ads.zzff {
        /*
        // Method dump skipped, instructions count: 1146
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzog.zza(com.google.android.gms.internal.ads.zzga[], com.google.android.gms.internal.ads.zzma[], int[][][]):com.google.android.gms.internal.ads.zzom[]");
    }

    private static boolean zza(zzfs zzfs, String str) {
        return str != null && TextUtils.equals(str, zzqe.zzai(zzfs.zzaaa));
    }
}
