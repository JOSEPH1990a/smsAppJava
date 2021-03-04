package com.google.android.gms.internal.ads;

final class zzbsc implements zzbsk {
    private zzbsk[] zzfry;

    zzbsc(zzbsk... zzbskArr) {
        this.zzfry = zzbskArr;
    }

    @Override // com.google.android.gms.internal.ads.zzbsk
    public final boolean zzb(Class<?> cls) {
        for (zzbsk zzbsk : this.zzfry) {
            if (zzbsk.zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbsk
    public final zzbsj zzc(Class<?> cls) {
        zzbsk[] zzbskArr = this.zzfry;
        for (zzbsk zzbsk : zzbskArr) {
            if (zzbsk.zzb(cls)) {
                return zzbsk.zzc(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
