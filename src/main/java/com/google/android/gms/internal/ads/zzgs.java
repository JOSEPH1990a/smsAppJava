package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.LinkedList;

public final class zzgs {
    private static boolean zzabu = false;
    private static boolean zzabv = false;
    private int streamType;
    private final zzgh zzabw = null;
    private final zzhb zzabx;
    private final zzhi zzaby;
    private final zzgi[] zzabz;
    private final zzgy zzaca;
    private final ConditionVariable zzacb;
    private final long[] zzacc;
    private final zzgu zzacd;
    private final LinkedList<zzgz> zzace;
    private AudioTrack zzacf;
    private int zzacg;
    private int zzach;
    private int zzaci;
    private boolean zzacj;
    private int zzack;
    private long zzacl;
    private zzfy zzacm;
    private long zzacn;
    private long zzaco;
    private ByteBuffer zzacp;
    private int zzacq;
    private int zzacr;
    private int zzacs;
    private long zzact;
    private long zzacu;
    private boolean zzacv;
    private long zzacw;
    private Method zzacx;
    private int zzacy;
    private long zzacz;
    private long zzada;
    private int zzadb;
    private long zzadc;
    private long zzadd;
    private int zzade;
    private int zzadf;
    private long zzadg;
    private long zzadh;
    private long zzadi;
    private zzgi[] zzadj;
    private ByteBuffer[] zzadk;
    private ByteBuffer zzadl;
    private ByteBuffer zzadm;
    private byte[] zzadn;
    private int zzado;
    private int zzadp;
    private boolean zzadq;
    private boolean zzadr;
    private int zzads;
    private boolean zzadt;
    private boolean zzadu;
    private long zzadv;
    private float zzcu;
    private zzfy zzxm;
    private int zzzu;

