package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.webkit.ValueCallback;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@zzark
@ParametersAreNonnullByDefault
public class zzbig extends zzbid implements zzbij {
    @GuardedBy("this")
    private boolean zzdas;
    private final zzbie zzfbf;
    @GuardedBy("this")
    private boolean zzfbg;

    public zzbig(Context context, zzbie zzbie) {
        super(context);
        zzbv.zzlj().zzyn();
        this.zzfbf = zzbie;
        super.setWebViewClient(zzbie);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
    }

    /* access modifiers changed from: protected */
    @GuardedBy("this")
    public void zzba(boolean z) {
    }

    public final synchronized boolean isDestroyed() {
        return this.zzdas;
    }

    public synchronized void destroy() {
        if (!this.zzdas) {
            this.zzdas = true;
            this.zzfbf.zza(this);
            zzba(false);
            zzaxz.v("Initiating WebView self destruct sequence in 3...");
            zzaxz.v("Loading blank page in WebView, 2...");
            try {
                super.loadUrl("about:blank");
            } catch (UnsatisfiedLinkError e) {
                zzbv.zzlj().zza(e, "AdWebViewImpl.loadUrlUnsafe");
                zzaxz.zzd("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final synchronized void zza(zzbif zzbif) {
        zzaxz.v("Blank page loaded, 1...");
        zzadr();
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    public synchronized void zzadr() {
        zzaxz.v("Destroying WebView!");
        zzyo();
        zzbcg.zzepo.execute(new zzbih(this));
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (!isDestroyed()) {
                    zzba(true);
                }
                zzyo();
            }
        } finally {
            super.finalize();
        }
    }

    private final synchronized void zzyo() {
        if (!this.zzfbg) {
            this.zzfbg = true;
            zzbv.zzlj().zzyo();
        }
    }

    @Override // android.webkit.WebView
    @TargetApi(19)
    public synchronized void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (isDestroyed()) {
            zzaxz.zzeo("#004 The webview is destroyed. Ignoring action.");
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
            }
            return;
        }
        super.evaluateJavascript(str, valueCallback);
    }

    @Override // com.google.android.gms.internal.ads.zzbid
    public synchronized void loadUrl(String str) {
        if (!isDestroyed()) {
            super.loadUrl(str);
        } else {
            zzaxz.zzeo("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public synchronized void loadData(String str, String str2, String str3) {
        if (!isDestroyed()) {
            super.loadData(str, str2, str3);
        } else {
            zzaxz.zzeo("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!isDestroyed()) {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            zzaxz.zzeo("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return !isDestroyed() && super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    @TargetApi(21)
    public void onDraw(Canvas canvas) {
        if (!isDestroyed()) {
            super.onDraw(canvas);
        }
    }

    public void onPause() {
        if (!isDestroyed()) {
            super.onPause();
        }
    }

    public void onResume() {
        if (!isDestroyed()) {
            super.onResume();
        }
    }

    public void stopLoading() {
        if (!isDestroyed()) {
            super.stopLoading();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbid
    public /* bridge */ /* synthetic */ void addJavascriptInterface(Object obj, String str) {
        super.addJavascriptInterface(obj, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbid
    public /* bridge */ /* synthetic */ void zzcg(String str) {
        super.zzcg(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaff() {
        super.destroy();
    }
}
