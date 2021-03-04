package com.google.android.gms.ads.internal;

import android.webkit.CookieManager;
import java.util.concurrent.Callable;

/* access modifiers changed from: package-private */
public final class zzf implements Callable<String> {
    private final /* synthetic */ zzc zzbmd;

    zzf(zzc zzc) {
        this.zzbmd = zzc;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        CookieManager zzba = zzbv.zzlh().zzba(this.zzbmd.zzbls.zzsp);
        if (zzba != null) {
            return zzba.getCookie("googleads.g.doubleclick.net");
        }
        return "";
    }
}
