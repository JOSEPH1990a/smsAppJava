package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbmv;
import java.security.GeneralSecurityException;

final class zzbkk implements zzbjt<zzbjm> {
    zzbkk() {
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.KmsAeadKey";
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final int getVersion() {
        return 0;
    }

    private static zzbjm zzd(zzbpu zzbpu) throws GeneralSecurityException {
        try {
            return zzc(zzbni.zzaj(zzbpu));
        } catch (zzbrl e) {
            throw new GeneralSecurityException("expected KmsAeadKey proto", e);
        }
    }

    private static zzbjm zzc(zzbsl zzbsl) throws GeneralSecurityException {
        if (zzbsl instanceof zzbni) {
            zzbni zzbni = (zzbni) zzbsl;
            zzbpd.zzs(zzbni.getVersion(), 0);
            String zzajl = zzbni.zzaji().zzajl();
            return zzbjw.zzfh(zzajl).zzfg(zzajl);
        }
        throw new GeneralSecurityException("expected KmsAeadKey proto");
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbsl zzb(zzbpu zzbpu) throws GeneralSecurityException {
        try {
            return zzb(zzbnk.zzak(zzbpu));
        } catch (zzbrl e) {
            throw new GeneralSecurityException("expected serialized KmsAeadKeyFormat proto", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbsl zzb(zzbsl zzbsl) throws GeneralSecurityException {
        if (zzbsl instanceof zzbnk) {
            return (zzbrd) zzbni.zzajj().zzb((zzbnk) zzbsl).zzed(0).zzana();
        }
        throw new GeneralSecurityException("expected KmsAeadKeyFormat proto");
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbmv zzc(zzbpu zzbpu) throws GeneralSecurityException {
        return (zzbmv) ((zzbrd) zzbmv.zzaij().zzfl("type.googleapis.com/google.crypto.tink.KmsAeadKey").zzai(((zzbni) zzb(zzbpu)).zzakf()).zzb(zzbmv.zzb.REMOTE).zzana());
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzbjt
    public final /* synthetic */ zzbjm zza(zzbsl zzbsl) throws GeneralSecurityException {
        return zzc(zzbsl);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzbjt
    public final /* synthetic */ zzbjm zza(zzbpu zzbpu) throws GeneralSecurityException {
        return zzd(zzbpu);
    }
}
