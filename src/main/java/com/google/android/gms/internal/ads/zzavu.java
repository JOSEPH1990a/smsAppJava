package com.google.android.gms.internal.ads;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
public final class zzavu extends zzaxv implements zzavt {
    private final Context mContext;
    private final Object mLock;
    private final zzaxg zzdsk;
    private final long zzeet;
    private final ArrayList<zzavk> zzefh;
    private final List<zzavn> zzefi;
    private final HashSet<String> zzefj;
    private final zzauk zzefk;

    public zzavu(Context context, zzaxg zzaxg, zzauk zzauk) {
        this(context, zzaxg, zzauk, ((Long) zzwu.zzpz().zzd(zzaan.zzcrj)).longValue());
    }

    @Override // com.google.android.gms.internal.ads.zzaxv
    public final void onStop() {
    }

    @Override // com.google.android.gms.internal.ads.zzavt
    public final void zza(String str, int i) {
    }

    @VisibleForTesting
    private zzavu(Context context, zzaxg zzaxg, zzauk zzauk, long j) {
        this.zzefh = new ArrayList<>();
        this.zzefi = new ArrayList();
        this.zzefj = new HashSet<>();
        this.mLock = new Object();
        this.mContext = context;
        this.zzdsk = zzaxg;
        this.zzefk = zzauk;
        this.zzeet = j;
    }

