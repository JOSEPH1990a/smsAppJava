package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import java.util.HashMap;

@zzark
public final class zzafb extends RemoteCreator<zzadn> {
    @VisibleForTesting
    public zzafb() {
        super("com.google.android.gms.ads.NativeAdViewHolderDelegateCreatorImpl");
    }

    public final zzadk zzb(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        try {
            IBinder zza = ((zzadn) getRemoteCreatorInstance(view.getContext())).zza(ObjectWrapper.wrap(view), ObjectWrapper.wrap(hashMap), ObjectWrapper.wrap(hashMap2));
            if (zza == null) {
                return null;
            }
            IInterface queryLocalInterface = zza.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
            if (queryLocalInterface instanceof zzadk) {
                return (zzadk) queryLocalInterface;
            }
            return new zzadm(zza);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzbbd.zzc("Could not create remote NativeAdViewHolderDelegate.", e);
            return null;
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.dynamic.RemoteCreator
    public final /* synthetic */ zzadn getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegateCreator");
        if (queryLocalInterface instanceof zzadn) {
            return (zzadn) queryLocalInterface;
        }
        return new zzado(iBinder);
    }
}
