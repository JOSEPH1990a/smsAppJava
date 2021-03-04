package android.support.transition;

import android.animation.Animator;
import android.graphics.Matrix;
import android.support.annotation.RequiresApi;
import android.widget.ImageView;

/* access modifiers changed from: package-private */
@RequiresApi(14)
public interface ImageViewUtilsImpl {
    void animateTransform(ImageView imageView, Matrix matrix);

    void reserveEndAnimateTransform(ImageView imageView, Animator animator);

    void startAnimateTransform(ImageView imageView);
}
