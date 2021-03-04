package com.google.android.gms.internal.ads;

import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@zzark
@ParametersAreNonnullByDefault
public final class zzact extends zzadl implements View.OnClickListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzacw {
    @VisibleForTesting
    static final String[] zzdcy = {NativeAppInstallAd.ASSET_MEDIA_VIDEO, NativeContentAd.ASSET_MEDIA_VIDEO, UnifiedNativeAdAssetNames.ASSET_MEDIA_VIDEO};
    private final Object mLock = new Object();
    @VisibleForTesting
    @GuardedBy("mLock")
    @Nullable
    private zzacd zzdbj;
    @VisibleForTesting
    @Nullable
    private View zzddc;
    @VisibleForTesting
    private Point zzdde = new Point();
    @VisibleForTesting
    private Point zzddf = new Point();
    @VisibleForTesting
    @Nullable
    private WeakReference<zzsc> zzddg = new WeakReference<>(null);
    private final WeakReference<View> zzddj;
    private final Map<String, WeakReference<View>> zzddk = new HashMap();
    private final Map<String, WeakReference<View>> zzddl = new HashMap();
    private final Map<String, WeakReference<View>> zzddm = new HashMap();

    public zzact(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        zzbv.zzme();
        zzbct.zza(view, (ViewTreeObserver.OnGlobalLayoutListener) this);
        zzbv.zzme();
        zzbct.zza(view, (ViewTreeObserver.OnScrollChangedListener) this);
        view.setOnTouchListener(this);
        view.setOnClickListener(this);
        this.zzddj = new WeakReference<>(view);
        for (Map.Entry<String, View> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            View value = entry.getValue();
            if (value != null) {
                this.zzddk.put(key, new WeakReference<>(value));
                if (!NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW.equals(key) && !UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW.equals(key)) {
                    value.setOnTouchListener(this);
                    value.setClickable(true);
                    value.setOnClickListener(this);
                }
            }
        }
        this.zzddm.putAll(this.zzddk);
        for (Map.Entry<String, View> entry2 : hashMap2.entrySet()) {
            View value2 = entry2.getValue();
            if (value2 != null) {
                this.zzddl.put(entry2.getKey(), new WeakReference<>(value2));
                value2.setOnTouchListener(this);
            }
        }
        this.zzddm.putAll(this.zzddl);
        zzaan.initialize(view.getContext());
    }

