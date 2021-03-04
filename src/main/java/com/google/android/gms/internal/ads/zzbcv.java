package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

/* access modifiers changed from: package-private */
@zzark
public final class zzbcv extends zzbcw implements ViewTreeObserver.OnScrollChangedListener {
    private final WeakReference<ViewTreeObserver.OnScrollChangedListener> zzeqc;

    public zzbcv(View view, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        super(view);
        this.zzeqc = new WeakReference<>(onScrollChangedListener);
    }

    public final void onScrollChanged() {
        ViewTreeObserver.OnScrollChangedListener onScrollChangedListener = this.zzeqc.get();
        if (onScrollChangedListener != null) {
            onScrollChangedListener.onScrollChanged();
        } else {
            detach();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbcw
    public final void zza(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnScrollChangedListener(this);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbcw
    public final void zzb(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.removeOnScrollChangedListener(this);
    }
}
