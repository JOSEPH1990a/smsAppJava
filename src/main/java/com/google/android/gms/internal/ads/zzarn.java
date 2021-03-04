package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzuo;
import javax.annotation.concurrent.GuardedBy;

@zzark
public final class zzarn extends zzaxv implements zzasa {
    private final Context mContext;
    @VisibleForTesting
    private zzakr zzdmn;
    @VisibleForTesting
    private zzasi zzdnh;
    @VisibleForTesting
    private zzasm zzdsl;
    private Runnable zzdsm;
    private final Object zzdsn = new Object();
    private final zzarm zzdvp;
    private final zzasj zzdvq;
    private final zzum zzdvr;
    private final zzur zzdvs;
    @VisibleForTesting
    @GuardedBy("mCancelLock")
    private boolean zzdvt;
    @VisibleForTesting
    @GuardedBy("mCancelLock")
    private zzazb zzdvu;

    public zzarn(Context context, zzasj zzasj, zzarm zzarm, zzur zzur) {
        this.zzdvp = zzarm;
        this.mContext = context;
        this.zzdvq = zzasj;
        this.zzdvs = zzur;
        this.zzdvr = new zzum(this.zzdvs);
        this.zzdvr.zza(new zzaro(this));
        zzvq zzvq = new zzvq();
        zzvq.zzchy = Integer.valueOf(this.zzdvq.zzbsp.zzeou);
        zzvq.zzchz = Integer.valueOf(this.zzdvq.zzbsp.zzeov);
        zzvq.zzcia = Integer.valueOf(this.zzdvq.zzbsp.zzeow ? 0 : 2);
        this.zzdvr.zza(new zzarp(zzvq));
        if (this.zzdvq.zzdwh != null) {
            this.zzdvr.zza(new zzarq(this));
        }
        zzwf zzwf = this.zzdvq.zzbst;
        if (zzwf.zzckl && "interstitial_mb".equals(zzwf.zzckk)) {
            this.zzdvr.zza(zzarr.zzdvx);
        } else if (zzwf.zzckl && "reward_mb".equals(zzwf.zzckk)) {
            this.zzdvr.zza(zzars.zzdvx);
        } else if (zzwf.zzckn || zzwf.zzckl) {
            this.zzdvr.zza(zzaru.zzdvx);
        } else {
            this.zzdvr.zza(zzart.zzdvx);
        }
        this.zzdvr.zza(zzuo.zza.zzb.AD_REQUEST);
    }

    @Override // com.google.android.gms.internal.ads.zzaxv
    public final void zzki() {
        String string;
        zzaxz.zzdn("AdLoaderBackgroundTask started.");
        this.zzdsm = new zzarv(this);
        zzayh.zzelc.postDelayed(this.zzdsm, ((Long) zzwu.zzpz().zzd(zzaan.zzcte)).longValue());
        long elapsedRealtime = zzbv.zzlm().elapsedRealtime();
        if (this.zzdvq.zzdwg.extras == null || (string = this.zzdvq.zzdwg.extras.getString("_ad")) == null) {
            zzbcr zzbcr = new zzbcr();
            zzayf.zzc(new zzarw(this, zzbcr));
            this.zzdnh = new zzasi(this.zzdvq, elapsedRealtime, zzbv.zzmf().zzx(this.mContext), zzbv.zzmf().zzy(this.mContext), zzbv.zzmf().zzz(this.mContext), zzbv.zzmf().zzaa(this.mContext));
            zzbcr.zzo(this.zzdnh);
            return;
        }
        this.zzdnh = new zzasi(this.zzdvq, elapsedRealtime, null, null, null, null);
        zza(zzatv.zza(this.mContext, this.zzdnh, string));
    }

