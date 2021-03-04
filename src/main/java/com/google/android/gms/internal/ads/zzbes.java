package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.nio.ByteBuffer;

@zzark
public final class zzbes implements zzfh, zzll, zzpn<zzov>, zzqu {
    @VisibleForTesting
    private static int zzevp;
    @VisibleForTesting
    private static int zzevq;
    private int bytesTransferred;
    private final zzbdy zzeuo;
    private final zzber zzevr = new zzber();
    private final zzfz zzevs = new zzqo(this.zzsp, zzka.zzavh, 0, zzayh.zzelc, this, -1);
    private final zzfz zzevt = new zzhd(zzka.zzavh);
    private final zzoj zzevu = new zzog();
    private zzfg zzevv;
    private ByteBuffer zzevw;
    private boolean zzevx;
    private zzbez zzevy;
    private final Context zzsp;

    public zzbes(Context context, zzbdy zzbdy) {
        this.zzsp = context;
        this.zzeuo = zzbdy;
        if (zzaxz.zzza()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 28);
            sb.append("ExoPlayerAdapter initialize ");
            sb.append(valueOf);
            zzaxz.v(sb.toString());
        }
        zzevp++;
        this.zzevv = zzfk.zza(new zzfz[]{this.zzevt, this.zzevs}, this.zzevu, this.zzevr);
        this.zzevv.zza(this);
    }

    @Override // com.google.android.gms.internal.ads.zzqu
    public final void zza(Surface surface) {
    }

    @Override // com.google.android.gms.internal.ads.zzfh
    public final void zza(zzfy zzfy) {
    }

    @Override // com.google.android.gms.internal.ads.zzfh
    public final void zza(zzgc zzgc, Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzfh
    public final void zza(zzma zzma, zzoo zzoo) {
    }

    @Override // com.google.android.gms.internal.ads.zzfh
    public final void zzbs() {
    }

    @Override // com.google.android.gms.internal.ads.zzqu
    public final void zzd(String str, long j, long j2) {
    }

    @Override // com.google.android.gms.internal.ads.zzfh
    public final void zzd(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzqu
    public final void zze(zzhn zzhn) {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzpn
    public final /* bridge */ /* synthetic */ void zze(zzov zzov) {
    }

    @Override // com.google.android.gms.internal.ads.zzqu
    public final void zzf(zzhn zzhn) {
    }

    @Override // com.google.android.gms.internal.ads.zzqu
    public final void zzh(int i, long j) {
    }

    @Override // com.google.android.gms.internal.ads.zzqu
    public final void zzl(zzfs zzfs) {
    }

    public final zzfg zzacw() {
        return this.zzevv;
    }

    public static int zzacx() {
        return zzevp;
    }

    public static int zzacy() {
        return zzevq;
    }

    public final void zza(zzbez zzbez) {
        this.zzevy = zzbez;
    }

    public final zzber zzacz() {
        return this.zzevr;
    }

    public final void zza(Uri uri, String str) {
        zza(uri, str, ByteBuffer.allocate(0), false);
    }

    public final void zza(Uri uri, String str, ByteBuffer byteBuffer, boolean z) {
        zzlo zzlo;
        this.zzevw = byteBuffer;
        this.zzevx = z;
        if (this.zzeuo.zzett) {
            zzow zzev = zzev(str);
            zzlo = new zzmu(uri, zzev, new zzng(zzev), zzayh.zzelc, null);
        } else {
            zzlo = new zzlk(uri, zzev(str), zzbex.zzewd, -1, zzayh.zzelc, this, null, this.zzeuo.zzetq);
        }
        this.zzevv.zza(zzlo);
        zzevq++;
    }

    public final void release() {
        zzfg zzfg = this.zzevv;
        if (zzfg != null) {
            zzfg.zzb(this);
            this.zzevv.release();
            this.zzevv = null;
            zzevq--;
        }
    }

    public final long getBytesTransferred() {
        return (long) this.bytesTransferred;
    }

    @Override // com.google.android.gms.internal.ads.zzll
    public final void zzb(IOException iOException) {
        zzbez zzbez = this.zzevy;
        if (zzbez != null) {
            zzbez.zza("onLoadError", iOException);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqu
    public final void zza(int i, int i2, int i3, float f) {
        zzbez zzbez = this.zzevy;
        if (zzbez != null) {
            zzbez.zzp(i, i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfh
    public final void zza(boolean z, int i) {
        zzbez zzbez = this.zzevy;
        if (zzbez != null) {
            zzbez.zzdd(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfh
    public final void zza(zzff zzff) {
        zzbez zzbez = this.zzevy;
        if (zzbez != null) {
            zzbez.zza("onPlayerError", zzff);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(Surface surface, boolean z) {
        zzfj zzfj = new zzfj(this.zzevs, 1, surface);
        if (z) {
            this.zzevv.zzb(zzfj);
            return;
        }
        this.zzevv.zza(zzfj);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(float f, boolean z) {
        zzfj zzfj = new zzfj(this.zzevt, 2, Float.valueOf(f));
        if (z) {
            this.zzevv.zzb(zzfj);
            return;
        }
        this.zzevv.zza(zzfj);
    }

    /* access modifiers changed from: package-private */
    public final void zzau(boolean z) {
        for (int i = 0; i < this.zzevv.zzbq(); i++) {
            this.zzevu.zzf(i, !z);
        }
    }

    @VisibleForTesting
    private final zzow zzev(String str) {
        if (!this.zzevx || this.zzevw.limit() <= 0) {
            zzbeu zzbeu = new zzbeu(this, str);
            zzow zzbev = this.zzeuo.zzets ? new zzbev(this, zzbeu) : zzbeu;
            if (this.zzevw.limit() <= 0) {
                return zzbev;
            }
            byte[] bArr = new byte[this.zzevw.limit()];
            this.zzevw.get(bArr);
            return new zzbew(zzbev, bArr);
        }
        byte[] bArr2 = new byte[this.zzevw.limit()];
        this.zzevw.get(bArr2);
        return new zzbet(bArr2);
    }

    public final void finalize() throws Throwable {
        zzevp--;
        if (zzaxz.zzza()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 26);
            sb.append("ExoPlayerAdapter finalize ");
            sb.append(valueOf);
            zzaxz.v(sb.toString());
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int] */
    @Override // com.google.android.gms.internal.ads.zzpn
    public final /* synthetic */ void zzc(zzov zzov, int i) {
        this.bytesTransferred += i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.google.android.gms.internal.ads.zzoz] */
    @Override // com.google.android.gms.internal.ads.zzpn
    public final /* synthetic */ void zza(zzov zzov, zzoz zzoz) {
        this.bytesTransferred = 0;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzov zza(zzow zzow) {
        return new zzbep(this.zzsp, zzow.zzgs(), this, new zzbey(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(boolean z, long j) {
        zzbez zzbez = this.zzevy;
        if (zzbez != null) {
            zzbez.zzb(z, j);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzov zzew(String str) {
        return new zzpb(str, null, this.zzeuo.zzets ? null : this, this.zzeuo.zzetn, this.zzeuo.zzetp, true, null);
    }
}
