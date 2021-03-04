package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;

/* access modifiers changed from: package-private */
public final class zzta implements ValueCallback<String> {
    private final /* synthetic */ zzsz zzbyp;

    zzta(zzsz zzsz) {
        this.zzbyp = zzsz;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(String str) {
        this.zzbyp.zzbyk.zza(this.zzbyp.zzbym, this.zzbyp.zzbyn, str, this.zzbyp.zzbyo);
    }
}
