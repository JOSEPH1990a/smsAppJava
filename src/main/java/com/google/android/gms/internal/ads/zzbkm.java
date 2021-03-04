package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbmv;
import java.security.GeneralSecurityException;

final class zzbkm implements zzbjt<zzbjm> {
    zzbkm() {
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final int getVersion() {
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzd */
    public final zzbjm zza(zzbpu zzbpu) throws GeneralSecurityException {
        try {
            zzbnm zzal = zzbnm.zzal(zzbpu);
            if (zzal instanceof zzbnm) {
                zzbnm zzbnm = zzal;
                zzbpd.zzs(zzbnm.getVersion(), 0);
                String zzajr = zzbnm.zzajo().zzajr();
                return new zzbkl(zzbnm.zzajo().zzajs(), zzbjw.zzfh(zzajr).zzfg(zzajr));
            }
            throw new GeneralSecurityException("expected KmsEnvelopeAeadKey proto");
        } catch (zzbrl e) {
            throw new GeneralSecurityException("expected serialized KmSEnvelopeAeadKey proto", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbsl zzb(zzbpu zzbpu) throws GeneralSecurityException {
        try {
            return zzb(zzbno.zzam(zzbpu));
        } catch (zzbrl e) {
            throw new GeneralSecurityException("expected serialized KmsEnvelopeAeadKeyFormat proto", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbsl zzb(zzbsl zzbsl) throws GeneralSecurityException {
        if (zzbsl instanceof zzbno) {
            return (zzbrd) zzbnm.zzajp().zzb((zzbno) zzbsl).zzee(0).zzana();
        }
        throw new GeneralSecurityException("expected KmsEnvelopeAeadKeyFormat proto");
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbmv zzc(zzbpu zzbpu) throws GeneralSecurityException {
        return (zzbmv) ((zzbrd) zzbmv.zzaij().zzfl("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey").zzai(((zzbnm) zzb(zzbpu)).zzakf()).zzb(zzbmv.zzb.REMOTE).zzana());
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzbjt
    public final /* synthetic */ zzbjm zza(zzbsl zzbsl) throws GeneralSecurityException {
        if (zzbsl instanceof zzbnm) {
            zzbnm zzbnm = (zzbnm) zzbsl;
            zzbpd.zzs(zzbnm.getVersion(), 0);
            String zzajr = zzbnm.zzajo().zzajr();
            return new zzbkl(zzbnm.zzajo().zzajs(), zzbjw.zzfh(zzajr).zzfg(zzajr));
        }
        throw new GeneralSecurityException("expected KmsEnvelopeAeadKey proto");
    }
}
