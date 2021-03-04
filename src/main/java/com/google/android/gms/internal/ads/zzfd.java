package com.google.android.gms.internal.ads;

import java.io.IOException;

public abstract class zzfd implements zzfz, zzga {
    private int index;
    private int state;
    private final int zzwg;
    private zzgb zzwh;
    private zzlv zzwi;
    private long zzwj;
    private boolean zzwk = true;
    private boolean zzwl;

    public zzfd(int i) {
        this.zzwg = i;
    }

    /* access modifiers changed from: protected */
    public void onStarted() throws zzff {
    }

    /* access modifiers changed from: protected */
    public void onStopped() throws zzff {
    }

    @Override // com.google.android.gms.internal.ads.zzfi
    public void zza(int i, Object obj) throws zzff {
    }

    /* access modifiers changed from: protected */
    public void zza(long j, boolean z) throws zzff {
    }

    /* access modifiers changed from: protected */
    public void zza(zzfs[] zzfsArr, long j) throws zzff {
    }

    /* access modifiers changed from: protected */
    public void zzb(boolean z) throws zzff {
    }

    @Override // com.google.android.gms.internal.ads.zzfz
    public final zzga zzbe() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfz
    public zzps zzbf() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzga
    public int zzbl() throws zzff {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void zzbm() {
    }

    @Override // com.google.android.gms.internal.ads.zzga, com.google.android.gms.internal.ads.zzfz
    public final int getTrackType() {
        return this.zzwg;
    }

    @Override // com.google.android.gms.internal.ads.zzfz
    public final void setIndex(int i) {
        this.index = i;
    }

    @Override // com.google.android.gms.internal.ads.zzfz
    public final int getState() {
        return this.state;
    }

    @Override // com.google.android.gms.internal.ads.zzfz
    public final void zza(zzgb zzgb, zzfs[] zzfsArr, zzlv zzlv, long j, boolean z, long j2) throws zzff {
        zzpo.checkState(this.state == 0);
        this.zzwh = zzgb;
        this.state = 1;
        zzb(z);
        zza(zzfsArr, zzlv, j2);
        zza(j, z);
    }

    @Override // com.google.android.gms.internal.ads.zzfz
    public final void start() throws zzff {
        boolean z = true;
        if (this.state != 1) {
            z = false;
        }
        zzpo.checkState(z);
        this.state = 2;
        onStarted();
    }

    @Override // com.google.android.gms.internal.ads.zzfz
    public final void zza(zzfs[] zzfsArr, zzlv zzlv, long j) throws zzff {
        zzpo.checkState(!this.zzwl);
        this.zzwi = zzlv;
        this.zzwk = false;
        this.zzwj = j;
        zza(zzfsArr, j);
    }

    @Override // com.google.android.gms.internal.ads.zzfz
    public final zzlv zzbg() {
        return this.zzwi;
    }

    @Override // com.google.android.gms.internal.ads.zzfz
    public final boolean zzbh() {
        return this.zzwk;
    }

    @Override // com.google.android.gms.internal.ads.zzfz
    public final void zzbi() {
        this.zzwl = true;
    }

    @Override // com.google.android.gms.internal.ads.zzfz
    public final boolean zzbj() {
        return this.zzwl;
    }

    @Override // com.google.android.gms.internal.ads.zzfz
    public final void zzbk() throws IOException {
        this.zzwi.zzev();
    }

    @Override // com.google.android.gms.internal.ads.zzfz
    public final void zzd(long j) throws zzff {
        this.zzwl = false;
        this.zzwk = false;
        zza(j, false);
    }

    @Override // com.google.android.gms.internal.ads.zzfz
    public final void stop() throws zzff {
        zzpo.checkState(this.state == 2);
        this.state = 1;
        onStopped();
    }

    @Override // com.google.android.gms.internal.ads.zzfz
    public final void disable() {
        boolean z = true;
        if (this.state != 1) {
            z = false;
        }
        zzpo.checkState(z);
        this.state = 0;
        this.zzwi = null;
        this.zzwl = false;
        zzbm();
    }

    /* access modifiers changed from: protected */
    public final zzgb zzbn() {
        return this.zzwh;
    }

    /* access modifiers changed from: protected */
    public final int getIndex() {
        return this.index;
    }

    /* access modifiers changed from: protected */
    public final int zza(zzfu zzfu, zzho zzho, boolean z) {
        int zzb = this.zzwi.zzb(zzfu, zzho, z);
        if (zzb == -4) {
            if (zzho.zzdp()) {
                this.zzwk = true;
                if (this.zzwl) {
                    return -4;
                }
                return -3;
            }
            zzho.zzago += this.zzwj;
        } else if (zzb == -5) {
            zzfs zzfs = zzfu.zzaad;
            if (zzfs.zzzy != Long.MAX_VALUE) {
                zzfu.zzaad = zzfs.zzj(zzfs.zzzy + this.zzwj);
            }
        }
        return zzb;
    }

    /* access modifiers changed from: protected */
    public final void zze(long j) {
        this.zzwi.zzz(j - this.zzwj);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbo() {
        return this.zzwk ? this.zzwl : this.zzwi.isReady();
    }
}
