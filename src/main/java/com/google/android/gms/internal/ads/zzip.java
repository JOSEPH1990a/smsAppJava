package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.google.android.gms.internal.ads.zzhp;
import com.google.firebase.FirebaseError;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;

public final class zzip implements zzhz {
    private static final zzic zzahq = new zziq();
    private static final byte[] zzahr = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] zzahs = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final UUID zzaht = new UUID(72057594037932032L, -9223371306706625679L);
    private long zzaan;
    private final zziu zzahk;
    private final zzin zzahu;
    private final SparseArray<zzis> zzahv;
    private final boolean zzahw;
    private final zzpx zzahx;
    private final zzpx zzahy;
    private final zzpx zzahz;
    private final zzpx zzaia;
    private final zzpx zzaib;
    private final zzpx zzaic;
    private final zzpx zzaid;
    private final zzpx zzaie;
    private final zzpx zzaif;
    private ByteBuffer zzaig;
    private long zzaih;
    private long zzaii;
    private long zzaij;
    private long zzaik;
    private zzis zzail;
    private boolean zzaim;
    private int zzain;
    private long zzaio;
    private boolean zzaip;
    private long zzaiq;
    private long zzair;
    private long zzais;
    private zzpr zzait;
    private zzpr zzaiu;
    private boolean zzaiv;
    private int zzaiw;
    private long zzaix;
    private long zzaiy;
    private int zzaiz;
    private int zzaja;
    private int[] zzajb;
    private int zzajc;
    private int zzajd;
    private int zzaje;
    private int zzajf;
    private boolean zzajg;
    private boolean zzajh;
    private boolean zzaji;
    private boolean zzajj;
    private byte zzajk;
    private int zzajl;
    private int zzajm;
    private int zzajn;
    private boolean zzajo;
    private boolean zzajp;
    private zzib zzajq;

    public zzip() {
        this(0);
    }

    static int zzab(int i) {
        switch (i) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 241:
            case 251:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 22186:
            case 22203:
            case 25188:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case FirebaseError.ERROR_WEAK_PASSWORD /*{ENCODED_INT: 17026}*/:
            case 2274716:
                return 3;
            case 160:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
                return 5;
            default:
                return 0;
        }
    }

    static boolean zzac(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final void release() {
    }

    public zzip(int i) {
        this(new zzik(), i);
    }

    private zzip(zzin zzin, int i) {
        this.zzaii = -1;
        this.zzaij = -9223372036854775807L;
        this.zzaik = -9223372036854775807L;
        this.zzaan = -9223372036854775807L;
        this.zzaiq = -1;
        this.zzair = -1;
        this.zzais = -9223372036854775807L;
        this.zzahu = zzin;
        this.zzahu.zza(new zzir(this, null));
        this.zzahw = (i & 1) != 0 ? false : true;
        this.zzahk = new zziu();
        this.zzahv = new SparseArray<>();
        this.zzahz = new zzpx(4);
        this.zzaia = new zzpx(ByteBuffer.allocate(4).putInt(-1).array());
        this.zzaib = new zzpx(4);
        this.zzahx = new zzpx(zzpu.zzbhi);
        this.zzahy = new zzpx(4);
        this.zzaic = new zzpx();
        this.zzaid = new zzpx();
        this.zzaie = new zzpx(8);
        this.zzaif = new zzpx();
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final boolean zza(zzia zzia) throws IOException, InterruptedException {
        return new zzit().zza(zzia);
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final void zza(zzib zzib) {
        this.zzajq = zzib;
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final void zzc(long j, long j2) {
        this.zzais = -9223372036854775807L;
        this.zzaiw = 0;
        this.zzahu.reset();
        this.zzahk.reset();
        zzeb();
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final int zza(zzia zzia, zzif zzif) throws IOException, InterruptedException {
        boolean z;
        this.zzajo = false;
        boolean z2 = true;
        while (z2 && !this.zzajo) {
            z2 = this.zzahu.zzb(zzia);
            if (z2) {
                long position = zzia.getPosition();
                if (this.zzaip) {
                    this.zzair = position;
                    zzif.zzaha = this.zzaiq;
                    this.zzaip = false;
                    z = true;
                } else {
                    if (this.zzaim) {
                        long j = this.zzair;
                        if (j != -1) {
                            zzif.zzaha = j;
                            this.zzair = -1;
                            z = true;
                        }
                    }
                    z = false;
                }
                if (z) {
                    return 1;
                }
            }
        }
        if (z2) {
            return 0;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public final void zzd(int i, long j, long j2) throws zzfx {
        if (i == 160) {
            this.zzajp = false;
        } else if (i == 174) {
            this.zzail = new zzis(null);
        } else if (i == 187) {
            this.zzaiv = false;
        } else if (i == 19899) {
            this.zzain = -1;
            this.zzaio = -1;
        } else if (i == 20533) {
            this.zzail.zzaju = true;
        } else if (i == 21968) {
            this.zzail.zzakb = true;
        } else if (i == 25152) {
        } else {
            if (i == 408125543) {
                long j3 = this.zzaii;
                if (j3 == -1 || j3 == j) {
                    this.zzaii = j;
                    this.zzaih = j2;
                    return;
                }
                throw new zzfx("Multiple Segment elements not supported");
            } else if (i == 475249515) {
                this.zzait = new zzpr();
                this.zzaiu = new zzpr();
            } else if (i != 524531317 || this.zzaim) {
            } else {
                if (!this.zzahw || this.zzaiq == -1) {
                    this.zzajq.zza(new zzih(this.zzaan));
                    this.zzaim = true;
                    return;
                }
                this.zzaip = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzad(int i) throws zzfx {
        zzig zzig;
        zzpr zzpr;
        zzpr zzpr2;
        int i2;
        int i3 = 0;
        if (i != 160) {
            if (i == 174) {
                String str = this.zzail.zzajs;
                if ("V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str)) {
                    i3 = 1;
                }
                if (i3 != 0) {
                    zzis zzis = this.zzail;
                    zzis.zza(this.zzajq, zzis.number);
                    this.zzahv.put(this.zzail.number, this.zzail);
                }
                this.zzail = null;
            } else if (i == 19899) {
                int i4 = this.zzain;
                if (i4 != -1) {
                    long j = this.zzaio;
                    if (j != -1) {
                        if (i4 == 475249515) {
                            this.zzaiq = j;
                            return;
                        }
                        return;
                    }
                }
                throw new zzfx("Mandatory element SeekID or SeekPosition not found");
            } else if (i != 25152) {
                if (i != 28032) {
                    if (i == 357149030) {
                        if (this.zzaij == -9223372036854775807L) {
                            this.zzaij = 1000000;
                        }
                        long j2 = this.zzaik;
                        if (j2 != -9223372036854775807L) {
                            this.zzaan = zzs(j2);
                        }
                    } else if (i != 374648427) {
                        if (i == 475249515 && !this.zzaim) {
                            zzib zzib = this.zzajq;
                            if (this.zzaii == -1 || this.zzaan == -9223372036854775807L || (zzpr = this.zzait) == null || zzpr.size() == 0 || (zzpr2 = this.zzaiu) == null || zzpr2.size() != this.zzait.size()) {
                                this.zzait = null;
                                this.zzaiu = null;
                                zzig = new zzih(this.zzaan);
                            } else {
                                int size = this.zzait.size();
                                int[] iArr = new int[size];
                                long[] jArr = new long[size];
                                long[] jArr2 = new long[size];
                                long[] jArr3 = new long[size];
                                for (int i5 = 0; i5 < size; i5++) {
                                    jArr3[i5] = this.zzait.get(i5);
                                    jArr[i5] = this.zzaii + this.zzaiu.get(i5);
                                }
                                while (true) {
                                    i2 = size - 1;
                                    if (i3 >= i2) {
                                        break;
                                    }
                                    int i6 = i3 + 1;
                                    iArr[i3] = (int) (jArr[i6] - jArr[i3]);
                                    jArr2[i3] = jArr3[i6] - jArr3[i3];
                                    i3 = i6;
                                }
                                iArr[i2] = (int) ((this.zzaii + this.zzaih) - jArr[i2]);
                                jArr2[i2] = this.zzaan - jArr3[i2];
                                this.zzait = null;
                                this.zzaiu = null;
                                zzig = new zzhw(iArr, jArr, jArr2, jArr3);
                            }
                            zzib.zza(zzig);
                            this.zzaim = true;
                        }
                    } else if (this.zzahv.size() != 0) {
                        this.zzajq.zzdy();
                    } else {
                        throw new zzfx("No valid tracks were found");
                    }
                } else if (this.zzail.zzaju && this.zzail.zzajv != null) {
                    throw new zzfx("Combining encryption and compression is not supported");
                }
            } else if (this.zzail.zzaju) {
                if (this.zzail.zzajw != null) {
                    this.zzail.zzzm = new zzhp(new zzhp.zza(zzfe.zzwm, "video/webm", this.zzail.zzajw.zzahh));
                    return;
                }
                throw new zzfx("Encrypted Track found but ContentEncKeyID was not found");
            }
        } else if (this.zzaiw == 2) {
            if (!this.zzajp) {
                this.zzaje |= 1;
            }
            zza(this.zzahv.get(this.zzajc), this.zzaix);
            this.zzaiw = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc(int i, long j) throws zzfx {
        boolean z = false;
        switch (i) {
            case 131:
                this.zzail.type = (int) j;
                return;
            case 136:
                zzis zzis = this.zzail;
                if (j == 1) {
                    z = true;
                }
                zzis.zzaku = z;
                return;
            case 155:
                this.zzaiy = zzs(j);
                return;
            case 159:
                this.zzail.zzzt = (int) j;
                return;
            case 176:
                this.zzail.width = (int) j;
                return;
            case 179:
                this.zzait.add(zzs(j));
                return;
            case 186:
                this.zzail.height = (int) j;
                return;
            case 215:
                this.zzail.number = (int) j;
                return;
            case 231:
                this.zzais = zzs(j);
                return;
            case 241:
                if (!this.zzaiv) {
                    this.zzaiu.add(j);
                    this.zzaiv = true;
                    return;
                }
                return;
            case 251:
                this.zzajp = true;
                return;
            case 16980:
                if (j != 3) {
                    StringBuilder sb = new StringBuilder(50);
                    sb.append("ContentCompAlgo ");
                    sb.append(j);
                    sb.append(" not supported");
                    throw new zzfx(sb.toString());
                }
                return;
            case 17029:
                if (j < 1 || j > 2) {
                    StringBuilder sb2 = new StringBuilder(53);
                    sb2.append("DocTypeReadVersion ");
                    sb2.append(j);
                    sb2.append(" not supported");
                    throw new zzfx(sb2.toString());
                }
                return;
            case 17143:
                if (j != 1) {
                    StringBuilder sb3 = new StringBuilder(50);
                    sb3.append("EBMLReadVersion ");
                    sb3.append(j);
                    sb3.append(" not supported");
                    throw new zzfx(sb3.toString());
                }
                return;
            case 18401:
                if (j != 5) {
                    StringBuilder sb4 = new StringBuilder(49);
                    sb4.append("ContentEncAlgo ");
                    sb4.append(j);
                    sb4.append(" not supported");
                    throw new zzfx(sb4.toString());
                }
                return;
            case 18408:
                if (j != 1) {
                    StringBuilder sb5 = new StringBuilder(56);
                    sb5.append("AESSettingsCipherMode ");
                    sb5.append(j);
                    sb5.append(" not supported");
                    throw new zzfx(sb5.toString());
                }
                return;
            case 20529:
                if (j != 0) {
                    StringBuilder sb6 = new StringBuilder(55);
                    sb6.append("ContentEncodingOrder ");
                    sb6.append(j);
                    sb6.append(" not supported");
                    throw new zzfx(sb6.toString());
                }
                return;
            case 20530:
                if (j != 1) {
                    StringBuilder sb7 = new StringBuilder(55);
                    sb7.append("ContentEncodingScope ");
                    sb7.append(j);
                    sb7.append(" not supported");
                    throw new zzfx(sb7.toString());
                }
                return;
            case 21420:
                this.zzaio = j + this.zzaii;
                return;
            case 21432:
                int i2 = (int) j;
                if (i2 == 3) {
                    this.zzail.zzzq = 1;
                    return;
                } else if (i2 != 15) {
                    switch (i2) {
                        case 0:
                            this.zzail.zzzq = 0;
                            return;
                        case 1:
                            this.zzail.zzzq = 2;
                            return;
                        default:
                            return;
                    }
                } else {
                    this.zzail.zzzq = 3;
                    return;
                }
            case 21680:
                this.zzail.zzajy = (int) j;
                return;
            case 21682:
                this.zzail.zzaka = (int) j;
                return;
            case 21690:
                this.zzail.zzajz = (int) j;
                return;
            case 21930:
                zzis zzis2 = this.zzail;
                if (j == 1) {
                    z = true;
                }
                zzis2.zzakv = z;
                return;
            case 21945:
                switch ((int) j) {
                    case 1:
                        this.zzail.zzake = 2;
                        return;
                    case 2:
                        this.zzail.zzake = 1;
                        return;
                    default:
                        return;
                }
            case 21946:
                int i3 = (int) j;
                if (i3 != 1) {
                    if (i3 == 16) {
                        this.zzail.zzakd = 6;
                        return;
                    } else if (i3 != 18) {
                        switch (i3) {
                            case 6:
                            case 7:
                                break;
                            default:
                                return;
                        }
                    } else {
                        this.zzail.zzakd = 7;
                        return;
                    }
                }
                this.zzail.zzakd = 3;
                return;
            case 21947:
                zzis zzis3 = this.zzail;
                zzis3.zzakb = true;
                int i4 = (int) j;
                if (i4 == 1) {
                    zzis3.zzakc = 1;
                    return;
                } else if (i4 != 9) {
                    switch (i4) {
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                            zzis3.zzakc = 2;
                            return;
                        default:
                            return;
                    }
                } else {
                    zzis3.zzakc = 6;
                    return;
                }
            case 21948:
                this.zzail.zzakf = (int) j;
                return;
            case 21949:
                this.zzail.zzakg = (int) j;
                return;
            case 22186:
                this.zzail.zzaks = j;
                return;
            case 22203:
                this.zzail.zzakt = j;
                return;
            case 25188:
                this.zzail.zzakr = (int) j;
                return;
            case 2352003:
                this.zzail.zzajt = (int) j;
                return;
            case 2807729:
                this.zzaij = j;
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(int i, double d) {
        if (i == 181) {
            this.zzail.zzzu = (int) d;
        } else if (i != 17545) {
            switch (i) {
                case 21969:
                    this.zzail.zzakh = (float) d;
                    return;
                case 21970:
                    this.zzail.zzaki = (float) d;
                    return;
                case 21971:
                    this.zzail.zzakj = (float) d;
                    return;
                case 21972:
                    this.zzail.zzakk = (float) d;
                    return;
                case 21973:
                    this.zzail.zzakl = (float) d;
                    return;
                case 21974:
                    this.zzail.zzakm = (float) d;
                    return;
                case 21975:
                    this.zzail.zzakn = (float) d;
                    return;
                case 21976:
                    this.zzail.zzako = (float) d;
                    return;
                case 21977:
                    this.zzail.zzakp = (float) d;
                    return;
                case 21978:
                    this.zzail.zzakq = (float) d;
                    return;
                default:
                    return;
            }
        } else {
            this.zzaik = (long) d;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(int i, String str) throws zzfx {
        if (i == 134) {
            this.zzail.zzajs = str;
        } else if (i != 17026) {
            if (i == 2274716) {
                zzis.zza(this.zzail, str);
            }
        } else if (!"webm".equals(str) && !"matroska".equals(str)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22);
            sb.append("DocType ");
            sb.append(str);
            sb.append(" not supported");
            throw new zzfx(sb.toString());
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0205, code lost:
        throw new com.google.android.gms.internal.ads.zzfx("EBML lacing sample size out of range.");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(int r20, int r21, com.google.android.gms.internal.ads.zzia r22) throws java.io.IOException, java.lang.InterruptedException {
        /*
        // Method dump skipped, instructions count: 706
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzip.zza(int, int, com.google.android.gms.internal.ads.zzia):void");
    }

    private final void zza(zzis zzis, long j) {
        byte[] bArr;
        if ("S_TEXT/UTF8".equals(zzis.zzajs)) {
            byte[] bArr2 = this.zzaid.data;
            long j2 = this.zzaiy;
            if (j2 == -9223372036854775807L) {
                bArr = zzahs;
            } else {
                int i = (int) (j2 / 3600000000L);
                long j3 = j2 - (((long) i) * 3600000000L);
                int i2 = (int) (j3 / 60000000);
                long j4 = j3 - ((long) (60000000 * i2));
                int i3 = (int) (j4 / 1000000);
                bArr = zzqe.zzaj(String.format(Locale.US, "%02d:%02d:%02d,%03d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j4 - ((long) (1000000 * i3))) / 1000))));
            }
            System.arraycopy(bArr, 0, bArr2, 19, 12);
            zzii zzii = zzis.zzakw;
            zzpx zzpx = this.zzaid;
            zzii.zza(zzpx, zzpx.limit());
            this.zzajn += this.zzaid.limit();
        }
        zzis.zzakw.zza(j, this.zzaje, this.zzajn, 0, zzis.zzajw);
        this.zzajo = true;
        zzeb();
    }

    private final void zzeb() {
        this.zzajf = 0;
        this.zzajn = 0;
        this.zzajm = 0;
        this.zzajg = false;
        this.zzajh = false;
        this.zzajj = false;
        this.zzajl = 0;
        this.zzajk = 0;
        this.zzaji = false;
        this.zzaic.reset();
    }

    private final void zzb(zzia zzia, int i) throws IOException, InterruptedException {
        if (this.zzahz.limit() < i) {
            if (this.zzahz.capacity() < i) {
                zzpx zzpx = this.zzahz;
                zzpx.zzc(Arrays.copyOf(zzpx.data, Math.max(this.zzahz.data.length << 1, i)), this.zzahz.limit());
            }
            zzia.readFully(this.zzahz.data, this.zzahz.limit(), i - this.zzahz.limit());
            this.zzahz.zzbk(i);
        }
    }

    private final void zza(zzia zzia, zzis zzis, int i) throws IOException, InterruptedException {
        int i2;
        if ("S_TEXT/UTF8".equals(zzis.zzajs)) {
            int length = zzahr.length + i;
            if (this.zzaid.capacity() < length) {
                this.zzaid.data = Arrays.copyOf(zzahr, length + i);
            }
            zzia.readFully(this.zzaid.data, zzahr.length, i);
            this.zzaid.setPosition(0);
            this.zzaid.zzbk(length);
            return;
        }
        zzii zzii = zzis.zzakw;
        if (!this.zzajg) {
            if (zzis.zzaju) {
                this.zzaje &= -1073741825;
                int i3 = 128;
                if (!this.zzajh) {
                    zzia.readFully(this.zzahz.data, 0, 1);
                    this.zzajf++;
                    if ((this.zzahz.data[0] & 128) != 128) {
                        this.zzajk = this.zzahz.data[0];
                        this.zzajh = true;
                    } else {
                        throw new zzfx("Extension bit is set in signal byte");
                    }
                }
                byte b = this.zzajk;
                if ((b & 1) == 1) {
                    boolean z = (b & 2) == 2;
                    this.zzaje |= 1073741824;
                    if (!this.zzaji) {
                        zzia.readFully(this.zzaie.data, 0, 8);
                        this.zzajf += 8;
                        this.zzaji = true;
                        byte[] bArr = this.zzahz.data;
                        if (!z) {
                            i3 = 0;
                        }
                        bArr[0] = (byte) (i3 | 8);
                        this.zzahz.setPosition(0);
                        zzii.zza(this.zzahz, 1);
                        this.zzajn++;
                        this.zzaie.setPosition(0);
                        zzii.zza(this.zzaie, 8);
                        this.zzajn += 8;
                    }
                    if (z) {
                        if (!this.zzajj) {
                            zzia.readFully(this.zzahz.data, 0, 1);
                            this.zzajf++;
                            this.zzahz.setPosition(0);
                            this.zzajl = this.zzahz.readUnsignedByte();
                            this.zzajj = true;
                        }
                        int i4 = this.zzajl << 2;
                        this.zzahz.reset(i4);
                        zzia.readFully(this.zzahz.data, 0, i4);
                        this.zzajf += i4;
                        short s = (short) ((this.zzajl / 2) + 1);
                        int i5 = (s * 6) + 2;
                        ByteBuffer byteBuffer = this.zzaig;
                        if (byteBuffer == null || byteBuffer.capacity() < i5) {
                            this.zzaig = ByteBuffer.allocate(i5);
                        }
                        this.zzaig.position(0);
                        this.zzaig.putShort(s);
                        int i6 = 0;
                        int i7 = 0;
                        while (true) {
                            i2 = this.zzajl;
                            if (i6 >= i2) {
                                break;
                            }
                            int zzhg = this.zzahz.zzhg();
                            if (i6 % 2 == 0) {
                                this.zzaig.putShort((short) (zzhg - i7));
                            } else {
                                this.zzaig.putInt(zzhg - i7);
                            }
                            i6++;
                            i7 = zzhg;
                        }
                        int i8 = (i - this.zzajf) - i7;
                        if (i2 % 2 == 1) {
                            this.zzaig.putInt(i8);
                        } else {
                            this.zzaig.putShort((short) i8);
                            this.zzaig.putInt(0);
                        }
                        this.zzaif.zzc(this.zzaig.array(), i5);
                        zzii.zza(this.zzaif, i5);
                        this.zzajn += i5;
                    }
                }
            } else if (zzis.zzajv != null) {
                this.zzaic.zzc(zzis.zzajv, zzis.zzajv.length);
            }
            this.zzajg = true;
        }
        int limit = i + this.zzaic.limit();
        if (!"V_MPEG4/ISO/AVC".equals(zzis.zzajs) && !"V_MPEGH/ISO/HEVC".equals(zzis.zzajs)) {
            while (true) {
                int i9 = this.zzajf;
                if (i9 >= limit) {
                    break;
                }
                zza(zzia, zzii, limit - i9);
            }
        } else {
            byte[] bArr2 = this.zzahy.data;
            bArr2[0] = 0;
            bArr2[1] = 0;
            bArr2[2] = 0;
            int i10 = zzis.zzakx;
            int i11 = 4 - zzis.zzakx;
            while (this.zzajf < limit) {
                int i12 = this.zzajm;
                if (i12 == 0) {
                    int min = Math.min(i10, this.zzaic.zzhb());
                    zzia.readFully(bArr2, i11 + min, i10 - min);
                    if (min > 0) {
                        this.zzaic.zze(bArr2, i11, min);
                    }
                    this.zzajf += i10;
                    this.zzahy.setPosition(0);
                    this.zzajm = this.zzahy.zzhg();
                    this.zzahx.setPosition(0);
                    zzii.zza(this.zzahx, 4);
                    this.zzajn += 4;
                } else {
                    this.zzajm = i12 - zza(zzia, zzii, i12);
                }
            }
        }
        if ("A_VORBIS".equals(zzis.zzajs)) {
            this.zzaia.setPosition(0);
            zzii.zza(this.zzaia, 4);
            this.zzajn += 4;
        }
    }

    private final int zza(zzia zzia, zzii zzii, int i) throws IOException, InterruptedException {
        int i2;
        int zzhb = this.zzaic.zzhb();
        if (zzhb > 0) {
            i2 = Math.min(i, zzhb);
            zzii.zza(this.zzaic, i2);
        } else {
            i2 = zzii.zza(zzia, i, false);
        }
        this.zzajf += i2;
        this.zzajn += i2;
        return i2;
    }

    private final long zzs(long j) throws zzfx {
        long j2 = this.zzaij;
        if (j2 != -9223372036854775807L) {
            return zzqe.zza(j, j2, 1000);
        }
        throw new zzfx("Can't scale timecode prior to timecodeScale being set.");
    }

    private static int[] zza(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        if (iArr.length >= i) {
            return iArr;
        }
        return new int[Math.max(iArr.length << 1, i)];
    }
}