    @Override // com.google.android.gms.internal.ads.zzadk
    public final void unregisterNativeAd() {
        synchronized (this.mLock) {
            this.zzddc = null;
            this.zzdbj = null;
            this.zzdde = null;
            this.zzddf = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadk
    public final void zza(IObjectWrapper iObjectWrapper) {
        int i;
        View view;
        synchronized (this.mLock) {
            ViewGroup viewGroup = null;
            zzm(null);
            Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
            if (!(unwrap instanceof zzach)) {
                zzaxz.zzeo("Not an instance of native engine. This is most likely a transient error");
                return;
            }
            zzach zzach = (zzach) unwrap;
            if (!zzach.zzsl()) {
                zzaxz.e("Your account must be enabled to use this feature. Talk to your account manager to request this feature for your account.");
                return;
            }
            View view2 = this.zzddj.get();
            if (!(this.zzdbj == null || view2 == null)) {
                this.zzdbj.zzb(view2, this.zzddm);
            }
            synchronized (this.mLock) {
                i = 0;
                if (this.zzdbj instanceof zzach) {
                    zzach zzach2 = (zzach) this.zzdbj;
                    View view3 = this.zzddj.get();
                    if (!(zzach2 == null || zzach2.getContext() == null || view3 == null || !zzbv.zzmf().zzv(view3.getContext()))) {
                        zzawv zzsu = zzach2.zzsu();
                        if (zzsu != null) {
                            zzsu.zzai(false);
                        }
                        zzsc zzsc = this.zzddg.get();
                        if (!(zzsc == null || zzsu == null)) {
                            zzsc.zzb(zzsu);
                        }
                    }
                }
            }
            if (!(this.zzdbj instanceof zzacc) || !((zzacc) this.zzdbj).zzsn()) {
                this.zzdbj = zzach;
                if (zzach instanceof zzacc) {
                    ((zzacc) zzach).zzc(null);
                }
            } else {
                ((zzacc) this.zzdbj).zzc(zzach);
            }
            String[] strArr = {NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW, UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW};
            while (true) {
                if (i >= 2) {
                    view = null;
                    break;
                }
                WeakReference<View> weakReference = this.zzddm.get(strArr[i]);
                if (weakReference != null) {
                    view = weakReference.get();
                    break;
                }
                i++;
            }
            if (view == null) {
                zzaxz.zzeo("Ad choices asset view is not provided.");
            } else {
                if (view instanceof ViewGroup) {
                    viewGroup = (ViewGroup) view;
                }
                if (viewGroup != null) {
                    this.zzddc = zzach.zza((View.OnClickListener) this, true);
                    if (this.zzddc != null) {
                        this.zzddm.put(NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE, new WeakReference<>(this.zzddc));
                        this.zzddk.put(NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE, new WeakReference<>(this.zzddc));
                        viewGroup.removeAllViews();
                        viewGroup.addView(this.zzddc);
                    }
                }
            }
            zzach.zza(view2, this.zzddk, this.zzddl, this, this);
            zzayh.zzelc.post(new zzacu(this, zzach));
            zzm(view2);
            this.zzdbj.zzj(view2);
            synchronized (this.mLock) {
                if (this.zzdbj instanceof zzach) {
                    zzach zzach3 = (zzach) this.zzdbj;
                    View view4 = this.zzddj.get();
                    if (!(zzach3 == null || zzach3.getContext() == null || view4 == null || !zzbv.zzmf().zzv(view4.getContext()))) {
                        zzsc zzsc2 = this.zzddg.get();
                        if (zzsc2 == null) {
                            zzsc2 = new zzsc(view4.getContext(), view4);
                            this.zzddg = new WeakReference<>(zzsc2);
                        }
                        zzsc2.zza(zzach3.zzsu());
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadk
    public final void zzc(IObjectWrapper iObjectWrapper) {
        synchronized (this.mLock) {
            this.zzdbj.setClickConfirmingView((View) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    /* access modifiers changed from: private */
    public final boolean zza(String[] strArr) {
        for (String str : strArr) {
            if (this.zzddk.get(str) != null) {
                return true;
            }
        }
        for (String str2 : strArr) {
            if (this.zzddl.get(str2) != null) {
                return false;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void zza(zzach zzach) {
        View view;
        synchronized (this.mLock) {
            String[] strArr = zzdcy;
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    view = null;
                    break;
                }
                WeakReference<View> weakReference = this.zzddm.get(strArr[i]);
                if (weakReference != null) {
                    view = weakReference.get();
                    break;
                }
                i++;
            }
            if (!(view instanceof FrameLayout)) {
                zzach.zzsr();
                return;
            }
            zzacv zzacv = new zzacv(this, view);
            if (zzach instanceof zzacc) {
                zzach.zzb(view, zzacv);
            } else {
                zzach.zza(view, zzacv);
            }
        }
    }

    private final void zzm(@Nullable View view) {
        zzacd zzacd;
        synchronized (this.mLock) {
            if (this.zzdbj != null) {
                if (this.zzdbj instanceof zzacc) {
                    zzacd = ((zzacc) this.zzdbj).zzso();
                } else {
                    zzacd = this.zzdbj;
                }
                if (zzacd != null) {
                    zzacd.zzm(view);
                }
            }
        }
    }

    public final void onGlobalLayout() {
        View view;
        synchronized (this.mLock) {
            if (!(this.zzdbj == null || (view = this.zzddj.get()) == null)) {
                this.zzdbj.zzc(view, this.zzddm);
            }
        }
    }

    public final void onScrollChanged() {
        View view;
        synchronized (this.mLock) {
            if (!(this.zzdbj == null || (view = this.zzddj.get()) == null)) {
                this.zzdbj.zzc(view, this.zzddm);
            }
        }
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        synchronized (this.mLock) {
            if (this.zzdbj == null) {
                return false;
            }
            View view2 = this.zzddj.get();
            if (view2 == null) {
                return false;
            }
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            Point point = new Point((int) (motionEvent.getRawX() - ((float) iArr[0])), (int) (motionEvent.getRawY() - ((float) iArr[1])));
            this.zzdde = point;
            if (motionEvent.getAction() == 0) {
                this.zzddf = point;
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setLocation((float) point.x, (float) point.y);
            this.zzdbj.zzd(obtain);
            obtain.recycle();
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacw
    public final synchronized Map<String, WeakReference<View>> zzsv() {
        return this.zzddm;
    }

    @Override // com.google.android.gms.internal.ads.zzacw
    @Nullable
    public final View zzsw() {
        return this.zzddj.get();
    }

    public final void onClick(View view) {
        synchronized (this.mLock) {
            if (this.zzdbj != null) {
                View view2 = this.zzddj.get();
                if (view2 != null) {
                    Bundle bundle = new Bundle();
                    bundle.putFloat("x", (float) zzck(this.zzdde.x));
                    bundle.putFloat("y", (float) zzck(this.zzdde.y));
                    bundle.putFloat("start_x", (float) zzck(this.zzddf.x));
                    bundle.putFloat("start_y", (float) zzck(this.zzddf.y));
                    if (this.zzddc == null || !this.zzddc.equals(view)) {
                        this.zzdbj.zza(view, this.zzddm, bundle, view2);
                    } else if (!(this.zzdbj instanceof zzacc)) {
                        this.zzdbj.zza(view, NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE, bundle, this.zzddm, view2, false);
                    } else if (((zzacc) this.zzdbj).zzso() != null) {
                        ((zzacc) this.zzdbj).zzso().zza(view, NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE, bundle, this.zzddm, view2, false);
                    }
                }
            }
        }
    }

    @VisibleForTesting
    private final int zzck(int i) {
        int zzb;
        synchronized (this.mLock) {
            zzwu.zzpv();
            zzb = zzbat.zzb(this.zzdbj.getContext(), i);
        }
        return zzb;
    }
}
