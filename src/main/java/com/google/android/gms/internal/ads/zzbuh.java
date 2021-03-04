package com.google.android.gms.internal.ads;

final class zzbuh extends zzbue {
    zzbuh() {
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0065, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00ba, code lost:
        return -1;
     */
    @Override // com.google.android.gms.internal.ads.zzbue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(int r18, byte[] r19, int r20, int r21) {
        /*
        // Method dump skipped, instructions count: 222
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbuh.zzb(int, byte[], int, int):int");
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzbue
    public final String zzo(byte[] bArr, int i, int i2) throws zzbrl {
        if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (i < i3) {
                byte zza = zzbua.zza(bArr, (long) i);
                if (!zzbud.zzi(zza)) {
                    break;
                }
                i++;
                zzbud.zzb(zza, cArr, i4);
                i4++;
            }
            int i5 = i4;
            while (i < i3) {
                int i6 = i + 1;
                byte zza2 = zzbua.zza(bArr, (long) i);
                if (zzbud.zzi(zza2)) {
                    int i7 = i5 + 1;
                    zzbud.zzb(zza2, cArr, i5);
                    while (i6 < i3) {
                        byte zza3 = zzbua.zza(bArr, (long) i6);
                        if (!zzbud.zzi(zza3)) {
                            break;
                        }
                        i6++;
                        zzbud.zzb(zza3, cArr, i7);
                        i7++;
                    }
                    i = i6;
                    i5 = i7;
                } else if (zzbud.zzj(zza2)) {
                    if (i6 < i3) {
                        int i8 = i6 + 1;
                        zzbud.zzb(zza2, zzbua.zza(bArr, (long) i6), cArr, i5);
                        i = i8;
                        i5++;
                    } else {
                        throw zzbrl.zzank();
                    }
                } else if (zzbud.zzk(zza2)) {
                    if (i6 < i3 - 1) {
                        int i9 = i6 + 1;
                        int i10 = i9 + 1;
                        zzbud.zzb(zza2, zzbua.zza(bArr, (long) i6), zzbua.zza(bArr, (long) i9), cArr, i5);
                        i = i10;
                        i5++;
                    } else {
                        throw zzbrl.zzank();
                    }
                } else if (i6 < i3 - 2) {
                    int i11 = i6 + 1;
                    int i12 = i11 + 1;
                    zzbud.zzb(zza2, zzbua.zza(bArr, (long) i6), zzbua.zza(bArr, (long) i11), zzbua.zza(bArr, (long) i12), cArr, i5);
                    i = i12 + 1;
                    i5 = i5 + 1 + 1;
                } else {
                    throw zzbrl.zzank();
                }
            }
            return new String(cArr, 0, i5);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzbue
    public final int zzb(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int i3;
        char charAt;
        long j = (long) i;
        long j2 = ((long) i2) + j;
        int length = charSequence.length();
        if (length > i2 || bArr.length - i2 < i) {
            char charAt2 = charSequence.charAt(length - 1);
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(charAt2);
            sb.append(" at index ");
            sb.append(i + i2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i4 = 0;
        while (i4 < length && (charAt = charSequence.charAt(i4)) < 128) {
            zzbua.zza(bArr, j, (byte) charAt);
            i4++;
            j = 1 + j;
        }
        if (i4 == length) {
            return (int) j;
        }
        while (i4 < length) {
            char charAt3 = charSequence.charAt(i4);
            if (charAt3 < 128 && j < j2) {
                zzbua.zza(bArr, j, (byte) charAt3);
                j++;
            } else if (charAt3 < 2048 && j <= j2 - 2) {
                long j3 = j + 1;
                zzbua.zza(bArr, j, (byte) ((charAt3 >>> 6) | 960));
                j = j3 + 1;
                zzbua.zza(bArr, j3, (byte) ((charAt3 & '?') | 128));
            } else if ((charAt3 < 55296 || 57343 < charAt3) && j <= j2 - 3) {
                long j4 = j + 1;
                zzbua.zza(bArr, j, (byte) ((charAt3 >>> '\f') | 480));
                long j5 = j4 + 1;
                zzbua.zza(bArr, j4, (byte) (((charAt3 >>> 6) & 63) | 128));
                zzbua.zza(bArr, j5, (byte) ((charAt3 & '?') | 128));
                j = j5 + 1;
            } else if (j <= j2 - 4) {
                int i5 = i4 + 1;
                if (i5 != length) {
                    char charAt4 = charSequence.charAt(i5);
                    if (Character.isSurrogatePair(charAt3, charAt4)) {
                        int codePoint = Character.toCodePoint(charAt3, charAt4);
                        long j6 = j + 1;
                        zzbua.zza(bArr, j, (byte) ((codePoint >>> 18) | 240));
                        long j7 = j6 + 1;
                        zzbua.zza(bArr, j6, (byte) (((codePoint >>> 12) & 63) | 128));
                        long j8 = j7 + 1;
                        zzbua.zza(bArr, j7, (byte) (((codePoint >>> 6) & 63) | 128));
                        j = j8 + 1;
                        zzbua.zza(bArr, j8, (byte) ((codePoint & 63) | 128));
                        i4 = i5;
                    }
                } else {
                    i5 = i4;
                }
                throw new zzbug(i5 - 1, length);
            } else if (55296 > charAt3 || charAt3 > 57343 || ((i3 = i4 + 1) != length && Character.isSurrogatePair(charAt3, charSequence.charAt(i3)))) {
                StringBuilder sb2 = new StringBuilder(46);
                sb2.append("Failed writing ");
                sb2.append(charAt3);
                sb2.append(" at index ");
                sb2.append(j);
                throw new ArrayIndexOutOfBoundsException(sb2.toString());
            } else {
                throw new zzbug(i4, length);
            }
            i4++;
        }
        return (int) j;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003d A[LOOP:1: B:11:0x003d->B:35:0x0104, LOOP_START, PHI: r4 r9 r10 r11 
      PHI: (r4v5 long) = (r4v4 long), (r4v8 long) binds: [B:8:0x0035, B:35:0x0104] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r9v3 int) = (r9v2 int), (r9v5 int) binds: [B:8:0x0035, B:35:0x0104] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r10v1 char) = (r10v0 char), (r10v2 char) binds: [B:8:0x0035, B:35:0x0104] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r11v2 long) = (r11v1 long), (r11v3 long) binds: [B:8:0x0035, B:35:0x0104] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0037  */
    @Override // com.google.android.gms.internal.ads.zzbue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(java.lang.CharSequence r22, java.nio.ByteBuffer r23) {
        /*
        // Method dump skipped, instructions count: 384
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbuh.zzb(java.lang.CharSequence, java.nio.ByteBuffer):void");
    }

    private static int zza(byte[] bArr, int i, long j, int i2) {
        switch (i2) {
            case 0:
                return zzbuc.zzga(i);
            case 1:
                return zzbuc.zzak(i, zzbua.zza(bArr, j));
            case 2:
                return zzbuc.zzh(i, zzbua.zza(bArr, j), zzbua.zza(bArr, j + 1));
            default:
                throw new AssertionError();
        }
    }
}
