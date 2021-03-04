package com.google.android.gms.internal.ads;

/* access modifiers changed from: package-private */
public final class zzlq {
    private int length;
    private int[] zzagt;
    private long[] zzagu;
    private long[] zzagw;
    private int[] zzapr;
    private int zzaxz = 1000;
    private int[] zzaya;
    private zzij[] zzayb;
    private zzfs[] zzayc;
    private int zzayd;
    private int zzaye;
    private int zzayf;
    private long zzayg;
    private long zzayh;
    private boolean zzayi;
    private boolean zzayj;
    private zzfs zzayk;

    public zzlq() {
        int i = this.zzaxz;
        this.zzaya = new int[i];
        this.zzagu = new long[i];
        this.zzagw = new long[i];
        this.zzapr = new int[i];
        this.zzagt = new int[i];
        this.zzayb = new zzij[i];
        this.zzayc = new zzfs[i];
        this.zzayg = Long.MIN_VALUE;
        this.zzayh = Long.MIN_VALUE;
        this.zzayj = true;
        this.zzayi = true;
    }

    public final void zzfi() {
        this.zzayd = 0;
        this.zzaye = 0;
        this.zzayf = 0;
        this.length = 0;
        this.zzayi = true;
    }

    public final void zzfj() {
        this.zzayg = Long.MIN_VALUE;
        this.zzayh = Long.MIN_VALUE;
    }

    public final int zzfk() {
        return this.zzayd + this.length;
    }

    public final long zzaq(int i) {
        int zzfk = zzfk() - i;
        zzpo.checkArgument(zzfk >= 0 && zzfk <= this.length);
        if (zzfk != 0) {
            this.length -= zzfk;
            int i2 = this.zzayf;
            int i3 = this.zzaxz;
            this.zzayf = ((i2 + i3) - zzfk) % i3;
            this.zzayh = Long.MIN_VALUE;
            for (int i4 = this.length - 1; i4 >= 0; i4--) {
                int i5 = (this.zzaye + i4) % this.zzaxz;
                this.zzayh = Math.max(this.zzayh, this.zzagw[i5]);
                if ((this.zzapr[i5] & 1) != 0) {
                    break;
                }
            }
            return this.zzagu[this.zzayf];
        } else if (this.zzayd == 0 && this.length == 0) {
            return 0;
        } else {
            int i6 = this.zzayf;
            if (i6 == 0) {
                i6 = this.zzaxz;
            }
            int i7 = i6 - 1;
            return this.zzagu[i7] + ((long) this.zzagt[i7]);
        }
    }

    public final int zzfl() {
        return this.zzayd;
    }

    public final synchronized boolean zzfm() {
        return this.length != 0;
    }

    public final synchronized zzfs zzfn() {
        if (this.zzayj) {
            return null;
        }
        return this.zzayk;
    }

    public final synchronized long zzfc() {
        return Math.max(this.zzayg, this.zzayh);
    }

    public final synchronized int zza(zzfu zzfu, zzho zzho, boolean z, boolean z2, zzfs zzfs, zzlr zzlr) {
        long j;
        if (!zzfm()) {
            if (z2) {
                zzho.setFlags(4);
                return -4;
            } else if (this.zzayk == null || (!z && this.zzayk == zzfs)) {
                return -3;
            } else {
                zzfu.zzaad = this.zzayk;
                return -5;
            }
        } else if (z || this.zzayc[this.zzaye] != zzfs) {
            zzfu.zzaad = this.zzayc[this.zzaye];
            return -5;
        } else {
            if (zzho.zzdd == null) {
                return -3;
            }
            zzho.zzago = this.zzagw[this.zzaye];
            zzho.setFlags(this.zzapr[this.zzaye]);
            zzlr.size = this.zzagt[this.zzaye];
            zzlr.zzapb = this.zzagu[this.zzaye];
            zzlr.zzajw = this.zzayb[this.zzaye];
            this.zzayg = Math.max(this.zzayg, zzho.zzago);
            this.length--;
            this.zzaye++;
            this.zzayd++;
            if (this.zzaye == this.zzaxz) {
                this.zzaye = 0;
            }
            if (this.length > 0) {
                j = this.zzagu[this.zzaye];
            } else {
                j = zzlr.zzapb + ((long) zzlr.size);
            }
            zzlr.zzayl = j;
            return -4;
        }
    }

