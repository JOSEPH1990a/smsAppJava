package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

final class zzdb implements zzdh {
    private final /* synthetic */ Activity val$activity;

    zzdb(zzcz zzcz, Activity activity) {
        this.val$activity = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzdh
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStarted(this.val$activity);
    }
}
