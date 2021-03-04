package com.google.android.gms.internal.ads;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class zzav extends ByteArrayOutputStream {
    private final zzak zzbq;

    public zzav(zzak zzak, int i) {
        this.zzbq = zzak;
        this.buf = this.zzbq.zzb(Math.max(i, 256));
    }

    @Override // java.io.OutputStream, java.io.ByteArrayOutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.zzbq.zza(this.buf);
        this.buf = null;
        super.close();
    }

    @Override // java.lang.Object
    public final void finalize() {
        this.zzbq.zza(this.buf);
    }

    private final void zzc(int i) {
        if (this.count + i > this.buf.length) {
            byte[] zzb = this.zzbq.zzb((this.count + i) << 1);
            System.arraycopy(this.buf, 0, zzb, 0, this.count);
            this.zzbq.zza(this.buf);
            this.buf = zzb;
        }
    }

    @Override // java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i, int i2) {
        zzc(i2);
        super.write(bArr, i, i2);
    }

    @Override // java.io.OutputStream, java.io.ByteArrayOutputStream
    public final synchronized void write(int i) {
        zzc(1);
        super.write(i);
    }
}
