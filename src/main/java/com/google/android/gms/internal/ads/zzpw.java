package com.google.android.gms.internal.ads;

public final class zzpw {
    private byte[] data;
    private int zzbhx;
    private int zzbhy;
    private int zzbhz;

    public zzpw() {
    }

    public zzpw(byte[] bArr) {
        this(bArr, bArr.length);
    }

    private zzpw(byte[] bArr, int i) {
        this.data = bArr;
        this.zzbhz = i;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x002b */
    /* JADX DEBUG: Multi-variable search result rejected for r6v2, resolved type: byte[] */
    /* JADX DEBUG: Multi-variable search result rejected for r6v3, resolved type: byte */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1 */
    public final int zzbj(int i) {
        int i2;
        int i3;
        byte b;
        boolean z = false;
        if (i == 0) {
            return 0;
        }
        int i4 = i / 8;
        int i5 = i;
        int i6 = 0;
        for (int i7 = 0; i7 < i4; i7++) {
            int i8 = this.zzbhy;
            if (i8 != 0) {
                byte[] bArr = this.data;
                int i9 = this.zzbhx;
                b = ((bArr[i9 + 1] & 255) >>> (8 - i8)) | ((bArr[i9] & 255) << i8);
            } else {
                b = this.data[this.zzbhx];
            }
            i5 -= 8;
            i6 |= (255 & (b == true ? 1 : 0)) << i5;
            this.zzbhx++;
        }
        if (i5 > 0) {
            int i10 = this.zzbhy + i5;
            byte b2 = (byte) (255 >> (8 - i5));
            if (i10 > 8) {
                byte[] bArr2 = this.data;
                int i11 = this.zzbhx;
                int i12 = (bArr2[i11] & 255) << (i10 - 8);
                this.zzbhx = i11 + 1;
                i6 = (b2 & (((bArr2[i11 + 1] & 255) >> (16 - i10)) | i12)) | i6;
            } else {
                byte[] bArr3 = this.data;
                int i13 = this.zzbhx;
                int i14 = (b2 & ((bArr3[i13] & 255) >> (8 - i10))) | i6;
                if (i10 == 8) {
                    this.zzbhx = i13 + 1;
                }
                i6 = i14;
            }
            this.zzbhy = i10 % 8;
        }
        int i15 = this.zzbhx;
        if (i15 >= 0 && (i2 = this.zzbhy) >= 0 && i2 < 8 && (i15 < (i3 = this.zzbhz) || (i15 == i3 && i2 == 0))) {
            z = true;
        }
        zzpo.checkState(z);
        return i6;
    }
}
