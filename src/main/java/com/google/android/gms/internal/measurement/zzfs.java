package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfs extends zzyc<zzfs> {
    private static volatile zzfs[] zzaww;
    public Integer zzawx = null;
    public Long zzawy = null;

    public static zzfs[] zzmy() {
        if (zzaww == null) {
            synchronized (zzyg.zzcfc) {
                if (zzaww == null) {
                    zzaww = new zzfs[0];
                }
            }
        }
        return zzaww;
    }

    public zzfs() {
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfs)) {
            return false;
        }
        zzfs zzfs = (zzfs) obj;
        Integer num = this.zzawx;
        if (num == null) {
            if (zzfs.zzawx != null) {
                return false;
            }
        } else if (!num.equals(zzfs.zzawx)) {
            return false;
        }
        Long l = this.zzawy;
        if (l == null) {
            if (zzfs.zzawy != null) {
                return false;
            }
        } else if (!l.equals(zzfs.zzawy)) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzfs.zzcet == null || zzfs.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzfs.zzcet);
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        Integer num = this.zzawx;
        int i = 0;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Long l = this.zzawy;
        int hashCode3 = (hashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            i = this.zzcet.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi, com.google.android.gms.internal.measurement.zzyc
    public final void zza(zzya zzya) throws IOException {
        Integer num = this.zzawx;
        if (num != null) {
            zzya.zzd(1, num.intValue());
        }
        Long l = this.zzawy;
        if (l != null) {
            zzya.zzi(2, l.longValue());
        }
        super.zza(zzya);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzyi, com.google.android.gms.internal.measurement.zzyc
    public final int zzf() {
        int zzf = super.zzf();
        Integer num = this.zzawx;
        if (num != null) {
            zzf += zzya.zzh(1, num.intValue());
        }
        Long l = this.zzawy;
        return l != null ? zzf + zzya.zzd(2, l.longValue()) : zzf;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public final /* synthetic */ zzyi zza(zzxz zzxz) throws IOException {
        while (true) {
            int zzuj = zzxz.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 8) {
                this.zzawx = Integer.valueOf(zzxz.zzvb());
            } else if (zzuj == 16) {
                this.zzawy = Long.valueOf(zzxz.zzvc());
            } else if (!super.zza(zzxz, zzuj)) {
                return this;
            }
        }
    }
}
