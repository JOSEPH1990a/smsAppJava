package com.google.android.gms.internal.ads;

/* access modifiers changed from: package-private */
public final /* synthetic */ class zzbew implements zzow {
    private final zzow zzewb;
    private final byte[] zzewc;

    zzbew(zzow zzow, byte[] bArr) {
        this.zzewb = zzow;
        this.zzewc = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzow
    public final zzov zzgs() {
        zzow zzow = this.zzewb;
        byte[] bArr = this.zzewc;
        return new zzbfa(new zzou(bArr), bArr.length, zzow.zzgs());
    }
}
