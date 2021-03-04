package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
public abstract class zzjy extends zzfd {
    private static final byte[] zzatt = zzqe.zzan("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private zzfs zzaad;
    private ByteBuffer[] zzadk;
    private final zzka zzatu;
    private final zzhu<Object> zzatv;
    private final boolean zzatw;
    private final zzho zzatx;
    private final zzho zzaty;
    private final zzfu zzatz;
    private final List<Long> zzaua;
    private final MediaCodec.BufferInfo zzaub;
    private zzhs<Object> zzauc;
    private zzhs<Object> zzaud;
    private MediaCodec zzaue;
    private zzjx zzauf;
    private boolean zzaug;
    private boolean zzauh;
    private boolean zzaui;
    private boolean zzauj;
    private boolean zzauk;
    private boolean zzaul;
    private boolean zzaum;
    private boolean zzaun;
    private boolean zzauo;
    private ByteBuffer[] zzaup;
    private long zzauq;
    private int zzaur;
    private int zzaus;
    private boolean zzaut;
    private boolean zzauu;
    private int zzauv;
    private int zzauw;
    private boolean zzaux;
    private boolean zzauy;
    private boolean zzauz;
    private boolean zzava;
    private boolean zzavb;
    private boolean zzavc;
    protected zzhn zzavd;

    public zzjy(int i, zzka zzka, zzhu<Object> zzhu, boolean z) {
        super(i);
        zzpo.checkState(zzqe.SDK_INT >= 16);
        this.zzatu = (zzka) zzpo.checkNotNull(zzka);
        this.zzatv = zzhu;
        this.zzatw = z;
        this.zzatx = new zzho(0);
        this.zzaty = new zzho(0);
        this.zzatz = new zzfu();
        this.zzaua = new ArrayList();
        this.zzaub = new MediaCodec.BufferInfo();
        this.zzauv = 0;
        this.zzauw = 0;
    }

    /* access modifiers changed from: protected */
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) throws zzff {
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzfd
    public void onStarted() {
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzfd
    public void onStopped() {
    }

    /* access modifiers changed from: protected */
    public abstract int zza(zzka zzka, zzfs zzfs) throws zzke;

    /* access modifiers changed from: protected */
    public void zza(zzho zzho) {
    }

    /* access modifiers changed from: protected */
    public abstract void zza(zzjx zzjx, MediaCodec mediaCodec, zzfs zzfs, MediaCrypto mediaCrypto) throws zzke;

    /* access modifiers changed from: protected */
    public abstract boolean zza(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws zzff;

    /* access modifiers changed from: protected */
    public boolean zza(MediaCodec mediaCodec, boolean z, zzfs zzfs, zzfs zzfs2) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean zza(zzjx zzjx) {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzfd, com.google.android.gms.internal.ads.zzga
    public final int zzbl() {
        return 4;
    }

    /* access modifiers changed from: protected */
    public void zzc(String str, long j, long j2) {
    }

    /* access modifiers changed from: protected */
    public void zzdj() throws zzff {
    }

    @Override // com.google.android.gms.internal.ads.zzga
    public final int zzb(zzfs zzfs) throws zzff {
        try {
            return zza(this.zzatu, zzfs);
        } catch (zzke e) {
            throw zzff.zza(e, getIndex());
        }
    }

    /* access modifiers changed from: protected */
    public zzjx zza(zzka zzka, zzfs zzfs, boolean z) throws zzke {
        return zzka.zzb(zzfs.zzzj, z);
    }

    /* access modifiers changed from: protected */
    public final void zzek() throws zzff {
        zzfs zzfs;
        if (this.zzaue == null && (zzfs = this.zzaad) != null) {
            this.zzauc = this.zzaud;
            String str = zzfs.zzzj;
            zzhs<Object> zzhs = this.zzauc;
            if (zzhs != null) {
                int state = zzhs.getState();
                if (state == 0) {
                    throw zzff.zza(this.zzauc.zzdv(), getIndex());
                } else if (state == 3 || state == 4) {
                    this.zzauc.zzdu();
                    throw new NoSuchMethodError();
                }
            } else {
                if (this.zzauf == null) {
                    try {
                        this.zzauf = zza(this.zzatu, this.zzaad, false);
                    } catch (zzke e) {
                        zza(new zzjz(this.zzaad, (Throwable) e, false, -49998));
                    }
                    if (this.zzauf == null) {
                        zza(new zzjz(this.zzaad, (Throwable) null, false, -49999));
                    }
                }
                if (zza(this.zzauf)) {
                    String str2 = this.zzauf.name;
                    this.zzaug = zzqe.SDK_INT < 21 && this.zzaad.zzzl.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str2);
                    this.zzauh = zzqe.SDK_INT < 18 || (zzqe.SDK_INT == 18 && ("OMX.SEC.avc.dec".equals(str2) || "OMX.SEC.avc.dec.secure".equals(str2))) || (zzqe.SDK_INT == 19 && zzqe.MODEL.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str2) || "OMX.Exynos.avc.dec.secure".equals(str2)));
                    this.zzaui = zzqe.SDK_INT < 24 && ("OMX.Nvidia.h264.decode".equals(str2) || "OMX.Nvidia.h264.decode.secure".equals(str2)) && ("flounder".equals(zzqe.DEVICE) || "flounder_lte".equals(zzqe.DEVICE) || "grouper".equals(zzqe.DEVICE) || "tilapia".equals(zzqe.DEVICE));
                    this.zzauj = zzqe.SDK_INT <= 17 && ("OMX.rk.video_decoder.avc".equals(str2) || "OMX.allwinner.video.decoder.avc".equals(str2));
                    this.zzauk = (zzqe.SDK_INT <= 23 && "OMX.google.vorbis.decoder".equals(str2)) || (zzqe.SDK_INT <= 19 && "hb2000".equals(zzqe.DEVICE) && ("OMX.amlogic.avc.decoder.awesome".equals(str2) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str2)));
                    this.zzaul = zzqe.SDK_INT == 21 && "OMX.google.aac.decoder".equals(str2);
                    this.zzaum = zzqe.SDK_INT <= 18 && this.zzaad.zzzt == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str2);
                    try {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        String valueOf = String.valueOf(str2);
                        zzqc.beginSection(valueOf.length() != 0 ? "createCodec:".concat(valueOf) : new String("createCodec:"));
                        this.zzaue = MediaCodec.createByCodecName(str2);
                        zzqc.endSection();
                        zzqc.beginSection("configureCodec");
                        zza(this.zzauf, this.zzaue, this.zzaad, (MediaCrypto) null);
                        zzqc.endSection();
                        zzqc.beginSection("startCodec");
                        this.zzaue.start();
                        zzqc.endSection();
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        zzc(str2, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                        this.zzaup = this.zzaue.getInputBuffers();
                        this.zzadk = this.zzaue.getOutputBuffers();
                    } catch (Exception e2) {
                        zza(new zzjz(this.zzaad, (Throwable) e2, false, str2));
                    }
                    this.zzauq = getState() == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                    this.zzaur = -1;
                    this.zzaus = -1;
                    this.zzavc = true;
                    this.zzavd.zzagg++;
                }
            }
        }
    }

