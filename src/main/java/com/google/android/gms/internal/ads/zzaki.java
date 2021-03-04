package com.google.android.gms.internal.ads;

/* access modifiers changed from: package-private */
public final class zzaki implements zzbco {
    private final /* synthetic */ zzaji zzdkk;
    private final /* synthetic */ zzbcl zzdkm;

    zzaki(zzakg zzakg, zzbcl zzbcl, zzaji zzaji) {
        this.zzdkm = zzbcl;
        this.zzdkk = zzaji;
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void run() {
        this.zzdkm.setException(new zzaju("Unable to obtain a JavascriptEngine."));
        this.zzdkk.release();
    }
}
