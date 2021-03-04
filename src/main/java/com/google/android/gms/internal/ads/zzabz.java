package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
public final class zzabz extends zzaex implements zzacg {
    private Bundle mExtras;
    private final Object mLock = new Object();
    private String zzdaw;
    private List<zzabr> zzdax;
    private String zzday;
    private zzadb zzdaz;
    private String zzdba;
    private double zzdbb;
    private String zzdbc;
    private String zzdbd;
    @Nullable
    private zzabm zzdbe;
    @Nullable
    private zzyp zzdbf;
    @Nullable
    private View zzdbg;
    @Nullable
    private IObjectWrapper zzdbh;
    @Nullable
    private String zzdbi;
    private zzacd zzdbj;
    private String zzdbm;
    private List<Object> zzdbs;
    private boolean zzdbt;

    public zzabz(String str, List<zzabr> list, String str2, zzadb zzadb, String str3, String str4, double d, String str5, String str6, @Nullable zzabm zzabm, zzyp zzyp, View view, IObjectWrapper iObjectWrapper, String str7, Bundle bundle) {
        this.zzdaw = str;
        this.zzdax = list;
        this.zzdbs = null;
        this.zzdbt = false;
        this.zzday = str2;
        this.zzdaz = zzadb;
        this.zzdba = str3;
        this.zzdbm = str4;
        this.zzdbb = d;
        this.zzdbc = str5;
        this.zzdbd = str6;
        this.zzdbe = zzabm;
        this.zzdbf = zzyp;
        this.zzdbg = view;
        this.zzdbh = iObjectWrapper;
        this.zzdbi = str7;
        this.mExtras = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzacf
    public final String getCustomTemplateId() {
        return "";
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final List getMuteThisAdReasons() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final boolean isCustomMuteThisAdEnabled() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void zza(zzyh zzyh) {
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void zza(zzyl zzyl) {
    }

    @Override // com.google.android.gms.internal.ads.zzacf
    public final String zzrv() {
        return "6";
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final String getHeadline() {
        return this.zzdaw;
    }

    @Override // com.google.android.gms.internal.ads.zzacg, com.google.android.gms.internal.ads.zzaew
    public final List getImages() {
        return this.zzdax;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final String getBody() {
        return this.zzday;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final zzadb zzsb() {
        return this.zzdaz;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final String getCallToAction() {
        return this.zzdba;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final String getAdvertiser() {
        return this.zzdbm;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final double getStarRating() {
        return this.zzdbb;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final String getStore() {
        return this.zzdbc;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final String getPrice() {
        return this.zzdbd;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final zzyp getVideoController() {
        return this.zzdbf;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final IObjectWrapper zzsc() {
        return ObjectWrapper.wrap(this.zzdbj);
    }

    @Override // com.google.android.gms.internal.ads.zzacf
    public final void zzb(zzacd zzacd) {
        synchronized (this.mLock) {
            this.zzdbj = zzacd;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacf
    public final zzabm zzrw() {
        return this.zzdbe;
    }

    @Override // com.google.android.gms.internal.ads.zzacf
    public final View zzrx() {
        return this.zzdbg;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final IObjectWrapper zzsd() {
        return this.zzdbh;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    @Nullable
    public final String getMediationAdapterClassName() {
        return this.zzdbi;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final Bundle getExtras() {
        return this.mExtras;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final zzacx zzse() {
        return this.zzdbe;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void destroy() {
        zzayh.zzelc.post(new zzaca(this));
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void performClick(Bundle bundle) {
        synchronized (this.mLock) {
            if (this.zzdbj == null) {
                zzaxz.e("#001 Attempt to perform click before app native ad initialized.");
            } else {
                this.zzdbj.performClick(bundle);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final boolean recordImpression(Bundle bundle) {
        synchronized (this.mLock) {
            if (this.zzdbj == null) {
                zzaxz.e("#002 Attempt to record impression before native ad initialized.");
                return false;
            }
            return this.zzdbj.recordImpression(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void reportTouchEvent(Bundle bundle) {
        synchronized (this.mLock) {
            if (this.zzdbj == null) {
                zzaxz.e("#003 Attempt to report touch event before native ad initialized.");
            } else {
                this.zzdbj.reportTouchEvent(bundle);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void zza(zzaet zzaet) {
        this.zzdbj.zza(zzaet);
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void zzsi() {
        synchronized (this.mLock) {
            if (this.zzdbj != null) {
                this.zzdbj.zzsi();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void recordCustomClickGesture() {
        synchronized (this.mLock) {
            if (this.zzdbj != null) {
                this.zzdbj.recordCustomClickGesture();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void cancelUnconfirmedClick() {
        this.zzdbj.cancelUnconfirmedClick();
    }
}
