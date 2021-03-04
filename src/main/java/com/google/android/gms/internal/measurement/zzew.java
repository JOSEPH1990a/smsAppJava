package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzea;

/* access modifiers changed from: package-private */
public final class zzew extends zzea.zzb {
    private final /* synthetic */ zzea zzadv;
    private final /* synthetic */ Bundle zzaem;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzew(zzea zzea, Bundle bundle) {
        super(zzea);
        this.zzadv = zzea;
        this.zzaem = bundle;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzea.zzb
    public final void zzgd() throws RemoteException {
        zzea.zzb(this.zzadv).setConditionalUserProperty(this.zzaem, this.timestamp);
    }
}
