package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzagz implements zzahi {
    zzagz(zzagy zzagy) {
    }

    @Override // com.google.android.gms.internal.ads.zzahi
    public final void zzb(zzahj zzahj) throws RemoteException {
        if (zzahj.zzdhb != null) {
            zzahj.zzdhb.onRewardedVideoAdLoaded();
        }
    }
}
