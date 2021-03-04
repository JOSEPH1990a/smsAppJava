package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzagx implements zzahi {
    zzagx(zzagw zzagw) {
    }

    @Override // com.google.android.gms.internal.ads.zzahi
    public final void zzb(zzahj zzahj) throws RemoteException {
        if (zzahj.zzdha != null) {
            zzahj.zzdha.onAdClicked();
        }
    }
}
