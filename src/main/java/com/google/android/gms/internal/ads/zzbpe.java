package com.google.android.gms.internal.ads;

import java.io.PrintWriter;

public final class zzbpe {
    private static final zzbpf zzfkn;
    private static final int zzfko;

    static final class zza extends zzbpf {
        zza() {
        }

        @Override // com.google.android.gms.internal.ads.zzbpf
        public final void zze(Throwable th) {
            th.printStackTrace();
        }

        @Override // com.google.android.gms.internal.ads.zzbpf
        public final void zza(Throwable th, PrintWriter printWriter) {
            th.printStackTrace(printWriter);
        }
    }

    public static void zze(Throwable th) {
        zzfkn.zze(th);
    }

    public static void zza(Throwable th, PrintWriter printWriter) {
        zzfkn.zza(th, printWriter);
    }

    private static Integer zzake() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(System.err);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0068  */
    static {
        /*
        // Method dump skipped, instructions count: 111
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbpe.<clinit>():void");
    }
}
