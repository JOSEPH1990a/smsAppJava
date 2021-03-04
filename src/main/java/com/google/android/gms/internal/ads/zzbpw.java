package com.google.android.gms.internal.ads;

import java.util.Comparator;

final class zzbpw implements Comparator<zzbpu> {
    zzbpw() {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzbpu zzbpu, zzbpu zzbpu2) {
        zzbpu zzbpu3 = zzbpu;
        zzbpu zzbpu4 = zzbpu2;
        zzbqa zzbqa = (zzbqa) zzbpu3.iterator();
        zzbqa zzbqa2 = (zzbqa) zzbpu4.iterator();
        while (zzbqa.hasNext() && zzbqa2.hasNext()) {
            int compare = Integer.compare(zzbpu.zzb(zzbqa.nextByte()), zzbpu.zzb(zzbqa2.nextByte()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzbpu3.size(), zzbpu4.size());
    }
}
