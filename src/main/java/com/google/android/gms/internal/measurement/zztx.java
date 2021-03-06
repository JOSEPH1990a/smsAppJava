package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuo;
import java.io.IOException;
import java.util.List;
import java.util.Map;

final class zztx implements zzxy {
    private final zztv zzbtw;

    public static zztx zza(zztv zztv) {
        if (zztv.zzbun != null) {
            return zztv.zzbun;
        }
        return new zztx(zztv);
    }

    private zztx(zztv zztv) {
        this.zzbtw = (zztv) zzuq.zza(zztv, "output");
        this.zzbtw.zzbun = this;
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final int zzvm() {
        return zzuo.zze.zzbyv;
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzn(int i, int i2) throws IOException {
        this.zzbtw.zzg(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzi(int i, long j) throws IOException {
        this.zzbtw.zza(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzj(int i, long j) throws IOException {
        this.zzbtw.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zza(int i, float f) throws IOException {
        this.zzbtw.zza(i, f);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zza(int i, double d) throws IOException {
        this.zzbtw.zza(i, d);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzo(int i, int i2) throws IOException {
        this.zzbtw.zzd(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zza(int i, long j) throws IOException {
        this.zzbtw.zza(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzd(int i, int i2) throws IOException {
        this.zzbtw.zzd(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzc(int i, long j) throws IOException {
        this.zzbtw.zzc(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzg(int i, int i2) throws IOException {
        this.zzbtw.zzg(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzb(int i, boolean z) throws IOException {
        this.zzbtw.zzb(i, z);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzb(int i, String str) throws IOException {
        this.zzbtw.zzb(i, str);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zza(int i, zzte zzte) throws IOException {
        this.zzbtw.zza(i, zzte);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zze(int i, int i2) throws IOException {
        this.zzbtw.zze(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzf(int i, int i2) throws IOException {
        this.zzbtw.zzf(i, i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzb(int i, long j) throws IOException {
        this.zzbtw.zzb(i, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zza(int i, Object obj, zzwl zzwl) throws IOException {
        this.zzbtw.zza(i, (zzvv) obj, zzwl);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzb(int i, Object obj, zzwl zzwl) throws IOException {
        zztv zztv = this.zzbtw;
        zztv.zzc(i, 3);
        zzwl.zza((zzvv) obj, zztv.zzbun);
        zztv.zzc(i, 4);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzbm(int i) throws IOException {
        this.zzbtw.zzc(i, 3);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzbn(int i) throws IOException {
        this.zzbtw.zzc(i, 4);
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zza(int i, Object obj) throws IOException {
        if (obj instanceof zzte) {
            this.zzbtw.zzb(i, (zzte) obj);
        } else {
            this.zzbtw.zzb(i, (zzvv) obj);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zza(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbtw.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzbe(list.get(i4).intValue());
            }
            this.zzbtw.zzba(i3);
            while (i2 < list.size()) {
                this.zzbtw.zzaz(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbtw.zzd(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzb(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbtw.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzbh(list.get(i4).intValue());
            }
            this.zzbtw.zzba(i3);
            while (i2 < list.size()) {
                this.zzbtw.zzbc(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbtw.zzg(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzc(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbtw.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzaw(list.get(i4).longValue());
            }
            this.zzbtw.zzba(i3);
            while (i2 < list.size()) {
                this.zzbtw.zzat(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbtw.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzd(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbtw.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzax(list.get(i4).longValue());
            }
            this.zzbtw.zzba(i3);
            while (i2 < list.size()) {
                this.zzbtw.zzat(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbtw.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zze(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbtw.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzaz(list.get(i4).longValue());
            }
            this.zzbtw.zzba(i3);
            while (i2 < list.size()) {
                this.zzbtw.zzav(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbtw.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzf(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbtw.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzb(list.get(i4).floatValue());
            }
            this.zzbtw.zzba(i3);
            while (i2 < list.size()) {
                this.zzbtw.zza(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbtw.zza(i, list.get(i2).floatValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzg(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbtw.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzc(list.get(i4).doubleValue());
            }
            this.zzbtw.zzba(i3);
            while (i2 < list.size()) {
                this.zzbtw.zzb(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbtw.zza(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzh(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbtw.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzbj(list.get(i4).intValue());
            }
            this.zzbtw.zzba(i3);
            while (i2 < list.size()) {
                this.zzbtw.zzaz(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbtw.zzd(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzi(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbtw.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzt(list.get(i4).booleanValue());
            }
            this.zzbtw.zzba(i3);
            while (i2 < list.size()) {
                this.zzbtw.zzs(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbtw.zzb(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zza(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzve) {
            zzve zzve = (zzve) list;
            while (i2 < list.size()) {
                Object zzbp = zzve.zzbp(i2);
                if (zzbp instanceof String) {
                    this.zzbtw.zzb(i, (String) zzbp);
                } else {
                    this.zzbtw.zza(i, (zzte) zzbp);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbtw.zzb(i, list.get(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzb(int i, List<zzte> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zzbtw.zza(i, list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzj(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbtw.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzbf(list.get(i4).intValue());
            }
            this.zzbtw.zzba(i3);
            while (i2 < list.size()) {
                this.zzbtw.zzba(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbtw.zze(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzk(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbtw.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzbi(list.get(i4).intValue());
            }
            this.zzbtw.zzba(i3);
            while (i2 < list.size()) {
                this.zzbtw.zzbc(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbtw.zzg(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzl(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbtw.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzba(list.get(i4).longValue());
            }
            this.zzbtw.zzba(i3);
            while (i2 < list.size()) {
                this.zzbtw.zzav(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbtw.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzm(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbtw.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzbg(list.get(i4).intValue());
            }
            this.zzbtw.zzba(i3);
            while (i2 < list.size()) {
                this.zzbtw.zzbb(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbtw.zzf(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzn(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzbtw.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zztv.zzay(list.get(i4).longValue());
            }
            this.zzbtw.zzba(i3);
            while (i2 < list.size()) {
                this.zzbtw.zzau(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzbtw.zzb(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zza(int i, List<?> list, zzwl zzwl) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, list.get(i2), zzwl);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final void zzb(int i, List<?> list, zzwl zzwl) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, list.get(i2), zzwl);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzxy
    public final <K, V> void zza(int i, zzvo<K, V> zzvo, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.zzbtw.zzc(i, 2);
            this.zzbtw.zzba(zzvn.zza(zzvo, entry.getKey(), entry.getValue()));
            zzvn.zza(this.zzbtw, zzvo, entry.getKey(), entry.getValue());
        }
    }
}
