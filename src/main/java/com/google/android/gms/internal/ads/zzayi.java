package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* access modifiers changed from: package-private */
public final /* synthetic */ class zzayi implements Callable {
    private final Context zzcmy;
    private final zzayh zzeli;

    zzayi(zzayh zzayh, Context context) {
        this.zzeli = zzayh;
        this.zzcmy = context;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Context context = this.zzcmy;
        if (!((Boolean) zzwu.zzpz().zzd(zzaan.zzcym)).booleanValue()) {
            return "";
        }
        return context.getSharedPreferences("mobileads_consent", 0).getString("consent_string", "");
    }
}
