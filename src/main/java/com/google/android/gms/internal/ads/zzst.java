package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.common.util.PlatformVersion;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@zzark
@ParametersAreNonnullByDefault
public final class zzst {
    private final Object zzbxp = new Object();
    @GuardedBy("mActivityTrackerLock")
    private zzsu zzbxq = null;
    @GuardedBy("mActivityTrackerLock")
    private boolean zzbxr = false;

    public final void initialize(Context context) {
        synchronized (this.zzbxp) {
            if (!this.zzbxr) {
                if (PlatformVersion.isAtLeastIceCreamSandwich()) {
                    Application application = null;
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext == null) {
                        applicationContext = context;
                    }
                    if (applicationContext instanceof Application) {
                        application = (Application) applicationContext;
                    }
                    if (application == null) {
                        zzaxz.zzeo("Can not cast Context to Application");
                        return;
                    }
                    if (this.zzbxq == null) {
                        this.zzbxq = new zzsu();
                    }
                    this.zzbxq.zza(application, context);
                    this.zzbxr = true;
                }
            }
        }
    }

    public final void zza(zzsw zzsw) {
        synchronized (this.zzbxp) {
            if (PlatformVersion.isAtLeastIceCreamSandwich()) {
                if (this.zzbxq == null) {
                    this.zzbxq = new zzsu();
                }
                this.zzbxq.zza(zzsw);
            }
        }
    }

    @Nullable
    public final Activity getActivity() {
        synchronized (this.zzbxp) {
            if (!PlatformVersion.isAtLeastIceCreamSandwich()) {
                return null;
            }
            if (this.zzbxq == null) {
                return null;
            }
            return this.zzbxq.getActivity();
        }
    }

    @Nullable
    public final Context getContext() {
        synchronized (this.zzbxp) {
            if (!PlatformVersion.isAtLeastIceCreamSandwich()) {
                return null;
            }
            if (this.zzbxq == null) {
                return null;
            }
            return this.zzbxq.getContext();
        }
    }
}
