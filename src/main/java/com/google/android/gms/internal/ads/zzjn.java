package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public final class zzjn implements zzhz, zzig {
    private static final zzic zzahq = new zzjo();
    private static final int zzasf = zzqe.zzam("qt  ");
    private long zzaan;
    private final zzpx zzahx = new zzpx(zzpu.zzbhi);
    private final zzpx zzahy = new zzpx(4);
    private int zzajm;
    private int zzajn;
    private zzib zzajq;
    private final zzpx zzaqa = new zzpx(16);
    private final Stack<zziw> zzaqc = new Stack<>();
    private int zzaqe;
    private int zzaqf;
    private long zzaqg;
    private int zzaqh;
    private zzpx zzaqi;
    private zzjp[] zzasg;
    private boolean zzash;

    @Override // com.google.android.gms.internal.ads.zzhz
    public final void release() {
    }

    @Override // com.google.android.gms.internal.ads.zzig
    public final boolean zzdw() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final boolean zza(zzia zzia) throws IOException, InterruptedException {
        return zzjr.zze(zzia);
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final void zza(zzib zzib) {
        this.zzajq = zzib;
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final void zzc(long j, long j2) {
        this.zzaqc.clear();
        this.zzaqh = 0;
        this.zzajn = 0;
        this.zzajm = 0;
        if (j == 0) {
            zzei();
            return;
        }
        zzjp[] zzjpArr = this.zzasg;
        if (zzjpArr != null) {
            for (zzjp zzjp : zzjpArr) {
                zzjv zzjv = zzjp.zzasi;
                int zzu = zzjv.zzu(j2);
                if (zzu == -1) {
                    zzu = zzjv.zzv(j2);
                }
                zzjp.zzapm = zzu;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:150:0x0198 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x02af A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0006 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0006 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzhz
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(com.google.android.gms.internal.ads.zzia r25, com.google.android.gms.internal.ads.zzif r26) throws java.io.IOException, java.lang.InterruptedException {
        /*
        // Method dump skipped, instructions count: 698
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjn.zza(com.google.android.gms.internal.ads.zzia, com.google.android.gms.internal.ads.zzif):int");
    }

    @Override // com.google.android.gms.internal.ads.zzig
    public final long getDurationUs() {
        return this.zzaan;
    }

    @Override // com.google.android.gms.internal.ads.zzig
    public final long zzr(long j) {
        long j2 = Long.MAX_VALUE;
        for (zzjp zzjp : this.zzasg) {
            zzjv zzjv = zzjp.zzasi;
            int zzu = zzjv.zzu(j);
            if (zzu == -1) {
                zzu = zzjv.zzv(j);
            }
            long j3 = zzjv.zzagu[zzu];
            if (j3 < j2) {
                j2 = j3;
            }
        }
        return j2;
    }

    private final void zzei() {
        this.zzaqe = 0;
        this.zzaqh = 0;
    }

    private final void zzt(long j) throws zzfx {
        zzjs zza;
        while (!this.zzaqc.isEmpty() && this.zzaqc.peek().zzaop == j) {
            zziw pop = this.zzaqc.pop();
            if (pop.type == zziv.zzamb) {
                long j2 = -9223372036854775807L;
                ArrayList arrayList = new ArrayList();
                zzki zzki = null;
                zzid zzid = new zzid();
                zzix zzai = pop.zzai(zziv.zzaoa);
                if (!(zzai == null || (zzki = zziy.zza(zzai, this.zzash)) == null)) {
                    zzid.zzb(zzki);
                }
                for (int i = 0; i < pop.zzaor.size(); i++) {
                    zziw zziw = pop.zzaor.get(i);
                    if (zziw.type == zziv.zzamd && (zza = zziy.zza(zziw, pop.zzai(zziv.zzamc), -9223372036854775807L, (zzhp) null, this.zzash)) != null) {
                        zzjv zza2 = zziy.zza(zza, zziw.zzaj(zziv.zzame).zzaj(zziv.zzamf).zzaj(zziv.zzamg), zzid);
                        if (zza2.zzapk != 0) {
                            zzjp zzjp = new zzjp(zza, zza2, this.zzajq.zzb(i, zza.type));
                            zzfs zzj = zza.zzaad.zzj(zza2.zzapp + 30);
                            if (zza.type == 1) {
                                if (zzid.zzea()) {
                                    zzj = zzj.zza(zzid.zzzw, zzid.zzzx);
                                }
                                if (zzki != null) {
                                    zzj = zzj.zza(zzki);
                                }
                            }
                            zzjp.zzasj.zzf(zzj);
                            j2 = Math.max(j2, zza.zzaan);
                            arrayList.add(zzjp);
                        }
                    }
                }
                this.zzaan = j2;
                this.zzasg = (zzjp[]) arrayList.toArray(new zzjp[arrayList.size()]);
                this.zzajq.zzdy();
                this.zzajq.zza(this);
                this.zzaqc.clear();
                this.zzaqe = 2;
            } else if (!this.zzaqc.isEmpty()) {
                this.zzaqc.peek().zza(pop);
            }
        }
        if (this.zzaqe != 2) {
            zzei();
        }
    }
}
