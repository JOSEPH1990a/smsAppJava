package com.google.android.gms.ads.internal;

import android.content.Context;
import android.graphics.Rect;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzalg;
import com.google.android.gms.internal.ads.zzals;
import com.google.android.gms.internal.ads.zzalv;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzawr;
import com.google.android.gms.internal.ads.zzawv;
import com.google.android.gms.internal.ads.zzaxf;
import com.google.android.gms.internal.ads.zzaxg;
import com.google.android.gms.internal.ads.zzaxz;
import com.google.android.gms.internal.ads.zzayh;
import com.google.android.gms.internal.ads.zzbbi;
import com.google.android.gms.internal.ads.zzbgg;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzbhr;
import com.google.android.gms.internal.ads.zzbht;
import com.google.android.gms.internal.ads.zzsc;
import com.google.android.gms.internal.ads.zzwb;
import com.google.android.gms.internal.ads.zzwf;
import com.google.android.gms.internal.ads.zzwu;
import com.google.android.gms.internal.ads.zzyp;
import java.lang.ref.WeakReference;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
public final class zzx extends zzh implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private boolean zzbli;
    private boolean zzbmz;
    private WeakReference<Object> zzbna = new WeakReference<>(null);

    public zzx(Context context, zzwf zzwf, String str, zzalg zzalg, zzbbi zzbbi, zzv zzv) {
        super(context, zzwf, str, zzalg, zzbbi, zzv);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zzh
    public final zzbgg zza(zzaxg zzaxg, @Nullable zzw zzw, @Nullable zzawr zzawr) throws zzbgq {
        zzwf zzwf;
        AdSize adSize;
        if (this.zzbls.zzbst.zzckm == null && this.zzbls.zzbst.zzcko) {
            zzbw zzbw = this.zzbls;
            if (zzaxg.zzehy.zzcko) {
                zzwf = this.zzbls.zzbst;
            } else {
                String str = zzaxg.zzehy.zzdyg;
                if (str != null) {
                    String[] split = str.split("[xX]");
                    split[0] = split[0].trim();
                    split[1] = split[1].trim();
                    adSize = new AdSize(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                } else {
                    adSize = this.zzbls.zzbst.zzpp();
                }
                zzwf = new zzwf(this.zzbls.zzsp, adSize);
            }
            zzbw.zzbst = zzwf;
        }
        return super.zza(zzaxg, zzw, zzawr);
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.ads.zzxl
    public final boolean zzb(zzwb zzwb) {
        zzwb zzwb2 = zzwb;
        this.zzbmz = false;
        this.zzblx = null;
        if (zzwb2.zzcjg != this.zzbli) {
            zzwb2 = new zzwb(zzwb2.versionCode, zzwb2.zzcjb, zzwb2.extras, zzwb2.zzcjc, zzwb2.zzcjd, zzwb2.zzcje, zzwb2.zzcjf, zzwb2.zzcjg || this.zzbli, zzwb2.zzcjh, zzwb2.zzcji, zzwb2.zzcjj, zzwb2.zzcjk, zzwb2.zzcjl, zzwb2.zzcjm, zzwb2.zzcjn, zzwb2.zzcjo, zzwb2.zzcjp, zzwb2.zzcjq, null, zzwb2.zzcjs, zzwb2.zzcjt);
        }
        return super.zzb(zzwb2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007c, code lost:
        if (((java.lang.Boolean) com.google.android.gms.internal.ads.zzwu.zzpz().zzd(com.google.android.gms.internal.ads.zzaan.zzcuc)).booleanValue() != false) goto L_0x007e;
     */
    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.ads.internal.zzh, com.google.android.gms.ads.internal.zza
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(@android.support.annotation.Nullable com.google.android.gms.internal.ads.zzaxf r5, com.google.android.gms.internal.ads.zzaxf r6) {
        /*
        // Method dump skipped, instructions count: 324
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzx.zza(com.google.android.gms.internal.ads.zzaxf, com.google.android.gms.internal.ads.zzaxf):boolean");
    }

    private final boolean zzd(@Nullable zzaxf zzaxf, zzaxf zzaxf2) {
        if (zzaxf2.zzdyd) {
            View zze = zzas.zze(zzaxf2);
            if (zze == null) {
                zzaxz.zzeo("Could not get mediation view");
                return false;
            }
            View nextView = this.zzbls.zzbsq.getNextView();
            if (nextView != null) {
                if (nextView instanceof zzbgg) {
                    ((zzbgg) nextView).destroy();
                }
                this.zzbls.zzbsq.removeView(nextView);
            }
            if (!zzas.zzf(zzaxf2)) {
                try {
                    if (zzbv.zzmf().zzv(this.zzbls.zzsp)) {
                        new zzsc(this.zzbls.zzsp, zze).zza(new zzawv(this.zzbls.zzsp, this.zzbls.zzbsn));
                    }
                    if (zzaxf2.zzehl != null) {
                        this.zzbls.zzbsq.setMinimumWidth(zzaxf2.zzehl.widthPixels);
                        this.zzbls.zzbsq.setMinimumHeight(zzaxf2.zzehl.heightPixels);
                    }
                    zzg(zze);
                } catch (Exception e) {
                    zzbv.zzlj().zza(e, "BannerAdManager.swapViews");
                    zzaxz.zzc("Could not add mediation view to view hierarchy.", e);
                    return false;
                }
            }
        } else if (!(zzaxf2.zzehl == null || zzaxf2.zzdrv == null)) {
            zzaxf2.zzdrv.zza(zzbht.zzb(zzaxf2.zzehl));
            this.zzbls.zzbsq.removeAllViews();
            this.zzbls.zzbsq.setMinimumWidth(zzaxf2.zzehl.widthPixels);
            this.zzbls.zzbsq.setMinimumHeight(zzaxf2.zzehl.heightPixels);
            zzg(zzaxf2.zzdrv.getView());
        }
        if (this.zzbls.zzbsq.getChildCount() > 1) {
            this.zzbls.zzbsq.showNext();
        }
        if (zzaxf != null) {
            View nextView2 = this.zzbls.zzbsq.getNextView();
            if (nextView2 instanceof zzbgg) {
                ((zzbgg) nextView2).destroy();
            } else if (nextView2 != null) {
                this.zzbls.zzbsq.removeView(nextView2);
            }
            this.zzbls.zzmi();
        }
        this.zzbls.zzbsq.setVisibility(0);
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zzh, com.google.android.gms.ads.internal.zza
    public final void zzil() {
        zzbgg zzbgg = this.zzbls.zzbsu != null ? this.zzbls.zzbsu.zzdrv : null;
        if (!this.zzbmz && zzbgg != null) {
            zzc(zzbgg);
        }
        super.zzil();
    }

    private final void zzc(zzbgg zzbgg) {
        WebView webView;
        View view;
        if (zzjj() && (webView = zzbgg.getWebView()) != null && (view = zzbgg.getView()) != null && zzbv.zzlw().zzk(this.zzbls.zzsp)) {
            int i = this.zzbls.zzbsp.zzeou;
            int i2 = this.zzbls.zzbsp.zzeov;
            StringBuilder sb = new StringBuilder(23);
            sb.append(i);
            sb.append(".");
            sb.append(i2);
            this.zzblx = zzbv.zzlw().zza(sb.toString(), webView, "", "javascript", zzit());
            if (this.zzblx != null) {
                zzbv.zzlw().zza(this.zzblx, view);
                zzbgg.zzaa(this.zzblx);
                zzbv.zzlw().zzo(this.zzblx);
                this.zzbmz = true;
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zzc
    public final boolean zziu() {
        boolean z;
        zzbv.zzlf();
        if (!zzayh.zzn(this.zzbls.zzsp, "android.permission.INTERNET")) {
            zzwu.zzpv().zza(this.zzbls.zzbsq, this.zzbls.zzbst, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            z = false;
        } else {
            z = true;
        }
        zzbv.zzlf();
        if (!zzayh.zzah(this.zzbls.zzsp)) {
            zzwu.zzpv().zza(this.zzbls.zzbsq, this.zzbls.zzbst, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            z = false;
        }
        if (!z && this.zzbls.zzbsq != null) {
            this.zzbls.zzbsq.setVisibility(0);
        }
        return z;
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.ads.zzxl
    public final void setManualImpressionsEnabled(boolean z) {
        Preconditions.checkMainThread("setManualImpressionsEnabled must be called from the main thread.");
        this.zzbli = z;
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.internal.ads.zzxl
    public final void showInterstitial() {
        throw new IllegalStateException("Interstitial is NOT supported by BannerAdManager.");
    }

    public final void onGlobalLayout() {
        zzd(this.zzbls.zzbsu);
    }

    public final void onScrollChanged() {
        zzd(this.zzbls.zzbsu);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zzc
    public final void zza(@Nullable zzaxf zzaxf, boolean z) {
        if (zzjj()) {
            zzbgg zzbgg = zzaxf != null ? zzaxf.zzdrv : null;
            if (zzbgg != null) {
                if (!this.zzbmz) {
                    zzc(zzbgg);
                }
                if (this.zzblx != null) {
                    zzbgg.zza("onSdkImpression", new ArrayMap());
                }
            }
        }
        super.zza(zzaxf, z);
        if (zzas.zzf(zzaxf)) {
            zzab zzab = new zzab(this);
            if (zzaxf != null && zzas.zzf(zzaxf)) {
                zzbgg zzbgg2 = zzaxf.zzdrv;
                View view = zzbgg2 != null ? zzbgg2.getView() : null;
                if (view == null) {
                    zzaxz.zzeo("AdWebView is null");
                    return;
                }
                try {
                    List<String> list = zzaxf.zzdnb != null ? zzaxf.zzdnb.zzdll : null;
                    if (list != null) {
                        if (!list.isEmpty()) {
                            zzals zzuu = zzaxf.zzdnc != null ? zzaxf.zzdnc.zzuu() : null;
                            zzalv zzuv = zzaxf.zzdnc != null ? zzaxf.zzdnc.zzuv() : null;
                            if (list.contains("2") && zzuu != null) {
                                zzuu.zzl(ObjectWrapper.wrap(view));
                                if (!zzuu.getOverrideImpressionRecording()) {
                                    zzuu.recordImpression();
                                }
                                zzbgg2.zza("/nativeExpressViewClicked", zzas.zza(zzuu, (zzalv) null, zzab));
                                return;
                            } else if (!list.contains("1") || zzuv == null) {
                                zzaxz.zzeo("No matching template id and mapper");
                                return;
                            } else {
                                zzuv.zzl(ObjectWrapper.wrap(view));
                                if (!zzuv.getOverrideImpressionRecording()) {
                                    zzuv.recordImpression();
                                }
                                zzbgg2.zza("/nativeExpressViewClicked", zzas.zza((zzals) null, zzuv, zzab));
                                return;
                            }
                        }
                    }
                    zzaxz.zzeo("No template ids present in mediation response");
                } catch (RemoteException e) {
                    zzaxz.zzc("Error occurred while recording impression and registering for clicks", e);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zzd(@Nullable zzaxf zzaxf) {
        if (zzaxf != null && !zzaxf.zzehi && this.zzbls.zzbsq != null && zzbv.zzlf().zza(this.zzbls.zzbsq, this.zzbls.zzsp) && this.zzbls.zzbsq.getGlobalVisibleRect(new Rect(), null)) {
            if (!(zzaxf == null || zzaxf.zzdrv == null || zzaxf.zzdrv.zzadl() == null)) {
                zzaxf.zzdrv.zzadl().zza((zzbhr) null);
            }
            zza(zzaxf, false);
            zzaxf.zzehi = true;
        }
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.ads.zzxl
    @Nullable
    public final zzyp getVideoController() {
        Preconditions.checkMainThread("getVideoController must be called from the main thread.");
        if (this.zzbls.zzbsu == null || this.zzbls.zzbsu.zzdrv == null) {
            return null;
        }
        return this.zzbls.zzbsu.zzdrv.zzabu();
    }

    @Override // com.google.android.gms.internal.ads.zzaol
    public final void zzjv() {
        this.zzblr.zzku();
    }
}
