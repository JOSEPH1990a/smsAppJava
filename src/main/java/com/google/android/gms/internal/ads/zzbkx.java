package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbmv;
import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

final class zzbkx implements zzbjt<zzbjx> {
    zzbkx() {
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final int getVersion() {
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzh */
    public final zzbjx zza(zzbpu zzbpu) throws GeneralSecurityException {
        zzbow zzbow;
        try {
            zzbmp zzae = zzbmp.zzae(zzbpu);
            if (zzae instanceof zzbmp) {
                zzbmp zzbmp = zzae;
                zzbpd.zzs(zzbmp.getVersion(), 0);
                if (zzbmp.zzagf().size() >= 16) {
                    zza(zzbmp.zzahw());
                    zzbmn zzaic = zzbmp.zzahw().zzaic();
                    SecretKeySpec secretKeySpec = new SecretKeySpec(zzbmp.zzagf().toByteArray(), "HMAC");
                    int zzaid = zzbmp.zzahw().zzaid();
                    switch (zzaic) {
                        case SHA1:
                            zzbow = new zzbow("HMACSHA1", secretKeySpec, zzaid);
                            break;
                        case SHA256:
                            zzbow = new zzbow("HMACSHA256", secretKeySpec, zzaid);
                            break;
                        case SHA512:
                            zzbow = new zzbow("HMACSHA512", secretKeySpec, zzaid);
                            break;
                        default:
                            throw new GeneralSecurityException("unknown hash");
                    }
                    return zzbow;
                }
                throw new GeneralSecurityException("key too short");
            }
            throw new GeneralSecurityException("expected HmacKey proto");
        } catch (zzbrl e) {
            throw new GeneralSecurityException("expected serialized HmacKey proto", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbsl zzb(zzbpu zzbpu) throws GeneralSecurityException {
        try {
            return zzb(zzbmr.zzag(zzbpu));
        } catch (zzbrl e) {
            throw new GeneralSecurityException("expected serialized HmacKeyFormat proto", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbsl zzb(zzbsl zzbsl) throws GeneralSecurityException {
        if (zzbsl instanceof zzbmr) {
            zzbmr zzbmr = (zzbmr) zzbsl;
            if (zzbmr.getKeySize() >= 16) {
                zza(zzbmr.zzahw());
                return (zzbrd) zzbmp.zzahx().zzdu(0).zzc(zzbmr.zzahw()).zzaf(zzbpu.zzr(zzboy.zzeg(zzbmr.getKeySize()))).zzana();
            }
            throw new GeneralSecurityException("key too short");
        }
        throw new GeneralSecurityException("expected HmacKeyFormat proto");
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final zzbmv zzc(zzbpu zzbpu) throws GeneralSecurityException {
        return (zzbmv) ((zzbrd) zzbmv.zzaij().zzfl("type.googleapis.com/google.crypto.tink.HmacKey").zzai(((zzbmp) zzb(zzbpu)).zzakf()).zzb(zzbmv.zzb.SYMMETRIC).zzana());
    }

    private static void zza(zzbmt zzbmt) throws GeneralSecurityException {
        if (zzbmt.zzaid() >= 10) {
            switch (zzbmt.zzaic()) {
                case SHA1:
                    if (zzbmt.zzaid() > 20) {
                        throw new GeneralSecurityException("tag size too big");
                    }
                    return;
                case SHA256:
                    if (zzbmt.zzaid() > 32) {
                        throw new GeneralSecurityException("tag size too big");
                    }
                    return;
                case SHA512:
                    if (zzbmt.zzaid() > 64) {
                        throw new GeneralSecurityException("tag size too big");
                    }
                    return;
                default:
                    throw new GeneralSecurityException("unknown hash type");
            }
        } else {
            throw new GeneralSecurityException("tag size too small");
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.ads.zzbjt
    public final /* synthetic */ zzbjx zza(zzbsl zzbsl) throws GeneralSecurityException {
        if (zzbsl instanceof zzbmp) {
            zzbmp zzbmp = (zzbmp) zzbsl;
            zzbpd.zzs(zzbmp.getVersion(), 0);
            if (zzbmp.zzagf().size() >= 16) {
                zza(zzbmp.zzahw());
                zzbmn zzaic = zzbmp.zzahw().zzaic();
                SecretKeySpec secretKeySpec = new SecretKeySpec(zzbmp.zzagf().toByteArray(), "HMAC");
                int zzaid = zzbmp.zzahw().zzaid();
                switch (zzaic) {
                    case SHA1:
                        return new zzbow("HMACSHA1", secretKeySpec, zzaid);
                    case SHA256:
                        return new zzbow("HMACSHA256", secretKeySpec, zzaid);
                    case SHA512:
                        return new zzbow("HMACSHA512", secretKeySpec, zzaid);
                    default:
                        throw new GeneralSecurityException("unknown hash");
                }
            } else {
                throw new GeneralSecurityException("key too short");
            }
        } else {
            throw new GeneralSecurityException("expected HmacKey proto");
        }
    }
}
