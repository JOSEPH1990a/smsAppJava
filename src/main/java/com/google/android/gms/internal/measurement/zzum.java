package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzub;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/* access modifiers changed from: package-private */
public abstract class zzum<T extends zzub> {
    private static final Logger logger = Logger.getLogger(zztv.class.getName());
    private static String zzbyb = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";

    zzum() {
    }

    /* access modifiers changed from: protected */
    public abstract T zzwd();

    static <T extends zzub> T zzd(Class<T> cls) {
        String str;
        ClassLoader classLoader = zzum.class.getClassLoader();
        if (cls.equals(zzub.class)) {
            str = zzbyb;
        } else if (cls.getPackage().equals(zzum.class.getPackage())) {
            str = String.format("%s.BlazeGenerated%sLoader", cls.getPackage().getName(), cls.getSimpleName());
        } else {
            throw new IllegalArgumentException(cls.getName());
        }
        try {
            try {
                return cls.cast(((zzum) Class.forName(str, true, classLoader).getConstructor(new Class[0]).newInstance(new Object[0])).zzwd());
            } catch (NoSuchMethodException e) {
                throw new IllegalStateException(e);
            } catch (InstantiationException e2) {
                throw new IllegalStateException(e2);
            } catch (IllegalAccessException e3) {
                throw new IllegalStateException(e3);
            } catch (InvocationTargetException e4) {
                throw new IllegalStateException(e4);
            }
        } catch (ClassNotFoundException unused) {
            Iterator it = ServiceLoader.load(zzum.class, classLoader).iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                try {
                    arrayList.add(cls.cast(((zzum) it.next()).zzwd()));
                } catch (ServiceConfigurationError e5) {
                    Logger logger2 = logger;
                    Level level = Level.SEVERE;
                    String valueOf = String.valueOf(cls.getSimpleName());
                    logger2.logp(level, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", valueOf.length() != 0 ? "Unable to load ".concat(valueOf) : new String("Unable to load "), (Throwable) e5);
                }
            }
            if (arrayList.size() == 1) {
                return (T) ((zzub) arrayList.get(0));
            }
            if (arrayList.size() == 0) {
                return null;
            }
            try {
                return (T) ((zzub) cls.getMethod("combine", Collection.class).invoke(null, arrayList));
            } catch (NoSuchMethodException e6) {
                throw new IllegalStateException(e6);
            } catch (IllegalAccessException e7) {
                throw new IllegalStateException(e7);
            } catch (InvocationTargetException e8) {
                throw new IllegalStateException(e8);
            }
        }
    }
}
