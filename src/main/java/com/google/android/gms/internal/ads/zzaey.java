package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

public final class zzaey extends zzew implements zzaew {
    zzaey(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final String getHeadline() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken());
        String readString = transactAndReadException.readString();
        transactAndReadException.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final List getImages() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(3, obtainAndWriteInterfaceToken());
        ArrayList zzb = zzey.zzb(transactAndReadException);
        transactAndReadException.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final String getBody() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(4, obtainAndWriteInterfaceToken());
        String readString = transactAndReadException.readString();
        transactAndReadException.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final zzadb zzsb() throws RemoteException {
        zzadb zzadb;
        Parcel transactAndReadException = transactAndReadException(5, obtainAndWriteInterfaceToken());
        IBinder readStrongBinder = transactAndReadException.readStrongBinder();
        if (readStrongBinder == null) {
            zzadb = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            if (queryLocalInterface instanceof zzadb) {
                zzadb = (zzadb) queryLocalInterface;
            } else {
                zzadb = new zzadd(readStrongBinder);
            }
        }
        transactAndReadException.recycle();
        return zzadb;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final String getCallToAction() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(6, obtainAndWriteInterfaceToken());
        String readString = transactAndReadException.readString();
        transactAndReadException.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final String getAdvertiser() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(7, obtainAndWriteInterfaceToken());
        String readString = transactAndReadException.readString();
        transactAndReadException.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final double getStarRating() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(8, obtainAndWriteInterfaceToken());
        double readDouble = transactAndReadException.readDouble();
        transactAndReadException.recycle();
        return readDouble;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final String getStore() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(9, obtainAndWriteInterfaceToken());
        String readString = transactAndReadException.readString();
        transactAndReadException.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final String getPrice() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(10, obtainAndWriteInterfaceToken());
        String readString = transactAndReadException.readString();
        transactAndReadException.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final zzyp getVideoController() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(11, obtainAndWriteInterfaceToken());
        zzyp zzg = zzyq.zzg(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(12, obtainAndWriteInterfaceToken());
        String readString = transactAndReadException.readString();
        transactAndReadException.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void destroy() throws RemoteException {
        zza(13, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final zzacx zzse() throws RemoteException {
        zzacx zzacx;
        Parcel transactAndReadException = transactAndReadException(14, obtainAndWriteInterfaceToken());
        IBinder readStrongBinder = transactAndReadException.readStrongBinder();
        if (readStrongBinder == null) {
            zzacx = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
            if (queryLocalInterface instanceof zzacx) {
                zzacx = (zzacx) queryLocalInterface;
            } else {
                zzacx = new zzacz(readStrongBinder);
            }
        }
        transactAndReadException.recycle();
        return zzacx;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void performClick(Bundle bundle) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, bundle);
        zza(15, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final boolean recordImpression(Bundle bundle) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, bundle);
        Parcel transactAndReadException = transactAndReadException(16, obtainAndWriteInterfaceToken);
        boolean zza = zzey.zza(transactAndReadException);
        transactAndReadException.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void reportTouchEvent(Bundle bundle) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, bundle);
        zza(17, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final IObjectWrapper zzsc() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(18, obtainAndWriteInterfaceToken());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final IObjectWrapper zzsd() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(19, obtainAndWriteInterfaceToken());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final Bundle getExtras() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(20, obtainAndWriteInterfaceToken());
        Bundle bundle = (Bundle) zzey.zza(transactAndReadException, Bundle.CREATOR);
        transactAndReadException.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void zza(zzaet zzaet) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzaet);
        zza(21, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void cancelUnconfirmedClick() throws RemoteException {
        zza(22, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final List getMuteThisAdReasons() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(23, obtainAndWriteInterfaceToken());
        ArrayList zzb = zzey.zzb(transactAndReadException);
        transactAndReadException.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final boolean isCustomMuteThisAdEnabled() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(24, obtainAndWriteInterfaceToken());
        boolean zza = zzey.zza(transactAndReadException);
        transactAndReadException.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void zza(zzyl zzyl) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzyl);
        zza(25, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void zza(zzyh zzyh) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzyh);
        zza(26, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void zzsi() throws RemoteException {
        zza(27, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void recordCustomClickGesture() throws RemoteException {
        zza(28, obtainAndWriteInterfaceToken());
    }
}
