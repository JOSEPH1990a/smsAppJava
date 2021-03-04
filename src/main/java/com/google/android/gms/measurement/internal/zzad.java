package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Iterator;

@SafeParcelable.Class(creator = "EventParamsCreator")
@SafeParcelable.Reserved({1})
public final class zzad extends AbstractSafeParcelable implements Iterable<String> {
    public static final Parcelable.Creator<zzad> CREATOR = new zzaf();
    @SafeParcelable.Field(getter = "z", id = 2)
    private final Bundle zzaid;

    @SafeParcelable.Constructor
    zzad(@SafeParcelable.Param(id = 2) Bundle bundle) {
        this.zzaid = bundle;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, zziy(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* access modifiers changed from: package-private */
    public final Object get(String str) {
        return this.zzaid.get(str);
    }

    /* access modifiers changed from: package-private */
    public final Long getLong(String str) {
        return Long.valueOf(this.zzaid.getLong(str));
    }

    /* access modifiers changed from: package-private */
    public final Double zzbr(String str) {
        return Double.valueOf(this.zzaid.getDouble(str));
    }

    /* access modifiers changed from: package-private */
    public final String getString(String str) {
        return this.zzaid.getString(str);
    }

    public final int size() {
        return this.zzaid.size();
    }

    public final String toString() {
        return this.zzaid.toString();
    }

    public final Bundle zziy() {
        return new Bundle(this.zzaid);
    }

    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        return new zzae(this);
    }
}
