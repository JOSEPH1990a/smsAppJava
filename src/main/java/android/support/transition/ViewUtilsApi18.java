package android.support.transition;

import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.view.View;

@RequiresApi(18)
class ViewUtilsApi18 extends ViewUtilsApi14 {
    ViewUtilsApi18() {
    }

    @Override // android.support.transition.ViewUtilsImpl, android.support.transition.ViewUtilsApi14
    public ViewOverlayImpl getOverlay(@NonNull View view) {
        return new ViewOverlayApi18(view);
    }

    @Override // android.support.transition.ViewUtilsImpl, android.support.transition.ViewUtilsApi14
    public WindowIdImpl getWindowId(@NonNull View view) {
        return new WindowIdApi18(view);
    }
}
