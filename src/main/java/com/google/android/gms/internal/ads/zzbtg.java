package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class zzbtg extends zzbtf<FieldDescriptorType, Object> {
    zzbtg(int i) {
        super(i, null);
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final void zzakj() {
        if (!isImmutable()) {
            for (int i = 0; i < zzaop(); i++) {
                Map.Entry zzfy = zzfy(i);
                if (((zzbqw) zzfy.getKey()).zzamn()) {
                    zzfy.setValue(Collections.unmodifiableList((List) zzfy.getValue()));
                }
            }
            for (Map.Entry entry : zzaoq()) {
                if (((zzbqw) entry.getKey()).zzamn()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzakj();
    }
}
