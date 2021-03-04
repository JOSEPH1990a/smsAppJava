package com.google.android.gms.internal.ads;

public enum zzbuo {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(false),
    STRING(""),
    BYTE_STRING(zzbpu.zzfli),
    ENUM(null),
    MESSAGE(null);
    
    private final Object zzfrh;

    private zzbuo(Object obj) {
        this.zzfrh = obj;
    }
}
