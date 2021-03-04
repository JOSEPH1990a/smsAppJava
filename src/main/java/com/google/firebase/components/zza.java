package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-common@@16.0.2 */
public abstract class zza implements ComponentContainer {
    zza() {
    }

    @Override // com.google.firebase.components.ComponentContainer
    public <T> T get(Class<T> cls) {
        Provider<T> provider = getProvider(cls);
        if (provider == null) {
            return null;
        }
        return provider.get();
    }
}
