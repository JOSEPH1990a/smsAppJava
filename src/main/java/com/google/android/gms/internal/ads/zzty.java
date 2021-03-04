package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@zzark
@SafeParcelable.Class(creator = "CacheOfferingCreator")
@SafeParcelable.Reserved({1})
public final class zzty extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzty> CREATOR = new zztz();
    @Nullable
    @SafeParcelable.Field(id = 2)
    public final String url;
    @SafeParcelable.Field(id = 3)
    private final long zzbzv;
    @SafeParcelable.Field(id = 4)
    private final String zzbzw;
    @SafeParcelable.Field(id = 5)
    private final String zzbzx;
    @SafeParcelable.Field(id = 6)
    private final String zzbzy;
    @SafeParcelable.Field(id = 7)
    private final Bundle zzbzz;
    @SafeParcelable.Field(id = 8)
    public final boolean zzcaa;
    @SafeParcelable.Field(id = 9)
    public long zzcab;

    @Nullable
    public static zzty zzbb(String str) {
        return zzd(Uri.parse(str));
    }

    @Nullable
    public static zzty zzd(Uri uri) {
        long j;
        try {
            if (!"gcache".equals(uri.getScheme())) {
                return null;
            }
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments.size() != 2) {
                int size = pathSegments.size();
                StringBuilder sb = new StringBuilder(62);
                sb.append("Expected 2 path parts for namespace and id, found :");
                sb.append(size);
                zzaxz.zzeo(sb.toString());
                return null;
            }
            String str = pathSegments.get(0);
            String str2 = pathSegments.get(1);
            String host = uri.getHost();
            String queryParameter = uri.getQueryParameter(ImagesContract.URL);
            boolean equals = "1".equals(uri.getQueryParameter("read_only"));
            String queryParameter2 = uri.getQueryParameter("expiration");
            if (queryParameter2 == null) {
                j = 0;
            } else {
                j = Long.parseLong(queryParameter2);
            }
            Bundle bundle = new Bundle();
            for (String str3 : zzbv.zzlh().zzh(uri)) {
                if (str3.startsWith("tag.")) {
                    bundle.putString(str3.substring(4), uri.getQueryParameter(str3));
                }
            }
            return new zzty(queryParameter, j, host, str, str2, bundle, equals, 0);
        } catch (NullPointerException | NumberFormatException e) {
            zzaxz.zzc("Unable to parse Uri into cache offering.", e);
            return null;
        }
    }

    @SafeParcelable.Constructor
    zzty(@SafeParcelable.Param(id = 2) @Nullable String str, @SafeParcelable.Param(id = 3) long j, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) String str3, @SafeParcelable.Param(id = 6) String str4, @SafeParcelable.Param(id = 7) Bundle bundle, @SafeParcelable.Param(id = 8) boolean z, @SafeParcelable.Param(id = 9) long j2) {
        this.url = str;
        this.zzbzv = j;
        this.zzbzw = str2 == null ? "" : str2;
        this.zzbzx = str3 == null ? "" : str3;
        this.zzbzy = str4 == null ? "" : str4;
        this.zzbzz = bundle == null ? new Bundle() : bundle;
        this.zzcaa = z;
        this.zzcab = j2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.url, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzbzv);
        SafeParcelWriter.writeString(parcel, 4, this.zzbzw, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzbzx, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzbzy, false);
        SafeParcelWriter.writeBundle(parcel, 7, this.zzbzz, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzcaa);
        SafeParcelWriter.writeLong(parcel, 9, this.zzcab);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
