package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.view.View;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaba;
import com.google.android.gms.internal.ads.zzabg;
import com.google.android.gms.internal.ads.zzabs;
import com.google.android.gms.internal.ads.zzabu;
import com.google.android.gms.internal.ads.zzabz;
import com.google.android.gms.internal.ads.zzacb;
import com.google.android.gms.internal.ads.zzacc;
import com.google.android.gms.internal.ads.zzacd;
import com.google.android.gms.internal.ads.zzace;
import com.google.android.gms.internal.ads.zzadb;
import com.google.android.gms.internal.ads.zzadx;
import com.google.android.gms.internal.ads.zzaeh;
import com.google.android.gms.internal.ads.zzakr;
import com.google.android.gms.internal.ads.zzalg;
import com.google.android.gms.internal.ads.zzals;
import com.google.android.gms.internal.ads.zzalv;
import com.google.android.gms.internal.ads.zzaly;
import com.google.android.gms.internal.ads.zzapl;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzaxf;
import com.google.android.gms.internal.ads.zzaxg;
import com.google.android.gms.internal.ads.zzaxz;
import com.google.android.gms.internal.ads.zzayh;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbbi;
import com.google.android.gms.internal.ads.zzbgg;
import com.google.android.gms.internal.ads.zzwb;
import com.google.android.gms.internal.ads.zzwf;
import com.google.android.gms.internal.ads.zzyp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
public final class zzp extends zzc implements zzace {
    private boolean zzbli;
    private zzaxf zzbmk;
    private boolean zzbml = false;

