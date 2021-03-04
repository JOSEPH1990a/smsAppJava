package com.google.android.gms.internal.ads;

public final class zzpy {
    private byte[] data;
    private int zzbhx;
    private int zzbhy = 0;
    private int zzbhz;

    public zzpy(byte[] bArr, int i, int i2) {
        this.data = bArr;
        this.zzbhx = i;
        this.zzbhz = i2;
        zzhn();
    }

    public final void zzbn(int i) {
        int i2 = this.zzbhx;
        this.zzbhx = (i / 8) + i2;
        this.zzbhy += i % 8;
        int i3 = this.zzbhy;
        if (i3 > 7) {
            this.zzbhx++;
            this.zzbhy = i3 - 8;
        }
        while (true) {
            i2++;
            if (i2 > this.zzbhx) {
                zzhn();
                return;
            } else if (zzbo(i2)) {
                this.zzbhx++;
                i2 += 2;
            }
        }
    }

    public final boolean zzhj() {
        return zzbj(1) == 1;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x003a */
    /* JADX DEBUG: Multi-variable search result rejected for r4v2, resolved type: byte[] */
    /* JADX DEBUG: Multi-variable search result rejected for r4v3, resolved type: byte */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1 */
    public final int zzbj(int i) {
        byte b;
        if (i == 0) {
            return 0;
        }
        int i2 = i / 8;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = zzbo(this.zzbhx + 1) ? this.zzbhx + 2 : this.zzbhx + 1;
            int i6 = this.zzbhy;
            if (i6 != 0) {
                byte[] bArr = this.data;
                b = ((bArr[i5] & 255) >>> (8 - i6)) | ((bArr[this.zzbhx] & 255) << i6);
            } else {
                b = this.data[this.zzbhx];
            }
            i -= 8;
            i3 |= (255 & (b == true ? 1 : 0)) << i;
            this.zzbhx = i5;
        }
        if (i > 0) {
            int i7 = this.zzbhy + i;
            byte b2 = (byte) (255 >> (8 - i));
            int i8 = zzbo(this.zzbhx + 1) ? this.zzbhx + 2 : this.zzbhx + 1;
            if (i7 > 8) {
                byte[] bArr2 = this.data;
                int i9 = (255 & bArr2[i8]) >> (16 - i7);
                this.zzbhx = i8;
                i3 = (b2 & (i9 | ((bArr2[this.zzbhx] & 255) << (i7 - 8)))) | i3;
            } else {
                int i10 = (b2 & ((255 & this.data[this.zzbhx]) >> (8 - i7))) | i3;
                if (i7 == 8) {
                    this.zzbhx = i8;
                }
                i3 = i10;
            }
            this.zzbhy = i7 % 8;
        }
        zzhn();
        return i3;
    }

    public final int zzhk() {
        return zzhm();
    }

    public final int zzhl() {
        int zzhm = zzhm();
        return (zzhm % 2 == 0 ? -1 : 1) * ((zzhm + 1) / 2);
    }

    private final int zzhm() {
        int i = 0;
        int i2 = 0;
        while (!zzhj()) {
            i2++;
        }
        int i3 = (1 << i2) - 1;
        if (i2 > 0) {
            i = zzbj(i2);
        }
        return i3 + i;
    }

    private final boolean zzbo(int i) {
        if (2 > i || i >= this.zzbhz) {
            return false;
        }
        byte[] bArr = this.data;
        return bArr[i] == 3 && bArr[i + -2] == 0 && bArr[i - 1] == 0;
    }

    private final void zzhn() {
        int i;
        int i2;
        int i3 = this.zzbhx;
        zzpo.checkState(i3 >= 0 && (i = this.zzbhy) >= 0 && i < 8 && (i3 < (i2 = this.zzbhz) || (i3 == i2 && i == 0)));
    }
}
