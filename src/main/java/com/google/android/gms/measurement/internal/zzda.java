package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v4.app.NotificationCompat;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

public final class zzda extends zzf {
    @VisibleForTesting
    protected zzdu zzaqx;
    private zzcx zzaqy;
    private final Set<zzcy> zzaqz = new CopyOnWriteArraySet();
    private boolean zzara;
    private final AtomicReference<String> zzarb = new AtomicReference<>();
    @VisibleForTesting
    protected boolean zzarc = true;

    protected zzda(zzbw zzbw) {
        super(zzbw);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.measurement.internal.zzf
    public final boolean zzgy() {
        return false;
    }

    public final void zzkw() {
        if (getContext().getApplicationContext() instanceof Application) {
            ((Application) getContext().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zzaqx);
        }
    }

    public final Boolean zzkx() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzgs().zza(atomicReference, 15000, "boolean test flag value", new zzdb(this, atomicReference));
    }

    public final String zzky() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzgs().zza(atomicReference, 15000, "String test flag value", new zzdl(this, atomicReference));
    }

    public final Long zzkz() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzgs().zza(atomicReference, 15000, "long test flag value", new zzdn(this, atomicReference));
    }

    public final Integer zzla() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzgs().zza(atomicReference, 15000, "int test flag value", new zzdo(this, atomicReference));
    }

    public final Double zzlb() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzgs().zza(atomicReference, 15000, "double test flag value", new zzdp(this, atomicReference));
    }

    public final void setMeasurementEnabled(boolean z) {
        zzcl();
        zzgg();
        zzgs().zzc(new zzdq(this, z));
    }

    public final void zzd(boolean z) {
        zzcl();
        zzgg();
        zzgs().zzc(new zzdr(this, z));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzj(boolean z) {
        zzaf();
        zzgg();
        zzcl();
        zzgt().zzjn().zzg("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        zzgu().setMeasurementEnabled(z);
        zzlc();
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzlc() {
        if (!zzgv().zzba(zzgk().zzal()) || !this.zzada.isEnabled() || !this.zzarc) {
            zzgt().zzjn().zzby("Updating Scion state (FE)");
            zzgl().zzlg();
            return;
        }
        zzgt().zzjn().zzby("Recording app launch after enabling measurement for the first time (FE)");
        zzld();
    }

    public final void setMinimumSessionDuration(long j) {
        zzgg();
        zzgs().zzc(new zzds(this, j));
    }

    public final void setSessionTimeoutDuration(long j) {
        zzgg();
        zzgs().zzc(new zzdt(this, j));
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z) {
        logEvent(str, str2, bundle, false, true, zzbx().currentTimeMillis());
    }

    public final void logEvent(String str, String str2, Bundle bundle) {
        logEvent(str, str2, bundle, true, true, zzbx().currentTimeMillis());
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(String str, String str2, Bundle bundle) {
        zzgg();
        zzaf();
        zza(str, str2, zzbx().currentTimeMillis(), bundle);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(String str, String str2, long j, Bundle bundle) {
        zzgg();
        zzaf();
        zza(str, str2, j, bundle, true, this.zzaqy == null || zzfy.zzcy(str2), false, null);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzdx zzdx;
        String[] strArr;
        int i;
        List<String> list;
        int i2;
        long j2;
        ArrayList arrayList;
        int i3;
        String str4 = str2;
        Preconditions.checkNotEmpty(str);
        if (!zzgv().zze(str3, zzai.zzalg)) {
            Preconditions.checkNotEmpty(str2);
        }
        Preconditions.checkNotNull(bundle);
        zzaf();
        zzcl();
        if (!this.zzada.isEnabled()) {
            zzgt().zzjn().zzby("Event not sent since app measurement is disabled");
            return;
        }
        int i4 = 0;
        if (!this.zzara) {
            this.zzara = true;
            try {
                try {
                    Class.forName("com.google.android.gms.tagmanager.TagManagerService").getDeclaredMethod("initialize", Context.class).invoke(null, getContext());
                } catch (Exception e) {
                    zzgt().zzjj().zzg("Failed to invoke Tag Manager's initialize() method", e);
                }
            } catch (ClassNotFoundException unused) {
                zzgt().zzjm().zzby("Tag Manager is not found and thus will not be used");
            }
        }
        if (z3) {
            zzgw();
            if (!"_iap".equals(str4)) {
                zzfy zzgr = this.zzada.zzgr();
                if (!zzgr.zzs(NotificationCompat.CATEGORY_EVENT, str4)) {
                    i3 = 2;
                } else if (!zzgr.zza(NotificationCompat.CATEGORY_EVENT, zzcu.zzaqq, str4)) {
                    i3 = 13;
                } else {
                    i3 = !zzgr.zza(NotificationCompat.CATEGORY_EVENT, 40, str4) ? 2 : 0;
                }
                if (i3 != 0) {
                    zzgt().zzji().zzg("Invalid public event name. Event will not be logged (FE)", zzgq().zzbt(str4));
                    this.zzada.zzgr();
                    this.zzada.zzgr().zza(i3, "_ev", zzfy.zza(str4, 40, true), str4 != null ? str2.length() : 0);
                    return;
                }
            }
        }
        zzgw();
        zzdx zzle = zzgm().zzle();
        if (zzle != null && !bundle.containsKey("_sc")) {
            zzle.zzarp = true;
        }
        zzdy.zza(zzle, bundle, z && z3);
        boolean equals = "am".equals(str);
        boolean zzcy = zzfy.zzcy(str2);
        if (z && this.zzaqy != null && !zzcy && !equals) {
            zzgt().zzjn().zze("Passing event to registered event handler (FE)", zzgq().zzbt(str4), zzgq().zzd(bundle));
            this.zzaqy.interceptEvent(str, str2, bundle, j);
        } else if (this.zzada.zzkv()) {
            int zzcu = zzgr().zzcu(str4);
            if (zzcu != 0) {
                zzgt().zzji().zzg("Invalid event name. Event will not be logged (FE)", zzgq().zzbt(str4));
                zzgr();
                String zza = zzfy.zza(str4, 40, true);
                if (str4 != null) {
                    i4 = str2.length();
                }
                this.zzada.zzgr().zza(str3, zzcu, "_ev", zza, i4);
                return;
            }
            List<String> listOf = CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"});
            Bundle zza2 = zzgr().zza(str3, str2, bundle, listOf, z3, true);
            zzdx zzdx2 = (zza2 == null || !zza2.containsKey("_sc") || !zza2.containsKey("_si")) ? null : new zzdx(zza2.getString("_sn"), zza2.getString("_sc"), Long.valueOf(zza2.getLong("_si")).longValue());
            zzdx zzdx3 = zzdx2 == null ? zzle : zzdx2;
            if (zzgv().zzbk(str3)) {
                zzgw();
                if (zzgm().zzle() != null && AppMeasurement.Event.APP_EXCEPTION.equals(str4)) {
                    long zzlp = zzgo().zzlp();
                    if (zzlp > 0) {
                        zzgr().zza(zza2, zzlp);
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(zza2);
            long nextLong = zzgr().zzmk().nextLong();
            if (zzgv().zzbj(zzgk().zzal())) {
                if (zza2.getLong("extend_session", 0) == 1) {
                    zzgt().zzjo().zzby("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                    this.zzada.zzgo().zza(j, true);
                }
            }
            String[] strArr2 = (String[]) zza2.keySet().toArray(new String[bundle.size()]);
            Arrays.sort(strArr2);
            int length = strArr2.length;
            int i5 = 0;
            int i6 = 0;
            while (i5 < length) {
                ArrayList arrayList3 = arrayList2;
                String str5 = strArr2[i5];
                Object obj = zza2.get(str5);
                zzgr();
                Bundle[] zzf = zzfy.zzf(obj);
                if (zzf != null) {
                    strArr = strArr2;
                    zza2.putInt(str5, zzf.length);
                    int i7 = 0;
                    while (i7 < zzf.length) {
                        Bundle bundle2 = zzf[i7];
                        zzdy.zza(zzdx3, bundle2, true);
                        Bundle zza3 = zzgr().zza(str3, "_ep", bundle2, listOf, z3, false);
                        zza3.putString("_en", str4);
                        zza3.putLong("_eid", nextLong);
                        zza3.putString("_gn", str5);
                        zza3.putInt("_ll", zzf.length);
                        zza3.putInt("_i", i7);
                        arrayList3.add(zza3);
                        i7++;
                        nextLong = nextLong;
                        str5 = str5;
                        length = length;
                        i5 = i5;
                        zzdx3 = zzdx3;
                        arrayList3 = arrayList3;
                        listOf = listOf;
                    }
                    list = listOf;
                    i = i5;
                    i2 = length;
                    arrayList = arrayList3;
                    zzdx = zzdx3;
                    j2 = nextLong;
                    i6 += zzf.length;
                } else {
                    list = listOf;
                    strArr = strArr2;
                    i = i5;
                    i2 = length;
                    arrayList = arrayList3;
                    zzdx = zzdx3;
                    j2 = nextLong;
                }
                i5 = i + 1;
                strArr2 = strArr;
                arrayList2 = arrayList;
                nextLong = j2;
                length = i2;
                listOf = list;
                zzdx3 = zzdx;
            }
            if (i6 != 0) {
                zza2.putLong("_eid", nextLong);
                zza2.putInt("_epc", i6);
            }
            int i8 = 0;
            while (i8 < arrayList2.size()) {
                Bundle bundle3 = (Bundle) arrayList2.get(i8);
                String str6 = i8 != 0 ? "_ep" : str4;
                bundle3.putString("_o", str);
                Bundle zze = z2 ? zzgr().zze(bundle3) : bundle3;
                zzgt().zzjn().zze("Logging event (FE)", zzgq().zzbt(str4), zzgq().zzd(zze));
                zzgl().zzc(new zzag(str6, new zzad(zze), str, j), str3);
                if (!equals) {
                    for (zzcy zzcy2 : this.zzaqz) {
                        zzcy2.onEvent(str, str2, new Bundle(zze), j);
                    }
                }
                i8++;
                str4 = str4;
            }
            zzgw();
            if (zzgm().zzle() != null && AppMeasurement.Event.APP_EXCEPTION.equals(str4)) {
                zzgo().zza(true, true);
            }
        }
    }

    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        boolean z3;
        zzgg();
        String str3 = str == null ? "app" : str;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (z2) {
            if (this.zzaqy != null && !zzfy.zzcy(str2)) {
                z3 = false;
                zzb(str3, str2, j, bundle2, z2, z3, !z, null);
            }
        }
        z3 = true;
        zzb(str3, str2, j, bundle2, z2, z3, !z, null);
    }

    private final void zzb(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzgs().zzc(new zzdc(this, str, str2, j, zzfy.zzf(bundle), z, z2, z3, str3));
    }

    public final void zzb(String str, String str2, Object obj, boolean z) {
        zza(str, str2, obj, z, zzbx().currentTimeMillis());
    }

    public final void zza(String str, String str2, Object obj, boolean z, long j) {
        String str3 = str == null ? "app" : str;
        int i = 6;
        int i2 = 0;
        if (z) {
            i = zzgr().zzcv(str2);
        } else {
            zzfy zzgr = zzgr();
            if (zzgr.zzs("user property", str2)) {
                if (!zzgr.zza("user property", zzcw.zzaqu, str2)) {
                    i = 15;
                } else if (zzgr.zza("user property", 24, str2)) {
                    i = 0;
                }
            }
        }
        if (i != 0) {
            zzgr();
            String zza = zzfy.zza(str2, 24, true);
            if (str2 != null) {
                i2 = str2.length();
            }
            this.zzada.zzgr().zza(i, "_ev", zza, i2);
        } else if (obj != null) {
            int zzi = zzgr().zzi(str2, obj);
            if (zzi != 0) {
                zzgr();
                String zza2 = zzfy.zza(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i2 = String.valueOf(obj).length();
                }
                this.zzada.zzgr().zza(zzi, "_ev", zza2, i2);
                return;
            }
            Object zzj = zzgr().zzj(str2, obj);
            if (zzj != null) {
                zza(str3, str2, j, zzj);
            }
        } else {
            zza(str3, str2, j, (Object) null);
        }
    }

    private final void zza(String str, String str2, long j, Object obj) {
        zzgs().zzc(new zzdd(this, str, str2, obj, j));
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(String str, String str2, Object obj, long j) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzaf();
        zzgg();
        zzcl();
        if (!this.zzada.isEnabled()) {
            zzgt().zzjn().zzby("User property not set since app measurement is disabled");
        } else if (this.zzada.zzkv()) {
            zzgt().zzjn().zze("Setting user property (FE)", zzgq().zzbt(str2), obj);
            zzgl().zzb(new zzfv(str2, j, obj, str));
        }
    }

    public final List<zzfv> zzk(boolean z) {
        zzgg();
        zzcl();
        zzgt().zzjn().zzby("Fetching user attributes (FE)");
        if (zzgs().zzkf()) {
            zzgt().zzjg().zzby("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        } else if (zzn.isMainThread()) {
            zzgt().zzjg().zzby("Cannot get all user properties from main thread");
            return Collections.emptyList();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            synchronized (atomicReference) {
                this.zzada.zzgs().zzc(new zzde(this, atomicReference, z));
                try {
                    atomicReference.wait(5000);
                } catch (InterruptedException e) {
                    zzgt().zzjj().zzg("Interrupted waiting for get user properties", e);
                }
            }
            List<zzfv> list = (List) atomicReference.get();
            if (list != null) {
                return list;
            }
            zzgt().zzjj().zzby("Timed out waiting for get user properties");
            return Collections.emptyList();
        }
    }

    @Nullable
    public final String zzgc() {
        zzgg();
        return this.zzarb.get();
    }

    @Nullable
    public final String zzag(long j) {
        if (zzgs().zzkf()) {
            zzgt().zzjg().zzby("Cannot retrieve app instance id from analytics worker thread");
            return null;
        } else if (zzn.isMainThread()) {
            zzgt().zzjg().zzby("Cannot retrieve app instance id from main thread");
            return null;
        } else {
            long elapsedRealtime = zzbx().elapsedRealtime();
            String zzah = zzah(120000);
            long elapsedRealtime2 = zzbx().elapsedRealtime() - elapsedRealtime;
            return (zzah != null || elapsedRealtime2 >= 120000) ? zzah : zzah(120000 - elapsedRealtime2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzcp(@Nullable String str) {
        this.zzarb.set(str);
    }

    @Nullable
    private final String zzah(long j) {
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            zzgs().zzc(new zzdf(this, atomicReference));
            try {
                atomicReference.wait(j);
            } catch (InterruptedException unused) {
                zzgt().zzjj().zzby("Interrupted waiting for app instance id");
                return null;
            }
        }
        return (String) atomicReference.get();
    }

    public final void resetAnalyticsData(long j) {
        if (zzgv().zza(zzai.zzalb)) {
            zzcp(null);
        }
        zzgs().zzc(new zzdg(this, j));
    }

    @WorkerThread
    public final void zzld() {
        zzaf();
        zzgg();
        zzcl();
        if (this.zzada.zzkv()) {
            zzgl().zzld();
            this.zzarc = false;
            String zzka = zzgu().zzka();
            if (!TextUtils.isEmpty(zzka)) {
                zzgp().zzcl();
                if (!zzka.equals(Build.VERSION.RELEASE)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", zzka);
                    logEvent("auto", "_ou", bundle);
                }
            }
        }
    }

    @WorkerThread
    public final void zza(zzcx zzcx) {
        zzcx zzcx2;
        zzaf();
        zzgg();
        zzcl();
        if (!(zzcx == null || zzcx == (zzcx2 = this.zzaqy))) {
            Preconditions.checkState(zzcx2 == null, "EventInterceptor already set.");
        }
        this.zzaqy = zzcx;
    }

    public final void zza(zzcy zzcy) {
        zzgg();
        zzcl();
        Preconditions.checkNotNull(zzcy);
        if (!this.zzaqz.add(zzcy)) {
            zzgt().zzjj().zzby("OnEventListener already registered");
        }
    }

    public final void zzb(zzcy zzcy) {
        zzgg();
        zzcl();
        Preconditions.checkNotNull(zzcy);
        if (!this.zzaqz.remove(zzcy)) {
            zzgt().zzjj().zzby("OnEventListener had not been registered");
        }
    }

    public final void setConditionalUserProperty(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        Preconditions.checkNotNull(conditionalUserProperty);
        zzgg();
        AppMeasurement.ConditionalUserProperty conditionalUserProperty2 = new AppMeasurement.ConditionalUserProperty(conditionalUserProperty);
        if (!TextUtils.isEmpty(conditionalUserProperty2.mAppId)) {
            zzgt().zzjj().zzby("Package name should be null when calling setConditionalUserProperty");
        }
        conditionalUserProperty2.mAppId = null;
        zza(conditionalUserProperty2);
    }

    public final void setConditionalUserPropertyAs(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        Preconditions.checkNotNull(conditionalUserProperty);
        Preconditions.checkNotEmpty(conditionalUserProperty.mAppId);
        zzgf();
        zza(new AppMeasurement.ConditionalUserProperty(conditionalUserProperty));
    }

    private final void zza(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        long currentTimeMillis = zzbx().currentTimeMillis();
        Preconditions.checkNotNull(conditionalUserProperty);
        Preconditions.checkNotEmpty(conditionalUserProperty.mName);
        Preconditions.checkNotEmpty(conditionalUserProperty.mOrigin);
        Preconditions.checkNotNull(conditionalUserProperty.mValue);
        conditionalUserProperty.mCreationTimestamp = currentTimeMillis;
        String str = conditionalUserProperty.mName;
        Object obj = conditionalUserProperty.mValue;
        if (zzgr().zzcv(str) != 0) {
            zzgt().zzjg().zzg("Invalid conditional user property name", zzgq().zzbv(str));
        } else if (zzgr().zzi(str, obj) != 0) {
            zzgt().zzjg().zze("Invalid conditional user property value", zzgq().zzbv(str), obj);
        } else {
            Object zzj = zzgr().zzj(str, obj);
            if (zzj == null) {
                zzgt().zzjg().zze("Unable to normalize conditional user property value", zzgq().zzbv(str), obj);
                return;
            }
            conditionalUserProperty.mValue = zzj;
            long j = conditionalUserProperty.mTriggerTimeout;
            if (TextUtils.isEmpty(conditionalUserProperty.mTriggerEventName) || (j <= 15552000000L && j >= 1)) {
                long j2 = conditionalUserProperty.mTimeToLive;
                if (j2 > 15552000000L || j2 < 1) {
                    zzgt().zzjg().zze("Invalid conditional user property time to live", zzgq().zzbv(str), Long.valueOf(j2));
                } else {
                    zzgs().zzc(new zzdi(this, conditionalUserProperty));
                }
            } else {
                zzgt().zzjg().zze("Invalid conditional user property timeout", zzgq().zzbv(str), Long.valueOf(j));
            }
        }
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        zzgg();
        zza((String) null, str, str2, bundle);
    }

    public final void clearConditionalUserPropertyAs(String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotEmpty(str);
        zzgf();
        zza(str, str2, str3, bundle);
    }

    private final void zza(String str, String str2, String str3, Bundle bundle) {
        long currentTimeMillis = zzbx().currentTimeMillis();
        Preconditions.checkNotEmpty(str2);
        AppMeasurement.ConditionalUserProperty conditionalUserProperty = new AppMeasurement.ConditionalUserProperty();
        conditionalUserProperty.mAppId = str;
        conditionalUserProperty.mName = str2;
        conditionalUserProperty.mCreationTimestamp = currentTimeMillis;
        if (str3 != null) {
            conditionalUserProperty.mExpiredEventName = str3;
            conditionalUserProperty.mExpiredEventParams = bundle;
        }
        zzgs().zzc(new zzdj(this, conditionalUserProperty));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzb(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        zzaf();
        zzcl();
        Preconditions.checkNotNull(conditionalUserProperty);
        Preconditions.checkNotEmpty(conditionalUserProperty.mName);
        Preconditions.checkNotEmpty(conditionalUserProperty.mOrigin);
        Preconditions.checkNotNull(conditionalUserProperty.mValue);
        if (!this.zzada.isEnabled()) {
            zzgt().zzjn().zzby("Conditional property not sent since collection is disabled");
            return;
        }
        zzfv zzfv = new zzfv(conditionalUserProperty.mName, conditionalUserProperty.mTriggeredTimestamp, conditionalUserProperty.mValue, conditionalUserProperty.mOrigin);
        try {
            zzag zza = zzgr().zza(conditionalUserProperty.mAppId, conditionalUserProperty.mTriggeredEventName, conditionalUserProperty.mTriggeredEventParams, conditionalUserProperty.mOrigin, 0, true, false);
            zzgl().zzd(new zzo(conditionalUserProperty.mAppId, conditionalUserProperty.mOrigin, zzfv, conditionalUserProperty.mCreationTimestamp, false, conditionalUserProperty.mTriggerEventName, zzgr().zza(conditionalUserProperty.mAppId, conditionalUserProperty.mTimedOutEventName, conditionalUserProperty.mTimedOutEventParams, conditionalUserProperty.mOrigin, 0, true, false), conditionalUserProperty.mTriggerTimeout, zza, conditionalUserProperty.mTimeToLive, zzgr().zza(conditionalUserProperty.mAppId, conditionalUserProperty.mExpiredEventName, conditionalUserProperty.mExpiredEventParams, conditionalUserProperty.mOrigin, 0, true, false)));
        } catch (IllegalArgumentException unused) {
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzc(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        zzaf();
        zzcl();
        Preconditions.checkNotNull(conditionalUserProperty);
        Preconditions.checkNotEmpty(conditionalUserProperty.mName);
        if (!this.zzada.isEnabled()) {
            zzgt().zzjn().zzby("Conditional property not cleared since collection is disabled");
            return;
        }
        try {
            zzgl().zzd(new zzo(conditionalUserProperty.mAppId, conditionalUserProperty.mOrigin, new zzfv(conditionalUserProperty.mName, 0, null, null), conditionalUserProperty.mCreationTimestamp, conditionalUserProperty.mActive, conditionalUserProperty.mTriggerEventName, null, conditionalUserProperty.mTriggerTimeout, null, conditionalUserProperty.mTimeToLive, zzgr().zza(conditionalUserProperty.mAppId, conditionalUserProperty.mExpiredEventName, conditionalUserProperty.mExpiredEventParams, conditionalUserProperty.mOrigin, conditionalUserProperty.mCreationTimestamp, true, false)));
        } catch (IllegalArgumentException unused) {
        }
    }

    public final List<AppMeasurement.ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        zzgg();
        return zzf(null, str, str2);
    }

    public final List<AppMeasurement.ConditionalUserProperty> getConditionalUserPropertiesAs(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzgf();
        return zzf(str, str2, str3);
    }

    @VisibleForTesting
    private final List<AppMeasurement.ConditionalUserProperty> zzf(String str, String str2, String str3) {
        if (zzgs().zzkf()) {
            zzgt().zzjg().zzby("Cannot get conditional user properties from analytics worker thread");
            return Collections.emptyList();
        } else if (zzn.isMainThread()) {
            zzgt().zzjg().zzby("Cannot get conditional user properties from main thread");
            return Collections.emptyList();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            synchronized (atomicReference) {
                this.zzada.zzgs().zzc(new zzdk(this, atomicReference, str, str2, str3));
                try {
                    atomicReference.wait(5000);
                } catch (InterruptedException e) {
                    zzgt().zzjj().zze("Interrupted waiting for get conditional user properties", str, e);
                }
            }
            List<zzo> list = (List) atomicReference.get();
            if (list == null) {
                zzgt().zzjj().zzg("Timed out waiting for get conditional user properties", str);
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (zzo zzo : list) {
                AppMeasurement.ConditionalUserProperty conditionalUserProperty = new AppMeasurement.ConditionalUserProperty();
                conditionalUserProperty.mAppId = zzo.packageName;
                conditionalUserProperty.mOrigin = zzo.origin;
                conditionalUserProperty.mCreationTimestamp = zzo.creationTimestamp;
                conditionalUserProperty.mName = zzo.zzags.name;
                conditionalUserProperty.mValue = zzo.zzags.getValue();
                conditionalUserProperty.mActive = zzo.active;
                conditionalUserProperty.mTriggerEventName = zzo.triggerEventName;
                if (zzo.zzagt != null) {
                    conditionalUserProperty.mTimedOutEventName = zzo.zzagt.name;
                    if (zzo.zzagt.zzahu != null) {
                        conditionalUserProperty.mTimedOutEventParams = zzo.zzagt.zzahu.zziy();
                    }
                }
                conditionalUserProperty.mTriggerTimeout = zzo.triggerTimeout;
                if (zzo.zzagu != null) {
                    conditionalUserProperty.mTriggeredEventName = zzo.zzagu.name;
                    if (zzo.zzagu.zzahu != null) {
                        conditionalUserProperty.mTriggeredEventParams = zzo.zzagu.zzahu.zziy();
                    }
                }
                conditionalUserProperty.mTriggeredTimestamp = zzo.zzags.zzauk;
                conditionalUserProperty.mTimeToLive = zzo.timeToLive;
                if (zzo.zzagv != null) {
                    conditionalUserProperty.mExpiredEventName = zzo.zzagv.name;
                    if (zzo.zzagv.zzahu != null) {
                        conditionalUserProperty.mExpiredEventParams = zzo.zzagv.zzahu.zziy();
                    }
                }
                arrayList.add(conditionalUserProperty);
            }
            return arrayList;
        }
    }

    public final Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        zzgg();
        return zzb((String) null, str, str2, z);
    }

    public final Map<String, Object> getUserPropertiesAs(String str, String str2, String str3, boolean z) {
        Preconditions.checkNotEmpty(str);
        zzgf();
        return zzb(str, str2, str3, z);
    }

    @VisibleForTesting
    private final Map<String, Object> zzb(String str, String str2, String str3, boolean z) {
        if (zzgs().zzkf()) {
            zzgt().zzjg().zzby("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        } else if (zzn.isMainThread()) {
            zzgt().zzjg().zzby("Cannot get user properties from main thread");
            return Collections.emptyMap();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            synchronized (atomicReference) {
                this.zzada.zzgs().zzc(new zzdm(this, atomicReference, str, str2, str3, z));
                try {
                    atomicReference.wait(5000);
                } catch (InterruptedException e) {
                    zzgt().zzjj().zzg("Interrupted waiting for get user properties", e);
                }
            }
            List<zzfv> list = (List) atomicReference.get();
            if (list == null) {
                zzgt().zzjj().zzby("Timed out waiting for get user properties");
                return Collections.emptyMap();
            }
            ArrayMap arrayMap = new ArrayMap(list.size());
            for (zzfv zzfv : list) {
                arrayMap.put(zzfv.name, zzfv.getValue());
            }
            return arrayMap;
        }
    }

    @Nullable
    public final String getCurrentScreenName() {
        zzdx zzlf = this.zzada.zzgm().zzlf();
        if (zzlf != null) {
            return zzlf.zzuw;
        }
        return null;
    }

    @Nullable
    public final String getCurrentScreenClass() {
        zzdx zzlf = this.zzada.zzgm().zzlf();
        if (zzlf != null) {
            return zzlf.zzarn;
        }
        return null;
    }

    @Nullable
    public final String getGmpAppId() {
        if (this.zzada.zzko() != null) {
            return this.zzada.zzko();
        }
        try {
            return GoogleServices.getGoogleAppId();
        } catch (IllegalStateException e) {
            this.zzada.zzgt().zzjg().zzg("getGoogleAppId failed with exception", e);
            return null;
        }
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
