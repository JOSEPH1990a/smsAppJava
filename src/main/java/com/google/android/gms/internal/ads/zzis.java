package com.google.android.gms.internal.ads;

import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class zzis {
    public int height;
    public int number;
    public int type;
    public int width;
    private String zzaaa;
    public String zzajs;
    public int zzajt;
    public boolean zzaju;
    public byte[] zzajv;
    public zzij zzajw;
    public byte[] zzajx;
    public int zzajy;
    public int zzajz;
    public int zzaka;
    public boolean zzakb;
    public int zzakc;
    public int zzakd;
    public int zzake;
    public int zzakf;
    public int zzakg;
    public float zzakh;
    public float zzaki;
    public float zzakj;
    public float zzakk;
    public float zzakl;
    public float zzakm;
    public float zzakn;
    public float zzako;
    public float zzakp;
    public float zzakq;
    public int zzakr;
    public long zzaks;
    public long zzakt;
    public boolean zzaku;
    public boolean zzakv;
    public zzii zzakw;
    public int zzakx;
    public zzhp zzzm;
    public int zzzq;
    public byte[] zzzr;
    public int zzzt;
    public int zzzu;

    private zzis() {
        this.width = -1;
        this.height = -1;
        this.zzajy = -1;
        this.zzajz = -1;
        this.zzaka = 0;
        this.zzzr = null;
        this.zzzq = -1;
        this.zzakb = false;
        this.zzakc = -1;
        this.zzakd = -1;
        this.zzake = -1;
        this.zzakf = 1000;
        this.zzakg = ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION;
        this.zzakh = -1.0f;
        this.zzaki = -1.0f;
        this.zzakj = -1.0f;
        this.zzakk = -1.0f;
        this.zzakl = -1.0f;
        this.zzakm = -1.0f;
        this.zzakn = -1.0f;
        this.zzako = -1.0f;
        this.zzakp = -1.0f;
        this.zzakq = -1.0f;
        this.zzzt = 1;
        this.zzakr = -1;
        this.zzzu = 8000;
        this.zzaks = 0;
        this.zzakt = 0;
        this.zzakv = true;
        this.zzaaa = "eng";
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final void zza(zzib zzib, int i) {
        char c;
        int i2;
        int i3;
        String str;
        List<byte[]> list;
        zzfs zzfs;
        zzqi zzqi;
        int i4;
        String str2 = this.zzajs;
        int i5 = 3;
        switch (str2.hashCode()) {
            case -2095576542:
                if (str2.equals("V_MPEG4/ISO/AP")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -2095575984:
                if (str2.equals("V_MPEG4/ISO/SP")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1985379776:
                if (str2.equals("A_MS/ACM")) {
                    c = 22;
                    break;
                }
                c = 65535;
                break;
            case -1784763192:
                if (str2.equals("A_TRUEHD")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case -1730367663:
                if (str2.equals("A_VORBIS")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case -1482641358:
                if (str2.equals("A_MPEG/L2")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case -1482641357:
                if (str2.equals("A_MPEG/L3")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case -1373388978:
                if (str2.equals("V_MS/VFW/FOURCC")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -933872740:
                if (str2.equals("S_DVBSUB")) {
                    c = 27;
                    break;
                }
                c = 65535;
                break;
            case -538363189:
                if (str2.equals("V_MPEG4/ISO/ASP")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -538363109:
                if (str2.equals("V_MPEG4/ISO/AVC")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -425012669:
                if (str2.equals("S_VOBSUB")) {
                    c = 25;
                    break;
                }
                c = 65535;
                break;
            case -356037306:
                if (str2.equals("A_DTS/LOSSLESS")) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case 62923557:
                if (str2.equals("A_AAC")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 62923603:
                if (str2.equals("A_AC3")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 62927045:
                if (str2.equals("A_DTS")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case 82338133:
                if (str2.equals("V_VP8")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 82338134:
                if (str2.equals("V_VP9")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 99146302:
                if (str2.equals("S_HDMV/PGS")) {
                    c = 26;
                    break;
                }
                c = 65535;
                break;
            case 444813526:
                if (str2.equals("V_THEORA")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 542569478:
                if (str2.equals("A_DTS/EXPRESS")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case 725957860:
                if (str2.equals("A_PCM/INT/LIT")) {
                    c = 23;
                    break;
                }
                c = 65535;
                break;
            case 855502857:
                if (str2.equals("V_MPEGH/ISO/HEVC")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 1422270023:
                if (str2.equals("S_TEXT/UTF8")) {
                    c = 24;
                    break;
                }
                c = 65535;
                break;
            case 1809237540:
                if (str2.equals("V_MPEG2")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1950749482:
                if (str2.equals("A_EAC3")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 1950789798:
                if (str2.equals("A_FLAC")) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case 1951062397:
                if (str2.equals("A_OPUS")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        byte[] bArr = null;
        switch (c) {
            case 0:
                str = "video/x-vnd.on2.vp8";
                list = null;
                i3 = -1;
                i2 = -1;
                break;
            case 1:
                str = "video/x-vnd.on2.vp9";
                list = null;
                i3 = -1;
                i2 = -1;
                break;
            case 2:
                str = "video/mpeg2";
                list = null;
                i3 = -1;
                i2 = -1;
                break;
            case 3:
            case 4:
            case 5:
                byte[] bArr2 = this.zzajx;
                list = bArr2 == null ? null : Collections.singletonList(bArr2);
                str = "video/mp4v-es";
                i3 = -1;
                i2 = -1;
                break;
            case 6:
                zzqh zzg = zzqh.zzg(new zzpx(this.zzajx));
                List<byte[]> list2 = zzg.zzzl;
                this.zzakx = zzg.zzakx;
                str = "video/avc";
                list = list2;
                i3 = -1;
                i2 = -1;
                break;
            case 7:
                zzqn zzi = zzqn.zzi(new zzpx(this.zzajx));
                List<byte[]> list3 = zzi.zzzl;
                this.zzakx = zzi.zzakx;
                str = "video/hevc";
                list = list3;
                i3 = -1;
                i2 = -1;
                break;
            case '\b':
                List<byte[]> zza = zza(new zzpx(this.zzajx));
                if (zza == null) {
                    Log.w("MatroskaExtractor", "Unsupported FourCC. Setting mimeType to video/x-unknown");
                    str = "video/x-unknown";
                    i3 = -1;
                    i2 = -1;
                    list = zza;
                    break;
                } else {
                    str = "video/wvc1";
                    i3 = -1;
                    i2 = -1;
                    list = zza;
                    break;
                }
            case '\t':
                str = "video/x-unknown";
                list = null;
                i3 = -1;
                i2 = -1;
                break;
            case '\n':
                str = "audio/vorbis";
                list = zzd(this.zzajx);
                i3 = 8192;
                i2 = -1;
                break;
            case 11:
                ArrayList arrayList = new ArrayList(3);
                arrayList.add(this.zzajx);
                arrayList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.zzaks).array());
                arrayList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.zzakt).array());
                str = "audio/opus";
                list = arrayList;
                i3 = 5760;
                i2 = -1;
                break;
            case '\f':
                list = Collections.singletonList(this.zzajx);
                str = "audio/mp4a-latm";
                i3 = -1;
                i2 = -1;
                break;
            case '\r':
                str = "audio/mpeg-L2";
                list = null;
                i3 = 4096;
                i2 = -1;
                break;
            case 14:
                str = "audio/mpeg";
                list = null;
                i3 = 4096;
                i2 = -1;
                break;
            case 15:
                str = "audio/ac3";
                list = null;
                i3 = -1;
                i2 = -1;
                break;
            case 16:
                str = "audio/eac3";
                list = null;
                i3 = -1;
                i2 = -1;
                break;
            case 17:
                str = "audio/true-hd";
                list = null;
                i3 = -1;
                i2 = -1;
                break;
            case 18:
            case 19:
                str = "audio/vnd.dts";
                list = null;
                i3 = -1;
                i2 = -1;
                break;
            case 20:
                str = "audio/vnd.dts.hd";
                list = null;
                i3 = -1;
                i2 = -1;
                break;
            case 21:
                list = Collections.singletonList(this.zzajx);
                str = "audio/x-flac";
                i3 = -1;
                i2 = -1;
                break;
            case 22:
                if (!zzb(new zzpx(this.zzajx))) {
                    String valueOf = String.valueOf("audio/x-unknown");
                    Log.w("MatroskaExtractor", valueOf.length() != 0 ? "Non-PCM MS/ACM is unsupported. Setting mimeType to ".concat(valueOf) : new String("Non-PCM MS/ACM is unsupported. Setting mimeType to "));
                    str = "audio/x-unknown";
                    list = null;
                    i3 = -1;
                    i2 = -1;
                    break;
                } else {
                    int zzbp = zzqe.zzbp(this.zzakr);
                    if (zzbp != 0) {
                        str = "audio/raw";
                        i2 = zzbp;
                        list = null;
                        i3 = -1;
                        break;
                    } else {
                        int i6 = this.zzakr;
                        StringBuilder sb = new StringBuilder(String.valueOf("audio/x-unknown").length() + 60);
                        sb.append("Unsupported PCM bit depth: ");
                        sb.append(i6);
                        sb.append(". Setting mimeType to ");
                        sb.append("audio/x-unknown");
                        Log.w("MatroskaExtractor", sb.toString());
                        str = "audio/x-unknown";
                        list = null;
                        i3 = -1;
                        i2 = -1;
                        break;
                    }
                }
            case 23:
                int zzbp2 = zzqe.zzbp(this.zzakr);
                if (zzbp2 != 0) {
                    str = "audio/raw";
                    i2 = zzbp2;
                    list = null;
                    i3 = -1;
                    break;
                } else {
                    int i7 = this.zzakr;
                    StringBuilder sb2 = new StringBuilder(String.valueOf("audio/x-unknown").length() + 60);
                    sb2.append("Unsupported PCM bit depth: ");
                    sb2.append(i7);
                    sb2.append(". Setting mimeType to ");
                    sb2.append("audio/x-unknown");
                    Log.w("MatroskaExtractor", sb2.toString());
                    str = "audio/x-unknown";
                    list = null;
                    i3 = -1;
                    i2 = -1;
                    break;
                }
            case 24:
                str = "application/x-subrip";
                list = null;
                i3 = -1;
                i2 = -1;
                break;
            case 25:
                list = Collections.singletonList(this.zzajx);
                str = "application/vobsub";
                i3 = -1;
                i2 = -1;
                break;
            case 26:
                str = "application/pgs";
                list = null;
                i3 = -1;
                i2 = -1;
                break;
            case 27:
                byte[] bArr3 = this.zzajx;
                list = Collections.singletonList(new byte[]{bArr3[0], bArr3[1], bArr3[2], bArr3[3]});
                str = "application/dvbsubs";
                i3 = -1;
                i2 = -1;
                break;
            default:
                throw new zzfx("Unrecognized codec identifier.");
        }
        int i8 = (this.zzakv ? 1 : 0) | 0 | (this.zzaku ? 2 : 0);
        if (zzpt.zzab(str)) {
            zzfs = zzfs.zza(Integer.toString(i), str, null, -1, i3, this.zzzt, this.zzzu, i2, list, this.zzzm, i8, this.zzaaa);
            i5 = 1;
        } else if (zzpt.zzac(str)) {
            if (this.zzaka == 0) {
                int i9 = this.zzajy;
                if (i9 == -1) {
                    i9 = this.width;
                }
                this.zzajy = i9;
                int i10 = this.zzajz;
                if (i10 == -1) {
                    i10 = this.height;
                }
                this.zzajz = i10;
            }
            int i11 = this.zzajy;
            float f = (i11 == -1 || (i4 = this.zzajz) == -1) ? -1.0f : ((float) (this.height * i11)) / ((float) (this.width * i4));
            if (this.zzakb) {
                if (!(this.zzakh == -1.0f || this.zzaki == -1.0f || this.zzakj == -1.0f || this.zzakk == -1.0f || this.zzakl == -1.0f || this.zzakm == -1.0f || this.zzakn == -1.0f || this.zzako == -1.0f || this.zzakp == -1.0f || this.zzakq == -1.0f)) {
                    bArr = new byte[25];
                    ByteBuffer wrap = ByteBuffer.wrap(bArr);
                    wrap.put((byte) 0);
                    wrap.putShort((short) ((int) ((this.zzakh * 50000.0f) + 0.5f)));
                    wrap.putShort((short) ((int) ((this.zzaki * 50000.0f) + 0.5f)));
                    wrap.putShort((short) ((int) ((this.zzakj * 50000.0f) + 0.5f)));
                    wrap.putShort((short) ((int) ((this.zzakk * 50000.0f) + 0.5f)));
                    wrap.putShort((short) ((int) ((this.zzakl * 50000.0f) + 0.5f)));
                    wrap.putShort((short) ((int) ((this.zzakm * 50000.0f) + 0.5f)));
                    wrap.putShort((short) ((int) ((this.zzakn * 50000.0f) + 0.5f)));
                    wrap.putShort((short) ((int) ((this.zzako * 50000.0f) + 0.5f)));
                    wrap.putShort((short) ((int) (this.zzakp + 0.5f)));
                    wrap.putShort((short) ((int) (this.zzakq + 0.5f)));
                    wrap.putShort((short) this.zzakf);
                    wrap.putShort((short) this.zzakg);
                }
                zzqi = new zzqi(this.zzakc, this.zzake, this.zzakd, bArr);
            } else {
                zzqi = null;
            }
            zzfs = zzfs.zza(Integer.toString(i), str, null, -1, i3, this.width, this.height, -1.0f, list, -1, f, this.zzzr, this.zzzq, zzqi, this.zzzm);
            i5 = 2;
        } else if ("application/x-subrip".equals(str)) {
            zzfs = zzfs.zza(Integer.toString(i), str, (String) null, -1, i8, this.zzaaa, this.zzzm);
        } else if ("application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str)) {
            zzfs = zzfs.zza(Integer.toString(i), str, (String) null, -1, list, this.zzaaa, this.zzzm);
        } else {
            throw new zzfx("Unexpected MIME type.");
        }
        this.zzakw = zzib.zzb(this.number, i5);
        this.zzakw.zzf(zzfs);
    }

    private static List<byte[]> zza(zzpx zzpx) {
        try {
            zzpx.zzbl(16);
            if (zzpx.zzhe() != 826496599) {
                return null;
            }
            byte[] bArr = zzpx.data;
            for (int position = zzpx.getPosition() + 20; position < bArr.length - 4; position++) {
                if (bArr[position] == 0 && bArr[position + 1] == 0 && bArr[position + 2] == 1 && bArr[position + 3] == 15) {
                    return Collections.singletonList(Arrays.copyOfRange(bArr, position, bArr.length));
                }
            }
            throw new zzfx("Failed to find FourCC VC1 initialization data");
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzfx("Error parsing FourCC VC1 codec private");
        }
    }

    private static List<byte[]> zzd(byte[] bArr) {
        try {
            if (bArr[0] == 2) {
                int i = 1;
                int i2 = 0;
                while (bArr[i] == -1) {
                    i2 += 255;
                    i++;
                }
                int i3 = i + 1;
                int i4 = i2 + bArr[i];
                int i5 = 0;
                while (bArr[i3] == -1) {
                    i5 += 255;
                    i3++;
                }
                int i6 = i3 + 1;
                int i7 = i5 + bArr[i3];
                if (bArr[i6] == 1) {
                    byte[] bArr2 = new byte[i4];
                    System.arraycopy(bArr, i6, bArr2, 0, i4);
                    int i8 = i6 + i4;
                    if (bArr[i8] == 3) {
                        int i9 = i8 + i7;
                        if (bArr[i9] == 5) {
                            byte[] bArr3 = new byte[(bArr.length - i9)];
                            System.arraycopy(bArr, i9, bArr3, 0, bArr.length - i9);
                            ArrayList arrayList = new ArrayList(2);
                            arrayList.add(bArr2);
                            arrayList.add(bArr3);
                            return arrayList;
                        }
                        throw new zzfx("Error parsing vorbis codec private");
                    }
                    throw new zzfx("Error parsing vorbis codec private");
                }
                throw new zzfx("Error parsing vorbis codec private");
            }
            throw new zzfx("Error parsing vorbis codec private");
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzfx("Error parsing vorbis codec private");
        }
    }

    private static boolean zzb(zzpx zzpx) {
        try {
            int zzhc = zzpx.zzhc();
            if (zzhc == 1) {
                return true;
            }
            if (zzhc != 65534) {
                return false;
            }
            zzpx.setPosition(24);
            return zzpx.readLong() == zzip.zzaht.getMostSignificantBits() && zzpx.readLong() == zzip.zzaht.getLeastSignificantBits();
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzfx("Error parsing MS/ACM codec private");
        }
    }

    /* synthetic */ zzis(zziq zziq) {
        this();
    }
}
