package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

final class zzrz extends ContentObserver {
    private final /* synthetic */ zzrx zzbri;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzrz(zzrx zzrx, Handler handler) {
        super(null);
        this.zzbri = zzrx;
    }

    public final void onChange(boolean z) {
        this.zzbri.zztl();
    }
}
