package com.google.android.gms.internal.ads;

import android.util.JsonWriter;

/* access modifiers changed from: package-private */
public final /* synthetic */ class zzbba implements zzbbc {
    private final byte[] zzeot;

    zzbba(byte[] bArr) {
        this.zzeot = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzbbc
    public final void zza(JsonWriter jsonWriter) {
        zzbax.zza(this.zzeot, jsonWriter);
    }
}
