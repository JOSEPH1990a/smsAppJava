package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.gmsg.zzu;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzals;
import com.google.android.gms.internal.ads.zzalv;
import com.google.android.gms.internal.ads.zzaxz;
import com.google.android.gms.internal.ads.zzbgg;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class zzax implements zzu<zzbgg> {
    private final /* synthetic */ zzals zzbpo;
    private final /* synthetic */ zzab zzbpp;
    private final /* synthetic */ zzalv zzbpq;

    zzax(zzals zzals, zzab zzab, zzalv zzalv) {
        this.zzbpo = zzals;
        this.zzbpp = zzab;
        this.zzbpq = zzalv;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.util.Map] */
    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final /* synthetic */ void zza(zzbgg zzbgg, Map map) {
        zzbgg zzbgg2 = zzbgg;
        View view = zzbgg2.getView();
        if (view != null) {
            try {
                if (this.zzbpo != null) {
                    if (!this.zzbpo.getOverrideClickHandling()) {
                        this.zzbpo.zzk(ObjectWrapper.wrap(view));
                        this.zzbpp.zzbng.onAdClicked();
                        return;
                    }
                    zzas.zze(zzbgg2);
                } else if (this.zzbpq == null) {
                } else {
                    if (!this.zzbpq.getOverrideClickHandling()) {
                        this.zzbpq.zzk(ObjectWrapper.wrap(view));
                        this.zzbpp.zzbng.onAdClicked();
                        return;
                    }
                    zzas.zze(zzbgg2);
                }
            } catch (RemoteException e) {
                zzaxz.zzc("Unable to call handleClick on mapper", e);
            }
        }
    }
}
