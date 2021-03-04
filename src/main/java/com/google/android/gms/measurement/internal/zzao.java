package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcel;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzao extends zzf {
    private final zzap zzalm = new zzap(this, getContext(), "google_app_measurement_local.db");
    private boolean zzaln;

    zzao(zzbw zzbw) {
        super(zzbw);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.measurement.internal.zzf
    public final boolean zzgy() {
        return false;
    }

    @WorkerThread
    public final void resetAnalyticsData() {
        zzgg();
        zzaf();
        try {
            int delete = getWritableDatabase().delete("messages", null, null) + 0;
            if (delete > 0) {
                zzgt().zzjo().zzg("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzgt().zzjg().zzg("Error resetting local analytics data. error", e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c6 A[SYNTHETIC, Splitter:B:48:0x00c6] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0119 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0119 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0119 A[SYNTHETIC] */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zza(int r17, byte[] r18) {
        /*
        // Method dump skipped, instructions count: 315
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzao.zza(int, byte[]):boolean");
    }

    public final boolean zza(zzag zzag) {
        Parcel obtain = Parcel.obtain();
        zzag.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zza(0, marshall);
        }
        zzgt().zzjj().zzby("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean zza(zzfv zzfv) {
        Parcel obtain = Parcel.obtain();
        zzfv.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zza(1, marshall);
        }
        zzgt().zzjj().zzby("User property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean zzc(zzo zzo) {
        zzgr();
        byte[] zza = zzfy.zza(zzo);
        if (zza.length <= 131072) {
            return zza(2, zza);
        }
        zzgt().zzjj().zzby("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0197, code lost:
        if (r2.inTransaction() != false) goto L_0x0199;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0199, code lost:
        r2.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01ad, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x01b2, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x01b6, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x01c2, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x01c7, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x01e3, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x01e8, code lost:
        r15.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x01f6, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x01fb, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        zzgt().zzjg().zzby("Failed to load event from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b6, code lost:
        r13.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b9, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        zzgt().zzjg().zzby("Failed to load user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e2, code lost:
        r13.recycle();
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ec, code lost:
        r13.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ef, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0109, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        zzgt().zzjg().zzby("Failed to load user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0118, code lost:
        r13.recycle();
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0123, code lost:
        r13.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0126, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x017b, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x017c, code lost:
        r2 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x017e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x017f, code lost:
        r2 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0181, code lost:
        r2 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0185, code lost:
        r0 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x00a5 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00d5 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:62:0x010b */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0193 A[SYNTHETIC, Splitter:B:106:0x0193] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x01c7  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x01e3  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01e8  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01f6  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01eb A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x01eb A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x01eb A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:93:? A[ExcHandler: SQLiteDatabaseLockedException (unused android.database.sqlite.SQLiteDatabaseLockedException), SYNTHETIC, Splitter:B:12:0x0031] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable> zzr(int r20) {
        /*
        // Method dump skipped, instructions count: 526
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzao.zzr(int):java.util.List");
    }

    @WorkerThread
    @VisibleForTesting
    private final SQLiteDatabase getWritableDatabase() throws SQLiteException {
        if (this.zzaln) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zzalm.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzaln = true;
        return null;
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
