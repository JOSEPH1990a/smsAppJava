package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzxn extends zzew implements zzxl {
    zzxn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManager");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final IObjectWrapper zzie() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void destroy() throws RemoteException {
        zza(2, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final boolean isReady() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(3, obtainAndWriteInterfaceToken());
        boolean zza = zzey.zza(transactAndReadException);
        transactAndReadException.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final boolean zzb(zzwb zzwb) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzwb);
        Parcel transactAndReadException = transactAndReadException(4, obtainAndWriteInterfaceToken);
        boolean zza = zzey.zza(transactAndReadException);
        transactAndReadException.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void pause() throws RemoteException {
        zza(5, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void resume() throws RemoteException {
        zza(6, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzxa zzxa) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzxa);
        zza(7, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzxt zzxt) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzxt);
        zza(8, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void showInterstitial() throws RemoteException {
        zza(9, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void stopLoading() throws RemoteException {
        zza(10, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zzih() throws RemoteException {
        zza(11, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final zzwf zzif() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(12, obtainAndWriteInterfaceToken());
        zzwf zzwf = (zzwf) zzey.zza(transactAndReadException, zzwf.CREATOR);
        transactAndReadException.recycle();
        return zzwf;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzwf zzwf) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzwf);
        zza(13, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzaow zzaow) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzaow);
        zza(14, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzapc zzapc, String str) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzapc);
        obtainAndWriteInterfaceToken.writeString(str);
        zza(15, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(18, obtainAndWriteInterfaceToken());
        String readString = transactAndReadException.readString();
        transactAndReadException.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzabg zzabg) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzabg);
        zza(19, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzwx zzwx) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzwx);
        zza(20, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzxz zzxz) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzxz);
        zza(21, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void setManualImpressionsEnabled(boolean z) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.writeBoolean(obtainAndWriteInterfaceToken, z);
        zza(22, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final boolean isLoading() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(23, obtainAndWriteInterfaceToken());
        boolean zza = zzey.zza(transactAndReadException);
        transactAndReadException.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzavb zzavb) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzavb);
        zza(24, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void setUserId(String str) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        zza(25, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final zzyp getVideoController() throws RemoteException {
        zzyp zzyp;
        Parcel transactAndReadException = transactAndReadException(26, obtainAndWriteInterfaceToken());
        IBinder readStrongBinder = transactAndReadException.readStrongBinder();
        if (readStrongBinder == null) {
            zzyp = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
            if (queryLocalInterface instanceof zzyp) {
                zzyp = (zzyp) queryLocalInterface;
            } else {
                zzyp = new zzyr(readStrongBinder);
            }
        }
        transactAndReadException.recycle();
        return zzyp;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzzw zzzw) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzzw);
        zza(29, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzyv zzyv) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzyv);
        zza(30, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final String getAdUnitId() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(31, obtainAndWriteInterfaceToken());
        String readString = transactAndReadException.readString();
        transactAndReadException.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final zzxt zzir() throws RemoteException {
        zzxt zzxt;
        Parcel transactAndReadException = transactAndReadException(32, obtainAndWriteInterfaceToken());
        IBinder readStrongBinder = transactAndReadException.readStrongBinder();
        if (readStrongBinder == null) {
            zzxt = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
            if (queryLocalInterface instanceof zzxt) {
                zzxt = (zzxt) queryLocalInterface;
            } else {
                zzxt = new zzxv(readStrongBinder);
            }
        }
        transactAndReadException.recycle();
        return zzxt;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final zzxa zzis() throws RemoteException {
        zzxa zzxa;
        Parcel transactAndReadException = transactAndReadException(33, obtainAndWriteInterfaceToken());
        IBinder readStrongBinder = transactAndReadException.readStrongBinder();
        if (readStrongBinder == null) {
            zzxa = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
            if (queryLocalInterface instanceof zzxa) {
                zzxa = (zzxa) queryLocalInterface;
            } else {
                zzxa = new zzxc(readStrongBinder);
            }
        }
        transactAndReadException.recycle();
        return zzxa;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void setImmersiveMode(boolean z) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.writeBoolean(obtainAndWriteInterfaceToken, z);
        zza(34, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final String zzje() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(35, obtainAndWriteInterfaceToken());
        String readString = transactAndReadException.readString();
        transactAndReadException.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzxq zzxq) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, zzxq);
        zza(36, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final Bundle getAdMetadata() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(37, obtainAndWriteInterfaceToken());
        Bundle bundle = (Bundle) zzey.zza(transactAndReadException, Bundle.CREATOR);
        transactAndReadException.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zzap(String str) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        zza(38, obtainAndWriteInterfaceToken);
    }
}
