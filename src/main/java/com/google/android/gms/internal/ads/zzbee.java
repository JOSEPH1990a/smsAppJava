package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import com.google.android.gms.ads.internal.zzbv;
import java.nio.ByteBuffer;

@zzark
@TargetApi(16)
public final class zzbee extends zzbdi implements TextureView.SurfaceTextureListener, zzbez {
    private Surface zzbjb;
    private final zzbdz zzerw;
    private final zzbea zzeum;
    private final boolean zzeun;
    private final zzbdy zzeuo;
    private zzbdh zzeup;
    private zzbes zzeuq;
    private String zzeur;
    private boolean zzeus;
    private int zzeut = 1;
    private zzbdx zzeuu;
    private final boolean zzeuv;
    private boolean zzeuw;
    private boolean zzeux;
    private int zzeuy;
    private int zzeuz;
    private int zzeva;
    private int zzevb;
    private float zzevc;

    public zzbee(Context context, zzbea zzbea, zzbdz zzbdz, boolean z, boolean z2, zzbdy zzbdy) {
        super(context);
        this.zzeun = z2;
        this.zzerw = zzbdz;
        this.zzeum = zzbea;
        this.zzeuv = z;
        this.zzeuo = zzbdy;
        setSurfaceTextureListener(this);
        this.zzeum.zzb(this);
    }

    private final zzbes zzach() {
        return new zzbes(this.zzerw.getContext(), this.zzeuo);
    }

    private final String zzaci() {
        return zzbv.zzlf().zzo(this.zzerw.getContext(), this.zzerw.zzabz().zzdp);
    }

    private final boolean zzacj() {
        return this.zzeuq != null && !this.zzeus;
    }

    private final boolean zzack() {
        return zzacj() && this.zzeut != 1;
    }

    private final void zzacl() {
        String str;
        if (this.zzeuq == null && (str = this.zzeur) != null && this.zzbjb != null) {
            if (str.startsWith("cache:")) {
                zzbfk zzet = this.zzerw.zzet(this.zzeur);
                if (zzet instanceof zzbfw) {
                    this.zzeuq = ((zzbfw) zzet).zzadd();
                } else if (zzet instanceof zzbfv) {
                    zzbfv zzbfv = (zzbfv) zzet;
                    String zzaci = zzaci();
                    ByteBuffer byteBuffer = zzbfv.getByteBuffer();
                    boolean zzadc = zzbfv.zzadc();
                    String url = zzbfv.getUrl();
                    if (url == null) {
                        zzaxz.zzeo("Stream cache URL is null.");
                        return;
                    } else {
                        this.zzeuq = zzach();
                        this.zzeuq.zza(Uri.parse(url), zzaci, byteBuffer, zzadc);
                    }
                } else {
                    String valueOf = String.valueOf(this.zzeur);
                    zzaxz.zzeo(valueOf.length() != 0 ? "Stream cache miss: ".concat(valueOf) : new String("Stream cache miss: "));
                    return;
                }
            } else {
                this.zzeuq = zzach();
                this.zzeuq.zza(Uri.parse(this.zzeur), zzaci());
            }
            this.zzeuq.zza(this);
            zza(this.zzbjb, false);
            this.zzeut = this.zzeuq.zzacw().getPlaybackState();
            if (this.zzeut == 3) {
                zzacm();
            }
        }
    }

    private final void zza(Surface surface, boolean z) {
        zzbes zzbes = this.zzeuq;
        if (zzbes != null) {
            zzbes.zza(surface, z);
        } else {
            zzaxz.zzeo("Trying to set surface before player is initalized.");
        }
    }

