package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzhp;

final class zzhr implements Parcelable.Creator<zzhp.zza> {
    zzhr() {
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzhp.zza[] newArray(int i) {
        return new zzhp.zza[i];
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzhp.zza createFromParcel(Parcel parcel) {
        return new zzhp.zza(parcel);
    }
}
