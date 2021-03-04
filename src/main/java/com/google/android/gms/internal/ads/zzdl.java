package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zzdl {
    private static final String TAG = "zzdl";
    private volatile boolean zzrp = false;
    protected Context zzsp;
    private ExecutorService zzsq;
    private DexClassLoader zzsr;
    private zzcw zzss;
    private byte[] zzst;
    private volatile AdvertisingIdClient zzsu = null;
    private Future zzsv = null;
    private boolean zzsw;
    private volatile zzbl zzsx = null;
    private Future zzsy = null;
    private zzco zzsz;
    private boolean zzta = false;
    private boolean zztb = false;
    private Map<Pair<String, String>, zzes> zztc;
    private boolean zztd = false;
    private boolean zzte;
    private boolean zztf;

    final class zza extends BroadcastReceiver {
        private zza() {
        }

        public final void onReceive(Context context, Intent intent) {
            if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                zzdl.this.zzte = true;
            } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                zzdl.this.zzte = false;
            }
        }

        /* synthetic */ zza(zzdl zzdl, zzdm zzdm) {
            this();
        }
    }

    public static zzdl zza(Context context, String str, String str2, boolean z) {
        zzdl zzdl = new zzdl(context);
        try {
            zzdl.zzsq = Executors.newCachedThreadPool(new zzdm());
            zzdl.zzrp = z;
            if (z) {
                zzdl.zzsv = zzdl.zzsq.submit(new zzdn(zzdl));
            }
            zzdl.zzsq.execute(new zzdp(zzdl));
            try {
                GoogleApiAvailabilityLight instance = GoogleApiAvailabilityLight.getInstance();
                zzdl.zzta = instance.getApkVersion(zzdl.zzsp) > 0;
                zzdl.zztb = instance.isGooglePlayServicesAvailable(zzdl.zzsp) == 0;
            } catch (Throwable unused) {
            }
            zzdl.zza(0, true);
            if (zzds.isMainThread()) {
                if (((Boolean) zzwu.zzpz().zzd(zzaan.zzctr)).booleanValue()) {
                    throw new IllegalStateException("Task Context initialization must not be called from the UI thread.");
                }
            }
            zzdl.zzss = new zzcw(null);
            try {
                zzdl.zzst = zzdl.zzss.zzl(str);
                try {
                    File cacheDir = zzdl.zzsp.getCacheDir();
                    if (cacheDir == null) {
                        cacheDir = zzdl.zzsp.getDir("dex", 0);
                        if (cacheDir == null) {
                            throw new zzdi();
                        }
                    }
                    File file = new File(String.format("%s/%s.jar", cacheDir, "1529567361524"));
                    if (!file.exists()) {
                        byte[] zza2 = zzdl.zzss.zza(zzdl.zzst, str2);
                        file.createNewFile();
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        fileOutputStream.write(zza2, 0, zza2.length);
                        fileOutputStream.close();
                    }
                    zzdl.zzb(cacheDir, "1529567361524");
                    try {
                        zzdl.zzsr = new DexClassLoader(file.getAbsolutePath(), cacheDir.getAbsolutePath(), null, zzdl.zzsp.getClassLoader());
                        zzb(file);
                        zzdl.zza(cacheDir, "1529567361524");
                        zzm(String.format("%s/%s.dex", cacheDir, "1529567361524"));
                        if (!zzdl.zztf) {
                            IntentFilter intentFilter = new IntentFilter();
                            intentFilter.addAction("android.intent.action.USER_PRESENT");
                            intentFilter.addAction("android.intent.action.SCREEN_OFF");
                            zzdl.zzsp.registerReceiver(new zza(zzdl, null), intentFilter);
                            zzdl.zztf = true;
                        }
                        zzdl.zzsz = new zzco(zzdl);
                        zzdl.zztd = true;
                        return zzdl;
                    } catch (Throwable th) {
                        zzb(file);
                        zzdl.zza(cacheDir, "1529567361524");
                        zzm(String.format("%s/%s.dex", cacheDir, "1529567361524"));
                        throw th;
                    }
                } catch (FileNotFoundException e) {
                    throw new zzdi(e);
                } catch (IOException e2) {
                    throw new zzdi(e2);
                } catch (zzcx e3) {
                    throw new zzdi(e3);
                } catch (NullPointerException e4) {
                    throw new zzdi(e4);
                }
            } catch (zzcx e5) {
                throw new zzdi(e5);
            }
        } catch (zzdi unused2) {
        }
    }

    public final Context getContext() {
        return this.zzsp;
    }

    public final boolean isInitialized() {
        return this.zztd;
    }

    public final ExecutorService zzac() {
        return this.zzsq;
    }

    public final DexClassLoader zzad() {
        return this.zzsr;
    }

    public final zzcw zzae() {
        return this.zzss;
    }

    public final byte[] zzaf() {
        return this.zzst;
    }

    public final boolean zzag() {
        return this.zzta;
    }

    public final zzco zzah() {
        return this.zzsz;
    }

    public final boolean zzai() {
        return this.zztb;
    }

    public final boolean zzaj() {
        return this.zzte;
    }

    public final zzbl zzak() {
        return this.zzsx;
    }

    public final Future zzal() {
        return this.zzsy;
    }

    private zzdl(Context context) {
        boolean z = true;
        this.zzte = true;
        this.zztf = false;
        Context applicationContext = context.getApplicationContext();
        this.zzsw = applicationContext == null ? false : z;
        this.zzsp = this.zzsw ? applicationContext : context;
        this.zztc = new HashMap();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:20|21|22|23|24|25|26|27|28|30) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0091 */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a3 A[SYNTHETIC, Splitter:B:39:0x00a3] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a8 A[SYNTHETIC, Splitter:B:43:0x00a8] */
    /* JADX WARNING: Removed duplicated region for block: B:51:? A[ExcHandler: zzcx | IOException | NoSuchAlgorithmException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:20:0x0054] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00b2 A[SYNTHETIC, Splitter:B:52:0x00b2] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b7 A[SYNTHETIC, Splitter:B:56:0x00b7] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zza(java.io.File r8, java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 190
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdl.zza(java.io.File, java.lang.String):void");
    }

    private static void zzm(String str) {
        zzb(new File(str));
    }

    private static void zzb(File file) {
        if (!file.exists()) {
            Log.d(TAG, String.format("File %s not found. No need for deletion", file.getAbsolutePath()));
            return;
        }
        file.delete();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:29|30|31|32|33|34|35|36) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x00b1 */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c7 A[SYNTHETIC, Splitter:B:51:0x00c7] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00cc A[SYNTHETIC, Splitter:B:55:0x00cc] */
    /* JADX WARNING: Removed duplicated region for block: B:62:? A[ExcHandler: zzcx | IOException | NoSuchAlgorithmException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:21:0x005e] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00d3 A[SYNTHETIC, Splitter:B:63:0x00d3] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d8 A[SYNTHETIC, Splitter:B:67:0x00d8] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzb(java.io.File r10, java.lang.String r11) {
        /*
        // Method dump skipped, instructions count: 220
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdl.zzb(java.io.File, java.lang.String):boolean");
    }

    public final boolean zza(String str, String str2, Class<?>... clsArr) {
        if (this.zztc.containsKey(new Pair(str, str2))) {
            return false;
        }
        this.zztc.put(new Pair<>(str, str2), new zzes(this, str, str2, clsArr));
        return true;
    }

    public final Method zza(String str, String str2) {
        zzes zzes = this.zztc.get(new Pair(str, str2));
        if (zzes == null) {
            return null;
        }
        return zzes.zzax();
    }

    /* access modifiers changed from: private */
    public final void zzam() {
        try {
            if (this.zzsu == null && this.zzsw) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.zzsp);
                advertisingIdClient.start();
                this.zzsu = advertisingIdClient;
            }
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException unused) {
            this.zzsu = null;
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zza(int i, boolean z) {
        if (this.zztb) {
            Future<?> submit = this.zzsq.submit(new zzdo(this, i, z));
            if (i == 0) {
                this.zzsy = submit;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final zzbl zzb(int i, boolean z) {
        if (i > 0 && z) {
            try {
                Thread.sleep((long) (i * 1000));
            } catch (InterruptedException unused) {
            }
        }
        return zzan();
    }

    /* access modifiers changed from: private */
    public static boolean zza(int i, zzbl zzbl) {
        if (i >= 4) {
            return false;
        }
        if (zzbl == null) {
            return true;
        }
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzctu)).booleanValue() && (zzbl.zzdq == null || zzbl.zzdq.equals("0000000000000000000000000000000000000000000000000000000000000000"))) {
            return true;
        }
        if (!((Boolean) zzwu.zzpz().zzd(zzaan.zzctv)).booleanValue()) {
            return false;
        }
        if (zzbl.zzgj == null || zzbl.zzgj.zzhh == null || zzbl.zzgj.zzhh.longValue() == -2) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    private final zzbl zzan() {
        try {
            return zzbjd.zzk(this.zzsp, this.zzsp.getPackageName(), Integer.toString(this.zzsp.getPackageManager().getPackageInfo(this.zzsp.getPackageName(), 0).versionCode));
        } catch (Throwable unused) {
            return null;
        }
    }

    public final AdvertisingIdClient zzao() {
        if (!this.zzrp) {
            return null;
        }
        if (this.zzsu != null) {
            return this.zzsu;
        }
        Future future = this.zzsv;
        if (future != null) {
            try {
                future.get(2000, TimeUnit.MILLISECONDS);
                this.zzsv = null;
            } catch (InterruptedException | ExecutionException unused) {
            } catch (TimeoutException unused2) {
                this.zzsv.cancel(true);
            }
        }
        return this.zzsu;
    }

    public final int zzy() {
        if (this.zzsz != null) {
            return zzco.zzy();
        }
        return Integer.MIN_VALUE;
    }
}
