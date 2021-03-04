package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzea;

final class zzeu extends zzea.zzb {
    private final /* synthetic */ String val$name;
    private final /* synthetic */ String zzads;
    private final /* synthetic */ zzea zzadv;
    private final /* synthetic */ Long zzaeo;
    private final /* synthetic */ Bundle zzaep;
    private final /* synthetic */ boolean zzaeq = true;
    private final /* synthetic */ boolean zzaer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzeu(zzea zzea, Long l, String str, String str2, Bundle bundle, boolean z, boolean z2) {
        super(zzea);
        this.zzadv = zzea;
        this.zzaeo = l;
        this.zzads = str;
        this.val$name = str2;
        this.zzaep = bundle;
        this.zzaer = z2;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzea.zzb
    public final void zzgd() throws RemoteException {
        Long l = this.zzaeo;
        zzea.zzb(this.zzadv).logEvent(this.zzads, this.val$name, this.zzaep, this.zzaeq, this.zzaer, l == null ? this.timestamp : l.longValue());
    }
}
