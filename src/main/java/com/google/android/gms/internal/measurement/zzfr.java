package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfr extends zzyc<zzfr> {
    private static volatile zzfr[] zzaws;
    public Integer zzave = null;
    public zzfx zzawt = null;
    public zzfx zzawu = null;
    public Boolean zzawv = null;

    public static zzfr[] zzmx() {
        if (zzaws == null) {
            synchronized (zzyg.zzcfc) {
                if (zzaws == null) {
                    zzaws = new zzfr[0];
                }
            }
        }
        return zzaws;
    }

    public zzfr() {
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfr)) {
            return false;
        }
        zzfr zzfr = (zzfr) obj;
        Integer num = this.zzave;
        if (num == null) {
            if (zzfr.zzave != null) {
                return false;
            }
        } else if (!num.equals(zzfr.zzave)) {
            return false;
        }
        zzfx zzfx = this.zzawt;
        if (zzfx == null) {
            if (zzfr.zzawt != null) {
                return false;
            }
        } else if (!zzfx.equals(zzfr.zzawt)) {
            return false;
        }
        zzfx zzfx2 = this.zzawu;
        if (zzfx2 == null) {
            if (zzfr.zzawu != null) {
                return false;
            }
        } else if (!zzfx2.equals(zzfr.zzawu)) {
            return false;
        }
        Boolean bool = this.zzawv;
        if (bool == null) {
            if (zzfr.zzawv != null) {
                return false;
            }
        } else if (!bool.equals(zzfr.zzawv)) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzfr.zzcet == null || zzfr.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzfr.zzcet);
    }

    public final int hashCode() {
        int i;
        int i2;
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        Integer num = this.zzave;
        int i3 = 0;
        int hashCode2 = hashCode + (num == null ? 0 : num.hashCode());
        zzfx zzfx = this.zzawt;
        int i4 = hashCode2 * 31;
        if (zzfx == null) {
            i = 0;
        } else {
            i = zzfx.hashCode();
        }
        int i5 = i4 + i;
        zzfx zzfx2 = this.zzawu;
        int i6 = i5 * 31;
        if (zzfx2 == null) {
            i2 = 0;
        } else {
            i2 = zzfx2.hashCode();
        }
        int i7 = (i6 + i2) * 31;
        Boolean bool = this.zzawv;
        int hashCode3 = (i7 + (bool == null ? 0 : bool.hashCode())) * 31;
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            i3 = this.zzcet.hashCode();
        }
        return hashCode3 + i3;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi, com.google.android.gms.internal.measurement.zzyc
    public final void zza(zzya zzya) throws IOException {
        Integer num = this.zzave;
        if (num != null) {
            zzya.zzd(1, num.intValue());
        }
        zzfx zzfx = this.zzawt;
        if (zzfx != null) {
            zzya.zza(2, zzfx);
        }
        zzfx zzfx2 = this.zzawu;
        if (zzfx2 != null) {
            zzya.zza(3, zzfx2);
        }
        Boolean bool = this.zzawv;
        if (bool != null) {
            zzya.zzb(4, bool.booleanValue());
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
        zzfx zzfx = this.zzawt;
        if (zzfx != null) {
            zzf += zzya.zzb(2, zzfx);
        }
        zzfx zzfx2 = this.zzawu;
        if (zzfx2 != null) {
            zzf += zzya.zzb(3, zzfx2);
        }
        Boolean bool = this.zzawv;
        if (bool == null) {
            return zzf;
        }
        bool.booleanValue();
        return zzf + zzya.zzbd(4) + 1;
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
                if (this.zzawt == null) {
                    this.zzawt = new zzfx();
                }
                zzxz.zza(this.zzawt);
            } else if (zzuj == 26) {
                if (this.zzawu == null) {
                    this.zzawu = new zzfx();
                }
                zzxz.zza(this.zzawu);
            } else if (zzuj == 32) {
                this.zzawv = Boolean.valueOf(zzxz.zzup());
            } else if (!super.zza(zzxz, zzuj)) {
                return this;
            }
        }
    }
}
