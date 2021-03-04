package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.ads.zzbgg;
import java.util.Map;

final class zzq implements zzu<zzbgg> {
    zzq() {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.util.Map] */
    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final /* synthetic */ void zza(zzbgg zzbgg, Map map) {
        zzbgg zzbgg2 = zzbgg;
        String str = (String) map.get("action");
        if ("pause".equals(str)) {
            zzbgg2.zzjf();
        } else if ("resume".equals(str)) {
            zzbgg2.zzjg();
        }
    }
}
