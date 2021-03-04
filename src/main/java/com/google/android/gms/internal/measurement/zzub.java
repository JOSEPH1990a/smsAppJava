package com.google.android.gms.internal.measurement;

import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.measurement.zzuo;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzub {
    private static volatile boolean zzbva = false;
    private static final Class<?> zzbvb = zzvq();
    private static volatile zzub zzbvc;
    static final zzub zzbvd = new zzub(true);
    private final Map<zza, zzuo.zzd<?, ?>> zzbve;

    private static Class<?> zzvq() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    static final class zza {
        private final int number;
        private final Object object;

        zza(Object obj, int i) {
            this.object = obj;
            this.number = i;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.object) * SupportMenu.USER_MASK) + this.number;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (this.object == zza.object && this.number == zza.number) {
                return true;
            }
            return false;
        }
    }

    public static zzub zzvr() {
        return zzua.zzvo();
    }

    public static zzub zzvs() {
        zzub zzub = zzbvc;
        if (zzub == null) {
            synchronized (zzub.class) {
                zzub = zzbvc;
                if (zzub == null) {
                    zzub = zzua.zzvp();
                    zzbvc = zzub;
                }
            }
        }
        return zzub;
    }

    static zzub zzvp() {
        return zzum.zzd(zzub.class);
    }

    public final <ContainingType extends zzvv> zzuo.zzd<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return (zzuo.zzd<ContainingType, ?>) this.zzbve.get(new zza(containingtype, i));
    }

    zzub() {
        this.zzbve = new HashMap();
    }

    private zzub(boolean z) {
        this.zzbve = Collections.emptyMap();
    }
}
