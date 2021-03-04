package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzbv;

@zzark
public final class zzawv implements zzsg {
    private final Object mLock;
    private String zzboa;
    private final Context zzdvi;
    private boolean zzegs;

    public zzawv(Context context, String str) {
        this.zzdvi = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzboa = str;
        this.zzegs = false;
        this.mLock = new Object();
    }

    public final void setAdUnitId(String str) {
        this.zzboa = str;
    }

    public final void zzai(boolean z) {
        if (zzbv.zzmf().zzv(this.zzdvi)) {
            synchronized (this.mLock) {
                if (this.zzegs != z) {
                    this.zzegs = z;
                    if (!TextUtils.isEmpty(this.zzboa)) {
                        if (this.zzegs) {
                            zzbv.zzmf().zzc(this.zzdvi, this.zzboa);
                        } else {
                            zzbv.zzmf().zzd(this.zzdvi, this.zzboa);
                        }
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsg
    public final void zza(zzsf zzsf) {
        zzai(zzsf.zzuc);
    }
}
