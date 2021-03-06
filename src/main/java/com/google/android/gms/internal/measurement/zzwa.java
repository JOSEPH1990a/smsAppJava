package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class zzwa<T> implements zzwl<T> {
    private final zzvv zzcau;
    private final boolean zzcav;
    private final zzxd<?, ?> zzcbe;
    private final zzuc<?> zzcbf;

    private zzwa(zzxd<?, ?> zzxd, zzuc<?> zzuc, zzvv zzvv) {
        this.zzcbe = zzxd;
        this.zzcav = zzuc.zze(zzvv);
        this.zzcbf = zzuc;
        this.zzcau = zzvv;
    }

    static <T> zzwa<T> zza(zzxd<?, ?> zzxd, zzuc<?> zzuc, zzvv zzvv) {
        return new zzwa<>(zzxd, zzuc, zzvv);
    }

    @Override // com.google.android.gms.internal.measurement.zzwl
    public final T newInstance() {
        return (T) this.zzcau.zzwi().zzwn();
    }

    @Override // com.google.android.gms.internal.measurement.zzwl
    public final boolean equals(T t, T t2) {
        if (!this.zzcbe.zzal(t).equals(this.zzcbe.zzal(t2))) {
            return false;
        }
        if (this.zzcav) {
            return this.zzcbf.zzw(t).equals(this.zzcbf.zzw(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzwl
    public final int hashCode(T t) {
        int hashCode = this.zzcbe.zzal(t).hashCode();
        return this.zzcav ? (hashCode * 53) + this.zzcbf.zzw(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.measurement.zzwl
    public final void zzd(T t, T t2) {
        zzwn.zza(this.zzcbe, t, t2);
        if (this.zzcav) {
            zzwn.zza(this.zzcbf, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzwl
    public final void zza(T t, zzxy zzxy) throws IOException {
        Iterator<Map.Entry<?, Object>> it = this.zzcbf.zzw(t).iterator();
        while (it.hasNext()) {
            Map.Entry<?, Object> next = it.next();
            zzuh zzuh = (zzuh) next.getKey();
            if (zzuh.zzwa() != zzxx.MESSAGE || zzuh.zzwb() || zzuh.zzwc()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzva) {
                zzxy.zza(zzuh.zzc(), (Object) ((zzva) next).zzxa().zztw());
            } else {
                zzxy.zza(zzuh.zzc(), next.getValue());
            }
        }
        zzxd<?, ?> zzxd = this.zzcbe;
        zzxd.zzc(zzxd.zzal(t), zzxy);
    }

    @Override // com.google.android.gms.internal.measurement.zzwl
    public final void zza(T t, zzwk zzwk, zzub zzub) throws IOException {
        boolean z;
        zzxd<?, ?> zzxd = this.zzcbe;
        zzuc<?> zzuc = this.zzcbf;
        Object zzam = zzxd.zzam(t);
        zzuf<?> zzx = zzuc.zzx(t);
        do {
            try {
                if (zzwk.zzvh() == Integer.MAX_VALUE) {
                    zzxd.zzg(t, zzam);
                    return;
                }
                int tag = zzwk.getTag();
                if (tag == 11) {
                    int i = 0;
                    Object obj = null;
                    zzte zzte = null;
                    while (zzwk.zzvh() != Integer.MAX_VALUE) {
                        int tag2 = zzwk.getTag();
                        if (tag2 == 16) {
                            i = zzwk.zzus();
                            obj = zzuc.zza(zzub, this.zzcau, i);
                        } else if (tag2 == 26) {
                            if (obj != null) {
                                zzuc.zza(zzwk, obj, zzub, zzx);
                            } else {
                                zzte = zzwk.zzur();
                            }
                        } else if (!zzwk.zzvi()) {
                            break;
                        }
                    }
                    if (zzwk.getTag() != 12) {
                        throw zzuv.zzwt();
                    } else if (zzte != null) {
                        if (obj != null) {
                            zzuc.zza(zzte, obj, zzub, zzx);
                        } else {
                            zzxd.zza(zzam, i, zzte);
                        }
                    }
                } else if ((tag & 7) == 2) {
                    Object zza = zzuc.zza(zzub, this.zzcau, tag >>> 3);
                    if (zza != null) {
                        zzuc.zza(zzwk, zza, zzub, zzx);
                    } else {
                        z = zzxd.zza(zzam, zzwk);
                        continue;
                    }
                } else {
                    z = zzwk.zzvi();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzxd.zzg(t, zzam);
            }
        } while (z);
    }

    @Override // com.google.android.gms.internal.measurement.zzwl
    public final void zzy(T t) {
        this.zzcbe.zzy(t);
        this.zzcbf.zzy(t);
    }

    @Override // com.google.android.gms.internal.measurement.zzwl
    public final boolean zzaj(T t) {
        return this.zzcbf.zzw(t).isInitialized();
    }

    @Override // com.google.android.gms.internal.measurement.zzwl
    public final int zzai(T t) {
        zzxd<?, ?> zzxd = this.zzcbe;
        int zzan = zzxd.zzan(zzxd.zzal(t)) + 0;
        return this.zzcav ? zzan + this.zzcbf.zzw(t).zzvy() : zzan;
    }
}
