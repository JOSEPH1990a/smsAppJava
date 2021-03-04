package com.google.android.gms.ads.internal.gmsg;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.internal.ads.zzaxz;
import com.google.android.gms.internal.ads.zzayh;
import com.google.android.gms.internal.ads.zzbgg;
import java.util.HashMap;
import java.util.Map;

final class zzt implements zzu<zzbgg> {
    zzt() {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.util.Map] */
    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final /* synthetic */ void zza(zzbgg zzbgg, Map map) {
        zzbgg zzbgg2 = zzbgg;
        zzbv.zzlf();
        DisplayMetrics zza = zzayh.zza((WindowManager) zzbgg2.getContext().getSystemService("window"));
        int i = zza.widthPixels;
        int i2 = zza.heightPixels;
        int[] iArr = new int[2];
        HashMap hashMap = new HashMap();
        ((View) zzbgg2).getLocationInWindow(iArr);
        hashMap.put("xInPixels", Integer.valueOf(iArr[0]));
        hashMap.put("yInPixels", Integer.valueOf(iArr[1]));
        hashMap.put("windowWidthInPixels", Integer.valueOf(i));
        hashMap.put("windowHeightInPixels", Integer.valueOf(i2));
        zzbgg2.zza("locationReady", hashMap);
        zzaxz.zzeo("GET LOCATION COMPILED");
    }
}
