package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.Set;

public final class zzf implements zza {
    private AppMeasurement zzbsq;
    private AnalyticsConnector.AnalyticsConnectorListener zzbtd;
    private zzg zzbtg = new zzg(this);

    public zzf(AppMeasurement appMeasurement, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.zzbtd = analyticsConnectorListener;
        this.zzbsq = appMeasurement;
        this.zzbsq.registerOnMeasurementEventListener(this.zzbtg);
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void registerEventNames(Set<String> set) {
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void unregisterEventNames() {
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final AnalyticsConnector.AnalyticsConnectorListener zztv() {
        return this.zzbtd;
    }
}
