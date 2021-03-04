package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import java.io.IOException;

/* access modifiers changed from: package-private */
public final class zzfn implements Handler.Callback, zzln, zzlp, zzoq {
    private final Handler handler;
    private int repeatMode = 0;
    private int state;
    private final zzfz[] zzwu;
    private final zzop zzwv;
    private final Handler zzwx;
    private final zzgf zzxa;
    private final zzge zzxb;
    private boolean zzxd;
    private boolean zzxh;
    private zzgc zzxi;
    private zzfy zzxm;
    private zzfp zzxn;
    private final zzga[] zzxs;
    private final zzfw zzxt;
    private final zzqa zzxu;
    private final HandlerThread zzxv;
    private final zzfg zzxw;
    private zzfz zzxx;
    private zzps zzxy;
    private zzlo zzxz;
    private zzfz[] zzya;
    private boolean zzyb;
    private boolean zzyc;
    private int zzyd;
    private int zzye;
    private long zzyf;
    private int zzyg;
    private zzfq zzyh;
    private long zzyi;
    private zzfo zzyj;
    private zzfo zzyk;
    private zzfo zzyl;

    public zzfn(zzfz[] zzfzArr, zzop zzop, zzfw zzfw, boolean z, int i, Handler handler2, zzfp zzfp, zzfg zzfg) {
        this.zzwu = zzfzArr;
        this.zzwv = zzop;
        this.zzxt = zzfw;
        this.zzxd = z;
        this.zzwx = handler2;
        this.state = 1;
        this.zzxn = zzfp;
        this.zzxw = zzfg;
        this.zzxs = new zzga[zzfzArr.length];
        for (int i2 = 0; i2 < zzfzArr.length; i2++) {
            zzfzArr[i2].setIndex(i2);
            this.zzxs[i2] = zzfzArr[i2].zzbe();
        }
        this.zzxu = new zzqa();
        this.zzya = new zzfz[0];
        this.zzxa = new zzgf();
        this.zzxb = new zzge();
        zzop.zza(this);
        this.zzxm = zzfy.zzaaf;
        this.zzxv = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.zzxv.start();
        this.handler = new Handler(this.zzxv.getLooper(), this);
    }

    public final void zza(zzlo zzlo, boolean z) {
        this.handler.obtainMessage(0, 1, 0, zzlo).sendToTarget();
    }

    public final void zzc(boolean z) {
        this.handler.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
    }

    public final void zza(zzgc zzgc, int i, long j) {
        this.handler.obtainMessage(3, new zzfq(zzgc, i, j)).sendToTarget();
    }

    public final void stop() {
        this.handler.sendEmptyMessage(5);
    }

