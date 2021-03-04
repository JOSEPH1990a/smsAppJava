package com.google.android.gms.internal.measurement;

public final class zzye implements Cloneable {
    private static final zzyf zzcew = new zzyf();
    private int mSize;
    private boolean zzcex;
    private int[] zzcey;
    private zzyf[] zzcez;

    zzye() {
        this(10);
    }

    private zzye(int i) {
        this.zzcex = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.zzcey = new int[idealIntArraySize];
        this.zzcez = new zzyf[idealIntArraySize];
        this.mSize = 0;
    }

    /* access modifiers changed from: package-private */
    public final zzyf zzce(int i) {
        int zzcg = zzcg(i);
        if (zzcg < 0) {
            return null;
        }
        zzyf[] zzyfArr = this.zzcez;
        if (zzyfArr[zzcg] == zzcew) {
            return null;
        }
        return zzyfArr[zzcg];
    }

    /* access modifiers changed from: package-private */
    public final void zza(int i, zzyf zzyf) {
        int zzcg = zzcg(i);
        if (zzcg >= 0) {
            this.zzcez[zzcg] = zzyf;
            return;
        }
        int i2 = zzcg ^ -1;
        if (i2 < this.mSize) {
            zzyf[] zzyfArr = this.zzcez;
            if (zzyfArr[i2] == zzcew) {
                this.zzcey[i2] = i;
                zzyfArr[i2] = zzyf;
                return;
            }
        }
        int i3 = this.mSize;
        if (i3 >= this.zzcey.length) {
            int idealIntArraySize = idealIntArraySize(i3 + 1);
            int[] iArr = new int[idealIntArraySize];
            zzyf[] zzyfArr2 = new zzyf[idealIntArraySize];
            int[] iArr2 = this.zzcey;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            zzyf[] zzyfArr3 = this.zzcez;
            System.arraycopy(zzyfArr3, 0, zzyfArr2, 0, zzyfArr3.length);
            this.zzcey = iArr;
            this.zzcez = zzyfArr2;
        }
        int i4 = this.mSize;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.zzcey;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            zzyf[] zzyfArr4 = this.zzcez;
            System.arraycopy(zzyfArr4, i2, zzyfArr4, i5, this.mSize - i2);
        }
        this.zzcey[i2] = i;
        this.zzcez[i2] = zzyf;
        this.mSize++;
    }

    /* access modifiers changed from: package-private */
    public final int size() {
        return this.mSize;
    }

    public final boolean isEmpty() {
        return this.mSize == 0;
    }

    /* access modifiers changed from: package-private */
    public final zzyf zzcf(int i) {
        return this.zzcez[i];
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzye)) {
            return false;
        }
        zzye zzye = (zzye) obj;
        int i = this.mSize;
        if (i != zzye.mSize) {
            return false;
        }
        int[] iArr = this.zzcey;
        int[] iArr2 = zzye.zzcey;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                z = true;
                break;
            } else if (iArr[i2] != iArr2[i2]) {
                z = false;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            zzyf[] zzyfArr = this.zzcez;
            zzyf[] zzyfArr2 = zzye.zzcez;
            int i3 = this.mSize;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    z2 = true;
                    break;
                } else if (!zzyfArr[i4].equals(zzyfArr2[i4])) {
                    z2 = false;
                    break;
                } else {
                    i4++;
                }
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.zzcey[i2]) * 31) + this.zzcez[i2].hashCode();
        }
        return i;
    }

    private static int idealIntArraySize(int i) {
        int i2 = i << 2;
        int i3 = 4;
        while (true) {
            if (i3 >= 32) {
                break;
            }
            int i4 = (1 << i3) - 12;
            if (i2 <= i4) {
                i2 = i4;
                break;
            }
            i3++;
        }
        return i2 / 4;
    }

    private final int zzcg(int i) {
        int i2 = this.mSize - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            int i5 = this.zzcey[i4];
            if (i5 < i) {
                i3 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i2 = i4 - 1;
            }
        }
        return i3 ^ -1;
    }

    @Override // java.lang.Object
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        int i = this.mSize;
        zzye zzye = new zzye(i);
        System.arraycopy(this.zzcey, 0, zzye.zzcey, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            zzyf[] zzyfArr = this.zzcez;
            if (zzyfArr[i2] != null) {
                zzye.zzcez[i2] = (zzyf) zzyfArr[i2].clone();
            }
        }
        zzye.mSize = i;
        return zzye;
    }
}
