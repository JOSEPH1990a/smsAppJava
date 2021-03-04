package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient;

/* access modifiers changed from: package-private */
public final class zztt implements BaseGmsClient.BaseConnectionCallbacks {
    private final /* synthetic */ zztq zzbzt;

    zztt(zztq zztq) {
        this.zzbzt = zztq;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        synchronized (this.zzbzt.mLock) {
            try {
                if (this.zzbzt.zzbzr != null) {
                    this.zzbzt.zzbzs = this.zzbzt.zzbzr.zzoh();
                }
            } catch (DeadObjectException e) {
                zzaxz.zzb("Unable to obtain a cache service instance.", e);
                this.zzbzt.disconnect();
            }
            this.zzbzt.mLock.notifyAll();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        synchronized (this.zzbzt.mLock) {
            this.zzbzt.zzbzs = null;
            this.zzbzt.mLock.notifyAll();
        }
    }
}
