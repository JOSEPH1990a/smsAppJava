package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.support.annotation.GuardedBy;
import android.support.v4.content.PermissionChecker;
import android.util.Log;

/* access modifiers changed from: package-private */
public final class zzse implements zzsb {
    @GuardedBy("GservicesLoader.class")
    static zzse zzbrj;
    private final Context zzri;

    static zzse zzad(Context context) {
        zzse zzse;
        synchronized (zzse.class) {
            if (zzbrj == null) {
                zzbrj = PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzse(context) : new zzse();
            }
            zzse = zzbrj;
        }
        return zzse;
    }

    private zzse(Context context) {
        this.zzri = context;
        this.zzri.getContentResolver().registerContentObserver(zzru.CONTENT_URI, true, new zzsg(this, null));
    }

    private zzse() {
        this.zzri = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzfo */
    public final String zzfn(String str) {
        if (this.zzri == null) {
            return null;
        }
        try {
            return (String) zzsc.zza(new zzsf(this, str));
        } catch (SecurityException e) {
            String valueOf = String.valueOf(str);
            Log.e("GservicesLoader", valueOf.length() != 0 ? "Unable to read GServices for: ".concat(valueOf) : new String("Unable to read GServices for: "), e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zzfp(String str) {
        return zzru.zza(this.zzri.getContentResolver(), str, (String) null);
    }
}
