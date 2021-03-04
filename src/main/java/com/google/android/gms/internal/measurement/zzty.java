package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzty extends zzta<Double> implements zzuu<Double>, zzwg, RandomAccess {
    private static final zzty zzbux;
    private int size;
    private double[] zzbuy;

    zzty() {
        this(new double[10], 0);
    }

    private zzty(double[] dArr, int i) {
        this.zzbuy = dArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzua();
        if (i2 >= i) {
            double[] dArr = this.zzbuy;
            System.arraycopy(dArr, i2, dArr, i, this.size - i2);
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
        if (!(obj instanceof zzty)) {
            return super.equals(obj);
        }
        zzty zzty = (zzty) obj;
        if (this.size != zzty.size) {
            return false;
        }
        double[] dArr = zzty.zzbuy;
        for (int i = 0; i < this.size; i++) {
            if (Double.doubleToLongBits(this.zzbuy[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzta
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzuq.zzbd(Double.doubleToLongBits(this.zzbuy[i2]));
        }
        return i;
    }

    public final int size() {
        return this.size;
    }

    public final void zzd(double d) {
        zzc(this.size, d);
    }

    private final void zzc(int i, double d) {
        int i2;
        zzua();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzak(i));
        }
        double[] dArr = this.zzbuy;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
        } else {
            double[] dArr2 = new double[(((i2 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.zzbuy, i, dArr2, i + 1, this.size - i);
            this.zzbuy = dArr2;
        }
        this.zzbuy[i] = d;
        this.size++;
        this.modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.List, com.google.android.gms.internal.measurement.zzta, java.util.Collection
    public final boolean addAll(Collection<? extends Double> collection) {
        zzua();
        zzuq.checkNotNull(collection);
        if (!(collection instanceof zzty)) {
            return super.addAll(collection);
        }
        zzty zzty = (zzty) collection;
        int i = zzty.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            double[] dArr = this.zzbuy;
            if (i3 > dArr.length) {
                this.zzbuy = Arrays.copyOf(dArr, i3);
            }
            System.arraycopy(zzty.zzbuy, 0, this.zzbuy, this.size, zzty.size);
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
            if (obj.equals(Double.valueOf(this.zzbuy[i]))) {
                double[] dArr = this.zzbuy;
                System.arraycopy(dArr, i + 1, dArr, i, (this.size - i) - 1);
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
    public final /* synthetic */ Double set(int i, Double d) {
        double doubleValue = d.doubleValue();
        zzua();
        zzaj(i);
        double[] dArr = this.zzbuy;
        double d2 = dArr[i];
        dArr[i] = doubleValue;
        return Double.valueOf(d2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, com.google.android.gms.internal.measurement.zzta, java.util.AbstractList
    public final /* synthetic */ Double remove(int i) {
        zzua();
        zzaj(i);
        double[] dArr = this.zzbuy;
        double d = dArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Double.valueOf(d);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // java.util.List, com.google.android.gms.internal.measurement.zzta, java.util.AbstractList
    public final /* synthetic */ void add(int i, Double d) {
        zzc(i, d.doubleValue());
    }

    /* Return type fixed from 'com.google.android.gms.internal.measurement.zzuu' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzuu
    public final /* synthetic */ zzuu<Double> zzal(int i) {
        if (i >= this.size) {
            return new zzty(Arrays.copyOf(this.zzbuy, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object get(int i) {
        zzaj(i);
        return Double.valueOf(this.zzbuy[i]);
    }

    static {
        zzty zzty = new zzty();
        zzbux = zzty;
        zzty.zzsw();
    }
}
