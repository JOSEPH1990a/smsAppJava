package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Size;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Map;

public final class zzdy extends zzf {
    @VisibleForTesting
    protected zzdx zzarq;
    private volatile zzdx zzarr;
    private zzdx zzars;
    private final Map<Activity, zzdx> zzart = new ArrayMap();
    private zzdx zzaru;
    private String zzarv;

    public zzdy(zzbw zzbw) {
        super(zzbw);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.measurement.internal.zzf
    public final boolean zzgy() {
        return false;
    }

    @WorkerThread
    public final zzdx zzle() {
        zzcl();
        zzaf();
        return this.zzarq;
    }

    public final void setCurrentScreen(@NonNull Activity activity, @Size(max = 36, min = 1) @Nullable String str, @Size(max = 36, min = 1) @Nullable String str2) {
        if (this.zzarr == null) {
            zzgt().zzjj().zzby("setCurrentScreen cannot be called while no activity active");
        } else if (this.zzart.get(activity) == null) {
            zzgt().zzjj().zzby("setCurrentScreen must be called with an activity in the activity lifecycle");
        } else {
            if (str2 == null) {
                str2 = zzcq(activity.getClass().getCanonicalName());
            }
            boolean equals = this.zzarr.zzarn.equals(str2);
            boolean zzv = zzfy.zzv(this.zzarr.zzuw, str);
            if (equals && zzv) {
                zzgt().zzjl().zzby("setCurrentScreen cannot be called with the same class and name");
            } else if (str != null && (str.length() <= 0 || str.length() > 100)) {
                zzgt().zzjj().zzg("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            } else if (str2 == null || (str2.length() > 0 && str2.length() <= 100)) {
                zzgt().zzjo().zze("Setting current screen to name, class", str == null ? "null" : str, str2);
                zzdx zzdx = new zzdx(str, str2, zzgr().zzmj());
                this.zzart.put(activity, zzdx);
                zza(activity, zzdx, true);
            } else {
                zzgt().zzjj().zzg("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            }
        }
    }

    public final zzdx zzlf() {
        zzgg();
        return this.zzarr;
    }

    @MainThread
    private final void zza(Activity activity, zzdx zzdx, boolean z) {
        zzdx zzdx2 = this.zzarr == null ? this.zzars : this.zzarr;
        if (zzdx.zzarn == null) {
            zzdx = new zzdx(zzdx.zzuw, zzcq(activity.getClass().getCanonicalName()), zzdx.zzaro);
        }
        this.zzars = this.zzarr;
        this.zzarr = zzdx;
        zzgs().zzc(new zzdz(this, z, zzdx2, zzdx));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(@NonNull zzdx zzdx, boolean z) {
        zzgi().zzm(zzbx().elapsedRealtime());
        if (zzgo().zza(zzdx.zzarp, z)) {
            zzdx.zzarp = false;
        }
    }

    public static void zza(zzdx zzdx, Bundle bundle, boolean z) {
        if (bundle != null && zzdx != null && (!bundle.containsKey("_sc") || z)) {
            if (zzdx.zzuw != null) {
                bundle.putString("_sn", zzdx.zzuw);
            } else {
                bundle.remove("_sn");
            }
            bundle.putString("_sc", zzdx.zzarn);
            bundle.putLong("_si", zzdx.zzaro);
        } else if (bundle != null && zzdx == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    @WorkerThread
    public final void zza(String str, zzdx zzdx) {
        zzaf();
        synchronized (this) {
            if (this.zzarv == null || this.zzarv.equals(str) || zzdx != null) {
                this.zzarv = str;
                this.zzaru = zzdx;
            }
        }
    }

    @VisibleForTesting
    private static String zzcq(String str) {
        String[] split = str.split("\\.");
        String str2 = split.length > 0 ? split[split.length - 1] : "";
        return str2.length() > 100 ? str2.substring(0, 100) : str2;
    }

    @MainThread
    private final zzdx zze(@NonNull Activity activity) {
        Preconditions.checkNotNull(activity);
        zzdx zzdx = this.zzart.get(activity);
        if (zzdx != null) {
            return zzdx;
        }
        zzdx zzdx2 = new zzdx(null, zzcq(activity.getClass().getCanonicalName()), zzgr().zzmj());
        this.zzart.put(activity, zzdx2);
        return zzdx2;
    }

    @MainThread
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (bundle != null && (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) != null) {
            this.zzart.put(activity, new zzdx(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME), bundle2.getString("referrer_name"), bundle2.getLong("id")));
        }
    }

    @MainThread
    public final void onActivityResumed(Activity activity) {
        zza(activity, zze(activity), false);
        zza zzgi = zzgi();
        zzgi.zzgs().zzc(new zzd(zzgi, zzgi.zzbx().elapsedRealtime()));
    }

    @MainThread
    public final void onActivityPaused(Activity activity) {
        zzdx zze = zze(activity);
        this.zzars = this.zzarr;
        this.zzarr = null;
        zzgs().zzc(new zzea(this, zze));
    }

    @MainThread
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzdx zzdx;
        if (bundle != null && (zzdx = this.zzart.get(activity)) != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("id", zzdx.zzaro);
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, zzdx.zzuw);
            bundle2.putString("referrer_name", zzdx.zzarn);
            bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
        }
    }

    @MainThread
    public final void onActivityDestroyed(Activity activity) {
        this.zzart.remove(activity);
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ void zzgf() {
        super.zzgf();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ void zzgg() {
        super.zzgg();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ void zzgh() {
        super.zzgh();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ void zzaf() {
        super.zzaf();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zza zzgi() {
        return super.zzgi();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzda zzgj() {
        return super.zzgj();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzam zzgk() {
        return super.zzgk();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzeb zzgl() {
        return super.zzgl();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzdy zzgm() {
        return super.zzgm();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzao zzgn() {
        return super.zzgn();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzfd zzgo() {
        return super.zzgo();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzaa zzgp() {
        return super.zzgp();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ Clock zzbx() {
        return super.zzbx();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzaq zzgq() {
        return super.zzgq();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzfy zzgr() {
        return super.zzgr();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ zzbr zzgs() {
        return super.zzgs();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ zzas zzgt() {
        return super.zzgt();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzbd zzgu() {
        return super.zzgu();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzq zzgv() {
        return super.zzgv();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ zzn zzgw() {
        return super.zzgw();
    }
}
