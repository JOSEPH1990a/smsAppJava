package com.google.android.gms.measurement.internal;

final class zzfl extends zzy {
    private final /* synthetic */ zzfo zzasx;
    private final /* synthetic */ zzfk zzatf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfl(zzfk zzfk, zzct zzct, zzfo zzfo) {
        super(zzct);
        this.zzatf = zzfk;
        this.zzasx = zzfo;
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public final void run() {
        this.zzatf.cancel();
        this.zzatf.zzgt().zzjo().zzby("Starting upload from DelayedRunnable");
        this.zzasx.zzlz();
    }
}
