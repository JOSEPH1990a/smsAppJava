package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.ads.AdRequest;

@zzark
public final class zzaxz extends zzbbd {
    public static void v(String str) {
        if (zzza()) {
            Log.v(AdRequest.LOGTAG, str);
        }
    }

    public static boolean zzza() {
        if (!isLoggable(2)) {
            return false;
        }
        return ((Boolean) zzwu.zzpz().zzd(zzaan.zzcss)).booleanValue();
    }
}
