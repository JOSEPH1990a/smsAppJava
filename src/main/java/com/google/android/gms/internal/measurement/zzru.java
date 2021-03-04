package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class zzru {
    public static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
    private static final Uri zzbqn = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern zzbqo = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern zzbqp = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    private static final AtomicBoolean zzbqq = new AtomicBoolean();
    private static HashMap<String, String> zzbqr;
    private static final HashMap<String, Boolean> zzbqs = new HashMap<>();
    private static final HashMap<String, Integer> zzbqt = new HashMap<>();
    private static final HashMap<String, Long> zzbqu = new HashMap<>();
    private static final HashMap<String, Float> zzbqv = new HashMap<>();
    private static Object zzbqw;
    private static boolean zzbqx;
    private static String[] zzbqy = new String[0];

    private static void zza(ContentResolver contentResolver) {
        if (zzbqr == null) {
            zzbqq.set(false);
            zzbqr = new HashMap<>();
            zzbqw = new Object();
            zzbqx = false;
            contentResolver.registerContentObserver(CONTENT_URI, true, new zzrv(null));
        } else if (zzbqq.getAndSet(false)) {
            zzbqr.clear();
            zzbqs.clear();
            zzbqt.clear();
            zzbqu.clear();
            zzbqv.clear();
            zzbqw = new Object();
            zzbqx = false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0064, code lost:
        r13 = r13.query(com.google.android.gms.internal.measurement.zzru.CONTENT_URI, null, null, new java.lang.String[]{r14}, null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0072, code lost:
        if (r13 != null) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0074, code lost:
        if (r13 == null) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0076, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0079, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x007e, code lost:
        if (r13.moveToFirst() != false) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0080, code lost:
        zza(r0, r14, (java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0088, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0089, code lost:
        r15 = r13.getString(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x008d, code lost:
        if (r15 == null) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0093, code lost:
        if (r15.equals(null) == false) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0095, code lost:
        r15 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0096, code lost:
        zza(r0, r14, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0099, code lost:
        if (r15 == null) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x009c, code lost:
        r15 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x009d, code lost:
        if (r13 == null) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x009f, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00a2, code lost:
        return r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00a3, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00a4, code lost:
        if (r13 != null) goto L_0x00a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00a6, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00a9, code lost:
        throw r14;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String zza(android.content.ContentResolver r13, java.lang.String r14, java.lang.String r15) {
        /*
        // Method dump skipped, instructions count: 174
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzru.zza(android.content.ContentResolver, java.lang.String, java.lang.String):java.lang.String");
    }

    private static void zza(Object obj, String str, String str2) {
        synchronized (zzru.class) {
            if (obj == zzbqw) {
                zzbqr.put(str, str2);
            }
        }
    }

    private static Map<String, String> zza(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(zzbqn, null, null, strArr, null);
        TreeMap treeMap = new TreeMap();
        if (query == null) {
            return treeMap;
        }
        while (query.moveToNext()) {
            try {
                treeMap.put(query.getString(0), query.getString(1));
            } finally {
                query.close();
            }
        }
        return treeMap;
    }
}
