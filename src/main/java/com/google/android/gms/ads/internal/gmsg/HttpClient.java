package com.google.android.gms.ads.internal.gmsg;

import android.content.Context;
import android.support.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzahu;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzaxz;
import com.google.android.gms.internal.ads.zzayf;
import com.google.android.gms.internal.ads.zzbbi;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Keep
@zzark
@KeepName
public class HttpClient implements zzu<zzahu> {
    private final Context mContext;
    private final zzbbi zzbob;

    public HttpClient(Context context, zzbbi zzbbi) {
        this.mContext = context;
        this.zzbob = zzbbi;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    @zzark
    public static class zza {
        private final String mKey;
        private final String mValue;

        public zza(String str, String str2) {
            this.mKey = str;
            this.mValue = str2;
        }

        public final String getKey() {
            return this.mKey;
        }

        public final String getValue() {
            return this.mValue;
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    @zzark
    public class zzc {
        private final zzd zzdfv;
        private final boolean zzdfw;
        private final String zzdfx;

        public zzc(HttpClient httpClient, boolean z, zzd zzd, String str) {
            this.zzdfw = z;
            this.zzdfv = zzd;
            this.zzdfx = str;
        }

        public final String getReason() {
            return this.zzdfx;
        }

        public final zzd zztc() {
            return this.zzdfv;
        }

        public final boolean isSuccess() {
            return this.zzdfw;
        }
    }

    private static zzb zzc(JSONObject jSONObject) {
        String optString = jSONObject.optString("http_request_id");
        String optString2 = jSONObject.optString(ImagesContract.URL);
        URL url = null;
        String optString3 = jSONObject.optString("post_body", null);
        try {
            url = new URL(optString2);
        } catch (MalformedURLException e) {
            zzaxz.zzb("Error constructing http request.", e);
        }
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("headers");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(new zza(optJSONObject.optString("key"), optJSONObject.optString("value")));
            }
        }
        return new zzb(optString, url, arrayList, optString3);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    @zzark
    public static class zzb {
        private final String zzdfr;
        private final URL zzdfs;
        private final ArrayList<zza> zzdft;
        private final String zzdfu;

        zzb(String str, URL url, ArrayList<zza> arrayList, String str2) {
            this.zzdfr = str;
            this.zzdfs = url;
            this.zzdft = arrayList;
            this.zzdfu = str2;
        }

        public final String zzsy() {
            return this.zzdfr;
        }

        public final URL zzsz() {
            return this.zzdfs;
        }

        public final ArrayList<zza> zzta() {
            return this.zzdft;
        }

        public final String zztb() {
            return this.zzdfu;
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    @zzark
    public static class zzd {
        private final List<zza> zzcf;
        private final String zzday;
        private final String zzdfr;
        private final int zzdfy;

        zzd(String str, int i, List<zza> list, String str2) {
            this.zzdfr = str;
            this.zzdfy = i;
            this.zzcf = list;
            this.zzday = str2;
        }

        public final String zzsy() {
            return this.zzdfr;
        }

        public final int getResponseCode() {
            return this.zzdfy;
        }

        public final Iterable<zza> zztd() {
            return this.zzcf;
        }

        public final String getBody() {
            return this.zzday;
        }
    }

    private static JSONObject zza(zzd zzd2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("http_request_id", zzd2.zzsy());
            if (zzd2.getBody() != null) {
                jSONObject.put("body", zzd2.getBody());
            }
            JSONArray jSONArray = new JSONArray();
            for (zza zza2 : zzd2.zztd()) {
                jSONArray.put(new JSONObject().put("key", zza2.getKey()).put("value", zza2.getValue()));
            }
            jSONObject.put("headers", jSONArray);
            jSONObject.put("response_code", zzd2.getResponseCode());
        } catch (JSONException e) {
            zzaxz.zzb("Error constructing JSON for http response.", e);
        }
        return jSONObject;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0104  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.ads.internal.gmsg.HttpClient.zzc zza(com.google.android.gms.ads.internal.gmsg.HttpClient.zzb r13) {
        /*
        // Method dump skipped, instructions count: 265
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.gmsg.HttpClient.zza(com.google.android.gms.ads.internal.gmsg.HttpClient$zzb):com.google.android.gms.ads.internal.gmsg.HttpClient$zzc");
    }

    @Keep
    @KeepName
    public JSONObject send(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            String optString = jSONObject.optString("http_request_id");
            zzc zza2 = zza(zzc(jSONObject));
            if (zza2.isSuccess()) {
                jSONObject2.put("response", zza(zza2.zztc()));
                jSONObject2.put(FirebaseAnalytics.Param.SUCCESS, true);
            } else {
                jSONObject2.put("response", new JSONObject().put("http_request_id", optString));
                jSONObject2.put(FirebaseAnalytics.Param.SUCCESS, false);
                jSONObject2.put("reason", zza2.getReason());
            }
        } catch (Exception e) {
            zzaxz.zzb("Error executing http request.", e);
            try {
                jSONObject2.put("response", new JSONObject().put("http_request_id", ""));
                jSONObject2.put(FirebaseAnalytics.Param.SUCCESS, false);
                jSONObject2.put("reason", e.toString());
            } catch (JSONException e2) {
                zzaxz.zzb("Error executing http request.", e2);
            }
        }
        return jSONObject2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.util.Map] */
    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final /* synthetic */ void zza(zzahu zzahu, Map map) {
        zzayf.zzc(new zzv(this, map, zzahu));
    }
}
