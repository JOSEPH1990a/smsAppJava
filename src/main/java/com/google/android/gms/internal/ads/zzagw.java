package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzagw extends zzwy {
    private final /* synthetic */ zzagj zzdgq;

    zzagw(zzagj zzagj) {
        this.zzdgq = zzagj;
    }

    @Override // com.google.android.gms.internal.ads.zzwx
    public final void onAdClicked() throws RemoteException {
        this.zzdgq.zzbnj.add(new zzagx(this));
    }
}
