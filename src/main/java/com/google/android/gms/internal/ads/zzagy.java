package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzagy extends zzavc {
    private final /* synthetic */ zzagj zzdgq;

    zzagy(zzagj zzagj) {
        this.zzdgq = zzagj;
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void onRewardedVideoAdLoaded() throws RemoteException {
        this.zzdgq.zzbnj.add(new zzagz(this));
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void onRewardedVideoAdOpened() throws RemoteException {
        this.zzdgq.zzbnj.add(new zzaha(this));
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void onRewardedVideoStarted() throws RemoteException {
        this.zzdgq.zzbnj.add(new zzahb(this));
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void onRewardedVideoAdClosed() throws RemoteException {
        this.zzdgq.zzbnj.add(new zzahc(this));
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void zza(zzaur zzaur) throws RemoteException {
        this.zzdgq.zzbnj.add(new zzahd(this, zzaur));
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void onRewardedVideoAdLeftApplication() throws RemoteException {
        this.zzdgq.zzbnj.add(new zzahe(this));
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void onRewardedVideoAdFailedToLoad(int i) throws RemoteException {
        this.zzdgq.zzbnj.add(new zzahf(this, i));
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final void onRewardedVideoCompleted() throws RemoteException {
        this.zzdgq.zzbnj.add(new zzahg(this));
    }
}
