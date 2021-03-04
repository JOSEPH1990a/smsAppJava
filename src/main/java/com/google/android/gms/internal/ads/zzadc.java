package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract class zzadc extends zzex implements zzadb {
    public zzadc() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    public static zzadb zzj(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
        if (queryLocalInterface instanceof zzadb) {
            return (zzadb) queryLocalInterface;
        }
        return new zzadd(iBinder);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzex
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                IObjectWrapper zzsa = zzsa();
                parcel2.writeNoException();
                zzey.zza(parcel2, zzsa);
                return true;
            case 2:
                Uri uri = getUri();
                parcel2.writeNoException();
                zzey.zzb(parcel2, uri);
                return true;
            case 3:
                double scale = getScale();
                parcel2.writeNoException();
                parcel2.writeDouble(scale);
                return true;
            default:
                return false;
        }
    }
}
