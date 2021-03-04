package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfx extends zzyc<zzfx> {
    public long[] zzayn = zzyl.zzcfi;
    public long[] zzayo = zzyl.zzcfi;
    public zzfs[] zzayp = zzfs.zzmy();
    public zzfy[] zzayq = zzfy.zznc();

    public zzfx() {
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfx)) {
            return false;
        }
        zzfx zzfx = (zzfx) obj;
        if (!zzyg.equals(this.zzayn, zzfx.zzayn) || !zzyg.equals(this.zzayo, zzfx.zzayo) || !zzyg.equals(this.zzayp, zzfx.zzayp) || !zzyg.equals(this.zzayq, zzfx.zzayq)) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzfx.zzcet == null || zzfx.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzfx.zzcet);
    }

    public final int hashCode() {
        return ((((((((((getClass().getName().hashCode() + 527) * 31) + zzyg.hashCode(this.zzayn)) * 31) + zzyg.hashCode(this.zzayo)) * 31) + zzyg.hashCode(this.zzayp)) * 31) + zzyg.hashCode(this.zzayq)) * 31) + ((this.zzcet == null || this.zzcet.isEmpty()) ? 0 : this.zzcet.hashCode());
    }

    @Override // com.google.android.gms.internal.measurement.zzyi, com.google.android.gms.internal.measurement.zzyc
    public final void zza(zzya zzya) throws IOException {
        long[] jArr = this.zzayn;
        int i = 0;
        if (jArr != null && jArr.length > 0) {
            int i2 = 0;
            while (true) {
                long[] jArr2 = this.zzayn;
                if (i2 >= jArr2.length) {
                    break;
                }
                zzya.zza(1, jArr2[i2]);
                i2++;
            }
        }
        long[] jArr3 = this.zzayo;
        if (jArr3 != null && jArr3.length > 0) {
            int i3 = 0;
            while (true) {
                long[] jArr4 = this.zzayo;
                if (i3 >= jArr4.length) {
                    break;
                }
                zzya.zza(2, jArr4[i3]);
                i3++;
            }
        }
        zzfs[] zzfsArr = this.zzayp;
        if (zzfsArr != null && zzfsArr.length > 0) {
            int i4 = 0;
            while (true) {
                zzfs[] zzfsArr2 = this.zzayp;
                if (i4 >= zzfsArr2.length) {
                    break;
                }
                zzfs zzfs = zzfsArr2[i4];
                if (zzfs != null) {
                    zzya.zza(3, zzfs);
                }
                i4++;
            }
        }
        zzfy[] zzfyArr = this.zzayq;
        if (zzfyArr != null && zzfyArr.length > 0) {
            while (true) {
                zzfy[] zzfyArr2 = this.zzayq;
                if (i >= zzfyArr2.length) {
                    break;
                }
                zzfy zzfy = zzfyArr2[i];
                if (zzfy != null) {
                    zzya.zza(4, zzfy);
                }
                i++;
            }
        }
        super.zza(zzya);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzyi, com.google.android.gms.internal.measurement.zzyc
    public final int zzf() {
        long[] jArr;
        long[] jArr2;
        int zzf = super.zzf();
        long[] jArr3 = this.zzayn;
        int i = 0;
        if (jArr3 != null && jArr3.length > 0) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                jArr2 = this.zzayn;
                if (i2 >= jArr2.length) {
                    break;
                }
                i3 += zzya.zzbg(jArr2[i2]);
                i2++;
            }
            zzf = zzf + i3 + (jArr2.length * 1);
        }
        long[] jArr4 = this.zzayo;
        if (jArr4 != null && jArr4.length > 0) {
            int i4 = 0;
            int i5 = 0;
            while (true) {
                jArr = this.zzayo;
                if (i4 >= jArr.length) {
                    break;
                }
                i5 += zzya.zzbg(jArr[i4]);
                i4++;
            }
            zzf = zzf + i5 + (jArr.length * 1);
        }
        zzfs[] zzfsArr = this.zzayp;
        if (zzfsArr != null && zzfsArr.length > 0) {
            int i6 = zzf;
            int i7 = 0;
            while (true) {
                zzfs[] zzfsArr2 = this.zzayp;
                if (i7 >= zzfsArr2.length) {
                    break;
                }
                zzfs zzfs = zzfsArr2[i7];
                if (zzfs != null) {
                    i6 += zzya.zzb(3, zzfs);
                }
                i7++;
            }
            zzf = i6;
        }
        zzfy[] zzfyArr = this.zzayq;
        if (zzfyArr != null && zzfyArr.length > 0) {
            while (true) {
                zzfy[] zzfyArr2 = this.zzayq;
                if (i >= zzfyArr2.length) {
                    break;
                }
                zzfy zzfy = zzfyArr2[i];
                if (zzfy != null) {
                    zzf += zzya.zzb(4, zzfy);
                }
                i++;
            }
        }
        return zzf;
    }

    @Override // com.google.android.gms.internal.measurement.zzyi
    public final /* synthetic */ zzyi zza(zzxz zzxz) throws IOException {
        while (true) {
            int zzuj = zzxz.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 8) {
                int zzb = zzyl.zzb(zzxz, 8);
                long[] jArr = this.zzayn;
                int length = jArr == null ? 0 : jArr.length;
                long[] jArr2 = new long[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzayn, 0, jArr2, 0, length);
                }
                while (length < jArr2.length - 1) {
                    jArr2[length] = zzxz.zzvc();
                    zzxz.zzuj();
                    length++;
                }
                jArr2[length] = zzxz.zzvc();
                this.zzayn = jArr2;
            } else if (zzuj == 10) {
                int zzas = zzxz.zzas(zzxz.zzvb());
                int position = zzxz.getPosition();
                int i = 0;
                while (zzxz.zzyy() > 0) {
                    zzxz.zzvc();
                    i++;
                }
                zzxz.zzcb(position);
                long[] jArr3 = this.zzayn;
                int length2 = jArr3 == null ? 0 : jArr3.length;
                long[] jArr4 = new long[(i + length2)];
                if (length2 != 0) {
                    System.arraycopy(this.zzayn, 0, jArr4, 0, length2);
                }
                while (length2 < jArr4.length) {
                    jArr4[length2] = zzxz.zzvc();
                    length2++;
                }
                this.zzayn = jArr4;
                zzxz.zzat(zzas);
            } else if (zzuj == 16) {
                int zzb2 = zzyl.zzb(zzxz, 16);
                long[] jArr5 = this.zzayo;
                int length3 = jArr5 == null ? 0 : jArr5.length;
                long[] jArr6 = new long[(zzb2 + length3)];
                if (length3 != 0) {
                    System.arraycopy(this.zzayo, 0, jArr6, 0, length3);
                }
                while (length3 < jArr6.length - 1) {
                    jArr6[length3] = zzxz.zzvc();
                    zzxz.zzuj();
                    length3++;
                }
                jArr6[length3] = zzxz.zzvc();
                this.zzayo = jArr6;
            } else if (zzuj == 18) {
                int zzas2 = zzxz.zzas(zzxz.zzvb());
                int position2 = zzxz.getPosition();
                int i2 = 0;
                while (zzxz.zzyy() > 0) {
                    zzxz.zzvc();
                    i2++;
                }
                zzxz.zzcb(position2);
                long[] jArr7 = this.zzayo;
                int length4 = jArr7 == null ? 0 : jArr7.length;
                long[] jArr8 = new long[(i2 + length4)];
                if (length4 != 0) {
                    System.arraycopy(this.zzayo, 0, jArr8, 0, length4);
                }
                while (length4 < jArr8.length) {
                    jArr8[length4] = zzxz.zzvc();
                    length4++;
                }
                this.zzayo = jArr8;
                zzxz.zzat(zzas2);
            } else if (zzuj == 26) {
                int zzb3 = zzyl.zzb(zzxz, 26);
                zzfs[] zzfsArr = this.zzayp;
                int length5 = zzfsArr == null ? 0 : zzfsArr.length;
                zzfs[] zzfsArr2 = new zzfs[(zzb3 + length5)];
                if (length5 != 0) {
                    System.arraycopy(this.zzayp, 0, zzfsArr2, 0, length5);
                }
                while (length5 < zzfsArr2.length - 1) {
                    zzfsArr2[length5] = new zzfs();
                    zzxz.zza(zzfsArr2[length5]);
                    zzxz.zzuj();
                    length5++;
                }
                zzfsArr2[length5] = new zzfs();
                zzxz.zza(zzfsArr2[length5]);
                this.zzayp = zzfsArr2;
            } else if (zzuj == 34) {
                int zzb4 = zzyl.zzb(zzxz, 34);
                zzfy[] zzfyArr = this.zzayq;
                int length6 = zzfyArr == null ? 0 : zzfyArr.length;
                zzfy[] zzfyArr2 = new zzfy[(zzb4 + length6)];
                if (length6 != 0) {
                    System.arraycopy(this.zzayq, 0, zzfyArr2, 0, length6);
                }
                while (length6 < zzfyArr2.length - 1) {
                    zzfyArr2[length6] = new zzfy();
                    zzxz.zza(zzfyArr2[length6]);
                    zzxz.zzuj();
                    length6++;
                }
                zzfyArr2[length6] = new zzfy();
                zzxz.zza(zzfyArr2[length6]);
                this.zzayq = zzfyArr2;
            } else if (!super.zza(zzxz, zzuj)) {
                return this;
            }
        }
    }
}
