package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzark
public final class zzavj implements RewardedVideoAd {
    private final Context mContext;
    private final Object mLock = new Object();
    private String zzbtr;
    @NonNull
    private final zzauw zzeem;
    private final zzavg zzeen = new zzavg(null);
    private String zzeeo;

    public zzavj(Context context, @Nullable zzauw zzauw) {
        this.zzeem = zzauw == null ? new zzzq() : zzauw;
        this.mContext = context.getApplicationContext();
    }

    private final void zza(String str, zzyx zzyx) {
        synchronized (this.mLock) {
            if (this.zzeem != null) {
                try {
                    this.zzeem.zza(new zzavh(zzwe.zza(this.mContext, zzyx), str));
                } catch (RemoteException e) {
                    zzbbd.zzd("#007 Could not call remote method.", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void loadAd(String str, AdRequest adRequest) {
        zza(str, adRequest.zzaz());
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void loadAd(String str, PublisherAdRequest publisherAdRequest) {
        zza(str, publisherAdRequest.zzaz());
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void show() {
        synchronized (this.mLock) {
            if (this.zzeem != null) {
                try {
                    this.zzeem.show();
                } catch (RemoteException e) {
                    zzbbd.zzd("#007 Could not call remote method.", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        synchronized (this.mLock) {
            this.zzeen.setRewardedVideoAdListener(rewardedVideoAdListener);
            if (this.zzeem != null) {
                try {
                    this.zzeem.zza(this.zzeen);
                } catch (RemoteException e) {
                    zzbbd.zzd("#007 Could not call remote method.", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setAdMetadataListener(AdMetadataListener adMetadataListener) {
        synchronized (this.mLock) {
            if (this.zzeem != null) {
                try {
                    this.zzeem.zza(new zzwa(adMetadataListener));
                } catch (RemoteException e) {
                    zzbbd.zzd("#007 Could not call remote method.", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final Bundle getAdMetadata() {
        synchronized (this.mLock) {
            if (this.zzeem != null) {
                try {
                    return this.zzeem.getAdMetadata();
                } catch (RemoteException e) {
                    zzbbd.zzd("#007 Could not call remote method.", e);
                }
            }
            return new Bundle();
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setUserId(String str) {
        synchronized (this.mLock) {
            this.zzbtr = str;
            if (this.zzeem != null) {
                try {
                    this.zzeem.setUserId(str);
                } catch (RemoteException e) {
                    zzbbd.zzd("#007 Could not call remote method.", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final boolean isLoaded() {
        synchronized (this.mLock) {
            if (this.zzeem == null) {
                return false;
            }
            try {
                return this.zzeem.isLoaded();
            } catch (RemoteException e) {
                zzbbd.zzd("#007 Could not call remote method.", e);
                return false;
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void pause() {
        pause(null);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void pause(Context context) {
        synchronized (this.mLock) {
            if (this.zzeem != null) {
                try {
                    this.zzeem.zze(ObjectWrapper.wrap(context));
                } catch (RemoteException e) {
                    zzbbd.zzd("#007 Could not call remote method.", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void resume() {
        resume(null);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void resume(Context context) {
        synchronized (this.mLock) {
            if (this.zzeem != null) {
                try {
                    this.zzeem.zzf(ObjectWrapper.wrap(context));
                } catch (RemoteException e) {
                    zzbbd.zzd("#007 Could not call remote method.", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void destroy() {
        destroy(null);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void destroy(Context context) {
        synchronized (this.mLock) {
            this.zzeen.setRewardedVideoAdListener(null);
            if (this.zzeem != null) {
                try {
                    this.zzeem.zzg(ObjectWrapper.wrap(context));
                } catch (RemoteException e) {
                    zzbbd.zzd("#007 Could not call remote method.", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final RewardedVideoAdListener getRewardedVideoAdListener() {
        RewardedVideoAdListener rewardedVideoAdListener;
        synchronized (this.mLock) {
            rewardedVideoAdListener = this.zzeen.getRewardedVideoAdListener();
        }
        return rewardedVideoAdListener;
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final String getUserId() {
        String str;
        synchronized (this.mLock) {
            str = this.zzbtr;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final String getMediationAdapterClassName() {
        try {
            if (this.zzeem != null) {
                return this.zzeem.getMediationAdapterClassName();
            }
            return null;
        } catch (RemoteException e) {
            zzbbd.zzd("#007 Could not call remote method.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setImmersiveMode(boolean z) {
        synchronized (this.mLock) {
            if (this.zzeem != null) {
                try {
                    this.zzeem.setImmersiveMode(z);
                } catch (RemoteException e) {
                    zzbbd.zzd("#007 Could not call remote method.", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setCustomData(String str) {
        synchronized (this.mLock) {
            if (this.zzeem != null) {
                try {
                    this.zzeem.setCustomData(str);
                    this.zzeeo = str;
                } catch (RemoteException e) {
                    zzbbd.zzd("#007 Could not call remote method.", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final String getCustomData() {
        String str;
        synchronized (this.mLock) {
            str = this.zzeeo;
        }
        return str;
    }
}
