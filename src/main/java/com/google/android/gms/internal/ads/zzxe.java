package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzxe extends zzex implements zzxd {
    public zzxe() {
        super("com.google.android.gms.ads.internal.client.IAdLoader");
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzex
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzd((zzwb) zzey.zza(parcel, zzwb.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                String mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                return true;
            case 3:
                boolean isLoading = isLoading();
                parcel2.writeNoException();
                zzey.writeBoolean(parcel2, isLoading);
                return true;
            case 4:
                String zzje = zzje();
                parcel2.writeNoException();
                parcel2.writeString(zzje);
                return true;
            case 5:
                zza((zzwb) zzey.zza(parcel, zzwb.CREATOR), parcel.readInt());
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
