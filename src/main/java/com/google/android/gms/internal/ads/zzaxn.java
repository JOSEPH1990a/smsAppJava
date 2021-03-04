package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzbv;

/* access modifiers changed from: package-private */
public final class zzaxn {
    private final Object mLock;
    private volatile int zzejg;
    private volatile long zzejh;

    private zzaxn() {
        this.mLock = new Object();
        this.zzejg = zzaxo.zzeji;
        this.zzejh = 0;
    }

    private final void zzk(int i, int i2) {
        zzyu();
        long currentTimeMillis = zzbv.zzlm().currentTimeMillis();
        synchronized (this.mLock) {
            if (this.zzejg == i) {
                this.zzejg = i2;
                if (this.zzejg == zzaxo.zzejk) {
                    this.zzejh = currentTimeMillis;
                }
            }
        }
    }

    private final void zzyu() {
        long currentTimeMillis = zzbv.zzlm().currentTimeMillis();
        synchronized (this.mLock) {
            if (this.zzejg == zzaxo.zzejk) {
                if (this.zzejh + ((Long) zzwu.zzpz().zzd(zzaan.zzcye)).longValue() <= currentTimeMillis) {
                    this.zzejg = zzaxo.zzeji;
                }
            }
        }
    }

    public final void zzal(boolean z) {
        if (z) {
            zzk(zzaxo.zzeji, zzaxo.zzejj);
        } else {
            zzk(zzaxo.zzejj, zzaxo.zzeji);
        }
    }

    public final boolean zzyj() {
        zzyu();
        return this.zzejg == zzaxo.zzejj;
    }

    public final boolean zzyk() {
        zzyu();
        return this.zzejg == zzaxo.zzejk;
    }

    public final void zzyl() {
        zzk(zzaxo.zzejj, zzaxo.zzejk);
    }

    /* synthetic */ zzaxn(zzaxm zzaxm) {
        this();
    }
}
