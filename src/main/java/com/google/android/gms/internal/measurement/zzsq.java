package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;

/* access modifiers changed from: package-private */
public final /* synthetic */ class zzsq implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final zzsp zzbsc;

    zzsq(zzsp zzsp) {
        this.zzbsc = zzsp;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        this.zzbsc.zza(sharedPreferences, str);
    }
}
