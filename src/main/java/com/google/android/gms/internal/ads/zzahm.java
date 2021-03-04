package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.Nullable;
import android.util.Base64;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
public final class zzahm {
    private final Map<zzahn, zzaho> zzdhe = new HashMap();
    private final LinkedList<zzahn> zzdhf = new LinkedList<>();
    @Nullable
    private zzagi zzdhg;

    /* access modifiers changed from: package-private */
    public final void zza(zzagi zzagi) {
        if (this.zzdhg == null) {
            this.zzdhg = zzagi.zztg();
            zzagi zzagi2 = this.zzdhg;
            if (zzagi2 != null) {
                SharedPreferences sharedPreferences = zzagi2.getApplicationContext().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0);
                while (this.zzdhf.size() > 0) {
                    zzahn remove = this.zzdhf.remove();
                    zzaho zzaho = this.zzdhe.get(remove);
                    zza("Flushing interstitial queue for %s.", remove);
                    while (zzaho.size() > 0) {
                        zzaho.zzl(null).zzdhl.zzke();
                    }
                    this.zzdhe.remove(remove);
                }
                try {
                    HashMap hashMap = new HashMap();
                    for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
                        if (!entry.getKey().equals("PoolKeys")) {
                            zzahs zzcc = zzahs.zzcc((String) entry.getValue());
                            zzahn zzahn = new zzahn(zzcc.zzbqo, zzcc.zzboa, zzcc.zzdhj);
                            if (!this.zzdhe.containsKey(zzahn)) {
                                this.zzdhe.put(zzahn, new zzaho(zzcc.zzbqo, zzcc.zzboa, zzcc.zzdhj));
                                hashMap.put(zzahn.toString(), zzahn);
                                zza("Restored interstitial queue for %s.", zzahn);
                            }
                        }
                    }
                    for (String str : zzbz(sharedPreferences.getString("PoolKeys", ""))) {
                        zzahn zzahn2 = (zzahn) hashMap.get(str);
                        if (this.zzdhe.containsKey(zzahn2)) {
                            this.zzdhf.add(zzahn2);
                        }
                    }
                } catch (IOException | RuntimeException e) {
                    zzbv.zzlj().zza(e, "InterstitialAdPool.restore");
                    zzaxz.zzc("Malformed preferences value for InterstitialAdPool.", e);
                    this.zzdhe.clear();
                    this.zzdhf.clear();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final zzahp zza(zzwb zzwb, String str) {
        if (zzca(str)) {
            return null;
        }
        int i = new zzaua(this.zzdhg.getApplicationContext()).zzwx().zzedd;
        zzwb zzj = zzj(zzwb);
        String zzcb = zzcb(str);
        zzahn zzahn = new zzahn(zzj, zzcb, i);
        zzaho zzaho = this.zzdhe.get(zzahn);
        if (zzaho == null) {
            zza("Interstitial pool created at %s.", zzahn);
            zzaho = new zzaho(zzj, zzcb, i);
            this.zzdhe.put(zzahn, zzaho);
        }
        this.zzdhf.remove(zzahn);
        this.zzdhf.add(zzahn);
        zzaho.zztm();
        while (true) {
            if (this.zzdhf.size() <= ((Integer) zzwu.zzpz().zzd(zzaan.zzcsd)).intValue()) {
                break;
            }
            zzahn remove = this.zzdhf.remove();
            zzaho zzaho2 = this.zzdhe.get(remove);
            zza("Evicting interstitial queue for %s.", remove);
            while (zzaho2.size() > 0) {
                zzahp zzl = zzaho2.zzl(null);
                if (zzl.zzblw) {
                    zzahq.zzto().zztq();
                }
                zzl.zzdhl.zzke();
            }
            this.zzdhe.remove(remove);
        }
        while (zzaho.size() > 0) {
            zzahp zzl2 = zzaho.zzl(zzj);
            if (zzl2.zzblw) {
                if (zzbv.zzlm().currentTimeMillis() - zzl2.zzdho > ((long) ((Integer) zzwu.zzpz().zzd(zzaan.zzcsf)).intValue()) * 1000) {
                    zza("Expired interstitial at %s.", zzahn);
                    zzahq.zzto().zztp();
                }
            }
            String str2 = zzl2.zzdhm != null ? " (inline) " : " ";
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 34);
            sb.append("Pooled interstitial");
            sb.append(str2);
            sb.append("returned at %s.");
            zza(sb.toString(), zzahn);
            return zzl2;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzwb zzwb, String str) {
        zzagi zzagi = this.zzdhg;
        if (zzagi != null) {
            int i = new zzaua(zzagi.getApplicationContext()).zzwx().zzedd;
            zzwb zzj = zzj(zzwb);
            String zzcb = zzcb(str);
            zzahn zzahn = new zzahn(zzj, zzcb, i);
            zzaho zzaho = this.zzdhe.get(zzahn);
            if (zzaho == null) {
                zza("Interstitial pool created at %s.", zzahn);
                zzaho = new zzaho(zzj, zzcb, i);
                this.zzdhe.put(zzahn, zzaho);
            }
            zzaho.zza(this.zzdhg, zzwb);
            zzaho.zztm();
            zza("Inline entry added to the queue at %s.", zzahn);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzth() {
        int size;
        int zztk;
        if (this.zzdhg != null) {
            for (Map.Entry<zzahn, zzaho> entry : this.zzdhe.entrySet()) {
                zzahn key = entry.getKey();
                zzaho value = entry.getValue();
                if (zzaxz.isLoggable(2) && (zztk = value.zztk()) < (size = value.size())) {
                    zzaxz.v(String.format("Loading %s/%s pooled interstitials for %s.", Integer.valueOf(size - zztk), Integer.valueOf(size), key));
                }
                int zztl = value.zztl() + 0;
                while (true) {
                    if (value.size() >= ((Integer) zzwu.zzpz().zzd(zzaan.zzcse)).intValue()) {
                        break;
                    }
                    zza("Pooling and loading one new interstitial for %s.", key);
                    if (value.zzb(this.zzdhg)) {
                        zztl++;
                    }
                }
                zzahq.zzto().zzcn(zztl);
            }
            zzagi zzagi = this.zzdhg;
            if (zzagi != null) {
                SharedPreferences.Editor edit = zzagi.getApplicationContext().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0).edit();
                edit.clear();
                for (Map.Entry<zzahn, zzaho> entry2 : this.zzdhe.entrySet()) {
                    zzahn key2 = entry2.getKey();
                    zzaho value2 = entry2.getValue();
                    if (value2.zztn()) {
                        edit.putString(key2.toString(), new zzahs(value2).zzty());
                        zza("Saved interstitial queue for %s.", key2);
                    }
                }
                edit.putString("PoolKeys", zzti());
                edit.apply();
            }
        }
    }

    private final String zzti() {
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<zzahn> it = this.zzdhf.iterator();
            while (it.hasNext()) {
                sb.append(Base64.encodeToString(it.next().toString().getBytes("UTF-8"), 0));
                if (it.hasNext()) {
                    sb.append("\u0000");
                }
            }
            return sb.toString();
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    private static String[] zzbz(String str) {
        try {
            String[] split = str.split("\u0000");
            for (int i = 0; i < split.length; i++) {
                split[i] = new String(Base64.decode(split[i], 0), "UTF-8");
            }
            return split;
        } catch (UnsupportedEncodingException unused) {
            return new String[0];
        }
    }

    private static boolean zzca(String str) {
        try {
            return Pattern.matches((String) zzwu.zzpz().zzd(zzaan.zzcsg), str);
        } catch (RuntimeException e) {
            zzbv.zzlj().zza(e, "InterstitialAdPool.isExcludedAdUnit");
            return false;
        }
    }

    static Set<String> zzh(zzwb zzwb) {
        HashSet hashSet = new HashSet();
        hashSet.addAll(zzwb.extras.keySet());
        Bundle bundle = zzwb.zzcjl.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        if (bundle != null) {
            hashSet.addAll(bundle.keySet());
        }
        return hashSet;
    }

    static zzwb zzi(zzwb zzwb) {
        zzwb zzk = zzk(zzwb);
        Bundle bundle = zzk.zzcjl.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        if (bundle != null) {
            bundle.putBoolean("_skipMediation", true);
        }
        zzk.extras.putBoolean("_skipMediation", true);
        return zzk;
    }

    @VisibleForTesting
    private static zzwb zzj(zzwb zzwb) {
        zzwb zzk = zzk(zzwb);
        String[] split = ((String) zzwu.zzpz().zzd(zzaan.zzcsc)).split(",");
        for (String str : split) {
            zzb(zzk.zzcjl, str);
            if (str.startsWith("com.google.ads.mediation.admob.AdMobAdapter/")) {
                zzb(zzk.extras, str.replaceFirst("com.google.ads.mediation.admob.AdMobAdapter/", ""));
            }
        }
        return zzk;
    }

    @VisibleForTesting
    private static String zzcb(String str) {
        try {
            Matcher matcher = Pattern.compile("([^/]+/[0-9]+).*").matcher(str);
            if (matcher.matches()) {
                return matcher.group(1);
            }
        } catch (RuntimeException unused) {
        }
        return str;
    }

    @VisibleForTesting
    private static zzwb zzk(zzwb zzwb) {
        Parcel obtain = Parcel.obtain();
        zzwb.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        obtain.recycle();
        return zzwb.CREATOR.createFromParcel(obtain).zzpm();
    }

    private static void zzb(Bundle bundle, String str) {
        while (true) {
            String[] split = str.split("/", 2);
            if (split.length != 0) {
                String str2 = split[0];
                if (split.length == 1) {
                    bundle.remove(str2);
                    return;
                }
                bundle = bundle.getBundle(str2);
                if (bundle != null) {
                    str = split[1];
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private static void zza(String str, zzahn zzahn) {
        if (zzaxz.isLoggable(2)) {
            zzaxz.v(String.format(str, zzahn));
        }
    }
}
