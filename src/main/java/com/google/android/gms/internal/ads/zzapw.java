package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzbb;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;
import fi.iki.elonen.NanoHTTPD;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
public final class zzapw implements Callable<zzaxf> {
    @VisibleForTesting
    private static long zzdtd = 10;
    private final Context mContext;
    private int mErrorCode;
    private final Object mLock = new Object();
    private final zzaba zzbln;
    private final zzaqp zzbqa;
    private final zzcu zzdcf;
    private final zzaxg zzdsk;
    private final zzazs zzdte;
    private final zzbb zzdtf;
    private boolean zzdtg;
    private List<String> zzdth;
    private JSONObject zzdti;
    private String zzdtj;
    @Nullable
    private String zzdtk;

    public zzapw(Context context, zzbb zzbb, zzazs zzazs, zzcu zzcu, zzaxg zzaxg, zzaba zzaba) {
        this.mContext = context;
        this.zzdtf = zzbb;
        this.zzdte = zzazs;
        this.zzdsk = zzaxg;
        this.zzdcf = zzcu;
        this.zzbln = zzaba;
        this.zzbqa = zzbb.zzkn();
        this.zzdtg = false;
        this.mErrorCode = -2;
        this.zzdth = null;
        this.zzdtj = null;
        this.zzdtk = null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003e, code lost:
        if (r3.length() != 0) goto L_0x0044;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0071 A[Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x021c, TimeoutException -> 0x0215, Exception -> 0x020e }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0078 A[Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x021c, TimeoutException -> 0x0215, Exception -> 0x020e }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007b A[Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x021c, TimeoutException -> 0x0215, Exception -> 0x020e }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0081 A[Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x021c, TimeoutException -> 0x0215, Exception -> 0x020e }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b7 A[Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x021c, TimeoutException -> 0x0215, Exception -> 0x020e }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x017c A[Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x021c, TimeoutException -> 0x0215, Exception -> 0x020e }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x017e A[Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x021c, TimeoutException -> 0x0215, Exception -> 0x020e }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01f1 A[Catch:{ InterruptedException | CancellationException | ExecutionException | JSONException -> 0x021c, TimeoutException -> 0x0215, Exception -> 0x020e }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0226  */
    /* renamed from: zzwd */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzaxf call() {
        /*
        // Method dump skipped, instructions count: 558
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzapw.call():com.google.android.gms.internal.ads.zzaxf");
    }

    private static zzbgg zzb(zzbcb<zzbgg> zzbcb) {
        try {
            return (zzbgg) zzbcb.get((long) ((Integer) zzwu.zzpz().zzd(zzaan.zzcui)).intValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            zzbbd.zzc("", e);
            Thread.currentThread().interrupt();
            return null;
        } catch (CancellationException | ExecutionException | TimeoutException e2) {
            zzbbd.zzc("", e2);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public final void zzc(zzadx zzadx, String str) {
        try {
            zzaeh zzar = this.zzdtf.zzar(zzadx.getCustomTemplateId());
            if (zzar != null) {
                zzar.zzb(zzadx, str);
            }
        } catch (RemoteException e) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40);
            sb.append("Failed to call onCustomClick for asset ");
            sb.append(str);
            sb.append(".");
            zzaxz.zzc(sb.toString(), e);
        }
    }

    private final zzaxf zza(zzacf zzacf, boolean z) {
        int i;
        synchronized (this.mLock) {
            i = (zzacf == null && this.mErrorCode == -2) ? 0 : this.mErrorCode;
        }
        return new zzaxf(this.zzdsk.zzeag.zzdwg, null, this.zzdsk.zzehy.zzdlq, i, this.zzdsk.zzehy.zzdlr, this.zzdth, this.zzdsk.zzehy.orientation, this.zzdsk.zzehy.zzdlx, this.zzdsk.zzeag.zzdwj, false, null, null, null, null, null, 0, this.zzdsk.zzbst, this.zzdsk.zzehy.zzdyc, this.zzdsk.zzehn, this.zzdsk.zzeho, this.zzdsk.zzehy.zzdyi, this.zzdti, i != -2 ? null : zzacf, null, null, null, this.zzdsk.zzehy.zzdyu, this.zzdsk.zzehy.zzdyv, null, this.zzdsk.zzehy.zzdlu, this.zzdtj, this.zzdsk.zzehw, this.zzdsk.zzehy.zzbph, this.zzdsk.zzehx, z, this.zzdsk.zzehy.zzdls, this.zzdsk.zzehy.zzbpi, this.zzdtk, this.zzdsk.zzehy.zzdzf);
    }

    public final zzbcb<zzabm> zzg(JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject = jSONObject.optJSONObject("attribution");
        if (optJSONObject == null) {
            return zzbbq.zzm(null);
        }
        String optString = optJSONObject.optString("text");
        int optInt = optJSONObject.optInt("text_size", -1);
        Integer zzb = zzb(optJSONObject, "text_color");
        Integer zzb2 = zzb(optJSONObject, "bg_color");
        int optInt2 = optJSONObject.optInt("animation_ms", 1000);
        int optInt3 = optJSONObject.optInt("presentation_ms", 4000);
        int i = (this.zzdsk.zzeag.zzbti == null || this.zzdsk.zzeag.zzbti.versionCode < 2) ? 1 : this.zzdsk.zzeag.zzbti.zzdcv;
        boolean optBoolean = optJSONObject.optBoolean("allow_pub_rendering");
        List<zzbcb<zzabr>> arrayList = new ArrayList<>();
        if (optJSONObject.optJSONArray("images") != null) {
            arrayList = zza(optJSONObject, "images", false, false, true);
        } else {
            arrayList.add(zza(optJSONObject, "image", false, false));
        }
        zzbcl zzbcl = new zzbcl();
        int size = arrayList.size();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (zzbcb<zzabr> zzbcb : arrayList) {
            zzbcb.zza(new zzaqd(atomicInteger, size, zzbcl, arrayList), zzayf.zzeky);
            arrayList = arrayList;
        }
        return zzbbq.zza(zzbcl, new zzaqb(this, optString, zzb2, zzb, optInt, optInt3, optInt2, i, optBoolean), zzayf.zzeky);
    }

    private static Integer zzb(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException unused) {
            return null;
        }
    }

    public final Future<zzabr> zza(JSONObject jSONObject, String str, boolean z) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        boolean optBoolean = jSONObject2.optBoolean("require", true);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return zza(jSONObject2, optBoolean, z);
    }

    public final zzbcb<zzabr> zza(JSONObject jSONObject, String str, boolean z, boolean z2) throws JSONException {
        JSONObject jSONObject2 = z ? jSONObject.getJSONObject(str) : jSONObject.optJSONObject(str);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return zza(jSONObject2, z, z2);
    }

    public final List<zzbcb<zzabr>> zza(JSONObject jSONObject, String str, boolean z, boolean z2, boolean z3) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        ArrayList arrayList = new ArrayList();
        if (optJSONArray == null || optJSONArray.length() == 0) {
            zzh(0, false);
            return arrayList;
        }
        int length = z3 ? optJSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            arrayList.add(zza(jSONObject2, false, z2));
        }
        return arrayList;
    }

    private final zzbcb<zzabr> zza(JSONObject jSONObject, boolean z, boolean z2) throws JSONException {
        String str;
        if (z) {
            str = jSONObject.getString(ImagesContract.URL);
        } else {
            str = jSONObject.optString(ImagesContract.URL);
        }
        double optDouble = jSONObject.optDouble("scale", 1.0d);
        boolean optBoolean = jSONObject.optBoolean("is_transparent", true);
        if (TextUtils.isEmpty(str)) {
            zzh(0, z);
            return zzbbq.zzm(null);
        } else if (z2) {
            return zzbbq.zzm(new zzabr(null, Uri.parse(str), optDouble));
        } else {
            return this.zzdte.zza(str, new zzaqc(this, z, optDouble, optBoolean, str));
        }
    }

    public final zzbcb<zzbgg> zzc(JSONObject jSONObject, String str) throws JSONException {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return zzbbq.zzm(null);
        }
        if (TextUtils.isEmpty(optJSONObject.optString("vast_xml"))) {
            zzaxz.zzeo("Required field 'vast_xml' is missing");
            return zzbbq.zzm(null);
        }
        zzaqf zza = zza(this.mContext, this.zzdcf, this.zzdsk, this.zzbln, this.zzdtf);
        boolean equals = "instream".equals(jSONObject.optString(AppMeasurement.Param.TYPE));
        zzbcl zzbcl = new zzbcl();
        zzbcg.zzepo.execute(new zzaqg(zza, equals, optJSONObject, zzbcl));
        return zzbcl;
    }

    public final zzbcb<zzbgg> zza(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return zzbbq.zzm(null);
        }
        zzaqf zza = zza(this.mContext, this.zzdcf, this.zzdsk, this.zzbln, this.zzdtf);
        zzbcl zzbcl = new zzbcl();
        zzbcg.zzepo.execute(new zzaqh(zza, true, zzbcl, str, str2));
        return zzbcl;
    }

    private final boolean zzwe() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzdtg;
        }
        return z;
    }

    private final void zzcs(int i) {
        synchronized (this.mLock) {
            this.zzdtg = true;
            this.mErrorCode = i;
        }
    }

    public final void zzh(int i, boolean z) {
        if (z) {
            zzcs(i);
        }
    }

    static zzbgg zzc(zzbcb<zzbgg> zzbcb) {
        try {
            return (zzbgg) zzbcb.get((long) ((Integer) zzwu.zzpz().zzd(zzaan.zzcuh)).intValue(), TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            zzaxz.zzc("InterruptedException occurred while waiting for video to load", e);
            Thread.currentThread().interrupt();
            return null;
        } catch (CancellationException | ExecutionException | TimeoutException e2) {
            zzaxz.zzc("Exception occurred while waiting for video to load", e2);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static <V> List<V> zzk(List<zzbcb<V>> list) throws ExecutionException, InterruptedException {
        ArrayList arrayList = new ArrayList();
        for (zzbcb<V> zzbcb : list) {
            Object obj = zzbcb.get();
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @VisibleForTesting
    private static zzaqf zza(Context context, zzcu zzcu, zzaxg zzaxg, zzaba zzaba, zzbb zzbb) {
        return new zzaqf(context, zzcu, zzaxg, zzaba, zzbb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbcb zza(String str, Object obj) throws Exception {
        zzbv.zzlg();
        zzbgg zza = zzbgm.zza(this.mContext, zzbht.zzaey(), "native-omid", false, false, this.zzdcf, this.zzdsk.zzeag.zzbsp, this.zzbln, null, this.zzdtf.zzid(), this.zzdsk.zzehw);
        zzbck zzn = zzbck.zzn(zza);
        zza.zzadl().zza(new zzapy(zzn));
        zza.loadData(str, NanoHTTPD.MIME_HTML, "UTF-8");
        return zzn;
    }
}
