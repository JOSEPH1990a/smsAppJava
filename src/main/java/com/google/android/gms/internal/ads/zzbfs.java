package com.google.android.gms.internal.ads;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@zzark
public final class zzbfs extends zzbfk {
    private static final Set<String> zzewz = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat zzexa = new DecimalFormat("#,###");
    private File zzexb;
    private boolean zzexc;

    public zzbfs(zzbdz zzbdz) {
        super(zzbdz);
        File cacheDir = this.mContext.getCacheDir();
        if (cacheDir == null) {
            zzaxz.zzeo("Context.getCacheDir() returned null");
            return;
        }
        this.zzexb = new File(cacheDir, "admobVideoStreams");
        if (!this.zzexb.isDirectory() && !this.zzexb.mkdirs()) {
            String valueOf = String.valueOf(this.zzexb.getAbsolutePath());
            zzaxz.zzeo(valueOf.length() != 0 ? "Could not create preload cache directory at ".concat(valueOf) : new String("Could not create preload cache directory at "));
            this.zzexb = null;
        } else if (!this.zzexb.setReadable(true, false) || !this.zzexb.setExecutable(true, false)) {
            String valueOf2 = String.valueOf(this.zzexb.getAbsolutePath());
            zzaxz.zzeo(valueOf2.length() != 0 ? "Could not set cache file permissions at ".concat(valueOf2) : new String("Could not set cache file permissions at "));
            this.zzexb = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:?, code lost:
        r1 = r5.getResponseCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01fb, code lost:
        if (r1 < 400) goto L_0x0245;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01fd, code lost:
        r15 = "badUrl";
        r2 = java.lang.String.valueOf(java.lang.Integer.toString(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x020d, code lost:
        if (r2.length() == 0) goto L_0x0215;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x020f, code lost:
        r2 = "HTTP request failed. Code: ".concat(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0215, code lost:
        r2 = new java.lang.String("HTTP request failed. Code: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:?, code lost:
        r4 = new java.lang.StringBuilder(java.lang.String.valueOf(r31).length() + 32);
        r4.append("HTTP status code ");
        r4.append(r1);
        r4.append(" at ");
        r4.append(r31);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0242, code lost:
        throw new java.io.IOException(r4.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0243, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0245, code lost:
        r7 = r5.getContentLength();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0249, code lost:
        if (r7 >= 0) goto L_0x0274;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x024b, code lost:
        r1 = java.lang.String.valueOf(r31);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0255, code lost:
        if (r1.length() == 0) goto L_0x025c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0257, code lost:
        r0 = "Stream cache aborted, missing content-length header at ".concat(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x025c, code lost:
        r0 = new java.lang.String("Stream cache aborted, missing content-length header at ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0262, code lost:
        com.google.android.gms.internal.ads.zzaxz.zzeo(r0);
        zza(r31, r12.getAbsolutePath(), "contentLengthMissing", null);
        com.google.android.gms.internal.ads.zzbfs.zzewz.remove(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0273, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0274, code lost:
        r1 = com.google.android.gms.internal.ads.zzbfs.zzexa.format((long) r7);
        r3 = ((java.lang.Integer) com.google.android.gms.internal.ads.zzwu.zzpz().zzd(com.google.android.gms.internal.ads.zzaan.zzcou)).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x028b, code lost:
        if (r7 <= r3) goto L_0x02e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x028d, code lost:
        r2 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 33) + java.lang.String.valueOf(r31).length());
        r2.append("Content length ");
        r2.append(r1);
        r2.append(" exceeds limit at ");
        r2.append(r31);
        com.google.android.gms.internal.ads.zzaxz.zzeo(r2.toString());
        r1 = java.lang.String.valueOf(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x02c6, code lost:
        if (r1.length() == 0) goto L_0x02cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x02c8, code lost:
        r0 = "File too big for full file cache. Size: ".concat(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x02cd, code lost:
        r0 = new java.lang.String("File too big for full file cache. Size: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x02d3, code lost:
        zza(r31, r12.getAbsolutePath(), "sizeExceeded", r0);
        com.google.android.gms.internal.ads.zzbfs.zzewz.remove(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x02e1, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x02e2, code lost:
        r4 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 20) + java.lang.String.valueOf(r31).length());
        r4.append("Caching ");
        r4.append(r1);
        r4.append(" bytes from ");
        r4.append(r31);
        com.google.android.gms.internal.ads.zzaxz.zzdn(r4.toString());
        r5 = java.nio.channels.Channels.newChannel(r5.getInputStream());
        r4 = new java.io.FileOutputStream(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:?, code lost:
        r2 = r4.getChannel();
        r1 = java.nio.ByteBuffer.allocate(1048576);
        r16 = com.google.android.gms.ads.internal.zzbv.zzlm();
        r17 = r16.currentTimeMillis();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x033b, code lost:
        r10 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:?, code lost:
        r6 = new com.google.android.gms.internal.ads.zzbai(((java.lang.Long) com.google.android.gms.internal.ads.zzwu.zzpz().zzd(com.google.android.gms.internal.ads.zzaan.zzcox)).longValue());
        r13 = ((java.lang.Long) com.google.android.gms.internal.ads.zzwu.zzpz().zzd(com.google.android.gms.internal.ads.zzaan.zzcow)).longValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0355, code lost:
        r20 = r5.read(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0359, code lost:
        if (r20 < 0) goto L_0x0469;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x035b, code lost:
        r11 = r11 + r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x035d, code lost:
        if (r11 <= r3) goto L_0x038e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x035f, code lost:
        r15 = "sizeExceeded";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:?, code lost:
        r1 = java.lang.String.valueOf(java.lang.Integer.toString(r11));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x036f, code lost:
        if (r1.length() == 0) goto L_0x0377;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0371, code lost:
        r1 = "File too big for full file cache. Size: ".concat(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0377, code lost:
        r1 = new java.lang.String("File too big for full file cache. Size: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0383, code lost:
        throw new java.io.IOException("stream cache file size limit exceeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0384, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0385, code lost:
        r2 = r1;
        r1 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0388, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0389, code lost:
        r1 = r10;
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x038b, code lost:
        r10 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:?, code lost:
        r1.flip();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0395, code lost:
        if (r2.write(r1) > 0) goto L_0x045d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0397, code lost:
        r1.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x03a6, code lost:
        if ((r16.currentTimeMillis() - r17) > (1000 * r13)) goto L_0x041f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x03ac, code lost:
        if (r30.zzexc != false) goto L_0x040f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x03b2, code lost:
        if (r6.tryAcquire() == false) goto L_0x03e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x03ba, code lost:
        r22 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x03be, code lost:
        r24 = r10;
        r25 = r2;
        r26 = r3;
        r27 = r4;
        r21 = r5;
        r19 = r6;
        r29 = r7;
        com.google.android.gms.internal.ads.zzbat.zztu.post(new com.google.android.gms.internal.ads.zzbfl(r30, r31, r12.getAbsolutePath(), r11, r7, false));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x03e3, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x03e4, code lost:
        r27 = r4;
        r1 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x03e9, code lost:
        r25 = r2;
        r26 = r3;
        r27 = r4;
        r21 = r5;
        r19 = r6;
        r29 = r7;
        r24 = r10;
        r22 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x03fb, code lost:
        r6 = r19;
        r1 = r1;
        r5 = r21;
        r15 = r22;
        r10 = r24;
        r2 = r25;
        r3 = r26;
        r4 = r27;
        r7 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x041e, code lost:
        throw new java.io.IOException("abort requested");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x041f, code lost:
        r27 = r4;
        r15 = "downloadTimeout";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:?, code lost:
        r0 = java.lang.Long.toString(r13);
        r2 = new java.lang.StringBuilder(java.lang.String.valueOf(r0).length() + 29);
        r2.append("Timeout exceeded. Limit: ");
        r2.append(r0);
        r2.append(" sec");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0452, code lost:
        throw new java.io.IOException("stream cache time limit exceeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x0453, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x0454, code lost:
        r2 = r2.toString();
        r1 = r10;
        r10 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x045b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0461, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0462, code lost:
        r27 = r4;
        r1 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x0469, code lost:
        r27 = r4;
        r22 = r15;
        r27.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x0478, code lost:
        if (com.google.android.gms.internal.ads.zzaxz.isLoggable(3) == false) goto L_0x04b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x047a, code lost:
        r1 = com.google.android.gms.internal.ads.zzbfs.zzexa.format((long) r11);
        r3 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 22) + java.lang.String.valueOf(r31).length());
        r3.append("Preloaded ");
        r3.append(r1);
        r3.append(" bytes from ");
        r3.append(r31);
        com.google.android.gms.internal.ads.zzaxz.zzdn(r3.toString());
        r1 = false;
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x04b6, code lost:
        r1 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x04b9, code lost:
        r1 = false;
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:?, code lost:
        r12.setReadable(r2, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x04c2, code lost:
        if (r0.isFile() == false) goto L_0x04cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x04c4, code lost:
        r0.setLastModified(java.lang.System.currentTimeMillis());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:?, code lost:
        r0.createNewFile();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x04e1, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x04e2, code lost:
        r1 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x04e7, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x04e8, code lost:
        r27 = r4;
        r1 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x04ec, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x04ed, code lost:
        r27 = r4;
        r1 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x04f6, code lost:
        r1 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x0500, code lost:
        throw new java.io.IOException("Invalid protocol.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x050b, code lost:
        throw new java.io.IOException("Too many redirects (20)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x050c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x050d, code lost:
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x0510, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x0511, code lost:
        r1 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x0514, code lost:
        r2 = null;
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x051a, code lost:
        com.google.android.gms.ads.internal.zzbv.zzlj().zza(r0, "VideoStreamFullFileCache.preload");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x052a, code lost:
        r3 = new java.lang.StringBuilder(java.lang.String.valueOf(r31).length() + 26);
        r3.append("Preload aborted for URL \"");
        r3.append(r31);
        r3.append("\"");
        com.google.android.gms.internal.ads.zzaxz.zzen(r3.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x054e, code lost:
        r4 = new java.lang.StringBuilder(java.lang.String.valueOf(r31).length() + 25);
        r4.append("Preload failed for URL \"");
        r4.append(r31);
        r4.append("\"");
        com.google.android.gms.internal.ads.zzaxz.zzc(r4.toString(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x058d, code lost:
        r0 = "Could not delete partial cache file at ".concat(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x0592, code lost:
        r0 = new java.lang.String("Could not delete partial cache file at ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0131, code lost:
        r15 = "error";
        com.google.android.gms.ads.internal.zzbv.zzls();
        r1 = ((java.lang.Integer) com.google.android.gms.internal.ads.zzwu.zzpz().zzd(com.google.android.gms.internal.ads.zzaan.zzcoy)).intValue();
        r3 = new java.net.URL(r31);
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x014d, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0150, code lost:
        if (r2 > 20) goto L_0x0501;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0152, code lost:
        r5 = r3.openConnection();
        r5.setConnectTimeout(r1);
        r5.setReadTimeout(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x015e, code lost:
        if ((r5 instanceof java.net.HttpURLConnection) == false) goto L_0x04f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0160, code lost:
        r5 = (java.net.HttpURLConnection) r5;
        r6 = new com.google.android.gms.internal.ads.zzbax();
        r6.zza(r5, (byte[]) null);
        r5.setInstanceFollowRedirects(false);
        r7 = r5.getResponseCode();
        r6.zza(r5, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0177, code lost:
        if ((r7 / 100) != 3) goto L_0x01ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0179, code lost:
        r4 = r5.getHeaderField("Location");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x017f, code lost:
        if (r4 == null) goto L_0x01e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0181, code lost:
        r6 = new java.net.URL(r3, r4);
        r3 = r6.getProtocol();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x018a, code lost:
        if (r3 == null) goto L_0x01d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0192, code lost:
        if (r3.equals("http") != false) goto L_0x01b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x019a, code lost:
        if (r3.equals("https") != false) goto L_0x01b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x019c, code lost:
        r2 = java.lang.String.valueOf(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a8, code lost:
        if (r2.length() == 0) goto L_0x01af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01aa, code lost:
        r1 = "Unsupported scheme: ".concat(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01af, code lost:
        r1 = new java.lang.String("Unsupported scheme: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01b8, code lost:
        throw new java.io.IOException(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01b9, code lost:
        r4 = java.lang.String.valueOf(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01c3, code lost:
        if (r4.length() == 0) goto L_0x01ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01c5, code lost:
        r3 = "Redirecting to ".concat(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01ca, code lost:
        r3 = new java.lang.String("Redirecting to ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01d0, code lost:
        com.google.android.gms.internal.ads.zzaxz.zzdn(r3);
        r5.disconnect();
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01e0, code lost:
        throw new java.io.IOException("Protocol is null");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01e8, code lost:
        throw new java.io.IOException("Missing Location header in redirect");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01e9, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01ea, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01eb, code lost:
        r1 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01f0, code lost:
        if ((r5 instanceof java.net.HttpURLConnection) == false) goto L_0x0245;
     */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x051a  */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x052a  */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x054e  */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x058d  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x0592  */
    @Override // com.google.android.gms.internal.ads.zzbfk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzex(java.lang.String r31) {
        /*
        // Method dump skipped, instructions count: 1453
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbfs.zzex(java.lang.String):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzbfk
    public final void abort() {
        this.zzexc = true;
    }

    private final File zzc(File file) {
        return new File(this.zzexb, String.valueOf(file.getName()).concat(".done"));
    }
}
