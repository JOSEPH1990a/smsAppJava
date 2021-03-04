package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;

/* access modifiers changed from: package-private */
public final class zzwr extends zzwt<zzadk> {
    private final /* synthetic */ zzwj zzclc;
    private final /* synthetic */ View zzclf;
    private final /* synthetic */ HashMap zzclg;
    private final /* synthetic */ HashMap zzclh;

    zzwr(zzwj zzwj, View view, HashMap hashMap, HashMap hashMap2) {
        this.zzclc = zzwj;
        this.zzclf = view;
        this.zzclg = hashMap;
        this.zzclh = hashMap2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzwt
    public final /* synthetic */ zzadk zzpq() {
        zzwj.zza(this.zzclf.getContext(), "native_ad_view_holder_delegate");
        return new zzzp();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwt
    public final /* synthetic */ zzadk zzpr() throws RemoteException {
        return this.zzclc.zzcky.zzb(this.zzclf, this.zzclg, this.zzclh);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwt
    public final /* synthetic */ zzadk zza(zzxw zzxw) throws RemoteException {
        return zzxw.createNativeAdViewHolderDelegate(ObjectWrapper.wrap(this.zzclf), ObjectWrapper.wrap(this.zzclg), ObjectWrapper.wrap(this.zzclh));
    }
}
