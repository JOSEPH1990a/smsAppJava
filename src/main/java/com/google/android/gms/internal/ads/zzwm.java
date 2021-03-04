package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.firebase.analytics.FirebaseAnalytics;

/* access modifiers changed from: package-private */
public final class zzwm extends zzwt<zzxl> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzwf zzckz;
    private final /* synthetic */ String zzcla;
    private final /* synthetic */ zzwj zzclc;

    zzwm(zzwj zzwj, Context context, zzwf zzwf, String str) {
        this.zzclc = zzwj;
        this.val$context = context;
        this.zzckz = zzwf;
        this.zzcla = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwt
    public final /* synthetic */ zzxl zzpq() {
        zzwj.zza(this.val$context, FirebaseAnalytics.Event.SEARCH);
        return new zzzl();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwt
    public final /* synthetic */ zzxl zzpr() throws RemoteException {
        return this.zzclc.zzckr.zza(this.val$context, this.zzckz, this.zzcla, null, 3);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwt
    public final /* synthetic */ zzxl zza(zzxw zzxw) throws RemoteException {
        return zzxw.createSearchAdManager(ObjectWrapper.wrap(this.val$context), this.zzckz, this.zzcla, 14300000);
    }
}
