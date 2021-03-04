package com.google.android.gms.measurement.internal;

/* access modifiers changed from: package-private */
public final class zzb implements Runnable {
    private final /* synthetic */ String zzaee;
    private final /* synthetic */ long zzafe;
    private final /* synthetic */ zza zzaff;

    zzb(zza zza, String str, long j) {
        this.zzaff = zza;
        this.zzaee = str;
        this.zzafe = j;
    }

    public final void run() {
        this.zzaff.zza((zza) this.zzaee, (String) this.zzafe);
    }
}
