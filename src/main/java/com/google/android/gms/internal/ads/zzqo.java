package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class zzqo extends zzjy {
    private static final int[] zzbis = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private int zzaak;
    private boolean zzadt;
    private final zzqs zzbit;
    private final zzqv zzbiu;
    private final long zzbiv;
    private final int zzbiw;
    private final boolean zzbix;
    private final long[] zzbiy;
    private zzfs[] zzbiz;
    private zzqq zzbja;
    private Surface zzbjb;
    private Surface zzbjc;
    private int zzbjd;
    private boolean zzbje;
    private long zzbjf;
    private long zzbjg;
    private int zzbjh;
    private int zzbji;
    private int zzbjj;
    private float zzbjk;
    private int zzbjl;
    private int zzbjm;
    private int zzbjn;
    private float zzbjo;
    private int zzbjp;
    private int zzbjq;
    private int zzbjr;
    private float zzbjs;
    zzqr zzbjt;
    private long zzbju;
    private int zzbjv;
    private final Context zzsp;

    public zzqo(Context context, zzka zzka, long j, Handler handler, zzqu zzqu, int i) {
        this(context, zzka, 0, null, false, handler, zzqu, -1);
    }

    private static boolean zzan(long j) {
        return j < -30000;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzqo(Context context, zzka zzka, long j, zzhu<Object> zzhu, boolean z, Handler handler, zzqu zzqu, int i) {
        super(2, zzka, null, false);
        boolean z2 = false;
        this.zzbiv = 0;
        this.zzbiw = -1;
        this.zzsp = context.getApplicationContext();
        this.zzbit = new zzqs(context);
        this.zzbiu = new zzqv(handler, zzqu);
        if (zzqe.SDK_INT <= 22 && "foster".equals(zzqe.DEVICE) && "NVIDIA".equals(zzqe.MANUFACTURER)) {
            z2 = true;
        }
        this.zzbix = z2;
        this.zzbiy = new long[10];
        this.zzbju = -9223372036854775807L;
        this.zzbjf = -9223372036854775807L;
        this.zzbjl = -1;
        this.zzbjm = -1;
        this.zzbjo = -1.0f;
        this.zzbjk = -1.0f;
        this.zzbjd = 1;
        zzhr();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzjy
    public final int zza(zzka zzka, zzfs zzfs) throws zzke {
        boolean z;
        String str = zzfs.zzzj;
        int i = 0;
        if (!zzpt.zzac(str)) {
            return 0;
        }
        zzhp zzhp = zzfs.zzzm;
        if (zzhp != null) {
            z = false;
            for (int i2 = 0; i2 < zzhp.zzagr; i2++) {
                z |= zzhp.zzu(i2).zzags;
            }
        } else {
            z = false;
        }
        zzjx zzb = zzka.zzb(str, z);
        if (zzb == null) {
            return 1;
        }
        boolean zzu = zzb.zzu(zzfs.zzzg);
        if (zzu && zzfs.width > 0 && zzfs.height > 0) {
            if (zzqe.SDK_INT >= 21) {
                zzu = zzb.zza(zzfs.width, zzfs.height, (double) zzfs.zzzn);
            } else {
                zzu = zzfs.width * zzfs.height <= zzkc.zzer();
                if (!zzu) {
                    int i3 = zzfs.width;
                    int i4 = zzfs.height;
                    String str2 = zzqe.zzbic;
                    StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 56);
                    sb.append("FalseCheck [legacyFrameSize, ");
                    sb.append(i3);
                    sb.append("x");
                    sb.append(i4);
                    sb.append("] [");
                    sb.append(str2);
                    sb.append("]");
                    Log.d("MediaCodecVideoRenderer", sb.toString());
                }
            }
        }
        int i5 = zzb.zzatq ? 8 : 4;
        if (zzb.zzadt) {
            i = 16;
        }
        return (zzu ? 3 : 2) | i5 | i;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzjy, com.google.android.gms.internal.ads.zzfd
    public final void zzb(boolean z) throws zzff {
        super.zzb(z);
        this.zzaak = zzbn().zzaak;
        this.zzadt = this.zzaak != 0;
        this.zzbiu.zzc(this.zzavd);
        this.zzbit.enable();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzfd
    public final void zza(zzfs[] zzfsArr, long j) throws zzff {
        this.zzbiz = zzfsArr;
        if (this.zzbju == -9223372036854775807L) {
            this.zzbju = j;
        } else {
            int i = this.zzbjv;
            long[] jArr = this.zzbiy;
            if (i == jArr.length) {
                long j2 = jArr[i - 1];
                StringBuilder sb = new StringBuilder(65);
                sb.append("Too many stream changes, so dropping offset: ");
                sb.append(j2);
                Log.w("MediaCodecVideoRenderer", sb.toString());
            } else {
                this.zzbjv = i + 1;
            }
            this.zzbiy[this.zzbjv - 1] = j;
        }
        super.zza(zzfsArr, j);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzjy, com.google.android.gms.internal.ads.zzfd
    public final void zza(long j, boolean z) throws zzff {
        super.zza(j, z);
        zzhp();
        this.zzbji = 0;
        int i = this.zzbjv;
        if (i != 0) {
            this.zzbju = this.zzbiy[i - 1];
            this.zzbjv = 0;
        }
        if (z) {
            zzho();
        } else {
            this.zzbjf = -9223372036854775807L;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzjy, com.google.android.gms.internal.ads.zzfz
    public final boolean isReady() {
        Surface surface;
        if (super.isReady() && (this.zzbje || (((surface = this.zzbjc) != null && this.zzbjb == surface) || zzel() == null))) {
            this.zzbjf = -9223372036854775807L;
            return true;
        } else if (this.zzbjf == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.zzbjf) {
                return true;
            }
            this.zzbjf = -9223372036854775807L;
            return false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzjy, com.google.android.gms.internal.ads.zzfd
    public final void onStarted() {
        super.onStarted();
        this.zzbjh = 0;
        this.zzbjg = SystemClock.elapsedRealtime();
        this.zzbjf = -9223372036854775807L;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzjy, com.google.android.gms.internal.ads.zzfd
    public final void onStopped() {
        zzhu();
        super.onStopped();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzjy, com.google.android.gms.internal.ads.zzfd
    public final void zzbm() {
        this.zzbjl = -1;
        this.zzbjm = -1;
        this.zzbjo = -1.0f;
        this.zzbjk = -1.0f;
        this.zzbju = -9223372036854775807L;
        this.zzbjv = 0;
        zzhr();
        zzhp();
        this.zzbit.disable();
        this.zzbjt = null;
        this.zzadt = false;
        try {
            super.zzbm();
        } finally {
            this.zzavd.zzds();
            this.zzbiu.zzd(this.zzavd);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfd, com.google.android.gms.internal.ads.zzfi
    public final void zza(int i, Object obj) throws zzff {
        if (i == 1) {
            Surface surface = (Surface) obj;
            if (surface == null) {
                Surface surface2 = this.zzbjc;
                if (surface2 != null) {
                    surface = surface2;
                } else {
                    zzjx zzem = zzem();
                    if (zzem != null && zzl(zzem.zzatr)) {
                        this.zzbjc = zzqk.zzc(this.zzsp, zzem.zzatr);
                        surface = this.zzbjc;
                    }
                }
            }
            if (this.zzbjb != surface) {
                this.zzbjb = surface;
                int state = getState();
                if (state == 1 || state == 2) {
                    MediaCodec zzel = zzel();
                    if (zzqe.SDK_INT < 23 || zzel == null || surface == null) {
                        zzen();
                        zzek();
                    } else {
                        zzel.setOutputSurface(surface);
                    }
                }
                if (surface == null || surface == this.zzbjc) {
                    zzhr();
                    zzhp();
                    return;
                }
                zzht();
                zzhp();
                if (state == 2) {
                    zzho();
                }
            } else if (surface != null && surface != this.zzbjc) {
                zzht();
                if (this.zzbje) {
                    this.zzbiu.zzb(this.zzbjb);
                }
            }
        } else if (i == 4) {
            this.zzbjd = ((Integer) obj).intValue();
            MediaCodec zzel2 = zzel();
            if (zzel2 != null) {
                zzel2.setVideoScalingMode(this.zzbjd);
            }
        } else {
            super.zza(i, obj);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzjy
    public final boolean zza(zzjx zzjx) {
        return this.zzbjb != null || zzl(zzjx.zzatr);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzjy
    public final void zza(zzjx zzjx, MediaCodec mediaCodec, zzfs zzfs, MediaCrypto mediaCrypto) throws zzke {
        zzqq zzqq;
        Point point;
        zzfs[] zzfsArr = this.zzbiz;
        int i = zzfs.width;
        int i2 = zzfs.height;
        int zzj = zzj(zzfs);
        if (zzfsArr.length == 1) {
            zzqq = new zzqq(i, i2, zzj);
        } else {
            int i3 = i2;
            int i4 = zzj;
            boolean z = false;
            int i5 = i;
            for (zzfs zzfs2 : zzfsArr) {
                if (zza(zzjx.zzatq, zzfs, zzfs2)) {
                    z |= zzfs2.width == -1 || zzfs2.height == -1;
                    i5 = Math.max(i5, zzfs2.width);
                    int max = Math.max(i3, zzfs2.height);
                    i4 = Math.max(i4, zzj(zzfs2));
                    i3 = max;
                }
            }
            if (z) {
                StringBuilder sb = new StringBuilder(66);
                sb.append("Resolutions unknown. Codec max resolution: ");
                sb.append(i5);
                sb.append("x");
                sb.append(i3);
                Log.w("MediaCodecVideoRenderer", sb.toString());
                boolean z2 = zzfs.height > zzfs.width;
                int i6 = z2 ? zzfs.height : zzfs.width;
                int i7 = z2 ? zzfs.width : zzfs.height;
                float f = ((float) i7) / ((float) i6);
                int[] iArr = zzbis;
                int length = iArr.length;
                int i8 = 0;
                while (true) {
                    if (i8 >= length) {
                        point = null;
                        break;
                    }
                    int i9 = iArr[i8];
                    int i10 = (int) (((float) i9) * f);
                    if (i9 <= i6 || i10 <= i7) {
                        point = null;
                    } else {
                        if (zzqe.SDK_INT >= 21) {
                            int i11 = z2 ? i10 : i9;
                            if (!z2) {
                                i9 = i10;
                            }
                            Point zzc = zzjx.zzc(i11, i9);
                            if (zzjx.zza(zzc.x, zzc.y, (double) zzfs.zzzn)) {
                                point = zzc;
                                break;
                            }
                        } else {
                            int zzf = zzqe.zzf(i9, 16) << 4;
                            int zzf2 = zzqe.zzf(i10, 16) << 4;
                            if (zzf * zzf2 <= zzkc.zzer()) {
                                int i12 = z2 ? zzf2 : zzf;
                                if (z2) {
                                    zzf2 = zzf;
                                }
                                point = new Point(i12, zzf2);
                            }
                        }
                        i8++;
                        i6 = i6;
                        i7 = i7;
                    }
                }
                point = null;
                if (point != null) {
                    i5 = Math.max(i5, point.x);
                    i3 = Math.max(i3, point.y);
                    i4 = Math.max(i4, zza(zzfs.zzzj, i5, i3));
                    StringBuilder sb2 = new StringBuilder(57);
                    sb2.append("Codec max resolution adjusted to: ");
                    sb2.append(i5);
                    sb2.append("x");
                    sb2.append(i3);
                    Log.w("MediaCodecVideoRenderer", sb2.toString());
                }
            }
            zzqq = new zzqq(i5, i3, i4);
        }
        this.zzbja = zzqq;
        zzqq zzqq2 = this.zzbja;
        boolean z3 = this.zzbix;
        int i13 = this.zzaak;
        MediaFormat zzcf = zzfs.zzcf();
        zzcf.setInteger("max-width", zzqq2.width);
        zzcf.setInteger("max-height", zzqq2.height);
        if (zzqq2.zzbjw != -1) {
            zzcf.setInteger("max-input-size", zzqq2.zzbjw);
        }
        if (z3) {
            zzcf.setInteger("auto-frc", 0);
        }
        if (i13 != 0) {
            zzcf.setFeatureEnabled("tunneled-playback", true);
            zzcf.setInteger("audio-session-id", i13);
        }
        if (this.zzbjb == null) {
            zzpo.checkState(zzl(zzjx.zzatr));
            if (this.zzbjc == null) {
                this.zzbjc = zzqk.zzc(this.zzsp, zzjx.zzatr);
            }
            this.zzbjb = this.zzbjc;
        }
        mediaCodec.configure(zzcf, this.zzbjb, (MediaCrypto) null, 0);
        if (zzqe.SDK_INT >= 23 && this.zzadt) {
            this.zzbjt = new zzqr(this, mediaCodec);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzjy
    public final void zzen() {
        try {
            super.zzen();
        } finally {
            Surface surface = this.zzbjc;
            if (surface != null) {
                if (this.zzbjb == surface) {
                    this.zzbjb = null;
                }
                this.zzbjc.release();
                this.zzbjc = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzjy
    public final void zzc(String str, long j, long j2) {
        this.zzbiu.zzb(str, j, j2);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzjy
    public final void zze(zzfs zzfs) throws zzff {
        super.zze(zzfs);
        this.zzbiu.zzd(zzfs);
        this.zzbjk = zzfs.zzzp == -1.0f ? 1.0f : zzfs.zzzp;
        this.zzbjj = zzk(zzfs);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzjy
    public final void zza(zzho zzho) {
        if (zzqe.SDK_INT < 23 && this.zzadt) {
            zzhq();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzjy
    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int i;
        int i2;
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        if (z) {
            i = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            i = mediaFormat.getInteger("width");
        }
        this.zzbjl = i;
        if (z) {
            i2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            i2 = mediaFormat.getInteger("height");
        }
        this.zzbjm = i2;
        this.zzbjo = this.zzbjk;
        if (zzqe.SDK_INT >= 21) {
            int i3 = this.zzbjj;
            if (i3 == 90 || i3 == 270) {
                int i4 = this.zzbjl;
                this.zzbjl = this.zzbjm;
                this.zzbjm = i4;
                this.zzbjo = 1.0f / this.zzbjo;
            }
        } else {
            this.zzbjn = this.zzbjj;
        }
        mediaCodec.setVideoScalingMode(this.zzbjd);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzjy
    public final boolean zza(MediaCodec mediaCodec, boolean z, zzfs zzfs, zzfs zzfs2) {
        return zza(z, zzfs, zzfs2) && zzfs2.width <= this.zzbja.width && zzfs2.height <= this.zzbja.height && zzfs2.zzzk <= this.zzbja.zzbjw;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzjy
    public final boolean zza(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        while (true) {
            int i3 = this.zzbjv;
            if (i3 == 0) {
                break;
            }
            long[] jArr = this.zzbiy;
            if (j3 < jArr[0]) {
                break;
            }
            this.zzbju = jArr[0];
            this.zzbjv = i3 - 1;
            System.arraycopy(jArr, 1, jArr, 0, this.zzbjv);
        }
        long j4 = j3 - this.zzbju;
        if (z) {
            zza(mediaCodec, i, j4);
            return true;
        }
        long j5 = j3 - j;
        if (this.zzbjb == this.zzbjc) {
            if (!zzan(j5)) {
                return false;
            }
            zza(mediaCodec, i, j4);
            return true;
        } else if (!this.zzbje) {
            if (zzqe.SDK_INT >= 21) {
                zza(mediaCodec, i, j4, System.nanoTime());
            } else {
                zzb(mediaCodec, i, j4);
            }
            return true;
        } else if (getState() != 2) {
            return false;
        } else {
            long elapsedRealtime = j5 - ((SystemClock.elapsedRealtime() * 1000) - j2);
            long nanoTime = System.nanoTime();
            long zzh = this.zzbit.zzh(j3, (elapsedRealtime * 1000) + nanoTime);
            long j6 = (zzh - nanoTime) / 1000;
            if (zzan(j6)) {
                zzqc.beginSection("dropVideoBuffer");
                mediaCodec.releaseOutputBuffer(i, false);
                zzqc.endSection();
                this.zzavd.zzagl++;
                this.zzbjh++;
                this.zzbji++;
                this.zzavd.zzagm = Math.max(this.zzbji, this.zzavd.zzagm);
                if (this.zzbjh == this.zzbiw) {
                    zzhu();
                }
                return true;
            }
            if (zzqe.SDK_INT >= 21) {
                if (j6 < 50000) {
                    zza(mediaCodec, i, j4, zzh);
                    return true;
                }
            } else if (j6 < 30000) {
                if (j6 > 11000) {
                    try {
                        Thread.sleep((j6 - 10000) / 1000);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                zzb(mediaCodec, i, j4);
                return true;
            }
            return false;
        }
    }

    private final void zza(MediaCodec mediaCodec, int i, long j) {
        zzqc.beginSection("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        zzqc.endSection();
        this.zzavd.zzagk++;
    }

    private final void zzb(MediaCodec mediaCodec, int i, long j) {
        zzhs();
        zzqc.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        zzqc.endSection();
        this.zzavd.zzagj++;
        this.zzbji = 0;
        zzhq();
    }

    @TargetApi(21)
    private final void zza(MediaCodec mediaCodec, int i, long j, long j2) {
        zzhs();
        zzqc.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        zzqc.endSection();
        this.zzavd.zzagj++;
        this.zzbji = 0;
        zzhq();
    }

    private final boolean zzl(boolean z) {
        if (zzqe.SDK_INT < 23 || this.zzadt) {
            return false;
        }
        return !z || zzqk.zzb(this.zzsp);
    }

    private final void zzho() {
        this.zzbjf = this.zzbiv > 0 ? SystemClock.elapsedRealtime() + this.zzbiv : -9223372036854775807L;
    }

    private final void zzhp() {
        MediaCodec zzel;
        this.zzbje = false;
        if (zzqe.SDK_INT >= 23 && this.zzadt && (zzel = zzel()) != null) {
            this.zzbjt = new zzqr(this, zzel);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzhq() {
        if (!this.zzbje) {
            this.zzbje = true;
            this.zzbiu.zzb(this.zzbjb);
        }
    }

    private final void zzhr() {
        this.zzbjp = -1;
        this.zzbjq = -1;
        this.zzbjs = -1.0f;
        this.zzbjr = -1;
    }

    private final void zzhs() {
        if (this.zzbjp != this.zzbjl || this.zzbjq != this.zzbjm || this.zzbjr != this.zzbjn || this.zzbjs != this.zzbjo) {
            this.zzbiu.zzb(this.zzbjl, this.zzbjm, this.zzbjn, this.zzbjo);
            this.zzbjp = this.zzbjl;
            this.zzbjq = this.zzbjm;
            this.zzbjr = this.zzbjn;
            this.zzbjs = this.zzbjo;
        }
    }

    private final void zzht() {
        if (this.zzbjp != -1 || this.zzbjq != -1) {
            this.zzbiu.zzb(this.zzbjl, this.zzbjm, this.zzbjn, this.zzbjo);
        }
    }

    private final void zzhu() {
        if (this.zzbjh > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zzbiu.zzi(this.zzbjh, elapsedRealtime - this.zzbjg);
            this.zzbjh = 0;
            this.zzbjg = elapsedRealtime;
        }
    }

    private static int zzj(zzfs zzfs) {
        if (zzfs.zzzk != -1) {
            return zzfs.zzzk;
        }
        return zza(zzfs.zzzj, zzfs.width, zzfs.height);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private static int zza(String str, int i, int i2) {
        char c;
        int i3;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        int i4 = 4;
        switch (str.hashCode()) {
            case -1664118616:
                if (str.equals("video/3gpp")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1662541442:
                if (str.equals("video/hevc")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1187890754:
                if (str.equals("video/mp4v-es")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1331836730:
                if (str.equals("video/avc")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1599127256:
                if (str.equals("video/x-vnd.on2.vp8")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1599127257:
                if (str.equals("video/x-vnd.on2.vp9")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case 1:
                i3 = i * i2;
                i4 = 2;
                break;
            case 2:
                if (!"BRAVIA 4K 2015".equals(zzqe.MODEL)) {
                    i3 = ((zzqe.zzf(i, 16) * zzqe.zzf(i2, 16)) << 4) << 4;
                    i4 = 2;
                    break;
                } else {
                    return -1;
                }
            case 3:
                i3 = i * i2;
                i4 = 2;
                break;
            case 4:
            case 5:
                i3 = i * i2;
                break;
            default:
                return -1;
        }
        return (i3 * 3) / (i4 * 2);
    }

    private static boolean zza(boolean z, zzfs zzfs, zzfs zzfs2) {
        if (!zzfs.zzzj.equals(zzfs2.zzzj) || zzk(zzfs) != zzk(zzfs2)) {
            return false;
        }
        if (!z) {
            return zzfs.width == zzfs2.width && zzfs.height == zzfs2.height;
        }
        return true;
    }

    private static int zzk(zzfs zzfs) {
        if (zzfs.zzzo == -1) {
            return 0;
        }
        return zzfs.zzzo;
    }
}
