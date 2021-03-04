package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzr;
import com.google.android.gms.internal.measurement.zzs;
import java.util.List;

public abstract class zzak extends zzr implements zzaj {
    public zzak() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzr
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zza((zzag) zzs.zza(parcel, zzag.CREATOR), (zzk) zzs.zza(parcel, zzk.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                zza((zzfv) zzs.zza(parcel, zzfv.CREATOR), (zzk) zzs.zza(parcel, zzk.CREATOR));
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            default:
                return false;
            case 4:
                zza((zzk) zzs.zza(parcel, zzk.CREATOR));
                parcel2.writeNoException();
                return true;
            case 5:
                zza((zzag) zzs.zza(parcel, zzag.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                zzb((zzk) zzs.zza(parcel, zzk.CREATOR));
                parcel2.writeNoException();
                return true;
            case 7:
                List<zzfv> zza = zza((zzk) zzs.zza(parcel, zzk.CREATOR), zzs.zza(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza);
                return true;
            case 9:
                byte[] zza2 = zza((zzag) zzs.zza(parcel, zzag.CREATOR), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeByteArray(zza2);
                return true;
            case 10:
                zza(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                String zzc = zzc((zzk) zzs.zza(parcel, zzk.CREATOR));
                parcel2.writeNoException();
                parcel2.writeString(zzc);
                return true;
            case 12:
                zza((zzo) zzs.zza(parcel, zzo.CREATOR), (zzk) zzs.zza(parcel, zzk.CREATOR));
                parcel2.writeNoException();
                return true;
            case 13:
                zzb((zzo) zzs.zza(parcel, zzo.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                List<zzfv> zza3 = zza(parcel.readString(), parcel.readString(), zzs.zza(parcel), (zzk) zzs.zza(parcel, zzk.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza3);
                return true;
            case 15:
                List<zzfv> zza4 = zza(parcel.readString(), parcel.readString(), parcel.readString(), zzs.zza(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza4);
                return true;
            case 16:
                List<zzo> zza5 = zza(parcel.readString(), parcel.readString(), (zzk) zzs.zza(parcel, zzk.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza5);
                return true;
            case 17:
                List<zzo> zze = zze(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeTypedList(zze);
                return true;
            case 18:
                zzd((zzk) zzs.zza(parcel, zzk.CREATOR));
                parcel2.writeNoException();
                return true;
        }
    }
}
