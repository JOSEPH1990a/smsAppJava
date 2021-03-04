package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;

/* access modifiers changed from: package-private */
public final class zzbv extends Thread {
    private final /* synthetic */ zzbr zzapb;
    private final Object zzape = new Object();
    private final BlockingQueue<zzbu<?>> zzapf;

    public zzbv(zzbr zzbr, String str, BlockingQueue<zzbu<?>> blockingQueue) {
        this.zzapb = zzbr;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(blockingQueue);
        this.zzapf = blockingQueue;
        setName(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0065, code lost:
        r1 = r6.zzapb.zzaow;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x006b, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        r6.zzapb.zzaox.release();
        r6.zzapb.zzaow.notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0084, code lost:
        if (r6 != r6.zzapb.zzaoq) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0086, code lost:
        r6.zzapb.zzaoq = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0092, code lost:
        if (r6 != r6.zzapb.zzaor) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0094, code lost:
        r6.zzapb.zzaor = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x009a, code lost:
        r6.zzapb.zzgt().zzjg().zzby("Current scheduler thread is neither worker nor network");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a9, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00aa, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        // Method dump skipped, instructions count: 258
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzbv.run():void");
    }

    public final void zzki() {
        synchronized (this.zzape) {
            this.zzape.notifyAll();
        }
    }

    private final void zza(InterruptedException interruptedException) {
        this.zzapb.zzgt().zzjj().zzg(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }
}
