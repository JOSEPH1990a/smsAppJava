package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzea;

/* access modifiers changed from: package-private */
public final class zzeg extends zzea.zzb {
    private final /* synthetic */ zzea zzadv;
    private final /* synthetic */ String zzaee;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzeg(zzea zzea, String str) {
        super(zzea);
        this.zzadv = zzea;
        this.zzaee = str;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzea.zzb
    public final void zzgd() throws RemoteException {
        zzea.zzb(this.zzadv).beginAdUnitExposure(this.zzaee, this.zzaev);
    }
}
