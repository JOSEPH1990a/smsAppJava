package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import java.io.IOException;

/* access modifiers changed from: package-private */
public final class zzlc implements zzib, zzlm, zzlu, zzpg<zzlh> {
    private final Handler handler;
    private final Uri uri;
    private long zzaan;
    private final zzov zzagy;
    private final int zzawn;
    private final zzll zzawo;
    private final zzlp zzawp;
    private final zzot zzawq;
    private final String zzawr;
    private final long zzaws;
    private final zzpf zzawt = new zzpf("Loader:ExtractorMediaPeriod");
    private final zzli zzawu;
    private final zzpq zzawv;
    private final Runnable zzaww;
    private final Runnable zzawx;
    private final SparseArray<zzls> zzawy;
    private zzln zzawz;
    private zzig zzaxa;
    private boolean zzaxb;
    private boolean zzaxc;
    private boolean zzaxd;
    private int zzaxe;
    private zzma zzaxf;
    private boolean[] zzaxg;
    private boolean[] zzaxh;
    private boolean zzaxi;
    private long zzaxj;
    private long zzaxk;
    private int zzaxl;
    private boolean zzaxm;
    private long zzcc;
    private final Handler zzwx;
    private boolean zzyb;
    private boolean zzyu;

    public zzlc(Uri uri2, zzov zzov, zzhz[] zzhzArr, int i, Handler handler2, zzll zzll, zzlp zzlp, zzot zzot, String str, int i2) {
        this.uri = uri2;
        this.zzagy = zzov;
        this.zzawn = i;
        this.zzwx = handler2;
        this.zzawo = zzll;
        this.zzawp = zzlp;
        this.zzawq = zzot;
        this.zzawr = str;
        this.zzaws = (long) i2;
        this.zzawu = new zzli(zzhzArr, this);
        this.zzawv = new zzpq();
        this.zzaww = new zzld(this);
        this.zzawx = new zzle(this);
        this.handler = new Handler();
        this.zzaxk = -9223372036854775807L;
        this.zzawy = new SparseArray<>();
        this.zzcc = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzlm
    public final void zzaa(long j) {
    }

    public final void release() {
        this.zzawt.zza(new zzlf(this, this.zzawu));
        this.handler.removeCallbacksAndMessages(null);
        this.zzyb = true;
    }

    @Override // com.google.android.gms.internal.ads.zzlm
    public final void zza(zzln zzln, long j) {
        this.zzawz = zzln;
        this.zzawv.zzgz();
        startLoading();
    }

    @Override // com.google.android.gms.internal.ads.zzlm
    public final void zzew() throws IOException {
        this.zzawt.zzbi(Integer.MIN_VALUE);
    }

    @Override // com.google.android.gms.internal.ads.zzlm
    public final zzma zzex() {
        return this.zzaxf;
    }

    @Override // com.google.android.gms.internal.ads.zzlm
    public final long zza(zzom[] zzomArr, boolean[] zArr, zzlv[] zzlvArr, boolean[] zArr2, long j) {
        zzpo.checkState(this.zzyu);
        for (int i = 0; i < zzomArr.length; i++) {
            if (zzlvArr[i] != null && (zzomArr[i] == null || !zArr[i])) {
                int i2 = ((zzlj) zzlvArr[i]).track;
                zzpo.checkState(this.zzaxg[i2]);
                this.zzaxe--;
                this.zzaxg[i2] = false;
                this.zzawy.valueAt(i2).disable();
                zzlvArr[i] = null;
            }
        }
        boolean z = false;
        for (int i3 = 0; i3 < zzomArr.length; i3++) {
            if (zzlvArr[i3] == null && zzomArr[i3] != null) {
                zzom zzom = zzomArr[i3];
                zzpo.checkState(zzom.length() == 1);
                zzpo.checkState(zzom.zzbd(0) == 0);
                int zza = this.zzaxf.zza(zzom.zzgk());
                zzpo.checkState(!this.zzaxg[zza]);
                this.zzaxe++;
                this.zzaxg[zza] = true;
                zzlvArr[i3] = new zzlj(this, zza);
                zArr2[i3] = true;
                z = true;
            }
        }
        if (!this.zzaxc) {
            int size = this.zzawy.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (!this.zzaxg[i4]) {
                    this.zzawy.valueAt(i4).disable();
                }
            }
        }
        if (this.zzaxe == 0) {
            this.zzaxd = false;
            if (this.zzawt.isLoading()) {
                this.zzawt.zzgy();
            }
        } else if (!this.zzaxc ? j != 0 : z) {
            j = zzab(j);
            for (int i5 = 0; i5 < zzlvArr.length; i5++) {
                if (zzlvArr[i5] != null) {
                    zArr2[i5] = true;
                }
            }
        }
        this.zzaxc = true;
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzlw, com.google.android.gms.internal.ads.zzlm
    public final boolean zzy(long j) {
        if (this.zzaxm) {
            return false;
        }
        if (this.zzyu && this.zzaxe == 0) {
            return false;
        }
        boolean zzgz = this.zzawv.zzgz();
        if (this.zzawt.isLoading()) {
            return zzgz;
        }
        startLoading();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzlw, com.google.android.gms.internal.ads.zzlm
    public final long zzeu() {
        if (this.zzaxe == 0) {
            return Long.MIN_VALUE;
        }
        return zzez();
    }

    @Override // com.google.android.gms.internal.ads.zzlm
    public final long zzey() {
        if (!this.zzaxd) {
            return -9223372036854775807L;
        }
        this.zzaxd = false;
        return this.zzaxj;
    }

    @Override // com.google.android.gms.internal.ads.zzlm
    public final long zzez() {
        long j;
        if (this.zzaxm) {
            return Long.MIN_VALUE;
        }
        if (zzfd()) {
            return this.zzaxk;
        }
        if (this.zzaxi) {
            j = Long.MAX_VALUE;
            int size = this.zzawy.size();
            for (int i = 0; i < size; i++) {
                if (this.zzaxh[i]) {
                    j = Math.min(j, this.zzawy.valueAt(i).zzfc());
                }
            }
        } else {
            j = zzfc();
        }
        return j == Long.MIN_VALUE ? this.zzaxj : j;
    }

    @Override // com.google.android.gms.internal.ads.zzlm
    public final long zzab(long j) {
        if (!this.zzaxa.zzdw()) {
            j = 0;
        }
        this.zzaxj = j;
        int size = this.zzawy.size();
        boolean z = !zzfd();
        int i = 0;
        while (z && i < size) {
            if (this.zzaxg[i]) {
                z = this.zzawy.valueAt(i).zze(j, false);
            }
            i++;
        }
        if (!z) {
            this.zzaxk = j;
            this.zzaxm = false;
            if (this.zzawt.isLoading()) {
                this.zzawt.zzgy();
            } else {
                for (int i2 = 0; i2 < size; i2++) {
                    this.zzawy.valueAt(i2).zzh(this.zzaxg[i2]);
                }
            }
        }
        this.zzaxd = false;
        return j;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzap(int i) {
        if (!this.zzaxm) {
            return !zzfd() && this.zzawy.valueAt(i).zzfm();
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void zzev() throws IOException {
        this.zzawt.zzbi(Integer.MIN_VALUE);
    }

    /* access modifiers changed from: package-private */
    public final int zza(int i, zzfu zzfu, zzho zzho, boolean z) {
        if (this.zzaxd || zzfd()) {
            return -3;
        }
        return this.zzawy.valueAt(i).zza(zzfu, zzho, z, this.zzaxm, this.zzaxj);
    }

    /* access modifiers changed from: package-private */
    public final void zzd(int i, long j) {
        zzls valueAt = this.zzawy.valueAt(i);
        if (!this.zzaxm || j <= valueAt.zzfc()) {
            valueAt.zze(j, true);
        } else {
            valueAt.zzfp();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzib
    public final zzii zzb(int i, int i2) {
        zzls zzls = this.zzawy.get(i);
        if (zzls != null) {
            return zzls;
        }
        zzls zzls2 = new zzls(this.zzawq);
        zzls2.zza(this);
        this.zzawy.put(i, zzls2);
        return zzls2;
    }

    @Override // com.google.android.gms.internal.ads.zzib
    public final void zzdy() {
        this.zzaxb = true;
        this.handler.post(this.zzaww);
    }

    @Override // com.google.android.gms.internal.ads.zzib
    public final void zza(zzig zzig) {
        this.zzaxa = zzig;
        this.handler.post(this.zzaww);
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public final void zzg(zzfs zzfs) {
        this.handler.post(this.zzaww);
    }

    /* access modifiers changed from: private */
    public final void zzfa() {
        if (!this.zzyb && !this.zzyu && this.zzaxa != null && this.zzaxb) {
            int size = this.zzawy.size();
            for (int i = 0; i < size; i++) {
                if (this.zzawy.valueAt(i).zzfn() == null) {
                    return;
                }
            }
            this.zzawv.zzha();
            zzlz[] zzlzArr = new zzlz[size];
            this.zzaxh = new boolean[size];
            this.zzaxg = new boolean[size];
            this.zzaan = this.zzaxa.getDurationUs();
            int i2 = 0;
            while (true) {
                boolean z = true;
                if (i2 < size) {
                    zzfs zzfn = this.zzawy.valueAt(i2).zzfn();
                    zzlzArr[i2] = new zzlz(zzfn);
                    String str = zzfn.zzzj;
                    if (!zzpt.zzac(str) && !zzpt.zzab(str)) {
                        z = false;
                    }
                    this.zzaxh[i2] = z;
                    this.zzaxi = z | this.zzaxi;
                    i2++;
                } else {
                    this.zzaxf = new zzma(zzlzArr);
                    this.zzyu = true;
                    this.zzawp.zzb(new zzly(this.zzaan, this.zzaxa.zzdw()), null);
                    this.zzawz.zza((zzlm) this);
                    return;
                }
            }
        }
    }

    private final void zza(zzlh zzlh) {
        if (this.zzcc == -1) {
            this.zzcc = zzlh.zzcc;
        }
    }

    private final void startLoading() {
        zzig zzig;
        zzlh zzlh = new zzlh(this, this.uri, this.zzagy, this.zzawu, this.zzawv);
        if (this.zzyu) {
            zzpo.checkState(zzfd());
            long j = this.zzaan;
            if (j == -9223372036854775807L || this.zzaxk < j) {
                zzlh.zze(this.zzaxa.zzr(this.zzaxk), this.zzaxk);
                this.zzaxk = -9223372036854775807L;
            } else {
                this.zzaxm = true;
                this.zzaxk = -9223372036854775807L;
                return;
            }
        }
        this.zzaxl = zzfb();
        int i = this.zzawn;
        if (i == -1) {
            i = (this.zzyu && this.zzcc == -1 && ((zzig = this.zzaxa) == null || zzig.getDurationUs() == -9223372036854775807L)) ? 6 : 3;
        }
        this.zzawt.zza(zzlh, this, i);
    }

    private final int zzfb() {
        int size = this.zzawy.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.zzawy.valueAt(i2).zzfk();
        }
        return i;
    }

    private final long zzfc() {
        int size = this.zzawy.size();
        long j = Long.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            j = Math.max(j, this.zzawy.valueAt(i).zzfc());
        }
        return j;
    }

    private final boolean zzfd() {
        return this.zzaxk != -9223372036854775807L;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzpi, long, long, java.io.IOException] */
    @Override // com.google.android.gms.internal.ads.zzpg
    public final /* synthetic */ int zza(zzlh zzlh, long j, long j2, IOException iOException) {
        zzig zzig;
        zzlh zzlh2 = zzlh;
        zza(zzlh2);
        Handler handler2 = this.zzwx;
        if (!(handler2 == null || this.zzawo == null)) {
            handler2.post(new zzlg(this, iOException));
        }
        if (iOException instanceof zzmb) {
            return 3;
        }
        boolean z = zzfb() > this.zzaxl;
        if (this.zzcc == -1 && ((zzig = this.zzaxa) == null || zzig.getDurationUs() == -9223372036854775807L)) {
            this.zzaxj = 0;
            this.zzaxd = this.zzyu;
            int size = this.zzawy.size();
            for (int i = 0; i < size; i++) {
                this.zzawy.valueAt(i).zzh(!this.zzyu || this.zzaxg[i]);
            }
            zzlh2.zze(0, 0);
        }
        this.zzaxl = zzfb();
        return z ? 1 : 0;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzpi, long, long, boolean] */
    @Override // com.google.android.gms.internal.ads.zzpg
    public final /* synthetic */ void zza(zzlh zzlh, long j, long j2, boolean z) {
        zza(zzlh);
        if (!z && this.zzaxe > 0) {
            int size = this.zzawy.size();
            for (int i = 0; i < size; i++) {
                this.zzawy.valueAt(i).zzh(this.zzaxg[i]);
            }
            this.zzawz.zza((zzlw) this);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzpi, long, long] */
    @Override // com.google.android.gms.internal.ads.zzpg
    public final /* synthetic */ void zza(zzlh zzlh, long j, long j2) {
        zza(zzlh);
        this.zzaxm = true;
        if (this.zzaan == -9223372036854775807L) {
            long zzfc = zzfc();
            this.zzaan = zzfc == Long.MIN_VALUE ? 0 : zzfc + 10000;
            this.zzawp.zzb(new zzly(this.zzaan, this.zzaxa.zzdw()), null);
        }
        this.zzawz.zza((zzlw) this);
    }
}
