package com.google.android.gms.ads.internal.gmsg;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.view.View;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzcu;
import java.util.ArrayList;
import java.util.List;

@VisibleForTesting
public final class zzad {
    private final Context mContext;
    private final View mView;
    private final zzcu zzdgf;

    public zzad(Context context, zzcu zzcu, View view) {
        this.mContext = context;
        this.zzdgf = zzcu;
        this.mView = view;
    }

    private static Intent zze(Uri uri) {
        if (uri == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setData(uri);
        intent.setAction("android.intent.action.VIEW");
        return intent;
    }

    @VisibleForTesting
    private final ResolveInfo zzb(Intent intent) {
        return zza(intent, new ArrayList<>());
    }

    @VisibleForTesting
    private final ResolveInfo zza(Intent intent, ArrayList<ResolveInfo> arrayList) {
        ResolveInfo resolveInfo = null;
        try {
            PackageManager packageManager = this.mContext.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 65536);
            if (queryIntentActivities != null && resolveActivity != null) {
                int i = 0;
                while (true) {
                    if (i >= queryIntentActivities.size()) {
                        break;
                    }
                    ResolveInfo resolveInfo2 = queryIntentActivities.get(i);
                    if (resolveActivity != null && resolveActivity.activityInfo.name.equals(resolveInfo2.activityInfo.name)) {
                        resolveInfo = resolveActivity;
                        break;
                    }
                    i++;
                }
            }
            arrayList.addAll(queryIntentActivities);
            return resolveInfo;
        } catch (Throwable th) {
            zzbv.zzlj().zza(th, "OpenSystemBrowserHandler.getDefaultBrowserResolverForIntent");
        }
    }

    private static Intent zza(Intent intent, ResolveInfo resolveInfo) {
        Intent intent2 = new Intent(intent);
        intent2.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
        return intent2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00c4 A[ADDED_TO_REGION] */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.content.Intent zzi(java.util.Map<java.lang.String, java.lang.String> r12) {
        /*
        // Method dump skipped, instructions count: 297
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.gmsg.zzad.zzi(java.util.Map):android.content.Intent");
    }
}
