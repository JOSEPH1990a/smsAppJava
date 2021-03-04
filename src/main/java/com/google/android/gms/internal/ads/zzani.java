package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzani extends zzew implements zzang {
    zzani(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzwf zzwf, zzanj zzanj) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        obtainAndWriteInterfaceToken.writeString(str);
        zzey.zza(obtainAndWriteInterfaceToken, bundle);
        zzey.zza(obtainAndWriteInterfaceToken, bundle2);
        zzey.zza(obtainAndWriteInterfaceToken, zzwf);
        zzey.zza(obtainAndWriteInterfaceToken, zzanj);
        zza(1, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzans zzvi() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken());
        zzans zzans = (zzans) zzey.zza(transactAndReadException, zzans.CREATOR);
        transactAndReadException.recycle();
        return zzans;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzans zzvj() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(3, obtainAndWriteInterfaceToken());
        zzans zzans = (zzans) zzey.zza(transactAndReadException, zzans.CREATOR);
        transactAndReadException.recycle();
        return zzans;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(String str, String str2, Bundle bundle, IObjectWrapper iObjectWrapper, zzamy zzamy, zzalm zzalm, zzwf zzwf) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzey.zza(obtainAndWriteInterfaceToken, bundle);
        zzey.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzey.zza(obtainAndWriteInterfaceToken, zzamy);
        zzey.zza(obtainAndWriteInterfaceToken, zzalm);
        zzey.zza(obtainAndWriteInterfaceToken, zzwf);
        zza(4, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzyp getVideoController() throws RemoteException {
        Parcel transactAndReadException = transactAndReadException(5, obtainAndWriteInterfaceToken());
        zzyp zzg = zzyq.zzg(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(String str, String str2, Bundle bundle, IObjectWrapper iObjectWrapper, zzana zzana, zzalm zzalm) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzey.zza(obtainAndWriteInterfaceToken, bundle);
        zzey.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzey.zza(obtainAndWriteInterfaceToken, zzana);
        zzey.zza(obtainAndWriteInterfaceToken, zzalm);
        zza(6, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void showInterstitial() throws RemoteException {
        zza(7, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(String str, String str2, Bundle bundle, IObjectWrapper iObjectWrapper, zzane zzane, zzalm zzalm) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzey.zza(obtainAndWriteInterfaceToken, bundle);
        zzey.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzey.zza(obtainAndWriteInterfaceToken, zzane);
        zzey.zza(obtainAndWriteInterfaceToken, zzalm);
        zza(8, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zzvk() throws RemoteException {
        zza(9, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zzn(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzey.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zza(10, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(String[] strArr, Bundle[] bundleArr) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeStringArray(strArr);
        obtainAndWriteInterfaceToken.writeTypedArray(bundleArr, 0);
        zza(11, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(String str, String str2, Bundle bundle, IObjectWrapper iObjectWrapper, zzanc zzanc, zzalm zzalm) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzey.zza(obtainAndWriteInterfaceToken, bundle);
        zzey.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzey.zza(obtainAndWriteInterfaceToken, zzanc);
        zzey.zza(obtainAndWriteInterfaceToken, zzalm);
        zza(12, obtainAndWriteInterfaceToken);
    }
}
