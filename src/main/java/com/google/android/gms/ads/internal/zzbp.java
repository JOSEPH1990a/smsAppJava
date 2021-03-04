package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaan;
import com.google.android.gms.internal.ads.zzabg;
import com.google.android.gms.internal.ads.zzaow;
import com.google.android.gms.internal.ads.zzapc;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzavb;
import com.google.android.gms.internal.ads.zzaxz;
import com.google.android.gms.internal.ads.zzayf;
import com.google.android.gms.internal.ads.zzbat;
import com.google.android.gms.internal.ads.zzbbi;
import com.google.android.gms.internal.ads.zzcu;
import com.google.android.gms.internal.ads.zzcv;
import com.google.android.gms.internal.ads.zzwb;
import com.google.android.gms.internal.ads.zzwf;
import com.google.android.gms.internal.ads.zzwu;
import com.google.android.gms.internal.ads.zzwx;
import com.google.android.gms.internal.ads.zzxa;
import com.google.android.gms.internal.ads.zzxm;
import com.google.android.gms.internal.ads.zzxq;
import com.google.android.gms.internal.ads.zzxt;
import com.google.android.gms.internal.ads.zzxz;
import com.google.android.gms.internal.ads.zzyp;
import com.google.android.gms.internal.ads.zzyv;
import com.google.android.gms.internal.ads.zzzw;
import java.util.Map;
import java.util.concurrent.Future;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
public final class zzbp extends zzxm {
    private final Context mContext;
    @Nullable
    private zzxa zzbnn;
    private final zzbbi zzbob;
    private final zzwf zzbqu;
    private final Future<zzcu> zzbqv = zzayf.zza(new zzbs(this));
    private final zzbu zzbqw;
    @Nullable
    private WebView zzbqx = new WebView(this.mContext);
    @Nullable
    private zzcu zzbqy;
    private AsyncTask<Void, Void, String> zzbqz;

    public zzbp(Context context, zzwf zzwf, String str, zzbbi zzbbi) {
        this.mContext = context;
        this.zzbob = zzbbi;
        this.zzbqu = zzwf;
        this.zzbqw = new zzbu(str);
        zzbt(0);
        this.zzbqx.setVerticalScrollBarEnabled(false);
        this.zzbqx.getSettings().setJavaScriptEnabled(true);
        this.zzbqx.setWebViewClient(new zzbq(this));
        this.zzbqx.setOnTouchListener(new zzbr(this));
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    @Nullable
    public final String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    @Nullable
    public final zzyp getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final boolean isLoading() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final boolean isReady() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void setManualImpressionsEnabled(boolean z) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void stopLoading() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    @Nullable
    public final String zzje() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final IObjectWrapper zzie() throws RemoteException {
        Preconditions.checkMainThread("getAdFrame must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzbqx);
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void destroy() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzbqz.cancel(true);
        this.zzbqv.cancel(true);
        this.zzbqx.destroy();
        this.zzbqx = null;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final boolean zzb(zzwb zzwb) throws RemoteException {
        Preconditions.checkNotNull(this.zzbqx, "This Search Ad has already been torn down");
        this.zzbqw.zza(zzwb, this.zzbob);
        this.zzbqz = new zzbt(this, null).execute(new Void[0]);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void pause() throws RemoteException {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void resume() throws RemoteException {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzxa zzxa) throws RemoteException {
        this.zzbnn = zzxa;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzxt zzxt) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzxq zzxq) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final Bundle getAdMetadata() {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void showInterstitial() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zzih() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final zzwf zzif() throws RemoteException {
        return this.zzbqu;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzwf zzwf) throws RemoteException {
        throw new IllegalStateException("AdSize must be set before initialization");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzaow zzaow) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzapc zzapc, String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final String getAdUnitId() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final zzxt zzir() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final zzxa zzis() {
        throw new IllegalStateException("getIAdListener not implemented");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzabg zzabg) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzwx zzwx) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzxz zzxz) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzavb zzavb) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void setUserId(String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zzap(String str) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzzw zzzw) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzyv zzyv) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void setImmersiveMode(boolean z) {
        throw new IllegalStateException("Unused method");
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final int zzav(String str) {
        String queryParameter = Uri.parse(str).getQueryParameter("height");
        if (TextUtils.isEmpty(queryParameter)) {
            return 0;
        }
        try {
            zzwu.zzpv();
            return zzbat.zza(this.mContext, Integer.parseInt(queryParameter));
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zzbt(int i) {
        if (this.zzbqx != null) {
            this.zzbqx.setLayoutParams(new ViewGroup.LayoutParams(-1, i));
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final String zzkw() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https://").appendEncodedPath((String) zzwu.zzpz().zzd(zzaan.zzcvg));
        builder.appendQueryParameter(SearchIntents.EXTRA_QUERY, this.zzbqw.getQuery());
        builder.appendQueryParameter("pubId", this.zzbqw.zzkz());
        Map<String, String> zzla = this.zzbqw.zzla();
        for (String str : zzla.keySet()) {
            builder.appendQueryParameter(str, zzla.get(str));
        }
        Uri build = builder.build();
        zzcu zzcu = this.zzbqy;
        if (zzcu != null) {
            try {
                build = zzcu.zza(build, this.mContext);
            } catch (zzcv e) {
                zzaxz.zzc("Unable to process ad data", e);
            }
        }
        String zzkx = zzkx();
        String encodedQuery = build.getEncodedQuery();
        StringBuilder sb = new StringBuilder(String.valueOf(zzkx).length() + 1 + String.valueOf(encodedQuery).length());
        sb.append(zzkx);
        sb.append("#");
        sb.append(encodedQuery);
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final String zzkx() {
        String zzky = this.zzbqw.zzky();
        if (TextUtils.isEmpty(zzky)) {
            zzky = "www.google.com";
        }
        String str = (String) zzwu.zzpz().zzd(zzaan.zzcvg);
        StringBuilder sb = new StringBuilder(String.valueOf(zzky).length() + 8 + String.valueOf(str).length());
        sb.append("https://");
        sb.append(zzky);
        sb.append(str);
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public final String zzaw(String str) {
        if (this.zzbqy == null) {
            return str;
        }
        Uri parse = Uri.parse(str);
        try {
            parse = this.zzbqy.zza(parse, this.mContext, null, null);
        } catch (zzcv e) {
            zzaxz.zzc("Unable to process ad data", e);
        }
        return parse.toString();
    }

    /* access modifiers changed from: private */
    public final void zzax(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        this.mContext.startActivity(intent);
    }
}
