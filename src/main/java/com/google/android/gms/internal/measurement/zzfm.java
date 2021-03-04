package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfm extends zzyc<zzfm> {
    private static volatile zzfm[] zzavz;
    public Boolean zzavh = null;
    public Boolean zzavi = null;
    public Integer zzavk = null;
    public String zzawa = null;
    public zzfk zzawb = null;

    public static zzfm[] zzmu() {
        if (zzavz == null) {
            synchronized (zzyg.zzcfc) {
                if (zzavz == null) {
                    zzavz = new zzfm[0];
                }
            }
        }
        return zzavz;
    }

    public zzfm() {
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfm)) {
            return false;
        }
        zzfm zzfm = (zzfm) obj;
        Integer num = this.zzavk;
        if (num == null) {
            if (zzfm.zzavk != null) {
                return false;
            }
        } else if (!num.equals(zzfm.zzavk)) {
            return false;
        }
        String str = this.zzawa;
        if (str == null) {
            if (zzfm.zzawa != null) {
                return false;
            }
        } else if (!str.equals(zzfm.zzawa)) {
            return false;
        }
        zzfk zzfk = this.zzawb;
        if (zzfk == null) {
            if (zzfm.zzawb != null) {
                return false;
            }
        } else if (!zzfk.equals(zzfm.zzawb)) {
            return false;
        }
        Boolean bool = this.zzavh;
        if (bool == null) {
            if (zzfm.zzavh != null) {
                return false;
            }
        } else if (!bool.equals(zzfm.zzavh)) {
            return false;
        }
        Boolean bool2 = this.zzavi;
        if (bool2 == null) {
            if (zzfm.zzavi != null) {
                return false;
            }
        } else if (!bool2.equals(zzfm.zzavi)) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzfm.zzcet == null || zzfm.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzfm.zzcet);
    }

    public final int hashCode() {
        int i;
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        Integer num = this.zzavk;
        int i2 = 0;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.zzawa;
        int hashCode3 = hashCode2 + (str == null ? 0 : str.hashCode());
        zzfk zzfk = this.zzawb;
        int i3 = hashCode3 * 31;
        if (zzfk == null) {
            i = 0;
        } else {
            i = zzfk.hashCode();
        }
        int i4 = (i3 + i) * 31;
        Boolean bool = this.zzavh;
        int hashCode4 = (i4 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.zzavi;
        int hashCode5 = (hashCode4 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            i2 = this.zzcet.hashCode();
        }
        return hashCode5 + i2;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi, com.google.android.gms.internal.measurement.zzyc
    public final void zza(zzya zzya) throws IOException {
        Integer num = this.zzavk;
        if (num != null) {
            zzya.zzd(1, num.intValue());
        }
        String str = this.zzawa;
        if (str != null) {
            zzya.zzb(2, str);
        }
        zzfk zzfk = this.zzawb;
        if (zzfk != null) {
            zzya.zza(3, zzfk);
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
        Integer num = this.zzavk;
        if (num != null) {
            zzf += zzya.zzh(1, num.intValue());
        }
        String str = this.zzawa;
        if (str != null) {
            zzf += zzya.zzc(2, str);
        }
        zzfk zzfk = this.zzawb;
        if (zzfk != null) {
            zzf += zzya.zzb(3, zzfk);
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
                this.zzavk = Integer.valueOf(zzxz.zzvb());
            } else if (zzuj == 18) {
                this.zzawa = zzxz.readString();
            } else if (zzuj == 26) {
                if (this.zzawb == null) {
                    this.zzawb = new zzfk();
                }
                zzxz.zza(this.zzawb);
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
