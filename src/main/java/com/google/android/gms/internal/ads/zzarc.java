package com.google.android.gms.internal.ads;

import org.json.JSONObject;

final class zzarc implements zzbbn<zzbgg> {
    private final /* synthetic */ String val$message;
    private final /* synthetic */ JSONObject zzdve;

    zzarc(zzaqt zzaqt, String str, JSONObject jSONObject) {
        this.val$message = str;
        this.zzdve = jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzbbn
    public final void zzb(Throwable th) {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzbbn
    public final /* synthetic */ void zzl(zzbgg zzbgg) {
        zzbgg.zza(this.val$message, this.zzdve);
    }
}
