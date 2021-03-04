package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzavm implements Runnable {
    private final /* synthetic */ zzwb zzbod;
    private final /* synthetic */ zzalj zzeey;
    private final /* synthetic */ zzavk zzeez;
    private final /* synthetic */ zzavs zzefa;

    zzavm(zzavk zzavk, zzalj zzalj, zzwb zzwb, zzavs zzavs) {
        this.zzeez = zzavk;
        this.zzeey = zzalj;
        this.zzbod = zzwb;
        this.zzefa = zzavs;
    }

    public final void run() {
        try {
            this.zzeey.zza(ObjectWrapper.wrap(zzavk.zza(this.zzeez)), this.zzbod, (String) null, this.zzefa, zzavk.zzb(this.zzeez));
        } catch (RemoteException e) {
            String valueOf = String.valueOf(this.zzeez.zzdml);
            zzaxz.zzc(valueOf.length() != 0 ? "Fail to initialize adapter ".concat(valueOf) : new String("Fail to initialize adapter "), e);
            zzavk zzavk = this.zzeez;
            zzavk.zza(zzavk.zzdml, 0);
        }
    }
}