    private final void zzd(int i, String str) {
        zzasi zzasi;
        if (i == 3 || i == -1) {
            zzaxz.zzen(str);
        } else {
            zzaxz.zzeo(str);
        }
        zzasm zzasm = this.zzdsl;
        if (zzasm == null) {
            this.zzdsl = new zzasm(i);
        } else {
            this.zzdsl = new zzasm(i, zzasm.zzdlx);
        }
        zzasi zzasi2 = this.zzdnh;
        if (zzasi2 != null) {
            zzasi = zzasi2;
        } else {
            zzasi = new zzasi(this.zzdvq, -1, null, null, null, null);
        }
        zzasm zzasm2 = this.zzdsl;
        this.zzdvp.zza(new zzaxg(zzasi, zzasm2, this.zzdmn, null, i, -1, zzasm2.zzdyh, null, this.zzdvr, null));
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01dd  */
    @Override // com.google.android.gms.internal.ads.zzasa
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(@android.support.annotation.NonNull com.google.android.gms.internal.ads.zzasm r14) {
        /*
        // Method dump skipped, instructions count: 561
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzarn.zza(com.google.android.gms.internal.ads.zzasm):void");
    }

    @Override // com.google.android.gms.internal.ads.zzaxv
    public final void onStop() {
        synchronized (this.zzdsn) {
            if (this.zzdvu != null) {
                this.zzdvu.cancel();
            }
        }
    }

    @VisibleForTesting
    private final zzwf zza(zzasi zzasi) throws zzarx {
        int i;
        zzakr zzakr;
        zzasi zzasi2 = this.zzdnh;
        if (!(!((zzasi2 == null || zzasi2.zzbtn == null || this.zzdnh.zzbtn.size() <= 1) ? false : true) || (zzakr = this.zzdmn) == null || zzakr.zzdmi)) {
            return null;
        }
        if (this.zzdsl.zzcko) {
            zzwf[] zzwfArr = zzasi.zzbst.zzckm;
            for (zzwf zzwf : zzwfArr) {
                if (zzwf.zzcko) {
                    return new zzwf(zzwf, zzasi.zzbst.zzckm);
                }
            }
        }
        if (this.zzdsl.zzdyg != null) {
            String[] split = this.zzdsl.zzdyg.split("x");
            if (split.length != 2) {
                String valueOf = String.valueOf(this.zzdsl.zzdyg);
                throw new zzarx(valueOf.length() != 0 ? "Invalid ad size format from the ad response: ".concat(valueOf) : new String("Invalid ad size format from the ad response: "), 0);
            }
            try {
                int parseInt = Integer.parseInt(split[0]);
                int parseInt2 = Integer.parseInt(split[1]);
                zzwf[] zzwfArr2 = zzasi.zzbst.zzckm;
                for (zzwf zzwf2 : zzwfArr2) {
                    float f = this.mContext.getResources().getDisplayMetrics().density;
                    int i2 = zzwf2.width == -1 ? (int) (((float) zzwf2.widthPixels) / f) : zzwf2.width;
                    if (zzwf2.height == -2) {
                        i = (int) (((float) zzwf2.heightPixels) / f);
                    } else {
                        i = zzwf2.height;
                    }
                    if (parseInt == i2 && parseInt2 == i && !zzwf2.zzcko) {
                        return new zzwf(zzwf2, zzasi.zzbst.zzckm);
                    }
                }
                String valueOf2 = String.valueOf(this.zzdsl.zzdyg);
                throw new zzarx(valueOf2.length() != 0 ? "The ad size from the ad response was not one of the requested sizes: ".concat(valueOf2) : new String("The ad size from the ad response was not one of the requested sizes: "), 0);
            } catch (NumberFormatException unused) {
                String valueOf3 = String.valueOf(this.zzdsl.zzdyg);
                throw new zzarx(valueOf3.length() != 0 ? "Invalid ad size number from the ad response: ".concat(valueOf3) : new String("Invalid ad size number from the ad response: "), 0);
            }
        } else {
            throw new zzarx("The ad response must specify one of the supported ad sizes.", 0);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzbcn zzbcn) {
        zzasc zzasc;
        synchronized (this.zzdsn) {
            if (this.zzdvt) {
                zzaxz.zzeo("Request task was already canceled");
                return;
            }
            zzbbi zzbbi = this.zzdvq.zzbsp;
            Context context = this.mContext;
            if (new zzarz(context).zza(zzbbi)) {
                zzaxz.zzdn("Fetching ad response from local ad request service.");
                zzasc = new zzasf(context, zzbcn, this);
                zzasc.zzwa();
            } else {
                zzaxz.zzdn("Fetching ad response from remote ad request service.");
                zzwu.zzpv();
                if (!zzbat.zzc(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                    zzaxz.zzeo("Failed to connect to remote ad request service.");
                    zzasc = null;
                } else {
                    zzasc = new zzasg(context, zzbbi, zzbcn, this);
                }
            }
            this.zzdvu = zzasc;
            if (this.zzdvu == null) {
                zzd(0, "Could not start the ad request service.");
                zzayh.zzelc.removeCallbacks(this.zzdsm);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzwh() {
        synchronized (this.zzdsn) {
            this.zzdvt = true;
            if (this.zzdvu != null) {
                onStop();
            }
            zzd(2, "Timed out waiting for ad response.");
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzvp zzvp) {
        zzvp.zzchu.zzchc = this.zzdvq.zzdwh.packageName;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzvp zzvp) {
        zzvp.zzchp = this.zzdvq.zzdws;
    }
}
