package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseIntArray;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@SuppressLint({"InlinedApi"})
@TargetApi(16)
public final class zzkc {
    private static final zzjx zzavi = zzjx.zzt("OMX.google.raw.decoder");
    private static final Pattern zzavj = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap<zza, List<zzjx>> zzavk = new HashMap<>();
    private static final SparseIntArray zzavl;
    private static final SparseIntArray zzavm;
    private static final Map<String, Integer> zzavn;
    private static int zzavo = -1;

    public static zzjx zzeq() {
        return zzavi;
    }

    public static zzjx zzb(String str, boolean z) throws zzke {
        List<zzjx> zzc = zzc(str, z);
        if (zzc.isEmpty()) {
            return null;
        }
        return zzc.get(0);
    }

    /* access modifiers changed from: package-private */
    public static final class zza {
        public final String mimeType;
        public final boolean zzatr;

        public zza(String str, boolean z) {
            this.mimeType = str;
            this.zzatr = z;
        }

        public final int hashCode() {
            String str = this.mimeType;
            return (((str == null ? 0 : str.hashCode()) + 31) * 31) + (this.zzatr ? 1231 : 1237);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != zza.class) {
                return false;
            }
            zza zza = (zza) obj;
            return TextUtils.equals(this.mimeType, zza.mimeType) && this.zzatr == zza.zzatr;
        }
    }

    private static synchronized List<zzjx> zzc(String str, boolean z) throws zzke {
        synchronized (zzkc.class) {
            zza zza2 = new zza(str, z);
            List<zzjx> list = zzavk.get(zza2);
            if (list != null) {
                return list;
            }
            List<zzjx> zza3 = zza(zza2, zzqe.SDK_INT >= 21 ? new zzkh(z) : new zzkg());
            if (z && zza3.isEmpty() && 21 <= zzqe.SDK_INT && zzqe.SDK_INT <= 23) {
                zza3 = zza(zza2, new zzkg());
                if (!zza3.isEmpty()) {
                    String str2 = zza3.get(0).name;
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63 + String.valueOf(str2).length());
                    sb.append("MediaCodecList API didn't list secure decoder for: ");
                    sb.append(str);
                    sb.append(". Assuming: ");
                    sb.append(str2);
                    Log.w("MediaCodecUtil", sb.toString());
                }
            }
            List<zzjx> unmodifiableList = Collections.unmodifiableList(zza3);
            zzavk.put(zza2, unmodifiableList);
            return unmodifiableList;
        }
    }

    public static int zzer() throws zzke {
        int i;
        if (zzavo == -1) {
            int i2 = 0;
            zzjx zzb = zzb("video/avc", false);
            if (zzb != null) {
                MediaCodecInfo.CodecProfileLevel[] zzej = zzb.zzej();
                int length = zzej.length;
                int i3 = 0;
                while (i2 < length) {
                    switch (zzej[i2].level) {
                        case 1:
                            i = 25344;
                            break;
                        case 2:
                            i = 25344;
                            break;
                        case 8:
                            i = 101376;
                            break;
                        case 16:
                            i = 101376;
                            break;
                        case 32:
                            i = 101376;
                            break;
                        case 64:
                            i = 202752;
                            break;
                        case 128:
                            i = 414720;
                            break;
                        case 256:
                            i = 414720;
                            break;
                        case 512:
                            i = 921600;
                            break;
                        case 1024:
                            i = 1310720;
                            break;
                        case 2048:
                            i = 2097152;
                            break;
                        case 4096:
                            i = 2097152;
                            break;
                        case 8192:
                            i = 2228224;
                            break;
                        case 16384:
                            i = 5652480;
                            break;
                        case 32768:
                            i = 9437184;
                            break;
                        case 65536:
                            i = 9437184;
                            break;
                        default:
                            i = -1;
                            break;
                    }
                    i3 = Math.max(i, i3);
                    i2++;
                }
                i2 = Math.max(i3, zzqe.SDK_INT >= 21 ? 345600 : 172800);
            }
            zzavo = i2;
        }
        return zzavo;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
        if (r3.equals("hev1") != false) goto L_0x0041;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> zzw(java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 284
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkc.zzw(java.lang.String):android.util.Pair");
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x01bb A[Catch:{ Exception -> 0x02af }] */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x02a8 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<com.google.android.gms.internal.ads.zzjx> zza(com.google.android.gms.internal.ads.zzkc.zza r16, com.google.android.gms.internal.ads.zzkf r17) throws com.google.android.gms.internal.ads.zzke {
        /*
        // Method dump skipped, instructions count: 696
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkc.zza(com.google.android.gms.internal.ads.zzkc$zza, com.google.android.gms.internal.ads.zzkf):java.util.List");
    }

    private static Pair<Integer, Integer> zza(String str, String[] strArr) {
        Integer num;
        Integer num2;
        if (strArr.length < 2) {
            String valueOf = String.valueOf(str);
            Log.w("MediaCodecUtil", valueOf.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf) : new String("Ignoring malformed AVC codec string: "));
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                Integer valueOf2 = Integer.valueOf(Integer.parseInt(strArr[1].substring(0, 2), 16));
                num = Integer.valueOf(Integer.parseInt(strArr[1].substring(4), 16));
                num2 = valueOf2;
            } else if (strArr.length >= 3) {
                num2 = Integer.valueOf(Integer.parseInt(strArr[1]));
                num = Integer.valueOf(Integer.parseInt(strArr[2]));
            } else {
                String valueOf3 = String.valueOf(str);
                Log.w("MediaCodecUtil", valueOf3.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf3) : new String("Ignoring malformed AVC codec string: "));
                return null;
            }
            Integer valueOf4 = Integer.valueOf(zzavl.get(num2.intValue()));
            if (valueOf4 == null) {
                String valueOf5 = String.valueOf(num2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf5).length() + 21);
                sb.append("Unknown AVC profile: ");
                sb.append(valueOf5);
                Log.w("MediaCodecUtil", sb.toString());
                return null;
            }
            Integer valueOf6 = Integer.valueOf(zzavm.get(num.intValue()));
            if (valueOf6 != null) {
                return new Pair<>(valueOf4, valueOf6);
            }
            String valueOf7 = String.valueOf(num);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf7).length() + 19);
            sb2.append("Unknown AVC level: ");
            sb2.append(valueOf7);
            Log.w("MediaCodecUtil", sb2.toString());
            return null;
        } catch (NumberFormatException unused) {
            String valueOf8 = String.valueOf(str);
            Log.w("MediaCodecUtil", valueOf8.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf8) : new String("Ignoring malformed AVC codec string: "));
            return null;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        zzavl = sparseIntArray;
        sparseIntArray.put(66, 1);
        zzavl.put(77, 2);
        zzavl.put(88, 4);
        zzavl.put(100, 8);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        zzavm = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        zzavm.put(11, 4);
        zzavm.put(12, 8);
        zzavm.put(13, 16);
        zzavm.put(20, 32);
        zzavm.put(21, 64);
        zzavm.put(22, 128);
        zzavm.put(30, 256);
        zzavm.put(31, 512);
        zzavm.put(32, 1024);
        zzavm.put(40, 2048);
        zzavm.put(41, 4096);
        zzavm.put(42, 8192);
        zzavm.put(50, 16384);
        zzavm.put(51, 32768);
        zzavm.put(52, 65536);
        HashMap hashMap = new HashMap();
        zzavn = hashMap;
        hashMap.put("L30", 1);
        zzavn.put("L60", 4);
        zzavn.put("L63", 16);
        zzavn.put("L90", 64);
        zzavn.put("L93", 256);
        zzavn.put("L120", 1024);
        zzavn.put("L123", 4096);
        zzavn.put("L150", 16384);
        zzavn.put("L153", 65536);
        zzavn.put("L156", 262144);
        zzavn.put("L180", 1048576);
        zzavn.put("L183", 4194304);
        zzavn.put("L186", 16777216);
        zzavn.put("H30", 2);
        zzavn.put("H60", 8);
        zzavn.put("H63", 32);
        zzavn.put("H90", 128);
        zzavn.put("H93", 512);
        zzavn.put("H120", 2048);
        zzavn.put("H123", 8192);
        zzavn.put("H150", 32768);
        zzavn.put("H153", 131072);
        zzavn.put("H156", 524288);
        zzavn.put("H180", 2097152);
        zzavn.put("H183", 8388608);
        zzavn.put("H186", 33554432);
    }
}
