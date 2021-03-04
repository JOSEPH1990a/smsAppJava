package com.google.android.gms.internal.ads;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.HashMap;

/* access modifiers changed from: package-private */
public final class zzbfp implements Runnable {
    private final /* synthetic */ String val$message;
    private final /* synthetic */ String zzdvo;
    private final /* synthetic */ String zzewp;
    private final /* synthetic */ zzbfk zzewt;
    private final /* synthetic */ String zzewy;

    zzbfp(zzbfk zzbfk, String str, String str2, String str3, String str4) {
        this.zzewt = zzbfk;
        this.zzdvo = str;
        this.zzewp = str2;
        this.zzewy = str3;
        this.val$message = str4;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheCanceled");
        hashMap.put("src", this.zzdvo);
        if (!TextUtils.isEmpty(this.zzewp)) {
            hashMap.put("cachedSrc", this.zzewp);
        }
        zzbfk zzbfk = this.zzewt;
        hashMap.put(AppMeasurement.Param.TYPE, zzbfk.zzez(this.zzewy));
        hashMap.put("reason", this.zzewy);
        if (!TextUtils.isEmpty(this.val$message)) {
            hashMap.put("message", this.val$message);
        }
        this.zzewt.zza((zzbfk) "onPrecacheEvent", (String) hashMap);
    }
}
