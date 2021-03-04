package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfi extends zzyc<zzfi> {
    private static volatile zzfi[] zzavd;
    public Integer zzave = null;
    public zzfm[] zzavf = zzfm.zzmu();
    public zzfj[] zzavg = zzfj.zzms();
    private Boolean zzavh = null;
    private Boolean zzavi = null;

    public static zzfi[] zzmr() {
        if (zzavd == null) {
            synchronized (zzyg.zzcfc) {
                if (zzavd == null) {
                    zzavd = new zzfi[0];
                }
            }
        }
        return zzavd;
    }

    public zzfi() {
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfi)) {
            return false;
        }
        zzfi zzfi = (zzfi) obj;
        Integer num = this.zzave;
        if (num == null) {
            if (zzfi.zzave != null) {
                return false;
            }
        } else if (!num.equals(zzfi.zzave)) {
            return false;
        }
        if (!zzyg.equals(this.zzavf, zzfi.zzavf) || !zzyg.equals(this.zzavg, zzfi.zzavg)) {
            return false;
        }
        Boolean bool = this.zzavh;
        if (bool == null) {
            if (zzfi.zzavh != null) {
                return false;
            }
        } else if (!bool.equals(zzfi.zzavh)) {
            return false;
        }
        Boolean bool2 = this.zzavi;
        if (bool2 == null) {
            if (zzfi.zzavi != null) {
                return false;
            }
        } else if (!bool2.equals(zzfi.zzavi)) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzfi.zzcet == null || zzfi.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzfi.zzcet);
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        Integer num = this.zzave;
        int i = 0;
        int hashCode2 = (((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + zzyg.hashCode(this.zzavf)) * 31) + zzyg.hashCode(this.zzavg)) * 31;
        Boolean bool = this.zzavh;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.zzavi;
        int hashCode4 = (hashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            i = this.zzcet.hashCode();
        }
        return hashCode4 + i;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi, com.google.android.gms.internal.measurement.zzyc
    public final void zza(zzya zzya) throws IOException {
        Integer num = this.zzave;
        if (num != null) {
            zzya.zzd(1, num.intValue());
        }
        zzfm[] zzfmArr = this.zzavf;
        int i = 0;
        if (zzfmArr != null && zzfmArr.length > 0) {
            int i2 = 0;
            while (true) {
                zzfm[] zzfmArr2 = this.zzavf;
                if (i2 >= zzfmArr2.length) {
                    break;
                }
                zzfm zzfm = zzfmArr2[i2];
                if (zzfm != null) {
                    zzya.zza(2, zzfm);
                }
                i2++;
            }
        }
        zzfj[] zzfjArr = this.zzavg;
        if (zzfjArr != null && zzfjArr.length > 0) {
            while (true) {
                zzfj[] zzfjArr2 = this.zzavg;
                if (i >= zzfjArr2.length) {
                    break;
                }
                zzfj zzfj = zzfjArr2[i];
                if (zzfj != null) {
                    zzya.zza(3, zzfj);
                }
                i++;
            }
        }
        Boolean bool = this.zzavh;
        if (bool != null) {
            zzya.zzb(4, bool.booleanValue());
        }
        Boolean bool2 = this.zzavi;
        if (bool2 != null) {
            zzya.zzb(5, bool2.booleanValue());
        }
        super.zza(zzya);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzyi, com.google.android.gms.internal.measurement.zzyc
    public final int zzf() {
        int zzf = super.zzf();
        Integer num = this.zzave;
        if (num != null) {
            zzf += zzya.zzh(1, num.intValue());
        }
        zzfm[] zzfmArr = this.zzavf;
        int i = 0;
        if (zzfmArr != null && zzfmArr.length > 0) {
            int i2 = zzf;
            int i3 = 0;
            while (true) {
                zzfm[] zzfmArr2 = this.zzavf;
                if (i3 >= zzfmArr2.length) {
                    break;
                }
                zzfm zzfm = zzfmArr2[i3];
                if (zzfm != null) {
                    i2 += zzya.zzb(2, zzfm);
                }
                i3++;
            }
            zzf = i2;
        }
        zzfj[] zzfjArr = this.zzavg;
        if (zzfjArr != null && zzfjArr.length > 0) {
            while (true) {
                zzfj[] zzfjArr2 = this.zzavg;
                if (i >= zzfjArr2.length) {
                    break;
                }
                zzfj zzfj = zzfjArr2[i];
                if (zzfj != null) {
                    zzf += zzya.zzb(3, zzfj);
                }
                i++;
            }
        }
        Boolean bool = this.zzavh;
        if (bool != null) {
            bool.booleanValue();
            zzf += zzya.zzbd(4) + 1;
        }
        Boolean bool2 = this.zzavi;
        if (bool2 == null) {
            return zzf;
        }
        bool2.booleanValue();
        return zzf + zzya.zzbd(5) + 1;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public final /* synthetic */ zzyi zza(zzxz zzxz) throws IOException {
        while (true) {
            int zzuj = zzxz.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 8) {
                this.zzave = Integer.valueOf(zzxz.zzvb());
            } else if (zzuj == 18) {
                int zzb = zzyl.zzb(zzxz, 18);
                zzfm[] zzfmArr = this.zzavf;
                int length = zzfmArr == null ? 0 : zzfmArr.length;
                zzfm[] zzfmArr2 = new zzfm[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzavf, 0, zzfmArr2, 0, length);
                }
                while (length < zzfmArr2.length - 1) {
                    zzfmArr2[length] = new zzfm();
                    zzxz.zza(zzfmArr2[length]);
                    zzxz.zzuj();
                    length++;
                }
                zzfmArr2[length] = new zzfm();
                zzxz.zza(zzfmArr2[length]);
                this.zzavf = zzfmArr2;
            } else if (zzuj == 26) {
                int zzb2 = zzyl.zzb(zzxz, 26);
                zzfj[] zzfjArr = this.zzavg;
                int length2 = zzfjArr == null ? 0 : zzfjArr.length;
                zzfj[] zzfjArr2 = new zzfj[(zzb2 + length2)];
                if (length2 != 0) {
                    System.arraycopy(this.zzavg, 0, zzfjArr2, 0, length2);
                }
                while (length2 < zzfjArr2.length - 1) {
                    zzfjArr2[length2] = new zzfj();
                    zzxz.zza(zzfjArr2[length2]);
                    zzxz.zzuj();
                    length2++;
                }
                zzfjArr2[length2] = new zzfj();
                zzxz.zza(zzfjArr2[length2]);
                this.zzavg = zzfjArr2;
            } else if (zzuj == 32) {
                this.zzavh = Boolean.valueOf(zzxz.zzup());
            } else if (zzuj == 40) {
                this.zzavi = Boolean.valueOf(zzxz.zzup());
            } else if (!super.zza(zzxz, zzuj)) {
                return this;
            }
        }
    }
}
