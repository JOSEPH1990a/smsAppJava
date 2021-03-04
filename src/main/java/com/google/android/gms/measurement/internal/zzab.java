package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

public final class zzab {
    final String name;
    private final String origin;
    final long timestamp;
    final long zzaht;
    final zzad zzahu;
    final String zztt;

    private zzab(zzbw zzbw, String str, String str2, String str3, long j, long j2, zzad zzad) {
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzad);
        this.zztt = str2;
        this.name = str3;
        this.origin = TextUtils.isEmpty(str) ? null : str;
        this.timestamp = j;
        this.zzaht = j2;
        long j3 = this.zzaht;
        if (j3 != 0 && j3 > this.timestamp) {
            zzbw.zzgt().zzjj().zze("Event created with reverse previous/current timestamps. appId, name", zzas.zzbw(str2), zzas.zzbw(str3));
        }
        this.zzahu = zzad;
    }

    zzab(zzbw zzbw, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzad zzad;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        this.zztt = str2;
        this.name = str3;
        this.origin = TextUtils.isEmpty(str) ? null : str;
        this.timestamp = j;
        this.zzaht = j2;
        long j3 = this.zzaht;
        if (j3 != 0 && j3 > this.timestamp) {
            zzbw.zzgt().zzjj().zzg("Event created with reverse previous/current timestamps. appId", zzas.zzbw(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            zzad = new zzad(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    zzbw.zzgt().zzjg().zzby("Param name can't be null");
                    it.remove();
                } else {
                    Object zzh = zzbw.zzgr().zzh(next, bundle2.get(next));
                    if (zzh == null) {
                        zzbw.zzgt().zzjj().zzg("Param value can't be null", zzbw.zzgq().zzbu(next));
                        it.remove();
                    } else {
                        zzbw.zzgr().zza(bundle2, next, zzh);
                    }
                }
            }
            zzad = new zzad(bundle2);
        }
        this.zzahu = zzad;
    }

    /* access modifiers changed from: package-private */
    public final zzab zza(zzbw zzbw, long j) {
        return new zzab(zzbw, this.origin, this.zztt, this.name, this.timestamp, j, this.zzahu);
    }

    public final String toString() {
        String str = this.zztt;
        String str2 = this.name;
        String valueOf = String.valueOf(this.zzahu);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33 + String.valueOf(str2).length() + String.valueOf(valueOf).length());
        sb.append("Event{appId='");
        sb.append(str);
        sb.append("', name='");
        sb.append(str2);
        sb.append("', params=");
        sb.append(valueOf);
        sb.append('}');
        return sb.toString();
    }
}
