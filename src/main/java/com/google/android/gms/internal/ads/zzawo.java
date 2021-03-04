package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
@SafeParcelable.Class(creator = "SafeBrowsingConfigParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzawo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzawo> CREATOR = new zzawp();
    @SafeParcelable.Field(id = 2)
    public final String zzegh;
    @SafeParcelable.Field(id = 3)
    public final String zzegi;
    @SafeParcelable.Field(id = 4)
    public final boolean zzegj;
    @SafeParcelable.Field(id = 5)
    public final boolean zzegk;
    @SafeParcelable.Field(id = 6)
    public final List<String> zzegl;
    @SafeParcelable.Field(id = 7)
    public final boolean zzegm;
    @SafeParcelable.Field(id = 8)
    public final boolean zzegn;
    @SafeParcelable.Field(id = 9)
    public final List<String> zzego;

    @SafeParcelable.Constructor
    public zzawo(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) boolean z, @SafeParcelable.Param(id = 5) boolean z2, @SafeParcelable.Param(id = 6) List<String> list, @SafeParcelable.Param(id = 7) boolean z3, @SafeParcelable.Param(id = 8) boolean z4, @SafeParcelable.Param(id = 9) List<String> list2) {
        this.zzegh = str;
        this.zzegi = str2;
        this.zzegj = z;
        this.zzegk = z2;
        this.zzegl = list;
        this.zzegm = z3;
        this.zzegn = z4;
        this.zzego = list2 == null ? new ArrayList<>() : list2;
    }

    @Nullable
    public static zzawo zzo(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        return new zzawo(jSONObject.optString("click_string", ""), jSONObject.optString("report_url", ""), jSONObject.optBoolean("rendered_ad_enabled", false), jSONObject.optBoolean("non_malicious_reporting_enabled", false), zzbac.zza(jSONObject.optJSONArray("allowed_headers"), (List<String>) null), jSONObject.optBoolean("protection_enabled", false), jSONObject.optBoolean("malicious_reporting_enabled", false), zzbac.zza(jSONObject.optJSONArray("webview_permissions"), (List<String>) null));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzegh, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzegi, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzegj);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzegk);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzegl, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzegm);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzegn);
        SafeParcelWriter.writeStringList(parcel, 9, this.zzego, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
