package com.google.android.gms.internal.ads;

@zzark
public final class zzbft extends zzbfk {
    public zzbft(zzbdz zzbdz) {
        super(zzbdz);
    }

    @Override // com.google.android.gms.internal.ads.zzbfk
    public final void abort() {
    }

    @Override // com.google.android.gms.internal.ads.zzbfk
    public final boolean zzex(String str) {
        zzbdz zzbdz = (zzbdz) this.zzewo.get();
        if (zzbdz != null) {
            zzbdz.zza(zzey(str), this);
        }
        zzaxz.zzeo("VideoStreamNoopCache is doing nothing.");
        zza(str, zzey(str), "noop", "Noop cache is a noop.");
        return false;
    }
}
