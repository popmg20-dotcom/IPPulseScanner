package defpackage;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class zr1 extends bq4 {
    public static final /* synthetic */ int y0 = 0;
    public ValueAnimator A;
    public long b;
    public ub1 f;
    public Rect z;

    public static final void d(int i, int i2, zr1 zr1Var, ValueAnimator valueAnimator) {
        valueAnimator.getClass();
        Object animatedValue = valueAnimator.getAnimatedValue();
        animatedValue.getClass();
        zr1Var.setClippedHeight((int) (((i - i2) * ((Float) animatedValue).floatValue()) + i2));
    }

    private final void setClippedHeight(int i) {
        Rect rect = this.z;
        if (rect == null) {
            rect = new Rect();
        }
        rect.set(0, 0, getRight() - getLeft(), getTop() + i);
        this.z = rect;
        as1 as1Var = (as1) getBackground();
        if (as1Var != null) {
            as1Var.f = Integer.valueOf(i);
            as1Var.setBounds(as1Var.getBounds());
        }
        invalidate();
    }

    @Override // android.widget.ViewAnimator, android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        view.getClass();
        layoutParams.getClass();
        view.setLayoutParams(layoutParams);
        e(view, true);
    }

    public final void c(final int i, final int i2, ig0 ig0Var) {
        this.A.cancel();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(this.b);
        valueAnimatorOfFloat.setInterpolator(new ub1());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ur1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                zr1.d(i2, i, this, valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new vr1(0, ig0Var));
        valueAnimatorOfFloat.start();
        this.A = valueAnimatorOfFloat;
    }

    @Override // defpackage.bq4, android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        motionEvent.getClass();
        Rect rect = this.z;
        if (rect == null || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j) {
        canvas.getClass();
        view.getClass();
        if (getChildCount() > 1) {
            float translationX = view.getTranslationX();
            int iSave = canvas.save();
            canvas.translate(translationX, 0.0f);
            try {
                as1 as1Var = (as1) getBackground();
                if (as1Var != null) {
                    as1Var.b.draw(canvas);
                }
            } finally {
                canvas.restoreToCount(iSave);
            }
        }
        return super.drawChild(canvas, view, j);
    }

    public final void e(View view, boolean z) {
        yr1 yr1Var = new yr1(z, this, view);
        if (this.A.isRunning()) {
            this.A.addListener(new vr1(1, yr1Var));
        } else {
            yr1Var.a();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateDefaultLayoutParams() {
        return new FrameLayout.LayoutParams(-1, -2);
    }

    public final long getAnimationDuration() {
        return this.b;
    }

    public final ub1 getAnimationInterpolator() {
        return this.f;
    }

    @Override // android.widget.ViewFlipper, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.A.cancel();
        super.onDetachedFromWindow();
    }

    public final void setAnimationDuration(long j) {
        this.b = j;
    }

    public final void setAnimationInterpolator(ub1 ub1Var) {
        ub1Var.getClass();
        this.f = ub1Var;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == null) {
            super.setBackgroundDrawable(null);
        } else {
            super.setBackgroundDrawable(new as1(new b20(drawable, 1)));
        }
    }
}
