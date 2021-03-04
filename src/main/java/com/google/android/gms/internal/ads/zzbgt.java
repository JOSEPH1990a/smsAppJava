package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.gmsg.zzu;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.zzbo;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.firebase.analytics.FirebaseAnalytics;
import fi.iki.elonen.NanoHTTPD;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

@VisibleForTesting
@zzark
@ParametersAreNonnullByDefault
final class zzbgt extends WebView implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, zzbgg {
    @GuardedBy("this")
    private boolean mIsDestroyed;
    private final zzv zzbly;
    private final zzbbi zzbob;
    private zzbas zzbuf;
    private final WindowManager zzbuv;
    private final DisplayMetrics zzbwk;
    @Nullable
    private final zzcu zzdcf;
    private int zzdqf = -1;
    private int zzdqg = -1;
    private int zzdqi = -1;
    private int zzdqj = -1;
    private final zzum zzdvr;
    @GuardedBy("this")
    private Boolean zzeiy;
    @GuardedBy("this")
    private String zzetu = "";
    private zzaay zzetv;
    private final zzbhs zzezf;
    private final zzbo zzezg;
    private final float zzezh;
    private boolean zzezi = false;
    private boolean zzezj = false;
    private zzbgh zzezk;
    @GuardedBy("this")
    private zzd zzezl;
    @GuardedBy("this")
    private IObjectWrapper zzezm;
    @GuardedBy("this")
    private zzbht zzezn;
    @GuardedBy("this")
    private boolean zzezo;
    @GuardedBy("this")
    private boolean zzezp;
    @GuardedBy("this")
    private boolean zzezq;
    @GuardedBy("this")
    private int zzezr;
    @GuardedBy("this")
    private boolean zzezs = true;
    @GuardedBy("this")
    private boolean zzezt = false;
    @GuardedBy("this")
    private zzbgw zzezu;
    @GuardedBy("this")
    private boolean zzezv;
    @GuardedBy("this")
    private boolean zzezw;
    @GuardedBy("this")
    private zzacb zzezx;
    @GuardedBy("this")
    private int zzezy;
    @GuardedBy("this")
    private int zzezz;
    private zzaay zzfaa;
    private zzaay zzfab;
    private zzaaz zzfac;
    private WeakReference<View.OnClickListener> zzfad;
    @GuardedBy("this")
    private zzd zzfae;
    @GuardedBy("this")
    private boolean zzfaf;
    private Map<String, zzbfk> zzfag;
    @GuardedBy("this")
    private String zzvv;

