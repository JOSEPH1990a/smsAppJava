package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfl extends zzyc<zzfl> {
    public Integer zzavu = null;
    public Boolean zzavv = null;
    public String zzavw = null;
    public String zzavx = null;
    public String zzavy = null;

    public zzfl() {
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfl)) {
            return false;
        }
        zzfl zzfl = (zzfl) obj;
        Integer num = this.zzavu;
        if (num == null) {
            if (zzfl.zzavu != null) {
                return false;
            }
        } else if (!num.equals(zzfl.zzavu)) {
            return false;
        }
        Boolean bool = this.zzavv;
        if (bool == null) {
            if (zzfl.zzavv != null) {
                return false;
            }
        } else if (!bool.equals(zzfl.zzavv)) {
            return false;
        }
        String str = this.zzavw;
        if (str == null) {
            if (zzfl.zzavw != null) {
                return false;
            }
        } else if (!str.equals(zzfl.zzavw)) {
            return false;
        }
        String str2 = this.zzavx;
        if (str2 == null) {
            if (zzfl.zzavx != null) {
                return false;
            }
        } else if (!str2.equals(zzfl.zzavx)) {
            return false;
        }
        String str3 = this.zzavy;
        if (str3 == null) {
            if (zzfl.zzavy != null) {
                return false;
            }
        } else if (!str3.equals(zzfl.zzavy)) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzfl.zzcet == null || zzfl.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzfl.zzcet);
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        Integer num = this.zzavu;
        int i = 0;
        int intValue = (hashCode + (num == null ? 0 : num.intValue())) * 31;
        Boolean bool = this.zzavv;
        int hashCode2 = (intValue + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.zzavw;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.zzavx;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.zzavy;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            i = this.zzcet.hashCode();
        }
        return hashCode5 + i;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi, com.google.android.gms.internal.measurement.zzyc
    public final void zza(zzya zzya) throws IOException {
        Integer num = this.zzavu;
        if (num != null) {
            zzya.zzd(1, num.intValue());
        }
        Boolean bool = this.zzavv;
        if (bool != null) {
            zzya.zzb(2, bool.booleanValue());
        }
        String str = this.zzavw;
        if (str != null) {
            zzya.zzb(3, str);
        }
        String str2 = this.zzavx;
        if (str2 != null) {
            zzya.zzb(4, str2);
        }
        String str3 = this.zzavy;
        if (str3 != null) {
            zzya.zzb(5, str3);
        }
        super.zza(zzya);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzyi, com.google.android.gms.internal.measurement.zzyc
    public final int zzf() {
        int zzf = super.zzf();
        Integer num = this.zzavu;
        if (num != null) {
            zzf += zzya.zzh(1, num.intValue());
        }
        Boolean bool = this.zzavv;
        if (bool != null) {
            bool.booleanValue();
            zzf += zzya.zzbd(2) + 1;
        }
        String str = this.zzavw;
        if (str != null) {
            zzf += zzya.zzc(3, str);
        }
        String str2 = this.zzavx;
        if (str2 != null) {
            zzf += zzya.zzc(4, str2);
        }
        String str3 = this.zzavy;
        return str3 != null ? zzf + zzya.zzc(5, str3) : zzf;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzc */
    public final zzfl zza(zzxz zzxz) throws IOException {
        int zzvb;
        while (true) {
            int zzuj = zzxz.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 8) {
                try {
                    zzvb = zzxz.zzvb();
                    if (zzvb < 0 || zzvb > 4) {
                        StringBuilder sb = new StringBuilder(46);
                        sb.append(zzvb);
                        sb.append(" is not a valid enum ComparisonType");
                    } else {
                        this.zzavu = Integer.valueOf(zzvb);
                    }
                } catch (IllegalArgumentException unused) {
                    zzxz.zzcb(zzxz.getPosition());
                    zza(zzxz, zzuj);
                }
            } else if (zzuj == 16) {
                this.zzavv = Boolean.valueOf(zzxz.zzup());
            } else if (zzuj == 26) {
                this.zzavw = zzxz.readString();
            } else if (zzuj == 34) {
                this.zzavx = zzxz.readString();
            } else if (zzuj == 42) {
                this.zzavy = zzxz.readString();
            } else if (!super.zza(zzxz, zzuj)) {
                return this;
            }
        }
        StringBuilder sb2 = new StringBuilder(46);
        sb2.append(zzvb);
        sb2.append(" is not a valid enum ComparisonType");
        throw new IllegalArgumentException(sb2.toString());
    }
}
