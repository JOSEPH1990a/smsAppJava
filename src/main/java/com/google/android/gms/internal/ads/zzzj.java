package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzzj extends zzxe {
    final /* synthetic */ zzzh zzcmz;

    private zzzj(zzzh zzzh) {
        this.zzcmz = zzzh;
    }

    @Override // com.google.android.gms.internal.ads.zzxd
    public final String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxd
    public final boolean isLoading() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzxd
    public final String zzje() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxd
    public final void zzd(zzwb zzwb) throws RemoteException {
        zza(zzwb, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzxd
    public final void zza(zzwb zzwb, int i) throws RemoteException {
        zzbbd.e("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzbat.zztu.post(new zzzk(this));
    }
}
