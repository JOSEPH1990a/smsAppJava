package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzaej extends zzew implements zzaeh {
    zzaej(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
    }

    @Override // com.google.android.gms.internal.ads.zzaeh
    public final void zzb(zzadx zzadx, String str) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzadx);
        obtainAndWriteInterfaceToken.writeString(str);
        zza(1, obtainAndWriteInterfaceToken);
    }
}
