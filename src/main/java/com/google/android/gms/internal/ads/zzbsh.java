package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

final class zzbsh implements zzbsg {
    zzbsh() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final Map<?, ?> zzw(Object obj) {
        return (zzbsf) obj;
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final zzbse<?, ?> zzab(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final Map<?, ?> zzx(Object obj) {
        return (zzbsf) obj;
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final boolean zzy(Object obj) {
        return !((zzbsf) obj).isMutable();
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final Object zzz(Object obj) {
        ((zzbsf) obj).zzakj();
        return obj;
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final Object zzaa(Object obj) {
        return zzbsf.zzant().zzanu();
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final Object zzc(Object obj, Object obj2) {
        zzbsf zzbsf = (zzbsf) obj;
        zzbsf zzbsf2 = (zzbsf) obj2;
        if (!zzbsf2.isEmpty()) {
            if (!zzbsf.isMutable()) {
                zzbsf = zzbsf.zzanu();
            }
            zzbsf.zza(zzbsf2);
        }
        return zzbsf;
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final int zzb(int i, Object obj, Object obj2) {
        zzbsf zzbsf = (zzbsf) obj;
        if (zzbsf.isEmpty()) {
            return 0;
        }
        Iterator it = zzbsf.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
