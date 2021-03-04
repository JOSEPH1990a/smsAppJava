package com.google.android.gms.internal.ads;

import java.nio.ShortBuffer;
import java.util.Arrays;

final class zzhh {
    private float zzaag;
    private float zzaah;
    private final int zzafc;
    private final int zzafd;
    private final int zzafe;
    private final int zzaff = (this.zzafe * 2);
    private final short[] zzafg;
    private int zzafh;
    private short[] zzafi;
    private int zzafj;
    private short[] zzafk;
    private int zzafl;
    private short[] zzafm;
    private int zzafn;
    private int zzafo;
    private int zzafp;
    private int zzafq;
    private int zzafr;
    private int zzafs;
    private int zzaft;
    private int zzafu;
    private int zzafv;
    private int zzafw;
    private final int zzzu;

    public zzhh(int i, int i2) {
        this.zzzu = i;
        this.zzafc = i2;
        this.zzafd = i / 400;
        this.zzafe = i / 65;
        int i3 = this.zzaff;
        this.zzafg = new short[i3];
        this.zzafh = i3;
        this.zzafi = new short[(i3 * i2)];
        this.zzafj = i3;
        this.zzafk = new short[(i3 * i2)];
        this.zzafl = i3;
        this.zzafm = new short[(i3 * i2)];
        this.zzafn = 0;
        this.zzafo = 0;
        this.zzaft = 0;
        this.zzaag = 1.0f;
        this.zzaah = 1.0f;
    }

    public final void setSpeed(float f) {
        this.zzaag = f;
    }

    public final void zza(float f) {
        this.zzaah = f;
    }

    public final void zza(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i = this.zzafc;
        int i2 = remaining / i;
        zzp(i2);
        shortBuffer.get(this.zzafi, this.zzafp * this.zzafc, ((i * i2) << 1) / 2);
        this.zzafp += i2;
        zzdl();
    }

