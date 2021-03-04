package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

final class zzkr implements Parcelable.Creator<zzkq> {
    zzkr() {
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzkq[] newArray(int i) {
        return new zzkq[i];
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzkq createFromParcel(Parcel parcel) {
        return new zzkq(parcel);
    }
}
