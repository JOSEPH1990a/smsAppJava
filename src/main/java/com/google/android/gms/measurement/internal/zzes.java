package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class zzes implements ServiceConnection, BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzeb zzasi;
    private volatile boolean zzaso;
    private volatile zzar zzasp;

    protected zzes(zzeb zzeb) {
        this.zzasi = zzeb;
    }

    @WorkerThread
    public final void zzb(Intent intent) {
        this.zzasi.zzaf();
        Context context = this.zzasi.getContext();
        ConnectionTracker instance = ConnectionTracker.getInstance();
        synchronized (this) {
            if (this.zzaso) {
                this.zzasi.zzgt().zzjo().zzby("Connection attempt already in progress");
                return;
            }
            this.zzasi.zzgt().zzjo().zzby("Using local app measurement service");
            this.zzaso = true;
            instance.bindService(context, intent, this.zzasi.zzasb, 129);
        }
    }

    @WorkerThread
    public final void zzlk() {
        if (this.zzasp != null && (this.zzasp.isConnected() || this.zzasp.isConnecting())) {
            this.zzasp.disconnect();
        }
        this.zzasp = null;
    }

    @MainThread
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.zzaso = false;
                this.zzasi.zzgt().zzjg().zzby("Service connected with null binder");
                return;
            }
            zzal zzal = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    if (iBinder != null) {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                        if (queryLocalInterface instanceof zzaj) {
                            zzal = (zzaj) queryLocalInterface;
                        } else {
                            zzal = new zzal(iBinder);
                        }
                    }
                    this.zzasi.zzgt().zzjo().zzby("Bound to IMeasurementService interface");
                } else {
                    this.zzasi.zzgt().zzjg().zzg("Got binder with a wrong descriptor", interfaceDescriptor);
                }
            } catch (RemoteException unused) {
                this.zzasi.zzgt().zzjg().zzby("Service connect failed to get IMeasurementService");
            }
            if (zzal == null) {
                this.zzaso = false;
                try {
                    ConnectionTracker.getInstance().unbindService(this.zzasi.getContext(), this.zzasi.zzasb);
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                this.zzasi.zzgs().zzc(new zzet(this, zzal));
            }
        }
    }

    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceDisconnected");
        this.zzasi.zzgt().zzjn().zzby("Service disconnected");
        this.zzasi.zzgs().zzc(new zzeu(this, componentName));
    }

    @WorkerThread
    public final void zzll() {
        this.zzasi.zzaf();
        Context context = this.zzasi.getContext();
        synchronized (this) {
            if (this.zzaso) {
                this.zzasi.zzgt().zzjo().zzby("Connection attempt already in progress");
            } else if (this.zzasp == null || (!this.zzasp.isConnecting() && !this.zzasp.isConnected())) {
                this.zzasp = new zzar(context, Looper.getMainLooper(), this, this);
                this.zzasi.zzgt().zzjo().zzby("Connecting to remote service");
                this.zzaso = true;
                this.zzasp.checkAvailabilityAndConnect();
            } else {
                this.zzasi.zzgt().zzjo().zzby("Already awaiting connection attempt");
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    @MainThread
    public final void onConnected(@Nullable Bundle bundle) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                this.zzasi.zzgs().zzc(new zzev(this, (zzaj) this.zzasp.getService()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.zzasp = null;
                this.zzaso = false;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    @MainThread
    public final void onConnectionSuspended(int i) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionSuspended");
        this.zzasi.zzgt().zzjn().zzby("Service connection suspended");
        this.zzasi.zzgs().zzc(new zzew(this));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    @MainThread
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionFailed");
        zzas zzkj = this.zzasi.zzada.zzkj();
        if (zzkj != null) {
            zzkj.zzjj().zzg("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.zzaso = false;
            this.zzasp = null;
        }
        this.zzasi.zzgs().zzc(new zzex(this));
    }
}
