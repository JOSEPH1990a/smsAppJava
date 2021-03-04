package com.google.android.gms.internal.ads;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.PowerManager;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
@ParametersAreNonnullByDefault
public final class zzrg implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private final Object mLock = new Object();
    private boolean zzbqq = false;
    private zzbai zzbua;
    private final Context zzbup;
    private final WeakReference<zzaxf> zzbur;
    private WeakReference<ViewTreeObserver> zzbus;
    private final zzsq zzbut;
    protected final zzre zzbuu;
    private final WindowManager zzbuv;
    private final PowerManager zzbuw;
    private final KeyguardManager zzbux;
    private final DisplayMetrics zzbuy;
    @Nullable
    private zzrn zzbuz;
    private boolean zzbva;
    private boolean zzbvb = false;
    private boolean zzbvc;
    private boolean zzbvd;
    private boolean zzbve;
    @VisibleForTesting
    @Nullable
    private BroadcastReceiver zzbvf;
    private final HashSet<zzrd> zzbvg = new HashSet<>();
    private final HashSet<zzsb> zzbvh = new HashSet<>();
    private final Rect zzbvi = new Rect();
    private final zzrj zzbvj;
    private float zzbvk;

    public zzrg(Context context, zzwf zzwf, zzaxf zzaxf, zzbbi zzbbi, zzsq zzsq) {
        this.zzbur = new WeakReference<>(zzaxf);
        this.zzbut = zzsq;
        this.zzbus = new WeakReference<>(null);
        this.zzbvc = true;
        this.zzbve = false;
        this.zzbua = new zzbai(200);
        this.zzbuu = new zzre(UUID.randomUUID().toString(), zzbbi, zzwf.zzckk, zzaxf.zzehh, zzaxf.zzmu(), zzwf.zzckn);
        this.zzbuv = (WindowManager) context.getSystemService("window");
        this.zzbuw = (PowerManager) context.getApplicationContext().getSystemService("power");
        this.zzbux = (KeyguardManager) context.getSystemService("keyguard");
        this.zzbup = context;
        this.zzbvj = new zzrj(this, new Handler());
        this.zzbup.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.zzbvj);
        this.zzbuy = context.getResources().getDisplayMetrics();
        Display defaultDisplay = this.zzbuv.getDefaultDisplay();
        this.zzbvi.right = defaultDisplay.getWidth();
        this.zzbvi.bottom = defaultDisplay.getHeight();
        zzmw();
    }

    public final void zzmw() {
        this.zzbvk = zzaza.zzbb(this.zzbup);
    }

    public final void zzmx() {
        synchronized (this.mLock) {
            if (this.zzbvc) {
                this.zzbvd = true;
                try {
                    JSONObject zznb = zznb();
                    zznb.put("doneReasonCode", "u");
                    zza(zznb, true);
                } catch (JSONException e) {
                    zzaxz.zzb("JSON failure while processing active view data.", e);
                } catch (RuntimeException e2) {
                    zzaxz.zzb("Failure while processing active view data.", e2);
                }
                String valueOf = String.valueOf(this.zzbuu.zzmt());
                zzaxz.zzdn(valueOf.length() != 0 ? "Untracking ad unit: ".concat(valueOf) : new String("Untracking ad unit: "));
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zzbu(int i) {
        boolean z;
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver viewTreeObserver2;
        synchronized (this.mLock) {
            Iterator<zzsb> it = this.zzbvh.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().zznf()) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (z) {
                if (this.zzbvc) {
                    View zznc = this.zzbut.zznc();
                    boolean z2 = zznc != null && zzbv.zzlf().zza(zznc, this.zzbuw, this.zzbux);
                    boolean z3 = zznc != null && z2 && zznc.getGlobalVisibleRect(new Rect(), null);
                    if (this.zzbut.zznd()) {
                        zzmx();
                    } else if (i != 1 || this.zzbua.tryAcquire() || z3 != this.zzbve) {
                        if (z3 || this.zzbve || i != 1) {
                            try {
                                zza(zza(zznc, Boolean.valueOf(z2)), false);
                                this.zzbve = z3;
                            } catch (RuntimeException | JSONException e) {
                                zzaxz.zza("Active view update failed.", e);
                            }
                            View zznc2 = this.zzbut.zzne().zznc();
                            if (!(zznc2 == null || (viewTreeObserver2 = zznc2.getViewTreeObserver()) == (viewTreeObserver = this.zzbus.get()))) {
                                zzna();
                                if (!this.zzbva || (viewTreeObserver != null && viewTreeObserver.isAlive())) {
                                    this.zzbva = true;
                                    viewTreeObserver2.addOnScrollChangedListener(this);
                                    viewTreeObserver2.addOnGlobalLayoutListener(this);
                                }
                                this.zzbus = new WeakReference<>(viewTreeObserver2);
                            }
                            zzmy();
                        }
                    }
                }
            }
        }
    }

    private final void zzmy() {
        zzrn zzrn = this.zzbuz;
        if (zzrn != null) {
            zzrn.zza(this);
        }
    }

    public final boolean zzmz() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzbvc;
        }
        return z;
    }

    private static int zza(int i, DisplayMetrics displayMetrics) {
        return (int) (((float) i) / displayMetrics.density);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzc(@Nullable Map<String, String> map) {
        if (map == null) {
            return false;
        }
        String str = map.get("hashCode");
        if (TextUtils.isEmpty(str) || !str.equals(this.zzbuu.zzmt())) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void zzd(Map<String, String> map) {
        zzbu(3);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzsb zzsb, Map<String, String> map) {
        String valueOf = String.valueOf(this.zzbuu.zzmt());
        zzaxz.zzdn(valueOf.length() != 0 ? "Received request to untrack: ".concat(valueOf) : new String("Received request to untrack: "));
        zzb(zzsb);
    }

    /* access modifiers changed from: package-private */
    public final void zze(Map<String, String> map) {
        if (map.containsKey("isVisible")) {
            boolean z = "1".equals(map.get("isVisible")) || "true".equals(map.get("isVisible"));
            Iterator<zzrd> it = this.zzbvg.iterator();
            while (it.hasNext()) {
                it.next().zza(this, z);
            }
        }
    }

    private final void zzna() {
        ViewTreeObserver viewTreeObserver = this.zzbus.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this);
            viewTreeObserver.removeGlobalOnLayoutListener(this);
        }
    }

    private final JSONObject zznb() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("afmaVersion", this.zzbuu.zzmr()).put("activeViewJSON", this.zzbuu.zzms()).put(AppMeasurement.Param.TIMESTAMP, zzbv.zzlm().elapsedRealtime()).put("adFormat", this.zzbuu.zzmq()).put("hashCode", this.zzbuu.zzmt()).put("isMraid", this.zzbuu.zzmu()).put("isStopped", this.zzbvb).put("isPaused", this.zzbqq).put("isNative", this.zzbuu.zzmv()).put("isScreenOn", isScreenOn()).put("appMuted", zzbv.zzlk().zzkk()).put("appVolume", (double) zzbv.zzlk().zzkj()).put("deviceVolume", (double) this.zzbvk);
        return jSONObject;
    }

    private static JSONObject zza(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }

    private final void zza(JSONObject jSONObject, boolean z) {
        try {
            JSONObject zza = zza(jSONObject);
            ArrayList arrayList = new ArrayList(this.zzbvh);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((zzsb) obj).zzb(zza, z);
            }
        } catch (Throwable th) {
            zzaxz.zzb("Skipping active view message.", th);
        }
    }

    public final void zza(zzsb zzsb) {
        if (this.zzbvh.isEmpty()) {
            synchronized (this.mLock) {
                if (this.zzbvf == null) {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    this.zzbvf = new zzrh(this);
                    zzbv.zzmc().zza(this.zzbup, this.zzbvf, intentFilter);
                }
            }
            zzbu(3);
        }
        this.zzbvh.add(zzsb);
        try {
            zzsb.zzb(zza(zza(this.zzbut.zznc(), (Boolean) null)), false);
        } catch (JSONException e) {
            zzaxz.zzb("Skipping measurement update for new client.", e);
        }
    }

    public final void zzb(zzsb zzsb) {
        this.zzbvh.remove(zzsb);
        zzsb.zzng();
        if (this.zzbvh.isEmpty()) {
            synchronized (this.mLock) {
                zzna();
                synchronized (this.mLock) {
                    if (this.zzbvf != null) {
                        try {
                            zzbv.zzmc().zza(this.zzbup, this.zzbvf);
                        } catch (IllegalStateException e) {
                            zzaxz.zzb("Failed trying to unregister the receiver", e);
                        } catch (Exception e2) {
                            zzbv.zzlj().zza(e2, "ActiveViewUnit.stopScreenStatusMonitoring");
                        }
                        this.zzbvf = null;
                    }
                }
                this.zzbup.getContentResolver().unregisterContentObserver(this.zzbvj);
                int i = 0;
                this.zzbvc = false;
                zzmy();
                ArrayList arrayList = new ArrayList(this.zzbvh);
                int size = arrayList.size();
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    zzb((zzsb) obj);
                }
            }
        }
    }

    private final JSONObject zza(@Nullable View view, @Nullable Boolean bool) throws JSONException {
        if (view == null) {
            return zznb().put("isAttachedToWindow", false).put("isScreenOn", isScreenOn()).put("isVisible", false);
        }
        boolean isAttachedToWindow = zzbv.zzlh().isAttachedToWindow(view);
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        try {
            view.getLocationOnScreen(iArr);
            view.getLocationInWindow(iArr2);
        } catch (Exception e) {
            zzaxz.zzb("Failure getting view location.", e);
        }
        Rect rect = new Rect();
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        Rect rect2 = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect2, null);
        Rect rect3 = new Rect();
        boolean localVisibleRect = view.getLocalVisibleRect(rect3);
        Rect rect4 = new Rect();
        view.getHitRect(rect4);
        JSONObject zznb = zznb();
        zznb.put("windowVisibility", view.getWindowVisibility()).put("isAttachedToWindow", isAttachedToWindow).put("viewBox", new JSONObject().put("top", zza(this.zzbvi.top, this.zzbuy)).put("bottom", zza(this.zzbvi.bottom, this.zzbuy)).put("left", zza(this.zzbvi.left, this.zzbuy)).put("right", zza(this.zzbvi.right, this.zzbuy))).put("adBox", new JSONObject().put("top", zza(rect.top, this.zzbuy)).put("bottom", zza(rect.bottom, this.zzbuy)).put("left", zza(rect.left, this.zzbuy)).put("right", zza(rect.right, this.zzbuy))).put("globalVisibleBox", new JSONObject().put("top", zza(rect2.top, this.zzbuy)).put("bottom", zza(rect2.bottom, this.zzbuy)).put("left", zza(rect2.left, this.zzbuy)).put("right", zza(rect2.right, this.zzbuy))).put("globalVisibleBoxVisible", globalVisibleRect).put("localVisibleBox", new JSONObject().put("top", zza(rect3.top, this.zzbuy)).put("bottom", zza(rect3.bottom, this.zzbuy)).put("left", zza(rect3.left, this.zzbuy)).put("right", zza(rect3.right, this.zzbuy))).put("localVisibleBoxVisible", localVisibleRect).put("hitBox", new JSONObject().put("top", zza(rect4.top, this.zzbuy)).put("bottom", zza(rect4.bottom, this.zzbuy)).put("left", zza(rect4.left, this.zzbuy)).put("right", zza(rect4.right, this.zzbuy))).put("screenDensity", (double) this.zzbuy.density);
        if (bool == null) {
            bool = Boolean.valueOf(zzbv.zzlf().zza(view, this.zzbuw, this.zzbux));
        }
        zznb.put("isVisible", bool.booleanValue());
        return zznb;
    }

    @VisibleForTesting
    private final boolean isScreenOn() {
        if (Build.VERSION.SDK_INT >= 20) {
            return this.zzbuw.isInteractive();
        }
        return this.zzbuw.isScreenOn();
    }

    public final void onScrollChanged() {
        zzbu(1);
    }

    public final void onGlobalLayout() {
        zzbu(2);
    }

    public final void zza(zzrn zzrn) {
        synchronized (this.mLock) {
            this.zzbuz = zzrn;
        }
    }

    public final void stop() {
        synchronized (this.mLock) {
            this.zzbvb = true;
            zzbu(3);
        }
    }

    public final void pause() {
        synchronized (this.mLock) {
            this.zzbqq = true;
            zzbu(3);
        }
    }

    public final void resume() {
        synchronized (this.mLock) {
            this.zzbqq = false;
            zzbu(3);
        }
    }
}
