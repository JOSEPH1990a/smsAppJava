package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.AppMeasurement;

/* access modifiers changed from: package-private */
public final class zzdi implements Runnable {
    private final /* synthetic */ zzda zzare;
    private final /* synthetic */ AppMeasurement.ConditionalUserProperty zzarl;

    zzdi(zzda zzda, AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        this.zzare = zzda;
        this.zzarl = conditionalUserProperty;
    }

    public final void run() {
        this.zzare.zzb((zzda) this.zzarl);
    }
}
