package com.google.android.gms.internal.ads;

/* access modifiers changed from: package-private */
@zzark
public final class zzbfe extends zzax {
    static final zzbfe zzewi = new zzbfe();

    zzbfe() {
    }

    @Override // com.google.android.gms.internal.ads.zzax
    public final zzbc zza(String str, byte[] bArr, String str2) {
        if ("moov".equals(str)) {
            return new zzbe();
        }
        if ("mvhd".equals(str)) {
            return new zzbf();
        }
        return new zzbg(str);
    }
}
