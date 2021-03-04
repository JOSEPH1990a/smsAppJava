package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Size;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfe;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzfu;
import com.google.android.gms.internal.measurement.zzfv;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzfz;
import com.google.android.gms.internal.measurement.zzuo;
import com.google.android.gms.internal.measurement.zzya;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* access modifiers changed from: package-private */
public final class zzdv extends zzfn {
    public zzdv(zzfo zzfo) {
        super(zzfo);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.measurement.internal.zzfn
    public final boolean zzgy() {
        return false;
    }

    @WorkerThread
    public final byte[] zzb(@NonNull zzag zzag, @Size(min = 1) String str) {
        zzfw zzfw;
        Bundle bundle;
        zzg zzg;
        zzfv zzfv;
        zzac zzac;
        long j;
        zzfx zzfx;
        zzaf();
        this.zzada.zzgf();
        Preconditions.checkNotNull(zzag);
        Preconditions.checkNotEmpty(str);
        if (!zzgv().zze(str, zzai.zzalf)) {
            zzgt().zzjn().zzg("Generating ScionPayload disabled. packageName", str);
            return new byte[0];
        } else if ("_iap".equals(zzag.name) || "_iapx".equals(zzag.name)) {
            zzfv zzfv2 = new zzfv();
            zzjt().beginTransaction();
            try {
                zzg zzbm = zzjt().zzbm(str);
                if (zzbm == null) {
                    zzgt().zzjn().zzg("Log and bundle not available. package_name", str);
                    return new byte[0];
                } else if (!zzbm.isMeasurementEnabled()) {
                    zzgt().zzjn().zzg("Log and bundle disabled. package_name", str);
                    byte[] bArr = new byte[0];
                    zzjt().endTransaction();
                    return bArr;
                } else {
                    zzfw zzfw2 = new zzfw();
                    zzfv2.zzaxf = new zzfw[]{zzfw2};
                    zzfw2.zzaxh = 1;
                    zzfw2.zzaxp = "android";
                    zzfw2.zztt = zzbm.zzal();
                    zzfw2.zzafp = zzbm.zzhg();
                    zzfw2.zzts = zzbm.zzak();
                    long zzhf = zzbm.zzhf();
                    zzfw2.zzayb = zzhf == -2147483648L ? null : Integer.valueOf((int) zzhf);
                    zzfw2.zzaxt = Long.valueOf(zzbm.zzhh());
                    zzfw2.zzafi = zzbm.getGmpAppId();
                    if (TextUtils.isEmpty(zzfw2.zzafi)) {
                        zzfw2.zzawp = zzbm.zzhb();
                    }
                    zzfw2.zzaxx = Long.valueOf(zzbm.zzhi());
                    if (this.zzada.isEnabled() && zzq.zzie() && zzgv().zzas(zzfw2.zztt)) {
                        zzfw2.zzayh = null;
                    }
                    Pair<String, Boolean> zzbz = zzgu().zzbz(zzbm.zzal());
                    if (zzbm.zzhw() && zzbz != null && !TextUtils.isEmpty((CharSequence) zzbz.first)) {
                        try {
                            zzfw2.zzaxv = zzr((String) zzbz.first, Long.toString(zzag.zzaig));
                            zzfw2.zzaxw = (Boolean) zzbz.second;
                        } catch (SecurityException e) {
                            zzgt().zzjn().zzg("Resettable device id encryption failed", e.getMessage());
                            byte[] bArr2 = new byte[0];
                            zzjt().endTransaction();
                            return bArr2;
                        }
                    }
                    zzgp().zzcl();
                    zzfw2.zzaxr = Build.MODEL;
                    zzgp().zzcl();
                    zzfw2.zzaxq = Build.VERSION.RELEASE;
                    zzfw2.zzaxs = Integer.valueOf((int) zzgp().zziw());
                    zzfw2.zzahr = zzgp().zzix();
                    try {
                        zzfw2.zzafh = zzr(zzbm.getAppInstanceId(), Long.toString(zzag.zzaig));
                        zzfw2.zzafk = zzbm.getFirebaseInstanceId();
                        String str2 = zzfw2.zztt;
                        List<zzfx> zzbl = zzjt().zzbl(str2);
                        if (zzgv().zzau(str)) {
                            Iterator<zzfx> it = zzbl.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    zzfx = null;
                                    break;
                                }
                                zzfx = it.next();
                                if ("_lte".equals(zzfx.name)) {
                                    break;
                                }
                            }
                            if (zzfx == null || zzfx.value == null) {
                                zzfx zzfx2 = new zzfx(str2, "auto", "_lte", zzbx().currentTimeMillis(), 0L);
                                zzbl.add(zzfx2);
                                zzjt().zza(zzfx2);
                            }
                        }
                        zzfz[] zzfzArr = new zzfz[zzbl.size()];
                        for (int i = 0; i < zzbl.size(); i++) {
                            zzfz zzfz = new zzfz();
                            zzfzArr[i] = zzfz;
                            zzfz.name = zzbl.get(i).name;
                            zzfz.zzayu = Long.valueOf(zzbl.get(i).zzauk);
                            zzjr().zza(zzfz, zzbl.get(i).value);
                        }
                        zzfw2.zzaxj = zzfzArr;
                        Bundle zziy = zzag.zzahu.zziy();
                        zziy.putLong("_c", 1);
                        zzgt().zzjn().zzby("Marking in-app purchase as real-time");
                        zziy.putLong("_r", 1);
                        zziy.putString("_o", zzag.origin);
                        if (zzgr().zzcz(zzfw2.zztt)) {
                            zzgr().zza(zziy, "_dbg", (Object) 1L);
                            zzgr().zza(zziy, "_r", (Object) 1L);
                        }
                        zzac zzg2 = zzjt().zzg(str, zzag.name);
                        if (zzg2 == null) {
                            bundle = zziy;
                            zzfw = zzfw2;
                            zzfv = zzfv2;
                            zzg = zzbm;
                            zzac = new zzac(str, zzag.name, 0, 0, zzag.zzaig, 0, null, null, null, null);
                            j = 0;
                        } else {
                            bundle = zziy;
                            zzfw = zzfw2;
                            zzfv = zzfv2;
                            zzg = zzbm;
                            j = zzg2.zzahx;
                            zzac = zzg2.zzae(zzag.zzaig);
                        }
                        zzjt().zza(zzac);
                        zzab zzab = new zzab(this.zzada, zzag.origin, str, zzag.name, zzag.zzaig, j, bundle);
                        zzft zzft = new zzft();
                        zzfw.zzaxi = new zzft[]{zzft};
                        zzft.zzaxb = Long.valueOf(zzab.timestamp);
                        zzft.name = zzab.name;
                        zzft.zzaxc = Long.valueOf(zzab.zzaht);
                        zzft.zzaxa = new zzfu[zzab.zzahu.size()];
                        Iterator<String> it2 = zzab.zzahu.iterator();
                        int i2 = 0;
                        while (it2.hasNext()) {
                            String next = it2.next();
                            zzfu zzfu = new zzfu();
                            zzft.zzaxa[i2] = zzfu;
                            zzfu.name = next;
                            zzjr().zza(zzfu, zzab.zzahu.get(next));
                            i2++;
                        }
                        zzfw.zzayk = (zzfe.zzb) ((zzuo) zzfe.zzb.zzmp().zzb((zzfe.zza) ((zzuo) zzfe.zza.zzmn().zzan(zzac.zzahv).zzda(zzag.name).zzwo())).zzwo());
                        zzfw.zzaya = zzjs().zza(zzg.zzal(), (zzft[]) null, zzfw.zzaxj);
                        zzfw.zzaxl = zzft.zzaxb;
                        zzfw.zzaxm = zzft.zzaxb;
                        long zzhe = zzg.zzhe();
                        zzfw.zzaxo = zzhe != 0 ? Long.valueOf(zzhe) : null;
                        long zzhd = zzg.zzhd();
                        if (zzhd != 0) {
                            zzhe = zzhd;
                        }
                        zzfw.zzaxn = zzhe != 0 ? Long.valueOf(zzhe) : null;
                        zzg.zzhm();
                        zzfw.zzaxy = Integer.valueOf((int) zzg.zzhj());
                        zzfw.zzaxu = Long.valueOf(zzgv().zzhh());
                        zzfw.zzaxk = Long.valueOf(zzbx().currentTimeMillis());
                        zzfw.zzaxz = Boolean.TRUE;
                        zzg.zzo(zzfw.zzaxl.longValue());
                        zzg.zzp(zzfw.zzaxm.longValue());
                        zzjt().zza(zzg);
                        zzjt().setTransactionSuccessful();
                        zzjt().endTransaction();
                        try {
                            byte[] bArr3 = new byte[zzfv.zzvx()];
                            zzya zzk = zzya.zzk(bArr3, 0, bArr3.length);
                            zzfv.zza(zzk);
                            zzk.zzza();
                            return zzjr().zzb(bArr3);
                        } catch (IOException e2) {
                            zzgt().zzjg().zze("Data loss. Failed to bundle and serialize. appId", zzas.zzbw(str), e2);
                            return null;
                        }
                    } catch (SecurityException e3) {
                        zzgt().zzjn().zzg("app instance id encryption failed", e3.getMessage());
                        byte[] bArr4 = new byte[0];
                        zzjt().endTransaction();
                        return bArr4;
                    }
                }
            } finally {
                zzjt().endTransaction();
            }
        } else {
            zzgt().zzjn().zze("Generating a payload for this event is not available. package_name, event_name", str, zzag.name);
            return null;
        }
    }

    private static String zzr(String str, String str2) {
        throw new SecurityException("This implementation should not be used.");
    }
}
