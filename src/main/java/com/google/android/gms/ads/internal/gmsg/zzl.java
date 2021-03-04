package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.internal.ads.zzaxz;
import com.google.android.gms.internal.ads.zzbgg;
import java.util.Map;

final class zzl implements zzu<zzbgg> {
    zzl() {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.util.Map] */
    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final /* synthetic */ void zza(zzbgg zzbgg, Map map) {
        zzbgg zzbgg2 = zzbgg;
        zzd zzadh = zzbgg2.zzadh();
        if (zzadh != null) {
            zzadh.close();
            return;
        }
        zzd zzadi = zzbgg2.zzadi();
        if (zzadi != null) {
            zzadi.close();
        } else {
            zzaxz.zzeo("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
