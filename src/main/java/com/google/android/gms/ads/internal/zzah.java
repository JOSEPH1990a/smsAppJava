package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzaan;
import com.google.android.gms.internal.ads.zzacp;
import com.google.android.gms.internal.ads.zzaeb;
import com.google.android.gms.internal.ads.zzaee;
import com.google.android.gms.internal.ads.zzaeh;
import com.google.android.gms.internal.ads.zzaek;
import com.google.android.gms.internal.ads.zzaen;
import com.google.android.gms.internal.ads.zzaeq;
import com.google.android.gms.internal.ads.zzafz;
import com.google.android.gms.internal.ads.zzagf;
import com.google.android.gms.internal.ads.zzalg;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzaxz;
import com.google.android.gms.internal.ads.zzayh;
import com.google.android.gms.internal.ads.zzbbi;
import com.google.android.gms.internal.ads.zzwb;
import com.google.android.gms.internal.ads.zzwf;
import com.google.android.gms.internal.ads.zzwu;
import com.google.android.gms.internal.ads.zzxa;
import com.google.android.gms.internal.ads.zzxe;
import com.google.android.gms.internal.ads.zzxz;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
public final class zzah extends zzxe {
    private final Context mContext;
    private final Object mLock = new Object();
    private final zzv zzbly;
    private final zzalg zzbma;
    private final zzxa zzbnn;
    @Nullable
    private final zzaeb zzbno;
    @Nullable
    private final zzaeq zzbnp;
    @Nullable
    private final zzagf zzbnq;
    @Nullable
    private final zzaee zzbnr;
    @Nullable
    private final zzaen zzbns;
    @Nullable
    private final zzwf zzbnt;
    @Nullable
    private final PublisherAdViewOptions zzbnu;
    private final SimpleArrayMap<String, zzaek> zzbnv;
    private final SimpleArrayMap<String, zzaeh> zzbnw;
    private final zzacp zzbnx;
    private final zzafz zzbny;
    private final zzxz zzbnz;
    private final String zzboa;
    private final zzbbi zzbob;
    @Nullable
    private WeakReference<zzc> zzboc;

    zzah(Context context, String str, zzalg zzalg, zzbbi zzbbi, zzxa zzxa, zzaeb zzaeb, zzaeq zzaeq, zzagf zzagf, zzaee zzaee, SimpleArrayMap<String, zzaek> simpleArrayMap, SimpleArrayMap<String, zzaeh> simpleArrayMap2, zzacp zzacp, zzafz zzafz, zzxz zzxz, zzv zzv, zzaen zzaen, zzwf zzwf, PublisherAdViewOptions publisherAdViewOptions) {
        this.mContext = context;
        this.zzboa = str;
        this.zzbma = zzalg;
        this.zzbob = zzbbi;
        this.zzbnn = zzxa;
        this.zzbnr = zzaee;
        this.zzbno = zzaeb;
        this.zzbnp = zzaeq;
        this.zzbnq = zzagf;
        this.zzbnv = simpleArrayMap;
        this.zzbnw = simpleArrayMap2;
        this.zzbnx = zzacp;
        this.zzbny = zzafz;
        this.zzbnz = zzxz;
        this.zzbly = zzv;
        this.zzbns = zzaen;
        this.zzbnt = zzwf;
        this.zzbnu = publisherAdViewOptions;
        zzaan.initialize(this.mContext);
    }

    @Override // com.google.android.gms.internal.ads.zzxd
    public final void zzd(zzwb zzwb) {
        runOnUiThread(new zzai(this, zzwb));
    }

    @Override // com.google.android.gms.internal.ads.zzxd
    public final void zza(zzwb zzwb, int i) {
        if (i > 0) {
            runOnUiThread(new zzaj(this, zzwb, i));
            return;
        }
        throw new IllegalArgumentException("Number of ads has to be more than 0");
    }

