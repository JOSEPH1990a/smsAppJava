package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzaep extends zzew implements zzaen {
    zzaep(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnPublisherAdViewLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzaen
    public final void zza(zzxl zzxl, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzxl);
        zzey.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zza(1, obtainAndWriteInterfaceToken);
    }
}
