package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;

public final class zzxi extends zzew implements zzxg {
    zzxi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final zzxd zzkd() throws RemoteException {
        zzxd zzxd;
        Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken());
        IBinder readStrongBinder = transactAndReadException.readStrongBinder();
        if (readStrongBinder == null) {
            zzxd = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoader");
            if (queryLocalInterface instanceof zzxd) {
                zzxd = (zzxd) queryLocalInterface;
            } else {
                zzxd = new zzxf(readStrongBinder);
            }
        }
        transactAndReadException.recycle();
        return zzxd;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void zzb(zzxa zzxa) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzxa);
        zza(2, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void zza(zzaeb zzaeb) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzaeb);
        zza(3, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void zza(zzaee zzaee) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzaee);
        zza(4, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void zza(String str, zzaek zzaek, zzaeh zzaeh) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        zzey.zza(obtainAndWriteInterfaceToken, zzaek);
        zzey.zza(obtainAndWriteInterfaceToken, zzaeh);
        zza(5, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void zza(zzacp zzacp) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzacp);
        zza(6, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void zzb(zzxz zzxz) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzxz);
        zza(7, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void zza(zzaen zzaen, zzwf zzwf) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzaen);
        zzey.zza(obtainAndWriteInterfaceToken, zzwf);
        zza(8, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void zza(PublisherAdViewOptions publisherAdViewOptions) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, publisherAdViewOptions);
        zza(9, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void zza(zzaeq zzaeq) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzaeq);
        zza(10, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void zza(zzafz zzafz) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzafz);
        zza(13, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void zza(zzagf zzagf) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzagf);
        zza(14, obtainAndWriteInterfaceToken);
    }
}
