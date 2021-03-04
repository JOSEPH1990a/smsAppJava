package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import javax.annotation.concurrent.GuardedBy;

@zzark
@TargetApi(19)
public final class zzapq extends zzapn {
    private Object zzdst = new Object();
    @GuardedBy("mPopupWindowLock")
    private PopupWindow zzdsu;
    @GuardedBy("mPopupWindowLock")
    private boolean zzdsv = false;

    zzapq(Context context, zzaxg zzaxg, zzbgg zzbgg, zzapm zzapm) {
        super(context, zzaxg, zzbgg, zzapm);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzapn
    public final void zzwb() {
        Window window = this.mContext instanceof Activity ? ((Activity) this.mContext).getWindow() : null;
        if (window != null && window.getDecorView() != null && !((Activity) this.mContext).isDestroyed()) {
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            frameLayout.addView(this.zzdin.getView(), -1, -1);
            synchronized (this.zzdst) {
                if (!this.zzdsv) {
                    this.zzdsu = new PopupWindow((View) frameLayout, 1, 1, false);
                    this.zzdsu.setOutsideTouchable(true);
                    this.zzdsu.setClippingEnabled(false);
                    zzaxz.zzdn("Displaying the 1x1 popup off the screen.");
                    try {
                        this.zzdsu.showAtLocation(window.getDecorView(), 0, -1, -1);
                    } catch (Exception unused) {
                        this.zzdsu = null;
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzazb, com.google.android.gms.internal.ads.zzapf
    public final void cancel() {
        zzwc();
        super.cancel();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzapf
    public final void zzcq(int i) {
        zzwc();
        super.zzcq(i);
    }

    private final void zzwc() {
        synchronized (this.zzdst) {
            this.zzdsv = true;
            if ((this.mContext instanceof Activity) && ((Activity) this.mContext).isDestroyed()) {
                this.zzdsu = null;
            }
            if (this.zzdsu != null) {
                if (this.zzdsu.isShowing()) {
                    this.zzdsu.dismiss();
                }
                this.zzdsu = null;
            }
        }
    }
}
