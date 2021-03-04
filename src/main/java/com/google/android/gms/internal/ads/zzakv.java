package com.google.android.gms.internal.ads;

final class zzakv implements Runnable {
    private final /* synthetic */ zzakt zzdmx;
    private final /* synthetic */ zzaku zzdmy;

    zzakv(zzaku zzaku, zzakt zzakt) {
        this.zzdmy = zzaku;
        this.zzdmx = zzakt;
    }

    public final void run() {
        synchronized (zzaku.zza(this.zzdmy)) {
            if (zzaku.zzb(this.zzdmy) == -2) {
                zzaku.zza(this.zzdmy, zzaku.zzc(this.zzdmy));
                if (zzaku.zzd(this.zzdmy) == null) {
                    this.zzdmy.zzco(4);
                } else if (!zzaku.zze(this.zzdmy) || zzaku.zza(this.zzdmy, 1)) {
                    this.zzdmx.zza(this.zzdmy);
                    zzaku.zza(this.zzdmy, this.zzdmx);
                } else {
                    String zzf = zzaku.zzf(this.zzdmy);
                    StringBuilder sb = new StringBuilder(String.valueOf(zzf).length() + 56);
                    sb.append("Ignoring adapter ");
                    sb.append(zzf);
                    sb.append(" as delayed impression is not supported");
                    zzaxz.zzeo(sb.toString());
                    this.zzdmy.zzco(2);
                }
            }
        }
    }
}
