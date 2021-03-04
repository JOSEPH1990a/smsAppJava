package com.google.android.gms.internal.measurement;

import java.util.Comparator;

final class zztg implements Comparator<zzte> {
    zztg() {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzte zzte, zzte zzte2) {
        zzte zzte3 = zzte;
        zzte zzte4 = zzte2;
        zztl zztl = (zztl) zzte3.iterator();
        zztl zztl2 = (zztl) zzte4.iterator();
        while (zztl.hasNext() && zztl2.hasNext()) {
            int compare = Integer.compare(zzte.zza(zztl.nextByte()), zzte.zza(zztl2.nextByte()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzte3.size(), zzte4.size());
    }
}
