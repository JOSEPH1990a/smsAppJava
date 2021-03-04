package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzagk extends zzxb {
    private final /* synthetic */ zzagj zzdgq;

    zzagk(zzagj zzagj) {
        this.zzdgq = zzagj;
    }

    @Override // com.google.android.gms.internal.ads.zzxa
    public final void onAdClosed() throws RemoteException {
        this.zzdgq.zzbnj.add(new zzagl(this));
    }

    @Override // com.google.android.gms.internal.ads.zzxa
    public final void onAdFailedToLoad(int i) throws RemoteException {
        this.zzdgq.zzbnj.add(new zzagm(this, i));
        zzaxz.v("Pooled interstitial failed to load.");
    }

    @Override // com.google.android.gms.internal.ads.zzxa
    public final void onAdLeftApplication() throws RemoteException {
        this.zzdgq.zzbnj.add(new zzagn(this));
    }

    @Override // com.google.android.gms.internal.ads.zzxa
    public final void onAdLoaded() throws RemoteException {
        this.zzdgq.zzbnj.add(new zzago(this));
        zzaxz.v("Pooled interstitial loaded.");
    }

    @Override // com.google.android.gms.internal.ads.zzxa
    public final void onAdOpened() throws RemoteException {
        this.zzdgq.zzbnj.add(new zzagp(this));
    }

    @Override // com.google.android.gms.internal.ads.zzxa
    public final void onAdImpression() throws RemoteException {
        this.zzdgq.zzbnj.add(new zzagq(this));
    }

    @Override // com.google.android.gms.internal.ads.zzxa
    public final void onAdClicked() throws RemoteException {
        this.zzdgq.zzbnj.add(new zzagr(this));
    }
}
