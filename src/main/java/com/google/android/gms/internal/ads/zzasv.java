package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzasv extends zzew implements zzast {
    zzasv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdResponseListener");
    }

    @Override // com.google.android.gms.internal.ads.zzast
    public final void zza(zzasm zzasm) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzasm);
        zza(1, obtainAndWriteInterfaceToken);
    }
}
