package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

@zzark
public final class zzaxp {
    private final Object mLock = new Object();
    @VisibleForTesting
    private long zzejm = -1;
    @VisibleForTesting
    private long zzejn = -1;
    @VisibleForTesting
    @GuardedBy("mLock")
    private int zzejo = -1;
    @VisibleForTesting
    int zzejp = -1;
    @VisibleForTesting
    private long zzejq = 0;
    @VisibleForTesting
    private final String zzejr;
    private final zzayb zzejs;
    @VisibleForTesting
    @GuardedBy("mLock")
    private int zzejt = 0;
    @VisibleForTesting
    @GuardedBy("mLock")
    private int zzeju = 0;

    public zzaxp(String str, zzayb zzayb) {
        this.zzejr = str;
        this.zzejs = zzayb;
    }

    public final void zzxw() {
        synchronized (this.mLock) {
            this.zzejt++;
        }
    }

    public final void zzxv() {
        synchronized (this.mLock) {
            this.zzeju++;
        }
    }

    public final void zzb(zzwb zzwb, long j) {
        synchronized (this.mLock) {
            long zzzj = this.zzejs.zzzj();
            long currentTimeMillis = zzbv.zzlm().currentTimeMillis();
            if (this.zzejn == -1) {
                if (currentTimeMillis - zzzj > ((Long) zzwu.zzpz().zzd(zzaan.zzcrn)).longValue()) {
                    this.zzejp = -1;
                } else {
                    this.zzejp = this.zzejs.zzzk();
                }
                this.zzejn = j;
                this.zzejm = this.zzejn;
            } else {
                this.zzejm = j;
            }
            if (zzwb == null || zzwb.extras == null || zzwb.extras.getInt("gw", 2) != 1) {
                this.zzejo++;
                this.zzejp++;
                if (this.zzejp == 0) {
                    this.zzejq = 0;
                    this.zzejs.zzav(currentTimeMillis);
                } else {
                    this.zzejq = currentTimeMillis - this.zzejs.zzzl();
                }
            }
        }
    }

    public final Bundle zzl(Context context, String str) {
        Bundle bundle;
        synchronized (this.mLock) {
            bundle = new Bundle();
            bundle.putString("session_id", this.zzejr);
            bundle.putLong("basets", this.zzejn);
            bundle.putLong("currts", this.zzejm);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.zzejo);
            bundle.putInt("preqs_in_session", this.zzejp);
            bundle.putLong("time_in_session", this.zzejq);
            bundle.putInt("pclick", this.zzejt);
            bundle.putInt("pimp", this.zzeju);
            bundle.putBoolean("support_transparent_background", zzaf(context));
        }
        return bundle;
    }

    private static boolean zzaf(Context context) {
        int identifier = context.getResources().getIdentifier("Theme.Translucent", "style", "android");
        if (identifier == 0) {
            zzaxz.zzen("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        try {
            if (identifier == context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), AdActivity.CLASS_NAME), 0).theme) {
                return true;
            }
            zzaxz.zzen("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            zzaxz.zzeo("Fail to fetch AdActivity theme");
            zzaxz.zzen("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
    }
}
