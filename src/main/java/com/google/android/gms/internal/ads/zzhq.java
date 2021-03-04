package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

final class zzhq implements Parcelable.Creator<zzhp> {
    zzhq() {
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzhp[] newArray(int i) {
        return new zzhp[i];
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzhp createFromParcel(Parcel parcel) {
        return new zzhp(parcel);
    }
}
