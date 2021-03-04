package com.google.android.gms.internal.ads;

import java.util.Comparator;

public final class zzto implements Comparator<zztc> {
    public zzto(zztn zztn) {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zztc zztc, zztc zztc2) {
        zztc zztc3 = zztc;
        zztc zztc4 = zztc2;
        if (zztc3.zzny() < zztc4.zzny()) {
            return -1;
        }
        if (zztc3.zzny() > zztc4.zzny()) {
            return 1;
        }
        if (zztc3.zznx() < zztc4.zznx()) {
            return -1;
        }
        if (zztc3.zznx() > zztc4.zznx()) {
            return 1;
        }
        float zzoa = (zztc3.zzoa() - zztc3.zzny()) * (zztc3.zznz() - zztc3.zznx());
        float zzoa2 = (zztc4.zzoa() - zztc4.zzny()) * (zztc4.zznz() - zztc4.zznx());
        if (zzoa > zzoa2) {
            return -1;
        }
        if (zzoa < zzoa2) {
            return 1;
        }
        return 0;
    }
}
