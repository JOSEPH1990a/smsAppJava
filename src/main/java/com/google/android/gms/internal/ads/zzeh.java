package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

public final class zzeh extends zzeu {
    private long zzup = -1;

    public zzeh(zzdl zzdl, String str, String str2, zzbl zzbl, int i, int i2) {
        super(zzdl, str, str2, zzbl, i, 12);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzeu
    public final void zzas() throws IllegalAccessException, InvocationTargetException {
        this.zzun.zzeg = -1L;
        this.zzun.zzeg = (Long) this.zzuw.invoke(null, this.zzqo.getContext());
    }
}
