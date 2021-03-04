package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzass extends zzew implements zzasq {
    zzass(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.zzasq
    public final zzasm zzb(zzasi zzasi) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzasi);
        Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
        zzasm zzasm = (zzasm) zzey.zza(transactAndReadException, zzasm.CREATOR);
        transactAndReadException.recycle();
        return zzasm;
    }

    @Override // com.google.android.gms.internal.ads.zzasq
    public final void zza(zzasi zzasi, zzast zzast) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzasi);
        zzey.zza(obtainAndWriteInterfaceToken, zzast);
        zza(2, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzasq
    public final void zza(zzatb zzatb, zzasw zzasw) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzatb);
        zzey.zza(obtainAndWriteInterfaceToken, zzasw);
        zza(4, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzasq
    public final void zzb(zzatb zzatb, zzasw zzasw) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzatb);
        zzey.zza(obtainAndWriteInterfaceToken, zzasw);
        zza(5, obtainAndWriteInterfaceToken);
    }
}
