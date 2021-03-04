package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

@zzark
public final class zzbdq {
    private final Context zzcnq;
    private final zzbdz zzerw;
    private final ViewGroup zzerx;
    private zzbdk zzery;

    public zzbdq(Context context, ViewGroup viewGroup, zzbgg zzbgg) {
        this(context, viewGroup, zzbgg, null);
    }

    @VisibleForTesting
    private zzbdq(Context context, ViewGroup viewGroup, zzbdz zzbdz, zzbdk zzbdk) {
        this.zzcnq = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzerx = viewGroup;
        this.zzerw = zzbdz;
        this.zzery = null;
    }

    public final void zze(int i, int i2, int i3, int i4) {
        Preconditions.checkMainThread("The underlay may only be modified from the UI thread.");
        zzbdk zzbdk = this.zzery;
        if (zzbdk != null) {
            zzbdk.zzd(i, i2, i3, i4);
        }
    }

    public final void zza(int i, int i2, int i3, int i4, int i5, boolean z, zzbdy zzbdy) {
        if (this.zzery == null) {
            zzaat.zza(this.zzerw.zzaby().zzrf(), this.zzerw.zzabv(), "vpr2");
            Context context = this.zzcnq;
            zzbdz zzbdz = this.zzerw;
            this.zzery = new zzbdk(context, zzbdz, i5, z, zzbdz.zzaby().zzrf(), zzbdy);
            this.zzerx.addView(this.zzery, 0, new ViewGroup.LayoutParams(-1, -1));
            this.zzery.zzd(i, i2, i3, i4);
            this.zzerw.zzat(false);
        }
    }

    public final zzbdk zzabp() {
        Preconditions.checkMainThread("getAdVideoUnderlay must be called from the UI thread.");
        return this.zzery;
    }

    public final void onPause() {
        Preconditions.checkMainThread("onPause must be called from the UI thread.");
        zzbdk zzbdk = this.zzery;
        if (zzbdk != null) {
            zzbdk.pause();
        }
    }

    public final void onDestroy() {
        Preconditions.checkMainThread("onDestroy must be called from the UI thread.");
        zzbdk zzbdk = this.zzery;
        if (zzbdk != null) {
            zzbdk.destroy();
            this.zzerx.removeView(this.zzery);
            this.zzery = null;
        }
    }
}
