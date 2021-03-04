package com.google.android.gms.measurement.internal;

import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzfj;
import com.google.android.gms.internal.measurement.zzfk;
import com.google.android.gms.internal.measurement.zzfl;
import com.google.android.gms.internal.measurement.zzfm;
import com.google.android.gms.internal.measurement.zzfn;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzfu;
import com.google.android.gms.internal.measurement.zzfz;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* access modifiers changed from: package-private */
public final class zzm extends zzfn {
    zzm(zzfo zzfo) {
        super(zzfo);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.measurement.internal.zzfn
    public final boolean zzgy() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x02de  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x02ff  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0338  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x039b  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x03f3  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0447  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x045b  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x046a  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x02c1  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzfr[] zza(java.lang.String r66, com.google.android.gms.internal.measurement.zzft[] r67, com.google.android.gms.internal.measurement.zzfz[] r68) {
        /*
        // Method dump skipped, instructions count: 3519
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzm.zza(java.lang.String, com.google.android.gms.internal.measurement.zzft[], com.google.android.gms.internal.measurement.zzfz[]):com.google.android.gms.internal.measurement.zzfr[]");
    }

    private final Boolean zza(zzfj zzfj, String str, zzfu[] zzfuArr, long j) {
        Boolean bool;
        if (zzfj.zzavo != null) {
            Boolean zza = zza(j, zzfj.zzavo);
            if (zza == null) {
                return null;
            }
            if (!zza.booleanValue()) {
                return false;
            }
        }
        HashSet hashSet = new HashSet();
        zzfk[] zzfkArr = zzfj.zzavm;
        for (zzfk zzfk : zzfkArr) {
            if (TextUtils.isEmpty(zzfk.zzavt)) {
                zzgt().zzjj().zzg("null or empty param name in filter. event", zzgq().zzbt(str));
                return null;
            }
            hashSet.add(zzfk.zzavt);
        }
        ArrayMap arrayMap = new ArrayMap();
        for (zzfu zzfu : zzfuArr) {
            if (hashSet.contains(zzfu.name)) {
                if (zzfu.zzaxe != null) {
                    arrayMap.put(zzfu.name, zzfu.zzaxe);
                } else if (zzfu.zzaun != null) {
                    arrayMap.put(zzfu.name, zzfu.zzaun);
                } else if (zzfu.zzaml != null) {
                    arrayMap.put(zzfu.name, zzfu.zzaml);
                } else {
                    zzgt().zzjj().zze("Unknown value for param. event, param", zzgq().zzbt(str), zzgq().zzbu(zzfu.name));
                    return null;
                }
            }
        }
        zzfk[] zzfkArr2 = zzfj.zzavm;
        for (zzfk zzfk2 : zzfkArr2) {
            boolean equals = Boolean.TRUE.equals(zzfk2.zzavs);
            String str2 = zzfk2.zzavt;
            if (TextUtils.isEmpty(str2)) {
                zzgt().zzjj().zzg("Event has empty param name. event", zzgq().zzbt(str));
                return null;
            }
            Object obj = arrayMap.get(str2);
            if (obj instanceof Long) {
                if (zzfk2.zzavr == null) {
                    zzgt().zzjj().zze("No number filter for long param. event, param", zzgq().zzbt(str), zzgq().zzbu(str2));
                    return null;
                }
                Boolean zza2 = zza(((Long) obj).longValue(), zzfk2.zzavr);
                if (zza2 == null) {
                    return null;
                }
                if ((true ^ zza2.booleanValue()) ^ equals) {
                    return false;
                }
            } else if (obj instanceof Double) {
                if (zzfk2.zzavr == null) {
                    zzgt().zzjj().zze("No number filter for double param. event, param", zzgq().zzbt(str), zzgq().zzbu(str2));
                    return null;
                }
                Boolean zza3 = zza(((Double) obj).doubleValue(), zzfk2.zzavr);
                if (zza3 == null) {
                    return null;
                }
                if ((true ^ zza3.booleanValue()) ^ equals) {
                    return false;
                }
            } else if (obj instanceof String) {
                if (zzfk2.zzavq != null) {
                    bool = zza((String) obj, zzfk2.zzavq);
                } else if (zzfk2.zzavr != null) {
                    String str3 = (String) obj;
                    if (zzfu.zzcs(str3)) {
                        bool = zza(str3, zzfk2.zzavr);
                    } else {
                        zzgt().zzjj().zze("Invalid param value for number filter. event, param", zzgq().zzbt(str), zzgq().zzbu(str2));
                        return null;
                    }
                } else {
                    zzgt().zzjj().zze("No filter for String param. event, param", zzgq().zzbt(str), zzgq().zzbu(str2));
                    return null;
                }
                if (bool == null) {
                    return null;
                }
                if ((true ^ bool.booleanValue()) ^ equals) {
                    return false;
                }
            } else if (obj == null) {
                zzgt().zzjo().zze("Missing param for filter. event, param", zzgq().zzbt(str), zzgq().zzbu(str2));
                return false;
            } else {
                zzgt().zzjj().zze("Unknown param type. event, param", zzgq().zzbt(str), zzgq().zzbu(str2));
                return null;
            }
        }
        return true;
    }

    private final Boolean zza(zzfm zzfm, zzfz zzfz) {
        zzfk zzfk = zzfm.zzawb;
        if (zzfk == null) {
            zzgt().zzjj().zzg("Missing property filter. property", zzgq().zzbv(zzfz.name));
            return null;
        }
        boolean equals = Boolean.TRUE.equals(zzfk.zzavs);
        if (zzfz.zzaxe != null) {
            if (zzfk.zzavr != null) {
                return zza(zza(zzfz.zzaxe.longValue(), zzfk.zzavr), equals);
            }
            zzgt().zzjj().zzg("No number filter for long property. property", zzgq().zzbv(zzfz.name));
            return null;
        } else if (zzfz.zzaun != null) {
            if (zzfk.zzavr != null) {
                return zza(zza(zzfz.zzaun.doubleValue(), zzfk.zzavr), equals);
            }
            zzgt().zzjj().zzg("No number filter for double property. property", zzgq().zzbv(zzfz.name));
            return null;
        } else if (zzfz.zzaml == null) {
            zzgt().zzjj().zzg("User property has no value, property", zzgq().zzbv(zzfz.name));
            return null;
        } else if (zzfk.zzavq != null) {
            return zza(zza(zzfz.zzaml, zzfk.zzavq), equals);
        } else {
            if (zzfk.zzavr == null) {
                zzgt().zzjj().zzg("No string or number filter defined. property", zzgq().zzbv(zzfz.name));
            } else if (zzfu.zzcs(zzfz.zzaml)) {
                return zza(zza(zzfz.zzaml, zzfk.zzavr), equals);
            } else {
                zzgt().zzjj().zze("Invalid user property value for Numeric number filter. property, value", zzgq().zzbv(zzfz.name), zzfz.zzaml);
            }
            return null;
        }
    }

    @VisibleForTesting
    private static Boolean zza(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() ^ z);
    }

    @VisibleForTesting
    private final Boolean zza(String str, zzfn zzfn) {
        String str2;
        ArrayList arrayList;
        Preconditions.checkNotNull(zzfn);
        if (str == null || zzfn.zzawc == null || zzfn.zzawc.intValue() == 0) {
            return null;
        }
        if (zzfn.zzawc.intValue() == 6) {
            if (zzfn.zzawf == null || zzfn.zzawf.length == 0) {
                return null;
            }
        } else if (zzfn.zzawd == null) {
            return null;
        }
        int intValue = zzfn.zzawc.intValue();
        boolean z = zzfn.zzawe != null && zzfn.zzawe.booleanValue();
        if (z || intValue == 1 || intValue == 6) {
            str2 = zzfn.zzawd;
        } else {
            str2 = zzfn.zzawd.toUpperCase(Locale.ENGLISH);
        }
        if (zzfn.zzawf == null) {
            arrayList = null;
        } else {
            String[] strArr = zzfn.zzawf;
            if (z) {
                arrayList = Arrays.asList(strArr);
            } else {
                ArrayList arrayList2 = new ArrayList();
                for (String str3 : strArr) {
                    arrayList2.add(str3.toUpperCase(Locale.ENGLISH));
                }
                arrayList = arrayList2;
            }
        }
        return zza(str, intValue, z, str2, arrayList, intValue == 1 ? str2 : null);
    }

    private final Boolean zza(String str, int i, boolean z, String str2, List<String> list, String str3) {
        if (str == null) {
            return null;
        }
        if (i == 6) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && i != 1) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (i) {
            case 1:
                try {
                    return Boolean.valueOf(Pattern.compile(str3, z ? 0 : 66).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    zzgt().zzjj().zzg("Invalid regular expression in REGEXP audience filter. expression", str3);
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    private final Boolean zza(long j, zzfl zzfl) {
        try {
            return zza(new BigDecimal(j), zzfl, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private final Boolean zza(double d, zzfl zzfl) {
        try {
            return zza(new BigDecimal(d), zzfl, Math.ulp(d));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private final Boolean zza(String str, zzfl zzfl) {
        if (!zzfu.zzcs(str)) {
            return null;
        }
        try {
            return zza(new BigDecimal(str), zzfl, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0072, code lost:
        if (r3 != null) goto L_0x0074;
     */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Boolean zza(java.math.BigDecimal r7, com.google.android.gms.internal.measurement.zzfl r8, double r9) {
        /*
        // Method dump skipped, instructions count: 254
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzm.zza(java.math.BigDecimal, com.google.android.gms.internal.measurement.zzfl, double):java.lang.Boolean");
    }

    private static zzfs[] zzb(Map<Integer, Long> map) {
        if (map == null) {
            return null;
        }
        int i = 0;
        zzfs[] zzfsArr = new zzfs[map.size()];
        for (Integer num : map.keySet()) {
            zzfs zzfs = new zzfs();
            zzfs.zzawx = num;
            zzfs.zzawy = map.get(num);
            zzfsArr[i] = zzfs;
            i++;
        }
        return zzfsArr;
    }

    private static void zza(Map<Integer, Long> map, int i, long j) {
        Long l = map.get(Integer.valueOf(i));
        long j2 = j / 1000;
        if (l == null || j2 > l.longValue()) {
            map.put(Integer.valueOf(i), Long.valueOf(j2));
        }
    }

    private static void zzb(Map<Integer, List<Long>> map, int i, long j) {
        List<Long> list = map.get(Integer.valueOf(i));
        if (list == null) {
            list = new ArrayList<>();
            map.put(Integer.valueOf(i), list);
        }
        list.add(Long.valueOf(j / 1000));
    }
}
