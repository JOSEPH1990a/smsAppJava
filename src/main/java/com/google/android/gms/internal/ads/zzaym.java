package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzbv;

/* access modifiers changed from: package-private */
public final class zzaym implements zzbaw {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ String zzelm;

    zzaym(zzayh zzayh, Context context, String str) {
        this.val$context = context;
        this.zzelm = str;
    }

    @Override // com.google.android.gms.internal.ads.zzbaw
    public final void zzed(String str) {
        zzbv.zzlf();
        zzayh.zzc(this.val$context, this.zzelm, str);
    }
}