    private final void zza(float f, boolean z) {
        zzbes zzbes = this.zzeuq;
        if (zzbes != null) {
            zzbes.zzb(f, z);
        } else {
            zzaxz.zzeo("Trying to set volume before player is initalized.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbed, com.google.android.gms.internal.ads.zzbdi
    public final void zzabd() {
        zza(this.zzerb.getVolume(), false);
    }

    private final void zzacm() {
        if (!this.zzeuw) {
            this.zzeuw = true;
            zzayh.zzelc.post(new zzbef(this));
            zzabd();
            this.zzeum.zzcg();
            if (this.zzeux) {
                play();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final String zzaaz() {
        String valueOf = String.valueOf("ExoPlayer/3");
        String valueOf2 = String.valueOf(this.zzeuv ? " spherical" : "");
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zza(zzbdh zzbdh) {
        this.zzeup = zzbdh;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void setVideoPath(String str) {
        if (str != null) {
            this.zzeur = str;
            zzacl();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void play() {
        if (zzack()) {
            if (this.zzeuo.zzetk) {
                zzaco();
            }
            this.zzeuq.zzacw().zzc(true);
            this.zzeum.zzacd();
            this.zzerb.zzacd();
            this.zzera.zzabf();
            zzayh.zzelc.post(new zzbei(this));
            return;
        }
        this.zzeux = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void stop() {
        if (zzacj()) {
            this.zzeuq.zzacw().stop();
            if (this.zzeuq != null) {
                zza((Surface) null, true);
                zzbes zzbes = this.zzeuq;
                if (zzbes != null) {
                    zzbes.zza((zzbez) null);
                    this.zzeuq.release();
                    this.zzeuq = null;
                }
                this.zzeut = 1;
                this.zzeus = false;
                this.zzeuw = false;
                this.zzeux = false;
            }
        }
        this.zzeum.zzace();
        this.zzerb.zzace();
        this.zzeum.onStop();
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void pause() {
        if (zzack()) {
            if (this.zzeuo.zzetk) {
                zzacp();
            }
            this.zzeuq.zzacw().zzc(false);
            this.zzeum.zzace();
            this.zzerb.zzace();
            zzayh.zzelc.post(new zzbej(this));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void seekTo(int i) {
        if (zzack()) {
            this.zzeuq.zzacw().seekTo((long) i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zzcz(int i) {
        zzbes zzbes = this.zzeuq;
        if (zzbes != null) {
            zzbes.zzacz().zzdf(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zzda(int i) {
        zzbes zzbes = this.zzeuq;
        if (zzbes != null) {
            zzbes.zzacz().zzdg(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zzdb(int i) {
        zzbes zzbes = this.zzeuq;
        if (zzbes != null) {
            zzbes.zzacz().zzdb(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zzdc(int i) {
        zzbes zzbes = this.zzeuq;
        if (zzbes != null) {
            zzbes.zzacz().zzdc(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final void zza(float f, float f2) {
        zzbdx zzbdx = this.zzeuu;
        if (zzbdx != null) {
            zzbdx.zzb(f, f2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final int getCurrentPosition() {
        if (zzack()) {
            return (int) this.zzeuq.zzacw().zzbr();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final int getDuration() {
        if (zzack()) {
            return (int) this.zzeuq.zzacw().getDuration();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final int getVideoWidth() {
        return this.zzeuy;
    }

    @Override // com.google.android.gms.internal.ads.zzbdi
    public final int getVideoHeight() {
        return this.zzeuz;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0080  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r11, int r12) {
        /*
        // Method dump skipped, instructions count: 163
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbee.onMeasure(int, int):void");
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.zzeuv) {
            this.zzeuu = new zzbdx(getContext());
            this.zzeuu.zza(surfaceTexture, i, i2);
            this.zzeuu.start();
            SurfaceTexture zzabr = this.zzeuu.zzabr();
            if (zzabr != null) {
                surfaceTexture = zzabr;
            } else {
                this.zzeuu.zzabq();
                this.zzeuu = null;
            }
        }
        this.zzbjb = new Surface(surfaceTexture);
        if (this.zzeuq == null) {
            zzacl();
        } else {
            zza(this.zzbjb, true);
            if (!this.zzeuo.zzetk) {
                zzaco();
            }
        }
        zzacn();
        zzayh.zzelc.post(new zzbek(this));
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        zzbdx zzbdx = this.zzeuu;
        if (zzbdx != null) {
            zzbdx.zzo(i, i2);
        }
        zzayh.zzelc.post(new zzbel(this, i, i2));
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzeum.zzc(this);
        this.zzera.zza(surfaceTexture, this.zzeup);
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        pause();
        zzbdx zzbdx = this.zzeuu;
        if (zzbdx != null) {
            zzbdx.zzabq();
            this.zzeuu = null;
        }
        if (this.zzeuq != null) {
            zzacp();
            Surface surface = this.zzbjb;
            if (surface != null) {
                surface.release();
            }
            this.zzbjb = null;
            zza((Surface) null, true);
        }
        zzayh.zzelc.post(new zzbem(this));
        return true;
    }

    /* access modifiers changed from: protected */
    public final void onWindowVisibilityChanged(int i) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdExoPlayerView3 window visibility changed to ");
        sb.append(i);
        zzaxz.v(sb.toString());
        zzayh.zzelc.post(new zzben(this, i));
        super.onWindowVisibilityChanged(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbez
    public final void zzb(boolean z, long j) {
        if (this.zzerw != null) {
            zzbcg.zzepo.execute(new zzbeo(this, z, j));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbez
    public final void zzdd(int i) {
        if (this.zzeut != i) {
            this.zzeut = i;
            switch (i) {
                case 3:
                    zzacm();
                    return;
                case 4:
                    if (this.zzeuo.zzetk) {
                        zzacp();
                    }
                    this.zzeum.zzace();
                    this.zzerb.zzace();
                    zzayh.zzelc.post(new zzbeg(this));
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbez
    public final void zzp(int i, int i2) {
        this.zzeuy = i;
        this.zzeuz = i2;
        zzacn();
    }

    @Override // com.google.android.gms.internal.ads.zzbez
    public final void zza(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(canonicalName).length() + String.valueOf(message).length());
        sb.append(str);
        sb.append("/");
        sb.append(canonicalName);
        sb.append(":");
        sb.append(message);
        String sb2 = sb.toString();
        String valueOf = String.valueOf(sb2);
        zzaxz.zzeo(valueOf.length() != 0 ? "ExoPlayerAdapter error: ".concat(valueOf) : new String("ExoPlayerAdapter error: "));
        this.zzeus = true;
        if (this.zzeuo.zzetk) {
            zzacp();
        }
        zzayh.zzelc.post(new zzbeh(this, sb2));
    }

    private final void zzacn() {
        int i = this.zzeuz;
        float f = i > 0 ? ((float) this.zzeuy) / ((float) i) : 1.0f;
        if (this.zzevc != f) {
            this.zzevc = f;
            requestLayout();
        }
    }

    private final void zzaco() {
        zzbes zzbes = this.zzeuq;
        if (zzbes != null) {
            zzbes.zzau(true);
        }
    }

    private final void zzacp() {
        zzbes zzbes = this.zzeuq;
        if (zzbes != null) {
            zzbes.zzau(false);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(boolean z, long j) {
        this.zzerw.zza(z, j);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzde(int i) {
        zzbdh zzbdh = this.zzeup;
        if (zzbdh != null) {
            zzbdh.onWindowVisibilityChanged(i);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzacq() {
        zzbdh zzbdh = this.zzeup;
        if (zzbdh != null) {
            zzbdh.zzabh();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzq(int i, int i2) {
        zzbdh zzbdh = this.zzeup;
        if (zzbdh != null) {
            zzbdh.zzm(i, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzacr() {
        zzbdh zzbdh = this.zzeup;
        if (zzbdh != null) {
            zzbdh.zzabe();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzacs() {
        zzbdh zzbdh = this.zzeup;
        if (zzbdh != null) {
            zzbdh.onPaused();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzact() {
        zzbdh zzbdh = this.zzeup;
        if (zzbdh != null) {
            zzbdh.zzabf();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzeu(String str) {
        zzbdh zzbdh = this.zzeup;
        if (zzbdh != null) {
            zzbdh.zzi("ExoPlayerAdapter error", str);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzacu() {
        zzbdh zzbdh = this.zzeup;
        if (zzbdh != null) {
            zzbdh.zzabg();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzacv() {
        zzbdh zzbdh = this.zzeup;
        if (zzbdh != null) {
            zzbdh.zzcg();
        }
    }
}
