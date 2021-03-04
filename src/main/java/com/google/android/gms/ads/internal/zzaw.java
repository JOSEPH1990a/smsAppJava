package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.gmsg.zzu;
import com.google.android.gms.internal.ads.zzaxz;
import com.google.android.gms.internal.ads.zzbgg;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

final class zzaw implements zzu<zzbgg> {
    private final /* synthetic */ CountDownLatch zzbpn;

    zzaw(CountDownLatch countDownLatch) {
        this.zzbpn = countDownLatch;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.util.Map] */
    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final /* synthetic */ void zza(zzbgg zzbgg, Map map) {
        zzaxz.zzeo("Adapter returned an ad, but assets substitution failed");
        this.zzbpn.countDown();
        zzbgg.destroy();
    }
}
