package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

/* access modifiers changed from: package-private */
public class zzcr implements zzct {
    protected final zzbw zzada;

    zzcr(zzbw zzbw) {
        Preconditions.checkNotNull(zzbw);
        this.zzada = zzbw;
    }

    @Override // com.google.android.gms.measurement.internal.zzct
    public zzn zzgw() {
        return this.zzada.zzgw();
    }

    public zzq zzgv() {
        return this.zzada.zzgv();
    }

    public zzbd zzgu() {
        return this.zzada.zzgu();
    }

    @Override // com.google.android.gms.measurement.internal.zzct
    public zzas zzgt() {
        return this.zzada.zzgt();
    }

    @Override // com.google.android.gms.measurement.internal.zzct
    public zzbr zzgs() {
        return this.zzada.zzgs();
    }

    public zzfy zzgr() {
        return this.zzada.zzgr();
    }

    public zzaq zzgq() {
        return this.zzada.zzgq();
    }

    @Override // com.google.android.gms.measurement.internal.zzct
    public Context getContext() {
        return this.zzada.getContext();
    }

    @Override // com.google.android.gms.measurement.internal.zzct
    public Clock zzbx() {
        return this.zzada.zzbx();
    }

    public zzaa zzgp() {
        return this.zzada.zzgp();
    }

    public void zzaf() {
        this.zzada.zzgs().zzaf();
    }

    public void zzgh() {
        this.zzada.zzgs().zzgh();
    }

    public void zzgg() {
        this.zzada.zzgg();
    }

    public void zzgf() {
        this.zzada.zzgf();
    }
}
