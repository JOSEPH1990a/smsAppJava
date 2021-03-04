package com.google.android.gms.internal.ads;

import android.support.v4.app.NotificationCompat;
import java.util.HashMap;

/* access modifiers changed from: package-private */
public final class zzbfn implements Runnable {
    private final /* synthetic */ String zzdvo;
    private final /* synthetic */ String zzewp;
    private final /* synthetic */ int zzewr;
    private final /* synthetic */ zzbfk zzewt;

    zzbfn(zzbfk zzbfk, String str, String str2, int i) {
        this.zzewt = zzbfk;
        this.zzdvo = str;
        this.zzewp = str2;
        this.zzewr = i;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheComplete");
        hashMap.put("src", this.zzdvo);
        hashMap.put("cachedSrc", this.zzewp);
        hashMap.put("totalBytes", Integer.toString(this.zzewr));
        this.zzewt.zza((zzbfk) "onPrecacheEvent", (String) hashMap);
    }
}
