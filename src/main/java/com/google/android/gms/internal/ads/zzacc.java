package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
public final class zzacc extends zzach {
    private final Object mLock;
    @Nullable
    private zzals zzdbv;
    @Nullable
    private zzalv zzdbw;
    @Nullable
    private zzaly zzdbx;
    private final zzace zzdby;
    @Nullable
    private zzacd zzdbz;
    private boolean zzdca;
    private boolean zzdcb;

    public zzacc(Context context, zzace zzace, zzcu zzcu, zzals zzals, zzacf zzacf) {
        this(context, zzace, zzcu, zzacf);
        this.zzdbv = zzals;
    }

    @Override // com.google.android.gms.internal.ads.zzach
    @Nullable
    public final zzbgg zzsp() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzacd, com.google.android.gms.internal.ads.zzach
    public final void zzsq() {
    }

    @Override // com.google.android.gms.internal.ads.zzacd, com.google.android.gms.internal.ads.zzach
    public final void zzsr() {
    }

    public zzacc(Context context, zzace zzace, zzcu zzcu, zzalv zzalv, zzacf zzacf) {
        this(context, zzace, zzcu, zzacf);
        this.zzdbw = zzalv;
    }

    public zzacc(Context context, zzace zzace, zzcu zzcu, zzaly zzaly, zzacf zzacf) {
        this(context, zzace, zzcu, zzacf);
        this.zzdbx = zzaly;
    }

    private zzacc(Context context, zzace zzace, zzcu zzcu, zzacf zzacf) {
        super(context, zzace, null, zzcu, null, zzacf, null, null);
        this.zzdca = false;
        this.zzdcb = false;
        this.mLock = new Object();
        this.zzdby = zzace;
    }

