package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.Provider;
import javax.crypto.Mac;

public final class zzbor implements zzbom<Mac> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzbom
    public final /* synthetic */ Mac zzb(String str, Provider provider) throws GeneralSecurityException {
        if (provider == null) {
            return Mac.getInstance(str);
        }
        return Mac.getInstance(str, provider);
    }
}
