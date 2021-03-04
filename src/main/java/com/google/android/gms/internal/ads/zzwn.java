package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* access modifiers changed from: package-private */
public final class zzwn extends zzwt<zzxl> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzwf zzckz;
    private final /* synthetic */ String zzcla;
    private final /* synthetic */ zzalg zzclb;
    private final /* synthetic */ zzwj zzclc;

    zzwn(zzwj zzwj, Context context, zzwf zzwf, String str, zzalg zzalg) {
        this.zzclc = zzwj;
        this.val$context = context;
        this.zzckz = zzwf;
        this.zzcla = str;
        this.zzclb = zzalg;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwt
    public final /* synthetic */ zzxl zzpq() {
        zzwj.zza(this.val$context, "interstitial");
        return new zzzl();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwt
    public final /* synthetic */ zzxl zzpr() throws RemoteException {
        return this.zzclc.zzckr.zza(this.val$context, this.zzckz, this.zzcla, this.zzclb, 2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwt
    public final /* synthetic */ zzxl zza(zzxw zzxw) throws RemoteException {
        return zzxw.createInterstitialAdManager(ObjectWrapper.wrap(this.val$context), this.zzckz, this.zzcla, this.zzclb, 14300000);
    }
}
