package com.google.firebase.iid.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public interface FirebaseInstanceIdInternal {
    @KeepForSdk
    String getId();

    @KeepForSdk
    @Nullable
    String getToken();
}
