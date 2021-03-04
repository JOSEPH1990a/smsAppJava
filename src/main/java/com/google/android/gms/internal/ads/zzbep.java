package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;

@zzark
public final class zzbep implements zzov {
    private boolean isOpen;
    private Uri uri;
    private InputStream zzevf;
    private final zzov zzevg;
    @Nullable
    private final zzpn<zzov> zzevh;
    private final zzbeq zzevi;
    private final Context zzsp;

    public zzbep(Context context, zzov zzov, zzpn<zzov> zzpn, zzbeq zzbeq) {
        this.zzsp = context;
        this.zzevg = zzov;
        this.zzevh = zzpn;
        this.zzevi = zzbeq;
    }

    @Override // com.google.android.gms.internal.ads.zzov
    public final void close() throws IOException {
        if (this.isOpen) {
            this.isOpen = false;
            this.uri = null;
            InputStream inputStream = this.zzevf;
            if (inputStream != null) {
                IOUtils.closeQuietly(inputStream);
                this.zzevf = null;
            } else {
                this.zzevg.close();
            }
            zzpn<zzov> zzpn = this.zzevh;
            if (zzpn != null) {
                zzpn.zze(this);
                return;
            }
            return;
        }
        throw new IOException("Attempt to close an already closed CacheDataSource.");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x009f */
    @Override // com.google.android.gms.internal.ads.zzov
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zza(com.google.android.gms.internal.ads.zzoz r19) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 368
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbep.zza(com.google.android.gms.internal.ads.zzoz):long");
    }

    @Override // com.google.android.gms.internal.ads.zzov
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (this.isOpen) {
            InputStream inputStream = this.zzevf;
            if (inputStream != null) {
                i3 = inputStream.read(bArr, i, i2);
            } else {
                i3 = this.zzevg.read(bArr, i, i2);
            }
            zzpn<zzov> zzpn = this.zzevh;
            if (zzpn != null) {
                zzpn.zzc(this, i3);
            }
            return i3;
        }
        throw new IOException("Attempt to read closed CacheDataSource.");
    }

    @Override // com.google.android.gms.internal.ads.zzov
    public final Uri getUri() {
        return this.uri;
    }
}
