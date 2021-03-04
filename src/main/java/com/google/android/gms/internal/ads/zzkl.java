package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

final class zzkl implements Parcelable.Creator<zzkk> {
    zzkl() {
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzkk[] newArray(int i) {
        return new zzkk[i];
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzkk createFromParcel(Parcel parcel) {
        return new zzkk(parcel);
    }
}
