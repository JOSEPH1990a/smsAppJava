package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

final class zzde implements zzdh {
    private final /* synthetic */ Activity val$activity;

    zzde(zzcz zzcz, Activity activity) {
        this.val$activity = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzdh
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStopped(this.val$activity);
    }
}