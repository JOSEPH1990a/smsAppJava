package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzbv;

/* access modifiers changed from: package-private */
public final class zzaxm extends zzaxv {
    private final /* synthetic */ zzaxk zzejf;

    zzaxm(zzaxk zzaxk) {
        this.zzejf = zzaxk;
    }

    @Override // com.google.android.gms.internal.ads.zzaxv
    public final void onStop() {
    }

    @Override // com.google.android.gms.internal.ads.zzaxv
    public final void zzki() {
        zzaap zzaap = new zzaap(this.zzejf.mContext, this.zzejf.zzbob.zzdp);
        synchronized (this.zzejf.mLock) {
            try {
                zzbv.zzlo();
                zzaas.zza(this.zzejf.zzeix, zzaap);
            } catch (IllegalArgumentException e) {
                zzaxz.zzc("Cannot config CSI reporter.", e);
            }
        }
    }
}
