package com.google.android.gms.internal.ads;

@zzark
public abstract class zzaxv implements zzazb<zzbcb> {
    private volatile Thread zzeke;
    private boolean zzekf = false;
    private final Runnable zzy = new zzaxw(this);

    public zzaxv() {
    }

    public abstract void onStop();

    public abstract void zzki();

    public zzaxv(boolean z) {
    }

    public final zzbcb zzyz() {
        if (!this.zzekf) {
            return zzayf.zzc(this.zzy);
        }
        return zzayf.zzekz.zze(this.zzy);
    }

    @Override // com.google.android.gms.internal.ads.zzazb
    public final void cancel() {
        onStop();
        if (this.zzeke != null) {
            this.zzeke.interrupt();
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzazb
    public final /* synthetic */ zzbcb zzwa() {
        if (!this.zzekf) {
            return zzayf.zzc(this.zzy);
        }
        return zzayf.zzekz.zze(this.zzy);
    }
}
