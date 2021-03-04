package com.google.android.gms.internal.ads;

import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@zzark
public final class zzabw extends zzady implements zzacf {
    private final Object mLock = new Object();
    private final zzabm zzdbe;
    @Nullable
    private zzyp zzdbf;
    @Nullable
    private View zzdbg;
    private zzacd zzdbj;
    private final String zzdbo;
    private final SimpleArrayMap<String, zzabr> zzdbp;
    private final SimpleArrayMap<String, String> zzdbq;

    public zzabw(String str, SimpleArrayMap<String, zzabr> simpleArrayMap, SimpleArrayMap<String, String> simpleArrayMap2, zzabm zzabm, zzyp zzyp, View view) {
        this.zzdbo = str;
        this.zzdbp = simpleArrayMap;
        this.zzdbq = simpleArrayMap2;
        this.zzdbe = zzabm;
        this.zzdbf = zzyp;
        this.zzdbg = view;
    }

    @Override // com.google.android.gms.internal.ads.zzacf
    public final String zzrv() {
        return "3";
    }

    @Override // com.google.android.gms.internal.ads.zzadx
    public final String zzbq(String str) {
        return this.zzdbq.get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzadx
    public final zzadb zzbr(String str) {
        return this.zzdbp.get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzadx
    public final List<String> getAvailableAssetNames() {
        String[] strArr = new String[(this.zzdbp.size() + this.zzdbq.size())];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.zzdbp.size()) {
            strArr[i3] = this.zzdbp.keyAt(i2);
            i2++;
            i3++;
        }
        while (i < this.zzdbq.size()) {
            strArr[i3] = this.zzdbq.keyAt(i);
            i++;
            i3++;
        }
        return Arrays.asList(strArr);
    }

    @Override // com.google.android.gms.internal.ads.zzadx, com.google.android.gms.internal.ads.zzacf
    public final String getCustomTemplateId() {
        return this.zzdbo;
    }

    @Override // com.google.android.gms.internal.ads.zzacf
    public final void zzb(zzacd zzacd) {
        synchronized (this.mLock) {
            this.zzdbj = zzacd;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadx
    public final IObjectWrapper zzsc() {
        return ObjectWrapper.wrap(this.zzdbj);
    }

    @Override // com.google.android.gms.internal.ads.zzacf
    public final zzabm zzrw() {
        return this.zzdbe;
    }

    @Override // com.google.android.gms.internal.ads.zzadx
    public final zzyp getVideoController() {
        return this.zzdbf;
    }

    @Override // com.google.android.gms.internal.ads.zzadx
    public final boolean zzi(IObjectWrapper iObjectWrapper) {
        if (this.zzdbj == null) {
            zzbbd.e("Attempt to call renderVideoInMediaView before ad initialized.");
            return false;
        } else if (this.zzdbg == null) {
            return false;
        } else {
            zzabx zzabx = new zzabx(this);
            this.zzdbj.zza((FrameLayout) ObjectWrapper.unwrap(iObjectWrapper), zzabx);
            return true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacf
    public final View zzrx() {
        return this.zzdbg;
    }

    @Override // com.google.android.gms.internal.ads.zzadx
    public final void performClick(String str) {
        synchronized (this.mLock) {
            if (this.zzdbj == null) {
                zzbbd.e("#001 Attempt to perform click before app native ad initialized.");
            } else {
                this.zzdbj.zza(null, str, null, null, null, false);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadx
    public final void recordImpression() {
        synchronized (this.mLock) {
            if (this.zzdbj == null) {
                zzbbd.e("#002 Attempt to record impression before native ad initialized.");
            } else {
                this.zzdbj.zza((View) null, (Map<String, WeakReference<View>>) null);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadx
    public final IObjectWrapper zzsg() {
        return ObjectWrapper.wrap(this.zzdbj.getContext().getApplicationContext());
    }

    @Override // com.google.android.gms.internal.ads.zzadx
    public final void destroy() {
        zzayh.zzelc.post(new zzaby(this));
        this.zzdbf = null;
        this.zzdbg = null;
    }
}
