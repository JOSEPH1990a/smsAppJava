package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator = "AdRequestInfoParcelCreator")
public final class zzasi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzasi> CREATOR = new zzask();
    @SafeParcelable.Field(id = 6)
    public final ApplicationInfo applicationInfo;
    @SafeParcelable.Field(id = 1)
    public final int versionCode;
    @SafeParcelable.Field(id = 28)
    public final String zzbsm;
    @SafeParcelable.Field(id = 5)
    public final String zzbsn;
    @SafeParcelable.Field(id = 11)
    public final zzbbi zzbsp;
    @SafeParcelable.Field(id = 4)
    public final zzwf zzbst;
    @SafeParcelable.Field(id = 29)
    public final zzacp zzbti;
    @SafeParcelable.Field(id = 63)
    public final zzafz zzbtk;
    @Nullable
    @SafeParcelable.Field(id = 46)
    public final zzyv zzbtl;
    @SafeParcelable.Field(id = 53)
    public final List<Integer> zzbtn;
    @SafeParcelable.Field(id = 14)
    public final List<String> zzbtt;
    @SafeParcelable.Field(id = 20)
    public final float zzbwv;
    @SafeParcelable.Field(id = 10)
    public final String zzclm;
    @SafeParcelable.Field(id = 42)
    public final boolean zzdlv;
    @Nullable
    @SafeParcelable.Field(id = 2)
    public final Bundle zzdwf;
    @SafeParcelable.Field(id = 3)
    public final zzwb zzdwg;
    @Nullable
    @SafeParcelable.Field(id = 7)
    public final PackageInfo zzdwh;
    @SafeParcelable.Field(id = 8)
    public final String zzdwi;
    @SafeParcelable.Field(id = 9)
    public final String zzdwj;
    @SafeParcelable.Field(id = 12)
    public final Bundle zzdwk;
    @SafeParcelable.Field(id = 13)
    public final int zzdwl;
    @SafeParcelable.Field(id = 15)
    public final Bundle zzdwm;
    @SafeParcelable.Field(id = 16)
    public final boolean zzdwn;
    @SafeParcelable.Field(id = 18)
    public final int zzdwo;
    @SafeParcelable.Field(id = 19)
    public final int zzdwp;
    @SafeParcelable.Field(id = 21)
    public final String zzdwq;
    @SafeParcelable.Field(id = 25)
    public final long zzdwr;
    @SafeParcelable.Field(id = 26)
    public final String zzdws;
    @Nullable
    @SafeParcelable.Field(id = 27)
    public final List<String> zzdwt;
    @SafeParcelable.Field(id = 30)
    public final List<String> zzdwu;
    @SafeParcelable.Field(id = 31)
    public final long zzdwv;
    @SafeParcelable.Field(id = 33)
    public final String zzdww;
    @SafeParcelable.Field(id = 34)
    public final float zzdwx;
    @SafeParcelable.Field(id = 35)
    public final int zzdwy;
    @SafeParcelable.Field(id = 36)
    public final int zzdwz;
    @SafeParcelable.Field(id = 37)
    public final boolean zzdxa;
    @SafeParcelable.Field(id = 38)
    public final boolean zzdxb;
    @SafeParcelable.Field(id = 39)
    public final String zzdxc;
    @SafeParcelable.Field(id = 40)
    public final boolean zzdxd;
    @SafeParcelable.Field(id = 41)
    public final String zzdxe;
    @SafeParcelable.Field(id = 43)
    public final int zzdxf;
    @SafeParcelable.Field(id = 44)
    public final Bundle zzdxg;
    @SafeParcelable.Field(id = 45)
    public final String zzdxh;
    @SafeParcelable.Field(id = 47)
    public final boolean zzdxi;
    @SafeParcelable.Field(id = 48)
    public final Bundle zzdxj;
    @Nullable
    @SafeParcelable.Field(id = 49)
    public final String zzdxk;
    @Nullable
    @SafeParcelable.Field(id = 50)
    public final String zzdxl;
    @Nullable
    @SafeParcelable.Field(id = 51)
    public final String zzdxm;
    @SafeParcelable.Field(id = 52)
    public final boolean zzdxn;
    @SafeParcelable.Field(id = 54)
    public final String zzdxo;
    @SafeParcelable.Field(id = 55)
    public final List<String> zzdxp;
    @SafeParcelable.Field(id = 56)
    public final int zzdxq;
    @SafeParcelable.Field(id = 57)
    public final boolean zzdxr;
    @SafeParcelable.Field(id = 58)
    public final boolean zzdxs;
    @SafeParcelable.Field(id = 59)
    public final boolean zzdxt;
    @SafeParcelable.Field(id = 60)
    public final ArrayList<String> zzdxu;
    @SafeParcelable.Field(id = 61)
    public final String zzdxv;
    @Nullable
    @SafeParcelable.Field(id = 64)
    public final String zzdxw;
    @SafeParcelable.Field(id = 65)
    public final Bundle zzdxx;

    @VisibleForTesting
    private zzasi(@Nullable Bundle bundle, zzwb zzwb, zzwf zzwf, String str, ApplicationInfo applicationInfo2, @Nullable PackageInfo packageInfo, String str2, String str3, String str4, zzbbi zzbbi, Bundle bundle2, int i, List<String> list, List<String> list2, Bundle bundle3, boolean z, int i2, int i3, float f, String str5, long j, String str6, @Nullable List<String> list3, String str7, zzacp zzacp, long j2, String str8, float f2, boolean z2, int i4, int i5, boolean z3, boolean z4, String str9, String str10, boolean z5, int i6, Bundle bundle4, String str11, @Nullable zzyv zzyv, boolean z6, Bundle bundle5, @Nullable String str12, @Nullable String str13, @Nullable String str14, boolean z7, List<Integer> list4, String str15, List<String> list5, int i7, boolean z8, boolean z9, boolean z10, ArrayList<String> arrayList, String str16, zzafz zzafz, @Nullable String str17, Bundle bundle6) {
        this(24, bundle, zzwb, zzwf, str, applicationInfo2, packageInfo, str2, str3, str4, zzbbi, bundle2, i, list, bundle3, z, i2, i3, f, str5, j, str6, list3, str7, zzacp, list2, j2, str8, f2, z2, i4, i5, z3, z4, str9, str10, z5, i6, bundle4, str11, zzyv, z6, bundle5, str12, str13, str14, z7, list4, str15, list5, i7, z8, z9, z10, arrayList, str16, zzafz, str17, bundle6);
    }

    public zzasi(zzasj zzasj, long j, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this(zzasj.zzdwf, zzasj.zzdwg, zzasj.zzbst, zzasj.zzbsn, zzasj.applicationInfo, zzasj.zzdwh, (String) zzbbq.zza(zzasj.zzdxz, ""), zzasj.zzdwj, zzasj.zzclm, zzasj.zzbsp, zzasj.zzdwk, zzasj.zzdwl, zzasj.zzbtt, zzasj.zzdwu, zzasj.zzdwm, zzasj.zzdwn, zzasj.zzdwo, zzasj.zzdwp, zzasj.zzbwv, zzasj.zzdwq, zzasj.zzdwr, zzasj.zzdws, zzasj.zzdwt, zzasj.zzbsm, zzasj.zzbti, j, zzasj.zzdww, zzasj.zzdwx, zzasj.zzdxd, zzasj.zzdwy, zzasj.zzdwz, zzasj.zzdxa, zzasj.zzdxb, (String) zzbbq.zza(zzasj.zzdxy, "", 1, TimeUnit.SECONDS), zzasj.zzdxe, zzasj.zzdlv, zzasj.zzdxf, zzasj.zzdxg, zzasj.zzdxh, zzasj.zzbtl, zzasj.zzdxi, zzasj.zzdxj, str, str2, str3, zzasj.zzdxn, zzasj.zzbtn, zzasj.zzdxo, zzasj.zzdxp, zzasj.zzdxq, zzasj.zzdxr, zzasj.zzdxs, zzasj.zzdxt, zzasj.zzdxu, zzasj.zzdxv, zzasj.zzbtk, str4, zzasj.zzdxx);
    }

    @SafeParcelable.Constructor
    zzasi(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) Bundle bundle, @SafeParcelable.Param(id = 3) zzwb zzwb, @SafeParcelable.Param(id = 4) zzwf zzwf, @SafeParcelable.Param(id = 5) String str, @SafeParcelable.Param(id = 6) ApplicationInfo applicationInfo2, @SafeParcelable.Param(id = 7) PackageInfo packageInfo, @SafeParcelable.Param(id = 8) String str2, @SafeParcelable.Param(id = 9) String str3, @SafeParcelable.Param(id = 10) String str4, @SafeParcelable.Param(id = 11) zzbbi zzbbi, @SafeParcelable.Param(id = 12) Bundle bundle2, @SafeParcelable.Param(id = 13) int i2, @SafeParcelable.Param(id = 14) List<String> list, @SafeParcelable.Param(id = 15) Bundle bundle3, @SafeParcelable.Param(id = 16) boolean z, @SafeParcelable.Param(id = 18) int i3, @SafeParcelable.Param(id = 19) int i4, @SafeParcelable.Param(id = 20) float f, @SafeParcelable.Param(id = 21) String str5, @SafeParcelable.Param(id = 25) long j, @SafeParcelable.Param(id = 26) String str6, @SafeParcelable.Param(id = 27) List<String> list2, @SafeParcelable.Param(id = 28) String str7, @SafeParcelable.Param(id = 29) zzacp zzacp, @SafeParcelable.Param(id = 30) List<String> list3, @SafeParcelable.Param(id = 31) long j2, @SafeParcelable.Param(id = 33) String str8, @SafeParcelable.Param(id = 34) float f2, @SafeParcelable.Param(id = 40) boolean z2, @SafeParcelable.Param(id = 35) int i5, @SafeParcelable.Param(id = 36) int i6, @SafeParcelable.Param(id = 37) boolean z3, @SafeParcelable.Param(id = 38) boolean z4, @SafeParcelable.Param(id = 39) String str9, @SafeParcelable.Param(id = 41) String str10, @SafeParcelable.Param(id = 42) boolean z5, @SafeParcelable.Param(id = 43) int i7, @SafeParcelable.Param(id = 44) Bundle bundle4, @SafeParcelable.Param(id = 45) String str11, @SafeParcelable.Param(id = 46) zzyv zzyv, @SafeParcelable.Param(id = 47) boolean z6, @SafeParcelable.Param(id = 48) Bundle bundle5, @SafeParcelable.Param(id = 49) @Nullable String str12, @SafeParcelable.Param(id = 50) @Nullable String str13, @SafeParcelable.Param(id = 51) @Nullable String str14, @SafeParcelable.Param(id = 52) boolean z7, @SafeParcelable.Param(id = 53) List<Integer> list4, @SafeParcelable.Param(id = 54) String str15, @SafeParcelable.Param(id = 55) List<String> list5, @SafeParcelable.Param(id = 56) int i8, @SafeParcelable.Param(id = 57) boolean z8, @SafeParcelable.Param(id = 58) boolean z9, @SafeParcelable.Param(id = 59) boolean z10, @SafeParcelable.Param(id = 60) ArrayList<String> arrayList, @SafeParcelable.Param(id = 61) String str16, @SafeParcelable.Param(id = 63) zzafz zzafz, @SafeParcelable.Param(id = 64) @Nullable String str17, @SafeParcelable.Param(id = 65) Bundle bundle6) {
        List<String> list6;
        List<String> list7;
        this.versionCode = i;
        this.zzdwf = bundle;
        this.zzdwg = zzwb;
        this.zzbst = zzwf;
        this.zzbsn = str;
        this.applicationInfo = applicationInfo2;
        this.zzdwh = packageInfo;
        this.zzdwi = str2;
        this.zzdwj = str3;
        this.zzclm = str4;
        this.zzbsp = zzbbi;
        this.zzdwk = bundle2;
        this.zzdwl = i2;
        this.zzbtt = list;
        if (list3 == null) {
            list6 = Collections.emptyList();
        } else {
            list6 = Collections.unmodifiableList(list3);
        }
        this.zzdwu = list6;
        this.zzdwm = bundle3;
        this.zzdwn = z;
        this.zzdwo = i3;
        this.zzdwp = i4;
        this.zzbwv = f;
        this.zzdwq = str5;
        this.zzdwr = j;
        this.zzdws = str6;
        if (list2 == null) {
            list7 = Collections.emptyList();
        } else {
            list7 = Collections.unmodifiableList(list2);
        }
        this.zzdwt = list7;
        this.zzbsm = str7;
        this.zzbti = zzacp;
        this.zzdwv = j2;
        this.zzdww = str8;
        this.zzdwx = f2;
        this.zzdxd = z2;
        this.zzdwy = i5;
        this.zzdwz = i6;
        this.zzdxa = z3;
        this.zzdxb = z4;
        this.zzdxc = str9;
        this.zzdxe = str10;
        this.zzdlv = z5;
        this.zzdxf = i7;
        this.zzdxg = bundle4;
        this.zzdxh = str11;
        this.zzbtl = zzyv;
        this.zzdxi = z6;
        this.zzdxj = bundle5;
        this.zzdxk = str12;
        this.zzdxl = str13;
        this.zzdxm = str14;
        this.zzdxn = z7;
        this.zzbtn = list4;
        this.zzdxo = str15;
        this.zzdxp = list5;
        this.zzdxq = i8;
        this.zzdxr = z8;
        this.zzdxs = z9;
        this.zzdxt = z10;
        this.zzdxu = arrayList;
        this.zzdxv = str16;
        this.zzbtk = zzafz;
        this.zzdxw = str17;
        this.zzdxx = bundle6;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeBundle(parcel, 2, this.zzdwf, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzdwg, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzbst, i, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzbsn, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.applicationInfo, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzdwh, i, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzdwi, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzdwj, false);
        SafeParcelWriter.writeString(parcel, 10, this.zzclm, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzbsp, i, false);
        SafeParcelWriter.writeBundle(parcel, 12, this.zzdwk, false);
        SafeParcelWriter.writeInt(parcel, 13, this.zzdwl);
        SafeParcelWriter.writeStringList(parcel, 14, this.zzbtt, false);
        SafeParcelWriter.writeBundle(parcel, 15, this.zzdwm, false);
        SafeParcelWriter.writeBoolean(parcel, 16, this.zzdwn);
        SafeParcelWriter.writeInt(parcel, 18, this.zzdwo);
        SafeParcelWriter.writeInt(parcel, 19, this.zzdwp);
        SafeParcelWriter.writeFloat(parcel, 20, this.zzbwv);
        SafeParcelWriter.writeString(parcel, 21, this.zzdwq, false);
        SafeParcelWriter.writeLong(parcel, 25, this.zzdwr);
        SafeParcelWriter.writeString(parcel, 26, this.zzdws, false);
        SafeParcelWriter.writeStringList(parcel, 27, this.zzdwt, false);
        SafeParcelWriter.writeString(parcel, 28, this.zzbsm, false);
        SafeParcelWriter.writeParcelable(parcel, 29, this.zzbti, i, false);
        SafeParcelWriter.writeStringList(parcel, 30, this.zzdwu, false);
        SafeParcelWriter.writeLong(parcel, 31, this.zzdwv);
        SafeParcelWriter.writeString(parcel, 33, this.zzdww, false);
        SafeParcelWriter.writeFloat(parcel, 34, this.zzdwx);
        SafeParcelWriter.writeInt(parcel, 35, this.zzdwy);
        SafeParcelWriter.writeInt(parcel, 36, this.zzdwz);
        SafeParcelWriter.writeBoolean(parcel, 37, this.zzdxa);
        SafeParcelWriter.writeBoolean(parcel, 38, this.zzdxb);
        SafeParcelWriter.writeString(parcel, 39, this.zzdxc, false);
        SafeParcelWriter.writeBoolean(parcel, 40, this.zzdxd);
        SafeParcelWriter.writeString(parcel, 41, this.zzdxe, false);
        SafeParcelWriter.writeBoolean(parcel, 42, this.zzdlv);
        SafeParcelWriter.writeInt(parcel, 43, this.zzdxf);
        SafeParcelWriter.writeBundle(parcel, 44, this.zzdxg, false);
        SafeParcelWriter.writeString(parcel, 45, this.zzdxh, false);
        SafeParcelWriter.writeParcelable(parcel, 46, this.zzbtl, i, false);
        SafeParcelWriter.writeBoolean(parcel, 47, this.zzdxi);
        SafeParcelWriter.writeBundle(parcel, 48, this.zzdxj, false);
        SafeParcelWriter.writeString(parcel, 49, this.zzdxk, false);
        SafeParcelWriter.writeString(parcel, 50, this.zzdxl, false);
        SafeParcelWriter.writeString(parcel, 51, this.zzdxm, false);
        SafeParcelWriter.writeBoolean(parcel, 52, this.zzdxn);
        SafeParcelWriter.writeIntegerList(parcel, 53, this.zzbtn, false);
        SafeParcelWriter.writeString(parcel, 54, this.zzdxo, false);
        SafeParcelWriter.writeStringList(parcel, 55, this.zzdxp, false);
        SafeParcelWriter.writeInt(parcel, 56, this.zzdxq);
        SafeParcelWriter.writeBoolean(parcel, 57, this.zzdxr);
        SafeParcelWriter.writeBoolean(parcel, 58, this.zzdxs);
        SafeParcelWriter.writeBoolean(parcel, 59, this.zzdxt);
        SafeParcelWriter.writeStringList(parcel, 60, this.zzdxu, false);
        SafeParcelWriter.writeString(parcel, 61, this.zzdxv, false);
        SafeParcelWriter.writeParcelable(parcel, 63, this.zzbtk, i, false);
        SafeParcelWriter.writeString(parcel, 64, this.zzdxw, false);
        SafeParcelWriter.writeBundle(parcel, 65, this.zzdxx, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
