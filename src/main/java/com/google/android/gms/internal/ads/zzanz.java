package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

/* access modifiers changed from: package-private */
public final class zzanz implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzanx zzdpe;

    zzanz(zzanx zzanx) {
        this.zzdpe = zzanx;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzdpe.zzda("Operation denied by user.");
    }
}
