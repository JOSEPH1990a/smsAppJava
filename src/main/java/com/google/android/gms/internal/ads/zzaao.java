package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* access modifiers changed from: package-private */
public final class zzaao implements Callable<Void> {
    private final /* synthetic */ Context val$context;

    zzaao(Context context) {
        this.val$context = context;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Void call() throws Exception {
        zzwu.zzpz().initialize(this.val$context);
        return null;
    }
}
