package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.security.NetworkSecurityPolicy;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
public final class zzayc implements zzayb {
    private final Object mLock = new Object();
    @GuardedBy("mLock")
    private boolean zzebp = true;
    @GuardedBy("mLock")
    private boolean zzebq = true;
    @GuardedBy("mLock")
    private boolean zzebr = true;
    @GuardedBy("mLock")
    private boolean zzeby = false;
    @GuardedBy("mLock")
    private String zzeis = "";
    @GuardedBy("mLock")
    private int zzejp = -1;
    private boolean zzekh;
    private final List<Runnable> zzeki = new ArrayList();
    private zzbcb<?> zzekj;
    @GuardedBy("mLock")
    @Nullable
    private zzsx zzekk = null;
    @GuardedBy("mLock")
    @Nullable
    private SharedPreferences zzekl;
    @GuardedBy("mLock")
    @Nullable
    private SharedPreferences.Editor zzekm;
    @GuardedBy("mLock")
    private boolean zzekn = false;
    @GuardedBy("mLock")
    @Nullable
    private String zzeko;
    @GuardedBy("mLock")
    @Nullable
    private String zzekp;
    @GuardedBy("mLock")
    private long zzekq = 0;
    @GuardedBy("mLock")
    private long zzekr = 0;
    @GuardedBy("mLock")
    private long zzeks = 0;
    @GuardedBy("mLock")
    private int zzekt = 0;
    @GuardedBy("mLock")
    private Set<String> zzeku = Collections.emptySet();
    @GuardedBy("mLock")
    private JSONObject zzekv = new JSONObject();

    public final void zza(Context context, String str, boolean z) {
        this.zzekj = zzayf.zzc(new zzayd(this, context, "admob"));
        this.zzekh = true;
    }

    private final void zzzp() {
        zzbcb<?> zzbcb = this.zzekj;
        if (zzbcb != null && !zzbcb.isDone()) {
            try {
                this.zzekj.get(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                zzaxz.zzc("Interrupted while waiting for preferences loaded.", e);
            } catch (CancellationException | ExecutionException | TimeoutException e2) {
                zzaxz.zzb("Fail to initialize AdSharedPreferenceManager.", e2);
            }
        }
    }

    private final Bundle zzzq() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("listener_registration_bundle", true);
        synchronized (this.mLock) {
            bundle.putBoolean("use_https", this.zzebp);
            bundle.putBoolean("content_url_opted_out", this.zzebq);
            bundle.putBoolean("content_vertical_opted_out", this.zzebr);
            bundle.putBoolean("auto_collect_location", this.zzeby);
            bundle.putInt("version_code", this.zzekt);
            bundle.putStringArray("never_pool_slots", (String[]) this.zzeku.toArray(new String[this.zzeku.size()]));
            bundle.putString("app_settings_json", this.zzeis);
            bundle.putLong("app_settings_last_update_ms", this.zzekq);
            bundle.putLong("app_last_background_time_ms", this.zzekr);
            bundle.putInt("request_in_session_count", this.zzejp);
            bundle.putLong("first_ad_req_time_ms", this.zzeks);
            bundle.putString("native_advanced_settings", this.zzekv.toString());
            if (this.zzeko != null) {
                bundle.putString("content_url_hashes", this.zzeko);
            }
            if (this.zzekp != null) {
                bundle.putString("content_vertical_hashes", this.zzekp);
            }
        }
        return bundle;
    }

    private final void zzd(Bundle bundle) {
        zzayf.zzeky.execute(new zzaye(this));
    }

