package com.google.android.gms.internal.ads;

import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* access modifiers changed from: package-private */
public final class zzuk implements BaseGmsClient.BaseOnConnectionFailedListener {
    private final /* synthetic */ zzue zzcad;
    private final /* synthetic */ zzbcl zzcaf;

    zzuk(zzue zzue, zzbcl zzbcl) {
        this.zzcad = zzue;
        this.zzcaf = zzbcl;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        synchronized (zzue.zzb(this.zzcad)) {
            this.zzcaf.setException(new RuntimeException("Connection failed."));
        }
    }
}
