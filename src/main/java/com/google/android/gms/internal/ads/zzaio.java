package com.google.android.gms.internal.ads;

import fi.iki.elonen.NanoHTTPD;

final class zzaio implements Runnable {
    private final /* synthetic */ String zzdir;
    private final /* synthetic */ zzaik zzdis;

    zzaio(zzaik zzaik, String str) {
        this.zzdis = zzaik;
        this.zzdir = str;
    }

    public final void run() {
        zzaik.zza(this.zzdis).loadData(this.zzdir, NanoHTTPD.MIME_HTML, "UTF-8");
    }
}
