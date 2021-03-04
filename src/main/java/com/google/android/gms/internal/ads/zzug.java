package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient;

/* access modifiers changed from: package-private */
public final class zzug implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ zzue zzcad;
    private final /* synthetic */ zzty zzcae;
    private final /* synthetic */ zzbcl zzcaf;

    zzug(zzue zzue, zzty zzty, zzbcl zzbcl) {
        this.zzcad = zzue;
        this.zzcae = zzty;
        this.zzcaf = zzbcl;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        synchronized (zzue.zzb(this.zzcad)) {
            if (!zzue.zzc(this.zzcad)) {
                zzue.zza(this.zzcad, true);
                zztx zzd = zzue.zzd(this.zzcad);
                if (zzd != null) {
                    this.zzcaf.zza(new zzui(this.zzcaf, zzayf.zzc(new zzuh(this, zzd, this.zzcae, this.zzcaf))), zzbcg.zzepp);
                }
            }
        }
    }
}