    @Override // com.google.android.gms.internal.ads.zzaxv
    public final void zzki() {
        Object obj;
        String str;
        for (zzakq zzakq : this.zzdsk.zzehj.zzdlp) {
            String str2 = zzakq.zzdle;
            for (String str3 : zzakq.zzdkw) {
                if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str3) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str3)) {
                    try {
                        str = new JSONObject(str2).getString("class_name");
                    } catch (JSONException e) {
                        zzaxz.zzb("Unable to determine custom event class name, skipping...", e);
                    }
                } else {
                    str = str3;
                }
                Object obj2 = this.mLock;
                synchronized (obj2) {
                    try {
                        zzavy zzdd = this.zzefk.zzdd(str);
                        if (zzdd == null) {
                            obj = obj2;
                        } else if (zzdd.zzxo() == null) {
                            obj = obj2;
                        } else if (zzdd.zzxn() == null) {
                            obj = obj2;
                        } else {
                            obj = obj2;
                            zzavk zzavk = new zzavk(this.mContext, str, str2, zzakq, this.zzdsk, zzdd, this, this.zzeet);
                            zzavk.zza(this.zzefk.zzxb());
                            this.zzefh.add(zzavk);
                        }
                        this.zzefi.add(new zzavp().zzdg(zzakq.zzdkx).zzdf(str).zzar(0).zzcu(7).zzxm());
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                }
            }
        }
        HashSet hashSet = new HashSet();
        ArrayList<zzavk> arrayList = this.zzefh;
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            zzavk zzavk2 = arrayList.get(i2);
            i2++;
            zzavk zzavk3 = zzavk2;
            if (hashSet.add(zzavk3.zzdml)) {
                zzavk3.zzxi();
            }
        }
        ArrayList<zzavk> arrayList2 = this.zzefh;
        int size2 = arrayList2.size();
        while (i < size2) {
            zzavk zzavk4 = arrayList2.get(i);
            i++;
            zzavk zzavk5 = zzavk4;
            try {
                zzavk5.zzxi().get();
                synchronized (this.mLock) {
                    if (!TextUtils.isEmpty(zzavk5.zzdml)) {
                        this.zzefi.add(zzavk5.zzxj());
                    }
                }
                synchronized (this.mLock) {
                    if (this.zzefj.contains(zzavk5.zzdml)) {
                        zzbat.zztu.post(new zzavv(this, zza(-2, zzavk5.zzdml, zzavk5.zzxk())));
                        return;
                    }
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                synchronized (this.mLock) {
                    if (!TextUtils.isEmpty(zzavk5.zzdml)) {
                        this.zzefi.add(zzavk5.zzxj());
                    }
                }
            } catch (Exception e2) {
                try {
                    zzaxz.zzc("Unable to resolve rewarded adapter.", e2);
                    synchronized (this.mLock) {
                        if (!TextUtils.isEmpty(zzavk5.zzdml)) {
                            this.zzefi.add(zzavk5.zzxj());
                        }
                    }
                } catch (Throwable th2) {
                    synchronized (this.mLock) {
                        if (!TextUtils.isEmpty(zzavk5.zzdml)) {
                            this.zzefi.add(zzavk5.zzxj());
                        }
                        throw th2;
                    }
                }
            }
        }
        zzbat.zztu.post(new zzavw(this, zza(3, null, null)));
    }

    @Override // com.google.android.gms.internal.ads.zzavt
    public final void zzde(String str) {
        synchronized (this.mLock) {
            this.zzefj.add(str);
        }
    }

    private final zzaxf zza(int i, @Nullable String str, @Nullable zzakq zzakq) {
        String str2;
        boolean z;
        long j;
        String str3;
        zzwf zzwf;
        long j2;
        int i2;
        zzwb zzwb = this.zzdsk.zzeag.zzdwg;
        List<String> list = this.zzdsk.zzehy.zzdlq;
        List<String> list2 = this.zzdsk.zzehy.zzdlr;
        List<String> list3 = this.zzdsk.zzehy.zzdyf;
        int i3 = this.zzdsk.zzehy.orientation;
        long j3 = this.zzdsk.zzehy.zzdlx;
        String str4 = this.zzdsk.zzeag.zzdwj;
        boolean z2 = this.zzdsk.zzehy.zzdyd;
        zzakr zzakr = this.zzdsk.zzehj;
        long j4 = this.zzdsk.zzehy.zzdye;
        zzwf zzwf2 = this.zzdsk.zzbst;
        long j5 = this.zzdsk.zzehy.zzdyc;
        long j6 = this.zzdsk.zzehn;
        long j7 = this.zzdsk.zzehy.zzdyh;
        String str5 = this.zzdsk.zzehy.zzdyi;
        JSONObject jSONObject = this.zzdsk.zzehh;
        zzawd zzawd = this.zzdsk.zzehy.zzdyr;
        List<String> list4 = this.zzdsk.zzehy.zzdys;
        List<String> list5 = this.zzdsk.zzehy.zzdyt;
        boolean z3 = this.zzdsk.zzehy.zzdyu;
        zzaso zzaso = this.zzdsk.zzehy.zzdyv;
        StringBuilder sb = new StringBuilder("");
        List<zzavn> list6 = this.zzefi;
        if (list6 == null) {
            str2 = sb.toString();
            zzwf = zzwf2;
            z = z2;
            str3 = str5;
            j = j7;
        } else {
            Iterator<zzavn> it = list6.iterator();
            while (true) {
                zzwf = zzwf2;
                if (it.hasNext()) {
                    zzavn next = it.next();
                    if (next != null) {
                        if (!TextUtils.isEmpty(next.zzdkx)) {
                            String str6 = next.zzdkx;
                            switch (next.errorCode) {
                                case 3:
                                    j2 = j7;
                                    i2 = 1;
                                    break;
                                case 4:
                                    j2 = j7;
                                    i2 = 2;
                                    break;
                                case 5:
                                    j2 = j7;
                                    i2 = 4;
                                    break;
                                case 6:
                                    j2 = j7;
                                    i2 = 0;
                                    break;
                                case 7:
                                    j2 = j7;
                                    i2 = 3;
                                    break;
                                default:
                                    j2 = j7;
                                    i2 = 6;
                                    break;
                            }
                            long j8 = next.zzdng;
                            StringBuilder sb2 = new StringBuilder(String.valueOf(str6).length() + 33);
                            sb2.append(str6);
                            sb2.append(".");
                            sb2.append(i2);
                            sb2.append(".");
                            sb2.append(j8);
                            sb.append(String.valueOf(sb2.toString()).concat("_"));
                            it = it;
                            zzwf2 = zzwf;
                            str5 = str5;
                            j7 = j2;
                            z2 = z2;
                        } else {
                            it = it;
                        }
                    }
                    zzwf2 = zzwf;
                } else {
                    z = z2;
                    str3 = str5;
                    j = j7;
                    str2 = sb.substring(0, Math.max(0, sb.length() - 1));
                }
            }
        }
        return new zzaxf(zzwb, null, list, i, list2, list3, i3, j3, str4, z, zzakq, null, str, zzakr, null, j4, zzwf, j5, j6, j, str3, jSONObject, null, zzawd, list4, list5, z3, zzaso, str2, this.zzdsk.zzehy.zzdlu, this.zzdsk.zzehy.zzdyy, this.zzdsk.zzehw, this.zzdsk.zzehy.zzbph, this.zzdsk.zzehx, this.zzdsk.zzehy.zzdzc, this.zzdsk.zzehy.zzdls, this.zzdsk.zzehy.zzbpi, this.zzdsk.zzehy.zzdzd, this.zzdsk.zzehy.zzdzf);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzl(zzaxf zzaxf) {
        this.zzefk.zzxc().zzb(zzaxf);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzm(zzaxf zzaxf) {
        this.zzefk.zzxc().zzb(zzaxf);
    }
}
