package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;

/* access modifiers changed from: package-private */
public class zzto extends zztn {
    protected final byte[] zzbtx;

    zzto(byte[] bArr) {
        if (bArr != null) {
            this.zzbtx = bArr;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: protected */
    public int zzug() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzte
    public byte zzam(int i) {
        return this.zzbtx[i];
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzte
    public byte zzan(int i) {
        return this.zzbtx[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzte
    public int size() {
        return this.zzbtx.length;
    }

    @Override // com.google.android.gms.internal.measurement.zzte
    public final zzte zzb(int i, int i2) {
        int zzb = zzb(0, i2, size());
        if (zzb == 0) {
            return zzte.zzbtq;
        }
        return new zztj(this.zzbtx, zzug(), zzb);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzte
    public final void zza(zztd zztd) throws IOException {
        zztd.zza(this.zzbtx, zzug(), size());
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzte
    public final String zza(Charset charset) {
        return new String(this.zzbtx, zzug(), size(), charset);
    }

    @Override // com.google.android.gms.internal.measurement.zzte
    public final boolean zzue() {
        int zzug = zzug();
        return zzxl.zzf(this.zzbtx, zzug, size() + zzug);
    }

    @Override // com.google.android.gms.internal.measurement.zzte
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzte) || size() != ((zzte) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzto)) {
            return obj.equals(this);
        }
        zzto zzto = (zzto) obj;
        int zzuf = zzuf();
        int zzuf2 = zzto.zzuf();
        if (zzuf == 0 || zzuf2 == 0 || zzuf == zzuf2) {
            return zza(zzto, 0, size());
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zztn
    public final boolean zza(zzte zzte, int i, int i2) {
        if (i2 > zzte.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 > zzte.size()) {
            int size2 = zzte.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (!(zzte instanceof zzto)) {
            return zzte.zzb(0, i2).equals(zzb(0, i2));
        } else {
            zzto zzto = (zzto) zzte;
            byte[] bArr = this.zzbtx;
            byte[] bArr2 = zzto.zzbtx;
            int zzug = zzug() + i2;
            int zzug2 = zzug();
            int zzug3 = zzto.zzug();
            while (zzug2 < zzug) {
                if (bArr[zzug2] != bArr2[zzug3]) {
                    return false;
                }
                zzug2++;
                zzug3++;
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzte
    public final int zza(int i, int i2, int i3) {
        return zzuq.zza(i, this.zzbtx, zzug(), i3);
    }
}
