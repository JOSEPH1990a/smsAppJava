package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

public final class zzbi {
    private String value;
    private boolean zzans;
    private final /* synthetic */ zzbd zzant;
    private final String zzany = null;
    private final String zzoj;

    public zzbi(zzbd zzbd, String str, String str2) {
        this.zzant = zzbd;
        Preconditions.checkNotEmpty(str);
        this.zzoj = str;
    }

    @WorkerThread
    public final String zzkd() {
        if (!this.zzans) {
            this.zzans = true;
            this.value = this.zzant.zzju().getString(this.zzoj, null);
        }
        return this.value;
    }

    @WorkerThread
    public final void zzcd(String str) {
        if (!zzfy.zzv(str, this.value)) {
            SharedPreferences.Editor edit = this.zzant.zzju().edit();
            edit.putString(this.zzoj, str);
            edit.apply();
            this.value = str;
        }
    }
}
