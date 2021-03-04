package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.internal.zzbv;
import java.lang.ref.WeakReference;

/* access modifiers changed from: package-private */
@zzark
public final class zzbcu extends zzbcw implements ViewTreeObserver.OnGlobalLayoutListener {
    private final WeakReference<ViewTreeObserver.OnGlobalLayoutListener> zzeqc;

    public zzbcu(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        super(view);
        this.zzeqc = new WeakReference<>(onGlobalLayoutListener);
    }

    public final void onGlobalLayout() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.zzeqc.get();
        if (onGlobalLayoutListener != null) {
            onGlobalLayoutListener.onGlobalLayout();
        } else {
            detach();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbcw
    public final void zza(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnGlobalLayoutListener(this);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbcw
    public final void zzb(ViewTreeObserver viewTreeObserver) {
        zzbv.zzlh().zza(viewTreeObserver, this);
    }
}
