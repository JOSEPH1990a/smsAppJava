package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;

public final class zzblb extends zzbrd<zzblb, zza> implements zzbsn {
    private static volatile zzbsw<zzblb> zzcas;
    private static final zzblb zzfed = new zzblb();
    private int zzfea;
    private zzblf zzfeb;
    private zzbmp zzfec;

    private zzblb() {
    }

    public static final class zza extends zzbrd.zza<zzblb, zza> implements zzbsn {
        private zza() {
            super(zzblb.zzfed);
        }

        public final zza zzdk(int i) {
            zzamw();
            ((zzblb) this.zzfpy).setVersion(i);
            return this;
        }

        public final zza zzb(zzblf zzblf) {
            zzamw();
            ((zzblb) this.zzfpy).zza((zzblb) zzblf);
            return this;
        }

        public final zza zzb(zzbmp zzbmp) {
            zzamw();
            ((zzblb) this.zzfpy).zza((zzblb) zzbmp);
            return this;
        }

        /* synthetic */ zza(zzblc zzblc) {
            this();
        }
    }

    public final int getVersion() {
        return this.zzfea;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void setVersion(int i) {
        this.zzfea = i;
    }

    public final zzblf zzafx() {
        zzblf zzblf = this.zzfeb;
        return zzblf == null ? zzblf.zzagh() : zzblf;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zza(zzblf zzblf) {
        if (zzblf != null) {
            this.zzfeb = zzblf;
            return;
        }
        throw new NullPointerException();
    }

    public final zzbmp zzafy() {
        zzbmp zzbmp = this.zzfec;
        return zzbmp == null ? zzbmp.zzahy() : zzbmp;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zza(zzbmp zzbmp) {
        if (zzbmp != null) {
            this.zzfec = zzbmp;
            return;
        }
        throw new NullPointerException();
    }

    public static zzblb zzi(zzbpu zzbpu) throws zzbrl {
        return (zzblb) zzbrd.zza(zzfed, zzbpu);
    }

    public static zza zzafz() {
        return (zza) ((zzbrd.zza) zzfed.zza(zzbrd.zze.zzfqf, (Object) null, (Object) null));
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbrd
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzblc.zzcaq[i - 1]) {
            case 1:
                return new zzblb();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzfed, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[]{"zzfea", "zzfeb", "zzfec"});
            case 4:
                return zzfed;
            case 5:
                zzbsw<zzblb> zzbsw = zzcas;
                if (zzbsw == null) {
                    synchronized (zzblb.class) {
                        zzbsw = zzcas;
                        if (zzbsw == null) {
                            zzbsw = new zzbrd.zzb<>(zzfed);
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
        zzbrd.zza(zzblb.class, zzfed);
    }
}
