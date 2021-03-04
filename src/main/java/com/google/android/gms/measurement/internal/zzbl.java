package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zzu;
import com.google.firebase.analytics.FirebaseAnalytics;

final class zzbl implements Runnable {
    private final /* synthetic */ zzu zzaoa;
    private final /* synthetic */ ServiceConnection zzaob;
    private final /* synthetic */ zzbk zzaoc;

    zzbl(zzbk zzbk, zzu zzu, ServiceConnection serviceConnection) {
        this.zzaoc = zzbk;
        this.zzaoa = zzu;
        this.zzaob = serviceConnection;
    }

    public final void run() {
        zzbj zzbj = this.zzaoc.zzanz;
        String str = this.zzaoc.packageName;
        zzu zzu = this.zzaoa;
        ServiceConnection serviceConnection = this.zzaob;
        Bundle zza = zzbj.zza(str, zzu);
        zzbj.zzada.zzgs().zzaf();
        if (zza != null) {
            long j = zza.getLong("install_begin_timestamp_seconds", 0) * 1000;
            if (j == 0) {
                zzbj.zzada.zzgt().zzjg().zzby("Service response is missing Install Referrer install timestamp");
            } else {
                String string = zza.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    zzbj.zzada.zzgt().zzjg().zzby("No referrer defined in install referrer response");
                } else {
                    zzbj.zzada.zzgt().zzjo().zzg("InstallReferrer API result", string);
                    zzfy zzgr = zzbj.zzada.zzgr();
                    String valueOf = String.valueOf(string);
                    Bundle zza2 = zzgr.zza(Uri.parse(valueOf.length() != 0 ? "?".concat(valueOf) : new String("?")));
                    if (zza2 == null) {
                        zzbj.zzada.zzgt().zzjg().zzby("No campaign params defined in install referrer result");
                    } else {
                        String string2 = zza2.getString(FirebaseAnalytics.Param.MEDIUM);
                        if (string2 != null && !"(not set)".equalsIgnoreCase(string2) && !"organic".equalsIgnoreCase(string2)) {
                            long j2 = zza.getLong("referrer_click_timestamp_seconds", 0) * 1000;
                            if (j2 == 0) {
                                zzbj.zzada.zzgt().zzjg().zzby("Install Referrer is missing click timestamp for ad campaign");
                            } else {
                                zza2.putLong("click_timestamp", j2);
                            }
                        }
                        if (j == zzbj.zzada.zzgu().zzang.get()) {
                            zzbj.zzada.zzgw();
                            zzbj.zzada.zzgt().zzjo().zzby("Campaign has already been logged");
                        } else {
                            zzbj.zzada.zzgu().zzang.set(j);
                            zzbj.zzada.zzgw();
                            zzbj.zzada.zzgt().zzjo().zzg("Logging Install Referrer campaign from sdk with ", "referrer API");
                            zza2.putString("_cis", "referrer API");
                            zzbj.zzada.zzgj().logEvent("auto", "_cmp", zza2);
                        }
                    }
                }
            }
        }
        if (serviceConnection != null) {
            ConnectionTracker.getInstance().unbindService(zzbj.zzada.getContext(), serviceConnection);
        }
    }
}
