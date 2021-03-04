package com.google.android.gms.internal.ads;

public class zzbrs {
    private static final zzbqq zzfkz = zzbqq.zzamd();
    private zzbpu zzfrl;
    private volatile zzbsl zzfrm;
    private volatile zzbpu zzfrn;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbrs)) {
            return false;
        }
        zzbrs zzbrs = (zzbrs) obj;
        zzbsl zzbsl = this.zzfrm;
        zzbsl zzbsl2 = zzbrs.zzfrm;
        if (zzbsl == null && zzbsl2 == null) {
            return zzakf().equals(zzbrs.zzakf());
        }
        if (zzbsl != null && zzbsl2 != null) {
            return zzbsl.equals(zzbsl2);
        }
        if (zzbsl != null) {
            return zzbsl.equals(zzbrs.zzk(zzbsl.zzamv()));
        }
        return zzk(zzbsl2.zzamv()).equals(zzbsl2);
    }

    private final zzbsl zzk(zzbsl zzbsl) {
        if (this.zzfrm == null) {
            synchronized (this) {
                if (this.zzfrm == null) {
                    try {
                        this.zzfrm = zzbsl;
                        this.zzfrn = zzbpu.zzfli;
                    } catch (zzbrl unused) {
                        this.zzfrm = zzbsl;
                        this.zzfrn = zzbpu.zzfli;
                    }
                }
            }
        }
        return this.zzfrm;
    }

    public final zzbsl zzl(zzbsl zzbsl) {
        zzbsl zzbsl2 = this.zzfrm;
        this.zzfrl = null;
        this.zzfrn = null;
        this.zzfrm = zzbsl;
        return zzbsl2;
    }

    public final int zzamj() {
        if (this.zzfrn != null) {
            return this.zzfrn.size();
        }
        if (this.zzfrm != null) {
            return this.zzfrm.zzamj();
        }
        return 0;
    }

    public final zzbpu zzakf() {
        if (this.zzfrn != null) {
            return this.zzfrn;
        }
        synchronized (this) {
            if (this.zzfrn != null) {
                return this.zzfrn;
            }
            if (this.zzfrm == null) {
                this.zzfrn = zzbpu.zzfli;
            } else {
                this.zzfrn = this.zzfrm.zzakf();
            }
            return this.zzfrn;
        }
    }
}
