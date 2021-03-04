package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfn extends zzyc<zzfn> {
    public Integer zzawc = null;
    public String zzawd = null;
    public Boolean zzawe = null;
    public String[] zzawf = zzyl.zzcfm;

    public zzfn() {
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfn)) {
            return false;
        }
        zzfn zzfn = (zzfn) obj;
        Integer num = this.zzawc;
        if (num == null) {
            if (zzfn.zzawc != null) {
                return false;
            }
        } else if (!num.equals(zzfn.zzawc)) {
            return false;
        }
        String str = this.zzawd;
        if (str == null) {
            if (zzfn.zzawd != null) {
                return false;
            }
        } else if (!str.equals(zzfn.zzawd)) {
            return false;
        }
        Boolean bool = this.zzawe;
        if (bool == null) {
            if (zzfn.zzawe != null) {
                return false;
            }
        } else if (!bool.equals(zzfn.zzawe)) {
            return false;
        }
        if (!zzyg.equals(this.zzawf, zzfn.zzawf)) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzfn.zzcet == null || zzfn.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzfn.zzcet);
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        Integer num = this.zzawc;
        int i = 0;
        int intValue = (hashCode + (num == null ? 0 : num.intValue())) * 31;
        String str = this.zzawd;
        int hashCode2 = (intValue + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.zzawe;
        int hashCode3 = (((hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31) + zzyg.hashCode(this.zzawf)) * 31;
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            i = this.zzcet.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi, com.google.android.gms.internal.measurement.zzyc
    public final void zza(zzya zzya) throws IOException {
        Integer num = this.zzawc;
        if (num != null) {
            zzya.zzd(1, num.intValue());
        }
        String str = this.zzawd;
        if (str != null) {
            zzya.zzb(2, str);
        }
        Boolean bool = this.zzawe;
        if (bool != null) {
            zzya.zzb(3, bool.booleanValue());
        }
        String[] strArr = this.zzawf;
        if (strArr != null && strArr.length > 0) {
            int i = 0;
            while (true) {
                String[] strArr2 = this.zzawf;
                if (i >= strArr2.length) {
                    break;
                }
                String str2 = strArr2[i];
                if (str2 != null) {
                    zzya.zzb(4, str2);
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
        Integer num = this.zzawc;
        if (num != null) {
            zzf += zzya.zzh(1, num.intValue());
        }
        String str = this.zzawd;
        if (str != null) {
            zzf += zzya.zzc(2, str);
        }
        Boolean bool = this.zzawe;
        if (bool != null) {
            bool.booleanValue();
            zzf += zzya.zzbd(3) + 1;
        }
        String[] strArr = this.zzawf;
        if (strArr == null || strArr.length <= 0) {
            return zzf;
        }
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String[] strArr2 = this.zzawf;
            if (i >= strArr2.length) {
                return zzf + i2 + (i3 * 1);
            }
            String str2 = strArr2[i];
            if (str2 != null) {
                i3++;
                i2 += zzya.zzgc(str2);
            }
            i++;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzd */
    public final zzfn zza(zzxz zzxz) throws IOException {
        int zzvb;
        while (true) {
            int zzuj = zzxz.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 8) {
                try {
                    zzvb = zzxz.zzvb();
                    if (zzvb < 0 || zzvb > 6) {
                        StringBuilder sb = new StringBuilder(41);
                        sb.append(zzvb);
                        sb.append(" is not a valid enum MatchType");
                    } else {
                        this.zzawc = Integer.valueOf(zzvb);
                    }
                } catch (IllegalArgumentException unused) {
                    zzxz.zzcb(zzxz.getPosition());
                    zza(zzxz, zzuj);
                }
            } else if (zzuj == 18) {
                this.zzawd = zzxz.readString();
            } else if (zzuj == 24) {
                this.zzawe = Boolean.valueOf(zzxz.zzup());
            } else if (zzuj == 34) {
                int zzb = zzyl.zzb(zzxz, 34);
                String[] strArr = this.zzawf;
                int length = strArr == null ? 0 : strArr.length;
                String[] strArr2 = new String[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzawf, 0, strArr2, 0, length);
                }
                while (length < strArr2.length - 1) {
                    strArr2[length] = zzxz.readString();
                    zzxz.zzuj();
                    length++;
                }
                strArr2[length] = zzxz.readString();
                this.zzawf = strArr2;
            } else if (!super.zza(zzxz, zzuj)) {
                return this;
            }
        }
        StringBuilder sb2 = new StringBuilder(41);
        sb2.append(zzvb);
        sb2.append(" is not a valid enum MatchType");
        throw new IllegalArgumentException(sb2.toString());
    }
}
