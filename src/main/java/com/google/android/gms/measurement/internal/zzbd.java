package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.util.VisibleForTesting;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

/* access modifiers changed from: package-private */
public final class zzbd extends zzcs {
    @VisibleForTesting
    static final Pair<String, Long> zzamy = new Pair<>("", 0L);
    private SharedPreferences zzabr;
    public zzbh zzamz;
    public final zzbg zzana = new zzbg(this, "last_upload", 0);
    public final zzbg zzanb = new zzbg(this, "last_upload_attempt", 0);
    public final zzbg zzanc = new zzbg(this, "backoff", 0);
    public final zzbg zzand = new zzbg(this, "last_delete_stale", 0);
    public final zzbg zzane = new zzbg(this, "midnight_offset", 0);
    public final zzbg zzanf = new zzbg(this, "first_open_time", 0);
    public final zzbg zzang = new zzbg(this, "app_install_time", 0);
    public final zzbi zzanh = new zzbi(this, "app_instance_id", null);
    private String zzani;
    private boolean zzanj;
    private long zzank;
    public final zzbg zzanl = new zzbg(this, "time_before_start", 10000);
    public final zzbg zzanm = new zzbg(this, "session_timeout", 1800000);
    public final zzbf zzann = new zzbf(this, "start_new_session", true);
    public final zzbg zzano = new zzbg(this, "last_pause_time", 0);
    public final zzbg zzanp = new zzbg(this, "time_active", 0);
    public boolean zzanq;

    /* access modifiers changed from: package-private */
    @WorkerThread
    @NonNull
    public final Pair<String, Boolean> zzbz(String str) {
        zzaf();
        long elapsedRealtime = zzbx().elapsedRealtime();
        String str2 = this.zzani;
        if (str2 != null && elapsedRealtime < this.zzank) {
            return new Pair<>(str2, Boolean.valueOf(this.zzanj));
        }
        this.zzank = elapsedRealtime + zzgv().zza(str, zzai.zzaiv);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(getContext());
            if (advertisingIdInfo != null) {
                this.zzani = advertisingIdInfo.getId();
                this.zzanj = advertisingIdInfo.isLimitAdTrackingEnabled();
            }
            if (this.zzani == null) {
                this.zzani = "";
            }
        } catch (Exception e) {
            zzgt().zzjn().zzg("Unable to get advertising id", e);
            this.zzani = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(this.zzani, Boolean.valueOf(this.zzanj));
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.measurement.internal.zzcs
    public final boolean zzgy() {
        return true;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final String zzca(String str) {
        zzaf();
        String str2 = (String) zzbz(str).first;
        MessageDigest messageDigest = zzfy.getMessageDigest();
        if (messageDigest == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, messageDigest.digest(str2.getBytes())));
    }

    zzbd(zzbw zzbw) {
        super(zzbw);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.measurement.internal.zzcs
    @WorkerThread
    public final void zzgz() {
        this.zzabr = getContext().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.zzanq = this.zzabr.getBoolean("has_been_opened", false);
        if (!this.zzanq) {
            SharedPreferences.Editor edit = this.zzabr.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        this.zzamz = new zzbh(this, "health_monitor", Math.max(0L, zzai.zzaiw.get().longValue()));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final SharedPreferences zzju() {
        zzaf();
        zzcl();
        return this.zzabr;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzcb(String str) {
        zzaf();
        SharedPreferences.Editor edit = zzju().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final String zzjv() {
        zzaf();
        return zzju().getString("gmp_app_id", null);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzcc(String str) {
        zzaf();
        SharedPreferences.Editor edit = zzju().edit();
        edit.putString("admob_app_id", str);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final String zzjw() {
        zzaf();
        return zzju().getString("admob_app_id", null);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final Boolean zzjx() {
        zzaf();
        if (!zzju().contains("use_service")) {
            return null;
        }
        return Boolean.valueOf(zzju().getBoolean("use_service", false));
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzg(boolean z) {
        zzaf();
        zzgt().zzjo().zzg("Setting useService", Boolean.valueOf(z));
        SharedPreferences.Editor edit = zzju().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzjy() {
        zzaf();
        zzgt().zzjo().zzby("Clearing collection preferences.");
        if (zzgv().zza(zzai.zzalc)) {
            Boolean zzjz = zzjz();
            SharedPreferences.Editor edit = zzju().edit();
            edit.clear();
            edit.apply();
            if (zzjz != null) {
                setMeasurementEnabled(zzjz.booleanValue());
                return;
            }
            return;
        }
        boolean contains = zzju().contains("measurement_enabled");
        boolean z = true;
        if (contains) {
            z = zzh(true);
        }
        SharedPreferences.Editor edit2 = zzju().edit();
        edit2.clear();
        edit2.apply();
        if (contains) {
            setMeasurementEnabled(z);
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void setMeasurementEnabled(boolean z) {
        zzaf();
        zzgt().zzjo().zzg("Setting measurementEnabled", Boolean.valueOf(z));
        SharedPreferences.Editor edit = zzju().edit();
        edit.putBoolean("measurement_enabled", z);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzh(boolean z) {
        zzaf();
        return zzju().getBoolean("measurement_enabled", z);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final Boolean zzjz() {
        zzaf();
        if (zzju().contains("measurement_enabled")) {
            return Boolean.valueOf(zzju().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final String zzka() {
        zzaf();
        String string = zzju().getString("previous_os_version", null);
        zzgp().zzcl();
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str) && !str.equals(string)) {
            SharedPreferences.Editor edit = zzju().edit();
            edit.putString("previous_os_version", str);
            edit.apply();
        }
        return string;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzi(boolean z) {
        zzaf();
        zzgt().zzjo().zzg("Updating deferred analytics collection", Boolean.valueOf(z));
        SharedPreferences.Editor edit = zzju().edit();
        edit.putBoolean("deferred_analytics_collection", z);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzkb() {
        zzaf();
        return zzju().getBoolean("deferred_analytics_collection", false);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzkc() {
        return this.zzabr.contains("deferred_analytics_collection");
    }

    /* access modifiers changed from: package-private */
    public final boolean zzaf(long j) {
        return j - this.zzanm.get() > this.zzano.get();
    }
}
