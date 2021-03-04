package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzbv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@zzark
public final class zzala implements zzakp {
    private final Context mContext;
    private final Object mLock = new Object();
    private final long mStartTime;
    private final zzalg zzbma;
    private final boolean zzbum;
    private final zzakr zzdmn;
    private final boolean zzdms;
    private final boolean zzdmt;
    private final zzasi zzdnh;
    private final long zzdni;
    private final int zzdnj;
    private boolean zzdnk = false;
    private final Map<zzbcb<zzakx>, zzaku> zzdnl = new HashMap();
    private final String zzdnm;
    private List<zzakx> zzdnn = new ArrayList();

    public zzala(Context context, zzasi zzasi, zzalg zzalg, zzakr zzakr, boolean z, boolean z2, String str, long j, long j2, int i, boolean z3) {
        this.mContext = context;
        this.zzdnh = zzasi;
        this.zzbma = zzalg;
        this.zzdmn = zzakr;
        this.zzbum = z;
        this.zzdms = z2;
        this.zzdnm = str;
        this.mStartTime = j;
        this.zzdni = j2;
        this.zzdnj = 2;
        this.zzdmt = z3;
    }

    @Override // com.google.android.gms.internal.ads.zzakp
    public final zzakx zzh(List<zzakq> list) {
        zzaxz.zzdn("Starting mediation.");
        ArrayList arrayList = new ArrayList();
        zzwf zzwf = this.zzdnh.zzbst;
        int[] iArr = new int[2];
        if (zzwf.zzckm != null) {
            zzbv.zzlz();
            if (zzakz.zza(this.zzdnm, iArr)) {
                int i = 0;
                int i2 = iArr[0];
                int i3 = iArr[1];
                zzwf[] zzwfArr = zzwf.zzckm;
                int length = zzwfArr.length;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    zzwf zzwf2 = zzwfArr[i];
                    if (i2 == zzwf2.width && i3 == zzwf2.height) {
                        zzwf = zzwf2;
                        break;
                    }
                    i++;
                }
            }
        }
        Iterator<zzakq> it = list.iterator();
        while (it.hasNext()) {
            zzakq next = it.next();
            String valueOf = String.valueOf(next.zzdkv);
            zzaxz.zzen(valueOf.length() != 0 ? "Trying mediation network: ".concat(valueOf) : new String("Trying mediation network: "));
            for (Iterator<String> it2 = next.zzdkw.iterator(); it2.hasNext(); it2 = it2) {
                zzaku zzaku = new zzaku(this.mContext, it2.next(), this.zzbma, this.zzdmn, next, this.zzdnh.zzdwg, zzwf, this.zzdnh.zzbsp, this.zzbum, this.zzdms, this.zzdnh.zzbti, this.zzdnh.zzbtt, this.zzdnh.zzdwu, this.zzdnh.zzdxp, this.zzdmt);
                zzbcb<zzakx> zza = zzayf.zza(new zzalb(this, zzaku));
                this.zzdnl.put(zza, zzaku);
                arrayList.add(zza);
                it = it;
                arrayList = arrayList;
            }
        }
        if (this.zzdnj != 2) {
            return zzi(arrayList);
        }
        return zzj(arrayList);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        if (r4.hasNext() == false) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        r0 = r4.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r1 = (com.google.android.gms.internal.ads.zzakx) r0.get();
        r3.zzdnn.add(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002b, code lost:
        if (r1 == null) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002f, code lost:
        if (r1.zzdna != 0) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0031, code lost:
        zza(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0034, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0035, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0036, code lost:
        com.google.android.gms.internal.ads.zzaxz.zzc("Exception while processing an adapter; continuing with other adapters", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003c, code lost:
        zza((com.google.android.gms.internal.ads.zzbcb<com.google.android.gms.internal.ads.zzakx>) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0046, code lost:
        return new com.google.android.gms.internal.ads.zzakx(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
        r4 = r4.iterator();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.ads.zzakx zzi(java.util.List<com.google.android.gms.internal.ads.zzbcb<com.google.android.gms.internal.ads.zzakx>> r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.mLock
            monitor-enter(r0)
            boolean r1 = r3.zzdnk     // Catch:{ all -> 0x0047 }
            if (r1 == 0) goto L_0x000f
            com.google.android.gms.internal.ads.zzakx r4 = new com.google.android.gms.internal.ads.zzakx     // Catch:{ all -> 0x0047 }
            r1 = -1
            r4.<init>(r1)     // Catch:{ all -> 0x0047 }
            monitor-exit(r0)     // Catch:{ all -> 0x0047 }
            return r4
        L_0x000f:
            monitor-exit(r0)     // Catch:{ all -> 0x0047 }
            java.util.Iterator r4 = r4.iterator()
        L_0x0014:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x003c
            java.lang.Object r0 = r4.next()
            com.google.android.gms.internal.ads.zzbcb r0 = (com.google.android.gms.internal.ads.zzbcb) r0
            java.lang.Object r1 = r0.get()     // Catch:{ InterruptedException | ExecutionException -> 0x0035 }
            com.google.android.gms.internal.ads.zzakx r1 = (com.google.android.gms.internal.ads.zzakx) r1     // Catch:{ InterruptedException | ExecutionException -> 0x0035 }
            java.util.List<com.google.android.gms.internal.ads.zzakx> r2 = r3.zzdnn     // Catch:{ InterruptedException | ExecutionException -> 0x0035 }
            r2.add(r1)     // Catch:{ InterruptedException | ExecutionException -> 0x0035 }
            if (r1 == 0) goto L_0x0014
            int r2 = r1.zzdna     // Catch:{ InterruptedException | ExecutionException -> 0x0035 }
            if (r2 != 0) goto L_0x0014
            r3.zza(r0)     // Catch:{ InterruptedException | ExecutionException -> 0x0035 }
            return r1
        L_0x0035:
            r0 = move-exception
            java.lang.String r1 = "Exception while processing an adapter; continuing with other adapters"
            com.google.android.gms.internal.ads.zzaxz.zzc(r1, r0)
            goto L_0x0014
        L_0x003c:
            r4 = 0
            r3.zza(r4)
            com.google.android.gms.internal.ads.zzakx r4 = new com.google.android.gms.internal.ads.zzakx
            r0 = 1
            r4.<init>(r0)
            return r4
        L_0x0047:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzala.zzi(java.util.List):com.google.android.gms.internal.ads.zzakx");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0018, code lost:
        if (r13.zzdmn.zzdmb == -1) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
        r0 = r13.zzdmn.zzdmb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        r0 = 10000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
        r14 = r14.iterator();
        r3 = null;
        r1 = r0;
        r0 = null;
        r4 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002d, code lost:
        if (r14.hasNext() == false) goto L_0x00a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        r5 = r14.next();
        r6 = com.google.android.gms.ads.internal.zzbv.zzlm().currentTimeMillis();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
        if (r1 != 0) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0047, code lost:
        if (r5.isDone() == false) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0049, code lost:
        r10 = (com.google.android.gms.internal.ads.zzakx) r5.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0050, code lost:
        r10 = (com.google.android.gms.internal.ads.zzakx) r5.get(r1, java.util.concurrent.TimeUnit.MILLISECONDS);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0058, code lost:
        r13.zzdnn.add(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005d, code lost:
        if (r10 == null) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0061, code lost:
        if (r10.zzdna != 0) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0063, code lost:
        r11 = r10.zzdnf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0065, code lost:
        if (r11 == null) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006b, code lost:
        if (r11.zzur() <= r4) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0071, code lost:
        r4 = r11.zzur();
        r3 = r5;
        r0 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0074, code lost:
        r1 = java.lang.Math.max(r1 - (com.google.android.gms.ads.internal.zzbv.zzlm().currentTimeMillis() - r6), 0L);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0083, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0085, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        com.google.android.gms.internal.ads.zzaxz.zzc("Exception while processing an adapter; continuing with other adapters", r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x008b, code lost:
        r1 = java.lang.Math.max(r1 - (com.google.android.gms.ads.internal.zzbv.zzlm().currentTimeMillis() - r6), 0L);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x009a, code lost:
        java.lang.Math.max(r1 - (com.google.android.gms.ads.internal.zzbv.zzlm().currentTimeMillis() - r6), 0L);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a7, code lost:
        throw r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a8, code lost:
        zza(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ab, code lost:
        if (r0 != null) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00b3, code lost:
        return new com.google.android.gms.internal.ads.zzakx(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00b4, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.ads.zzakx zzj(java.util.List<com.google.android.gms.internal.ads.zzbcb<com.google.android.gms.internal.ads.zzakx>> r14) {
        /*
        // Method dump skipped, instructions count: 185
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzala.zzj(java.util.List):com.google.android.gms.internal.ads.zzakx");
    }

    private final void zza(zzbcb<zzakx> zzbcb) {
        zzayh.zzelc.post(new zzalc(this, zzbcb));
    }

    @Override // com.google.android.gms.internal.ads.zzakp
    public final void cancel() {
        synchronized (this.mLock) {
            this.zzdnk = true;
            for (zzaku zzaku : this.zzdnl.values()) {
                zzaku.cancel();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzakp
    public final List<zzakx> zzui() {
        return this.zzdnn;
    }
}
