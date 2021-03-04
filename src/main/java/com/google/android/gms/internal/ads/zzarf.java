package com.google.android.gms.internal.ads;

import java.lang.Thread;

/* access modifiers changed from: package-private */
public final class zzarf implements Thread.UncaughtExceptionHandler {
    private final /* synthetic */ Thread.UncaughtExceptionHandler zzdvk;
    private final /* synthetic */ zzare zzdvl;

    zzarf(zzare zzare, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zzdvl = zzare;
        this.zzdvk = uncaughtExceptionHandler;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            this.zzdvl.zza(thread, th);
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.zzdvk;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        } catch (Throwable th2) {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.zzdvk;
            if (uncaughtExceptionHandler2 != null) {
                uncaughtExceptionHandler2.uncaughtException(thread, th);
            }
            throw th2;
        }
    }
}
