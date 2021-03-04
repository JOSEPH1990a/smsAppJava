package com.google.android.gms.measurement.internal;

/* access modifiers changed from: package-private */
public final class zzek extends zzy {
    private final /* synthetic */ zzeb zzasi;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzek(zzeb zzeb, zzct zzct) {
        super(zzct);
        this.zzasi = zzeb;
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public final void run() {
        this.zzasi.zzgt().zzjj().zzby("Tasks have been queued for a long time");
    }
}
