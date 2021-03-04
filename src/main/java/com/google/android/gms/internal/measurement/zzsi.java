package com.google.android.gms.internal.measurement;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

public abstract class zzsi<T> {
    private static final Object zzbrm = new Object();
    private static boolean zzbrn = false;
    private static final AtomicInteger zzbrq = new AtomicInteger();
    @SuppressLint({"StaticFieldLeak"})
    private static Context zzri = null;
    private final String name;
    private volatile T zzalj;
    private final zzso zzbro;
    private final T zzbrp;
    private volatile int zzbrr;

    public static void zzae(Context context) {
        synchronized (zzbrm) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (zzri != context) {
                synchronized (zzrx.class) {
                    zzrx.zzbrb.clear();
                }
                synchronized (zzsp.class) {
                    zzsp.zzbrz.clear();
                }
                synchronized (zzse.class) {
                    zzse.zzbrj = null;
                }
                zzbrq.incrementAndGet();
                zzri = context;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public abstract T zzs(Object obj);

    static void zztq() {
        zzbrq.incrementAndGet();
    }

    private zzsi(zzso zzso, String str, T t) {
        this.zzbrr = -1;
        if (zzso.zza(zzso) != null) {
            this.zzbro = zzso;
            this.name = str;
            this.zzbrp = t;
            return;
        }
        throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }

    private final String zzfr(String str) {
        if (str != null && str.isEmpty()) {
            return this.name;
        }
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf(this.name);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public final String zztr() {
        return zzfr(zzso.zzb(this.zzbro));
    }

    public final T getDefaultValue() {
        return this.zzbrp;
    }

    public final T get() {
        int i = zzbrq.get();
        if (this.zzbrr < i) {
            synchronized (this) {
                if (this.zzbrr < i) {
                    if (zzri != null) {
                        zzso zzso = this.zzbro;
                        T zzts = zzts();
                        if (zzts == null) {
                            zzts = zztt();
                            if (zzts == null) {
                                zzts = this.zzbrp;
                            }
                        }
                        this.zzalj = zzts;
                        this.zzbrr = i;
                    } else {
                        throw new IllegalStateException("Must call PhenotypeFlag.init() first");
                    }
                }
            }
        }
        return this.zzalj;
    }

    @Nullable
    private final T zzts() {
        zzsb zzsb;
        Object zzfn;
        zzso zzso = this.zzbro;
        String str = (String) zzse.zzad(zzri).zzfn("gms:phenotype:phenotype_flag:debug_bypass_phenotype");
        if (!(str != null && zzru.zzbqo.matcher(str).matches())) {
            if (zzso.zza(this.zzbro) != null) {
                zzsb = zzrx.zza(zzri.getContentResolver(), zzso.zza(this.zzbro));
            } else {
                Context context = zzri;
                zzso zzso2 = this.zzbro;
                zzsb = zzsp.zzi(context, null);
            }
            if (!(zzsb == null || (zzfn = zzsb.zzfn(zztr())) == null)) {
                return zzs(zzfn);
            }
        } else {
            String valueOf = String.valueOf(zztr());
            Log.w("PhenotypeFlag", valueOf.length() != 0 ? "Bypass reading Phenotype values for flag: ".concat(valueOf) : new String("Bypass reading Phenotype values for flag: "));
        }
        return null;
    }

    @Nullable
    private final T zztt() {
        zzso zzso = this.zzbro;
        Object zzfn = zzse.zzad(zzri).zzfn(zzfr(zzso.zzc(this.zzbro)));
        if (zzfn != null) {
            return zzs(zzfn);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static zzsi<Long> zza(zzso zzso, String str, long j) {
        return new zzsj(zzso, str, Long.valueOf(j));
    }

    /* access modifiers changed from: private */
    public static zzsi<Integer> zza(zzso zzso, String str, int i) {
        return new zzsk(zzso, str, Integer.valueOf(i));
    }

    /* access modifiers changed from: private */
    public static zzsi<Boolean> zza(zzso zzso, String str, boolean z) {
        return new zzsl(zzso, str, Boolean.valueOf(z));
    }

    /* access modifiers changed from: private */
    public static zzsi<Double> zza(zzso zzso, String str, double d) {
        return new zzsm(zzso, str, Double.valueOf(d));
    }

    /* access modifiers changed from: private */
    public static zzsi<String> zza(zzso zzso, String str, String str2) {
        return new zzsn(zzso, str, str2);
    }

    /* synthetic */ zzsi(zzso zzso, String str, Object obj, zzsj zzsj) {
        this(zzso, str, obj);
    }
}
