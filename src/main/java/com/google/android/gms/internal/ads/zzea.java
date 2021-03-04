package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ExecutionException;

public final class zzea extends zzeu {
    private static final zzev<zzbv> zzuk = new zzev<>();
    private final Context zzuj;
    private zzbi zzul = null;

    public zzea(zzdl zzdl, String str, String str2, zzbl zzbl, int i, int i2, Context context, zzbi zzbi) {
        super(zzdl, str, str2, zzbl, i, 27);
        this.zzuj = context;
        this.zzul = zzbi;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0086  */
    @Override // com.google.android.gms.internal.ads.zzeu
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzas() throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
        // Method dump skipped, instructions count: 282
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzea.zzas():void");
    }

    private final String zzat() {
        try {
            if (this.zzqo.zzal() != null) {
                this.zzqo.zzal().get();
            }
            zzbl zzak = this.zzqo.zzak();
            if (zzak == null || zzak.zzdq == null) {
                return null;
            }
            return zzak.zzdq;
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }
}
