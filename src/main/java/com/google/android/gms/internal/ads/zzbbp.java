package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzbv;
import javax.annotation.Nullable;

/* access modifiers changed from: package-private */
public final class zzbbp implements zzbbn {
    private final /* synthetic */ String zzeoy;

    zzbbp(String str) {
        this.zzeoy = str;
    }

    @Override // com.google.android.gms.internal.ads.zzbbn
    public final void zzl(@Nullable Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzbbn
    public final void zzb(Throwable th) {
        zzbv.zzlj().zza(th, this.zzeoy);
    }
}
