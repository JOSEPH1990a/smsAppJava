package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.common.util.IOUtils;
import com.gsmmodem.Servers.MyHttpServer;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
public final class zzatq extends zzasr {
    private static final Object sLock = new Object();
    @GuardedBy("sLock")
    private static zzatq zzeau;
    private final Context mContext;
    private final zzatp zzeav;
    private final ScheduledExecutorService zzeaw = Executors.newSingleThreadScheduledExecutor();

    public static zzatq zza(Context context, zzatp zzatp) {
        zzatq zzatq;
        synchronized (sLock) {
            if (zzeau == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                zzaan.initialize(context);
                zzeau = new zzatq(context, zzatp);
                if (context.getApplicationContext() != null) {
                    zzbv.zzlf().zzaj(context);
                }
                zzaxx.zzag(context);
            }
            zzatq = zzeau;
        }
        return zzatq;
    }

    @Override // com.google.android.gms.internal.ads.zzasq
    public final void zza(zzatb zzatb, zzasw zzasw) {
        zzaxz.v("Nonagon code path entered in octagon");
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.ads.zzasq
    public final void zzb(zzatb zzatb, zzasw zzasw) {
        zzaxz.v("Nonagon code path entered in octagon");
        throw new IllegalArgumentException();
    }

    private static zzasm zza(Context context, zzatp zzatp, zzasi zzasi, ScheduledExecutorService scheduledExecutorService) {
        zzbcb<String> zzbcb;
        String str;
        int i;
        zzasm zzasm;
        int i2;
        char c;
        String string;
        zzaxz.zzdn("Starting ad request from service using: google.afma.request.getAdDictionary");
        zzaba zzaba = new zzaba(((Boolean) zzwu.zzpz().zzd(zzaan.zzcpw)).booleanValue(), "load_ad", zzasi.zzbst.zzckk);
        if (zzasi.versionCode > 10 && zzasi.zzdwv != -1) {
            zzaba.zza(zzaba.zzao(zzasi.zzdwv), "cts");
        }
        zzaay zzrg = zzaba.zzrg();
        zzbcb zza = zzbbq.zza(zzatp.zzear.zzm(context), ((Long) zzwu.zzpz().zzd(zzaan.zzcvj)).longValue(), TimeUnit.MILLISECONDS, scheduledExecutorService);
        zzbcb<String> zzm = zzbbq.zzm(null);
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcxz)).booleanValue()) {
            zzm = zzatp.zzeam.zzdo(zzasi.zzdwh.packageName);
        }
        zzbcb<String> zzdp = zzatp.zzeam.zzdp(zzasi.zzdwh.packageName);
        zzbcb<String> zza2 = zzatp.zzeas.zza(zzasi.zzdwi, zzasi.zzdwh);
        Future<zzatz> zzt = zzbv.zzlq().zzt(context);
        zzbcb<Location> zzm2 = zzbbq.zzm(null);
        Bundle bundle = zzasi.zzdwg.extras;
        boolean z = (bundle == null || bundle.getString("_ad") == null) ? false : true;
        if (zzasi.zzdxb && !z) {
            zzm2 = zzatp.zzeap.zza(zzasi.applicationInfo);
        }
        zzbcb zza3 = zzbbq.zza(zzm2, ((Long) zzwu.zzpz().zzd(zzaan.zzcuu)).longValue(), TimeUnit.MILLISECONDS, scheduledExecutorService);
        Future zzm3 = zzbbq.zzm(null);
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcro)).booleanValue()) {
            zzbcb = zzm;
            zzm3 = zzbbq.zza(zzatp.zzeas.zzad(context), ((Long) zzwu.zzpz().zzd(zzaan.zzcrp)).longValue(), TimeUnit.MILLISECONDS, scheduledExecutorService);
        } else {
            zzbcb = zzm;
        }
        Bundle bundle2 = (zzasi.versionCode < 4 || zzasi.zzdwm == null) ? null : zzasi.zzdwm;
        zzbv.zzlf();
        if (zzayh.zzn(context, "android.permission.ACCESS_NETWORK_STATE") && ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() == null) {
            zzaxz.zzdn("Device is offline.");
        }
        if (zzasi.versionCode >= 7) {
            str = zzasi.zzdws;
        } else {
            str = UUID.randomUUID().toString();
        }
        if (zzasi.zzdwg.extras != null && (string = zzasi.zzdwg.extras.getString("_ad")) != null) {
            return zzatv.zza(context, zzasi, string);
        }
        List<String> zzf = zzatp.zzean.zzf(zzasi.zzdwt);
        Bundle bundle3 = (Bundle) zzbbq.zza(zza, (Object) null, ((Long) zzwu.zzpz().zzd(zzaan.zzcvj)).longValue(), TimeUnit.MILLISECONDS);
        Location location = (Location) zzbbq.zza(zza3, (Object) null);
        AdvertisingIdClient.Info info = (AdvertisingIdClient.Info) zzbbq.zza(zzm3, (Object) null);
        String str2 = (String) zzbbq.zza(zza2, (Object) null);
        String str3 = (String) zzbbq.zza(zzbcb, (Object) null);
        String str4 = (String) zzbbq.zza(zzdp, (Object) null);
        zzatz zzatz = (zzatz) zzbbq.zza(zzt, (Object) null);
        if (zzatz == null) {
            zzaxz.zzeo("Error fetching device info. This is not recoverable.");
            return new zzasm(0);
        }
        zzato zzato = new zzato();
        zzato.zzeag = zzasi;
        zzato.zzeah = zzatz;
        zzato.zzcjj = location;
        zzato.zzeac = bundle3;
        zzato.zzdwi = str2;
        zzato.zzeaf = info;
        if (zzf == null) {
            zzato.zzdwt.clear();
        }
        zzato.zzdwt = zzf;
        zzato.zzdwm = bundle2;
        zzato.zzead = str3;
        zzato.zzeae = str4;
        zzato.zzeai = zzatp.zzeal.zzf(context);
        zzato.zzeaj = zzatp.zzeaj;
        JSONObject zza4 = zzatv.zza(context, zzato);
        if (zza4 == null) {
            return new zzasm(0);
        }
        if (zzasi.versionCode < 7) {
            try {
                zza4.put("request_id", str);
                i = 1;
            } catch (JSONException unused) {
                i = 1;
            }
        } else {
            i = 1;
        }
        String[] strArr = new String[i];
        strArr[0] = "arc";
        zzaba.zza(zzrg, strArr);
        zzbcb zza5 = zzbbq.zza(zzbbq.zza(zzatp.zzeat.zzwo().zzj(zza4), zzatr.zzbni, scheduledExecutorService), 10, TimeUnit.SECONDS, scheduledExecutorService);
        zzbcb<Void> zzwy = zzatp.zzeao.zzwy();
        if (zzwy != null) {
            zzbbo.zza(zzwy, "AdRequestServiceImpl.loadAd.flags");
            zzasm = null;
        } else {
            zzasm = null;
        }
        zzaty zzaty = (zzaty) zzbbq.zza(zza5, zzasm);
        if (zzaty == null) {
            return new zzasm(0);
        }
        if (zzaty.getErrorCode() != -2) {
            return new zzasm(zzaty.getErrorCode());
        }
        zzaba.zzrj();
        if (!TextUtils.isEmpty(zzaty.zzwt())) {
            zzasm = zzatv.zza(context, zzasi, zzaty.zzwt());
        }
        if (zzasm == null && !TextUtils.isEmpty(zzaty.getUrl())) {
            zzasm = zza(zzasi, context, zzasi.zzbsp.zzdp, zzaty.getUrl(), str3, str4, zzaty, zzaba, zzatp);
        }
        if (zzasm == null) {
            c = 0;
            zzasm = new zzasm(0);
            i2 = 1;
        } else {
            c = 0;
            i2 = 1;
        }
        String[] strArr2 = new String[i2];
        strArr2[c] = "tts";
        zzaba.zza(zzrg, strArr2);
        zzasm.zzdyq = zzaba.zzrh();
        zzasm.zzdze = zzaty.zzwv();
        return zzasm;
    }

    private static void zza(String str, Map<String, List<String>> map, String str2, int i) {
        if (zzaxz.isLoggable(2)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 39);
            sb.append("Http Response: {\n  URL:\n    ");
            sb.append(str);
            sb.append("\n  Headers:");
            zzaxz.v(sb.toString());
            if (map != null) {
                for (String str3 : map.keySet()) {
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str3).length() + 5);
                    sb2.append("    ");
                    sb2.append(str3);
                    sb2.append(":");
                    zzaxz.v(sb2.toString());
                    for (String str4 : map.get(str3)) {
                        String valueOf = String.valueOf(str4);
                        zzaxz.v(valueOf.length() != 0 ? "      ".concat(valueOf) : new String("      "));
                    }
                }
            }
            zzaxz.v("  Body:");
            if (str2 != null) {
                int i2 = 0;
                while (i2 < Math.min(str2.length(), 100000)) {
                    int i3 = i2 + 1000;
                    zzaxz.v(str2.substring(i2, Math.min(str2.length(), i3)));
                    i2 = i3;
                }
            } else {
                zzaxz.v("    null");
            }
            StringBuilder sb3 = new StringBuilder(34);
            sb3.append("  Response Code:\n    ");
            sb3.append(i);
            sb3.append("\n}");
            zzaxz.v(sb3.toString());
        }
    }

    public static zzasm zza(zzasi zzasi, Context context, String str, String str2, String str3, String str4, zzaty zzaty, zzaba zzaba, zzatp zzatp) {
        HttpURLConnection httpURLConnection;
        byte[] bArr;
        int responseCode;
        InputStreamReader inputStreamReader;
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        Throwable th2;
        zzasi zzasi2 = zzasi;
        zzaay zzrg = zzaba != null ? zzaba.zzrg() : null;
        try {
            zzatw zzatw = new zzatw(zzasi2, zzaty.zzwq());
            String valueOf = String.valueOf(str2);
            zzaxz.zzdn(valueOf.length() != 0 ? "AdRequestServiceImpl: Sending request: ".concat(valueOf) : new String("AdRequestServiceImpl: Sending request: "));
            URL url = new URL(str2);
            long elapsedRealtime = zzbv.zzlm().elapsedRealtime();
            boolean z = false;
            int i = 0;
            while (true) {
                if (zzatp != null) {
                    zzatp.zzeaq.zzwz();
                }
                httpURLConnection = (HttpURLConnection) url.openConnection();
                try {
                    zzbv.zzlf().zza(context, str, z, httpURLConnection);
                    if (zzaty.zzws()) {
                        if (!TextUtils.isEmpty(str3)) {
                            httpURLConnection.addRequestProperty("x-afma-drt-cookie", str3);
                        }
                        if (!TextUtils.isEmpty(str4)) {
                            httpURLConnection.addRequestProperty("x-afma-drt-v2-cookie", str4);
                        }
                    }
                    String str5 = zzasi2.zzdxc;
                    if (!TextUtils.isEmpty(str5)) {
                        zzaxz.zzdn("Sending webview cookie in ad request header.");
                        httpURLConnection.addRequestProperty("Cookie", str5);
                    }
                    if (zzaty == null || TextUtils.isEmpty(zzaty.zzwr())) {
                        bArr = null;
                    } else {
                        httpURLConnection.setDoOutput(true);
                        bArr = zzaty.zzwr().getBytes();
                        httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                        try {
                            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(httpURLConnection.getOutputStream());
                            try {
                                bufferedOutputStream2.write(bArr);
                                IOUtils.closeQuietly(bufferedOutputStream2);
                            } catch (Throwable th3) {
                                th2 = th3;
                                bufferedOutputStream = bufferedOutputStream2;
                                IOUtils.closeQuietly(bufferedOutputStream);
                                throw th2;
                            }
                        } catch (Throwable th4) {
                            th2 = th4;
                            bufferedOutputStream = null;
                            IOUtils.closeQuietly(bufferedOutputStream);
                            throw th2;
                        }
                    }
                    zzbax zzbax = new zzbax(zzasi2.zzdws);
                    zzbax.zza(httpURLConnection, bArr);
                    responseCode = httpURLConnection.getResponseCode();
                    Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                    zzbax.zza(httpURLConnection, responseCode);
                    if (responseCode < 200 || responseCode >= 300) {
                        zza(url.toString(), headerFields, (String) null, responseCode);
                        if (responseCode < 300 || responseCode >= 400) {
                            StringBuilder sb = new StringBuilder(46);
                            sb.append("Received error HTTP response code: ");
                            sb.append(responseCode);
                            zzaxz.zzeo(sb.toString());
                            zzasm zzasm = new zzasm(0);
                            httpURLConnection.disconnect();
                        } else {
                            String headerField = httpURLConnection.getHeaderField("Location");
                            if (TextUtils.isEmpty(headerField)) {
                                zzaxz.zzeo("No location header to follow redirect.");
                                zzasm zzasm2 = new zzasm(0);
                                httpURLConnection.disconnect();
                                if (zzatp != null) {
                                    zzatp.zzeaq.zzxa();
                                }
                                return zzasm2;
                            }
                            url = new URL(headerField);
                            i++;
                            if (i > ((Integer) zzwu.zzpz().zzd(zzaan.zzcwx)).intValue()) {
                                zzaxz.zzeo("Too many redirects.");
                                zzasm zzasm3 = new zzasm(0);
                                httpURLConnection.disconnect();
                                if (zzatp != null) {
                                    zzatp.zzeaq.zzxa();
                                }
                                return zzasm3;
                            }
                            zzatw.zzl(headerFields);
                            zzasi2 = zzasi;
                            z = false;
                        }
                    } else {
                        String url2 = url.toString();
                        try {
                            InputStreamReader inputStreamReader2 = new InputStreamReader(httpURLConnection.getInputStream());
                            try {
                                zzbv.zzlf();
                                String zza = zzayh.zza(inputStreamReader2);
                                IOUtils.closeQuietly(inputStreamReader2);
                                zzbax.zzek(zza);
                                zza(url2, headerFields, zza, responseCode);
                                zzatw.zza(url2, headerFields, zza);
                                if (zzaba != null) {
                                    zzaba.zza(zzrg, "ufe");
                                }
                                zzasm zza2 = zzatw.zza(elapsedRealtime, zzaty);
                                httpURLConnection.disconnect();
                                if (zzatp != null) {
                                    zzatp.zzeaq.zzxa();
                                }
                                return zza2;
                            } catch (Throwable th5) {
                                th = th5;
                                inputStreamReader = inputStreamReader2;
                                IOUtils.closeQuietly(inputStreamReader);
                                throw th;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            inputStreamReader = null;
                            IOUtils.closeQuietly(inputStreamReader);
                            throw th;
                        }
                    }
                } finally {
                    httpURLConnection.disconnect();
                    if (zzatp != null) {
                        zzatp.zzeaq.zzxa();
                    }
                }
            }
            StringBuilder sb2 = new StringBuilder(46);
            sb2.append("Received error HTTP response code: ");
            sb2.append(responseCode);
            zzaxz.zzeo(sb2.toString());
            zzasm zzasm4 = new zzasm(0);
            httpURLConnection.disconnect();
            if (zzatp != null) {
                zzatp.zzeaq.zzxa();
            }
            return zzasm4;
        } catch (IOException e) {
            String valueOf2 = String.valueOf(e.getMessage());
            zzaxz.zzeo(valueOf2.length() != 0 ? "Error while connecting to ad server: ".concat(valueOf2) : new String("Error while connecting to ad server: "));
            return new zzasm(2);
        }
    }

    private zzatq(Context context, zzatp zzatp) {
        this.mContext = context;
        this.zzeav = zzatp;
    }

    @Override // com.google.android.gms.internal.ads.zzasq
    public final zzasm zzb(zzasi zzasi) {
        return zza(this.mContext, this.zzeav, zzasi, this.zzeaw);
    }

    @Override // com.google.android.gms.internal.ads.zzasq
    public final void zza(zzasi zzasi, zzast zzast) {
        zzbv.zzlj().zzd(this.mContext, zzasi.zzbsp);
        zzbcb<?> zzc = zzayf.zzc(new zzats(this, zzasi, zzast));
        zzbv.zzlv().zzaak();
        zzbv.zzlv().getHandler().postDelayed(new zzatt(this, zzc), MyHttpServer.MINUTE_MILLIS);
    }
}
