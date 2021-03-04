package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.AppMeasurement;

/* access modifiers changed from: package-private */
public final class zzdj implements Runnable {
    private final /* synthetic */ zzda zzare;
    private final /* synthetic */ AppMeasurement.ConditionalUserProperty zzarl;

    zzdj(zzda zzda, AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        this.zzare = zzda;
        this.zzarl = conditionalUserProperty;
    }

    public final void run() {
        this.zzare.zzc(this.zzarl);
    }
}
