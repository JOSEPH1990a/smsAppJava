package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzyc;
import java.io.IOException;

public abstract class zzyc<M extends zzyc<M>> extends zzyi {
    protected zzye zzcet;

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzyi
    public int zzf() {
        if (this.zzcet == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.zzcet.size(); i2++) {
            i += this.zzcet.zzcf(i2).zzf();
        }
        return i;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public void zza(zzya zzya) throws IOException {
        if (this.zzcet != null) {
            for (int i = 0; i < this.zzcet.size(); i++) {
                this.zzcet.zzcf(i).zza(zzya);
            }
        }
    }

    public final <T> T zza(zzyd<M, T> zzyd) {
        zzyf zzce;
        zzye zzye = this.zzcet;
        if (zzye == null || (zzce = zzye.zzce(zzyd.tag >>> 3)) == null) {
            return null;
        }
        return (T) zzce.zzb(zzyd);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzxz zzxz, int i) throws IOException {
        int position = zzxz.getPosition();
        if (!zzxz.zzaq(i)) {
            return false;
        }
        int i2 = i >>> 3;
        zzyk zzyk = new zzyk(i, zzxz.zzs(position, zzxz.getPosition() - position));
        zzyf zzyf = null;
        zzye zzye = this.zzcet;
        if (zzye == null) {
            this.zzcet = new zzye();
        } else {
            zzyf = zzye.zzce(i2);
        }
        if (zzyf == null) {
            zzyf = new zzyf();
            this.zzcet.zza(i2, zzyf);
        }
        zzyf.zza(zzyk);
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public final /* synthetic */ zzyi zzzb() throws CloneNotSupportedException {
        return (zzyc) clone();
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzyc zzyc = (zzyc) super.clone();
        zzyg.zza(this, zzyc);
        return zzyc;
    }
}
