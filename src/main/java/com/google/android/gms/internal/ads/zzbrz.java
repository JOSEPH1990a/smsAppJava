package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzbrz extends zzbpo<Long> implements zzbrk<Long>, zzbsx, RandomAccess {
    private static final zzbrz zzfru;
    private int size;
    private long[] zzfrv;

    zzbrz() {
        this(new long[10], 0);
    }

    private zzbrz(long[] jArr, int i) {
        this.zzfrv = jArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzakk();
        if (i2 >= i) {
            long[] jArr = this.zzfrv;
            System.arraycopy(jArr, i2, jArr, i, this.size - i2);
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
        if (!(obj instanceof zzbrz)) {
            return super.equals(obj);
        }
        zzbrz zzbrz = (zzbrz) obj;
        if (this.size != zzbrz.size) {
            return false;
        }
        long[] jArr = zzbrz.zzfrv;
        for (int i = 0; i < this.size; i++) {
            if (this.zzfrv[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbpo
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzbrf.zzbi(this.zzfrv[i2]);
        }
        return i;
    }

    public final long getLong(int i) {
        zzej(i);
        return this.zzfrv[i];
    }

    public final int size() {
        return this.size;
    }

    public final void zzbj(long j) {
        zzt(this.size, j);
    }

    private final void zzt(int i, long j) {
        int i2;
        zzakk();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzek(i));
        }
        long[] jArr = this.zzfrv;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[(((i2 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.zzfrv, i, jArr2, i + 1, this.size - i);
            this.zzfrv = jArr2;
        }
        this.zzfrv[i] = j;
        this.size++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzbpo, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends Long> collection) {
        zzakk();
        zzbrf.checkNotNull(collection);
        if (!(collection instanceof zzbrz)) {
            return super.addAll(collection);
        }
        zzbrz zzbrz = (zzbrz) collection;
        int i = zzbrz.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.zzfrv;
            if (i3 > jArr.length) {
                this.zzfrv = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(zzbrz.zzfrv, 0, this.zzfrv, this.size, zzbrz.size);
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
            if (obj.equals(Long.valueOf(this.zzfrv[i]))) {
                long[] jArr = this.zzfrv;
                System.arraycopy(jArr, i + 1, jArr, i, this.size - i);
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
    public final /* synthetic */ Long set(int i, Long l) {
        long longValue = l.longValue();
        zzakk();
        zzej(i);
        long[] jArr = this.zzfrv;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzbpo, java.util.List, java.util.AbstractList
    public final /* synthetic */ Long remove(int i) {
        zzakk();
        zzej(i);
        long[] jArr = this.zzfrv;
        long j = jArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, i2 - i);
        }
        this.size--;
        this.modCount++;
        return Long.valueOf(j);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzbpo, java.util.List, java.util.AbstractList
    public final /* synthetic */ void add(int i, Long l) {
        zzt(i, l.longValue());
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzbrk' to match base method */
    @Override // com.google.android.gms.internal.ads.zzbrk
    public final /* synthetic */ zzbrk<Long> zzel(int i) {
        if (i >= this.size) {
            return new zzbrz(Arrays.copyOf(this.zzfrv, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(getLong(i));
    }

    static {
        zzbrz zzbrz = new zzbrz();
        zzfru = zzbrz;
        zzbrz.zzakj();
    }
}
