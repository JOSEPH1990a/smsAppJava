package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzsx;
import com.google.android.gms.internal.measurement.zzsy;

public abstract class zzsy<MessageType extends zzsx<MessageType, BuilderType>, BuilderType extends zzsy<MessageType, BuilderType>> implements zzvw {
    /* access modifiers changed from: protected */
    public abstract BuilderType zza(MessageType messagetype);

    /* renamed from: zzty */
    public abstract BuilderType clone();

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.android.gms.internal.measurement.zzsy<MessageType extends com.google.android.gms.internal.measurement.zzsx<MessageType, BuilderType>, BuilderType extends com.google.android.gms.internal.measurement.zzsy<MessageType, BuilderType>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzvw
    public final /* synthetic */ zzvw zza(zzvv zzvv) {
        if (zzwj().getClass().isInstance(zzvv)) {
            return zza((zzsx) zzvv);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
