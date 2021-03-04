package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;

@TargetApi(16)
public final class zzqs {
    private final zzqt zzbjy;
    private final boolean zzbjz;
    private final long zzbka;
    private final long zzbkb;
    private long zzbkc;
    private long zzbkd;
    private long zzbke;
    private boolean zzbkf;
    private long zzbkg;
    private long zzbkh;
    private long zzbki;

    public zzqs() {
        this(-1.0d);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzqs(android.content.Context r3) {
        /*
            r2 = this;
            java.lang.String r0 = "window"
            java.lang.Object r3 = r3.getSystemService(r0)
            android.view.WindowManager r3 = (android.view.WindowManager) r3
            android.view.Display r0 = r3.getDefaultDisplay()
            if (r0 == 0) goto L_0x0018
            android.view.Display r3 = r3.getDefaultDisplay()
            float r3 = r3.getRefreshRate()
            double r0 = (double) r3
            goto L_0x001a
        L_0x0018:
            r0 = -4616189618054758400(0xbff0000000000000, double:-1.0)
        L_0x001a:
            r2.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqs.<init>(android.content.Context):void");
    }

    private zzqs(double d) {
        this.zzbjz = d != -1.0d;
        if (this.zzbjz) {
            this.zzbjy = zzqt.zzhv();
            this.zzbka = (long) (1.0E9d / d);
            this.zzbkb = (this.zzbka * 80) / 100;
            return;
        }
        this.zzbjy = null;
        this.zzbka = -1;
        this.zzbkb = -1;
    }

    public final void enable() {
        this.zzbkf = false;
        if (this.zzbjz) {
            this.zzbjy.zzhw();
        }
    }

    public final void disable() {
        if (this.zzbjz) {
            this.zzbjy.zzhx();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzh(long r12, long r14) {
        /*
        // Method dump skipped, instructions count: 135
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqs.zzh(long, long):long");
    }

    private final boolean zzi(long j, long j2) {
        return Math.abs((j2 - this.zzbkg) - (j - this.zzbkh)) > 20000000;
    }
}
