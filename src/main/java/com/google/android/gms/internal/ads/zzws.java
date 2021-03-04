package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* access modifiers changed from: package-private */
public final class zzws extends zzwt<zzauw> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzalg zzclb;
    private final /* synthetic */ zzwj zzclc;

    zzws(zzwj zzwj, Context context, zzalg zzalg) {
        this.zzclc = zzwj;
        this.val$context = context;
        this.zzclb = zzalg;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzwt
    public final /* synthetic */ zzauw zzpq() {
        zzwj.zza(this.val$context, "rewarded_video");
        return new zzzq();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwt
    public final /* synthetic */ zzauw zzpr() throws RemoteException {
        return this.zzclc.zzckv.zza(this.val$context, this.zzclb);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwt
    public final /* synthetic */ zzauw zza(zzxw zzxw) throws RemoteException {
        return zzxw.createRewardedVideoAd(ObjectWrapper.wrap(this.val$context), this.zzclb, 14300000);
    }
}
