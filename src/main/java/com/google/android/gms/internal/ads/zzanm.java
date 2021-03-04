package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.mediation.zzb;
import com.google.android.gms.ads.zzc;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzanm extends zzanh {
    private final zzbit zzdon;

    public zzanm(zzbit zzbit) {
        this.zzdon = zzbit;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(String str, String str2, Bundle bundle, IObjectWrapper iObjectWrapper, zzamy zzamy, zzalm zzalm, zzwf zzwf) throws RemoteException {
        try {
            zzann zzann = new zzann(this, zzamy, zzalm);
            zzbit zzbit = this.zzdon;
            new zzbis((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzcx(str2), bundle);
            zzc.zza(zzwf.width, zzwf.height, zzwf.zzckk);
            zzann.zzbw(String.valueOf(zzbit.getClass().getSimpleName()).concat(" does not support banner ads."));
        } catch (Throwable th) {
            zzbbd.zzb("Adapter failed to render banner ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(String str, String str2, Bundle bundle, IObjectWrapper iObjectWrapper, zzana zzana, zzalm zzalm) throws RemoteException {
        try {
            zzano zzano = new zzano(this, zzana, zzalm);
            zzbit zzbit = this.zzdon;
            new zzbis((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzcx(str2), bundle);
            zzano.zzbw(String.valueOf(zzbit.getClass().getSimpleName()).concat(" does not support interstitial ads."));
        } catch (Throwable th) {
            zzbbd.zzb("Adapter failed to render interstitial ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(String str, String str2, Bundle bundle, IObjectWrapper iObjectWrapper, zzane zzane, zzalm zzalm) throws RemoteException {
        try {
            zzanp zzanp = new zzanp(this, zzane, zzalm);
            zzbit zzbit = this.zzdon;
            new zzbis((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzcx(str2), bundle);
            zzanp.zzbw(String.valueOf(zzbit.getClass().getSimpleName()).concat(" does not support rewarded ads."));
        } catch (Throwable th) {
            zzbbd.zzb("Adapter failed to render rewarded ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(String str, String str2, Bundle bundle, IObjectWrapper iObjectWrapper, zzanc zzanc, zzalm zzalm) throws RemoteException {
        try {
            zzanq zzanq = new zzanq(this, zzanc, zzalm);
            zzbit zzbit = this.zzdon;
            new zzbis((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzcx(str2), bundle);
            zzanq.zzbw(String.valueOf(zzbit.getClass().getSimpleName()).concat(" does not support native ads."));
        } catch (Throwable th) {
            zzbbd.zzb("Adapter failed to render rewarded ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void showInterstitial() throws RemoteException {
        zzbiq zzbiq = null;
        try {
            zzbiq.zzxh();
        } catch (Throwable th) {
            zzbbd.zzb("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zzvk() throws RemoteException {
        zzbir zzbir = null;
        try {
            zzbir.zzxh();
        } catch (Throwable th) {
            zzbbd.zzb("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzyp getVideoController() {
        zzbit zzbit = this.zzdon;
        if (!(zzbit instanceof zzb)) {
            return null;
        }
        try {
            return ((zzb) zzbit).getVideoController();
        } catch (Throwable th) {
            zzbbd.zzb("", th);
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v1, resolved type: com.google.android.gms.internal.ads.zzbit */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.ads.zzbiv, com.google.android.gms.internal.ads.zzanr] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.google.android.gms.internal.ads.zzang
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.dynamic.IObjectWrapper r4, java.lang.String r5, android.os.Bundle r6, android.os.Bundle r7, com.google.android.gms.internal.ads.zzwf r8, com.google.android.gms.internal.ads.zzanj r9) throws android.os.RemoteException {
        /*
            r3 = this;
            com.google.android.gms.internal.ads.zzanr r0 = new com.google.android.gms.internal.ads.zzanr     // Catch:{ Throwable -> 0x0029 }
            r0.<init>(r3, r9)     // Catch:{ Throwable -> 0x0029 }
            com.google.android.gms.internal.ads.zzbit r9 = r3.zzdon     // Catch:{ Throwable -> 0x0029 }
            com.google.android.gms.ads.mediation.zza r1 = new com.google.android.gms.ads.mediation.zza     // Catch:{ Throwable -> 0x0029 }
            int r5 = zzcw(r5)     // Catch:{ Throwable -> 0x0029 }
            r1.<init>(r5, r7)     // Catch:{ Throwable -> 0x0029 }
            com.google.android.gms.internal.ads.zzbiu r5 = new com.google.android.gms.internal.ads.zzbiu     // Catch:{ Throwable -> 0x0029 }
            java.lang.Object r4 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r4)     // Catch:{ Throwable -> 0x0029 }
            android.content.Context r4 = (android.content.Context) r4     // Catch:{ Throwable -> 0x0029 }
            int r7 = r8.width     // Catch:{ Throwable -> 0x0029 }
            int r2 = r8.height     // Catch:{ Throwable -> 0x0029 }
            java.lang.String r8 = r8.zzckk     // Catch:{ Throwable -> 0x0029 }
            com.google.android.gms.ads.AdSize r7 = com.google.android.gms.ads.zzc.zza(r7, r2, r8)     // Catch:{ Throwable -> 0x0029 }
            r5.<init>(r4, r1, r6, r7)     // Catch:{ Throwable -> 0x0029 }
            r9.zza(r5, r0)     // Catch:{ Throwable -> 0x0029 }
            return
        L_0x0029:
            r4 = move-exception
            java.lang.String r5 = "Error generating signals for RTB"
            com.google.android.gms.internal.ads.zzbbd.zzb(r5, r4)
            android.os.RemoteException r4 = new android.os.RemoteException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzanm.zza(com.google.android.gms.dynamic.IObjectWrapper, java.lang.String, android.os.Bundle, android.os.Bundle, com.google.android.gms.internal.ads.zzwf, com.google.android.gms.internal.ads.zzanj):void");
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzans zzvi() throws RemoteException {
        return zzans.zza(this.zzdon.zzafj());
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final zzans zzvj() throws RemoteException {
        return zzans.zza(this.zzdon.zzafi());
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zzn(IObjectWrapper iObjectWrapper) throws RemoteException {
        this.zzdon.initialize((Context) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final void zza(String[] strArr, Bundle[] bundleArr) throws RemoteException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < strArr.length; i++) {
            try {
                arrayList.add(new zza(zzcw(strArr[i]), bundleArr[i]));
            } catch (IndexOutOfBoundsException unused) {
                throw new RemoteException();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0056  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zzcw(java.lang.String r2) {
        /*
        // Method dump skipped, instructions count: 102
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzanm.zzcw(java.lang.String):int");
    }

    private static Bundle zzcx(String str) throws RemoteException {
        String valueOf = String.valueOf(str);
        zzbbd.zzeo(valueOf.length() != 0 ? "Server parameters: ".concat(valueOf) : new String("Server parameters: "));
        try {
            Bundle bundle = new Bundle();
            if (str == null) {
                return bundle;
            }
            JSONObject jSONObject = new JSONObject(str);
            Bundle bundle2 = new Bundle();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle2.putString(next, jSONObject.getString(next));
            }
            return bundle2;
        } catch (JSONException e) {
            zzbbd.zzb("", e);
            throw new RemoteException();
        }
    }
}
