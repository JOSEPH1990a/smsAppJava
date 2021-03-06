package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzvn<K, V> {
    static <K, V> void zza(zztv zztv, zzvo<K, V> zzvo, K k, V v) throws IOException {
        zzuf.zza(zztv, zzvo.zzcai, 1, k);
        zzuf.zza(zztv, zzvo.zzcak, 2, v);
    }

    static <K, V> int zza(zzvo<K, V> zzvo, K k, V v) {
        return zzuf.zza(zzvo.zzcai, 1, k) + zzuf.zza(zzvo.zzcak, 2, v);
    }
}
