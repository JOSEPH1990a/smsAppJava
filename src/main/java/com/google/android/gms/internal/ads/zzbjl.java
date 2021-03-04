package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbjl extends zzew implements zzbjk {
    zzbjl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    @Override // com.google.android.gms.internal.ads.zzbjk
    public final zzbji zza(zzbjg zzbjg) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzbjg);
        Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
        zzbji zzbji = (zzbji) zzey.zza(transactAndReadException, zzbji.CREATOR);
        transactAndReadException.recycle();
        return zzbji;
    }
}
