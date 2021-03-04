package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.zza;
import java.util.Arrays;
import java.util.List;

@KeepForSdk
public class WakeLockTracker {
    @VisibleForTesting
    private static boolean zzfb = false;
    private static WakeLockTracker zzgb = new WakeLockTracker();
    private static Boolean zzgc;

    @KeepForSdk
    public static WakeLockTracker getInstance() {
        return zzgb;
    }

    @KeepForSdk
    public void registerAcquireEvent(Context context, Intent intent, String str, String str2, String str3, int i, String str4) {
        registerEvent(context, intent.getStringExtra(LoggingConstants.EXTRA_WAKE_LOCK_KEY), 7, str, str2, str3, i, Arrays.asList(str4));
    }

    @KeepForSdk
    public void registerReleaseEvent(Context context, Intent intent) {
        registerEvent(context, intent.getStringExtra(LoggingConstants.EXTRA_WAKE_LOCK_KEY), 8, null, null, null, 0, null);
    }

    @KeepForSdk
    public void registerEvent(Context context, String str, int i, String str2, String str3, String str4, int i2, List<String> list) {
        registerEvent(context, str, i, str2, str3, str4, i2, list, 0);
    }

    @KeepForSdk
    public void registerEvent(Context context, String str, int i, String str2, String str3, String str4, int i2, List<String> list, long j) {
        List<String> list2;
        List<String> list3 = list;
        if (zzgc == null) {
            zzgc = false;
        }
        if (zzgc.booleanValue()) {
            if (TextUtils.isEmpty(str)) {
                String valueOf = String.valueOf(str);
                Log.e("WakeLockTracker", valueOf.length() != 0 ? "missing wakeLock key. ".concat(valueOf) : new String("missing wakeLock key. "));
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (7 == i || 8 == i || 10 == i || 11 == i) {
                if (list3 == null || list.size() != 1) {
                    list2 = list3;
                } else {
                    if ("com.google.android.gms".equals(list3.get(0))) {
                        list3 = null;
                    }
                    list2 = list3;
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                int zzg = zza.zzg(context);
                String packageName = context.getPackageName();
                try {
                    context.startService(new Intent().setComponent(LoggingConstants.zzfg).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", new WakeLockEvent(currentTimeMillis, i, str2, i2, list2, str, elapsedRealtime, zzg, str3, "com.google.android.gms".equals(packageName) ? null : packageName, zza.zzh(context), j, str4)));
                } catch (Exception e) {
                    Log.wtf("WakeLockTracker", e);
                }
            }
        }
    }
}
