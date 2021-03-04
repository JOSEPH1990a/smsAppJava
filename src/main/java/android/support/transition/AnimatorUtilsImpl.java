package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.annotation.NonNull;

/* access modifiers changed from: package-private */
public interface AnimatorUtilsImpl {
    void addPauseListener(@NonNull Animator animator, @NonNull AnimatorListenerAdapter animatorListenerAdapter);

    void pause(@NonNull Animator animator);

    void resume(@NonNull Animator animator);
}