package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "UserAttributeParcelCreator")
public final class zzfv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfv> CREATOR = new zzfw();
    @SafeParcelable.Field(id = 2)
    public final String name;
    @SafeParcelable.Field(id = 7)
    public final String origin;
    @SafeParcelable.Field(id = 1)
    private final int versionCode;
    @SafeParcelable.Field(id = 6)
    public final String zzaml;
    @SafeParcelable.Field(id = 3)
    public final long zzauk;
    @SafeParcelable.Field(id = 4)
    public final Long zzaul;
    @SafeParcelable.Field(id = 5)
    private final Float zzaum;
    @SafeParcelable.Field(id = 8)
    public final Double zzaun;

    zzfv(zzfx zzfx) {
        this(zzfx.name, zzfx.zzauk, zzfx.value, zzfx.origin);
    }

    zzfv(String str, long j, Object obj, String str2) {
        Preconditions.checkNotEmpty(str);
        this.versionCode = 2;
        this.name = str;
        this.zzauk = j;
        this.origin = str2;
        if (obj == null) {
            this.zzaul = null;
            this.zzaum = null;
            this.zzaun = null;
            this.zzaml = null;
        } else if (obj instanceof Long) {
            this.zzaul = (Long) obj;
            this.zzaum = null;
            this.zzaun = null;
            this.zzaml = null;
        } else if (obj instanceof String) {
            this.zzaul = null;
            this.zzaum = null;
            this.zzaun = null;
            this.zzaml = (String) obj;
        } else if (obj instanceof Double) {
            this.zzaul = null;
            this.zzaum = null;
            this.zzaun = (Double) obj;
            this.zzaml = null;
        } else {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }

    @SafeParcelable.Constructor
    zzfv(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) long j, @SafeParcelable.Param(id = 4) Long l, @SafeParcelable.Param(id = 5) Float f, @SafeParcelable.Param(id = 6) String str2, @SafeParcelable.Param(id = 7) String str3, @SafeParcelable.Param(id = 8) Double d) {
        this.versionCode = i;
        this.name = str;
        this.zzauk = j;
        this.zzaul = l;
        Double d2 = null;
        this.zzaum = null;
        if (i == 1) {
            this.zzaun = f != null ? Double.valueOf(f.doubleValue()) : d2;
        } else {
            this.zzaun = d;
        }
        this.zzaml = str2;
        this.origin = str3;
    }

    public final Object getValue() {
        Long l = this.zzaul;
        if (l != null) {
            return l;
        }
        Double d = this.zzaun;
        if (d != null) {
            return d;
        }
        String str = this.zzaml;
        if (str != null) {
            return str;
        }
        return null;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeString(parcel, 2, this.name, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzauk);
        SafeParcelWriter.writeLongObject(parcel, 4, this.zzaul, false);
        SafeParcelWriter.writeFloatObject(parcel, 5, null, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzaml, false);
        SafeParcelWriter.writeString(parcel, 7, this.origin, false);
        SafeParcelWriter.writeDoubleObject(parcel, 8, this.zzaun, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
