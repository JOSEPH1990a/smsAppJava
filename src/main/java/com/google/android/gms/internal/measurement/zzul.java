package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzul extends zzta<Float> implements zzuu<Float>, zzwg, RandomAccess {
    private static final zzul zzbxz;
    private int size;
    private float[] zzbya;

    zzul() {
        this(new float[10], 0);
    }

    private zzul(float[] fArr, int i) {
        this.zzbya = fArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzua();
        if (i2 >= i) {
            float[] fArr = this.zzbya;
            System.arraycopy(fArr, i2, fArr, i, this.size - i2);
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
        if (!(obj instanceof zzul)) {
            return super.equals(obj);
        }
        zzul zzul = (zzul) obj;
        if (this.size != zzul.size) {
            return false;
        }
        float[] fArr = zzul.zzbya;
        for (int i = 0; i < this.size; i++) {
            if (Float.floatToIntBits(this.zzbya[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzta
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.zzbya[i2]);
        }
        return i;
    }

    public final int size() {
        return this.size;
    }

    public final void zzc(float f) {
        zzc(this.size, f);
    }

    private final void zzc(int i, float f) {
        int i2;
        zzua();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzak(i));
        }
        float[] fArr = this.zzbya;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[(((i2 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.zzbya, i, fArr2, i + 1, this.size - i);
            this.zzbya = fArr2;
        }
        this.zzbya[i] = f;
        this.size++;
        this.modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.List, com.google.android.gms.internal.measurement.zzta, java.util.Collection
    public final boolean addAll(Collection<? extends Float> collection) {
        zzua();
        zzuq.checkNotNull(collection);
        if (!(collection instanceof zzul)) {
            return super.addAll(collection);
        }
        zzul zzul = (zzul) collection;
        int i = zzul.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            float[] fArr = this.zzbya;
            if (i3 > fArr.length) {
                this.zzbya = Arrays.copyOf(fArr, i3);
            }
            System.arraycopy(zzul.zzbya, 0, this.zzbya, this.size, zzul.size);
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
            if (obj.equals(Float.valueOf(this.zzbya[i]))) {
                float[] fArr = this.zzbya;
                System.arraycopy(fArr, i + 1, fArr, i, (this.size - i) - 1);
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
    public final /* synthetic */ Float set(int i, Float f) {
        float floatValue = f.floatValue();
        zzua();
        zzaj(i);
        float[] fArr = this.zzbya;
        float f2 = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, com.google.android.gms.internal.measurement.zzta, java.util.AbstractList
    public final /* synthetic */ Float remove(int i) {
        zzua();
        zzaj(i);
        float[] fArr = this.zzbya;
        float f = fArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Float.valueOf(f);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // java.util.List, com.google.android.gms.internal.measurement.zzta, java.util.AbstractList
    public final /* synthetic */ void add(int i, Float f) {
        zzc(i, f.floatValue());
    }

    /* Return type fixed from 'com.google.android.gms.internal.measurement.zzuu' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzuu
    public final /* synthetic */ zzuu<Float> zzal(int i) {
        if (i >= this.size) {
            return new zzul(Arrays.copyOf(this.zzbya, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object get(int i) {
        zzaj(i);
        return Float.valueOf(this.zzbya[i]);
    }

    static {
        zzul zzul = new zzul();
        zzbxz = zzul;
        zzul.zzsw();
    }
}
