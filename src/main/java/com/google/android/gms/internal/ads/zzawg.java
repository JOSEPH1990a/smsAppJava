package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.view.View;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
@ParametersAreNonnullByDefault
public final class zzawg implements zzawr {
    private static List<Future<Void>> zzefp = Collections.synchronizedList(new ArrayList());
    private static ScheduledExecutorService zzefq = Executors.newSingleThreadScheduledExecutor();
    private final Context mContext;
    private final Object mLock = new Object();
    private final zzawo zzecd;
    @GuardedBy("mLock")
    private final zzbvn zzefr;
    @GuardedBy("mLock")
    private final LinkedHashMap<String, zzbvt> zzefs;
    @GuardedBy("mLock")
    private final List<String> zzeft = new ArrayList();
    @GuardedBy("mLock")
    private final List<String> zzefu = new ArrayList();
    private final zzawt zzefv;
    @VisibleForTesting
    private boolean zzefw;
    private final zzawu zzefx;
    private HashSet<String> zzefy = new HashSet<>();
    private boolean zzefz = false;
    private boolean zzega = false;
    private boolean zzegb = false;

    public zzawg(Context context, zzbbi zzbbi, zzawo zzawo, String str, zzawt zzawt) {
        Preconditions.checkNotNull(zzawo, "SafeBrowsing config is not present.");
        this.mContext = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzefs = new LinkedHashMap<>();
        this.zzefv = zzawt;
        this.zzecd = zzawo;
        for (String str2 : this.zzecd.zzegl) {
            this.zzefy.add(str2.toLowerCase(Locale.ENGLISH));
        }
        this.zzefy.remove("cookie".toLowerCase(Locale.ENGLISH));
        zzbvn zzbvn = new zzbvn();
        zzbvn.zzgar = 8;
        zzbvn.url = str;
        zzbvn.zzgat = str;
        zzbvn.zzgav = new zzbvo();
        zzbvn.zzgav.zzegh = this.zzecd.zzegh;
        zzbvu zzbvu = new zzbvu();
        zzbvu.zzgcc = zzbbi.zzdp;
        zzbvu.zzgce = Boolean.valueOf(Wrappers.packageManager(this.mContext).isCallerInstantApp());
        long apkVersion = (long) GoogleApiAvailabilityLight.getInstance().getApkVersion(this.mContext);
        if (apkVersion > 0) {
            zzbvu.zzgcd = Long.valueOf(apkVersion);
        }
        zzbvn.zzgbf = zzbvu;
        this.zzefr = zzbvn;
        this.zzefx = new zzawu(this.mContext, this.zzecd.zzego, this);
    }

    static final /* synthetic */ Void zzdm(String str) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzawr
    public final zzawo zzxp() {
        return this.zzecd;
    }

