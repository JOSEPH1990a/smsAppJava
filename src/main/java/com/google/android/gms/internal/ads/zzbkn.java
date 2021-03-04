package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbmv;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;

final class zzbkn implements zzbjt<zzbjr> {
    zzbkn() {
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final int getVersion() {
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzf */
    public final zzbjr zza(zzbpu zzbpu) throws GeneralSecurityException {
        try {
            zzbmf zzx = zzbmf.zzx(zzbpu);
            if (zzx instanceof zzbmf) {
                zzbmf zzbmf = zzx;
                zzbpd.zzs(zzbmf.getVersion(), 0);
                zzbku.zza(zzbmf.zzahj().zzahc());
                zzbmd zzahc = zzbmf.zzahj().zzahc();
                zzbmj zzahe = zzahc.zzahe();
                zzboi zza = zzbku.zza(zzahe.zzahr());
                byte[] byteArray = zzbmf.zzagf().toByteArray();
                return new zzbob((ECPrivateKey) zzbol.zzfjx.zzfu("EC").generatePrivate(new ECPrivateKeySpec(new BigInteger(1, byteArray), zzbog.zza(zza))), zzahe.zzaht().toByteArray(), zzbku.zza(zzahe.zzahs()), zzbku.zza(zzahc.zzahg()), new zzbkw(zzahc.zzahf().zzagz()));
            }
            throw new GeneralSecurityException("expected EciesAeadHkdfPrivateKey proto");
        } catch (zzbrl e) {
            throw new GeneralSecurityException("expected serialized EciesAeadHkdfPrivateKey proto", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbsl zzb(zzbpu zzbpu) throws GeneralSecurityException {
        try {
            return zzb(zzbmb.zzw(zzbpu));
        } catch (zzbrl e) {
            throw new GeneralSecurityException("invalid EciesAeadHkdf key format", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbsl zzb(zzbsl zzbsl) throws GeneralSecurityException {
        if (zzbsl instanceof zzbmb) {
            zzbmb zzbmb = (zzbmb) zzbsl;
            zzbku.zza(zzbmb.zzahc());
            KeyPair zza = zzbog.zza(zzbog.zza(zzbku.zza(zzbmb.zzahc().zzahe().zzahr())));
            ECPoint w = ((ECPublicKey) zza.getPublic()).getW();
            return (zzbrd) zzbmf.zzahk().zzdq(0).zzb((zzbmh) ((zzbrd) zzbmh.zzaho().zzdr(0).zzc(zzbmb.zzahc()).zzac(zzbpu.zzr(w.getAffineX().toByteArray())).zzad(zzbpu.zzr(w.getAffineY().toByteArray())).zzana())).zzy(zzbpu.zzr(((ECPrivateKey) zza.getPrivate()).getS().toByteArray())).zzana();
        }
        throw new GeneralSecurityException("expected EciesAeadHkdfKeyFormat proto");
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbmv zzc(zzbpu zzbpu) throws GeneralSecurityException {
        return (zzbmv) ((zzbrd) zzbmv.zzaij().zzfl("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey").zzai(((zzbmf) zzb(zzbpu)).zzakf()).zzb(zzbmv.zzb.ASYMMETRIC_PRIVATE).zzana());
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzbjt
    public final /* synthetic */ zzbjr zza(zzbsl zzbsl) throws GeneralSecurityException {
        if (zzbsl instanceof zzbmf) {
            zzbmf zzbmf = (zzbmf) zzbsl;
            zzbpd.zzs(zzbmf.getVersion(), 0);
            zzbku.zza(zzbmf.zzahj().zzahc());
            zzbmd zzahc = zzbmf.zzahj().zzahc();
            zzbmj zzahe = zzahc.zzahe();
            zzboi zza = zzbku.zza(zzahe.zzahr());
            byte[] byteArray = zzbmf.zzagf().toByteArray();
            return new zzbob((ECPrivateKey) zzbol.zzfjx.zzfu("EC").generatePrivate(new ECPrivateKeySpec(new BigInteger(1, byteArray), zzbog.zza(zza))), zzahe.zzaht().toByteArray(), zzbku.zza(zzahe.zzahs()), zzbku.zza(zzahc.zzahg()), new zzbkw(zzahc.zzahf().zzagz()));
        }
        throw new GeneralSecurityException("expected EciesAeadHkdfPrivateKey proto");
    }
}
