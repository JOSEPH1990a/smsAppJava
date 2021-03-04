package com.google.android.gms.internal.ads;

import android.support.v4.view.PointerIconCompat;
import com.google.android.gms.internal.ads.zzbrd;

public final class zzuo {

    public static final class zza extends zzbrd<zza, C0008zza> implements zzbsn {
        private static final zza zzcar = new zza();
        private static volatile zzbsw<zza> zzcas;

        public enum zzb implements zzbrg {
            UNKNOWN_EVENT_TYPE(0),
            AD_REQUEST(1),
            AD_LOADED(2),
            AD_FAILED_TO_LOAD(3),
            AD_FAILED_TO_LOAD_NO_FILL(4),
            AD_IMPRESSION(5),
            AD_FIRST_CLICK(6),
            AD_SUBSEQUENT_CLICK(7),
            REQUEST_WILL_START(8),
            REQUEST_DID_END(9),
            REQUEST_WILL_UPDATE_SIGNALS(10),
            REQUEST_DID_UPDATE_SIGNALS(11),
            REQUEST_WILL_BUILD_URL(12),
            REQUEST_DID_BUILD_URL(13),
            REQUEST_WILL_MAKE_NETWORK_REQUEST(14),
            REQUEST_DID_RECEIVE_NETWORK_RESPONSE(15),
            REQUEST_WILL_PROCESS_RESPONSE(16),
            REQUEST_DID_PROCESS_RESPONSE(17),
            REQUEST_WILL_RENDER(18),
            REQUEST_DID_RENDER(19),
            REQUEST_WILL_UPDATE_GMS_SIGNALS(1000),
            REQUEST_DID_UPDATE_GMS_SIGNALS(PointerIconCompat.TYPE_CONTEXT_MENU),
            REQUEST_FAILED_TO_UPDATE_GMS_SIGNALS(PointerIconCompat.TYPE_HAND),
            REQUEST_FAILED_TO_BUILD_URL(PointerIconCompat.TYPE_HELP),
            REQUEST_FAILED_TO_MAKE_NETWORK_REQUEST(PointerIconCompat.TYPE_WAIT),
            REQUEST_FAILED_TO_PROCESS_RESPONSE(1005),
            REQUEST_FAILED_TO_UPDATE_SIGNALS(PointerIconCompat.TYPE_CELL),
            BANNER_SIZE_INVALID(10000),
            BANNER_SIZE_VALID(10001),
            ANDROID_WEBVIEW_CRASH(10002);
            
            private static final zzbrh<zzb> zzcbx = new zzuq();
            private final int value;

            @Override // com.google.android.gms.internal.ads.zzbrg
            public final int zzom() {
                return this.value;
            }

            private zzb(int i) {
                this.value = i;
            }
        }

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.ads.zzuo$zza$zza  reason: collision with other inner class name */
        public static final class C0008zza extends zzbrd.zza<zza, C0008zza> implements zzbsn {
            private C0008zza() {
                super(zza.zzcar);
            }

            /* synthetic */ C0008zza(zzup zzup) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzbrd
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzup.zzcaq[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0008zza(null);
                case 3:
                    return zza(zzcar, "\u0001\u0000", (Object[]) null);
                case 4:
                    return zzcar;
                case 5:
                    zzbsw<zza> zzbsw = zzcas;
                    if (zzbsw == null) {
                        synchronized (zza.class) {
                            zzbsw = zzcas;
                            if (zzbsw == null) {
                                zzbsw = new zzbrd.zzb<>(zzcar);
                                zzcas = zzbsw;
                            }
                        }
                    }
                    return zzbsw;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzbrd.zza(zza.class, zzcar);
        }
    }
}
