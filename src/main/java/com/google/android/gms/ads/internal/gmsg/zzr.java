package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.ads.zzbgg;
import java.util.Map;

final class zzr implements zzu<zzbgg> {
    zzr() {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.util.Map] */
    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final /* synthetic */ void zza(zzbgg zzbgg, Map map) {
        zzbgg zzbgg2 = zzbgg;
        if (map.keySet().contains("start")) {
            zzbgg2.zzadl().zzaeh();
        } else if (map.keySet().contains("stop")) {
            zzbgg2.zzadl().zzaei();
        } else if (map.keySet().contains("cancel")) {
            zzbgg2.zzadl().zzaej();
        }
    }
}
