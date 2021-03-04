package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzbv;

@zzark
public final class zzbfh extends zzaxv {
    final zzbdz zzerw;
    final zzbfk zzewk;
    private final String zzewl;

    zzbfh(zzbdz zzbdz, zzbfk zzbfk, String str) {
        this.zzerw = zzbdz;
        this.zzewk = zzbfk;
        this.zzewl = str;
        zzbv.zzmd().zza(this);
    }

    @Override // com.google.android.gms.internal.ads.zzaxv
    public final void zzki() {
        try {
            this.zzewk.zzex(this.zzewl);
        } finally {
            zzayh.zzelc.post(new zzbfi(this));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxv
    public final void onStop() {
        this.zzewk.abort();
    }
}