    private final void zza(zzjz zzjz) throws zzff {
        throw zzff.zza(zzjz, getIndex());
    }

    /* access modifiers changed from: protected */
    public final MediaCodec zzel() {
        return this.zzaue;
    }

    /* access modifiers changed from: protected */
    public final zzjx zzem() {
        return this.zzauf;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzfd
    public void zzb(boolean z) throws zzff {
        this.zzavd = new zzhn();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzfd
    public void zza(long j, boolean z) throws zzff {
        this.zzauz = false;
        this.zzava = false;
        if (this.zzaue != null) {
            this.zzauq = -9223372036854775807L;
            this.zzaur = -1;
            this.zzaus = -1;
            this.zzavc = true;
            this.zzavb = false;
            this.zzaut = false;
            this.zzaua.clear();
            this.zzaun = false;
            this.zzauo = false;
            if (this.zzauh || (this.zzauk && this.zzauy)) {
                zzen();
                zzek();
            } else if (this.zzauw != 0) {
                zzen();
                zzek();
            } else {
                this.zzaue.flush();
                this.zzaux = false;
            }
            if (this.zzauu && this.zzaad != null) {
                this.zzauv = 1;
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzfd
    public void zzbm() {
        this.zzaad = null;
        try {
            zzen();
            try {
                if (this.zzauc != null) {
                    this.zzatv.zza(this.zzauc);
                }
                try {
                    if (!(this.zzaud == null || this.zzaud == this.zzauc)) {
                        this.zzatv.zza(this.zzaud);
                    }
                } finally {
                    this.zzauc = null;
                    this.zzaud = null;
                }
            } catch (Throwable th) {
                if (!(this.zzaud == null || this.zzaud == this.zzauc)) {
                    this.zzatv.zza(this.zzaud);
                }
                throw th;
            } finally {
                this.zzauc = null;
                this.zzaud = null;
            }
        } catch (Throwable th2) {
            try {
                if (!(this.zzaud == null || this.zzaud == this.zzauc)) {
                    this.zzatv.zza(this.zzaud);
                }
                throw th2;
            } finally {
                this.zzauc = null;
                this.zzaud = null;
            }
        } finally {
        }
    }

    /* access modifiers changed from: protected */
    public void zzen() {
        this.zzauq = -9223372036854775807L;
        this.zzaur = -1;
        this.zzaus = -1;
        this.zzavb = false;
        this.zzaut = false;
        this.zzaua.clear();
        this.zzaup = null;
        this.zzadk = null;
        this.zzauf = null;
        this.zzauu = false;
        this.zzaux = false;
        this.zzaug = false;
        this.zzauh = false;
        this.zzaui = false;
        this.zzauj = false;
        this.zzauk = false;
        this.zzaum = false;
        this.zzaun = false;
        this.zzauo = false;
        this.zzauy = false;
        this.zzauv = 0;
        this.zzauw = 0;
        this.zzatx.zzdd = null;
        if (this.zzaue != null) {
            this.zzavd.zzagh++;
            try {
                this.zzaue.stop();
                try {
                    this.zzaue.release();
                    this.zzaue = null;
                    zzhs<Object> zzhs = this.zzauc;
                    if (zzhs != null && this.zzaud != zzhs) {
                        try {
                            this.zzatv.zza(zzhs);
                        } finally {
                            this.zzauc = null;
                        }
                    }
                } catch (Throwable th) {
                    this.zzaue = null;
                    zzhs<Object> zzhs2 = this.zzauc;
                    if (!(zzhs2 == null || this.zzaud == zzhs2)) {
                        this.zzatv.zza(zzhs2);
                    }
                    throw th;
                } finally {
                    this.zzauc = null;
                }
            } catch (Throwable th2) {
                this.zzaue = null;
                zzhs<Object> zzhs3 = this.zzauc;
                if (!(zzhs3 == null || this.zzaud == zzhs3)) {
                    try {
                        this.zzatv.zza(zzhs3);
                    } finally {
                        this.zzauc = null;
                    }
                }
                throw th2;
            } finally {
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfz
    public final void zzb(long j, long j2) throws zzff {
        if (this.zzava) {
            zzdj();
            return;
        }
        if (this.zzaad == null) {
            this.zzaty.clear();
            int zza = zza(this.zzatz, this.zzaty, true);
            if (zza == -5) {
                zze(this.zzatz.zzaad);
            } else if (zza == -4) {
                zzpo.checkState(this.zzaty.zzdp());
                this.zzauz = true;
                zzep();
                return;
            } else {
                return;
            }
        }
        zzek();
        if (this.zzaue != null) {
            zzqc.beginSection("drainAndFeed");
            do {
            } while (zzd(j, j2));
            do {
            } while (zzeo());
            zzqc.endSection();
        } else {
            zze(j);
            this.zzaty.clear();
            int zza2 = zza(this.zzatz, this.zzaty, false);
            if (zza2 == -5) {
                zze(this.zzatz.zzaad);
            } else if (zza2 == -4) {
                zzpo.checkState(this.zzaty.zzdp());
                this.zzauz = true;
                zzep();
            }
        }
        this.zzavd.zzds();
    }

    /* JADX WARNING: Removed duplicated region for block: B:84:0x014b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x014c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzeo() throws com.google.android.gms.internal.ads.zzff {
        /*
        // Method dump skipped, instructions count: 471
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjy.zzeo():boolean");
    }

    /* access modifiers changed from: protected */
    public void zze(zzfs zzfs) throws zzff {
        zzhp zzhp;
        MediaCodec mediaCodec;
        zzfs zzfs2 = this.zzaad;
        this.zzaad = zzfs;
        zzhp zzhp2 = this.zzaad.zzzm;
        if (zzfs2 == null) {
            zzhp = null;
        } else {
            zzhp = zzfs2.zzzm;
        }
        boolean zza = zzqe.zza(zzhp2, zzhp);
        boolean z = true;
        if (!zza) {
            if (this.zzaad.zzzm != null) {
                zzhu<Object> zzhu = this.zzatv;
                if (zzhu != null) {
                    this.zzaud = zzhu.zza(Looper.myLooper(), this.zzaad.zzzm);
                    zzhs<Object> zzhs = this.zzaud;
                    if (zzhs == this.zzauc) {
                        this.zzatv.zza(zzhs);
                    }
                } else {
                    throw zzff.zza(new IllegalStateException("Media requires a DrmSessionManager"), getIndex());
                }
            } else {
                this.zzaud = null;
            }
        }
        if (this.zzaud == this.zzauc && (mediaCodec = this.zzaue) != null && zza(mediaCodec, this.zzauf.zzatq, zzfs2, this.zzaad)) {
            this.zzauu = true;
            this.zzauv = 1;
            if (!(this.zzaui && this.zzaad.width == zzfs2.width && this.zzaad.height == zzfs2.height)) {
                z = false;
            }
            this.zzaun = z;
        } else if (this.zzaux) {
            this.zzauw = 1;
        } else {
            zzen();
            zzek();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfz
    public boolean zzcj() {
        return this.zzava;
    }

    @Override // com.google.android.gms.internal.ads.zzfz
    public boolean isReady() {
        if (this.zzaad == null || this.zzavb) {
            return false;
        }
        if (zzbo() || this.zzaus >= 0) {
            return true;
        }
        return this.zzauq != -9223372036854775807L && SystemClock.elapsedRealtime() < this.zzauq;
    }

    private final boolean zzd(long j, long j2) throws zzff {
        boolean z;
        boolean z2;
        if (this.zzaus < 0) {
            if (!this.zzaul || !this.zzauy) {
                this.zzaus = this.zzaue.dequeueOutputBuffer(this.zzaub, 0);
            } else {
                try {
                    this.zzaus = this.zzaue.dequeueOutputBuffer(this.zzaub, 0);
                } catch (IllegalStateException unused) {
                    zzep();
                    if (this.zzava) {
                        zzen();
                    }
                    return false;
                }
            }
            int i = this.zzaus;
            if (i >= 0) {
                if (this.zzauo) {
                    this.zzauo = false;
                    this.zzaue.releaseOutputBuffer(i, false);
                    this.zzaus = -1;
                    return true;
                } else if ((this.zzaub.flags & 4) != 0) {
                    zzep();
                    this.zzaus = -1;
                    return false;
                } else {
                    ByteBuffer byteBuffer = this.zzadk[this.zzaus];
                    if (byteBuffer != null) {
                        byteBuffer.position(this.zzaub.offset);
                        byteBuffer.limit(this.zzaub.offset + this.zzaub.size);
                    }
                    long j3 = this.zzaub.presentationTimeUs;
                    int size = this.zzaua.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            z2 = false;
                            break;
                        } else if (this.zzaua.get(i2).longValue() == j3) {
                            this.zzaua.remove(i2);
                            z2 = true;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    this.zzaut = z2;
                }
            } else if (i == -2) {
                MediaFormat outputFormat = this.zzaue.getOutputFormat();
                if (this.zzaui && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
                    this.zzauo = true;
                } else {
                    if (this.zzaum) {
                        outputFormat.setInteger("channel-count", 1);
                    }
                    onOutputFormatChanged(this.zzaue, outputFormat);
                }
                return true;
            } else if (i == -3) {
                this.zzadk = this.zzaue.getOutputBuffers();
                return true;
            } else {
                if (this.zzauj && (this.zzauz || this.zzauw == 2)) {
                    zzep();
                }
                return false;
            }
        }
        if (!this.zzaul || !this.zzauy) {
            MediaCodec mediaCodec = this.zzaue;
            ByteBuffer[] byteBufferArr = this.zzadk;
            int i3 = this.zzaus;
            z = zza(j, j2, mediaCodec, byteBufferArr[i3], i3, this.zzaub.flags, this.zzaub.presentationTimeUs, this.zzaut);
        } else {
            try {
                z = zza(j, j2, this.zzaue, this.zzadk[this.zzaus], this.zzaus, this.zzaub.flags, this.zzaub.presentationTimeUs, this.zzaut);
            } catch (IllegalStateException unused2) {
                zzep();
                if (this.zzava) {
                    zzen();
                }
                return false;
            }
        }
        if (!z) {
            return false;
        }
        long j4 = this.zzaub.presentationTimeUs;
        this.zzaus = -1;
        return true;
    }

    private final void zzep() throws zzff {
        if (this.zzauw == 2) {
            zzen();
            zzek();
            return;
        }
        this.zzava = true;
        zzdj();
    }
}
