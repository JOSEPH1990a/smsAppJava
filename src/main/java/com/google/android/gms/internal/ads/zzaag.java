package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public final class zzaag extends zzaac<Float> {
    zzaag(int i, String str, Float f) {
        super(i, str, f, null);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.SharedPreferences$Editor, java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzaac
    public final /* synthetic */ void zza(SharedPreferences.Editor editor, Float f) {
        editor.putFloat(getKey(), f.floatValue());
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzaac
    public final /* synthetic */ Float zzb(JSONObject jSONObject) {
        return Float.valueOf((float) jSONObject.optDouble(getKey(), (double) ((Float) zzqv()).floatValue()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzaac
    public final /* synthetic */ Float zza(SharedPreferences sharedPreferences) {
        return Float.valueOf(sharedPreferences.getFloat(getKey(), ((Float) zzqv()).floatValue()));
    }
}
