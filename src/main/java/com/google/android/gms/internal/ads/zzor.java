package com.google.android.gms.internal.ads;

public final class zzor {
    public final zzma zzbfk;
    public final zzoo zzbfl;
    public final Object zzbfm;
    public final zzgb[] zzbfn;

    public zzor(zzma zzma, zzoo zzoo, Object obj, zzgb[] zzgbArr) {
        this.zzbfk = zzma;
        this.zzbfl = zzoo;
        this.zzbfm = obj;
        this.zzbfn = zzgbArr;
    }

    public final boolean zza(zzor zzor, int i) {
        if (zzor != null && zzqe.zza(this.zzbfl.zzbe(i), zzor.zzbfl.zzbe(i)) && zzqe.zza(this.zzbfn[i], zzor.zzbfn[i])) {
            return true;
        }
        return false;
    }
}
