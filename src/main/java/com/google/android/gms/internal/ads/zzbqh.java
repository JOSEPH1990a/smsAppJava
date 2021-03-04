package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* access modifiers changed from: package-private */
public final class zzbqh extends zzbqf {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zzflv;
    private int zzflw;
    private int zzflx;
    private int zzfly;
    private int zzflz;

    private zzbqh(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzflz = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i2 + i;
        this.pos = i;
        this.zzflx = this.pos;
        this.zzflv = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final int zzaku() throws IOException {
        if (zzalk()) {
            this.zzfly = 0;
            return 0;
        }
        this.zzfly = zzalm();
        int i = this.zzfly;
        if ((i >>> 3) != 0) {
            return i;
        }
        throw zzbrl.zzanf();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final void zzeo(int i) throws zzbrl {
        if (this.zzfly != i) {
            throw zzbrl.zzang();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final boolean zzep(int i) throws IOException {
        int zzaku;
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
                    throw zzbrl.zzane();
                }
                while (i2 < 10) {
                    if (zzalr() < 0) {
                        i2++;
                    }
                }
                throw zzbrl.zzane();
                return true;
            case 1:
                zzet(8);
                return true;
            case 2:
                zzet(zzalm());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                zzet(4);
                return true;
            default:
                throw zzbrl.zzanh();
        }
        do {
            zzaku = zzaku();
            if (zzaku != 0) {
            }
            zzeo(((i >>> 3) << 3) | 4);
            return true;
        } while (zzep(zzaku));
        zzeo(((i >>> 3) << 3) | 4);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(zzalp());
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(zzalo());
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final long zzakv() throws IOException {
        return zzaln();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final long zzakw() throws IOException {
        return zzaln();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final int zzakx() throws IOException {
        return zzalm();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final long zzaky() throws IOException {
        return zzalp();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final int zzakz() throws IOException {
        return zzalo();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final boolean zzala() throws IOException {
        return zzaln() != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final String readString() throws IOException {
        int zzalm = zzalm();
        if (zzalm > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (zzalm <= i - i2) {
                String str = new String(this.buffer, i2, zzalm, zzbrf.UTF_8);
                this.pos += zzalm;
                return str;
            }
        }
        if (zzalm == 0) {
            return "";
        }
        if (zzalm < 0) {
            throw zzbrl.zzand();
        }
        throw zzbrl.zzanc();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final String zzalb() throws IOException {
        int zzalm = zzalm();
        if (zzalm > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (zzalm <= i - i2) {
                String zzo = zzbuc.zzo(this.buffer, i2, zzalm);
                this.pos += zzalm;
                return zzo;
            }
        }
        if (zzalm == 0) {
            return "";
        }
        if (zzalm <= 0) {
            throw zzbrl.zzand();
        }
        throw zzbrl.zzanc();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final <T extends zzbsl> T zza(zzbsw<T> zzbsw, zzbqq zzbqq) throws IOException {
        int zzalm = zzalm();
        if (this.zzflq < this.zzflr) {
            int zzer = zzer(zzalm);
            this.zzflq++;
            T zza = zzbsw.zza(this, zzbqq);
            zzeo(0);
            this.zzflq--;
            zzes(zzer);
            return zza;
        }
        throw zzbrl.zzani();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final zzbpu zzalc() throws IOException {
        byte[] bArr;
        int zzalm = zzalm();
        if (zzalm > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (zzalm <= i - i2) {
                zzbpu zzi = zzbpu.zzi(this.buffer, i2, zzalm);
                this.pos += zzalm;
                return zzi;
            }
        }
        if (zzalm == 0) {
            return zzbpu.zzfli;
        }
        if (zzalm > 0) {
            int i3 = this.limit;
            int i4 = this.pos;
            if (zzalm <= i3 - i4) {
                this.pos = zzalm + i4;
                bArr = Arrays.copyOfRange(this.buffer, i4, this.pos);
                return zzbpu.zzs(bArr);
            }
        }
        if (zzalm > 0) {
            throw zzbrl.zzanc();
        } else if (zzalm == 0) {
            bArr = zzbrf.zzfqr;
            return zzbpu.zzs(bArr);
        } else {
            throw zzbrl.zzand();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final int zzald() throws IOException {
        return zzalm();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final int zzale() throws IOException {
        return zzalm();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final int zzalf() throws IOException {
        return zzalo();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final long zzalg() throws IOException {
        return zzalp();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final int zzalh() throws IOException {
        return zzeu(zzalm());
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final long zzali() throws IOException {
        return zzax(zzaln());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0066, code lost:
        if (r2[r3] >= 0) goto L_0x006a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzalm() throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 115
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbqh.zzalm():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b7, code lost:
        if (((long) r2[r0]) >= 0) goto L_0x00bb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long zzaln() throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 195
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbqh.zzaln():long");
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzbqf
    public final long zzalj() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzalr = zzalr();
            j |= ((long) (zzalr & Byte.MAX_VALUE)) << i;
            if ((zzalr & 128) == 0) {
                return j;
            }
        }
        throw zzbrl.zzane();
    }

    private final int zzalo() throws IOException {
        int i = this.pos;
        if (this.limit - i >= 4) {
            byte[] bArr = this.buffer;
            this.pos = i + 4;
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }
        throw zzbrl.zzanc();
    }

    private final long zzalp() throws IOException {
        int i = this.pos;
        if (this.limit - i >= 8) {
            byte[] bArr = this.buffer;
            this.pos = i + 8;
            return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        }
        throw zzbrl.zzanc();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final int zzer(int i) throws zzbrl {
        if (i >= 0) {
            int zzall = i + zzall();
            int i2 = this.zzflz;
            if (zzall <= i2) {
                this.zzflz = zzall;
                zzalq();
                return i2;
            }
            throw zzbrl.zzanc();
        }
        throw zzbrl.zzand();
    }

    private final void zzalq() {
        this.limit += this.zzflw;
        int i = this.limit;
        int i2 = i - this.zzflx;
        int i3 = this.zzflz;
        if (i2 > i3) {
            this.zzflw = i2 - i3;
            this.limit = i - this.zzflw;
            return;
        }
        this.zzflw = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final void zzes(int i) {
        this.zzflz = i;
        zzalq();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final boolean zzalk() throws IOException {
        return this.pos == this.limit;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final int zzall() {
        return this.pos - this.zzflx;
    }

    private final byte zzalr() throws IOException {
        int i = this.pos;
        if (i != this.limit) {
            byte[] bArr = this.buffer;
            this.pos = i + 1;
            return bArr[i];
        }
        throw zzbrl.zzanc();
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final void zzet(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.limit;
            int i3 = this.pos;
            if (i <= i2 - i3) {
                this.pos = i3 + i;
                return;
            }
        }
        if (i < 0) {
            throw zzbrl.zzand();
        }
        throw zzbrl.zzanc();
    }
}
