package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import java.util.Map;

/* access modifiers changed from: package-private */
public final /* synthetic */ class zzbaz implements zzbbc {
    private final Map zzdcq;
    private final int zzeos;

    zzbaz(int i, Map map) {
        this.zzeos = i;
        this.zzdcq = map;
    }

    @Override // com.google.android.gms.internal.ads.zzbbc
    public final void zza(JsonWriter jsonWriter) {
        zzbax.zza(this.zzeos, this.zzdcq, jsonWriter);
    }
}
