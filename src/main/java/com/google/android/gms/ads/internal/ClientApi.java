package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.Keep;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.ads.internal.overlay.zzr;
import com.google.android.gms.ads.internal.overlay.zzs;
import com.google.android.gms.ads.internal.overlay.zzx;
import com.google.android.gms.ads.internal.overlay.zzy;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.common.util.RetainForClient;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzacr;
import com.google.android.gms.internal.ads.zzact;
import com.google.android.gms.internal.ads.zzadf;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzalg;
import com.google.android.gms.internal.ads.zzaop;
import com.google.android.gms.internal.ads.zzaoz;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzaun;
import com.google.android.gms.internal.ads.zzauw;
import com.google.android.gms.internal.ads.zzayh;
import com.google.android.gms.internal.ads.zzbbi;
import com.google.android.gms.internal.ads.zzwf;
import com.google.android.gms.internal.ads.zzxg;
import com.google.android.gms.internal.ads.zzxl;
import com.google.android.gms.internal.ads.zzxx;
import com.google.android.gms.internal.ads.zzyc;
import java.util.HashMap;
import javax.annotation.ParametersAreNonnullByDefault;

@RetainForClient
@Keep
@DynamiteApi
@zzark
@ParametersAreNonnullByDefault
@KeepForSdkWithMembers
public class ClientApi extends zzxx {
    @Override // com.google.android.gms.internal.ads.zzxw
    public zzaoz createInAppPurchaseManager(IObjectWrapper iObjectWrapper) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    @Nullable
    public zzauw createRewardedVideoAdSku(IObjectWrapper iObjectWrapper, int i) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    @Nullable
    public zzyc getMobileAdsSettingsManager(IObjectWrapper iObjectWrapper) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public zzxl createBannerAdManager(IObjectWrapper iObjectWrapper, zzwf zzwf, String str, zzalg zzalg, int i) throws RemoteException {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzbv.zzlf();
        return new zzx(context, zzwf, str, zzalg, new zzbbi(14300000, i, true, zzayh.zzav(context)), zzv.zzd(context));
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public zzxl createSearchAdManager(IObjectWrapper iObjectWrapper, zzwf zzwf, String str, int i) throws RemoteException {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzbv.zzlf();
        return new zzbp(context, zzwf, str, new zzbbi(14300000, i, true, zzayh.zzav(context)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0034, code lost:
        if (((java.lang.Boolean) com.google.android.gms.internal.ads.zzwu.zzpz().zzd(com.google.android.gms.internal.ads.zzaan.zzcrz)).booleanValue() == false) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0048, code lost:
        if (((java.lang.Boolean) com.google.android.gms.internal.ads.zzwu.zzpz().zzd(com.google.android.gms.internal.ads.zzaan.zzcsa)).booleanValue() != false) goto L_0x004c;
     */
    @Override // com.google.android.gms.internal.ads.zzxw
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.ads.zzxl createInterstitialAdManager(com.google.android.gms.dynamic.IObjectWrapper r8, com.google.android.gms.internal.ads.zzwf r9, java.lang.String r10, com.google.android.gms.internal.ads.zzalg r11, int r12) throws android.os.RemoteException {
        /*
        // Method dump skipped, instructions count: 107
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.ClientApi.createInterstitialAdManager(com.google.android.gms.dynamic.IObjectWrapper, com.google.android.gms.internal.ads.zzwf, java.lang.String, com.google.android.gms.internal.ads.zzalg, int):com.google.android.gms.internal.ads.zzxl");
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public zzxg createAdLoaderBuilder(IObjectWrapper iObjectWrapper, String str, zzalg zzalg, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzbv.zzlf();
        return new zzak(context, str, zzalg, new zzbbi(14300000, i, true, zzayh.zzav(context)), zzv.zzd(context));
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public zzyc getMobileAdsSettingsManagerWithClientJarVersion(IObjectWrapper iObjectWrapper, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzbv.zzlf();
        return zzay.zza(context, new zzbbi(14300000, i, true, zzayh.zzav(context)));
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public zzadf createNativeAdViewDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return new zzacr((FrameLayout) ObjectWrapper.unwrap(iObjectWrapper), (FrameLayout) ObjectWrapper.unwrap(iObjectWrapper2));
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public zzadk createNativeAdViewHolderDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        return new zzact((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public zzauw createRewardedVideoAd(IObjectWrapper iObjectWrapper, zzalg zzalg, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzbv.zzlf();
        return new zzaun(context, zzv.zzd(context), zzalg, new zzbbi(14300000, i, true, zzayh.zzav(context)));
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public zzaop createAdOverlay(IObjectWrapper iObjectWrapper) {
        Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        AdOverlayInfoParcel zzc = AdOverlayInfoParcel.zzc(activity.getIntent());
        if (zzc == null) {
            return new zzr(activity);
        }
        switch (zzc.zzdsa) {
            case 1:
                return new zzq(activity);
            case 2:
                return new zzx(activity);
            case 3:
                return new zzy(activity);
            case 4:
                return new zzs(activity, zzc);
            default:
                return new zzr(activity);
        }
    }
}
