package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzaan;
import com.google.android.gms.internal.ads.zzaba;
import com.google.android.gms.internal.ads.zzadx;
import com.google.android.gms.internal.ads.zzaeh;
import com.google.android.gms.internal.ads.zzaks;
import com.google.android.gms.internal.ads.zzakz;
import com.google.android.gms.internal.ads.zzalg;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzarn;
import com.google.android.gms.internal.ads.zzasj;
import com.google.android.gms.internal.ads.zzatd;
import com.google.android.gms.internal.ads.zzaxf;
import com.google.android.gms.internal.ads.zzaxj;
import com.google.android.gms.internal.ads.zzaxv;
import com.google.android.gms.internal.ads.zzaxz;
import com.google.android.gms.internal.ads.zzayh;
import com.google.android.gms.internal.ads.zzayp;
import com.google.android.gms.internal.ads.zzbbi;
import com.google.android.gms.internal.ads.zzbcg;
import com.google.android.gms.internal.ads.zzbgg;
import com.google.android.gms.internal.ads.zzsx;
import com.google.android.gms.internal.ads.zzuo;
import com.google.android.gms.internal.ads.zzur;
import com.google.android.gms.internal.ads.zzwb;
import com.google.android.gms.internal.ads.zzwf;
import com.google.android.gms.internal.ads.zzwu;
import java.util.concurrent.Executor;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
@ParametersAreNonnullByDefault
public abstract class zzc extends zza implements zzn, zzbo, zzaks {
    protected final zzalg zzbma;
    private transient boolean zzbmb;

    public zzc(Context context, zzwf zzwf, String str, zzalg zzalg, zzbbi zzbbi, zzv zzv) {
        this(new zzbw(context, zzwf, str, zzbbi), zzalg, null, zzv);
    }

    @VisibleForTesting
    private zzc(zzbw zzbw, zzalg zzalg, @Nullable zzbl zzbl, zzv zzv) {
        super(zzbw, null, zzv);
        this.zzbma = zzalg;
        this.zzbmb = false;
    }

