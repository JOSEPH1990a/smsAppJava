package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.HashSet;
import java.util.Set;

public final class zzd implements zza {
    private AppMeasurement zzbsq;
    Set<String> zzbtc;
    private AnalyticsConnector.AnalyticsConnectorListener zzbtd;
    private zze zzbte = new zze(this);

    public zzd(AppMeasurement appMeasurement, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.zzbtd = analyticsConnectorListener;
        this.zzbsq = appMeasurement;
        this.zzbsq.registerOnMeasurementEventListener(this.zzbte);
        this.zzbtc = new HashSet();
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final AnalyticsConnector.AnalyticsConnectorListener zztv() {
        return this.zzbtd;
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void registerEventNames(Set<String> set) {
        this.zzbtc.clear();
        Set<String> set2 = this.zzbtc;
        HashSet hashSet = new HashSet();
        for (String str : set) {
            if (hashSet.size() >= 50) {
                break;
            } else if (zzc.zzfw(str) && zzc.zzfv(str)) {
                hashSet.add(zzc.zzfy(str));
            }
        }
        set2.addAll(hashSet);
    }

    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void unregisterEventNames() {
        this.zzbtc.clear();
    }
}
