package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbqw;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class zzbqu<FieldDescriptorType extends zzbqw<FieldDescriptorType>> {
    private static final zzbqu zzfna = new zzbqu(true);
    private final zzbtf<FieldDescriptorType, Object> zzfmx = zzbtf.zzfx(16);
    private boolean zzfmy;
    private boolean zzfmz = false;

    private zzbqu() {
    }

    private zzbqu(boolean z) {
        zzakj();
    }

    public static <T extends zzbqw<T>> zzbqu<T> zzami() {
        return zzfna;
    }

    /* access modifiers changed from: package-private */
    public final boolean isEmpty() {
        return this.zzfmx.isEmpty();
    }

    public final void zzakj() {
        if (!this.zzfmy) {
            this.zzfmx.zzakj();
            this.zzfmy = true;
        }
    }

    public final boolean isImmutable() {
        return this.zzfmy;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbqu)) {
            return false;
        }
        return this.zzfmx.equals(((zzbqu) obj).zzfmx);
    }

    public final int hashCode() {
        return this.zzfmx.hashCode();
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> iterator() {
        if (this.zzfmz) {
            return new zzbrr(this.zzfmx.entrySet().iterator());
        }
        return this.zzfmx.entrySet().iterator();
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Map.Entry<FieldDescriptorType, Object>> descendingIterator() {
        if (this.zzfmz) {
            return new zzbrr(this.zzfmx.zzaor().iterator());
        }
        return this.zzfmx.zzaor().iterator();
    }

    private final Object zza(FieldDescriptorType fielddescriptortype) {
        Object obj = this.zzfmx.get(fielddescriptortype);
        return obj instanceof zzbro ? zzbro.zzanm() : obj;
    }

    private final void zza(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.zzamn()) {
            zza(fielddescriptortype.zzaml(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zza(fielddescriptortype.zzaml(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzbro) {
            this.zzfmz = true;
        }
        this.zzfmx.put(fielddescriptortype, obj);
    }

    private static void zza(zzbuj zzbuj, Object obj) {
        zzbrf.checkNotNull(obj);
        boolean z = false;
        switch (zzbqv.zzfnb[zzbuj.zzapj().ordinal()]) {
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
                if ((obj instanceof zzbpu) || (obj instanceof byte[])) {
                    z = true;
                    break;
                }
            case 8:
                if ((obj instanceof Integer) || (obj instanceof zzbrg)) {
                    z = true;
                    break;
                }
            case 9:
                if ((obj instanceof zzbsl) || (obj instanceof zzbro)) {
                    z = true;
                    break;
                }
        }
        if (!z) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.zzfmx.zzaop(); i++) {
            if (!zzb(this.zzfmx.zzfy(i))) {
                return false;
            }
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.zzfmx.zzaoq()) {
            if (!zzb(entry)) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzb(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.zzamm() == zzbuo.MESSAGE) {
            if (key.zzamn()) {
                for (zzbsl zzbsl : (List) entry.getValue()) {
                    if (!zzbsl.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzbsl) {
                    if (!((zzbsl) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof zzbro) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzbqu<FieldDescriptorType> zzbqu) {
        for (int i = 0; i < zzbqu.zzfmx.zzaop(); i++) {
            zzc(zzbqu.zzfmx.zzfy(i));
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : zzbqu.zzfmx.zzaoq()) {
            zzc(entry);
        }
    }

    private static Object zzt(Object obj) {
        if (obj instanceof zzbss) {
            return ((zzbss) obj).zzaoc();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final void zzc(Map.Entry<FieldDescriptorType, Object> entry) {
        zzbsl zzbsl;
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzbro) {
            value = zzbro.zzanm();
        }
        if (key.zzamn()) {
            Object zza = zza(key);
            if (zza == null) {
                zza = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) zza).add(zzt(obj));
            }
            this.zzfmx.put(key, zza);
        } else if (key.zzamm() == zzbuo.MESSAGE) {
            Object zza2 = zza(key);
            if (zza2 == null) {
                this.zzfmx.put(key, zzt(value));
                return;
            }
            if (zza2 instanceof zzbss) {
                zzbsl = key.zza((zzbss) zza2, (zzbss) value);
            } else {
                zzbsl = key.zza(((zzbsl) zza2).zzamt(), (zzbsl) value).zzana();
            }
            this.zzfmx.put(key, zzbsl);
        } else {
            this.zzfmx.put(key, zzt(value));
        }
    }

    static void zza(zzbqk zzbqk, zzbuj zzbuj, int i, Object obj) throws IOException {
        if (zzbuj == zzbuj.GROUP) {
            zzbsl zzbsl = (zzbsl) obj;
            zzbrf.zzi(zzbsl);
            zzbqk.zzu(i, 3);
            zzbsl.zzb(zzbqk);
            zzbqk.zzu(i, 4);
            return;
        }
        zzbqk.zzu(i, zzbuj.zzapk());
        switch (zzbqv.zzfmd[zzbuj.ordinal()]) {
            case 1:
                zzbqk.zzb(((Double) obj).doubleValue());
                return;
            case 2:
                zzbqk.zzf(((Float) obj).floatValue());
                return;
            case 3:
                zzbqk.zzay(((Long) obj).longValue());
                return;
            case 4:
                zzbqk.zzay(((Long) obj).longValue());
                return;
            case 5:
                zzbqk.zzez(((Integer) obj).intValue());
                return;
            case 6:
                zzbqk.zzba(((Long) obj).longValue());
                return;
            case 7:
                zzbqk.zzfc(((Integer) obj).intValue());
                return;
            case 8:
                zzbqk.zzbd(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzbsl) obj).zzb(zzbqk);
                return;
            case 10:
                zzbqk.zze((zzbsl) obj);
                return;
            case 11:
                if (obj instanceof zzbpu) {
                    zzbqk.zzan((zzbpu) obj);
                    return;
                } else {
                    zzbqk.zzfx((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzbpu) {
                    zzbqk.zzan((zzbpu) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzbqk.zzl(bArr, 0, bArr.length);
                return;
            case 13:
                zzbqk.zzfa(((Integer) obj).intValue());
                return;
            case 14:
                zzbqk.zzfc(((Integer) obj).intValue());
                return;
            case 15:
                zzbqk.zzba(((Long) obj).longValue());
                return;
            case 16:
                zzbqk.zzfb(((Integer) obj).intValue());
                return;
            case 17:
                zzbqk.zzaz(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzbrg) {
                    zzbqk.zzez(((zzbrg) obj).zzom());
                    return;
                } else {
                    zzbqk.zzez(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public final int zzamj() {
        int i = 0;
        for (int i2 = 0; i2 < this.zzfmx.zzaop(); i2++) {
            Map.Entry<FieldDescriptorType, Object> zzfy = this.zzfmx.zzfy(i2);
            i += zzb((zzbqw<?>) zzfy.getKey(), zzfy.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.zzfmx.zzaoq()) {
            i += zzb((zzbqw<?>) entry.getKey(), entry.getValue());
        }
        return i;
    }

    public final int zzamk() {
        int i = 0;
        for (int i2 = 0; i2 < this.zzfmx.zzaop(); i2++) {
            i += zzd(this.zzfmx.zzfy(i2));
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.zzfmx.zzaoq()) {
            i += zzd(entry);
        }
        return i;
    }

    private static int zzd(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzamm() != zzbuo.MESSAGE || key.zzamn() || key.zzamo()) {
            return zzb((zzbqw<?>) key, value);
        }
        if (value instanceof zzbro) {
            return zzbqk.zzb(entry.getKey().zzom(), (zzbro) value);
        }
        return zzbqk.zzd(entry.getKey().zzom(), (zzbsl) value);
    }

    static int zza(zzbuj zzbuj, int i, Object obj) {
        int zzfd = zzbqk.zzfd(i);
        if (zzbuj == zzbuj.GROUP) {
            zzbrf.zzi((zzbsl) obj);
            zzfd <<= 1;
        }
        return zzfd + zzb(zzbuj, obj);
    }

    private static int zzb(zzbuj zzbuj, Object obj) {
        switch (zzbqv.zzfmd[zzbuj.ordinal()]) {
            case 1:
                return zzbqk.zzc(((Double) obj).doubleValue());
            case 2:
                return zzbqk.zzg(((Float) obj).floatValue());
            case 3:
                return zzbqk.zzbb(((Long) obj).longValue());
            case 4:
                return zzbqk.zzbc(((Long) obj).longValue());
            case 5:
                return zzbqk.zzfe(((Integer) obj).intValue());
            case 6:
                return zzbqk.zzbe(((Long) obj).longValue());
            case 7:
                return zzbqk.zzfh(((Integer) obj).intValue());
            case 8:
                return zzbqk.zzbe(((Boolean) obj).booleanValue());
            case 9:
                return zzbqk.zzg((zzbsl) obj);
            case 10:
                if (obj instanceof zzbro) {
                    return zzbqk.zza((zzbro) obj);
                }
                return zzbqk.zzf((zzbsl) obj);
            case 11:
                if (obj instanceof zzbpu) {
                    return zzbqk.zzao((zzbpu) obj);
                }
                return zzbqk.zzfy((String) obj);
            case 12:
                if (obj instanceof zzbpu) {
                    return zzbqk.zzao((zzbpu) obj);
                }
                return zzbqk.zzu((byte[]) obj);
            case 13:
                return zzbqk.zzff(((Integer) obj).intValue());
            case 14:
                return zzbqk.zzfi(((Integer) obj).intValue());
            case 15:
                return zzbqk.zzbf(((Long) obj).longValue());
            case 16:
                return zzbqk.zzfg(((Integer) obj).intValue());
            case 17:
                return zzbqk.zzbd(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzbrg) {
                    return zzbqk.zzfj(((zzbrg) obj).zzom());
                }
                return zzbqk.zzfj(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static int zzb(zzbqw<?> zzbqw, Object obj) {
        zzbuj zzaml = zzbqw.zzaml();
        int zzom = zzbqw.zzom();
        if (!zzbqw.zzamn()) {
            return zza(zzaml, zzom, obj);
        }
        int i = 0;
        if (zzbqw.zzamo()) {
            for (Object obj2 : (List) obj) {
                i += zzb(zzaml, obj2);
            }
            return zzbqk.zzfd(zzom) + i + zzbqk.zzfl(i);
        }
        for (Object obj3 : (List) obj) {
            i += zza(zzaml, zzom, obj3);
        }
        return i;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzbqu zzbqu = new zzbqu();
        for (int i = 0; i < this.zzfmx.zzaop(); i++) {
            Map.Entry<FieldDescriptorType, Object> zzfy = this.zzfmx.zzfy(i);
            zzbqu.zza(zzfy.getKey(), zzfy.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.zzfmx.zzaoq()) {
            zzbqu.zza(entry.getKey(), entry.getValue());
        }
        zzbqu.zzfmz = this.zzfmz;
        return zzbqu;
    }
}
