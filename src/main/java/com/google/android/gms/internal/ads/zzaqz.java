package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.gmsg.zzu;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public final class zzaqz implements zzu<zzbgg> {
    private final /* synthetic */ zzbgg zzduz;
    private final /* synthetic */ zzbcl zzdva;
    private final /* synthetic */ zzaqt zzdvb;

    zzaqz(zzaqt zzaqt, zzbgg zzbgg, zzbcl zzbcl) {
        this.zzdvb = zzaqt;
        this.zzduz = zzbgg;
        this.zzdva = zzbcl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.util.Map] */
    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final /* synthetic */ void zza(zzbgg zzbgg, Map map) {
        boolean z;
        JSONObject jSONObject;
        try {
            String str = (String) map.get(FirebaseAnalytics.Param.SUCCESS);
            String str2 = (String) map.get("failure");
            if (!TextUtils.isEmpty(str2)) {
                jSONObject = new JSONObject(str2);
                z = false;
            } else {
                jSONObject = new JSONObject(str);
                z = true;
            }
            if (this.zzdvb.zzbqb.equals(jSONObject.optString("ads_id", ""))) {
                this.zzduz.zzb("/nativeAdPreProcess", this);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(FirebaseAnalytics.Param.SUCCESS, z);
                jSONObject2.put("json", jSONObject);
                this.zzdva.set(jSONObject2);
            }
        } catch (Throwable th) {
            zzaxz.zzb("Error while preprocessing json.", th);
            this.zzdva.setException(th);
        }
    }
}
