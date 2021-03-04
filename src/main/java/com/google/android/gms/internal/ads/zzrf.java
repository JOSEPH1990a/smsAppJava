package com.google.android.gms.internal.ads;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
public final class zzrf implements zzrn {
    private final Object mLock = new Object();
    private final zzbbi zzbob;
    private final WeakHashMap<zzaxf, zzrg> zzbun = new WeakHashMap<>();
    private final ArrayList<zzrg> zzbuo = new ArrayList<>();
    private final Context zzbup;
    private final zzait zzbuq;

    public zzrf(Context context, zzbbi zzbbi) {
        this.zzbup = context.getApplicationContext();
        this.zzbob = zzbbi;
        this.zzbuq = new zzait(context.getApplicationContext(), zzbbi, (String) zzwu.zzpz().zzd(zzaan.zzcnw));
    }

    public final void zza(zzwf zzwf, zzaxf zzaxf) {
        zza(zzwf, zzaxf, zzaxf.zzdrv.getView());
    }

    public final void zza(zzwf zzwf, zzaxf zzaxf, View view) {
        zza(zzwf, zzaxf, new zzrm(view, zzaxf), (zzbgg) null);
    }

    public final void zza(zzwf zzwf, zzaxf zzaxf, View view, zzbgg zzbgg) {
        zza(zzwf, zzaxf, new zzrm(view, zzaxf), zzbgg);
    }

    public final void zza(zzwf zzwf, zzaxf zzaxf, zzsq zzsq, @Nullable zzbgg zzbgg) {
        zzrg zzrg;
        synchronized (this.mLock) {
            if (zzg(zzaxf)) {
                zzrg = this.zzbun.get(zzaxf);
            } else {
                zzrg zzrg2 = new zzrg(this.zzbup, zzwf, zzaxf, this.zzbob, zzsq);
                zzrg2.zza(this);
                this.zzbun.put(zzaxf, zzrg2);
                this.zzbuo.add(zzrg2);
                zzrg = zzrg2;
            }
            if (zzbgg != null) {
                zzrg.zza(new zzro(zzrg, zzbgg));
            } else {
                zzrg.zza(new zzrs(zzrg, this.zzbuq, this.zzbup));
            }
        }
    }

    private final boolean zzg(zzaxf zzaxf) {
        boolean z;
        synchronized (this.mLock) {
            zzrg zzrg = this.zzbun.get(zzaxf);
            z = zzrg != null && zzrg.zzmz();
        }
        return z;
    }

    public final void zzh(zzaxf zzaxf) {
        synchronized (this.mLock) {
            zzrg zzrg = this.zzbun.get(zzaxf);
            if (zzrg != null) {
                zzrg.zzmx();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzrn
    public final void zza(zzrg zzrg) {
        synchronized (this.mLock) {
            if (!zzrg.zzmz()) {
                this.zzbuo.remove(zzrg);
                Iterator<Map.Entry<zzaxf, zzrg>> it = this.zzbun.entrySet().iterator();
                while (it.hasNext()) {
                    if (it.next().getValue() == zzrg) {
                        it.remove();
                    }
                }
            }
        }
    }

    public final void zzi(zzaxf zzaxf) {
        synchronized (this.mLock) {
            zzrg zzrg = this.zzbun.get(zzaxf);
            if (zzrg != null) {
                zzrg.stop();
            }
        }
    }

    public final void zzj(zzaxf zzaxf) {
        synchronized (this.mLock) {
            zzrg zzrg = this.zzbun.get(zzaxf);
            if (zzrg != null) {
                zzrg.pause();
            }
        }
    }

    public final void zzk(zzaxf zzaxf) {
        synchronized (this.mLock) {
            zzrg zzrg = this.zzbun.get(zzaxf);
            if (zzrg != null) {
                zzrg.resume();
            }
        }
    }
}