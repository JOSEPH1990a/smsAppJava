package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.gmsg.zzu;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class zzajb implements zzu<zzajr> {
    private final /* synthetic */ zzaii zzdji;
    private final /* synthetic */ zzait zzdjj;
    private final /* synthetic */ zzcu zzdjk;
    private final /* synthetic */ zzbaj zzdjl;

    zzajb(zzait zzait, zzcu zzcu, zzaii zzaii, zzbaj zzbaj) {
        this.zzdjj = zzait;
        this.zzdjk = zzcu;
        this.zzdji = zzaii;
        this.zzdjl = zzbaj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.util.Map] */
    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final /* synthetic */ void zza(zzajr zzajr, Map map) {
        synchronized (zzait.zza(this.zzdjj)) {
            zzaxz.zzen("JS Engine is requesting an update");
            if (zzait.zzd(this.zzdjj) == 0) {
                zzaxz.zzen("Starting reload.");
                zzait.zza(this.zzdjj, 2);
                this.zzdjj.zza(this.zzdjk);
            }
            this.zzdji.zzb("/requestReload", (zzu) this.zzdjl.get());
        }
    }
}
