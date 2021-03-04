package com.google.android.gms.internal.ads;

import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.ads.zzki;
import java.util.ArrayList;

/* access modifiers changed from: package-private */
public final class zziy {
    private static final int zzaob = zzqe.zzam("meta");
    private static final int zzaot = zzqe.zzam("vide");
    private static final int zzaou = zzqe.zzam("soun");
    private static final int zzaov = zzqe.zzam("text");
    private static final int zzaow = zzqe.zzam("sbtl");
    private static final int zzaox = zzqe.zzam("subt");
    private static final int zzaoy = zzqe.zzam("clcp");
    private static final int zzaoz = zzqe.zzam("cenc");

    /* JADX WARNING: Removed duplicated region for block: B:187:0x03cc  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x03d6  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x03dc  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x03df  */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x0435  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzjs zza(com.google.android.gms.internal.ads.zziw r47, com.google.android.gms.internal.ads.zzix r48, long r49, com.google.android.gms.internal.ads.zzhp r51, boolean r52) throws com.google.android.gms.internal.ads.zzfx {
        /*
        // Method dump skipped, instructions count: 2200
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zziy.zza(com.google.android.gms.internal.ads.zziw, com.google.android.gms.internal.ads.zzix, long, com.google.android.gms.internal.ads.zzhp, boolean):com.google.android.gms.internal.ads.zzjs");
    }

    public static zzjv zza(zzjs zzjs, zziw zziw, zzid zzid) throws zzfx {
        zzja zzja;
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        int[] iArr;
        long[] jArr;
        int[] iArr2;
        long[] jArr2;
        long j;
        boolean z2;
        int[] iArr3;
        int i5;
        long[] jArr3;
        int[] iArr4;
        int[] iArr5;
        int[] iArr6;
        int i6;
        int i7;
        zzja zzja2;
        int i8;
        int i9;
        int i10;
        int i11;
        zzjs zzjs2 = zzjs;
        zzix zzai = zziw.zzai(zziv.zzanq);
        if (zzai != null) {
            zzja = new zzjc(zzai);
        } else {
            zzix zzai2 = zziw.zzai(zziv.zzanr);
            if (zzai2 != null) {
                zzja = new zzjd(zzai2);
            } else {
                throw new zzfx("Track has no sample table size information");
            }
        }
        int zzef = zzja.zzef();
        if (zzef == 0) {
            return new zzjv(new long[0], new int[0], 0, new long[0], new int[0]);
        }
        zzix zzai3 = zziw.zzai(zziv.zzans);
        if (zzai3 == null) {
            zzai3 = zziw.zzai(zziv.zzant);
            z = true;
        } else {
            z = false;
        }
        zzpx zzpx = zzai3.zzaos;
        zzpx zzpx2 = zziw.zzai(zziv.zzanp).zzaos;
        zzpx zzpx3 = zziw.zzai(zziv.zzanm).zzaos;
        zzix zzai4 = zziw.zzai(zziv.zzann);
        zzpx zzpx4 = zzai4 != null ? zzai4.zzaos : null;
        zzix zzai5 = zziw.zzai(zziv.zzano);
        zzpx zzpx5 = zzai5 != null ? zzai5.zzaos : null;
        zziz zziz = new zziz(zzpx2, zzpx, z);
        zzpx3.setPosition(12);
        int zzhg = zzpx3.zzhg() - 1;
        int zzhg2 = zzpx3.zzhg();
        int zzhg3 = zzpx3.zzhg();
        if (zzpx5 != null) {
            zzpx5.setPosition(12);
            i = zzpx5.zzhg();
        } else {
            i = 0;
        }
        int i12 = -1;
        if (zzpx4 != null) {
            zzpx4.setPosition(12);
            i2 = zzpx4.zzhg();
            if (i2 > 0) {
                i12 = zzpx4.zzhg() - 1;
            } else {
                zzpx4 = null;
            }
        } else {
            i2 = 0;
        }
        long j2 = 0;
        if (!(zzja.zzeh() && "audio/raw".equals(zzjs2.zzaad.zzzj) && zzhg == 0 && i == 0 && i2 == 0)) {
            jArr2 = new long[zzef];
            iArr = new int[zzef];
            jArr = new long[zzef];
            iArr2 = new int[zzef];
            int i13 = i2;
            int i14 = zzhg3;
            int i15 = i;
            int i16 = i12;
            long j3 = 0;
            long j4 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = zzhg2;
            int i22 = zzhg;
            int i23 = 0;
            while (i23 < zzef) {
                long j5 = j3;
                int i24 = i17;
                while (i24 == 0) {
                    zzpo.checkState(zziz.zzee());
                    j5 = zziz.zzapb;
                    i24 = zziz.zzapa;
                    i22 = i22;
                    i14 = i14;
                }
                if (zzpx5 != null) {
                    while (i20 == 0 && i15 > 0) {
                        i20 = zzpx5.zzhg();
                        i19 = zzpx5.readInt();
                        i15--;
                    }
                    i20--;
                    i6 = i19;
                } else {
                    i6 = i19;
                }
                jArr2[i23] = j5;
                iArr[i23] = zzja.zzeg();
                if (iArr[i23] > i18) {
                    i7 = zzef;
                    i18 = iArr[i23];
                    zzja2 = zzja;
                } else {
                    i7 = zzef;
                    zzja2 = zzja;
                }
                jArr[i23] = j4 + ((long) i6);
                iArr2[i23] = zzpx4 == null ? 1 : 0;
                if (i23 == i16) {
                    iArr2[i23] = 1;
                    int i25 = i13 - 1;
                    if (i25 > 0) {
                        i9 = i25;
                        i8 = zzpx4.zzhg() - 1;
                        i10 = i14;
                    } else {
                        i9 = i25;
                        i8 = i16;
                        i10 = i14;
                    }
                } else {
                    i9 = i13;
                    i8 = i16;
                    i10 = i14;
                }
                j4 += (long) i10;
                i21--;
                if (i21 != 0 || i22 <= 0) {
                    i11 = i22;
                } else {
                    i11 = i22 - 1;
                    i21 = zzpx3.zzhg();
                    i10 = zzpx3.zzhg();
                }
                long j6 = j5 + ((long) iArr[i23]);
                i23++;
                i16 = i8;
                zzef = i7;
                i17 = i24 - 1;
                i19 = i6;
                i22 = i11;
                j3 = j6;
                i14 = i10;
                i13 = i9;
                zzja = zzja2;
            }
            i4 = zzef;
            zzpo.checkArgument(i20 == 0);
            while (i15 > 0) {
                zzpo.checkArgument(zzpx5.zzhg() == 0);
                zzpx5.readInt();
                i15--;
            }
            if (i13 == 0 && i21 == 0 && i17 == 0 && i22 == 0) {
                zzjs2 = zzjs;
            } else {
                zzjs2 = zzjs;
                int i26 = zzjs2.id;
                StringBuilder sb = new StringBuilder(215);
                sb.append("Inconsistent stbl box for track ");
                sb.append(i26);
                sb.append(": remainingSynchronizationSamples ");
                sb.append(i13);
                sb.append(", remainingSamplesAtTimestampDelta ");
                sb.append(i21);
                sb.append(", remainingSamplesInChunk ");
                sb.append(i17);
                sb.append(", remainingTimestampDeltaChanges ");
                sb.append(i22);
                Log.w("AtomParsers", sb.toString());
            }
            j = j4;
            i3 = i18;
        } else {
            i4 = zzef;
            long[] jArr4 = new long[zziz.length];
            int[] iArr7 = new int[zziz.length];
            while (zziz.zzee()) {
                jArr4[zziz.index] = zziz.zzapb;
                iArr7[zziz.index] = zziz.zzapa;
            }
            int zzeg = zzja.zzeg();
            long j7 = (long) zzhg3;
            int i27 = 8192 / zzeg;
            int i28 = 0;
            for (int i29 : iArr7) {
                i28 += zzqe.zzf(i29, i27);
            }
            long[] jArr5 = new long[i28];
            int[] iArr8 = new int[i28];
            long[] jArr6 = new long[i28];
            int[] iArr9 = new int[i28];
            int i30 = 0;
            int i31 = 0;
            int i32 = 0;
            int i33 = 0;
            while (i30 < iArr7.length) {
                int i34 = iArr7[i30];
                long j8 = jArr4[i30];
                int i35 = i31;
                int i36 = i33;
                while (i34 > 0) {
                    int min = Math.min(i27, i34);
                    jArr5[i32] = j8;
                    iArr8[i32] = zzeg * min;
                    i36 = Math.max(i36, iArr8[i32]);
                    jArr6[i32] = ((long) i35) * j7;
                    iArr9[i32] = 1;
                    j8 += (long) iArr8[i32];
                    i35 += min;
                    i34 -= min;
                    i32++;
                    jArr4 = jArr4;
                    iArr7 = iArr7;
                }
                i30++;
                i33 = i36;
                i31 = i35;
            }
            zzjh zzjh = new zzjh(jArr5, iArr8, i33, jArr6, iArr9);
            jArr2 = zzjh.zzagu;
            iArr = zzjh.zzagt;
            int i37 = zzjh.zzapp;
            jArr = zzjh.zzapq;
            iArr2 = zzjh.zzapr;
            i3 = i37;
            j = 0;
        }
        if (zzjs2.zzaso == null || zzid.zzea()) {
            zzqe.zza(jArr, 1000000, zzjs2.zzcr);
            return new zzjv(jArr2, iArr, i3, jArr, iArr2);
        }
        if (zzjs2.zzaso.length == 1 && zzjs2.type == 1 && jArr.length >= 2) {
            long j9 = zzjs2.zzasp[0];
            long zza = zzqe.zza(zzjs2.zzaso[0], zzjs2.zzcr, zzjs2.zzasl) + j9;
            if (jArr[0] <= j9 && j9 < jArr[1] && jArr[jArr.length - 1] < zza && zza <= j) {
                long j10 = j - zza;
                long zza2 = zzqe.zza(j9 - jArr[0], (long) zzjs2.zzaad.zzzu, zzjs2.zzcr);
                long zza3 = zzqe.zza(j10, (long) zzjs2.zzaad.zzzu, zzjs2.zzcr);
                if (!(zza2 == 0 && zza3 == 0) && zza2 <= 2147483647L && zza3 <= 2147483647L) {
                    zzid.zzzw = (int) zza2;
                    zzid.zzzx = (int) zza3;
                    zzqe.zza(jArr, 1000000, zzjs2.zzcr);
                    return new zzjv(jArr2, iArr, i3, jArr, iArr2);
                }
            }
        }
        if (zzjs2.zzaso.length == 1) {
            char c = 0;
            if (zzjs2.zzaso[0] == 0) {
                int i38 = 0;
                while (i38 < jArr.length) {
                    jArr[i38] = zzqe.zza(jArr[i38] - zzjs2.zzasp[c], 1000000, zzjs2.zzcr);
                    i38++;
                    c = 0;
                }
                return new zzjv(jArr2, iArr, i3, jArr, iArr2);
            }
        }
        boolean z3 = zzjs2.type == 1;
        int i39 = 0;
        boolean z4 = false;
        int i40 = 0;
        int i41 = 0;
        while (i39 < zzjs2.zzaso.length) {
            long j11 = zzjs2.zzasp[i39];
            if (j11 != -1) {
                iArr6 = iArr;
                long zza4 = zzqe.zza(zzjs2.zzaso[i39], zzjs2.zzcr, zzjs2.zzasl);
                int zzb = zzqe.zzb(jArr, j11, true, true);
                int zzb2 = zzqe.zzb(jArr, j11 + zza4, z3, false);
                i40 += zzb2 - zzb;
                z4 |= i41 != zzb;
                i41 = zzb2;
            } else {
                iArr6 = iArr;
            }
            i39++;
            iArr = iArr6;
        }
        int[] iArr10 = iArr;
        boolean z5 = (i40 != i4) | z4;
        long[] jArr7 = z5 ? new long[i40] : jArr2;
        int[] iArr11 = z5 ? new int[i40] : iArr10;
        if (z5) {
            i3 = 0;
        }
        int[] iArr12 = z5 ? new int[i40] : iArr2;
        long[] jArr8 = new long[i40];
        int i42 = i3;
        int i43 = 0;
        int i44 = 0;
        while (i43 < zzjs2.zzaso.length) {
            long j12 = zzjs2.zzasp[i43];
            long j13 = zzjs2.zzaso[i43];
            if (j12 != -1) {
                i5 = i43;
                int zzb3 = zzqe.zzb(jArr, j12, true, true);
                int zzb4 = zzqe.zzb(jArr, zzqe.zza(j13, zzjs2.zzcr, zzjs2.zzasl) + j12, z3, false);
                if (z5) {
                    int i45 = zzb4 - zzb3;
                    System.arraycopy(jArr2, zzb3, jArr7, i44, i45);
                    iArr4 = iArr10;
                    System.arraycopy(iArr4, zzb3, iArr11, i44, i45);
                    z2 = z3;
                    iArr5 = iArr12;
                    System.arraycopy(iArr2, zzb3, iArr5, i44, i45);
                } else {
                    iArr4 = iArr10;
                    z2 = z3;
                    iArr5 = iArr12;
                }
                int i46 = i42;
                while (zzb3 < zzb4) {
                    jArr8[i44] = zzqe.zza(j2, 1000000, zzjs2.zzasl) + zzqe.zza(jArr[zzb3] - j12, 1000000, zzjs2.zzcr);
                    if (z5 && iArr11[i44] > i46) {
                        i46 = iArr4[zzb3];
                    }
                    i44++;
                    zzb3++;
                    jArr2 = jArr2;
                    j12 = j12;
                    iArr2 = iArr2;
                }
                jArr3 = jArr2;
                iArr3 = iArr2;
                i42 = i46;
            } else {
                iArr4 = iArr10;
                z2 = z3;
                jArr3 = jArr2;
                iArr3 = iArr2;
                iArr5 = iArr12;
                i5 = i43;
            }
            j2 += j13;
            i43 = i5 + 1;
            iArr12 = iArr5;
            jArr2 = jArr3;
            iArr2 = iArr3;
            z3 = z2;
            iArr10 = iArr4;
        }
        boolean z6 = false;
        for (int i47 = 0; i47 < iArr12.length && !z6; i47++) {
            z6 |= (iArr12[i47] & 1) != 0;
        }
        if (z6) {
            return new zzjv(jArr7, iArr11, i42, jArr8, iArr12);
        }
        throw new zzfx("The edited sample sequence does not contain a sync sample.");
    }

    public static zzki zza(zzix zzix, boolean z) {
        if (z) {
            return null;
        }
        zzpx zzpx = zzix.zzaos;
        zzpx.setPosition(8);
        while (zzpx.zzhb() >= 8) {
            int position = zzpx.getPosition();
            int readInt = zzpx.readInt();
            if (zzpx.readInt() == zziv.zzaob) {
                zzpx.setPosition(position);
                int i = position + readInt;
                zzpx.zzbl(12);
                while (true) {
                    if (zzpx.getPosition() >= i) {
                        break;
                    }
                    int position2 = zzpx.getPosition();
                    int readInt2 = zzpx.readInt();
                    if (zzpx.readInt() == zziv.zzaoc) {
                        zzpx.setPosition(position2);
                        int i2 = position2 + readInt2;
                        zzpx.zzbl(8);
                        ArrayList arrayList = new ArrayList();
                        while (zzpx.getPosition() < i2) {
                            zzki.zza zzd = zzjm.zzd(zzpx);
                            if (zzd != null) {
                                arrayList.add(zzd);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            return new zzki(arrayList);
                        }
                    } else {
                        zzpx.zzbl(readInt2 - 8);
                    }
                }
                return null;
            }
            zzpx.zzbl(readInt - 8);
        }
        return null;
    }

    private static Pair<String, byte[]> zzb(zzpx zzpx, int i) {
        zzpx.setPosition(i + 8 + 4);
        zzpx.zzbl(1);
        zzc(zzpx);
        zzpx.zzbl(2);
        int readUnsignedByte = zzpx.readUnsignedByte();
        if ((readUnsignedByte & 128) != 0) {
            zzpx.zzbl(2);
        }
        if ((readUnsignedByte & 64) != 0) {
            zzpx.zzbl(zzpx.readUnsignedShort());
        }
        if ((readUnsignedByte & 32) != 0) {
            zzpx.zzbl(2);
        }
        zzpx.zzbl(1);
        zzc(zzpx);
        String str = null;
        switch (zzpx.readUnsignedByte()) {
            case 32:
                str = "video/mp4v-es";
                break;
            case 33:
                str = "video/avc";
                break;
            case 35:
                str = "video/hevc";
                break;
            case 64:
            case 102:
            case 103:
            case 104:
                str = "audio/mp4a-latm";
                break;
            case 107:
                return Pair.create("audio/mpeg", null);
            case 165:
                str = "audio/ac3";
                break;
            case 166:
                str = "audio/eac3";
                break;
            case 169:
            case 172:
                return Pair.create("audio/vnd.dts", null);
            case 170:
            case 171:
                return Pair.create("audio/vnd.dts.hd", null);
        }
        zzpx.zzbl(12);
        zzpx.zzbl(1);
        int zzc = zzc(zzpx);
        byte[] bArr = new byte[zzc];
        zzpx.zze(bArr, 0, zzc);
        return Pair.create(str, bArr);
    }

    private static int zza(zzpx zzpx, int i, int i2, zzjb zzjb, int i3) {
        zzjt zzjt;
        int position = zzpx.getPosition();
        while (true) {
            boolean z = false;
            if (position - i >= i2) {
                return 0;
            }
            zzpx.setPosition(position);
            int readInt = zzpx.readInt();
            zzpo.checkArgument(readInt > 0, "childAtomSize should be positive");
            if (zzpx.readInt() == zziv.zzamv) {
                int i4 = position + 8;
                Pair pair = null;
                Integer num = null;
                zzjt zzjt2 = null;
                boolean z2 = false;
                while (i4 - position < readInt) {
                    zzpx.setPosition(i4);
                    int readInt2 = zzpx.readInt();
                    int readInt3 = zzpx.readInt();
                    if (readInt3 == zziv.zzanb) {
                        num = Integer.valueOf(zzpx.readInt());
                    } else if (readInt3 == zziv.zzamw) {
                        zzpx.zzbl(4);
                        z2 = zzpx.readInt() == zzaoz;
                    } else if (readInt3 == zziv.zzamx) {
                        int i5 = i4 + 8;
                        while (true) {
                            if (i5 - i4 >= readInt2) {
                                zzjt = null;
                                break;
                            }
                            zzpx.setPosition(i5);
                            int readInt4 = zzpx.readInt();
                            if (zzpx.readInt() == zziv.zzamy) {
                                zzpx.zzbl(6);
                                boolean z3 = zzpx.readUnsignedByte() == 1;
                                int readUnsignedByte = zzpx.readUnsignedByte();
                                byte[] bArr = new byte[16];
                                zzpx.zze(bArr, 0, 16);
                                zzjt = new zzjt(z3, readUnsignedByte, bArr);
                            } else {
                                i5 += readInt4;
                            }
                        }
                        zzjt2 = zzjt;
                    }
                    i4 += readInt2;
                }
                if (z2) {
                    zzpo.checkArgument(num != null, "frma atom is mandatory");
                    if (zzjt2 != null) {
                        z = true;
                    }
                    zzpo.checkArgument(z, "schi->tenc atom is mandatory");
                    pair = Pair.create(num, zzjt2);
                }
                if (pair != null) {
                    zzjb.zzaph[i3] = (zzjt) pair.second;
                    return ((Integer) pair.first).intValue();
                }
            }
            position += readInt;
        }
    }

    private static int zzc(zzpx zzpx) {
        int readUnsignedByte = zzpx.readUnsignedByte();
        int i = readUnsignedByte & 127;
        while ((readUnsignedByte & 128) == 128) {
            readUnsignedByte = zzpx.readUnsignedByte();
            i = (i << 7) | (readUnsignedByte & 127);
        }
        return i;
    }
}
