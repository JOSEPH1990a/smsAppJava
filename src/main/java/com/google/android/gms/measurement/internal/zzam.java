package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzam extends zzf {
    private String zzafi;
    private String zzafp;
    private long zzafs;
    private String zzafv;
    private int zzagp;
    private int zzalk;
    private long zzall;
    private String zztr;
    private String zzts;
    private String zztt;

    zzam(zzbw zzbw) {
        super(zzbw);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.measurement.internal.zzf
    public final boolean zzgy() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x019b A[Catch:{ IllegalStateException -> 0x01cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x019e A[Catch:{ IllegalStateException -> 0x01cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01a7 A[Catch:{ IllegalStateException -> 0x01cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01ba A[Catch:{ IllegalStateException -> 0x01cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01ef  */
    @Override // com.google.android.gms.measurement.internal.zzf
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzgz() {
        /*
        // Method dump skipped, instructions count: 498
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.zzgz():void");
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final zzk zzbs(String str) {
        String str2;
        zzaf();
        zzgg();
        String zzal = zzal();
        String gmpAppId = getGmpAppId();
        zzcl();
        String str3 = this.zzts;
        long zzjd = (long) zzjd();
        zzcl();
        String str4 = this.zzafp;
        long zzhh = zzgv().zzhh();
        zzcl();
        zzaf();
        if (this.zzall == 0) {
            this.zzall = this.zzada.zzgr().zzd(getContext(), getContext().getPackageName());
        }
        long j = this.zzall;
        boolean isEnabled = this.zzada.isEnabled();
        boolean z = !zzgu().zzanq;
        zzaf();
        zzgg();
        if (!zzgv().zzaz(this.zztt) || this.zzada.isEnabled()) {
            str2 = zzjc();
        } else {
            str2 = null;
        }
        zzcl();
        long j2 = this.zzafs;
        long zzkt = this.zzada.zzkt();
        int zzje = zzje();
        zzq zzgv = zzgv();
        zzgv.zzgg();
        Boolean zzar = zzgv.zzar("google_analytics_adid_collection_enabled");
        boolean booleanValue = Boolean.valueOf(zzar == null || zzar.booleanValue()).booleanValue();
        zzq zzgv2 = zzgv();
        zzgv2.zzgg();
        Boolean zzar2 = zzgv2.zzar("google_analytics_ssaid_collection_enabled");
        return new zzk(zzal, gmpAppId, str3, zzjd, str4, zzhh, j, str, isEnabled, z, str2, j2, zzkt, zzje, booleanValue, Boolean.valueOf(zzar2 == null || zzar2.booleanValue()).booleanValue(), zzgu().zzkb(), zzhb());
    }

    @WorkerThread
    @VisibleForTesting
    private final String zzjc() {
        try {
            Class<?> loadClass = getContext().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
            if (loadClass == null) {
                return null;
            }
            try {
                Object invoke = loadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, getContext());
                if (invoke == null) {
                    return null;
                }
                try {
                    return (String) loadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(invoke, new Object[0]);
                } catch (Exception unused) {
                    zzgt().zzjl().zzby("Failed to retrieve Firebase Instance Id");
                    return null;
                }
            } catch (Exception unused2) {
                zzgt().zzjk().zzby("Failed to obtain Firebase Analytics instance");
                return null;
            }
        } catch (ClassNotFoundException unused3) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final String zzal() {
        zzcl();
        return this.zztt;
    }

    /* access modifiers changed from: package-private */
    public final String getGmpAppId() {
        zzcl();
        return this.zzafi;
    }

    /* access modifiers changed from: package-private */
    public final String zzhb() {
        zzcl();
        return this.zzafv;
    }

    /* access modifiers changed from: package-private */
    public final int zzjd() {
        zzcl();
        return this.zzalk;
    }

    /* access modifiers changed from: package-private */
    public final int zzje() {
        zzcl();
        return this.zzagp;
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
