package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

final class zzuj extends PushbackInputStream {
    private final /* synthetic */ zzug zzcam;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzuj(zzug zzug, InputStream inputStream, int i) {
        super(inputStream, 1);
        this.zzcam = zzug;
    }

    @Override // java.io.FilterInputStream, java.io.PushbackInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public final void close() throws IOException {
        this.zzcam.zzcad.disconnect();
        super.close();
    }
}
