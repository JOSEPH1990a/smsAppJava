package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.firebase_messaging.zza;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

final class zzad implements ServiceConnection {
    @GuardedBy("this")
    int state;
    final Messenger zzbx;
    zzai zzby;
    @GuardedBy("this")
    final Queue<zzak<?>> zzbz;
    @GuardedBy("this")
    final SparseArray<zzak<?>> zzca;
    final /* synthetic */ zzab zzcb;

    private zzad(zzab zzab) {
        this.zzcb = zzab;
        this.state = 0;
        this.zzbx = new Messenger(new zza(Looper.getMainLooper(), new zzae(this)));
        this.zzbz = new ArrayDeque();
        this.zzca = new SparseArray<>();
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean zzb(zzak zzak) {
        switch (this.state) {
            case 0:
                this.zzbz.add(zzak);
                Preconditions.checkState(this.state == 0);
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Starting bind to GmsCore");
                }
                this.state = 1;
                Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
                intent.setPackage("com.google.android.gms");
                if (!ConnectionTracker.getInstance().bindService(zzab.zza(this.zzcb), intent, this, 1)) {
                    zza(0, "Unable to bind to service");
                } else {
                    zzab.zzb(this.zzcb).schedule(new zzaf(this), 30, TimeUnit.SECONDS);
                }
                return true;
            case 1:
                this.zzbz.add(zzak);
                return true;
            case 2:
                this.zzbz.add(zzak);
                zzy();
                return true;
            case 3:
            case 4:
                return false;
            default:
                int i = this.state;
                StringBuilder sb = new StringBuilder(26);
                sb.append("Unknown state: ");
                sb.append(i);
                throw new IllegalStateException(sb.toString());
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0052, code lost:
        r5 = r5.getData();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005d, code lost:
        if (r5.getBoolean("unsupported", false) == false) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005f, code lost:
        r1.zza(new com.google.firebase.iid.zzal(4, "Not supported by GmsCore"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006b, code lost:
        r1.zzb(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006e, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(android.os.Message r5) {
        /*
        // Method dump skipped, instructions count: 114
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzad.zza(android.os.Message):boolean");
    }

    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        if (iBinder == null) {
            zza(0, "Null service connection");
            return;
        }
        try {
            this.zzby = new zzai(iBinder);
            this.state = 2;
            zzy();
        } catch (RemoteException e) {
            zza(0, e.getMessage());
        }
    }

    private final void zzy() {
        zzab.zzb(this.zzcb).execute(new zzag(this));
    }

    public final synchronized void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        zza(2, "Service disconnected");
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza(int i, String str) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(str);
            Log.d("MessengerIpcClient", valueOf.length() != 0 ? "Disconnected: ".concat(valueOf) : new String("Disconnected: "));
        }
        switch (this.state) {
            case 0:
                throw new IllegalStateException();
            case 1:
            case 2:
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Unbinding service");
                }
                this.state = 4;
                ConnectionTracker.getInstance().unbindService(zzab.zza(this.zzcb), this);
                zzal zzal = new zzal(i, str);
                for (zzak<?> zzak : this.zzbz) {
                    zzak.zza(zzal);
                }
                this.zzbz.clear();
                for (int i2 = 0; i2 < this.zzca.size(); i2++) {
                    this.zzca.valueAt(i2).zza(zzal);
                }
                this.zzca.clear();
                return;
            case 3:
                this.state = 4;
                return;
            case 4:
                return;
            default:
                int i3 = this.state;
                StringBuilder sb = new StringBuilder(26);
                sb.append("Unknown state: ");
                sb.append(i3);
                throw new IllegalStateException(sb.toString());
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzz() {
        if (this.state == 2 && this.zzbz.isEmpty() && this.zzca.size() == 0) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
            }
            this.state = 3;
            ConnectionTracker.getInstance().unbindService(zzab.zza(this.zzcb), this);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzaa() {
        if (this.state == 1) {
            zza(1, "Timed out while binding");
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza(int i) {
        zzak<?> zzak = this.zzca.get(i);
        if (zzak != null) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Timing out request: ");
            sb.append(i);
            Log.w("MessengerIpcClient", sb.toString());
            this.zzca.remove(i);
            zzak.zza(new zzal(3, "Timed out waiting for response"));
            zzz();
        }
    }
}
