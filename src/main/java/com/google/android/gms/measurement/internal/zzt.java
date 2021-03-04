package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzfi;
import com.google.android.gms.internal.measurement.zzfj;
import com.google.android.gms.internal.measurement.zzfm;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzfu;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzxz;
import com.google.android.gms.internal.measurement.zzya;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* access modifiers changed from: package-private */
public final class zzt extends zzfn {
    private static final String[] zzagz = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;"};
    private static final String[] zzaha = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    private static final String[] zzahb = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;"};
    private static final String[] zzahc = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    private static final String[] zzahd = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    private static final String[] zzahe = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private final zzw zzahf = new zzw(this, getContext(), "google_app_measurement.db");
    private final zzfj zzahg = new zzfj(zzbx());

    zzt(zzfo zzfo) {
        super(zzfo);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.measurement.internal.zzfn
    public final boolean zzgy() {
        return false;
    }

    @WorkerThread
    public final void beginTransaction() {
        zzcl();
        getWritableDatabase().beginTransaction();
    }

    @WorkerThread
    public final void setTransactionSuccessful() {
        zzcl();
        getWritableDatabase().setTransactionSuccessful();
    }

    @WorkerThread
    public final void endTransaction() {
        zzcl();
        getWritableDatabase().endTransaction();
    }

    @WorkerThread
    private final long zza(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = getWritableDatabase().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            zzgt().zzjg().zze("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    private final long zza(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = getWritableDatabase().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j2 = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return j2;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return j;
        } catch (SQLiteException e) {
            zzgt().zzjg().zze("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    public final SQLiteDatabase getWritableDatabase() {
        zzaf();
        try {
            return this.zzahf.getWritableDatabase();
        } catch (SQLiteException e) {
            zzgt().zzjj().zzg("Error opening database", e);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0134  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzac zzg(java.lang.String r23, java.lang.String r24) {
        /*
        // Method dump skipped, instructions count: 313
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzt.zzg(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzac");
    }

    @WorkerThread
    public final void zza(zzac zzac) {
        Preconditions.checkNotNull(zzac);
        zzaf();
        zzcl();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzac.zztt);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzac.name);
        contentValues.put("lifetime_count", Long.valueOf(zzac.zzahv));
        contentValues.put("current_bundle_count", Long.valueOf(zzac.zzahw));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzac.zzahx));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzac.zzahy));
        contentValues.put("last_bundled_day", zzac.zzahz);
        contentValues.put("last_sampled_complex_event_id", zzac.zzaia);
        contentValues.put("last_sampling_rate", zzac.zzaib);
        contentValues.put("last_exempt_from_sampling", (zzac.zzaic == null || !zzac.zzaic.booleanValue()) ? null : 1L);
        try {
            if (getWritableDatabase().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                zzgt().zzjg().zzg("Failed to insert/update event aggregates (got -1). appId", zzas.zzbw(zzac.zztt));
            }
        } catch (SQLiteException e) {
            zzgt().zzjg().zze("Error storing event aggregates. appId", zzas.zzbw(zzac.zztt), e);
        }
    }

    @WorkerThread
    public final void zzh(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzaf();
        zzcl();
        try {
            zzgt().zzjo().zzg("Deleted user attribute rows", Integer.valueOf(getWritableDatabase().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e) {
            zzgt().zzjg().zzd("Error deleting user attribute. appId", zzas.zzbw(str), zzgq().zzbv(str2), e);
        }
    }

    @WorkerThread
    public final boolean zza(zzfx zzfx) {
        Preconditions.checkNotNull(zzfx);
        zzaf();
        zzcl();
        if (zzi(zzfx.zztt, zzfx.name) == null) {
            if (zzfy.zzct(zzfx.name)) {
                if (zza("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzfx.zztt}) >= 25) {
                    return false;
                }
            } else {
                if (zza("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzfx.zztt, zzfx.origin}) >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzfx.zztt);
        contentValues.put("origin", zzfx.origin);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzfx.name);
        contentValues.put("set_timestamp", Long.valueOf(zzfx.zzauk));
        zza(contentValues, "value", zzfx.value);
        try {
            if (getWritableDatabase().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                zzgt().zzjg().zzg("Failed to insert/update user property (got -1). appId", zzas.zzbw(zzfx.zztt));
            }
        } catch (SQLiteException e) {
            zzgt().zzjg().zze("Error storing user property. appId", zzas.zzbw(zzfx.zztt), e);
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ae  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzfx zzi(java.lang.String r19, java.lang.String r20) {
        /*
        // Method dump skipped, instructions count: 178
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzt.zzi(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzfx");
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00bb  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.measurement.internal.zzfx> zzbl(java.lang.String r23) {
        /*
        // Method dump skipped, instructions count: 192
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzt.zzbl(java.lang.String):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x011a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0122, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0126, code lost:
        r0 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0122 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x000f] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0149  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.measurement.internal.zzfx> zzb(java.lang.String r22, java.lang.String r23, java.lang.String r24) {
        /*
        // Method dump skipped, instructions count: 334
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzt.zzb(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    @WorkerThread
    public final boolean zza(zzo zzo) {
        Preconditions.checkNotNull(zzo);
        zzaf();
        zzcl();
        if (zzi(zzo.packageName, zzo.zzags.name) == null) {
            if (zza("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{zzo.packageName}) >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzo.packageName);
        contentValues.put("origin", zzo.origin);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzo.zzags.name);
        zza(contentValues, "value", zzo.zzags.getValue());
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.valueOf(zzo.active));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzo.triggerEventName);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzo.triggerTimeout));
        zzgr();
        contentValues.put("timed_out_event", zzfy.zza(zzo.zzagt));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzo.creationTimestamp));
        zzgr();
        contentValues.put("triggered_event", zzfy.zza(zzo.zzagu));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzo.zzags.zzauk));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzo.timeToLive));
        zzgr();
        contentValues.put("expired_event", zzfy.zza(zzo.zzagv));
        try {
            if (getWritableDatabase().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                zzgt().zzjg().zzg("Failed to insert/update conditional user property (got -1)", zzas.zzbw(zzo.packageName));
            }
        } catch (SQLiteException e) {
            zzgt().zzjg().zze("Error storing conditional user property", zzas.zzbw(zzo.packageName), e);
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0155  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzo zzj(java.lang.String r33, java.lang.String r34) {
        /*
        // Method dump skipped, instructions count: 345
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzt.zzj(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzo");
    }

    @WorkerThread
    public final int zzk(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzaf();
        zzcl();
        try {
            return getWritableDatabase().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzgt().zzjg().zzd("Error deleting conditional property", zzas.zzbw(str), zzgq().zzbv(str2), e);
            return 0;
        }
    }

    @WorkerThread
    public final List<zzo> zzc(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzaf();
        zzcl();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return zzb(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0175  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.measurement.internal.zzo> zzb(java.lang.String r40, java.lang.String[] r41) {
        /*
        // Method dump skipped, instructions count: 378
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzt.zzb(java.lang.String, java.lang.String[]):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0180 A[Catch:{ SQLiteException -> 0x0212 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0184 A[Catch:{ SQLiteException -> 0x0212 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x01b8 A[Catch:{ SQLiteException -> 0x0212 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x01bb A[Catch:{ SQLiteException -> 0x0212 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x01ca A[Catch:{ SQLiteException -> 0x0212 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x01fb A[Catch:{ SQLiteException -> 0x0212 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x023f  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzg zzbm(java.lang.String r23) {
        /*
        // Method dump skipped, instructions count: 579
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzt.zzbm(java.lang.String):com.google.android.gms.measurement.internal.zzg");
    }

    @WorkerThread
    public final void zza(zzg zzg) {
        Preconditions.checkNotNull(zzg);
        zzaf();
        zzcl();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzg.zzal());
        contentValues.put("app_instance_id", zzg.getAppInstanceId());
        contentValues.put("gmp_app_id", zzg.getGmpAppId());
        contentValues.put("resettable_device_id_hash", zzg.zzhc());
        contentValues.put("last_bundle_index", Long.valueOf(zzg.zzhj()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzg.zzhd()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzg.zzhe()));
        contentValues.put("app_version", zzg.zzak());
        contentValues.put("app_store", zzg.zzhg());
        contentValues.put("gmp_version", Long.valueOf(zzg.zzhh()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzg.zzhi()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzg.isMeasurementEnabled()));
        contentValues.put("day", Long.valueOf(zzg.zzhn()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzg.zzho()));
        contentValues.put("daily_events_count", Long.valueOf(zzg.zzhp()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzg.zzhq()));
        contentValues.put("config_fetched_time", Long.valueOf(zzg.zzhk()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzg.zzhl()));
        contentValues.put("app_version_int", Long.valueOf(zzg.zzhf()));
        contentValues.put("firebase_instance_id", zzg.getFirebaseInstanceId());
        contentValues.put("daily_error_events_count", Long.valueOf(zzg.zzhs()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzg.zzhr()));
        contentValues.put("health_monitor_sample", zzg.zzht());
        contentValues.put("android_id", Long.valueOf(zzg.zzhv()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzg.zzhw()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(zzg.zzhx()));
        contentValues.put("admob_app_id", zzg.zzhb());
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (((long) writableDatabase.update("apps", contentValues, "app_id = ?", new String[]{zzg.zzal()})) == 0 && writableDatabase.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzgt().zzjg().zzg("Failed to insert/update app (got -1). appId", zzas.zzbw(zzg.zzal()));
            }
        } catch (SQLiteException e) {
            zzgt().zzjg().zze("Error storing app. appId", zzas.zzbw(zzg.zzal()), e);
        }
    }

    public final long zzbn(String str) {
        Preconditions.checkNotEmpty(str);
        zzaf();
        zzcl();
        try {
            return (long) getWritableDatabase().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, zzgv().zzb(str, zzai.zzajj))))});
        } catch (SQLiteException e) {
            zzgt().zzjg().zze("Error deleting over the limit events. appId", zzas.zzbw(str), e);
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x012f  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzu zza(long r19, java.lang.String r21, boolean r22, boolean r23, boolean r24, boolean r25, boolean r26) {
        /*
        // Method dump skipped, instructions count: 307
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzt.zza(long, java.lang.String, boolean, boolean, boolean, boolean, boolean):com.google.android.gms.measurement.internal.zzu");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0079  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] zzbo(java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 125
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzt.zzbo(java.lang.String):byte[]");
    }

    @WorkerThread
    public final boolean zza(zzfw zzfw, boolean z) {
        zzaf();
        zzcl();
        Preconditions.checkNotNull(zzfw);
        Preconditions.checkNotEmpty(zzfw.zztt);
        Preconditions.checkNotNull(zzfw.zzaxm);
        zzij();
        long currentTimeMillis = zzbx().currentTimeMillis();
        if (zzfw.zzaxm.longValue() < currentTimeMillis - zzq.zzib() || zzfw.zzaxm.longValue() > zzq.zzib() + currentTimeMillis) {
            zzgt().zzjj().zzd("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzas.zzbw(zzfw.zztt), Long.valueOf(currentTimeMillis), zzfw.zzaxm);
        }
        try {
            byte[] bArr = new byte[zzfw.zzvx()];
            zzya zzk = zzya.zzk(bArr, 0, bArr.length);
            zzfw.zza(zzk);
            zzk.zzza();
            byte[] zzb = zzjr().zzb(bArr);
            zzgt().zzjo().zzg("Saving bundle, size", Integer.valueOf(zzb.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzfw.zztt);
            contentValues.put("bundle_end_timestamp", zzfw.zzaxm);
            contentValues.put("data", zzb);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (zzfw.zzayj != null) {
                contentValues.put("retry_count", zzfw.zzayj);
            }
            try {
                if (getWritableDatabase().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                zzgt().zzjg().zzg("Failed to insert bundle (got -1). appId", zzas.zzbw(zzfw.zztt));
                return false;
            } catch (SQLiteException e) {
                zzgt().zzjg().zze("Error storing bundle. appId", zzas.zzbw(zzfw.zztt), e);
                return false;
            }
        } catch (IOException e2) {
            zzgt().zzjg().zze("Data loss. Failed to serialize bundle. appId", zzas.zzbw(zzfw.zztt), e2);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0041  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zzih() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.getWritableDatabase()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch:{ SQLiteException -> 0x0029, all -> 0x0024 }
            boolean r2 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x0022 }
            if (r2 == 0) goto L_0x001c
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch:{ SQLiteException -> 0x0022 }
            if (r0 == 0) goto L_0x001b
            r0.close()
        L_0x001b:
            return r1
        L_0x001c:
            if (r0 == 0) goto L_0x0021
            r0.close()
        L_0x0021:
            return r1
        L_0x0022:
            r2 = move-exception
            goto L_0x002b
        L_0x0024:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x003f
        L_0x0029:
            r2 = move-exception
            r0 = r1
        L_0x002b:
            com.google.android.gms.measurement.internal.zzas r3 = r6.zzgt()     // Catch:{ all -> 0x003e }
            com.google.android.gms.measurement.internal.zzau r3 = r3.zzjg()     // Catch:{ all -> 0x003e }
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.zzg(r4, r2)     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x003d
            r0.close()
        L_0x003d:
            return r1
        L_0x003e:
            r1 = move-exception
        L_0x003f:
            if (r0 == 0) goto L_0x0044
            r0.close()
        L_0x0044:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzt.zzih():java.lang.String");
    }

    public final boolean zzii() {
        return zza("select count(1) > 0 from queue where has_realtime = 1", null) != 0;
    }

    @WorkerThread
    public final List<Pair<zzfw, Long>> zzb(String str, int i, int i2) {
        zzaf();
        zzcl();
        Preconditions.checkArgument(i > 0);
        Preconditions.checkArgument(i2 > 0);
        Preconditions.checkNotEmpty(str);
        Cursor cursor = null;
        try {
            Cursor query = getWritableDatabase().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
            if (!query.moveToFirst()) {
                List<Pair<zzfw, Long>> emptyList = Collections.emptyList();
                if (query != null) {
                    query.close();
                }
                return emptyList;
            }
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            do {
                long j = query.getLong(0);
                try {
                    byte[] zza = zzjr().zza(query.getBlob(1));
                    if (!arrayList.isEmpty() && zza.length + i3 > i2) {
                        break;
                    }
                    zzxz zzj = zzxz.zzj(zza, 0, zza.length);
                    zzfw zzfw = new zzfw();
                    try {
                        zzfw.zza(zzj);
                        if (!query.isNull(2)) {
                            zzfw.zzayj = Integer.valueOf(query.getInt(2));
                        }
                        i3 += zza.length;
                        arrayList.add(Pair.create(zzfw, Long.valueOf(j)));
                    } catch (IOException e) {
                        zzgt().zzjg().zze("Failed to merge queued bundle. appId", zzas.zzbw(str), e);
                    }
                    if (!query.moveToNext()) {
                        break;
                    }
                } catch (IOException e2) {
                    zzgt().zzjg().zze("Failed to unzip queued bundle. appId", zzas.zzbw(str), e2);
                }
            } while (i3 <= i2);
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (SQLiteException e3) {
            zzgt().zzjg().zze("Error querying bundles. appId", zzas.zzbw(str), e3);
            List<Pair<zzfw, Long>> emptyList2 = Collections.emptyList();
            if (0 != 0) {
                cursor.close();
            }
            return emptyList2;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzij() {
        int delete;
        zzaf();
        zzcl();
        if (zzip()) {
            long j = zzgu().zzand.get();
            long elapsedRealtime = zzbx().elapsedRealtime();
            if (Math.abs(elapsedRealtime - j) > zzai.zzajs.get().longValue()) {
                zzgu().zzand.set(elapsedRealtime);
                zzaf();
                zzcl();
                if (zzip() && (delete = getWritableDatabase().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzbx().currentTimeMillis()), String.valueOf(zzq.zzib())})) > 0) {
                    zzgt().zzjo().zzg("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    public final void zzc(List<Long> list) {
        zzaf();
        zzcl();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzip()) {
            String join = TextUtils.join(",", list);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 80);
            sb3.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            sb3.append(sb2);
            sb3.append(" AND retry_count =  2147483647 LIMIT 1");
            if (zza(sb3.toString(), (String[]) null) > 0) {
                zzgt().zzjj().zzby("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                StringBuilder sb4 = new StringBuilder(String.valueOf(sb2).length() + 127);
                sb4.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb4.append(sb2);
                sb4.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                writableDatabase.execSQL(sb4.toString());
            } catch (SQLiteException e) {
                zzgt().zzjg().zzg("Error incrementing retry count. error", e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(String str, zzfi[] zzfiArr) {
        boolean z;
        zzcl();
        zzaf();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzfiArr);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            zzcl();
            zzaf();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase writableDatabase2 = getWritableDatabase();
            writableDatabase2.delete("property_filters", "app_id=?", new String[]{str});
            writableDatabase2.delete("event_filters", "app_id=?", new String[]{str});
            for (zzfi zzfi : zzfiArr) {
                zzcl();
                zzaf();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(zzfi);
                Preconditions.checkNotNull(zzfi.zzavg);
                Preconditions.checkNotNull(zzfi.zzavf);
                if (zzfi.zzave == null) {
                    zzgt().zzjj().zzg("Audience with no ID. appId", zzas.zzbw(str));
                } else {
                    int intValue = zzfi.zzave.intValue();
                    zzfj[] zzfjArr = zzfi.zzavg;
                    int length = zzfjArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            zzfm[] zzfmArr = zzfi.zzavf;
                            int length2 = zzfmArr.length;
                            int i2 = 0;
                            while (true) {
                                if (i2 >= length2) {
                                    zzfj[] zzfjArr2 = zzfi.zzavg;
                                    int length3 = zzfjArr2.length;
                                    int i3 = 0;
                                    while (true) {
                                        if (i3 >= length3) {
                                            z = true;
                                            break;
                                        } else if (!zza(str, intValue, zzfjArr2[i3])) {
                                            z = false;
                                            break;
                                        } else {
                                            i3++;
                                        }
                                    }
                                    if (z) {
                                        zzfm[] zzfmArr2 = zzfi.zzavf;
                                        int length4 = zzfmArr2.length;
                                        int i4 = 0;
                                        while (true) {
                                            if (i4 >= length4) {
                                                break;
                                            } else if (!zza(str, intValue, zzfmArr2[i4])) {
                                                z = false;
                                                break;
                                            } else {
                                                i4++;
                                            }
                                        }
                                    }
                                    if (!z) {
                                        zzcl();
                                        zzaf();
                                        Preconditions.checkNotEmpty(str);
                                        SQLiteDatabase writableDatabase3 = getWritableDatabase();
                                        writableDatabase3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(intValue)});
                                        writableDatabase3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(intValue)});
                                    }
                                } else if (zzfmArr[i2].zzavk == null) {
                                    zzgt().zzjj().zze("Property filter with no ID. Audience definition ignored. appId, audienceId", zzas.zzbw(str), zzfi.zzave);
                                    break;
                                } else {
                                    i2++;
                                }
                            }
                        } else if (zzfjArr[i].zzavk == null) {
                            zzgt().zzjj().zze("Event filter with no ID. Audience definition ignored. appId, audienceId", zzas.zzbw(str), zzfi.zzave);
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (zzfi zzfi2 : zzfiArr) {
                arrayList.add(zzfi2.zzave);
            }
            zza(str, arrayList);
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @WorkerThread
    private final boolean zza(String str, int i, zzfj zzfj) {
        zzcl();
        zzaf();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzfj);
        if (TextUtils.isEmpty(zzfj.zzavl)) {
            zzgt().zzjj().zzd("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzas.zzbw(str), Integer.valueOf(i), String.valueOf(zzfj.zzavk));
            return false;
        }
        try {
            byte[] bArr = new byte[zzfj.zzvx()];
            zzya zzk = zzya.zzk(bArr, 0, bArr.length);
            zzfj.zza(zzk);
            zzk.zzza();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", zzfj.zzavk);
            contentValues.put("event_name", zzfj.zzavl);
            contentValues.put("data", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("event_filters", null, contentValues, 5) != -1) {
                    return true;
                }
                zzgt().zzjg().zzg("Failed to insert event filter (got -1). appId", zzas.zzbw(str));
                return true;
            } catch (SQLiteException e) {
                zzgt().zzjg().zze("Error storing event filter. appId", zzas.zzbw(str), e);
                return false;
            }
        } catch (IOException e2) {
            zzgt().zzjg().zze("Configuration loss. Failed to serialize event filter. appId", zzas.zzbw(str), e2);
            return false;
        }
    }

    @WorkerThread
    private final boolean zza(String str, int i, zzfm zzfm) {
        zzcl();
        zzaf();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzfm);
        if (TextUtils.isEmpty(zzfm.zzawa)) {
            zzgt().zzjj().zzd("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzas.zzbw(str), Integer.valueOf(i), String.valueOf(zzfm.zzavk));
            return false;
        }
        try {
            byte[] bArr = new byte[zzfm.zzvx()];
            zzya zzk = zzya.zzk(bArr, 0, bArr.length);
            zzfm.zza(zzk);
            zzk.zzza();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", zzfm.zzavk);
            contentValues.put("property_name", zzfm.zzawa);
            contentValues.put("data", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                    return true;
                }
                zzgt().zzjg().zzg("Failed to insert property filter (got -1). appId", zzas.zzbw(str));
                return false;
            } catch (SQLiteException e) {
                zzgt().zzjg().zze("Error storing property filter. appId", zzas.zzbw(str), e);
                return false;
            }
        } catch (IOException e2) {
            zzgt().zzjg().zze("Configuration loss. Failed to serialize property filter. appId", zzas.zzbw(str), e2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzfj>> zzl(java.lang.String r13, java.lang.String r14) {
        /*
        // Method dump skipped, instructions count: 189
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzt.zzl(java.lang.String, java.lang.String):java.util.Map");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzfm>> zzm(java.lang.String r13, java.lang.String r14) {
        /*
        // Method dump skipped, instructions count: 189
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzt.zzm(java.lang.String, java.lang.String):java.util.Map");
    }

    private final boolean zza(String str, List<Integer> list) {
        Preconditions.checkNotEmpty(str);
        zzcl();
        zzaf();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        try {
            long zza = zza("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int max = Math.max(0, Math.min(2000, zzgv().zzb(str, zzai.zzajz)));
            if (zza <= ((long) max)) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = list.get(i);
                if (num == null || !(num instanceof Integer)) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String join = TextUtils.join(",", arrayList);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 140);
            sb3.append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
            sb3.append(sb2);
            sb3.append(" order by rowid desc limit -1 offset ?)");
            return writableDatabase.delete("audience_filter_values", sb3.toString(), new String[]{str, Integer.toString(max)}) > 0;
        } catch (SQLiteException e) {
            zzgt().zzjg().zze("Database error querying filters. appId", zzas.zzbw(str), e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, com.google.android.gms.internal.measurement.zzfx> zzbp(java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 160
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzt.zzbp(java.lang.String):java.util.Map");
    }

    @WorkerThread
    private static void zza(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    @WorkerThread
    @VisibleForTesting
    private final Object zza(Cursor cursor, int i) {
        int type = cursor.getType(i);
        switch (type) {
            case 0:
                zzgt().zzjg().zzby("Loaded invalid null value from database");
                return null;
            case 1:
                return Long.valueOf(cursor.getLong(i));
            case 2:
                return Double.valueOf(cursor.getDouble(i));
            case 3:
                return cursor.getString(i);
            case 4:
                zzgt().zzjg().zzby("Loaded invalid blob type value, ignoring it");
                return null;
            default:
                zzgt().zzjg().zzg("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
        }
    }

    @WorkerThread
    public final long zzik() {
        return zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    @VisibleForTesting
    public final long zzn(String str, String str2) {
        long j;
        SQLiteException e;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzaf();
        zzcl();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 32);
            sb.append("select ");
            sb.append(str2);
            sb.append(" from app2 where app_id=?");
            j = zza(sb.toString(), new String[]{str}, -1);
            if (j == -1) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("first_open_count", (Integer) 0);
                contentValues.put("previous_install_count", (Integer) 0);
                if (writableDatabase.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                    zzgt().zzjg().zze("Failed to insert column (got -1). appId", zzas.zzbw(str), str2);
                    writableDatabase.endTransaction();
                    return -1;
                }
                j = 0;
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str);
                contentValues2.put(str2, Long.valueOf(1 + j));
                if (((long) writableDatabase.update("app2", contentValues2, "app_id = ?", new String[]{str})) == 0) {
                    zzgt().zzjg().zze("Failed to update column (got 0). appId", zzas.zzbw(str), str2);
                    writableDatabase.endTransaction();
                    return -1;
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                return j;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzgt().zzjg().zzd("Error inserting column. appId", zzas.zzbw(str), str2, e);
                    return j;
                } finally {
                    writableDatabase.endTransaction();
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            j = 0;
            zzgt().zzjg().zzd("Error inserting column. appId", zzas.zzbw(str), str2, e);
            return j;
        }
    }

    @WorkerThread
    public final long zzil() {
        return zza("select max(timestamp) from raw_events", (String[]) null, 0);
    }

    public final long zza(zzfw zzfw) throws IOException {
        long j;
        zzaf();
        zzcl();
        Preconditions.checkNotNull(zzfw);
        Preconditions.checkNotEmpty(zzfw.zztt);
        try {
            byte[] bArr = new byte[zzfw.zzvx()];
            zzya zzk = zzya.zzk(bArr, 0, bArr.length);
            zzfw.zza(zzk);
            zzk.zzza();
            zzfu zzjr = zzjr();
            Preconditions.checkNotNull(bArr);
            zzjr.zzgr().zzaf();
            MessageDigest messageDigest = zzfy.getMessageDigest();
            if (messageDigest == null) {
                zzjr.zzgt().zzjg().zzby("Failed to get MD5");
                j = 0;
            } else {
                j = zzfy.zzc(messageDigest.digest(bArr));
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzfw.zztt);
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put("metadata", bArr);
            try {
                getWritableDatabase().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
                return j;
            } catch (SQLiteException e) {
                zzgt().zzjg().zze("Error storing raw event metadata. appId", zzas.zzbw(zzfw.zztt), e);
                throw e;
            }
        } catch (IOException e2) {
            zzgt().zzjg().zze("Data loss. Failed to serialize event metadata. appId", zzas.zzbw(zzfw.zztt), e2);
            throw e2;
        }
    }

    public final boolean zzim() {
        return zza("select count(1) > 0 from raw_events", null) != 0;
    }

    public final boolean zzin() {
        return zza("select count(1) > 0 from raw_events where realtime = 1", null) != 0;
    }

    public final long zzbq(String str) {
        Preconditions.checkNotEmpty(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zzad(long r5) {
        /*
            r4 = this;
            r4.zzaf()
            r4.zzcl()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r4.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0043, all -> 0x0040 }
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0043, all -> 0x0040 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x0043, all -> 0x0040 }
            r6 = 0
            r3[r6] = r5     // Catch:{ SQLiteException -> 0x0043, all -> 0x0040 }
            android.database.Cursor r5 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x0043, all -> 0x0040 }
            boolean r1 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x003e }
            if (r1 != 0) goto L_0x0034
            com.google.android.gms.measurement.internal.zzas r6 = r4.zzgt()     // Catch:{ SQLiteException -> 0x003e }
            com.google.android.gms.measurement.internal.zzau r6 = r6.zzjo()     // Catch:{ SQLiteException -> 0x003e }
            java.lang.String r1 = "No expired configs for apps with pending events"
            r6.zzby(r1)     // Catch:{ SQLiteException -> 0x003e }
            if (r5 == 0) goto L_0x0033
            r5.close()
        L_0x0033:
            return r0
        L_0x0034:
            java.lang.String r6 = r5.getString(r6)
            if (r5 == 0) goto L_0x003d
            r5.close()
        L_0x003d:
            return r6
        L_0x003e:
            r6 = move-exception
            goto L_0x0045
        L_0x0040:
            r6 = move-exception
            r5 = r0
            goto L_0x0059
        L_0x0043:
            r6 = move-exception
            r5 = r0
        L_0x0045:
            com.google.android.gms.measurement.internal.zzas r1 = r4.zzgt()     // Catch:{ all -> 0x0058 }
            com.google.android.gms.measurement.internal.zzau r1 = r1.zzjg()     // Catch:{ all -> 0x0058 }
            java.lang.String r2 = "Error selecting expired configs"
            r1.zzg(r2, r6)     // Catch:{ all -> 0x0058 }
            if (r5 == 0) goto L_0x0057
            r5.close()
        L_0x0057:
            return r0
        L_0x0058:
            r6 = move-exception
        L_0x0059:
            if (r5 == 0) goto L_0x005e
            r5.close()
        L_0x005e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzt.zzad(long):java.lang.String");
    }

    public final long zzio() {
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
            if (!cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return -1;
            }
            long j = cursor.getLong(0);
            if (cursor != null) {
                cursor.close();
            }
            return j;
        } catch (SQLiteException e) {
            zzgt().zzjg().zzg("Error querying raw events", e);
            if (cursor != null) {
                cursor.close();
            }
            return -1;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.util.Pair<com.google.android.gms.internal.measurement.zzft, java.lang.Long> zza(java.lang.String r8, java.lang.Long r9) {
        /*
        // Method dump skipped, instructions count: 147
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzt.zza(java.lang.String, java.lang.Long):android.util.Pair");
    }

    public final boolean zza(String str, Long l, long j, zzft zzft) {
        zzaf();
        zzcl();
        Preconditions.checkNotNull(zzft);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        try {
            byte[] bArr = new byte[zzft.zzvx()];
            zzya zzk = zzya.zzk(bArr, 0, bArr.length);
            zzft.zza(zzk);
            zzk.zzza();
            zzgt().zzjo().zze("Saving complex main event, appId, data size", zzgq().zzbt(str), Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("event_id", l);
            contentValues.put("children_to_process", Long.valueOf(j));
            contentValues.put("main_event", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                    return true;
                }
                zzgt().zzjg().zzg("Failed to insert complex main event (got -1). appId", zzas.zzbw(str));
                return false;
            } catch (SQLiteException e) {
                zzgt().zzjg().zze("Error storing complex main event. appId", zzas.zzbw(str), e);
                return false;
            }
        } catch (IOException e2) {
            zzgt().zzjg().zzd("Data loss. Failed to serialize event params/data. appId, eventId", zzas.zzbw(str), l, e2);
            return false;
        }
    }

    public final boolean zza(zzab zzab, long j, boolean z) {
        zzaf();
        zzcl();
        Preconditions.checkNotNull(zzab);
        Preconditions.checkNotEmpty(zzab.zztt);
        zzft zzft = new zzft();
        zzft.zzaxc = Long.valueOf(zzab.zzaht);
        zzft.zzaxa = new zzfu[zzab.zzahu.size()];
        Iterator<String> it = zzab.zzahu.iterator();
        int i = 0;
        while (it.hasNext()) {
            String next = it.next();
            zzfu zzfu = new zzfu();
            int i2 = i + 1;
            zzft.zzaxa[i] = zzfu;
            zzfu.name = next;
            zzjr().zza(zzfu, zzab.zzahu.get(next));
            i = i2;
        }
        try {
            byte[] bArr = new byte[zzft.zzvx()];
            zzya zzk = zzya.zzk(bArr, 0, bArr.length);
            zzft.zza(zzk);
            zzk.zzza();
            zzgt().zzjo().zze("Saving event, name, data size", zzgq().zzbt(zzab.name), Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzab.zztt);
            contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzab.name);
            contentValues.put(AppMeasurement.Param.TIMESTAMP, Long.valueOf(zzab.timestamp));
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put("data", bArr);
            contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
            try {
                if (getWritableDatabase().insert("raw_events", null, contentValues) != -1) {
                    return true;
                }
                zzgt().zzjg().zzg("Failed to insert raw event (got -1). appId", zzas.zzbw(zzab.zztt));
                return false;
            } catch (SQLiteException e) {
                zzgt().zzjg().zze("Error storing raw event. appId", zzas.zzbw(zzab.zztt), e);
                return false;
            }
        } catch (IOException e2) {
            zzgt().zzjg().zze("Data loss. Failed to serialize event params/data. appId", zzas.zzbw(zzab.zztt), e2);
            return false;
        }
    }

    private final boolean zzip() {
        return getContext().getDatabasePath("google_app_measurement.db").exists();
    }
}
