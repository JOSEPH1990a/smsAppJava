package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.util.Log;
import com.gsmmodem.Servers.MyHttpServer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class zznf implements zzmq {
    private final zzov zzagy;
    private final zzpk zzbaz;
    private zznj zzbbd;
    private final int[] zzbbf;
    private final long zzbbx;
    private final zzom zzbcf;
    private final zznh[] zzbcg;
    private final int zzbch;
    private IOException zzbci;
    private boolean zzbcj;
    private final int zzwg;
    private int zzyr;

    public zznf(zzpk zzpk, zznj zznj, int i, int[] iArr, zzom zzom, int i2, zzov zzov, long j, int i3, boolean z, boolean z2) {
        this.zzbaz = zzpk;
        this.zzbbd = zznj;
        this.zzbbf = iArr;
        this.zzbcf = zzom;
        this.zzwg = i2;
        this.zzagy = zzov;
        this.zzyr = i;
        this.zzbbx = j;
        this.zzbch = i3;
        long zzbb = zznj.zzbb(i);
        ArrayList<zznp> zzgf = zzgf();
        this.zzbcg = new zznh[zzom.length()];
        for (int i4 = 0; i4 < this.zzbcg.length; i4++) {
            this.zzbcg[i4] = new zznh(zzbb, zzgf.get(zzom.zzbd(i4)), z, z2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmq
    public final void zza(zznj zznj, int i) {
        try {
            this.zzbbd = zznj;
            this.zzyr = i;
            long zzbb = this.zzbbd.zzbb(this.zzyr);
            ArrayList<zznp> zzgf = zzgf();
            for (int i2 = 0; i2 < this.zzbcg.length; i2++) {
                this.zzbcg[i2].zza(zzbb, zzgf.get(this.zzbcf.zzbd(i2)));
            }
        } catch (zzkz e) {
            this.zzbci = e;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final void zzev() throws IOException {
        IOException iOException = this.zzbci;
        if (iOException == null) {
            this.zzbaz.zzev();
            return;
        }
        throw iOException;
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final void zza(zzmo zzmo, long j, zzmi zzmi) {
        long j2;
        int i;
        int i2;
        boolean z;
        zzme zzme;
        zzno zzno;
        zznf zznf = this;
        if (zznf.zzbci == null) {
            zznf.zzbcf.zzak(zzmo != null ? zzmo.zzazt - j : 0);
            zznh zznh = zznf.zzbcg[zznf.zzbcf.zzgm()];
            if (zznh.zzbat != null) {
                zznp zznp = zznh.zzbck;
                zzno zzno2 = null;
                zzno zzgh = zznh.zzbat.zzfx() == null ? zznp.zzgh() : null;
                if (zznh.zzbcl == null) {
                    zzno2 = zznp.zzgi();
                }
                if (!(zzgh == null && zzno2 == null)) {
                    zzov zzov = zznf.zzagy;
                    zzfs zzgl = zznf.zzbcf.zzgl();
                    int zzgn = zznf.zzbcf.zzgn();
                    Object zzgo = zznf.zzbcf.zzgo();
                    String str = zznh.zzbck.zzbde;
                    if (zzgh != null) {
                        zzno = zzgh.zza(zzno2, str);
                        if (zzno == null) {
                            zzno = zzgh;
                        }
                    } else {
                        zzno = zzno2;
                    }
                    zzmi.zzbaa = new zzmn(zzov, new zzoz(zzno.zzy(str), zzno.zzbdk, zzno.zzcc, zznh.zzbck.zzf()), zzgl, zzgn, zzgo, zznh.zzbat);
                    return;
                }
            }
            if (zznf.zzbbx != 0) {
                j2 = (SystemClock.elapsedRealtime() + zznf.zzbbx) * 1000;
            } else {
                j2 = System.currentTimeMillis() * 1000;
            }
            int zzgg = zznh.zzgg();
            boolean z2 = true;
            if (zzgg == 0) {
                if (zznf.zzbbd.zzbcs && zznf.zzyr >= zznf.zzbbd.zzcl() - 1) {
                    z2 = false;
                }
                zzmi.zzbab = z2;
                return;
            }
            int zzgd = zznh.zzgd();
            if (zzgg == -1) {
                long j3 = (j2 - (zznf.zzbbd.zzbcq * 1000)) - (zznf.zzbbd.zzba(zznf.zzyr).zzbdj * 1000);
                if (zznf.zzbbd.zzbcu != -9223372036854775807L) {
                    zzgd = Math.max(zzgd, zznh.zzaj(j3 - (zznf.zzbbd.zzbcu * 1000)));
                }
                i = zznh.zzaj(j3) - 1;
            } else {
                i = (zzgg + zzgd) - 1;
            }
            if (zzmo == null) {
                i2 = zzqe.zzd(zznh.zzaj(j), zzgd, i);
            } else {
                int zzfz = zzmo.zzfz();
                if (zzfz < zzgd) {
                    zznf.zzbci = new zzkz();
                    return;
                }
                i2 = zzfz;
            }
            if (i2 > i) {
                zznf = this;
            } else if (!zznf.zzbcj || i2 < i) {
                int min = Math.min(zznf.zzbch, (i - i2) + 1);
                zzov zzov2 = zznf.zzagy;
                int i3 = zznf.zzwg;
                zzfs zzgl2 = zznf.zzbcf.zzgl();
                int zzgn2 = zznf.zzbcf.zzgn();
                Object zzgo2 = zznf.zzbcf.zzgo();
                zznp zznp2 = zznh.zzbck;
                long zzay = zznh.zzay(i2);
                zzno zzax = zznh.zzax(i2);
                String str2 = zznp2.zzbde;
                if (zznh.zzbat == null) {
                    zzme = new zzmp(zzov2, new zzoz(zzax.zzy(str2), zzax.zzbdk, zzax.zzcc, zznp2.zzf()), zzgl2, zzgn2, zzgo2, zzay, zznh.zzaz(i2), i2, i3, zzgl2);
                } else {
                    int i4 = 1;
                    int i5 = 1;
                    while (i4 < min) {
                        zzno zza = zzax.zza(zznh.zzax(i2 + i4), str2);
                        if (zza == null) {
                            break;
                        }
                        i5++;
                        i4++;
                        zzax = zza;
                    }
                    zzme = new zzmm(zzov2, new zzoz(zzax.zzy(str2), zzax.zzbdk, zzax.zzcc, zznp2.zzf()), zzgl2, zzgn2, zzgo2, zzay, zznh.zzaz((i2 + i5) - 1), i2, i5, -zznp2.zzbdn, zznh.zzbat);
                }
                zzmi.zzbaa = zzme;
                return;
            }
            if (zznf.zzbbd.zzbcs) {
                z = true;
                if (zznf.zzyr >= zznf.zzbbd.zzcl() - 1) {
                    z = false;
                }
            } else {
                z = true;
            }
            zzmi.zzbab = z;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final void zza(zzme zzme) {
        zzig zzfw;
        if (zzme instanceof zzmn) {
            zznh zznh = this.zzbcg[this.zzbcf.zzi(((zzmn) zzme).zzazp)];
            if (zznh.zzbcl == null && (zzfw = zznh.zzbat.zzfw()) != null) {
                zznh.zzbcl = new zzne((zzhw) zzfw);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzml
    public final boolean zza(zzme zzme, boolean z, Exception exc) {
        zznh zznh;
        int zzgg;
        if (!z) {
            return false;
        }
        boolean z2 = true;
        if (this.zzbbd.zzbcs || !(zzme instanceof zzmo) || !(exc instanceof zzpd) || ((zzpd) exc).responseCode != 404 || (zzgg = (zznh = this.zzbcg[this.zzbcf.zzi(zzme.zzazp)]).zzgg()) == -1 || zzgg == 0 || ((zzmo) zzme).zzfz() <= (zznh.zzgd() + zzgg) - 1) {
            zzom zzom = this.zzbcf;
            int zzi = zzom.zzi(zzme.zzazp);
            if (exc instanceof zzpd) {
                int i = ((zzpd) exc).responseCode;
                if (!(i == 404 || i == 410)) {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            if (!z2) {
                return false;
            }
            boolean zzf = zzom.zzf(zzi, MyHttpServer.MINUTE_MILLIS);
            int i2 = ((zzpd) exc).responseCode;
            if (zzf) {
                String valueOf = String.valueOf(zzom.zzat(zzi));
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 77);
                sb.append("Blacklisted: duration=60000, responseCode=");
                sb.append(i2);
                sb.append(", format=");
                sb.append(valueOf);
                Log.w("ChunkedTrackBlacklist", sb.toString());
            } else {
                String valueOf2 = String.valueOf(zzom.zzat(zzi));
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 92);
                sb2.append("Blacklisting failed (cannot blacklist last enabled track): responseCode=");
                sb2.append(i2);
                sb2.append(", format=");
                sb2.append(valueOf2);
                Log.w("ChunkedTrackBlacklist", sb2.toString());
            }
            return zzf;
        }
        this.zzbcj = true;
        return true;
    }

    private final ArrayList<zznp> zzgf() {
        List<zzni> list = this.zzbbd.zzba(this.zzyr).zzbbe;
        ArrayList<zznp> arrayList = new ArrayList<>();
        for (int i : this.zzbbf) {
            arrayList.addAll(list.get(i).zzbcn);
        }
        return arrayList;
    }
}
