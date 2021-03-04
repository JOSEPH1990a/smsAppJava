package com.google.android.gms.internal.ads;

import java.io.PrintWriter;

final class zzbpj extends zzbpf {
    zzbpj() {
    }

    @Override // com.google.android.gms.internal.ads.zzbpf
    public final void zze(Throwable th) {
        th.printStackTrace();
    }

    @Override // com.google.android.gms.internal.ads.zzbpf
    public final void zza(Throwable th, PrintWriter printWriter) {
        th.printStackTrace(printWriter);
    }
}
