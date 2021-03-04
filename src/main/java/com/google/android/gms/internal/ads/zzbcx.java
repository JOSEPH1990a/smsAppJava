package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.google.android.gms.ads.internal.zzbv;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@zzark
@TargetApi(14)
public final class zzbcx extends zzbdi implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    private static final Map<Integer, String> zzeqe = new HashMap();
    private final zzbea zzeqf;
    private final boolean zzeqg;
    private int zzeqh = 0;
    private int zzeqi = 0;
    private MediaPlayer zzeqj;
    private Uri zzeqk;
    private int zzeql;
    private int zzeqm;
    private int zzeqn;
    private int zzeqo;
    private int zzeqp;
    private zzbdx zzeqq;
    private boolean zzeqr;
    private int zzeqs;
    private zzbdh zzeqt;

    public zzbcx(Context context, boolean z, boolean z2, zzbdy zzbdy, zzbea zzbea) {
        super(context);
        setSurfaceTextureListener(this);
        this.zzeqf = zzbea;
        this.zzeqr = z;
        this.zzeqg = z2;
        this.zzeqf.zzb(this);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final String zzaaz() {
        String valueOf = String.valueOf(this.zzeqr ? " spherical" : "");
        return valueOf.length() != 0 ? "MediaPlayer".concat(valueOf) : new String("MediaPlayer");
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zza(zzbdh zzbdh) {
        this.zzeqt = zzbdh;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void setVideoPath(String str) {
        Uri parse = Uri.parse(str);
        zzty zzd = zzty.zzd(parse);
        if (zzd != null) {
            parse = Uri.parse(zzd.url);
        }
        this.zzeqk = parse;
        this.zzeqs = 0;
        zzaba();
        requestLayout();
        invalidate();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void stop() {
        zzaxz.v("AdMediaPlayerView stop");
        MediaPlayer mediaPlayer = this.zzeqj;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.zzeqj.release();
            this.zzeqj = null;
            zzcx(0);
            this.zzeqi = 0;
        }
        this.zzeqf.onStop();
    }

    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdMediaPlayerView size changed: ");
        sb.append(i);
        sb.append(" x ");
        sb.append(i2);
        zzaxz.v(sb.toString());
        this.zzeql = mediaPlayer.getVideoWidth();
        this.zzeqm = mediaPlayer.getVideoHeight();
        if (this.zzeql != 0 && this.zzeqm != 0) {
            requestLayout();
        }
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        zzaxz.v("AdMediaPlayerView prepared");
        zzcx(2);
        this.zzeqf.zzcg();
        zzayh.zzelc.post(new zzbcz(this));
        this.zzeql = mediaPlayer.getVideoWidth();
        this.zzeqm = mediaPlayer.getVideoHeight();
        int i = this.zzeqs;
        if (i != 0) {
            seekTo(i);
        }
        zzabb();
        int i2 = this.zzeql;
        int i3 = this.zzeqm;
        StringBuilder sb = new StringBuilder(62);
        sb.append("AdMediaPlayerView stream dimensions: ");
        sb.append(i2);
        sb.append(" x ");
        sb.append(i3);
        zzaxz.zzen(sb.toString());
        if (this.zzeqi == 3) {
            play();
        }
        zzabd();
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        zzaxz.v("AdMediaPlayerView completion");
        zzcx(5);
        this.zzeqi = 5;
        zzayh.zzelc.post(new zzbda(this));
    }

    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        String str = zzeqe.get(Integer.valueOf(i));
        String str2 = zzeqe.get(Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 37 + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer info: ");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        zzaxz.v(sb.toString());
        return true;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        String str = zzeqe.get(Integer.valueOf(i));
        String str2 = zzeqe.get(Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 38 + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer error: ");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        zzaxz.zzeo(sb.toString());
        zzcx(-1);
        this.zzeqi = -1;
        zzayh.zzelc.post(new zzbdb(this, str, str2));
        return true;
    }

    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.zzeqn = i;
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        zzaxz.v("AdMediaPlayerView surface created");
        zzaba();
        zzayh.zzelc.post(new zzbdc(this));
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        zzaxz.v("AdMediaPlayerView surface changed");
        boolean z = true;
        boolean z2 = this.zzeqi == 3;
        if (!(this.zzeql == i && this.zzeqm == i2)) {
            z = false;
        }
        if (this.zzeqj != null && z2 && z) {
            int i3 = this.zzeqs;
            if (i3 != 0) {
                seekTo(i3);
            }
            play();
        }
        zzbdx zzbdx = this.zzeqq;
        if (zzbdx != null) {
            zzbdx.zzo(i, i2);
        }
        zzayh.zzelc.post(new zzbdd(this, i, i2));
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzaxz.v("AdMediaPlayerView surface destroyed");
        MediaPlayer mediaPlayer = this.zzeqj;
        if (mediaPlayer != null && this.zzeqs == 0) {
            this.zzeqs = mediaPlayer.getCurrentPosition();
        }
        zzbdx zzbdx = this.zzeqq;
        if (zzbdx != null) {
            zzbdx.zzabq();
        }
        zzayh.zzelc.post(new zzbde(this));
        zzar(true);
        return true;
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzeqf.zzc(this);
        this.zzera.zza(surfaceTexture, this.zzeqt);
    }

    /* access modifiers changed from: protected */
    public final void onWindowVisibilityChanged(int i) {
        StringBuilder sb = new StringBuilder(58);
        sb.append("AdMediaPlayerView window visibility changed to ");
        sb.append(i);
        zzaxz.v(sb.toString());
        zzayh.zzelc.post(new zzbcy(this, i));
        super.onWindowVisibilityChanged(i);
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int defaultSize = getDefaultSize(this.zzeql, i);
        int defaultSize2 = getDefaultSize(this.zzeqm, i2);
        if (this.zzeql <= 0 || this.zzeqm <= 0 || this.zzeqq != null) {
            i3 = defaultSize;
        } else {
            int mode = View.MeasureSpec.getMode(i);
            i3 = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i5 = this.zzeql;
                int i6 = i5 * size;
                int i7 = this.zzeqm;
                if (i6 < i3 * i7) {
                    defaultSize2 = size;
                    i3 = (i5 * size) / i7;
                } else if (i5 * size > i3 * i7) {
                    defaultSize2 = (i7 * i3) / i5;
                }
            } else if (mode == 1073741824) {
                int i8 = (this.zzeqm * i3) / this.zzeql;
                if (mode2 != Integer.MIN_VALUE || i8 <= size) {
                    defaultSize2 = i8;
                }
            } else if (mode2 == 1073741824) {
                int i9 = (this.zzeql * size) / this.zzeqm;
                if (mode != Integer.MIN_VALUE || i9 <= i3) {
                    i3 = i9;
                }
            } else {
                int i10 = this.zzeql;
                int i11 = this.zzeqm;
                if (mode2 != Integer.MIN_VALUE || i11 <= size) {
                    defaultSize2 = i11;
                } else {
                    i10 = (i10 * size) / i11;
                    defaultSize2 = size;
                }
                if (mode != Integer.MIN_VALUE || i10 <= i3) {
                    i3 = i10;
                } else {
                    defaultSize2 = (this.zzeqm * i3) / this.zzeql;
                }
            }
            defaultSize2 = size;
        }
        setMeasuredDimension(i3, defaultSize2);
        zzbdx zzbdx = this.zzeqq;
        if (zzbdx != null) {
            zzbdx.zzo(i3, defaultSize2);
        }
        if (Build.VERSION.SDK_INT == 16) {
            int i12 = this.zzeqo;
            if ((i12 > 0 && i12 != i3) || ((i4 = this.zzeqp) > 0 && i4 != defaultSize2)) {
                zzabb();
            }
            this.zzeqo = i3;
            this.zzeqp = defaultSize2;
        }
    }

    public final String toString() {
        String name = getClass().getName();
        String hexString = Integer.toHexString(hashCode());
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 1 + String.valueOf(hexString).length());
        sb.append(name);
        sb.append("@");
        sb.append(hexString);
        return sb.toString();
    }

    private final void zzaba() {
        zzaxz.v("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (this.zzeqk != null && surfaceTexture != null) {
            zzar(false);
            try {
                zzbv.zzlx();
                this.zzeqj = new MediaPlayer();
                this.zzeqj.setOnBufferingUpdateListener(this);
                this.zzeqj.setOnCompletionListener(this);
                this.zzeqj.setOnErrorListener(this);
                this.zzeqj.setOnInfoListener(this);
                this.zzeqj.setOnPreparedListener(this);
                this.zzeqj.setOnVideoSizeChangedListener(this);
                this.zzeqn = 0;
                if (this.zzeqr) {
                    this.zzeqq = new zzbdx(getContext());
                    this.zzeqq.zza(surfaceTexture, getWidth(), getHeight());
                    this.zzeqq.start();
                    SurfaceTexture zzabr = this.zzeqq.zzabr();
                    if (zzabr != null) {
                        surfaceTexture = zzabr;
                    } else {
                        this.zzeqq.zzabq();
                        this.zzeqq = null;
                    }
                }
                this.zzeqj.setDataSource(getContext(), this.zzeqk);
                zzbv.zzly();
                this.zzeqj.setSurface(new Surface(surfaceTexture));
                this.zzeqj.setAudioStreamType(3);
                this.zzeqj.setScreenOnWhilePlaying(true);
                this.zzeqj.prepareAsync();
                zzcx(1);
            } catch (IOException | IllegalArgumentException | IllegalStateException e) {
                String valueOf = String.valueOf(this.zzeqk);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 36);
                sb.append("Failed to initialize MediaPlayer at ");
                sb.append(valueOf);
                zzaxz.zzc(sb.toString(), e);
                onError(this.zzeqj, 1, 0);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzabb() {
        /*
            r8 = this;
            boolean r0 = r8.zzeqg
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            boolean r0 = r8.zzabc()
            if (r0 == 0) goto L_0x0059
            android.media.MediaPlayer r0 = r8.zzeqj
            int r0 = r0.getCurrentPosition()
            if (r0 <= 0) goto L_0x0059
            int r0 = r8.zzeqi
            r1 = 3
            if (r0 == r1) goto L_0x0059
            java.lang.String r0 = "AdMediaPlayerView nudging MediaPlayer"
            com.google.android.gms.internal.ads.zzaxz.v(r0)
            r0 = 0
            r8.zzd(r0)
            android.media.MediaPlayer r0 = r8.zzeqj
            r0.start()
            android.media.MediaPlayer r0 = r8.zzeqj
            int r0 = r0.getCurrentPosition()
            com.google.android.gms.common.util.Clock r1 = com.google.android.gms.ads.internal.zzbv.zzlm()
            long r1 = r1.currentTimeMillis()
        L_0x0034:
            boolean r3 = r8.zzabc()
            if (r3 == 0) goto L_0x0051
            android.media.MediaPlayer r3 = r8.zzeqj
            int r3 = r3.getCurrentPosition()
            if (r3 != r0) goto L_0x0051
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzbv.zzlm()
            long r3 = r3.currentTimeMillis()
            long r3 = r3 - r1
            r5 = 250(0xfa, double:1.235E-321)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0034
        L_0x0051:
            android.media.MediaPlayer r0 = r8.zzeqj
            r0.pause()
            r8.zzabd()
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbcx.zzabb():void");
    }

    private final void zzar(boolean z) {
        zzaxz.v("AdMediaPlayerView release");
        zzbdx zzbdx = this.zzeqq;
        if (zzbdx != null) {
            zzbdx.zzabq();
            this.zzeqq = null;
        }
        MediaPlayer mediaPlayer = this.zzeqj;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.zzeqj.release();
            this.zzeqj = null;
            zzcx(0);
            if (z) {
                this.zzeqi = 0;
                this.zzeqi = 0;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void play() {
        zzaxz.v("AdMediaPlayerView play");
        if (zzabc()) {
            this.zzeqj.start();
            zzcx(3);
            this.zzera.zzabf();
            zzayh.zzelc.post(new zzbdf(this));
        }
        this.zzeqi = 3;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void pause() {
        zzaxz.v("AdMediaPlayerView pause");
        if (zzabc() && this.zzeqj.isPlaying()) {
            this.zzeqj.pause();
            zzcx(4);
            zzayh.zzelc.post(new zzbdg(this));
        }
        this.zzeqi = 4;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final int getDuration() {
        if (zzabc()) {
            return this.zzeqj.getDuration();
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final int getCurrentPosition() {
        if (zzabc()) {
            return this.zzeqj.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void seekTo(int i) {
        StringBuilder sb = new StringBuilder(34);
        sb.append("AdMediaPlayerView seek ");
        sb.append(i);
        zzaxz.v(sb.toString());
        if (zzabc()) {
            this.zzeqj.seekTo(i);
            this.zzeqs = 0;
            return;
        }
        this.zzeqs = i;
    }

    private final boolean zzabc() {
        int i;
        return (this.zzeqj == null || (i = this.zzeqh) == -1 || i == 0 || i == 1) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zza(float f, float f2) {
        zzbdx zzbdx = this.zzeqq;
        if (zzbdx != null) {
            zzbdx.zzb(f, f2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final int getVideoWidth() {
        MediaPlayer mediaPlayer = this.zzeqj;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final int getVideoHeight() {
        MediaPlayer mediaPlayer = this.zzeqj;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbed, com.google.android.gms.internal.ads.zzbdi
    public final void zzabd() {
        zzd(this.zzerb.getVolume());
    }

    private final void zzd(float f) {
        MediaPlayer mediaPlayer = this.zzeqj;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setVolume(f, f);
            } catch (IllegalStateException unused) {
            }
        } else {
            zzaxz.zzeo("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
        }
    }

    private final void zzcx(int i) {
        if (i == 3) {
            this.zzeqf.zzacd();
            this.zzerb.zzacd();
        } else if (this.zzeqh == 3) {
            this.zzeqf.zzace();
            this.zzerb.zzace();
        }
        this.zzeqh = i;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzcy(int i) {
        zzbdh zzbdh = this.zzeqt;
        if (zzbdh != null) {
            zzbdh.onWindowVisibilityChanged(i);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            zzeqe.put(-1004, "MEDIA_ERROR_IO");
            zzeqe.put(-1007, "MEDIA_ERROR_MALFORMED");
            zzeqe.put(-1010, "MEDIA_ERROR_UNSUPPORTED");
            zzeqe.put(-110, "MEDIA_ERROR_TIMED_OUT");
            zzeqe.put(3, "MEDIA_INFO_VIDEO_RENDERING_START");
        }
        zzeqe.put(100, "MEDIA_ERROR_SERVER_DIED");
        zzeqe.put(1, "MEDIA_ERROR_UNKNOWN");
        zzeqe.put(1, "MEDIA_INFO_UNKNOWN");
        zzeqe.put(700, "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        zzeqe.put(701, "MEDIA_INFO_BUFFERING_START");
        zzeqe.put(702, "MEDIA_INFO_BUFFERING_END");
        zzeqe.put(800, "MEDIA_INFO_BAD_INTERLEAVING");
        zzeqe.put(801, "MEDIA_INFO_NOT_SEEKABLE");
        zzeqe.put(802, "MEDIA_INFO_METADATA_UPDATE");
        if (Build.VERSION.SDK_INT >= 19) {
            zzeqe.put(901, "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
            zzeqe.put(902, "MEDIA_INFO_SUBTITLE_TIMED_OUT");
        }
    }
}
