package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* access modifiers changed from: package-private */
public final /* synthetic */ class zzawx implements Callable {
    private final Context zzcmy;
    private final zzaww zzehe;

    zzawx(zzaww zzaww, Context context) {
        this.zzehe = zzaww;
        this.zzcmy = context;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.zzehe.zzac(this.zzcmy);
    }
}
