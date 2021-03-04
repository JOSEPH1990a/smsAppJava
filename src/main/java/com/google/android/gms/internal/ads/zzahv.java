package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzbv;
import fi.iki.elonen.NanoHTTPD;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@zzark
@ParametersAreNonnullByDefault
public final class zzahv extends zzaig<zzajr> implements zzaic, zzaii {
    private final zzbig zzdid;
    private zzaij zzdie;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.android.gms.internal.ads.zzahv */
    /* JADX WARN: Multi-variable type inference failed */
    public zzahv(Context context, zzbbi zzbbi) throws zzbgq {
        try {
            this.zzdid = new zzbig(context, new zzaib(this));
            this.zzdid.setWillNotDraw(true);
            this.zzdid.addJavascriptInterface(new zzaia(this), "GoogleJsInterface");
            zzbv.zzlf().zza(context, zzbbi.zzdp, this.zzdid.getSettings());
            super.zzi(this);
        } catch (Throwable th) {
            throw new zzbgq("Init failed.", th);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzahu
    public final void zza(String str, Map map) {
        zzaid.zza(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzahu, com.google.android.gms.internal.ads.zzaic
    public final void zza(String str, JSONObject jSONObject) {
        zzaid.zzb(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzais
    public final void zzb(String str, JSONObject jSONObject) {
        zzaid.zza(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzaic
    public final void zzh(String str, String str2) {
        zzaid.zza(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final void zzcd(String str) {
        zzce(String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head></html>", str));
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final void zzce(String str) {
        zzbcg.zzepo.execute(new zzahw(this, str));
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final void zzcf(String str) {
        zzbcg.zzepo.execute(new zzahx(this, str));
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final void zza(zzaij zzaij) {
        this.zzdie = zzaij;
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final void destroy() {
        this.zzdid.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final boolean isDestroyed() {
        return this.zzdid.isDestroyed();
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final zzajs zzua() {
        return new zzajt(this);
    }

    @Override // com.google.android.gms.internal.ads.zzaic, com.google.android.gms.internal.ads.zzais
    public final void zzcg(String str) {
        zzbcg.zzepo.execute(new zzahy(this, str));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzch(String str) {
        this.zzdid.zzcg(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzci(String str) {
        this.zzdid.loadUrl(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzcj(String str) {
        this.zzdid.loadData(str, NanoHTTPD.MIME_HTML, "UTF-8");
    }
}
