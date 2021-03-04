package com.google.android.gms.internal.ads;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzbb;
import com.google.android.gms.common.util.PlatformVersion;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
public final class zzapl {
    public static zzazb zza(Context context, zza zza, zzaxg zzaxg, zzcu zzcu, @Nullable zzbgg zzbgg, zzalg zzalg, zzapm zzapm, zzaba zzaba) {
        zzazb zzazb;
        zzasm zzasm = zzaxg.zzehy;
        if (zzasm.zzdyd) {
            zzazb = new zzapr(context, zzaxg, zzalg, zzapm, zzaba, zzbgg);
        } else if (zzasm.zzckn || (zza instanceof zzbb)) {
            if (!zzasm.zzckn || !(zza instanceof zzbb)) {
                zzazb = new zzapo(zzaxg, zzapm);
            } else {
                zzazb = new zzapt(context, (zzbb) zza, zzaxg, zzcu, zzapm, zzaba);
            }
        } else if (!PlatformVersion.isAtLeastKitKat() || PlatformVersion.isAtLeastLollipop() || zzbgg == null || !zzbgg.zzadj().zzafb()) {
            zzazb = new zzapn(context, zzaxg, zzbgg, zzapm);
        } else {
            zzazb = new zzapq(context, zzaxg, zzbgg, zzapm);
        }
        String valueOf = String.valueOf(zzazb.getClass().getName());
        zzaxz.zzdn(valueOf.length() != 0 ? "AdRenderer: ".concat(valueOf) : new String("AdRenderer: "));
        zzazb.zzwa();
        return zzazb;
    }
}
