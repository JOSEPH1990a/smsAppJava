package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzfi;
import com.google.android.gms.internal.measurement.zzfj;
import com.google.android.gms.internal.measurement.zzfk;
import com.google.android.gms.internal.measurement.zzfm;
import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfp;
import com.google.android.gms.internal.measurement.zzfq;
import com.google.android.gms.internal.measurement.zzxz;
import com.google.android.gms.internal.measurement.zzya;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Map;

public final class zzbq extends zzfn implements zzs {
    @VisibleForTesting
    private static int zzaoi = 65535;
    @VisibleForTesting
    private static int zzaoj = 2;
    private final Map<String, Map<String, String>> zzaok = new ArrayMap();
    private final Map<String, Map<String, Boolean>> zzaol = new ArrayMap();
    private final Map<String, Map<String, Boolean>> zzaom = new ArrayMap();
    private final Map<String, zzfp> zzaon = new ArrayMap();
    private final Map<String, Map<String, Integer>> zzaoo = new ArrayMap();
    private final Map<String, String> zzaop = new ArrayMap();

    zzbq(zzfo zzfo) {
        super(zzfo);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.measurement.internal.zzfn
    public final boolean zzgy() {
        return false;
    }

    @WorkerThread
    private final void zzcf(String str) {
        zzcl();
        zzaf();
        Preconditions.checkNotEmpty(str);
        if (this.zzaon.get(str) == null) {
            byte[] zzbo = zzjt().zzbo(str);
            if (zzbo == null) {
                this.zzaok.put(str, null);
                this.zzaol.put(str, null);
                this.zzaom.put(str, null);
                this.zzaon.put(str, null);
                this.zzaop.put(str, null);
                this.zzaoo.put(str, null);
                return;
            }
            zzfp zza = zza(str, zzbo);
            this.zzaok.put(str, zza(zza));
            zza(str, zza);
            this.zzaon.put(str, zza);
            this.zzaop.put(str, null);
        }
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final zzfp zzcg(String str) {
        zzcl();
        zzaf();
        Preconditions.checkNotEmpty(str);
        zzcf(str);
        return this.zzaon.get(str);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final String zzch(String str) {
        zzaf();
        return this.zzaop.get(str);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzci(String str) {
        zzaf();
        this.zzaop.put(str, null);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzcj(String str) {
        zzaf();
        this.zzaon.remove(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzs
    @WorkerThread
    public final String zzf(String str, String str2) {
        zzaf();
        zzcf(str);
        Map<String, String> map = this.zzaok.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
    }

    private static Map<String, String> zza(zzfp zzfp) {
        ArrayMap arrayMap = new ArrayMap();
        if (!(zzfp == null || zzfp.zzawm == null)) {
            zzfq[] zzfqArr = zzfp.zzawm;
            for (zzfq zzfq : zzfqArr) {
                if (zzfq != null) {
                    arrayMap.put(zzfq.zzoj, zzfq.value);
                }
            }
        }
        return arrayMap;
    }

    private final void zza(String str, zzfp zzfp) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        if (!(zzfp == null || zzfp.zzawn == null)) {
            zzfo[] zzfoArr = zzfp.zzawn;
            for (zzfo zzfo : zzfoArr) {
                if (TextUtils.isEmpty(zzfo.name)) {
                    zzgt().zzjj().zzby("EventConfig contained null event name");
                } else {
                    String zzco = zzcu.zzco(zzfo.name);
                    if (!TextUtils.isEmpty(zzco)) {
                        zzfo.name = zzco;
                    }
                    arrayMap.put(zzfo.name, zzfo.zzawh);
                    arrayMap2.put(zzfo.name, zzfo.zzawi);
                    if (zzfo.zzawj != null) {
                        if (zzfo.zzawj.intValue() < zzaoj || zzfo.zzawj.intValue() > zzaoi) {
                            zzgt().zzjj().zze("Invalid sampling rate. Event name, sample rate", zzfo.name, zzfo.zzawj);
                        } else {
                            arrayMap3.put(zzfo.name, zzfo.zzawj);
                        }
                    }
                }
            }
        }
        this.zzaol.put(str, arrayMap);
        this.zzaom.put(str, arrayMap2);
        this.zzaoo.put(str, arrayMap3);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final boolean zza(String str, byte[] bArr, String str2) {
        byte[] bArr2;
        zzcl();
        zzaf();
        Preconditions.checkNotEmpty(str);
        zzfp zza = zza(str, bArr);
        if (zza == null) {
            return false;
        }
        zza(str, zza);
        this.zzaon.put(str, zza);
        this.zzaop.put(str, str2);
        this.zzaok.put(str, zza(zza));
        zzm zzjs = zzjs();
        zzfi[] zzfiArr = zza.zzawo;
        Preconditions.checkNotNull(zzfiArr);
        for (zzfi zzfi : zzfiArr) {
            zzfj[] zzfjArr = zzfi.zzavg;
            for (zzfj zzfj : zzfjArr) {
                String zzco = zzcu.zzco(zzfj.zzavl);
                if (zzco != null) {
                    zzfj.zzavl = zzco;
                }
                zzfk[] zzfkArr = zzfj.zzavm;
                for (zzfk zzfk : zzfkArr) {
                    String zzco2 = zzcv.zzco(zzfk.zzavt);
                    if (zzco2 != null) {
                        zzfk.zzavt = zzco2;
                    }
                }
            }
            zzfm[] zzfmArr = zzfi.zzavf;
            for (zzfm zzfm : zzfmArr) {
                String zzco3 = zzcw.zzco(zzfm.zzawa);
                if (zzco3 != null) {
                    zzfm.zzawa = zzco3;
                }
            }
        }
        zzjs.zzjt().zza(str, zzfiArr);
        try {
            zza.zzawo = null;
            bArr2 = new byte[zza.zzvx()];
            zza.zza(zzya.zzk(bArr2, 0, bArr2.length));
        } catch (IOException e) {
            zzgt().zzjj().zze("Unable to serialize reduced-size config. Storing full config instead. appId", zzas.zzbw(str), e);
            bArr2 = bArr;
        }
        zzt zzjt = zzjt();
        Preconditions.checkNotEmpty(str);
        zzjt.zzaf();
        zzjt.zzcl();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr2);
        try {
            if (((long) zzjt.getWritableDatabase().update("apps", contentValues, "app_id = ?", new String[]{str})) == 0) {
                zzjt.zzgt().zzjg().zzg("Failed to update remote config (got 0). appId", zzas.zzbw(str));
            }
        } catch (SQLiteException e2) {
            zzjt.zzgt().zzjg().zze("Error storing remote config. appId", zzas.zzbw(str), e2);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzo(String str, String str2) {
        Boolean bool;
        zzaf();
        zzcf(str);
        if (zzcl(str) && zzfy.zzcy(str2)) {
            return true;
        }
        if (zzcm(str) && zzfy.zzct(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.zzaol.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzp(String str, String str2) {
        Boolean bool;
        zzaf();
        zzcf(str);
        if (FirebaseAnalytics.Event.ECOMMERCE_PURCHASE.equals(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.zzaom.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final int zzq(String str, String str2) {
        Integer num;
        zzaf();
        zzcf(str);
        Map<String, Integer> map = this.zzaoo.get(str);
        if (map == null || (num = map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final long zzck(String str) {
        String zzf = zzf(str, "measurement.account.time_zone_offset_minutes");
        if (TextUtils.isEmpty(zzf)) {
            return 0;
        }
        try {
            return Long.parseLong(zzf);
        } catch (NumberFormatException e) {
            zzgt().zzjj().zze("Unable to parse timezone offset. appId", zzas.zzbw(str), e);
            return 0;
        }
    }

    @WorkerThread
    private final zzfp zza(String str, byte[] bArr) {
        if (bArr == null) {
            return new zzfp();
        }
        zzxz zzj = zzxz.zzj(bArr, 0, bArr.length);
        zzfp zzfp = new zzfp();
        try {
            zzfp.zza(zzj);
            zzgt().zzjo().zze("Parsed config. version, gmp_app_id", zzfp.zzawk, zzfp.zzafi);
            return zzfp;
        } catch (IOException e) {
            zzgt().zzjj().zze("Unable to merge remote config. appId", zzas.zzbw(str), e);
            return new zzfp();
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzcl(String str) {
        return "1".equals(zzf(str, "measurement.upload.blacklist_internal"));
    }

    /* access modifiers changed from: package-private */
    public final boolean zzcm(String str) {
        return "1".equals(zzf(str, "measurement.upload.blacklist_public"));
    }

    @Override // com.google.android.gms.measurement.internal.zzfm
    public final /* bridge */ /* synthetic */ zzfu zzjr() {
        return super.zzjr();
    }

    @Override // com.google.android.gms.measurement.internal.zzfm
    public final /* bridge */ /* synthetic */ zzm zzjs() {
        return super.zzjs();
    }

    @Override // com.google.android.gms.measurement.internal.zzfm
    public final /* bridge */ /* synthetic */ zzt zzjt() {
        return super.zzjt();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzgf() {
        super.zzgf();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzgg() {
        super.zzgg();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzgh() {
        super.zzgh();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzaf() {
        super.zzaf();
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
