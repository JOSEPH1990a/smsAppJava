package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.internal.ads.zzhp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public final class zznk extends DefaultHandler implements zzpm<zznj> {
    private static final Pattern zzbcz = Pattern.compile("(\\d+)(?:/(\\d+))?");
    private static final Pattern zzbda = Pattern.compile("CC([1-4])=.*");
    private static final Pattern zzbdb = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");
    private final String zzbdc;
    private final XmlPullParserFactory zzbdd;

    public zznk() {
        this(null);
    }

    private zznk(String str) {
        this.zzbdc = null;
        try {
            this.zzbdd = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x05fa A[Catch:{ XmlPullParserException -> 0x08ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x05fd A[Catch:{ XmlPullParserException -> 0x08ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x061b A[Catch:{ XmlPullParserException -> 0x08ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x0641 A[Catch:{ XmlPullParserException -> 0x08ac }, LOOP:4: B:97:0x0384->B:241:0x0641, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x0759 A[Catch:{ XmlPullParserException -> 0x08ac }, LOOP:2: B:53:0x01d8->B:275:0x0759, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x082f A[Catch:{ XmlPullParserException -> 0x08ac }, LOOP:1: B:45:0x011a->B:299:0x082f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:316:0x087d A[Catch:{ XmlPullParserException -> 0x08ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x088f A[Catch:{ XmlPullParserException -> 0x08ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x0897 A[Catch:{ XmlPullParserException -> 0x08ac }, LOOP:0: B:30:0x0093->B:320:0x0897, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:326:0x085b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:329:0x07bd A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:330:0x06c1 A[EDGE_INSN: B:330:0x06c1->B:258:0x06c1 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:332:0x0429 A[EDGE_INSN: B:332:0x0429->B:124:0x0429 ?: BREAK  , SYNTHETIC] */
    /* renamed from: zzc */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zznj zzb(android.net.Uri r77, java.io.InputStream r78) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 2228
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zznk.zzb(android.net.Uri, java.io.InputStream):com.google.android.gms.internal.ads.zznj");
    }

    private static int zza(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "contentType");
        if (TextUtils.isEmpty(attributeValue)) {
            return -1;
        }
        if ("audio".equals(attributeValue)) {
            return 1;
        }
        if ("video".equals(attributeValue)) {
            return 2;
        }
        return "text".equals(attributeValue) ? 3 : -1;
    }

    private static zzhp.zza zzb(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        boolean equals = "urn:uuid:9a04f079-9840-4286-ab92-e65be0885f95".equals(xmlPullParser.getAttributeValue(null, "schemeIdUri"));
        byte[] bArr = null;
        UUID uuid = null;
        boolean z = false;
        do {
            xmlPullParser.next();
            if (bArr == null && zzqg.zzd(xmlPullParser, "cenc:pssh") && xmlPullParser.next() == 4) {
                bArr = Base64.decode(xmlPullParser.getText(), 0);
                uuid = zzjq.zze(bArr);
                if (uuid == null) {
                    Log.w("MpdParser", "Skipping malformed cenc:pssh data");
                    bArr = null;
                }
            } else if (bArr == null && equals && zzqg.zzd(xmlPullParser, "mspr:pro") && xmlPullParser.next() == 4) {
                bArr = zzjq.zza(zzfe.zzwp, Base64.decode(xmlPullParser.getText(), 0));
                uuid = zzfe.zzwp;
            } else if (zzqg.zzd(xmlPullParser, "widevine:license")) {
                String attributeValue = xmlPullParser.getAttributeValue(null, "robustness_level");
                z = attributeValue != null && attributeValue.startsWith("HW");
            }
        } while (!zzqg.zzc(xmlPullParser, "ContentProtection"));
        if (bArr != null) {
            return new zzhp.zza(uuid, "video/mp4", bArr, z);
        }
        return null;
    }

    private final zzny zza(XmlPullParser xmlPullParser, zzny zzny) throws XmlPullParserException, IOException {
        long j;
        long j2;
        long zzb = zzb(xmlPullParser, "timescale", zzny != null ? zzny.zzcr : 1);
        long j3 = 0;
        long zzb2 = zzb(xmlPullParser, "presentationTimeOffset", zzny != null ? zzny.zzbdw : 0);
        long j4 = zzny != null ? zzny.zzbec : 0;
        if (zzny != null) {
            j3 = zzny.zzbed;
        }
        zzno zzno = null;
        String attributeValue = xmlPullParser.getAttributeValue(null, "indexRange");
        if (attributeValue != null) {
            String[] split = attributeValue.split("-");
            j2 = Long.parseLong(split[0]);
            j = (Long.parseLong(split[1]) - j2) + 1;
        } else {
            j = j3;
            j2 = j4;
        }
        if (zzny != null) {
            zzno = zzny.zzbdv;
        }
        do {
            xmlPullParser.next();
            if (zzqg.zzd(xmlPullParser, "Initialization")) {
                zzno = zzd(xmlPullParser);
            }
        } while (!zzqg.zzc(xmlPullParser, "SegmentBase"));
        return new zzny(zzno, zzb, zzb2, j2, j);
    }

    private final zznv zza(XmlPullParser xmlPullParser, zznv zznv) throws XmlPullParserException, IOException {
        List list;
        List<zznx> list2;
        zzno zzno;
        long zzb = zzb(xmlPullParser, "timescale", zznv != null ? zznv.zzcr : 1);
        long zzb2 = zzb(xmlPullParser, "presentationTimeOffset", zznv != null ? zznv.zzbdw : 0);
        long zzb3 = zzb(xmlPullParser, "duration", zznv != null ? zznv.zzcs : -9223372036854775807L);
        int zza = zza(xmlPullParser, "startNumber", zznv != null ? zznv.zzbdx : 1);
        List list3 = null;
        zzno zzno2 = null;
        List<zznx> list4 = null;
        do {
            xmlPullParser.next();
            if (zzqg.zzd(xmlPullParser, "Initialization")) {
                zzno2 = zzd(xmlPullParser);
            } else if (zzqg.zzd(xmlPullParser, "SegmentTimeline")) {
                list4 = zzc(xmlPullParser);
            } else if (zzqg.zzd(xmlPullParser, "SegmentURL")) {
                if (list3 == null) {
                    list3 = new ArrayList();
                }
                list3.add(zza(xmlPullParser, "media", "mediaRange"));
            }
        } while (!zzqg.zzc(xmlPullParser, "SegmentList"));
        if (zznv != null) {
            if (zzno2 == null) {
                zzno2 = zznv.zzbdv;
            }
            if (list4 == null) {
                list4 = zznv.zzbdy;
            }
            if (list3 == null) {
                list3 = zznv.zzbdz;
            }
            list = list3;
            zzno = zzno2;
            list2 = list4;
        } else {
            list = list3;
            zzno = zzno2;
            list2 = list4;
        }
        return new zznv(zzno, zzb, zzb2, zza, zzb3, list2, list);
    }

    private final zznw zza(XmlPullParser xmlPullParser, zznw zznw) throws XmlPullParserException, IOException {
        List<zznx> list;
        zzno zzno;
        long zzb = zzb(xmlPullParser, "timescale", zznw != null ? zznw.zzcr : 1);
        long zzb2 = zzb(xmlPullParser, "presentationTimeOffset", zznw != null ? zznw.zzbdw : 0);
        long zzb3 = zzb(xmlPullParser, "duration", zznw != null ? zznw.zzcs : -9223372036854775807L);
        int zza = zza(xmlPullParser, "startNumber", zznw != null ? zznw.zzbdx : 1);
        zzno zzno2 = null;
        zzoa zza2 = zza(xmlPullParser, "media", zznw != null ? zznw.zzbeb : null);
        zzoa zza3 = zza(xmlPullParser, "initialization", zznw != null ? zznw.zzbea : null);
        List<zznx> list2 = null;
        do {
            xmlPullParser.next();
            if (zzqg.zzd(xmlPullParser, "Initialization")) {
                zzno2 = zzd(xmlPullParser);
            } else if (zzqg.zzd(xmlPullParser, "SegmentTimeline")) {
                list2 = zzc(xmlPullParser);
            }
        } while (!zzqg.zzc(xmlPullParser, "SegmentTemplate"));
        if (zznw != null) {
            if (zzno2 == null) {
                zzno2 = zznw.zzbdv;
            }
            if (list2 == null) {
                list2 = zznw.zzbdy;
            }
            list = list2;
            zzno = zzno2;
        } else {
            list = list2;
            zzno = zzno2;
        }
        return new zznw(zzno, zzb, zzb2, zza, zzb3, list, zza3, zza2);
    }

    private static List<zznx> zzc(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        long j = 0;
        do {
            xmlPullParser.next();
            if (zzqg.zzd(xmlPullParser, "S")) {
                j = zzb(xmlPullParser, "t", j);
                long zzb = zzb(xmlPullParser, "d", -9223372036854775807L);
                int zza = zza(xmlPullParser, "r", 0) + 1;
                for (int i = 0; i < zza; i++) {
                    arrayList.add(new zznx(j, zzb));
                    j += zzb;
                }
            }
        } while (!zzqg.zzc(xmlPullParser, "SegmentTimeline"));
        return arrayList;
    }

    private static zzoa zza(XmlPullParser xmlPullParser, String str, zzoa zzoa) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue != null ? zzoa.zzaa(attributeValue) : zzoa;
    }

    private final zzno zzd(XmlPullParser xmlPullParser) {
        return zza(xmlPullParser, "sourceURL", "range");
    }

    private static zzno zza(XmlPullParser xmlPullParser, String str, String str2) {
        long j;
        long j2;
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, str2);
        if (attributeValue2 != null) {
            String[] split = attributeValue2.split("-");
            long parseLong = Long.parseLong(split[0]);
            if (split.length == 2) {
                j = (Long.parseLong(split[1]) - parseLong) + 1;
                j2 = parseLong;
            } else {
                j = -1;
                j2 = parseLong;
            }
        } else {
            j = -1;
            j2 = 0;
        }
        return new zzno(attributeValue, j2, j);
    }

    private static int zze(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i = -1;
        if ("urn:mpeg:dash:23003:3:audio_channel_configuration:2011".equals(zzb(xmlPullParser, "schemeIdUri", (String) null))) {
            i = zza(xmlPullParser, "value", -1);
        }
        do {
            xmlPullParser.next();
        } while (!zzqg.zzc(xmlPullParser, "AudioChannelConfiguration"));
        return i;
    }

    private static boolean zzx(String str) {
        return zzpt.zzad(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/cea-708".equals(str) || "application/cea-608".equals(str);
    }

    private static int zzd(int i, int i2) {
        if (i == -1) {
            return i2;
        }
        if (i2 == -1) {
            return i;
        }
        zzpo.checkState(i == i2);
        return i;
    }

    private static zznm zza(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String zzb = zzb(xmlPullParser, "schemeIdUri", "");
        String zzb2 = zzb(xmlPullParser, "value", (String) null);
        String zzb3 = zzb(xmlPullParser, "id", (String) null);
        do {
            xmlPullParser.next();
        } while (!zzqg.zzc(xmlPullParser, str));
        return new zznm(zzb, zzb2, zzb3);
    }

    private static float zza(XmlPullParser xmlPullParser, float f) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "frameRate");
        if (attributeValue == null) {
            return f;
        }
        Matcher matcher = zzbcz.matcher(attributeValue);
        if (!matcher.matches()) {
            return f;
        }
        int parseInt = Integer.parseInt(matcher.group(1));
        String group = matcher.group(2);
        return !TextUtils.isEmpty(group) ? ((float) parseInt) / ((float) Integer.parseInt(group)) : (float) parseInt;
    }

    private static long zza(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue == null) {
            return j;
        }
        return zzqe.zzak(attributeValue);
    }

    private static String zzb(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        xmlPullParser.next();
        return zzqd.zzc(str, xmlPullParser.getText());
    }

    private static int zza(XmlPullParser xmlPullParser, String str, int i) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue == null) {
            return i;
        }
        return Integer.parseInt(attributeValue);
    }

    private static long zzb(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue == null) {
            return j;
        }
        return Long.parseLong(attributeValue);
    }

    private static String zzb(XmlPullParser xmlPullParser, String str, String str2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? str2 : attributeValue;
    }
}
