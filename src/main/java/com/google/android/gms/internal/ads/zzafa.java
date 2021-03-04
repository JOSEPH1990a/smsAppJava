package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

@zzark
public final class zzafa extends RemoteCreator<zzadi> {
    @VisibleForTesting
    public zzafa() {
        super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
    }

    public final zzadf zzb(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        try {
            IBinder zza = ((zzadi) getRemoteCreatorInstance(context)).zza(ObjectWrapper.wrap(context), ObjectWrapper.wrap(frameLayout), ObjectWrapper.wrap(frameLayout2), 14300000);
            if (zza == null) {
                return null;
            }
            IInterface queryLocalInterface = zza.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
            if (queryLocalInterface instanceof zzadf) {
                return (zzadf) queryLocalInterface;
            }
            return new zzadh(zza);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzbbd.zzc("Could not create remote NativeAdViewDelegate.", e);
            return null;
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.dynamic.RemoteCreator
    public final /* synthetic */ zzadi getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
        if (queryLocalInterface instanceof zzadi) {
            return (zzadi) queryLocalInterface;
        }
        return new zzadj(iBinder);
    }
}
