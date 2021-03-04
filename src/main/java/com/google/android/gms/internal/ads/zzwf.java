package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.zzc;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@zzark
@SafeParcelable.Class(creator = "AdSizeParcelCreator")
@SafeParcelable.Reserved({1})
public class zzwf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzwf> CREATOR = new zzwg();
    @SafeParcelable.Field(id = 3)
    public final int height;
    @SafeParcelable.Field(id = 4)
    public final int heightPixels;
    @SafeParcelable.Field(id = 6)
    public final int width;
    @SafeParcelable.Field(id = 7)
    public final int widthPixels;
    @SafeParcelable.Field(id = 2)
    public final String zzckk;
    @SafeParcelable.Field(id = 5)
    public final boolean zzckl;
    @SafeParcelable.Field(id = 8)
    public final zzwf[] zzckm;
    @SafeParcelable.Field(id = 9)
    public final boolean zzckn;
    @SafeParcelable.Field(id = 10)
    public final boolean zzcko;
    @SafeParcelable.Field(id = 11)
    public boolean zzckp;

    public static int zzb(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static int zzc(DisplayMetrics displayMetrics) {
        return (int) (((float) zzd(displayMetrics)) * displayMetrics.density);
    }

    private static int zzd(DisplayMetrics displayMetrics) {
        int i = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        if (i <= 400) {
            return 32;
        }
        return i <= 720 ? 50 : 90;
    }

    public static zzwf zzg(Context context) {
        return new zzwf("320x50_mb", 0, 0, false, 0, 0, null, true, false, false);
    }

    public static zzwf zzpo() {
        return new zzwf("reward_mb", 0, 0, true, 0, 0, null, false, false, false);
    }

    public zzwf() {
        this("interstitial_mb", 0, 0, true, 0, 0, null, false, false, false);
    }

    public zzwf(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0086  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzwf(android.content.Context r13, com.google.android.gms.ads.AdSize[] r14) {
        /*
        // Method dump skipped, instructions count: 252
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwf.<init>(android.content.Context, com.google.android.gms.ads.AdSize[]):void");
    }

    public zzwf(zzwf zzwf, zzwf[] zzwfArr) {
        this(zzwf.zzckk, zzwf.height, zzwf.heightPixels, zzwf.zzckl, zzwf.width, zzwf.widthPixels, zzwfArr, zzwf.zzckn, zzwf.zzcko, zzwf.zzckp);
    }

    @SafeParcelable.Constructor
    zzwf(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i, @SafeParcelable.Param(id = 4) int i2, @SafeParcelable.Param(id = 5) boolean z, @SafeParcelable.Param(id = 6) int i3, @SafeParcelable.Param(id = 7) int i4, @SafeParcelable.Param(id = 8) zzwf[] zzwfArr, @SafeParcelable.Param(id = 9) boolean z2, @SafeParcelable.Param(id = 10) boolean z3, @SafeParcelable.Param(id = 11) boolean z4) {
        this.zzckk = str;
        this.height = i;
        this.heightPixels = i2;
        this.zzckl = z;
        this.width = i3;
        this.widthPixels = i4;
        this.zzckm = zzwfArr;
        this.zzckn = z2;
        this.zzcko = z3;
        this.zzckp = z4;
    }

    public final AdSize zzpp() {
        return zzc.zza(this.width, this.height, this.zzckk);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzckk, false);
        SafeParcelWriter.writeInt(parcel, 3, this.height);
        SafeParcelWriter.writeInt(parcel, 4, this.heightPixels);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzckl);
        SafeParcelWriter.writeInt(parcel, 6, this.width);
        SafeParcelWriter.writeInt(parcel, 7, this.widthPixels);
        SafeParcelWriter.writeTypedArray(parcel, 8, this.zzckm, i, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzckn);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzcko);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzckp);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