    @Override // com.google.android.gms.internal.ads.zzayb
    public final void zzam(boolean z) {
        zzzp();
        synchronized (this.mLock) {
            if (this.zzebp != z) {
                this.zzebp = z;
                if (this.zzekm != null) {
                    this.zzekm.putBoolean("use_https", z);
                    this.zzekm.apply();
                }
                if (!this.zzekn) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("use_https", z);
                    zzd(bundle);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayb
    public final boolean zzzb() {
        boolean z;
        zzzp();
        synchronized (this.mLock) {
            if (!this.zzebp) {
                if (!this.zzekn) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzayb
    public final void zzan(boolean z) {
        zzzp();
        synchronized (this.mLock) {
            if (this.zzebq != z) {
                this.zzebq = z;
                if (this.zzekm != null) {
                    this.zzekm.putBoolean("content_url_opted_out", z);
                    this.zzekm.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("content_url_opted_out", this.zzebq);
                bundle.putBoolean("content_vertical_opted_out", this.zzebr);
                zzd(bundle);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayb
    public final boolean zzzc() {
        boolean z;
        zzzp();
        synchronized (this.mLock) {
            z = this.zzebq;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzayb
    public final void zzdq(@Nullable String str) {
        zzzp();
        synchronized (this.mLock) {
            if (str != null) {
                if (!str.equals(this.zzeko)) {
                    this.zzeko = str;
                    if (this.zzekm != null) {
                        this.zzekm.putString("content_url_hashes", str);
                        this.zzekm.apply();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("content_url_hashes", str);
                    zzd(bundle);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayb
    @Nullable
    public final String zzzd() {
        String str;
        zzzp();
        synchronized (this.mLock) {
            str = this.zzeko;
        }
        return str;
    }

    @Override // com.google.android.gms.internal.ads.zzayb
    public final void zzao(boolean z) {
        zzzp();
        synchronized (this.mLock) {
            if (this.zzebr != z) {
                this.zzebr = z;
                if (this.zzekm != null) {
                    this.zzekm.putBoolean("content_vertical_opted_out", z);
                    this.zzekm.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("content_url_opted_out", this.zzebq);
                bundle.putBoolean("content_vertical_opted_out", this.zzebr);
                zzd(bundle);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayb
    public final boolean zzze() {
        boolean z;
        zzzp();
        synchronized (this.mLock) {
            z = this.zzebr;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzayb
    public final void zzdr(@Nullable String str) {
        zzzp();
        synchronized (this.mLock) {
            if (str != null) {
                if (!str.equals(this.zzekp)) {
                    this.zzekp = str;
                    if (this.zzekm != null) {
                        this.zzekm.putString("content_vertical_hashes", str);
                        this.zzekm.apply();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("content_vertical_hashes", str);
                    zzd(bundle);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayb
    @Nullable
    public final String zzzf() {
        String str;
        zzzp();
        synchronized (this.mLock) {
            str = this.zzekp;
        }
        return str;
    }

    @Override // com.google.android.gms.internal.ads.zzayb
    public final void zzap(boolean z) {
        zzzp();
        synchronized (this.mLock) {
            if (this.zzeby != z) {
                this.zzeby = z;
                if (this.zzekm != null) {
                    this.zzekm.putBoolean("auto_collect_location", z);
                    this.zzekm.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("auto_collect_location", z);
                zzd(bundle);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayb
    public final boolean zzzg() {
        boolean z;
        zzzp();
        synchronized (this.mLock) {
            z = this.zzeby;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzayb
    public final void zzcv(int i) {
        zzzp();
        synchronized (this.mLock) {
            if (this.zzekt != i) {
                this.zzekt = i;
                if (this.zzekm != null) {
                    this.zzekm.putInt("version_code", i);
                    this.zzekm.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putInt("version_code", i);
                zzd(bundle);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayb
    public final int zzzh() {
        int i;
        zzzp();
        synchronized (this.mLock) {
            i = this.zzekt;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzayb
    public final void zzds(String str) {
        zzzp();
        synchronized (this.mLock) {
            if (!this.zzeku.contains(str)) {
                this.zzeku.add(str);
                if (this.zzekm != null) {
                    this.zzekm.putStringSet("never_pool_slots", this.zzeku);
                    this.zzekm.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putStringArray("never_pool_slots", (String[]) this.zzeku.toArray(new String[this.zzeku.size()]));
                zzd(bundle);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayb
    public final void zzdt(String str) {
        zzzp();
        synchronized (this.mLock) {
            if (this.zzeku.contains(str)) {
                this.zzeku.remove(str);
                if (this.zzekm != null) {
                    this.zzekm.putStringSet("never_pool_slots", this.zzeku);
                    this.zzekm.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putStringArray("never_pool_slots", (String[]) this.zzeku.toArray(new String[this.zzeku.size()]));
                zzd(bundle);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayb
    public final boolean zzdu(String str) {
        boolean contains;
        zzzp();
        synchronized (this.mLock) {
            contains = this.zzeku.contains(str);
        }
        return contains;
    }

    @Override // com.google.android.gms.internal.ads.zzayb
    public final void zzdv(String str) {
        zzzp();
        synchronized (this.mLock) {
            long currentTimeMillis = zzbv.zzlm().currentTimeMillis();
            this.zzekq = currentTimeMillis;
            if (str != null) {
                if (!str.equals(this.zzeis)) {
                    this.zzeis = str;
                    if (this.zzekm != null) {
                        this.zzekm.putString("app_settings_json", str);
                        this.zzekm.putLong("app_settings_last_update_ms", currentTimeMillis);
                        this.zzekm.apply();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("app_settings_json", str);
                    bundle.putLong("app_settings_last_update_ms", currentTimeMillis);
                    zzd(bundle);
                    for (Runnable runnable : this.zzeki) {
                        runnable.run();
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayb
    public final zzaxj zzzi() {
        zzaxj zzaxj;
        zzzp();
        synchronized (this.mLock) {
            zzaxj = new zzaxj(this.zzeis, this.zzekq);
        }
        return zzaxj;
    }

    @Override // com.google.android.gms.internal.ads.zzayb
    public final void zzau(long j) {
        zzzp();
        synchronized (this.mLock) {
            if (this.zzekr != j) {
                this.zzekr = j;
                if (this.zzekm != null) {
                    this.zzekm.putLong("app_last_background_time_ms", j);
                    this.zzekm.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putLong("app_last_background_time_ms", j);
                zzd(bundle);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayb
    public final long zzzj() {
        long j;
        zzzp();
        synchronized (this.mLock) {
            j = this.zzekr;
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzayb
    public final void zzcw(int i) {
        zzzp();
        synchronized (this.mLock) {
            if (this.zzejp != i) {
                this.zzejp = i;
                if (this.zzekm != null) {
                    this.zzekm.putInt("request_in_session_count", i);
                    this.zzekm.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putInt("request_in_session_count", i);
                zzd(bundle);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayb
    public final int zzzk() {
        int i;
        zzzp();
        synchronized (this.mLock) {
            i = this.zzejp;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzayb
    public final void zzav(long j) {
        zzzp();
        synchronized (this.mLock) {
            if (this.zzeks != j) {
                this.zzeks = j;
                if (this.zzekm != null) {
                    this.zzekm.putLong("first_ad_req_time_ms", j);
                    this.zzekm.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putLong("first_ad_req_time_ms", j);
                zzd(bundle);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayb
    public final long zzzl() {
        long j;
        zzzp();
        synchronized (this.mLock) {
            j = this.zzeks;
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzayb
    public final void zzb(String str, String str2, boolean z) {
        zzzp();
        synchronized (this.mLock) {
            JSONArray optJSONArray = this.zzekv.optJSONArray(str);
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            int length = optJSONArray.length();
            int i = 0;
            while (true) {
                if (i < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        if (!str2.equals(optJSONObject.optString("template_id"))) {
                            i++;
                        } else if (!z || optJSONObject.optBoolean("uses_media_view", false) != z) {
                            length = i;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("template_id", str2);
                jSONObject.put("uses_media_view", z);
                jSONObject.put("timestamp_ms", zzbv.zzlm().currentTimeMillis());
                optJSONArray.put(length, jSONObject);
                this.zzekv.put(str, optJSONArray);
            } catch (JSONException e) {
                zzaxz.zzc("Could not update native advanced settings", e);
            }
            if (this.zzekm != null) {
                this.zzekm.putString("native_advanced_settings", this.zzekv.toString());
                this.zzekm.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putString("native_advanced_settings", this.zzekv.toString());
            zzd(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayb
    public final JSONObject zzzm() {
        JSONObject jSONObject;
        zzzp();
        synchronized (this.mLock) {
            jSONObject = this.zzekv;
        }
        return jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzayb
    public final void zzzn() {
        zzzp();
        synchronized (this.mLock) {
            this.zzekv = new JSONObject();
            if (this.zzekm != null) {
                this.zzekm.remove("native_advanced_settings");
                this.zzekm.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putString("native_advanced_settings", "{}");
            zzd(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayb
    @Nullable
    public final zzsx zzzo() {
        if (!this.zzekh || !PlatformVersion.isAtLeastIceCreamSandwich()) {
            return null;
        }
        if (zzzc() && zzze()) {
            return null;
        }
        if (!((Boolean) zzwu.zzpz().zzd(zzaan.zzcpz)).booleanValue()) {
            return null;
        }
        synchronized (this.mLock) {
            if (Looper.getMainLooper() == null) {
                return null;
            }
            if (this.zzekk == null) {
                this.zzekk = new zzsx();
            }
            this.zzekk.zzns();
            zzaxz.zzen("start fetching content...");
            return this.zzekk;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzm(Context context, String str) {
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        synchronized (this.mLock) {
            this.zzekl = sharedPreferences;
            this.zzekm = edit;
            if (PlatformVersion.isAtLeastM() && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
                z = true;
            }
            this.zzekn = z;
            this.zzebp = this.zzekl.getBoolean("use_https", this.zzebp);
            this.zzebq = this.zzekl.getBoolean("content_url_opted_out", this.zzebq);
            this.zzeko = this.zzekl.getString("content_url_hashes", this.zzeko);
            this.zzeby = this.zzekl.getBoolean("auto_collect_location", this.zzeby);
            this.zzebr = this.zzekl.getBoolean("content_vertical_opted_out", this.zzebr);
            this.zzekp = this.zzekl.getString("content_vertical_hashes", this.zzekp);
            this.zzekt = this.zzekl.getInt("version_code", this.zzekt);
            this.zzeis = this.zzekl.getString("app_settings_json", this.zzeis);
            this.zzekq = this.zzekl.getLong("app_settings_last_update_ms", this.zzekq);
            this.zzekr = this.zzekl.getLong("app_last_background_time_ms", this.zzekr);
            this.zzejp = this.zzekl.getInt("request_in_session_count", this.zzejp);
            this.zzeks = this.zzekl.getLong("first_ad_req_time_ms", this.zzeks);
            this.zzeku = this.zzekl.getStringSet("never_pool_slots", this.zzeku);
            try {
                this.zzekv = new JSONObject(this.zzekl.getString("native_advanced_settings", "{}"));
            } catch (JSONException e) {
                zzaxz.zzc("Could not convert native advanced settings to json object", e);
            }
            zzd(zzzq());
        }
    }
}
