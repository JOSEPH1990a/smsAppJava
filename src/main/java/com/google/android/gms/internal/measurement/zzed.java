package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzea;

/* access modifiers changed from: package-private */
public final class zzed extends zzea.zzb {
    private final /* synthetic */ String zzads;
    private final /* synthetic */ zzea zzadv;
    private final /* synthetic */ String zzadz;
    private final /* synthetic */ zzea.zza zzaea;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzed(zzea zzea, String str, String str2, zzea.zza zza) {
        super(zzea);
        this.zzadv = zzea;
        this.zzads = str;
        this.zzadz = str2;
        this.zzaea = zza;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzea.zzb
    public final void zzgd() throws RemoteException {
        zzea.zzb(this.zzadv).getConditionalUserProperties(this.zzads, this.zzadz, this.zzaea);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzea.zzb
    public final void zzge() {
        this.zzaea.zzb(null);
    }
}
