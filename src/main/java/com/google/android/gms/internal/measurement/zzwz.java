package com.google.android.gms.internal.measurement;

/* access modifiers changed from: package-private */
public final class zzwz {
    static String zzd(zzte zzte) {
        zzxa zzxa = new zzxa(zzte);
        StringBuilder sb = new StringBuilder(zzxa.size());
        for (int i = 0; i < zzxa.size(); i++) {
            byte zzam = zzxa.zzam(i);
            if (zzam == 34) {
                sb.append("\\\"");
            } else if (zzam == 39) {
                sb.append("\\'");
            } else if (zzam != 92) {
                switch (zzam) {
                    case 7:
                        sb.append("\\a");
                        continue;
                    case 8:
                        sb.append("\\b");
                        continue;
                    case 9:
                        sb.append("\\t");
                        continue;
                    case 10:
                        sb.append("\\n");
                        continue;
                    case 11:
                        sb.append("\\v");
                        continue;
                    case 12:
                        sb.append("\\f");
                        continue;
                    case 13:
                        sb.append("\\r");
                        continue;
                    default:
                        if (zzam < 32 || zzam > 126) {
                            sb.append('\\');
                            sb.append((char) (((zzam >>> 6) & 3) + 48));
                            sb.append((char) (((zzam >>> 3) & 7) + 48));
                            sb.append((char) ((zzam & 7) + 48));
                            break;
                        } else {
                            sb.append((char) zzam);
                            continue;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}
