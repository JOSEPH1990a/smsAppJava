package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfj extends zzyc<zzfj> {
    private static volatile zzfj[] zzavj;
    public Boolean zzavh = null;
    public Boolean zzavi = null;
    public Integer zzavk = null;
    public String zzavl = null;
    public zzfk[] zzavm = zzfk.zzmt();
    private Boolean zzavn = null;
    public zzfl zzavo = null;

    public static zzfj[] zzms() {
        if (zzavj == null) {
            synchronized (zzyg.zzcfc) {
                if (zzavj == null) {
                    zzavj = new zzfj[0];
                }
            }
        }
        return zzavj;
    }

    public zzfj() {
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfj)) {
            return false;
        }
        zzfj zzfj = (zzfj) obj;
        Integer num = this.zzavk;
        if (num == null) {
            if (zzfj.zzavk != null) {
                return false;
            }
        } else if (!num.equals(zzfj.zzavk)) {
            return false;
        }
        String str = this.zzavl;
        if (str == null) {
            if (zzfj.zzavl != null) {
                return false;
            }
        } else if (!str.equals(zzfj.zzavl)) {
            return false;
        }
        if (!zzyg.equals(this.zzavm, zzfj.zzavm)) {
            return false;
        }
        Boolean bool = this.zzavn;
        if (bool == null) {
            if (zzfj.zzavn != null) {
                return false;
            }
        } else if (!bool.equals(zzfj.zzavn)) {
            return false;
        }
        zzfl zzfl = this.zzavo;
        if (zzfl == null) {
            if (zzfj.zzavo != null) {
                return false;
            }
        } else if (!zzfl.equals(zzfj.zzavo)) {
            return false;
        }
        Boolean bool2 = this.zzavh;
        if (bool2 == null) {
            if (zzfj.zzavh != null) {
                return false;
            }
        } else if (!bool2.equals(zzfj.zzavh)) {
            return false;
        }
        Boolean bool3 = this.zzavi;
        if (bool3 == null) {
            if (zzfj.zzavi != null) {
                return false;
            }
        } else if (!bool3.equals(zzfj.zzavi)) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzfj.zzcet == null || zzfj.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzfj.zzcet);
    }

    public final int hashCode() {
        int i;
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        Integer num = this.zzavk;
        int i2 = 0;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.zzavl;
        int hashCode3 = (((hashCode2 + (str == null ? 0 : str.hashCode())) * 31) + zzyg.hashCode(this.zzavm)) * 31;
        Boolean bool = this.zzavn;
        int hashCode4 = hashCode3 + (bool == null ? 0 : bool.hashCode());
        zzfl zzfl = this.zzavo;
        int i3 = hashCode4 * 31;
        if (zzfl == null) {
            i = 0;
        } else {
            i = zzfl.hashCode();
        }
        int i4 = (i3 + i) * 31;
        Boolean bool2 = this.zzavh;
        int hashCode5 = (i4 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.zzavi;
        int hashCode6 = (hashCode5 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            i2 = this.zzcet.hashCode();
        }
        return hashCode6 + i2;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi, com.google.android.gms.internal.measurement.zzyc
    public final void zza(zzya zzya) throws IOException {
        Integer num = this.zzavk;
        if (num != null) {
            zzya.zzd(1, num.intValue());
        }
        String str = this.zzavl;
        if (str != null) {
            zzya.zzb(2, str);
        }
        zzfk[] zzfkArr = this.zzavm;
        if (zzfkArr != null && zzfkArr.length > 0) {
            int i = 0;
            while (true) {
                zzfk[] zzfkArr2 = this.zzavm;
                if (i >= zzfkArr2.length) {
                    break;
                }
                zzfk zzfk = zzfkArr2[i];
                if (zzfk != null) {
                    zzya.zza(3, zzfk);
                }
                i++;
            }
        }
        Boolean bool = this.zzavn;
        if (bool != null) {
            zzya.zzb(4, bool.booleanValue());
        }
        zzfl zzfl = this.zzavo;
        if (zzfl != null) {
            zzya.zza(5, zzfl);
        }
        Boolean bool2 = this.zzavh;
        if (bool2 != null) {
            zzya.zzb(6, bool2.booleanValue());
        }
        Boolean bool3 = this.zzavi;
        if (bool3 != null) {
            zzya.zzb(7, bool3.booleanValue());
        }
        super.zza(zzya);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzyi, com.google.android.gms.internal.measurement.zzyc
    public final int zzf() {
        int zzf = super.zzf();
        Integer num = this.zzavk;
        if (num != null) {
            zzf += zzya.zzh(1, num.intValue());
        }
        String str = this.zzavl;
        if (str != null) {
            zzf += zzya.zzc(2, str);
        }
        zzfk[] zzfkArr = this.zzavm;
        if (zzfkArr != null && zzfkArr.length > 0) {
            int i = 0;
            while (true) {
                zzfk[] zzfkArr2 = this.zzavm;
                if (i >= zzfkArr2.length) {
                    break;
                }
                zzfk zzfk = zzfkArr2[i];
                if (zzfk != null) {
                    zzf += zzya.zzb(3, zzfk);
                }
                i++;
            }
        }
        Boolean bool = this.zzavn;
        if (bool != null) {
            bool.booleanValue();
            zzf += zzya.zzbd(4) + 1;
        }
        zzfl zzfl = this.zzavo;
        if (zzfl != null) {
            zzf += zzya.zzb(5, zzfl);
        }
        Boolean bool2 = this.zzavh;
        if (bool2 != null) {
            bool2.booleanValue();
            zzf += zzya.zzbd(6) + 1;
        }
        Boolean bool3 = this.zzavi;
        if (bool3 == null) {
            return zzf;
        }
        bool3.booleanValue();
        return zzf + zzya.zzbd(7) + 1;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public final /* synthetic */ zzyi zza(zzxz zzxz) throws IOException {
        while (true) {
            int zzuj = zzxz.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 8) {
                this.zzavk = Integer.valueOf(zzxz.zzvb());
            } else if (zzuj == 18) {
                this.zzavl = zzxz.readString();
            } else if (zzuj == 26) {
                int zzb = zzyl.zzb(zzxz, 26);
                zzfk[] zzfkArr = this.zzavm;
                int length = zzfkArr == null ? 0 : zzfkArr.length;
                zzfk[] zzfkArr2 = new zzfk[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzavm, 0, zzfkArr2, 0, length);
                }
                while (length < zzfkArr2.length - 1) {
                    zzfkArr2[length] = new zzfk();
                    zzxz.zza(zzfkArr2[length]);
                    zzxz.zzuj();
                    length++;
                }
                zzfkArr2[length] = new zzfk();
                zzxz.zza(zzfkArr2[length]);
                this.zzavm = zzfkArr2;
            } else if (zzuj == 32) {
                this.zzavn = Boolean.valueOf(zzxz.zzup());
            } else if (zzuj == 42) {
                if (this.zzavo == null) {
                    this.zzavo = new zzfl();
                }
                zzxz.zza(this.zzavo);
            } else if (zzuj == 48) {
                this.zzavh = Boolean.valueOf(zzxz.zzup());
            } else if (zzuj == 56) {
                this.zzavi = Boolean.valueOf(zzxz.zzup());
            } else if (!super.zza(zzxz, zzuj)) {
                return this;
            }
        }
    }
}
