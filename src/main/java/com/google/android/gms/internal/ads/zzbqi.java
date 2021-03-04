package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class zzbqi implements zzbtb {
    private int tag;
    private final zzbqf zzfma;
    private int zzfmb;
    private int zzfmc = 0;

    public static zzbqi zza(zzbqf zzbqf) {
        if (zzbqf.zzflt != null) {
            return zzbqf.zzflt;
        }
        return new zzbqi(zzbqf);
    }

    private zzbqi(zzbqf zzbqf) {
        this.zzfma = (zzbqf) zzbrf.zza(zzbqf, "input");
        this.zzfma.zzflt = this;
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final int zzals() throws IOException {
        int i = this.zzfmc;
        if (i != 0) {
            this.tag = i;
            this.zzfmc = 0;
        } else {
            this.tag = this.zzfma.zzaku();
        }
        int i2 = this.tag;
        if (i2 == 0 || i2 == this.zzfmb) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final int getTag() {
        return this.tag;
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final boolean zzalt() throws IOException {
        int i;
        if (this.zzfma.zzalk() || (i = this.tag) == this.zzfmb) {
            return false;
        }
        return this.zzfma.zzep(i);
    }

    private final void zzev(int i) throws IOException {
        if ((this.tag & 7) != i) {
            throw zzbrl.zzanh();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final double readDouble() throws IOException {
        zzev(1);
        return this.zzfma.readDouble();
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final float readFloat() throws IOException {
        zzev(5);
        return this.zzfma.readFloat();
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final long zzakv() throws IOException {
        zzev(0);
        return this.zzfma.zzakv();
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final long zzakw() throws IOException {
        zzev(0);
        return this.zzfma.zzakw();
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final int zzakx() throws IOException {
        zzev(0);
        return this.zzfma.zzakx();
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final long zzaky() throws IOException {
        zzev(1);
        return this.zzfma.zzaky();
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final int zzakz() throws IOException {
        zzev(5);
        return this.zzfma.zzakz();
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final boolean zzala() throws IOException {
        zzev(0);
        return this.zzfma.zzala();
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final String readString() throws IOException {
        zzev(2);
        return this.zzfma.readString();
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final String zzalb() throws IOException {
        zzev(2);
        return this.zzfma.zzalb();
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final <T> T zza(zzbtc<T> zzbtc, zzbqq zzbqq) throws IOException {
        zzev(2);
        return (T) zzc(zzbtc, zzbqq);
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final <T> T zzb(zzbtc<T> zzbtc, zzbqq zzbqq) throws IOException {
        zzev(3);
        return (T) zzd(zzbtc, zzbqq);
    }

    private final <T> T zzc(zzbtc<T> zzbtc, zzbqq zzbqq) throws IOException {
        int zzald = this.zzfma.zzald();
        if (this.zzfma.zzflq < this.zzfma.zzflr) {
            int zzer = this.zzfma.zzer(zzald);
            T newInstance = zzbtc.newInstance();
            this.zzfma.zzflq++;
            zzbtc.zza(newInstance, this, zzbqq);
            zzbtc.zzs(newInstance);
            this.zzfma.zzeo(0);
            zzbqf zzbqf = this.zzfma;
            zzbqf.zzflq--;
            this.zzfma.zzes(zzer);
            return newInstance;
        }
        throw zzbrl.zzani();
    }

    private final <T> T zzd(zzbtc<T> zzbtc, zzbqq zzbqq) throws IOException {
        int i = this.zzfmb;
        this.zzfmb = ((this.tag >>> 3) << 3) | 4;
        try {
            T newInstance = zzbtc.newInstance();
            zzbtc.zza(newInstance, this, zzbqq);
            zzbtc.zzs(newInstance);
            if (this.tag == this.zzfmb) {
                return newInstance;
            }
            throw zzbrl.zzanj();
        } finally {
            this.zzfmb = i;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final zzbpu zzalc() throws IOException {
        zzev(2);
        return this.zzfma.zzalc();
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final int zzald() throws IOException {
        zzev(0);
        return this.zzfma.zzald();
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final int zzale() throws IOException {
        zzev(0);
        return this.zzfma.zzale();
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final int zzalf() throws IOException {
        zzev(5);
        return this.zzfma.zzalf();
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final long zzalg() throws IOException {
        zzev(1);
        return this.zzfma.zzalg();
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final int zzalh() throws IOException {
        zzev(0);
        return this.zzfma.zzalh();
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final long zzali() throws IOException {
        zzev(0);
        return this.zzfma.zzali();
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzp(List<Double> list) throws IOException {
        int zzaku;
        int zzaku2;
        if (list instanceof zzbqn) {
            zzbqn zzbqn = (zzbqn) list;
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    int zzald = this.zzfma.zzald();
                    zzew(zzald);
                    int zzall = this.zzfma.zzall() + zzald;
                    do {
                        zzbqn.zzd(this.zzfma.readDouble());
                    } while (this.zzfma.zzall() < zzall);
                    return;
                default:
                    throw zzbrl.zzanh();
            }
            do {
                zzbqn.zzd(this.zzfma.readDouble());
                if (!this.zzfma.zzalk()) {
                    zzaku2 = this.zzfma.zzaku();
                } else {
                    return;
                }
            } while (zzaku2 == this.tag);
            this.zzfmc = zzaku2;
            return;
        }
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                int zzald2 = this.zzfma.zzald();
                zzew(zzald2);
                int zzall2 = this.zzfma.zzall() + zzald2;
                do {
                    list.add(Double.valueOf(this.zzfma.readDouble()));
                } while (this.zzfma.zzall() < zzall2);
                return;
            default:
                throw zzbrl.zzanh();
        }
        do {
            list.add(Double.valueOf(this.zzfma.readDouble()));
            if (!this.zzfma.zzalk()) {
                zzaku = this.zzfma.zzaku();
            } else {
                return;
            }
        } while (zzaku == this.tag);
        this.zzfmc = zzaku;
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzq(List<Float> list) throws IOException {
        int zzaku;
        int zzaku2;
        if (list instanceof zzbra) {
            zzbra zzbra = (zzbra) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzald = this.zzfma.zzald();
                zzex(zzald);
                int zzall = this.zzfma.zzall() + zzald;
                do {
                    zzbra.zzh(this.zzfma.readFloat());
                } while (this.zzfma.zzall() < zzall);
            } else if (i == 5) {
                do {
                    zzbra.zzh(this.zzfma.readFloat());
                    if (!this.zzfma.zzalk()) {
                        zzaku2 = this.zzfma.zzaku();
                    } else {
                        return;
                    }
                } while (zzaku2 == this.tag);
                this.zzfmc = zzaku2;
            } else {
                throw zzbrl.zzanh();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzald2 = this.zzfma.zzald();
                zzex(zzald2);
                int zzall2 = this.zzfma.zzall() + zzald2;
                do {
                    list.add(Float.valueOf(this.zzfma.readFloat()));
                } while (this.zzfma.zzall() < zzall2);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(this.zzfma.readFloat()));
                    if (!this.zzfma.zzalk()) {
                        zzaku = this.zzfma.zzaku();
                    } else {
                        return;
                    }
                } while (zzaku == this.tag);
                this.zzfmc = zzaku;
            } else {
                throw zzbrl.zzanh();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzr(List<Long> list) throws IOException {
        int zzaku;
        int zzaku2;
        if (list instanceof zzbrz) {
            zzbrz zzbrz = (zzbrz) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzbrz.zzbj(this.zzfma.zzakv());
                    if (!this.zzfma.zzalk()) {
                        zzaku2 = this.zzfma.zzaku();
                    } else {
                        return;
                    }
                } while (zzaku2 == this.tag);
                this.zzfmc = zzaku2;
            } else if (i == 2) {
                int zzall = this.zzfma.zzall() + this.zzfma.zzald();
                do {
                    zzbrz.zzbj(this.zzfma.zzakv());
                } while (this.zzfma.zzall() < zzall);
                zzey(zzall);
            } else {
                throw zzbrl.zzanh();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzfma.zzakv()));
                    if (!this.zzfma.zzalk()) {
                        zzaku = this.zzfma.zzaku();
                    } else {
                        return;
                    }
                } while (zzaku == this.tag);
                this.zzfmc = zzaku;
            } else if (i2 == 2) {
                int zzall2 = this.zzfma.zzall() + this.zzfma.zzald();
                do {
                    list.add(Long.valueOf(this.zzfma.zzakv()));
                } while (this.zzfma.zzall() < zzall2);
                zzey(zzall2);
            } else {
                throw zzbrl.zzanh();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzs(List<Long> list) throws IOException {
        int zzaku;
        int zzaku2;
        if (list instanceof zzbrz) {
            zzbrz zzbrz = (zzbrz) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzbrz.zzbj(this.zzfma.zzakw());
                    if (!this.zzfma.zzalk()) {
                        zzaku2 = this.zzfma.zzaku();
                    } else {
                        return;
                    }
                } while (zzaku2 == this.tag);
                this.zzfmc = zzaku2;
            } else if (i == 2) {
                int zzall = this.zzfma.zzall() + this.zzfma.zzald();
                do {
                    zzbrz.zzbj(this.zzfma.zzakw());
                } while (this.zzfma.zzall() < zzall);
                zzey(zzall);
            } else {
                throw zzbrl.zzanh();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzfma.zzakw()));
                    if (!this.zzfma.zzalk()) {
                        zzaku = this.zzfma.zzaku();
                    } else {
                        return;
                    }
                } while (zzaku == this.tag);
                this.zzfmc = zzaku;
            } else if (i2 == 2) {
                int zzall2 = this.zzfma.zzall() + this.zzfma.zzald();
                do {
                    list.add(Long.valueOf(this.zzfma.zzakw()));
                } while (this.zzfma.zzall() < zzall2);
                zzey(zzall2);
            } else {
                throw zzbrl.zzanh();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzt(List<Integer> list) throws IOException {
        int zzaku;
        int zzaku2;
        if (list instanceof zzbre) {
            zzbre zzbre = (zzbre) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzbre.zzfo(this.zzfma.zzakx());
                    if (!this.zzfma.zzalk()) {
                        zzaku2 = this.zzfma.zzaku();
                    } else {
                        return;
                    }
                } while (zzaku2 == this.tag);
                this.zzfmc = zzaku2;
            } else if (i == 2) {
                int zzall = this.zzfma.zzall() + this.zzfma.zzald();
                do {
                    zzbre.zzfo(this.zzfma.zzakx());
                } while (this.zzfma.zzall() < zzall);
                zzey(zzall);
            } else {
                throw zzbrl.zzanh();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzfma.zzakx()));
                    if (!this.zzfma.zzalk()) {
                        zzaku = this.zzfma.zzaku();
                    } else {
                        return;
                    }
                } while (zzaku == this.tag);
                this.zzfmc = zzaku;
            } else if (i2 == 2) {
                int zzall2 = this.zzfma.zzall() + this.zzfma.zzald();
                do {
                    list.add(Integer.valueOf(this.zzfma.zzakx()));
                } while (this.zzfma.zzall() < zzall2);
                zzey(zzall2);
            } else {
                throw zzbrl.zzanh();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzu(List<Long> list) throws IOException {
        int zzaku;
        int zzaku2;
        if (list instanceof zzbrz) {
            zzbrz zzbrz = (zzbrz) list;
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    int zzald = this.zzfma.zzald();
                    zzew(zzald);
                    int zzall = this.zzfma.zzall() + zzald;
                    do {
                        zzbrz.zzbj(this.zzfma.zzaky());
                    } while (this.zzfma.zzall() < zzall);
                    return;
                default:
                    throw zzbrl.zzanh();
            }
            do {
                zzbrz.zzbj(this.zzfma.zzaky());
                if (!this.zzfma.zzalk()) {
                    zzaku2 = this.zzfma.zzaku();
                } else {
                    return;
                }
            } while (zzaku2 == this.tag);
            this.zzfmc = zzaku2;
            return;
        }
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                int zzald2 = this.zzfma.zzald();
                zzew(zzald2);
                int zzall2 = this.zzfma.zzall() + zzald2;
                do {
                    list.add(Long.valueOf(this.zzfma.zzaky()));
                } while (this.zzfma.zzall() < zzall2);
                return;
            default:
                throw zzbrl.zzanh();
        }
        do {
            list.add(Long.valueOf(this.zzfma.zzaky()));
            if (!this.zzfma.zzalk()) {
                zzaku = this.zzfma.zzaku();
            } else {
                return;
            }
        } while (zzaku == this.tag);
        this.zzfmc = zzaku;
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzv(List<Integer> list) throws IOException {
        int zzaku;
        int zzaku2;
        if (list instanceof zzbre) {
            zzbre zzbre = (zzbre) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzald = this.zzfma.zzald();
                zzex(zzald);
                int zzall = this.zzfma.zzall() + zzald;
                do {
                    zzbre.zzfo(this.zzfma.zzakz());
                } while (this.zzfma.zzall() < zzall);
            } else if (i == 5) {
                do {
                    zzbre.zzfo(this.zzfma.zzakz());
                    if (!this.zzfma.zzalk()) {
                        zzaku2 = this.zzfma.zzaku();
                    } else {
                        return;
                    }
                } while (zzaku2 == this.tag);
                this.zzfmc = zzaku2;
            } else {
                throw zzbrl.zzanh();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzald2 = this.zzfma.zzald();
                zzex(zzald2);
                int zzall2 = this.zzfma.zzall() + zzald2;
                do {
                    list.add(Integer.valueOf(this.zzfma.zzakz()));
                } while (this.zzfma.zzall() < zzall2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zzfma.zzakz()));
                    if (!this.zzfma.zzalk()) {
                        zzaku = this.zzfma.zzaku();
                    } else {
                        return;
                    }
                } while (zzaku == this.tag);
                this.zzfmc = zzaku;
            } else {
                throw zzbrl.zzanh();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzw(List<Boolean> list) throws IOException {
        int zzaku;
        int zzaku2;
        if (list instanceof zzbps) {
            zzbps zzbps = (zzbps) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzbps.addBoolean(this.zzfma.zzala());
                    if (!this.zzfma.zzalk()) {
                        zzaku2 = this.zzfma.zzaku();
                    } else {
                        return;
                    }
                } while (zzaku2 == this.tag);
                this.zzfmc = zzaku2;
            } else if (i == 2) {
                int zzall = this.zzfma.zzall() + this.zzfma.zzald();
                do {
                    zzbps.addBoolean(this.zzfma.zzala());
                } while (this.zzfma.zzall() < zzall);
                zzey(zzall);
            } else {
                throw zzbrl.zzanh();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zzfma.zzala()));
                    if (!this.zzfma.zzalk()) {
                        zzaku = this.zzfma.zzaku();
                    } else {
                        return;
                    }
                } while (zzaku == this.tag);
                this.zzfmc = zzaku;
            } else if (i2 == 2) {
                int zzall2 = this.zzfma.zzall() + this.zzfma.zzald();
                do {
                    list.add(Boolean.valueOf(this.zzfma.zzala()));
                } while (this.zzfma.zzall() < zzall2);
                zzey(zzall2);
            } else {
                throw zzbrl.zzanh();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void readStringList(List<String> list) throws IOException {
        zzb(list, false);
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzx(List<String> list) throws IOException {
        zzb(list, true);
    }

    private final void zzb(List<String> list, boolean z) throws IOException {
        int zzaku;
        int zzaku2;
        if ((this.tag & 7) != 2) {
            throw zzbrl.zzanh();
        } else if (!(list instanceof zzbru) || z) {
            do {
                list.add(z ? zzalb() : readString());
                if (!this.zzfma.zzalk()) {
                    zzaku = this.zzfma.zzaku();
                } else {
                    return;
                }
            } while (zzaku == this.tag);
            this.zzfmc = zzaku;
        } else {
            zzbru zzbru = (zzbru) list;
            do {
                zzbru.zzap(zzalc());
                if (!this.zzfma.zzalk()) {
                    zzaku2 = this.zzfma.zzaku();
                } else {
                    return;
                }
            } while (zzaku2 == this.tag);
            this.zzfmc = zzaku2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzbtb
    public final <T> void zza(List<T> list, zzbtc<T> zzbtc, zzbqq zzbqq) throws IOException {
        int zzaku;
        int i = this.tag;
        if ((i & 7) == 2) {
            do {
                list.add(zzc(zzbtc, zzbqq));
                if (!this.zzfma.zzalk() && this.zzfmc == 0) {
                    zzaku = this.zzfma.zzaku();
                } else {
                    return;
                }
            } while (zzaku == i);
            this.zzfmc = zzaku;
            return;
        }
        throw zzbrl.zzanh();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzbtb
    public final <T> void zzb(List<T> list, zzbtc<T> zzbtc, zzbqq zzbqq) throws IOException {
        int zzaku;
        int i = this.tag;
        if ((i & 7) == 3) {
            do {
                list.add(zzd(zzbtc, zzbqq));
                if (!this.zzfma.zzalk() && this.zzfmc == 0) {
                    zzaku = this.zzfma.zzaku();
                } else {
                    return;
                }
            } while (zzaku == i);
            this.zzfmc = zzaku;
            return;
        }
        throw zzbrl.zzanh();
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzy(List<zzbpu> list) throws IOException {
        int zzaku;
        if ((this.tag & 7) == 2) {
            do {
                list.add(zzalc());
                if (!this.zzfma.zzalk()) {
                    zzaku = this.zzfma.zzaku();
                } else {
                    return;
                }
            } while (zzaku == this.tag);
            this.zzfmc = zzaku;
            return;
        }
        throw zzbrl.zzanh();
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzz(List<Integer> list) throws IOException {
        int zzaku;
        int zzaku2;
        if (list instanceof zzbre) {
            zzbre zzbre = (zzbre) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzbre.zzfo(this.zzfma.zzald());
                    if (!this.zzfma.zzalk()) {
                        zzaku2 = this.zzfma.zzaku();
                    } else {
                        return;
                    }
                } while (zzaku2 == this.tag);
                this.zzfmc = zzaku2;
            } else if (i == 2) {
                int zzall = this.zzfma.zzall() + this.zzfma.zzald();
                do {
                    zzbre.zzfo(this.zzfma.zzald());
                } while (this.zzfma.zzall() < zzall);
                zzey(zzall);
            } else {
                throw zzbrl.zzanh();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzfma.zzald()));
                    if (!this.zzfma.zzalk()) {
                        zzaku = this.zzfma.zzaku();
                    } else {
                        return;
                    }
                } while (zzaku == this.tag);
                this.zzfmc = zzaku;
            } else if (i2 == 2) {
                int zzall2 = this.zzfma.zzall() + this.zzfma.zzald();
                do {
                    list.add(Integer.valueOf(this.zzfma.zzald()));
                } while (this.zzfma.zzall() < zzall2);
                zzey(zzall2);
            } else {
                throw zzbrl.zzanh();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzaa(List<Integer> list) throws IOException {
        int zzaku;
        int zzaku2;
        if (list instanceof zzbre) {
            zzbre zzbre = (zzbre) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzbre.zzfo(this.zzfma.zzale());
                    if (!this.zzfma.zzalk()) {
                        zzaku2 = this.zzfma.zzaku();
                    } else {
                        return;
                    }
                } while (zzaku2 == this.tag);
                this.zzfmc = zzaku2;
            } else if (i == 2) {
                int zzall = this.zzfma.zzall() + this.zzfma.zzald();
                do {
                    zzbre.zzfo(this.zzfma.zzale());
                } while (this.zzfma.zzall() < zzall);
                zzey(zzall);
            } else {
                throw zzbrl.zzanh();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzfma.zzale()));
                    if (!this.zzfma.zzalk()) {
                        zzaku = this.zzfma.zzaku();
                    } else {
                        return;
                    }
                } while (zzaku == this.tag);
                this.zzfmc = zzaku;
            } else if (i2 == 2) {
                int zzall2 = this.zzfma.zzall() + this.zzfma.zzald();
                do {
                    list.add(Integer.valueOf(this.zzfma.zzale()));
                } while (this.zzfma.zzall() < zzall2);
                zzey(zzall2);
            } else {
                throw zzbrl.zzanh();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzab(List<Integer> list) throws IOException {
        int zzaku;
        int zzaku2;
        if (list instanceof zzbre) {
            zzbre zzbre = (zzbre) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzald = this.zzfma.zzald();
                zzex(zzald);
                int zzall = this.zzfma.zzall() + zzald;
                do {
                    zzbre.zzfo(this.zzfma.zzalf());
                } while (this.zzfma.zzall() < zzall);
            } else if (i == 5) {
                do {
                    zzbre.zzfo(this.zzfma.zzalf());
                    if (!this.zzfma.zzalk()) {
                        zzaku2 = this.zzfma.zzaku();
                    } else {
                        return;
                    }
                } while (zzaku2 == this.tag);
                this.zzfmc = zzaku2;
            } else {
                throw zzbrl.zzanh();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzald2 = this.zzfma.zzald();
                zzex(zzald2);
                int zzall2 = this.zzfma.zzall() + zzald2;
                do {
                    list.add(Integer.valueOf(this.zzfma.zzalf()));
                } while (this.zzfma.zzall() < zzall2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zzfma.zzalf()));
                    if (!this.zzfma.zzalk()) {
                        zzaku = this.zzfma.zzaku();
                    } else {
                        return;
                    }
                } while (zzaku == this.tag);
                this.zzfmc = zzaku;
            } else {
                throw zzbrl.zzanh();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzac(List<Long> list) throws IOException {
        int zzaku;
        int zzaku2;
        if (list instanceof zzbrz) {
            zzbrz zzbrz = (zzbrz) list;
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    int zzald = this.zzfma.zzald();
                    zzew(zzald);
                    int zzall = this.zzfma.zzall() + zzald;
                    do {
                        zzbrz.zzbj(this.zzfma.zzalg());
                    } while (this.zzfma.zzall() < zzall);
                    return;
                default:
                    throw zzbrl.zzanh();
            }
            do {
                zzbrz.zzbj(this.zzfma.zzalg());
                if (!this.zzfma.zzalk()) {
                    zzaku2 = this.zzfma.zzaku();
                } else {
                    return;
                }
            } while (zzaku2 == this.tag);
            this.zzfmc = zzaku2;
            return;
        }
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                int zzald2 = this.zzfma.zzald();
                zzew(zzald2);
                int zzall2 = this.zzfma.zzall() + zzald2;
                do {
                    list.add(Long.valueOf(this.zzfma.zzalg()));
                } while (this.zzfma.zzall() < zzall2);
                return;
            default:
                throw zzbrl.zzanh();
        }
        do {
            list.add(Long.valueOf(this.zzfma.zzalg()));
            if (!this.zzfma.zzalk()) {
                zzaku = this.zzfma.zzaku();
            } else {
                return;
            }
        } while (zzaku == this.tag);
        this.zzfmc = zzaku;
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzad(List<Integer> list) throws IOException {
        int zzaku;
        int zzaku2;
        if (list instanceof zzbre) {
            zzbre zzbre = (zzbre) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzbre.zzfo(this.zzfma.zzalh());
                    if (!this.zzfma.zzalk()) {
                        zzaku2 = this.zzfma.zzaku();
                    } else {
                        return;
                    }
                } while (zzaku2 == this.tag);
                this.zzfmc = zzaku2;
            } else if (i == 2) {
                int zzall = this.zzfma.zzall() + this.zzfma.zzald();
                do {
                    zzbre.zzfo(this.zzfma.zzalh());
                } while (this.zzfma.zzall() < zzall);
                zzey(zzall);
            } else {
                throw zzbrl.zzanh();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzfma.zzalh()));
                    if (!this.zzfma.zzalk()) {
                        zzaku = this.zzfma.zzaku();
                    } else {
                        return;
                    }
                } while (zzaku == this.tag);
                this.zzfmc = zzaku;
            } else if (i2 == 2) {
                int zzall2 = this.zzfma.zzall() + this.zzfma.zzald();
                do {
                    list.add(Integer.valueOf(this.zzfma.zzalh()));
                } while (this.zzfma.zzall() < zzall2);
                zzey(zzall2);
            } else {
                throw zzbrl.zzanh();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzae(List<Long> list) throws IOException {
        int zzaku;
        int zzaku2;
        if (list instanceof zzbrz) {
            zzbrz zzbrz = (zzbrz) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzbrz.zzbj(this.zzfma.zzali());
                    if (!this.zzfma.zzalk()) {
                        zzaku2 = this.zzfma.zzaku();
                    } else {
                        return;
                    }
                } while (zzaku2 == this.tag);
                this.zzfmc = zzaku2;
            } else if (i == 2) {
                int zzall = this.zzfma.zzall() + this.zzfma.zzald();
                do {
                    zzbrz.zzbj(this.zzfma.zzali());
                } while (this.zzfma.zzall() < zzall);
                zzey(zzall);
            } else {
                throw zzbrl.zzanh();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzfma.zzali()));
                    if (!this.zzfma.zzalk()) {
                        zzaku = this.zzfma.zzaku();
                    } else {
                        return;
                    }
                } while (zzaku == this.tag);
                this.zzfmc = zzaku;
            } else if (i2 == 2) {
                int zzall2 = this.zzfma.zzall() + this.zzfma.zzald();
                do {
                    list.add(Long.valueOf(this.zzfma.zzali()));
                } while (this.zzfma.zzall() < zzall2);
                zzey(zzall2);
            } else {
                throw zzbrl.zzanh();
            }
        }
    }

    private static void zzew(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzbrl.zzanj();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.util.Map<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzbtb
    public final <K, V> void zza(Map<K, V> map, zzbse<K, V> zzbse, zzbqq zzbqq) throws IOException {
        zzev(2);
        int zzer = this.zzfma.zzer(this.zzfma.zzald());
        Object obj = zzbse.zzfsa;
        Object obj2 = zzbse.zzfsc;
        while (true) {
            try {
                int zzals = zzals();
                if (zzals == Integer.MAX_VALUE || this.zzfma.zzalk()) {
                    map.put(obj, obj2);
                } else {
                    switch (zzals) {
                        case 1:
                            obj = zza(zzbse.zzfrz, (Class<?>) null, (zzbqq) null);
                            break;
                        case 2:
                            obj2 = zza(zzbse.zzfsb, zzbse.zzfsc.getClass(), zzbqq);
                            break;
                        default:
                            try {
                                if (zzalt()) {
                                    break;
                                } else {
                                    throw new zzbrl("Unable to parse map entry.");
                                }
                            } catch (zzbrm unused) {
                                if (zzalt()) {
                                    break;
                                } else {
                                    throw new zzbrl("Unable to parse map entry.");
                                }
                            }
                    }
                }
            } finally {
                this.zzfma.zzes(zzer);
            }
        }
        map.put(obj, obj2);
    }

    private final Object zza(zzbuj zzbuj, Class<?> cls, zzbqq zzbqq) throws IOException {
        switch (zzbqj.zzfmd[zzbuj.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzala());
            case 2:
                return zzalc();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(zzale());
            case 5:
                return Integer.valueOf(zzakz());
            case 6:
                return Long.valueOf(zzaky());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(zzakx());
            case 9:
                return Long.valueOf(zzakw());
            case 10:
                zzev(2);
                return zzc(zzbsy.zzaog().zzf(cls), zzbqq);
            case 11:
                return Integer.valueOf(zzalf());
            case 12:
                return Long.valueOf(zzalg());
            case 13:
                return Integer.valueOf(zzalh());
            case 14:
                return Long.valueOf(zzali());
            case 15:
                return zzalb();
            case 16:
                return Integer.valueOf(zzald());
            case 17:
                return Long.valueOf(zzakv());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static void zzex(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzbrl.zzanj();
        }
    }

    private final void zzey(int i) throws IOException {
        if (this.zzfma.zzall() != i) {
            throw zzbrl.zzanc();
        }
    }
}
