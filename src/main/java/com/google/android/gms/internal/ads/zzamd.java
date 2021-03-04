package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.mediation.zzb;
import com.google.android.gms.ads.reward.mediation.InitializableMediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.zzc;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@zzark
public final class zzamd extends zzalk {
    private final MediationAdapter zzdnx;
    private zzame zzdny;

    public zzamd(@NonNull MediationAdapter mediationAdapter) {
        this.zzdnx = mediationAdapter;
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final IObjectWrapper zzut() throws RemoteException {
        MediationAdapter mediationAdapter = this.zzdnx;
        if (!(mediationAdapter instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbbd.zzeo(valueOf.length() != 0 ? "Not a MediationBannerAdapter: ".concat(valueOf) : new String("Not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        try {
            return ObjectWrapper.wrap(((MediationBannerAdapter) mediationAdapter).getBannerView());
        } catch (Throwable th) {
            zzbbd.zzb("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void zza(IObjectWrapper iObjectWrapper, zzwf zzwf, zzwb zzwb, String str, zzalm zzalm) throws RemoteException {
        zza(iObjectWrapper, zzwf, zzwb, str, null, zzalm);
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void zza(IObjectWrapper iObjectWrapper, zzwf zzwf, zzwb zzwb, String str, String str2, zzalm zzalm) throws RemoteException {
        Date date;
        MediationAdapter mediationAdapter = this.zzdnx;
        if (!(mediationAdapter instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbbd.zzeo(valueOf.length() != 0 ? "Not a MediationBannerAdapter: ".concat(valueOf) : new String("Not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        zzbbd.zzdn("Requesting banner ad from adapter.");
        try {
            MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.zzdnx;
            HashSet hashSet = zzwb.zzcjd != null ? new HashSet(zzwb.zzcjd) : null;
            if (zzwb.zzcjb == -1) {
                date = null;
            } else {
                date = new Date(zzwb.zzcjb);
            }
            mediationBannerAdapter.requestBannerAd((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzame(zzalm), zza(str, zzwb, str2), zzc.zza(zzwf.width, zzwf.height, zzwf.zzckk), new zzamc(date, zzwb.zzcjc, hashSet, zzwb.zzcjj, zzm(zzwb), zzwb.zzcjf, zzwb.zzcjq), zzwb.zzcjl != null ? zzwb.zzcjl.getBundle(mediationBannerAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            zzbbd.zzb("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final Bundle zzuw() {
        MediationAdapter mediationAdapter = this.zzdnx;
        if (mediationAdapter instanceof zzbix) {
            return ((zzbix) mediationAdapter).zzuw();
        }
        String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
        zzbbd.zzeo(valueOf.length() != 0 ? "Not a v2 MediationBannerAdapter: ".concat(valueOf) : new String("Not a v2 MediationBannerAdapter: "));
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void zza(IObjectWrapper iObjectWrapper, zzwb zzwb, String str, zzalm zzalm) throws RemoteException {
        zza(iObjectWrapper, zzwb, str, (String) null, zzalm);
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void zza(IObjectWrapper iObjectWrapper, zzwb zzwb, String str, String str2, zzalm zzalm) throws RemoteException {
        Date date;
        MediationAdapter mediationAdapter = this.zzdnx;
        if (!(mediationAdapter instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbbd.zzeo(valueOf.length() != 0 ? "Not a MediationInterstitialAdapter: ".concat(valueOf) : new String("Not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzbbd.zzdn("Requesting interstitial ad from adapter.");
        try {
            MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.zzdnx;
            HashSet hashSet = zzwb.zzcjd != null ? new HashSet(zzwb.zzcjd) : null;
            if (zzwb.zzcjb == -1) {
                date = null;
            } else {
                date = new Date(zzwb.zzcjb);
            }
            mediationInterstitialAdapter.requestInterstitialAd((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzame(zzalm), zza(str, zzwb, str2), new zzamc(date, zzwb.zzcjc, hashSet, zzwb.zzcjj, zzm(zzwb), zzwb.zzcjf, zzwb.zzcjq), zzwb.zzcjl != null ? zzwb.zzcjl.getBundle(mediationInterstitialAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            zzbbd.zzb("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final Bundle getInterstitialAdapterInfo() {
        MediationAdapter mediationAdapter = this.zzdnx;
        if (mediationAdapter instanceof zzbiy) {
            return ((zzbiy) mediationAdapter).getInterstitialAdapterInfo();
        }
        String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
        zzbbd.zzeo(valueOf.length() != 0 ? "Not a v2 MediationInterstitialAdapter: ".concat(valueOf) : new String("Not a v2 MediationInterstitialAdapter: "));
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void zza(IObjectWrapper iObjectWrapper, zzwb zzwb, String str, String str2, zzalm zzalm, zzacp zzacp, List<String> list) throws RemoteException {
        Date date;
        MediationAdapter mediationAdapter = this.zzdnx;
        if (!(mediationAdapter instanceof MediationNativeAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbbd.zzeo(valueOf.length() != 0 ? "Not a MediationNativeAdapter: ".concat(valueOf) : new String("Not a MediationNativeAdapter: "));
            throw new RemoteException();
        }
        try {
            MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) mediationAdapter;
            Bundle bundle = null;
            HashSet hashSet = zzwb.zzcjd != null ? new HashSet(zzwb.zzcjd) : null;
            if (zzwb.zzcjb == -1) {
                date = null;
            } else {
                date = new Date(zzwb.zzcjb);
            }
            zzamh zzamh = new zzamh(date, zzwb.zzcjc, hashSet, zzwb.zzcjj, zzm(zzwb), zzwb.zzcjf, zzacp, list, zzwb.zzcjq);
            if (zzwb.zzcjl != null) {
                bundle = zzwb.zzcjl.getBundle(mediationNativeAdapter.getClass().getName());
            }
            this.zzdny = new zzame(zzalm);
            mediationNativeAdapter.requestNativeAd((Context) ObjectWrapper.unwrap(iObjectWrapper), this.zzdny, zza(str, zzwb, str2), zzamh, bundle);
        } catch (Throwable th) {
            zzbbd.zzb("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final Bundle zzux() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final zzals zzuu() {
        NativeAdMapper zzvd = this.zzdny.zzvd();
        if (zzvd instanceof NativeAppInstallAdMapper) {
            return new zzamf((NativeAppInstallAdMapper) zzvd);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final zzaly zzva() {
        UnifiedNativeAdMapper zzve = this.zzdny.zzve();
        if (zzve != null) {
            return new zzamx(zzve);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final zzalv zzuv() {
        NativeAdMapper zzvd = this.zzdny.zzvd();
        if (zzvd instanceof NativeContentAdMapper) {
            return new zzamg((NativeContentAdMapper) zzvd);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final zzadx zzuz() {
        NativeCustomTemplateAd zzvf = this.zzdny.zzvf();
        if (zzvf instanceof zzaea) {
            return ((zzaea) zzvf).zzsx();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final boolean zzuy() {
        return this.zzdnx instanceof InitializableMediationRewardedVideoAdAdapter;
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void zza(IObjectWrapper iObjectWrapper, zzwb zzwb, String str, zzavz zzavz, String str2) throws RemoteException {
        Bundle bundle;
        zzamc zzamc;
        Date date;
        MediationAdapter mediationAdapter = this.zzdnx;
        if (!(mediationAdapter instanceof MediationRewardedVideoAdAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbbd.zzeo(valueOf.length() != 0 ? "Not a MediationRewardedVideoAdAdapter: ".concat(valueOf) : new String("Not a MediationRewardedVideoAdAdapter: "));
            throw new RemoteException();
        }
        zzbbd.zzdn("Initialize rewarded video adapter.");
        try {
            MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzdnx;
            Bundle zza = zza(str2, zzwb, (String) null);
            if (zzwb != null) {
                HashSet hashSet = zzwb.zzcjd != null ? new HashSet(zzwb.zzcjd) : null;
                if (zzwb.zzcjb == -1) {
                    date = null;
                } else {
                    date = new Date(zzwb.zzcjb);
                }
                zzamc zzamc2 = new zzamc(date, zzwb.zzcjc, hashSet, zzwb.zzcjj, zzm(zzwb), zzwb.zzcjf, zzwb.zzcjq);
                if (zzwb.zzcjl != null) {
                    bundle = zzwb.zzcjl.getBundle(mediationRewardedVideoAdAdapter.getClass().getName());
                    zzamc = zzamc2;
                } else {
                    bundle = null;
                    zzamc = zzamc2;
                }
            } else {
                zzamc = null;
                bundle = null;
            }
            mediationRewardedVideoAdAdapter.initialize((Context) ObjectWrapper.unwrap(iObjectWrapper), zzamc, str, new zzawc(zzavz), zza, bundle);
        } catch (Throwable th) {
            zzbbd.zzb("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void zza(IObjectWrapper iObjectWrapper, zzavz zzavz, List<String> list) throws RemoteException {
        MediationAdapter mediationAdapter = this.zzdnx;
        if (!(mediationAdapter instanceof InitializableMediationRewardedVideoAdAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbbd.zzeo(valueOf.length() != 0 ? "Not an InitializableMediationRewardedVideoAdAdapter: ".concat(valueOf) : new String("Not an InitializableMediationRewardedVideoAdAdapter: "));
            throw new RemoteException();
        }
        zzbbd.zzdn("Initialize rewarded video adapter.");
        try {
            InitializableMediationRewardedVideoAdAdapter initializableMediationRewardedVideoAdAdapter = (InitializableMediationRewardedVideoAdAdapter) this.zzdnx;
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                arrayList.add(zza(str, (zzwb) null, (String) null));
            }
            initializableMediationRewardedVideoAdAdapter.initialize((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzawc(zzavz), arrayList);
        } catch (Throwable th) {
            zzbbd.zzc("Could not initialize rewarded video adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void zzc(zzwb zzwb, String str) throws RemoteException {
        zza(zzwb, str, (String) null);
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void zza(zzwb zzwb, String str, String str2) throws RemoteException {
        Date date;
        MediationAdapter mediationAdapter = this.zzdnx;
        if (!(mediationAdapter instanceof MediationRewardedVideoAdAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbbd.zzeo(valueOf.length() != 0 ? "Not a MediationRewardedVideoAdAdapter: ".concat(valueOf) : new String("Not a MediationRewardedVideoAdAdapter: "));
            throw new RemoteException();
        }
        zzbbd.zzdn("Requesting rewarded video ad from adapter.");
        try {
            MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzdnx;
            Bundle bundle = null;
            HashSet hashSet = zzwb.zzcjd != null ? new HashSet(zzwb.zzcjd) : null;
            if (zzwb.zzcjb == -1) {
                date = null;
            } else {
                date = new Date(zzwb.zzcjb);
            }
            zzamc zzamc = new zzamc(date, zzwb.zzcjc, hashSet, zzwb.zzcjj, zzm(zzwb), zzwb.zzcjf, zzwb.zzcjq);
            if (zzwb.zzcjl != null) {
                bundle = zzwb.zzcjl.getBundle(mediationRewardedVideoAdAdapter.getClass().getName());
            }
            mediationRewardedVideoAdAdapter.loadAd(zzamc, zza(str, zzwb, str2), bundle);
        } catch (Throwable th) {
            zzbbd.zzb("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void showVideo() throws RemoteException {
        MediationAdapter mediationAdapter = this.zzdnx;
        if (!(mediationAdapter instanceof MediationRewardedVideoAdAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbbd.zzeo(valueOf.length() != 0 ? "Not a MediationRewardedVideoAdAdapter: ".concat(valueOf) : new String("Not a MediationRewardedVideoAdAdapter: "));
            throw new RemoteException();
        }
        zzbbd.zzdn("Show rewarded video ad from adapter.");
        try {
            ((MediationRewardedVideoAdAdapter) this.zzdnx).showVideo();
        } catch (Throwable th) {
            zzbbd.zzb("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final boolean isInitialized() throws RemoteException {
        MediationAdapter mediationAdapter = this.zzdnx;
        if (!(mediationAdapter instanceof MediationRewardedVideoAdAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbbd.zzeo(valueOf.length() != 0 ? "Not a MediationRewardedVideoAdAdapter: ".concat(valueOf) : new String("Not a MediationRewardedVideoAdAdapter: "));
            throw new RemoteException();
        }
        zzbbd.zzdn("Check if adapter is initialized.");
        try {
            return ((MediationRewardedVideoAdAdapter) this.zzdnx).isInitialized();
        } catch (Throwable th) {
            zzbbd.zzb("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void setImmersiveMode(boolean z) throws RemoteException {
        MediationAdapter mediationAdapter = this.zzdnx;
        if (!(mediationAdapter instanceof OnImmersiveModeUpdatedListener)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbbd.zzen(valueOf.length() != 0 ? "Not an OnImmersiveModeUpdatedListener: ".concat(valueOf) : new String("Not an OnImmersiveModeUpdatedListener: "));
            return;
        }
        try {
            ((OnImmersiveModeUpdatedListener) mediationAdapter).onImmersiveModeUpdated(z);
        } catch (Throwable th) {
            zzbbd.zzb("", th);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final zzyp getVideoController() {
        MediationAdapter mediationAdapter = this.zzdnx;
        if (!(mediationAdapter instanceof zzb)) {
            return null;
        }
        try {
            return ((zzb) mediationAdapter).getVideoController();
        } catch (Throwable th) {
            zzbbd.zzb("", th);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void showInterstitial() throws RemoteException {
        MediationAdapter mediationAdapter = this.zzdnx;
        if (!(mediationAdapter instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbbd.zzeo(valueOf.length() != 0 ? "Not a MediationInterstitialAdapter: ".concat(valueOf) : new String("Not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzbbd.zzdn("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzdnx).showInterstitial();
        } catch (Throwable th) {
            zzbbd.zzb("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void destroy() throws RemoteException {
        try {
            this.zzdnx.onDestroy();
        } catch (Throwable th) {
            zzbbd.zzb("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void pause() throws RemoteException {
        try {
            this.zzdnx.onPause();
        } catch (Throwable th) {
            zzbbd.zzb("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void resume() throws RemoteException {
        try {
            this.zzdnx.onResume();
        } catch (Throwable th) {
            zzbbd.zzb("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        MediationAdapter mediationAdapter = this.zzdnx;
        if (mediationAdapter instanceof OnContextChangedListener) {
            ((OnContextChangedListener) mediationAdapter).onContextChanged(context);
        }
    }

    private final Bundle zza(String str, zzwb zzwb, String str2) throws RemoteException {
        Bundle bundle;
        String valueOf = String.valueOf(str);
        zzbbd.zzeo(valueOf.length() != 0 ? "Server parameters: ".concat(valueOf) : new String("Server parameters: "));
        try {
            Bundle bundle2 = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                bundle = new Bundle();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    bundle.putString(next, jSONObject.getString(next));
                }
            } else {
                bundle = bundle2;
            }
            if (this.zzdnx instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                if (zzwb != null) {
                    bundle.putInt("tagForChildDirectedTreatment", zzwb.zzcjf);
                }
            }
            return bundle;
        } catch (Throwable th) {
            zzbbd.zzb("", th);
            throw new RemoteException();
        }
    }

    private static boolean zzm(zzwb zzwb) {
        if (zzwb.zzcje) {
            return true;
        }
        zzwu.zzpv();
        return zzbat.zzaaq();
    }
}
