package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzagr implements zzahi {
    zzagr(zzagk zzagk) {
    }

    @Override // com.google.android.gms.internal.ads.zzahi
    public final void zzb(zzahj zzahj) throws RemoteException {
        if (zzahj.zzbnn != null) {
            zzahj.zzbnn.onAdClicked();
        }
    }
}
