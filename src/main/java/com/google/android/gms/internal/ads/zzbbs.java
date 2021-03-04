package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* access modifiers changed from: package-private */
public final /* synthetic */ class zzbbs implements Runnable {
    private final zzbcl zzcak;
    private final zzbbm zzepb;
    private final zzbcb zzepc;

    zzbbs(zzbcl zzbcl, zzbbm zzbbm, zzbcb zzbcb) {
        this.zzcak = zzbcl;
        this.zzepb = zzbbm;
        this.zzepc = zzbcb;
    }

    public final void run() {
        zzbcl zzbcl = this.zzcak;
        try {
            zzbcl.set(this.zzepb.apply(this.zzepc.get()));
        } catch (CancellationException unused) {
            zzbcl.cancel(true);
        } catch (ExecutionException e) {
            e = e;
            Throwable cause = e.getCause();
            if (cause != null) {
                e = cause;
            }
            zzbcl.setException(e);
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            zzbcl.setException(e2);
        } catch (Exception e3) {
            zzbcl.setException(e3);
        }
    }
}
