package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.List;

public final class zzns extends zznp {
    private final Uri uri;
    private final long zzbdr;
    private final String zzbds;
    private final zzno zzbdt;
    private final zznz zzbdu;

    public zzns(String str, long j, zzfs zzfs, String str2, zzny zzny, List<zznm> list, String str3, long j2) {
        super(str, -1, zzfs, str2, zzny, list);
        String str4;
        this.uri = Uri.parse(str2);
        zznz zznz = null;
        this.zzbdt = zzny.zzbed <= 0 ? null : new zzno(null, zzny.zzbec, zzny.zzbed);
        if (str != null) {
            String str5 = zzfs.zzze;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22 + String.valueOf(str5).length());
            sb.append(str);
            sb.append(".");
            sb.append(str5);
            sb.append(".-1");
            str4 = sb.toString();
        } else {
            str4 = null;
        }
        this.zzbds = str4;
        this.zzbdr = -1;
        this.zzbdu = this.zzbdt == null ? new zznz(new zzno(null, 0, -1)) : zznz;
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final zzno zzgi() {
        return this.zzbdt;
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final zznd zzgj() {
        return this.zzbdu;
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final String zzf() {
        return this.zzbds;
    }
}
