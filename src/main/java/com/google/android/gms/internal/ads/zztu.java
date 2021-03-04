package com.google.android.gms.internal.ads;

import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* access modifiers changed from: package-private */
public final class zztu implements BaseGmsClient.BaseOnConnectionFailedListener {
    private final /* synthetic */ zztq zzbzt;

    zztu(zztq zztq) {
        this.zzbzt = zztq;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        synchronized (this.zzbzt.mLock) {
            this.zzbzt.zzbzs = null;
            if (this.zzbzt.zzbzr != null) {
                this.zzbzt.zzbzr = null;
            }
            this.zzbzt.mLock.notifyAll();
        }
    }
}
