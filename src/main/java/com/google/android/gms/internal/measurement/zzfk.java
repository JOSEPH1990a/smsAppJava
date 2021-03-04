package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfk extends zzyc<zzfk> {
    private static volatile zzfk[] zzavp;
    public zzfn zzavq = null;
    public zzfl zzavr = null;
    public Boolean zzavs = null;
    public String zzavt = null;

    public static zzfk[] zzmt() {
        if (zzavp == null) {
            synchronized (zzyg.zzcfc) {
                if (zzavp == null) {
                    zzavp = new zzfk[0];
                }
            }
        }
        return zzavp;
    }

    public zzfk() {
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfk)) {
            return false;
        }
        zzfk zzfk = (zzfk) obj;
        zzfn zzfn = this.zzavq;
        if (zzfn == null) {
            if (zzfk.zzavq != null) {
                return false;
            }
        } else if (!zzfn.equals(zzfk.zzavq)) {
            return false;
        }
        zzfl zzfl = this.zzavr;
        if (zzfl == null) {
            if (zzfk.zzavr != null) {
                return false;
            }
        } else if (!zzfl.equals(zzfk.zzavr)) {
            return false;
        }
        Boolean bool = this.zzavs;
        if (bool == null) {
            if (zzfk.zzavs != null) {
                return false;
            }
        } else if (!bool.equals(zzfk.zzavs)) {
            return false;
        }
        String str = this.zzavt;
        if (str == null) {
            if (zzfk.zzavt != null) {
                return false;
            }
        } else if (!str.equals(zzfk.zzavt)) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzfk.zzcet == null || zzfk.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzfk.zzcet);
    }

    public final int hashCode() {
        int i;
        int i2;
        zzfn zzfn = this.zzavq;
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        int i3 = 0;
        if (zzfn == null) {
            i = 0;
        } else {
            i = zzfn.hashCode();
        }
        int i4 = hashCode + i;
        zzfl zzfl = this.zzavr;
        int i5 = i4 * 31;
        if (zzfl == null) {
            i2 = 0;
        } else {
            i2 = zzfl.hashCode();
        }
        int i6 = (i5 + i2) * 31;
        Boolean bool = this.zzavs;
        int hashCode2 = (i6 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.zzavt;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            i3 = this.zzcet.hashCode();
        }
        return hashCode3 + i3;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi, com.google.android.gms.internal.measurement.zzyc
    public final void zza(zzya zzya) throws IOException {
        zzfn zzfn = this.zzavq;
        if (zzfn != null) {
            zzya.zza(1, zzfn);
        }
        zzfl zzfl = this.zzavr;
        if (zzfl != null) {
            zzya.zza(2, zzfl);
        }
        Boolean bool = this.zzavs;
        if (bool != null) {
            zzya.zzb(3, bool.booleanValue());
        }
        String str = this.zzavt;
        if (str != null) {
            zzya.zzb(4, str);
        }
        super.zza(zzya);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzyi, com.google.android.gms.internal.measurement.zzyc
    public final int zzf() {
        int zzf = super.zzf();
        zzfn zzfn = this.zzavq;
        if (zzfn != null) {
            zzf += zzya.zzb(1, zzfn);
        }
        zzfl zzfl = this.zzavr;
        if (zzfl != null) {
            zzf += zzya.zzb(2, zzfl);
        }
        Boolean bool = this.zzavs;
        if (bool != null) {
            bool.booleanValue();
            zzf += zzya.zzbd(3) + 1;
        }
        String str = this.zzavt;
        return str != null ? zzf + zzya.zzc(4, str) : zzf;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public final /* synthetic */ zzyi zza(zzxz zzxz) throws IOException {
        while (true) {
            int zzuj = zzxz.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 10) {
                if (this.zzavq == null) {
                    this.zzavq = new zzfn();
                }
                zzxz.zza(this.zzavq);
            } else if (zzuj == 18) {
                if (this.zzavr == null) {
                    this.zzavr = new zzfl();
                }
                zzxz.zza(this.zzavr);
            } else if (zzuj == 24) {
                this.zzavs = Boolean.valueOf(zzxz.zzup());
            } else if (zzuj == 34) {
                this.zzavt = zzxz.readString();
            } else if (!super.zza(zzxz, zzuj)) {
                return this;
            }
        }
    }
}
