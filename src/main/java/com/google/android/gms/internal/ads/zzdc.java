package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

final class zzdc implements zzdh {
    private final /* synthetic */ Activity val$activity;

    zzdc(zzcz zzcz, Activity activity) {
        this.val$activity = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzdh
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityResumed(this.val$activity);
    }
}