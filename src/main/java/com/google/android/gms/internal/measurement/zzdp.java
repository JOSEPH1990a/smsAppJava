package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

public final class zzdp extends zzq implements zzdn {
    zzdp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    @Override // com.google.android.gms.internal.measurement.zzdn
    public final void initialize(IObjectWrapper iObjectWrapper, zzdy zzdy, long j) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzs.zza(obtainAndWriteInterfaceToken, zzdy);
        obtainAndWriteInterfaceToken.writeLong(j);
        zza(1, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn
    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzs.zza(obtainAndWriteInterfaceToken, bundle);
        zzs.writeBoolean(obtainAndWriteInterfaceToken, z);
        zzs.writeBoolean(obtainAndWriteInterfaceToken, z2);
        obtainAndWriteInterfaceToken.writeLong(j);
        zza(2, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn
    public final void logEventAndBundle(String str, String str2, Bundle bundle, zzdq zzdq, long j) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzs.zza(obtainAndWriteInterfaceToken, bundle);
        zzs.zza(obtainAndWriteInterfaceToken, zzdq);
        obtainAndWriteInterfaceToken.writeLong(j);
        zza(3, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn
    public final void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzs.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzs.writeBoolean(obtainAndWriteInterfaceToken, z);
        obtainAndWriteInterfaceToken.writeLong(j);
        zza(4, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn
    public final void getUserProperties(String str, String str2, boolean z, zzdq zzdq) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzs.writeBoolean(obtainAndWriteInterfaceToken, z);
        zzs.zza(obtainAndWriteInterfaceToken, zzdq);
        zza(5, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn
    public final void getMaxUserProperties(String str, zzdq zzdq) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        zzs.zza(obtainAndWriteInterfaceToken, zzdq);
        zza(6, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn
    public final void setUserId(String str, long j) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeLong(j);
        zza(7, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn
    public final void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, bundle);
        obtainAndWriteInterfaceToken.writeLong(j);
        zza(8, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzs.zza(obtainAndWriteInterfaceToken, bundle);
        zza(9, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn
    public final void getConditionalUserProperties(String str, String str2, zzdq zzdq) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzs.zza(obtainAndWriteInterfaceToken, zzdq);
        zza(10, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn
    public final void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.writeBoolean(obtainAndWriteInterfaceToken, z);
        obtainAndWriteInterfaceToken.writeLong(j);
        zza(11, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn
    public final void resetAnalyticsData(long j) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeLong(j);
        zza(12, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn
    public final void setMinimumSessionDuration(long j) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeLong(j);
        zza(13, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn
    public final void setSessionTimeoutDuration(long j) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeLong(j);
        zza(14, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn
    public final void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        obtainAndWriteInterfaceToken.writeLong(j);
        zza(15, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn
    public final void getCurrentScreenName(zzdq zzdq) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, zzdq);
        zza(16, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn
    public final void getCurrentScreenClass(zzdq zzdq) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, zzdq);
        zza(17, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn
    public final void setInstanceIdProvider(zzdw zzdw) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, zzdw);
        zza(18, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn
    public final void getCachedAppInstanceId(zzdq zzdq) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, zzdq);
        zza(19, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn
    public final void getAppInstanceId(zzdq zzdq) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, zzdq);
        zza(20, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn
    public final void getGmpAppId(zzdq zzdq) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, zzdq);
        zza(21, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn
    public final void generateEventId(zzdq zzdq) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, zzdq);
        zza(22, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn
    public final void beginAdUnitExposure(String str, long j) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeLong(j);
        zza(23, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn
    public final void endAdUnitExposure(String str, long j) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeLong(j);
        zza(24, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn
    public final void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        obtainAndWriteInterfaceToken.writeLong(j);
        zza(25, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn
    public final void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        obtainAndWriteInterfaceToken.writeLong(j);
        zza(26, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn
    public final void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzs.zza(obtainAndWriteInterfaceToken, bundle);
        obtainAndWriteInterfaceToken.writeLong(j);
        zza(27, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn
    public final void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        obtainAndWriteInterfaceToken.writeLong(j);
        zza(28, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn
    public final void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        obtainAndWriteInterfaceToken.writeLong(j);
        zza(29, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn
    public final void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        obtainAndWriteInterfaceToken.writeLong(j);
        zza(30, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn
    public final void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzdq zzdq, long j) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzs.zza(obtainAndWriteInterfaceToken, zzdq);
        obtainAndWriteInterfaceToken.writeLong(j);
        zza(31, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn
    public final void performAction(Bundle bundle, zzdq zzdq, long j) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, bundle);
        zzs.zza(obtainAndWriteInterfaceToken, zzdq);
        obtainAndWriteInterfaceToken.writeLong(j);
        zza(32, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn
    public final void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeInt(i);
        obtainAndWriteInterfaceToken.writeString(str);
        zzs.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzs.zza(obtainAndWriteInterfaceToken, iObjectWrapper2);
        zzs.zza(obtainAndWriteInterfaceToken, iObjectWrapper3);
        zza(33, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn
    public final void setEventInterceptor(zzdt zzdt) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, zzdt);
        zza(34, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn
    public final void registerOnMeasurementEventListener(zzdt zzdt) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, zzdt);
        zza(35, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn
    public final void unregisterOnMeasurementEventListener(zzdt zzdt) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, zzdt);
        zza(36, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn
    public final void initForTests(Map map) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeMap(map);
        zza(37, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.measurement.zzdn
    public final void getTestFlag(zzdq zzdq, int i) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzs.zza(obtainAndWriteInterfaceToken, zzdq);
        obtainAndWriteInterfaceToken.writeInt(i);
        zza(38, obtainAndWriteInterfaceToken);
    }
}
