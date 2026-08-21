package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.getsurfboard.R;
import defpackage.b3;
import defpackage.cd3;
import defpackage.uq3;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {
    public Drawable A;
    public final boolean A0;
    public boolean B0;
    public final int C0;
    public boolean b;
    public View f;
    public Drawable y0;
    public View z;
    public Drawable z0;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackground(new b3(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cd3.a);
        boolean z = false;
        this.A = typedArrayObtainStyledAttributes.getDrawable(0);
        this.y0 = typedArrayObtainStyledAttributes.getDrawable(2);
        this.C0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(13, -1);
        if (getId() == R.id.split_action_bar) {
            this.A0 = true;
            this.z0 = typedArrayObtainStyledAttributes.getDrawable(1);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.A0 ? !(this.A != null || this.y0 != null) : this.z0 == null) {
            z = true;
        }
        setWillNotDraw(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.A;
        if (drawable != null && drawable.isStateful()) {
            this.A.setState(getDrawableState());
        }
        Drawable drawable2 = this.y0;
        if (drawable2 != null && drawable2.isStateful()) {
            this.y0.setState(getDrawableState());
        }
        Drawable drawable3 = this.z0;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.z0.setState(getDrawableState());
    }

    public View getTabContainer() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.A;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.y0;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.z0;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f = findViewById(R.id.action_bar);
        this.z = findViewById(R.id.action_context_bar);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.b || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        boolean z2 = true;
        if (this.A0) {
            Drawable drawable = this.z0;
            if (drawable != null) {
                drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z2 = false;
            }
        } else {
            if (this.A == null) {
                z2 = false;
            } else if (this.f.getVisibility() == 0) {
                this.A.setBounds(this.f.getLeft(), this.f.getTop(), this.f.getRight(), this.f.getBottom());
            } else {
                View view = this.z;
                if (view == null || view.getVisibility() != 0) {
                    this.A.setBounds(0, 0, 0, 0);
                } else {
                    this.A.setBounds(this.z.getLeft(), this.z.getTop(), this.z.getRight(), this.z.getBottom());
                }
            }
            this.B0 = false;
        }
        if (z2) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        if (this.f == null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && (i3 = this.C0) >= 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(i3, View.MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.f == null) {
            return;
        }
        View.MeasureSpec.getMode(i2);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.A;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.A);
        }
        this.A = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f;
            if (view != null) {
                this.A.setBounds(view.getLeft(), this.f.getTop(), this.f.getRight(), this.f.getBottom());
            }
        }
        boolean z = false;
        if (!this.A0 ? !(this.A != null || this.y0 != null) : this.z0 == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        invalidateOutline();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.z0;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.z0);
        }
        this.z0 = drawable;
        boolean z = this.A0;
        boolean z2 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (z && (drawable2 = this.z0) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!z ? !(this.A != null || this.y0 != null) : this.z0 == null) {
            z2 = true;
        }
        setWillNotDraw(z2);
        invalidate();
        invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2 = this.y0;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.y0);
        }
        this.y0 = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.B0 && this.y0 != null) {
                throw null;
            }
        }
        boolean z = false;
        if (!this.A0 ? !(this.A != null || this.y0 != null) : this.z0 == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
        invalidateOutline();
    }

    public void setTransitioning(boolean z) {
        this.b = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.A;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.y0;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.z0;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        Drawable drawable2 = this.A;
        boolean z = this.A0;
        if (drawable == drawable2 && !z) {
            return true;
        }
        if (drawable == this.y0 && this.B0) {
            return true;
        }
        return (drawable == this.z0 && z) || super.verifyDrawable(drawable);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    public void setTabContainer(uq3 uq3Var) {
    }

    public ActionBarContainer(Context context) {
        this(context, null);
    }
}