    public final boolean zza(zzwb zzwb, zzaba zzaba, int i) {
        Bundle bundle;
        zzaxj zzaxj;
        if (!zziu()) {
            return false;
        }
        zzbv.zzlf();
        zzsx zzzo = zzbv.zzlj().zzyq().zzzo();
        String str = null;
        if (zzzo == null) {
            bundle = null;
        } else {
            bundle = zzayh.zza(zzzo);
        }
        this.zzblr.cancel();
        this.zzbls.zzbtw = 0;
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcuz)).booleanValue()) {
            zzaxj = zzbv.zzlj().zzyq().zzzi();
            zzad zzln = zzbv.zzln();
            Context context = this.zzbls.zzsp;
            zzbbi zzbbi = this.zzbls.zzbsp;
            String str2 = this.zzbls.zzbsn;
            if (zzaxj != null) {
                str = zzaxj.zzyf();
            }
            zzln.zza(context, zzbbi, false, zzaxj, str, str2, null);
        } else {
            zzaxj = null;
        }
        return zza(zza(zzwb, bundle, zzaxj, i), zzaba);
    }

    public final boolean zza(zzasj zzasj, zzaba zzaba) {
        zzaxv zzaxv;
        this.zzbln = zzaba;
        zzaba.zzg("seq_num", zzasj.zzdwj);
        zzaba.zzg("request_id", zzasj.zzdws);
        zzaba.zzg("session_id", zzasj.zzclm);
        if (zzasj.zzdwh != null) {
            zzaba.zzg("app_version", String.valueOf(zzasj.zzdwh.versionCode));
        }
        zzbw zzbw = this.zzbls;
        zzbv.zzlb();
        Context context = this.zzbls.zzsp;
        zzur zzur = this.zzbly.zzbmv;
        if (zzasj.zzdwg.extras.getBundle("sdk_less_server_data") != null) {
            zzaxv = new zzatd(context, zzasj, this, zzur);
        } else {
            zzaxv = new zzarn(context, zzasj, this, zzur);
        }
        zzaxv.zzyz();
        zzbw.zzbsr = zzaxv;
        return true;
    }

    @Override // com.google.android.gms.ads.internal.zza
    public boolean zza(zzwb zzwb, zzaba zzaba) {
        return zza(zzwb, zzaba, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzapm, com.google.android.gms.ads.internal.zza
    public final void zzb(zzaxf zzaxf) {
        super.zzb(zzaxf);
        if (zzaxf.zzdnb != null) {
            zzaxz.zzdn("Disable the debug gesture detector on the mediation ad frame.");
            if (this.zzbls.zzbsq != null) {
                this.zzbls.zzbsq.zzmp();
            }
            zzaxz.zzdn("Pinging network fill URLs.");
            zzbv.zzlz();
            zzakz.zza(this.zzbls.zzsp, this.zzbls.zzbsp.zzdp, zzaxf, this.zzbls.zzbsn, false, zzaxf.zzdnb.zzdld);
            if (!(zzaxf.zzehj == null || zzaxf.zzehj.zzdlu == null || zzaxf.zzehj.zzdlu.size() <= 0)) {
                zzaxz.zzdn("Pinging urls remotely");
                zzbv.zzlf().zza(this.zzbls.zzsp, zzaxf.zzehj.zzdlu);
            }
        } else {
            zzaxz.zzdn("Enable the debug gesture detector on the admob ad frame.");
            if (this.zzbls.zzbsq != null) {
                this.zzbls.zzbsq.zzmo();
            }
        }
        if (zzaxf.errorCode == 3 && zzaxf.zzehj != null && zzaxf.zzehj.zzdlt != null) {
            zzaxz.zzdn("Pinging no fill URLs.");
            zzbv.zzlz();
            zzakz.zza(this.zzbls.zzsp, this.zzbls.zzbsp.zzdp, zzaxf, this.zzbls.zzbsn, false, zzaxf.zzehj.zzdlt);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public boolean zza(@Nullable zzaxf zzaxf, zzaxf zzaxf2) {
        int i;
        if (!(zzaxf == null || zzaxf.zzdne == null)) {
            zzaxf.zzdne.zza((zzaks) null);
        }
        if (zzaxf2.zzdne != null) {
            zzaxf2.zzdne.zza(this);
        }
        int i2 = 0;
        if (zzaxf2.zzehj != null) {
            i2 = zzaxf2.zzehj.zzdmg;
            i = zzaxf2.zzehj.zzdmh;
        } else {
            i = 0;
        }
        this.zzbls.zzbtu.zzl(i2, i);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.ads.internal.zza
    public void onAdClicked() {
        if (this.zzbls.zzbsu == null) {
            zzaxz.zzeo("Ad state was null when trying to ping click URLs.");
            return;
        }
        if (!(this.zzbls.zzbsu.zzehj == null || this.zzbls.zzbsu.zzehj.zzdlq == null)) {
            zzbv.zzlz();
            zzakz.zza(this.zzbls.zzsp, this.zzbls.zzbsp.zzdp, this.zzbls.zzbsu, this.zzbls.zzbsn, false, zza(this.zzbls.zzbsu.zzehj.zzdlq, this.zzbls.zzbsu.zzdzf));
        }
        if (!(this.zzbls.zzbsu.zzdnb == null || this.zzbls.zzbsu.zzdnb.zzdkz == null)) {
            zzbv.zzlz();
            zzakz.zza(this.zzbls.zzsp, this.zzbls.zzbsp.zzdp, this.zzbls.zzbsu, this.zzbls.zzbsn, false, this.zzbls.zzbsu.zzdnb.zzdkz);
        }
        super.onAdClicked();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.ads.internal.zza
    public final boolean zza(zzaxf zzaxf) {
        zzwb zzwb;
        boolean z = false;
        if (this.zzblt != null) {
            zzwb = this.zzblt;
            this.zzblt = null;
        } else {
            zzwb = zzaxf.zzdwg;
            if (zzwb.extras != null) {
                z = zzwb.extras.getBoolean("_noRefresh", false);
            }
        }
        return zza(zzwb, zzaxf, z);
    }

    /* access modifiers changed from: protected */
    public boolean zza(zzwb zzwb, zzaxf zzaxf, boolean z) {
        if (!z && this.zzbls.zzmj()) {
            if (zzaxf.zzdlx > 0) {
                this.zzblr.zza(zzwb, zzaxf.zzdlx);
            } else if (zzaxf.zzehj != null && zzaxf.zzehj.zzdlx > 0) {
                this.zzblr.zza(zzwb, zzaxf.zzehj.zzdlx);
            } else if (!zzaxf.zzdyd && zzaxf.errorCode == 2) {
                this.zzblr.zzg(zzwb);
            }
        }
        return this.zzblr.zzkv();
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.ads.zzxl
    public void pause() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        if (!(this.zzbls.zzbsu == null || this.zzbls.zzbsu.zzdrv == null || !this.zzbls.zzmj())) {
            zzbv.zzlh();
            zzayp.zzi(this.zzbls.zzbsu.zzdrv);
        }
        if (!(this.zzbls.zzbsu == null || this.zzbls.zzbsu.zzdnc == null)) {
            try {
                this.zzbls.zzbsu.zzdnc.pause();
            } catch (RemoteException unused) {
                zzaxz.zzeo("Could not pause mediation adapter.");
            }
        }
        this.zzblu.zzj(this.zzbls.zzbsu);
        this.zzblr.pause();
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.ads.zzxl
    public void resume() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        zzbgg zzbgg = (this.zzbls.zzbsu == null || this.zzbls.zzbsu.zzdrv == null) ? null : this.zzbls.zzbsu.zzdrv;
        if (zzbgg != null && this.zzbls.zzmj()) {
            zzbv.zzlh();
            zzayp.zzj(this.zzbls.zzbsu.zzdrv);
        }
        if (!(this.zzbls.zzbsu == null || this.zzbls.zzbsu.zzdnc == null)) {
            try {
                this.zzbls.zzbsu.zzdnc.resume();
            } catch (RemoteException unused) {
                zzaxz.zzeo("Could not resume mediation adapter.");
            }
        }
        if (zzbgg == null || !zzbgg.zzadt()) {
            this.zzblr.resume();
        }
        this.zzblu.zzk(this.zzbls.zzbsu);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public final boolean zzc(zzwb zzwb) {
        return super.zzc(zzwb) && !this.zzbmb;
    }

    /* access modifiers changed from: protected */
    public boolean zziu() {
        zzbv.zzlf();
        if (zzayh.zzn(this.zzbls.zzsp, "android.permission.INTERNET")) {
            zzbv.zzlf();
            return zzayh.zzah(this.zzbls.zzsp);
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzn
    public void zziv() {
        this.zzbmb = false;
        zzii();
        this.zzbls.zzbsw.zzxx();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzn
    public void zziw() {
        this.zzbmb = true;
        zzik();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzn
    public final void onPause() {
        this.zzblu.zzj(this.zzbls.zzbsu);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzn
    public final void onResume() {
        this.zzblu.zzk(this.zzbls.zzbsu);
    }

    @Override // com.google.android.gms.internal.ads.zzaks
    public void zzix() {
        zzaxz.zzeo("Mediated ad does not support onVideoEnd callback");
    }

    @Override // com.google.android.gms.internal.ads.zzaks
    public void zziy() {
        onAdClicked();
    }

    @Override // com.google.android.gms.internal.ads.zzaks
    public final void zziz() {
        zziv();
    }

    @Override // com.google.android.gms.internal.ads.zzaks
    public final void zzja() {
        zzij();
    }

    @Override // com.google.android.gms.internal.ads.zzaks
    public final void zzjb() {
        zziw();
    }

    @Override // com.google.android.gms.internal.ads.zzaks
    public final void zzjc() {
        if (this.zzbls.zzbsu != null) {
            String str = this.zzbls.zzbsu.zzdnd;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 74);
            sb.append("Mediation adapter ");
            sb.append(str);
            sb.append(" refreshed, but mediation adapters should never refresh.");
            zzaxz.zzeo(sb.toString());
        }
        zza(this.zzbls.zzbsu, true);
        zzb(this.zzbls.zzbsu, true);
        zzil();
    }

    @Override // com.google.android.gms.internal.ads.zzaks
    public void zzjd() {
        recordImpression();
    }

    @Override // com.google.android.gms.internal.ads.zzaks
    public final void zzd(String str, String str2) {
        onAppEvent(str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzaks
    public final void zza(zzadx zzadx, String str) {
        String str2;
        zzaeh zzaeh = null;
        if (zzadx != null) {
            try {
                str2 = zzadx.getCustomTemplateId();
            } catch (RemoteException e) {
                zzaxz.zzc("Unable to call onCustomClick.", e);
                return;
            }
        } else {
            str2 = null;
        }
        if (!(this.zzbls.zzbtg == null || str2 == null)) {
            zzaeh = this.zzbls.zzbtg.get(str2);
        }
        if (zzaeh == null) {
            zzaxz.zzeo("Mediation adapter invoked onCustomClick but no listeners were set.");
        } else {
            zzaeh.zzb(zzadx, str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x018d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.ads.zzasj zza(com.google.android.gms.internal.ads.zzwb r59, android.os.Bundle r60, com.google.android.gms.internal.ads.zzaxj r61, int r62) {
        /*
        // Method dump skipped, instructions count: 746
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzc.zza(com.google.android.gms.internal.ads.zzwb, android.os.Bundle, com.google.android.gms.internal.ads.zzaxj, int):com.google.android.gms.internal.ads.zzasj");
    }

    public final void recordImpression() {
        zza(this.zzbls.zzbsu, false);
    }

    /* access modifiers changed from: protected */
    public void zza(@Nullable zzaxf zzaxf, boolean z) {
        if (zzaxf == null) {
            zzaxz.zzeo("Ad state was null when trying to ping impression URLs.");
            return;
        }
        if (zzaxf == null) {
            zzaxz.zzeo("Ad state was null when trying to ping impression URLs.");
        } else {
            zzaxz.zzdn("Pinging Impression URLs.");
            if (this.zzbls.zzbsw != null) {
                this.zzbls.zzbsw.zzxv();
            }
            zzaxf.zzehw.zza(zzuo.zza.zzb.AD_IMPRESSION);
            if (zzaxf.zzdlr != null && !zzaxf.zzehq) {
                zzbv.zzlf();
                zzayh.zza(this.zzbls.zzsp, this.zzbls.zzbsp.zzdp, zza(zzaxf.zzdlr, zzaxf.zzdzf));
                zzaxf.zzehq = true;
            }
        }
        if (!zzaxf.zzehs || z) {
            if (!(zzaxf.zzehj == null || zzaxf.zzehj.zzdlr == null)) {
                zzbv.zzlz();
                zzakz.zza(this.zzbls.zzsp, this.zzbls.zzbsp.zzdp, zzaxf, this.zzbls.zzbsn, z, zza(zzaxf.zzehj.zzdlr, zzaxf.zzdzf));
            }
            if (!(zzaxf.zzdnb == null || zzaxf.zzdnb.zzdla == null)) {
                zzbv.zzlz();
                zzakz.zza(this.zzbls.zzsp, this.zzbls.zzbsp.zzdp, zzaxf, this.zzbls.zzbsn, z, zzaxf.zzdnb.zzdla);
            }
            zzaxf.zzehs = true;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzb(@Nullable zzaxf zzaxf, boolean z) {
        if (zzaxf != null) {
            if (!(zzaxf == null || zzaxf.zzdls == null || zzaxf.zzehr)) {
                zzbv.zzlf();
                zzayh.zza(this.zzbls.zzsp, this.zzbls.zzbsp.zzdp, zzc(zzaxf.zzdls));
                zzaxf.zzehr = true;
            }
            if (!zzaxf.zzeht || z) {
                if (!(zzaxf.zzehj == null || zzaxf.zzehj.zzdls == null)) {
                    zzbv.zzlz();
                    zzakz.zza(this.zzbls.zzsp, this.zzbls.zzbsp.zzdp, zzaxf, this.zzbls.zzbsn, z, zzc(zzaxf.zzehj.zzdls));
                }
                if (!(zzaxf.zzdnb == null || zzaxf.zzdnb.zzdlb == null)) {
                    zzbv.zzlz();
                    zzakz.zza(this.zzbls.zzsp, this.zzbls.zzbsp.zzdp, zzaxf, this.zzbls.zzbsn, z, zzaxf.zzdnb.zzdlb);
                }
                zzaxf.zzeht = true;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    @Nullable
    public final String getMediationAdapterClassName() {
        if (this.zzbls.zzbsu == null) {
            return null;
        }
        return this.zzbls.zzbsu.zzdnd;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    @Nullable
    public final String zzje() {
        if (this.zzbls.zzbsu == null) {
            return null;
        }
        return zzc(this.zzbls.zzbsu);
    }

    @Nullable
    static String zzc(zzaxf zzaxf) {
        if (zzaxf == null) {
            return null;
        }
        String str = zzaxf.zzdnd;
        if (("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) && zzaxf.zzdnb != null) {
            try {
                return new JSONObject(zzaxf.zzdnb.zzdle).getString("class_name");
            } catch (NullPointerException | JSONException unused) {
            }
        }
        return str;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public void showInterstitial() {
        zzaxz.zzeo("showInterstitial is not supported for current ad type");
    }

    @Override // com.google.android.gms.ads.internal.zzbo
    public final void zzjf() {
        Executor executor = zzbcg.zzepo;
        zzbl zzbl = this.zzblr;
        zzbl.getClass();
        executor.execute(zzd.zza(zzbl));
    }

    @Override // com.google.android.gms.ads.internal.zzbo
    public final void zzjg() {
        Executor executor = zzbcg.zzepo;
        zzbl zzbl = this.zzblr;
        zzbl.getClass();
        executor.execute(zze.zza(zzbl));
    }
}
