package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzkm extends zzkp {
    public static final Parcelable.Creator<zzkm> CREATOR = new zzkn();
    public final String description;
    private final String zzaaa;
    public final String zzavu;

    public zzkm(String str, String str2, String str3) {
        super("COMM");
        this.zzaaa = str;
        this.description = str2;
        this.zzavu = str3;
    }

    zzkm(Parcel parcel) {
        super("COMM");
        this.zzaaa = parcel.readString();
        this.description = parcel.readString();
        this.zzavu = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzkm zzkm = (zzkm) obj;
        return zzqe.zza(this.description, zzkm.description) && zzqe.zza(this.zzaaa, zzkm.zzaaa) && zzqe.zza(this.zzavu, zzkm.zzavu);
    }

    public final int hashCode() {
        String str = this.zzaaa;
        int i = 0;
        int hashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.description;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.zzavu;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzze);
        parcel.writeString(this.zzaaa);
        parcel.writeString(this.zzavu);
    }
}
