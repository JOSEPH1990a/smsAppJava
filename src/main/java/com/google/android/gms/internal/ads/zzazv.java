package com.google.android.gms.internal.ads;

import java.io.ByteArrayInputStream;

/* access modifiers changed from: package-private */
public final class zzazv implements zzbbm<zzp, T> {
    private final /* synthetic */ zzazy zzemz;

    zzazv(zzazs zzazs, zzazy zzazy) {
        this.zzemz = zzazy;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzbbm
    public final /* synthetic */ Object apply(zzp zzp) {
        return this.zzemz.zze(new ByteArrayInputStream(zzp.data));
    }
}
