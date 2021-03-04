package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public final class zzaad extends zzaac<Boolean> {
    zzaad(int i, String str, Boolean bool) {
        super(i, str, bool, null);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.SharedPreferences$Editor, java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzaac
    public final /* synthetic */ void zza(SharedPreferences.Editor editor, Boolean bool) {
        editor.putBoolean(getKey(), bool.booleanValue());
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzaac
    public final /* synthetic */ Boolean zzb(JSONObject jSONObject) {
        return Boolean.valueOf(jSONObject.optBoolean(getKey(), ((Boolean) zzqv()).booleanValue()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzaac
    public final /* synthetic */ Boolean zza(SharedPreferences sharedPreferences) {
        return Boolean.valueOf(sharedPreferences.getBoolean(getKey(), ((Boolean) zzqv()).booleanValue()));
    }
}
