package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzbv;
import javax.annotation.concurrent.GuardedBy;

@zzark
public final class zztq {
    @GuardedBy("mLock")
    @Nullable
    private Context mContext;
    private final Object mLock = new Object();
    private final Runnable zzbzq = new zztr(this);
    @GuardedBy("mLock")
    @Nullable
    private zztx zzbzr;
    @GuardedBy("mLock")
    @Nullable
    private zzub zzbzs;

    public final void initialize(Context context) {
        if (context != null) {
            synchronized (this.mLock) {
                if (this.mContext == null) {
                    this.mContext = context.getApplicationContext();
                    if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcvr)).booleanValue()) {
                        connect();
                    } else {
                        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcvq)).booleanValue()) {
                            zzbv.zzli().zza(new zzts(this));
                        }
                    }
                }
            }
        }
    }

    public final void zzod() {
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcvs)).booleanValue()) {
            synchronized (this.mLock) {
                connect();
                zzbv.zzlf();
                zzayh.zzelc.removeCallbacks(this.zzbzq);
                zzbv.zzlf();
                zzayh.zzelc.postDelayed(this.zzbzq, ((Long) zzwu.zzpz().zzd(zzaan.zzcvt)).longValue());
            }
        }
    }

    public final zztv zza(zzty zzty) {
        synchronized (this.mLock) {
            if (this.zzbzs == null) {
                return new zztv();
            }
            try {
                return this.zzbzs.zza(zzty);
            } catch (RemoteException e) {
                zzaxz.zzb("Unable to call into cache service.", e);
                return new zztv();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void connect() {
        synchronized (this.mLock) {
            if (this.mContext != null) {
                if (this.zzbzr == null) {
                    this.zzbzr = new zztx(this.mContext, zzbv.zzlv().zzaak(), new zztt(this), new zztu(this));
                    this.zzbzr.checkAvailabilityAndConnect();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void disconnect() {
        synchronized (this.mLock) {
            if (this.zzbzr != null) {
                if (this.zzbzr.isConnected() || this.zzbzr.isConnecting()) {
                    this.zzbzr.disconnect();
                }
                this.zzbzr = null;
                this.zzbzs = null;
                Binder.flushPendingCommands();
            }
        }
    }
}