    public final synchronized long zzfo() {
        if (!zzfm()) {
            return -1;
        }
        int i = ((this.zzaye + this.length) - 1) % this.zzaxz;
        this.zzaye = (this.zzaye + this.length) % this.zzaxz;
        this.zzayd += this.length;
        this.length = 0;
        return this.zzagu[i] + ((long) this.zzagt[i]);
    }

    public final synchronized long zzd(long j, boolean z) {
        if (zzfm()) {
            if (j >= this.zzagw[this.zzaye]) {
                if (j > this.zzayh && !z) {
                    return -1;
                }
                int i = this.zzaye;
                int i2 = -1;
                int i3 = 0;
                while (i != this.zzayf && this.zzagw[i] <= j) {
                    if ((this.zzapr[i] & 1) != 0) {
                        i2 = i3;
                    }
                    i = (i + 1) % this.zzaxz;
                    i3++;
                }
                if (i2 == -1) {
                    return -1;
                }
                this.zzaye = (this.zzaye + i2) % this.zzaxz;
                this.zzayd += i2;
                this.length -= i2;
                return this.zzagu[this.zzaye];
            }
        }
        return -1;
    }

    public final synchronized boolean zzh(zzfs zzfs) {
        if (zzfs == null) {
            this.zzayj = true;
            return false;
        }
        this.zzayj = false;
        if (zzqe.zza(zzfs, this.zzayk)) {
            return false;
        }
        this.zzayk = zzfs;
        return true;
    }

    public final synchronized void zza(long j, int i, long j2, int i2, zzij zzij) {
        if (this.zzayi) {
            if ((i & 1) != 0) {
                this.zzayi = false;
            } else {
                return;
            }
        }
        zzpo.checkState(!this.zzayj);
        zzac(j);
        this.zzagw[this.zzayf] = j;
        this.zzagu[this.zzayf] = j2;
        this.zzagt[this.zzayf] = i2;
        this.zzapr[this.zzayf] = i;
        this.zzayb[this.zzayf] = zzij;
        this.zzayc[this.zzayf] = this.zzayk;
        this.zzaya[this.zzayf] = 0;
        this.length++;
        if (this.length == this.zzaxz) {
            int i3 = this.zzaxz + 1000;
            int[] iArr = new int[i3];
            long[] jArr = new long[i3];
            long[] jArr2 = new long[i3];
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            zzij[] zzijArr = new zzij[i3];
            zzfs[] zzfsArr = new zzfs[i3];
            int i4 = this.zzaxz - this.zzaye;
            System.arraycopy(this.zzagu, this.zzaye, jArr, 0, i4);
            System.arraycopy(this.zzagw, this.zzaye, jArr2, 0, i4);
            System.arraycopy(this.zzapr, this.zzaye, iArr2, 0, i4);
            System.arraycopy(this.zzagt, this.zzaye, iArr3, 0, i4);
            System.arraycopy(this.zzayb, this.zzaye, zzijArr, 0, i4);
            System.arraycopy(this.zzayc, this.zzaye, zzfsArr, 0, i4);
            System.arraycopy(this.zzaya, this.zzaye, iArr, 0, i4);
            int i5 = this.zzaye;
            System.arraycopy(this.zzagu, 0, jArr, i4, i5);
            System.arraycopy(this.zzagw, 0, jArr2, i4, i5);
            System.arraycopy(this.zzapr, 0, iArr2, i4, i5);
            System.arraycopy(this.zzagt, 0, iArr3, i4, i5);
            System.arraycopy(this.zzayb, 0, zzijArr, i4, i5);
            System.arraycopy(this.zzayc, 0, zzfsArr, i4, i5);
            System.arraycopy(this.zzaya, 0, iArr, i4, i5);
            this.zzagu = jArr;
            this.zzagw = jArr2;
            this.zzapr = iArr2;
            this.zzagt = iArr3;
            this.zzayb = zzijArr;
            this.zzayc = zzfsArr;
            this.zzaya = iArr;
            this.zzaye = 0;
            this.zzayf = this.zzaxz;
            this.length = this.zzaxz;
            this.zzaxz = i3;
            return;
        }
        this.zzayf++;
        if (this.zzayf == this.zzaxz) {
            this.zzayf = 0;
        }
    }

    public final synchronized void zzac(long j) {
        this.zzayh = Math.max(this.zzayh, j);
    }
}
