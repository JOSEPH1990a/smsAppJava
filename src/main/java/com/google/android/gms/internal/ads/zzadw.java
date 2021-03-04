package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

@zzark
public final class zzadw extends NativeContentAd {
    private final VideoController zzcml = new VideoController();
    private final List<NativeAd.Image> zzddt = new ArrayList();
    private final NativeAd.AdChoicesInfo zzddv;
    private final zzadt zzddw;
    private final zzade zzddx;

    public zzadw(zzadt zzadt) {
        zzade zzade;
        zzadb zzadb;
        IBinder iBinder;
        this.zzddw = zzadt;
        zzada zzada = null;
        try {
            List images = this.zzddw.getImages();
            if (images != null) {
                for (Object obj : images) {
                    if (!(obj instanceof IBinder) || (iBinder = (IBinder) obj) == null) {
                        zzadb = null;
                    } else {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                        zzadb = queryLocalInterface instanceof zzadb ? (zzadb) queryLocalInterface : new zzadd(iBinder);
                    }
                    if (zzadb != null) {
                        this.zzddt.add(new zzade(zzadb));
                    }
                }
            }
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
        }
        try {
            zzadb zzsf = this.zzddw.zzsf();
            zzade = zzsf != null ? new zzade(zzsf) : null;
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
            zzade = null;
        }
        this.zzddx = zzade;
        try {
            if (this.zzddw.zzse() != null) {
                zzada = new zzada(this.zzddw.zzse());
            }
        } catch (RemoteException e3) {
            zzbbd.zzb("", e3);
        }
        this.zzddv = zzada;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzsc */
    public final IObjectWrapper zzhy() {
        try {
            return this.zzddw.zzsc();
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd
    public final void performClick(Bundle bundle) {
        try {
            this.zzddw.performClick(bundle);
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd
    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zzddw.recordImpression(bundle);
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd
    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zzddw.reportTouchEvent(bundle);
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final CharSequence getHeadline() {
        try {
            return this.zzddw.getHeadline();
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final List<NativeAd.Image> getImages() {
        return this.zzddt;
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final CharSequence getBody() {
        try {
            return this.zzddw.getBody();
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final NativeAd.Image getLogo() {
        return this.zzddx;
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final CharSequence getCallToAction() {
        try {
            return this.zzddw.getCallToAction();
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final CharSequence getAdvertiser() {
        try {
            return this.zzddw.getAdvertiser();
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final VideoController getVideoController() {
        try {
            if (this.zzddw.getVideoController() != null) {
                this.zzcml.zza(this.zzddw.getVideoController());
            }
        } catch (RemoteException e) {
            zzbbd.zzb("Exception occurred while getting video controller", e);
        }
        return this.zzcml;
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final Bundle getExtras() {
        try {
            return this.zzddw.getExtras();
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.zzddv;
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final CharSequence getMediationAdapterClassName() {
        try {
            return this.zzddw.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeContentAd
    public final void destroy() {
        try {
            this.zzddw.destroy();
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
        }
    }
}
