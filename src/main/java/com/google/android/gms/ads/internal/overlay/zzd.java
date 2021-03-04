package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaan;
import com.google.android.gms.internal.ads.zzaok;
import com.google.android.gms.internal.ads.zzaoq;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzaxz;
import com.google.android.gms.internal.ads.zzayh;
import com.google.android.gms.internal.ads.zzayp;
import com.google.android.gms.internal.ads.zzbgg;
import com.google.android.gms.internal.ads.zzwu;
import java.util.Collections;

@zzark
public class zzd extends zzaoq implements zzw {
    @VisibleForTesting
    private static final int zzdqt = Color.argb(0, 0, 0, 0);
    protected final Activity mActivity;
    @VisibleForTesting
    zzbgg zzdin;
    @VisibleForTesting
    AdOverlayInfoParcel zzdqu;
    @VisibleForTesting
    private zzi zzdqv;
    @VisibleForTesting
    private zzo zzdqw;
    @VisibleForTesting
    private boolean zzdqx = false;
    @VisibleForTesting
    private FrameLayout zzdqy;
    @VisibleForTesting
    private WebChromeClient.CustomViewCallback zzdqz;
    @VisibleForTesting
    private boolean zzdra = false;
    @VisibleForTesting
    private boolean zzdrb = false;
    @VisibleForTesting
    private zzh zzdrc;
    @VisibleForTesting
    private boolean zzdrd = false;
    @VisibleForTesting
    int zzdre = 0;
    private final Object zzdrf = new Object();
    private Runnable zzdrg;
    private boolean zzdrh;
    private boolean zzdri;
    private boolean zzdrj = false;
    private boolean zzdrk = false;
    private boolean zzdrl = true;

