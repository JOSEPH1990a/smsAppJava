package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.common.internal.ImagesContract;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
public final class zzatv {
    @Nullable
    public static JSONObject zza(Context context, zzato zzato) {
        int i;
        int i2;
        boolean z;
        String str;
        String str2;
        String str3;
        int i3;
        int i4;
        int i5;
        zzasi zzasi = zzato.zzeag;
        Location location = zzato.zzcjj;
        zzatz zzatz = zzato.zzeah;
        Bundle bundle = zzato.zzdwm;
        JSONObject jSONObject = zzato.zzeai;
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("extra_caps", zzwu.zzpz().zzd(zzaan.zzcty));
            if (zzato.zzdwt.size() > 0) {
                hashMap.put("eid", TextUtils.join(",", zzato.zzdwt));
            }
            if (zzasi.zzdwf != null) {
                hashMap.put("ad_pos", zzasi.zzdwf);
            }
            zzwb zzwb = zzasi.zzdwg;
            zzaxu.zzyy();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.US);
            if (zzwb.zzcjb != -1) {
                hashMap.put("cust_age", simpleDateFormat.format(new Date(zzwb.zzcjb)));
            }
            if (zzwb.extras != null) {
                hashMap.put("extras", zzwb.extras);
            }
            int i6 = -1;
            if (zzwb.zzcjc != -1) {
                hashMap.put("cust_gender", Integer.valueOf(zzwb.zzcjc));
            }
            if (zzwb.zzcjd != null) {
                hashMap.put("kw", zzwb.zzcjd);
            }
            if (zzwb.zzcjf != -1) {
                hashMap.put("tag_for_child_directed_treatment", Integer.valueOf(zzwb.zzcjf));
            }
            if (zzwb.zzcje) {
                hashMap.put("test_request", true);
            }
            if (zzwb.versionCode >= 2) {
                if (zzwb.zzcjg) {
                    hashMap.put("d_imp_hdr", 1);
                }
                if (!TextUtils.isEmpty(zzwb.zzcjh)) {
                    hashMap.put("ppid", zzwb.zzcjh);
                }
            }
            if (zzwb.versionCode >= 3 && zzwb.zzcjk != null) {
                hashMap.put(ImagesContract.URL, zzwb.zzcjk);
            }
            if (zzwb.versionCode >= 5) {
                if (zzwb.zzcjm != null) {
                    hashMap.put("custom_targeting", zzwb.zzcjm);
                }
                if (zzwb.zzcjn != null) {
                    hashMap.put("category_exclusions", zzwb.zzcjn);
                }
                if (zzwb.zzcjo != null) {
                    hashMap.put("request_agent", zzwb.zzcjo);
                }
            }
            if (zzwb.versionCode >= 6 && zzwb.zzcjp != null) {
                hashMap.put("request_pkg", zzwb.zzcjp);
            }
            if (zzwb.versionCode >= 7) {
                hashMap.put("is_designed_for_families", Boolean.valueOf(zzwb.zzcjq));
            }
            if (zzwb.versionCode >= 8) {
                if (zzwb.zzcjs != -1) {
                    hashMap.put("tag_for_under_age_of_consent", Integer.valueOf(zzwb.zzcjs));
                }
                if (zzwb.zzcjt != null) {
                    hashMap.put("max_ad_content_rating", zzwb.zzcjt);
                }
            }
            if (zzasi.zzbst.zzckm != null) {
                zzwf[] zzwfArr = zzasi.zzbst.zzckm;
                boolean z2 = false;
                boolean z3 = false;
                for (zzwf zzwf : zzwfArr) {
                    if (!zzwf.zzcko && !z2) {
                        hashMap.put("format", zzwf.zzckk);
                        z2 = true;
                    }
                    if (zzwf.zzcko && !z3) {
                        hashMap.put("fluid", "height");
                        z3 = true;
                    }
                    if (z2 && z3) {
                        break;
                    }
                }
            } else {
                hashMap.put("format", zzasi.zzbst.zzckk);
                if (zzasi.zzbst.zzcko) {
                    hashMap.put("fluid", "height");
                }
            }
            if (zzasi.zzbst.width == -1) {
                hashMap.put("smart_w", "full");
            }
            if (zzasi.zzbst.height == -2) {
                hashMap.put("smart_h", "auto");
            }
            if (zzasi.zzbst.zzckm != null) {
                StringBuilder sb = new StringBuilder();
                zzwf[] zzwfArr2 = zzasi.zzbst.zzckm;
                int length = zzwfArr2.length;
                int i7 = 0;
                boolean z4 = false;
                while (i7 < length) {
                    zzwf zzwf2 = zzwfArr2[i7];
                    if (zzwf2.zzcko) {
                        z4 = true;
                    } else {
                        if (sb.length() != 0) {
                            sb.append("|");
                        }
                        if (zzwf2.width == i6) {
                            i4 = (int) (((float) zzwf2.widthPixels) / zzatz.zzbwv);
                        } else {
                            i4 = zzwf2.width;
                        }
                        sb.append(i4);
                        sb.append("x");
                        if (zzwf2.height == -2) {
                            i5 = (int) (((float) zzwf2.heightPixels) / zzatz.zzbwv);
                        } else {
                            i5 = zzwf2.height;
                        }
                        sb.append(i5);
                    }
                    i7++;
                    i6 = -1;
                }
                if (z4) {
                    if (sb.length() != 0) {
                        i3 = 0;
                        sb.insert(0, "|");
                    } else {
                        i3 = 0;
                    }
                    sb.insert(i3, "320x50");
                }
                hashMap.put("sz", sb);
            }
            if (zzasi.zzdwl != 0) {
                hashMap.put("native_version", Integer.valueOf(zzasi.zzdwl));
                hashMap.put("native_templates", zzasi.zzbtt);
                zzacp zzacp = zzasi.zzbti;
                if (zzacp != null) {
                    switch (zzacp.zzdct) {
                        case 0:
                            str3 = "any";
                            break;
                        case 1:
                            str3 = "portrait";
                            break;
                        case 2:
                            str3 = "landscape";
                            break;
                        default:
                            str3 = "not_set";
                            break;
                    }
                } else {
                    str3 = "any";
                }
                hashMap.put("native_image_orientation", str3);
                zzacp zzacp2 = zzasi.zzbti;
                hashMap.put("native_multiple_images", Boolean.valueOf(zzacp2 != null && zzacp2.zzdcu));
                if (!zzasi.zzdwu.isEmpty()) {
                    hashMap.put("native_custom_templates", zzasi.zzdwu);
                }
                if (zzasi.versionCode >= 24) {
                    hashMap.put("max_num_ads", Integer.valueOf(zzasi.zzdxq));
                }
                if (!TextUtils.isEmpty(zzasi.zzdxo)) {
                    try {
                        hashMap.put("native_advanced_settings", new JSONArray(zzasi.zzdxo));
                    } catch (JSONException e) {
                        zzaxz.zzc("Problem creating json from native advanced settings", e);
                    }
                }
            }
            if (zzasi.zzbtn != null && zzasi.zzbtn.size() > 0) {
                for (Integer num : zzasi.zzbtn) {
                    if (num.intValue() == 2) {
                        hashMap.put("iba", true);
                    } else if (num.intValue() == 1) {
                        hashMap.put("ina", true);
                    }
                }
            }
            if (zzasi.zzbst.zzckp) {
                hashMap.put("ene", true);
            }
            if (zzasi.zzbtl != null) {
                hashMap.put("is_icon_ad", true);
                hashMap.put("icon_ad_expansion_behavior", Integer.valueOf(zzasi.zzbtl.zzcly));
            }
            if (zzasi.zzbtk != null) {
                zzafz zzafz = zzasi.zzbtk;
                switch (zzafz.zzdgp) {
                    case 1:
                        str2 = "l";
                        break;
                    case 2:
                        str2 = "p";
                        break;
                    default:
                        int i8 = zzafz.zzdgp;
                        StringBuilder sb2 = new StringBuilder(52);
                        sb2.append("Instream ad video aspect ratio ");
                        sb2.append(i8);
                        sb2.append(" is wrong.");
                        zzbbd.e(sb2.toString());
                        str2 = "l";
                        break;
                }
                hashMap.put("ia_var", str2);
                hashMap.put("instr", true);
            }
            hashMap.put("slotname", zzasi.zzbsn);
            hashMap.put("pn", zzasi.applicationInfo.packageName);
            if (zzasi.zzdwh != null) {
                hashMap.put("vc", Integer.valueOf(zzasi.zzdwh.versionCode));
            }
            hashMap.put("ms", zzato.zzdwi);
            hashMap.put("seq_num", zzasi.zzdwj);
            hashMap.put("session_id", zzasi.zzclm);
            hashMap.put("js", zzasi.zzbsp.zzdp);
            Bundle bundle2 = zzasi.zzdxg;
            Bundle bundle3 = zzato.zzeac;
            hashMap.put("am", Integer.valueOf(zzatz.zzecp));
            hashMap.put("cog", zzag(zzatz.zzecq));
            hashMap.put("coh", zzag(zzatz.zzecr));
            if (!TextUtils.isEmpty(zzatz.zzecs)) {
                hashMap.put("carrier", zzatz.zzecs);
            }
            hashMap.put("gl", zzatz.zzect);
            if (zzatz.zzecu) {
                hashMap.put("simulator", 1);
            }
            hashMap.put("is_latchsky", Boolean.valueOf(zzatz.zzecv));
            if (zzatz.zzecw) {
                hashMap.put("is_sidewinder", 1);
            }
            hashMap.put("ma", zzag(zzatz.zzecx));
            hashMap.put("sp", zzag(zzatz.zzecy));
            hashMap.put("hl", zzatz.zzecz);
            if (!TextUtils.isEmpty(zzatz.zzeda)) {
                hashMap.put("mv", zzatz.zzeda);
            }
            hashMap.put("muv", Integer.valueOf(zzatz.zzedc));
            if (zzatz.zzedd != -2) {
                hashMap.put("cnt", Integer.valueOf(zzatz.zzedd));
            }
            hashMap.put("gnt", Integer.valueOf(zzatz.zzede));
            hashMap.put("pt", Integer.valueOf(zzatz.zzedf));
            hashMap.put("rm", Integer.valueOf(zzatz.zzedg));
            hashMap.put("riv", Integer.valueOf(zzatz.zzedh));
            Bundle bundle4 = new Bundle();
            bundle4.putString("build_build", zzatz.zzedm);
            bundle4.putString("build_device", zzatz.zzedn);
            Bundle bundle5 = new Bundle();
            bundle5.putBoolean("is_charging", zzatz.zzedj);
            bundle5.putDouble("battery_level", zzatz.zzedi);
            bundle4.putBundle("battery", bundle5);
            Bundle bundle6 = new Bundle();
            bundle6.putInt("active_network_state", zzatz.zzedl);
            bundle6.putBoolean("active_network_metered", zzatz.zzedk);
            bundle4.putBundle("network", bundle6);
            Bundle bundle7 = new Bundle();
            bundle7.putBoolean("is_browser_custom_tabs_capable", zzatz.zzedo);
            bundle4.putBundle("browser", bundle7);
            if (bundle2 != null) {
                Bundle bundle8 = new Bundle();
                bundle8.putString("runtime_free", Long.toString(bundle2.getLong("runtime_free_memory", -1)));
                bundle8.putString("runtime_max", Long.toString(bundle2.getLong("runtime_max_memory", -1)));
                bundle8.putString("runtime_total", Long.toString(bundle2.getLong("runtime_total_memory", -1)));
                i = 0;
                bundle8.putString("web_view_count", Integer.toString(bundle2.getInt("web_view_count", 0)));
                Debug.MemoryInfo memoryInfo = (Debug.MemoryInfo) bundle2.getParcelable("debug_memory_info");
                if (memoryInfo != null) {
                    bundle8.putString("debug_info_dalvik_private_dirty", Integer.toString(memoryInfo.dalvikPrivateDirty));
                    bundle8.putString("debug_info_dalvik_pss", Integer.toString(memoryInfo.dalvikPss));
                    bundle8.putString("debug_info_dalvik_shared_dirty", Integer.toString(memoryInfo.dalvikSharedDirty));
                    bundle8.putString("debug_info_native_private_dirty", Integer.toString(memoryInfo.nativePrivateDirty));
                    bundle8.putString("debug_info_native_pss", Integer.toString(memoryInfo.nativePss));
                    bundle8.putString("debug_info_native_shared_dirty", Integer.toString(memoryInfo.nativeSharedDirty));
                    bundle8.putString("debug_info_other_private_dirty", Integer.toString(memoryInfo.otherPrivateDirty));
                    bundle8.putString("debug_info_other_pss", Integer.toString(memoryInfo.otherPss));
                    bundle8.putString("debug_info_other_shared_dirty", Integer.toString(memoryInfo.otherSharedDirty));
                }
                bundle4.putBundle("android_mem_info", bundle8);
            } else {
                i = 0;
            }
            Bundle bundle9 = new Bundle();
            bundle9.putBundle("parental_controls", bundle3);
            if (!TextUtils.isEmpty(zzatz.zzedb)) {
                bundle9.putString("package_version", zzatz.zzedb);
            }
            bundle4.putBundle("play_store", bundle9);
            hashMap.put("device", bundle4);
            Bundle bundle10 = new Bundle();
            bundle10.putString("doritos", zzato.zzead);
            bundle10.putString("doritos_v2", zzato.zzeae);
            if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcro)).booleanValue()) {
                if (zzato.zzeaf != null) {
                    str = zzato.zzeaf.getId();
                    z = zzato.zzeaf.isLimitAdTrackingEnabled();
                } else {
                    str = null;
                    z = false;
                }
                if (!TextUtils.isEmpty(str)) {
                    bundle10.putString("rdid", str);
                    bundle10.putBoolean("is_lat", z);
                    bundle10.putString("idtype", "adid");
                } else {
                    zzwu.zzpv();
                    bundle10.putString("pdid", zzbat.zzbg(context));
                    bundle10.putString("pdidtype", "ssaid");
                }
            }
            hashMap.put("pii", bundle10);
            hashMap.put("platform", Build.MANUFACTURER);
            hashMap.put("submodel", Build.MODEL);
            if (location != null) {
                zza(hashMap, location);
            } else if (zzasi.zzdwg.versionCode >= 2 && zzasi.zzdwg.zzcjj != null) {
                zza(hashMap, zzasi.zzdwg.zzcjj);
            }
            if (zzasi.versionCode >= 2) {
                hashMap.put("quality_signals", zzasi.zzdwk);
            }
            if (zzasi.versionCode >= 4 && zzasi.zzdwn) {
                hashMap.put("forceHttps", Boolean.valueOf(zzasi.zzdwn));
            }
            if (bundle != null) {
                hashMap.put("content_info", bundle);
            }
            if (zzasi.versionCode >= 5) {
                hashMap.put("u_sd", Float.valueOf(zzasi.zzbwv));
                hashMap.put("sh", Integer.valueOf(zzasi.zzdwp));
                hashMap.put("sw", Integer.valueOf(zzasi.zzdwo));
            } else {
                hashMap.put("u_sd", Float.valueOf(zzatz.zzbwv));
                hashMap.put("sh", Integer.valueOf(zzatz.zzdwp));
                hashMap.put("sw", Integer.valueOf(zzatz.zzdwo));
            }
            if (zzasi.versionCode >= 6) {
                if (!TextUtils.isEmpty(zzasi.zzdwq)) {
                    try {
                        hashMap.put("view_hierarchy", new JSONObject(zzasi.zzdwq));
                    } catch (JSONException e2) {
                        zzaxz.zzc("Problem serializing view hierarchy to JSON", e2);
                    }
                }
                hashMap.put("correlation_id", Long.valueOf(zzasi.zzdwr));
            }
            if (zzasi.versionCode >= 7) {
                hashMap.put("request_id", zzasi.zzdws);
            }
            if (zzasi.versionCode >= 12 && !TextUtils.isEmpty(zzasi.zzdww)) {
                hashMap.put("anchor", zzasi.zzdww);
            }
            if (zzasi.versionCode >= 13) {
                hashMap.put("android_app_volume", Float.valueOf(zzasi.zzdwx));
            }
            if (zzasi.versionCode >= 18) {
                hashMap.put("android_app_muted", Boolean.valueOf(zzasi.zzdxd));
            }
            if (zzasi.versionCode >= 14 && zzasi.zzdwy > 0) {
                hashMap.put("target_api", Integer.valueOf(zzasi.zzdwy));
            }
            if (zzasi.versionCode >= 15) {
                int i9 = -1;
                if (zzasi.zzdwz != -1) {
                    i9 = zzasi.zzdwz;
                }
                hashMap.put("scroll_index", Integer.valueOf(i9));
            }
            if (zzasi.versionCode >= 16) {
                hashMap.put("_activity_context", Boolean.valueOf(zzasi.zzdxa));
            }
            if (zzasi.versionCode >= 18) {
                if (!TextUtils.isEmpty(zzasi.zzdxe)) {
                    try {
                        hashMap.put("app_settings", new JSONObject(zzasi.zzdxe));
                    } catch (JSONException e3) {
                        zzaxz.zzc("Problem creating json from app settings", e3);
                    }
                }
                hashMap.put("render_in_browser", Boolean.valueOf(zzasi.zzdlv));
            }
            if (zzasi.versionCode >= 18) {
                hashMap.put("android_num_video_cache_tasks", Integer.valueOf(zzasi.zzdxf));
            }
            zzbbi zzbbi = zzasi.zzbsp;
            boolean z5 = zzasi.zzdxr;
            boolean z6 = zzato.zzeaj;
            boolean z7 = zzasi.zzdxt;
            Bundle bundle11 = new Bundle();
            Bundle bundle12 = new Bundle();
            bundle12.putString("cl", "221522000");
            bundle12.putString("rapid_rc", "dev");
            bundle12.putString("rapid_rollup", "HEAD");
            bundle11.putBundle("build_meta", bundle12);
            bundle11.putString("mf", Boolean.toString(((Boolean) zzwu.zzpz().zzd(zzaan.zzcua)).booleanValue()));
            bundle11.putBoolean("instant_app", z5);
            bundle11.putBoolean("lite", zzbbi.zzeox);
            bundle11.putBoolean("local_service", z6);
            bundle11.putBoolean("is_privileged_process", z7);
            bundle11.putInt("container_version", 12451009);
            hashMap.put("sdk_env", bundle11);
            hashMap.put("cache_state", jSONObject);
            if (zzasi.versionCode >= 19) {
                hashMap.put("gct", zzasi.zzdxh);
            }
            if (zzasi.versionCode >= 21 && zzasi.zzdxi) {
                hashMap.put("de", "1");
            }
            if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcrz)).booleanValue()) {
                String str4 = zzasi.zzbst.zzckk;
                boolean z8 = str4.equals("interstitial_mb") || str4.equals("reward_mb");
                Bundle bundle13 = zzasi.zzdxj;
                boolean z9 = bundle13 != null;
                if (z8 && z9) {
                    Bundle bundle14 = new Bundle();
                    bundle14.putBundle("interstitial_pool", bundle13);
                    hashMap.put("counters", bundle14);
                }
            }
            if (zzasi.zzdxk != null) {
                hashMap.put("gmp_app_id", zzasi.zzdxk);
            }
            if (zzasi.zzdxl == null) {
                hashMap.put("fbs_aiid", "");
            } else if ("TIME_OUT".equals(zzasi.zzdxl)) {
                hashMap.put("sai_timeout", zzwu.zzpz().zzd(zzaan.zzcqu));
            } else {
                hashMap.put("fbs_aiid", zzasi.zzdxl);
            }
            if (zzasi.zzdxm != null) {
                hashMap.put("fbs_aeid", zzasi.zzdxm);
            }
            if (zzasi.zzdxw != null) {
                hashMap.put("apm_id_origin", zzasi.zzdxw);
            }
            if (zzasi.versionCode >= 24) {
                hashMap.put("disable_ml", Boolean.valueOf(zzasi.zzdxs));
            }
            String str5 = (String) zzwu.zzpz().zzd(zzaan.zzcpj);
            if (str5 != null && !str5.isEmpty()) {
                if (Build.VERSION.SDK_INT >= ((Integer) zzwu.zzpz().zzd(zzaan.zzcpk)).intValue()) {
                    HashMap hashMap2 = new HashMap();
                    String[] split = str5.split(",");
                    int length2 = split.length;
                    while (i < length2) {
                        String str6 = split[i];
                        hashMap2.put(str6, zzbar.zzeh(str6));
                        i++;
                    }
                    hashMap.put("video_decoders", hashMap2);
                }
            }
            if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcwy)).booleanValue()) {
                hashMap.put("omid_v", zzbv.zzlw().getVersion(context));
            }
            if (zzasi.zzdxu != null && !zzasi.zzdxu.isEmpty()) {
                hashMap.put("android_permissions", zzasi.zzdxu);
            }
            if (zzasi.zzdxv != null) {
                hashMap.put("consent_string", zzasi.zzdxv);
            }
            if (zzasi.zzdxv != null) {
                hashMap.put("iab_consent_info", zzasi.zzdxx);
                i2 = 2;
            } else {
                i2 = 2;
            }
            if (zzaxz.isLoggable(i2)) {
                String valueOf = String.valueOf(zzbv.zzlf().zzn(hashMap).toString(i2));
                zzaxz.v(valueOf.length() != 0 ? "Ad Request JSON: ".concat(valueOf) : new String("Ad Request JSON: "));
            }
            return zzbv.zzlf().zzn(hashMap);
        } catch (JSONException e4) {
            String valueOf2 = String.valueOf(e4.getMessage());
            zzaxz.zzeo(valueOf2.length() != 0 ? "Problem serializing ad request to JSON: ".concat(valueOf2) : new String("Problem serializing ad request to JSON: "));
            return null;
        }
    }

    private static void zza(HashMap<String, Object> hashMap, Location location) {
        HashMap hashMap2 = new HashMap();
        Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
        Long valueOf2 = Long.valueOf(location.getTime() * 1000);
        Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
        Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
        hashMap2.put("radius", valueOf);
        hashMap2.put("lat", valueOf3);
        hashMap2.put("long", valueOf4);
        hashMap2.put("time", valueOf2);
        hashMap.put("uule", hashMap2);
    }

    private static Integer zzag(boolean z) {
        return Integer.valueOf(z ? 1 : 0);
    }

    public static zzasm zza(Context context, zzasi zzasi, String str) {
        int i;
        long j;
        String str2;
        String str3;
        zzasm zzasm;
        List<String> list;
        List<String> list2;
        List<String> list3;
        List<String> list4;
        long j2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("ad_base_url", null);
            String optString2 = jSONObject.optString("ad_url", null);
            String optString3 = jSONObject.optString("ad_size", null);
            String optString4 = jSONObject.optString("ad_slot_size", optString3);
            boolean z = (zzasi == null || zzasi.zzdwl == 0) ? false : true;
            String optString5 = jSONObject.optString("ad_json", null);
            if (optString5 == null) {
                optString5 = jSONObject.optString("ad_html", null);
            }
            if (optString5 == null) {
                optString5 = jSONObject.optString("body", null);
            }
            if (optString5 == null && jSONObject.has("ads")) {
                optString5 = jSONObject.toString();
            }
            String optString6 = jSONObject.optString("debug_dialog", null);
            String optString7 = jSONObject.optString("debug_signals", null);
            long j3 = jSONObject.has("interstitial_timeout") ? (long) (jSONObject.getDouble("interstitial_timeout") * 1000.0d) : -1;
            String optString8 = jSONObject.optString("orientation", null);
            if ("portrait".equals(optString8)) {
                i = zzbv.zzlh().zzzx();
            } else {
                i = "landscape".equals(optString8) ? zzbv.zzlh().zzzw() : -1;
            }
            if (!TextUtils.isEmpty(optString5) || TextUtils.isEmpty(optString2)) {
                str3 = optString;
                str2 = optString5;
                zzasm = null;
                j = -1;
            } else {
                zzasm = zzatq.zza(zzasi, context, zzasi.zzbsp.zzdp, optString2, null, null, null, null, null);
                String str4 = zzasm.zzbde;
                String str5 = zzasm.zzdyb;
                j = zzasm.zzdyh;
                str2 = str5;
                str3 = str4;
            }
            if (str2 == null) {
                return new zzasm(0);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("click_urls");
            if (zzasm == null) {
                list = null;
            } else {
                list = zzasm.zzdlq;
            }
            if (optJSONArray != null) {
                list = zza(optJSONArray, list);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("impression_urls");
            if (zzasm == null) {
                list2 = null;
            } else {
                list2 = zzasm.zzdlr;
            }
            if (optJSONArray2 != null) {
                list2 = zza(optJSONArray2, list2);
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("downloaded_impression_urls");
            if (zzasm == null) {
                list3 = null;
            } else {
                list3 = zzasm.zzdls;
            }
            List<String> zza = optJSONArray3 != null ? zza(optJSONArray3, list3) : list3;
            JSONArray optJSONArray4 = jSONObject.optJSONArray("manual_impression_urls");
            if (zzasm == null) {
                list4 = null;
            } else {
                list4 = zzasm.zzdyf;
            }
            List<String> zza2 = optJSONArray4 != null ? zza(optJSONArray4, list4) : list4;
            if (zzasm != null) {
                if (zzasm.orientation != -1) {
                    i = zzasm.orientation;
                }
                j2 = zzasm.zzdyc > 0 ? zzasm.zzdyc : j3;
            } else {
                j2 = j3;
            }
            String optString9 = jSONObject.optString("active_view");
            boolean optBoolean = jSONObject.optBoolean("ad_is_javascript", false);
            String optString10 = optBoolean ? jSONObject.optString("ad_passback_url", null) : null;
            boolean optBoolean2 = jSONObject.optBoolean("mediation", false);
            boolean optBoolean3 = jSONObject.optBoolean("custom_render_allowed", false);
            boolean optBoolean4 = jSONObject.optBoolean("content_url_opted_out", true);
            boolean optBoolean5 = jSONObject.optBoolean("content_vertical_opted_out", true);
            boolean optBoolean6 = jSONObject.optBoolean("prefetch", false);
            long optLong = jSONObject.optLong("refresh_interval_milliseconds", -1);
            long optLong2 = jSONObject.optLong("mediation_config_cache_time_milliseconds", -1);
            String optString11 = jSONObject.optString("gws_query_id", "");
            boolean equals = "height".equals(jSONObject.optString("fluid", ""));
            boolean optBoolean7 = jSONObject.optBoolean("native_express", false);
            List<String> zza3 = zza(jSONObject.optJSONArray("video_start_urls"), (List<String>) null);
            List<String> zza4 = zza(jSONObject.optJSONArray("video_complete_urls"), (List<String>) null);
            zzawd zza5 = zzawd.zza(jSONObject.optJSONArray("rewards"));
            boolean optBoolean8 = jSONObject.optBoolean("use_displayed_impression", false);
            zzaso zzl = zzaso.zzl(jSONObject.optJSONObject("auto_protection_configuration"));
            String optString12 = jSONObject.optString("set_cookie", "");
            List<String> zza6 = zza(jSONObject.optJSONArray("remote_ping_urls"), (List<String>) null);
            zzawo zzo = zzawo.zzo(jSONObject.optJSONObject("safe_browsing"));
            boolean optBoolean9 = jSONObject.optBoolean("render_in_browser", zzasi.zzdlv);
            boolean optBoolean10 = jSONObject.optBoolean("custom_close_blocked");
            boolean optBoolean11 = jSONObject.optBoolean("enable_omid", false);
            String optString13 = jSONObject.optString("omid_settings", null);
            boolean optBoolean12 = jSONObject.optBoolean("disable_closable_area", false);
            Bundle bundle = zzasi.zzdwg.zzcjl.getBundle(AdMobAdapter.class.getName());
            return new zzasm(zzasi, str3, str2, list, list2, j2, optBoolean2, optLong2, zza2, optLong, i, optString3, j, optString6, optBoolean, optString10, optString9, optBoolean3, z, zzasi.zzdwn, optBoolean4, optBoolean6, optString11, equals, optBoolean7, zza5, zza3, zza4, optBoolean8, zzl, zzasi.zzdxb, optString12, zza6, optBoolean9, optString4, zzo, optString7, optBoolean5, zzasi.zzdxn, optBoolean10, 0, optBoolean11, zza, optBoolean12, optString13, "", bundle != null && bundle.getBoolean("is_analytics_logging_enabled", false));
        } catch (JSONException e) {
            String valueOf = String.valueOf(e.getMessage());
            zzaxz.zzeo(valueOf.length() != 0 ? "Could not parse the inline ad response: ".concat(valueOf) : new String("Could not parse the inline ad response: "));
            return new zzasm(0);
        }
    }

    @Nullable
    private static List<String> zza(@Nullable JSONArray jSONArray, @Nullable List<String> list) throws JSONException {
        if (jSONArray == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            list.add(jSONArray.getString(i));
        }
        return list;
    }

    public static JSONObject zzb(zzasm zzasm) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (zzasm.zzbde != null) {
            jSONObject.put("ad_base_url", zzasm.zzbde);
        }
        if (zzasm.zzdyg != null) {
            jSONObject.put("ad_size", zzasm.zzdyg);
        }
        jSONObject.put("native", zzasm.zzckn);
        if (zzasm.zzckn) {
            jSONObject.put("ad_json", zzasm.zzdyb);
        } else {
            jSONObject.put("ad_html", zzasm.zzdyb);
        }
        if (zzasm.zzdyi != null) {
            jSONObject.put("debug_dialog", zzasm.zzdyi);
        }
        if (zzasm.zzdyy != null) {
            jSONObject.put("debug_signals", zzasm.zzdyy);
        }
        if (zzasm.zzdyc != -1) {
            double d = (double) zzasm.zzdyc;
            Double.isNaN(d);
            jSONObject.put("interstitial_timeout", d / 1000.0d);
        }
        if (zzasm.orientation == zzbv.zzlh().zzzx()) {
            jSONObject.put("orientation", "portrait");
        } else if (zzasm.orientation == zzbv.zzlh().zzzw()) {
            jSONObject.put("orientation", "landscape");
        }
        if (zzasm.zzdlq != null) {
            jSONObject.put("click_urls", zzm(zzasm.zzdlq));
        }
        if (zzasm.zzdlr != null) {
            jSONObject.put("impression_urls", zzm(zzasm.zzdlr));
        }
        if (zzasm.zzdls != null) {
            jSONObject.put("downloaded_impression_urls", zzm(zzasm.zzdls));
        }
        if (zzasm.zzdyf != null) {
            jSONObject.put("manual_impression_urls", zzm(zzasm.zzdyf));
        }
        if (zzasm.zzdyl != null) {
            jSONObject.put("active_view", zzasm.zzdyl);
        }
        jSONObject.put("ad_is_javascript", zzasm.zzdyj);
        if (zzasm.zzdyk != null) {
            jSONObject.put("ad_passback_url", zzasm.zzdyk);
        }
        jSONObject.put("mediation", zzasm.zzdyd);
        jSONObject.put("custom_render_allowed", zzasm.zzdym);
        jSONObject.put("content_url_opted_out", zzasm.zzdyn);
        jSONObject.put("content_vertical_opted_out", zzasm.zzdyz);
        jSONObject.put("prefetch", zzasm.zzdyo);
        if (zzasm.zzdlx != -1) {
            jSONObject.put("refresh_interval_milliseconds", zzasm.zzdlx);
        }
        if (zzasm.zzdye != -1) {
            jSONObject.put("mediation_config_cache_time_milliseconds", zzasm.zzdye);
        }
        if (!TextUtils.isEmpty(zzasm.zzcgx)) {
            jSONObject.put("gws_query_id", zzasm.zzcgx);
        }
        jSONObject.put("fluid", zzasm.zzcko ? "height" : "");
        jSONObject.put("native_express", zzasm.zzckp);
        if (zzasm.zzdys != null) {
            jSONObject.put("video_start_urls", zzm(zzasm.zzdys));
        }
        if (zzasm.zzdyt != null) {
            jSONObject.put("video_complete_urls", zzm(zzasm.zzdyt));
        }
        if (zzasm.zzdyr != null) {
            zzawd zzawd = zzasm.zzdyr;
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("rb_type", zzawd.type);
            jSONObject2.put("rb_amount", zzawd.zzefo);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            jSONObject.put("rewards", jSONArray);
        }
        jSONObject.put("use_displayed_impression", zzasm.zzdyu);
        jSONObject.put("auto_protection_configuration", zzasm.zzdyv);
        jSONObject.put("render_in_browser", zzasm.zzdlv);
        jSONObject.put("disable_closable_area", zzasm.zzbpi);
        return jSONObject;
    }

    @Nullable
    private static JSONArray zzm(List<String> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (String str : list) {
            jSONArray.put(str);
        }
        return jSONArray;
    }
}