    private final void zzbr(int i) {
        zzxa zzxa = this.zzbnn;
        if (zzxa != null) {
            try {
                zzxa.onAdFailedToLoad(0);
            } catch (RemoteException e) {
                zzaxz.zzc("Failed calling onAdFailedToLoad.", e);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zze(zzwb zzwb) {
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcup)).booleanValue() || this.zzbnp == null) {
            zzp zzp = new zzp(this.mContext, this.zzbly, this.zzbnt, this.zzboa, this.zzbma, this.zzbob);
            this.zzboc = new WeakReference<>(zzp);
            zzaen zzaen = this.zzbns;
            Preconditions.checkMainThread("setOnPublisherAdViewLoadedListener must be called on the main UI thread.");
            zzp.zzbls.zzbtm = zzaen;
            PublisherAdViewOptions publisherAdViewOptions = this.zzbnu;
            if (publisherAdViewOptions != null) {
                if (publisherAdViewOptions.zzib() != null) {
                    zzp.zza(this.zzbnu.zzib());
                }
                zzp.setManualImpressionsEnabled(this.zzbnu.getManualImpressionsEnabled());
            }
            zzaeb zzaeb = this.zzbno;
            Preconditions.checkMainThread("setOnAppInstallAdLoadedListener must be called on the main UI thread.");
            zzp.zzbls.zzbtc = zzaeb;
            zzaeq zzaeq = this.zzbnp;
            Preconditions.checkMainThread("setOnUnifiedNativeAdLoadedListener must be called on the main UI thread.");
            zzp.zzbls.zzbte = zzaeq;
            zzaee zzaee = this.zzbnr;
            Preconditions.checkMainThread("setOnContentAdLoadedListener must be called on the main UI thread.");
            zzp.zzbls.zzbtd = zzaee;
            SimpleArrayMap<String, zzaek> simpleArrayMap = this.zzbnv;
            Preconditions.checkMainThread("setOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
            zzp.zzbls.zzbth = simpleArrayMap;
            SimpleArrayMap<String, zzaeh> simpleArrayMap2 = this.zzbnw;
            Preconditions.checkMainThread("setOnCustomClickListener must be called on the main UI thread.");
            zzp.zzbls.zzbtg = simpleArrayMap2;
            zzacp zzacp = this.zzbnx;
            Preconditions.checkMainThread("setNativeAdOptions must be called on the main UI thread.");
            zzp.zzbls.zzbti = zzacp;
            zzp.zzd(zzkc());
            zzp.zza(this.zzbnn);
            zzp.zza(this.zzbnz);
            ArrayList arrayList = new ArrayList();
            if (zzkb()) {
                arrayList.add(1);
            }
            if (this.zzbns != null) {
                arrayList.add(2);
            }
            zzp.zze(arrayList);
            if (zzkb()) {
                zzwb.extras.putBoolean("ina", true);
            }
            if (this.zzbns != null) {
                zzwb.extras.putBoolean("iba", true);
            }
            zzp.zzb(zzwb);
            return;
        }
        zzbr(0);
    }

    /* access modifiers changed from: private */
    public final void zzb(zzwb zzwb, int i) {
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcup)).booleanValue() || this.zzbnp == null) {
            if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcuq)).booleanValue() || this.zzbnq == null) {
                Context context = this.mContext;
                zzbb zzbb = new zzbb(context, this.zzbly, zzwf.zzg(context), this.zzboa, this.zzbma, this.zzbob);
                this.zzboc = new WeakReference<>(zzbb);
                zzaeb zzaeb = this.zzbno;
                Preconditions.checkMainThread("setOnAppInstallAdLoadedListener must be called on the main UI thread.");
                zzbb.zzbls.zzbtc = zzaeb;
                zzaeq zzaeq = this.zzbnp;
                Preconditions.checkMainThread("setOnUnifiedNativeAdLoadedListener must be called on the main UI thread.");
                zzbb.zzbls.zzbte = zzaeq;
                zzagf zzagf = this.zzbnq;
                Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setInstreamAdLoadCallback");
                zzbb.zzbls.zzbtf = zzagf;
                zzaee zzaee = this.zzbnr;
                Preconditions.checkMainThread("setOnContentAdLoadedListener must be called on the main UI thread.");
                zzbb.zzbls.zzbtd = zzaee;
                SimpleArrayMap<String, zzaek> simpleArrayMap = this.zzbnv;
                Preconditions.checkMainThread("setOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
                zzbb.zzbls.zzbth = simpleArrayMap;
                zzbb.zza(this.zzbnn);
                SimpleArrayMap<String, zzaeh> simpleArrayMap2 = this.zzbnw;
                Preconditions.checkMainThread("setOnCustomClickListener must be called on the main UI thread.");
                zzbb.zzbls.zzbtg = simpleArrayMap2;
                zzbb.zzd(zzkc());
                zzacp zzacp = this.zzbnx;
                Preconditions.checkMainThread("setNativeAdOptions must be called on the main UI thread.");
                zzbb.zzbls.zzbti = zzacp;
                zzafz zzafz = this.zzbny;
                Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setInstreamAdConfiguration");
                zzbb.zzbls.zzbtk = zzafz;
                zzbb.zza(this.zzbnz);
                zzbb.zzbs(i);
                zzbb.zzb(zzwb);
                return;
            }
            zzbr(0);
            return;
        }
        zzbr(0);
    }

    /* access modifiers changed from: private */
    public final boolean zzka() {
        return this.zzbnq == null && this.zzbns != null;
    }

    private final boolean zzkb() {
        if (this.zzbno != null || this.zzbnr != null || this.zzbnp != null) {
            return true;
        }
        SimpleArrayMap<String, zzaek> simpleArrayMap = this.zzbnv;
        return simpleArrayMap != null && simpleArrayMap.size() > 0;
    }

    @Override // com.google.android.gms.internal.ads.zzxd
    @Nullable
    public final String getMediationAdapterClassName() {
        synchronized (this.mLock) {
            String str = null;
            if (this.zzboc == null) {
                return null;
            }
            zzc zzc = this.zzboc.get();
            if (zzc != null) {
                str = zzc.getMediationAdapterClassName();
            }
            return str;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxd
    @Nullable
    public final String zzje() {
        synchronized (this.mLock) {
            String str = null;
            if (this.zzboc == null) {
                return null;
            }
            zzc zzc = this.zzboc.get();
            if (zzc != null) {
                str = zzc.zzje();
            }
            return str;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxd
    public final boolean isLoading() {
        synchronized (this.mLock) {
            boolean z = false;
            if (this.zzboc == null) {
                return false;
            }
            zzc zzc = this.zzboc.get();
            if (zzc != null) {
                z = zzc.isLoading();
            }
            return z;
        }
    }

    private final List<String> zzkc() {
        ArrayList arrayList = new ArrayList();
        if (this.zzbnr != null) {
            arrayList.add("1");
        }
        if (this.zzbno != null) {
            arrayList.add("2");
        }
        if (this.zzbnp != null) {
            arrayList.add("6");
        }
        if (this.zzbnv.size() > 0) {
            arrayList.add("3");
        }
        if (this.zzbnq != null) {
            arrayList.add("2");
            arrayList.add("1");
        }
        return arrayList;
    }

    private static void runOnUiThread(Runnable runnable) {
        zzayh.zzelc.post(runnable);
    }
}
