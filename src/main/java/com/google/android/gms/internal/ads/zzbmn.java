package com.google.android.gms.internal.ads;

public enum zzbmn implements zzbrg {
    UNKNOWN_HASH(0),
    SHA1(1),
    SHA256(3),
    SHA512(4),
    UNRECOGNIZED(-1);
    
    private static final zzbrh<zzbmn> zzcbx = new zzbmo();
    private final int value;

    @Override // com.google.android.gms.internal.ads.zzbrg
    public final int zzom() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static zzbmn zzdt(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_HASH;
            case 1:
                return SHA1;
            case 2:
            default:
                return null;
            case 3:
                return SHA256;
            case 4:
                return SHA512;
        }
    }

    private zzbmn(int i) {
        this.value = i;
    }
}
