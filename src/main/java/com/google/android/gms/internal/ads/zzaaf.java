package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public final class zzaaf extends zzaac<Long> {
    zzaaf(int i, String str, Long l) {
        super(i, str, l, null);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.SharedPreferences$Editor, java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzaac
    public final /* synthetic */ void zza(SharedPreferences.Editor editor, Long l) {
        editor.putLong(getKey(), l.longValue());
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzaac
    public final /* synthetic */ Long zzb(JSONObject jSONObject) {
        return Long.valueOf(jSONObject.optLong(getKey(), ((Long) zzqv()).longValue()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzaac
    public final /* synthetic */ Long zza(SharedPreferences sharedPreferences) {
        return Long.valueOf(sharedPreferences.getLong(getKey(), ((Long) zzqv()).longValue()));
    }
}
