package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.gmsg.zzu;
import com.google.android.gms.common.util.Predicate;

final /* synthetic */ class zzaim implements Predicate {
    private final zzu zzdip;

    zzaim(zzu zzu) {
        this.zzdip = zzu;
    }

    @Override // com.google.android.gms.common.util.Predicate
    public final boolean apply(Object obj) {
        zzu zzu = (zzu) obj;
        return (zzu instanceof zzair) && zzair.zza((zzair) zzu).equals(this.zzdip);
    }
}
