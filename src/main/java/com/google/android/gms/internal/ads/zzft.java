package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

final class zzft implements Parcelable.Creator<zzfs> {
    zzft() {
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzfs[] newArray(int i) {
        return new zzfs[i];
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzfs createFromParcel(Parcel parcel) {
        return new zzfs(parcel);
    }
}
