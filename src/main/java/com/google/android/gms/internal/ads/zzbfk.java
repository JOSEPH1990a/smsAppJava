package com.google.android.gms.internal.ads;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
public abstract class zzbfk implements Releasable {
    protected Context mContext;
    protected String zzeiz;
    protected WeakReference<zzbdz> zzewo;

    public zzbfk(zzbdz zzbdz) {
        this.mContext = zzbdz.getContext();
        this.zzeiz = zzbv.zzlf().zzo(this.mContext, zzbdz.zzabz().zzdp);
        this.zzewo = new WeakReference<>(zzbdz);
    }

    public abstract void abort();

    @Override // com.google.android.gms.common.api.Releasable
    public void release() {
    }

    /* access modifiers changed from: protected */
    public void zzcz(int i) {
    }

    /* access modifiers changed from: protected */
    public void zzda(int i) {
    }

    /* access modifiers changed from: protected */
    public void zzdb(int i) {
    }

    /* access modifiers changed from: protected */
    public void zzdc(int i) {
    }

    public abstract boolean zzex(String str);

    @VisibleForTesting
    public final void zza(String str, String str2, long j, long j2, boolean z, int i, int i2) {
        zzbat.zztu.post(new zzbfm(this, str, str2, j, j2, z, i, i2));
    }

    /* access modifiers changed from: protected */
    public final void zza(String str, String str2, int i) {
        zzbat.zztu.post(new zzbfn(this, str, str2, i));
    }

    @VisibleForTesting
    public final void zzc(String str, String str2, long j) {
        zzbat.zztu.post(new zzbfo(this, str, str2, j));
    }

    @VisibleForTesting
    public final void zza(String str, String str2, String str3, @Nullable String str4) {
        zzbat.zztu.post(new zzbfp(this, str, str2, str3, str4));
    }

    /* access modifiers changed from: protected */
    public String zzey(String str) {
        zzwu.zzpv();
        return zzbat.zzei(str);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: private */
    public static String zzez(String str) {
        char c;
        switch (str.hashCode()) {
            case -1947652542:
                if (str.equals("interrupted")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1396664534:
                if (str.equals("badUrl")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -1347010958:
                if (str.equals("inProgress")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -918817863:
                if (str.equals("downloadTimeout")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -659376217:
                if (str.equals("contentLengthMissing")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -642208130:
                if (str.equals("playerFailed")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -354048396:
                if (str.equals("sizeExceeded")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -32082395:
                if (str.equals("externalAbort")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 3387234:
                if (str.equals("noop")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 96784904:
                if (str.equals("error")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 580119100:
                if (str.equals("expireFailed")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 725497484:
                if (str.equals("noCacheDir")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return "internal";
            case 6:
            case 7:
                return "io";
            case '\b':
            case '\t':
                return "network";
            case '\n':
            case 11:
                return "policy";
            default:
                return "internal";
        }
    }

    /* access modifiers changed from: private */
    public final void zza(String str, Map<String, String> map) {
        zzbdz zzbdz = this.zzewo.get();
        if (zzbdz != null) {
            zzbdz.zza(str, map);
        }
    }
}
