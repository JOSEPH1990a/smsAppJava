package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.atomic.AtomicReference;

public final class zzaq extends zzcs {
    private static final AtomicReference<String[]> zzalp = new AtomicReference<>();
    private static final AtomicReference<String[]> zzalq = new AtomicReference<>();
    private static final AtomicReference<String[]> zzalr = new AtomicReference<>();

    zzaq(zzbw zzbw) {
        super(zzbw);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.measurement.internal.zzcs
    public final boolean zzgy() {
        return false;
    }

    private final boolean zzjf() {
        zzgw();
        return this.zzada.zzkn() && this.zzada.zzgt().isLoggable(3);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zzbt(String str) {
        if (str == null) {
            return null;
        }
        if (!zzjf()) {
            return str;
        }
        return zza(str, zzcu.zzaqr, zzcu.zzaqq, zzalp);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zzbu(String str) {
        if (str == null) {
            return null;
        }
        if (!zzjf()) {
            return str;
        }
        return zza(str, zzcv.zzaqt, zzcv.zzaqs, zzalq);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zzbv(String str) {
        if (str == null) {
            return null;
        }
        if (!zzjf()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return zza(str, zzcw.zzaqv, zzcw.zzaqu, zzalr);
        }
        return "experiment_id" + "(" + str + ")";
    }

    @Nullable
    private static String zza(String str, String[] strArr, String[] strArr2, AtomicReference<String[]> atomicReference) {
        String str2;
        Preconditions.checkNotNull(strArr);
        Preconditions.checkNotNull(strArr2);
        Preconditions.checkNotNull(atomicReference);
        Preconditions.checkArgument(strArr.length == strArr2.length);
        for (int i = 0; i < strArr.length; i++) {
            if (zzfy.zzv(str, strArr[i])) {
                synchronized (atomicReference) {
                    String[] strArr3 = atomicReference.get();
                    if (strArr3 == null) {
                        strArr3 = new String[strArr2.length];
                        atomicReference.set(strArr3);
                    }
                    if (strArr3[i] == null) {
                        strArr3[i] = strArr2[i] + "(" + strArr[i] + ")";
                    }
                    str2 = strArr3[i];
                }
                return str2;
            }
        }
        return str;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zzb(zzag zzag) {
        if (zzag == null) {
            return null;
        }
        if (!zzjf()) {
            return zzag.toString();
        }
        return "origin=" + zzag.origin + ",name=" + zzbt(zzag.name) + ",params=" + zzb(zzag.zzahu);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zza(zzab zzab) {
        if (zzab == null) {
            return null;
        }
        if (!zzjf()) {
            return zzab.toString();
        }
        return "Event{appId='" + zzab.zztt + "', name='" + zzbt(zzab.name) + "', params=" + zzb(zzab.zzahu) + "}";
    }

    @Nullable
    private final String zzb(zzad zzad) {
        if (zzad == null) {
            return null;
        }
        if (!zzjf()) {
            return zzad.toString();
        }
        return zzd(zzad.zziy());
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String zzd(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!zzjf()) {
            return bundle.toString();
        }
        StringBuilder sb = new StringBuilder();
        for (String str : bundle.keySet()) {
            if (sb.length() != 0) {
                sb.append(", ");
            } else {
                sb.append("Bundle[{");
            }
            sb.append(zzbu(str));
            sb.append("=");
            sb.append(bundle.get(str));
        }
        sb.append("}]");
        return sb.toString();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzgf() {
        super.zzgf();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzgg() {
        super.zzgg();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzgh() {
        super.zzgh();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ void zzaf() {
        super.zzaf();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzaa zzgp() {
        return super.zzgp();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ Clock zzbx() {
        return super.zzbx();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzaq zzgq() {
        return super.zzgq();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzfy zzgr() {
        return super.zzgr();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ zzbr zzgs() {
        return super.zzgs();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ zzas zzgt() {
        return super.zzgt();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzbd zzgu() {
        return super.zzgu();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzq zzgv() {
        return super.zzgv();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ zzn zzgw() {
        return super.zzgw();
    }
}
