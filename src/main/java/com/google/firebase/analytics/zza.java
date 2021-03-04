package com.google.firebase.analytics;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;

final class zza implements Callable<String> {
    private final /* synthetic */ FirebaseAnalytics zzbso;

    zza(FirebaseAnalytics firebaseAnalytics) {
        this.zzbso = firebaseAnalytics;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        String zza = FirebaseAnalytics.zza(this.zzbso);
        if (zza != null) {
            return zza;
        }
        String zzag = FirebaseAnalytics.zzb(this.zzbso).zzgj().zzag(120000);
        if (zzag != null) {
            FirebaseAnalytics.zza(this.zzbso, zzag);
            return zzag;
        }
        throw new TimeoutException();
    }
}
