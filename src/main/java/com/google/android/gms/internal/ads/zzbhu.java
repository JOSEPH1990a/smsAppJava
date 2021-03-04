package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.gmsg.zza;
import com.google.android.gms.ads.internal.gmsg.zzaa;
import com.google.android.gms.ads.internal.gmsg.zzab;
import com.google.android.gms.ads.internal.gmsg.zzac;
import com.google.android.gms.ads.internal.gmsg.zzb;
import com.google.android.gms.ads.internal.gmsg.zzc;
import com.google.android.gms.ads.internal.gmsg.zzd;
import com.google.android.gms.ads.internal.gmsg.zzf;
import com.google.android.gms.ads.internal.gmsg.zzu;
import com.google.android.gms.ads.internal.gmsg.zzx;
import com.google.android.gms.ads.internal.gmsg.zzy;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@VisibleForTesting
@zzark
@ParametersAreNonnullByDefault
public final class zzbhu extends zzbie implements zzbhn {
    private final Object mLock = new Object();
    @Nullable
    private zzawr zzbmx;
    private zzvt zzciw;
    private zzb zzder;
    private zzd zzdes;
    private zzw zzdgb;
    private zzaoa zzdgc;
    private zzbgg zzdin;
    private boolean zzdzf;
    private zzn zzexw;
    private zzbho zzexx;
    private zzbhp zzexy;
    private zzbhq zzexz;
    private boolean zzeya = false;
    @GuardedBy("mLock")
    private boolean zzeyb;
    @GuardedBy("mLock")
    private ViewTreeObserver.OnGlobalLayoutListener zzeyc;
    @GuardedBy("mLock")
    private ViewTreeObserver.OnScrollChangedListener zzeyd;
    @GuardedBy("mLock")
    private boolean zzeye;
    private zzt zzeyf;
    private zzaoj zzeyg;
    private zzbhr zzeyh;
    private boolean zzeyi;
    private boolean zzeyj;
    private int zzeyk;
    private View.OnAttachStateChangeListener zzeyl;
    private final zzaig<zzbgg> zzfav = new zzaig<>();
    private volatile boolean zzfaw;

    /* access modifiers changed from: package-private */
    public final void zzb(zzbgg zzbgg, boolean z) {
        zzaoj zzaoj = new zzaoj(zzbgg, zzbgg.zzadg(), new zzzy(zzbgg.getContext()));
        this.zzdin = zzbgg;
        this.zzfaw = z;
        this.zzeyg = zzaoj;
        this.zzdgc = null;
        this.zzfav.zzi(zzbgg);
    }

    @Override // com.google.android.gms.internal.ads.zzbhn
    public final void zza(int i, int i2, boolean z) {
        this.zzeyg.zzj(i, i2);
        zzaoa zzaoa = this.zzdgc;
        if (zzaoa != null) {
            zzaoa.zza(i, i2, z);
        }
    }

    public final void zza(String str, zzu<? super zzbgg> zzu) {
        this.zzfav.zza(str, zzu);
    }

    public final void zzb(String str, zzu<? super zzbgg> zzu) {
        this.zzfav.zzb(str, zzu);
    }

    public final void zza(String str, Predicate<zzu<? super zzbgg>> predicate) {
        this.zzfav.zza(str, predicate);
    }

