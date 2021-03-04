package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import java.util.List;

/* access modifiers changed from: package-private */
public final class zzayk implements zzabl {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ List zzelj;
    private final /* synthetic */ zzabk zzelk;

    zzayk(zzayh zzayh, List list, zzabk zzabk, Context context) {
        this.zzelj = list;
        this.zzelk = zzabk;
        this.val$context = context;
    }

    @Override // com.google.android.gms.internal.ads.zzabl
    public final void zzrn() {
    }

    @Override // com.google.android.gms.internal.ads.zzabl
    public final void zzrm() {
        for (String str : this.zzelj) {
            String valueOf = String.valueOf(str);
            zzaxz.zzen(valueOf.length() != 0 ? "Pinging url: ".concat(valueOf) : new String("Pinging url: "));
            this.zzelk.mayLaunchUrl(Uri.parse(str), null, null);
        }
        this.zzelk.zzc((Activity) this.val$context);
    }
}
