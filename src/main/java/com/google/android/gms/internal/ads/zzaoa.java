package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Map;
import java.util.Set;

@zzark
public final class zzaoa extends zzaok {
    private static final Set<String> zzdpf = CollectionUtils.setOf("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
    private final Object mLock = new Object();
    private zzaol zzdgd;
    private final zzbgg zzdin;
    private final Activity zzdow;
    private String zzdpg = "top-right";
    private boolean zzdph = true;
    private int zzdpi = 0;
    private int zzdpj = 0;
    private int zzdpk = 0;
    private int zzdpl = 0;
    private zzbht zzdpm;
    private ImageView zzdpn;
    private LinearLayout zzdpo;
    private PopupWindow zzdpp;
    private RelativeLayout zzdpq;
    private ViewGroup zzdpr;
    private int zzvt = -1;
    private int zzvu = -1;

    public zzaoa(zzbgg zzbgg, zzaol zzaol) {
        super(zzbgg, "resize");
        this.zzdin = zzbgg;
        this.zzdow = zzbgg.zzabw();
        this.zzdgd = zzaol;
    }

    public final void zzk(Map<String, String> map) {
        char c;
        synchronized (this.mLock) {
            if (this.zzdow == null) {
                zzda("Not an activity context. Cannot resize.");
            } else if (this.zzdin.zzadj() == null) {
                zzda("Webview is not yet available, size is not set.");
            } else if (this.zzdin.zzadj().zzafb()) {
                zzda("Is interstitial. Cannot resize an interstitial.");
            } else if (this.zzdin.zzadq()) {
                zzda("Cannot resize an expanded banner.");
            } else {
                if (!TextUtils.isEmpty(map.get("width"))) {
                    zzbv.zzlf();
                    this.zzvt = zzayh.zzdy(map.get("width"));
                }
                if (!TextUtils.isEmpty(map.get("height"))) {
                    zzbv.zzlf();
                    this.zzvu = zzayh.zzdy(map.get("height"));
                }
                if (!TextUtils.isEmpty(map.get("offsetX"))) {
                    zzbv.zzlf();
                    this.zzdpk = zzayh.zzdy(map.get("offsetX"));
                }
                if (!TextUtils.isEmpty(map.get("offsetY"))) {
                    zzbv.zzlf();
                    this.zzdpl = zzayh.zzdy(map.get("offsetY"));
                }
                if (!TextUtils.isEmpty(map.get("allowOffscreen"))) {
                    this.zzdph = Boolean.parseBoolean(map.get("allowOffscreen"));
                }
                String str = map.get("customClosePosition");
                if (!TextUtils.isEmpty(str)) {
                    this.zzdpg = str;
                }
                if (!(this.zzvt >= 0 && this.zzvu >= 0)) {
                    zzda("Invalid width and height options. Cannot resize.");
                    return;
                }
                Window window = this.zzdow.getWindow();
                if (window != null) {
                    if (window.getDecorView() != null) {
                        int[] zzvl = zzvl();
                        if (zzvl == null) {
                            zzda("Resize location out of screen or close button is not visible.");
                            return;
                        }
                        zzwu.zzpv();
                        int zza = zzbat.zza(this.zzdow, this.zzvt);
                        zzwu.zzpv();
                        int zza2 = zzbat.zza(this.zzdow, this.zzvu);
                        ViewParent parent = this.zzdin.getView().getParent();
                        if (parent == null || !(parent instanceof ViewGroup)) {
                            zzda("Webview is detached, probably in the middle of a resize or expand.");
                            return;
                        }
                        ((ViewGroup) parent).removeView(this.zzdin.getView());
                        if (this.zzdpp == null) {
                            this.zzdpr = (ViewGroup) parent;
                            zzbv.zzlf();
                            Bitmap zzt = zzayh.zzt(this.zzdin.getView());
                            this.zzdpn = new ImageView(this.zzdow);
                            this.zzdpn.setImageBitmap(zzt);
                            this.zzdpm = this.zzdin.zzadj();
                            this.zzdpr.addView(this.zzdpn);
                        } else {
                            this.zzdpp.dismiss();
                        }
                        this.zzdpq = new RelativeLayout(this.zzdow);
                        this.zzdpq.setBackgroundColor(0);
                        this.zzdpq.setLayoutParams(new ViewGroup.LayoutParams(zza, zza2));
                        zzbv.zzlf();
                        this.zzdpp = zzayh.zza((View) this.zzdpq, zza, zza2, false);
                        this.zzdpp.setOutsideTouchable(true);
                        this.zzdpp.setTouchable(true);
                        this.zzdpp.setClippingEnabled(!this.zzdph);
                        this.zzdpq.addView(this.zzdin.getView(), -1, -1);
                        this.zzdpo = new LinearLayout(this.zzdow);
                        zzwu.zzpv();
                        int zza3 = zzbat.zza(this.zzdow, 50);
                        zzwu.zzpv();
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(zza3, zzbat.zza(this.zzdow, 50));
                        String str2 = this.zzdpg;
                        switch (str2.hashCode()) {
                            case -1364013995:
                                if (str2.equals("center")) {
                                    c = 2;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1012429441:
                                if (str2.equals("top-left")) {
                                    c = 0;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -655373719:
                                if (str2.equals("bottom-left")) {
                                    c = 3;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1163912186:
                                if (str2.equals("bottom-right")) {
                                    c = 5;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1288627767:
                                if (str2.equals("bottom-center")) {
                                    c = 4;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1755462605:
                                if (str2.equals("top-center")) {
                                    c = 1;
                                    break;
                                }
                                c = 65535;
                                break;
                            default:
                                c = 65535;
                                break;
                        }
                        switch (c) {
                            case 0:
                                layoutParams.addRule(10);
                                layoutParams.addRule(9);
                                break;
                            case 1:
                                layoutParams.addRule(10);
                                layoutParams.addRule(14);
                                break;
                            case 2:
                                layoutParams.addRule(13);
                                break;
                            case 3:
                                layoutParams.addRule(12);
                                layoutParams.addRule(9);
                                break;
                            case 4:
                                layoutParams.addRule(12);
                                layoutParams.addRule(14);
                                break;
                            case 5:
                                layoutParams.addRule(12);
                                layoutParams.addRule(11);
                                break;
                            default:
                                layoutParams.addRule(10);
                                layoutParams.addRule(11);
                                break;
                        }
                        this.zzdpo.setOnClickListener(new zzaob(this));
                        this.zzdpo.setContentDescription("Close button");
                        this.zzdpq.addView(this.zzdpo, layoutParams);
                        try {
                            PopupWindow popupWindow = this.zzdpp;
                            View decorView = window.getDecorView();
                            zzwu.zzpv();
                            int zza4 = zzbat.zza(this.zzdow, zzvl[0]);
                            zzwu.zzpv();
                            popupWindow.showAtLocation(decorView, 0, zza4, zzbat.zza(this.zzdow, zzvl[1]));
                            int i = zzvl[0];
                            int i2 = zzvl[1];
                            if (this.zzdgd != null) {
                                this.zzdgd.zza(i, i2, this.zzvt, this.zzvu);
                            }
                            this.zzdin.zza(zzbht.zzr(zza, zza2));
                            zzh(zzvl[0], zzvl[1]);
                            zzdc("resized");
                            return;
                        } catch (RuntimeException e) {
                            String valueOf = String.valueOf(e.getMessage());
                            zzda(valueOf.length() != 0 ? "Cannot show popup window: ".concat(valueOf) : new String("Cannot show popup window: "));
                            this.zzdpq.removeView(this.zzdin.getView());
                            if (this.zzdpr != null) {
                                this.zzdpr.removeView(this.zzdpn);
                                this.zzdpr.addView(this.zzdin.getView());
                                this.zzdin.zza(this.zzdpm);
                            }
                            return;
                        }
                    }
                }
                zzda("Activity context is not ready, cannot get window or decor view.");
            }
        }
    }

    public final void zzx(boolean z) {
        synchronized (this.mLock) {
            if (this.zzdpp != null) {
                this.zzdpp.dismiss();
                this.zzdpq.removeView(this.zzdin.getView());
                if (this.zzdpr != null) {
                    this.zzdpr.removeView(this.zzdpn);
                    this.zzdpr.addView(this.zzdin.getView());
                    this.zzdin.zza(this.zzdpm);
                }
                if (z) {
                    zzdc("default");
                    if (this.zzdgd != null) {
                        this.zzdgd.zzjk();
                    }
                }
                this.zzdpp = null;
                this.zzdpq = null;
                this.zzdpr = null;
                this.zzdpo = null;
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private final int[] zzvl() {
        boolean z;
        int i;
        char c;
        int i2;
        int i3;
        int[] zzh = zzbv.zzlf().zzh(this.zzdow);
        int[] zzi = zzbv.zzlf().zzi(this.zzdow);
        int i4 = zzh[0];
        int i5 = zzh[1];
        int i6 = this.zzvt;
        if (i6 < 50 || i6 > i4) {
            zzaxz.zzeo("Width is too small or too large.");
            z = false;
        } else {
            int i7 = this.zzvu;
            if (i7 < 50 || i7 > i5) {
                zzaxz.zzeo("Height is too small or too large.");
                z = false;
            } else if (i7 == i5 && i6 == i4) {
                zzaxz.zzeo("Cannot resize to a full-screen ad.");
                z = false;
            } else {
                if (this.zzdph) {
                    String str = this.zzdpg;
                    switch (str.hashCode()) {
                        case -1364013995:
                            if (str.equals("center")) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1012429441:
                            if (str.equals("top-left")) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        case -655373719:
                            if (str.equals("bottom-left")) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1163912186:
                            if (str.equals("bottom-right")) {
                                c = 5;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1288627767:
                            if (str.equals("bottom-center")) {
                                c = 4;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1755462605:
                            if (str.equals("top-center")) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
                    switch (c) {
                        case 0:
                            i3 = this.zzdpi + this.zzdpk;
                            i2 = this.zzdpj + this.zzdpl;
                            break;
                        case 1:
                            i3 = ((this.zzdpi + this.zzdpk) + (this.zzvt / 2)) - 25;
                            i2 = this.zzdpj + this.zzdpl;
                            break;
                        case 2:
                            i3 = ((this.zzdpi + this.zzdpk) + (this.zzvt / 2)) - 25;
                            i2 = ((this.zzdpj + this.zzdpl) + (this.zzvu / 2)) - 25;
                            break;
                        case 3:
                            i3 = this.zzdpi + this.zzdpk;
                            i2 = ((this.zzdpj + this.zzdpl) + this.zzvu) - 50;
                            break;
                        case 4:
                            i3 = ((this.zzdpi + this.zzdpk) + (this.zzvt / 2)) - 25;
                            i2 = ((this.zzdpj + this.zzdpl) + this.zzvu) - 50;
                            break;
                        case 5:
                            i3 = ((this.zzdpi + this.zzdpk) + this.zzvt) - 50;
                            i2 = ((this.zzdpj + this.zzdpl) + this.zzvu) - 50;
                            break;
                        default:
                            i3 = ((this.zzdpi + this.zzdpk) + this.zzvt) - 50;
                            i2 = this.zzdpj + this.zzdpl;
                            break;
                    }
                    if (i3 < 0 || i3 + 50 > i4 || i2 < zzi[0] || i2 + 50 > zzi[1]) {
                        z = false;
                    }
                }
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        if (this.zzdph) {
            return new int[]{this.zzdpi + this.zzdpk, this.zzdpj + this.zzdpl};
        }
        int[] zzh2 = zzbv.zzlf().zzh(this.zzdow);
        int[] zzi2 = zzbv.zzlf().zzi(this.zzdow);
        int i8 = zzh2[0];
        int i9 = this.zzdpi + this.zzdpk;
        int i10 = this.zzdpj + this.zzdpl;
        if (i9 < 0) {
            i = 0;
        } else {
            int i11 = this.zzvt;
            i = i9 + i11 > i8 ? i8 - i11 : i9;
        }
        if (i10 < zzi2[0]) {
            i10 = zzi2[0];
        } else {
            int i12 = this.zzvu;
            if (i10 + i12 > zzi2[1]) {
                i10 = zzi2[1] - i12;
            }
        }
        return new int[]{i, i10};
    }

    public final void zza(int i, int i2, boolean z) {
        synchronized (this.mLock) {
            this.zzdpi = i;
            this.zzdpj = i2;
            if (this.zzdpp != null && z) {
                int[] zzvl = zzvl();
                if (zzvl != null) {
                    PopupWindow popupWindow = this.zzdpp;
                    zzwu.zzpv();
                    int zza = zzbat.zza(this.zzdow, zzvl[0]);
                    zzwu.zzpv();
                    popupWindow.update(zza, zzbat.zza(this.zzdow, zzvl[1]), this.zzdpp.getWidth(), this.zzdpp.getHeight());
                    zzh(zzvl[0], zzvl[1]);
                } else {
                    zzx(true);
                }
            }
        }
    }

    private final void zzh(int i, int i2) {
        zzb(i, i2 - zzbv.zzlf().zzi(this.zzdow)[0], this.zzvt, this.zzvu);
    }

    public final boolean zzvm() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzdpp != null;
        }
        return z;
    }

    public final void zzi(int i, int i2) {
        this.zzdpi = i;
        this.zzdpj = i2;
    }
}
