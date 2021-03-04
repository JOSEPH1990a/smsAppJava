package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

@zzark
public final class zzasl extends zzasu {
    private final WeakReference<zzasa> zzdya;

    public zzasl(zzasa zzasa) {
        this.zzdya = new WeakReference<>(zzasa);
    }

    @Override // com.google.android.gms.internal.ads.zzast
    public final void zza(zzasm zzasm) {
        zzasa zzasa = this.zzdya.get();
        if (zzasa != null) {
            zzasa.zza(zzasm);
        }
    }
}
