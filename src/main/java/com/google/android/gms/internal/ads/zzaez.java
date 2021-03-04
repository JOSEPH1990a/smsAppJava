package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdListener;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.List;

@zzark
public final class zzaez extends UnifiedNativeAd {
    private final zzaew zzdeb;
    private final List<NativeAd.Image> zzdec = new ArrayList();
    private final zzade zzded;
    private final VideoController zzdee = new VideoController();
    private final NativeAd.AdChoicesInfo zzdef;
    private final List<MuteThisAdReason> zzdeg = new ArrayList();

    public zzaez(zzaew zzaew) {
        zzade zzade;
        zzadb zzadb;
        IBinder iBinder;
        this.zzdeb = zzaew;
        zzada zzada = null;
        try {
            List images = this.zzdeb.getImages();
            if (images != null) {
                for (Object obj : images) {
                    if (!(obj instanceof IBinder) || (iBinder = (IBinder) obj) == null) {
                        zzadb = null;
                    } else {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                        zzadb = queryLocalInterface instanceof zzadb ? (zzadb) queryLocalInterface : new zzadd(iBinder);
                    }
                    if (zzadb != null) {
                        this.zzdec.add(new zzade(zzadb));
                    }
                }
            }
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
        }
        try {
            List muteThisAdReasons = this.zzdeb.getMuteThisAdReasons();
            if (muteThisAdReasons != null) {
                for (Object obj2 : muteThisAdReasons) {
                    zzyl zzf = obj2 instanceof IBinder ? zzym.zzf((IBinder) obj2) : null;
                    if (zzf != null) {
                        this.zzdeg.add(new zzyo(zzf));
                    }
                }
            }
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
        }
        try {
            zzadb zzsb = this.zzdeb.zzsb();
            zzade = zzsb != null ? new zzade(zzsb) : null;
        } catch (RemoteException e3) {
            zzbbd.zzb("", e3);
            zzade = null;
        }
        this.zzded = zzade;
        try {
            if (this.zzdeb.zzse() != null) {
                zzada = new zzada(this.zzdeb.zzse());
            }
        } catch (RemoteException e4) {
            zzbbd.zzb("", e4);
        }
        this.zzdef = zzada;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzsc */
    public final IObjectWrapper zzhy() {
        try {
            return this.zzdeb.zzsc();
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final Object zzic() {
        try {
            IObjectWrapper zzsd = this.zzdeb.zzsd();
            if (zzsd != null) {
                return ObjectWrapper.unwrap(zzsd);
            }
            return null;
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void performClick(Bundle bundle) {
        try {
            this.zzdeb.performClick(bundle);
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zzdeb.recordImpression(bundle);
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zzdeb.reportTouchEvent(bundle);
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getHeadline() {
        try {
            return this.zzdeb.getHeadline();
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final List<NativeAd.Image> getImages() {
        return this.zzdec;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getBody() {
        try {
            return this.zzdeb.getBody();
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final NativeAd.Image getIcon() {
        return this.zzded;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getCallToAction() {
        try {
            return this.zzdeb.getCallToAction();
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final Double getStarRating() {
        try {
            double starRating = this.zzdeb.getStarRating();
            if (starRating == -1.0d) {
                return null;
            }
            return Double.valueOf(starRating);
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getStore() {
        try {
            return this.zzdeb.getStore();
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getPrice() {
        try {
            return this.zzdeb.getPrice();
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final VideoController getVideoController() {
        try {
            if (this.zzdeb.getVideoController() != null) {
                this.zzdee.zza(this.zzdeb.getVideoController());
            }
        } catch (RemoteException e) {
            zzbbd.zzb("Exception occurred while getting video controller", e);
        }
        return this.zzdee;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.zzdef;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getMediationAdapterClassName() {
        try {
            return this.zzdeb.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final Bundle getExtras() {
        try {
            Bundle extras = this.zzdeb.getExtras();
            if (extras != null) {
                return extras;
            }
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
        }
        return new Bundle();
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void enableCustomClickGesture() {
        try {
            this.zzdeb.zzsi();
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void recordCustomClickGesture() {
        try {
            this.zzdeb.recordCustomClickGesture();
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final List<MuteThisAdReason> getMuteThisAdReasons() {
        return this.zzdeg;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final boolean isCustomMuteThisAdEnabled() {
        try {
            return this.zzdeb.isCustomMuteThisAdEnabled();
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void destroy() {
        try {
            this.zzdeb.destroy();
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void setUnconfirmedClickListener(UnifiedNativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        try {
            this.zzdeb.zza(new zzafj(unconfirmedClickListener));
        } catch (RemoteException e) {
            zzbbd.zzb("Failed to setUnconfirmedClickListener", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void muteThisAd(MuteThisAdReason muteThisAdReason) {
        try {
            if (!isCustomMuteThisAdEnabled()) {
                zzbbd.e("Ad is not custom mute enabled");
            } else if (muteThisAdReason == null) {
                this.zzdeb.zza((zzyl) null);
            } else if (muteThisAdReason instanceof zzyo) {
                this.zzdeb.zza(((zzyo) muteThisAdReason).zzqe());
            } else {
                zzbbd.e("Use mute reason from UnifiedNativeAd.getMuteThisAdReasons() or null");
            }
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void setMuteThisAdListener(MuteThisAdListener muteThisAdListener) {
        try {
            this.zzdeb.zza(new zzyk(muteThisAdListener));
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void cancelUnconfirmedClick() {
        try {
            this.zzdeb.cancelUnconfirmedClick();
        } catch (RemoteException e) {
            zzbbd.zzb("Failed to cancelUnconfirmedClick", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getAdvertiser() {
        try {
            return this.zzdeb.getAdvertiser();
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
            return null;
        }
    }
}
