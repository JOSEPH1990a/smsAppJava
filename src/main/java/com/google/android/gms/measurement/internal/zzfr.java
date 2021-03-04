package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class zzfr implements zzay {
    private final /* synthetic */ zzfo zzaue;

    zzfr(zzfo zzfo) {
        this.zzaue = zzfo;
    }

    @Override // com.google.android.gms.measurement.internal.zzay
    public final void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        this.zzaue.zzb(str, i, th, bArr, map);
    }
}
