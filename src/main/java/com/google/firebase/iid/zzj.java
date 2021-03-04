package com.google.firebase.iid;

import java.util.concurrent.ThreadFactory;

/* access modifiers changed from: package-private */
public final /* synthetic */ class zzj implements ThreadFactory {
    static final ThreadFactory zzae = new zzj();

    private zzj() {
    }

    public final Thread newThread(Runnable runnable) {
        return zzi.zza(runnable);
    }
}
