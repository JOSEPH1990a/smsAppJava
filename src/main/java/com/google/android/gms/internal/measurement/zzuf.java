package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuh;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class zzuf<FieldDescriptorType extends zzuh<FieldDescriptorType>> {
    private static final zzuf zzbvj = new zzuf(true);
    private boolean zzbpy;
    private final zzwo<FieldDescriptorType, Object> zzbvh = zzwo.zzbw(16);
    private boolean zzbvi = false;

    private zzuf() {
    }

    private zzuf(boolean z) {
        zzsw();
    }

    public static <T extends zzuh<T>> zzuf<T> zzvw() {
        return zzbvj;
    }

    /* access modifiers changed from: package-private */
    public final boolean isEmpty() {
        return this.zzbvh.isEmpty();
    }

    public final void zzsw() {
        if (!this.zzbpy) {
            this.zzbvh.zzsw();
            this.zzbpy = true;
        }
    }

    public final boolean isImmutable() {
        return this.zzbpy;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzuf)) {
            return false;
        }
        return this.zzbvh.equals(((zzuf) obj).zzbvh);
    }

    public final int hashCode() {
        return this.zzbvh.hashCode();
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> iterator() {
        if (this.zzbvi) {
            return new zzvb(this.zzbvh.entrySet().iterator());
        }
        return this.zzbvh.entrySet().iterator();
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Map.Entry<FieldDescriptorType, Object>> descendingIterator() {
        if (this.zzbvi) {
            return new zzvb(this.zzbvh.zzye().iterator());
        }
        return this.zzbvh.zzye().iterator();
    }

    private final Object zza(FieldDescriptorType fielddescriptortype) {
        Object obj = this.zzbvh.get(fielddescriptortype);
        return obj instanceof zzuy ? zzuy.zzwz() : obj;
    }

    private final void zza(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.zzwb()) {
            zza(fielddescriptortype.zzvz(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zza(fielddescriptortype.zzvz(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzuy) {
            this.zzbvi = true;
        }
        this.zzbvh.put(fielddescriptortype, obj);
    }

    private static void zza(zzxs zzxs, Object obj) {
        zzuq.checkNotNull(obj);
        boolean z = false;
        switch (zzug.zzbvk[zzxs.zzyv().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                break;
            case 2:
                z = obj instanceof Long;
                break;
            case 3:
                z = obj instanceof Float;
                break;
            case 4:
                z = obj instanceof Double;
                break;
            case 5:
                z = obj instanceof Boolean;
                break;
            case 6:
                z = obj instanceof String;
                break;
            case 7:
                if ((obj instanceof zzte) || (obj instanceof byte[])) {
                    z = true;
                    break;
                }
            case 8:
                if ((obj instanceof Integer) || (obj instanceof zzur)) {
                    z = true;
                    break;
                }
            case 9:
                if ((obj instanceof zzvv) || (obj instanceof zzuy)) {
                    z = true;
                    break;
                }
        }
        if (!z) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.zzbvh.zzyc(); i++) {
            if (!zzc(this.zzbvh.zzbx(i))) {
                return false;
            }
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.zzbvh.zzyd()) {
            if (!zzc(entry)) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzc(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.zzwa() == zzxx.MESSAGE) {
            if (key.zzwb()) {
                for (zzvv zzvv : (List) entry.getValue()) {
                    if (!zzvv.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzvv) {
                    if (!((zzvv) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof zzuy) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzuf<FieldDescriptorType> zzuf) {
        for (int i = 0; i < zzuf.zzbvh.zzyc(); i++) {
            zzd(zzuf.zzbvh.zzbx(i));
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : zzuf.zzbvh.zzyd()) {
            zzd(entry);
        }
    }

    private static Object zzz(Object obj) {
        if (obj instanceof zzwb) {
            return ((zzwb) obj).zzxp();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final void zzd(Map.Entry<FieldDescriptorType, Object> entry) {
        zzvv zzvv;
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzuy) {
            value = zzuy.zzwz();
        }
        if (key.zzwb()) {
            Object zza = zza(key);
            if (zza == null) {
                zza = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) zza).add(zzz(obj));
            }
            this.zzbvh.put(key, zza);
        } else if (key.zzwa() == zzxx.MESSAGE) {
            Object zza2 = zza(key);
            if (zza2 == null) {
                this.zzbvh.put(key, zzz(value));
                return;
            }
            if (zza2 instanceof zzwb) {
                zzvv = key.zza((zzwb) zza2, (zzwb) value);
            } else {
                zzvv = key.zza(((zzvv) zza2).zzwh(), (zzvv) value).zzwo();
            }
            this.zzbvh.put(key, zzvv);
        } else {
            this.zzbvh.put(key, zzz(value));
        }
    }

    static void zza(zztv zztv, zzxs zzxs, int i, Object obj) throws IOException {
        if (zzxs == zzxs.GROUP) {
            zzvv zzvv = (zzvv) obj;
            zzuq.zzf(zzvv);
            zztv.zzc(i, 3);
            zzvv.zzb(zztv);
            zztv.zzc(i, 4);
            return;
        }
        zztv.zzc(i, zzxs.zzyw());
        switch (zzug.zzbul[zzxs.ordinal()]) {
            case 1:
                zztv.zzb(((Double) obj).doubleValue());
                return;
            case 2:
                zztv.zza(((Float) obj).floatValue());
                return;
            case 3:
                zztv.zzat(((Long) obj).longValue());
                return;
            case 4:
                zztv.zzat(((Long) obj).longValue());
                return;
            case 5:
                zztv.zzaz(((Integer) obj).intValue());
                return;
            case 6:
                zztv.zzav(((Long) obj).longValue());
                return;
            case 7:
                zztv.zzbc(((Integer) obj).intValue());
                return;
            case 8:
                zztv.zzs(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzvv) obj).zzb(zztv);
                return;
            case 10:
                zztv.zzb((zzvv) obj);
                return;
            case 11:
                if (obj instanceof zzte) {
                    zztv.zza((zzte) obj);
                    return;
                } else {
                    zztv.zzgb((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzte) {
                    zztv.zza((zzte) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zztv.zze(bArr, 0, bArr.length);
                return;
            case 13:
                zztv.zzba(((Integer) obj).intValue());
                return;
            case 14:
                zztv.zzbc(((Integer) obj).intValue());
                return;
            case 15:
                zztv.zzav(((Long) obj).longValue());
                return;
            case 16:
                zztv.zzbb(((Integer) obj).intValue());
                return;
            case 17:
                zztv.zzau(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzur) {
                    zztv.zzaz(((zzur) obj).zzc());
                    return;
                } else {
                    zztv.zzaz(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public final int zzvx() {
        int i = 0;
        for (int i2 = 0; i2 < this.zzbvh.zzyc(); i2++) {
            Map.Entry<FieldDescriptorType, Object> zzbx = this.zzbvh.zzbx(i2);
            i += zzb((zzuh<?>) zzbx.getKey(), zzbx.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.zzbvh.zzyd()) {
            i += zzb((zzuh<?>) entry.getKey(), entry.getValue());
        }
        return i;
    }

    public final int zzvy() {
        int i = 0;
        for (int i2 = 0; i2 < this.zzbvh.zzyc(); i2++) {
            i += zze(this.zzbvh.zzbx(i2));
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.zzbvh.zzyd()) {
            i += zze(entry);
        }
        return i;
    }

    private static int zze(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzwa() != zzxx.MESSAGE || key.zzwb() || key.zzwc()) {
            return zzb((zzuh<?>) key, value);
        }
        if (value instanceof zzuy) {
            return zztv.zzb(entry.getKey().zzc(), (zzuy) value);
        }
        return zztv.zzd(entry.getKey().zzc(), (zzvv) value);
    }

    static int zza(zzxs zzxs, int i, Object obj) {
        int zzbd = zztv.zzbd(i);
        if (zzxs == zzxs.GROUP) {
            zzuq.zzf((zzvv) obj);
            zzbd <<= 1;
        }
        return zzbd + zzb(zzxs, obj);
    }

    private static int zzb(zzxs zzxs, Object obj) {
        switch (zzug.zzbul[zzxs.ordinal()]) {
            case 1:
                return zztv.zzc(((Double) obj).doubleValue());
            case 2:
                return zztv.zzb(((Float) obj).floatValue());
            case 3:
                return zztv.zzaw(((Long) obj).longValue());
            case 4:
                return zztv.zzax(((Long) obj).longValue());
            case 5:
                return zztv.zzbe(((Integer) obj).intValue());
            case 6:
                return zztv.zzaz(((Long) obj).longValue());
            case 7:
                return zztv.zzbh(((Integer) obj).intValue());
            case 8:
                return zztv.zzt(((Boolean) obj).booleanValue());
            case 9:
                return zztv.zzd((zzvv) obj);
            case 10:
                if (obj instanceof zzuy) {
                    return zztv.zza((zzuy) obj);
                }
                return zztv.zzc((zzvv) obj);
            case 11:
                if (obj instanceof zzte) {
                    return zztv.zzb((zzte) obj);
                }
                return zztv.zzgc((String) obj);
            case 12:
                if (obj instanceof zzte) {
                    return zztv.zzb((zzte) obj);
                }
                return zztv.zzk((byte[]) obj);
            case 13:
                return zztv.zzbf(((Integer) obj).intValue());
            case 14:
                return zztv.zzbi(((Integer) obj).intValue());
            case 15:
                return zztv.zzba(((Long) obj).longValue());
            case 16:
                return zztv.zzbg(((Integer) obj).intValue());
            case 17:
                return zztv.zzay(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzur) {
                    return zztv.zzbj(((zzur) obj).zzc());
                }
                return zztv.zzbj(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static int zzb(zzuh<?> zzuh, Object obj) {
        zzxs zzvz = zzuh.zzvz();
        int zzc = zzuh.zzc();
        if (!zzuh.zzwb()) {
            return zza(zzvz, zzc, obj);
        }
        int i = 0;
        if (zzuh.zzwc()) {
            for (Object obj2 : (List) obj) {
                i += zzb(zzvz, obj2);
            }
            return zztv.zzbd(zzc) + i + zztv.zzbl(i);
        }
        for (Object obj3 : (List) obj) {
            i += zza(zzvz, zzc, obj3);
        }
        return i;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzuf zzuf = new zzuf();
        for (int i = 0; i < this.zzbvh.zzyc(); i++) {
            Map.Entry<FieldDescriptorType, Object> zzbx = this.zzbvh.zzbx(i);
            zzuf.zza(zzbx.getKey(), zzbx.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.zzbvh.zzyd()) {
            zzuf.zza(entry.getKey(), entry.getValue());
        }
        zzuf.zzbvi = this.zzbvi;
        return zzuf;
    }
}