    public zzgs(zzgh zzgh, zzgi[] zzgiArr, zzgy zzgy) {
        this.zzaca = zzgy;
        this.zzacb = new ConditionVariable(true);
        if (zzqe.SDK_INT >= 18) {
            try {
                this.zzacx = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        if (zzqe.SDK_INT >= 19) {
            this.zzacd = new zzgv();
        } else {
            this.zzacd = new zzgu(null);
        }
        this.zzabx = new zzhb();
        this.zzaby = new zzhi();
        this.zzabz = new zzgi[(zzgiArr.length + 3)];
        this.zzabz[0] = new zzhg();
        zzgi[] zzgiArr2 = this.zzabz;
        zzgiArr2[1] = this.zzabx;
        System.arraycopy(zzgiArr, 0, zzgiArr2, 2, zzgiArr.length);
        this.zzabz[zzgiArr.length + 2] = this.zzaby;
        this.zzacc = new long[10];
        this.zzcu = 1.0f;
        this.zzadf = 0;
        this.streamType = 3;
        this.zzads = 0;
        this.zzxm = zzfy.zzaaf;
        this.zzadp = -1;
        this.zzadj = new zzgi[0];
        this.zzadk = new ByteBuffer[0];
        this.zzace = new LinkedList<>();
    }

    public final boolean zzq(String str) {
        zzgh zzgh = this.zzabw;
        return zzgh != null && zzgh.zzk(zzr(str));
    }

    public final long zzg(boolean z) {
        long j;
        long j2;
        if (!(isInitialized() && this.zzadf != 0)) {
            return Long.MIN_VALUE;
        }
        if (this.zzacf.getPlayState() == 3) {
            long zzde = this.zzacd.zzde();
            if (zzde != 0) {
                long nanoTime = System.nanoTime() / 1000;
                if (nanoTime - this.zzacu >= 30000) {
                    long[] jArr = this.zzacc;
                    int i = this.zzacr;
                    jArr[i] = zzde - nanoTime;
                    this.zzacr = (i + 1) % 10;
                    int i2 = this.zzacs;
                    if (i2 < 10) {
                        this.zzacs = i2 + 1;
                    }
                    this.zzacu = nanoTime;
                    this.zzact = 0;
                    int i3 = 0;
                    while (true) {
                        int i4 = this.zzacs;
                        if (i3 >= i4) {
                            break;
                        }
                        this.zzact += this.zzacc[i3] / ((long) i4);
                        i3++;
                    }
                }
                if (!zzdc() && nanoTime - this.zzacw >= 500000) {
                    this.zzacv = this.zzacd.zzdf();
                    if (this.zzacv) {
                        long zzdg = this.zzacd.zzdg() / 1000;
                        long zzdh = this.zzacd.zzdh();
                        if (zzdg < this.zzadh) {
                            this.zzacv = false;
                        } else if (Math.abs(zzdg - nanoTime) > 5000000) {
                            StringBuilder sb = new StringBuilder(136);
                            sb.append("Spurious audio timestamp (system clock mismatch): ");
                            sb.append(zzdh);
                            sb.append(", ");
                            sb.append(zzdg);
                            sb.append(", ");
                            sb.append(nanoTime);
                            sb.append(", ");
                            sb.append(zzde);
                            Log.w("AudioTrack", sb.toString());
                            this.zzacv = false;
                        } else if (Math.abs(zzn(zzdh) - zzde) > 5000000) {
                            StringBuilder sb2 = new StringBuilder(138);
                            sb2.append("Spurious audio timestamp (frame position mismatch): ");
                            sb2.append(zzdh);
                            sb2.append(", ");
                            sb2.append(zzdg);
                            sb2.append(", ");
                            sb2.append(nanoTime);
                            sb2.append(", ");
                            sb2.append(zzde);
                            Log.w("AudioTrack", sb2.toString());
                            this.zzacv = false;
                        }
                    }
                    Method method = this.zzacx;
                    if (method != null && !this.zzacj) {
                        try {
                            this.zzadi = (((long) ((Integer) method.invoke(this.zzacf, null)).intValue()) * 1000) - this.zzacl;
                            this.zzadi = Math.max(this.zzadi, 0L);
                            if (this.zzadi > 5000000) {
                                long j3 = this.zzadi;
                                StringBuilder sb3 = new StringBuilder(61);
                                sb3.append("Ignoring impossibly large audio latency: ");
                                sb3.append(j3);
                                Log.w("AudioTrack", sb3.toString());
                                this.zzadi = 0;
                            }
                        } catch (Exception unused) {
                            this.zzacx = null;
                        }
                    }
                    this.zzacw = nanoTime;
                }
            }
        }
        long nanoTime2 = System.nanoTime() / 1000;
        if (this.zzacv) {
            j = zzn(this.zzacd.zzdh() + zzo(nanoTime2 - (this.zzacd.zzdg() / 1000)));
        } else {
            if (this.zzacs == 0) {
                j = this.zzacd.zzde();
            } else {
                j = nanoTime2 + this.zzact;
            }
            if (!z) {
                j -= this.zzadi;
            }
        }
        long j4 = this.zzadg;
        while (!this.zzace.isEmpty() && j >= this.zzace.getFirst().zzyz) {
            zzgz remove = this.zzace.remove();
            this.zzxm = remove.zzxm;
            this.zzaco = remove.zzyz;
            this.zzacn = remove.zzaek - this.zzadg;
        }
        if (this.zzxm.zzaag == 1.0f) {
            j2 = (j + this.zzacn) - this.zzaco;
        } else if (!this.zzace.isEmpty() || this.zzaby.zzdn() < PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
            long j5 = this.zzacn;
            double d = (double) this.zzxm.zzaag;
            double d2 = (double) (j - this.zzaco);
            Double.isNaN(d);
            Double.isNaN(d2);
            j2 = ((long) (d * d2)) + j5;
        } else {
            j2 = zzqe.zza(j - this.zzaco, this.zzaby.zzdm(), this.zzaby.zzdn()) + this.zzacn;
        }
        return j4 + j2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0142  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r8, int r9, int r10, int r11, int r12, int[] r13) throws com.google.android.gms.internal.ads.zzgw {
        /*
        // Method dump skipped, instructions count: 360
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgs.zza(java.lang.String, int, int, int, int, int[]):void");
    }

    private final void zzcs() {
        ArrayList arrayList = new ArrayList();
        zzgi[] zzgiArr = this.zzabz;
        for (zzgi zzgi : zzgiArr) {
            if (zzgi.isActive()) {
                arrayList.add(zzgi);
            } else {
                zzgi.flush();
            }
        }
        int size = arrayList.size();
        this.zzadj = (zzgi[]) arrayList.toArray(new zzgi[size]);
        this.zzadk = new ByteBuffer[size];
        for (int i = 0; i < size; i++) {
            zzgi zzgi2 = this.zzadj[i];
            zzgi2.flush();
            this.zzadk[i] = zzgi2.zzcr();
        }
    }

    public final void play() {
        this.zzadr = true;
        if (isInitialized()) {
            this.zzadh = System.nanoTime() / 1000;
            this.zzacf.play();
        }
    }

    public final void zzct() {
        if (this.zzadf == 1) {
            this.zzadf = 2;
        }
    }

    public final boolean zza(ByteBuffer byteBuffer, long j) throws zzgx, zzha {
        int i;
        int i2;
        ByteBuffer byteBuffer2 = this.zzadl;
        zzpo.checkArgument(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (!isInitialized()) {
            this.zzacb.block();
            if (this.zzadt) {
                this.zzacf = new AudioTrack(new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(16).build(), new AudioFormat.Builder().setChannelMask(this.zzacg).setEncoding(this.zzaci).setSampleRate(this.zzzu).build(), this.zzack, 1, this.zzads);
            } else {
                int i3 = this.zzads;
                if (i3 == 0) {
                    this.zzacf = new AudioTrack(this.streamType, this.zzzu, this.zzacg, this.zzaci, this.zzack, 1);
                } else {
                    this.zzacf = new AudioTrack(this.streamType, this.zzzu, this.zzacg, this.zzaci, this.zzack, 1, i3);
                }
            }
            int state = this.zzacf.getState();
            if (state == 1) {
                int audioSessionId = this.zzacf.getAudioSessionId();
                if (this.zzads != audioSessionId) {
                    this.zzads = audioSessionId;
                    this.zzaca.zzl(audioSessionId);
                }
                this.zzacd.zza(this.zzacf, zzdc());
                zzcz();
                this.zzadu = false;
                if (this.zzadr) {
                    play();
                }
            } else {
                try {
                    this.zzacf.release();
                } catch (Exception unused) {
                } finally {
                    this.zzacf = null;
                }
                throw new zzgx(state, this.zzzu, this.zzacg, this.zzack);
            }
        }
        if (zzdc()) {
            if (this.zzacf.getPlayState() == 2) {
                this.zzadu = false;
                return false;
            } else if (this.zzacf.getPlayState() == 1 && this.zzacd.zzdd() != 0) {
                return false;
            }
        }
        boolean z = this.zzadu;
        this.zzadu = zzcw();
        if (z && !this.zzadu && this.zzacf.getPlayState() != 1) {
            this.zzaca.zzc(this.zzack, zzfe.zzf(this.zzacl), SystemClock.elapsedRealtime() - this.zzadv);
        }
        if (this.zzadl == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (this.zzacj && this.zzade == 0) {
                int i4 = this.zzaci;
                if (i4 == 7 || i4 == 8) {
                    i2 = zzhc.zzj(byteBuffer);
                } else if (i4 == 5) {
                    i2 = zzgg.zzcn();
                } else if (i4 == 6) {
                    i2 = zzgg.zzh(byteBuffer);
                } else {
                    StringBuilder sb = new StringBuilder(38);
                    sb.append("Unexpected audio encoding: ");
                    sb.append(i4);
                    throw new IllegalStateException(sb.toString());
                }
                this.zzade = i2;
            }
            if (this.zzacm != null) {
                if (!zzcv()) {
                    return false;
                }
                this.zzace.add(new zzgz(this.zzacm, Math.max(0L, j), zzn(zzda()), null));
                this.zzacm = null;
                zzcs();
            }
            if (this.zzadf == 0) {
                this.zzadg = Math.max(0L, j);
                this.zzadf = 1;
            } else {
                long zzn = this.zzadg + zzn(this.zzacj ? this.zzada : this.zzacz / ((long) this.zzacy));
                if (this.zzadf != 1) {
                    i = 2;
                } else if (Math.abs(zzn - j) > 200000) {
                    StringBuilder sb2 = new StringBuilder(80);
                    sb2.append("Discontinuity detected [expected ");
                    sb2.append(zzn);
                    sb2.append(", got ");
                    sb2.append(j);
                    sb2.append("]");
                    Log.e("AudioTrack", sb2.toString());
                    i = 2;
                    this.zzadf = 2;
                } else {
                    i = 2;
                }
                if (this.zzadf == i) {
                    this.zzadg += j - zzn;
                    this.zzadf = 1;
                    this.zzaca.zzbs();
                }
            }
            if (this.zzacj) {
                this.zzada += (long) this.zzade;
            } else {
                this.zzacz += (long) byteBuffer.remaining();
            }
            this.zzadl = byteBuffer;
        }
        if (this.zzacj) {
            zzb(this.zzadl, j);
        } else {
            zzm(j);
        }
        if (this.zzadl.hasRemaining()) {
            return false;
        }
        this.zzadl = null;
        return true;
    }

    private final void zzm(long j) throws zzha {
        ByteBuffer byteBuffer;
        int length = this.zzadj.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.zzadk[i - 1];
            } else {
                byteBuffer = this.zzadl;
                if (byteBuffer == null) {
                    byteBuffer = zzgi.zzabh;
                }
            }
            if (i == length) {
                zzb(byteBuffer, j);
            } else {
                zzgi zzgi = this.zzadj[i];
                zzgi.zzi(byteBuffer);
                ByteBuffer zzcr = zzgi.zzcr();
                this.zzadk[i] = zzcr;
                if (zzcr.hasRemaining()) {
                    i++;
                }
            }
            if (!byteBuffer.hasRemaining()) {
                i--;
            } else {
                return;
            }
        }
    }

    private final boolean zzb(ByteBuffer byteBuffer, long j) throws zzha {
        int i;
        if (!byteBuffer.hasRemaining()) {
            return true;
        }
        ByteBuffer byteBuffer2 = this.zzadm;
        if (byteBuffer2 != null) {
            zzpo.checkArgument(byteBuffer2 == byteBuffer);
        } else {
            this.zzadm = byteBuffer;
            if (zzqe.SDK_INT < 21) {
                int remaining = byteBuffer.remaining();
                byte[] bArr = this.zzadn;
                if (bArr == null || bArr.length < remaining) {
                    this.zzadn = new byte[remaining];
                }
                int position = byteBuffer.position();
                byteBuffer.get(this.zzadn, 0, remaining);
                byteBuffer.position(position);
                this.zzado = 0;
            }
        }
        int remaining2 = byteBuffer.remaining();
        if (zzqe.SDK_INT < 21) {
            int zzdd = this.zzack - ((int) (this.zzadc - (this.zzacd.zzdd() * ((long) this.zzadb))));
            if (zzdd > 0) {
                i = this.zzacf.write(this.zzadn, this.zzado, Math.min(remaining2, zzdd));
                if (i > 0) {
                    this.zzado += i;
                    byteBuffer.position(byteBuffer.position() + i);
                }
            } else {
                i = 0;
            }
        } else if (this.zzadt) {
            zzpo.checkState(j != -9223372036854775807L);
            AudioTrack audioTrack = this.zzacf;
            if (this.zzacp == null) {
                this.zzacp = ByteBuffer.allocate(16);
                this.zzacp.order(ByteOrder.BIG_ENDIAN);
                this.zzacp.putInt(1431633921);
            }
            if (this.zzacq == 0) {
                this.zzacp.putInt(4, remaining2);
                this.zzacp.putLong(8, j * 1000);
                this.zzacp.position(0);
                this.zzacq = remaining2;
            }
            int remaining3 = this.zzacp.remaining();
            if (remaining3 > 0) {
                int write = audioTrack.write(this.zzacp, remaining3, 1);
                if (write < 0) {
                    this.zzacq = 0;
                    i = write;
                } else if (write < remaining3) {
                    i = 0;
                }
            }
            int write2 = audioTrack.write(byteBuffer, remaining2, 1);
            if (write2 < 0) {
                this.zzacq = 0;
            } else {
                this.zzacq -= write2;
            }
            i = write2;
        } else {
            i = this.zzacf.write(byteBuffer, remaining2, 1);
        }
        this.zzadv = SystemClock.elapsedRealtime();
        if (i >= 0) {
            if (!this.zzacj) {
                this.zzadc += (long) i;
            }
            if (i != remaining2) {
                return false;
            }
            if (this.zzacj) {
                this.zzadd += (long) this.zzade;
            }
            this.zzadm = null;
            return true;
        }
        throw new zzha(i);
    }

    public final void zzcu() throws zzha {
        if (!this.zzadq && isInitialized() && zzcv()) {
            this.zzacd.zzp(zzda());
            this.zzacq = 0;
            this.zzadq = true;
        }
    }

    private final boolean zzcv() throws zzha {
        boolean z;
        if (this.zzadp == -1) {
            this.zzadp = this.zzacj ? this.zzadj.length : 0;
            z = true;
        } else {
            z = false;
        }
        while (true) {
            int i = this.zzadp;
            zzgi[] zzgiArr = this.zzadj;
            if (i < zzgiArr.length) {
                zzgi zzgi = zzgiArr[i];
                if (z) {
                    zzgi.zzcq();
                }
                zzm(-9223372036854775807L);
                if (!zzgi.zzcj()) {
                    return false;
                }
                this.zzadp++;
                z = true;
            } else {
                ByteBuffer byteBuffer = this.zzadm;
                if (byteBuffer != null) {
                    zzb(byteBuffer, -9223372036854775807L);
                    if (this.zzadm != null) {
                        return false;
                    }
                }
                this.zzadp = -1;
                return true;
            }
        }
    }

    public final boolean zzcj() {
        if (isInitialized()) {
            return this.zzadq && !zzcw();
        }
        return true;
    }

    public final boolean zzcw() {
        if (isInitialized()) {
            if (zzda() <= this.zzacd.zzdd()) {
                if (zzdc() && this.zzacf.getPlayState() == 2 && this.zzacf.getPlaybackHeadPosition() == 0) {
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    public final zzfy zzb(zzfy zzfy) {
        if (this.zzacj) {
            this.zzxm = zzfy.zzaaf;
            return this.zzxm;
        }
        zzfy zzfy2 = new zzfy(this.zzaby.zzb(zzfy.zzaag), this.zzaby.zzc(zzfy.zzaah));
        zzfy zzfy3 = this.zzacm;
        if (zzfy3 == null) {
            if (!this.zzace.isEmpty()) {
                zzfy3 = this.zzace.getLast().zzxm;
            } else {
                zzfy3 = this.zzxm;
            }
        }
        if (!zzfy2.equals(zzfy3)) {
            if (isInitialized()) {
                this.zzacm = zzfy2;
            } else {
                this.zzxm = zzfy2;
            }
        }
        return this.zzxm;
    }

    public final zzfy zzcx() {
        return this.zzxm;
    }

    public final void setStreamType(int i) {
        if (this.streamType != i) {
            this.streamType = i;
            if (!this.zzadt) {
                reset();
                this.zzads = 0;
            }
        }
    }

    public final void zzn(int i) {
        zzpo.checkState(zzqe.SDK_INT >= 21);
        if (!this.zzadt || this.zzads != i) {
            this.zzadt = true;
            this.zzads = i;
            reset();
        }
    }

    public final void zzcy() {
        if (this.zzadt) {
            this.zzadt = false;
            this.zzads = 0;
            reset();
        }
    }

    public final void setVolume(float f) {
        if (this.zzcu != f) {
            this.zzcu = f;
            zzcz();
        }
    }

    private final void zzcz() {
        if (!isInitialized()) {
            return;
        }
        if (zzqe.SDK_INT >= 21) {
            this.zzacf.setVolume(this.zzcu);
            return;
        }
        AudioTrack audioTrack = this.zzacf;
        float f = this.zzcu;
        audioTrack.setStereoVolume(f, f);
    }

    public final void pause() {
        this.zzadr = false;
        if (isInitialized()) {
            zzdb();
            this.zzacd.pause();
        }
    }

    public final void reset() {
        if (isInitialized()) {
            this.zzacz = 0;
            this.zzada = 0;
            this.zzadc = 0;
            this.zzadd = 0;
            this.zzade = 0;
            zzfy zzfy = this.zzacm;
            if (zzfy != null) {
                this.zzxm = zzfy;
                this.zzacm = null;
            } else if (!this.zzace.isEmpty()) {
                this.zzxm = this.zzace.getLast().zzxm;
            }
            this.zzace.clear();
            this.zzacn = 0;
            this.zzaco = 0;
            this.zzadl = null;
            this.zzadm = null;
            int i = 0;
            while (true) {
                zzgi[] zzgiArr = this.zzadj;
                if (i >= zzgiArr.length) {
                    break;
                }
                zzgi zzgi = zzgiArr[i];
                zzgi.flush();
                this.zzadk[i] = zzgi.zzcr();
                i++;
            }
            this.zzadq = false;
            this.zzadp = -1;
            this.zzacp = null;
            this.zzacq = 0;
            this.zzadf = 0;
            this.zzadi = 0;
            zzdb();
            if (this.zzacf.getPlayState() == 3) {
                this.zzacf.pause();
            }
            AudioTrack audioTrack = this.zzacf;
            this.zzacf = null;
            this.zzacd.zza(null, false);
            this.zzacb.close();
            new zzgt(this, audioTrack).start();
        }
    }

    public final void release() {
        reset();
        for (zzgi zzgi : this.zzabz) {
            zzgi.reset();
        }
        this.zzads = 0;
        this.zzadr = false;
    }

    private final boolean isInitialized() {
        return this.zzacf != null;
    }

    private final long zzn(long j) {
        return (j * 1000000) / ((long) this.zzzu);
    }

    private final long zzo(long j) {
        return (j * ((long) this.zzzu)) / 1000000;
    }

    private final long zzda() {
        return this.zzacj ? this.zzadd : this.zzadc / ((long) this.zzadb);
    }

    private final void zzdb() {
        this.zzact = 0;
        this.zzacs = 0;
        this.zzacr = 0;
        this.zzacu = 0;
        this.zzacv = false;
        this.zzacw = 0;
    }

    private final boolean zzdc() {
        if (zzqe.SDK_INT >= 23) {
            return false;
        }
        int i = this.zzaci;
        return i == 5 || i == 6;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0046 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0047 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004e A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zzr(java.lang.String r3) {
        /*
            int r0 = r3.hashCode()
            r1 = -1095064472(0xffffffffbebaa468, float:-0.36453557)
            r2 = 0
            if (r0 == r1) goto L_0x0038
            r1 = 187078296(0xb269698, float:3.208373E-32)
            if (r0 == r1) goto L_0x002e
            r1 = 1504578661(0x59ae0c65, float:6.1237842E15)
            if (r0 == r1) goto L_0x0024
            r1 = 1505942594(0x59c2dc42, float:6.8560402E15)
            if (r0 == r1) goto L_0x001a
            goto L_0x0042
        L_0x001a:
            java.lang.String r0 = "audio/vnd.dts.hd"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0042
            r3 = 3
            goto L_0x0043
        L_0x0024:
            java.lang.String r0 = "audio/eac3"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0042
            r3 = 1
            goto L_0x0043
        L_0x002e:
            java.lang.String r0 = "audio/ac3"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0042
            r3 = 0
            goto L_0x0043
        L_0x0038:
            java.lang.String r0 = "audio/vnd.dts"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0042
            r3 = 2
            goto L_0x0043
        L_0x0042:
            r3 = -1
        L_0x0043:
            switch(r3) {
                case 0: goto L_0x004e;
                case 1: goto L_0x004c;
                case 2: goto L_0x004a;
                case 3: goto L_0x0047;
                default: goto L_0x0046;
            }
        L_0x0046:
            return r2
        L_0x0047:
            r3 = 8
            return r3
        L_0x004a:
            r3 = 7
            return r3
        L_0x004c:
            r3 = 6
            return r3
        L_0x004e:
            r3 = 5
            return r3
            switch-data {0->0x004e, 1->0x004c, 2->0x004a, 3->0x0047, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgs.zzr(java.lang.String):int");
    }
}
