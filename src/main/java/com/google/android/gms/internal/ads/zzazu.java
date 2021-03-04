package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzbv;

/* access modifiers changed from: package-private */
public final class zzazu implements zzbbl<Throwable, T> {
    private final /* synthetic */ zzazy zzemz;

    zzazu(zzazs zzazs, zzazy zzazy) {
        this.zzemz = zzazy;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzbbl
    public final /* synthetic */ zzbcb zzf(Throwable th) throws Exception {
        Throwable th2 = th;
        zzaxz.zzb("Error occurred while dispatching http response in getter.", th2);
        zzbv.zzlj().zza(th2, "HttpGetter.deliverResponse.1");
        return zzbbq.zzm(this.zzemz.zzwf());
    }
}
