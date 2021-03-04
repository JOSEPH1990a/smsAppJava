package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* access modifiers changed from: package-private */
public final class zzwl extends zzwt<zzaop> {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ zzwj zzclc;

    zzwl(zzwj zzwj, Activity activity) {
        this.zzclc = zzwj;
        this.val$activity = activity;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzwt
    public final /* synthetic */ zzaop zzpq() {
        zzwj.zza(this.val$activity, "ad_overlay");
        return null;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwt
    public final /* synthetic */ zzaop zzpr() throws RemoteException {
        return this.zzclc.zzckx.zze(this.val$activity);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzwt
    public final /* synthetic */ zzaop zza(zzxw zzxw) throws RemoteException {
        return zzxw.createAdOverlay(ObjectWrapper.wrap(this.val$activity));
    }
}
