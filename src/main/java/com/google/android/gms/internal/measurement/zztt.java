package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class zztt implements zzwk {
    private int tag;
    private final zztq zzbui;
    private int zzbuj;
    private int zzbuk = 0;

    public static zztt zza(zztq zztq) {
        if (zztq.zzbub != null) {
            return zztq.zzbub;
        }
        return new zztt(zztq);
    }

    private zztt(zztq zztq) {
        this.zzbui = (zztq) zzuq.zza(zztq, "input");
        this.zzbui.zzbub = this;
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final int zzvh() throws IOException {
        int i = this.zzbuk;
        if (i != 0) {
            this.tag = i;
            this.zzbuk = 0;
        } else {
            this.tag = this.zzbui.zzuj();
        }
        int i2 = this.tag;
        if (i2 == 0 || i2 == this.zzbuj) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final int getTag() {
        return this.tag;
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final boolean zzvi() throws IOException {
        int i;
        if (this.zzbui.zzuz() || (i = this.tag) == this.zzbuj) {
            return false;
        }
        return this.zzbui.zzaq(i);
    }

    private final void zzav(int i) throws IOException {
        if ((this.tag & 7) != i) {
            throw zzuv.zzwu();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final double readDouble() throws IOException {
        zzav(1);
        return this.zzbui.readDouble();
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final float readFloat() throws IOException {
        zzav(5);
        return this.zzbui.readFloat();
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final long zzuk() throws IOException {
        zzav(0);
        return this.zzbui.zzuk();
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final long zzul() throws IOException {
        zzav(0);
        return this.zzbui.zzul();
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final int zzum() throws IOException {
        zzav(0);
        return this.zzbui.zzum();
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final long zzun() throws IOException {
        zzav(1);
        return this.zzbui.zzun();
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final int zzuo() throws IOException {
        zzav(5);
        return this.zzbui.zzuo();
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final boolean zzup() throws IOException {
        zzav(0);
        return this.zzbui.zzup();
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final String readString() throws IOException {
        zzav(2);
        return this.zzbui.readString();
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final String zzuq() throws IOException {
        zzav(2);
        return this.zzbui.zzuq();
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final <T> T zza(zzwl<T> zzwl, zzub zzub) throws IOException {
        zzav(2);
        return (T) zzc(zzwl, zzub);
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final <T> T zzb(zzwl<T> zzwl, zzub zzub) throws IOException {
        zzav(3);
        return (T) zzd(zzwl, zzub);
    }

    private final <T> T zzc(zzwl<T> zzwl, zzub zzub) throws IOException {
        int zzus = this.zzbui.zzus();
        if (this.zzbui.zzbty < this.zzbui.zzbtz) {
            int zzas = this.zzbui.zzas(zzus);
            T newInstance = zzwl.newInstance();
            this.zzbui.zzbty++;
            zzwl.zza(newInstance, this, zzub);
            zzwl.zzy(newInstance);
            this.zzbui.zzap(0);
            zztq zztq = this.zzbui;
            zztq.zzbty--;
            this.zzbui.zzat(zzas);
            return newInstance;
        }
        throw zzuv.zzwv();
    }

    private final <T> T zzd(zzwl<T> zzwl, zzub zzub) throws IOException {
        int i = this.zzbuj;
        this.zzbuj = ((this.tag >>> 3) << 3) | 4;
        try {
            T newInstance = zzwl.newInstance();
            zzwl.zza(newInstance, this, zzub);
            zzwl.zzy(newInstance);
            if (this.tag == this.zzbuj) {
                return newInstance;
            }
            throw zzuv.zzww();
        } finally {
            this.zzbuj = i;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final zzte zzur() throws IOException {
        zzav(2);
        return this.zzbui.zzur();
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final int zzus() throws IOException {
        zzav(0);
        return this.zzbui.zzus();
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final int zzut() throws IOException {
        zzav(0);
        return this.zzbui.zzut();
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final int zzuu() throws IOException {
        zzav(5);
        return this.zzbui.zzuu();
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final long zzuv() throws IOException {
        zzav(1);
        return this.zzbui.zzuv();
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final int zzuw() throws IOException {
        zzav(0);
        return this.zzbui.zzuw();
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final long zzux() throws IOException {
        zzav(0);
        return this.zzbui.zzux();
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final void zzi(List<Double> list) throws IOException {
        int zzuj;
        int zzuj2;
        if (list instanceof zzty) {
            zzty zzty = (zzty) list;
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    int zzus = this.zzbui.zzus();
                    zzaw(zzus);
                    int zzva = this.zzbui.zzva() + zzus;
                    do {
                        zzty.zzd(this.zzbui.readDouble());
                    } while (this.zzbui.zzva() < zzva);
                    return;
                default:
                    throw zzuv.zzwu();
            }
            do {
                zzty.zzd(this.zzbui.readDouble());
                if (!this.zzbui.zzuz()) {
                    zzuj2 = this.zzbui.zzuj();
                } else {
                    return;
                }
            } while (zzuj2 == this.tag);
            this.zzbuk = zzuj2;
            return;
        }
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                int zzus2 = this.zzbui.zzus();
                zzaw(zzus2);
                int zzva2 = this.zzbui.zzva() + zzus2;
                do {
                    list.add(Double.valueOf(this.zzbui.readDouble()));
                } while (this.zzbui.zzva() < zzva2);
                return;
            default:
                throw zzuv.zzwu();
        }
        do {
            list.add(Double.valueOf(this.zzbui.readDouble()));
            if (!this.zzbui.zzuz()) {
                zzuj = this.zzbui.zzuj();
            } else {
                return;
            }
        } while (zzuj == this.tag);
        this.zzbuk = zzuj;
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final void zzj(List<Float> list) throws IOException {
        int zzuj;
        int zzuj2;
        if (list instanceof zzul) {
            zzul zzul = (zzul) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzus = this.zzbui.zzus();
                zzax(zzus);
                int zzva = this.zzbui.zzva() + zzus;
                do {
                    zzul.zzc(this.zzbui.readFloat());
                } while (this.zzbui.zzva() < zzva);
            } else if (i == 5) {
                do {
                    zzul.zzc(this.zzbui.readFloat());
                    if (!this.zzbui.zzuz()) {
                        zzuj2 = this.zzbui.zzuj();
                    } else {
                        return;
                    }
                } while (zzuj2 == this.tag);
                this.zzbuk = zzuj2;
            } else {
                throw zzuv.zzwu();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzus2 = this.zzbui.zzus();
                zzax(zzus2);
                int zzva2 = this.zzbui.zzva() + zzus2;
                do {
                    list.add(Float.valueOf(this.zzbui.readFloat()));
                } while (this.zzbui.zzva() < zzva2);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(this.zzbui.readFloat()));
                    if (!this.zzbui.zzuz()) {
                        zzuj = this.zzbui.zzuj();
                    } else {
                        return;
                    }
                } while (zzuj == this.tag);
                this.zzbuk = zzuj;
            } else {
                throw zzuv.zzwu();
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final void zzk(List<Long> list) throws IOException {
        int zzuj;
        int zzuj2;
        if (list instanceof zzvj) {
            zzvj zzvj = (zzvj) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzvj.zzbe(this.zzbui.zzuk());
                    if (!this.zzbui.zzuz()) {
                        zzuj2 = this.zzbui.zzuj();
                    } else {
                        return;
                    }
                } while (zzuj2 == this.tag);
                this.zzbuk = zzuj2;
            } else if (i == 2) {
                int zzva = this.zzbui.zzva() + this.zzbui.zzus();
                do {
                    zzvj.zzbe(this.zzbui.zzuk());
                } while (this.zzbui.zzva() < zzva);
                zzay(zzva);
            } else {
                throw zzuv.zzwu();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzbui.zzuk()));
                    if (!this.zzbui.zzuz()) {
                        zzuj = this.zzbui.zzuj();
                    } else {
                        return;
                    }
                } while (zzuj == this.tag);
                this.zzbuk = zzuj;
            } else if (i2 == 2) {
                int zzva2 = this.zzbui.zzva() + this.zzbui.zzus();
                do {
                    list.add(Long.valueOf(this.zzbui.zzuk()));
                } while (this.zzbui.zzva() < zzva2);
                zzay(zzva2);
            } else {
                throw zzuv.zzwu();
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final void zzl(List<Long> list) throws IOException {
        int zzuj;
        int zzuj2;
        if (list instanceof zzvj) {
            zzvj zzvj = (zzvj) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzvj.zzbe(this.zzbui.zzul());
                    if (!this.zzbui.zzuz()) {
                        zzuj2 = this.zzbui.zzuj();
                    } else {
                        return;
                    }
                } while (zzuj2 == this.tag);
                this.zzbuk = zzuj2;
            } else if (i == 2) {
                int zzva = this.zzbui.zzva() + this.zzbui.zzus();
                do {
                    zzvj.zzbe(this.zzbui.zzul());
                } while (this.zzbui.zzva() < zzva);
                zzay(zzva);
            } else {
                throw zzuv.zzwu();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzbui.zzul()));
                    if (!this.zzbui.zzuz()) {
                        zzuj = this.zzbui.zzuj();
                    } else {
                        return;
                    }
                } while (zzuj == this.tag);
                this.zzbuk = zzuj;
            } else if (i2 == 2) {
                int zzva2 = this.zzbui.zzva() + this.zzbui.zzus();
                do {
                    list.add(Long.valueOf(this.zzbui.zzul()));
                } while (this.zzbui.zzva() < zzva2);
                zzay(zzva2);
            } else {
                throw zzuv.zzwu();
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final void zzm(List<Integer> list) throws IOException {
        int zzuj;
        int zzuj2;
        if (list instanceof zzup) {
            zzup zzup = (zzup) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzup.zzbo(this.zzbui.zzum());
                    if (!this.zzbui.zzuz()) {
                        zzuj2 = this.zzbui.zzuj();
                    } else {
                        return;
                    }
                } while (zzuj2 == this.tag);
                this.zzbuk = zzuj2;
            } else if (i == 2) {
                int zzva = this.zzbui.zzva() + this.zzbui.zzus();
                do {
                    zzup.zzbo(this.zzbui.zzum());
                } while (this.zzbui.zzva() < zzva);
                zzay(zzva);
            } else {
                throw zzuv.zzwu();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzbui.zzum()));
                    if (!this.zzbui.zzuz()) {
                        zzuj = this.zzbui.zzuj();
                    } else {
                        return;
                    }
                } while (zzuj == this.tag);
                this.zzbuk = zzuj;
            } else if (i2 == 2) {
                int zzva2 = this.zzbui.zzva() + this.zzbui.zzus();
                do {
                    list.add(Integer.valueOf(this.zzbui.zzum()));
                } while (this.zzbui.zzva() < zzva2);
                zzay(zzva2);
            } else {
                throw zzuv.zzwu();
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final void zzn(List<Long> list) throws IOException {
        int zzuj;
        int zzuj2;
        if (list instanceof zzvj) {
            zzvj zzvj = (zzvj) list;
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    int zzus = this.zzbui.zzus();
                    zzaw(zzus);
                    int zzva = this.zzbui.zzva() + zzus;
                    do {
                        zzvj.zzbe(this.zzbui.zzun());
                    } while (this.zzbui.zzva() < zzva);
                    return;
                default:
                    throw zzuv.zzwu();
            }
            do {
                zzvj.zzbe(this.zzbui.zzun());
                if (!this.zzbui.zzuz()) {
                    zzuj2 = this.zzbui.zzuj();
                } else {
                    return;
                }
            } while (zzuj2 == this.tag);
            this.zzbuk = zzuj2;
            return;
        }
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                int zzus2 = this.zzbui.zzus();
                zzaw(zzus2);
                int zzva2 = this.zzbui.zzva() + zzus2;
                do {
                    list.add(Long.valueOf(this.zzbui.zzun()));
                } while (this.zzbui.zzva() < zzva2);
                return;
            default:
                throw zzuv.zzwu();
        }
        do {
            list.add(Long.valueOf(this.zzbui.zzun()));
            if (!this.zzbui.zzuz()) {
                zzuj = this.zzbui.zzuj();
            } else {
                return;
            }
        } while (zzuj == this.tag);
        this.zzbuk = zzuj;
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final void zzo(List<Integer> list) throws IOException {
        int zzuj;
        int zzuj2;
        if (list instanceof zzup) {
            zzup zzup = (zzup) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzus = this.zzbui.zzus();
                zzax(zzus);
                int zzva = this.zzbui.zzva() + zzus;
                do {
                    zzup.zzbo(this.zzbui.zzuo());
                } while (this.zzbui.zzva() < zzva);
            } else if (i == 5) {
                do {
                    zzup.zzbo(this.zzbui.zzuo());
                    if (!this.zzbui.zzuz()) {
                        zzuj2 = this.zzbui.zzuj();
                    } else {
                        return;
                    }
                } while (zzuj2 == this.tag);
                this.zzbuk = zzuj2;
            } else {
                throw zzuv.zzwu();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzus2 = this.zzbui.zzus();
                zzax(zzus2);
                int zzva2 = this.zzbui.zzva() + zzus2;
                do {
                    list.add(Integer.valueOf(this.zzbui.zzuo()));
                } while (this.zzbui.zzva() < zzva2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zzbui.zzuo()));
                    if (!this.zzbui.zzuz()) {
                        zzuj = this.zzbui.zzuj();
                    } else {
                        return;
                    }
                } while (zzuj == this.tag);
                this.zzbuk = zzuj;
            } else {
                throw zzuv.zzwu();
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final void zzp(List<Boolean> list) throws IOException {
        int zzuj;
        int zzuj2;
        if (list instanceof zztc) {
            zztc zztc = (zztc) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zztc.addBoolean(this.zzbui.zzup());
                    if (!this.zzbui.zzuz()) {
                        zzuj2 = this.zzbui.zzuj();
                    } else {
                        return;
                    }
                } while (zzuj2 == this.tag);
                this.zzbuk = zzuj2;
            } else if (i == 2) {
                int zzva = this.zzbui.zzva() + this.zzbui.zzus();
                do {
                    zztc.addBoolean(this.zzbui.zzup());
                } while (this.zzbui.zzva() < zzva);
                zzay(zzva);
            } else {
                throw zzuv.zzwu();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zzbui.zzup()));
                    if (!this.zzbui.zzuz()) {
                        zzuj = this.zzbui.zzuj();
                    } else {
                        return;
                    }
                } while (zzuj == this.tag);
                this.zzbuk = zzuj;
            } else if (i2 == 2) {
                int zzva2 = this.zzbui.zzva() + this.zzbui.zzus();
                do {
                    list.add(Boolean.valueOf(this.zzbui.zzup()));
                } while (this.zzbui.zzva() < zzva2);
                zzay(zzva2);
            } else {
                throw zzuv.zzwu();
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final void readStringList(List<String> list) throws IOException {
        zza(list, false);
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final void zzq(List<String> list) throws IOException {
        zza(list, true);
    }

    private final void zza(List<String> list, boolean z) throws IOException {
        int zzuj;
        int zzuj2;
        if ((this.tag & 7) != 2) {
            throw zzuv.zzwu();
        } else if (!(list instanceof zzve) || z) {
            do {
                list.add(z ? zzuq() : readString());
                if (!this.zzbui.zzuz()) {
                    zzuj = this.zzbui.zzuj();
                } else {
                    return;
                }
            } while (zzuj == this.tag);
            this.zzbuk = zzuj;
        } else {
            zzve zzve = (zzve) list;
            do {
                zzve.zzc(zzur());
                if (!this.zzbui.zzuz()) {
                    zzuj2 = this.zzbui.zzuj();
                } else {
                    return;
                }
            } while (zzuj2 == this.tag);
            this.zzbuk = zzuj2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzwk
    public final <T> void zza(List<T> list, zzwl<T> zzwl, zzub zzub) throws IOException {
        int zzuj;
        int i = this.tag;
        if ((i & 7) == 2) {
            do {
                list.add(zzc(zzwl, zzub));
                if (!this.zzbui.zzuz() && this.zzbuk == 0) {
                    zzuj = this.zzbui.zzuj();
                } else {
                    return;
                }
            } while (zzuj == i);
            this.zzbuk = zzuj;
            return;
        }
        throw zzuv.zzwu();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzwk
    public final <T> void zzb(List<T> list, zzwl<T> zzwl, zzub zzub) throws IOException {
        int zzuj;
        int i = this.tag;
        if ((i & 7) == 3) {
            do {
                list.add(zzd(zzwl, zzub));
                if (!this.zzbui.zzuz() && this.zzbuk == 0) {
                    zzuj = this.zzbui.zzuj();
                } else {
                    return;
                }
            } while (zzuj == i);
            this.zzbuk = zzuj;
            return;
        }
        throw zzuv.zzwu();
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final void zzr(List<zzte> list) throws IOException {
        int zzuj;
        if ((this.tag & 7) == 2) {
            do {
                list.add(zzur());
                if (!this.zzbui.zzuz()) {
                    zzuj = this.zzbui.zzuj();
                } else {
                    return;
                }
            } while (zzuj == this.tag);
            this.zzbuk = zzuj;
            return;
        }
        throw zzuv.zzwu();
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final void zzs(List<Integer> list) throws IOException {
        int zzuj;
        int zzuj2;
        if (list instanceof zzup) {
            zzup zzup = (zzup) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzup.zzbo(this.zzbui.zzus());
                    if (!this.zzbui.zzuz()) {
                        zzuj2 = this.zzbui.zzuj();
                    } else {
                        return;
                    }
                } while (zzuj2 == this.tag);
                this.zzbuk = zzuj2;
            } else if (i == 2) {
                int zzva = this.zzbui.zzva() + this.zzbui.zzus();
                do {
                    zzup.zzbo(this.zzbui.zzus());
                } while (this.zzbui.zzva() < zzva);
                zzay(zzva);
            } else {
                throw zzuv.zzwu();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzbui.zzus()));
                    if (!this.zzbui.zzuz()) {
                        zzuj = this.zzbui.zzuj();
                    } else {
                        return;
                    }
                } while (zzuj == this.tag);
                this.zzbuk = zzuj;
            } else if (i2 == 2) {
                int zzva2 = this.zzbui.zzva() + this.zzbui.zzus();
                do {
                    list.add(Integer.valueOf(this.zzbui.zzus()));
                } while (this.zzbui.zzva() < zzva2);
                zzay(zzva2);
            } else {
                throw zzuv.zzwu();
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final void zzt(List<Integer> list) throws IOException {
        int zzuj;
        int zzuj2;
        if (list instanceof zzup) {
            zzup zzup = (zzup) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzup.zzbo(this.zzbui.zzut());
                    if (!this.zzbui.zzuz()) {
                        zzuj2 = this.zzbui.zzuj();
                    } else {
                        return;
                    }
                } while (zzuj2 == this.tag);
                this.zzbuk = zzuj2;
            } else if (i == 2) {
                int zzva = this.zzbui.zzva() + this.zzbui.zzus();
                do {
                    zzup.zzbo(this.zzbui.zzut());
                } while (this.zzbui.zzva() < zzva);
                zzay(zzva);
            } else {
                throw zzuv.zzwu();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzbui.zzut()));
                    if (!this.zzbui.zzuz()) {
                        zzuj = this.zzbui.zzuj();
                    } else {
                        return;
                    }
                } while (zzuj == this.tag);
                this.zzbuk = zzuj;
            } else if (i2 == 2) {
                int zzva2 = this.zzbui.zzva() + this.zzbui.zzus();
                do {
                    list.add(Integer.valueOf(this.zzbui.zzut()));
                } while (this.zzbui.zzva() < zzva2);
                zzay(zzva2);
            } else {
                throw zzuv.zzwu();
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final void zzu(List<Integer> list) throws IOException {
        int zzuj;
        int zzuj2;
        if (list instanceof zzup) {
            zzup zzup = (zzup) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzus = this.zzbui.zzus();
                zzax(zzus);
                int zzva = this.zzbui.zzva() + zzus;
                do {
                    zzup.zzbo(this.zzbui.zzuu());
                } while (this.zzbui.zzva() < zzva);
            } else if (i == 5) {
                do {
                    zzup.zzbo(this.zzbui.zzuu());
                    if (!this.zzbui.zzuz()) {
                        zzuj2 = this.zzbui.zzuj();
                    } else {
                        return;
                    }
                } while (zzuj2 == this.tag);
                this.zzbuk = zzuj2;
            } else {
                throw zzuv.zzwu();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzus2 = this.zzbui.zzus();
                zzax(zzus2);
                int zzva2 = this.zzbui.zzva() + zzus2;
                do {
                    list.add(Integer.valueOf(this.zzbui.zzuu()));
                } while (this.zzbui.zzva() < zzva2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zzbui.zzuu()));
                    if (!this.zzbui.zzuz()) {
                        zzuj = this.zzbui.zzuj();
                    } else {
                        return;
                    }
                } while (zzuj == this.tag);
                this.zzbuk = zzuj;
            } else {
                throw zzuv.zzwu();
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final void zzv(List<Long> list) throws IOException {
        int zzuj;
        int zzuj2;
        if (list instanceof zzvj) {
            zzvj zzvj = (zzvj) list;
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    int zzus = this.zzbui.zzus();
                    zzaw(zzus);
                    int zzva = this.zzbui.zzva() + zzus;
                    do {
                        zzvj.zzbe(this.zzbui.zzuv());
                    } while (this.zzbui.zzva() < zzva);
                    return;
                default:
                    throw zzuv.zzwu();
            }
            do {
                zzvj.zzbe(this.zzbui.zzuv());
                if (!this.zzbui.zzuz()) {
                    zzuj2 = this.zzbui.zzuj();
                } else {
                    return;
                }
            } while (zzuj2 == this.tag);
            this.zzbuk = zzuj2;
            return;
        }
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                int zzus2 = this.zzbui.zzus();
                zzaw(zzus2);
                int zzva2 = this.zzbui.zzva() + zzus2;
                do {
                    list.add(Long.valueOf(this.zzbui.zzuv()));
                } while (this.zzbui.zzva() < zzva2);
                return;
            default:
                throw zzuv.zzwu();
        }
        do {
            list.add(Long.valueOf(this.zzbui.zzuv()));
            if (!this.zzbui.zzuz()) {
                zzuj = this.zzbui.zzuj();
            } else {
                return;
            }
        } while (zzuj == this.tag);
        this.zzbuk = zzuj;
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final void zzw(List<Integer> list) throws IOException {
        int zzuj;
        int zzuj2;
        if (list instanceof zzup) {
            zzup zzup = (zzup) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzup.zzbo(this.zzbui.zzuw());
                    if (!this.zzbui.zzuz()) {
                        zzuj2 = this.zzbui.zzuj();
                    } else {
                        return;
                    }
                } while (zzuj2 == this.tag);
                this.zzbuk = zzuj2;
            } else if (i == 2) {
                int zzva = this.zzbui.zzva() + this.zzbui.zzus();
                do {
                    zzup.zzbo(this.zzbui.zzuw());
                } while (this.zzbui.zzva() < zzva);
                zzay(zzva);
            } else {
                throw zzuv.zzwu();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzbui.zzuw()));
                    if (!this.zzbui.zzuz()) {
                        zzuj = this.zzbui.zzuj();
                    } else {
                        return;
                    }
                } while (zzuj == this.tag);
                this.zzbuk = zzuj;
            } else if (i2 == 2) {
                int zzva2 = this.zzbui.zzva() + this.zzbui.zzus();
                do {
                    list.add(Integer.valueOf(this.zzbui.zzuw()));
                } while (this.zzbui.zzva() < zzva2);
                zzay(zzva2);
            } else {
                throw zzuv.zzwu();
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzwk
    public final void zzx(List<Long> list) throws IOException {
        int zzuj;
        int zzuj2;
        if (list instanceof zzvj) {
            zzvj zzvj = (zzvj) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzvj.zzbe(this.zzbui.zzux());
                    if (!this.zzbui.zzuz()) {
                        zzuj2 = this.zzbui.zzuj();
                    } else {
                        return;
                    }
                } while (zzuj2 == this.tag);
                this.zzbuk = zzuj2;
            } else if (i == 2) {
                int zzva = this.zzbui.zzva() + this.zzbui.zzus();
                do {
                    zzvj.zzbe(this.zzbui.zzux());
                } while (this.zzbui.zzva() < zzva);
                zzay(zzva);
            } else {
                throw zzuv.zzwu();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzbui.zzux()));
                    if (!this.zzbui.zzuz()) {
                        zzuj = this.zzbui.zzuj();
                    } else {
                        return;
                    }
                } while (zzuj == this.tag);
                this.zzbuk = zzuj;
            } else if (i2 == 2) {
                int zzva2 = this.zzbui.zzva() + this.zzbui.zzus();
                do {
                    list.add(Long.valueOf(this.zzbui.zzux()));
                } while (this.zzbui.zzva() < zzva2);
                zzay(zzva2);
            } else {
                throw zzuv.zzwu();
            }
        }
    }

    private static void zzaw(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzuv.zzww();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.util.Map<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzwk
    public final <K, V> void zza(Map<K, V> map, zzvo<K, V> zzvo, zzub zzub) throws IOException {
        zzav(2);
        int zzas = this.zzbui.zzas(this.zzbui.zzus());
        Object obj = zzvo.zzcaj;
        Object obj2 = zzvo.zzbrp;
        while (true) {
            try {
                int zzvh = zzvh();
                if (zzvh == Integer.MAX_VALUE || this.zzbui.zzuz()) {
                    map.put(obj, obj2);
                } else {
                    switch (zzvh) {
                        case 1:
                            obj = zza(zzvo.zzcai, (Class<?>) null, (zzub) null);
                            break;
                        case 2:
                            obj2 = zza(zzvo.zzcak, zzvo.zzbrp.getClass(), zzub);
                            break;
                        default:
                            try {
                                if (zzvi()) {
                                    break;
                                } else {
                                    throw new zzuv("Unable to parse map entry.");
                                }
                            } catch (zzuw unused) {
                                if (zzvi()) {
                                    break;
                                } else {
                                    throw new zzuv("Unable to parse map entry.");
                                }
                            }
                    }
                }
            } finally {
                this.zzbui.zzat(zzas);
            }
        }
        map.put(obj, obj2);
    }

    private final Object zza(zzxs zzxs, Class<?> cls, zzub zzub) throws IOException {
        switch (zztu.zzbul[zzxs.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzup());
            case 2:
                return zzur();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(zzut());
            case 5:
                return Integer.valueOf(zzuo());
            case 6:
                return Long.valueOf(zzun());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(zzum());
            case 9:
                return Long.valueOf(zzul());
            case 10:
                zzav(2);
                return zzc(zzwh.zzxt().zzi(cls), zzub);
            case 11:
                return Integer.valueOf(zzuu());
            case 12:
                return Long.valueOf(zzuv());
            case 13:
                return Integer.valueOf(zzuw());
            case 14:
                return Long.valueOf(zzux());
            case 15:
                return zzuq();
            case 16:
                return Integer.valueOf(zzus());
            case 17:
                return Long.valueOf(zzuk());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static void zzax(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzuv.zzww();
        }
    }

    private final void zzay(int i) throws IOException {
        if (this.zzbui.zzva() != i) {
            throw zzuv.zzwq();
        }
    }
}
