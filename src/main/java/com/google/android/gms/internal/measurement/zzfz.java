package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfz extends zzyc<zzfz> {
    private static volatile zzfz[] zzayt;
    public String name = null;
    public String zzaml = null;
    private Float zzaum = null;
    public Double zzaun = null;
    public Long zzaxe = null;
    public Long zzayu = null;

    public static zzfz[] zznd() {
        if (zzayt == null) {
            synchronized (zzyg.zzcfc) {
                if (zzayt == null) {
                    zzayt = new zzfz[0];
                }
            }
        }
        return zzayt;
    }

    public zzfz() {
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfz)) {
            return false;
        }
        zzfz zzfz = (zzfz) obj;
        Long l = this.zzayu;
        if (l == null) {
            if (zzfz.zzayu != null) {
                return false;
            }
        } else if (!l.equals(zzfz.zzayu)) {
            return false;
        }
        String str = this.name;
        if (str == null) {
            if (zzfz.name != null) {
                return false;
            }
        } else if (!str.equals(zzfz.name)) {
            return false;
        }
        String str2 = this.zzaml;
        if (str2 == null) {
            if (zzfz.zzaml != null) {
                return false;
            }
        } else if (!str2.equals(zzfz.zzaml)) {
            return false;
        }
        Long l2 = this.zzaxe;
        if (l2 == null) {
            if (zzfz.zzaxe != null) {
                return false;
            }
        } else if (!l2.equals(zzfz.zzaxe)) {
            return false;
        }
        Float f = this.zzaum;
        if (f == null) {
            if (zzfz.zzaum != null) {
                return false;
            }
        } else if (!f.equals(zzfz.zzaum)) {
            return false;
        }
        Double d = this.zzaun;
        if (d == null) {
            if (zzfz.zzaun != null) {
                return false;
            }
        } else if (!d.equals(zzfz.zzaun)) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzfz.zzcet == null || zzfz.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzfz.zzcet);
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        Long l = this.zzayu;
        int i = 0;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.name;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.zzaml;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l2 = this.zzaxe;
        int hashCode5 = (hashCode4 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Float f = this.zzaum;
        int hashCode6 = (hashCode5 + (f == null ? 0 : f.hashCode())) * 31;
        Double d = this.zzaun;
        int hashCode7 = (hashCode6 + (d == null ? 0 : d.hashCode())) * 31;
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            i = this.zzcet.hashCode();
        }
        return hashCode7 + i;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi, com.google.android.gms.internal.measurement.zzyc
    public final void zza(zzya zzya) throws IOException {
        Long l = this.zzayu;
        if (l != null) {
            zzya.zzi(1, l.longValue());
        }
        String str = this.name;
        if (str != null) {
            zzya.zzb(2, str);
        }
        String str2 = this.zzaml;
        if (str2 != null) {
            zzya.zzb(3, str2);
        }
        Long l2 = this.zzaxe;
        if (l2 != null) {
            zzya.zzi(4, l2.longValue());
        }
        Float f = this.zzaum;
        if (f != null) {
            zzya.zza(5, f.floatValue());
        }
        Double d = this.zzaun;
        if (d != null) {
            zzya.zza(6, d.doubleValue());
        }
        super.zza(zzya);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzyi, com.google.android.gms.internal.measurement.zzyc
    public final int zzf() {
        int zzf = super.zzf();
        Long l = this.zzayu;
        if (l != null) {
            zzf += zzya.zzd(1, l.longValue());
        }
        String str = this.name;
        if (str != null) {
            zzf += zzya.zzc(2, str);
        }
        String str2 = this.zzaml;
        if (str2 != null) {
            zzf += zzya.zzc(3, str2);
        }
        Long l2 = this.zzaxe;
        if (l2 != null) {
            zzf += zzya.zzd(4, l2.longValue());
        }
        Float f = this.zzaum;
        if (f != null) {
            f.floatValue();
            zzf += zzya.zzbd(5) + 4;
        }
        Double d = this.zzaun;
        if (d == null) {
            return zzf;
        }
        d.doubleValue();
        return zzf + zzya.zzbd(6) + 8;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public final /* synthetic */ zzyi zza(zzxz zzxz) throws IOException {
        while (true) {
            int zzuj = zzxz.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 8) {
                this.zzayu = Long.valueOf(zzxz.zzvc());
            } else if (zzuj == 18) {
                this.name = zzxz.readString();
            } else if (zzuj == 26) {
                this.zzaml = zzxz.readString();
            } else if (zzuj == 32) {
                this.zzaxe = Long.valueOf(zzxz.zzvc());
            } else if (zzuj == 45) {
                this.zzaum = Float.valueOf(Float.intBitsToFloat(zzxz.zzvd()));
            } else if (zzuj == 49) {
                this.zzaun = Double.valueOf(Double.longBitsToDouble(zzxz.zzve()));
            } else if (!super.zza(zzxz, zzuj)) {
                return this;
            }
        }
    }
}
