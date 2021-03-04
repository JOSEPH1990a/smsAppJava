package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class zzbsr<T> implements zzbtc<T> {
    private final zzbsl zzfsm;
    private final boolean zzfsn;
    private final zzbtu<?, ?> zzfsw;
    private final zzbqr<?> zzfsx;

    private zzbsr(zzbtu<?, ?> zzbtu, zzbqr<?> zzbqr, zzbsl zzbsl) {
        this.zzfsw = zzbtu;
        this.zzfsn = zzbqr.zzh(zzbsl);
        this.zzfsx = zzbqr;
        this.zzfsm = zzbsl;
    }

    static <T> zzbsr<T> zza(zzbtu<?, ?> zzbtu, zzbqr<?> zzbqr, zzbsl zzbsl) {
        return new zzbsr<>(zzbtu, zzbqr, zzbsl);
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final T newInstance() {
        return (T) this.zzfsm.zzamu().zzamz();
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final boolean equals(T t, T t2) {
        if (!this.zzfsw.zzag(t).equals(this.zzfsw.zzag(t2))) {
            return false;
        }
        if (this.zzfsn) {
            return this.zzfsx.zzq(t).equals(this.zzfsx.zzq(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final int hashCode(T t) {
        int hashCode = this.zzfsw.zzag(t).hashCode();
        return this.zzfsn ? (hashCode * 53) + this.zzfsx.zzq(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void zzd(T t, T t2) {
        zzbte.zza(this.zzfsw, t, t2);
        if (this.zzfsn) {
            zzbte.zza(this.zzfsx, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void zza(T t, zzbup zzbup) throws IOException {
        Iterator<Map.Entry<?, Object>> it = this.zzfsx.zzq(t).iterator();
        while (it.hasNext()) {
            Map.Entry<?, Object> next = it.next();
            zzbqw zzbqw = (zzbqw) next.getKey();
            if (zzbqw.zzamm() != zzbuo.MESSAGE || zzbqw.zzamn() || zzbqw.zzamo()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzbrq) {
                zzbup.zzb(zzbqw.zzom(), ((zzbrq) next).zzann().zzakf());
            } else {
                zzbup.zzb(zzbqw.zzom(), next.getValue());
            }
        }
        zzbtu<?, ?> zzbtu = this.zzfsw;
        zzbtu.zzc(zzbtu.zzag(t), zzbup);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0061 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzbtc
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r7, byte[] r8, int r9, int r10, com.google.android.gms.internal.ads.zzbpr r11) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 124
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbsr.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.ads.zzbpr):void");
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void zza(T t, zzbtb zzbtb, zzbqq zzbqq) throws IOException {
        boolean z;
        zzbtu<?, ?> zzbtu = this.zzfsw;
        zzbqr<?> zzbqr = this.zzfsx;
        Object zzah = zzbtu.zzah(t);
        zzbqu<?> zzr = zzbqr.zzr(t);
        do {
            try {
                if (zzbtb.zzals() == Integer.MAX_VALUE) {
                    zzbtu.zzg(t, zzah);
                    return;
                }
                int tag = zzbtb.getTag();
                if (tag == 11) {
                    int i = 0;
                    Object obj = null;
                    zzbpu zzbpu = null;
                    while (zzbtb.zzals() != Integer.MAX_VALUE) {
                        int tag2 = zzbtb.getTag();
                        if (tag2 == 16) {
                            i = zzbtb.zzald();
                            obj = zzbqr.zza(zzbqq, this.zzfsm, i);
                        } else if (tag2 == 26) {
                            if (obj != null) {
                                zzbqr.zza(zzbtb, obj, zzbqq, zzr);
                            } else {
                                zzbpu = zzbtb.zzalc();
                            }
                        } else if (!zzbtb.zzalt()) {
                            break;
                        }
                    }
                    if (zzbtb.getTag() != 12) {
                        throw zzbrl.zzang();
                    } else if (zzbpu != null) {
                        if (obj != null) {
                            zzbqr.zza(zzbpu, obj, zzbqq, zzr);
                        } else {
                            zzbtu.zza(zzah, i, zzbpu);
                        }
                    }
                } else if ((tag & 7) == 2) {
                    Object zza = zzbqr.zza(zzbqq, this.zzfsm, tag >>> 3);
                    if (zza != null) {
                        zzbqr.zza(zzbtb, zza, zzbqq, zzr);
                    } else {
                        z = zzbtu.zza(zzah, zzbtb);
                        continue;
                    }
                } else {
                    z = zzbtb.zzalt();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzbtu.zzg(t, zzah);
            }
        } while (z);
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void zzs(T t) {
        this.zzfsw.zzs(t);
        this.zzfsx.zzs(t);
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final boolean zzae(T t) {
        return this.zzfsx.zzq(t).isInitialized();
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final int zzac(T t) {
        zzbtu<?, ?> zzbtu = this.zzfsw;
        int zzai = zzbtu.zzai(zzbtu.zzag(t)) + 0;
        return this.zzfsn ? zzai + this.zzfsx.zzq(t).zzamk() : zzai;
    }
}
