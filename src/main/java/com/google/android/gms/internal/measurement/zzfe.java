package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuo;

public final class zzfe {

    public static final class zza extends zzuo<zza, C0010zza> implements zzvx {
        private static final zza zzauw = new zza();
        private static volatile zzwf<zza> zznw;
        private String zzauu = "";
        private long zzauv;
        private int zznr;

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.measurement.zzfe$zza$zza  reason: collision with other inner class name */
        public static final class C0010zza extends zzuo.zza<zza, C0010zza> implements zzvx {
            private C0010zza() {
                super(zza.zzauw);
            }

            public final C0010zza zzda(String str) {
                zzwk();
                ((zza) this.zzbyh).setName(str);
                return this;
            }

            public final C0010zza zzan(long j) {
                zzwk();
                ((zza) this.zzbyh).zzam(j);
                return this;
            }

            /* synthetic */ C0010zza(zzff zzff) {
                this();
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void setName(String str) {
            if (str != null) {
                this.zznr |= 1;
                this.zzauu = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zzam(long j) {
            this.zznr |= 2;
            this.zzauv = j;
        }

        public static C0010zza zzmn() {
            return (C0010zza) ((zzuo.zza) zzauw.zza(zzuo.zze.zzbyo, (Object) null, (Object) null));
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.measurement.zzuo
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzff.zznq[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0010zza(null);
                case 3:
                    return zza(zzauw, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\u0002\u0001", new Object[]{"zznr", "zzauu", "zzauv"});
                case 4:
                    return zzauw;
                case 5:
                    zzwf<zza> zzwf = zznw;
                    if (zzwf == null) {
                        synchronized (zza.class) {
                            zzwf = zznw;
                            if (zzwf == null) {
                                zzwf = new zzuo.zzb<>(zzauw);
                                zznw = zzwf;
                            }
                        }
                    }
                    return zzwf;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzuo.zza(zza.class, zzauw);
        }
    }

    public static final class zzb extends zzuo<zzb, zza> implements zzvx {
        private static final zzb zzauz = new zzb();
        private static volatile zzwf<zzb> zznw;
        private int zzaux = 1;
        private zzuu<zza> zzauy = zzwg();
        private int zznr;

        /* renamed from: com.google.android.gms.internal.measurement.zzfe$zzb$zzb  reason: collision with other inner class name */
        public enum EnumC0011zzb implements zzur {
            RADS(1),
            PROVISIONING(2);
            
            private static final zzus<EnumC0011zzb> zzoa = new zzfg();
            private final int value;

            @Override // com.google.android.gms.internal.measurement.zzur
            public final int zzc() {
                return this.value;
            }

            public static EnumC0011zzb zzt(int i) {
                switch (i) {
                    case 1:
                        return RADS;
                    case 2:
                        return PROVISIONING;
                    default:
                        return null;
                }
            }

            public static zzut zzd() {
                return zzfh.zzoc;
            }

            private EnumC0011zzb(int i) {
                this.value = i;
            }
        }

        private zzb() {
        }

        public static final class zza extends zzuo.zza<zzb, zza> implements zzvx {
            private zza() {
                super(zzb.zzauz);
            }

            public final zza zzb(zza zza) {
                zzwk();
                ((zzb) this.zzbyh).zza(zza);
                return this;
            }

            /* synthetic */ zza(zzff zzff) {
                this();
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void zza(zza zza2) {
            if (zza2 != null) {
                if (!this.zzauy.zztz()) {
                    zzuu<zza> zzuu = this.zzauy;
                    int size = zzuu.size();
                    this.zzauy = zzuu.zzal(size == 0 ? 10 : size << 1);
                }
                this.zzauy.add(zza2);
                return;
            }
            throw new NullPointerException();
        }

        public static zza zzmp() {
            return (zza) ((zzuo.zza) zzauz.zza(zzuo.zze.zzbyo, (Object) null, (Object) null));
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.measurement.zzuo
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzff.zznq[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(null);
                case 3:
                    return zza(zzauz, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\f\u0000\u0002\u001b", new Object[]{"zznr", "zzaux", EnumC0011zzb.zzd(), "zzauy", zza.class});
                case 4:
                    return zzauz;
                case 5:
                    zzwf<zzb> zzwf = zznw;
                    if (zzwf == null) {
                        synchronized (zzb.class) {
                            zzwf = zznw;
                            if (zzwf == null) {
                                zzwf = new zzuo.zzb<>(zzauz);
                                zznw = zzwf;
                            }
                        }
                    }
                    return zzwf;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzwf<zzb> zza() {
            return (zzwf) zzauz.zza(zzuo.zze.zzbyq, (Object) null, (Object) null);
        }

        static {
            zzuo.zza(zzb.class, zzauz);
        }
    }
}
