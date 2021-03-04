package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.gmsg.zzu;
import com.google.android.gms.ads.internal.zzbv;
import java.util.Map;
import org.json.JSONObject;

@zzark
public final class zzbfq implements zzu<zzbdz> {
    private static Integer zze(Map<String, String> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(map.get(str)));
        } catch (NumberFormatException unused) {
            String str2 = map.get(str);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 39 + String.valueOf(str2).length());
            sb.append("Precache invalid numeric parameter '");
            sb.append(str);
            sb.append("': ");
            sb.append(str2);
            zzaxz.zzeo(sb.toString());
            return null;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.util.Map] */
    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final /* synthetic */ void zza(zzbdz zzbdz, Map map) {
        zzbfk zzbfk;
        zzbdz zzbdz2 = zzbdz;
        if (zzaxz.isLoggable(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String valueOf = String.valueOf(jSONObject);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 15);
            sb.append("Precache GMSG: ");
            sb.append(valueOf);
            zzaxz.zzdn(sb.toString());
        }
        zzbv.zzmd();
        if (!map.containsKey("abort")) {
            String str = (String) map.get("src");
            if (str == null) {
                zzbfh zzd = zzbfj.zzd(zzbdz2);
                if (zzd != null) {
                    zzbfk = zzd.zzewk;
                } else {
                    zzaxz.zzeo("Precache must specify a source.");
                    return;
                }
            } else if (zzbfj.zzd(zzbdz2) != null) {
                zzaxz.zzeo("Precache task is already running.");
                return;
            } else if (zzbdz2.zzid() == null) {
                zzaxz.zzeo("Precache requires a dependency provider.");
                return;
            } else {
                zzbdy zzbdy = new zzbdy((String) map.get("flags"));
                Integer zze = zze(map, "player");
                if (zze == null) {
                    zze = 0;
                }
                zzbfk = zzbdz2.zzid().zzbms.zza(zzbdz2, zze.intValue(), null, zzbdy);
                new zzbfh(zzbdz2, zzbfk, str).zzwa();
            }
            Integer zze2 = zze(map, "minBufferMs");
            if (zze2 != null) {
                zzbfk.zzcz(zze2.intValue());
            }
            Integer zze3 = zze(map, "maxBufferMs");
            if (zze3 != null) {
                zzbfk.zzda(zze3.intValue());
            }
            Integer zze4 = zze(map, "bufferForPlaybackMs");
            if (zze4 != null) {
                zzbfk.zzdb(zze4.intValue());
            }
            Integer zze5 = zze(map, "bufferForPlaybackAfterRebufferMs");
            if (zze5 != null) {
                zzbfk.zzdc(zze5.intValue());
            }
        } else if (!zzbfj.zzc(zzbdz2)) {
            zzaxz.zzeo("Precache abort but no precache task running.");
        }
    }
}