    static zzbgt zzb(Context context, zzbht zzbht, String str, boolean z, boolean z2, @Nullable zzcu zzcu, zzbbi zzbbi, zzaba zzaba, zzbo zzbo, zzv zzv, zzum zzum) {
        return new zzbgt(new zzbhs(context), zzbht, str, z, z2, zzcu, zzbbi, zzaba, zzbo, zzv, zzum);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbhm
    public final View getView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final WebView getWebView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbdz
    public final zzbdq zzabt() {
        return null;
    }

    @VisibleForTesting
    private zzbgt(zzbhs zzbhs, zzbht zzbht, String str, boolean z, boolean z2, @Nullable zzcu zzcu, zzbbi zzbbi, zzaba zzaba, zzbo zzbo, zzv zzv, zzum zzum) {
        super(zzbhs);
        this.zzezf = zzbhs;
        this.zzezn = zzbht;
        this.zzvv = str;
        this.zzezp = z;
        this.zzezr = -1;
        this.zzdcf = zzcu;
        this.zzbob = zzbbi;
        this.zzezg = zzbo;
        this.zzbly = zzv;
        this.zzbuv = (WindowManager) getContext().getSystemService("window");
        zzbv.zzlf();
        this.zzbwk = zzayh.zza(this.zzbuv);
        this.zzezh = this.zzbwk.density;
        this.zzdvr = zzum;
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException e) {
            zzaxz.zzb("Unable to enable Javascript.", e);
        }
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(2);
        }
        zzbv.zzlf().zza(zzbhs, zzbbi.zzdp, settings);
        zzbv.zzlh().zza(getContext(), settings);
        setDownloadListener(this);
        zzaer();
        if (PlatformVersion.isAtLeastJellyBeanMR1()) {
            addJavascriptInterface(zzbgz.zzk(this), "googleAdsJsInterface");
        }
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        this.zzbuf = new zzbas(this.zzezf.zzabw(), this, this, null);
        zzaev();
        this.zzfac = new zzaaz(new zzaba(true, "make_wv", this.zzvv));
        this.zzfac.zzrf().zzc(zzaba);
        this.zzetv = zzaat.zzb(this.zzfac.zzrf());
        this.zzfac.zza("native:view_create", this.zzetv);
        this.zzfab = null;
        this.zzfaa = null;
        zzbv.zzlh().zzaz(zzbhs);
        zzbv.zzlj().zzyn();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzbgh) {
            this.zzezk = (zzbgh) webViewClient;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbdz
    public final zzv zzid() {
        return this.zzbly;
    }

    private final boolean zzaeo() {
        int i;
        int i2;
        boolean z = false;
        if (!this.zzezk.zzmu() && !this.zzezk.zzaeb()) {
            return false;
        }
        zzwu.zzpv();
        DisplayMetrics displayMetrics = this.zzbwk;
        int zzb = zzbat.zzb(displayMetrics, displayMetrics.widthPixels);
        zzwu.zzpv();
        DisplayMetrics displayMetrics2 = this.zzbwk;
        int zzb2 = zzbat.zzb(displayMetrics2, displayMetrics2.heightPixels);
        Activity zzabw = this.zzezf.zzabw();
        if (zzabw == null || zzabw.getWindow() == null) {
            i2 = zzb;
            i = zzb2;
        } else {
            zzbv.zzlf();
            int[] zzg = zzayh.zzg(zzabw);
            zzwu.zzpv();
            int zzb3 = zzbat.zzb(this.zzbwk, zzg[0]);
            zzwu.zzpv();
            i = zzbat.zzb(this.zzbwk, zzg[1]);
            i2 = zzb3;
        }
        if (this.zzdqf == zzb && this.zzdqg == zzb2 && this.zzdqi == i2 && this.zzdqj == i) {
            return false;
        }
        if (!(this.zzdqf == zzb && this.zzdqg == zzb2)) {
            z = true;
        }
        this.zzdqf = zzb;
        this.zzdqg = zzb2;
        this.zzdqi = i2;
        this.zzdqj = i;
        new zzaok(this).zza(zzb, zzb2, i2, i, this.zzbwk.density, this.zzbuv.getDefaultDisplay().getRotation());
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzahu
    public final void zza(String str, Map<String, ?> map) {
        try {
            zza(str, zzbv.zzlf().zzn(map));
        } catch (JSONException unused) {
            zzaxz.zzeo("Could not convert parameters to JSON.");
        }
    }

    @Override // android.webkit.WebView
    @TargetApi(19)
    public final synchronized void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (isDestroyed()) {
            zzaxz.zzeq("#004 The webview is destroyed. Ignoring action.");
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
            }
            return;
        }
        super.evaluateJavascript(str, valueCallback);
    }

    private final synchronized void zzfc(String str) {
        if (!isDestroyed()) {
            loadUrl(str);
        } else {
            zzaxz.zzeo("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void loadUrl(String str) {
        if (!isDestroyed()) {
            try {
                super.loadUrl(str);
            } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError e) {
                zzbv.zzlj().zza(e, "AdWebViewImpl.loadUrl");
                zzaxz.zzc("Could not call loadUrl. ", e);
            }
        } else {
            zzaxz.zzeo("#004 The webview is destroyed. Ignoring action.");
        }
    }

    private final synchronized void zzfd(String str) {
        try {
            super.loadUrl(str);
        } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError | UnsatisfiedLinkError e) {
            zzbv.zzlj().zza(e, "AdWebViewImpl.loadUrlUnsafe");
            zzaxz.zzc("Could not call loadUrl. ", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void loadData(String str, String str2, String str3) {
        if (!isDestroyed()) {
            super.loadData(str, str2, str3);
        } else {
            zzaxz.zzeo("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!isDestroyed()) {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            zzaxz.zzeo("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void zzc(String str, String str2, @Nullable String str3) {
        String str4;
        if (!isDestroyed()) {
            if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcre)).booleanValue()) {
                str4 = zzbhi.zzc(str2, zzbhi.zzaex());
            } else {
                str4 = str2;
            }
            super.loadDataWithBaseURL(str, str4, NanoHTTPD.MIME_HTML, "UTF-8", str3);
            return;
        }
        zzaxz.zzeo("#004 The webview is destroyed. Ignoring action.");
    }

    @TargetApi(19)
    private final synchronized void zza(String str, ValueCallback<String> valueCallback) {
        if (!isDestroyed()) {
            evaluateJavascript(str, null);
        } else {
            zzaxz.zzeo("#004 The webview is destroyed. Ignoring action.");
        }
    }

    private final void zzfe(String str) {
        if (PlatformVersion.isAtLeastKitKat()) {
            if (zzyi() == null) {
                zzaep();
            }
            if (zzyi().booleanValue()) {
                zza(str, (ValueCallback<String>) null);
                return;
            }
            String valueOf = String.valueOf(str);
            zzfc(valueOf.length() != 0 ? "javascript:".concat(valueOf) : new String("javascript:"));
            return;
        }
        String valueOf2 = String.valueOf(str);
        zzfc(valueOf2.length() != 0 ? "javascript:".concat(valueOf2) : new String("javascript:"));
    }

    @Override // com.google.android.gms.internal.ads.zzais
    public final void zzcg(String str) {
        zzfe(str);
    }

    private final synchronized void zzaep() {
        this.zzeiy = zzbv.zzlj().zzyi();
        if (this.zzeiy == null) {
            try {
                evaluateJavascript("(function(){})()", null);
                zza((Boolean) true);
            } catch (IllegalStateException unused) {
                zza((Boolean) false);
            }
        }
    }

    @VisibleForTesting
    private final void zza(Boolean bool) {
        synchronized (this) {
            this.zzeiy = bool;
        }
        zzbv.zzlj().zza(bool);
    }

    @VisibleForTesting
    private final synchronized Boolean zzyi() {
        return this.zzeiy;
    }

    @Override // com.google.android.gms.internal.ads.zzais
    public final void zzb(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(jSONObject2).length());
        sb.append(str);
        sb.append("(");
        sb.append(jSONObject2);
        sb.append(");");
        zzfe(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzahu
    public final void zza(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("'");
        sb.append(",");
        sb.append(jSONObject2);
        sb.append(");");
        String valueOf = String.valueOf(sb.toString());
        zzaxz.zzdn(valueOf.length() != 0 ? "Dispatching AFMA event: ".concat(valueOf) : new String("Dispatching AFMA event: "));
        zzfe(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzade() {
        zzaeq();
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zzbob.zzdp);
        zza("onhide", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzdh(int i) {
        if (i == 0) {
            zzaat.zza(this.zzfac.zzrf(), this.zzetv, "aebb2");
        }
        zzaeq();
        if (this.zzfac.zzrf() != null) {
            this.zzfac.zzrf().zzg("close_type", String.valueOf(i));
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put("version", this.zzbob.zzdp);
        zza("onhide", hashMap);
    }

    private final void zzaeq() {
        zzaat.zza(this.zzfac.zzrf(), this.zzetv, "aeh2");
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzvv() {
        if (this.zzfaa == null) {
            zzaat.zza(this.zzfac.zzrf(), this.zzetv, "aes2");
            this.zzfaa = zzaat.zzb(this.zzfac.zzrf());
            this.zzfac.zza("native:view_show", this.zzfaa);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zzbob.zzdp);
        zza("onshow", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzadf() {
        HashMap hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(zzbv.zzlk().zzkk()));
        hashMap.put("app_volume", String.valueOf(zzbv.zzlk().zzkj()));
        hashMap.put("device_volume", String.valueOf(zzaza.zzbb(getContext())));
        zza("volume", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbdz
    public final void zza(boolean z, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put(FirebaseAnalytics.Param.SUCCESS, z ? "1" : "0");
        hashMap.put("duration", Long.toString(j));
        zza("onCacheAccessComplete", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized zzd zzadh() {
        return this.zzezl;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized IObjectWrapper zzadp() {
        return this.zzezm;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized zzd zzadi() {
        return this.zzfae;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbhj
    public final synchronized zzbht zzadj() {
        return this.zzezn;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized String zzadk() {
        return this.zzvv;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final WebViewClient zzadm() {
        return this.zzezk;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized boolean zzadn() {
        return this.zzezo;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbhk
    public final zzcu zzado() {
        return this.zzdcf;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbdz, com.google.android.gms.internal.ads.zzbhl
    public final zzbbi zzabz() {
        return this.zzbob;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbhd
    public final synchronized boolean zzadq() {
        return this.zzezp;
    }

    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            zzbv.zzlf();
            zzayh.zza(getContext(), intent);
        } catch (ActivityNotFoundException unused) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(str4).length());
            sb.append("Couldn't find an Activity to view url/mimetype: ");
            sb.append(str);
            sb.append(" / ");
            sb.append(str4);
            zzaxz.zzdn(sb.toString());
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.zzezk.zzaeb()) {
            synchronized (this) {
                if (this.zzezx != null) {
                    this.zzezx.zzc(motionEvent);
                }
            }
        } else {
            zzcu zzcu = this.zzdcf;
            if (zzcu != null) {
                zzcu.zza(motionEvent);
            }
        }
        if (isDestroyed()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue = motionEvent.getAxisValue(9);
        float axisValue2 = motionEvent.getAxisValue(10);
        if (motionEvent.getActionMasked() == 8) {
            if (axisValue > 0.0f && !canScrollVertically(-1)) {
                return false;
            }
            if (axisValue < 0.0f && !canScrollVertically(1)) {
                return false;
            }
            if (axisValue2 > 0.0f && !canScrollHorizontally(-1)) {
                return false;
            }
            if (axisValue2 < 0.0f && !canScrollHorizontally(1)) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0164, code lost:
        if (r2 != false) goto L_0x0168;
     */
    @android.annotation.SuppressLint({"DrawAllocation"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void onMeasure(int r8, int r9) {
        /*
        // Method dump skipped, instructions count: 514
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbgt.onMeasure(int, int):void");
    }

    public final void onGlobalLayout() {
        boolean zzaeo = zzaeo();
        zzd zzadh = zzadh();
        if (zzadh != null && zzaeo) {
            zzadh.zzvu();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void zza(zzd zzd) {
        this.zzezl = zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void zzaa(IObjectWrapper iObjectWrapper) {
        this.zzezm = iObjectWrapper;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void zzb(zzd zzd) {
        this.zzfae = zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void zza(zzbht zzbht) {
        this.zzezn = zzbht;
        requestLayout();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void zzav(boolean z) {
        boolean z2 = z != this.zzezp;
        this.zzezp = z;
        zzaer();
        if (z2) {
            new zzaok(this).zzdc(z ? "expanded" : "default");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzadv() {
        this.zzbuf.zzaam();
    }

    /* access modifiers changed from: protected */
    public final synchronized void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isDestroyed()) {
            this.zzbuf.onAttachedToWindow();
        }
        boolean z = this.zzezv;
        if (this.zzezk != null && this.zzezk.zzaeb()) {
            if (!this.zzezw) {
                ViewTreeObserver.OnGlobalLayoutListener zzaec = this.zzezk.zzaec();
                if (zzaec != null) {
                    zzbv.zzme();
                    zzbct.zza(this, zzaec);
                }
                ViewTreeObserver.OnScrollChangedListener zzaed = this.zzezk.zzaed();
                if (zzaed != null) {
                    zzbv.zzme();
                    zzbct.zza(this, zzaed);
                }
                this.zzezw = true;
            }
            zzaeo();
            z = true;
        }
        zzaz(z);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        synchronized (this) {
            if (!isDestroyed()) {
                this.zzbuf.onDetachedFromWindow();
            }
            super.onDetachedFromWindow();
            if (this.zzezw && this.zzezk != null && this.zzezk.zzaeb() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                ViewTreeObserver.OnGlobalLayoutListener zzaec = this.zzezk.zzaec();
                if (zzaec != null) {
                    zzbv.zzlh().zza(getViewTreeObserver(), zzaec);
                }
                ViewTreeObserver.OnScrollChangedListener zzaed = this.zzezk.zzaed();
                if (zzaed != null) {
                    getViewTreeObserver().removeOnScrollChangedListener(zzaed);
                }
                this.zzezw = false;
            }
        }
        zzaz(false);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzbo(Context context) {
        this.zzezf.setBaseContext(context);
        this.zzbuf.zzj(this.zzezf.zzabw());
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void zzaf(boolean z) {
        if (this.zzezl != null) {
            this.zzezl.zza(this.zzezk.zzmu(), z);
        } else {
            this.zzezo = z;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized int getRequestedOrientation() {
        return this.zzezr;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void setRequestedOrientation(int i) {
        this.zzezr = i;
        if (this.zzezl != null) {
            this.zzezl.setRequestedOrientation(this.zzezr);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbdz, com.google.android.gms.internal.ads.zzbhc
    public final Activity zzabw() {
        return this.zzezf.zzabw();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final Context zzadg() {
        return this.zzezf.zzadg();
    }

    private final synchronized void zzaer() {
        if (!this.zzezp) {
            if (!this.zzezn.zzafb()) {
                if (Build.VERSION.SDK_INT < 18) {
                    zzaxz.zzdn("Disabling hardware acceleration on an AdView.");
                    zzaes();
                    return;
                }
                zzaxz.zzdn("Enabling hardware acceleration on an AdView.");
                zzaet();
                return;
            }
        }
        zzaxz.zzdn("Enabling hardware acceleration on an overlay.");
        zzaet();
    }

    private final synchronized void zzaes() {
        if (!this.zzezq) {
            zzbv.zzlh().zzaa(this);
        }
        this.zzezq = true;
    }

    private final synchronized void zzaet() {
        if (this.zzezq) {
            zzbv.zzlh().zzz(this);
        }
        this.zzezq = false;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void destroy() {
        zzaev();
        this.zzbuf.zzaan();
        if (this.zzezl != null) {
            this.zzezl.close();
            this.zzezl.onDestroy();
            this.zzezl = null;
        }
        this.zzezm = null;
        this.zzezk.reset();
        if (!this.mIsDestroyed) {
            zzbv.zzmd();
            zzbfj.zzc(this);
            zzaeu();
            this.mIsDestroyed = true;
            zzaxz.v("Initiating WebView self destruct sequence in 3...");
            zzaxz.v("Loading blank page in WebView, 2...");
            zzfd("about:blank");
        }
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public final void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (!this.mIsDestroyed) {
                    this.zzezk.reset();
                    zzbv.zzmd();
                    zzbfj.zzc(this);
                    zzaeu();
                    zzyo();
                }
            }
        } finally {
            super.finalize();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void zzadr() {
        zzaxz.v("Destroying WebView!");
        zzyo();
        zzayh.zzelc.post(new zzbgv(this));
    }

    private final synchronized void zzyo() {
        if (!this.zzfaf) {
            this.zzfaf = true;
            zzbv.zzlj().zzyo();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized boolean isDestroyed() {
        return this.mIsDestroyed;
    }

    /* access modifiers changed from: protected */
    @TargetApi(21)
    public final void onDraw(Canvas canvas) {
        if (!isDestroyed()) {
            if (Build.VERSION.SDK_INT != 21 || !canvas.isHardwareAccelerated() || isAttachedToWindow()) {
                super.onDraw(canvas);
                zzbgh zzbgh = this.zzezk;
                if (zzbgh != null && zzbgh.zzael() != null) {
                    this.zzezk.zzael().zzjw();
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzadw() {
        if (this.zzfab == null) {
            this.zzfab = zzaat.zzb(this.zzfac.zzrf());
            this.zzfac.zza("native:view_load", this.zzfab);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void onPause() {
        if (!isDestroyed()) {
            try {
                super.onPause();
            } catch (Exception e) {
                zzaxz.zzb("Could not pause webview.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void onResume() {
        if (!isDestroyed()) {
            try {
                super.onResume();
            } catch (Exception e) {
                zzaxz.zzb("Could not resume webview.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzadz() {
        zzaxz.v("Cannot add text view to inner AdWebView");
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzay(boolean z) {
        this.zzezk.zzay(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void stopLoading() {
        if (!isDestroyed()) {
            try {
                super.stopLoading();
            } catch (Exception e) {
                zzaxz.zzb("Could not stop loading webview.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void zzaw(boolean z) {
        this.zzezs = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized boolean zzads() {
        return this.zzezs;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized boolean zzadt() {
        return this.zzezt;
    }

    @Override // com.google.android.gms.ads.internal.zzbo
    public final synchronized void zzjf() {
        this.zzezt = true;
        if (this.zzezg != null) {
            this.zzezg.zzjf();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzbo
    public final synchronized void zzjg() {
        this.zzezt = false;
        if (this.zzezg != null) {
            this.zzezg.zzjg();
        }
    }

    private final synchronized void zzaeu() {
        if (this.zzfag != null) {
            for (zzbfk zzbfk : this.zzfag.values()) {
                zzbfk.release();
            }
        }
        this.zzfag = null;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbdz
    public final synchronized void zza(String str, zzbfk zzbfk) {
        if (this.zzfag == null) {
            this.zzfag = new HashMap();
        }
        this.zzfag.put(str, zzbfk);
    }

    @Override // com.google.android.gms.internal.ads.zzbdz
    public final synchronized zzbfk zzet(String str) {
        if (this.zzfag == null) {
            return null;
        }
        return this.zzfag.get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void zzfb(String str) {
        if (str == null) {
            str = "";
        }
        this.zzetu = str;
    }

    @Override // com.google.android.gms.internal.ads.zzbdz
    public final synchronized String zzabx() {
        return this.zzetu;
    }

    @Override // com.google.android.gms.internal.ads.zzbdz
    public final synchronized void zzacc() {
    }

    @Override // com.google.android.gms.internal.ads.zzbdz
    public final zzaay zzabv() {
        return this.zzetv;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbdz
    public final zzaaz zzaby() {
        return this.zzfac;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zzfad = new WeakReference<>(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final View.OnClickListener getOnClickListener() {
        return this.zzfad.get();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void zzb(zzacb zzacb) {
        this.zzezx = zzacb;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized zzacb zzadx() {
        return this.zzezx;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbdz
    public final synchronized zzbgw zzabu() {
        return this.zzezu;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbdz
    public final synchronized void zza(zzbgw zzbgw) {
        if (this.zzezu != null) {
            zzaxz.e("Attempt to create multiple AdWebViewVideoControllers.");
        } else {
            this.zzezu = zzbgw;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized boolean zzadu() {
        return this.zzezy > 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void zzax(boolean z) {
        this.zzezy += z ? 1 : -1;
        if (this.zzezy <= 0 && this.zzezl != null) {
            this.zzezl.zzvx();
        }
    }

    private final void zzaev() {
        zzaba zzrf;
        zzaaz zzaaz = this.zzfac;
        if (zzaaz != null && (zzrf = zzaaz.zzrf()) != null && zzbv.zzlj().zzyh() != null) {
            zzbv.zzlj().zzyh().zza(zzrf);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzady() {
        setBackgroundColor(0);
    }

    @Override // com.google.android.gms.internal.ads.zzbdz
    public final void zzat(boolean z) {
        this.zzezk.zzat(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbdz
    public final void zzvw() {
        zzd zzadh = zzadh();
        if (zzadh != null) {
            zzadh.zzvw();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdz
    public final int zzaca() {
        return getMeasuredHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzbdz
    public final int zzacb() {
        return getMeasuredWidth();
    }

    @Override // com.google.android.gms.internal.ads.zzbhh
    public final void zza(zzc zzc) {
        this.zzezk.zza(zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzbhh
    public final void zzb(boolean z, int i) {
        this.zzezk.zzb(z, i);
    }

    @Override // com.google.android.gms.internal.ads.zzbhh
    public final void zza(boolean z, int i, String str) {
        this.zzezk.zza(z, i, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbhh
    public final void zza(boolean z, int i, String str, String str2) {
        this.zzezk.zza(z, i, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzsg
    public final void zza(zzsf zzsf) {
        synchronized (this) {
            this.zzezv = zzsf.zzuc;
        }
        zzaz(zzsf.zzuc);
    }

    private final void zzaz(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : "0");
        zza("onAdVisibilityChanged", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zza(String str, zzu<? super zzbgg> zzu) {
        zzbgh zzbgh = this.zzezk;
        if (zzbgh != null) {
            zzbgh.zza(str, zzu);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzb(String str, zzu<? super zzbgg> zzu) {
        zzbgh zzbgh = this.zzezk;
        if (zzbgh != null) {
            zzbgh.zzb(str, zzu);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zza(String str, Predicate<zzu<? super zzbgg>> predicate) {
        zzbgh zzbgh = this.zzezk;
        if (zzbgh != null) {
            zzbgh.zza(str, predicate);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final /* synthetic */ zzbhn zzadl() {
        return this.zzezk;
    }
}
