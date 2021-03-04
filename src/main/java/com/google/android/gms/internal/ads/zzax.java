package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzax implements zzaz {
    private static Logger zzcm = Logger.getLogger(zzax.class.getName());
    private ThreadLocal<ByteBuffer> zzcn = new zzay(this);

    public abstract zzbc zza(String str, byte[] bArr, String str2);

    @Override // com.google.android.gms.internal.ads.zzaz
    public final zzbc zza(zzbwa zzbwa, zzbd zzbd) throws IOException {
        int read;
        long j;
        long j2;
        long position = zzbwa.position();
        this.zzcn.get().rewind().limit(8);
        do {
            read = zzbwa.read(this.zzcn.get());
            if (read == 8) {
                this.zzcn.get().rewind();
                long zza = zzbb.zza(this.zzcn.get());
                byte[] bArr = null;
                if (zza >= 8 || zza <= 1) {
                    String zzf = zzbb.zzf(this.zzcn.get());
                    if (zza == 1) {
                        this.zzcn.get().limit(16);
                        zzbwa.read(this.zzcn.get());
                        this.zzcn.get().position(8);
                        j = zzbb.zzc(this.zzcn.get()) - 16;
                    } else {
                        j = zza == 0 ? zzbwa.size() - zzbwa.position() : zza - 8;
                    }
                    if ("uuid".equals(zzf)) {
                        this.zzcn.get().limit(this.zzcn.get().limit() + 16);
                        zzbwa.read(this.zzcn.get());
                        bArr = new byte[16];
                        for (int position2 = this.zzcn.get().position() - 16; position2 < this.zzcn.get().position(); position2++) {
                            bArr[position2 - (this.zzcn.get().position() - 16)] = this.zzcn.get().get(position2);
                        }
                        j2 = j - 16;
                    } else {
                        j2 = j;
                    }
                    zzbc zza2 = zza(zzf, bArr, zzbd instanceof zzbc ? ((zzbc) zzbd).getType() : "");
                    zza2.zza(zzbd);
                    this.zzcn.get().rewind();
                    zza2.zza(zzbwa, this.zzcn.get(), j2, this);
                    return zza2;
                }
                Logger logger = zzcm;
                Level level = Level.SEVERE;
                StringBuilder sb = new StringBuilder(80);
                sb.append("Plausibility check failed: size < 8 (size = ");
                sb.append(zza);
                sb.append("). Stop parsing!");
                logger.logp(level, "com.coremedia.iso.AbstractBoxParser", "parseBox", sb.toString());
                return null;
            }
        } while (read >= 0);
        zzbwa.zzaw(position);
        throw new EOFException();
    }
}
