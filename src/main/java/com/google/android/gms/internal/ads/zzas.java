package com.google.android.gms.internal.ads;

import android.support.annotation.VisibleForTesting;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

public final class zzas extends zzai {
    private final zzau zzci;
    private final SSLSocketFactory zzcj;

    public zzas() {
        this(null);
    }

    private zzas(zzau zzau) {
        this(null, null);
    }

    private zzas(zzau zzau, SSLSocketFactory sSLSocketFactory) {
        this.zzci = null;
        this.zzcj = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x0128  */
    @Override // com.google.android.gms.internal.ads.zzai
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzaq zza(com.google.android.gms.internal.ads.zzr<?> r7, java.util.Map<java.lang.String, java.lang.String> r8) throws java.io.IOException, com.google.android.gms.internal.ads.zza {
        /*
        // Method dump skipped, instructions count: 324
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzas.zza(com.google.android.gms.internal.ads.zzr, java.util.Map):com.google.android.gms.internal.ads.zzaq");
    }

    @VisibleForTesting
    private static List<zzl> zza(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                for (String str : entry.getValue()) {
                    arrayList.add(new zzl(entry.getKey(), str));
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static InputStream zza(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    private static void zza(HttpURLConnection httpURLConnection, zzr<?> zzr) throws IOException, zza {
        byte[] zzh = zzr.zzh();
        if (zzh != null) {
            httpURLConnection.setDoOutput(true);
            if (!httpURLConnection.getRequestProperties().containsKey("Content-Type")) {
                String valueOf = String.valueOf("UTF-8");
                httpURLConnection.setRequestProperty("Content-Type", valueOf.length() != 0 ? "application/x-www-form-urlencoded; charset=".concat(valueOf) : new String("application/x-www-form-urlencoded; charset="));
            }
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(zzh);
            dataOutputStream.close();
        }
    }
}
