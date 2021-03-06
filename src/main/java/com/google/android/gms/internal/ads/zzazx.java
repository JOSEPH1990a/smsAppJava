package com.google.android.gms.internal.ads;

import java.util.Map;

/* access modifiers changed from: package-private */
public final class zzazx extends zzaw {
    private final /* synthetic */ byte[] zzenb;
    private final /* synthetic */ Map zzenc;
    private final /* synthetic */ zzbax zzend;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzazx(zzazs zzazs, int i, String str, zzz zzz, zzy zzy, byte[] bArr, Map map, zzbax zzbax) {
        super(i, str, zzz, zzy);
        this.zzenb = bArr;
        this.zzenc = map;
        this.zzend = zzbax;
    }

    @Override // com.google.android.gms.internal.ads.zzr
    public final byte[] zzh() throws zza {
        byte[] bArr = this.zzenb;
        return bArr == null ? super.zzh() : bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzr
    public final Map<String, String> getHeaders() throws zza {
        Map<String, String> map = this.zzenc;
        return map == null ? super.getHeaders() : map;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzaw
    public final void zzh(String str) {
        this.zzend.zzek(str);
        super.zza(str);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzr, com.google.android.gms.internal.ads.zzaw
    public final /* synthetic */ void zza(String str) {
        zza(str);
    }
}
