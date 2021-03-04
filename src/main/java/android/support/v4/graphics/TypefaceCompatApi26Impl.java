package android.support.v4.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.v4.content.res.FontResourcesParserCompat;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

@RequiresApi(26)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TypefaceCompatApi26Impl extends TypefaceCompatApi21Impl {
    private static final String ABORT_CREATION_METHOD = "abortCreation";
    private static final String ADD_FONT_FROM_ASSET_MANAGER_METHOD = "addFontFromAssetManager";
    private static final String ADD_FONT_FROM_BUFFER_METHOD = "addFontFromBuffer";
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
    private static final String FREEZE_METHOD = "freeze";
    private static final int RESOLVE_BY_FONT_TABLE = -1;
    private static final String TAG = "TypefaceCompatApi26Impl";
    private static final Method sAbortCreation;
    private static final Method sAddFontFromAssetManager;
    private static final Method sAddFontFromBuffer;
    private static final Method sCreateFromFamiliesWithDefault;
    private static final Class sFontFamily;
    private static final Constructor sFontFamilyCtor;
    private static final Method sFreeze;

    static {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Class<?> cls;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName(FONT_FAMILY_CLASS);
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method4 = cls.getMethod(ADD_FONT_FROM_ASSET_MANAGER_METHOD, AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class);
            method3 = cls.getMethod(ADD_FONT_FROM_BUFFER_METHOD, ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE);
            method2 = cls.getMethod(FREEZE_METHOD, new Class[0]);
            method = cls.getMethod(ABORT_CREATION_METHOD, new Class[0]);
            method5 = Typeface.class.getDeclaredMethod(CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD, Array.newInstance(cls, 1).getClass(), Integer.TYPE, Integer.TYPE);
            method5.setAccessible(true);
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e(TAG, "Unable to collect necessary methods for class " + e.getClass().getName(), e);
            cls = null;
            method5 = null;
            method4 = null;
            method3 = null;
            method2 = null;
            method = null;
        }
        sFontFamilyCtor = constructor;
        sFontFamily = cls;
        sAddFontFromAssetManager = method4;
        sAddFontFromBuffer = method3;
        sFreeze = method2;
        sAbortCreation = method;
        sCreateFromFamiliesWithDefault = method5;
    }

    private static boolean isFontFamilyPrivateAPIAvailable() {
        if (sAddFontFromAssetManager == null) {
            Log.w(TAG, "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return sAddFontFromAssetManager != null;
    }

    private static Object newFamily() {
        try {
            return sFontFamilyCtor.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean addFontFromAssetManager(Context context, Object obj, String str, int i, int i2, int i3) {
        try {
            return ((Boolean) sAddFontFromAssetManager.invoke(obj, context.getAssets(), str, 0, false, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean addFontFromBuffer(Object obj, ByteBuffer byteBuffer, int i, int i2, int i3) {
        try {
            return ((Boolean) sAddFontFromBuffer.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Integer.valueOf(i3))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static Typeface createFromFamiliesWithDefault(Object obj) {
        try {
            Object newInstance = Array.newInstance(sFontFamily, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) sCreateFromFamiliesWithDefault.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean freeze(Object obj) {
        try {
            return ((Boolean) sFreeze.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean abortCreation(Object obj) {
        try {
            return ((Boolean) sAbortCreation.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // android.support.v4.graphics.TypefaceCompat.TypefaceCompatImpl, android.support.v4.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i) {
        if (!isFontFamilyPrivateAPIAvailable()) {
            return super.createFromFontFamilyFilesResourceEntry(context, fontFamilyFilesResourceEntry, resources, i);
        }
        Object newFamily = newFamily();
        FontResourcesParserCompat.FontFileResourceEntry[] entries = fontFamilyFilesResourceEntry.getEntries();
        for (FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry : entries) {
            if (!addFontFromAssetManager(context, newFamily, fontFileResourceEntry.getFileName(), 0, fontFileResourceEntry.getWeight(), fontFileResourceEntry.isItalic() ? 1 : 0)) {
                abortCreation(newFamily);
                return null;
            }
        }
        if (!freeze(newFamily)) {
            return null;
        }
        return createFromFamiliesWithDefault(newFamily);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0041, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0046, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0047, code lost:
        r11 = r10;
        r10 = r11;
     */
    @Override // android.support.v4.graphics.TypefaceCompatApi21Impl, android.support.v4.graphics.TypefaceCompat.TypefaceCompatImpl, android.support.v4.graphics.TypefaceCompatBaseImpl
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Typeface createFromFontInfo(android.content.Context r9, @android.support.annotation.Nullable android.os.CancellationSignal r10, @android.support.annotation.NonNull android.support.v4.provider.FontsContractCompat.FontInfo[] r11, int r12) {
        /*
        // Method dump skipped, instructions count: 164
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompatApi26Impl.createFromFontInfo(android.content.Context, android.os.CancellationSignal, android.support.v4.provider.FontsContractCompat$FontInfo[], int):android.graphics.Typeface");
    }

    @Override // android.support.v4.graphics.TypefaceCompat.TypefaceCompatImpl, android.support.v4.graphics.TypefaceCompatBaseImpl
    @Nullable
    public Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str, int i2) {
        if (!isFontFamilyPrivateAPIAvailable()) {
            return super.createFromResourcesFontFile(context, resources, i, str, i2);
        }
        Object newFamily = newFamily();
        if (!addFontFromAssetManager(context, newFamily, str, 0, -1, -1)) {
            abortCreation(newFamily);
            return null;
        } else if (!freeze(newFamily)) {
            return null;
        } else {
            return createFromFamiliesWithDefault(newFamily);
        }
    }
}
