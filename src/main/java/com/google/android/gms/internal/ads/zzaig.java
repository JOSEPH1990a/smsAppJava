package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.support.annotation.GuardedBy;
import com.google.android.gms.ads.internal.gmsg.zzu;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.common.util.Predicate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
public class zzaig<ReferenceT> {
    @GuardedBy("this")
    private final Map<String, CopyOnWriteArrayList<zzu<? super ReferenceT>>> zzdii = new HashMap();
    private ReferenceT zzdij;

    public final void zzi(ReferenceT referencet) {
        this.zzdij = referencet;
    }

    public final boolean zzf(Uri uri) {
        if (!"gmsg".equalsIgnoreCase(uri.getScheme()) || !"mobileads.google.com".equalsIgnoreCase(uri.getHost())) {
            return false;
        }
        String path = uri.getPath();
        zzbv.zzlf();
        zzb(path, zzayh.zzg(uri));
        return true;
    }

    private final synchronized void zzb(String str, Map<String, String> map) {
        if (zzaxz.isLoggable(2)) {
            String valueOf = String.valueOf(str);
            zzaxz.v(valueOf.length() != 0 ? "Received GMSG: ".concat(valueOf) : new String("Received GMSG: "));
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 4 + String.valueOf(str3).length());
                sb.append("  ");
                sb.append(str2);
                sb.append(": ");
                sb.append(str3);
                zzaxz.v(sb.toString());
            }
        }
        CopyOnWriteArrayList<zzu<? super ReferenceT>> copyOnWriteArrayList = this.zzdii.get(str);
        if (copyOnWriteArrayList != null) {
            Iterator<zzu<? super ReferenceT>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                zzbcg.zzepo.execute(new zzaih(this, it.next(), map));
            }
        }
    }

    public final synchronized void zza(String str, zzu<? super ReferenceT> zzu) {
        CopyOnWriteArrayList<zzu<? super ReferenceT>> copyOnWriteArrayList = this.zzdii.get(str);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.zzdii.put(str, copyOnWriteArrayList);
        }
        copyOnWriteArrayList.add(zzu);
    }

    public final synchronized void zzb(String str, zzu<? super ReferenceT> zzu) {
        CopyOnWriteArrayList<zzu<? super ReferenceT>> copyOnWriteArrayList = this.zzdii.get(str);
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.remove(zzu);
        }
    }

    public final synchronized void zza(String str, Predicate<zzu<? super ReferenceT>> predicate) {
        CopyOnWriteArrayList<zzu<? super ReferenceT>> copyOnWriteArrayList = this.zzdii.get(str);
        if (copyOnWriteArrayList != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<zzu<? super ReferenceT>> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                zzu<? super ReferenceT> next = it.next();
                if (predicate.apply(next)) {
                    arrayList.add(next);
                }
            }
            copyOnWriteArrayList.removeAll(arrayList);
        }
    }

    public final synchronized void reset() {
        this.zzdii.clear();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzu zzu, Map map) {
        zzu.zza(this.zzdij, map);
    }
}
