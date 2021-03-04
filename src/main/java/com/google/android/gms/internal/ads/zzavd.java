package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzavd extends zzew implements zzavb {
    zzavd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void onRewardedVideoAdLoaded() throws RemoteException {
        zza(1, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void onRewardedVideoAdOpened() throws RemoteException {
        zza(2, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void onRewardedVideoStarted() throws RemoteException {
        zza(3, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void onRewardedVideoAdClosed() throws RemoteException {
        zza(4, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void zza(zzaur zzaur) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzaur);
        zza(5, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void onRewardedVideoAdLeftApplication() throws RemoteException {
        zza(6, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void onRewardedVideoAdFailedToLoad(int i) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeInt(i);
        zza(7, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void onRewardedVideoCompleted() throws RemoteException {
        zza(8, obtainAndWriteInterfaceToken());
    }
}
