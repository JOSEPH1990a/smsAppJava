package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.support.annotation.WorkerThread;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzbh {
    private final long zzabv;
    private final /* synthetic */ zzbd zzant;
    @VisibleForTesting
    private final String zzanv;
    private final String zzanw;
    private final String zzanx;

    private zzbh(zzbd zzbd, String str, long j) {
        this.zzant = zzbd;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkArgument(j > 0);
        this.zzanv = String.valueOf(str).concat(":start");
        this.zzanw = String.valueOf(str).concat(":count");
        this.zzanx = String.valueOf(str).concat(":value");
        this.zzabv = j;
    }

    @WorkerThread
    private final void zzfl() {
        this.zzant.zzaf();
        long currentTimeMillis = this.zzant.zzbx().currentTimeMillis();
        SharedPreferences.Editor edit = this.zzant.zzju().edit();
        edit.remove(this.zzanw);
        edit.remove(this.zzanx);
        edit.putLong(this.zzanv, currentTimeMillis);
        edit.apply();
    }

    @WorkerThread
    public final void zzc(String str, long j) {
        this.zzant.zzaf();
        if (zzfn() == 0) {
            zzfl();
        }
        if (str == null) {
            str = "";
        }
        long j2 = this.zzant.zzju().getLong(this.zzanw, 0);
        if (j2 <= 0) {
            SharedPreferences.Editor edit = this.zzant.zzju().edit();
            edit.putString(this.zzanx, str);
            edit.putLong(this.zzanw, 1);
            edit.apply();
            return;
        }
        long j3 = j2 + 1;
        boolean z = (this.zzant.zzgr().zzmk().nextLong() & Long.MAX_VALUE) < Long.MAX_VALUE / j3;
        SharedPreferences.Editor edit2 = this.zzant.zzju().edit();
        if (z) {
            edit2.putString(this.zzanx, str);
        }
        edit2.putLong(this.zzanw, j3);
        edit2.apply();
    }

    @WorkerThread
    public final Pair<String, Long> zzfm() {
        long j;
        this.zzant.zzaf();
        this.zzant.zzaf();
        long zzfn = zzfn();
        if (zzfn == 0) {
            zzfl();
            j = 0;
        } else {
            j = Math.abs(zzfn - this.zzant.zzbx().currentTimeMillis());
        }
        long j2 = this.zzabv;
        if (j < j2) {
            return null;
        }
        if (j > (j2 << 1)) {
            zzfl();
            return null;
        }
        String string = this.zzant.zzju().getString(this.zzanx, null);
        long j3 = this.zzant.zzju().getLong(this.zzanw, 0);
        zzfl();
        if (string == null || j3 <= 0) {
            return zzbd.zzamy;
        }
        return new Pair<>(string, Long.valueOf(j3));
    }

    @WorkerThread
    private final long zzfn() {
        return this.zzant.zzju().getLong(this.zzanv, 0);
    }
}
