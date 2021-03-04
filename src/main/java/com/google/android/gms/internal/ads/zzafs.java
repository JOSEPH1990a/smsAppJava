package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzafs extends zzew implements zzafr {
    zzafs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final void zza(zzafl zzafl, zzafp zzafp) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzafl);
        zzey.zza(obtainAndWriteInterfaceToken, zzafp);
        zzb(2, obtainAndWriteInterfaceToken);
    }
}
