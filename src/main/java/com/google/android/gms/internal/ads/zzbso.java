package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* access modifiers changed from: package-private */
public final class zzbso {
    static String zza(zzbsl zzbsl, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zza(zzbsl, sb, 0);
        return sb.toString();
    }

    private static void zza(zzbsl zzbsl, StringBuilder sb, int i) {
        boolean z;
        boolean z2;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet();
        Method[] declaredMethods = zzbsl.getClass().getDeclaredMethods();
        for (Method method : declaredMethods) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str : treeSet) {
            String replaceFirst = str.replaceFirst("get", "");
            if (replaceFirst.endsWith("List") && !replaceFirst.endsWith("OrBuilderList") && !replaceFirst.equals("List")) {
                String valueOf = String.valueOf(replaceFirst.substring(0, 1).toLowerCase());
                String valueOf2 = String.valueOf(replaceFirst.substring(1, replaceFirst.length() - 4));
                String concat = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                Method method2 = (Method) hashMap.get(str);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    zza(sb, i, zzgb(concat), zzbrd.zza(method2, zzbsl, new Object[0]));
                }
            }
            if (replaceFirst.endsWith("Map") && !replaceFirst.equals("Map")) {
                String valueOf3 = String.valueOf(replaceFirst.substring(0, 1).toLowerCase());
                String valueOf4 = String.valueOf(replaceFirst.substring(1, replaceFirst.length() - 3));
                String concat2 = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
                Method method3 = (Method) hashMap.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    zza(sb, i, zzgb(concat2), zzbrd.zza(method3, zzbsl, new Object[0]));
                }
            }
            String valueOf5 = String.valueOf(replaceFirst);
            if (((Method) hashMap2.get(valueOf5.length() != 0 ? "set".concat(valueOf5) : new String("set"))) != null) {
                if (replaceFirst.endsWith("Bytes")) {
                    String valueOf6 = String.valueOf(replaceFirst.substring(0, replaceFirst.length() - 5));
                    if (hashMap.containsKey(valueOf6.length() != 0 ? "get".concat(valueOf6) : new String("get"))) {
                    }
                }
                String valueOf7 = String.valueOf(replaceFirst.substring(0, 1).toLowerCase());
                String valueOf8 = String.valueOf(replaceFirst.substring(1));
                String concat3 = valueOf8.length() != 0 ? valueOf7.concat(valueOf8) : new String(valueOf7);
                String valueOf9 = String.valueOf(replaceFirst);
                Method method4 = (Method) hashMap.get(valueOf9.length() != 0 ? "get".concat(valueOf9) : new String("get"));
                String valueOf10 = String.valueOf(replaceFirst);
                Method method5 = (Method) hashMap.get(valueOf10.length() != 0 ? "has".concat(valueOf10) : new String("has"));
                if (method4 != null) {
                    Object zza = zzbrd.zza(method4, zzbsl, new Object[0]);
                    if (method5 == null) {
                        if (zza instanceof Boolean) {
                            z2 = !((Boolean) zza).booleanValue();
                        } else if (zza instanceof Integer) {
                            z2 = ((Integer) zza).intValue() == 0;
                        } else if (zza instanceof Float) {
                            z2 = ((Float) zza).floatValue() == 0.0f;
                        } else if (zza instanceof Double) {
                            z2 = ((Double) zza).doubleValue() == 0.0d;
                        } else if (zza instanceof String) {
                            z2 = zza.equals("");
                        } else if (zza instanceof zzbpu) {
                            z2 = zza.equals(zzbpu.zzfli);
                        } else if (zza instanceof zzbsl) {
                            z2 = zza == ((zzbsl) zza).zzamv();
                        } else {
                            z2 = zza instanceof Enum ? ((Enum) zza).ordinal() == 0 : false;
                        }
                        z = !z2;
                    } else {
                        z = ((Boolean) zzbrd.zza(method5, zzbsl, new Object[0])).booleanValue();
                    }
                    if (z) {
                        zza(sb, i, zzgb(concat3), zza);
                    }
                }
            }
        }
        if (zzbsl instanceof zzbrd.zzc) {
            Iterator<Map.Entry<Object, Object>> it = ((zzbrd.zzc) zzbsl).zzfqa.iterator();
            if (it.hasNext()) {
                it.next().getKey();
                throw new NoSuchMethodError();
            }
        }
        zzbrd zzbrd = (zzbrd) zzbsl;
        if (zzbrd.zzfpu != null) {
            zzbrd.zzfpu.zza(sb, i);
        }
    }

    static final void zza(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                zza(sb, i, str, obj2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                zza(sb, i, str, entry);
            }
        } else {
            sb.append('\n');
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(zzbtq.zzaq(zzbpu.zzfw((String) obj)));
                sb.append('\"');
            } else if (obj instanceof zzbpu) {
                sb.append(": \"");
                sb.append(zzbtq.zzaq((zzbpu) obj));
                sb.append('\"');
            } else if (obj instanceof zzbrd) {
                sb.append(" {");
                zza((zzbrd) obj, sb, i + 2);
                sb.append("\n");
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry2 = (Map.Entry) obj;
                int i4 = i + 2;
                zza(sb, i4, "key", entry2.getKey());
                zza(sb, i4, "value", entry2.getValue());
                sb.append("\n");
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj.toString());
            }
        }
    }

    private static final String zzgb(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }
}
