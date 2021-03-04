package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
public final class zzacr extends zzadg implements View.OnClickListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzacw {
    @VisibleForTesting
    private static final String[] zzdcy = {NativeAppInstallAd.ASSET_MEDIA_VIDEO, NativeContentAd.ASSET_MEDIA_VIDEO, UnifiedNativeAdAssetNames.ASSET_MEDIA_VIDEO};
    private final Object mLock = new Object();
    @VisibleForTesting
    @Nullable
    private FrameLayout zzbld;
    @VisibleForTesting
    @Nullable
    private zzacd zzdbj;
    private final FrameLayout zzdcz;
    private View zzdda;
    @VisibleForTesting
    private Map<String, WeakReference<View>> zzddb = Collections.synchronizedMap(new HashMap());
    @VisibleForTesting
    @Nullable
    private View zzddc;
    @VisibleForTesting
    private boolean zzddd = false;
    @VisibleForTesting
    private Point zzdde = new Point();
    @VisibleForTesting
    private Point zzddf = new Point();
    @VisibleForTesting
    private WeakReference<zzsc> zzddg = new WeakReference<>(null);

    @TargetApi(21)
    public zzacr(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.zzdcz = frameLayout;
        this.zzbld = frameLayout2;
        zzbv.zzme();
        zzbct.zza((View) this.zzdcz, (ViewTreeObserver.OnGlobalLayoutListener) this);
        zzbv.zzme();
        zzbct.zza((View) this.zzdcz, (ViewTreeObserver.OnScrollChangedListener) this);
        this.zzdcz.setOnTouchListener(this);
        this.zzdcz.setOnClickListener(this);
        if (frameLayout2 != null && PlatformVersion.isAtLeastLollipop()) {
            frameLayout2.setElevation(Float.MAX_VALUE);
        }
        zzaan.initialize(this.zzdcz.getContext());
    }

    @Override // com.google.android.gms.internal.ads.zzadf
    public final void zzb(String str, IObjectWrapper iObjectWrapper) {
        View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
        synchronized (this.mLock) {
            if (this.zzddb != null) {
                if (view == null) {
                    this.zzddb.remove(str);
                } else {
                    this.zzddb.put(str, new WeakReference<>(view));
                    if (!NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str)) {
                        if (!UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str)) {
                            view.setOnTouchListener(this);
                            view.setClickable(true);
                            view.setOnClickListener(this);
                        }
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadf
    public final IObjectWrapper zzbm(String str) {
        synchronized (this.mLock) {
            View view = null;
            if (this.zzddb == null) {
                return null;
            }
            WeakReference<View> weakReference = this.zzddb.get(str);
            if (weakReference != null) {
                view = weakReference.get();
            }
            return ObjectWrapper.wrap(view);
        }
    }

    private final void zzm(@Nullable View view) {
        zzacd zzacd = this.zzdbj;
        if (zzacd != null) {
            if (zzacd instanceof zzacc) {
                zzacd = ((zzacc) zzacd).zzso();
            }
            if (zzacd != null) {
                zzacd.zzm(view);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x017f A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzadf
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.dynamic.IObjectWrapper r12) {
        /*
        // Method dump skipped, instructions count: 542
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzacr.zza(com.google.android.gms.dynamic.IObjectWrapper):void");
    }

    public final void onClick(View view) {
        synchronized (this.mLock) {
            if (this.zzdbj != null) {
                this.zzdbj.cancelUnconfirmedClick();
                Bundle bundle = new Bundle();
                bundle.putFloat("x", (float) zzck(this.zzdde.x));
                bundle.putFloat("y", (float) zzck(this.zzdde.y));
                bundle.putFloat("start_x", (float) zzck(this.zzddf.x));
                bundle.putFloat("start_y", (float) zzck(this.zzddf.y));
                if (this.zzddc == null || !this.zzddc.equals(view)) {
                    this.zzdbj.zza(view, this.zzddb, bundle, this.zzdcz);
                } else if (!(this.zzdbj instanceof zzacc)) {
                    this.zzdbj.zza(view, NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE, bundle, this.zzddb, this.zzdcz, false);
                } else if (((zzacc) this.zzdbj).zzso() != null) {
                    ((zzacc) this.zzdbj).zzso().zza(view, NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE, bundle, this.zzddb, this.zzdcz, false);
                }
            }
        }
    }

    public final void onGlobalLayout() {
        synchronized (this.mLock) {
            if (this.zzdbj != null) {
                this.zzdbj.zzc(this.zzdcz, this.zzddb);
            }
        }
    }

    public final void onScrollChanged() {
        synchronized (this.mLock) {
            if (this.zzdbj != null) {
                this.zzdbj.zzc(this.zzdcz, this.zzddb);
            }
        }
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        synchronized (this.mLock) {
            if (this.zzdbj == null) {
                return false;
            }
            int[] iArr = new int[2];
            this.zzdcz.getLocationOnScreen(iArr);
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

    @Override // com.google.android.gms.internal.ads.zzadf
    public final void destroy() {
        synchronized (this.mLock) {
            if (this.zzbld != null) {
                this.zzbld.removeAllViews();
            }
            this.zzbld = null;
            this.zzddb = null;
            this.zzddc = null;
            this.zzdbj = null;
            this.zzdde = null;
            this.zzddf = null;
            this.zzddg = null;
            this.zzdda = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadf
    public final void zzb(IObjectWrapper iObjectWrapper, int i) {
        WeakReference<zzsc> weakReference;
        zzsc zzsc;
        if (zzbv.zzmf().zzv(this.zzdcz.getContext()) && (weakReference = this.zzddg) != null && (zzsc = weakReference.get()) != null) {
            zzsc.zznh();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadf
    public final void zzc(IObjectWrapper iObjectWrapper) {
        this.zzdbj.setClickConfirmingView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzacw
    public final synchronized Map<String, WeakReference<View>> zzsv() {
        return this.zzddb;
    }

    @Override // com.google.android.gms.internal.ads.zzacw
    public final View zzsw() {
        return this.zzdcz;
    }

    @VisibleForTesting
    private final int zzck(int i) {
        zzwu.zzpv();
        return zzbat.zzb(this.zzdbj.getContext(), i);
    }
}
