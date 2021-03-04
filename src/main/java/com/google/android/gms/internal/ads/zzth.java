package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.MurmurHash3;
import java.io.UnsupportedEncodingException;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
public final class zzth {
    public static int zzba(String str) {
        byte[] bArr;
        try {
            bArr = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            bArr = str.getBytes();
        }
        return MurmurHash3.murmurhash3_x86_32(bArr, 0, bArr.length, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x007f, code lost:
        if (((r6 >= 65382 && r6 <= 65437) || (r6 >= 65441 && r6 <= 65500)) != false) goto L_0x0081;
     */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009c  */
    @android.support.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String[] zze(@android.support.annotation.Nullable java.lang.String r11, boolean r12) {
        /*
        // Method dump skipped, instructions count: 246
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzth.zze(java.lang.String, boolean):java.lang.String[]");
    }
}
