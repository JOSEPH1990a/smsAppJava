package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;

final class zzawj implements Runnable {
    private final /* synthetic */ Bitmap val$bitmap;
    private final /* synthetic */ zzawg zzege;

    zzawj(zzawg zzawg, Bitmap bitmap) {
        this.zzege = zzawg;
        this.val$bitmap = bitmap;
    }

    public final void run() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.val$bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
        synchronized (zzawg.zza(this.zzege)) {
            zzawg.zzb(this.zzege).zzgay = new zzbvs();
            zzawg.zzb(this.zzege).zzgay.zzgbs = byteArrayOutputStream.toByteArray();
            zzawg.zzb(this.zzege).zzgay.mimeType = "image/png";
            zzawg.zzb(this.zzege).zzgay.zzgar = 1;
        }
    }
}
