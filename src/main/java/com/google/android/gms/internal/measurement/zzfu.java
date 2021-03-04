package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfu extends zzyc<zzfu> {
    private static volatile zzfu[] zzaxd;
    public String name = null;
    public String zzaml = null;
    private Float zzaum = null;
    public Double zzaun = null;
    public Long zzaxe = null;

    public static zzfu[] zzna() {
        if (zzaxd == null) {
            synchronized (zzyg.zzcfc) {
                if (zzaxd == null) {
                    zzaxd = new zzfu[0];
                }
            }
        }
        return zzaxd;
    }

    public zzfu() {
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfu)) {
            return false;
        }
        zzfu zzfu = (zzfu) obj;
        String str = this.name;
        if (str == null) {
            if (zzfu.name != null) {
                return false;
            }
        } else if (!str.equals(zzfu.name)) {
            return false;
        }
        String str2 = this.zzaml;
        if (str2 == null) {
            if (zzfu.zzaml != null) {
                return false;
            }
        } else if (!str2.equals(zzfu.zzaml)) {
            return false;
        }
        Long l = this.zzaxe;
        if (l == null) {
            if (zzfu.zzaxe != null) {
                return false;
            }
        } else if (!l.equals(zzfu.zzaxe)) {
            return false;
        }
        Float f = this.zzaum;
        if (f == null) {
            if (zzfu.zzaum != null) {
                return false;
            }
        } else if (!f.equals(zzfu.zzaum)) {
            return false;
        }
        Double d = this.zzaun;
        if (d == null) {
            if (zzfu.zzaun != null) {
                return false;
            }
        } else if (!d.equals(zzfu.zzaun)) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzfu.zzcet == null || zzfu.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzfu.zzcet);
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        String str = this.name;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.zzaml;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.zzaxe;
        int hashCode4 = (hashCode3 + (l == null ? 0 : l.hashCode())) * 31;
        Float f = this.zzaum;
        int hashCode5 = (hashCode4 + (f == null ? 0 : f.hashCode())) * 31;
        Double d = this.zzaun;
        int hashCode6 = (hashCode5 + (d == null ? 0 : d.hashCode())) * 31;
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            i = this.zzcet.hashCode();
        }
        return hashCode6 + i;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi, com.google.android.gms.internal.measurement.zzyc
    public final void zza(zzya zzya) throws IOException {
        String str = this.name;
        if (str != null) {
            zzya.zzb(1, str);
        }
        String str2 = this.zzaml;
        if (str2 != null) {
            zzya.zzb(2, str2);
        }
        Long l = this.zzaxe;
        if (l != null) {
            zzya.zzi(3, l.longValue());
        }
        Float f = this.zzaum;
        if (f != null) {
            zzya.zza(4, f.floatValue());
        }
        Double d = this.zzaun;
        if (d != null) {
            zzya.zza(5, d.doubleValue());
        }
        super.zza(zzya);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzyi, com.google.android.gms.internal.measurement.zzyc
    public final int zzf() {
        int zzf = super.zzf();
        String str = this.name;
        if (str != null) {
            zzf += zzya.zzc(1, str);
        }
        String str2 = this.zzaml;
        if (str2 != null) {
            zzf += zzya.zzc(2, str2);
        }
        Long l = this.zzaxe;
        if (l != null) {
            zzf += zzya.zzd(3, l.longValue());
        }
        Float f = this.zzaum;
        if (f != null) {
            f.floatValue();
            zzf += zzya.zzbd(4) + 4;
        }
        Double d = this.zzaun;
        if (d == null) {
            return zzf;
        }
        d.doubleValue();
        return zzf + zzya.zzbd(5) + 8;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public final /* synthetic */ zzyi zza(zzxz zzxz) throws IOException {
        while (true) {
            int zzuj = zzxz.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 10) {
                this.name = zzxz.readString();
            } else if (zzuj == 18) {
                this.zzaml = zzxz.readString();
            } else if (zzuj == 24) {
                this.zzaxe = Long.valueOf(zzxz.zzvc());
            } else if (zzuj == 37) {
                this.zzaum = Float.valueOf(Float.intBitsToFloat(zzxz.zzvd()));
            } else if (zzuj == 41) {
                this.zzaun = Double.valueOf(Double.longBitsToDouble(zzxz.zzve()));
            } else if (!super.zza(zzxz, zzuj)) {
                return this;
            }
        }
    }
}