    @Override // com.google.android.gms.internal.ads.zzawr
    public final void zzdi(String str) {
        synchronized (this.mLock) {
            this.zzefr.zzgax = str;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzawr
    public final boolean zzxq() {
        return PlatformVersion.isAtLeastKitKat() && this.zzecd.zzegj && !this.zzega;
    }

    @Override // com.google.android.gms.internal.ads.zzawr
    public final void zzs(View view) {
        if (this.zzecd.zzegj && !this.zzega) {
            zzbv.zzlf();
            Bitmap zzu = zzayh.zzu(view);
            if (zzu == null) {
                zzawq.zzdn("Failed to capture the webview bitmap.");
                return;
            }
            this.zzega = true;
            zzayh.zzd(new zzawj(this, zzu));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzawr
    public final void zza(String str, Map<String, String> map, int i) {
        synchronized (this.mLock) {
            if (i == 3) {
                this.zzegb = true;
            }
            if (this.zzefs.containsKey(str)) {
                if (i == 3) {
                    this.zzefs.get(str).zzgca = Integer.valueOf(i);
                }
                return;
            }
            zzbvt zzbvt = new zzbvt();
            zzbvt.zzgca = Integer.valueOf(i);
            zzbvt.zzgbu = Integer.valueOf(this.zzefs.size());
            zzbvt.url = str;
            zzbvt.zzgbv = new zzbvq();
            if (this.zzefy.size() > 0 && map != null) {
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    try {
                        String key = entry.getKey() != null ? entry.getKey() : "";
                        String value = entry.getValue() != null ? entry.getValue() : "";
                        if (this.zzefy.contains(key.toLowerCase(Locale.ENGLISH))) {
                            zzbvp zzbvp = new zzbvp();
                            zzbvp.zzgbj = key.getBytes("UTF-8");
                            zzbvp.zzgbk = value.getBytes("UTF-8");
                            arrayList.add(zzbvp);
                        }
                    } catch (UnsupportedEncodingException unused) {
                        zzawq.zzdn("Cannot convert string to bytes, skip header.");
                    }
                }
                zzbvp[] zzbvpArr = new zzbvp[arrayList.size()];
                arrayList.toArray(zzbvpArr);
                zzbvt.zzgbv.zzgbm = zzbvpArr;
            }
            this.zzefs.put(str, zzbvt);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzdj(String str) {
        synchronized (this.mLock) {
            this.zzeft.add(str);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzdk(String str) {
        synchronized (this.mLock) {
            this.zzefu.add(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzawr
    public final String[] zzb(String[] strArr) {
        return (String[]) this.zzefx.zzc(strArr).toArray(new String[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzawr
    public final void zzxr() {
        this.zzefz = true;
    }

    @Nullable
    private final zzbvt zzdl(String str) {
        zzbvt zzbvt;
        synchronized (this.mLock) {
            zzbvt = this.zzefs.get(str);
        }
        return zzbvt;
    }

    @Override // com.google.android.gms.internal.ads.zzawr
    public final void zzxs() {
        synchronized (this.mLock) {
            zzbcb zza = zzbbq.zza(this.zzefv.zza(this.mContext, this.zzefs.keySet()), new zzawh(this), zzbcg.zzepp);
            zzbcb zza2 = zzbbq.zza(zza, 10, TimeUnit.SECONDS, zzefq);
            zzbbq.zza(zza, new zzawk(this, zza2), zzbcg.zzepp);
            zzefp.add(zza2);
        }
    }

    @VisibleForTesting
    private final zzbcb<Void> zzxt() {
        zzbcb<Void> zza;
        if (!((this.zzefw && this.zzecd.zzegn) || (this.zzegb && this.zzecd.zzegm) || (!this.zzefw && this.zzecd.zzegk))) {
            return zzbbq.zzm(null);
        }
        synchronized (this.mLock) {
            this.zzefr.zzgaw = new zzbvt[this.zzefs.size()];
            this.zzefs.values().toArray(this.zzefr.zzgaw);
            this.zzefr.zzgbg = (String[]) this.zzeft.toArray(new String[0]);
            this.zzefr.zzgbh = (String[]) this.zzefu.toArray(new String[0]);
            if (zzawq.isEnabled()) {
                String str = this.zzefr.url;
                String str2 = this.zzefr.zzgax;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 53 + String.valueOf(str2).length());
                sb.append("Sending SB report\n  url: ");
                sb.append(str);
                sb.append("\n  clickUrl: ");
                sb.append(str2);
                sb.append("\n  resources: \n");
                StringBuilder sb2 = new StringBuilder(sb.toString());
                zzbvt[] zzbvtArr = this.zzefr.zzgaw;
                for (zzbvt zzbvt : zzbvtArr) {
                    sb2.append("    [");
                    sb2.append(zzbvt.zzgcb.length);
                    sb2.append("] ");
                    sb2.append(zzbvt.url);
                }
                zzawq.zzdn(sb2.toString());
            }
            zzbcb<String> zza2 = new zzazs(this.mContext).zza(1, this.zzecd.zzegi, null, zzbuz.zzb(this.zzefr));
            if (zzawq.isEnabled()) {
                zza2.zza(new zzawl(this), zzayf.zzeky);
            }
            zza = zzbbq.zza(zza2, zzawi.zzegd, zzbcg.zzepp);
        }
        return zza;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbcb zzm(Map map) throws Exception {
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    JSONArray optJSONArray = new JSONObject((String) map.get(str)).optJSONArray("matches");
                    if (optJSONArray != null) {
                        synchronized (this.mLock) {
                            int length = optJSONArray.length();
                            zzbvt zzdl = zzdl(str);
                            if (zzdl == null) {
                                String valueOf = String.valueOf(str);
                                zzawq.zzdn(valueOf.length() != 0 ? "Cannot find the corresponding resource object for ".concat(valueOf) : new String("Cannot find the corresponding resource object for "));
                            } else {
                                zzdl.zzgcb = new String[length];
                                boolean z = false;
                                for (int i = 0; i < length; i++) {
                                    zzdl.zzgcb[i] = optJSONArray.getJSONObject(i).getString("threat_type");
                                }
                                boolean z2 = this.zzefw;
                                if (length > 0) {
                                    z = true;
                                }
                                this.zzefw = z | z2;
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcvm)).booleanValue()) {
                    zzaxz.zza("Failed to get SafeBrowsing metadata", e);
                }
                return zzbbq.zzd(new Exception("Safebrowsing report transmission failed."));
            }
        }
        if (this.zzefw) {
            synchronized (this.mLock) {
                this.zzefr.zzgar = 9;
            }
        }
        return zzxt();
    }
}
