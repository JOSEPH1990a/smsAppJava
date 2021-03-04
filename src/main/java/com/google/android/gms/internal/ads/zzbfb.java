package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* access modifiers changed from: package-private */
@zzark
public final class zzbfb implements zzbwa {
    private final ByteBuffer zzaep;

    zzbfb(ByteBuffer byteBuffer) {
        this.zzaep = byteBuffer.duplicate();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, com.google.android.gms.internal.ads.zzbwa
    public final void close() throws IOException {
    }

    @Override // com.google.android.gms.internal.ads.zzbwa
    public final int read(ByteBuffer byteBuffer) throws IOException {
        if (this.zzaep.remaining() == 0 && byteBuffer.remaining() > 0) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), this.zzaep.remaining());
        byte[] bArr = new byte[min];
        this.zzaep.get(bArr);
        byteBuffer.put(bArr);
        return min;
    }

    @Override // com.google.android.gms.internal.ads.zzbwa
    public final long size() throws IOException {
        return (long) this.zzaep.limit();
    }

    @Override // com.google.android.gms.internal.ads.zzbwa
    public final long position() throws IOException {
        return (long) this.zzaep.position();
    }

    @Override // com.google.android.gms.internal.ads.zzbwa
    public final void zzaw(long j) throws IOException {
        this.zzaep.position((int) j);
    }

    @Override // com.google.android.gms.internal.ads.zzbwa
    public final ByteBuffer zzk(long j, long j2) throws IOException {
        int position = this.zzaep.position();
        this.zzaep.position((int) j);
        ByteBuffer slice = this.zzaep.slice();
        slice.limit((int) j2);
        this.zzaep.position(position);
        return slice;
    }
}
