package android.support.transition;

import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.view.ViewGroup;

/* access modifiers changed from: package-private */
@RequiresApi(14)
public interface ViewGroupUtilsImpl {
    ViewGroupOverlayImpl getOverlay(@NonNull ViewGroup viewGroup);

    void suppressLayout(@NonNull ViewGroup viewGroup, boolean z);
}