    public zzd(Activity activity) {
        this.mActivity = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void onRestart() {
    }

    public final void close() {
        this.zzdre = 2;
        this.mActivity.finish();
    }

    public final void zzvo() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzdqu;
        if (adOverlayInfoParcel != null && this.zzdqx) {
            setRequestedOrientation(adOverlayInfoParcel.orientation);
        }
        if (this.zzdqy != null) {
            this.mActivity.setContentView(this.zzdrc);
            this.zzdri = true;
            this.zzdqy.removeAllViews();
            this.zzdqy = null;
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.zzdqz;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
            this.zzdqz = null;
        }
        this.zzdqx = false;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzw
    public final void zzvp() {
        this.zzdre = 1;
        this.mActivity.finish();
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void onBackPressed() {
        this.zzdre = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final boolean zzvq() {
        this.zzdre = 0;
        zzbgg zzbgg = this.zzdin;
        if (zzbgg == null) {
            return true;
        }
        boolean zzads = zzbgg.zzads();
        if (!zzads) {
            this.zzdin.zza("onbackblocked", Collections.emptyMap());
        }
        return zzads;
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public void onCreate(Bundle bundle) {
        this.mActivity.requestWindowFeature(1);
        this.zzdra = bundle != null ? bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false) : false;
        try {
            this.zzdqu = AdOverlayInfoParcel.zzc(this.mActivity.getIntent());
            if (this.zzdqu != null) {
                if (this.zzdqu.zzbsp.zzeov > 7500000) {
                    this.zzdre = 3;
                }
                if (this.mActivity.getIntent() != null) {
                    this.zzdrl = this.mActivity.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
                }
                if (this.zzdqu.zzdsc != null) {
                    this.zzdrb = this.zzdqu.zzdsc.zzbpa;
                } else {
                    this.zzdrb = false;
                }
                if (this.zzdrb && this.zzdqu.zzdsc.zzbpf != -1) {
                    new zzj(this, null).zzyz();
                }
                if (bundle == null) {
                    if (this.zzdqu.zzdru != null && this.zzdrl) {
                        this.zzdqu.zzdru.zziw();
                    }
                    if (!(this.zzdqu.zzdsa == 1 || this.zzdqu.zzdrt == null)) {
                        this.zzdqu.zzdrt.onAdClicked();
                    }
                }
                this.zzdrc = new zzh(this.mActivity, this.zzdqu.zzdsb, this.zzdqu.zzbsp.zzdp);
                this.zzdrc.setId(1000);
                switch (this.zzdqu.zzdsa) {
                    case 1:
                        zzae(false);
                        return;
                    case 2:
                        this.zzdqv = new zzi(this.zzdqu.zzdrv);
                        zzae(false);
                        return;
                    case 3:
                        zzae(true);
                        return;
                    default:
                        throw new zzg("Could not determine ad overlay type.");
                }
            } else {
                throw new zzg("Could not get info for ad overlay.");
            }
        } catch (zzg e) {
            zzaxz.zzeo(e.getMessage());
            this.zzdre = 3;
            this.mActivity.finish();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void onStart() {
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcwm)).booleanValue()) {
            zzbgg zzbgg = this.zzdin;
            if (zzbgg == null || zzbgg.isDestroyed()) {
                zzaxz.zzeo("The webview does not exist. Ignoring action.");
                return;
            }
            zzbv.zzlh();
            zzayp.zzj(this.zzdin);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void onResume() {
        if (this.zzdqu.zzdru != null) {
            this.zzdqu.zzdru.onResume();
        }
        if (!((Boolean) zzwu.zzpz().zzd(zzaan.zzcwm)).booleanValue()) {
            zzbgg zzbgg = this.zzdin;
            if (zzbgg == null || zzbgg.isDestroyed()) {
                zzaxz.zzeo("The webview does not exist. Ignoring action.");
                return;
            }
            zzbv.zzlh();
            zzayp.zzj(this.zzdin);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void onPause() {
        zzvo();
        if (this.zzdqu.zzdru != null) {
            this.zzdqu.zzdru.onPause();
        }
        if (!((Boolean) zzwu.zzpz().zzd(zzaan.zzcwm)).booleanValue() && this.zzdin != null && (!this.mActivity.isFinishing() || this.zzdqv == null)) {
            zzbv.zzlh();
            zzayp.zzi(this.zzdin);
        }
        zzvs();
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void zzq(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcwl)).booleanValue() && PlatformVersion.isAtLeastN()) {
            zzbv.zzlf();
            if (zzayh.zza(this.mActivity, (Configuration) ObjectWrapper.unwrap(iObjectWrapper))) {
                this.mActivity.getWindow().addFlags(1024);
                this.mActivity.getWindow().clearFlags(2048);
                return;
            }
            this.mActivity.getWindow().addFlags(2048);
            this.mActivity.getWindow().clearFlags(1024);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzdra);
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void onStop() {
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcwm)).booleanValue() && this.zzdin != null && (!this.mActivity.isFinishing() || this.zzdqv == null)) {
            zzbv.zzlh();
            zzayp.zzi(this.zzdin);
        }
        zzvs();
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void onDestroy() {
        zzbgg zzbgg = this.zzdin;
        if (zzbgg != null) {
            this.zzdrc.removeView(zzbgg.getView());
        }
        zzvs();
    }

    private final void zzad(boolean z) {
        int intValue = ((Integer) zzwu.zzpz().zzd(zzaan.zzcwo)).intValue();
        zzp zzp = new zzp();
        zzp.size = 50;
        zzp.paddingLeft = z ? intValue : 0;
        zzp.paddingRight = z ? 0 : intValue;
        zzp.paddingTop = 0;
        zzp.paddingBottom = intValue;
        this.zzdqw = new zzo(this.mActivity, zzp, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        zza(z, this.zzdqu.zzdrx);
        this.zzdrc.addView(this.zzdqw, layoutParams);
    }

    @Override // com.google.android.gms.internal.ads.zzaop
    public final void zzay() {
        this.zzdri = true;
    }

    public final void zza(boolean z, boolean z2) {
        AdOverlayInfoParcel adOverlayInfoParcel;
        AdOverlayInfoParcel adOverlayInfoParcel2;
        boolean z3 = true;
        boolean z4 = ((Boolean) zzwu.zzpz().zzd(zzaan.zzcrt)).booleanValue() && (adOverlayInfoParcel2 = this.zzdqu) != null && adOverlayInfoParcel2.zzdsc != null && this.zzdqu.zzdsc.zzbph;
        boolean z5 = ((Boolean) zzwu.zzpz().zzd(zzaan.zzcru)).booleanValue() && (adOverlayInfoParcel = this.zzdqu) != null && adOverlayInfoParcel.zzdsc != null && this.zzdqu.zzdsc.zzbpi;
        if (z && z2 && z4 && !z5) {
            new zzaok(this.zzdin, "useCustomClose").zzda("Custom close has been disabled for interstitial ads in this ad slot.");
        }
        zzo zzo = this.zzdqw;
        if (zzo != null) {
            if (!z5 && (!z2 || z4)) {
                z3 = false;
            }
            zzo.zzaf(z3);
        }
    }

    public final void zzvr() {
        this.zzdrc.removeView(this.zzdqw);
        zzad(true);
    }

    public final void setRequestedOrientation(int i) {
        if (this.mActivity.getApplicationInfo().targetSdkVersion >= ((Integer) zzwu.zzpz().zzd(zzaan.zzcyg)).intValue()) {
            if (this.mActivity.getApplicationInfo().targetSdkVersion <= ((Integer) zzwu.zzpz().zzd(zzaan.zzcyh)).intValue()) {
                if (Build.VERSION.SDK_INT >= ((Integer) zzwu.zzpz().zzd(zzaan.zzcyi)).intValue()) {
                    if (Build.VERSION.SDK_INT <= ((Integer) zzwu.zzpz().zzd(zzaan.zzcyj)).intValue()) {
                        return;
                    }
                }
            }
        }
        this.mActivity.setRequestedOrientation(i);
    }

    public final void zza(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.zzdqy = new FrameLayout(this.mActivity);
        this.zzdqy.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.zzdqy.addView(view, -1, -1);
        this.mActivity.setContentView(this.zzdqy);
        this.zzdri = true;
        this.zzdqz = customViewCallback;
        this.zzdqx = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:113:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0124 A[SYNTHETIC, Splitter:B:58:0x0124] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0211  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzae(boolean r18) throws com.google.android.gms.ads.internal.overlay.zzg {
        /*
        // Method dump skipped, instructions count: 618
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzd.zzae(boolean):void");
    }

    private final void zzvs() {
        if (this.mActivity.isFinishing() && !this.zzdrj) {
            this.zzdrj = true;
            zzbgg zzbgg = this.zzdin;
            if (zzbgg != null) {
                zzbgg.zzdh(this.zzdre);
                synchronized (this.zzdrf) {
                    if (!this.zzdrh && this.zzdin.zzadu()) {
                        this.zzdrg = new zzf(this);
                        zzayh.zzelc.postDelayed(this.zzdrg, ((Long) zzwu.zzpz().zzd(zzaan.zzcrs)).longValue());
                        return;
                    }
                }
            }
            zzvt();
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zzvt() {
        if (!this.zzdrk) {
            this.zzdrk = true;
            zzbgg zzbgg = this.zzdin;
            if (zzbgg != null) {
                this.zzdrc.removeView(zzbgg.getView());
                zzi zzi = this.zzdqv;
                if (zzi != null) {
                    this.zzdin.zzbo(zzi.zzsp);
                    this.zzdin.zzav(false);
                    this.zzdqv.parent.addView(this.zzdin.getView(), this.zzdqv.index, this.zzdqv.zzdrp);
                    this.zzdqv = null;
                } else if (this.mActivity.getApplicationContext() != null) {
                    this.zzdin.zzbo(this.mActivity.getApplicationContext());
                }
                this.zzdin = null;
            }
            AdOverlayInfoParcel adOverlayInfoParcel = this.zzdqu;
            if (!(adOverlayInfoParcel == null || adOverlayInfoParcel.zzdru == null)) {
                this.zzdqu.zzdru.zziv();
            }
            AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzdqu;
            if (adOverlayInfoParcel2 != null && adOverlayInfoParcel2.zzdrv != null) {
                zzb(this.zzdqu.zzdrv.zzadp(), this.zzdqu.zzdrv.getView());
            }
        }
    }

    private static void zzb(@Nullable IObjectWrapper iObjectWrapper, @Nullable View view) {
        if (iObjectWrapper != null && view != null) {
            zzbv.zzlw().zza(iObjectWrapper, view);
        }
    }

    public final void zzvu() {
        if (this.zzdrd) {
            this.zzdrd = false;
            zzvv();
        }
    }

    private final void zzvv() {
        this.zzdin.zzvv();
    }

    public final void zzvw() {
        this.zzdrc.zzdro = true;
    }

    public final void zzvx() {
        synchronized (this.zzdrf) {
            this.zzdrh = true;
            if (this.zzdrg != null) {
                zzayh.zzelc.removeCallbacks(this.zzdrg);
                zzayh.zzelc.post(this.zzdrg);
            }
        }
    }
}
