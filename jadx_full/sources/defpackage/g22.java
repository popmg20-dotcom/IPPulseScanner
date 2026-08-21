package defpackage;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class g22 implements Animator.AnimatorListener {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final rg3 e;
    public final int f;
    public final ValueAnimator g;
    public boolean h;
    public float i;
    public float j;
    public boolean k = false;
    public boolean l = false;
    public float m;
    public final /* synthetic */ int n;
    public final /* synthetic */ rg3 o;
    public final /* synthetic */ k22 p;

    public g22(k22 k22Var, rg3 rg3Var, int i, float f, float f2, float f3, float f4, int i2, rg3 rg3Var2) {
        this.p = k22Var;
        this.n = i2;
        this.o = rg3Var2;
        this.f = i;
        this.e = rg3Var;
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.g = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new io(2, this));
        valueAnimatorOfFloat.setTarget(rg3Var.a);
        valueAnimatorOfFloat.addListener(this);
        this.m = 0.0f;
    }

    public final void a(Animator animator) {
        if (!this.l) {
            this.e.p(true);
        }
        this.l = true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.m = 1.0f;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        a(animator);
        if (this.k) {
            return;
        }
        int i = this.n;
        rg3 rg3Var = this.o;
        k22 k22Var = this.p;
        if (i <= 0) {
            i22.a(rg3Var);
        } else {
            k22Var.a.add(rg3Var.a);
            this.h = true;
            if (i > 0) {
                k22Var.r.post(new um1(k22Var, this, i));
            }
        }
        View view = k22Var.w;
        View view2 = rg3Var.a;
        if (view == view2 && view2 == view) {
            k22Var.w = null;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}
