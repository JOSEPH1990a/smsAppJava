package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.SystemClock;
import javax.annotation.concurrent.GuardedBy;

@zzark
public abstract class zzaph extends zzaxv {
    protected final Context mContext;
    protected final Object mLock = new Object();
    protected final zzapm zzdsj;
    protected final zzaxg zzdsk;
    @GuardedBy("mLock")
    protected zzasm zzdsl;
    protected final Object zzdsn = new Object();

    protected zzaph(Context context, zzaxg zzaxg, zzapm zzapm) {
        super(true);
        this.mContext = context;
        this.zzdsk = zzaxg;
        this.zzdsl = zzaxg.zzehy;
        this.zzdsj = zzapm;
    }

    @Override // com.google.android.gms.internal.ads.zzaxv
    public void onStop() {
    }

    /* access modifiers changed from: protected */
    public abstract void zzap(long j) throws zzapk;

    /* access modifiers changed from: protected */
    public abstract zzaxf zzcr(int i);

    @Override // com.google.android.gms.internal.ads.zzaxv
    public final void zzki() {
        synchronized (this.mLock) {
            zzaxz.zzdn("AdRendererBackgroundTask started.");
            int i = this.zzdsk.errorCode;
            try {
                zzap(SystemClock.elapsedRealtime());
            } catch (zzapk e) {
                int errorCode = e.getErrorCode();
                if (errorCode == 3 || errorCode == -1) {
                    zzaxz.zzen(e.getMessage());
                } else {
                    zzaxz.zzeo(e.getMessage());
                }
                if (this.zzdsl == null) {
                    this.zzdsl = new zzasm(errorCode);
                } else {
                    this.zzdsl = new zzasm(errorCode, this.zzdsl.zzdlx);
                }
                zzayh.zzelc.post(new zzapi(this));
                i = errorCode;
            }
            zzayh.zzelc.post(new zzapj(this, zzcr(i)));
        }
    }
}
