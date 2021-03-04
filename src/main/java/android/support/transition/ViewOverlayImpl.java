package android.support.transition;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;

/* access modifiers changed from: package-private */
@RequiresApi(14)
public interface ViewOverlayImpl {
    void add(@NonNull Drawable drawable);

    void clear();

    void remove(@NonNull Drawable drawable);
}
