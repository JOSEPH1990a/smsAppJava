package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzmk implements zzlv {
    private final int index;
    public final zzmj<T> zzbap;
    private final zzls zzbaq;
    private final /* synthetic */ zzmj zzbar;

    public zzmk(zzmj zzmj, zzmj<T> zzmj2, zzls zzls, int i) {
        this.zzbar = zzmj;
        this.zzbap = zzmj2;
        this.zzbaq = zzls;
        this.index = i;
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final void zzev() throws IOException {
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final boolean isReady() {
        if (!this.zzbar.zzaxm) {
            return !this.zzbar.zzfd() && this.zzbaq.zzfm();
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final void zzz(long j) {
        if (!this.zzbar.zzaxm || j <= this.zzbaq.zzfc()) {
            this.zzbaq.zze(j, true);
        } else {
            this.zzbaq.zzfp();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final int zzb(zzfu zzfu, zzho zzho, boolean z) {
        if (this.zzbar.zzfd()) {
            return -3;
        }
        return this.zzbaq.zza(zzfu, zzho, z, this.zzbar.zzaxm, this.zzbar.zzaxj);
    }

    public final void release() {
        zzpo.checkState(zzmj.zza(this.zzbar)[this.index]);
        zzmj.zza(this.zzbar)[this.index] = false;
    }
}
