package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class zzf implements zzt {
    private final Map<String, List<zzr<?>>> zzp = new HashMap();
    private final zzd zzq;

    zzf(zzd zzd) {
        this.zzq = zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzt
    public final void zza(zzr<?> zzr, zzx<?> zzx) {
        List<zzr<?>> remove;
        if (zzx.zzbg == null || zzx.zzbg.zzb()) {
            zza(zzr);
            return;
        }
        String zzf = zzr.zzf();
        synchronized (this) {
            remove = this.zzp.remove(zzf);
        }
        if (remove != null) {
            if (zzaf.DEBUG) {
                zzaf.v("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), zzf);
            }
            for (zzr<?> zzr2 : remove) {
                zzd.zzb(this.zzq).zzb(zzr2, zzx);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzt
    public final synchronized void zza(zzr<?> zzr) {
        String zzf = zzr.zzf();
        List<zzr<?>> remove = this.zzp.remove(zzf);
        if (remove != null && !remove.isEmpty()) {
            if (zzaf.DEBUG) {
                zzaf.v("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(remove.size()), zzf);
            }
            zzr<?> remove2 = remove.remove(0);
            this.zzp.put(zzf, remove);
            remove2.zza((zzt) this);
            try {
                zzd.zza(this.zzq).put(remove2);
            } catch (InterruptedException e) {
                zzaf.e("Couldn't add request to queue. %s", e.toString());
                Thread.currentThread().interrupt();
                this.zzq.quit();
            }
        }
    }

    /* access modifiers changed from: private */
    public final synchronized boolean zzb(zzr<?> zzr) {
        String zzf = zzr.zzf();
        if (this.zzp.containsKey(zzf)) {
            List<zzr<?>> list = this.zzp.get(zzf);
            if (list == null) {
                list = new ArrayList<>();
            }
            zzr.zzb("waiting-for-response");
            list.add(zzr);
            this.zzp.put(zzf, list);
            if (zzaf.DEBUG) {
                zzaf.d("Request for cacheKey=%s is in flight, putting on hold.", zzf);
            }
            return true;
        }
        this.zzp.put(zzf, null);
        zzr.zza((zzt) this);
        if (zzaf.DEBUG) {
            zzaf.d("new request, sending to network %s", zzf);
        }
        return false;
    }
}
