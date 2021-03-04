package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.gmsg.zzu;
import com.google.android.gms.internal.ads.zzbgg;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

final class zzav implements zzu<zzbgg> {
    private final /* synthetic */ CountDownLatch zzbpn;

    zzav(CountDownLatch countDownLatch) {
        this.zzbpn = countDownLatch;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.util.Map] */
    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final /* synthetic */ void zza(zzbgg zzbgg, Map map) {
        this.zzbpn.countDown();
        zzbgg.getView().setVisibility(0);
    }
}
