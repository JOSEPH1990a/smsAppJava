package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzauv extends zzew implements zzauu {
    zzauv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener");
    }

    @Override // com.google.android.gms.internal.ads.zzauu
    public final void zza(zzaur zzaur, String str) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzaur);
        obtainAndWriteInterfaceToken.writeString(str);
        zza(1, obtainAndWriteInterfaceToken);
    }
}
