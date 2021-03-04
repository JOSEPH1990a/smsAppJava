package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzcx;
import com.google.android.gms.measurement.internal.zzcy;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class zzea {
    private static volatile zzea zzadk;
    private final String zzadh;
    private final ExecutorService zzadl;
    private final AppMeasurementSdk zzadm;
    private Map<zzcy, zzd> zzadn;
    private int zzado;
    private boolean zzadp;
    private String zzadq;
    private zzdn zzadr;
    protected final Clock zzrz;

    /* access modifiers changed from: package-private */
    public class zze implements Application.ActivityLifecycleCallbacks {
        zze() {
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            zzea.this.zza((zzea) new zzex(this, activity, bundle));
        }

        public final void onActivityStarted(Activity activity) {
            zzea.this.zza((zzea) new zzey(this, activity));
        }

        public final void onActivityResumed(Activity activity) {
            zzea.this.zza((zzea) new zzez(this, activity));
        }

        public final void onActivityPaused(Activity activity) {
            zzea.this.zza((zzea) new zzfa(this, activity));
        }

        public final void onActivityStopped(Activity activity) {
            zzea.this.zza((zzea) new zzfb(this, activity));
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            zza zza = new zza();
            zzea.this.zza((zzea) new zzfc(this, activity, zza));
            Bundle zzl = zza.zzl(50);
            if (zzl != null) {
                bundle.putAll(zzl);
            }
        }

        public final void onActivityDestroyed(Activity activity) {
            zzea.this.zza((zzea) new zzfd(this, activity));
        }
    }

    public static zzea zza(Context context, String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotNull(context);
        if (zzadk == null) {
            synchronized (zzea.class) {
                if (zzadk == null) {
                    zzadk = new zzea(context, str, str2, str3, bundle);
                }
            }
        }
        return zzadk;
    }

    /* access modifiers changed from: package-private */
    public class zza extends zzdr {
        private final AtomicReference<Bundle> zzaet = new AtomicReference<>();
        private boolean zzaeu;

        zza() {
        }

        @Override // com.google.android.gms.internal.measurement.zzdq
        public final void zzb(Bundle bundle) {
            synchronized (this.zzaet) {
                try {
                    this.zzaet.set(bundle);
                    this.zzaeu = true;
                    this.zzaet.notify();
                } catch (Throwable th) {
                    this.zzaet.notify();
                    throw th;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final String zzk(long j) {
            return (String) zza(zzl(j), String.class);
        }

        /* access modifiers changed from: package-private */
        public final Bundle zzl(long j) {
            Bundle bundle;
            synchronized (this.zzaet) {
                if (!this.zzaeu) {
                    try {
                        this.zzaet.wait(j);
                    } catch (InterruptedException unused) {
                        return null;
                    }
                }
                bundle = this.zzaet.get();
            }
            return bundle;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
            r9 = r9.get("r");
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final <T> T zza(android.os.Bundle r9, java.lang.Class<T> r10) {
            /*
                r8 = this;
                r0 = 0
                if (r9 == 0) goto L_0x004b
                java.lang.String r1 = "r"
                java.lang.Object r9 = r9.get(r1)
                if (r9 == 0) goto L_0x004a
                java.lang.Object r9 = r10.cast(r9)     // Catch:{ ClassCastException -> 0x0010 }
                return r9
            L_0x0010:
                r6 = move-exception
                java.lang.String r7 = "Unexpected object type. Expected, Received"
                java.lang.String r10 = r10.getCanonicalName()
                java.lang.Class r9 = r9.getClass()
                java.lang.String r9 = r9.getCanonicalName()
                com.google.android.gms.internal.measurement.zzea r0 = com.google.android.gms.internal.measurement.zzea.this
                r1 = 5
                r2 = r7
                r3 = r10
                r4 = r9
                r5 = r6
                r0.zzc(r1, r2, r3, r4, r5)
                com.google.android.gms.internal.measurement.zzea r0 = com.google.android.gms.internal.measurement.zzea.this
                java.lang.String r0 = com.google.android.gms.internal.measurement.zzea.zzc(r0)
                java.lang.String r1 = java.lang.String.valueOf(r7)
                java.lang.String r2 = ": %s, %s"
                java.lang.String r1 = r1.concat(r2)
                r2 = 2
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                r2[r3] = r10
                r10 = 1
                r2[r10] = r9
                java.lang.String r9 = java.lang.String.format(r1, r2)
                android.util.Log.w(r0, r9, r6)
                throw r6
            L_0x004a:
                return r0
            L_0x004b:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzea.zza.zza(android.os.Bundle, java.lang.Class):java.lang.Object");
        }
    }

    /* access modifiers changed from: package-private */
    public abstract class zzb implements Runnable {
        final long timestamp;
        final long zzaev;
        private final boolean zzaew;

        zzb(zzea zzea) {
            this(true);
        }

        /* access modifiers changed from: package-private */
        public abstract void zzgd() throws RemoteException;

        /* access modifiers changed from: protected */
        public void zzge() {
        }

        zzb(boolean z) {
            this.timestamp = zzea.this.zzrz.currentTimeMillis();
            this.zzaev = zzea.this.zzrz.elapsedRealtime();
            this.zzaew = z;
        }

        public void run() {
            if (zzea.this.zzadp) {
                zzge();
                return;
            }
            try {
                zzgd();
            } catch (Exception e) {
                zzea.this.zza((zzea) e, (Exception) false, this.zzaew);
                zzge();
            }
        }
    }

    static class zzc extends zzdu {
        private final zzcx zzaex;

        zzc(zzcx zzcx) {
            this.zzaex = zzcx;
        }

        @Override // com.google.android.gms.internal.measurement.zzdt
        public final void onEvent(String str, String str2, Bundle bundle, long j) {
            this.zzaex.interceptEvent(str, str2, bundle, j);
        }

        @Override // com.google.android.gms.internal.measurement.zzdt
        public final int id() {
            return this.zzaex.hashCode();
        }
    }

    /* access modifiers changed from: package-private */
    public static class zzd extends zzdu {
        private final zzcy zzaey;

        zzd(zzcy zzcy) {
            this.zzaey = zzcy;
        }

        @Override // com.google.android.gms.internal.measurement.zzdt
        public final void onEvent(String str, String str2, Bundle bundle, long j) {
            this.zzaey.onEvent(str, str2, bundle, j);
        }

        @Override // com.google.android.gms.internal.measurement.zzdt
        public final int id() {
            return this.zzaey.hashCode();
        }
    }

    public final AppMeasurementSdk zzga() {
        return this.zzadm;
    }

    private zzea(Context context, String str, String str2, String str3, Bundle bundle) {
        if (str == null || !zze(str2, str3)) {
            this.zzadh = "FA";
        } else {
            this.zzadh = str;
        }
        this.zzrz = DefaultClock.getInstance();
        this.zzadl = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue());
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.zzadh, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new zze());
        }
        this.zzadm = new AppMeasurementSdk(this);
        boolean z = false;
        if (!(!zzf(context) || zzgb())) {
            this.zzadq = null;
            this.zzadp = true;
            Log.w(this.zzadh, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
            return;
        }
        if (!zze(str2, str3)) {
            this.zzadq = "fa";
            if (str2 == null || str3 == null) {
                if ((str2 == null) ^ (str3 == null ? true : z)) {
                    Log.w(this.zzadh, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            } else {
                Log.v(this.zzadh, "Deferring to Google Analytics for Firebase for event data collection. https://goo.gl/J1sWQy");
                this.zzadp = true;
                return;
            }
        } else {
            this.zzadq = str2;
        }
        zza(new zzeb(this, context, str2, str3, bundle));
    }

    private static boolean zzf(Context context) {
        try {
            GoogleServices.initialize(context);
            if (GoogleServices.getGoogleAppId() != null) {
                return true;
            }
            return false;
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public static boolean zze(String str, String str2) {
        return (str2 == null || str == null || zzgb()) ? false : true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zza(zzb zzb2) {
        this.zzadl.execute(zzb2);
    }

    /* access modifiers changed from: protected */
    public final zzdn zzg(Context context) {
        try {
            return zzdo.asInterface(DynamiteModule.load(context, DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION, "com.google.android.gms.measurement.dynamite").instantiate("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
        } catch (DynamiteModule.LoadingException e) {
            zza((Exception) e, true, false);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static int zzh(Context context) {
        return DynamiteModule.getRemoteVersion(context, "com.google.android.gms.measurement.dynamite");
    }

    /* access modifiers changed from: private */
    public static int zzi(Context context) {
        return DynamiteModule.getLocalVersion(context, "com.google.android.gms.measurement.dynamite");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zza(Exception exc, boolean z, boolean z2) {
        this.zzadp |= z;
        if (z) {
            Log.w(this.zzadh, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z2) {
            zzc(5, "Error with data collection. Data lost.", exc, null, null);
        }
        Log.w(this.zzadh, "Error with data collection. Data lost.", exc);
    }

    private static boolean zzgb() {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final void zza(zzcx zzcx) {
        zza(new zzei(this, zzcx));
    }

    public final void zza(zzcy zzcy) {
        zza(new zzes(this, zzcy));
    }

    public final void zzb(zzcy zzcy) {
        zza(new zzet(this, zzcy));
    }

    public final void logEventInternal(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, null);
    }

    public final void logEventInternalNoInterceptor(String str, String str2, Bundle bundle, long j) {
        zza(str, str2, bundle, true, false, Long.valueOf(j));
    }

    private final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l) {
        zza(new zzeu(this, l, str, str2, bundle, true, z2));
    }

    public final void zza(String str, String str2, Object obj, boolean z) {
        zza(new zzev(this, str, str2, obj, true));
    }

    public final void setConditionalUserProperty(Bundle bundle) {
        zza(new zzew(this, bundle));
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        zza(new zzec(this, str, str2, bundle));
    }

    public final List<Bundle> getConditionalUserProperties(String str, String str2) {
        zza zza2 = new zza();
        zza(new zzed(this, str, str2, zza2));
        List<Bundle> list = (List) zza2.zza(zza2.zzl(5000), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    public final void setCurrentScreen(Activity activity, String str, String str2) {
        zza(new zzee(this, activity, str, str2));
    }

    public final void setMeasurementEnabled(boolean z) {
        zza(new zzef(this, z));
    }

    public final void beginAdUnitExposure(String str) {
        zza(new zzeg(this, str));
    }

    public final void endAdUnitExposure(String str) {
        zza(new zzeh(this, str));
    }

    public final String getGmpAppId() {
        zza zza2 = new zza();
        zza(new zzej(this, zza2));
        return zza2.zzk(500);
    }

    public final String zzgc() {
        zza zza2 = new zza();
        zza(new zzek(this, zza2));
        return zza2.zzk(50);
    }

    public final long generateEventId() {
        zza zza2 = new zza();
        zza(new zzel(this, zza2));
        Long l = (Long) zza2.zza(zza2.zzl(500), Long.class);
        if (l != null) {
            return l.longValue();
        }
        long nextLong = new Random(System.nanoTime() ^ this.zzrz.currentTimeMillis()).nextLong();
        int i = this.zzado + 1;
        this.zzado = i;
        return nextLong + ((long) i);
    }

    public final String getCurrentScreenName() {
        zza zza2 = new zza();
        zza(new zzem(this, zza2));
        return zza2.zzk(500);
    }

    public final String getCurrentScreenClass() {
        zza zza2 = new zza();
        zza(new zzen(this, zza2));
        return zza2.zzk(500);
    }

    public final Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        zza zza2 = new zza();
        zza(new zzeo(this, str, str2, z, zza2));
        Bundle zzl = zza2.zzl(5000);
        if (zzl == null || zzl.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap(zzl.size());
        for (String str3 : zzl.keySet()) {
            Object obj = zzl.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                hashMap.put(str3, obj);
            }
        }
        return hashMap;
    }

    public final void zzc(int i, String str, Object obj, Object obj2, Object obj3) {
        zza(new zzep(this, false, 5, str, obj, obj2, obj3));
    }

    public final Bundle zza(Bundle bundle, boolean z) {
        zza zza2 = new zza();
        zza(new zzeq(this, bundle, zza2));
        if (z) {
            return zza2.zzl(5000);
        }
        return null;
    }

    public final int getMaxUserProperties(String str) {
        zza zza2 = new zza();
        zza(new zzer(this, str, zza2));
        Integer num = (Integer) zza2.zza(zza2.zzl(10000), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    public final String getAppIdOrigin() {
        return this.zzadq;
    }
}
