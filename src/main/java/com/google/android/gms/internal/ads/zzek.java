package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public final class zzek extends zzeu {
    private List<Long> zzuq = null;

    public zzek(zzdl zzdl, String str, String str2, zzbl zzbl, int i, int i2) {
        super(zzdl, str, str2, zzbl, i, 31);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzeu
    public final void zzas() throws IllegalAccessException, InvocationTargetException {
        this.zzun.zzes = -1L;
        this.zzun.zzet = -1L;
        if (this.zzuq == null) {
            this.zzuq = (List) this.zzuw.invoke(null, this.zzqo.getContext());
        }
        List<Long> list = this.zzuq;
        if (list != null && list.size() == 2) {
            synchronized (this.zzun) {
                this.zzun.zzes = Long.valueOf(this.zzuq.get(0).longValue());
                this.zzun.zzet = Long.valueOf(this.zzuq.get(1).longValue());
            }
        }
    }
}
