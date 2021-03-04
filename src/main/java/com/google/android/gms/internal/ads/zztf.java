package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* access modifiers changed from: package-private */
public final class zztf implements Comparator<zztl> {
    zztf(zzte zzte) {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zztl zztl, zztl zztl2) {
        zztl zztl3 = zztl;
        zztl zztl4 = zztl2;
        int i = zztl3.zzbzg - zztl4.zzbzg;
        if (i != 0) {
            return i;
        }
        return (int) (zztl3.value - zztl4.value);
    }
}
