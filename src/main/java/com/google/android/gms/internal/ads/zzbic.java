package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.gmsg.zzu;
import java.util.Map;

final class zzbic implements zzu<zzbgg> {
    private final /* synthetic */ zzbib zzfbd;

    zzbic(zzbib zzbib) {
        this.zzfbd = zzbib;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.util.Map] */
    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final /* synthetic */ void zza(zzbgg zzbgg, Map map) {
        if (map != null) {
            String str = (String) map.get("height");
            if (!TextUtils.isEmpty(str)) {
                try {
                    int parseInt = Integer.parseInt(str);
                    synchronized (this.zzfbd) {
                        if (this.zzfbd.zzezz != parseInt) {
                            this.zzfbd.zzezz = parseInt;
                            this.zzfbd.requestLayout();
                        }
                    }
                } catch (Exception e) {
                    zzaxz.zzc("Exception occurred while getting webview content height", e);
                }
            }
        }
    }
}
