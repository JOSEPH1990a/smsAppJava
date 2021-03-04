package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfo extends zzyc<zzfo> {
    private static volatile zzfo[] zzawg;
    public String name = null;
    public Boolean zzawh = null;
    public Boolean zzawi = null;
    public Integer zzawj = null;

    public static zzfo[] zzmv() {
        if (zzawg == null) {
            synchronized (zzyg.zzcfc) {
                if (zzawg == null) {
                    zzawg = new zzfo[0];
                }
            }
        }
        return zzawg;
    }

    public zzfo() {
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfo)) {
            return false;
        }
        zzfo zzfo = (zzfo) obj;
        String str = this.name;
        if (str == null) {
            if (zzfo.name != null) {
                return false;
            }
        } else if (!str.equals(zzfo.name)) {
            return false;
        }
        Boolean bool = this.zzawh;
        if (bool == null) {
            if (zzfo.zzawh != null) {
                return false;
            }
        } else if (!bool.equals(zzfo.zzawh)) {
            return false;
        }
        Boolean bool2 = this.zzawi;
        if (bool2 == null) {
            if (zzfo.zzawi != null) {
                return false;
            }
        } else if (!bool2.equals(zzfo.zzawi)) {
            return false;
        }
        Integer num = this.zzawj;
        if (num == null) {
            if (zzfo.zzawj != null) {
                return false;
            }
        } else if (!num.equals(zzfo.zzawj)) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzfo.zzcet == null || zzfo.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzfo.zzcet);
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        String str = this.name;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.zzawh;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.zzawi;
        int hashCode4 = (hashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Integer num = this.zzawj;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            i = this.zzcet.hashCode();
        }
        return hashCode5 + i;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi, com.google.android.gms.internal.measurement.zzyc
    public final void zza(zzya zzya) throws IOException {
        String str = this.name;
        if (str != null) {
            zzya.zzb(1, str);
        }
        Boolean bool = this.zzawh;
        if (bool != null) {
            zzya.zzb(2, bool.booleanValue());
        }
        Boolean bool2 = this.zzawi;
        if (bool2 != null) {
            zzya.zzb(3, bool2.booleanValue());
        }
        Integer num = this.zzawj;
        if (num != null) {
            zzya.zzd(4, num.intValue());
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
        Boolean bool = this.zzawh;
        if (bool != null) {
            bool.booleanValue();
            zzf += zzya.zzbd(2) + 1;
        }
        Boolean bool2 = this.zzawi;
        if (bool2 != null) {
            bool2.booleanValue();
            zzf += zzya.zzbd(3) + 1;
        }
        Integer num = this.zzawj;
        return num != null ? zzf + zzya.zzh(4, num.intValue()) : zzf;
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
            } else if (zzuj == 16) {
                this.zzawh = Boolean.valueOf(zzxz.zzup());
            } else if (zzuj == 24) {
                this.zzawi = Boolean.valueOf(zzxz.zzup());
            } else if (zzuj == 32) {
                this.zzawj = Integer.valueOf(zzxz.zzvb());
            } else if (!super.zza(zzxz, zzuj)) {
                return this;
            }
        }
    }
}
