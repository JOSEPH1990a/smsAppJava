package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.google.ads.AdRequest;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.common.util.VisibleForTesting;
import fi.iki.elonen.NanoHTTPD;
import java.util.ArrayList;
import java.util.List;

@zzark
public final class zzazc {
    private Handler handler;
    private final Context mContext;
    private int state;
    private String zzboa;
    private String zzbuk;
    private final float zzdqe;
    @Nullable
    private String zzebe;
    private String zzelo;
    private float zzelp;
    private float zzelq;
    private float zzelr;
    private int zzels;
    private float zzelt;
    private float zzelu;
    private float zzelv;
    private float zzelw;
    private Runnable zzelx;

    public zzazc(Context context) {
        this.state = 0;
        this.zzelx = new zzazd(this);
        this.mContext = context;
        this.zzdqe = context.getResources().getDisplayMetrics().density;
        this.zzels = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
        zzbv.zzlv().zzaak();
        this.handler = zzbv.zzlv().getHandler();
    }

    public zzazc(Context context, String str) {
        this(context);
        this.zzelo = str;
    }

    public final void zze(MotionEvent motionEvent) {
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcwd)).booleanValue()) {
            int actionMasked = motionEvent.getActionMasked();
            int historySize = motionEvent.getHistorySize();
            int pointerCount = motionEvent.getPointerCount();
            if (actionMasked == 0) {
                this.state = 0;
                this.zzelt = motionEvent.getX();
                this.zzelu = motionEvent.getY();
                return;
            }
            int i = this.state;
            if (i != -1) {
                boolean z = true;
                if (i == 0 && actionMasked == 5) {
                    this.state = 5;
                    this.zzelv = motionEvent.getX(1);
                    this.zzelw = motionEvent.getY(1);
                    this.handler.postDelayed(this.zzelx, ((Long) zzwu.zzpz().zzd(zzaan.zzcwe)).longValue());
                } else if (this.state == 5) {
                    if (pointerCount == 2) {
                        if (actionMasked == 2) {
                            boolean z2 = false;
                            for (int i2 = 0; i2 < historySize; i2++) {
                                if (!zza(motionEvent.getHistoricalX(0, i2), motionEvent.getHistoricalY(0, i2), motionEvent.getHistoricalX(1, i2), motionEvent.getHistoricalY(1, i2))) {
                                    z2 = true;
                                }
                            }
                            if (zza(motionEvent.getX(), motionEvent.getY(), motionEvent.getX(1), motionEvent.getY(1))) {
                                z = z2;
                            }
                        } else {
                            z = false;
                        }
                    }
                    if (z) {
                        this.state = -1;
                        this.handler.removeCallbacks(this.zzelx);
                    }
                }
            }
        } else {
            int historySize2 = motionEvent.getHistorySize();
            for (int i3 = 0; i3 < historySize2; i3++) {
                zza(motionEvent.getActionMasked(), motionEvent.getHistoricalX(0, i3), motionEvent.getHistoricalY(0, i3));
            }
            zza(motionEvent.getActionMasked(), motionEvent.getX(), motionEvent.getY());
        }
    }

    private final boolean zza(float f, float f2, float f3, float f4) {
        return Math.abs(this.zzelt - f) < ((float) this.zzels) && Math.abs(this.zzelu - f2) < ((float) this.zzels) && Math.abs(this.zzelv - f3) < ((float) this.zzels) && Math.abs(this.zzelw - f4) < ((float) this.zzels);
    }

    @VisibleForTesting
    private final void zza(int i, float f, float f2) {
        if (i == 0) {
            this.state = 0;
            this.zzelp = f;
            this.zzelq = f2;
            this.zzelr = f2;
            return;
        }
        int i2 = this.state;
        if (i2 != -1) {
            if (i == 2) {
                if (f2 > this.zzelq) {
                    this.zzelq = f2;
                } else if (f2 < this.zzelr) {
                    this.zzelr = f2;
                }
                if (this.zzelq - this.zzelr > this.zzdqe * 30.0f) {
                    this.state = -1;
                    return;
                }
                int i3 = this.state;
                if (i3 == 0 || i3 == 2) {
                    if (f - this.zzelp >= this.zzdqe * 50.0f) {
                        this.zzelp = f;
                        this.state++;
                    }
                } else if ((i3 == 1 || i3 == 3) && f - this.zzelp <= this.zzdqe * -50.0f) {
                    this.zzelp = f;
                    this.state++;
                }
                int i4 = this.state;
                if (i4 == 1 || i4 == 3) {
                    if (f > this.zzelp) {
                        this.zzelp = f;
                    }
                } else if (i4 == 2 && f < this.zzelp) {
                    this.zzelp = f;
                }
            } else if (i == 1 && i2 == 4) {
                showDialog();
            }
        }
    }

    public final void showDialog() {
        try {
            if (!(this.mContext instanceof Activity)) {
                zzaxz.zzen("Can not create dialog without Activity Context");
                return;
            }
            String str = !TextUtils.isEmpty(zzbv.zzlp().zzaag()) ? "Creative Preview (Enabled)" : "Creative Preview";
            String str2 = zzbv.zzlp().zzaah() ? "Troubleshooting (Enabled)" : "Troubleshooting";
            ArrayList arrayList = new ArrayList();
            int zza = zza((List<String>) arrayList, "Ad Information", true);
            int zza2 = zza((List<String>) arrayList, str, true);
            int zza3 = zza((List<String>) arrayList, str2, true);
            AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext, zzbv.zzlh().zzaab());
            builder.setTitle("Select a Debug Mode").setItems((CharSequence[]) arrayList.toArray(new String[0]), new zzaze(this, zza, zza2, zza3));
            builder.create().show();
        } catch (WindowManager.BadTokenException e) {
            if (zzaxz.zzza()) {
                Log.v(AdRequest.LOGTAG, "", e);
            }
        }
    }

    public final void setAdUnitId(String str) {
        this.zzboa = str;
    }

    public final void zzee(String str) {
        this.zzbuk = str;
    }

    public final void zzef(String str) {
        this.zzelo = str;
    }

    public final void zzeg(String str) {
        this.zzebe = str;
    }

    private static int zza(List<String> list, String str, boolean z) {
        list.add(str);
        return list.size() - 1;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaad() {
        zzbv.zzlp().zza(this.mContext, this.zzboa, this.zzbuk, this.zzebe);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaae() {
        zzbv.zzlp().zzf(this.mContext, this.zzboa, this.zzbuk);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(String str, DialogInterface dialogInterface, int i) {
        zzbv.zzlf();
        zzayh.zza(this.mContext, Intent.createChooser(new Intent("android.intent.action.SEND").setType(NanoHTTPD.MIME_PLAINTEXT).putExtra("android.intent.extra.TEXT", str), "Share via"));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x006e, code lost:
        if (android.text.TextUtils.isEmpty(r1) == false) goto L_0x0073;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zza(int r1, int r2, int r3, android.content.DialogInterface r4, int r5) {
        /*
        // Method dump skipped, instructions count: 187
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzazc.zza(int, int, int, android.content.DialogInterface, int):void");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaaf() {
        this.state = 4;
        showDialog();
    }
}
