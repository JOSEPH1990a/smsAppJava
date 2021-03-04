package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzbps extends zzbpo<Boolean> implements zzbrk<Boolean>, zzbsx, RandomAccess {
    private static final zzbps zzflg;
    private int size;
    private boolean[] zzflh;

    zzbps() {
        this(new boolean[10], 0);
    }

    private zzbps(boolean[] zArr, int i) {
        this.zzflh = zArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzakk();
        if (i2 >= i) {
            boolean[] zArr = this.zzflh;
            System.arraycopy(zArr, i2, zArr, i, this.size - i2);
            this.size -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.ads.zzbpo
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbps)) {
            return super.equals(obj);
        }
        zzbps zzbps = (zzbps) obj;
        if (this.size != zzbps.size) {
            return false;
        }
        boolean[] zArr = zzbps.zzflh;
        for (int i = 0; i < this.size; i++) {
            if (this.zzflh[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbpo
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzbrf.zzbf(this.zzflh[i2]);
        }
        return i;
    }

    public final int size() {
        return this.size;
    }

    public final void addBoolean(boolean z) {
        zzi(this.size, z);
    }

    private final void zzi(int i, boolean z) {
        int i2;
        zzakk();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzek(i));
        }
        boolean[] zArr = this.zzflh;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[(((i2 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.zzflh, i, zArr2, i + 1, this.size - i);
            this.zzflh = zArr2;
        }
        this.zzflh[i] = z;
        this.size++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzbpo, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzakk();
        zzbrf.checkNotNull(collection);
        if (!(collection instanceof zzbps)) {
            return super.addAll(collection);
        }
        zzbps zzbps = (zzbps) collection;
        int i = zzbps.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            boolean[] zArr = this.zzflh;
            if (i3 > zArr.length) {
                this.zzflh = Arrays.copyOf(zArr, i3);
            }
            System.arraycopy(zzbps.zzflh, 0, this.zzflh, this.size, zzbps.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // com.google.android.gms.internal.ads.zzbpo, java.util.List
    public final boolean remove(Object obj) {
        zzakk();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Boolean.valueOf(this.zzflh[i]))) {
                boolean[] zArr = this.zzflh;
                System.arraycopy(zArr, i + 1, zArr, i, this.size - i);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void zzej(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzek(i));
        }
    }

    private final String zzek(int i) {
        int i2 = this.size;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzbpo, java.util.List, java.util.AbstractList
    public final /* synthetic */ Boolean set(int i, Boolean bool) {
        boolean booleanValue = bool.booleanValue();
        zzakk();
        zzej(i);
        boolean[] zArr = this.zzflh;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzbpo, java.util.List, java.util.AbstractList
    public final /* synthetic */ Boolean remove(int i) {
        zzakk();
        zzej(i);
        boolean[] zArr = this.zzflh;
        boolean z = zArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, i2 - i);
        }
        this.size--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzbpo, java.util.List, java.util.AbstractList
    public final /* synthetic */ void add(int i, Boolean bool) {
        zzi(i, bool.booleanValue());
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzbrk' to match base method */
    @Override // com.google.android.gms.internal.ads.zzbrk
    public final /* synthetic */ zzbrk<Boolean> zzel(int i) {
        if (i >= this.size) {
            return new zzbps(Arrays.copyOf(this.zzflh, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object get(int i) {
        zzej(i);
        return Boolean.valueOf(this.zzflh[i]);
    }

    static {
        zzbps zzbps = new zzbps();
        zzflg = zzbps;
        zzbps.zzakj();
    }
}
