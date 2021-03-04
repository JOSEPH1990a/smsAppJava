package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class zzcr implements zzcq {
    protected static volatile zzdl zzqo;
    protected MotionEvent zzqu;
    protected LinkedList<MotionEvent> zzqv = new LinkedList<>();
    protected long zzqw = 0;
    protected long zzqx = 0;
    protected long zzqy = 0;
    protected long zzqz = 0;
    protected long zzra = 0;
    protected long zzrb = 0;
    protected long zzrc = 0;
    protected double zzrd;
    private double zzre;
    private double zzrf;
    protected float zzrg;
    protected float zzrh;
    protected float zzri;
    protected float zzrj;
    private boolean zzrk = false;
    protected boolean zzrl = false;
    protected DisplayMetrics zzrm;

    protected zzcr(Context context) {
        try {
            if (((Boolean) zzwu.zzpz().zzd(zzaan.zzctq)).booleanValue()) {
                zzbw.zzw();
            } else {
                zzdq.zzb(zzqo);
            }
            this.zzrm = context.getResources().getDisplayMetrics();
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: protected */
    public abstract long zza(StackTraceElement[] stackTraceElementArr) throws zzdi;

    /* access modifiers changed from: protected */
    public abstract zzbl zza(Context context, View view, Activity activity);

    /* access modifiers changed from: protected */
    public abstract zzbl zza(Context context, zzbi zzbi);

    /* access modifiers changed from: protected */
    public abstract zzdr zzb(MotionEvent motionEvent) throws zzdi;

    @Override // com.google.android.gms.internal.ads.zzcq
    public void zzb(View view) {
    }

    @Override // com.google.android.gms.internal.ads.zzcq
    public final String zza(Context context) {
        if (zzds.isMainThread()) {
            if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcts)).booleanValue()) {
                throw new IllegalStateException("The caller must not be called from the UI thread.");
            }
        }
        return zza(context, null, false, null, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzcq
    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzcq
    public final String zza(Context context, String str, View view, Activity activity) {
        return zza(context, str, true, view, activity, null);
    }

    @Override // com.google.android.gms.internal.ads.zzcq
    public final void zza(MotionEvent motionEvent) {
        boolean z = false;
        if (this.zzrk) {
            this.zzqz = 0;
            this.zzqy = 0;
            this.zzqx = 0;
            this.zzqw = 0;
            this.zzra = 0;
            this.zzrc = 0;
            this.zzrb = 0;
            Iterator<MotionEvent> it = this.zzqv.iterator();
            while (it.hasNext()) {
                it.next().recycle();
            }
            this.zzqv.clear();
            this.zzqu = null;
            this.zzrk = false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.zzrd = 0.0d;
                this.zzre = (double) motionEvent.getRawX();
                this.zzrf = (double) motionEvent.getRawY();
                break;
            case 1:
            case 2:
                double rawX = (double) motionEvent.getRawX();
                double rawY = (double) motionEvent.getRawY();
                double d = this.zzre;
                Double.isNaN(rawX);
                double d2 = rawX - d;
                double d3 = this.zzrf;
                Double.isNaN(rawY);
                double d4 = rawY - d3;
                this.zzrd += Math.sqrt((d2 * d2) + (d4 * d4));
                this.zzre = rawX;
                this.zzrf = rawY;
                break;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.zzrg = motionEvent.getX();
                this.zzrh = motionEvent.getY();
                this.zzri = motionEvent.getRawX();
                this.zzrj = motionEvent.getRawY();
                this.zzqw++;
                break;
            case 1:
                this.zzqu = MotionEvent.obtain(motionEvent);
                this.zzqv.add(this.zzqu);
                if (this.zzqv.size() > 6) {
                    this.zzqv.remove().recycle();
                }
                this.zzqy++;
                this.zzra = zza(new Throwable().getStackTrace());
                break;
            case 2:
                this.zzqx += (long) (motionEvent.getHistorySize() + 1);
                try {
                    zzdr zzb = zzb(motionEvent);
                    if ((zzb == null || zzb.zzgn == null || zzb.zztp == null) ? false : true) {
                        this.zzrb += zzb.zzgn.longValue() + zzb.zztp.longValue();
                    }
                    if (!(this.zzrm == null || zzb == null || zzb.zzgl == null || zzb.zztq == null)) {
                        z = true;
                    }
                    if (z) {
                        this.zzrc += zzb.zzgl.longValue() + zzb.zztq.longValue();
                        break;
                    }
                } catch (zzdi unused) {
                    break;
                }
                break;
            case 3:
                this.zzqz++;
                break;
        }
        this.zzrl = true;
    }

    @Override // com.google.android.gms.internal.ads.zzcq
    public final void zza(int i, int i2, int i3) {
        MotionEvent motionEvent = this.zzqu;
        if (motionEvent != null) {
            motionEvent.recycle();
        }
        DisplayMetrics displayMetrics = this.zzrm;
        if (displayMetrics != null) {
            this.zzqu = MotionEvent.obtain(0, (long) i3, 1, ((float) i) * displayMetrics.density, this.zzrm.density * ((float) i2), 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        } else {
            this.zzqu = null;
        }
        this.zzrl = false;
    }

    private final String zza(Context context, String str, boolean z, View view, Activity activity, byte[] bArr) {
        zzbl zzbl;
        if (z) {
            try {
                zzbl = zza(context, view, activity);
                this.zzrk = true;
            } catch (UnsupportedEncodingException | GeneralSecurityException unused) {
                return Integer.toString(7);
            } catch (Throwable unused2) {
                return Integer.toString(3);
            }
        } else {
            zzbl = zza(context, null);
        }
        if (zzbl != null) {
            if (zzbl.zzamj() != 0) {
                return zzbw.zza(zzbl, str);
            }
        }
        return Integer.toString(5);
    }
}
