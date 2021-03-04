package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;

public final class zzbvd {

    public static final class zza extends zzbrd<zza, C0001zza> implements zzbsn {
        private static volatile zzbsw<zza> zzcas;
        private static final zza zzfxm = new zza();
        private int zzccg;
        private int zzfxf;
        private zzb zzfxg;
        private zzbpu zzfxh = zzbpu.zzfli;
        private zzbpu zzfxi = zzbpu.zzfli;
        private boolean zzfxj;
        private boolean zzfxk;
        private byte zzfxl = 2;

        public static final class zzb extends zzbrd<zzb, C0002zza> implements zzbsn {
            private static volatile zzbsw<zzb> zzcas;
            private static final zzb zzfxr = new zzb();
            private int zzccg;
            private String zzfxn = "";
            private String zzfxo = "";
            private String zzfxp = "";
            private int zzfxq;

            private zzb() {
            }

            /* renamed from: com.google.android.gms.internal.ads.zzbvd$zza$zzb$zza  reason: collision with other inner class name */
            public static final class C0002zza extends zzbrd.zza<zzb, C0002zza> implements zzbsn {
                private C0002zza() {
                    super(zzb.zzfxr);
                }

                /* synthetic */ C0002zza(zzbve zzbve) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzbrd
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzbve.zzcaq[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new C0002zza(null);
                    case 3:
                        return zza(zzfxr, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\u0004\u0003", new Object[]{"zzccg", "zzfxn", "zzfxo", "zzfxp", "zzfxq"});
                    case 4:
                        return zzfxr;
                    case 5:
                        zzbsw<zzb> zzbsw = zzcas;
                        if (zzbsw == null) {
                            synchronized (zzb.class) {
                                zzbsw = zzcas;
                                if (zzbsw == null) {
                                    zzbsw = new zzbrd.zzb<>(zzfxr);
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
                zzbrd.zza(zzb.class, zzfxr);
            }
        }

        public enum zzc implements zzbrg {
            SAFE(0),
            DANGEROUS(1),
            UNKNOWN(2),
            POTENTIALLY_UNWANTED(3),
            DANGEROUS_HOST(4);
            
            private static final zzbrh<zzc> zzcbx = new zzbvf();
            private final int value;

            @Override // com.google.android.gms.internal.ads.zzbrg
            public final int zzom() {
                return this.value;
            }

            public static zzc zzgi(int i) {
                switch (i) {
                    case 0:
                        return SAFE;
                    case 1:
                        return DANGEROUS;
                    case 2:
                        return UNKNOWN;
                    case 3:
                        return POTENTIALLY_UNWANTED;
                    case 4:
                        return DANGEROUS_HOST;
                    default:
                        return null;
                }
            }

            public static zzbri zzop() {
                return zzbvg.zzccw;
            }

            private zzc(int i) {
                this.value = i;
            }
        }

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.ads.zzbvd$zza$zza  reason: collision with other inner class name */
        public static final class C0001zza extends zzbrd.zza<zza, C0001zza> implements zzbsn {
            private C0001zza() {
                super(zza.zzfxm);
            }

            /* synthetic */ C0001zza(zzbve zzbve) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzbrd
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 0;
            switch (zzbve.zzcaq[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0001zza(null);
                case 3:
                    return zza(zzfxm, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0001\u0001Ԍ\u0000\u0002\t\u0001\u0003\n\u0002\u0004\n\u0003\u0005\u0007\u0004\u0006\u0007\u0005", new Object[]{"zzccg", "zzfxf", zzc.zzop(), "zzfxg", "zzfxh", "zzfxi", "zzfxj", "zzfxk"});
                case 4:
                    return zzfxm;
                case 5:
                    zzbsw<zza> zzbsw = zzcas;
                    if (zzbsw == null) {
                        synchronized (zza.class) {
                            zzbsw = zzcas;
                            if (zzbsw == null) {
                                zzbsw = new zzbrd.zzb<>(zzfxm);
                                zzcas = zzbsw;
                            }
                        }
                    }
                    return zzbsw;
                case 6:
                    return Byte.valueOf(this.zzfxl);
                case 7:
                    if (obj != null) {
                        i2 = 1;
                    }
                    this.zzfxl = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzbrd.zza(zza.class, zzfxm);
        }
    }

    public static final class zzb extends zzbrd<zzb, zza> implements zzbsn {
        private static volatile zzbsw<zzb> zzcas;
        private static final zzb zzfyn = new zzb();
        private int zzccg;
        private int zzcch;
        private zzbpu zzfxh = zzbpu.zzfli;
        private byte zzfxl = 2;
        private String zzfxo = "";
        private int zzfxy;
        private String zzfxz = "";
        private String zzfya = "";
        private C0003zzb zzfyb;
        private zzbrk<zzh> zzfyc = zzams();
        private String zzfyd = "";
        private zzf zzfye;
        private boolean zzfyf;
        private zzbrk<String> zzfyg = zzbrd.zzams();
        private String zzfyh = "";
        private boolean zzfyi;
        private boolean zzfyj;
        private zzi zzfyk;
        private zzbrk<String> zzfyl = zzbrd.zzams();
        private zzbrk<String> zzfym = zzbrd.zzams();

        /* renamed from: com.google.android.gms.internal.ads.zzbvd$zzb$zzb  reason: collision with other inner class name */
        public static final class C0003zzb extends zzbrd<C0003zzb, zza> implements zzbsn {
            private static volatile zzbsw<C0003zzb> zzcas;
            private static final C0003zzb zzfyp = new C0003zzb();
            private int zzccg;
            private String zzfyo = "";

            private C0003zzb() {
            }

            /* renamed from: com.google.android.gms.internal.ads.zzbvd$zzb$zzb$zza */
            public static final class zza extends zzbrd.zza<C0003zzb, zza> implements zzbsn {
                private zza() {
                    super(C0003zzb.zzfyp);
                }

                /* synthetic */ zza(zzbve zzbve) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzbrd
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzbve.zzcaq[i - 1]) {
                    case 1:
                        return new C0003zzb();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zza(zzfyp, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\b\u0000", new Object[]{"zzccg", "zzfyo"});
                    case 4:
                        return zzfyp;
                    case 5:
                        zzbsw<C0003zzb> zzbsw = zzcas;
                        if (zzbsw == null) {
                            synchronized (C0003zzb.class) {
                                zzbsw = zzcas;
                                if (zzbsw == null) {
                                    zzbsw = new zzbrd.zzb<>(zzfyp);
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
                zzbrd.zza(C0003zzb.class, zzfyp);
            }
        }

        public static final class zzc extends zzbrd<zzc, zza> implements zzbsn {
            private static volatile zzbsw<zzc> zzcas;
            private static final zzc zzfyr = new zzc();
            private int zzccg;
            private zzbpu zzfgl = zzbpu.zzfli;
            private byte zzfxl = 2;
            private zzbpu zzfyq = zzbpu.zzfli;

            private zzc() {
            }

            public static final class zza extends zzbrd.zza<zzc, zza> implements zzbsn {
                private zza() {
                    super(zzc.zzfyr);
                }

                /* synthetic */ zza(zzbve zzbve) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzbrd
            public final Object zza(int i, Object obj, Object obj2) {
                int i2 = 0;
                switch (zzbve.zzcaq[i - 1]) {
                    case 1:
                        return new zzc();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zza(zzfyr, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001Ԋ\u0000\u0002\n\u0001", new Object[]{"zzccg", "zzfyq", "zzfgl"});
                    case 4:
                        return zzfyr;
                    case 5:
                        zzbsw<zzc> zzbsw = zzcas;
                        if (zzbsw == null) {
                            synchronized (zzc.class) {
                                zzbsw = zzcas;
                                if (zzbsw == null) {
                                    zzbsw = new zzbrd.zzb<>(zzfyr);
                                    zzcas = zzbsw;
                                }
                            }
                        }
                        return zzbsw;
                    case 6:
                        return Byte.valueOf(this.zzfxl);
                    case 7:
                        if (obj != null) {
                            i2 = 1;
                        }
                        this.zzfxl = (byte) i2;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zzbrd.zza(zzc.class, zzfyr);
            }
        }

        public static final class zzd extends zzbrd<zzd, zza> implements zzbsn {
            private static volatile zzbsw<zzd> zzcas;
            private static final zzd zzfyx = new zzd();
            private int zzccg;
            private byte zzfxl = 2;
            private C0004zzb zzfys;
            private zzbrk<zzc> zzfyt = zzams();
            private zzbpu zzfyu = zzbpu.zzfli;
            private zzbpu zzfyv = zzbpu.zzfli;
            private int zzfyw;

            /* renamed from: com.google.android.gms.internal.ads.zzbvd$zzb$zzd$zzb  reason: collision with other inner class name */
            public static final class C0004zzb extends zzbrd<C0004zzb, zza> implements zzbsn {
                private static volatile zzbsw<C0004zzb> zzcas;
                private static final C0004zzb zzfzb = new C0004zzb();
                private int zzccg;
                private zzbpu zzfyy = zzbpu.zzfli;
                private zzbpu zzfyz = zzbpu.zzfli;
                private zzbpu zzfza = zzbpu.zzfli;

                private C0004zzb() {
                }

                /* renamed from: com.google.android.gms.internal.ads.zzbvd$zzb$zzd$zzb$zza */
                public static final class zza extends zzbrd.zza<C0004zzb, zza> implements zzbsn {
                    private zza() {
                        super(C0004zzb.zzfzb);
                    }

                    /* synthetic */ zza(zzbve zzbve) {
                        this();
                    }
                }

                /* access modifiers changed from: protected */
                @Override // com.google.android.gms.internal.ads.zzbrd
                public final Object zza(int i, Object obj, Object obj2) {
                    switch (zzbve.zzcaq[i - 1]) {
                        case 1:
                            return new C0004zzb();
                        case 2:
                            return new zza(null);
                        case 3:
                            return zza(zzfzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\n\u0000\u0002\n\u0001\u0003\n\u0002", new Object[]{"zzccg", "zzfyy", "zzfyz", "zzfza"});
                        case 4:
                            return zzfzb;
                        case 5:
                            zzbsw<C0004zzb> zzbsw = zzcas;
                            if (zzbsw == null) {
                                synchronized (C0004zzb.class) {
                                    zzbsw = zzcas;
                                    if (zzbsw == null) {
                                        zzbsw = new zzbrd.zzb<>(zzfzb);
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

                public static zzbsw<C0004zzb> zzon() {
                    return (zzbsw) zzfzb.zza(zzbrd.zze.zzfqh, (Object) null, (Object) null);
                }

                static {
                    zzbrd.zza(C0004zzb.class, zzfzb);
                }
            }

            private zzd() {
            }

            public static final class zza extends zzbrd.zza<zzd, zza> implements zzbsn {
                private zza() {
                    super(zzd.zzfyx);
                }

                /* synthetic */ zza(zzbve zzbve) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzbrd
            public final Object zza(int i, Object obj, Object obj2) {
                int i2 = 0;
                switch (zzbve.zzcaq[i - 1]) {
                    case 1:
                        return new zzd();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zza(zzfyx, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001\t\u0000\u0002Л\u0003\n\u0001\u0004\n\u0002\u0005\u0004\u0003", new Object[]{"zzccg", "zzfys", "zzfyt", zzc.class, "zzfyu", "zzfyv", "zzfyw"});
                    case 4:
                        return zzfyx;
                    case 5:
                        zzbsw<zzd> zzbsw = zzcas;
                        if (zzbsw == null) {
                            synchronized (zzd.class) {
                                zzbsw = zzcas;
                                if (zzbsw == null) {
                                    zzbsw = new zzbrd.zzb<>(zzfyx);
                                    zzcas = zzbsw;
                                }
                            }
                        }
                        return zzbsw;
                    case 6:
                        return Byte.valueOf(this.zzfxl);
                    case 7:
                        if (obj != null) {
                            i2 = 1;
                        }
                        this.zzfxl = (byte) i2;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zzbrd.zza(zzd.class, zzfyx);
            }
        }

        public static final class zze extends zzbrd<zze, zza> implements zzbsn {
            private static volatile zzbsw<zze> zzcas;
            private static final zze zzfze = new zze();
            private int zzccg;
            private byte zzfxl = 2;
            private zzbrk<zzc> zzfyt = zzams();
            private zzbpu zzfyu = zzbpu.zzfli;
            private zzbpu zzfyv = zzbpu.zzfli;
            private int zzfyw;
            private C0005zzb zzfzc;
            private zzbpu zzfzd = zzbpu.zzfli;

            /* renamed from: com.google.android.gms.internal.ads.zzbvd$zzb$zze$zzb  reason: collision with other inner class name */
            public static final class C0005zzb extends zzbrd<C0005zzb, zza> implements zzbsn {
                private static volatile zzbsw<C0005zzb> zzcas;
                private static final C0005zzb zzfzh = new C0005zzb();
                private int zzccg;
                private zzbpu zzfza = zzbpu.zzfli;
                private int zzfzf;
                private zzbpu zzfzg = zzbpu.zzfli;

                private C0005zzb() {
                }

                /* renamed from: com.google.android.gms.internal.ads.zzbvd$zzb$zze$zzb$zza */
                public static final class zza extends zzbrd.zza<C0005zzb, zza> implements zzbsn {
                    private zza() {
                        super(C0005zzb.zzfzh);
                    }

                    /* synthetic */ zza(zzbve zzbve) {
                        this();
                    }
                }

                /* access modifiers changed from: protected */
                @Override // com.google.android.gms.internal.ads.zzbrd
                public final Object zza(int i, Object obj, Object obj2) {
                    switch (zzbve.zzcaq[i - 1]) {
                        case 1:
                            return new C0005zzb();
                        case 2:
                            return new zza(null);
                        case 3:
                            return zza(zzfzh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0000\u0002\n\u0001\u0003\n\u0002", new Object[]{"zzccg", "zzfzf", "zzfzg", "zzfza"});
                        case 4:
                            return zzfzh;
                        case 5:
                            zzbsw<C0005zzb> zzbsw = zzcas;
                            if (zzbsw == null) {
                                synchronized (C0005zzb.class) {
                                    zzbsw = zzcas;
                                    if (zzbsw == null) {
                                        zzbsw = new zzbrd.zzb<>(zzfzh);
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

                public static zzbsw<C0005zzb> zzon() {
                    return (zzbsw) zzfzh.zza(zzbrd.zze.zzfqh, (Object) null, (Object) null);
                }

                static {
                    zzbrd.zza(C0005zzb.class, zzfzh);
                }
            }

            private zze() {
            }

            public static final class zza extends zzbrd.zza<zze, zza> implements zzbsn {
                private zza() {
                    super(zze.zzfze);
                }

                /* synthetic */ zza(zzbve zzbve) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzbrd
            public final Object zza(int i, Object obj, Object obj2) {
                int i2 = 0;
                switch (zzbve.zzcaq[i - 1]) {
                    case 1:
                        return new zze();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zza(zzfze, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001\t\u0000\u0002Л\u0003\n\u0001\u0004\n\u0002\u0005\u0004\u0003\u0006\n\u0004", new Object[]{"zzccg", "zzfzc", "zzfyt", zzc.class, "zzfyu", "zzfyv", "zzfyw", "zzfzd"});
                    case 4:
                        return zzfze;
                    case 5:
                        zzbsw<zze> zzbsw = zzcas;
                        if (zzbsw == null) {
                            synchronized (zze.class) {
                                zzbsw = zzcas;
                                if (zzbsw == null) {
                                    zzbsw = new zzbrd.zzb<>(zzfze);
                                    zzcas = zzbsw;
                                }
                            }
                        }
                        return zzbsw;
                    case 6:
                        return Byte.valueOf(this.zzfxl);
                    case 7:
                        if (obj != null) {
                            i2 = 1;
                        }
                        this.zzfxl = (byte) i2;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zzbrd.zza(zze.class, zzfze);
            }
        }

        public static final class zzf extends zzbrd<zzf, zza> implements zzbsn {
            private static volatile zzbsw<zzf> zzcas;
            private static final zzf zzfzk = new zzf();
            private int zzccg;
            private int zzcch;
            private String zzfzi = "";
            private zzbpu zzfzj = zzbpu.zzfli;

            /* renamed from: com.google.android.gms.internal.ads.zzbvd$zzb$zzf$zzb  reason: collision with other inner class name */
            public enum EnumC0006zzb implements zzbrg {
                TYPE_UNKNOWN(0),
                TYPE_CREATIVE(1);
                
                private static final zzbrh<EnumC0006zzb> zzcbx = new zzbvh();
                private final int value;

                @Override // com.google.android.gms.internal.ads.zzbrg
                public final int zzom() {
                    return this.value;
                }

                public static EnumC0006zzb zzgj(int i) {
                    switch (i) {
                        case 0:
                            return TYPE_UNKNOWN;
                        case 1:
                            return TYPE_CREATIVE;
                        default:
                            return null;
                    }
                }

                public static zzbri zzop() {
                    return zzbvi.zzccw;
                }

                private EnumC0006zzb(int i) {
                    this.value = i;
                }
            }

            private zzf() {
            }

            public static final class zza extends zzbrd.zza<zzf, zza> implements zzbsn {
                private zza() {
                    super(zzf.zzfzk);
                }

                /* synthetic */ zza(zzbve zzbve) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzbrd
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzbve.zzcaq[i - 1]) {
                    case 1:
                        return new zzf();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zza(zzfzk, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\b\u0001\u0003\n\u0002", new Object[]{"zzccg", "zzcch", EnumC0006zzb.zzop(), "zzfzi", "zzfzj"});
                    case 4:
                        return zzfzk;
                    case 5:
                        zzbsw<zzf> zzbsw = zzcas;
                        if (zzbsw == null) {
                            synchronized (zzf.class) {
                                zzbsw = zzcas;
                                if (zzbsw == null) {
                                    zzbsw = new zzbrd.zzb<>(zzfzk);
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
                zzbrd.zza(zzf.class, zzfzk);
            }
        }

        public enum zzg implements zzbrg {
            UNKNOWN(0),
            URL_PHISHING(1),
            URL_MALWARE(2),
            URL_UNWANTED(3),
            CLIENT_SIDE_PHISHING_URL(4),
            CLIENT_SIDE_MALWARE_URL(5),
            DANGEROUS_DOWNLOAD_RECOVERY(6),
            DANGEROUS_DOWNLOAD_WARNING(7),
            OCTAGON_AD(8),
            OCTAGON_AD_SB_MATCH(9);
            
            private static final zzbrh<zzg> zzcbx = new zzbvj();
            private final int value;

            @Override // com.google.android.gms.internal.ads.zzbrg
            public final int zzom() {
                return this.value;
            }

            public static zzg zzgk(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN;
                    case 1:
                        return URL_PHISHING;
                    case 2:
                        return URL_MALWARE;
                    case 3:
                        return URL_UNWANTED;
                    case 4:
                        return CLIENT_SIDE_PHISHING_URL;
                    case 5:
                        return CLIENT_SIDE_MALWARE_URL;
                    case 6:
                        return DANGEROUS_DOWNLOAD_RECOVERY;
                    case 7:
                        return DANGEROUS_DOWNLOAD_WARNING;
                    case 8:
                        return OCTAGON_AD;
                    case 9:
                        return OCTAGON_AD_SB_MATCH;
                    default:
                        return null;
                }
            }

            public static zzbri zzop() {
                return zzbvk.zzccw;
            }

            private zzg(int i) {
                this.value = i;
            }
        }

        public static final class zzh extends zzbrd<zzh, C0007zzb> implements zzbsn {
            private static volatile zzbsw<zzh> zzcas;
            private static final zzh zzgah = new zzh();
            private int zzccg;
            private byte zzfxl = 2;
            private String zzfxo = "";
            private int zzfzz;
            private zzd zzgaa;
            private zze zzgab;
            private int zzgac;
            private zzbrj zzgad = zzamr();
            private String zzgae = "";
            private int zzgaf;
            private zzbrk<String> zzgag = zzbrd.zzams();

            public enum zza implements zzbrg {
                AD_RESOURCE_UNKNOWN(0),
                AD_RESOURCE_CREATIVE(1),
                AD_RESOURCE_POST_CLICK(2),
                AD_RESOURCE_AUTO_CLICK_DESTINATION(3);
                
                private static final zzbrh<zza> zzcbx = new zzbvl();
                private final int value;

                @Override // com.google.android.gms.internal.ads.zzbrg
                public final int zzom() {
                    return this.value;
                }

                public static zza zzgl(int i) {
                    switch (i) {
                        case 0:
                            return AD_RESOURCE_UNKNOWN;
                        case 1:
                            return AD_RESOURCE_CREATIVE;
                        case 2:
                            return AD_RESOURCE_POST_CLICK;
                        case 3:
                            return AD_RESOURCE_AUTO_CLICK_DESTINATION;
                        default:
                            return null;
                    }
                }

                public static zzbri zzop() {
                    return zzbvm.zzccw;
                }

                private zza(int i) {
                    this.value = i;
                }
            }

            private zzh() {
            }

            /* renamed from: com.google.android.gms.internal.ads.zzbvd$zzb$zzh$zzb  reason: collision with other inner class name */
            public static final class C0007zzb extends zzbrd.zza<zzh, C0007zzb> implements zzbsn {
                private C0007zzb() {
                    super(zzh.zzgah);
                }

                /* synthetic */ C0007zzb(zzbve zzbve) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzbrd
            public final Object zza(int i, Object obj, Object obj2) {
                int i2 = 0;
                switch (zzbve.zzcaq[i - 1]) {
                    case 1:
                        return new zzh();
                    case 2:
                        return new C0007zzb(null);
                    case 3:
                        return zza(zzgah, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0003\u0001Ԅ\u0000\u0002\b\u0001\u0003Љ\u0002\u0004Љ\u0003\u0005\u0004\u0004\u0006\u0016\u0007\b\u0005\b\f\u0006\t\u001a", new Object[]{"zzccg", "zzfzz", "zzfxo", "zzgaa", "zzgab", "zzgac", "zzgad", "zzgae", "zzgaf", zza.zzop(), "zzgag"});
                    case 4:
                        return zzgah;
                    case 5:
                        zzbsw<zzh> zzbsw = zzcas;
                        if (zzbsw == null) {
                            synchronized (zzh.class) {
                                zzbsw = zzcas;
                                if (zzbsw == null) {
                                    zzbsw = new zzbrd.zzb<>(zzgah);
                                    zzcas = zzbsw;
                                }
                            }
                        }
                        return zzbsw;
                    case 6:
                        return Byte.valueOf(this.zzfxl);
                    case 7:
                        if (obj != null) {
                            i2 = 1;
                        }
                        this.zzfxl = (byte) i2;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                zzbrd.zza(zzh.class, zzgah);
            }
        }

        public static final class zzi extends zzbrd<zzi, zza> implements zzbsn {
            private static volatile zzbsw<zzi> zzcas;
            private static final zzi zzgaq = new zzi();
            private int zzccg;
            private String zzgan = "";
            private long zzgao;
            private boolean zzgap;

            private zzi() {
            }

            public static final class zza extends zzbrd.zza<zzi, zza> implements zzbsn {
                private zza() {
                    super(zzi.zzgaq);
                }

                /* synthetic */ zza(zzbve zzbve) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzbrd
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzbve.zzcaq[i - 1]) {
                    case 1:
                        return new zzi();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zza(zzgaq, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\b\u0000\u0002\u0002\u0001\u0003\u0007\u0002", new Object[]{"zzccg", "zzgan", "zzgao", "zzgap"});
                    case 4:
                        return zzgaq;
                    case 5:
                        zzbsw<zzi> zzbsw = zzcas;
                        if (zzbsw == null) {
                            synchronized (zzi.class) {
                                zzbsw = zzcas;
                                if (zzbsw == null) {
                                    zzbsw = new zzbrd.zzb<>(zzgaq);
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
                zzbrd.zza(zzi.class, zzgaq);
            }
        }

        private zzb() {
        }

        public static final class zza extends zzbrd.zza<zzb, zza> implements zzbsn {
            private zza() {
                super(zzb.zzfyn);
            }

            /* synthetic */ zza(zzbve zzbve) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzbrd
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 0;
            switch (zzbve.zzcaq[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzfyn, "\u0001\u0012\u0000\u0001\u0001\u0015\u0012\u0000\u0004\u0001\u0001\b\u0002\u0002\b\u0003\u0003\b\u0004\u0004Л\u0005\u0007\b\u0006\u001a\u0007\b\t\b\u0007\n\t\u0007\u000b\n\f\u0000\u000b\f\u0001\f\t\u0005\r\b\u0006\u000e\t\u0007\u000f\n\f\u0011\t\r\u0014\u001a\u0015\u001a", new Object[]{"zzccg", "zzfxo", "zzfxz", "zzfya", "zzfyc", zzh.class, "zzfyf", "zzfyg", "zzfyh", "zzfyi", "zzfyj", "zzcch", zzg.zzop(), "zzfxy", zza.zzc.zzop(), "zzfyb", "zzfyd", "zzfye", "zzfxh", "zzfyk", "zzfyl", "zzfym"});
                case 4:
                    return zzfyn;
                case 5:
                    zzbsw<zzb> zzbsw = zzcas;
                    if (zzbsw == null) {
                        synchronized (zzb.class) {
                            zzbsw = zzcas;
                            if (zzbsw == null) {
                                zzbsw = new zzbrd.zzb<>(zzfyn);
                                zzcas = zzbsw;
                            }
                        }
                    }
                    return zzbsw;
                case 6:
                    return Byte.valueOf(this.zzfxl);
                case 7:
                    if (obj != null) {
                        i2 = 1;
                    }
                    this.zzfxl = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzbrd.zza(zzb.class, zzfyn);
        }
    }
}
