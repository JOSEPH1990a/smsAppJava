package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
public final class zzapv implements zzaqe<zzabq> {
    /* Return type fixed from 'com.google.android.gms.internal.ads.zzacf' to match base method */
    @Override // com.google.android.gms.internal.ads.zzaqe
    public final /* synthetic */ zzabq zza(zzapw zzapw, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        zzbcb<zzbgg> zzbcb;
        JSONObject zza = zzbac.zza(jSONObject, "html_containers", "instream");
        if (zza == null) {
            zzbcb = zzapw.zzc(jSONObject, "video");
        } else {
            zzbcb = zzapw.zza(zza.optString("base_url"), zza.optString("html"), true);
        }
        zzbgg zzc = zzapw.zzc(zzbcb);
        if (zzc != null) {
            return new zzabq(zzc);
        }
        zzaxz.zzeo("Can not get video view for instream ad.");
        return null;
    }
}
