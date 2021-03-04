package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Iterator;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
@ParametersAreNonnullByDefault
@TargetApi(14)
public final class zzsx extends Thread {
    private final Object mLock;
    private boolean mStarted;
    private boolean zzbm;
    private final int zzbwy;
    private final int zzbxa;
    private boolean zzbxz;
    private final zzss zzbya;
    private final int zzbyb;
    private final int zzbyc;
    private final int zzbyd;
    private final int zzbye;
    private final int zzbyf;
    private final int zzbyg;
    private final String zzbyh;
    private final boolean zzbyi;

    public zzsx() {
        this(new zzss());
    }

    @VisibleForTesting
    private zzsx(zzss zzss) {
        this.mStarted = false;
        this.zzbxz = false;
        this.zzbm = false;
        this.zzbya = zzss;
        this.mLock = new Object();
        this.zzbwy = ((Integer) zzwu.zzpz().zzd(zzaan.zzcqa)).intValue();
        this.zzbyc = ((Integer) zzwu.zzpz().zzd(zzaan.zzcqb)).intValue();
        this.zzbxa = ((Integer) zzwu.zzpz().zzd(zzaan.zzcqc)).intValue();
        this.zzbyd = ((Integer) zzwu.zzpz().zzd(zzaan.zzcqd)).intValue();
        this.zzbye = ((Integer) zzwu.zzpz().zzd(zzaan.zzcqf)).intValue();
        this.zzbyf = ((Integer) zzwu.zzpz().zzd(zzaan.zzcqg)).intValue();
        this.zzbyg = ((Integer) zzwu.zzpz().zzd(zzaan.zzcqh)).intValue();
        this.zzbyb = ((Integer) zzwu.zzpz().zzd(zzaan.zzcqe)).intValue();
        this.zzbyh = (String) zzwu.zzpz().zzd(zzaan.zzcqj);
        this.zzbyi = ((Boolean) zzwu.zzpz().zzd(zzaan.zzcqk)).booleanValue();
        setName("ContentFetchTask");
    }

    public final void zzns() {
        synchronized (this.mLock) {
            if (this.mStarted) {
                zzaxz.zzdn("Content hash thread already started, quiting...");
                return;
            }
            this.mStarted = true;
            start();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003e, code lost:
        com.google.android.gms.ads.internal.zzbv.zzlj().zza(r0, "ContentFetchTask.extractContent");
        com.google.android.gms.internal.ads.zzaxz.zzdn("Failed getting root view of activity. Content not extracted.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007b, code lost:
        com.google.android.gms.internal.ads.zzaxz.zzb("Error in ContentFetchTask", r0);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x0083 */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007a A[ExcHandler: InterruptedException (r0v1 'e' java.lang.InterruptedException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0083 A[LOOP:1: B:28:0x0083->B:39:0x0083, LOOP_START, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        // Method dump skipped, instructions count: 153
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsx.run():void");
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zzk(View view) {
        try {
            zzsr zzsr = new zzsr(this.zzbwy, this.zzbyc, this.zzbxa, this.zzbyd, this.zzbye, this.zzbyf, this.zzbyg);
            Context context = zzbv.zzli().getContext();
            if (context != null && !TextUtils.isEmpty(this.zzbyh)) {
                String str = (String) view.getTag(context.getResources().getIdentifier((String) zzwu.zzpz().zzd(zzaan.zzcqi), "id", context.getPackageName()));
                if (str != null && str.equals(this.zzbyh)) {
                    return;
                }
            }
            zztb zza = zza(view, zzsr);
            zzsr.zznp();
            if (zza.zzbyq != 0 || zza.zzbyr != 0) {
                if (zza.zzbyr != 0 || zzsr.zznq() != 0) {
                    if (zza.zzbyr != 0 || !this.zzbya.zza(zzsr)) {
                        this.zzbya.zzc(zzsr);
                    }
                }
            }
        } catch (Exception e) {
            zzaxz.zzb("Exception in fetchContentOnUIThread", e);
            zzbv.zzlj().zza(e, "ContentFetchTask.fetchContent");
        }
    }

    @VisibleForTesting
    private static boolean zznt() {
        boolean z;
        try {
            Context context = zzbv.zzli().getContext();
            if (context == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager != null) {
                if (keyguardManager != null) {
                    List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                    if (runningAppProcesses == null) {
                        return false;
                    }
                    Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ActivityManager.RunningAppProcessInfo next = it.next();
                        if (Process.myPid() == next.pid) {
                            if (next.importance == 100 && !keyguardManager.inKeyguardRestrictedInputMode()) {
                                PowerManager powerManager = (PowerManager) context.getSystemService("power");
                                if (powerManager == null) {
                                    z = false;
                                } else {
                                    z = powerManager.isScreenOn();
                                }
                                if (z) {
                                    return true;
                                }
                            }
                        }
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable th) {
            zzbv.zzlj().zza(th, "ContentFetchTask.isInForeground");
            return false;
        }
    }

    @VisibleForTesting
    private final zztb zza(@Nullable View view, zzsr zzsr) {
        boolean z;
        if (view == null) {
            return new zztb(this, 0, 0);
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new zztb(this, 0, 0);
            }
            zzsr.zzb(text.toString(), globalVisibleRect, view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
            return new zztb(this, 1, 0);
        } else if ((view instanceof WebView) && !(view instanceof zzbgg)) {
            zzsr.zzno();
            WebView webView = (WebView) view;
            if (!PlatformVersion.isAtLeastKitKat()) {
                z = false;
            } else {
                zzsr.zzno();
                webView.post(new zzsz(this, zzsr, webView, globalVisibleRect));
                z = true;
            }
            if (z) {
                return new zztb(this, 0, 1);
            }
            return new zztb(this, 0, 0);
        } else if (!(view instanceof ViewGroup)) {
            return new zztb(this, 0, 0);
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                zztb zza = zza(viewGroup.getChildAt(i3), zzsr);
                i += zza.zzbyq;
                i2 += zza.zzbyr;
            }
            return new zztb(this, i, i2);
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zza(zzsr zzsr, WebView webView, String str, boolean z) {
        zzsr.zznn();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (this.zzbyi || TextUtils.isEmpty(webView.getTitle())) {
                    zzsr.zza(optString, z, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                } else {
                    String title = webView.getTitle();
                    StringBuilder sb = new StringBuilder(String.valueOf(title).length() + 1 + String.valueOf(optString).length());
                    sb.append(title);
                    sb.append("\n");
                    sb.append(optString);
                    zzsr.zza(sb.toString(), z, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                }
            }
            if (zzsr.zzni()) {
                this.zzbya.zzb(zzsr);
            }
        } catch (JSONException unused) {
            zzaxz.zzdn("Json string may be malformed.");
        } catch (Throwable th) {
            zzaxz.zza("Failed to get webview content.", th);
            zzbv.zzlj().zza(th, "ContentFetchTask.processWebViewContent");
        }
    }

    public final zzsr zznu() {
        return this.zzbya.zznr();
    }

    public final void wakeup() {
        synchronized (this.mLock) {
            this.zzbxz = false;
            this.mLock.notifyAll();
            zzaxz.zzdn("ContentFetchThread: wakeup");
        }
    }

    private final void zznv() {
        synchronized (this.mLock) {
            this.zzbxz = true;
            boolean z = this.zzbxz;
            StringBuilder sb = new StringBuilder(42);
            sb.append("ContentFetchThread: paused, mPause = ");
            sb.append(z);
            zzaxz.zzdn(sb.toString());
        }
    }

    public final boolean zznw() {
        return this.zzbxz;
    }
}
