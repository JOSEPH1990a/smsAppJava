package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract class zzaux extends zzex implements zzauw {
    public zzaux() {
        super("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    public static zzauw zzab(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
        if (queryLocalInterface instanceof zzauw) {
            return (zzauw) queryLocalInterface;
        }
        return new zzauy(iBinder);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzex
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 34) {
            zzavb zzavb = null;
            zzauu zzauu = null;
            switch (i) {
                case 1:
                    zza((zzavh) zzey.zza(parcel, zzavh.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    show();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    IBinder readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder != null) {
                        IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
                        if (queryLocalInterface instanceof zzavb) {
                            zzavb = (zzavb) queryLocalInterface;
                        } else {
                            zzavb = new zzavd(readStrongBinder);
                        }
                    }
                    zza(zzavb);
                    parcel2.writeNoException();
                    return true;
                default:
                    switch (i) {
                        case 5:
                            boolean isLoaded = isLoaded();
                            parcel2.writeNoException();
                            zzey.writeBoolean(parcel2, isLoaded);
                            return true;
                        case 6:
                            pause();
                            parcel2.writeNoException();
                            return true;
                        case 7:
                            resume();
                            parcel2.writeNoException();
                            return true;
                        case 8:
                            destroy();
                            parcel2.writeNoException();
                            return true;
                        case 9:
                            zze(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            return true;
                        case 10:
                            zzf(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            return true;
                        case 11:
                            zzg(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            return true;
                        case 12:
                            String mediationAdapterClassName = getMediationAdapterClassName();
                            parcel2.writeNoException();
                            parcel2.writeString(mediationAdapterClassName);
                            return true;
                        case 13:
                            setUserId(parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        case 14:
                            zza(zzxr.zzc(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            return true;
                        case 15:
                            Bundle adMetadata = getAdMetadata();
                            parcel2.writeNoException();
                            zzey.zzb(parcel2, adMetadata);
                            return true;
                        case 16:
                            IBinder readStrongBinder2 = parcel.readStrongBinder();
                            if (readStrongBinder2 != null) {
                                IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener");
                                if (queryLocalInterface2 instanceof zzauu) {
                                    zzauu = (zzauu) queryLocalInterface2;
                                } else {
                                    zzauu = new zzauv(readStrongBinder2);
                                }
                            }
                            zza(zzauu);
                            parcel2.writeNoException();
                            return true;
                        case 17:
                            setAppPackageName(parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        case 18:
                            zzd(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            return true;
                        case 19:
                            setCustomData(parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        default:
                            return false;
                    }
            }
        } else {
            setImmersiveMode(zzey.zza(parcel));
            parcel2.writeNoException();
            return true;
        }
    }
}
