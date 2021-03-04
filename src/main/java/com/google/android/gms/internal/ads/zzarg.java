package com.google.android.gms.internal.ads;

import java.lang.Thread;

/* access modifiers changed from: package-private */
public final class zzarg implements Thread.UncaughtExceptionHandler {
    private final /* synthetic */ zzare zzdvl;
    private final /* synthetic */ Thread.UncaughtExceptionHandler zzdvm;

    zzarg(zzare zzare, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zzdvl = zzare;
        this.zzdvm = uncaughtExceptionHandler;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            this.zzdvl.zza(thread, th);
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.zzdvm;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        } catch (Throwable th2) {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.zzdvm;
            if (uncaughtExceptionHandler2 != null) {
                uncaughtExceptionHandler2.uncaughtException(thread, th);
            }
            throw th2;
        }
    }
}
