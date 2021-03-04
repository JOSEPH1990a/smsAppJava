package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* access modifiers changed from: package-private */
public final class zzg implements AppMeasurement.OnEventListener {
    private final /* synthetic */ zzf zzbth;

    public zzg(zzf zzf) {
        this.zzbth = zzf;
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.OnEventListener, com.google.android.gms.measurement.internal.zzcy
    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        if (str != null && !str.equals(AppMeasurement.CRASH_ORIGIN) && zzc.zzfu(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, str2);
            bundle2.putLong("timestampInMillis", j);
            bundle2.putBundle("params", bundle);
            this.zzbth.zzbtd.onMessageTriggered(3, bundle2);
        }
    }
}
