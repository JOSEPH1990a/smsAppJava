package com.google.android.gms.common;

import java.util.concurrent.Callable;

/* access modifiers changed from: package-private */
public final class zzo extends zzm {
    private final Callable<String> zzae;

    private zzo(Callable<String> callable) {
        super(false, null, null);
        this.zzae = callable;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.common.zzm
    public final String getErrorMessage() {
        try {
            return this.zzae.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
