package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbmv;
import java.security.GeneralSecurityException;

final class zzbki implements zzbjt<zzbjm> {
    zzbki() {
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final int getVersion() {
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzd */
    public final zzbjm zza(zzbpu zzbpu) throws GeneralSecurityException {
        try {
            zzblr zzr = zzblr.zzr(zzbpu);
            if (zzr instanceof zzblr) {
                zzblr zzblr = zzr;
                zzbpd.zzs(zzblr.getVersion(), 0);
                zzbpd.zzeh(zzblr.zzagf().size());
                return new zzbnw(zzblr.zzagf().toByteArray());
            }
            throw new GeneralSecurityException("expected AesGcmKey proto");
        } catch (zzbrl unused) {
            throw new GeneralSecurityException("expected AesGcmKey proto");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbsl zzb(zzbpu zzbpu) throws GeneralSecurityException {
        try {
            return zzb(zzblt.zzt(zzbpu));
        } catch (zzbrl e) {
            throw new GeneralSecurityException("expected serialized AesGcmKeyFormat proto", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbsl zzb(zzbsl zzbsl) throws GeneralSecurityException {
        if (zzbsl instanceof zzblt) {
            zzblt zzblt = (zzblt) zzbsl;
            zzbpd.zzeh(zzblt.getKeySize());
            return (zzbrd) zzblr.zzagu().zzs(zzbpu.zzr(zzboy.zzeg(zzblt.getKeySize()))).zzdn(0).zzana();
        }
        throw new GeneralSecurityException("expected AesGcmKeyFormat proto");
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbmv zzc(zzbpu zzbpu) throws GeneralSecurityException {
        return (zzbmv) ((zzbrd) zzbmv.zzaij().zzfl("type.googleapis.com/google.crypto.tink.AesGcmKey").zzai(((zzblr) zzb(zzbpu)).zzakf()).zzb(zzbmv.zzb.SYMMETRIC).zzana());
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzbjt
    public final /* synthetic */ zzbjm zza(zzbsl zzbsl) throws GeneralSecurityException {
        if (zzbsl instanceof zzblr) {
            zzblr zzblr = (zzblr) zzbsl;
            zzbpd.zzs(zzblr.getVersion(), 0);
            zzbpd.zzeh(zzblr.zzagf().size());
            return new zzbnw(zzblr.zzagf().toByteArray());
        }
        throw new GeneralSecurityException("expected AesGcmKey proto");
    }
}
