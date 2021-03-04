package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.gmsg.zzu;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class zzaja implements zzu<zzajr> {
    private final /* synthetic */ zzajm zzdjh;
    private final /* synthetic */ zzaii zzdji;
    private final /* synthetic */ zzait zzdjj;

    zzaja(zzait zzait, zzajm zzajm, zzaii zzaii) {
        this.zzdjj = zzait;
        this.zzdjh = zzajm;
        this.zzdji = zzaii;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.util.Map] */
    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final /* synthetic */ void zza(zzajr zzajr, Map map) {
        synchronized (zzait.zza(this.zzdjj)) {
            if (this.zzdjh.getStatus() != -1) {
                if (this.zzdjh.getStatus() != 1) {
                    zzait.zza(this.zzdjj, 0);
                    zzait.zzc(this.zzdjj).zzh(this.zzdji);
                    this.zzdjh.zzo(this.zzdji);
                    zzait.zza(this.zzdjj, this.zzdjh);
                    zzaxz.v("Successfully loaded JS Engine.");
                }
            }
        }
    }
}
