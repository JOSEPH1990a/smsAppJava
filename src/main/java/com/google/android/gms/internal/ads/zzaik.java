package com.google.android.gms.internal.ads;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.gmsg.zzu;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.ads.internal.zzv;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@zzark
@ParametersAreNonnullByDefault
public final class zzaik implements zzaic, zzaii {
    private final Context mContext;
    private final zzbgg zzdin;

    public zzaik(Context context, zzbbi zzbbi, @Nullable zzcu zzcu, zzv zzv) throws zzbgq {
        this.mContext = context;
        zzbv.zzlg();
        this.zzdin = zzbgm.zza(context, zzbht.zzaey(), "", false, false, zzcu, zzbbi, null, null, null, zzum.zzoi());
        this.zzdin.getView().setWillNotDraw(true);
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

    private static void runOnUiThread(Runnable runnable) {
        zzwu.zzpv();
        if (zzbat.zzaar()) {
            runnable.run();
        } else {
            zzayh.zzelc.post(runnable);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaic, com.google.android.gms.internal.ads.zzais
    public final void zzcg(String str) {
        runOnUiThread(new zzail(this, str));
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final void zzcd(String str) {
        runOnUiThread(new zzaio(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", str)));
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final void zzce(String str) {
        runOnUiThread(new zzaip(this, str));
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final void zzcf(String str) {
        runOnUiThread(new zzaiq(this, str));
    }

    @Override // com.google.android.gms.internal.ads.zzajr
    public final void zza(String str, zzu<? super zzajr> zzu) {
        this.zzdin.zza(str, new zzair(this, zzu));
    }

    @Override // com.google.android.gms.internal.ads.zzajr
    public final void zzb(String str, zzu<? super zzajr> zzu) {
        this.zzdin.zza(str, new zzaim(zzu));
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final void zza(zzaij zzaij) {
        zzbhn zzadl = this.zzdin.zzadl();
        zzaij.getClass();
        zzadl.zza(zzain.zzb(zzaij));
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final zzajs zzua() {
        return new zzajt(this);
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final void destroy() {
        this.zzdin.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final boolean isDestroyed() {
        return this.zzdin.isDestroyed();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzck(String str) {
        this.zzdin.zzcg(str);
    }
}
