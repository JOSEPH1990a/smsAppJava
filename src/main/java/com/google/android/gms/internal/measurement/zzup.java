package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzup extends zzta<Integer> implements zzuu<Integer>, zzwg, RandomAccess {
    private static final zzup zzbyy;
    private int size;
    private int[] zzbyz;

    zzup() {
        this(new int[10], 0);
    }

    private zzup(int[] iArr, int i) {
        this.zzbyz = iArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzua();
        if (i2 >= i) {
            int[] iArr = this.zzbyz;
            System.arraycopy(iArr, i2, iArr, i, this.size - i2);
            this.size -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.measurement.zzta
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzup)) {
            return super.equals(obj);
        }
        zzup zzup = (zzup) obj;
        if (this.size != zzup.size) {
            return false;
        }
        int[] iArr = zzup.zzbyz;
        for (int i = 0; i < this.size; i++) {
            if (this.zzbyz[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzta
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + this.zzbyz[i2];
        }
        return i;
    }

    public final int getInt(int i) {
        zzaj(i);
        return this.zzbyz[i];
    }

    public final int size() {
        return this.size;
    }

    public final void zzbo(int i) {
        zzp(this.size, i);
    }

    private final void zzp(int i, int i2) {
        int i3;
        zzua();
        if (i < 0 || i > (i3 = this.size)) {
            throw new IndexOutOfBoundsException(zzak(i));
        }
        int[] iArr = this.zzbyz;
        if (i3 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i3 - i);
        } else {
            int[] iArr2 = new int[(((i3 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.zzbyz, i, iArr2, i + 1, this.size - i);
            this.zzbyz = iArr2;
        }
        this.zzbyz[i] = i2;
        this.size++;
        this.modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.List, com.google.android.gms.internal.measurement.zzta, java.util.Collection
    public final boolean addAll(Collection<? extends Integer> collection) {
        zzua();
        zzuq.checkNotNull(collection);
        if (!(collection instanceof zzup)) {
            return super.addAll(collection);
        }
        zzup zzup = (zzup) collection;
        int i = zzup.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.zzbyz;
            if (i3 > iArr.length) {
                this.zzbyz = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(zzup.zzbyz, 0, this.zzbyz, this.size, zzup.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // java.util.List, com.google.android.gms.internal.measurement.zzta
    public final boolean remove(Object obj) {
        zzua();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Integer.valueOf(this.zzbyz[i]))) {
                int[] iArr = this.zzbyz;
                System.arraycopy(iArr, i + 1, iArr, i, (this.size - i) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void zzaj(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzak(i));
        }
    }

    private final String zzak(int i) {
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
    @Override // java.util.List, com.google.android.gms.internal.measurement.zzta, java.util.AbstractList
    public final /* synthetic */ Integer set(int i, Integer num) {
        int intValue = num.intValue();
        zzua();
        zzaj(i);
        int[] iArr = this.zzbyz;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, com.google.android.gms.internal.measurement.zzta, java.util.AbstractList
    public final /* synthetic */ Integer remove(int i) {
        zzua();
        zzaj(i);
        int[] iArr = this.zzbyz;
        int i2 = iArr[i];
        int i3 = this.size;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (i3 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // java.util.List, com.google.android.gms.internal.measurement.zzta, java.util.AbstractList
    public final /* synthetic */ void add(int i, Integer num) {
        zzp(i, num.intValue());
    }

    /* Return type fixed from 'com.google.android.gms.internal.measurement.zzuu' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzuu
    public final /* synthetic */ zzuu<Integer> zzal(int i) {
        if (i >= this.size) {
            return new zzup(Arrays.copyOf(this.zzbyz, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(getInt(i));
    }

    static {
        zzup zzup = new zzup();
        zzbyy = zzup;
        zzup.zzsw();
    }
}
