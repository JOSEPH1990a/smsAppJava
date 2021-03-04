package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

final class zzlh implements zzpi {
    private final Uri uri;
    private final zzov zzagy;
    private final zzli zzawu;
    private final zzpq zzawv;
    private final /* synthetic */ zzlc zzaxn;
    private final zzif zzaxp = new zzif();
    private volatile boolean zzaxq;
    private boolean zzaxr = true;
    private long zzaxs;
    private long zzcc = -1;

    public zzlh(zzlc zzlc, Uri uri2, zzov zzov, zzli zzli, zzpq zzpq) {
        this.zzaxn = zzlc;
        this.uri = (Uri) zzpo.checkNotNull(uri2);
        this.zzagy = (zzov) zzpo.checkNotNull(zzov);
        this.zzawu = (zzli) zzpo.checkNotNull(zzli);
        this.zzawv = zzpq;
    }

    public final void zze(long j, long j2) {
        this.zzaxp.zzaha = j;
        this.zzaxs = j2;
        this.zzaxr = true;
    }

    @Override // com.google.android.gms.internal.ads.zzpi
    public final void cancelLoad() {
        this.zzaxq = true;
    }

    @Override // com.google.android.gms.internal.ads.zzpi
    public final boolean zzfe() {
        return this.zzaxq;
    }

    @Override // com.google.android.gms.internal.ads.zzpi
    public final void zzff() throws IOException, InterruptedException {
        zzhx zzhx;
        Throwable th;
        int i = 0;
        while (i == 0 && !this.zzaxq) {
            try {
                long j = this.zzaxp.zzaha;
                this.zzcc = this.zzagy.zza(new zzoz(this.uri, j, -1, zzlc.zzf(this.zzaxn)));
                if (this.zzcc != -1) {
                    this.zzcc += j;
                }
                zzhx = new zzhx(this.zzagy, j, this.zzcc);
                try {
                    zzhz zza = this.zzawu.zza(zzhx, this.zzagy.getUri());
                    if (this.zzaxr) {
                        zza.zzc(j, this.zzaxs);
                        this.zzaxr = false;
                    }
                    while (i == 0 && !this.zzaxq) {
                        this.zzawv.block();
                        i = zza.zza(zzhx, this.zzaxp);
                        if (zzhx.getPosition() > zzlc.zzg(this.zzaxn) + j) {
                            j = zzhx.getPosition();
                            this.zzawv.zzha();
                            zzlc.zzi(this.zzaxn).post(zzlc.zzh(this.zzaxn));
                        }
                    }
                    if (i == 1) {
                        i = 0;
                    } else {
                        this.zzaxp.zzaha = zzhx.getPosition();
                    }
                    zzqe.zza(this.zzagy);
                } catch (Throwable th2) {
                    th = th2;
                    if (!(i == 1 || zzhx == null)) {
                        this.zzaxp.zzaha = zzhx.getPosition();
                    }
                    zzqe.zza(this.zzagy);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                zzhx = null;
                this.zzaxp.zzaha = zzhx.getPosition();
                zzqe.zza(this.zzagy);
                throw th;
            }
        }
    }
}
