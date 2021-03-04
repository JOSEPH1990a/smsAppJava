package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzea;

/* access modifiers changed from: package-private */
public final class zzev extends zzea.zzb {
    private final /* synthetic */ String val$name;
    private final /* synthetic */ String zzads;
    private final /* synthetic */ zzea zzadv;
    private final /* synthetic */ boolean zzaeq = true;
    private final /* synthetic */ Object zzaes;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzev(zzea zzea, String str, String str2, Object obj, boolean z) {
        super(zzea);
        this.zzadv = zzea;
        this.zzads = str;
        this.val$name = str2;
        this.zzaes = obj;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzea.zzb
    public final void zzgd() throws RemoteException {
        zzea.zzb(this.zzadv).setUserProperty(this.zzads, this.val$name, ObjectWrapper.wrap(this.zzaes), this.zzaeq, this.timestamp);
    }
}
