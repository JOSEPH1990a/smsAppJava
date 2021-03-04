package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;

@zzark
public final class zzbfc {
    private long zzcs;

    public final long zzl(ByteBuffer byteBuffer) {
        zzbf zzbf;
        zzbe zzbe;
        long j = this.zzcs;
        if (j > 0) {
            return j;
        }
        try {
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.flip();
            Iterator<zzbc> it = new zzba(new zzbfb(duplicate), zzbfe.zzewi).zzaqh().iterator();
            while (true) {
                zzbf = null;
                if (!it.hasNext()) {
                    zzbe = null;
                    break;
                }
                zzbc next = it.next();
                if (next instanceof zzbe) {
                    zzbe = (zzbe) next;
                    break;
                }
            }
            Iterator<zzbc> it2 = zzbe.zzaqh().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                zzbc next2 = it2.next();
                if (next2 instanceof zzbf) {
                    zzbf = (zzbf) next2;
                    break;
                }
            }
            this.zzcs = (zzbf.getDuration() * 1000) / zzbf.zzs();
            return this.zzcs;
        } catch (IOException | RuntimeException unused) {
            return 0;
        }
    }
}
