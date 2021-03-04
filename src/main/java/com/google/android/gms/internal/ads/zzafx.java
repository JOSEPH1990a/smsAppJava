package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zzafx implements BaseGmsClient.BaseConnectionCallbacks {
    private final /* synthetic */ zzbcl zzcaf;
    private final /* synthetic */ zzaft zzdgo;

    zzafx(zzaft zzaft, zzbcl zzbcl) {
        this.zzdgo = zzaft;
        this.zzcaf = zzbcl;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        try {
            this.zzcaf.set(zzaft.zzb(this.zzdgo).zzte());
        } catch (DeadObjectException e) {
            this.zzcaf.setException(e);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        zzbcl zzbcl = this.zzcaf;
        StringBuilder sb = new StringBuilder(34);
        sb.append("onConnectionSuspended: ");
        sb.append(i);
        zzbcl.setException(new RuntimeException(sb.toString()));
    }
}
