package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;

public final class zzbmv extends zzbrd<zzbmv, zza> implements zzbsn {
    private static volatile zzbsw<zzbmv> zzcas;
    private static final zzbmv zzfgn = new zzbmv();
    private String zzfgk = "";
    private zzbpu zzfgl = zzbpu.zzfli;
    private int zzfgm;

    public enum zzb implements zzbrg {
        UNKNOWN_KEYMATERIAL(0),
        SYMMETRIC(1),
        ASYMMETRIC_PRIVATE(2),
        ASYMMETRIC_PUBLIC(3),
        REMOTE(4),
        UNRECOGNIZED(-1);
        
        private static final zzbrh<zzb> zzcbx = new zzbmx();
        private final int value;

        @Override // com.google.android.gms.internal.ads.zzbrg
        public final int zzom() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        public static zzb zzdv(int i) {
            switch (i) {
                case 0:
                    return UNKNOWN_KEYMATERIAL;
                case 1:
                    return SYMMETRIC;
                case 2:
                    return ASYMMETRIC_PRIVATE;
                case 3:
                    return ASYMMETRIC_PUBLIC;
                case 4:
                    return REMOTE;
                default:
                    return null;
            }
        }

        private zzb(int i) {
            this.value = i;
        }
    }

    private zzbmv() {
    }

    public static final class zza extends zzbrd.zza<zzbmv, zza> implements zzbsn {
        private zza() {
            super(zzbmv.zzfgn);
        }

        public final zza zzfl(String str) {
            zzamw();
            ((zzbmv) this.zzfpy).zzfk(str);
            return this;
        }

        public final zza zzai(zzbpu zzbpu) {
            zzamw();
            ((zzbmv) this.zzfpy).zzah(zzbpu);
            return this;
        }

        public final zza zzb(zzb zzb) {
            zzamw();
            ((zzbmv) this.zzfpy).zza(zzb);
            return this;
        }

        /* synthetic */ zza(zzbmw zzbmw) {
            this();
        }
    }

    public final String zzaig() {
        return this.zzfgk;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zzfk(String str) {
        if (str != null) {
            this.zzfgk = str;
            return;
        }
        throw new NullPointerException();
    }

    public final zzbpu zzaih() {
        return this.zzfgl;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zzah(zzbpu zzbpu) {
        if (zzbpu != null) {
            this.zzfgl = zzbpu;
            return;
        }
        throw new NullPointerException();
    }

    public final zzb zzaii() {
        zzb zzdv = zzb.zzdv(this.zzfgm);
        return zzdv == null ? zzb.UNRECOGNIZED : zzdv;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zza(zzb zzb2) {
        if (zzb2 != null) {
            this.zzfgm = zzb2.zzom();
            return;
        }
        throw new NullPointerException();
    }

    public static zza zzaij() {
        return (zza) ((zzbrd.zza) zzfgn.zza(zzbrd.zze.zzfqf, (Object) null, (Object) null));
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbrd
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzbmw.zzcaq[i - 1]) {
            case 1:
                return new zzbmv();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzfgn, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzfgk", "zzfgl", "zzfgm"});
            case 4:
                return zzfgn;
            case 5:
                zzbsw<zzbmv> zzbsw = zzcas;
                if (zzbsw == null) {
                    synchronized (zzbmv.class) {
                        zzbsw = zzcas;
                        if (zzbsw == null) {
                            zzbsw = new zzbrd.zzb<>(zzfgn);
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

    public static zzbmv zzaik() {
        return zzfgn;
    }

    static {
        zzbrd.zza(zzbmv.class, zzfgn);
    }
}