    @Override // com.google.android.gms.internal.ads.zzacd, com.google.android.gms.internal.ads.zzach
    @Nullable
    public final View zza(View.OnClickListener onClickListener, boolean z) {
        IObjectWrapper iObjectWrapper;
        synchronized (this.mLock) {
            if (this.zzdbz != null) {
                return this.zzdbz.zza(onClickListener, z);
            }
            try {
                if (this.zzdbx != null) {
                    iObjectWrapper = this.zzdbx.zzvb();
                } else if (this.zzdbv != null) {
                    iObjectWrapper = this.zzdbv.zzvb();
                } else {
                    iObjectWrapper = this.zzdbw != null ? this.zzdbw.zzvb() : null;
                }
            } catch (RemoteException e) {
                zzaxz.zzc("Failed to call getAdChoicesContent", e);
                iObjectWrapper = null;
            }
            if (iObjectWrapper == null) {
                return null;
            }
            return (View) ObjectWrapper.unwrap(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacd, com.google.android.gms.internal.ads.zzach
    public final boolean zzsj() {
        synchronized (this.mLock) {
            if (this.zzdbz != null) {
                return this.zzdbz.zzsj();
            }
            return this.zzdby.zzjo();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacd, com.google.android.gms.internal.ads.zzach
    public final boolean zzsk() {
        synchronized (this.mLock) {
            if (this.zzdbz != null) {
                return this.zzdbz.zzsk();
            }
            return this.zzdby.zzjq();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacd, com.google.android.gms.internal.ads.zzach
    public final boolean zzsl() {
        synchronized (this.mLock) {
            if (this.zzdbz != null) {
                return this.zzdbz.zzsl();
            }
            return this.zzdby.zzjp();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacd, com.google.android.gms.internal.ads.zzach
    public final void zza(zzaet zzaet) {
        synchronized (this.mLock) {
            if (this.zzdbz != null) {
                this.zzdbz.zza(zzaet);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacd, com.google.android.gms.internal.ads.zzach
    public final void cancelUnconfirmedClick() {
        synchronized (this.mLock) {
            if (this.zzdbz != null) {
                this.zzdbz.cancelUnconfirmedClick();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacd, com.google.android.gms.internal.ads.zzach
    public final void setClickConfirmingView(View view) {
        synchronized (this.mLock) {
            if (this.zzdbz != null) {
                this.zzdbz.setClickConfirmingView(view);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacd, com.google.android.gms.internal.ads.zzach
    public final void zza(View view, Map<String, WeakReference<View>> map) {
        Preconditions.checkMainThread("recordImpression must be called on the main UI thread.");
        synchronized (this.mLock) {
            this.zzdcg = true;
            if (this.zzdbz != null) {
                this.zzdbz.zza(view, map);
                this.zzdby.recordImpression();
            } else {
                try {
                    if (this.zzdbx != null && !this.zzdbx.getOverrideImpressionRecording()) {
                        this.zzdbx.recordImpression();
                        this.zzdby.recordImpression();
                    } else if (this.zzdbv != null && !this.zzdbv.getOverrideImpressionRecording()) {
                        this.zzdbv.recordImpression();
                        this.zzdby.recordImpression();
                    } else if (this.zzdbw != null && !this.zzdbw.getOverrideImpressionRecording()) {
                        this.zzdbw.recordImpression();
                        this.zzdby.recordImpression();
                    }
                } catch (RemoteException e) {
                    zzaxz.zzc("Failed to call recordImpression", e);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacd, com.google.android.gms.internal.ads.zzach
    public final void zzsm() {
        Preconditions.checkMainThread("recordDownloadedImpression must be called on main UI thread.");
        synchronized (this.mLock) {
            this.zzdch = true;
            if (this.zzdbz != null) {
                this.zzdbz.zzsm();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacd, com.google.android.gms.internal.ads.zzach
    public final void zzd(MotionEvent motionEvent) {
        synchronized (this.mLock) {
            if (this.zzdbz != null) {
                this.zzdbz.zzd(motionEvent);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacd, com.google.android.gms.internal.ads.zzach
    public final void zza(View view, Map<String, WeakReference<View>> map, Bundle bundle, View view2) {
        Preconditions.checkMainThread("performClick must be called on the main UI thread.");
        synchronized (this.mLock) {
            if (!this.zzdcb || !zzsk()) {
                if (this.zzdbz != null) {
                    this.zzdbz.zza(view, map, bundle, view2);
                    this.zzdby.onAdClicked();
                } else {
                    zzl(view);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacd, com.google.android.gms.internal.ads.zzach
    public final void zzsi() {
        this.zzdcb = true;
        zzacd zzacd = this.zzdbz;
        if (zzacd != null) {
            zzacd.zzsi();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacd, com.google.android.gms.internal.ads.zzach
    public final void recordCustomClickGesture() {
        Preconditions.checkMainThread("recordCustomClickGesture must be called on the main UI thread.");
        synchronized (this.mLock) {
            if (this.zzdbz != null) {
                if (this.zzdcb) {
                    this.zzdbz.zzsi();
                }
                this.zzdbz.recordCustomClickGesture();
                this.zzdby.onAdClicked();
            } else if (!this.zzdcb) {
                zzaxz.zzeo("Custom click reporting for 3p ads failed. enableCustomClickGesture is not set.");
            } else if (!zzsk()) {
                zzaxz.zzeo("Custom click reporting for 3p ads failed. Ad unit id not whitelisted.");
            } else if (zzst() != null) {
                zzl(zzst().zzsw());
            }
        }
    }

    private final void zzl(View view) {
        try {
            if (this.zzdbx != null && !this.zzdbx.getOverrideClickHandling()) {
                this.zzdbx.zzk(ObjectWrapper.wrap(view));
                this.zzdby.onAdClicked();
            } else if (this.zzdbv != null && !this.zzdbv.getOverrideClickHandling()) {
                this.zzdbv.zzk(ObjectWrapper.wrap(view));
                this.zzdby.onAdClicked();
            } else if (this.zzdbw != null && !this.zzdbw.getOverrideClickHandling()) {
                this.zzdbw.zzk(ObjectWrapper.wrap(view));
                this.zzdby.onAdClicked();
            }
        } catch (RemoteException e) {
            zzaxz.zzc("Failed to call performClick", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzach
    public final void zza(View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        synchronized (this.mLock) {
            this.zzdca = true;
            HashMap<String, View> zzb = zzb(map);
            HashMap<String, View> zzb2 = zzb(map2);
            try {
                if (this.zzdbx != null) {
                    this.zzdbx.zzb(ObjectWrapper.wrap(view), ObjectWrapper.wrap(zzb), ObjectWrapper.wrap(zzb2));
                } else if (this.zzdbv != null) {
                    this.zzdbv.zzb(ObjectWrapper.wrap(view), ObjectWrapper.wrap(zzb), ObjectWrapper.wrap(zzb2));
                    this.zzdbv.zzl(ObjectWrapper.wrap(view));
                } else if (this.zzdbw != null) {
                    this.zzdbw.zzb(ObjectWrapper.wrap(view), ObjectWrapper.wrap(zzb), ObjectWrapper.wrap(zzb2));
                    this.zzdbw.zzl(ObjectWrapper.wrap(view));
                }
            } catch (RemoteException e) {
                zzaxz.zzc("Failed to call prepareAd", e);
            }
            this.zzdca = false;
        }
    }

    private static HashMap<String, View> zzb(Map<String, WeakReference<View>> map) {
        HashMap<String, View> hashMap = new HashMap<>();
        if (map == null) {
            return hashMap;
        }
        synchronized (map) {
            for (Map.Entry<String, WeakReference<View>> entry : map.entrySet()) {
                View view = entry.getValue().get();
                if (view != null) {
                    hashMap.put(entry.getKey(), view);
                }
            }
        }
        return hashMap;
    }

    @Override // com.google.android.gms.internal.ads.zzacd, com.google.android.gms.internal.ads.zzach
    public final void zzb(View view, Map<String, WeakReference<View>> map) {
        synchronized (this.mLock) {
            try {
                if (this.zzdbx != null) {
                    this.zzdbx.zzm(ObjectWrapper.wrap(view));
                } else if (this.zzdbv != null) {
                    this.zzdbv.zzm(ObjectWrapper.wrap(view));
                } else if (this.zzdbw != null) {
                    this.zzdbw.zzm(ObjectWrapper.wrap(view));
                }
            } catch (RemoteException e) {
                zzaxz.zzc("Failed to call untrackView", e);
            }
        }
    }

    public final boolean zzsn() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzdca;
        }
        return z;
    }

    public final void zzc(@Nullable zzacd zzacd) {
        synchronized (this.mLock) {
            this.zzdbz = zzacd;
        }
    }

    public final zzacd zzso() {
        zzacd zzacd;
        synchronized (this.mLock) {
            zzacd = this.zzdbz;
        }
        return zzacd;
    }

    @Override // com.google.android.gms.internal.ads.zzacd, com.google.android.gms.internal.ads.zzach
    public final void zzjl() {
        zzacd zzacd = this.zzdbz;
        if (zzacd != null) {
            zzacd.zzjl();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacd, com.google.android.gms.internal.ads.zzach
    public final void zzjm() {
        zzacd zzacd = this.zzdbz;
        if (zzacd != null) {
            zzacd.zzjm();
        }
    }
}
