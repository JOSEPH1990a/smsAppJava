package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.http.SslError;

@TargetApi(14)
public class zzayu extends zzays {
    @Override // com.google.android.gms.internal.ads.zzayp
    public int zzaab() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzayp
    public final String zza(SslError sslError) {
        return sslError.getUrl();
    }
}
