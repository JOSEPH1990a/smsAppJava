package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import android.view.View;
import com.google.ads.AdRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaan;
import com.google.android.gms.internal.ads.zzaba;
import com.google.android.gms.internal.ads.zzabg;
import com.google.android.gms.internal.ads.zzabq;
import com.google.android.gms.internal.ads.zzabs;
import com.google.android.gms.internal.ads.zzabu;
import com.google.android.gms.internal.ads.zzabw;
import com.google.android.gms.internal.ads.zzabz;
import com.google.android.gms.internal.ads.zzacb;
import com.google.android.gms.internal.ads.zzacc;
import com.google.android.gms.internal.ads.zzacd;
import com.google.android.gms.internal.ads.zzace;
import com.google.android.gms.internal.ads.zzacf;
import com.google.android.gms.internal.ads.zzach;
import com.google.android.gms.internal.ads.zzadb;
import com.google.android.gms.internal.ads.zzadx;
import com.google.android.gms.internal.ads.zzaeh;
import com.google.android.gms.internal.ads.zzaek;
import com.google.android.gms.internal.ads.zzakr;
import com.google.android.gms.internal.ads.zzalg;
import com.google.android.gms.internal.ads.zzalj;
import com.google.android.gms.internal.ads.zzals;
import com.google.android.gms.internal.ads.zzalv;
import com.google.android.gms.internal.ads.zzaly;
import com.google.android.gms.internal.ads.zzaow;
import com.google.android.gms.internal.ads.zzapl;
import com.google.android.gms.internal.ads.zzaqp;
import com.google.android.gms.internal.ads.zzaqt;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzaxf;
import com.google.android.gms.internal.ads.zzaxg;
import com.google.android.gms.internal.ads.zzaxz;
import com.google.android.gms.internal.ads.zzayf;
import com.google.android.gms.internal.ads.zzayh;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbbi;
import com.google.android.gms.internal.ads.zzbcb;
import com.google.android.gms.internal.ads.zzbcl;
import com.google.android.gms.internal.ads.zzbgg;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzri;
import com.google.android.gms.internal.ads.zzwb;
import com.google.android.gms.internal.ads.zzwf;
import com.google.android.gms.internal.ads.zzwu;
import com.google.android.gms.internal.ads.zzyp;
import com.google.android.gms.internal.ads.zzys;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
@ParametersAreNonnullByDefault
public final class zzbb extends zzc implements zzace {
    private final Object mLock;
    private boolean zzbme;
    @VisibleForTesting
    private boolean zzbpv;
    private zzbcl<zzacf> zzbpw;
    private zzbgg zzbpx;
    @Nullable
    private zzbgg zzbpy;
    private int zzbpz;
    @GuardedBy("mLock")
    private zzaqp zzbqa;
    private final String zzbqb;

    public zzbb(Context context, zzv zzv, zzwf zzwf, String str, zzalg zzalg, zzbbi zzbbi) {
        this(context, zzv, zzwf, str, zzalg, zzbbi, false);
    }

    public zzbb(Context context, zzv zzv, zzwf zzwf, String str, zzalg zzalg, zzbbi zzbbi, boolean z) {
        super(context, zzwf, str, zzalg, zzbbi, zzv);
        this.mLock = new Object();
        this.zzbpw = new zzbcl<>();
        this.zzbpz = 1;
        this.zzbqb = UUID.randomUUID().toString();
        this.zzbpv = z;
    }

