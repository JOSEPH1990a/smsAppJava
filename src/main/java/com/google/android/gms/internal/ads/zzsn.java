package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

final class zzsn implements zzsp {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ Bundle zzsj;

    zzsn(zzsh zzsh, Activity activity, Bundle bundle) {
        this.val$activity = activity;
        this.zzsj = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzsp
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivitySaveInstanceState(this.val$activity, this.zzsj);
    }
}
