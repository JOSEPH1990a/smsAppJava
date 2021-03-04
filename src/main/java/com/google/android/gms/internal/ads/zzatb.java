package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator = "NonagonRequestParcelCreator")
public final class zzatb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzatb> CREATOR = new zzatc();
    @SafeParcelable.Field(id = 3)
    private final ApplicationInfo applicationInfo;
    @SafeParcelable.Field(id = 4)
    private final String packageName;
    @Nullable
    @SafeParcelable.Field(id = 6)
    private final PackageInfo zzdwh;
    @SafeParcelable.Field(id = 5)
    private final List<String> zzdwt;
    @SafeParcelable.Field(id = 7)
    private final String zzdxc;
    @SafeParcelable.Field(id = 1)
    private final Bundle zzdzn;
    @SafeParcelable.Field(id = 2)
    private final zzbbi zzdzo;
    @SafeParcelable.Field(id = 8)
    private final boolean zzdzp;
    @SafeParcelable.Field(id = 9)
    private final String zzdzq;

    @SafeParcelable.Constructor
    public zzatb(@SafeParcelable.Param(id = 1) Bundle bundle, @SafeParcelable.Param(id = 2) zzbbi zzbbi, @SafeParcelable.Param(id = 3) ApplicationInfo applicationInfo2, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) List<String> list, @SafeParcelable.Param(id = 6) @Nullable PackageInfo packageInfo, @SafeParcelable.Param(id = 7) String str2, @SafeParcelable.Param(id = 8) boolean z, @SafeParcelable.Param(id = 9) String str3) {
        this.zzdzn = bundle;
        this.zzdzo = zzbbi;
        this.packageName = str;
        this.applicationInfo = applicationInfo2;
        this.zzdwt = list;
        this.zzdwh = packageInfo;
        this.zzdxc = str2;
        this.zzdzp = z;
        this.zzdzq = str3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 1, this.zzdzn, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdzo, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.applicationInfo, i, false);
        SafeParcelWriter.writeString(parcel, 4, this.packageName, false);
        SafeParcelWriter.writeStringList(parcel, 5, this.zzdwt, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzdwh, i, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzdxc, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzdzp);
        SafeParcelWriter.writeString(parcel, 9, this.zzdzq, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