    @Override // com.google.android.gms.internal.ads.zzbhn
    public final void zza(zzvt zzvt, zzb zzb, zzn zzn, zzd zzd, zzt zzt, boolean z, @Nullable zzy zzy, zzw zzw, zzaol zzaol, @Nullable zzawr zzawr) {
        if (zzw == null) {
            zzw = new zzw(this.zzdin.getContext(), zzawr, null);
        }
        this.zzdgc = new zzaoa(this.zzdin, zzaol);
        this.zzbmx = zzawr;
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcrk)).booleanValue()) {
            zza("/adMetadata", new zza(zzb));
        }
        zza("/appEvent", new zzc(zzd));
        zza("/backButton", zzf.zzdfc);
        zza("/refresh", zzf.zzdfd);
        zza("/canOpenURLs", zzf.zzdet);
        zza("/canOpenIntents", zzf.zzdeu);
        zza("/click", zzf.zzdev);
        zza("/close", zzf.zzdew);
        zza("/customClose", zzf.zzdex);
        zza("/instrument", zzf.zzdfg);
        zza("/delayPageLoaded", zzf.zzdfi);
        zza("/delayPageClosed", zzf.zzdfj);
        zza("/getLocationInfo", zzf.zzdfk);
        zza("/httpTrack", zzf.zzdey);
        zza("/log", zzf.zzdez);
        zza("/mraid", new zzab(zzw, this.zzdgc, zzaol));
        zza("/mraidLoaded", this.zzeyg);
        zza("/open", new zzac(zzw, this.zzdgc));
        zza("/precache", new zzbfq());
        zza("/touch", zzf.zzdfb);
        zza("/video", zzf.zzdfe);
        zza("/videoMeta", zzf.zzdff);
        if (zzbv.zzmf().zzv(this.zzdin.getContext())) {
            zza("/logScionEvent", new zzaa(this.zzdin.getContext()));
        }
        if (zzy != null) {
            zza("/setInterstitialProperties", new zzx(zzy));
        }
        this.zzciw = zzvt;
        this.zzexw = zzn;
        this.zzder = zzb;
        this.zzdes = zzd;
        this.zzeyf = zzt;
        this.zzdgb = zzw;
        this.zzeya = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbhn
    public final zzw zzaea() {
        return this.zzdgb;
    }

    @Override // com.google.android.gms.internal.ads.zzbhn
    public final boolean zzmu() {
        return this.zzfaw;
    }

    public final boolean zzaeb() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzeyb;
        }
        return z;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener zzaec() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
        synchronized (this.mLock) {
            onGlobalLayoutListener = this.zzeyc;
        }
        return onGlobalLayoutListener;
    }

    public final ViewTreeObserver.OnScrollChangedListener zzaed() {
        ViewTreeObserver.OnScrollChangedListener onScrollChangedListener;
        synchronized (this.mLock) {
            onScrollChangedListener = this.zzeyd;
        }
        return onScrollChangedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzbhn
    public final boolean zzaee() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzeye;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzbie
    public final void zza(zzbif zzbif) {
        this.zzeyi = true;
        zzbhp zzbhp = this.zzexy;
        if (zzbhp != null) {
            zzbhp.zzuc();
            this.zzexy = null;
        }
        zzaek();
    }

    /* access modifiers changed from: private */
    public final void zza(View view, zzawr zzawr, int i) {
        if (zzawr.zzxq() && i > 0) {
            zzawr.zzs(view);
            if (zzawr.zzxq()) {
                zzayh.zzelc.postDelayed(new zzbhw(this, view, zzawr, i), 100);
            }
        }
    }

    private final void zzaef() {
        if (this.zzeyl != null) {
            this.zzdin.getView().removeOnAttachStateChangeListener(this.zzeyl);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhn
    public final void zzaeg() {
        zzawr zzawr = this.zzbmx;
        if (zzawr != null) {
            WebView webView = this.zzdin.getWebView();
            if (ViewCompat.isAttachedToWindow(webView)) {
                zza(webView, zzawr, 10);
                return;
            }
            zzaef();
            this.zzeyl = new zzbhx(this, zzawr);
            this.zzdin.getView().addOnAttachStateChangeListener(this.zzeyl);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhn
    public final void zzaeh() {
        synchronized (this.mLock) {
            this.zzeye = true;
        }
        this.zzeyk++;
        zzaek();
    }

    @Override // com.google.android.gms.internal.ads.zzbhn
    public final void zzaei() {
        this.zzeyk--;
        zzaek();
    }

    @Override // com.google.android.gms.internal.ads.zzbhn
    public final void zzaej() {
        this.zzeyj = true;
        zzaek();
    }

    private final void zzaek() {
        if (this.zzexx != null && ((this.zzeyi && this.zzeyk <= 0) || this.zzeyj)) {
            this.zzexx.zzp(!this.zzeyj);
            this.zzexx = null;
        }
        this.zzdin.zzadw();
    }

    public final void zza(com.google.android.gms.ads.internal.overlay.zzc zzc) {
        zzn zzn;
        boolean zzadq = this.zzdin.zzadq();
        zzvt zzvt = (!zzadq || this.zzdin.zzadj().zzafb()) ? this.zzciw : null;
        if (zzadq) {
            zzn = null;
        } else {
            zzn = this.zzexw;
        }
        zza(new AdOverlayInfoParcel(zzc, zzvt, zzn, this.zzeyf, this.zzdin.zzabz()));
    }

    public final void zzb(boolean z, int i) {
        zzvt zzvt = (!this.zzdin.zzadq() || this.zzdin.zzadj().zzafb()) ? this.zzciw : null;
        zzn zzn = this.zzexw;
        zzt zzt = this.zzeyf;
        zzbgg zzbgg = this.zzdin;
        zza(new AdOverlayInfoParcel(zzvt, zzn, zzt, zzbgg, z, i, zzbgg.zzabz()));
    }

    public final void zza(boolean z, int i, String str) {
        zzbhy zzbhy;
        boolean zzadq = this.zzdin.zzadq();
        zzvt zzvt = (!zzadq || this.zzdin.zzadj().zzafb()) ? this.zzciw : null;
        if (zzadq) {
            zzbhy = null;
        } else {
            zzbhy = new zzbhy(this.zzdin, this.zzexw);
        }
        zzb zzb = this.zzder;
        zzd zzd = this.zzdes;
        zzt zzt = this.zzeyf;
        zzbgg zzbgg = this.zzdin;
        zza(new AdOverlayInfoParcel(zzvt, zzbhy, zzb, zzd, zzt, zzbgg, z, i, str, zzbgg.zzabz()));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        zzbhy zzbhy;
        boolean zzadq = this.zzdin.zzadq();
        zzvt zzvt = (!zzadq || this.zzdin.zzadj().zzafb()) ? this.zzciw : null;
        if (zzadq) {
            zzbhy = null;
        } else {
            zzbhy = new zzbhy(this.zzdin, this.zzexw);
        }
        zzb zzb = this.zzder;
        zzd zzd = this.zzdes;
        zzt zzt = this.zzeyf;
        zzbgg zzbgg = this.zzdin;
        zza(new AdOverlayInfoParcel(zzvt, zzbhy, zzb, zzd, zzt, zzbgg, z, i, str, str2, zzbgg.zzabz()));
    }

    private final void zza(AdOverlayInfoParcel adOverlayInfoParcel) {
        zzaoa zzaoa = this.zzdgc;
        boolean z = false;
        boolean zzvm = zzaoa != null ? zzaoa.zzvm() : false;
        zzbv.zzld();
        Context context = this.zzdin.getContext();
        if (!zzvm) {
            z = true;
        }
        zzl.zza(context, adOverlayInfoParcel, z);
        if (this.zzbmx != null) {
            String str = adOverlayInfoParcel.url;
            if (str == null && adOverlayInfoParcel.zzdrs != null) {
                str = adOverlayInfoParcel.zzdrs.url;
            }
            this.zzbmx.zzdi(str);
        }
    }

    public final void destroy() {
        zzawr zzawr = this.zzbmx;
        if (zzawr != null) {
            zzawr.zzxs();
            this.zzbmx = null;
        }
        zzaef();
        this.zzfav.reset();
        this.zzfav.zzi(null);
        synchronized (this.mLock) {
            this.zzciw = null;
            this.zzexw = null;
            this.zzexx = null;
            this.zzexy = null;
            this.zzder = null;
            this.zzdes = null;
            this.zzeyf = null;
            this.zzexz = null;
            if (this.zzdgc != null) {
                this.zzdgc.zzx(true);
                this.zzdgc = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhn
    public final void zza(zzbho zzbho) {
        this.zzexx = zzbho;
    }

    @Override // com.google.android.gms.internal.ads.zzbhn
    public final void zza(zzbhp zzbhp) {
        this.zzexy = zzbhp;
    }

    @Override // com.google.android.gms.internal.ads.zzbhn
    public final void zza(zzbhq zzbhq) {
        this.zzexz = zzbhq;
    }

    @Override // com.google.android.gms.internal.ads.zzbhn
    public final void zza(zzbhr zzbhr) {
        this.zzeyh = zzbhr;
    }

    public final zzbhr zzael() {
        return this.zzeyh;
    }

    @Override // com.google.android.gms.internal.ads.zzbie
    public final void zzb(zzbif zzbif) {
        this.zzfav.zzf(zzbif.uri);
    }

    @Override // com.google.android.gms.internal.ads.zzbie
    public final boolean zzc(zzbif zzbif) {
        String valueOf = String.valueOf(zzbif.url);
        zzaxz.v(valueOf.length() != 0 ? "AdWebView shouldOverrideUrlLoading: ".concat(valueOf) : new String("AdWebView shouldOverrideUrlLoading: "));
        Uri uri = zzbif.uri;
        if (this.zzfav.zzf(uri)) {
            return true;
        }
        if (this.zzeya) {
            String scheme = uri.getScheme();
            if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                zzvt zzvt = this.zzciw;
                if (zzvt != null) {
                    zzvt.onAdClicked();
                    zzawr zzawr = this.zzbmx;
                    if (zzawr != null) {
                        zzawr.zzdi(zzbif.url);
                    }
                    this.zzciw = null;
                }
                return false;
            }
        }
        if (!this.zzdin.getWebView().willNotDraw()) {
            try {
                zzcu zzado = this.zzdin.zzado();
                if (zzado != null && zzado.zzb(uri)) {
                    uri = zzado.zza(uri, this.zzdin.getContext(), this.zzdin.getView(), this.zzdin.zzabw());
                }
            } catch (zzcv unused) {
                String valueOf2 = String.valueOf(zzbif.url);
                zzaxz.zzeo(valueOf2.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf2) : new String("Unable to append parameter to URL: "));
            }
            zzw zzw = this.zzdgb;
            if (zzw == null || zzw.zzju()) {
                zza(new com.google.android.gms.ads.internal.overlay.zzc("android.intent.action.VIEW", uri.toString(), null, null, null, null, null));
            } else {
                this.zzdgb.zzas(zzbif.url);
            }
        } else {
            String valueOf3 = String.valueOf(zzbif.url);
            zzaxz.zzeo(valueOf3.length() != 0 ? "AdWebView unable to handle URL: ".concat(valueOf3) : new String("AdWebView unable to handle URL: "));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbie
    @Nullable
    public final WebResourceResponse zzd(zzbif zzbif) {
        WebResourceResponse webResourceResponse;
        zztv zza;
        String str;
        zzawr zzawr = this.zzbmx;
        if (zzawr != null) {
            zzawr.zza(zzbif.url, zzbif.zzab, 1);
        }
        if (!"mraid.js".equalsIgnoreCase(new File(zzbif.url).getName())) {
            webResourceResponse = null;
        } else {
            zzvr();
            if (this.zzdin.zzadj().zzafb()) {
                str = (String) zzwu.zzpz().zzd(zzaan.zzcpt);
            } else if (this.zzdin.zzadq()) {
                str = (String) zzwu.zzpz().zzd(zzaan.zzcps);
            } else {
                str = (String) zzwu.zzpz().zzd(zzaan.zzcpr);
            }
            zzbv.zzlf();
            webResourceResponse = zzayh.zze(this.zzdin.getContext(), this.zzdin.zzabz().zzdp, str);
        }
        if (webResourceResponse != null) {
            return webResourceResponse;
        }
        try {
            if (!zzawz.zzb(zzbif.url, this.zzdin.getContext(), this.zzdzf).equals(zzbif.url)) {
                return zze(zzbif);
            }
            zzty zzbb = zzty.zzbb(zzbif.url);
            if (zzbb != null && (zza = zzbv.zzll().zza(zzbb)) != null && zza.zzoe()) {
                return new WebResourceResponse("", "", zza.zzof());
            }
            if (zzbax.isEnabled()) {
                if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcso)).booleanValue()) {
                    return zze(zzbif);
                }
            }
            return null;
        } catch (Exception | NoClassDefFoundError e) {
            zzbv.zzlj().zza(e, "AdWebViewClient.interceptRequest");
            return null;
        }
    }

    private final WebResourceResponse zze(zzbif zzbif) throws IOException {
        HttpURLConnection httpURLConnection;
        URL url = new URL(zzbif.url);
        int i = 0;
        while (true) {
            i++;
            if (i <= 20) {
                URLConnection openConnection = url.openConnection();
                openConnection.setConnectTimeout(10000);
                openConnection.setReadTimeout(10000);
                for (Map.Entry<String, String> entry : zzbif.zzab.entrySet()) {
                    openConnection.addRequestProperty(entry.getKey(), entry.getValue());
                }
                if (openConnection instanceof HttpURLConnection) {
                    httpURLConnection = (HttpURLConnection) openConnection;
                    zzbv.zzlf().zza(this.zzdin.getContext(), this.zzdin.zzabz().zzdp, false, httpURLConnection);
                    zzbax zzbax = new zzbax();
                    zzbax.zza(httpURLConnection, (byte[]) null);
                    int responseCode = httpURLConnection.getResponseCode();
                    zzbax.zza(httpURLConnection, responseCode);
                    if (responseCode < 300 || responseCode >= 400) {
                        zzbv.zzlf();
                    } else {
                        String headerField = httpURLConnection.getHeaderField("Location");
                        if (headerField != null) {
                            URL url2 = new URL(url, headerField);
                            String protocol = url2.getProtocol();
                            if (protocol == null) {
                                zzaxz.zzeo("Protocol is null");
                                return null;
                            } else if (protocol.equals("http") || protocol.equals("https")) {
                                String valueOf = String.valueOf(headerField);
                                zzaxz.zzdn(valueOf.length() != 0 ? "Redirecting to ".concat(valueOf) : new String("Redirecting to "));
                                httpURLConnection.disconnect();
                                url = url2;
                            } else {
                                String valueOf2 = String.valueOf(protocol);
                                zzaxz.zzeo(valueOf2.length() != 0 ? "Unsupported scheme: ".concat(valueOf2) : new String("Unsupported scheme: "));
                                return null;
                            }
                        } else {
                            throw new IOException("Missing Location header in redirect");
                        }
                    }
                } else {
                    throw new IOException("Invalid protocol.");
                }
            } else {
                StringBuilder sb = new StringBuilder(32);
                sb.append("Too many redirects (20)");
                throw new IOException(sb.toString());
            }
        }
        zzbv.zzlf();
        return zzayh.zzd(httpURLConnection);
    }

    public final void zzat(boolean z) {
        this.zzeya = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbhn
    public final zzawr zzaem() {
        return this.zzbmx;
    }

    @Override // com.google.android.gms.internal.ads.zzbhn
    public final void zza(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        synchronized (this.mLock) {
            this.zzeyb = true;
            this.zzdin.zzadv();
            this.zzeyc = onGlobalLayoutListener;
            this.zzeyd = onScrollChangedListener;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhn
    public final void zzvr() {
        synchronized (this.mLock) {
            this.zzeya = false;
            this.zzfaw = true;
            zzbcg.zzepo.execute(new zzbhv(this));
        }
    }

    public final void zzay(boolean z) {
        this.zzdzf = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbhn
    public final void zzi(int i, int i2) {
        zzaoa zzaoa = this.zzdgc;
        if (zzaoa != null) {
            zzaoa.zzi(i, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaen() {
        this.zzdin.zzadv();
        com.google.android.gms.ads.internal.overlay.zzd zzadh = this.zzdin.zzadh();
        if (zzadh != null) {
            zzadh.zzvr();
        }
        zzbhq zzbhq = this.zzexz;
        if (zzbhq != null) {
            zzbhq.zzjx();
            this.zzexz = null;
        }
    }
}
