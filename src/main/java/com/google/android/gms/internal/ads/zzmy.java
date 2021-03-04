package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/* access modifiers changed from: package-private */
public final class zzmy implements zzpm<Long> {
    private zzmy() {
    }

    private static Long zza(Uri uri, InputStream inputStream) throws IOException {
        String readLine = new BufferedReader(new InputStreamReader(inputStream)).readLine();
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return Long.valueOf(simpleDateFormat.parse(readLine).getTime());
        } catch (ParseException e) {
            throw new zzfx(e);
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzpm
    public final /* synthetic */ Long zzb(Uri uri, InputStream inputStream) throws IOException {
        return zza(uri, inputStream);
    }

    /* synthetic */ zzmy(zzmv zzmv) {
        this();
    }
}
