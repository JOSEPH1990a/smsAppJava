package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

final class zzkn implements Parcelable.Creator<zzkm> {
    zzkn() {
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzkm[] newArray(int i) {
        return new zzkm[i];
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzkm createFromParcel(Parcel parcel) {
        return new zzkm(parcel);
    }
}
