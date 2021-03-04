package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;

public final class zzbnk extends zzbrd<zzbnk, zza> implements zzbsn {
    private static volatile zzbsw<zzbnk> zzcas;
    private static final zzbnk zzfhv = new zzbnk();
    private String zzfhu = "";

    private zzbnk() {
    }

    public static final class zza extends zzbrd.zza<zzbnk, zza> implements zzbsn {
        private zza() {
            super(zzbnk.zzfhv);
        }

        /* synthetic */ zza(zzbnl zzbnl) {
            this();
        }
    }

    public final String zzajl() {
        return this.zzfhu;
    }

    public static zzbnk zzak(zzbpu zzbpu) throws zzbrl {
        return (zzbnk) zzbrd.zza(zzfhv, zzbpu);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbrd
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzbnl.zzcaq[i - 1]) {
            case 1:
                return new zzbnk();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzfhv, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzfhu"});
            case 4:
                return zzfhv;
            case 5:
                zzbsw<zzbnk> zzbsw = zzcas;
                if (zzbsw == null) {
                    synchronized (zzbnk.class) {
                        zzbsw = zzcas;
                        if (zzbsw == null) {
                            zzbsw = new zzbrd.zzb<>(zzfhv);
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

    public static zzbnk zzajm() {
        return zzfhv;
    }

    static {
        zzbrd.zza(zzbnk.class, zzfhv);
    }
}
