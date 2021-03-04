package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Signature;

public final class zzbot implements zzbom<Signature> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzbom
    public final /* synthetic */ Signature zzb(String str, Provider provider) throws GeneralSecurityException {
        if (provider == null) {
            return Signature.getInstance(str);
        }
        return Signature.getInstance(str, provider);
    }
}
