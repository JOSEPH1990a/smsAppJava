package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.gmsg.zzu;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class zzaqa implements zzu<Object> {
    private final /* synthetic */ zzapw zzdtp;
    private final /* synthetic */ zzabw zzdtq;

    zzaqa(zzapw zzapw, zzabw zzabw) {
        this.zzdtp = zzapw;
        this.zzdtq = zzabw;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final void zza(Object obj, Map<String, String> map) {
        this.zzdtp.zzc((zzapw) this.zzdtq, (zzadx) map.get("asset"));
    }
}
