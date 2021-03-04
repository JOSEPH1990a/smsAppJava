package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzft extends zzyc<zzft> {
    private static volatile zzft[] zzawz;
    public Integer count = null;
    public String name = null;
    public zzfu[] zzaxa = zzfu.zzna();
    public Long zzaxb = null;
    public Long zzaxc = null;

    public static zzft[] zzmz() {
        if (zzawz == null) {
            synchronized (zzyg.zzcfc) {
                if (zzawz == null) {
                    zzawz = new zzft[0];
                }
            }
        }
        return zzawz;
    }

    public zzft() {
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzft)) {
            return false;
        }
        zzft zzft = (zzft) obj;
        if (!zzyg.equals(this.zzaxa, zzft.zzaxa)) {
            return false;
        }
        String str = this.name;
        if (str == null) {
            if (zzft.name != null) {
                return false;
            }
        } else if (!str.equals(zzft.name)) {
            return false;
        }
        Long l = this.zzaxb;
        if (l == null) {
            if (zzft.zzaxb != null) {
                return false;
            }
        } else if (!l.equals(zzft.zzaxb)) {
            return false;
        }
        Long l2 = this.zzaxc;
        if (l2 == null) {
            if (zzft.zzaxc != null) {
                return false;
            }
        } else if (!l2.equals(zzft.zzaxc)) {
            return false;
        }
        Integer num = this.count;
        if (num == null) {
            if (zzft.count != null) {
                return false;
            }
        } else if (!num.equals(zzft.count)) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzft.zzcet == null || zzft.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzft.zzcet);
    }

    public final int hashCode() {
        int hashCode = (((getClass().getName().hashCode() + 527) * 31) + zzyg.hashCode(this.zzaxa)) * 31;
        String str = this.name;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l = this.zzaxb;
        int hashCode3 = (hashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.zzaxc;
        int hashCode4 = (hashCode3 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Integer num = this.count;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            i = this.zzcet.hashCode();
        }
        return hashCode5 + i;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi, com.google.android.gms.internal.measurement.zzyc
    public final void zza(zzya zzya) throws IOException {
        zzfu[] zzfuArr = this.zzaxa;
        if (zzfuArr != null && zzfuArr.length > 0) {
            int i = 0;
            while (true) {
                zzfu[] zzfuArr2 = this.zzaxa;
                if (i >= zzfuArr2.length) {
                    break;
                }
                zzfu zzfu = zzfuArr2[i];
                if (zzfu != null) {
                    zzya.zza(1, zzfu);
                }
                i++;
            }
        }
        String str = this.name;
        if (str != null) {
            zzya.zzb(2, str);
        }
        Long l = this.zzaxb;
        if (l != null) {
            zzya.zzi(3, l.longValue());
        }
        Long l2 = this.zzaxc;
        if (l2 != null) {
            zzya.zzi(4, l2.longValue());
        }
        Integer num = this.count;
        if (num != null) {
            zzya.zzd(5, num.intValue());
        }
        super.zza(zzya);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzyi, com.google.android.gms.internal.measurement.zzyc
    public final int zzf() {
        int zzf = super.zzf();
        zzfu[] zzfuArr = this.zzaxa;
        if (zzfuArr != null && zzfuArr.length > 0) {
            int i = 0;
            while (true) {
                zzfu[] zzfuArr2 = this.zzaxa;
                if (i >= zzfuArr2.length) {
                    break;
                }
                zzfu zzfu = zzfuArr2[i];
                if (zzfu != null) {
                    zzf += zzya.zzb(1, zzfu);
                }
                i++;
            }
        }
        String str = this.name;
        if (str != null) {
            zzf += zzya.zzc(2, str);
        }
        Long l = this.zzaxb;
        if (l != null) {
            zzf += zzya.zzd(3, l.longValue());
        }
        Long l2 = this.zzaxc;
        if (l2 != null) {
            zzf += zzya.zzd(4, l2.longValue());
        }
        Integer num = this.count;
        return num != null ? zzf + zzya.zzh(5, num.intValue()) : zzf;
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
                zzfu[] zzfuArr = this.zzaxa;
                int length = zzfuArr == null ? 0 : zzfuArr.length;
                zzfu[] zzfuArr2 = new zzfu[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzaxa, 0, zzfuArr2, 0, length);
                }
                while (length < zzfuArr2.length - 1) {
                    zzfuArr2[length] = new zzfu();
                    zzxz.zza(zzfuArr2[length]);
                    zzxz.zzuj();
                    length++;
                }
                zzfuArr2[length] = new zzfu();
                zzxz.zza(zzfuArr2[length]);
                this.zzaxa = zzfuArr2;
            } else if (zzuj == 18) {
                this.name = zzxz.readString();
            } else if (zzuj == 24) {
                this.zzaxb = Long.valueOf(zzxz.zzvc());
            } else if (zzuj == 32) {
                this.zzaxc = Long.valueOf(zzxz.zzvc());
            } else if (zzuj == 40) {
                this.count = Integer.valueOf(zzxz.zzvb());
            } else if (!super.zza(zzxz, zzuj)) {
                return this;
            }
        }
    }
}
