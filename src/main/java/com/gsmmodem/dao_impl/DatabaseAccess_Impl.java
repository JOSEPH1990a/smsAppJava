package com.gsmmodem.dao_impl;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomMasterTable;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.util.TableInfo;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.gsmmodem.dao_services.DaoAccess;
import com.gsmmodem.dao_services.DaoAccess_Impl;
import java.util.HashMap;
import java.util.HashSet;

public class DatabaseAccess_Impl extends DatabaseAccess {
    private volatile DaoAccess _daoAccess;

    /* access modifiers changed from: protected */
    @Override // android.arch.persistence.room.RoomDatabase
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(1) {
            /* class com.gsmmodem.dao_impl.DatabaseAccess_Impl.AnonymousClass1 */

            @Override // android.arch.persistence.room.RoomOpenHelper.Delegate
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `AppSettingsEntity` (`id` INTEGER NOT NULL, `PORT` TEXT, `GET_SMS_SWITCH` INTEGER, `GET_SMS_URL` TEXT, `OUTGOING_SMS_SWITCH` INTEGER, `NO_SMS` INTEGER, `NO_MINUTES` INTEGER, `DATE_LAST_SMS` TEXT, `SMS_NUMBER_COUNT` INTEGER, `IS_SERVER_STARTED` INTEGER, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `UsersEntity` (`id` INTEGER, `name` TEXT, `password` TEXT, `isChecked` INTEGER, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"5a05a946fd1500e732ba18b8290c6d2e\")");
            }

            @Override // android.arch.persistence.room.RoomOpenHelper.Delegate
            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `AppSettingsEntity`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `UsersEntity`");
            }

            /* access modifiers changed from: protected */
            @Override // android.arch.persistence.room.RoomOpenHelper.Delegate
            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (DatabaseAccess_Impl.this.mCallbacks != null) {
                    int size = DatabaseAccess_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) DatabaseAccess_Impl.this.mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            @Override // android.arch.persistence.room.RoomOpenHelper.Delegate
            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                DatabaseAccess_Impl.this.mDatabase = supportSQLiteDatabase;
                DatabaseAccess_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (DatabaseAccess_Impl.this.mCallbacks != null) {
                    int size = DatabaseAccess_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) DatabaseAccess_Impl.this.mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            /* access modifiers changed from: protected */
            @Override // android.arch.persistence.room.RoomOpenHelper.Delegate
            public void validateMigration(SupportSQLiteDatabase supportSQLiteDatabase) {
                HashMap hashMap = new HashMap(10);
                hashMap.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
                hashMap.put("PORT", new TableInfo.Column("PORT", "TEXT", false, 0));
                hashMap.put("GET_SMS_SWITCH", new TableInfo.Column("GET_SMS_SWITCH", "INTEGER", false, 0));
                hashMap.put("GET_SMS_URL", new TableInfo.Column("GET_SMS_URL", "TEXT", false, 0));
                hashMap.put("OUTGOING_SMS_SWITCH", new TableInfo.Column("OUTGOING_SMS_SWITCH", "INTEGER", false, 0));
                hashMap.put("NO_SMS", new TableInfo.Column("NO_SMS", "INTEGER", false, 0));
                hashMap.put("NO_MINUTES", new TableInfo.Column("NO_MINUTES", "INTEGER", false, 0));
                hashMap.put("DATE_LAST_SMS", new TableInfo.Column("DATE_LAST_SMS", "TEXT", false, 0));
                hashMap.put("SMS_NUMBER_COUNT", new TableInfo.Column("SMS_NUMBER_COUNT", "INTEGER", false, 0));
                hashMap.put("IS_SERVER_STARTED", new TableInfo.Column("IS_SERVER_STARTED", "INTEGER", false, 0));
                TableInfo tableInfo = new TableInfo("AppSettingsEntity", hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(supportSQLiteDatabase, "AppSettingsEntity");
                if (tableInfo.equals(read)) {
                    HashMap hashMap2 = new HashMap(4);
                    hashMap2.put("id", new TableInfo.Column("id", "INTEGER", false, 1));
                    hashMap2.put(AppMeasurementSdk.ConditionalUserProperty.NAME, new TableInfo.Column(AppMeasurementSdk.ConditionalUserProperty.NAME, "TEXT", false, 0));
                    hashMap2.put("password", new TableInfo.Column("password", "TEXT", false, 0));
                    hashMap2.put("isChecked", new TableInfo.Column("isChecked", "INTEGER", false, 0));
                    TableInfo tableInfo2 = new TableInfo("UsersEntity", hashMap2, new HashSet(0), new HashSet(0));
                    TableInfo read2 = TableInfo.read(supportSQLiteDatabase, "UsersEntity");
                    if (!tableInfo2.equals(read2)) {
                        throw new IllegalStateException("Migration didn't properly handle UsersEntity(com.gsmmodem.entities.UsersEntity).\n Expected:\n" + tableInfo2 + "\n" + " Found:\n" + read2);
                    }
                    return;
                }
                throw new IllegalStateException("Migration didn't properly handle AppSettingsEntity(com.gsmmodem.entities.AppSettingsEntity).\n Expected:\n" + tableInfo + "\n" + " Found:\n" + read);
            }
        }, "5a05a946fd1500e732ba18b8290c6d2e", "d07a107d5ac6003eab59d5c36c94636e")).build());
    }

    /* access modifiers changed from: protected */
    @Override // android.arch.persistence.room.RoomDatabase
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, "AppSettingsEntity", "UsersEntity");
    }

    @Override // android.arch.persistence.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `AppSettingsEntity`");
            writableDatabase.execSQL("DELETE FROM `UsersEntity`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // com.gsmmodem.dao_impl.DatabaseAccess
    public DaoAccess daoAccess() {
        DaoAccess daoAccess;
        if (this._daoAccess != null) {
            return this._daoAccess;
        }
        synchronized (this) {
            if (this._daoAccess == null) {
                this._daoAccess = new DaoAccess_Impl(this);
            }
            daoAccess = this._daoAccess;
        }
        return daoAccess;
    }
}
