package com.google.android.gms.internal.ads;

import android.provider.Settings;
import java.lang.reflect.InvocationTargetException;

public final class zzdy extends zzeu {
    public zzdy(zzdl zzdl, String str, String str2, zzbl zzbl, int i, int i2) {
        super(zzdl, str, str2, zzbl, i, 49);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzeu
    public final void zzas() throws IllegalAccessException, InvocationTargetException {
        this.zzun.zzfg = 2;
        try {
            int i = 1;
            boolean booleanValue = ((Boolean) this.zzuw.invoke(null, this.zzqo.getContext())).booleanValue();
            zzbl zzbl = this.zzun;
            if (!booleanValue) {
                i = 0;
            }
            zzbl.zzfg = Integer.valueOf(i);
        } catch (InvocationTargetException e) {
            if (!(e.getTargetException() instanceof Settings.SettingNotFoundException)) {
                throw e;
            }
        }
    }
}
