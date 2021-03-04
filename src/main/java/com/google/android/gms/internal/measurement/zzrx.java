package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.support.annotation.GuardedBy;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzrx implements zzsb {
    @GuardedBy("ConfigurationContentLoader.class")
    static final Map<Uri, zzrx> zzbrb = new ArrayMap();
    private static final String[] zzbrg = {"key", "value"};
    private final Uri uri;
    private final ContentResolver zzbrc;
    private final Object zzbrd = new Object();
    private volatile Map<String, String> zzbre;
    @GuardedBy("this")
    private final List<zzsa> zzbrf = new ArrayList();

    private zzrx(ContentResolver contentResolver, Uri uri2) {
        this.zzbrc = contentResolver;
        this.uri = uri2;
        this.zzbrc.registerContentObserver(uri2, false, new zzrz(this, null));
    }

    public static zzrx zza(ContentResolver contentResolver, Uri uri2) {
        zzrx zzrx;
        synchronized (zzrx.class) {
            zzrx = zzbrb.get(uri2);
            if (zzrx == null) {
                try {
                    zzrx zzrx2 = new zzrx(contentResolver, uri2);
                    try {
                        zzbrb.put(uri2, zzrx2);
                        zzrx = zzrx2;
                    } catch (SecurityException unused) {
                        zzrx = zzrx2;
                    }
                } catch (SecurityException unused2) {
                }
            }
        }
        return zzrx;
    }

    public final Map<String, String> zztk() {
        Map<String, String> map = this.zzbre;
        if (map == null) {
            synchronized (this.zzbrd) {
                map = this.zzbre;
                if (map == null) {
                    map = zztm();
                    this.zzbre = map;
                }
            }
        }
        if (map != null) {
            return map;
        }
        return Collections.emptyMap();
    }

    public final void zztl() {
        synchronized (this.zzbrd) {
            this.zzbre = null;
            zzsi.zztq();
        }
        synchronized (this) {
            for (zzsa zzsa : this.zzbrf) {
                zzsa.zztp();
            }
        }
    }

    private final Map<String, String> zztm() {
        try {
            return (Map) zzsc.zza(new zzry(this));
        } catch (SQLiteException | SecurityException unused) {
            Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
            return null;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzsb
    public final /* synthetic */ Object zzfn(String str) {
        return zztk().get(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Map zztn() {
        Map map;
        Cursor query = this.zzbrc.query(this.uri, zzbrg, null, null, null);
        if (query == null) {
            return Collections.emptyMap();
        }
        try {
            int count = query.getCount();
            if (count == 0) {
                return Collections.emptyMap();
            }
            if (count <= 256) {
                map = new ArrayMap(count);
            } else {
                map = new HashMap(count, 1.0f);
            }
            while (query.moveToNext()) {
                map.put(query.getString(0), query.getString(1));
            }
            query.close();
            return map;
        } finally {
            query.close();
        }
    }
}
