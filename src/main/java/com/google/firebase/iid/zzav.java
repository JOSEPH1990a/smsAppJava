package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.VisibleForTesting;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

public final class zzav {
    private static zzav zzcx;
    @GuardedBy("serviceClassNames")
    private final SimpleArrayMap<String, String> zzcy = new SimpleArrayMap<>();
    private Boolean zzcz = null;
    @VisibleForTesting
    final Queue<Intent> zzda = new ArrayDeque();
    @VisibleForTesting
    private final Queue<Intent> zzdb = new ArrayDeque();

    public static synchronized zzav zzai() {
        zzav zzav;
        synchronized (zzav.class) {
            if (zzcx == null) {
                zzcx = new zzav();
            }
            zzav = zzcx;
        }
        return zzav;
    }

    private zzav() {
    }

    public static PendingIntent zza(Context context, int i, Intent intent, int i2) {
        return PendingIntent.getBroadcast(context, i, zza(context, "com.google.firebase.MESSAGING_EVENT", intent), 1073741824);
    }

    public static void zzb(Context context, Intent intent) {
        context.sendBroadcast(zza(context, "com.google.firebase.INSTANCE_ID_EVENT", intent));
    }

    public static void zzc(Context context, Intent intent) {
        context.sendBroadcast(zza(context, "com.google.firebase.MESSAGING_EVENT", intent));
    }

    private static Intent zza(Context context, String str, Intent intent) {
        Intent intent2 = new Intent(context, FirebaseInstanceIdReceiver.class);
        intent2.setAction(str);
        intent2.putExtra("wrapped_intent", intent);
        return intent2;
    }

    public final Intent zzaj() {
        return this.zzdb.poll();
    }

    public final int zzb(Context context, String str, Intent intent) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf = String.valueOf(str);
            Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Starting service: ".concat(valueOf) : new String("Starting service: "));
        }
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -842411455) {
            if (hashCode == 41532704 && str.equals("com.google.firebase.MESSAGING_EVENT")) {
                c = 1;
            }
        } else if (str.equals("com.google.firebase.INSTANCE_ID_EVENT")) {
            c = 0;
        }
        switch (c) {
            case 0:
                this.zzda.offer(intent);
                break;
            case 1:
                this.zzdb.offer(intent);
                break;
            default:
                String valueOf2 = String.valueOf(str);
                Log.w("FirebaseInstanceId", valueOf2.length() != 0 ? "Unknown service action: ".concat(valueOf2) : new String("Unknown service action: "));
                return 500;
        }
        Intent intent2 = new Intent(str);
        intent2.setPackage(context.getPackageName());
        return zzd(context, intent2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00db A[Catch:{ SecurityException -> 0x0138, IllegalStateException -> 0x0110 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00f2 A[Catch:{ SecurityException -> 0x0138, IllegalStateException -> 0x0110 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00f7 A[Catch:{ SecurityException -> 0x0138, IllegalStateException -> 0x0110 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0104 A[Catch:{ SecurityException -> 0x0138, IllegalStateException -> 0x0110 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x010e A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzd(android.content.Context r7, android.content.Intent r8) {
        /*
        // Method dump skipped, instructions count: 326
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzav.zzd(android.content.Context, android.content.Intent):int");
    }
}
