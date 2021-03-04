package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzbaa extends zzr<zzp> {
    private final zzbcl<zzp> zzene;
    private final Map<String, String> zzenf;
    private final zzbax zzeng;

    public zzbaa(String str, zzbcl<zzp> zzbcl) {
        this(str, null, zzbcl);
    }

    private zzbaa(String str, Map<String, String> map, zzbcl<zzp> zzbcl) {
        super(0, str, new zzbab(zzbcl));
        this.zzenf = null;
        this.zzene = zzbcl;
        this.zzeng = new zzbax();
        this.zzeng.zza(str, "GET", null, null);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzr
    public final zzx<zzp> zza(zzp zzp) {
        return zzx.zza(zzp, zzap.zzb(zzp));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzr
    public final /* synthetic */ void zza(zzp zzp) {
        zzp zzp2 = zzp;
        this.zzeng.zza(zzp2.zzab, zzp2.statusCode);
        zzbax zzbax = this.zzeng;
        byte[] bArr = zzp2.data;
        if (zzbax.isEnabled() && bArr != null) {
            zzbax.zzi(bArr);
        }
        this.zzene.set(zzp2);
    }
}
