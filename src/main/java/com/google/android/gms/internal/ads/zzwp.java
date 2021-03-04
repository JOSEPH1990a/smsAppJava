package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* access modifiers changed from: package-private */
public final class zzwp extends zzwt<zzyc> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzwj zzclc;

    zzwp(zzwj zzwj, Context context) {
        this.zzclc = zzwj;
        this.val$context = context;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzwt
    public final /* synthetic */ zzyc zzpq() {
        zzwj.zza(this.val$context, "mobile_ads_settings");
        return new zzzn();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwt
    public final /* synthetic */ zzyc zzpr() throws RemoteException {
        return this.zzclc.zzckt.zzi(this.val$context);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwt
    public final /* synthetic */ zzyc zza(zzxw zzxw) throws RemoteException {
        return zzxw.getMobileAdsSettingsManagerWithClientJarVersion(ObjectWrapper.wrap(this.val$context), 14300000);
    }
}
