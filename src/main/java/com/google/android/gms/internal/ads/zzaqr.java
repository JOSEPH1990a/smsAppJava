package com.google.android.gms.internal.ads;

import android.content.res.Resources;
import android.os.Bundle;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.zzbv;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
public final class zzaqr implements zzaqe<zzabu> {
    private final boolean zzdmt;
    private final boolean zzdut;
    private final boolean zzduu;

    public zzaqr(boolean z, boolean z2, boolean z3) {
        this.zzdut = z;
        this.zzduu = z2;
        this.zzdmt = z3;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzacf' to match base method */
    @Override // com.google.android.gms.internal.ads.zzaqe
    public final /* synthetic */ zzabu zza(zzapw zzapw, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        String str;
        List<zzbcb<zzabr>> zza = zzapw.zza(jSONObject, "images", false, this.zzdut, this.zzduu);
        zzbcb<zzabr> zza2 = zzapw.zza(jSONObject, "secondary_image", false, this.zzdut);
        zzbcb<zzabm> zzg = zzapw.zzg(jSONObject);
        zzbcb<zzbgg> zzc = zzapw.zzc(jSONObject, "video");
        ArrayList arrayList = new ArrayList();
        for (zzbcb<zzabr> zzbcb : zza) {
            arrayList.add((zzabr) zzbcb.get());
        }
        zzbgg zzc2 = zzapw.zzc(zzc);
        String string = jSONObject.getString("headline");
        if (this.zzdmt) {
            Resources resources = zzbv.zzlj().getResources();
            str = resources != null ? resources.getString(R.string.s7) : "Test Ad";
            if (string != null) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(string).length());
                sb.append(str);
                sb.append(" : ");
                sb.append(string);
                str = sb.toString();
            }
        } else {
            str = string;
        }
        return new zzabu(str, arrayList, jSONObject.getString("body"), (zzadb) zza2.get(), jSONObject.getString("call_to_action"), jSONObject.getString("advertiser"), (zzabm) zzg.get(), new Bundle(), zzc2 != null ? zzc2.zzabu() : null, zzc2 != null ? zzc2.getView() : null, null, null);
    }
}
