package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.DownloadManager;

@TargetApi(9)
public class zzayr extends zzayp {
    public zzayr() {
        super();
    }

    @Override // com.google.android.gms.internal.ads.zzayp
    public final int zzzw() {
        return 6;
    }

    @Override // com.google.android.gms.internal.ads.zzayp
    public final int zzzx() {
        return 7;
    }

    @Override // com.google.android.gms.internal.ads.zzayp
    public boolean zza(DownloadManager.Request request) {
        request.setShowRunningNotification(true);
        return true;
    }
}
