package com.google.android.gms.internal.ads;

import android.util.JsonWriter;

/* access modifiers changed from: package-private */
public final /* synthetic */ class zzbbb implements zzbbc {
    private final String zzeoq;

    zzbbb(String str) {
        this.zzeoq = str;
    }

    @Override // com.google.android.gms.internal.ads.zzbbc
    public final void zza(JsonWriter jsonWriter) {
        zzbax.zza(this.zzeoq, jsonWriter);
    }
}
