package com.google.firebase.components;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-common@@16.0.2 */
public final class zzd implements zze<Context> {
    private zzd() {
    }

    /* synthetic */ zzd(byte b) {
        this();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.firebase.components.zze
    public final /* synthetic */ List zza(Context context) {
        Bundle zza = zza(context);
        if (zza == null) {
            Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (String str : zza.keySet()) {
            if ("com.google.firebase.components.ComponentRegistrar".equals(zza.get(str)) && str.startsWith("com.google.firebase.components:")) {
                arrayList.add(str.substring(31));
            }
        }
        return arrayList;
    }

    private static Bundle zza(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                Log.w("ComponentDiscovery", "Context has no PackageManager.");
                return null;
            }
            ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, ComponentDiscoveryService.class), 128);
            if (serviceInfo != null) {
                return serviceInfo.metaData;
            }
            Log.w("ComponentDiscovery", "ComponentDiscoveryService has no service info.");
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("ComponentDiscovery", "Application info not found.");
            return null;
        }
    }
}
