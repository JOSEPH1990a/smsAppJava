package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzea;
import com.google.android.gms.measurement.internal.zzcx;

/* access modifiers changed from: package-private */
public final class zzei extends zzea.zzb {
    private final /* synthetic */ zzea zzadv;
    private final /* synthetic */ zzcx zzaef;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzei(zzea zzea, zzcx zzcx) {
        super(zzea);
        this.zzadv = zzea;
        this.zzaef = zzcx;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzea.zzb
    public final void zzgd() throws RemoteException {
        zzea.zzb(this.zzadv).setEventInterceptor(new zzea.zzc(this.zzaef));
    }
}
