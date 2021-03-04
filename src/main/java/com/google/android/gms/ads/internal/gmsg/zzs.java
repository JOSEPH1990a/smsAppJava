package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.ads.zzbgg;
import java.util.Map;

final class zzs implements zzu<zzbgg> {
    zzs() {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.util.Map] */
    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final /* synthetic */ void zza(zzbgg zzbgg, Map map) {
        zzbgg zzbgg2 = zzbgg;
        if (map.keySet().contains("start")) {
            zzbgg2.zzax(true);
        }
        if (map.keySet().contains("stop")) {
            zzbgg2.zzax(false);
        }
    }
}
