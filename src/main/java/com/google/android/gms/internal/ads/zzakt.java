package com.google.android.gms.internal.ads;

import android.support.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@zzark
@ParametersAreNonnullByDefault
public final class zzakt extends zzaln {
    private final Object mLock = new Object();
    @GuardedBy("mLock")
    private zzaky zzdmj;
    @GuardedBy("mLock")
    private zzaks zzdmk;

    @Override // com.google.android.gms.internal.ads.zzalm
    public final void onVideoPause() {
    }

    @Override // com.google.android.gms.internal.ads.zzalm
    public final void zzc(zzawd zzawd) {
    }

    @Override // com.google.android.gms.internal.ads.zzalm
    public final void zzcl(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzalm
    public final void zzul() {
    }

    public final void zza(zzaky zzaky) {
        synchronized (this.mLock) {
            this.zzdmj = zzaky;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalm
    public final void onAdClicked() {
        synchronized (this.mLock) {
            if (this.zzdmk != null) {
                this.zzdmk.zziy();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalm
    public final void onAdClosed() {
        synchronized (this.mLock) {
            if (this.zzdmk != null) {
                this.zzdmk.zziz();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalm
    public final void onAdFailedToLoad(int i) {
        synchronized (this.mLock) {
            if (this.zzdmj != null) {
                this.zzdmj.zzco(i == 3 ? 1 : 2);
                this.zzdmj = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalm
    public final void onAdLeftApplication() {
        synchronized (this.mLock) {
            if (this.zzdmk != null) {
                this.zzdmk.zzja();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalm
    public final void onAdOpened() {
        synchronized (this.mLock) {
            if (this.zzdmk != null) {
                this.zzdmk.zzjb();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalm
    public final void onAdLoaded() {
        synchronized (this.mLock) {
            if (this.zzdmj != null) {
                this.zzdmj.zzco(0);
                this.zzdmj = null;
                return;
            }
            if (this.zzdmk != null) {
                this.zzdmk.zzjc();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalm
    public final void zza(zzalp zzalp) {
        synchronized (this.mLock) {
            if (this.zzdmj != null) {
                this.zzdmj.zza(0, zzalp);
                this.zzdmj = null;
                return;
            }
            if (this.zzdmk != null) {
                this.zzdmk.zzjc();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalm
    public final void onAdImpression() {
        synchronized (this.mLock) {
            if (this.zzdmk != null) {
                this.zzdmk.zzjd();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalm
    public final void onAppEvent(String str, String str2) {
        synchronized (this.mLock) {
            if (this.zzdmk != null) {
                this.zzdmk.zzd(str, str2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalm
    public final void zzb(zzadx zzadx, String str) {
        synchronized (this.mLock) {
            if (this.zzdmk != null) {
                this.zzdmk.zza(zzadx, str);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalm
    public final void onVideoEnd() {
        synchronized (this.mLock) {
            if (this.zzdmk != null) {
                this.zzdmk.zzix();
            }
        }
    }

    public final void zza(@Nullable zzaks zzaks) {
        synchronized (this.mLock) {
            this.zzdmk = zzaks;
        }
    }
}
