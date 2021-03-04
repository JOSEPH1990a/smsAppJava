package com.google.android.gms.internal.measurement;

final class zzvm implements zzvu {
    private zzvu[] zzcah;

    zzvm(zzvu... zzvuArr) {
        this.zzcah = zzvuArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzvu
    public final boolean zze(Class<?> cls) {
        for (zzvu zzvu : this.zzcah) {
            if (zzvu.zze(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzvu
    public final zzvt zzf(Class<?> cls) {
        zzvu[] zzvuArr = this.zzcah;
        for (zzvu zzvu : zzvuArr) {
            if (zzvu.zze(cls)) {
                return zzvu.zzf(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
