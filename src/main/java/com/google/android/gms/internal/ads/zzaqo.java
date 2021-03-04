package com.google.android.gms.internal.ads;

import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

/* access modifiers changed from: package-private */
public final class zzaqo implements ViewTreeObserver.OnScrollChangedListener {
    private final /* synthetic */ zzaqf zzdur;
    private final /* synthetic */ WeakReference zzdus;

    zzaqo(zzaqf zzaqf, WeakReference weakReference) {
        this.zzdur = zzaqf;
        this.zzdus = weakReference;
    }

    public final void onScrollChanged() {
        this.zzdur.zza((zzaqf) this.zzdus, (WeakReference) true);
    }
}