    public final void zza(zzfj... zzfjArr) {
        if (this.zzyb) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            return;
        }
        this.zzyd++;
        this.handler.obtainMessage(11, zzfjArr).sendToTarget();
    }

    public final synchronized void zzb(zzfj... zzfjArr) {
        if (this.zzyb) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            return;
        }
        int i = this.zzyd;
        this.zzyd = i + 1;
        this.handler.obtainMessage(11, zzfjArr).sendToTarget();
        while (this.zzye <= i) {
            try {
                wait();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public final synchronized void release() {
        if (!this.zzyb) {
            this.handler.sendEmptyMessage(6);
            while (!this.zzyb) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
            this.zzxv.quit();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlp
    public final void zzb(zzgc zzgc, Object obj) {
        this.handler.obtainMessage(7, Pair.create(zzgc, obj)).sendToTarget();
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public final void zza(zzlm zzlm) {
        this.handler.obtainMessage(8, zzlm).sendToTarget();
    }

    @Override // com.google.android.gms.internal.ads.zzoq
    public final void zzbu() {
        this.handler.sendEmptyMessage(10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r36v0, types: [com.google.android.gms.internal.ads.zzfn, java.lang.Object, com.google.android.gms.internal.ads.zzlp, com.google.android.gms.internal.ads.zzln] */
    /* JADX WARN: Type inference failed for: r9v0, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r3v7, types: [android.os.Handler] */
    /* JADX WARN: Type inference failed for: r1v33, types: [com.google.android.gms.internal.ads.zzgc] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r2v22, types: [com.google.android.gms.internal.ads.zzgc] */
    /* JADX WARN: Type inference failed for: r2v70, types: [com.google.android.gms.internal.ads.zzgc] */
    /* JADX WARN: Type inference failed for: r2v72, types: [com.google.android.gms.internal.ads.zzgc] */
    /* JADX WARN: Type inference failed for: r7v18, types: [com.google.android.gms.internal.ads.zzgc] */
    /* JADX WARN: Type inference failed for: r2v83, types: [com.google.android.gms.internal.ads.zzgc] */
    /* JADX WARN: Type inference failed for: r3v54, types: [android.os.Handler] */
    /* JADX WARN: Type inference failed for: r2v101, types: [android.os.Handler] */
    /* JADX WARN: Type inference failed for: r2v107, types: [android.os.Handler] */
    /* JADX WARN: Type inference failed for: r1v132, types: [android.os.Handler] */
    /* JADX WARN: Type inference failed for: r6v24, types: [com.google.android.gms.internal.ads.zzgc] */
    /* JADX WARN: Type inference failed for: r1v148, types: [com.google.android.gms.internal.ads.zzfo] */
    /* JADX WARN: Type inference failed for: r3v89, types: [com.google.android.gms.internal.ads.zzfo] */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARNING: Code restructure failed: missing block: B:485:0x08cd, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:486:0x08ce, code lost:
        android.util.Log.e("ExoPlayerImplInternal", "Internal runtime error.", r0);
        r36.zzwx.obtainMessage(8, com.google.android.gms.internal.ads.zzff.zza(r0)).sendToTarget();
        zzby();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:487:0x08e8, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:488:0x08e9, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:489:0x08ea, code lost:
        r3 = 8;
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:492:0x0905, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:493:0x0906, code lost:
        r3 = 8;
        r1 = r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x028f  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0292  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0296  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x0358  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x036c  */
    /* JADX WARNING: Removed duplicated region for block: B:305:0x05bf  */
    /* JADX WARNING: Removed duplicated region for block: B:315:0x05db A[LOOP:7: B:315:0x05db->B:319:0x05ed, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:426:0x07f6  */
    /* JADX WARNING: Removed duplicated region for block: B:485:0x08cd A[ExcHandler: RuntimeException (r0v2 'e' java.lang.RuntimeException A[CUSTOM_DECLARE]), Splitter:B:1:0x0005] */
    /* JADX WARNING: Unknown variable types count: 15 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleMessage(android.os.Message r37) {
        /*
        // Method dump skipped, instructions count: 2364
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfn.handleMessage(android.os.Message):boolean");
    }

    private final void setState(int i) {
        if (this.state != i) {
            this.state = i;
            this.zzwx.obtainMessage(1, i, 0).sendToTarget();
        }
    }

    private final void zze(boolean z) {
        if (this.zzxh != z) {
            this.zzxh = z;
            this.zzwx.obtainMessage(2, z ? 1 : 0, 0).sendToTarget();
        }
    }

    private final void zzbv() throws zzff {
        this.zzyc = false;
        this.zzxu.start();
        for (zzfz zzfz : this.zzya) {
            zzfz.start();
        }
    }

    private final void zzbw() throws zzff {
        this.zzxu.stop();
        for (zzfz zzfz : this.zzya) {
            zza(zzfz);
        }
    }

    private final void zzbx() throws zzff {
        long j;
        zzfo zzfo = this.zzyl;
        if (zzfo != null) {
            long zzey = zzfo.zzym.zzey();
            if (zzey != -9223372036854775807L) {
                zzh(zzey);
            } else {
                zzfz zzfz = this.zzxx;
                if (zzfz == null || zzfz.zzcj()) {
                    this.zzyi = this.zzxu.zzde();
                } else {
                    this.zzyi = this.zzxy.zzde();
                    this.zzxu.zzam(this.zzyi);
                }
                zzey = this.zzyi - this.zzyl.zzcb();
            }
            this.zzxn.zzyz = zzey;
            this.zzyf = SystemClock.elapsedRealtime() * 1000;
            if (this.zzya.length == 0) {
                j = Long.MIN_VALUE;
            } else {
                j = this.zzyl.zzym.zzez();
            }
            zzfp zzfp = this.zzxn;
            if (j == Long.MIN_VALUE) {
                j = this.zzxi.zza(this.zzyl.zzyr, this.zzxb, false).zzaan;
            }
            zzfp.zzza = j;
        }
    }

    private final void zza(long j, long j2) {
        this.handler.removeMessages(2);
        long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.handler.sendEmptyMessage(2);
        } else {
            this.handler.sendEmptyMessageDelayed(2, elapsedRealtime);
        }
    }

    private final long zza(int i, long j) throws zzff {
        zzfo zzfo;
        zzbw();
        this.zzyc = false;
        setState(2);
        zzfo zzfo2 = this.zzyl;
        if (zzfo2 == null) {
            zzfo zzfo3 = this.zzyj;
            if (zzfo3 != null) {
                zzfo3.release();
            }
            zzfo = null;
        } else {
            zzfo = null;
            while (zzfo2 != null) {
                if (zzfo2.zzyr != i || !zzfo2.zzyu) {
                    zzfo2.release();
                } else {
                    zzfo = zzfo2;
                }
                zzfo2 = zzfo2.zzyw;
            }
        }
        zzfo zzfo4 = this.zzyl;
        if (!(zzfo4 == zzfo && zzfo4 == this.zzyk)) {
            for (zzfz zzfz : this.zzya) {
                zzfz.disable();
            }
            this.zzya = new zzfz[0];
            this.zzxy = null;
            this.zzxx = null;
            this.zzyl = null;
        }
        if (zzfo != null) {
            zzfo.zzyw = null;
            this.zzyj = zzfo;
            this.zzyk = zzfo;
            zzb(zzfo);
            if (this.zzyl.zzyv) {
                j = this.zzyl.zzym.zzab(j);
            }
            zzh(j);
            zzca();
        } else {
            this.zzyj = null;
            this.zzyk = null;
            this.zzyl = null;
            zzh(j);
        }
        this.handler.sendEmptyMessage(2);
        return j;
    }

    private final void zzh(long j) throws zzff {
        long j2;
        zzfo zzfo = this.zzyl;
        if (zzfo == null) {
            j2 = j + 60000000;
        } else {
            j2 = j + zzfo.zzcb();
        }
        this.zzyi = j2;
        this.zzxu.zzam(this.zzyi);
        for (zzfz zzfz : this.zzya) {
            zzfz.zzd(this.zzyi);
        }
    }

    private final void zzby() {
        zzf(true);
        this.zzxt.onStopped();
        setState(1);
    }

    private final void zzf(boolean z) {
        this.handler.removeMessages(2);
        this.zzyc = false;
        this.zzxu.stop();
        this.zzxy = null;
        this.zzxx = null;
        this.zzyi = 60000000;
        zzfz[] zzfzArr = this.zzya;
        for (zzfz zzfz : zzfzArr) {
            try {
                zza(zzfz);
                zzfz.disable();
            } catch (zzff | RuntimeException e) {
                Log.e("ExoPlayerImplInternal", "Stop failed.", e);
            }
        }
        this.zzya = new zzfz[0];
        zzfo zzfo = this.zzyl;
        if (zzfo == null) {
            zzfo = this.zzyj;
        }
        zza(zzfo);
        this.zzyj = null;
        this.zzyk = null;
        this.zzyl = null;
        zze(false);
        if (z) {
            zzlo zzlo = this.zzxz;
            if (zzlo != null) {
                zzlo.zzfh();
                this.zzxz = null;
            }
            this.zzxi = null;
        }
    }

    private static void zza(zzfz zzfz) throws zzff {
        if (zzfz.getState() == 2) {
            zzfz.stop();
        }
    }

    private final boolean zzi(long j) {
        if (j == -9223372036854775807L || this.zzxn.zzyz < j) {
            return true;
        }
        return this.zzyl.zzyw != null && this.zzyl.zzyw.zzyu;
    }

    private final void zzbz() throws IOException {
        zzfo zzfo = this.zzyj;
        if (!(zzfo == null || zzfo.zzyu)) {
            zzfo zzfo2 = this.zzyk;
            if (zzfo2 == null || zzfo2.zzyw == this.zzyj) {
                for (zzfz zzfz : this.zzya) {
                    if (!zzfz.zzbh()) {
                        return;
                    }
                }
                this.zzyj.zzym.zzew();
            }
        }
    }

    private final void zza(Object obj, int i) {
        this.zzxn = new zzfp(0, 0);
        zzb(obj, i);
        this.zzxn = new zzfp(0, -9223372036854775807L);
        setState(4);
        zzf(false);
    }

    private final void zzb(Object obj, int i) {
        this.zzwx.obtainMessage(6, new zzfr(this.zzxi, obj, this.zzxn, i)).sendToTarget();
    }

    private final int zza(int i, zzgc zzgc, zzgc zzgc2) {
        int zzcl = zzgc.zzcl();
        int i2 = i;
        int i3 = -1;
        for (int i4 = 0; i4 < zzcl && i3 == -1; i4++) {
            i2 = zzgc.zza(i2, this.zzxb, this.zzxa, this.repeatMode);
            i3 = zzgc2.zzc(zzgc.zza(i2, this.zzxb, true).zzyn);
        }
        return i3;
    }

    private final boolean zzi(int i) {
        this.zzxi.zza(i, this.zzxb, false);
        if (this.zzxi.zza(0, this.zzxa, false, 0L).zzaat || this.zzxi.zza(i, this.zzxb, this.zzxa, this.repeatMode) != -1) {
            return false;
        }
        return true;
    }

    private final Pair<Integer, Long> zza(zzfq zzfq) {
        zzgc zzgc = zzfq.zzxi;
        if (zzgc.isEmpty()) {
            zzgc = this.zzxi;
        }
        try {
            Pair<Integer, Long> zzb = zzb(zzgc, zzfq.zzzb, zzfq.zzzc);
            zzgc zzgc2 = this.zzxi;
            if (zzgc2 == zzgc) {
                return zzb;
            }
            int zzc = zzgc2.zzc(zzgc.zza(((Integer) zzb.first).intValue(), this.zzxb, true).zzyn);
            if (zzc != -1) {
                return Pair.create(Integer.valueOf(zzc), (Long) zzb.second);
            }
            int zza = zza(((Integer) zzb.first).intValue(), zzgc, this.zzxi);
            if (zza == -1) {
                return null;
            }
            this.zzxi.zza(zza, this.zzxb, false);
            return zzb(0, -9223372036854775807L);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzfv(this.zzxi, zzfq.zzzb, zzfq.zzzc);
        }
    }

    private final Pair<Integer, Long> zzb(int i, long j) {
        return zzb(this.zzxi, i, -9223372036854775807L);
    }

    private final Pair<Integer, Long> zzb(zzgc zzgc, int i, long j) {
        return zza(zzgc, i, j, 0);
    }

    private final Pair<Integer, Long> zza(zzgc zzgc, int i, long j, long j2) {
        zzpo.zzc(i, 0, zzgc.zzck());
        zzgc.zza(i, this.zzxa, false, j2);
        if (j == -9223372036854775807L) {
            j = this.zzxa.zzaaw;
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        long j3 = this.zzxa.zzaax + j;
        long j4 = zzgc.zza(0, this.zzxb, false).zzaan;
        int i2 = 0;
        while (j4 != -9223372036854775807L && j3 >= j4 && i2 < this.zzxa.zzaav) {
            j3 -= j4;
            i2++;
            j4 = zzgc.zza(i2, this.zzxb, false).zzaan;
        }
        return Pair.create(Integer.valueOf(i2), Long.valueOf(j3));
    }

    private final void zzca() {
        long j;
        if (!this.zzyj.zzyu) {
            j = 0;
        } else {
            j = this.zzyj.zzym.zzeu();
        }
        if (j == Long.MIN_VALUE) {
            zze(false);
            return;
        }
        long zzcb = this.zzyi - this.zzyj.zzcb();
        boolean zzk = this.zzxt.zzk(j - zzcb);
        zze(zzk);
        if (zzk) {
            this.zzyj.zzym.zzy(zzcb);
        }
    }

    private static void zza(zzfo zzfo) {
        while (zzfo != null) {
            zzfo.release();
            zzfo = zzfo.zzyw;
        }
    }

    private final void zzb(zzfo zzfo) throws zzff {
        if (this.zzyl != zzfo) {
            boolean[] zArr = new boolean[this.zzwu.length];
            int i = 0;
            int i2 = 0;
            while (true) {
                zzfz[] zzfzArr = this.zzwu;
                if (i < zzfzArr.length) {
                    zzfz zzfz = zzfzArr[i];
                    zArr[i] = zzfz.getState() != 0;
                    zzom zzbe = zzfo.zzyx.zzbfl.zzbe(i);
                    if (zzbe != null) {
                        i2++;
                    }
                    if (zArr[i] && (zzbe == null || (zzfz.zzbj() && zzfz.zzbg() == this.zzyl.zzyo[i]))) {
                        if (zzfz == this.zzxx) {
                            this.zzxu.zza(this.zzxy);
                            this.zzxy = null;
                            this.zzxx = null;
                        }
                        zza(zzfz);
                        zzfz.disable();
                    }
                    i++;
                } else {
                    this.zzyl = zzfo;
                    this.zzwx.obtainMessage(3, zzfo.zzyx).sendToTarget();
                    zza(zArr, i2);
                    return;
                }
            }
        }
    }

    private final void zza(boolean[] zArr, int i) throws zzff {
        this.zzya = new zzfz[i];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            zzfz[] zzfzArr = this.zzwu;
            if (i2 < zzfzArr.length) {
                zzfz zzfz = zzfzArr[i2];
                zzom zzbe = this.zzyl.zzyx.zzbfl.zzbe(i2);
                if (zzbe != null) {
                    int i4 = i3 + 1;
                    this.zzya[i3] = zzfz;
                    if (zzfz.getState() == 0) {
                        zzgb zzgb = this.zzyl.zzyx.zzbfn[i2];
                        boolean z = this.zzxd && this.state == 3;
                        boolean z2 = !zArr[i2] && z;
                        zzfs[] zzfsArr = new zzfs[zzbe.length()];
                        for (int i5 = 0; i5 < zzfsArr.length; i5++) {
                            zzfsArr[i5] = zzbe.zzat(i5);
                        }
                        zzfz.zza(zzgb, zzfsArr, this.zzyl.zzyo[i2], this.zzyi, z2, this.zzyl.zzcb());
                        zzps zzbf = zzfz.zzbf();
                        if (zzbf != null) {
                            if (this.zzxy == null) {
                                this.zzxy = zzbf;
                                this.zzxx = zzfz;
                                this.zzxy.zzb(this.zzxm);
                            } else {
                                throw zzff.zza(new IllegalStateException("Multiple renderer media clocks enabled."));
                            }
                        }
                        if (z) {
                            zzfz.start();
                        }
                    }
                    i3 = i4;
                }
                i2++;
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzlw] */
    @Override // com.google.android.gms.internal.ads.zzlx
    public final /* synthetic */ void zza(zzlm zzlm) {
        this.handler.obtainMessage(9, zzlm).sendToTarget();
    }
}
