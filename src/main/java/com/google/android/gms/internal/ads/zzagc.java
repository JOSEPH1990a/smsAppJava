package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract class zzagc extends zzex implements zzagb {
    public zzagc() {
        super("com.google.android.gms.ads.internal.instream.client.IInstreamAd");
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzex
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzagd zzagd;
        switch (i) {
            case 3:
                zzyp videoController = getVideoController();
                parcel2.writeNoException();
                zzey.zza(parcel2, videoController);
                return true;
            case 4:
                destroy();
                parcel2.writeNoException();
                return true;
            case 5:
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzagd = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
                    if (queryLocalInterface instanceof zzagd) {
                        zzagd = (zzagd) queryLocalInterface;
                    } else {
                        zzagd = new zzage(readStrongBinder);
                    }
                }
                zza(asInterface, zzagd);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
