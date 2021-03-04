package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuo;

final class zzun implements zzvu {
    private static final zzun zzbyc = new zzun();

    private zzun() {
    }

    public static zzun zzwe() {
        return zzbyc;
    }

    @Override // com.google.android.gms.internal.measurement.zzvu
    public final boolean zze(Class<?> cls) {
        return zzuo.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.measurement.zzvu
    public final zzvt zzf(Class<?> cls) {
        if (!zzuo.class.isAssignableFrom(cls)) {
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unsupported message type: ".concat(valueOf) : new String("Unsupported message type: "));
        }
        try {
            return (zzvt) zzuo.zzg(cls.asSubclass(zzuo.class)).zza(zzuo.zze.zzbym, (Object) null, (Object) null);
        } catch (Exception e) {
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? "Unable to get message info for ".concat(valueOf2) : new String("Unable to get message info for "), e);
        }
    }
}