    public final void zzb(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.zzafc, this.zzafq);
        shortBuffer.put(this.zzafk, 0, this.zzafc * min);
        this.zzafq -= min;
        short[] sArr = this.zzafk;
        int i = this.zzafc;
        System.arraycopy(sArr, min * i, sArr, 0, this.zzafq * i);
    }

    public final void zzcq() {
        int i;
        int i2 = this.zzafp;
        float f = this.zzaag;
        float f2 = this.zzaah;
        int i3 = this.zzafq + ((int) ((((((float) i2) / (f / f2)) + ((float) this.zzafr)) / f2) + 0.5f));
        zzp((this.zzaff * 2) + i2);
        int i4 = 0;
        while (true) {
            i = this.zzaff;
            int i5 = this.zzafc;
            if (i4 >= i * 2 * i5) {
                break;
            }
            this.zzafi[(i5 * i2) + i4] = 0;
            i4++;
        }
        this.zzafp += i * 2;
        zzdl();
        if (this.zzafq > i3) {
            this.zzafq = i3;
        }
        this.zzafp = 0;
        this.zzafs = 0;
        this.zzafr = 0;
    }

    public final int zzdk() {
        return this.zzafq;
    }

    private final void zzo(int i) {
        int i2 = this.zzafq + i;
        int i3 = this.zzafj;
        if (i2 > i3) {
            this.zzafj = i3 + (i3 / 2) + i;
            this.zzafk = Arrays.copyOf(this.zzafk, this.zzafj * this.zzafc);
        }
    }

    private final void zzp(int i) {
        int i2 = this.zzafp + i;
        int i3 = this.zzafh;
        if (i2 > i3) {
            this.zzafh = i3 + (i3 / 2) + i;
            this.zzafi = Arrays.copyOf(this.zzafi, this.zzafh * this.zzafc);
        }
    }

    private final void zza(short[] sArr, int i, int i2) {
        zzo(i2);
        int i3 = this.zzafc;
        System.arraycopy(sArr, i * i3, this.zzafk, this.zzafq * i3, i3 * i2);
        this.zzafq += i2;
    }

    private final void zzb(short[] sArr, int i, int i2) {
        int i3 = this.zzaff / i2;
        int i4 = this.zzafc;
        int i5 = i2 * i4;
        int i6 = i * i4;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = 0;
            for (int i9 = 0; i9 < i5; i9++) {
                i8 += sArr[(i7 * i5) + i6 + i9];
            }
            this.zzafg[i7] = (short) (i8 / i5);
        }
    }

    private final int zza(short[] sArr, int i, int i2, int i3) {
        int i4 = i * this.zzafc;
        int i5 = 1;
        int i6 = 0;
        int i7 = 0;
        int i8 = 255;
        while (i2 <= i3) {
            int i9 = 0;
            for (int i10 = 0; i10 < i2; i10++) {
                short s = sArr[i4 + i10];
                short s2 = sArr[i4 + i2 + i10];
                i9 += s >= s2 ? s - s2 : s2 - s;
            }
            if (i9 * i6 < i5 * i2) {
                i6 = i2;
                i5 = i9;
            }
            if (i9 * i8 > i7 * i2) {
                i8 = i2;
                i7 = i9;
            }
            i2++;
        }
        this.zzafv = i5 / i6;
        this.zzafw = i7 / i8;
        return i6;
    }

    private final void zzdl() {
        int i;
        int i2;
        int i3;
        int i4;
        boolean z;
        int i5;
        int i6;
        int i7 = this.zzafq;
        float f = this.zzaag / this.zzaah;
        double d = (double) f;
        int i8 = 1;
        if (d > 1.00001d || d < 0.99999d) {
            int i9 = this.zzafp;
            if (i9 >= this.zzaff) {
                int i10 = 0;
                while (true) {
                    int i11 = this.zzafs;
                    if (i11 > 0) {
                        int min = Math.min(this.zzaff, i11);
                        zza(this.zzafi, i10, min);
                        this.zzafs -= min;
                        i10 += min;
                    } else {
                        short[] sArr = this.zzafi;
                        int i12 = this.zzzu;
                        int i13 = i12 > 4000 ? i12 / 4000 : 1;
                        if (this.zzafc == i8 && i13 == i8) {
                            i4 = zza(sArr, i10, this.zzafd, this.zzafe);
                        } else {
                            zzb(sArr, i10, i13);
                            int zza = zza(this.zzafg, 0, this.zzafd / i13, this.zzafe / i13);
                            if (i13 != i8) {
                                int i14 = zza * i13;
                                int i15 = i13 << 2;
                                int i16 = i14 - i15;
                                int i17 = i14 + i15;
                                int i18 = this.zzafd;
                                if (i16 >= i18) {
                                    i18 = i16;
                                }
                                int i19 = this.zzafe;
                                if (i17 > i19) {
                                    i17 = i19;
                                }
                                if (this.zzafc == i8) {
                                    i4 = zza(sArr, i10, i18, i17);
                                } else {
                                    zzb(sArr, i10, i8);
                                    i4 = zza(this.zzafg, 0, i18, i17);
                                }
                            } else {
                                i4 = zza;
                            }
                        }
                        int i20 = this.zzafv;
                        int i21 = this.zzafw;
                        if (i20 == 0 || this.zzaft == 0) {
                            z = false;
                        } else {
                            z = i21 > i20 * 3 ? false : (i20 << 1) > this.zzafu * 3;
                        }
                        int i22 = z ? this.zzaft : i4;
                        this.zzafu = this.zzafv;
                        this.zzaft = i4;
                        if (d > 1.0d) {
                            short[] sArr2 = this.zzafi;
                            if (f >= 2.0f) {
                                i6 = (int) (((float) i22) / (f - 1.0f));
                            } else {
                                this.zzafs = (int) ((((float) i22) * (2.0f - f)) / (f - 1.0f));
                                i6 = i22;
                            }
                            zzo(i6);
                            zza(i6, this.zzafc, this.zzafk, this.zzafq, sArr2, i10, sArr2, i10 + i22);
                            this.zzafq += i6;
                            i10 += i22 + i6;
                        } else {
                            short[] sArr3 = this.zzafi;
                            if (f < 0.5f) {
                                i5 = (int) ((((float) i22) * f) / (1.0f - f));
                            } else {
                                this.zzafs = (int) ((((float) i22) * ((2.0f * f) - 1.0f)) / (1.0f - f));
                                i5 = i22;
                            }
                            int i23 = i22 + i5;
                            zzo(i23);
                            int i24 = this.zzafc;
                            System.arraycopy(sArr3, i10 * i24, this.zzafk, this.zzafq * i24, i24 * i22);
                            zza(i5, this.zzafc, this.zzafk, this.zzafq + i22, sArr3, i22 + i10, sArr3, i10);
                            this.zzafq += i23;
                            i10 += i5;
                        }
                    }
                    if (this.zzaff + i10 > i9) {
                        break;
                    }
                    i8 = 1;
                }
                int i25 = this.zzafp - i10;
                short[] sArr4 = this.zzafi;
                int i26 = this.zzafc;
                System.arraycopy(sArr4, i10 * i26, sArr4, 0, i26 * i25);
                this.zzafp = i25;
            }
        } else {
            zza(this.zzafi, 0, this.zzafp);
            this.zzafp = 0;
        }
        float f2 = this.zzaah;
        if (f2 != 1.0f && this.zzafq != i7) {
            int i27 = this.zzzu;
            int i28 = (int) (((float) i27) / f2);
            while (true) {
                if (i28 <= 16384 && i27 <= 16384) {
                    break;
                }
                i28 /= 2;
                i27 /= 2;
            }
            int i29 = this.zzafq - i7;
            int i30 = this.zzafr + i29;
            int i31 = this.zzafl;
            if (i30 > i31) {
                this.zzafl = i31 + (i31 / 2) + i29;
                this.zzafm = Arrays.copyOf(this.zzafm, this.zzafl * this.zzafc);
            }
            short[] sArr5 = this.zzafk;
            int i32 = this.zzafc;
            System.arraycopy(sArr5, i7 * i32, this.zzafm, this.zzafr * i32, i32 * i29);
            this.zzafq = i7;
            this.zzafr += i29;
            int i33 = 0;
            while (true) {
                i = this.zzafr;
                if (i33 >= i - 1) {
                    break;
                }
                while (true) {
                    i2 = this.zzafn;
                    int i34 = (i2 + 1) * i28;
                    i3 = this.zzafo;
                    if (i34 <= i3 * i27) {
                        break;
                    }
                    zzo(1);
                    int i35 = 0;
                    while (true) {
                        int i36 = this.zzafc;
                        if (i35 >= i36) {
                            break;
                        }
                        short[] sArr6 = this.zzafm;
                        int i37 = (i33 * i36) + i35;
                        short s = sArr6[i37];
                        short s2 = sArr6[i37 + i36];
                        int i38 = this.zzafn;
                        int i39 = i38 * i28;
                        int i40 = (i38 + 1) * i28;
                        int i41 = i40 - (this.zzafo * i27);
                        int i42 = i40 - i39;
                        this.zzafk[(this.zzafq * i36) + i35] = (short) (((s * i41) + ((i42 - i41) * s2)) / i42);
                        i35++;
                    }
                    this.zzafo++;
                    this.zzafq++;
                }
                this.zzafn = i2 + 1;
                if (this.zzafn == i27) {
                    this.zzafn = 0;
                    zzpo.checkState(i3 == i28);
                    this.zzafo = 0;
                }
                i33++;
            }
            int i43 = i - 1;
            if (i43 != 0) {
                short[] sArr7 = this.zzafm;
                int i44 = this.zzafc;
                System.arraycopy(sArr7, i43 * i44, sArr7, 0, (i - i43) * i44);
                this.zzafr -= i43;
            }
        }
    }

    private static void zza(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i4 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i3 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i9] = (short) (((sArr2[i7] * (i - i10)) + (sArr3[i8] * i10)) / i);
                i9 += i2;
                i7 += i2;
                i8 += i2;
            }
        }
    }
}
