package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.ArrayList;
import java.util.List;

@zzark
final class zzagj {
    private final List<zzahi> zzbnj = new ArrayList();

    zzagj() {
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzahj zzahj) {
        Handler handler = zzayh.zzelc;
        for (zzahi zzahi : this.zzbnj) {
            handler.post(new zzahh(this, zzahi, zzahj));
        }
        this.zzbnj.clear();
    }
}
