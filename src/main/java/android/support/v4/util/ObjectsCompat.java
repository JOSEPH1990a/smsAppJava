package android.support.v4.util;

import android.os.Build;
import android.support.annotation.RequiresApi;
import java.util.Objects;

public class ObjectsCompat {
    private static final ImplBase IMPL;

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            IMPL = new ImplApi19();
        } else {
            IMPL = new ImplBase();
        }
    }

    private ObjectsCompat() {
    }

    public static boolean equals(Object obj, Object obj2) {
        return IMPL.equals(obj, obj2);
    }

    /* access modifiers changed from: private */
    public static class ImplBase {
        private ImplBase() {
        }

        public boolean equals(Object obj, Object obj2) {
            return obj == obj2 || (obj != null && obj.equals(obj2));
        }
    }

    @RequiresApi(19)
    private static class ImplApi19 extends ImplBase {
        private ImplApi19() {
            super();
        }

        @Override // android.support.v4.util.ObjectsCompat.ImplBase
        public boolean equals(Object obj, Object obj2) {
            return Objects.equals(obj, obj2);
        }
    }
}