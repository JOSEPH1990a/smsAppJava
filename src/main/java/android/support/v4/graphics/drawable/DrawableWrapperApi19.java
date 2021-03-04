package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.graphics.drawable.DrawableWrapperApi14;

@RequiresApi(19)
class DrawableWrapperApi19 extends DrawableWrapperApi14 {
    DrawableWrapperApi19(Drawable drawable) {
        super(drawable);
    }

    DrawableWrapperApi19(DrawableWrapperApi14.DrawableWrapperState drawableWrapperState, Resources resources) {
        super(drawableWrapperState, resources);
    }

    public void setAutoMirrored(boolean z) {
        this.mDrawable.setAutoMirrored(z);
    }

    public boolean isAutoMirrored() {
        return this.mDrawable.isAutoMirrored();
    }

    /* access modifiers changed from: package-private */
    @Override // android.support.v4.graphics.drawable.DrawableWrapperApi14
    @NonNull
    public DrawableWrapperApi14.DrawableWrapperState mutateConstantState() {
        return new DrawableWrapperStateKitKat(this.mState, null);
    }

    private static class DrawableWrapperStateKitKat extends DrawableWrapperApi14.DrawableWrapperState {
        DrawableWrapperStateKitKat(@Nullable DrawableWrapperApi14.DrawableWrapperState drawableWrapperState, @Nullable Resources resources) {
            super(drawableWrapperState, resources);
        }

        @Override // android.support.v4.graphics.drawable.DrawableWrapperApi14.DrawableWrapperState
        public Drawable newDrawable(@Nullable Resources resources) {
            return new DrawableWrapperApi19(this, resources);
        }
    }
}
