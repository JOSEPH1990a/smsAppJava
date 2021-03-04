package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.internal.ads.zzaan;
import com.google.android.gms.internal.ads.zzanx;
import com.google.android.gms.internal.ads.zzaoa;
import com.google.android.gms.internal.ads.zzaoc;
import com.google.android.gms.internal.ads.zzaod;
import com.google.android.gms.internal.ads.zzaol;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzaxz;
import com.google.android.gms.internal.ads.zzbgg;
import com.google.android.gms.internal.ads.zzwu;
import java.util.Map;

@zzark
public final class zzab implements zzu<zzbgg> {
    private static final Map<String, Integer> zzdge = CollectionUtils.mapOfKeyValueArrays(new String[]{"resize", "playVideo", "storePicture", "createCalendarEvent", "setOrientationProperties", "closeResizedAd", "unload"}, new Integer[]{1, 2, 3, 4, 5, 6, 7});
    private final zzw zzdgb;
    private final zzaoa zzdgc;
    private final zzaol zzdgd;

    public zzab(zzw zzw, zzaoa zzaoa, zzaol zzaol) {
        this.zzdgb = zzw;
        this.zzdgc = zzaoa;
        this.zzdgd = zzaol;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.util.Map] */
    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final /* synthetic */ void zza(zzbgg zzbgg, Map map) {
        zzw zzw;
        zzbgg zzbgg2 = zzbgg;
        int intValue = zzdge.get((String) map.get("a")).intValue();
        if (intValue != 5 && intValue != 7 && (zzw = this.zzdgb) != null && !zzw.zzju()) {
            this.zzdgb.zzas(null);
        } else if (intValue != 1) {
            switch (intValue) {
                case 3:
                    new zzaod(zzbgg2, map).execute();
                    return;
                case 4:
                    new zzanx(zzbgg2, map).execute();
                    return;
                case 5:
                    new zzaoc(zzbgg2, map).execute();
                    return;
                case 6:
                    this.zzdgc.zzx(true);
                    return;
                case 7:
                    if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcpv)).booleanValue()) {
                        this.zzdgd.zzjv();
                        return;
                    }
                    return;
                default:
                    zzaxz.zzen("Unknown MRAID command called.");
                    return;
            }
        } else {
            this.zzdgc.zzk(map);
        }
    }
}
