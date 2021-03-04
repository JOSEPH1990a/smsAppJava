package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-common@@16.0.2 */
public final class zzj<T> implements Provider<T> {
    private static final Object zza = new Object();
    private volatile Object zzb = zza;
    private volatile Provider<T> zzc;

    zzj(ComponentFactory<T> componentFactory, ComponentContainer componentContainer) {
        this.zzc = zzk.zza(componentFactory, componentContainer);
    }

    @Override // com.google.firebase.inject.Provider
    public final T get() {
        T t = (T) this.zzb;
        if (t == zza) {
            synchronized (this) {
                t = this.zzb;
                if (t == zza) {
                    t = this.zzc.get();
                    this.zzb = t;
                    this.zzc = null;
                }
            }
        }
        return t;
    }
}
