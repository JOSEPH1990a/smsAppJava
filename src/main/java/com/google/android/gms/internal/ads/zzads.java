package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

@zzark
public final class zzads extends NativeAppInstallAd {
    private final VideoController zzcml = new VideoController();
    private final zzadp zzdds;
    private final List<NativeAd.Image> zzddt = new ArrayList();
    private final zzade zzddu;
    private final NativeAd.AdChoicesInfo zzddv;

    public zzads(zzadp zzadp) {
        zzade zzade;
        zzadb zzadb;
        IBinder iBinder;
        this.zzdds = zzadp;
        zzada zzada = null;
        try {
            List images = this.zzdds.getImages();
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
            zzadb zzsb = this.zzdds.zzsb();
            zzade = zzsb != null ? new zzade(zzsb) : null;
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
            zzade = null;
        }
        this.zzddu = zzade;
        try {
            if (this.zzdds.zzse() != null) {
                zzada = new zzada(this.zzdds.zzse());
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
            return this.zzdds.zzsc();
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd
    public final void performClick(Bundle bundle) {
        try {
            this.zzdds.performClick(bundle);
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd
    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zzdds.recordImpression(bundle);
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd
    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zzdds.reportTouchEvent(bundle);
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getHeadline() {
        try {
            return this.zzdds.getHeadline();
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final List<NativeAd.Image> getImages() {
        return this.zzddt;
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getBody() {
        try {
            return this.zzdds.getBody();
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final NativeAd.Image getIcon() {
        return this.zzddu;
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getCallToAction() {
        try {
            return this.zzdds.getCallToAction();
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final Double getStarRating() {
        try {
            double starRating = this.zzdds.getStarRating();
            if (starRating == -1.0d) {
                return null;
            }
            return Double.valueOf(starRating);
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getStore() {
        try {
            return this.zzdds.getStore();
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getPrice() {
        try {
            return this.zzdds.getPrice();
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final VideoController getVideoController() {
        try {
            if (this.zzdds.getVideoController() != null) {
                this.zzcml.zza(this.zzdds.getVideoController());
            }
        } catch (RemoteException e) {
            zzbbd.zzb("Exception occurred while getting video controller", e);
        }
        return this.zzcml;
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.zzddv;
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getMediationAdapterClassName() {
        try {
            return this.zzdds.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final Bundle getExtras() {
        try {
            return this.zzdds.getExtras();
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final void destroy() {
        try {
            this.zzdds.destroy();
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
        }
    }
}
