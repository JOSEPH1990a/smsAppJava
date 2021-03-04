package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;
import com.google.android.gms.internal.ads.zzbrd.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzbrd<MessageType extends zzbrd<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzbpl<MessageType, BuilderType> {
    private static Map<Object, zzbrd<?, ?>> zzfpw = new ConcurrentHashMap();
    protected zzbtv zzfpu = zzbtv.zzaoz();
    private int zzfpv = -1;

    public static abstract class zzc<MessageType extends zzc<MessageType, BuilderType>, BuilderType> extends zzbrd<MessageType, BuilderType> implements zzbsn {
        protected zzbqu<Object> zzfqa = zzbqu.zzami();
    }

    public static class zzd<ContainingType extends zzbsl, Type> extends zzbqo<ContainingType, Type> {
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    public static final class zze {
        public static final int zzfqb = 1;
        public static final int zzfqc = 2;
        public static final int zzfqd = 3;
        public static final int zzfqe = 4;
        public static final int zzfqf = 5;
        public static final int zzfqg = 6;
        public static final int zzfqh = 7;
        private static final /* synthetic */ int[] zzfqi = {zzfqb, zzfqc, zzfqd, zzfqe, zzfqf, zzfqg, zzfqh};
        public static final int zzfqj = 1;
        public static final int zzfqk = 2;
        private static final /* synthetic */ int[] zzfql = {zzfqj, zzfqk};
        public static final int zzfqm = 1;
        public static final int zzfqn = 2;
        private static final /* synthetic */ int[] zzfqo = {zzfqm, zzfqn};

        public static int[] values$50KLMJ33DTMIUPRFDTJMOP9FE1P6UT3FC9QMCBQ7CLN6ASJ1EHIM8JB5EDPM2PR59HKN8P949LIN8Q3FCHA6UIBEEPNMMP9R0() {
            return (int[]) zzfqi.clone();
        }
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    public static class zzb<T extends zzbrd<T, ?>> extends zzbpn<T> {
        private final T zzfpx;

        public zzb(T t) {
            this.zzfpx = t;
        }

        @Override // com.google.android.gms.internal.ads.zzbsw
        public final /* synthetic */ Object zza(zzbqf zzbqf, zzbqq zzbqq) throws zzbrl {
            return zzbrd.zza(this.zzfpx, zzbqf, zzbqq);
        }
    }

    public String toString() {
        return zzbso.zza(this, super.toString());
    }

    public int hashCode() {
        if (this.zzfkx != 0) {
            return this.zzfkx;
        }
        this.zzfkx = zzbsy.zzaog().zzaf(this).hashCode(this);
        return this.zzfkx;
    }

    public static abstract class zza<MessageType extends zzbrd<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzbpm<MessageType, BuilderType> {
        private final MessageType zzfpx;
        protected MessageType zzfpy;
        private boolean zzfpz = false;

        protected zza(MessageType messagetype) {
            this.zzfpx = messagetype;
            this.zzfpy = (MessageType) ((zzbrd) messagetype.zza(zze.zzfqe, null, null));
        }

        /* access modifiers changed from: protected */
        public final void zzamw() {
            if (this.zzfpz) {
                MessageType messagetype = (MessageType) ((zzbrd) this.zzfpy.zza(zze.zzfqe, null, null));
                zza(messagetype, this.zzfpy);
                this.zzfpy = messagetype;
                this.zzfpz = false;
            }
        }

        @Override // com.google.android.gms.internal.ads.zzbsn
        public final boolean isInitialized() {
            return zzbrd.zza((zzbrd) this.zzfpy, false);
        }

        /* renamed from: zzamx */
        public MessageType zzamz() {
            if (this.zzfpz) {
                return this.zzfpy;
            }
            MessageType messagetype = this.zzfpy;
            zzbsy.zzaog().zzaf(messagetype).zzs(messagetype);
            this.zzfpz = true;
            return this.zzfpy;
        }

        /* renamed from: zzamy */
        public final MessageType zzana() {
            MessageType messagetype = (MessageType) ((zzbrd) zzamz());
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) messagetype.zza(zze.zzfqb, null, null)).byteValue();
            boolean z = true;
            if (byteValue != 1) {
                if (byteValue == 0) {
                    z = false;
                } else {
                    z = zzbsy.zzaog().zzaf(messagetype).zzae(messagetype);
                    if (booleanValue) {
                        messagetype.zza(zze.zzfqc, z ? messagetype : null, null);
                    }
                }
            }
            if (z) {
                return messagetype;
            }
            throw new zzbtt(messagetype);
        }

        public final BuilderType zza(MessageType messagetype) {
            zzamw();
            zza(this.zzfpy, messagetype);
            return this;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzbsy.zzaog().zzaf(messagetype).zzd(messagetype, messagetype2);
        }

        @Override // com.google.android.gms.internal.ads.zzbpm
        public final /* synthetic */ zzbpm zzakh() {
            return (zza) clone();
        }

        @Override // com.google.android.gms.internal.ads.zzbsn
        public final /* synthetic */ zzbsl zzamv() {
            return this.zzfpx;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.google.android.gms.internal.ads.zzbrd$zza */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.ads.zzbpm, java.lang.Object
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zza = (zza) this.zzfpx.zza(zze.zzfqf, null, null);
            zza.zza((zzbrd) zzamz());
            return zza;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((zzbrd) zza(zze.zzfqg, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return false;
        }
        return zzbsy.zzaog().zzaf(this).equals(this, (zzbrd) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final boolean isInitialized() {
        boolean booleanValue = Boolean.TRUE.booleanValue();
        byte byteValue = ((Byte) zza(zze.zzfqb, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzae = zzbsy.zzaog().zzaf(this).zzae(this);
        if (booleanValue) {
            zza(zze.zzfqc, zzae ? this : null, (Object) null);
        }
        return zzae;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzbpl
    public final int zzakg() {
        return this.zzfpv;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzbpl
    public final void zzei(int i) {
        this.zzfpv = i;
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final void zzb(zzbqk zzbqk) throws IOException {
        zzbsy.zzaog().zzf(getClass()).zza(this, zzbqm.zza(zzbqk));
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final int zzamj() {
        if (this.zzfpv == -1) {
            this.zzfpv = zzbsy.zzaog().zzaf(this).zzac(this);
        }
        return this.zzfpv;
    }

    static <T extends zzbrd<?, ?>> T zzd(Class<T> cls) {
        T t = (T) zzfpw.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (T) zzfpw.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t != null) {
            return t;
        }
        String valueOf = String.valueOf(cls.getName());
        throw new IllegalStateException(valueOf.length() != 0 ? "Unable to get default instance for: ".concat(valueOf) : new String("Unable to get default instance for: "));
    }

    protected static <T extends zzbrd<?, ?>> void zza(Class<T> cls, T t) {
        zzfpw.put(cls, t);
    }

    protected static Object zza(zzbsl zzbsl, String str, Object[] objArr) {
        return new zzbta(zzbsl, str, objArr);
    }

    static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static final <T extends zzbrd<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zze.zzfqb, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        return zzbsy.zzaog().zzaf(t).zzae(t);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.ads.zzbre, com.google.android.gms.internal.ads.zzbrj] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static com.google.android.gms.internal.ads.zzbrj zzamr() {
        /*
            com.google.android.gms.internal.ads.zzbre r0 = com.google.android.gms.internal.ads.zzbre.zzanb()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbrd.zzamr():com.google.android.gms.internal.ads.zzbrj");
    }

    protected static <E> zzbrk<E> zzams() {
        return zzbsz.zzaoh();
    }

    static <T extends zzbrd<T, ?>> T zza(T t, zzbqf zzbqf, zzbqq zzbqq) throws zzbrl {
        T t2 = (T) ((zzbrd) t.zza(zze.zzfqe, null, null));
        try {
            zzbsy.zzaog().zzaf(t2).zza(t2, zzbqi.zza(zzbqf), zzbqq);
            zzbsy.zzaog().zzaf(t2).zzs(t2);
            return t2;
        } catch (IOException e) {
            if (e.getCause() instanceof zzbrl) {
                throw ((zzbrl) e.getCause());
            }
            throw new zzbrl(e.getMessage()).zzj(t2);
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof zzbrl) {
                throw ((zzbrl) e2.getCause());
            }
            throw e2;
        }
    }

    private static <T extends zzbrd<T, ?>> T zza(T t, byte[] bArr) throws zzbrl {
        T t2 = (T) ((zzbrd) t.zza(zze.zzfqe, null, null));
        try {
            zzbsy.zzaog().zzaf(t2).zza(t2, bArr, 0, bArr.length, new zzbpr());
            zzbsy.zzaog().zzaf(t2).zzs(t2);
            if (((zzbrd) t2).zzfkx == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e) {
            if (e.getCause() instanceof zzbrl) {
                throw ((zzbrl) e.getCause());
            }
            throw new zzbrl(e.getMessage()).zzj(t2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzbrl.zzanc().zzj(t2);
        }
    }

    protected static <T extends zzbrd<T, ?>> T zza(T t, zzbpu zzbpu) throws zzbrl {
        boolean z;
        T t2 = (T) zza(t, zzbpu, zzbqq.zzamd());
        boolean z2 = false;
        if (t2 != null) {
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) t2.zza(zze.zzfqb, null, null)).byteValue();
            if (byteValue == 1) {
                z = true;
            } else if (byteValue == 0) {
                z = false;
            } else {
                z = zzbsy.zzaog().zzaf(t2).zzae(t2);
                if (booleanValue) {
                    t2.zza(zze.zzfqc, z ? t2 : null, null);
                }
            }
            if (!z) {
                throw new zzbtt(t2).zzaox().zzj(t2);
            }
        }
        if (t2 != null) {
            boolean booleanValue2 = Boolean.TRUE.booleanValue();
            byte byteValue2 = ((Byte) t2.zza(zze.zzfqb, null, null)).byteValue();
            if (byteValue2 == 1) {
                z2 = true;
            } else if (byteValue2 != 0) {
                z2 = zzbsy.zzaog().zzaf(t2).zzae(t2);
                if (booleanValue2) {
                    t2.zza(zze.zzfqc, z2 ? t2 : null, null);
                }
            }
            if (!z2) {
                throw new zzbtt(t2).zzaox().zzj(t2);
            }
        }
        return t2;
    }

    private static <T extends zzbrd<T, ?>> T zza(T t, zzbpu zzbpu, zzbqq zzbqq) throws zzbrl {
        try {
            zzbqf zzakp = zzbpu.zzakp();
            T t2 = (T) zza(t, zzakp, zzbqq);
            try {
                zzakp.zzeo(0);
                return t2;
            } catch (zzbrl e) {
                throw e.zzj(t2);
            }
        } catch (zzbrl e2) {
            throw e2;
        }
    }

    protected static <T extends zzbrd<T, ?>> T zzb(T t, byte[] bArr) throws zzbrl {
        T t2 = (T) zza(t, bArr);
        if (t2 != null) {
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) t2.zza(zze.zzfqb, null, null)).byteValue();
            boolean z = true;
            if (byteValue != 1) {
                if (byteValue == 0) {
                    z = false;
                } else {
                    z = zzbsy.zzaog().zzaf(t2).zzae(t2);
                    if (booleanValue) {
                        t2.zza(zze.zzfqc, z ? t2 : null, null);
                    }
                }
            }
            if (!z) {
                throw new zzbtt(t2).zzaox().zzj(t2);
            }
        }
        return t2;
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final /* synthetic */ zzbsm zzamt() {
        zza zza2 = (zza) zza(zze.zzfqf, (Object) null, (Object) null);
        zza2.zza((zzbrd) this);
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final /* synthetic */ zzbsm zzamu() {
        return (zza) zza(zze.zzfqf, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final /* synthetic */ zzbsl zzamv() {
        return (zzbrd) zza(zze.zzfqg, (Object) null, (Object) null);
    }
}
