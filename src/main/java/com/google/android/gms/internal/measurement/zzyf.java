package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* access modifiers changed from: package-private */
public final class zzyf implements Cloneable {
    private Object value;
    private zzyd<?, ?> zzcfa;
    private List<zzyk> zzcfb = new ArrayList();

    zzyf() {
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzyk zzyk) throws IOException {
        Object obj;
        List<zzyk> list = this.zzcfb;
        if (list != null) {
            list.add(zzyk);
            return;
        }
        Object obj2 = this.value;
        if (obj2 instanceof zzyi) {
            byte[] bArr = zzyk.zzbtx;
            zzxz zzj = zzxz.zzj(bArr, 0, bArr.length);
            int zzvb = zzj.zzvb();
            if (zzvb == bArr.length - zzya.zzbe(zzvb)) {
                obj = ((zzyi) this.value).zza(zzj);
            } else {
                throw zzyh.zzzd();
            }
        } else if (obj2 instanceof zzyi[]) {
            zzyi[] zzyiArr = (zzyi[]) this.zzcfa.zzai(Collections.singletonList(zzyk));
            zzyi[] zzyiArr2 = (zzyi[]) this.value;
            zzyi[] zzyiArr3 = (zzyi[]) Arrays.copyOf(zzyiArr2, zzyiArr2.length + zzyiArr.length);
            System.arraycopy(zzyiArr, 0, zzyiArr3, zzyiArr2.length, zzyiArr.length);
            obj = zzyiArr3;
        } else if (obj2 instanceof zzvv) {
            obj = ((zzvv) this.value).zzwh().zza((zzvv) this.zzcfa.zzai(Collections.singletonList(zzyk))).zzwo();
        } else if (obj2 instanceof zzvv[]) {
            zzvv[] zzvvArr = (zzvv[]) this.zzcfa.zzai(Collections.singletonList(zzyk));
            zzvv[] zzvvArr2 = (zzvv[]) this.value;
            zzvv[] zzvvArr3 = (zzvv[]) Arrays.copyOf(zzvvArr2, zzvvArr2.length + zzvvArr.length);
            System.arraycopy(zzvvArr, 0, zzvvArr3, zzvvArr2.length, zzvvArr.length);
            obj = zzvvArr3;
        } else {
            obj = this.zzcfa.zzai(Collections.singletonList(zzyk));
        }
        this.zzcfa = this.zzcfa;
        this.value = obj;
        this.zzcfb = null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.android.gms.internal.measurement.zzyd<?, T> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    public final <T> T zzb(zzyd<?, T> zzyd) {
        if (this.value == null) {
            this.zzcfa = zzyd;
            this.value = zzyd.zzai(this.zzcfb);
            this.zzcfb = null;
        } else if (!this.zzcfa.equals(zzyd)) {
            throw new IllegalStateException("Tried to getExtension with a different Extension.");
        }
        return (T) this.value;
    }

    /* access modifiers changed from: package-private */
    public final int zzf() {
        Object obj = this.value;
        if (obj != null) {
            zzyd<?, ?> zzyd = this.zzcfa;
            if (!zzyd.zzcev) {
                return zzyd.zzao(obj);
            }
            int length = Array.getLength(obj);
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                Object obj2 = Array.get(obj, i2);
                if (obj2 != null) {
                    i += zzyd.zzao(obj2);
                }
            }
            return i;
        }
        int i3 = 0;
        for (zzyk zzyk : this.zzcfb) {
            i3 += zzya.zzbl(zzyk.tag) + 0 + zzyk.zzbtx.length;
        }
        return i3;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzya zzya) throws IOException {
        Object obj = this.value;
        if (obj != null) {
            zzyd<?, ?> zzyd = this.zzcfa;
            if (zzyd.zzcev) {
                int length = Array.getLength(obj);
                for (int i = 0; i < length; i++) {
                    Object obj2 = Array.get(obj, i);
                    if (obj2 != null) {
                        zzyd.zza(obj2, zzya);
                    }
                }
                return;
            }
            zzyd.zza(obj, zzya);
            return;
        }
        for (zzyk zzyk : this.zzcfb) {
            zzya.zzcd(zzyk.tag);
            zzya.zzp(zzyk.zzbtx);
        }
    }

    public final boolean equals(Object obj) {
        List<zzyk> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzyf)) {
            return false;
        }
        zzyf zzyf = (zzyf) obj;
        if (this.value == null || zzyf.value == null) {
            List<zzyk> list2 = this.zzcfb;
            if (list2 != null && (list = zzyf.zzcfb) != null) {
                return list2.equals(list);
            }
            try {
                return Arrays.equals(toByteArray(), zzyf.toByteArray());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } else {
            zzyd<?, ?> zzyd = this.zzcfa;
            if (zzyd != zzyf.zzcfa) {
                return false;
            }
            if (!zzyd.zzceu.isArray()) {
                return this.value.equals(zzyf.value);
            }
            Object obj2 = this.value;
            if (obj2 instanceof byte[]) {
                return Arrays.equals((byte[]) obj2, (byte[]) zzyf.value);
            }
            if (obj2 instanceof int[]) {
                return Arrays.equals((int[]) obj2, (int[]) zzyf.value);
            }
            if (obj2 instanceof long[]) {
                return Arrays.equals((long[]) obj2, (long[]) zzyf.value);
            }
            if (obj2 instanceof float[]) {
                return Arrays.equals((float[]) obj2, (float[]) zzyf.value);
            }
            if (obj2 instanceof double[]) {
                return Arrays.equals((double[]) obj2, (double[]) zzyf.value);
            }
            if (obj2 instanceof boolean[]) {
                return Arrays.equals((boolean[]) obj2, (boolean[]) zzyf.value);
            }
            return Arrays.deepEquals((Object[]) obj2, (Object[]) zzyf.value);
        }
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private final byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zzf()];
        zza(zzya.zzo(bArr));
        return bArr;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzzc */
    public final zzyf clone() {
        zzyf zzyf = new zzyf();
        try {
            zzyf.zzcfa = this.zzcfa;
            if (this.zzcfb == null) {
                zzyf.zzcfb = null;
            } else {
                zzyf.zzcfb.addAll(this.zzcfb);
            }
            if (this.value != null) {
                if (this.value instanceof zzyi) {
                    zzyf.value = (zzyi) ((zzyi) this.value).clone();
                } else if (this.value instanceof byte[]) {
                    zzyf.value = ((byte[]) this.value).clone();
                } else {
                    int i = 0;
                    if (this.value instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.value;
                        byte[][] bArr2 = new byte[bArr.length][];
                        zzyf.value = bArr2;
                        while (i < bArr.length) {
                            bArr2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (this.value instanceof boolean[]) {
                        zzyf.value = ((boolean[]) this.value).clone();
                    } else if (this.value instanceof int[]) {
                        zzyf.value = ((int[]) this.value).clone();
                    } else if (this.value instanceof long[]) {
                        zzyf.value = ((long[]) this.value).clone();
                    } else if (this.value instanceof float[]) {
                        zzyf.value = ((float[]) this.value).clone();
                    } else if (this.value instanceof double[]) {
                        zzyf.value = ((double[]) this.value).clone();
                    } else if (this.value instanceof zzyi[]) {
                        zzyi[] zzyiArr = (zzyi[]) this.value;
                        zzyi[] zzyiArr2 = new zzyi[zzyiArr.length];
                        zzyf.value = zzyiArr2;
                        while (i < zzyiArr.length) {
                            zzyiArr2[i] = (zzyi) zzyiArr[i].clone();
                            i++;
                        }
                    }
                }
            }
            return zzyf;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
