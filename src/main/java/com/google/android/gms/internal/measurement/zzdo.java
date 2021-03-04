package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract class zzdo extends zzr implements zzdn {
    public zzdo() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public static zzdn asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        if (queryLocalInterface instanceof zzdn) {
            return (zzdn) queryLocalInterface;
        }
        return new zzdp(iBinder);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzr
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzds zzds;
        zzdq zzdq = null;
        zzdq zzdq2 = null;
        zzdt zzdt = null;
        zzdt zzdt2 = null;
        zzdt zzdt3 = null;
        zzdq zzdq3 = null;
        zzdq zzdq4 = null;
        zzdq zzdq5 = null;
        zzdq zzdq6 = null;
        zzdq zzdq7 = null;
        zzdq zzdq8 = null;
        zzdw zzdw = null;
        zzdq zzdq9 = null;
        zzdq zzdq10 = null;
        zzdq zzdq11 = null;
        zzdq zzdq12 = null;
        switch (i) {
            case 1:
                initialize(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzdy) zzs.zza(parcel, zzdy.CREATOR), parcel.readLong());
                break;
            case 2:
                logEvent(parcel.readString(), parcel.readString(), (Bundle) zzs.zza(parcel, Bundle.CREATOR), zzs.zza(parcel), zzs.zza(parcel), parcel.readLong());
                break;
            case 3:
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                Bundle bundle = (Bundle) zzs.zza(parcel, Bundle.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzds = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface instanceof zzdq) {
                        zzds = (zzdq) queryLocalInterface;
                    } else {
                        zzds = new zzds(readStrongBinder);
                    }
                }
                logEventAndBundle(readString, readString2, bundle, zzds, parcel.readLong());
                break;
            case 4:
                setUserProperty(parcel.readString(), parcel.readString(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzs.zza(parcel), parcel.readLong());
                break;
            case 5:
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                boolean zza = zzs.zza(parcel);
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface2 instanceof zzdq) {
                        zzdq = (zzdq) queryLocalInterface2;
                    } else {
                        zzdq = new zzds(readStrongBinder2);
                    }
                }
                getUserProperties(readString3, readString4, zza, zzdq);
                break;
            case 6:
                String readString5 = parcel.readString();
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface3 instanceof zzdq) {
                        zzdq12 = (zzdq) queryLocalInterface3;
                    } else {
                        zzdq12 = new zzds(readStrongBinder3);
                    }
                }
                getMaxUserProperties(readString5, zzdq12);
                break;
            case 7:
                setUserId(parcel.readString(), parcel.readLong());
                break;
            case 8:
                setConditionalUserProperty((Bundle) zzs.zza(parcel, Bundle.CREATOR), parcel.readLong());
                break;
            case 9:
                clearConditionalUserProperty(parcel.readString(), parcel.readString(), (Bundle) zzs.zza(parcel, Bundle.CREATOR));
                break;
            case 10:
                String readString6 = parcel.readString();
                String readString7 = parcel.readString();
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface4 instanceof zzdq) {
                        zzdq11 = (zzdq) queryLocalInterface4;
                    } else {
                        zzdq11 = new zzds(readStrongBinder4);
                    }
                }
                getConditionalUserProperties(readString6, readString7, zzdq11);
                break;
            case 11:
                setMeasurementEnabled(zzs.zza(parcel), parcel.readLong());
                break;
            case 12:
                resetAnalyticsData(parcel.readLong());
                break;
            case 13:
                setMinimumSessionDuration(parcel.readLong());
                break;
            case 14:
                setSessionTimeoutDuration(parcel.readLong());
                break;
            case 15:
                setCurrentScreen(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readLong());
                break;
            case 16:
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface5 instanceof zzdq) {
                        zzdq10 = (zzdq) queryLocalInterface5;
                    } else {
                        zzdq10 = new zzds(readStrongBinder5);
                    }
                }
                getCurrentScreenName(zzdq10);
                break;
            case 17:
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 != null) {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface6 instanceof zzdq) {
                        zzdq9 = (zzdq) queryLocalInterface6;
                    } else {
                        zzdq9 = new zzds(readStrongBinder6);
                    }
                }
                getCurrentScreenClass(zzdq9);
                break;
            case 18:
                IBinder readStrongBinder7 = parcel.readStrongBinder();
                if (readStrongBinder7 != null) {
                    IInterface queryLocalInterface7 = readStrongBinder7.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
                    if (queryLocalInterface7 instanceof zzdw) {
                        zzdw = (zzdw) queryLocalInterface7;
                    } else {
                        zzdw = new zzdx(readStrongBinder7);
                    }
                }
                setInstanceIdProvider(zzdw);
                break;
            case 19:
                IBinder readStrongBinder8 = parcel.readStrongBinder();
                if (readStrongBinder8 != null) {
                    IInterface queryLocalInterface8 = readStrongBinder8.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface8 instanceof zzdq) {
                        zzdq8 = (zzdq) queryLocalInterface8;
                    } else {
                        zzdq8 = new zzds(readStrongBinder8);
                    }
                }
                getCachedAppInstanceId(zzdq8);
                break;
            case 20:
                IBinder readStrongBinder9 = parcel.readStrongBinder();
                if (readStrongBinder9 != null) {
                    IInterface queryLocalInterface9 = readStrongBinder9.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface9 instanceof zzdq) {
                        zzdq7 = (zzdq) queryLocalInterface9;
                    } else {
                        zzdq7 = new zzds(readStrongBinder9);
                    }
                }
                getAppInstanceId(zzdq7);
                break;
            case 21:
                IBinder readStrongBinder10 = parcel.readStrongBinder();
                if (readStrongBinder10 != null) {
                    IInterface queryLocalInterface10 = readStrongBinder10.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface10 instanceof zzdq) {
                        zzdq6 = (zzdq) queryLocalInterface10;
                    } else {
                        zzdq6 = new zzds(readStrongBinder10);
                    }
                }
                getGmpAppId(zzdq6);
                break;
            case 22:
                IBinder readStrongBinder11 = parcel.readStrongBinder();
                if (readStrongBinder11 != null) {
                    IInterface queryLocalInterface11 = readStrongBinder11.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface11 instanceof zzdq) {
                        zzdq5 = (zzdq) queryLocalInterface11;
                    } else {
                        zzdq5 = new zzds(readStrongBinder11);
                    }
                }
                generateEventId(zzdq5);
                break;
            case 23:
                beginAdUnitExposure(parcel.readString(), parcel.readLong());
                break;
            case 24:
                endAdUnitExposure(parcel.readString(), parcel.readLong());
                break;
            case 25:
                onActivityStarted(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 26:
                onActivityStopped(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 27:
                onActivityCreated(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (Bundle) zzs.zza(parcel, Bundle.CREATOR), parcel.readLong());
                break;
            case 28:
                onActivityDestroyed(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 29:
                onActivityPaused(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 30:
                onActivityResumed(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 31:
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IBinder readStrongBinder12 = parcel.readStrongBinder();
                if (readStrongBinder12 != null) {
                    IInterface queryLocalInterface12 = readStrongBinder12.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface12 instanceof zzdq) {
                        zzdq4 = (zzdq) queryLocalInterface12;
                    } else {
                        zzdq4 = new zzds(readStrongBinder12);
                    }
                }
                onActivitySaveInstanceState(asInterface, zzdq4, parcel.readLong());
                break;
            case 32:
                Bundle bundle2 = (Bundle) zzs.zza(parcel, Bundle.CREATOR);
                IBinder readStrongBinder13 = parcel.readStrongBinder();
                if (readStrongBinder13 != null) {
                    IInterface queryLocalInterface13 = readStrongBinder13.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface13 instanceof zzdq) {
                        zzdq3 = (zzdq) queryLocalInterface13;
                    } else {
                        zzdq3 = new zzds(readStrongBinder13);
                    }
                }
                performAction(bundle2, zzdq3, parcel.readLong());
                break;
            case 33:
                logHealthData(parcel.readInt(), parcel.readString(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                break;
            case 34:
                IBinder readStrongBinder14 = parcel.readStrongBinder();
                if (readStrongBinder14 != null) {
                    IInterface queryLocalInterface14 = readStrongBinder14.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    if (queryLocalInterface14 instanceof zzdt) {
                        zzdt3 = (zzdt) queryLocalInterface14;
                    } else {
                        zzdt3 = new zzdv(readStrongBinder14);
                    }
                }
                setEventInterceptor(zzdt3);
                break;
            case 35:
                IBinder readStrongBinder15 = parcel.readStrongBinder();
                if (readStrongBinder15 != null) {
                    IInterface queryLocalInterface15 = readStrongBinder15.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    if (queryLocalInterface15 instanceof zzdt) {
                        zzdt2 = (zzdt) queryLocalInterface15;
                    } else {
                        zzdt2 = new zzdv(readStrongBinder15);
                    }
                }
                registerOnMeasurementEventListener(zzdt2);
                break;
            case 36:
                IBinder readStrongBinder16 = parcel.readStrongBinder();
                if (readStrongBinder16 != null) {
                    IInterface queryLocalInterface16 = readStrongBinder16.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    if (queryLocalInterface16 instanceof zzdt) {
                        zzdt = (zzdt) queryLocalInterface16;
                    } else {
                        zzdt = new zzdv(readStrongBinder16);
                    }
                }
                unregisterOnMeasurementEventListener(zzdt);
                break;
            case 37:
                initForTests(zzs.zzb(parcel));
                break;
            case 38:
                IBinder readStrongBinder17 = parcel.readStrongBinder();
                if (readStrongBinder17 != null) {
                    IInterface queryLocalInterface17 = readStrongBinder17.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface17 instanceof zzdq) {
                        zzdq2 = (zzdq) queryLocalInterface17;
                    } else {
                        zzdq2 = new zzds(readStrongBinder17);
                    }
                }
                getTestFlag(zzdq2, parcel.readInt());
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