    public final String getUuid() {
        return this.zzbqb;
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.ads.internal.zza
    public final boolean zza(zzwb zzwb, zzaba zzaba) {
        try {
            zzkm();
            return super.zza(zzwb, zzaba, this.zzbpz);
        } catch (Exception e) {
            if (!zzbbd.isLoggable(4)) {
                return false;
            }
            Log.i(AdRequest.LOGTAG, "Error initializing webview.", e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzkm() throws zzbgq {
        synchronized (this.mLock) {
            zzaxz.v("Initializing webview native ads utills");
            this.zzbqa = new zzaqt(this.zzbls.zzsp, this, this.zzbqb, this.zzbls.zzbso, this.zzbls.zzbsp);
        }
    }

    @Nullable
    public final zzaqp zzkn() {
        zzaqp zzaqp;
        synchronized (this.mLock) {
            zzaqp = this.zzbqa;
        }
        return zzaqp;
    }

    @Override // com.google.android.gms.ads.internal.zza
    public final void zza(zzaxg zzaxg, zzaba zzaba) {
        if (zzaxg.zzbst != null) {
            this.zzbls.zzbst = zzaxg.zzbst;
        }
        if (zzaxg.errorCode != -2) {
            zzayh.zzelc.post(new zzbc(this, zzaxg));
            return;
        }
        int i = zzaxg.zzeag.zzdxq;
        if (i == 1) {
            this.zzbls.zzbtw = 0;
            zzbw zzbw = this.zzbls;
            zzbv.zzle();
            zzbw.zzbss = zzapl.zza(this.zzbls.zzsp, this, zzaxg, this.zzbls.zzbso, null, this.zzbma, this, zzaba);
            String valueOf = String.valueOf(this.zzbls.zzbss.getClass().getName());
            zzaxz.zzdn(valueOf.length() != 0 ? "AdRenderer: ".concat(valueOf) : new String("AdRenderer: "));
            return;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            JSONArray jSONArray2 = new JSONObject(zzaxg.zzehy.zzdyb).getJSONArray("slots");
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                JSONArray optJSONArray = jSONArray2.getJSONObject(i2).optJSONArray("ads");
                int i3 = 0;
                while (optJSONArray != null && i3 < optJSONArray.length()) {
                    jSONArray.put(optJSONArray.get(i3));
                    i3++;
                }
            }
            zzkt();
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < i; i4++) {
                arrayList.add(zzayf.zza(new zzbe(this, i4, jSONArray, i, zzaxg)));
            }
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                try {
                    zzayh.zzelc.post(new zzbf(this, (zzacf) ((zzbcb) arrayList.get(i5)).get(((Long) zzwu.zzpz().zzd(zzaan.zzctf)).longValue(), TimeUnit.MILLISECONDS), i5, arrayList));
                } catch (InterruptedException e) {
                    zzbbd.zzc("", e);
                    Thread.currentThread().interrupt();
                } catch (CancellationException | ExecutionException | TimeoutException e2) {
                    zzbbd.zzc("", e2);
                }
            }
        } catch (JSONException e3) {
            zzaxz.zzc("Malformed native ad response", e3);
            zzbr(0);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public final void zzbr(int i) {
        zzg(i, false);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public final void zzg(int i, boolean z) {
        zzkt();
        super.zzg(i, z);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zzc
    public final boolean zza(zzwb zzwb, zzaxf zzaxf, boolean z) {
        return this.zzblr.zzkv();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.ads.internal.zza
    public final boolean zza(zzaxf zzaxf, zzaxf zzaxf2) {
        View view = null;
        zzd(null);
        if (this.zzbls.zzmj()) {
            if (zzaxf2.zzdyd) {
                zzkt();
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
                        zza(zzabs);
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
                        zza(zzabu);
                    } else if (zzuz == null || this.zzbls.zzbth == null || this.zzbls.zzbth.get(zzuz.getCustomTemplateId()) == null) {
                        zzaxz.zzeo("No matching mapper/listener for retrieved native ad template.");
                        zzbr(0);
                        return false;
                    } else {
                        zzayh.zzelc.post(new zzbk(this, zzuz));
                    }
                } catch (RemoteException e) {
                    zzaxz.zzd("#007 Could not call remote method.", e);
                }
            } else {
                zzacf zzacf = zzaxf2.zzehp;
                if (this.zzbpv) {
                    zzd("Google", zzaxf2.zzdzc);
                    this.zzbpw.set(zzacf);
                } else {
                    boolean z = zzacf instanceof zzabu;
                    if (z && this.zzbls.zzbte != null) {
                        zzd("Google", zzaxf2.zzdzc);
                        zza(zza(zzaxf2.zzehp));
                    } else if (!z || this.zzbls.zzbtd == null) {
                        boolean z2 = zzacf instanceof zzabs;
                        if (z2 && this.zzbls.zzbte != null) {
                            zzd("Google", zzaxf2.zzdzc);
                            zza(zza(zzaxf2.zzehp));
                        } else if (!z2 || this.zzbls.zzbtc == null) {
                            if ((zzacf instanceof zzabw) && this.zzbls.zzbth != null) {
                                zzabw zzabw = (zzabw) zzacf;
                                if (this.zzbls.zzbth.get(zzabw.getCustomTemplateId()) != null) {
                                    zzayh.zzelc.post(new zzbj(this, zzabw.getCustomTemplateId(), zzaxf2));
                                }
                            }
                            if (!(zzacf instanceof zzabq) || this.zzbls.zzbtf == null) {
                                zzaxz.zzeo("No matching listener for retrieved native ad template.");
                                zzbr(0);
                                return false;
                            }
                            zzayh.zzelc.post(new zzbd(this, (zzabq) zzacf));
                        } else {
                            zzd("Google", zzaxf2.zzdzc);
                            zza((zzabs) zzaxf2.zzehp);
                        }
                    } else {
                        zzd("Google", zzaxf2.zzdzc);
                        zza((zzabu) zzaxf2.zzehp);
                    }
                }
            }
            return super.zza(zzaxf, zzaxf2);
        }
        throw new IllegalStateException("Native ad DOES NOT have custom rendering mode.");
    }

    /* access modifiers changed from: protected */
    public final void zzb(@Nullable IObjectWrapper iObjectWrapper) {
        Object unwrap = iObjectWrapper != null ? ObjectWrapper.unwrap(iObjectWrapper) : null;
        if (unwrap instanceof zzacd) {
            ((zzacd) unwrap).zzsm();
        }
        super.zzb(this.zzbls.zzbsu, false);
    }

    /* access modifiers changed from: protected */
    public final Future<zzacf> zzko() {
        return this.zzbpw;
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.ads.zzxl
    public final void pause() {
        throw new IllegalStateException("Native Ad DOES NOT support pause().");
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.ads.zzxl
    public final void resume() {
        throw new IllegalStateException("Native Ad DOES NOT support resume().");
    }

    private final void zza(zzabs zzabs) {
        zzayh.zzelc.post(new zzbg(this, zzabs));
    }

    private final void zza(zzabz zzabz) {
        zzayh.zzelc.post(new zzbh(this, zzabz));
    }

    private final void zza(zzabu zzabu) {
        zzayh.zzelc.post(new zzbi(this, zzabu));
    }

    private final void zzd(String str, boolean z) {
        String str2;
        if (z) {
            if (this.zzbpy != null || this.zzbpx != null) {
                boolean z2 = true;
                boolean z3 = this.zzbpy != null;
                if (this.zzbpx == null) {
                    z2 = false;
                }
                zzbgg zzbgg = null;
                if (z3) {
                    str2 = null;
                    zzbgg = this.zzbpy;
                } else if (z2) {
                    zzbgg = this.zzbpx;
                    str2 = "javascript";
                } else {
                    str2 = null;
                }
                if (zzbgg.getWebView() != null && zzbv.zzlw().zzk(this.zzbls.zzsp)) {
                    int i = this.zzbls.zzbsp.zzeou;
                    int i2 = this.zzbls.zzbsp.zzeov;
                    StringBuilder sb = new StringBuilder(23);
                    sb.append(i);
                    sb.append(".");
                    sb.append(i2);
                    this.zzblx = zzbv.zzlw().zza(sb.toString(), zzbgg.getWebView(), "", "javascript", str2, str);
                    if (this.zzblx != null) {
                        zzbgg.zzaa(this.zzblx);
                        if (z2) {
                            IObjectWrapper iObjectWrapper = this.zzblx;
                            View view = this.zzbpx.getView();
                            if (view != null) {
                                zzbv.zzlw().zza(iObjectWrapper, view);
                            }
                        }
                        zzbv.zzlw().zzo(this.zzblx);
                    }
                }
            }
        }
    }

    private final boolean zzjj() {
        return this.zzbls.zzbsu != null && this.zzbls.zzbsu.zzdzc;
    }

    @Override // com.google.android.gms.internal.ads.zzace
    public final void zzi(View view) {
        boolean z = this.zzbpy != null;
        if (zzjj() && this.zzblx != null && z && view != null) {
            zzbv.zzlw().zza(this.zzblx, view);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzace
    public final void zzjl() {
        if (zzjj() && this.zzblx != null) {
            zzbgg zzbgg = this.zzbpy;
            if (zzbgg == null && (zzbgg = this.zzbpx) == null) {
                zzbgg = null;
            }
            if (zzbgg != null) {
                zzbgg.zza("onSdkImpression", new HashMap());
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public final void zzil() {
        zzm(false);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public final void zzm(boolean z) {
        super.zzm(z);
        if (this.zzbme) {
            if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcuk)).booleanValue()) {
                zzkp();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzace
    public final void zza(zzacd zzacd) {
        if (this.zzbls.zzbsu.zzehh != null && this.zzbls.zzbtk == null) {
            zzbv.zzlj().zzym().zza(this.zzbls.zzbst, this.zzbls.zzbsu, new zzri(zzacd), (zzbgg) null);
        }
    }

    public final void zzkp() {
        if (this.zzbls.zzbsu == null || this.zzbpx == null) {
            this.zzbme = true;
            zzaxz.zzeo("Request to enable ActiveView before adState is available.");
            return;
        }
        zzbv.zzlj().zzym().zza(this.zzbls.zzbst, this.zzbls.zzbsu, this.zzbpx.getView(), this.zzbpx);
        this.zzbme = false;
    }

    public final void zzkq() {
        this.zzbme = false;
        if (this.zzbls.zzbsu == null || this.zzbpx == null) {
            zzaxz.zzeo("Request to enable ActiveView before adState is available.");
        } else {
            zzbv.zzlj().zzym().zzh(this.zzbls.zzbsu);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzace, com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.ads.zzxl
    public final String getAdUnitId() {
        return this.zzbls.zzbsn;
    }

    public final void zzd(@Nullable List<String> list) {
        Preconditions.checkMainThread("setNativeTemplates must be called on the main UI thread.");
        this.zzbls.zzbtt = list;
    }

    @Override // com.google.android.gms.internal.ads.zzace
    @Nullable
    public final zzaeh zzar(String str) {
        Preconditions.checkMainThread("getOnCustomClickListener must be called on the main UI thread.");
        if (this.zzbls.zzbtg == null) {
            return null;
        }
        return this.zzbls.zzbtg.get(str);
    }

    public final SimpleArrayMap<String, zzaek> zzkr() {
        Preconditions.checkMainThread("getOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        return this.zzbls.zzbth;
    }

    public final void zzbs(int i) {
        Preconditions.checkMainThread("setMaxNumberOfAds must be called on the main UI thread.");
        this.zzbpz = i;
    }

    public final void zzf(zzbgg zzbgg) {
        this.zzbpx = zzbgg;
    }

    public final void zzg(@Nullable zzbgg zzbgg) {
        this.zzbpy = zzbgg;
    }

    @Override // com.google.android.gms.internal.ads.zzace
    public final void zzjn() {
        zzbgg zzbgg = this.zzbpx;
        if (zzbgg != null) {
            zzbgg.destroy();
            this.zzbpx = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzace
    public final void zzjm() {
        this.zzblx = null;
        zzbgg zzbgg = this.zzbpy;
        if (zzbgg != null) {
            zzbgg.destroy();
            this.zzbpy = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzace
    public final void zza(zzacb zzacb) {
        zzbgg zzbgg = this.zzbpx;
        if (zzbgg != null) {
            zzbgg.zzb(zzacb);
        }
    }

    public final void zzks() {
        zzbgg zzbgg;
        zzbgg zzbgg2 = this.zzbpx;
        if (zzbgg2 != null && zzbgg2.zzabu() != null && this.zzbls.zzbti != null && this.zzbls.zzbti.zzdcw != null) {
            this.zzbpx.zzabu().zzb(this.zzbls.zzbti.zzdcw);
        } else if (this.zzbls.zzbtf != null && (zzbgg = this.zzbpx) != null && zzbgg.zzabu() != null) {
            this.zzbpx.zzabu().zza(false, true, false);
        }
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

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.ads.zzxl
    public final void zza(zzaow zzaow) {
        throw new IllegalStateException("In App Purchase is NOT supported by NativeAdManager.");
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.ads.zzxl
    public final void zza(zzabg zzabg) {
        throw new IllegalStateException("CustomRendering is NOT supported by NativeAdManager.");
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.internal.ads.zzxl
    public final void showInterstitial() {
        throw new IllegalStateException("Interstitial is NOT supported by NativeAdManager.");
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.internal.ads.zzaks
    public final void zziy() {
        if (this.zzbls.zzbsu == null || !"com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzbls.zzbsu.zzdnd)) {
            super.zziy();
        } else {
            zzin();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.internal.ads.zzaks
    public final void zzjd() {
        if (this.zzbls.zzbsu == null || !"com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzbls.zzbsu.zzdnd)) {
            super.zzjd();
        } else {
            zzim();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.internal.ads.zzaks
    public final void zzix() {
        zzys zzqh;
        zzaxf zzaxf = this.zzbls.zzbsu;
        if (zzaxf.zzdnc == null) {
            super.zzix();
            return;
        }
        try {
            zzalj zzalj = zzaxf.zzdnc;
            zzyp zzyp = null;
            zzals zzuu = zzalj.zzuu();
            if (zzuu != null) {
                zzyp = zzuu.getVideoController();
            } else {
                zzalv zzuv = zzalj.zzuv();
                if (zzuv != null) {
                    zzyp = zzuv.getVideoController();
                } else {
                    zzadx zzuz = zzalj.zzuz();
                    if (zzuz != null) {
                        zzyp = zzuz.getVideoController();
                    }
                }
            }
            if (zzyp != null && (zzqh = zzyp.zzqh()) != null) {
                zzqh.onVideoEnd();
            }
        } catch (RemoteException e) {
            zzaxz.zzd("#007 Could not call remote method.", e);
        }
    }

    /* access modifiers changed from: private */
    public static zzabz zza(zzacf zzacf) {
        zzabz zzabz;
        Object obj = null;
        if (zzacf instanceof zzabu) {
            zzabu zzabu = (zzabu) zzacf;
            zzabz = new zzabz(zzabu.getHeadline(), zzabu.getImages(), zzabu.getBody(), zzabu.zzsf(), zzabu.getCallToAction(), zzabu.getAdvertiser(), -1.0d, null, null, zzabu.zzrw(), zzabu.getVideoController(), zzabu.zzrx(), zzabu.zzsd(), zzabu.getMediationAdapterClassName(), zzabu.getExtras());
            if (zzabu.zzsc() != null) {
                obj = ObjectWrapper.unwrap(zzabu.zzsc());
            }
        } else if (zzacf instanceof zzabs) {
            zzabs zzabs = (zzabs) zzacf;
            zzabz = new zzabz(zzabs.getHeadline(), zzabs.getImages(), zzabs.getBody(), zzabs.zzsb(), zzabs.getCallToAction(), null, zzabs.getStarRating(), zzabs.getStore(), zzabs.getPrice(), zzabs.zzrw(), zzabs.getVideoController(), zzabs.zzrx(), zzabs.zzsd(), zzabs.getMediationAdapterClassName(), zzabs.getExtras());
            if (zzabs.zzsc() != null) {
                obj = ObjectWrapper.unwrap(zzabs.zzsc());
            }
        } else {
            zzabz = null;
        }
        if (obj instanceof zzach) {
            zzabz.zzb((zzach) obj);
        }
        return zzabz;
    }

    /* access modifiers changed from: private */
    public static void zza(zzbw zzbw, zzbw zzbw2) {
        if (zzbw2.zzbtc == null) {
            zzbw2.zzbtc = zzbw.zzbtc;
        }
        if (zzbw2.zzbtd == null) {
            zzbw2.zzbtd = zzbw.zzbtd;
        }
        if (zzbw2.zzbtg == null) {
            zzbw2.zzbtg = zzbw.zzbtg;
        }
        if (zzbw2.zzbth == null) {
            zzbw2.zzbth = zzbw.zzbth;
        }
        if (zzbw2.zzbtj == null) {
            zzbw2.zzbtj = zzbw.zzbtj;
        }
        if (zzbw2.zzbti == null) {
            zzbw2.zzbti = zzbw.zzbti;
        }
        if (zzbw2.zzbtt == null) {
            zzbw2.zzbtt = zzbw.zzbtt;
        }
        if (zzbw2.zzbsw == null) {
            zzbw2.zzbsw = zzbw.zzbsw;
        }
        if (zzbw2.zzbtu == null) {
            zzbw2.zzbtu = zzbw.zzbtu;
        }
        if (zzbw2.zzbsx == null) {
            zzbw2.zzbsx = zzbw.zzbsx;
        }
        if (zzbw2.zzbsy == null) {
            zzbw2.zzbsy = zzbw.zzbsy;
        }
        if (zzbw2.zzbst == null) {
            zzbw2.zzbst = zzbw.zzbst;
        }
        if (zzbw2.zzbsu == null) {
            zzbw2.zzbsu = zzbw.zzbsu;
        }
        if (zzbw2.zzbsv == null) {
            zzbw2.zzbsv = zzbw.zzbsv;
        }
    }

    private final void zzkt() {
        zzaqp zzkn = zzkn();
        if (zzkn != null) {
            zzkn.zzug();
        }
    }
}
