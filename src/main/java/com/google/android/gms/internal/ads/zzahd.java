package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzahd implements zzahi {
    private final /* synthetic */ zzaur zzdgu;

    zzahd(zzagy zzagy, zzaur zzaur) {
        this.zzdgu = zzaur;
    }

    @Override // com.google.android.gms.internal.ads.zzahi
    public final void zzb(zzahj zzahj) throws RemoteException {
        if (zzahj.zzdhb != null) {
            zzahj.zzdhb.zza(this.zzdgu);
        }
    }
}