    public zzp(Context context, zzv zzv, zzwf zzwf, String str, zzalg zzalg, zzbbi zzbbi) {
        super(context, zzwf, str, zzalg, zzbbi, zzv);
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.ads.zzxl
    @Nullable
    public final zzyp getVideoController() {
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zzc
    public final boolean zza(zzwb zzwb, zzaxf zzaxf, boolean z) {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.ads.zzxl
    public final boolean zzb(zzwb zzwb) {
        zzwb zzwb2 = zzwb;
        if (this.zzbls.zzbtn != null && this.zzbls.zzbtn.size() == 1 && this.zzbls.zzbtn.get(0).intValue() == 2) {
            zzaxz.e("Requesting only banner Ad from AdLoader or calling loadAd on returned banner is not yet supported");
            zzbr(0);
            return false;
        } else if (this.zzbls.zzbtm == null) {
            return super.zzb(zzwb);
        } else {
            if (zzwb2.zzcjg != this.zzbli) {
                zzwb2 = new zzwb(zzwb2.versionCode, zzwb2.zzcjb, zzwb2.extras, zzwb2.zzcjc, zzwb2.zzcjd, zzwb2.zzcje, zzwb2.zzcjf, zzwb2.zzcjg || this.zzbli, zzwb2.zzcjh, zzwb2.zzcji, zzwb2.zzcjj, zzwb2.zzcjk, zzwb2.zzcjl, zzwb2.zzcjm, zzwb2.zzcjn, zzwb2.zzcjo, zzwb2.zzcjp, zzwb2.zzcjq, null, zzwb2.zzcjs, zzwb2.zzcjt);
            }
            return super.zzb(zzwb2);
        }
    }

    @Override // com.google.android.gms.ads.internal.zza
    public final void zza(zzaxg zzaxg, zzaba zzaba) {
        this.zzbmk = null;
        if (zzaxg.errorCode != -2) {
            this.zzbmk = zza(zzaxg, zzaxg.errorCode);
        } else if (!zzaxg.zzehy.zzdyd) {
            zzaxz.zzeo("partialAdState is not mediation");
            this.zzbmk = zza(zzaxg, 0);
        }
        if (this.zzbmk != null) {
            zzayh.zzelc.post(new zzq(this));
            return;
        }
        if (zzaxg.zzbst != null) {
            this.zzbls.zzbst = zzaxg.zzbst;
        }
        this.zzbls.zzbtw = 0;
        zzbw zzbw = this.zzbls;
        zzbv.zzle();
        zzbw.zzbss = zzapl.zza(this.zzbls.zzsp, this, zzaxg, this.zzbls.zzbso, null, this.zzbma, this, zzaba);
    }

    private static zzaxf zza(zzaxg zzaxg, int i) {
        return new zzaxf(zzaxg.zzeag.zzdwg, null, zzaxg.zzehy.zzdlq, i, zzaxg.zzehy.zzdlr, zzaxg.zzehy.zzdyf, zzaxg.zzehy.orientation, zzaxg.zzehy.zzdlx, zzaxg.zzeag.zzdwj, zzaxg.zzehy.zzdyd, null, null, null, zzaxg.zzehj, null, zzaxg.zzehy.zzdye, zzaxg.zzbst, zzaxg.zzehy.zzdyc, zzaxg.zzehn, zzaxg.zzeho, zzaxg.zzehy.zzdyi, zzaxg.zzehh, null, zzaxg.zzehy.zzdyr, zzaxg.zzehy.zzdys, zzaxg.zzehy.zzdys, zzaxg.zzehy.zzdyu, zzaxg.zzehy.zzdyv, null, zzaxg.zzehy.zzdlu, zzaxg.zzehy.zzdyy, zzaxg.zzehw, zzaxg.zzehy.zzbph, zzaxg.zzehx, zzaxg.zzehy.zzdzc, zzaxg.zzehy.zzdls, zzaxg.zzehy.zzbpi, zzaxg.zzehy.zzdzd, zzaxg.zzehy.zzdzf);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.ads.internal.zza
    public final boolean zza(@Nullable zzaxf zzaxf, zzaxf zzaxf2) {
        boolean z;
        if (!this.zzbls.zzmj()) {
            throw new IllegalStateException("AdLoader API does not support custom rendering.");
        } else if (!zzaxf2.zzdyd) {
            zzbr(0);
            zzaxz.zzeo("newState is not mediation.");
            return false;
        } else {
            if (zzaxf2.zzdnb != null && zzaxf2.zzdnb.zzuj()) {
                if (this.zzbls.zzmj() && this.zzbls.zzbsq != null) {
                    this.zzbls.zzbsq.zzmm().zzef(zzaxf2.zzdyi);
                }
                if (!super.zza(zzaxf, zzaxf2)) {
                    z = false;
                } else if (!this.zzbls.zzmj() || zzc(zzaxf, zzaxf2)) {
                    if (!this.zzbls.zzmk()) {
                        super.zza(zzaxf2, false);
                    }
                    z = true;
                } else {
                    zzbr(0);
                    z = false;
                }
                if (!z) {
                    return false;
                }
                this.zzbml = true;
            } else if (zzaxf2.zzdnb == null || !zzaxf2.zzdnb.zzuk()) {
                zzbr(0);
                zzaxz.zzeo("Response is neither banner nor native.");
                return false;
            } else if (!zzb(zzaxf, zzaxf2)) {
                return false;
            }
            zze(new ArrayList(Arrays.asList(2)));
            return true;
        }
    }

    private final boolean zzb(zzaxf zzaxf, zzaxf zzaxf2) {
        View view = null;
        zzd(null);
        if (!this.zzbls.zzmj()) {
            zzaxz.zzeo("Native ad does not have custom rendering mode.");
            zzbr(0);
            return false;
        }
        try {
            zzaly zzva = zzaxf2.zzdnc != null ? zzaxf2.zzdnc.zzva() : null;
            zzals zzuu = zzaxf2.zzdnc != null ? zzaxf2.zzdnc.zzuu() : null;
            zzalv zzuv = zzaxf2.zzdnc != null ? zzaxf2.zzdnc.zzuv() : null;
            zzadx zzuz = zzaxf2.zzdnc != null ? zzaxf2.zzdnc.zzuz() : null;
            String zzc = zzc(zzaxf2);
            if (zzva != null && this.zzbls.zzbte != null) {
                String headline = zzva.getHeadline();
                List images = zzva.getImages();
                String body = zzva.getBody();
                zzadb zzsb = zzva.zzsb() != null ? zzva.zzsb() : null;
                String callToAction = zzva.getCallToAction();
                String advertiser = zzva.getAdvertiser();
                double starRating = zzva.getStarRating();
                String store = zzva.getStore();
                String price = zzva.getPrice();
                zzyp videoController = zzva.getVideoController();
                if (zzva.zzvc() != null) {
                    view = (View) ObjectWrapper.unwrap(zzva.zzvc());
                }
                zzabz zzabz = new zzabz(headline, images, body, zzsb, callToAction, advertiser, starRating, store, price, null, videoController, view, zzva.zzsd(), zzc, zzva.getExtras());
                zzabz.zzb(new zzacc(this.zzbls.zzsp, this, this.zzbls.zzbso, zzva, zzabz));
                zza(zzabz);
            } else if (zzuu != null && this.zzbls.zzbte != null) {
                String headline2 = zzuu.getHeadline();
                List images2 = zzuu.getImages();
                String body2 = zzuu.getBody();
                zzadb zzsb2 = zzuu.zzsb() != null ? zzuu.zzsb() : null;
                String callToAction2 = zzuu.getCallToAction();
                double starRating2 = zzuu.getStarRating();
                String store2 = zzuu.getStore();
                String price2 = zzuu.getPrice();
                zzyp videoController2 = zzuu.getVideoController();
                if (zzuu.zzvc() != null) {
                    view = (View) ObjectWrapper.unwrap(zzuu.zzvc());
                }
                zzabz zzabz2 = new zzabz(headline2, images2, body2, zzsb2, callToAction2, null, starRating2, store2, price2, null, videoController2, view, zzuu.zzsd(), zzc, zzuu.getExtras());
                zzabz2.zzb(new zzacc(this.zzbls.zzsp, this, this.zzbls.zzbso, zzuu, zzabz2));
                zza(zzabz2);
            } else if (zzuu != null && this.zzbls.zzbtc != null) {
                String headline3 = zzuu.getHeadline();
                List images3 = zzuu.getImages();
                String body3 = zzuu.getBody();
                zzadb zzsb3 = zzuu.zzsb() != null ? zzuu.zzsb() : null;
                String callToAction3 = zzuu.getCallToAction();
                double starRating3 = zzuu.getStarRating();
                String store3 = zzuu.getStore();
                String price3 = zzuu.getPrice();
                Bundle extras = zzuu.getExtras();
                zzyp videoController3 = zzuu.getVideoController();
                if (zzuu.zzvc() != null) {
                    view = (View) ObjectWrapper.unwrap(zzuu.zzvc());
                }
                zzabs zzabs = new zzabs(headline3, images3, body3, zzsb3, callToAction3, starRating3, store3, price3, null, extras, videoController3, view, zzuu.zzsd(), zzc);
                zzabs.zzb(new zzacc(this.zzbls.zzsp, this, this.zzbls.zzbso, zzuu, zzabs));
                zzayh.zzelc.post(new zzs(this, zzabs));
            } else if (zzuv != null && this.zzbls.zzbte != null) {
                String headline4 = zzuv.getHeadline();
                List images4 = zzuv.getImages();
                String body4 = zzuv.getBody();
                zzadb zzsf = zzuv.zzsf() != null ? zzuv.zzsf() : null;
                String callToAction4 = zzuv.getCallToAction();
                String advertiser2 = zzuv.getAdvertiser();
                zzyp videoController4 = zzuv.getVideoController();
                if (zzuv.zzvc() != null) {
                    view = (View) ObjectWrapper.unwrap(zzuv.zzvc());
                }
                zzabz zzabz3 = new zzabz(headline4, images4, body4, zzsf, callToAction4, advertiser2, -1.0d, null, null, null, videoController4, view, zzuv.zzsd(), zzc, zzuv.getExtras());
                zzabz3.zzb(new zzacc(this.zzbls.zzsp, this, this.zzbls.zzbso, zzuv, zzabz3));
                zza(zzabz3);
            } else if (zzuv != null && this.zzbls.zzbtd != null) {
                String headline5 = zzuv.getHeadline();
                List images5 = zzuv.getImages();
                String body5 = zzuv.getBody();
                zzadb zzsf2 = zzuv.zzsf() != null ? zzuv.zzsf() : null;
                String callToAction5 = zzuv.getCallToAction();
                String advertiser3 = zzuv.getAdvertiser();
                Bundle extras2 = zzuv.getExtras();
                zzyp videoController5 = zzuv.getVideoController();
                if (zzuv.zzvc() != null) {
                    view = (View) ObjectWrapper.unwrap(zzuv.zzvc());
                }
                zzabu zzabu = new zzabu(headline5, images5, body5, zzsf2, callToAction5, advertiser3, null, extras2, videoController5, view, zzuv.zzsd(), zzc);
                zzabu.zzb(new zzacc(this.zzbls.zzsp, this, this.zzbls.zzbso, zzuv, zzabu));
                zzayh.zzelc.post(new zzt(this, zzabu));
            } else if (zzuz == null || this.zzbls.zzbth == null || this.zzbls.zzbth.get(zzuz.getCustomTemplateId()) == null) {
                zzaxz.zzeo("No matching mapper/listener for retrieved native ad template.");
                zzbr(0);
                return false;
            } else {
                zzayh.zzelc.post(new zzu(this, zzuz));
            }
            return super.zza(zzaxf, zzaxf2);
        } catch (RemoteException e) {
            zzaxz.zzd("#007 Could not call remote method.", e);
            zzbr(0);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzb(@Nullable IObjectWrapper iObjectWrapper) {
        Object unwrap = iObjectWrapper != null ? ObjectWrapper.unwrap(iObjectWrapper) : null;
        if (unwrap instanceof zzacd) {
            ((zzacd) unwrap).zzsm();
        }
        super.zzb(this.zzbls.zzbsu, false);
    }

    private final void zza(zzabz zzabz) {
        zzayh.zzelc.post(new zzr(this, zzabz));
    }

    @Override // com.google.android.gms.internal.ads.zzace
    public final void zzi(View view) {
        zzbbd.zzd("#005 Unexpected call to an abstract (unimplemented) method.", null);
    }

    @Override // com.google.android.gms.internal.ads.zzace
    public final void zzjl() {
        zzbbd.zzd("#005 Unexpected call to an abstract (unimplemented) method.", null);
    }

    @Override // com.google.android.gms.internal.ads.zzace
    public final void zzjm() {
        zzbbd.zzd("#005 Unexpected call to an abstract (unimplemented) method.", null);
    }

    @Override // com.google.android.gms.internal.ads.zzace
    public final void zza(zzacd zzacd) {
        zzbbd.zzd("#005 Unexpected call to an abstract (unimplemented) method.", null);
    }

    @Override // com.google.android.gms.internal.ads.zzace
    public final void zzjn() {
        zzbbd.zzd("#005 Unexpected call to an abstract (unimplemented) method.", null);
    }

    @Override // com.google.android.gms.internal.ads.zzace
    public final void zza(zzacb zzacb) {
        zzbbd.zzd("#005 Unexpected call to an abstract (unimplemented) method.", null);
    }

    @Override // com.google.android.gms.internal.ads.zzace
    public final boolean zzjo() {
        if (zzjr() != null) {
            return zzjr().zzdmd;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzace
    public final boolean zzjp() {
        if (zzjr() != null) {
            return zzjr().zzdme;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzace
    public final boolean zzjq() {
        if (zzjr() != null) {
            return zzjr().zzdmf;
        }
        return false;
    }

    @Nullable
    private final zzakr zzjr() {
        if (this.zzbls.zzbsu == null || !this.zzbls.zzbsu.zzdyd) {
            return null;
        }
        return this.zzbls.zzbsu.zzehj;
    }

    private final boolean zzc(zzaxf zzaxf, zzaxf zzaxf2) {
        View zze = zzas.zze(zzaxf2);
        if (zze == null) {
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
                zzg(zze);
            } catch (Throwable th) {
                zzbv.zzlj().zza(th, "AdLoaderManager.swapBannerViews");
                zzaxz.zzc("Could not add mediation view to view hierarchy.", th);
                return false;
            }
        }
        if (this.zzbls.zzbsq.getChildCount() > 1) {
            this.zzbls.zzbsq.showNext();
        }
        if (zzaxf != null) {
            View nextView2 = this.zzbls.zzbsq.getNextView();
            if (nextView2 != null) {
                this.zzbls.zzbsq.removeView(nextView2);
            }
            this.zzbls.zzmi();
        }
        this.zzbls.zzbsq.setMinimumWidth(zzif().widthPixels);
        this.zzbls.zzbsq.setMinimumHeight(zzif().heightPixels);
        this.zzbls.zzbsq.requestLayout();
        this.zzbls.zzbsq.setVisibility(0);
        return true;
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.ads.zzxl
    public final void pause() {
        if (this.zzbml) {
            super.pause();
            return;
        }
        throw new IllegalStateException("Native Ad does not support pause().");
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.ads.zzxl
    public final void resume() {
        if (this.zzbml) {
            super.resume();
            return;
        }
        throw new IllegalStateException("Native Ad does not support resume().");
    }

    public final void zzd(@Nullable List<String> list) {
        Preconditions.checkMainThread("setNativeTemplates must be called on the main UI thread.");
        this.zzbls.zzbtt = list;
    }

    @Override // com.google.android.gms.internal.ads.zzace
    @Nullable
    public final zzaeh zzar(String str) {
        Preconditions.checkMainThread("getOnCustomClickListener must be called on the main UI thread.");
        return this.zzbls.zzbtg.get(str);
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.ads.zzxl
    public final void setManualImpressionsEnabled(boolean z) {
        Preconditions.checkMainThread("setManualImpressionsEnabled must be called from the main thread.");
        this.zzbli = z;
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.ads.zzxl
    public final void zza(zzabg zzabg) {
        throw new IllegalStateException("CustomRendering is not supported by AdLoaderManager.");
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.internal.ads.zzxl
    public final void showInterstitial() {
        throw new IllegalStateException("Interstitial is not supported by AdLoaderManager.");
    }

    public final void zze(List<Integer> list) {
        Preconditions.checkMainThread("setAllowedAdTypes must be called on the main UI thread.");
        this.zzbls.zzbtn = list;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public final void zzil() {
        super.zzil();
        zzaxf zzaxf = this.zzbls.zzbsu;
        if (zzaxf != null && zzaxf.zzdnb != null && zzaxf.zzdnb.zzuj() && this.zzbls.zzbtm != null) {
            try {
                this.zzbls.zzbtm.zza(this, ObjectWrapper.wrap(this.zzbls.zzsp));
                super.zzb(this.zzbls.zzbsu, false);
            } catch (RemoteException e) {
                zzaxz.zzd("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.internal.ads.zzaks
    public final void zziy() {
        if (this.zzbls.zzbsu == null || !"com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzbls.zzbsu.zzdnd) || this.zzbls.zzbsu.zzdnb == null || !this.zzbls.zzbsu.zzdnb.zzuk()) {
            super.zziy();
        } else {
            zzin();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.internal.ads.zzaks
    public final void zzjd() {
        if (this.zzbls.zzbsu == null || !"com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzbls.zzbsu.zzdnd) || this.zzbls.zzbsu.zzdnb == null || !this.zzbls.zzbsu.zzdnb.zzuk()) {
            super.zzjd();
        } else {
            zzim();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzjs() {
        zzb(this.zzbmk);
    }
}
