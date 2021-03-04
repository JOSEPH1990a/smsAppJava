package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public final class zzaah extends zzaac<String> {
    zzaah(int i, String str, String str2) {
        super(i, str, str2, null);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.SharedPreferences$Editor, java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzaac
    public final /* synthetic */ void zza(SharedPreferences.Editor editor, String str) {
        editor.putString(getKey(), str);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzaac
    public final /* synthetic */ String zzb(JSONObject jSONObject) {
        return jSONObject.optString(getKey(), (String) zzqv());
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzaac
    public final /* synthetic */ String zza(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString(getKey(), (String) zzqv());
    }
}
