package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;
import java.util.List;

public final class zzbns extends zzbrd<zzbns, zza> implements zzbsn {
    private static volatile zzbsw<zzbns> zzcas;
    private static final zzbns zzfik = new zzbns();
    private int zzccg;
    private String zzfii = "";
    private zzbrk<zzbnc> zzfij = zzams();

    private zzbns() {
    }

    public static final class zza extends zzbrd.zza<zzbns, zza> implements zzbsn {
        private zza() {
            super(zzbns.zzfik);
        }

        public final zza zzft(String str) {
            zzamw();
            ((zzbns) this.zzfpy).zzfs(str);
            return this;
        }

        public final zza zzb(zzbnc zzbnc) {
            zzamw();
            ((zzbns) this.zzfpy).zza(zzbnc);
            return this;
        }

        /* synthetic */ zza(zzbnt zzbnt) {
            this();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zzfs(String str) {
        if (str != null) {
            this.zzfii = str;
            return;
        }
        throw new NullPointerException();
    }

    public final List<zzbnc> zzajv() {
        return this.zzfij;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zza(zzbnc zzbnc) {
        if (zzbnc != null) {
            if (!this.zzfij.zzaki()) {
                zzbrk<zzbnc> zzbrk = this.zzfij;
                int size = zzbrk.size();
                this.zzfij = zzbrk.zzel(size == 0 ? 10 : size << 1);
            }
            this.zzfij.add(zzbnc);
            return;
        }
        throw new NullPointerException();
    }

    public static zza zzajw() {
        return (zza) ((zzbrd.zza) zzfik.zza(zzbrd.zze.zzfqf, (Object) null, (Object) null));
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbrd
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzbnt.zzcaq[i - 1]) {
            case 1:
                return new zzbns();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzfik, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzccg", "zzfii", "zzfij", zzbnc.class});
            case 4:
                return zzfik;
            case 5:
                zzbsw<zzbns> zzbsw = zzcas;
                if (zzbsw == null) {
                    synchronized (zzbns.class) {
                        zzbsw = zzcas;
                        if (zzbsw == null) {
                            zzbsw = new zzbrd.zzb<>(zzfik);
                            zzcas = zzbsw;
                        }
                    }
                }
                return zzbsw;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        zzbrd.zza(zzbns.class, zzfik);
    }
}
