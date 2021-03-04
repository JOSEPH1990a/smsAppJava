package com.google.android.gms.measurement.internal;

import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.net.URL;
import java.util.Map;

/* access modifiers changed from: package-private */
@WorkerThread
public final class zzba implements Runnable {
    private final String packageName;
    private final URL url;
    private final byte[] zzamr;
    private final zzay zzams;
    private final Map<String, String> zzamt;
    private final /* synthetic */ zzaw zzamu;

    public zzba(zzaw zzaw, String str, URL url2, byte[] bArr, Map<String, String> map, zzay zzay) {
        this.zzamu = zzaw;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url2);
        Preconditions.checkNotNull(zzay);
        this.url = url2;
        this.zzamr = bArr;
        this.zzams = zzay;
        this.packageName = str;
        this.zzamt = map;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c4 A[SYNTHETIC, Splitter:B:43:0x00c4] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0101 A[SYNTHETIC, Splitter:B:56:0x0101] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x011d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        // Method dump skipped, instructions count: 310
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzba.run():void");
    }
}
