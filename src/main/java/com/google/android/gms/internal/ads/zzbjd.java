package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.internal.ShowFirstParty;
import fi.iki.elonen.NanoHTTPD;

@ShowFirstParty
public final class zzbjd {
    public static zzbl zzk(Context context, String str, String str2) {
        return new zzbje(context, str, str2).zzdj(NanoHTTPD.SOCKET_READ_TIMEOUT);
    }
}
