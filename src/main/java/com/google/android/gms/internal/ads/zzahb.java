package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzahb implements zzahi {
    zzahb(zzagy zzagy) {
    }

    @Override // com.google.android.gms.internal.ads.zzahi
    public final void zzb(zzahj zzahj) throws RemoteException {
        if (zzahj.zzdhb != null) {
            zzahj.zzdhb.onRewardedVideoStarted();
        }
    }
}
