package com.google.firebase.iid;

/* access modifiers changed from: package-private */
public final /* synthetic */ class zzag implements Runnable {
    private final zzad zzcc;

    zzag(zzad zzad) {
        this.zzcc = zzad;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
        if (android.util.Log.isLoggable("MessengerIpcClient", 3) == false) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0042, code lost:
        r4 = java.lang.String.valueOf(r1);
        r6 = new java.lang.StringBuilder(java.lang.String.valueOf(r4).length() + 8);
        r6.append("Sending ");
        r6.append(r4);
        android.util.Log.d("MessengerIpcClient", r6.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0066, code lost:
        r3 = r0.zzcb.zzx;
        r4 = r0.zzbx;
        r5 = android.os.Message.obtain();
        r5.what = r1.what;
        r5.arg1 = r1.zzcf;
        r5.replyTo = r4;
        r4 = new android.os.Bundle();
        r4.putBoolean("oneWay", r1.zzab());
        r4.putString("pkg", r3.getPackageName());
        r4.putBundle("data", r1.zzch);
        r5.setData(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r0.zzby.send(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00a4, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a5, code lost:
        r0.zza(2, r1.getMessage());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        // Method dump skipped, instructions count: 178
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzag.run():void");
    }
}
