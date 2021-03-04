package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

@zzark
final class zzbfa implements zzov {
    private Uri uri;
    private final zzov zzewe;
    private final long zzewf;
    private final zzov zzewg;
    private long zzewh;

    zzbfa(zzov zzov, int i, zzov zzov2) {
        this.zzewe = zzov;
        this.zzewf = (long) i;
        this.zzewg = zzov2;
    }

    @Override // com.google.android.gms.internal.ads.zzov
    public final long zza(zzoz zzoz) throws IOException {
        zzoz zzoz2;
        zzoz zzoz3;
        long j;
        this.uri = zzoz.uri;
        if (zzoz.zzaha >= this.zzewf) {
            zzoz2 = null;
        } else {
            long j2 = zzoz.zzaha;
            if (zzoz.zzcc != -1) {
                j = Math.min(zzoz.zzcc, this.zzewf - j2);
            } else {
                j = this.zzewf - j2;
            }
            zzoz2 = new zzoz(zzoz.uri, j2, j, null);
        }
        if (zzoz.zzcc == -1 || zzoz.zzaha + zzoz.zzcc > this.zzewf) {
            zzoz3 = new zzoz(zzoz.uri, Math.max(this.zzewf, zzoz.zzaha), zzoz.zzcc != -1 ? Math.min(zzoz.zzcc, (zzoz.zzaha + zzoz.zzcc) - this.zzewf) : -1, null);
        } else {
            zzoz3 = null;
        }
        long j3 = 0;
        long zza = zzoz2 != null ? this.zzewe.zza(zzoz2) : 0;
        if (zzoz3 != null) {
            j3 = this.zzewg.zza(zzoz3);
        }
        this.zzewh = zzoz.zzaha;
        if (zza == -1 || j3 == -1) {
            return -1;
        }
        return zza + j3;
    }

    @Override // com.google.android.gms.internal.ads.zzov
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        long j = this.zzewh;
        long j2 = this.zzewf;
        if (j < j2) {
            i3 = this.zzewe.read(bArr, i, (int) Math.min((long) i2, j2 - j));
            this.zzewh += (long) i3;
        } else {
            i3 = 0;
        }
        if (this.zzewh < this.zzewf) {
            return i3;
        }
        int read = this.zzewg.read(bArr, i + i3, i2 - i3);
        int i4 = i3 + read;
        this.zzewh += (long) read;
        return i4;
    }

    @Override // com.google.android.gms.internal.ads.zzov
    public final Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.gms.internal.ads.zzov
    public final void close() throws IOException {
        this.zzewe.close();
        this.zzewg.close();
    }
}
