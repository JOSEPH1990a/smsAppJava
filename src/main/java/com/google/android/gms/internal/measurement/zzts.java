package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;

/* access modifiers changed from: package-private */
public final class zzts extends zztq {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zzbud;
    private int zzbue;
    private int zzbuf;
    private int zzbug;
    private int zzbuh;

    private zzts(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzbuh = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i2 + i;
        this.pos = i;
        this.zzbuf = this.pos;
        this.zzbud = z;
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final int zzuj() throws IOException {
        if (zzuz()) {
            this.zzbug = 0;
            return 0;
        }
        this.zzbug = zzvb();
        int i = this.zzbug;
        if ((i >>> 3) != 0) {
            return i;
        }
        throw new zzuv("Protocol message contained an invalid tag (zero).");
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final void zzap(int i) throws zzuv {
        if (this.zzbug != i) {
            throw zzuv.zzwt();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final boolean zzaq(int i) throws IOException {
        int zzuj;
        int i2 = 0;
        switch (i & 7) {
            case 0:
                if (this.limit - this.pos >= 10) {
                    while (i2 < 10) {
                        byte[] bArr = this.buffer;
                        int i3 = this.pos;
                        this.pos = i3 + 1;
                        if (bArr[i3] < 0) {
                            i2++;
                        }
                    }
                    throw zzuv.zzws();
                }
                while (i2 < 10) {
                    if (zzvg() < 0) {
                        i2++;
                    }
                }
                throw zzuv.zzws();
                return true;
            case 1:
                zzau(8);
                return true;
            case 2:
                zzau(zzvb());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                zzau(4);
                return true;
            default:
                throw zzuv.zzwu();
        }
        do {
            zzuj = zzuj();
            if (zzuj != 0) {
            }
            zzap(((i >>> 3) << 3) | 4);
            return true;
        } while (zzaq(zzuj));
        zzap(((i >>> 3) << 3) | 4);
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(zzve());
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(zzvd());
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final long zzuk() throws IOException {
        return zzvc();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final long zzul() throws IOException {
        return zzvc();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final int zzum() throws IOException {
        return zzvb();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final long zzun() throws IOException {
        return zzve();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final int zzuo() throws IOException {
        return zzvd();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final boolean zzup() throws IOException {
        return zzvc() != 0;
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final String readString() throws IOException {
        int zzvb = zzvb();
        if (zzvb > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (zzvb <= i - i2) {
                String str = new String(this.buffer, i2, zzvb, zzuq.UTF_8);
                this.pos += zzvb;
                return str;
            }
        }
        if (zzvb == 0) {
            return "";
        }
        if (zzvb < 0) {
            throw zzuv.zzwr();
        }
        throw zzuv.zzwq();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final String zzuq() throws IOException {
        int zzvb = zzvb();
        if (zzvb > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (zzvb <= i - i2) {
                String zzh = zzxl.zzh(this.buffer, i2, zzvb);
                this.pos += zzvb;
                return zzh;
            }
        }
        if (zzvb == 0) {
            return "";
        }
        if (zzvb <= 0) {
            throw zzuv.zzwr();
        }
        throw zzuv.zzwq();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final <T extends zzvv> T zza(zzwf<T> zzwf, zzub zzub) throws IOException {
        int zzvb = zzvb();
        if (this.zzbty < this.zzbtz) {
            int zzas = zzas(zzvb);
            this.zzbty++;
            T zza = zzwf.zza(this, zzub);
            zzap(0);
            this.zzbty--;
            zzat(zzas);
            return zza;
        }
        throw zzuv.zzwv();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final zzte zzur() throws IOException {
        byte[] bArr;
        int zzvb = zzvb();
        if (zzvb > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (zzvb <= i - i2) {
                zzte zzb = zzte.zzb(this.buffer, i2, zzvb);
                this.pos += zzvb;
                return zzb;
            }
        }
        if (zzvb == 0) {
            return zzte.zzbtq;
        }
        if (zzvb > 0) {
            int i3 = this.limit;
            int i4 = this.pos;
            if (zzvb <= i3 - i4) {
                this.pos = zzvb + i4;
                bArr = Arrays.copyOfRange(this.buffer, i4, this.pos);
                return zzte.zzi(bArr);
            }
        }
        if (zzvb > 0) {
            throw zzuv.zzwq();
        } else if (zzvb == 0) {
            bArr = zzuq.zzbza;
            return zzte.zzi(bArr);
        } else {
            throw zzuv.zzwr();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final int zzus() throws IOException {
        return zzvb();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final int zzut() throws IOException {
        return zzvb();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final int zzuu() throws IOException {
        return zzvd();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final long zzuv() throws IOException {
        return zzve();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final int zzuw() throws IOException {
        int zzvb = zzvb();
        return (-(zzvb & 1)) ^ (zzvb >>> 1);
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final long zzux() throws IOException {
        long zzvc = zzvc();
        return (-(zzvc & 1)) ^ (zzvc >>> 1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0066, code lost:
        if (r2[r3] >= 0) goto L_0x006a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzvb() throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 115
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzts.zzvb():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b7, code lost:
        if (((long) r2[r0]) >= 0) goto L_0x00bb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long zzvc() throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 195
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzts.zzvc():long");
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zztq
    public final long zzuy() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzvg = zzvg();
            j |= ((long) (zzvg & Byte.MAX_VALUE)) << i;
            if ((zzvg & 128) == 0) {
                return j;
            }
        }
        throw zzuv.zzws();
    }

    private final int zzvd() throws IOException {
        int i = this.pos;
        if (this.limit - i >= 4) {
            byte[] bArr = this.buffer;
            this.pos = i + 4;
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }
        throw zzuv.zzwq();
    }

    private final long zzve() throws IOException {
        int i = this.pos;
        if (this.limit - i >= 8) {
            byte[] bArr = this.buffer;
            this.pos = i + 8;
            return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        }
        throw zzuv.zzwq();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final int zzas(int i) throws zzuv {
        if (i >= 0) {
            int zzva = i + zzva();
            int i2 = this.zzbuh;
            if (zzva <= i2) {
                this.zzbuh = zzva;
                zzvf();
                return i2;
            }
            throw zzuv.zzwq();
        }
        throw zzuv.zzwr();
    }

    private final void zzvf() {
        this.limit += this.zzbue;
        int i = this.limit;
        int i2 = i - this.zzbuf;
        int i3 = this.zzbuh;
        if (i2 > i3) {
            this.zzbue = i2 - i3;
            this.limit = i - this.zzbue;
            return;
        }
        this.zzbue = 0;
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final void zzat(int i) {
        this.zzbuh = i;
        zzvf();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final boolean zzuz() throws IOException {
        return this.pos == this.limit;
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final int zzva() {
        return this.pos - this.zzbuf;
    }

    private final byte zzvg() throws IOException {
        int i = this.pos;
        if (i != this.limit) {
            byte[] bArr = this.buffer;
            this.pos = i + 1;
            return bArr[i];
        }
        throw zzuv.zzwq();
    }

    @Override // com.google.android.gms.internal.measurement.zztq
    public final void zzau(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.limit;
            int i3 = this.pos;
            if (i <= i2 - i3) {
                this.pos = i3 + i;
                return;
            }
        }
        if (i < 0) {
            throw zzuv.zzwr();
        }
        throw zzuv.zzwq();
    }
}
