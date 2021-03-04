package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zztc extends zzta<Boolean> implements zzuu<Boolean>, zzwg, RandomAccess {
    private static final zztc zzbto;
    private int size;
    private boolean[] zzbtp;

    zztc() {
        this(new boolean[10], 0);
    }

    private zztc(boolean[] zArr, int i) {
        this.zzbtp = zArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzua();
        if (i2 >= i) {
            boolean[] zArr = this.zzbtp;
            System.arraycopy(zArr, i2, zArr, i, this.size - i2);
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
        if (!(obj instanceof zztc)) {
            return super.equals(obj);
        }
        zztc zztc = (zztc) obj;
        if (this.size != zztc.size) {
            return false;
        }
        boolean[] zArr = zztc.zzbtp;
        for (int i = 0; i < this.size; i++) {
            if (this.zzbtp[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzta
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzuq.zzu(this.zzbtp[i2]);
        }
        return i;
    }

    public final int size() {
        return this.size;
    }

    public final void addBoolean(boolean z) {
        zza(this.size, z);
    }

    private final void zza(int i, boolean z) {
        int i2;
        zzua();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzak(i));
        }
        boolean[] zArr = this.zzbtp;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[(((i2 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.zzbtp, i, zArr2, i + 1, this.size - i);
            this.zzbtp = zArr2;
        }
        this.zzbtp[i] = z;
        this.size++;
        this.modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.List, com.google.android.gms.internal.measurement.zzta, java.util.Collection
    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzua();
        zzuq.checkNotNull(collection);
        if (!(collection instanceof zztc)) {
            return super.addAll(collection);
        }
        zztc zztc = (zztc) collection;
        int i = zztc.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            boolean[] zArr = this.zzbtp;
            if (i3 > zArr.length) {
                this.zzbtp = Arrays.copyOf(zArr, i3);
            }
            System.arraycopy(zztc.zzbtp, 0, this.zzbtp, this.size, zztc.size);
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
            if (obj.equals(Boolean.valueOf(this.zzbtp[i]))) {
                boolean[] zArr = this.zzbtp;
                System.arraycopy(zArr, i + 1, zArr, i, (this.size - i) - 1);
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
    public final /* synthetic */ Boolean set(int i, Boolean bool) {
        boolean booleanValue = bool.booleanValue();
        zzua();
        zzaj(i);
        boolean[] zArr = this.zzbtp;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, com.google.android.gms.internal.measurement.zzta, java.util.AbstractList
    public final /* synthetic */ Boolean remove(int i) {
        zzua();
        zzaj(i);
        boolean[] zArr = this.zzbtp;
        boolean z = zArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // java.util.List, com.google.android.gms.internal.measurement.zzta, java.util.AbstractList
    public final /* synthetic */ void add(int i, Boolean bool) {
        zza(i, bool.booleanValue());
    }

    /* Return type fixed from 'com.google.android.gms.internal.measurement.zzuu' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzuu
    public final /* synthetic */ zzuu<Boolean> zzal(int i) {
        if (i >= this.size) {
            return new zztc(Arrays.copyOf(this.zzbtp, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object get(int i) {
        zzaj(i);
        return Boolean.valueOf(this.zzbtp[i]);
    }

    static {
        zztc zztc = new zztc();
        zzbto = zztc;
        zztc.zzsw();
    }
}
