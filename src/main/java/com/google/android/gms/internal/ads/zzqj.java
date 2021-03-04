package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

final class zzqj implements Parcelable.Creator<zzqi> {
    zzqj() {
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzqi[] newArray(int i) {
        return new zzqi[0];
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzqi createFromParcel(Parcel parcel) {
        return new zzqi(parcel);
    }
}
