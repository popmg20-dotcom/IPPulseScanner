package defpackage;

import android.animation.ValueAnimator;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.os.Build;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.fragment.app.p;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c4 {
    public ValueAnimator a;
    public float b;
    public boolean c;

    public static final void d(c4 c4Var, View view, ValueAnimator valueAnimator) {
        valueAnimator.getClass();
        Object animatedValue = valueAnimator.getAnimatedValue();
        animatedValue.getClass();
        float fFloatValue = ((Float) animatedValue).floatValue();
        if (Build.VERSION.SDK_INT < 31) {
            return;
        }
        c4Var.b = fFloatValue;
        if (fFloatValue <= 0.0f) {
            view.setRenderEffect(null);
        } else {
            view.setRenderEffect(RenderEffect.createBlurEffect(fFloatValue, fFloatValue, Shader.TileMode.CLAMP));
        }
    }

    public final void a(p pVar, View view, pl1 pl1Var) {
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        ViewPropertyAnimator viewPropertyAnimatorAlpha;
        ViewPropertyAnimator viewPropertyAnimatorScaleX;
        ViewPropertyAnimator viewPropertyAnimatorScaleY;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator interpolator;
        ViewPropertyAnimator viewPropertyAnimatorAnimate2;
        ViewPropertyAnimator viewPropertyAnimatorAlpha2;
        ViewPropertyAnimator viewPropertyAnimatorScaleX2;
        ViewPropertyAnimator viewPropertyAnimatorScaleY2;
        ViewPropertyAnimator duration2;
        ViewPropertyAnimator interpolator2;
        ViewPropertyAnimator viewPropertyAnimatorWithEndAction;
        Window window;
        if (this.c) {
            return;
        }
        this.c = true;
        View decorView = (Build.VERSION.SDK_INT < 31 || pVar == null || (window = pVar.getWindow()) == null) ? null : window.getDecorView();
        int i = 0;
        if (decorView != null) {
            if (view != null && (viewPropertyAnimatorAnimate = view.animate()) != null && (viewPropertyAnimatorAlpha = viewPropertyAnimatorAnimate.alpha(0.0f)) != null && (viewPropertyAnimatorScaleX = viewPropertyAnimatorAlpha.scaleX(0.95f)) != null && (viewPropertyAnimatorScaleY = viewPropertyAnimatorScaleX.scaleY(0.95f)) != null && (duration = viewPropertyAnimatorScaleY.setDuration(300L)) != null && (interpolator = duration.setInterpolator(new AccelerateDecelerateInterpolator())) != null) {
                interpolator.start();
            }
            c(decorView, this.b, 0.0f, new b4(i, this, decorView, pl1Var));
            return;
        }
        if (view == null || (viewPropertyAnimatorAnimate2 = view.animate()) == null || (viewPropertyAnimatorAlpha2 = viewPropertyAnimatorAnimate2.alpha(0.0f)) == null || (viewPropertyAnimatorScaleX2 = viewPropertyAnimatorAlpha2.scaleX(0.95f)) == null || (viewPropertyAnimatorScaleY2 = viewPropertyAnimatorScaleX2.scaleY(0.95f)) == null || (duration2 = viewPropertyAnimatorScaleY2.setDuration(300L)) == null || (interpolator2 = duration2.setInterpolator(new AccelerateDecelerateInterpolator())) == null || (viewPropertyAnimatorWithEndAction = interpolator2.withEndAction(new a4(0, pl1Var))) == null) {
            pl1Var.a();
        } else {
            viewPropertyAnimatorWithEndAction.start();
        }
    }

    public final void b(View view) {
        if (Build.VERSION.SDK_INT < 31) {
            return;
        }
        this.b = 0.0f;
        view.setRenderEffect(null);
    }

    public final void c(View view, float f, float f2, b4 b4Var) {
        ValueAnimator valueAnimator = this.a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        int i = 1;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f2);
        valueAnimatorOfFloat.setDuration(300L);
        valueAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new z3(0, this, view));
        if (b4Var != null) {
            valueAnimatorOfFloat.addListener(new d3(i, b4Var));
        }
        valueAnimatorOfFloat.start();
        this.a = valueAnimatorOfFloat;
    }
}
