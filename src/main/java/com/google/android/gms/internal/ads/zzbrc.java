package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;

final class zzbrc implements zzbsk {
    private static final zzbrc zzfpt = new zzbrc();

    private zzbrc() {
    }

    public static zzbrc zzamq() {
        return zzfpt;
    }

    @Override // com.google.android.gms.internal.ads.zzbsk
    public final boolean zzb(Class<?> cls) {
        return zzbrd.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.ads.zzbsk
    public final zzbsj zzc(Class<?> cls) {
        if (!zzbrd.class.isAssignableFrom(cls)) {
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unsupported message type: ".concat(valueOf) : new String("Unsupported message type: "));
        }
        try {
            return (zzbsj) zzbrd.zzd(cls.asSubclass(zzbrd.class)).zza(zzbrd.zze.zzfqd, (Object) null, (Object) null);
        } catch (Exception e) {
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? "Unable to get message info for ".concat(valueOf2) : new String("Unable to get message info for "), e);
        }
    }
}
