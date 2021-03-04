package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* access modifiers changed from: package-private */
public final class zznc implements zzpm<Long> {
    private zznc() {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzpm
    public final /* synthetic */ Long zzb(Uri uri, InputStream inputStream) throws IOException {
        return Long.valueOf(zzqe.zzal(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
    }

    /* synthetic */ zznc(zzmv zzmv) {
        this();
    }
}
