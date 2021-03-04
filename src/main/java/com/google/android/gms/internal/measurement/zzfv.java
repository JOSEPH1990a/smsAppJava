package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfv extends zzyc<zzfv> {
    public zzfw[] zzaxf = zzfw.zznb();

    public zzfv() {
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfv)) {
            return false;
        }
        zzfv zzfv = (zzfv) obj;
        if (!zzyg.equals(this.zzaxf, zzfv.zzaxf)) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzfv.zzcet == null || zzfv.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzfv.zzcet);
    }

    public final int hashCode() {
        return ((((getClass().getName().hashCode() + 527) * 31) + zzyg.hashCode(this.zzaxf)) * 31) + ((this.zzcet == null || this.zzcet.isEmpty()) ? 0 : this.zzcet.hashCode());
    }

    @Override // com.google.android.gms.internal.measurement.zzyi, com.google.android.gms.internal.measurement.zzyc
    public final void zza(zzya zzya) throws IOException {
        zzfw[] zzfwArr = this.zzaxf;
        if (zzfwArr != null && zzfwArr.length > 0) {
            int i = 0;
            while (true) {
                zzfw[] zzfwArr2 = this.zzaxf;
                if (i >= zzfwArr2.length) {
                    break;
                }
                zzfw zzfw = zzfwArr2[i];
                if (zzfw != null) {
                    zzya.zza(1, zzfw);
                }
                i++;
            }
        }
        super.zza(zzya);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzyi, com.google.android.gms.internal.measurement.zzyc
    public final int zzf() {
        int zzf = super.zzf();
        zzfw[] zzfwArr = this.zzaxf;
        if (zzfwArr != null && zzfwArr.length > 0) {
            int i = 0;
            while (true) {
                zzfw[] zzfwArr2 = this.zzaxf;
                if (i >= zzfwArr2.length) {
                    break;
                }
                zzfw zzfw = zzfwArr2[i];
                if (zzfw != null) {
                    zzf += zzya.zzb(1, zzfw);
                }
                i++;
            }
        }
        return zzf;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public final /* synthetic */ zzyi zza(zzxz zzxz) throws IOException {
        while (true) {
            int zzuj = zzxz.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 10) {
                int zzb = zzyl.zzb(zzxz, 10);
                zzfw[] zzfwArr = this.zzaxf;
                int length = zzfwArr == null ? 0 : zzfwArr.length;
                zzfw[] zzfwArr2 = new zzfw[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzaxf, 0, zzfwArr2, 0, length);
                }
                while (length < zzfwArr2.length - 1) {
                    zzfwArr2[length] = new zzfw();
                    zzxz.zza(zzfwArr2[length]);
                    zzxz.zzuj();
                    length++;
                }
                zzfwArr2[length] = new zzfw();
                zzxz.zza(zzfwArr2[length]);
                this.zzaxf = zzfwArr2;
            } else if (!super.zza(zzxz, zzuj)) {
                return this;
            }
        }
    }
}
