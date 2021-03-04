package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Size;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.measurement.internal.zzai;
import java.lang.reflect.InvocationTargetException;

public final class zzq extends zzcr {
    private Boolean zzagw;
    @NonNull
    private zzs zzagx = zzr.zzagy;
    private Boolean zzyk;

    zzq(zzbw zzbw) {
        super(zzbw);
        zzai.zza(zzbw);
    }

    /* access modifiers changed from: package-private */
    public final void zza(@NonNull zzs zzs) {
        this.zzagx = zzs;
    }

    static String zzhy() {
        return zzai.zzaiu.get();
    }

    @WorkerThread
    public final int zzaq(@Size(min = 1) String str) {
        return zzb(str, zzai.zzaji);
    }

    public final long zzhh() {
        zzgw();
        return 14710;
    }

    public final boolean zzdw() {
        if (this.zzyk == null) {
            synchronized (this) {
                if (this.zzyk == null) {
                    ApplicationInfo applicationInfo = getContext().getApplicationInfo();
                    String myProcessName = ProcessUtils.getMyProcessName();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.zzyk = Boolean.valueOf(str != null && str.equals(myProcessName));
                    }
                    if (this.zzyk == null) {
                        this.zzyk = Boolean.TRUE;
                        zzgt().zzjg().zzby("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzyk.booleanValue();
    }

    @WorkerThread
    public final long zza(String str, @NonNull zzai.zza<Long> zza) {
        if (str == null) {
            return zza.get().longValue();
        }
        String zzf = this.zzagx.zzf(str, zza.getKey());
        if (TextUtils.isEmpty(zzf)) {
            return zza.get().longValue();
        }
        try {
            return zza.get(Long.valueOf(Long.parseLong(zzf))).longValue();
        } catch (NumberFormatException unused) {
            return zza.get().longValue();
        }
    }

    @WorkerThread
    public final int zzb(String str, @NonNull zzai.zza<Integer> zza) {
        if (str == null) {
            return zza.get().intValue();
        }
        String zzf = this.zzagx.zzf(str, zza.getKey());
        if (TextUtils.isEmpty(zzf)) {
            return zza.get().intValue();
        }
        try {
            return zza.get(Integer.valueOf(Integer.parseInt(zzf))).intValue();
        } catch (NumberFormatException unused) {
            return zza.get().intValue();
        }
    }

    @WorkerThread
    public final double zzc(String str, @NonNull zzai.zza<Double> zza) {
        if (str == null) {
            return zza.get().doubleValue();
        }
        String zzf = this.zzagx.zzf(str, zza.getKey());
        if (TextUtils.isEmpty(zzf)) {
            return zza.get().doubleValue();
        }
        try {
            return zza.get(Double.valueOf(Double.parseDouble(zzf))).doubleValue();
        } catch (NumberFormatException unused) {
            return zza.get().doubleValue();
        }
    }

    @WorkerThread
    public final boolean zzd(String str, @NonNull zzai.zza<Boolean> zza) {
        if (str == null) {
            return zza.get().booleanValue();
        }
        String zzf = this.zzagx.zzf(str, zza.getKey());
        if (TextUtils.isEmpty(zzf)) {
            return zza.get().booleanValue();
        }
        return zza.get(Boolean.valueOf(Boolean.parseBoolean(zzf))).booleanValue();
    }

    public final boolean zze(String str, zzai.zza<Boolean> zza) {
        return zzd(str, zza);
    }

    public final boolean zza(zzai.zza<Boolean> zza) {
        return zzd(null, zza);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    @Nullable
    public final Boolean zzar(@Size(min = 1) String str) {
        Preconditions.checkNotEmpty(str);
        try {
            if (getContext().getPackageManager() == null) {
                zzgt().zzjg().zzby("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(getContext()).getApplicationInfo(getContext().getPackageName(), 128);
            if (applicationInfo == null) {
                zzgt().zzjg().zzby("Failed to load metadata: ApplicationInfo is null");
                return null;
            } else if (applicationInfo.metaData == null) {
                zzgt().zzjg().zzby("Failed to load metadata: Metadata bundle is null");
                return null;
            } else if (!applicationInfo.metaData.containsKey(str)) {
                return null;
            } else {
                return Boolean.valueOf(applicationInfo.metaData.getBoolean(str));
            }
        } catch (PackageManager.NameNotFoundException e) {
            zzgt().zzjg().zzg("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    public final boolean zzhz() {
        zzgw();
        Boolean zzar = zzar("firebase_analytics_collection_deactivated");
        return zzar != null && zzar.booleanValue();
    }

    public final Boolean zzia() {
        zzgw();
        return zzar("firebase_analytics_collection_enabled");
    }

    public static long zzib() {
        return zzai.zzajx.get().longValue();
    }

    public static long zzic() {
        return zzai.zzaix.get().longValue();
    }

    public final String zzid() {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, "debug.firebase.analytics.app", "");
        } catch (ClassNotFoundException e) {
            zzgt().zzjg().zzg("Could not find SystemProperties class", e);
            return "";
        } catch (NoSuchMethodException e2) {
            zzgt().zzjg().zzg("Could not find SystemProperties.get() method", e2);
            return "";
        } catch (IllegalAccessException e3) {
            zzgt().zzjg().zzg("Could not access SystemProperties.get()", e3);
            return "";
        } catch (InvocationTargetException e4) {
            zzgt().zzjg().zzg("SystemProperties.get() threw an exception", e4);
            return "";
        }
    }

    public static boolean zzie() {
        return zzai.zzait.get().booleanValue();
    }

    public final boolean zzas(String str) {
        return "1".equals(this.zzagx.zzf(str, "gaia_collection_enabled"));
    }

    public final boolean zzat(String str) {
        return "1".equals(this.zzagx.zzf(str, "measurement.event_sampling_enabled"));
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzau(String str) {
        return zzd(str, zzai.zzakh);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzav(String str) {
        return zzd(str, zzai.zzakj);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzaw(String str) {
        return zzd(str, zzai.zzakk);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzax(String str) {
        return zzd(str, zzai.zzakb);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final String zzay(String str) {
        zzai.zza<String> zza = zzai.zzakc;
        if (str == null) {
            return zza.get();
        }
        return zza.get(this.zzagx.zzf(str, zza.getKey()));
    }

    /* access modifiers changed from: package-private */
    public final boolean zzaz(String str) {
        return zzd(str, zzai.zzakl);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzba(String str) {
        return zzd(str, zzai.zzakm);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzbb(String str) {
        return zzd(str, zzai.zzako);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzbc(String str) {
        return zzd(str, zzai.zzakp);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzbd(String str) {
        return zzd(str, zzai.zzakq);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzbe(String str) {
        return zzd(str, zzai.zzaks);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzif() {
        if (this.zzagw == null) {
            this.zzagw = zzar("app_measurement_lite");
            if (this.zzagw == null) {
                this.zzagw = false;
            }
        }
        if (this.zzagw.booleanValue() || !this.zzada.zzkr()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzbf(String str) {
        return zzd(str, zzai.zzakr);
    }

    @WorkerThread
    static boolean zzig() {
        return zzai.zzakt.get().booleanValue();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzbg(String str) {
        return zzd(str, zzai.zzaku);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzbh(String str) {
        return zzd(str, zzai.zzakv);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzbi(String str) {
        return zzd(str, zzai.zzakw);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzbj(String str) {
        return zzd(str, zzai.zzakx);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzbk(String str) {
        return zzd(str, zzai.zzakz);
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzgf() {
        super.zzgf();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzgg() {
        super.zzgg();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzgh() {
        super.zzgh();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzaf() {
        super.zzaf();
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
