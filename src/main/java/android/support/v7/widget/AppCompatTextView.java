package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.view.TintableBackgroundView;
import android.support.v4.widget.AutoSizeableTextView;
import android.util.AttributeSet;
import android.widget.TextView;

public class AppCompatTextView extends TextView implements TintableBackgroundView, AutoSizeableTextView {
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private final AppCompatTextHelper mTextHelper;

    public AppCompatTextView(Context context) {
        this(context, null);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int i) {
        super(TintContextWrapper.wrap(context), attributeSet, i);
        this.mBackgroundTintHelper = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper.loadFromAttributes(attributeSet, i);
        this.mTextHelper = AppCompatTextHelper.create(this);
        this.mTextHelper.loadFromAttributes(attributeSet, i);
        this.mTextHelper.applyCompoundDrawablesTints();
    }

    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.onSetBackgroundResource(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.onSetBackgroundDrawable(drawable);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.getSupportBackgroundTintList();
        }
        return null;
    }

    @Override // android.support.v4.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.getSupportBackgroundTintMode();
        }
        return null;
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.onSetTextAppearance(context, i);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.applySupportBackgroundTint();
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.applyCompoundDrawablesTints();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.onLayout(z, i, i2, i3, i4);
        }
    }

    public void setTextSize(int i, float f) {
        if (Build.VERSION.SDK_INT >= 26) {
            super.setTextSize(i, f);
            return;
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.setTextSize(i, f);
        }
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (this.mTextHelper != null && Build.VERSION.SDK_INT < 26 && this.mTextHelper.isAutoSizeEnabled()) {
            this.mTextHelper.autoSizeText();
        }
    }

    @Override // android.support.v4.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.setAutoSizeTextTypeWithDefaults(i);
        }
    }

    @Override // android.support.v4.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        if (Build.VERSION.SDK_INT >= 26) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        }
    }

    @Override // android.support.v4.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] iArr, int i) throws IllegalArgumentException {
        if (Build.VERSION.SDK_INT >= 26) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        }
    }

    @Override // android.support.v4.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getAutoSizeTextType() {
        if (Build.VERSION.SDK_INT < 26) {
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper != null) {
                return appCompatTextHelper.getAutoSizeTextType();
            }
            return 0;
        } else if (super.getAutoSizeTextType() == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override // android.support.v4.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getAutoSizeStepGranularity() {
        if (Build.VERSION.SDK_INT >= 26) {
            return super.getAutoSizeStepGranularity();
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            return appCompatTextHelper.getAutoSizeStepGranularity();
        }
        return -1;
    }

    @Override // android.support.v4.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getAutoSizeMinTextSize() {
        if (Build.VERSION.SDK_INT >= 26) {
            return super.getAutoSizeMinTextSize();
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            return appCompatTextHelper.getAutoSizeMinTextSize();
        }
        return -1;
    }

    @Override // android.support.v4.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getAutoSizeMaxTextSize() {
        if (Build.VERSION.SDK_INT >= 26) {
            return super.getAutoSizeMaxTextSize();
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            return appCompatTextHelper.getAutoSizeMaxTextSize();
        }
        return -1;
    }

    @Override // android.support.v4.widget.AutoSizeableTextView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int[] getAutoSizeTextAvailableSizes() {
        if (Build.VERSION.SDK_INT >= 26) {
            return super.getAutoSizeTextAvailableSizes();
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            return appCompatTextHelper.getAutoSizeTextAvailableSizes();
        }
        return new int[0];
    }
}
