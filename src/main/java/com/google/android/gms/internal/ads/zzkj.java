package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

final class zzkj implements Parcelable.Creator<zzki> {
    zzkj() {
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzki[] newArray(int i) {
        return new zzki[0];
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzki createFromParcel(Parcel parcel) {
        return new zzki(parcel);
    }
}
