package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzuc extends zzew implements zzub {
    zzuc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.cache.ICacheService");
    }

    @Override // com.google.android.gms.internal.ads.zzub
    public final zztv zza(zzty zzty) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzty);
        Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
        zztv zztv = (zztv) zzey.zza(transactAndReadException, zztv.CREATOR);
        transactAndReadException.recycle();
        return zztv;
    }
}
