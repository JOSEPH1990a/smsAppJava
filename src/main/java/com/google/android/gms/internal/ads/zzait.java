package com.google.android.gms.internal.ads;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzbv;
import java.util.concurrent.Executor;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
public final class zzait {
    private final Context mContext;
    private final Object mLock;
    private final zzbbi zzbob;
    private final String zzdiv;
    private zzazn<zzaii> zzdiw;
    private zzazn<zzaii> zzdix;
    @Nullable
    private zzajm zzdiy;
    private int zzdiz;

    public zzait(Context context, zzbbi zzbbi, String str) {
        this.mLock = new Object();
        this.zzdiz = 1;
        this.zzdiv = str;
        this.mContext = context.getApplicationContext();
        this.zzbob = zzbbi;
        this.zzdiw = new zzajh();
        this.zzdix = new zzajh();
    }

    public zzait(Context context, zzbbi zzbbi, String str, zzazn<zzaii> zzazn, zzazn<zzaii> zzazn2) {
        this(context, zzbbi, str);
        this.zzdiw = zzazn;
        this.zzdix = zzazn2;
    }

    /* access modifiers changed from: protected */
    public final zzajm zza(@Nullable zzcu zzcu) {
        zzajm zzajm = new zzajm(this.zzdix);
        zzbcg.zzepo.execute(new zzaiu(this, zzcu, zzajm));
        zzajm.zza(new zzaje(this, zzajm), new zzajf(this, zzajm));
        return zzajm;
    }

    public final zzaji zzb(@Nullable zzcu zzcu) {
        synchronized (this.mLock) {
            synchronized (this.mLock) {
                if (this.zzdiy != null && this.zzdiz == 0) {
                    if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcob)).booleanValue()) {
                        this.zzdiy.zza(new zzaiv(this), zzaiw.zzdjd);
                    }
                }
            }
            if (this.zzdiy == null || this.zzdiy.getStatus() == -1) {
                this.zzdiz = 2;
                this.zzdiy = zza((zzcu) null);
                return this.zzdiy.zzud();
            } else if (this.zzdiz == 0) {
                return this.zzdiy.zzud();
            } else if (this.zzdiz == 1) {
                this.zzdiz = 2;
                zza((zzcu) null);
                return this.zzdiy.zzud();
            } else if (this.zzdiz == 2) {
                return this.zzdiy.zzud();
            } else {
                return this.zzdiy.zzud();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzaii zzaii) {
        if (zzaii.isDestroyed()) {
            this.zzdiz = 1;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzcu zzcu, zzajm zzajm) {
        zzaii zzaii;
        try {
            Context context = this.mContext;
            zzbbi zzbbi = this.zzbob;
            if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcrd)).booleanValue()) {
                zzaii = new zzahv(context, zzbbi);
            } else {
                zzaii = new zzaik(context, zzbbi, zzcu, null);
            }
            zzaii.zza(new zzaix(this, zzajm, zzaii));
            zzaii.zza("/jsLoaded", new zzaja(this, zzajm, zzaii));
            zzbaj zzbaj = new zzbaj();
            zzajb zzajb = new zzajb(this, zzcu, zzaii, zzbaj);
            zzbaj.set(zzajb);
            zzaii.zza("/requestReload", zzajb);
            if (this.zzdiv.endsWith(".js")) {
                zzaii.zzcd(this.zzdiv);
            } else if (this.zzdiv.startsWith("<html>")) {
                zzaii.zzce(this.zzdiv);
            } else {
                zzaii.zzcf(this.zzdiv);
            }
            zzayh.zzelc.postDelayed(new zzajc(this, zzajm, zzaii), (long) zzajg.zzdjn);
        } catch (Throwable th) {
            zzaxz.zzb("Error creating webview.", th);
            zzbv.zzlj().zza(th, "SdkJavascriptFactory.loadJavascriptEngine");
            zzajm.reject();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzajm zzajm, zzaii zzaii) {
        synchronized (this.mLock) {
            if (zzajm.getStatus() != -1) {
                if (zzajm.getStatus() != 1) {
                    zzajm.reject();
                    Executor executor = zzbcg.zzepo;
                    zzaii.getClass();
                    executor.execute(zzaiz.zzb(zzaii));
                    zzaxz.v("Could not receive loaded message in a timely manner. Rejecting.");
                }
            }
        }
    }
}
