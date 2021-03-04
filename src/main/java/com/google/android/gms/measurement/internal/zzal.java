package com.google.android.gms.measurement.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzq;
import com.google.android.gms.internal.measurement.zzs;
import java.util.ArrayList;
import java.util.List;

public final class zzal extends zzq implements zzaj {
    zzal(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    public final void zza(zzag zzag, zzk zzk) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, zzag);
        zzs.zza(obtainAndWriteInterfaceToken, zzk);
        zza(1, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    public final void zza(zzfv zzfv, zzk zzk) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, zzfv);
        zzs.zza(obtainAndWriteInterfaceToken, zzk);
        zza(2, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    public final void zza(zzk zzk) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, zzk);
        zza(4, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    public final void zza(zzag zzag, String str, String str2) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, zzag);
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zza(5, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    public final void zzb(zzk zzk) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, zzk);
        zza(6, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    public final List<zzfv> zza(zzk zzk, boolean z) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, zzk);
        zzs.writeBoolean(obtainAndWriteInterfaceToken, z);
        Parcel transactAndReadException = transactAndReadException(7, obtainAndWriteInterfaceToken);
        ArrayList createTypedArrayList = transactAndReadException.createTypedArrayList(zzfv.CREATOR);
        transactAndReadException.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    public final byte[] zza(zzag zzag, String str) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, zzag);
        obtainAndWriteInterfaceToken.writeString(str);
        Parcel transactAndReadException = transactAndReadException(9, obtainAndWriteInterfaceToken);
        byte[] createByteArray = transactAndReadException.createByteArray();
        transactAndReadException.recycle();
        return createByteArray;
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    public final void zza(long j, String str, String str2, String str3) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeLong(j);
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        obtainAndWriteInterfaceToken.writeString(str3);
        zza(10, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    public final String zzc(zzk zzk) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, zzk);
        Parcel transactAndReadException = transactAndReadException(11, obtainAndWriteInterfaceToken);
        String readString = transactAndReadException.readString();
        transactAndReadException.recycle();
        return readString;
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    public final void zza(zzo zzo, zzk zzk) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, zzo);
        zzs.zza(obtainAndWriteInterfaceToken, zzk);
        zza(12, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    public final void zzb(zzo zzo) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, zzo);
        zza(13, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    public final List<zzfv> zza(String str, String str2, boolean z, zzk zzk) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzs.writeBoolean(obtainAndWriteInterfaceToken, z);
        zzs.zza(obtainAndWriteInterfaceToken, zzk);
        Parcel transactAndReadException = transactAndReadException(14, obtainAndWriteInterfaceToken);
        ArrayList createTypedArrayList = transactAndReadException.createTypedArrayList(zzfv.CREATOR);
        transactAndReadException.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    public final List<zzfv> zza(String str, String str2, String str3, boolean z) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        obtainAndWriteInterfaceToken.writeString(str3);
        zzs.writeBoolean(obtainAndWriteInterfaceToken, z);
        Parcel transactAndReadException = transactAndReadException(15, obtainAndWriteInterfaceToken);
        ArrayList createTypedArrayList = transactAndReadException.createTypedArrayList(zzfv.CREATOR);
        transactAndReadException.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    public final List<zzo> zza(String str, String str2, zzk zzk) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzs.zza(obtainAndWriteInterfaceToken, zzk);
        Parcel transactAndReadException = transactAndReadException(16, obtainAndWriteInterfaceToken);
        ArrayList createTypedArrayList = transactAndReadException.createTypedArrayList(zzo.CREATOR);
        transactAndReadException.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    public final List<zzo> zze(String str, String str2, String str3) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        obtainAndWriteInterfaceToken.writeString(str3);
        Parcel transactAndReadException = transactAndReadException(17, obtainAndWriteInterfaceToken);
        ArrayList createTypedArrayList = transactAndReadException.createTypedArrayList(zzo.CREATOR);
        transactAndReadException.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    public final void zzd(zzk zzk) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, zzk);
        zza(18, obtainAndWriteInterfaceToken);
    }
}
