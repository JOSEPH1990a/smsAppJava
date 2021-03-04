package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyPairGenerator;
import java.security.Provider;

public final class zzboq implements zzbom<KeyPairGenerator> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzbom
    public final /* synthetic */ KeyPairGenerator zzb(String str, Provider provider) throws GeneralSecurityException {
        if (provider == null) {
            return KeyPairGenerator.getInstance(str);
        }
        return KeyPairGenerator.getInstance(str, provider);
    }
}
