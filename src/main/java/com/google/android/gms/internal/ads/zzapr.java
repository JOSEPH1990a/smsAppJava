package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

@zzark
public final class zzapr extends zzaph {
    private final zzaba zzbln;
    private zzalg zzbma;
    private final zzbgg zzdin;
    private zzakr zzdmn;
    @VisibleForTesting
    private zzakp zzdsw;
    protected zzakx zzdsx;
    private boolean zzdsy;

    zzapr(Context context, zzaxg zzaxg, zzalg zzalg, zzapm zzapm, zzaba zzaba, zzbgg zzbgg) {
        super(context, zzaxg, zzapm);
        this.zzbma = zzalg;
        this.zzdmn = zzaxg.zzehj;
        this.zzbln = zzaba;
        this.zzdin = zzbgg;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzaph
    public final zzaxf zzcr(int i) {
        String str;
        String str2;
        boolean z;
        zzakr zzakr;
        long j;
        zzaso zzaso;
        String str3;
        zzakr zzakr2;
        Iterator<zzakx> it;
        zzakr zzakr3;
        int i2;
        zzasi zzasi = this.zzdsk.zzeag;
        zzwb zzwb = zzasi.zzdwg;
        zzbgg zzbgg = this.zzdin;
        List<String> list = this.zzdsl.zzdlq;
        List<String> list2 = this.zzdsl.zzdlr;
        List<String> list3 = this.zzdsl.zzdyf;
        int i3 = this.zzdsl.orientation;
        long j2 = this.zzdsl.zzdlx;
        String str4 = zzasi.zzdwj;
        boolean z2 = this.zzdsl.zzdyd;
        zzakx zzakx = this.zzdsx;
        zzakq zzakq = zzakx != null ? zzakx.zzdnb : null;
        zzakx zzakx2 = this.zzdsx;
        zzalj zzalj = zzakx2 != null ? zzakx2.zzdnc : null;
        zzakx zzakx3 = this.zzdsx;
        if (zzakx3 != null) {
            str = zzakx3.zzdnd;
        } else {
            str = AdMobAdapter.class.getName();
        }
        zzakr zzakr4 = this.zzdmn;
        zzakx zzakx4 = this.zzdsx;
        zzakt zzakt = zzakx4 != null ? zzakx4.zzdne : null;
        long j3 = this.zzdsl.zzdye;
        zzwf zzwf = this.zzdsk.zzbst;
        long j4 = this.zzdsl.zzdyc;
        long j5 = this.zzdsk.zzehn;
        long j6 = this.zzdsl.zzdyh;
        String str5 = this.zzdsl.zzdyi;
        JSONObject jSONObject = this.zzdsk.zzehh;
        zzawd zzawd = this.zzdsl.zzdyr;
        List<String> list4 = this.zzdsl.zzdys;
        List<String> list5 = this.zzdsl.zzdyt;
        zzakr zzakr5 = this.zzdmn;
        boolean z3 = zzakr5 != null ? zzakr5.zzdmc : false;
        zzaso zzaso2 = this.zzdsl.zzdyv;
        zzakp zzakp = this.zzdsw;
        if (zzakp != null) {
            List<zzakx> zzui = zzakp.zzui();
            if (zzui == null) {
                zzakr = zzakr4;
                zzaso = zzaso2;
                str3 = "".toString();
                str2 = str4;
                z = z2;
                j = j6;
            } else {
                Iterator<zzakx> it2 = zzui.iterator();
                String str6 = "";
                while (it2.hasNext()) {
                    zzakx next = it2.next();
                    if (next != null) {
                        it = it2;
                        if (next.zzdnb == null) {
                            zzakr2 = zzakr4;
                        } else if (!TextUtils.isEmpty(next.zzdnb.zzdkx)) {
                            String valueOf = String.valueOf(str6);
                            String str7 = next.zzdnb.zzdkx;
                            switch (next.zzdna) {
                                case -1:
                                    i2 = 4;
                                    zzakr3 = zzakr4;
                                    break;
                                case 0:
                                    zzakr3 = zzakr4;
                                    i2 = 0;
                                    break;
                                case 1:
                                    zzakr3 = zzakr4;
                                    i2 = 1;
                                    break;
                                case 2:
                                default:
                                    i2 = 6;
                                    zzakr3 = zzakr4;
                                    break;
                                case 3:
                                    i2 = 2;
                                    zzakr3 = zzakr4;
                                    break;
                                case 4:
                                    i2 = 3;
                                    zzakr3 = zzakr4;
                                    break;
                                case 5:
                                    i2 = 5;
                                    zzakr3 = zzakr4;
                                    break;
                            }
                            long j7 = next.zzdng;
                            StringBuilder sb = new StringBuilder(String.valueOf(str7).length() + 33);
                            sb.append(str7);
                            sb.append(".");
                            sb.append(i2);
                            sb.append(".");
                            sb.append(j7);
                            String sb2 = sb.toString();
                            StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(sb2).length());
                            sb3.append(valueOf);
                            sb3.append(sb2);
                            sb3.append("_");
                            str6 = sb3.toString();
                            it2 = it;
                            zzaso2 = zzaso2;
                            j6 = j6;
                            zzakr4 = zzakr3;
                            z2 = z2;
                            str4 = str4;
                        } else {
                            zzakr2 = zzakr4;
                        }
                    } else {
                        zzakr2 = zzakr4;
                        it = it2;
                    }
                    it2 = it;
                    zzaso2 = zzaso2;
                    j6 = j6;
                    zzakr4 = zzakr2;
                    z2 = z2;
                    str4 = str4;
                }
                zzakr = zzakr4;
                zzaso = zzaso2;
                str2 = str4;
                z = z2;
                j = j6;
                str3 = str6.substring(0, Math.max(0, str6.length() - 1));
            }
        } else {
            zzakr = zzakr4;
            zzaso = zzaso2;
            str2 = str4;
            z = z2;
            j = j6;
            str3 = null;
        }
        return new zzaxf(zzwb, zzbgg, list, i, list2, list3, i3, j2, str2, z, zzakq, zzalj, str, zzakr, zzakt, j3, zzwf, j4, j5, j, str5, jSONObject, null, zzawd, list4, list5, z3, zzaso, str3, this.zzdsl.zzdlu, this.zzdsl.zzdyy, this.zzdsk.zzehw, this.zzdsl.zzbph, this.zzdsk.zzehx, this.zzdsl.zzdzc, this.zzdsl.zzdls, this.zzdsl.zzbpi, this.zzdsl.zzdzd, this.zzdsl.zzdzf);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzaph
    public final void zzap(long j) throws zzapk {
        zzakp zzakp;
        Bundle bundle;
        synchronized (this.zzdsn) {
            if (this.zzdmn.zzdma != -1) {
                zzakp = new zzala(this.mContext, this.zzdsk.zzeag, this.zzbma, this.zzdmn, this.zzdsl.zzckn, this.zzdsl.zzckp, this.zzdsl.zzdyw, j, ((Long) zzwu.zzpz().zzd(zzaan.zzctf)).longValue(), 2, this.zzdsk.zzehx);
            } else {
                zzakp = new zzald(this.mContext, this.zzdsk.zzeag, this.zzbma, this.zzdmn, this.zzdsl.zzckn, this.zzdsl.zzckp, this.zzdsl.zzdyw, j, ((Long) zzwu.zzpz().zzd(zzaan.zzctf)).longValue(), this.zzbln, this.zzdsk.zzehx);
            }
            this.zzdsw = zzakp;
        }
        ArrayList arrayList = new ArrayList(this.zzdmn.zzdlp);
        Bundle bundle2 = this.zzdsk.zzeag.zzdwg.zzcjl;
        if ((bundle2 == null || (bundle = bundle2.getBundle("com.google.ads.mediation.admob.AdMobAdapter")) == null) ? false : bundle.getBoolean("_skipMediation")) {
            ListIterator listIterator = arrayList.listIterator();
            while (listIterator.hasNext()) {
                if (!((zzakq) listIterator.next()).zzdkw.contains("com.google.ads.mediation.admob.AdMobAdapter")) {
                    listIterator.remove();
                }
            }
        }
        this.zzdsx = this.zzdsw.zzh(arrayList);
        switch (this.zzdsx.zzdna) {
            case 0:
                if (this.zzdsx.zzdnb != null && this.zzdsx.zzdnb.zzdli != null) {
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    zzayh.zzelc.post(new zzaps(this, countDownLatch));
                    try {
                        countDownLatch.await(10, TimeUnit.SECONDS);
                        synchronized (this.zzdsn) {
                            if (!this.zzdsy) {
                                throw new zzapk("View could not be prepared", 0);
                            } else if (this.zzdin.isDestroyed()) {
                                throw new zzapk("Assets not loaded, web view is destroyed", 0);
                            }
                        }
                        return;
                    } catch (InterruptedException e) {
                        String valueOf = String.valueOf(e);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 38);
                        sb.append("Interrupted while waiting for latch : ");
                        sb.append(valueOf);
                        throw new zzapk(sb.toString(), 0);
                    }
                } else {
                    return;
                }
            case 1:
                throw new zzapk("No fill from any mediation ad networks.", 3);
            default:
                int i = this.zzdsx.zzdna;
                StringBuilder sb2 = new StringBuilder(40);
                sb2.append("Unexpected mediation result: ");
                sb2.append(i);
                throw new zzapk(sb2.toString(), 0);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxv, com.google.android.gms.internal.ads.zzaph
    public final void onStop() {
        synchronized (this.zzdsn) {
            super.onStop();
            if (this.zzdsw != null) {
                this.zzdsw.cancel();
            }
        }
    }
}
