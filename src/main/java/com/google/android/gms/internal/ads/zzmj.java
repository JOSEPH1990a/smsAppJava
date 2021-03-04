package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzml;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class zzmj<T extends zzml> implements zzlv, zzlw, zzpg<zzme> {
    private final int zzawn;
    private final zzpf zzawt = new zzpf("Loader:ChunkSampleStream");
    long zzaxj;
    private long zzaxk;
    boolean zzaxm;
    private final int zzbac;
    private final int[] zzbad;
    private final boolean[] zzbae;
    private final T zzbaf;
    private final zzlx<zzmj<T>> zzbag;
    private final zzkt zzbah;
    private final zzmi zzbai = new zzmi();
    private final LinkedList<zzmc> zzbaj = new LinkedList<>();
    private final List<zzmc> zzbak = Collections.unmodifiableList(this.zzbaj);
    private final zzls zzbal;
    private final zzls[] zzbam;
    private final zzmd zzban;
    private zzfs zzbao;

    public zzmj(int i, int[] iArr, T t, zzlx<zzmj<T>> zzlx, zzot zzot, long j, int i2, zzkt zzkt) {
        int i3;
        this.zzbac = i;
        this.zzbad = iArr;
        this.zzbaf = t;
        this.zzbag = zzlx;
        this.zzbah = zzkt;
        this.zzawn = i2;
        int i4 = 0;
        if (iArr == null) {
            i3 = 0;
        } else {
            i3 = iArr.length;
        }
        this.zzbam = new zzls[i3];
        this.zzbae = new boolean[i3];
        int i5 = i3 + 1;
        int[] iArr2 = new int[i5];
        zzls[] zzlsArr = new zzls[i5];
        this.zzbal = new zzls(zzot);
        iArr2[0] = i;
        zzlsArr[0] = this.zzbal;
        while (i4 < i3) {
            zzls zzls = new zzls(zzot);
            this.zzbam[i4] = zzls;
            int i6 = i4 + 1;
            zzlsArr[i6] = zzls;
            iArr2[i6] = iArr[i4];
            i4 = i6;
        }
        this.zzban = new zzmd(iArr2, zzlsArr);
        this.zzaxk = j;
        this.zzaxj = j;
    }

    public final void zzaf(long j) {
        int i = 0;
        while (true) {
            zzls[] zzlsArr = this.zzbam;
            if (i < zzlsArr.length) {
                if (!this.zzbae[i]) {
                    zzlsArr[i].zze(j, true);
                }
                i++;
            } else {
                return;
            }
        }
    }

    public final zzmk zza(long j, int i) {
        for (int i2 = 0; i2 < this.zzbam.length; i2++) {
            if (this.zzbad[i2] == i) {
                zzpo.checkState(!this.zzbae[i2]);
                this.zzbae[i2] = true;
                this.zzbam[i2].zze(j, true);
                return new zzmk(this, this, this.zzbam[i2], i2);
            }
        }
        throw new IllegalStateException();
    }

    public final T zzfy() {
        return this.zzbaf;
    }

    public final long zzez() {
        if (this.zzaxm) {
            return Long.MIN_VALUE;
        }
        if (zzfd()) {
            return this.zzaxk;
        }
        long j = this.zzaxj;
        zzmc last = this.zzbaj.getLast();
        if (!last.zzga()) {
            if (this.zzbaj.size() > 1) {
                LinkedList<zzmc> linkedList = this.zzbaj;
                last = linkedList.get(linkedList.size() - 2);
            } else {
                last = null;
            }
        }
        if (last != null) {
            j = Math.max(j, last.zzazt);
        }
        return Math.max(j, this.zzbal.zzfc());
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0022 A[LOOP:0: B:11:0x0022->B:15:0x003e, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzag(long r7) {
        /*
        // Method dump skipped, instructions count: 124
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzmj.zzag(long):void");
    }

    public final void release() {
        this.zzbal.disable();
        for (zzls zzls : this.zzbam) {
            zzls.disable();
        }
        this.zzawt.zza((Runnable) null);
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final boolean isReady() {
        if (!this.zzaxm) {
            return !zzfd() && this.zzbal.zzfm();
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final void zzev() throws IOException {
        this.zzawt.zzbi(Integer.MIN_VALUE);
        if (!this.zzawt.isLoading()) {
            this.zzbaf.zzev();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final int zzb(zzfu zzfu, zzho zzho, boolean z) {
        if (zzfd()) {
            return -3;
        }
        int zzfl = this.zzbal.zzfl();
        if (!this.zzbaj.isEmpty()) {
            while (this.zzbaj.size() > 1 && this.zzbaj.get(1).zzav(0) <= zzfl) {
                this.zzbaj.removeFirst();
            }
            zzmc first = this.zzbaj.getFirst();
            zzfs zzfs = first.zzazp;
            if (!zzfs.equals(this.zzbao)) {
                this.zzbah.zzb(this.zzbac, zzfs, first.zzazq, first.zzazr, first.zzazs);
            }
            this.zzbao = zzfs;
        }
        return this.zzbal.zza(zzfu, zzho, z, this.zzaxm, this.zzaxj);
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public final void zzz(long j) {
        if (!this.zzaxm || j <= this.zzbal.zzfc()) {
            this.zzbal.zze(j, true);
        } else {
            this.zzbal.zzfp();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlw
    public final boolean zzy(long j) {
        if (this.zzaxm || this.zzawt.isLoading()) {
            return false;
        }
        T t = this.zzbaf;
        zzmc last = this.zzbaj.isEmpty() ? null : this.zzbaj.getLast();
        long j2 = this.zzaxk;
        if (j2 == -9223372036854775807L) {
            j2 = j;
        }
        t.zza(last, j2, this.zzbai);
        boolean z = this.zzbai.zzbab;
        zzme zzme = this.zzbai.zzbaa;
        zzmi zzmi = this.zzbai;
        zzmi.zzbaa = null;
        zzmi.zzbab = false;
        if (z) {
            this.zzaxk = -9223372036854775807L;
            this.zzaxm = true;
            return true;
        } else if (zzme == null) {
            return false;
        } else {
            if (zzme instanceof zzmc) {
                this.zzaxk = -9223372036854775807L;
                zzmc zzmc = (zzmc) zzme;
                zzmc.zza(this.zzban);
                this.zzbaj.add(zzmc);
            }
            this.zzbah.zzb(zzme.zzazo, zzme.type, this.zzbac, zzme.zzazp, zzme.zzazq, zzme.zzazr, zzme.zzazs, zzme.zzazt, this.zzawt.zza(zzme, this, this.zzawn));
            return true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlw
    public final long zzeu() {
        if (zzfd()) {
            return this.zzaxk;
        }
        if (this.zzaxm) {
            return Long.MIN_VALUE;
        }
        return this.zzbaj.getLast().zzazt;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzfd() {
        return this.zzaxk != -9223372036854775807L;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzpi, long, long, java.io.IOException] */
    @Override // com.google.android.gms.internal.ads.zzpg
    public final /* synthetic */ int zza(zzme zzme, long j, long j2, IOException iOException) {
        boolean z;
        zzme zzme2 = zzme;
        long zzfv = zzme2.zzfv();
        boolean z2 = zzme2 instanceof zzmc;
        if (this.zzbaf.zza(zzme2, !z2 || zzfv == 0 || this.zzbaj.size() > 1, iOException)) {
            if (z2) {
                zzmc removeLast = this.zzbaj.removeLast();
                zzpo.checkState(removeLast == zzme2);
                this.zzbal.zzar(removeLast.zzav(0));
                int i = 0;
                while (true) {
                    zzls[] zzlsArr = this.zzbam;
                    if (i >= zzlsArr.length) {
                        break;
                    }
                    zzls zzls = zzlsArr[i];
                    i++;
                    zzls.zzar(removeLast.zzav(i));
                }
                if (this.zzbaj.isEmpty()) {
                    this.zzaxk = this.zzaxj;
                }
            }
            z = true;
        } else {
            z = false;
        }
        this.zzbah.zzb(zzme2.zzazo, zzme2.type, this.zzbac, zzme2.zzazp, zzme2.zzazq, zzme2.zzazr, zzme2.zzazs, zzme2.zzazt, j, j2, zzfv, iOException, z);
        if (!z) {
            return 0;
        }
        this.zzbag.zza(this);
        return 2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzpi, long, long, boolean] */
    @Override // com.google.android.gms.internal.ads.zzpg
    public final /* synthetic */ void zza(zzme zzme, long j, long j2, boolean z) {
        zzme zzme2 = zzme;
        this.zzbah.zzd(zzme2.zzazo, zzme2.type, this.zzbac, zzme2.zzazp, zzme2.zzazq, zzme2.zzazr, zzme2.zzazs, zzme2.zzazt, j, j2, zzme2.zzfv());
        if (!z) {
            this.zzbal.zzh(true);
            for (zzls zzls : this.zzbam) {
                zzls.zzh(true);
            }
            this.zzbag.zza(this);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzpi, long, long] */
    @Override // com.google.android.gms.internal.ads.zzpg
    public final /* synthetic */ void zza(zzme zzme, long j, long j2) {
        zzme zzme2 = zzme;
        this.zzbaf.zza(zzme2);
        this.zzbah.zzc(zzme2.zzazo, zzme2.type, this.zzbac, zzme2.zzazp, zzme2.zzazq, zzme2.zzazr, zzme2.zzazs, zzme2.zzazt, j, j2, zzme2.zzfv());
        this.zzbag.zza(this);
    }
}
