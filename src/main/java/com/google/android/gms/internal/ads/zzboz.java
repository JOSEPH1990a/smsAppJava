package com.google.android.gms.internal.ads;

import java.security.SecureRandom;

final class zzboz extends ThreadLocal<SecureRandom> {
    zzboz() {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // java.lang.ThreadLocal
    public final /* synthetic */ SecureRandom initialValue() {
        return zzboy.zzakb();
    }
}
