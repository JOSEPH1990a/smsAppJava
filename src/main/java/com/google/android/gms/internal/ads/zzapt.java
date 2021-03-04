package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzbb;
import com.gsmmodem.Servers.MyHttpServer;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzark
public final class zzapt extends zzaxv {
    private final Object mLock;
    private final zzapm zzdsj;
    private final zzaxg zzdsk;
    private final zzasm zzdsl;
    private final zzapw zzdta;
    private Future<zzaxf> zzdtb;

    public zzapt(Context context, zzbb zzbb, zzaxg zzaxg, zzcu zzcu, zzapm zzapm, zzaba zzaba) {
        this(zzaxg, zzapm, new zzapw(context, zzbb, new zzazs(context), zzcu, zzaxg, zzaba));
    }

    private zzapt(zzaxg zzaxg, zzapm zzapm, zzapw zzapw) {
        this.mLock = new Object();
        this.zzdsk = zzaxg;
        this.zzdsl = zzaxg.zzehy;
        this.zzdsj = zzapm;
        this.zzdta = zzapw;
    }

    @Override // com.google.android.gms.internal.ads.zzaxv
    public final void zzki() {
        int i;
        zzaxf zzaxf = null;
        try {
            synchronized (this.mLock) {
                this.zzdtb = zzayf.zza(this.zzdta);
            }
            zzaxf = this.zzdtb.get(MyHttpServer.MINUTE_MILLIS, TimeUnit.MILLISECONDS);
            i = -2;
        } catch (TimeoutException unused) {
            zzaxz.zzeo("Timed out waiting for native ad.");
            this.zzdtb.cancel(true);
            i = 2;
        } catch (ExecutionException unused2) {
            i = 0;
        } catch (InterruptedException unused3) {
            i = 0;
        } catch (CancellationException unused4) {
            i = 0;
        }
        zzayh.zzelc.post(new zzapu(this, zzaxf != null ? zzaxf : new zzaxf(this.zzdsk.zzeag.zzdwg, null, null, i, null, null, this.zzdsl.orientation, this.zzdsl.zzdlx, this.zzdsk.zzeag.zzdwj, false, null, null, null, null, null, this.zzdsl.zzdye, this.zzdsk.zzbst, this.zzdsl.zzdyc, this.zzdsk.zzehn, this.zzdsl.zzdyh, this.zzdsl.zzdyi, this.zzdsk.zzehh, null, null, null, null, this.zzdsk.zzehy.zzdyu, this.zzdsk.zzehy.zzdyv, null, null, this.zzdsl.zzdyy, this.zzdsk.zzehw, this.zzdsk.zzehy.zzbph, false, this.zzdsk.zzehy.zzdzc, null, this.zzdsk.zzehy.zzbpi, this.zzdsk.zzehy.zzdzd, this.zzdsk.zzehy.zzdzf)));
    }

    @Override // com.google.android.gms.internal.ads.zzaxv
    public final void onStop() {
        synchronized (this.mLock) {
            if (this.zzdtb != null) {
                this.zzdtb.cancel(true);
            }
        }
    }
}
