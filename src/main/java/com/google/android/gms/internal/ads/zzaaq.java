package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
public final class zzaaq {
    @VisibleForTesting
    private Context mContext;
    @VisibleForTesting
    private String zzbuk;
    @VisibleForTesting
    private String zzcyt;
    @VisibleForTesting
    private BlockingQueue<zzaba> zzcyv = new ArrayBlockingQueue(100);
    @VisibleForTesting
    private ExecutorService zzcyw;
    @VisibleForTesting
    private LinkedHashMap<String, String> zzcyx = new LinkedHashMap<>();
    @VisibleForTesting
    private Map<String, zzaau> zzcyy = new HashMap();
    private AtomicBoolean zzcyz;
    private File zzcza;

    public final void zza(Context context, String str, String str2, Map<String, String> map) {
        File externalStorageDirectory;
        this.mContext = context;
        this.zzbuk = str;
        this.zzcyt = str2;
        this.zzcyz = new AtomicBoolean(false);
        this.zzcyz.set(((Boolean) zzwu.zzpz().zzd(zzaan.zzcpy)).booleanValue());
        if (this.zzcyz.get() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
            this.zzcza = new File(externalStorageDirectory, "sdk_csi_data.txt");
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.zzcyx.put(entry.getKey(), entry.getValue());
        }
        this.zzcyw = Executors.newSingleThreadExecutor();
        this.zzcyw.execute(new zzaar(this));
        this.zzcyy.put("action", zzaau.zzczd);
        this.zzcyy.put("ad_format", zzaau.zzczd);
        this.zzcyy.put("e", zzaau.zzcze);
    }

    public final void zzg(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            this.zzcyx.put("e", TextUtils.join(",", list));
        }
    }

    public final boolean zza(zzaba zzaba) {
        return this.zzcyv.offer(zzaba);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009f A[SYNTHETIC, Splitter:B:31:0x009f] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ae A[SYNTHETIC, Splitter:B:36:0x00ae] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0000 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzrc() {
        /*
        // Method dump skipped, instructions count: 211
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaaq.zzrc():void");
    }

    /* access modifiers changed from: package-private */
    public final Map<String, String> zza(Map<String, String> map, @Nullable Map<String, String> map2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        if (map2 == null) {
            return linkedHashMap;
        }
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            String key = entry.getKey();
            String str = (String) linkedHashMap.get(key);
            linkedHashMap.put(key, zzbn(key).zzf(str, entry.getValue()));
        }
        return linkedHashMap;
    }

    public final zzaau zzbn(String str) {
        zzaau zzaau = this.zzcyy.get(str);
        if (zzaau != null) {
            return zzaau;
        }
        return zzaau.zzczc;
    }
}
