package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.gmsg.zzu;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class zzabo implements zzu<Object> {
    private final /* synthetic */ zzabn zzdan;

    zzabo(zzabn zzabn) {
        this.zzdan = zzabn;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final void zza(Object obj, Map<String, String> map) {
        try {
            this.zzdan.zzdal = Long.valueOf(Long.parseLong(map.get(AppMeasurement.Param.TIMESTAMP)));
        } catch (NumberFormatException unused) {
            zzaxz.e("Failed to call parse unconfirmedClickTimestamp.");
        }
        this.zzdan.zzdak = map.get("id");
        String str = map.get("asset_id");
        if (zzabn.zza(this.zzdan) == null) {
            zzaxz.zzdn("Received unconfirmed click but UnconfirmedClickListener is null.");
            return;
        }
        try {
            zzabn.zza(this.zzdan).onUnconfirmedClickReceived(str);
        } catch (RemoteException e) {
            zzbbd.zzd("#007 Could not call remote method.", e);
        }
    }
}
