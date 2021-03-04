package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzasr extends zzex implements zzasq {
    public zzasr() {
        super("com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzex
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzast zzast = null;
        zzasw zzasw = null;
        zzasw zzasw2 = null;
        switch (i) {
            case 1:
                zzasm zzb = zzb((zzasi) zzey.zza(parcel, zzasi.CREATOR));
                parcel2.writeNoException();
                zzey.zzb(parcel2, zzb);
                return true;
            case 2:
                zzasi zzasi = (zzasi) zzey.zza(parcel, zzasi.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
                    if (queryLocalInterface instanceof zzast) {
                        zzast = (zzast) queryLocalInterface;
                    } else {
                        zzast = new zzasv(readStrongBinder);
                    }
                }
                zza(zzasi, zzast);
                parcel2.writeNoException();
                return true;
            case 3:
            default:
                return false;
            case 4:
                zzatb zzatb = (zzatb) zzey.zza(parcel, zzatb.CREATOR);
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    if (queryLocalInterface2 instanceof zzasw) {
                        zzasw2 = (zzasw) queryLocalInterface2;
                    } else {
                        zzasw2 = new zzasx(readStrongBinder2);
                    }
                }
                zza(zzatb, zzasw2);
                parcel2.writeNoException();
                return true;
            case 5:
                zzatb zzatb2 = (zzatb) zzey.zza(parcel, zzatb.CREATOR);
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    if (queryLocalInterface3 instanceof zzasw) {
                        zzasw = (zzasw) queryLocalInterface3;
                    } else {
                        zzasw = new zzasx(readStrongBinder3);
                    }
                }
                zzb(zzatb2, zzasw);
                parcel2.writeNoException();
                return true;
        }
    }
}
