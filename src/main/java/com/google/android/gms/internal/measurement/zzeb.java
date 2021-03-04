package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzea;
import java.util.HashMap;

final class zzeb extends zzea.zzb {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ String zzads;
    private final /* synthetic */ String zzadt;
    private final /* synthetic */ Bundle zzadu;
    private final /* synthetic */ zzea zzadv;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzeb(zzea zzea, Context context, String str, String str2, Bundle bundle) {
        super(zzea);
        this.zzadv = zzea;
        this.val$context = context;
        this.zzads = str;
        this.zzadt = str2;
        this.zzadu = bundle;
    }

    @Override // com.google.android.gms.internal.measurement.zzea.zzb
    public final void zzgd() {
        String str;
        String str2;
        String str3;
        try {
            zzea.zza(this.zzadv, new HashMap());
            zzea.zza(this.zzadv, this.zzadv.zzg(this.val$context));
            if (zzea.zzb(this.zzadv) == null) {
                Log.w(zzea.zzc(this.zzadv), "Failed to connect to measurement client.");
                return;
            }
            if (zzea.zza(this.zzadv, this.zzads, this.zzadt)) {
                String str4 = this.zzadt;
                str2 = this.zzads;
                str = str4;
                str3 = zzea.zzc(this.zzadv);
            } else {
                str3 = null;
                str2 = null;
                str = null;
            }
            int zzj = zzea.zzj(this.val$context);
            int zzk = zzea.zzk(this.val$context);
            zzea.zzb(this.zzadv).initialize(ObjectWrapper.wrap(this.val$context), new zzdy(13001, (long) Math.max(zzj, zzk), zzk < zzj, str3, str2, str, this.zzadu), this.timestamp);
        } catch (RemoteException e) {
            zzea.zza(this.zzadv, (Exception) e, true, false);
        }
    }
}
