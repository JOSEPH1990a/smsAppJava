package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
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
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

@VisibleForTesting
@zzark
@ParametersAreNonnullByDefault
final class zzbib extends zzbig implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, zzaic, zzbgg {
    private final zzv zzbly;
    private final zzbbi zzbob;
    private zzbas zzbuf;
    private final WindowManager zzbuv;
    @Nullable
    private final zzcu zzdcf;
    private int zzdqf = -1;
    private int zzdqg = -1;
    private int zzdqi = -1;
    private int zzdqj = -1;
    @GuardedBy("this")
    private String zzetu = "";
    private zzaay zzetv;
    private final zzbo zzezg;
    @GuardedBy("this")
    private zzd zzezl;
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
    private Map<String, zzbfk> zzfag;
    private final zzbhs zzfaz;
    private final zzbhu zzfba;
    private final AtomicReference<IObjectWrapper> zzfbb = new AtomicReference<>();
    private float zzfbc;
    @GuardedBy("this")
    private String zzvv;

    @VisibleForTesting
    protected zzbib(zzbhs zzbhs, zzbhu zzbhu, zzbht zzbht, String str, boolean z, boolean z2, @Nullable zzcu zzcu, zzbbi zzbbi, zzaba zzaba, zzbo zzbo, zzv zzv) {
        super(zzbhs, zzbhu);
        this.zzfaz = zzbhs;
        this.zzfba = zzbhu;
        this.zzezn = zzbht;
        this.zzvv = str;
        this.zzezp = z;
        this.zzezr = -1;
        this.zzdcf = zzcu;
        this.zzbob = zzbbi;
        this.zzezg = zzbo;
        this.zzbly = zzv;
        this.zzbuv = (WindowManager) getContext().getSystemService("window");
        this.zzbuf = new zzbas(this.zzfaz.zzabw(), this, this, null);
        zzbv.zzlf().zza(zzbhs, zzbbi.zzdp, getSettings());
        setDownloadListener(this);
        this.zzfbc = zzbhs.getResources().getDisplayMetrics().density;
        zzaer();
        if (PlatformVersion.isAtLeastJellyBeanMR1()) {
            addJavascriptInterface(zzbgz.zzk(this), "googleAdsJsInterface");
        }
        zzaev();
        this.zzfac = new zzaaz(new zzaba(true, "make_wv", this.zzvv));
        this.zzfac.zzrf().zzc(zzaba);
        this.zzetv = zzaat.zzb(this.zzfac.zzrf());
        this.zzfac.zza("native:view_create", this.zzetv);
        this.zzfab = null;
        this.zzfaa = null;
        zzbv.zzlh().zzaz(zzbhs);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbhm
    public final View getView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final WebView getWebView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzahu
    public final void zza(String str, Map map) {
        zzaid.zza(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzaic, com.google.android.gms.internal.ads.zzahu
    public final void zza(String str, JSONObject jSONObject) {
        zzaid.zzb(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbdz
    public final zzbdq zzabt() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbig
    public final void zzadr() {
    }

    @Override // com.google.android.gms.internal.ads.zzais
    public final void zzb(String str, JSONObject jSONObject) {
        zzaid.zza(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzaic
    public final void zzh(String str, String str2) {
        zzaid.zza(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbdz
    public final zzv zzid() {
        return this.zzbly;
    }

    private final boolean zzaeo() {
        int i;
        int i2;
        boolean z = false;
        if (!this.zzfba.zzmu() && !this.zzfba.zzaeb()) {
            return false;
        }
        zzbv.zzlf();
        DisplayMetrics zza = zzayh.zza(this.zzbuv);
        zzwu.zzpv();
        int zzb = zzbat.zzb(zza, zza.widthPixels);
        zzwu.zzpv();
        int zzb2 = zzbat.zzb(zza, zza.heightPixels);
        Activity zzabw = this.zzfaz.zzabw();
        if (zzabw == null || zzabw.getWindow() == null) {
            i2 = zzb;
            i = zzb2;
        } else {
            zzbv.zzlf();
            int[] zzg = zzayh.zzg(zzabw);
            zzwu.zzpv();
            i2 = zzbat.zzb(zza, zzg[0]);
            zzwu.zzpv();
            i = zzbat.zzb(zza, zzg[1]);
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
        new zzaok(this).zza(zzb, zzb2, i2, i, zza.density, this.zzbuv.getDefaultDisplay().getRotation());
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void zzc(String str, String str2, @Nullable String str3) {
        String str4;
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcre)).booleanValue()) {
            str4 = zzbhi.zzc(str2, zzbhi.zzaex());
        } else {
            str4 = str2;
        }
        super.loadDataWithBaseURL(str, str4, NanoHTTPD.MIME_HTML, "UTF-8", str3);
    }

    @Override // com.google.android.gms.internal.ads.zzbig, com.google.android.gms.internal.ads.zzbid, com.google.android.gms.internal.ads.zzaic, com.google.android.gms.internal.ads.zzais
    public final synchronized void zzcg(String str) {
        if (!isDestroyed()) {
            super.zzcg(str);
        } else {
            zzaxz.zzeo("The webview is destroyed. Ignoring action.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzade() {
        zzaeq();
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zzbob.zzdp);
        zzaid.zza(this, "onhide", hashMap);
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
        zzaid.zza(this, "onhide", hashMap);
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
        zzaid.zza(this, "onshow", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzadf() {
        HashMap hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(zzbv.zzlk().zzkk()));
        hashMap.put("app_volume", String.valueOf(zzbv.zzlk().zzkj()));
        hashMap.put("device_volume", String.valueOf(zzaza.zzbb(getContext())));
        zzaid.zza(this, "volume", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbdz
    public final void zza(boolean z, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put(FirebaseAnalytics.Param.SUCCESS, z ? "1" : "0");
        hashMap.put("duration", Long.toString(j));
        zzaid.zza(this, "onCacheAccessComplete", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized zzd zzadh() {
        return this.zzezl;
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final IObjectWrapper zzadp() {
        return this.zzfbb.get();
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
        return this.zzfba;
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

    @Override // com.google.android.gms.internal.ads.zzbig
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.zzfba.zzaeb()) {
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
    @SuppressLint({"DrawAllocation"})
    public final synchronized void onMeasure(int i, int i2) {
        int i3;
        if (isDestroyed()) {
            setMeasuredDimension(0, 0);
        } else if (isInEditMode() || this.zzezp || this.zzezn.zzafc()) {
            super.onMeasure(i, i2);
        } else if (this.zzezn.zzafe()) {
            super.onMeasure(i, i2);
        } else if (this.zzezn.zzafd()) {
            if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcum)).booleanValue()) {
                super.onMeasure(i, i2);
                return;
            }
            zzbgw zzabu = zzabu();
            float aspectRatio = zzabu != null ? zzabu.getAspectRatio() : 0.0f;
            if (aspectRatio == 0.0f) {
                super.onMeasure(i, i2);
                return;
            }
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            int i4 = (int) (((float) size2) * aspectRatio);
            int i5 = (int) (((float) size) / aspectRatio);
            if (size2 == 0 && i5 != 0) {
                i4 = (int) (((float) i5) * aspectRatio);
                size2 = i5;
            } else if (size == 0 && i4 != 0) {
                i5 = (int) (((float) i4) / aspectRatio);
                size = i4;
            }
            setMeasuredDimension(Math.min(i4, size), Math.min(i5, size2));
        } else if (this.zzezn.isFluid()) {
            if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcur)).booleanValue() || !PlatformVersion.isAtLeastJellyBeanMR1()) {
                super.onMeasure(i, i2);
                return;
            }
            zza("/contentHeight", new zzbic(this));
            zzcg("(function() {  var height = -1;  if (document.body) {    height = document.body.offsetHeight;  } else if (document.documentElement) {    height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  try {    window.googleAdsJsInterface.notify(url);  } catch (e) {    var frame = document.getElementById('afma-notify-fluid');    if (!frame) {      frame = document.createElement('IFRAME');      frame.id = 'afma-notify-fluid';      frame.style.display = 'none';      var body = document.body || document.documentElement;      body.appendChild(frame);    }    frame.src = url;  }})();");
            int size3 = View.MeasureSpec.getSize(i);
            if (this.zzezz != -1) {
                i3 = (int) (((float) this.zzezz) * this.zzfbc);
            } else {
                i3 = View.MeasureSpec.getSize(i2);
            }
            setMeasuredDimension(size3, i3);
        } else if (this.zzezn.zzafb()) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.zzbuv.getDefaultDisplay().getMetrics(displayMetrics);
            setMeasuredDimension(displayMetrics.widthPixels, displayMetrics.heightPixels);
        } else {
            int mode = View.MeasureSpec.getMode(i);
            int size4 = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size5 = View.MeasureSpec.getSize(i2);
            int i6 = Integer.MAX_VALUE;
            int i7 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size4 : Integer.MAX_VALUE;
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i6 = size5;
            }
            boolean z = true;
            boolean z2 = this.zzezn.widthPixels > i7 || this.zzezn.heightPixels > i6;
            if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcxk)).booleanValue()) {
                if (((float) this.zzezn.widthPixels) / this.zzfbc > ((float) i7) / this.zzfbc || ((float) this.zzezn.heightPixels) / this.zzfbc > ((float) i6) / this.zzfbc) {
                    z = false;
                }
                if (z2) {
                    z2 = z;
                }
            }
            if (z2) {
                StringBuilder sb = new StringBuilder(103);
                sb.append("Not enough space to show ad. Needs ");
                sb.append((int) (((float) this.zzezn.widthPixels) / this.zzfbc));
                sb.append("x");
                sb.append((int) (((float) this.zzezn.heightPixels) / this.zzfbc));
                sb.append(" dp, but only has ");
                sb.append((int) (((float) size4) / this.zzfbc));
                sb.append("x");
                sb.append((int) (((float) size5) / this.zzfbc));
                sb.append(" dp.");
                zzaxz.zzeo(sb.toString());
                if (getVisibility() != 8) {
                    setVisibility(4);
                }
                setMeasuredDimension(0, 0);
                return;
            }
            if (getVisibility() != 8) {
                setVisibility(0);
            }
            setMeasuredDimension(this.zzezn.widthPixels, this.zzezn.heightPixels);
        }
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
    public final void zzaa(IObjectWrapper iObjectWrapper) {
        this.zzfbb.set(iObjectWrapper);
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
        if (this.zzfba != null && this.zzfba.zzaeb()) {
            if (!this.zzezw) {
                ViewTreeObserver.OnGlobalLayoutListener zzaec = this.zzfba.zzaec();
                if (zzaec != null) {
                    zzbv.zzme();
                    zzbct.zza(this, zzaec);
                }
                ViewTreeObserver.OnScrollChangedListener zzaed = this.zzfba.zzaed();
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
            if (this.zzezw && this.zzfba != null && this.zzfba.zzaeb() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                ViewTreeObserver.OnGlobalLayoutListener zzaec = this.zzfba.zzaec();
                if (zzaec != null) {
                    zzbv.zzlh().zza(getViewTreeObserver(), zzaec);
                }
                ViewTreeObserver.OnScrollChangedListener zzaed = this.zzfba.zzaed();
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
        this.zzfaz.setBaseContext(context);
        this.zzbuf.zzj(this.zzfaz.zzabw());
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final synchronized void zzaf(boolean z) {
        if (this.zzezl != null) {
            this.zzezl.zza(this.zzfba.zzmu(), z);
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
        return this.zzfaz.zzabw();
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final Context zzadg() {
        return this.zzfaz.zzadg();
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

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbig
    public final synchronized void zzba(boolean z) {
        if (!z) {
            zzaev();
            this.zzbuf.zzaan();
            if (this.zzezl != null) {
                this.zzezl.close();
                this.zzezl.onDestroy();
                this.zzezl = null;
            }
        }
        this.zzfbb.set(null);
        this.zzfba.destroy();
        zzbv.zzmd();
        zzbfj.zzc(this);
        zzaeu();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbig
    @TargetApi(21)
    public final void onDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT != 21 || !canvas.isHardwareAccelerated() || isAttachedToWindow()) {
            super.onDraw(canvas);
            zzbhu zzbhu = this.zzfba;
            if (zzbhu != null && zzbhu.zzael() != null) {
                this.zzfba.zzael().zzjw();
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

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbig
    public final void onPause() {
        try {
            super.onPause();
        } catch (Exception e) {
            zzaxz.zzb("Could not pause webview.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbig
    public final void onResume() {
        try {
            super.onResume();
        } catch (Exception e) {
            zzaxz.zzb("Could not resume webview.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzadz() {
        zzaxz.v("Cannot add text view to inner AdWebView");
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzay(boolean z) {
        this.zzfba.zzay(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg, com.google.android.gms.internal.ads.zzbig
    public final void stopLoading() {
        try {
            super.stopLoading();
        } catch (Exception e) {
            zzaxz.zzb("Could not stop loading webview.", e);
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

    @Override // com.google.android.gms.internal.ads.zzbdz
    public final synchronized void zzacc() {
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
        this.zzfba.zzat(z);
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
        this.zzfba.zza(zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzbhh
    public final void zzb(boolean z, int i) {
        this.zzfba.zzb(z, i);
    }

    @Override // com.google.android.gms.internal.ads.zzbhh
    public final void zza(boolean z, int i, String str) {
        this.zzfba.zza(z, i, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbhh
    public final void zza(boolean z, int i, String str, String str2) {
        this.zzfba.zza(z, i, str, str2);
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
        zzaid.zza(this, "onAdVisibilityChanged", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zza(String str, zzu<? super zzbgg> zzu) {
        zzbhu zzbhu = this.zzfba;
        if (zzbhu != null) {
            zzbhu.zza(str, zzu);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zzb(String str, zzu<? super zzbgg> zzu) {
        zzbhu zzbhu = this.zzfba;
        if (zzbhu != null) {
            zzbhu.zzb(str, zzu);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final void zza(String str, Predicate<zzu<? super zzbgg>> predicate) {
        zzbhu zzbhu = this.zzfba;
        if (zzbhu != null) {
            zzbhu.zza(str, predicate);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgg
    public final /* synthetic */ zzbhn zzadl() {
        return this.zzfba;
    }
}
