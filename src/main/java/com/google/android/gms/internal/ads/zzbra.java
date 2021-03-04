package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzbra extends zzbpo<Float> implements zzbrk<Float>, zzbsx, RandomAccess {
    private static final zzbra zzfpq;
    private int size;
    private float[] zzfpr;

    zzbra() {
        this(new float[10], 0);
    }

    private zzbra(float[] fArr, int i) {
        this.zzfpr = fArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzakk();
        if (i2 >= i) {
            float[] fArr = this.zzfpr;
            System.arraycopy(fArr, i2, fArr, i, this.size - i2);
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
        if (!(obj instanceof zzbra)) {
            return super.equals(obj);
        }
        zzbra zzbra = (zzbra) obj;
        if (this.size != zzbra.size) {
            return false;
        }
        float[] fArr = zzbra.zzfpr;
        for (int i = 0; i < this.size; i++) {
            if (this.zzfpr[i] != fArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbpo
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.zzfpr[i2]);
        }
        return i;
    }

    public final int size() {
        return this.size;
    }

    public final void zzh(float f) {
        zzc(this.size, f);
    }

    private final void zzc(int i, float f) {
        int i2;
        zzakk();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzek(i));
        }
        float[] fArr = this.zzfpr;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[(((i2 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.zzfpr, i, fArr2, i + 1, this.size - i);
            this.zzfpr = fArr2;
        }
        this.zzfpr[i] = f;
        this.size++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzbpo, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends Float> collection) {
        zzakk();
        zzbrf.checkNotNull(collection);
        if (!(collection instanceof zzbra)) {
            return super.addAll(collection);
        }
        zzbra zzbra = (zzbra) collection;
        int i = zzbra.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            float[] fArr = this.zzfpr;
            if (i3 > fArr.length) {
                this.zzfpr = Arrays.copyOf(fArr, i3);
            }
            System.arraycopy(zzbra.zzfpr, 0, this.zzfpr, this.size, zzbra.size);
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
            if (obj.equals(Float.valueOf(this.zzfpr[i]))) {
                float[] fArr = this.zzfpr;
                System.arraycopy(fArr, i + 1, fArr, i, this.size - i);
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
    public final /* synthetic */ Float set(int i, Float f) {
        float floatValue = f.floatValue();
        zzakk();
        zzej(i);
        float[] fArr = this.zzfpr;
        float f2 = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzbpo, java.util.List, java.util.AbstractList
    public final /* synthetic */ Float remove(int i) {
        zzakk();
        zzej(i);
        float[] fArr = this.zzfpr;
        float f = fArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, i2 - i);
        }
        this.size--;
        this.modCount++;
        return Float.valueOf(f);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzbpo, java.util.List, java.util.AbstractList
    public final /* synthetic */ void add(int i, Float f) {
        zzc(i, f.floatValue());
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzbrk' to match base method */
    @Override // com.google.android.gms.internal.ads.zzbrk
    public final /* synthetic */ zzbrk<Float> zzel(int i) {
        if (i >= this.size) {
            return new zzbra(Arrays.copyOf(this.zzfpr, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object get(int i) {
        zzej(i);
        return Float.valueOf(this.zzfpr[i]);
    }

    static {
        zzbra zzbra = new zzbra();
        zzfpq = zzbra;
        zzbra.zzakj();
    }
}
