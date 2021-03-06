package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzdl;

public final class zzfd extends zzf {
    private Handler handler;
    @VisibleForTesting
    private long zzasy = zzbx().elapsedRealtime();
    @VisibleForTesting
    private long zzasz = this.zzasy;
    private final zzy zzata = new zzfe(this, this.zzada);
    private final zzy zzatb = new zzff(this, this.zzada);
    private final zzy zzatc = new zzfg(this, this.zzada);

    zzfd(zzbw zzbw) {
        super(zzbw);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.measurement.internal.zzf
    public final boolean zzgy() {
        return false;
    }

    private final void zzlm() {
        synchronized (this) {
            if (this.handler == null) {
                this.handler = new zzdl(Looper.getMainLooper());
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzln() {
        zzaf();
        this.zzata.cancel();
        this.zzatb.cancel();
        this.zzasy = 0;
        this.zzasz = this.zzasy;
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzai(long j) {
        zzaf();
        zzlm();
        zzgt().zzjo().zzg("Activity resumed, time", Long.valueOf(j));
        this.zzasy = j;
        this.zzasz = this.zzasy;
        if (zzgv().zzbi(zzgk().zzal())) {
            zzaj(zzbx().currentTimeMillis());
            return;
        }
        this.zzata.cancel();
        this.zzatb.cancel();
        if (zzgv().zzbg(zzgk().zzal()) || zzgv().zzbh(zzgk().zzal())) {
            this.zzatc.cancel();
        }
        if (zzgu().zzaf(zzbx().currentTimeMillis())) {
            zzgu().zzann.set(true);
            zzgu().zzanp.set(0);
        }
        if (zzgu().zzann.get()) {
            this.zzata.zzh(Math.max(0L, zzgu().zzanl.get() - zzgu().zzanp.get()));
        } else {
            this.zzatb.zzh(Math.max(0L, 3600000 - zzgu().zzanp.get()));
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzaj(long j) {
        zzaf();
        zzlm();
        zza(j, false);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(long j, boolean z) {
        zzaf();
        zzlm();
        this.zzata.cancel();
        this.zzatb.cancel();
        if (zzgv().zzbg(zzgk().zzal()) || zzgv().zzbh(zzgk().zzal())) {
            this.zzatc.cancel();
        }
        if (zzgu().zzaf(j)) {
            zzgu().zzann.set(true);
            zzgu().zzanp.set(0);
        }
        if (zzgu().zzann.get()) {
            zzal(j);
            return;
        }
        this.zzatb.zzh(Math.max(0L, 3600000 - zzgu().zzanp.get()));
        if (z && zzgv().zzbj(zzgk().zzal())) {
            zzgu().zzano.set(j);
            if (zzgv().zzbg(zzgk().zzal()) || zzgv().zzbh(zzgk().zzal())) {
                this.zzatc.cancel();
                this.zzatc.zzh(zzgu().zzanm.get());
            }
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzak(long j) {
        zzaf();
        zzlm();
        this.zzata.cancel();
        this.zzatb.cancel();
        if (zzgv().zzbg(zzgk().zzal()) || zzgv().zzbh(zzgk().zzal())) {
            this.zzatc.cancel();
            this.zzatc.zzh(zzgu().zzanm.get());
        }
        zzgt().zzjo().zzg("Activity paused, time", Long.valueOf(j));
        if (this.zzasy != 0) {
            zzgu().zzanp.set(zzgu().zzanp.get() + (j - this.zzasy));
        }
    }

    @WorkerThread
    private final void zzal(long j) {
        zzaf();
        zzgt().zzjo().zzg("Session started, time", Long.valueOf(zzbx().elapsedRealtime()));
        long j2 = null;
        Long valueOf = zzgv().zzbg(zzgk().zzal()) ? Long.valueOf(j / 1000) : null;
        if (zzgv().zzbh(zzgk().zzal())) {
            j2 = -1L;
        }
        zzgj().zza("auto", "_sid", valueOf, j);
        zzgj().zza("auto", "_sno", j2, j);
        zzgu().zzann.set(false);
        Bundle bundle = new Bundle();
        if (zzgv().zzbg(zzgk().zzal())) {
            bundle.putLong("_sid", valueOf.longValue());
        }
        zzgj().zza("auto", "_s", j, bundle);
        zzgu().zzano.set(j);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    @VisibleForTesting
    public final void zzlo() {
        zzaf();
        zzal(zzbx().currentTimeMillis());
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    public final long zzlp() {
        long elapsedRealtime = zzbx().elapsedRealtime();
        long j = elapsedRealtime - this.zzasz;
        this.zzasz = elapsedRealtime;
        return j;
    }

    @WorkerThread
    public final boolean zza(boolean z, boolean z2) {
        zzaf();
        zzcl();
        long elapsedRealtime = zzbx().elapsedRealtime();
        zzgu().zzano.set(zzbx().currentTimeMillis());
        long j = elapsedRealtime - this.zzasy;
        if (z || j >= 1000) {
            zzgu().zzanp.set(j);
            zzgt().zzjo().zzg("Recording user engagement, ms", Long.valueOf(j));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j);
            zzdy.zza(zzgm().zzle(), bundle, true);
            if (zzgv().zzbk(zzgk().zzal())) {
                if (zzgv().zze(zzgk().zzal(), zzai.zzala)) {
                    if (!z2) {
                        zzlp();
                    }
                } else if (z2) {
                    bundle.putLong("_fr", 1);
                } else {
                    zzlp();
                }
            }
            if (!zzgv().zze(zzgk().zzal(), zzai.zzala) || !z2) {
                zzgj().logEvent("auto", "_e", bundle);
            }
            this.zzasy = elapsedRealtime;
            this.zzatb.cancel();
            this.zzatb.zzh(Math.max(0L, 3600000 - zzgu().zzanp.get()));
            return true;
        }
        zzgt().zzjo().zzg("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j));
        return false;
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzlq() {
        zzaf();
        zza(false, false);
        zzgi().zzm(zzbx().elapsedRealtime());
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ void zzgf() {
        super.zzgf();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ void zzgg() {
        super.zzgg();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ void zzgh() {
        super.zzgh();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ void zzaf() {
        super.zzaf();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zza zzgi() {
        return super.zzgi();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzda zzgj() {
        return super.zzgj();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzam zzgk() {
        return super.zzgk();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzeb zzgl() {
        return super.zzgl();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzdy zzgm() {
        return super.zzgm();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzao zzgn() {
        return super.zzgn();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzfd zzgo() {
        return super.zzgo();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzaa zzgp() {
        return super.zzgp();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ Clock zzbx() {
        return super.zzbx();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzaq zzgq() {
        return super.zzgq();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzfy zzgr() {
        return super.zzgr();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ zzbr zzgs() {
        return super.zzgs();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ zzas zzgt() {
        return super.zzgt();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzbd zzgu() {
        return super.zzgu();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzq zzgv() {
        return super.zzgv();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ zzn zzgw() {
        return super.zzgw();
    }
}
