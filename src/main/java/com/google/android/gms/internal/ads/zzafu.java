package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;

final class zzafu implements zzbbl<zzafr, ParcelFileDescriptor> {
    private final /* synthetic */ zzafl zzdgn;

    zzafu(zzaft zzaft, zzafl zzafl) {
        this.zzdgn = zzafl;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzbcb' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzbbl
    public final /* synthetic */ zzbcb<ParcelFileDescriptor> zzf(zzafr zzafr) throws Exception {
        zzbcl zzbcl = new zzbcl();
        zzafr.zza(this.zzdgn, new zzafv(this, zzbcl));
        return zzbcl;
    }
}
