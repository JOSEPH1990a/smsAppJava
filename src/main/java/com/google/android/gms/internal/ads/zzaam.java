package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* access modifiers changed from: package-private */
public final class zzaam implements Callable<T> {
    private final /* synthetic */ zzaac zzcnt;
    private final /* synthetic */ zzaak zzcnu;

    zzaam(zzaak zzaak, zzaac zzaac) {
        this.zzcnu = zzaak;
        this.zzcnt = zzaac;
    }

    @Override // java.util.concurrent.Callable
    public final T call() {
        return (T) this.zzcnt.zza(this.zzcnu.zzcnp);
    }
}
